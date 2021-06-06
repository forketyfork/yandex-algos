package com.forketyfork.yandexalgo.assignment1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LinearEquations2 {

    public static void main(String[] args) {

        double a, b, c, d, e, f;

        try (var scanner = new Scanner(System.in)) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            d = scanner.nextDouble();
            e = scanner.nextDouble();
            f = scanner.nextDouble();
        }

        var result = solve(a, b, c, d, e, f);

        System.out.println(result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    public static List<Number> solve(double a, double b, double c, double d, double e, double f) {
        if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0) {
            return List.of(5);
        }

        if (a == 0 && b == 0 && e != 0 || c == 0 && d == 0 && f != 0) {
            return List.of(0);
        }

        if (b == 0 && d == 0) {
            if (a == 0 && c != 0) {
                return List.of(3, f / c);
            }
            else if (a != 0 && c == 0) {
                return List.of(3, e / a);
            }
            double d1 = e / a;
            double d2 = f / c;
            if (d1 == d2) {
                return List.of(3, d1);
            }
            else {
                return List.of(0);
            }
        }

        if (a == 0 && c == 0) {
            if (b == 0 && d != 0) {
                return List.of(4, f / d);
            }
            else if (b != 0 && d == 0) {
                return List.of(4, e / b);
            }
            double d1 = e / b;
            double d2 = f / d;
            if (d1 == d2) {
                return List.of(4, d1);
            }
            else {
                return List.of(0);
            }
        }

        if (a == 0 && b == 0 && e == 0) {
            double k = -c / d;
            double kb = f / d;
            return List.of(1, k, kb);
        }

        if (c == 0 && d == 0 && f == 0) {
            double k = -a / b;
            double kb = e / b;
            return List.of(1, k, kb);
        }

        if (a == 0 && b != 0 && c != 0) {
            double y = e / b;
            double x = (f - d * y) / c;
            return List.of(2, x, y);
        }
        else if (b == 0 && a != 0 && d != 0) {
            double x = e / a;
            double y = (f - c * x) / d;
            return List.of(2, x, y);
        }
        else if (c == 0 && d != 0 && a != 0) {
            double y = f / d;
            double x = (e - b * y) / a;
            return List.of(2, x, y);
        }
        else if (d == 0 && c != 0 && b != 0) {
            double x = f / c;
            double y = (e - a * x) / b;
            return List.of(2, x, y);
        }

        double d1 = -a / b;
        double d2 = e / b;
        double d3 = -c / d;
        double d4 = f / d;
        if (d1 == d3 && d2 == d4) {
            return List.of(1, d1, d2);
        }

        double det = c * b - d * a;

        if (det == 0) {
            return List.of(0);
        }

        double x = (f * b - d * e) / det;
        double y = -a * x / b + e / b;
        return List.of(2, x, y);

    }

}
