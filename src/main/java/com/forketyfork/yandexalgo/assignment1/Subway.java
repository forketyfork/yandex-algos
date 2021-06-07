package com.forketyfork.yandexalgo.assignment1;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @see <a href="https://contest.yandex.ru/contest/27393/problems/H/">H. Метро</a>
 */
public class Subway {

    public static void main(String[] args) {

        int a, b, n, m;

        try (var scanner = new Scanner(System.in)) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            n = scanner.nextInt();
            m = scanner.nextInt();
        }

        List<Integer> result = getInterval(a, b, n, m);

        System.out.println(result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    public static List<Integer> getInterval(int a, int b, int n, int m) {
        List<Integer> l1 = getInterval(a, n);
        List<Integer> l2 = getInterval(b, m);
        int i1 = Math.max(l1.get(0), l2.get(0));
        int i2 = Math.min(l1.get(1), l2.get(1));
        if (i1 > i2) {
            return Collections.singletonList(-1);
        }
        else {
            return List.of(i1, i2);
        }
    }

    public static List<Integer> getInterval(int a, int n) {
        return List.of(n + (n - 1) * a, n + (n + 1) * a);
    }

}
