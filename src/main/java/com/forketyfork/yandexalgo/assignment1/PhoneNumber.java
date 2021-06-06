package com.forketyfork.yandexalgo.assignment1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneNumber {

    public static void main(String[] args) {

        String newNumber, number1, number2, number3;

        try (var scanner = new Scanner(System.in)) {
            newNumber = scanner.nextLine();
            number1 = scanner.nextLine();
            number2 = scanner.nextLine();
            number3 = scanner.nextLine();
        }

        for (boolean same : isNumberSame(newNumber, List.of(number1, number2, number3))) {
            System.out.println(same ? "YES" : "NO");
        }
    }

    public static List<Boolean> isNumberSame(String newNumber, List<String> numbers) {
        String newNormalizedNumber = normalizeNumber(newNumber);
        return numbers.stream()
                .map(PhoneNumber::normalizeNumber)
                .map(newNormalizedNumber::equals)
                .collect(Collectors.toList());
    }

    public static String normalizeNumber(String number) {

        var normalized = number.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c == '+' || (c >= '0' && c <= '9'))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

        if (normalized.substring(0, 2).equals("+7")) {
            normalized.delete(0, 2);
        }
        else if (normalized.length() == 7) {
            normalized.insert(0, "495");
        }
        else if (normalized.charAt(0) == '8' && normalized.length() == 11) {
            normalized.delete(0, 1);
        }
        return normalized.toString();
    }

}
