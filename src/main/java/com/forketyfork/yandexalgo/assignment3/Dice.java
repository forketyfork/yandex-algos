package com.forketyfork.yandexalgo.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://contest.yandex.ru/contest/27663/problems/C/">C. Кубики</a>
 */
public class Dice {

    public static void main(String[] args) throws IOException {

        var streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        streamTokenizer.nextToken();
        int size1 = (int) streamTokenizer.nval;
        int[] numbers1 = new int[size1];

        streamTokenizer.nextToken();
        int size2 = (int) streamTokenizer.nval;
        int[] numbers2 = new int[size2];

        for (int i = 0; i < size1; i++) {
            streamTokenizer.nextToken();
            numbers1[i] = (int) streamTokenizer.nval;
        }
        for (int i = 0; i < size2; i++) {
            streamTokenizer.nextToken();
            numbers2[i] = (int) streamTokenizer.nval;
        }

        var result = intersect(numbers1, numbers2);

        PrintWriter writer = new PrintWriter(System.out);

        printList(writer, result.intersect);
        printList(writer, result.unique1);
        printList(writer, result.unique2);

        writer.flush();
    }

    private static void printList(PrintWriter writer, List<Integer> list) {
        writer.println(list.size());
        list.forEach(element -> {
            writer.print(element);
            writer.print(' ');
        });
        writer.println();
    }

    public static final class Result {

        private final List<Integer> intersect;
        private final List<Integer> unique1;
        private final List<Integer> unique2;

        public Result(List<Integer> intersect, List<Integer> unique1, List<Integer> unique2) {
            this.intersect = intersect;
            this.unique1 = unique1;
            this.unique2 = unique2;
        }

        public List<Integer> getIntersect() {
            return intersect;
        }

        public List<Integer> getUnique1() {
            return unique1;
        }

        public List<Integer> getUnique2() {
            return unique2;
        }
    }

    public static Result intersect(int[] numbers1, int[] numbers2) {
        List<Integer> intersect = new ArrayList<>();
        List<Integer> unique1 = new ArrayList<>();
        List<Integer> unique2 = new ArrayList<>();
        Result result = new Result(intersect, unique1, unique2);

        Set<Integer> numbers1Set = new HashSet<>(Math.max((int) (numbers1.length / 0.75) + 1, 16));
        for (int number1 : numbers1) {
            numbers1Set.add(number1);
        }
        for (int number2 : numbers2) {
            if (numbers1Set.remove(number2)) {
                intersect.add(number2);
            }
            else {
                unique2.add(number2);
            }
        }
        unique1.addAll(numbers1Set);

        Collections.sort(intersect);
        Collections.sort(unique1);
        Collections.sort(unique2);

        return result;
    }

}
