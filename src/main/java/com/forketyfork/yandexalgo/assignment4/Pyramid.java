package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/E/">E. Пирамида</a>
 */
public class Pyramid {

    public static void main(String[] args) throws IOException {

        var tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        tokenizer.nextToken();
        int size = (int) tokenizer.nval;

        Map<Integer, Integer> map = new HashMap<>(((int) (size / 0.75F + 1.0F)) << 1);

        for (int i = 0; i < size; i++) {
            tokenizer.nextToken();
            int width = (int) tokenizer.nval;
            tokenizer.nextToken();
            int height = (int) tokenizer.nval;
            map.compute(width, (key, value) -> value != null && value > height ? value : height);
        }

        long sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
        }

        System.out.println(sum);

    }
}
