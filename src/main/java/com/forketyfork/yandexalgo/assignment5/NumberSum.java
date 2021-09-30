package com.forketyfork.yandexalgo.assignment5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @see <a href="https://contest.yandex.ru/contest/27794/problems/B/">B. Сумма номеров</a>
 */
public class NumberSum {

    public static void main(String[] args) throws IOException {

        var tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        tokenizer.nextToken();
        int n = (int) tokenizer.nval;

        tokenizer.nextToken();
        int k = (int) tokenizer.nval;

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            tokenizer.nextToken();
            numbers[i] = (int) tokenizer.nval;
        }

        int total = 0;

        int l = 0, r = 0;
        int currentSum = 0;
        while (true) {
            if (currentSum < k) {
                if (r >= numbers.length) {
                    break;
                }
                currentSum += numbers[r];
                r++;
            }
            else if (currentSum > k) {
                currentSum -= numbers[l];
                l++;
            }
            else {
                total++;
                if (r >= numbers.length) {
                    break;
                }
                currentSum += numbers[r];
                r++;
            }
        }

        System.out.println(total);
    }
}
