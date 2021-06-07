package com.forketyfork.yandexalgo.assignment1;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @see <a href="https://contest.yandex.ru/contest/27393/problems/D/">D. Уравнение с корнем</a>
 */
public class Equation {

    public static void main(String[] args) {

        int a, b, c;

        try (var scanner = new Scanner(System.in)) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
        }

        var result = solve(a, b, c);

        if (result instanceof InfiniteExceptionsResult) {
            System.out.println("MANY SOLUTIONS");
        }
        else if (result instanceof ListResult) {
            var listResult = (ListResult) result;
            if (listResult.getRoots().isEmpty()) {
                System.out.println("NO SOLUTION");
            }
            else {
                System.out.println(listResult.getRoots().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")));
            }
        }
    }

    public static Result solve(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) {
            return Result.infinite();
        }
        if (c < 0) {
            return Result.empty();
        }
        if (a == 0) {
            if (b == c * c) {
                return Result.infinite();
            }
            else {
                return Result.empty();
            }
        }
        int d = c * c - b;
        if (d % a == 0) {
            return Result.single(d / a);
        }
        else {
            return Result.empty();
        }
    }

    public interface Result {

        static Result empty() {
            return new ListResult(Collections.emptyList());
        }

        static Result infinite() {
            return new InfiniteExceptionsResult();
        }

        static Result single(int x) {
            return new ListResult(Collections.singletonList(x));
        }

    }

    public static class InfiniteExceptionsResult implements Result {

    }

    public static class ListResult implements Result {

        private final List<Integer> roots;

        public ListResult(List<Integer> roots) {
            this.roots = Collections.unmodifiableList(roots);
        }

        public List<Integer> getRoots() {
            return roots;
        }

    }

}
