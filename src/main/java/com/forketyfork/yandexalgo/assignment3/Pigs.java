package com.forketyfork.yandexalgo.assignment3;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27663/problems/H/">H. Злые свинки</a>
 */
public class Pigs {

    public static void main(String[] args) {

        int[][] birds;

        try (var scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            birds = new int[size][];
            for (int i = 0; i < size; i++) {
                birds[i] = new int[] {scanner.nextInt(), scanner.nextInt()};
            }
        }

        System.out.println(minSteps(birds));
    }

    public static int minSteps(int[][] birds) {
        var set = new HashSet<>();
        for (int[] bird : birds) {
            set.add(bird[0]);
        }
        return set.size();
    }

}
