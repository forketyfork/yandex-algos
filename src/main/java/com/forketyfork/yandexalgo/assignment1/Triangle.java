package com.forketyfork.yandexalgo.assignment1;

import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27393/problems/B/">B. Треугольник</a>
 */
public class Triangle {

    public static void main(String[] args) {

        int a, b, c;

        try (var scanner = new Scanner(System.in)) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
        }

        if (isTriangle(a, b, c)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static boolean isTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }

}
