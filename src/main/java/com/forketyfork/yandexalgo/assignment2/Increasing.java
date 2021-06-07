package com.forketyfork.yandexalgo.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27472/problems/A/">A. Возрастает ли список?</a>
 */
public class Increasing {

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>();

        try (var scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                elements.add(scanner.nextInt());
            }
        }

        if (isIncreasing(elements)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }

    public static boolean isIncreasing(List<Integer> list) {
        int prev = Integer.MIN_VALUE;
        for (Integer i : list) {
            if (i <= prev) {
                return false;
            }
            prev = i;
        }
        return true;
    }

}
