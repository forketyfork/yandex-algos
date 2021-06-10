package com.forketyfork.yandexalgo.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @see <a href="https://contest.yandex.ru/contest/27663/problems/E/">E. OpenCalculator</a>
 */
public class Genom {

    public static void main(String[] args) throws IOException {

        int[] genom1 = new int[676];
        int[] genom2 = new int[676];

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int prev = reader.read(), curr;
            while ((curr = reader.read()) != '\n') {
                genom1[(prev - 'A') * 26 + (curr - 'A')]++;
                prev = curr;
            }
            prev = reader.read();
            while ((curr = reader.read()) != '\n') {
                genom2[(prev - 'A') * 26 + (curr - 'A')]++;
                prev = curr;
            }
        }

        int sum = 0;
        for (int i = 0; i < 676; i++) {
            if (genom2[i] != 0 && genom1[i] != 0) {
                sum += genom1[i];
            }
        }

        System.out.println(sum);
    }

}
