package com.aor.refactoring.example5;

public class FrontCommand implements Command {
    public FrontCommand() {}

    @Override
    public void executeCommand(Turtle turtle) {
        if (turtle.getDirection() == 'N') turtle.decRow();
        else if (turtle.getDirection() == 'S') turtle.incRow();
        else if (turtle.getDirection() == 'W') turtle.decCol();
        else if (turtle.getDirection() == 'E') turtle.incCol();
    }
}
