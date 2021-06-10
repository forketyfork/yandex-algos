package com.forketyfork.yandexalgo.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.forketyfork.yandexalgo.assignment2.Triangle.Record;
import static org.assertj.core.api.Assertions.assertThat;

class TriangleTest {

    @AllArgsConstructor
    private static class TestCase {

        private final List<Record> records;
        private final double[] expected;

    }

    public static Stream<TestCase> source() throws IOException {
        return Stream.of(
                new TestCase(List.of(new Record(440, true), new Record(220, true), new Record(300, false)),
                        new double[] {30.0, 260.0}),
                new TestCase(List.of(new Record(554, true),
                        new Record(880, false),
                        new Record(440, true),
                        new Record(622, true)),
                        new double[] {531, 660}),
                new TestCase(readFromFile(Path.of("src", "test", "resources", "assignment2", "triangle-008.txt")),
                        new double[] {3444.0, 3474.0}) // test 008
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void test(TestCase testCase) {
        assertThat(Triangle.getRange(testCase.records)).isEqualTo(testCase.expected);
    }

    private static List<Record> readFromFile(Path path) throws IOException {
        return Files.readAllLines(path).stream()
                .map(line -> {
                    String[] strings = line.split(" ");
                    double value = Double.parseDouble(strings[0]);
                    boolean closer = true;
                    if (strings.length == 2) {
                        closer = "closer".equals(strings[1]);
                    }
                    return new Record(value, closer);
                })
                .collect(Collectors.toList());
    }

}

