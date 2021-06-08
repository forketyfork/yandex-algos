package com.forketyfork.yandexalgo.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://contest.yandex.ru/contest/27663/problems/B/">B. Пересечение множеств</a>
 */
public class Intersect {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("input.txt"));

        List<Integer> numbers1 = Arrays.stream(lines.get(0).split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbers2 = Arrays.stream(lines.get(1).split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = intersect(numbers1, numbers2);

        String resultString = result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        Files.write(Path.of("output.txt"), Collections.singletonList(resultString));
    }

    public static List<Integer> intersect(List<Integer> numbers1, List<Integer> numbers2) {
        var numbers1Set = new HashSet<>(numbers1);
        return numbers2.stream()
                .filter(numbers1Set::contains)
                .sorted()
                .collect(Collectors.toList());
    }

}
