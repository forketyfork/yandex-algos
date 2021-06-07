package com.forketyfork.yandexalgo.assignment1;

import java.util.Locale;
import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27393/problems/A/">A. Кондиционер</a>
 */
public class Conditioner {

    private enum Mode {
        FREEZE, HEAT, AUTO, FAN
    }

    public static void main(String[] args) {

        int startTemp;
        int endTemp;
        Mode mode;

        try (var scanner = new Scanner(System.in)) {
            startTemp = scanner.nextInt();
            endTemp = scanner.nextInt();
            scanner.nextLine();
            mode = Mode.valueOf(scanner.nextLine().toUpperCase(Locale.ENGLISH));
        }

        int actualTemp = getActualTemp(mode, startTemp, endTemp);

        System.out.println(actualTemp);
    }

    public static int getActualTemp(Mode mode, int startTemp, int endTemp) {
        return switch (mode) {
            case FAN -> startTemp;
            case AUTO -> endTemp;
            case FREEZE -> Math.min(startTemp, endTemp);
            case HEAT -> Math.max(startTemp, endTemp);
        };
    }

}
