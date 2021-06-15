package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/B/">B. Номер появления слова</a>
 */
public class WordNumber {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new HashMap<>();

        try (var reader = new BufferedReader(new InputStreamReader(System.in));
             var writer = new PrintWriter(System.out)) {
            int c;
            List<Character> list = new ArrayList<>();
            while ((c = reader.read()) != -1) {
                if (c == ' ' || c == '\n' && !list.isEmpty()) {

                    int wordSize = list.size();
                    char[] array = new char[wordSize];
                    for (int i = 0; i < wordSize; i++) {
                        array[i] = list.get(i);
                    }
                    list.clear();
                    String word = new String(array);

                    map.compute(word, (key, total) -> {
                        int count = total == null ? 0 : total + 1;
                        writer.print(count);
                        writer.print(' ');
                        return count;
                    });
                }
                else {
                    list.add((char) c);
                }
            }
        }

    }
}
