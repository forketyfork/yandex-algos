package com.forketyfork.yandexalgo.assignment2;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class SequenceType {

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>();

        try (var scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int nextInt = scanner.nextInt();
                if (nextInt == -2000000000) {
                    break;
                }
                elements.add(nextInt);
            }
        }

        System.out.println(getSequenceType(elements).getDisplayName());

    }

    public enum Type {
        CONSTANT("CONSTANT"),
        ASCENDING("ASCENDING"),
        WEAKLY_ASCENDING("WEAKLY ASCENDING"),
        DESCENDING("DESCENDING"),
        WEAKLY_DESCENDING("WEAKLY DESCENDING"),
        RANDOM("RANDOM");

        private final String displayName;

        public String getDisplayName() {
            return displayName;
        }

        Type(String displayName) {
            this.displayName = displayName;
        }
    }

    public static Type getSequenceType(List<Integer> list) {
        var typeSet = EnumSet.allOf(Type.class);

        if (list.size() < 2) {
            throw new UnsupportedOperationException();
        }

        int prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i);

            if (value == prev) {
                typeSet.remove(Type.ASCENDING);
                typeSet.remove(Type.DESCENDING);
            }
            else {
                typeSet.remove(Type.CONSTANT);
                if (value > prev) {
                    typeSet.remove(Type.DESCENDING);
                    typeSet.remove(Type.WEAKLY_DESCENDING);
                }
                else {
                    typeSet.remove(Type.ASCENDING);
                    typeSet.remove(Type.WEAKLY_ASCENDING);
                }

            }
            if (typeSet.size() == 1) {
                return typeSet.iterator().next();
            }
            prev = value;
        }

        typeSet.remove(Type.RANDOM);

        if (typeSet.size() == 1) {
            return typeSet.iterator().next();
        }

        if (typeSet.contains(Type.CONSTANT)) {
            return Type.CONSTANT;
        }
        if (typeSet.contains(Type.ASCENDING)) {
            return Type.ASCENDING;
        }
        if (typeSet.contains(Type.DESCENDING)) {
            return Type.DESCENDING;
        }

        throw new UnsupportedOperationException();

    }

}
