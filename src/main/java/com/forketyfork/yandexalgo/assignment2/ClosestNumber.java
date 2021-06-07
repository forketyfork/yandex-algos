package com.forketyfork.yandexalgo.assignment2;

import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27472/problems/C/">C. Ближайшее число</a>
 */
public class ClosestNumber {

    public static void main(String[] args) {

        int size;
        int target;
        int[] elements;

        try (var scanner = new Scanner(System.in)) {
            size = scanner.nextInt();
            if (size == 0) {
                throw new UnsupportedOperationException();
            }
            elements = new int[size];
            for (int i = 0; i < size; i++) {
                elements[i] = scanner.nextInt();
            }
            target = scanner.nextInt();
        }

        System.out.println(closest(target, elements));
    }

    public static int closest(int target, int[] elements) {

        int closest = elements[0];
        int distance = Math.abs(target - closest);

        for (int i = 1; i < elements.length; i++) {
            int element = elements[i];
            int newDistance = Math.abs(target - element);
            if (newDistance < distance) {
                distance = newDistance;
                closest = element;
            }
        }

        return closest;
    }

}
