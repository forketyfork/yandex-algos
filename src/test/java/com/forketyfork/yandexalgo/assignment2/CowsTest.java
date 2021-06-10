package com.forketyfork.yandexalgo.assignment2;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CowsTest {

    @AllArgsConstructor
    private static class TestCase {

        private final int[] places;
        private final int expected;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[] {10, 20, 15, 10, 30, 5, 1}, 6),
                new TestCase(new int[] {15, 15, 10}, 1),
                new TestCase(new int[] {10, 15, 20}, 0),
                new TestCase(new int[] {1000, 100, 15}, 0) // test 004
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(Cows.maximumPlace(testCase.places)).isEqualTo(testCase.expected);
    }

}