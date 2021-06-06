package com.forketyfork.yandexalgo.assignment2;

import java.util.Scanner;

public class SymmetricSequence {

    public static void main(String[] args) {

        int size;
        int[] elements;

        try (var scanner = new Scanner(System.in)) {
            size = scanner.nextInt();
            elements = new int[size];
            for (int i = 0; i < size; i++) {
                elements[i] = scanner.nextInt();
            }
        }

        int sequenceStart = sequenceStart(elements);
        System.out.println(sequenceStart + 1);
        for (int i = sequenceStart; i >= 0; i--) {
            System.out.print(elements[i]);
            System.out.print(' ');
        }
    }

    public static int sequenceStart(int[] elements) {
        outer:
        for (int i = 0; i < elements.length; i++) {
            int middle = (i + elements.length) >> 1;
            for (int j = i; j <= middle; j++) {
                if (elements[j] != elements[elements.length - j + i - 1]) {
                    continue outer;
                }
            }
            return i - 1;
        }
        return elements.length - 1;
    }

}
