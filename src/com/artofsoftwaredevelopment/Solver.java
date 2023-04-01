package com.artofsoftwaredevelopment;

public class Solver {
    public Board board;
    public Solution solution;
    public PossibleRCSolutions[] rowConstraints;
    public PossibleRCSolutions[] columnConstraints;

    public Solver(Board board) {
        this.board = board;
        this.solution = new Solution(board.size);

        rowConstraints = new PossibleRCSolutions[board.size];
        for (int row = 0; row < board.size; row++) {
            rowConstraints[row] = getPossibleSolutionsForRow(board, row);
        }
        columnConstraints = new PossibleRCSolutions[board.size];
        for (int column = 0; column < board.size; column++) {
            columnConstraints[column] = getPossibleSolutionsForColumn(board, column);
        }
    }

    private PossibleRCSolutions getPossibleSolutionsForRow(Board board, int row) {
        PossibleRCSolutions allSubsets = PossibleRCSolutions.getAllPosibilities(board.size);

        int rowSum = board.rowSums[row];
        PossibleRCSolutions results = new PossibleRCSolutions();
        for (IndexSet indexSet : allSubsets) {
            int sum = 0;
            for (int index: indexSet) {
                sum += board.values[row][index];
            }
            if (sum == rowSum) {
                results.add(indexSet);
            }
        }
        return results;
    }

    private PossibleRCSolutions getPossibleSolutionsForColumn(Board board, int column) {
        PossibleRCSolutions allSubsets = PossibleRCSolutions.getAllPosibilities(board.size);

        int columnSum = board.columnSums[column];
        PossibleRCSolutions results = new PossibleRCSolutions();
        for (IndexSet indexSet : allSubsets) {
            int sum = 0;
            for (int index: indexSet) {
                sum += board.values[index][column];
            }
            if (sum == columnSum) {
                results.add(indexSet);
            }
        }
        return results;
    }

    public void solve() {
        // Do something here
    }
}
