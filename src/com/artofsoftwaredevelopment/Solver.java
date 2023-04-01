package com.artofsoftwaredevelopment;

public class Solver {
    public Board board;
    public Solution solution;

    public Solver(Board board) {
        this.board = board;
        this.solution = new Solution(board.size);
    }

    public void solve() {
        // Do something here
    }
}
