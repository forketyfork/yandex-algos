package com.forketyfork.yandexalgo.assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27663/problems/A/">A. Количество различных чисел</a>
 */
public class Unique {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        try (var scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        }

        System.out.println(uniqueNumbers(numbers));
    }

    public static int uniqueNumbers(List<Integer> numbers) {
        return new HashSet<>(numbers).size();
    }

}
