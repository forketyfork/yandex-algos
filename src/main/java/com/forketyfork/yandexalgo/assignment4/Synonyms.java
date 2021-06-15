package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/A/">A. Словарь синонимов</a>
 */
public class Synonyms {

    public static void main(String[] args) throws IOException {

        HashMap<String, String> map;
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine());
            map = new HashMap<>(((int) (size / 0.75F + 1.0F)) << 1);
            for (int i = 0; i < size; i++) {
                String line = reader.readLine();
                int spaceIdx = line.indexOf(' ');
                String word1 = line.substring(0, spaceIdx);
                String word2 = line.substring(spaceIdx + 1);
                map.put(word1, word2);
                map.put(word2, word1);
            }
            String word = reader.readLine();
            System.out.println(map.get(word));
        }
    }

}
