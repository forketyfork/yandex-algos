package com.forketyfork.yandexalgo.assignment2;

import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27472/problems/E/">E. Чемпионат по метанию коровьих лепешек</a>
 */
public class Cows {

    public static void main(String[] args) {

        int size;
        int[] elements;

        try (var scanner = new Scanner(System.in)) {
            size = scanner.nextInt();
            elements = new int[size];
            for (int i = 0; i < size; i++) {
                elements[i] = scanner.nextInt();
            }
        }

        System.out.println(maximumPlace(elements));
    }

    public static int maximumPlace(int[] elements) {

        int leftmostWinner = -1;
        int winnerThrow = 0;
        int maxThrow = 0;
        int maxThrowPos = -1;
        for (int i = 0; i < elements.length; i++) {
            int element = elements[i];
            if (element > winnerThrow) {
                leftmostWinner = i;
                winnerThrow = element;
                maxThrow = 0;
                maxThrowPos = -1;
            }
            else if (i < elements.length - 1
                    && leftmostWinner != -1
                    && element % 10 == 5
                    && elements[i + 1] < element
                    && element > maxThrow) {
                maxThrow = element;
                maxThrowPos = i;
            }
        }

        if (maxThrowPos == -1) {
            return 0;
        }

        int place = 1;
        for (int element : elements) {
            if (element > maxThrow) {
                place++;
            }
        }

        return place;
    }

}
