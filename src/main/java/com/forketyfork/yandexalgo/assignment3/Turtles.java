package com.forketyfork.yandexalgo.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.regex.Pattern;

public class Turtles {

    public static void main(String[] args) throws IOException {

        int count;

        Pattern regex = Pattern.compile(" ");
        BitSet set = new BitSet(10000);

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                String[] values = regex.split(reader.readLine());
                int before = Integer.parseInt(values[0]);
                int after = Integer.parseInt(values[1]);
                if (before >= 0 && after >= 0 && before + after + 1 == count) {
                    set.set(before);
                }
            }
        }
        System.out.println(set.cardinality());
    }

}
