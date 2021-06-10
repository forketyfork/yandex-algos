package com.forketyfork.yandexalgo.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @see <a href="https://contest.yandex.ru/contest/27663/problems/D/">D. Количество слов в тексте</a>
 */
public class Words {

    public static void main(String[] args) throws IOException {

        var set = new HashSet<>();
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int c;
            StringBuilder sb = new StringBuilder();
            while ((c = reader.read()) != -1) {
                if (Character.isWhitespace(c) && !sb.isEmpty()) {
                    String word = sb.toString();
                    set.add(word);
                    sb.delete(0, sb.length());
                }
                else {
                    sb.append(c);
                }
            }
        }
        System.out.println(set.size());
    }

}
