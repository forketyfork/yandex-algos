package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/D/">D. Клавиатура</a>
 */
public class Keyboard {

    public static void main(String[] args) throws IOException {

        var tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        tokenizer.nextToken();
        int size = (int) tokenizer.nval;

        int[] presses = new int[size];

        for (int i = 0; i < size; i++) {
            tokenizer.nextToken();
            presses[i] = (int) tokenizer.nval;
        }

        tokenizer.nextToken();
        int totalPresses = (int) tokenizer.nval;

        for (int i = 0; i < totalPresses; i++) {
            tokenizer.nextToken();
            int key = (int) tokenizer.nval;
            presses[key - 1]--;
        }

        try (var writer = new PrintWriter(System.out)) {
            for (int i = 0; i < size; i++) {
                writer.println(presses[i] >= 0 ? "NO" : "YES");
            }
        }

    }
}
