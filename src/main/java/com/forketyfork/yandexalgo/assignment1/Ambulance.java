package com.forketyfork.yandexalgo.assignment1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @see <a href="https://contest.yandex.ru/contest/27393/problems/E/">E. Скорая помощь</a>
 */
public class Ambulance {

    public static void main(String[] args) {

        int k1, m, k2, p2, n2;

        try (var scanner = new Scanner(System.in)) {
            k1 = scanner.nextInt();
            m = scanner.nextInt();
            k2 = scanner.nextInt();
            p2 = scanner.nextInt();
            n2 = scanner.nextInt();
        }

        List<Integer> result = calculate(k1, m, k2, p2, n2);
        System.out.println(result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    public static List<Integer> calculate(int k1, int m, int k2, int p2, int n2) {
        if (n2 > m) {
            return List.of(-1, -1);
        }
        if (p2 == 1 && n2 == 1) {
            if (m == 1) {
                if (k2 == k1) {
                    return List.of(1, 1);
                }
                return List.of(0, 1);
            }
            else if (m >= k1) {
                return List.of(1, 0);
            }
            else if (k1 <= k2) {
                return List.of(1, 1);
            }
            else {
                return List.of(0, 0);
            }
        }

        int p1 = -1, n1 = -1;
        for (int c = (int) Math.ceil(1.0 * k2 / ((p2 - 1) * m + n2));
                c < Math.ceil(1.0 * k2 / ((p2 - 1) * m + n2 - 1)); c++) {
            if (p1 == -1) {
                p1 = (k1 - 1) / (c * m) + 1;
                n1 = ((k1 - 1) % (c * m)) / c + 1;
            }
            else {
                if (p1 != 0 && p1 != (k1 - 1) / (c * m) + 1) {
                    p1 = 0;
                }
                if (n1 != 0 && n1 != ((k1 - 1) % (c * m)) / c + 1) {
                    n1 = 0;
                }
            }
        }
        return List.of(p1, n1);
    }

}
