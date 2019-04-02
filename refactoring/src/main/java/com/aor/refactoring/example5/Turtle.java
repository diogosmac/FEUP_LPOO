package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void decRow() {
        row--;
    }

    public void incRow() {
        row++;
    }

    public void decCol() {
        column--;
    }

    public void incCol() {
        column++;
    }

    public void execute(Command command) {
        command.executeCommand(this);
    }
}
