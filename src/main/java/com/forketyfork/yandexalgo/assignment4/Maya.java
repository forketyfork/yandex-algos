package com.forketyfork.yandexalgo.assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * @see <a href="https://contest.yandex.ru/contest/27665/problems/H/">H. Расшифровка письменности Майя</a>
 */
public class Maya {

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line1 = reader.readLine();

            int space = line1.indexOf(' ');
            int wordLen = Integer.parseInt(line1.substring(0, space));
            int seqLen = Integer.parseInt(line1.substring(space + 1));

            int[] word = new int[52];
            for (int i = 0; i < wordLen; i++) {
                int letter = convert(reader.read());
                word[letter]++;
            }

            int uniqueLetters = 0;
            for (int i : word) {
                if (i > 0) {
                    uniqueLetters++;
                }
            }

            reader.readLine();

            int[] seq = new int[52];
            int matchSize = 0;
            int result = 0;
            ArrayDeque<Integer> buffer = new ArrayDeque<>();

            for (int i = 0; i < seqLen; i++) {

                int letter = convert(reader.read());

                buffer.addLast(letter);

                boolean wasEqual = seq[letter] == word[letter];

                seq[letter]++;

                boolean isEqual = seq[letter] == word[letter];

                if (wasEqual) {
                    matchSize--;
                }
                else if (isEqual) {
                    matchSize++;
                }

                if (i >= wordLen) {
                    letter = buffer.removeFirst();

                    wasEqual = seq[letter] == word[letter];

                    seq[letter]--;

                    isEqual = seq[letter] == word[letter];

                    if (wasEqual) {
                        matchSize--;
                    }
                    else if (isEqual) {
                        matchSize++;
                    }
                }

                if (matchSize == uniqueLetters) {
                    result++;
                }
            }

            System.out.println(result);

        }
    }

    private static int convert(int letter) {
        if (letter >= 'a' && letter <= 'z') {
            return letter - 'a';
        }
        else {
            return letter - 'A' + 26;
        }
    }
}