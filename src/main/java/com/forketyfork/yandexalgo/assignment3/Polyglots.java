package com.forketyfork.yandexalgo.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @see <a href="https://contest.yandex.ru/contest/27663/problems/I/">I. Полиглоты</a>
 */
public class Polyglots {

    public static void main(String[] args) throws IOException {

        var allKnow = new HashSet<>();
        var atLeastOneKnows = new HashSet<>();

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            int languageCount = Integer.parseInt(reader.readLine());
            for (int j = 0; j < languageCount; j++) {
                var language = reader.readLine();
                allKnow.add(language);
                atLeastOneKnows.add(language);
            }

            for (int i = 1; i < count; i++) {
                languageCount = Integer.parseInt(reader.readLine());
                var knows = new HashSet<>();
                for (int j = 0; j < languageCount; j++) {
                    var language = reader.readLine();
                    knows.add(language);
                    atLeastOneKnows.add(language);
                }
                allKnow.retainAll(knows);
            }
        }

        System.out.println(allKnow.size());
        allKnow.forEach(System.out::println);

        System.out.println(atLeastOneKnows.size());
        atLeastOneKnows.forEach(System.out::println);
    }

}
