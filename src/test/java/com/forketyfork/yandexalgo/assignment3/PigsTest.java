package com.forketyfork.yandexalgo.assignment3;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class PigsTest {

    @AllArgsConstructor
    private static class TestCase {

        private final int[][] birds;
        private final int expected;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[][] {
                        new int[] {1, 1}, new int[] {2, 2}, new int[] {3, 3}, new int[] {2, 1}, new int[] {3, 2},
                        new int[] {3, 1}
                }, 3),
                new TestCase(new int[][] {
                        new int[] {1, 1}, new int[] {2, 2}, new int[] {3, 3}, new int[] {2, 1}, new int[] {3, 2},
                        new int[] {3, 4}
                }, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(Pigs.minSteps(testCase.birds)).isEqualTo(testCase.expected);
    }

}