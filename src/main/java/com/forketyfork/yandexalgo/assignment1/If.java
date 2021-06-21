package com.forketyfork.yandexalgo.assignment1;

import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27393/problems/I/">I. Узник замка Иф</a>
 */
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

        int[] values = {a, b, c, d, e};

        sort2(values, 3);
        sort2(values, 0);
        sort2(values, 1);
        sort2(values, 0);

        return values[0] <= values[3] && values[1] <= values[4];
    }

    public static void sort2(int[] array, int first) {
        int second = first + 1;
        if (array[first] > array[second]) {
            int tmp = array[first];
            array[first] = array[second];
            array[second] = tmp;
        }
    }

}
