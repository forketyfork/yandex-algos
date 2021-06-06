package com.forketyfork.yandexalgo.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Triangle {

    private static class Record {

        private final double value;
        private final boolean closer;

        Record(double value, boolean closer) {
            this.value = value;
            this.closer = closer;
        }
    }

    public static void main(String[] args) {

        int size;
        List<Record> elements;

        try (var scanner = new Scanner(System.in)) {
            size = scanner.nextInt();
            elements = new ArrayList<>(size);
            elements.add(new Record(scanner.nextDouble(), true));
            for (int i = 1; i < size; i++) {
                elements.add(new Record(
                        scanner.nextDouble(),
                        "closer".equals(scanner.nextLine().trim())
                ));
            }
        }

        double[] result = getRange(elements);

        System.out.println(result[0] + " " + result[1]);
    }

    public static double[] getRange(List<Record> elements) {

        double min = 30, max = 4000;

        double prev = elements.get(0).value;

        for (int i = 1; i < elements.size(); i++) {
            Record element = elements.get(i);
            if (element.value == prev) {
                continue;
            }
            double middle = (element.value + prev) / 2;
            if (element.value < prev && element.closer
                    || element.value >= prev && !element.closer) {
                max = Math.min(max, middle);
            }
            else {
                min = Math.max(min, middle);
            }
            prev = element.value;
        }
        return new double[] {min, max};
    }

}
