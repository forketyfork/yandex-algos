package com.forketyfork.yandexalgo.assignment3;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class IntersectTest {

    @AllArgsConstructor
    private static class TestCase {

        private final List<Integer> numbers1;
        private final List<Integer> numbers2;
        private final List<Integer> expected;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(List.of(1, 3, 2), List.of(4, 3, 2), List.of(2, 3)),
                new TestCase(List.of(1, 2, 6, 4, 5, 7), List.of(10, 2, 3, 4, 8), List.of(2, 4)),
                new TestCase(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
                new TestCase(List.of(1), List.of(1), List.of(1)),
                new TestCase(List.of(1), List.of(2), Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(Intersect.intersect(testCase.numbers1, testCase.numbers2)).isEqualTo(testCase.expected);
    }

}