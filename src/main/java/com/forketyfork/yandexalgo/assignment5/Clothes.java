package com.forketyfork.yandexalgo.assignment5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @see <a href="https://contest.yandex.ru/contest/27794/problems/A/">A. Стильная одежда</a>
 */
public class Clothes {

    public static void main(String[] args) throws IOException {

        var tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        tokenizer.nextToken();
        int pantsSize = (int) tokenizer.nval;
        int[] pants = new int[pantsSize];

        for (int i = 0; i < pantsSize; i++) {
            tokenizer.nextToken();
            pants[i] = (int) tokenizer.nval;
        }

        tokenizer.nextToken();
        int shirtsSize = (int) tokenizer.nval;
        int[] shirts = new int[shirtsSize];

        for (int i = 0; i < shirtsSize; i++) {
            tokenizer.nextToken();
            shirts[i] = (int) tokenizer.nval;
        }

        int i1 = 0, i2 = 0;

        int diff = Integer.MAX_VALUE;
        int v1 = -1, v2 = -1;

        while (i1 < pants.length && i2 < shirts.length) {
            int p = pants[i1];
            int s = shirts[i2];

            int newDiff = Math.abs(p - s);
            if (newDiff == 0) {
                v1 = p;
                v2 = s;
                break;
            }
            else if (newDiff < diff) {
                diff = newDiff;
                v1 = p;
                v2 = s;
            }
            if (p < s) {
                i1++;
            }
            else {
                i2++;
            }
        }

        System.out.println(v1 + " " + v2);

    }
}
