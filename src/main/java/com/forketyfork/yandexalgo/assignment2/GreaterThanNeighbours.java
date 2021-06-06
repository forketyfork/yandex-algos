package com.forketyfork.yandexalgo.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GreaterThanNeighbours {

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>();

        try (var scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                elements.add(scanner.nextInt());
            }
        }

        System.out.println(greaterThanNeighbours(elements));
    }

    public static int greaterThanNeighbours(List<Integer> elements) {
        if (elements.size() < 3) {
            return 0;
        }

        int total = 0;
        int prev1 = elements.get(1), prev2 = elements.get(0);

        for (int i = 2; i < elements.size(); i++) {
            int curr = elements.get(i);
            if (prev1 > curr && prev1 > prev2) {
                total++;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return total;
    }

}
