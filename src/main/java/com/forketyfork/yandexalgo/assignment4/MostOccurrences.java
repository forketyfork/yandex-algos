package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Map;
import java.util.TreeMap;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/C/">C. Самое частое слово</a>
 */
public class MostOccurrences {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new TreeMap<>();

        var tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            String word = tokenizer.sval;
            map.compute(word, (key, total) -> total == null ? 1 : total + 1);
        }

        int maxTotal = 0;
        String maxWord = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxTotal) {
                maxWord = entry.getKey();
                maxTotal = entry.getValue();
            }
        }

        System.out.println(maxWord);

    }
}
