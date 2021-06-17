package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/I/">I. Контрольная по ударениям</a>
 */
public class Stress {

    public static void main(String[] args) throws IOException {

        var tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        tokenizer.nextToken();
        int dictSize = (int) tokenizer.nval;
        Map<String, BitSet> dictionary = new HashMap<>(((int) (dictSize / 0.75F + 1.0F)) << 1);
        for (int i = 0; i < dictSize; i++) {
            tokenizer.nextToken();
            String word = tokenizer.sval;
            String key = word.toLowerCase();
            BitSet stresses = dictionary.computeIfAbsent(key, k -> new BitSet(30));
            for (int j = 0; j < word.length(); j++) {
                if (Character.isUpperCase(word.charAt(j))) {
                    stresses.set(j);
                    break;
                }
            }
        }

        int errors = 0;

        outer:
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            String word = tokenizer.sval;
            int stress = -1;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    if (stress == -1) {
                        stress = i;
                    }
                    else {
                        errors++;
                        continue outer;
                    }
                }
            }
            if (stress == -1) {
                errors++;
                continue;
            }
            String key = word.toLowerCase();
            BitSet stresses = dictionary.get(key);
            if (stresses != null && !stresses.get(stress)) {
                errors++;
            }
        }

        System.out.println(errors);

    }
}
