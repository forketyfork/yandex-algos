package com.forketyfork.yandexalgo.assignment1;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class IfTest {

    @AllArgsConstructor
    private static class TestCase {

        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;

        private final boolean expected;

    }

    public static Stream<TestCase> source() {
        return Stream.of(
                new TestCase(1, 1, 1, 1, 1, true),
                new TestCase(2, 2, 2, 1, 1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(If.canPass(
                testCase.a,
                testCase.b,
                testCase.c,
                testCase.d,
                testCase.e
        )).isEqualTo(testCase.expected);
    }

}
