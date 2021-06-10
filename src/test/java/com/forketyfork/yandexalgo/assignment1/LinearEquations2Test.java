package com.forketyfork.yandexalgo.assignment1;

import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class LinearEquations2Test {

    @AllArgsConstructor
    private static class TestCase {

        private final int a, b, c, d, e, f;

        private final List<Number> expected;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(1, 0, 0, 1, 3, 3, List.of(2, 3.0, 3.0)),
                new TestCase(1, 1, 2, 2, 1, 2, List.of(1, -1.0, 1.0)),
                new TestCase(0, 2, 0, 4, 1, 2, List.of(4, 0.5)),
                new TestCase(1, 2, 3, 4, -1, -1, List.of(2, 1.0, -1.0)), // test 007
                new TestCase(2, 3, 4, 6, 1, 1, List.of(0)), // test 011
                new TestCase(0, 0, 1, 2, 0, 3, List.of(1, -0.5, 1.5)) // test 032
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(LinearEquations2.solve(testCase.a,
                testCase.b,
                testCase.c,
                testCase.d,
                testCase.e,
                testCase.f)).isEqualTo(testCase.expected);
    }

}
