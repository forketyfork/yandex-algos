package com.forketyfork.yandexalgo.assignment1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Notebooks {

    public static void main(String[] args) {

        int x1, y1, x2, y2;

        try (var scanner = new Scanner(System.in)) {
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
        }

        List<Integer> results = getTableSize(x1, y1, x2, y2);

        System.out.println(results.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    public static class Solution implements Comparable<Solution> {

        private final int width;
        private final int height;
        private final int square;

        public Solution(int width, int height) {
            this.width = width;
            this.height = height;
            this.square = width * height;
        }

        @Override
        public int compareTo(Solution o) {
            return Integer.compare(this.square, o.square);
        }

        public List<Integer> toList() {
            return List.of(width, height);
        }

    }

    public static List<Integer> getTableSize(int x1, int y1, int x2, int y2) {

        List<Solution> solutions = Arrays.asList(
                new Solution(Math.max(x1, x2), y1 + y2),
                new Solution(x1 + x2, Math.max(y1, y2)),
                new Solution(Math.max(x1, y2), y1 + x2),
                new Solution(x1 + y2, Math.max(y1, x2))
        );
        Collections.sort(solutions);
        return solutions.get(0).toList();
    }

}
