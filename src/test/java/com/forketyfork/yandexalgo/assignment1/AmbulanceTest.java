package com.forketyfork.yandexalgo.assignment1;

import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class AmbulanceTest {

    @AllArgsConstructor
    private static class TestCase {

        private final int k1;
        private final int m;
        private final int k2;
        private final int p2;
        private final int n2;

        private final List<Integer> expected;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(89, 20, 41, 1, 11, List.of(2, 3)),
                new TestCase(11, 1, 1, 1, 1, List.of(0, 1)),
                new TestCase(3, 2, 2, 2, 1, List.of(-1, -1)),
                new TestCase(5, 20, 2, 1, 1, List.of(1, 0)),
                new TestCase(1, 1, 1, 1, 1, List.of(1, 1)),
                new TestCase(11, 2, 4, 1, 2, List.of(0, 2)),
                new TestCase(41, 10, 41, 1, 10, List.of(-1, -1)),
                new TestCase(1000, 1, 449, 449, 1, List.of(1000, 1)), // test 006
                new TestCase(753, 10, 1000, 1, 1, List.of(1, 1)), // test 009
                new TestCase(10, 3, 50, 1, 50, List.of(-1, -1)) // test 023
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(Ambulance.calculate(
                testCase.k1,
                testCase.m,
                testCase.k2,
                testCase.p2,
                testCase.n2
        )).isEqualTo(testCase.expected);
    }

}
