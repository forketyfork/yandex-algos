package com.forketyfork.yandexalgo.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @see <a href="https://contest.yandex.ru/contest/27472/problems/H/">H. Наибольшее произведение трёх чисел</a>
 */
public class MaxThreeMult {

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>();

        try (var scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                elements.add(scanner.nextInt());
            }
        }

        System.out.println(max3Mult(elements).stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));

    }

    public static List<Integer> max3Mult(List<Integer> list) {
        if (list.size() < 3) {
            throw new UnsupportedOperationException();
        }
        if (list.size() == 3) {
            return list;
        }

        int max1pos = 0, max2pos = 0, max3pos = 0, min1neg = 0, min2neg = 0,
                max1neg = Integer.MIN_VALUE, max2neg = Integer.MIN_VALUE, max3neg = Integer.MIN_VALUE;
        int nonNegCount = 0;
        for (int value : list) {
            if (value >= 0) {
                nonNegCount++;
            }
            if (value > 0) {
                if (value > max1pos) {
                    max3pos = max2pos;
                    max2pos = max1pos;
                    max1pos = value;
                }
                else if (value > max2pos) {
                    max3pos = max2pos;
                    max2pos = value;
                }
                else if (value > max3pos) {
                    max3pos = value;
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
                if (value > max1neg) {
                    max3neg = max2neg;
                    max2neg = max1neg;
                    max1neg = value;
                }
                else if (value > max2neg) {
                    max3neg = max2neg;
                    max2neg = value;
                }
                else if (value > max3neg) {
                    max3neg = value;
                }
            }
        }

        if (nonNegCount == 0) {
            return List.of(max1neg, max2neg, max3neg);
        }
        long threePosMul = (long) max1pos * max2pos * max3pos;

        long posTwoNegMul = (long) max1pos * min1neg * min2neg;

        if (threePosMul > posTwoNegMul) {
            return List.of(max1pos, max2pos, max3pos);
        }
        else {
            return List.of(max1pos, min1neg, min2neg);
        }

    }

}
