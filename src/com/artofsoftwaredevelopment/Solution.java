package com.artofsoftwaredevelopment;

public class Solution {
    // X = crossed out
    // O = circled
    // <space> = unknown
    char[][] values;

    public Solution(int size) {
        values = new char[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                values[row][column] = ' ';
            }
        }
    }

    public void print() {

        System.out.print(" |");
        for (int column = 0; column < values.length; column++) {
            System.out.print(column);
        }
        System.out.println();

        for (int column = 0; column < values.length + 2; column++) {
            System.out.print('-');
        }
        System.out.println();

        for (int row = 0; row < values.length; row++) {
            System.out.print(row);
            System.out.print('|');
            for (int column = 0; column < values.length; column++) {
                System.out.print(values[row][column]);
            }
            System.out.println();
        }
    }
}
