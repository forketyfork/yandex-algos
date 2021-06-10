package com.forketyfork.yandexalgo.assignment3;

import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class OpenCalculatorTest {

    @AllArgsConstructor
    private static class TestCase {

        private final List<Integer> numbers;
        private final int n;
        private final int expected;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(List.of(1, 2, 3), 1123, 0),
                new TestCase(List.of(1, 2, 3), 1001, 1),
                new TestCase(List.of(5, 7, 3), 123, 2),
                new TestCase(List.of(), 123, 3),
                new TestCase(List.of(0), 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(OpenCalculator.missingCount(testCase.numbers, testCase.n)).isEqualTo(testCase.expected);
    }

}