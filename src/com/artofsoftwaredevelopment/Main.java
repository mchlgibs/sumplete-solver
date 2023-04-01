package com.artofsoftwaredevelopment;

public class Main {
    private static Board board3x3() {
        return new Board(
            3,
            new int[][]{
                {8, 7, 7},
                {4, 8, 2},
                {1, 3, 6}
            },
            new int[]{14, 6, 0},
            new int[]{4, 7, 9}
        );
    }

    private static Board board6x6() {
        return new Board(
            6,
            new int[][]{
                {6, 5, 3, 5, 8, 5},
                {3, 3, 3, 1, 3, 2},
                {1, 2, 4, 4, 5, 9},
                {8, 4, 3, 7, 1, 3},
                {1, 5, 3, 1, 1, 8},
                {2, 9, 2, 4, 8, 8}
            },
            new int[]{13, 7, 14, 18, 14, 21},
            new int[]{12, 17, 9, 13, 11, 25}
        );
    }

    private static Board board9x9() {
        return new Board(
            9,
            new int[][]{
                {-11, -2, 11, 11, -19, -3, -9, 2, -6},
                {-1, -19, -13, 13, -11, -17, -11, -12, 12},
                {18, 10, -17, -5, 11, -5, 2, 5, 14},
                {15, 16, -11, -3, 12, -18, -1, -12, -4},
                {2, 1, 7, -4, -13, -16, 19, 14, -2},
                {19, 6, -4, 10, 13, -1, -17, -2, -14},
                {9, 16, 2, -14, -9, -6, 9, -3, 13},
                {-8, 11, -19, -13, -17, -5, 14, 19, 4},
                {-3, 16, 12, -11, 10, -2, 8, -7, -9}
            },
            new int[]{-12, -72, 24, 9, -15, -3, 30, -19, 10},
            new int[]{34, 13, -11, 12, -49, -54, 33, -13, -13}
        );
    }
    public static void main(String[] args) {
        Board board = board3x3();
        Solver solver = new Solver(board);
        solver.solve();
        solver.solution.print();
    }
}
