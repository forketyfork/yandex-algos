package com.forketyfork.yandexalgo.assignment1;

import java.util.Scanner;

public class If {

    public static void main(String[] args) {

        int a, b, c, d, e;

        try (var scanner = new Scanner(System.in)) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            d = scanner.nextInt();
            e = scanner.nextInt();
        }

        boolean result = canPass(a, b, c, d, e);

        System.out.println(result ? "YES" : "NO");
    }

    public static boolean canPass(int a, int b, int c, int d, int e) {
        return a <= d && b <= e
                || a <= d && c <= e
                || b <= d && a <= e
                || b <= d && c <= e
                || c <= d && a <= e
                || c <= d && b <= e;
    }

}
