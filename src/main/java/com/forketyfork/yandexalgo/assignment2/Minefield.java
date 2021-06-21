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
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                int cell = field[i][j];
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
        int[][] field = new int[rows + 2][cols + 2];

        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (int[] b : bs) {
            field[b[0]][b[1]] = -1;
        }

        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                if (field[i][j] == -1) {
                    continue;
                }
                int sum = 0;

                for (int k = 0; k < 8; k++) {
                    if (field[i + dx[k]][j + dy[k]] == -1) {
                        sum++;
                    }
                }
                field[i][j] = sum;
            }
        }

        return field;
    }

}
