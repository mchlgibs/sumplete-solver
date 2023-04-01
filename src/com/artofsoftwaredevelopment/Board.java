package com.artofsoftwaredevelopment;

public class Board {
    public final int size;
    public final int[][] values;
    public final int[] rowSums;
    public final int[] columnSums;

    public Board(int size, int[][] values, int[] rowSums, int[] columnSums) {
        this.size = size;
        this.values = values;
        this.rowSums = rowSums;
        this.columnSums = columnSums;

        assert(size > 0);
        assert(rowSums.length == size);
        assert(columnSums.length == size);
        assert(values.length == size);
        assert(values[0].length == size);
    }
}
