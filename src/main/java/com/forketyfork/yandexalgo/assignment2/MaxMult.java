package com.forketyfork.yandexalgo.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @see <a href="https://contest.yandex.ru/contest/27472/problems/G/">G. Наибольшее произведение двух чисел</a>
 */
public class MaxMult {

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>();

        try (var scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                elements.add(scanner.nextInt());
            }
        }

        System.out.println(maxMult(elements).stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));

    }

    public static List<Integer> maxMult(List<Integer> list) {
        if (list.size() == 2) {
            return List.of(Math.min(list.get(0), list.get(1)), Math.max(list.get(0), list.get(1)));
        }
        int max1pos = 0, max2pos = 0, min1neg = 0, min2neg = 0;
        for (int value : list) {
            if (value > 0) {
                if (value > max1pos) {
                    max2pos = max1pos;
                    max1pos = value;
                }
                else if (value > max2pos) {
                    max2pos = value;
                }
            }
            else if (value < 0) {
                if (value < min1neg) {
                    min2neg = min1neg;
                    min1neg = value;
                }
                else if (value < min2neg) {
                    min2neg = value;
                }
            }
        }

        if (((max1pos > 0 || max2pos > 0) && (min1neg == 0 && min2neg == 0)) ||
                (long) max1pos * max2pos > (long) min1neg * min2neg) {
            return List.of(max2pos, max1pos);
        }
        else {
            return List.of(min1neg, min2neg);
        }
    }

}
