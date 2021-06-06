package com.forketyfork.yandexalgo.assignment1;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmbulanceTest {

    private static class TestCase {

        private final int k1;
        private final int m;
        private final int k2;
        private final int p2;
        private final int n2;

        private final List<Integer> result;

        public TestCase(int k1, int m, int k2, int p2, int n2, List<Integer> result) {
            this.k1 = k1;
            this.m = m;
            this.k2 = k2;
            this.p2 = p2;
            this.n2 = n2;
            this.result = result;
        }

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
                new TestCase(1000, 1, 449, 449, 1, List.of(1000, 1)),
                new TestCase(753, 10, 1000, 1, 1, List.of(1, 1)),
                new TestCase(10, 3, 50, 1, 50, List.of(-1, -1))
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test(TestCase testCase) {
        assertEquals(testCase.result,
                Ambulance.calculate(
                        testCase.k1,
                        testCase.m,
                        testCase.k2,
                        testCase.p2,
                        testCase.n2
                ));
    }

}