package com.forketyfork.yandexalgo.assignment3;

import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class DiceTest {

    @AllArgsConstructor
    private static class TestCase {

        private final int[] numbers1;
        private final int[] numbers2;
        private final List<Integer> expectedIntersect;
        private final List<Integer> expectedUnique1;
        private final List<Integer> expectedUnique2;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(new int[] {0, 1, 10, 9}, new int[] {1, 3, 0}, List.of(0, 1), List.of(9, 10), List.of(3)),
                new TestCase(new int[] {1, 2}, new int[] {2, 3}, List.of(2), List.of(1), List.of(3)),
                new TestCase(new int[] {}, new int[] {}, List.of(), List.of(), List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        var result = Dice.intersect(testCase.numbers1, testCase.numbers2);
        assertThat(result.getIntersect()).isEqualTo(testCase.expectedIntersect);
        assertThat(result.getUnique1()).isEqualTo(testCase.expectedUnique1);
        assertThat(result.getUnique2()).isEqualTo(testCase.expectedUnique2);
    }

}