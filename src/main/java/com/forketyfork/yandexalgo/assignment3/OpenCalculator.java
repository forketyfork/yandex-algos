package com.forketyfork.yandexalgo.assignment3;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @see <a href="https://contest.yandex.ru/contest/27663/problems/E/">E. OpenCalculator</a>
 */
public class OpenCalculator {

    public static void main(String[] args) {

        List<Integer> numbers;
        int n;

        try (var scanner = new Scanner(System.in)) {
            numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            n = scanner.nextInt();
        }

        System.out.println(missingCount(numbers, n));
    }

    public static int missingCount(List<Integer> numbers, int n) {

        BitSet presentNumbers = new BitSet(10);
        numbers.forEach(presentNumbers::set);

        BitSet requiredNumbers = new BitSet(10);

        if (n == 0 && !presentNumbers.get(0)) {
            requiredNumbers.set(0);
        }
        else {
            while (n > 0) {
                int digit = n % 10;
                n /= 10;
                if (!presentNumbers.get(digit)) {
                    requiredNumbers.set(digit);
                }
            }
        }

        return requiredNumbers.cardinality();
    }

}
