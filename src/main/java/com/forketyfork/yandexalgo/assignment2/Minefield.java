package com.forketyfork.yandexalgo.assignment2;

import java.util.Scanner;

/**
 * @see <a href="https://contest.yandex.ru/contest/27472/problems/I/">I. Сапер</a>
 */
public class Minefield {

    public static void main(String[] args) {

        int rows, cols, b;
        int[][] bs;

        try (var scanner = new Scanner(System.in)) {
            rows = scanner.nextInt();
            cols = scanner.nextInt();
            b = scanner.nextInt();
            bs = new int[b][];
            for (int i = 0; i < b; i++) {
                bs[i] = new int[2];
                bs[i][0] = scanner.nextInt();
                bs[i][1] = scanner.nextInt();
            }
        }

        int[][] field = field(rows, cols, bs);
        for (int[] row : field) {
            for (int cell : row) {
                if (cell == -1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] field(int rows, int cols, int[][] bs) {
        int[][] field = new int[rows][cols];

        for (int[] b : bs) {
            field[b[0] - 1][b[1] - 1] = -1;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (field[i][j] == -1) {
                    continue;
                }
                int sum = 0;
                if (i > 0 && field[i - 1][j] == -1) {
                    sum++;
                }
                if (i < rows - 1 && field[i + 1][j] == -1) {
                    sum++;
                }
                if (j > 0 && field[i][j - 1] == -1) {
                    sum++;
                }
                if (j < cols - 1 && field[i][j + 1] == -1) {
                    sum++;
                }
                if (i > 0 && j > 0 && field[i - 1][j - 1] == -1) {
                    sum++;
                }
                if (i > 0 && j < cols - 1 && field[i - 1][j + 1] == -1) {
                    sum++;
                }
                if (i < rows - 1 && j > 0 && field[i + 1][j - 1] == -1) {
                    sum++;
                }
                if (i < rows - 1 && j < cols - 1 && field[i + 1][j + 1] == -1) {
                    sum++;
                }
                field[i][j] = sum;
            }
        }

        return field;
    }

}
