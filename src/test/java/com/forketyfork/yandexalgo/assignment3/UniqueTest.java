package com.forketyfork.yandexalgo.assignment3;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueTest {

    @AllArgsConstructor
    private static class TestCase {

        private final List<Integer> numbers;
        private final int expected;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(List.of(1, 2, 3, 2, 1), 3),
                new TestCase(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10),
                new TestCase(List.of(1, 2, 3, 4, 5, 1, 2, 1, 2, 7, 3), 6),
                new TestCase(Collections.emptyList(), 0),
                new TestCase(Collections.singletonList(1), 1),
                new TestCase(List.of(1, 1), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(testCase.expected).isEqualTo(Unique.uniqueNumbers(testCase.numbers));
    }

}