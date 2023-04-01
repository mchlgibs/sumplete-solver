package com.artofsoftwaredevelopment;

public interface Operation {
    void execute(Solver solver);
}

class CircleOperation implements Operation {
    final Cell cell;

    public CircleOperation(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void execute(Solver solver) {
        char current = solver.solution.values[cell.row][cell.column];
        if (current == ' ') {
            solver.solution.values[cell.row][cell.column] = 'O';
            solver.rowConstraints[cell.row].filterWith(cell.column);
            solver.columnConstraints[cell.column].filterWith(cell.row);
            solver.todoQueue.add(new ReevaluateRowOperation(cell.row));
            solver.todoQueue.add(new ReevaluateColumnOperation(cell.column));
        } else if (current == 'O') {
            // Do nothing
        } else {
            throw new RuntimeException("Bad state");
        }
    }
}

class CrossOutOperation implements Operation {
    final Cell cell;

    public CrossOutOperation(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void execute(Solver solver) {
        char current = solver.solution.values[cell.row][cell.column];
        if (current == ' ') {
            solver.solution.values[cell.row][cell.column] = 'X';
            solver.rowConstraints[cell.row].filterWithout(cell.column);
            solver.columnConstraints[cell.column].filterWithout(cell.row);
            solver.todoQueue.add(new ReevaluateRowOperation(cell.row));
            solver.todoQueue.add(new ReevaluateColumnOperation(cell.column));
        } else if (current == 'X') {
            // Do nothing
        } else {
            throw new RuntimeException("Bad state");
        }
    }
}

class ReevaluateRowOperation implements Operation {
    public final int row;

    public ReevaluateRowOperation(int row) {
        this.row = row;
    }

    @Override
    public void execute(Solver solver) {
        PossibleRCSolutions thisRow = solver.rowConstraints[row];

        if (thisRow.size() == 0) {
            throw new IllegalStateException();
        } else if (thisRow.size() == 1) {
            IndexSet theSolution = thisRow.get(0);
            for (int column = 0; column < solver.board.size; column++) {
                if (theSolution.contains(column)) {
                    solver.todoQueue.add(new CircleOperation(new Cell(row, column)));
                } else {
                    solver.todoQueue.add(new CrossOutOperation(new Cell(row, column)));
                }
            }
        } else {
            IndexSet intersection = IndexSet.intersection(thisRow);
            for (int column : intersection) {
                solver.todoQueue.add(new CircleOperation(new Cell(row, column)));
            }

            IndexSet union = IndexSet.union(thisRow);
            for (int column = 0; column < solver.board.size; column++) {
                if (!union.contains(column)) {
                    solver.todoQueue.add(new CrossOutOperation(new Cell(row, column)));
                }
            }
        }
    }
}


class ReevaluateColumnOperation implements Operation {
    public final int column;

    public ReevaluateColumnOperation(int column) {
        this.column = column;
    }

    @Override
    public void execute(Solver solver) {
        PossibleRCSolutions thisColumn = solver.columnConstraints[column];

        if (thisColumn.size() == 0) {
            throw new IllegalStateException();
        } if (thisColumn.size() == 1) {
            IndexSet theSolution = thisColumn.get(0);
            for (int row = 0; row < solver.board.size; row++) {
                if (theSolution.contains(row)) {
                    solver.todoQueue.add(new CircleOperation(new Cell(row, this.column)));
                } else {
                    solver.todoQueue.add(new CrossOutOperation(new Cell(row, this.column)));
                }
            }
        } else {
            IndexSet intersection = IndexSet.intersection(thisColumn);
            for (int row : intersection) {
                solver.todoQueue.add(new CircleOperation(new Cell(row, column)));
            }

            IndexSet union = IndexSet.union(thisColumn);
            for (int row = 0; row < solver.board.size; row++) {
                if (!union.contains(row)) {
                    solver.todoQueue.add(new CrossOutOperation(new Cell(row, column)));
                }
            }
        }
    }
}