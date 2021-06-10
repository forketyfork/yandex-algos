package com.forketyfork.yandexalgo.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MaxThreeMultTest {

    @AllArgsConstructor
    private static class TestCase {

        private final List<Integer> numbers;
        private final List<Integer> expected;

    }

    public static Stream<TestCase> source() throws IOException {
        return Stream.of(
                new TestCase(List.of(3, 5, 1, 7, 9, 0, 9, -3, 10), List.of(10, 9, 9)),
                new TestCase(List.of(-5, -30000, -12), List.of(-5, -12, -30000)),
                new TestCase(List.of(1, 2, 3), List.of(3, 2, 1)),
                new TestCase(List.of(-70,
                        -68,
                        -29,
                        -45,
                        -34,
                        -88,
                        -32,
                        -38,
                        -25,
                        -95,
                        -68,
                        -96,
                        -28,
                        -45,
                        -59,
                        -95,
                        -73,
                        -8,
                        -37,
                        -49,
                        -47,
                        -9,
                        -61,
                        -91,
                        -11,
                        -90,
                        -16,
                        -25,
                        -17,
                        -4,
                        -14,
                        -38,
                        -38,
                        -85,
                        -46,
                        -16,
                        -22,
                        -63,
                        -54,
                        -14,
                        -51,
                        -4,
                        -20,
                        -44,
                        -74,
                        -78,
                        -83,
                        -91,
                        -35,
                        -43,
                        -49,
                        -89,
                        -100,
                        -27,
                        -39,
                        -95,
                        -90,
                        -90,
                        -92,
                        -48,
                        -44,
                        -4,
                        -37,
                        -13,
                        -73,
                        -28,
                        -61,
                        -32,
                        -95,
                        -43,
                        -83,
                        -43,
                        -51,
                        -19), List.of(-4, -4, -4)), // test 016
                new TestCase(readFromFile(Path.of("src", "test", "resources", "assignment2", "max-three-mult-050.txt")),
                        List.of(999804, -999911, -999860)) // test 050
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(MaxThreeMult.max3Mult(testCase.numbers)).containsExactlyInAnyOrderElementsOf(testCase.expected);
    }

    private static List<Integer> readFromFile(Path path) throws IOException {
        return Arrays.stream(Files.readString(path).split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
