package com.forketyfork.yandexalgo.assignment1;

import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27393/problems/G/">G. Детали</a>
 */
public class Parts {

    public static void main(String[] args) {

        int n, k, m;

        try (var scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            m = scanner.nextInt();
        }

        int result = getTotalDetailsCount(n, k, m);

        System.out.println(result);
    }

    public static int getTotalDetailsCount(int n, int k, int m) {
        if (k > n || m > k) {
            return 0;
        }
        int total = 0;
        while (n >= k) {
            int ks = n / k;
            int ms = ks * (k / m);
            total += ms;
            n -= ms * m;
        }
        return total;
    }

}
