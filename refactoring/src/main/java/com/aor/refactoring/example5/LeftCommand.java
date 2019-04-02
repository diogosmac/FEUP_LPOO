package com.aor.refactoring.example5;

public class LeftCommand implements Command {
    public LeftCommand() {}

    @Override
    public void executeCommand(Turtle turtle) {
        if (turtle.getDirection() == 'N') turtle.setDirection('W');
        else if (turtle.getDirection() == 'W') turtle.setDirection('S');
        else if (turtle.getDirection() == 'S') turtle.setDirection('E');
        else if (turtle.getDirection() == 'E') turtle.setDirection('N');
    }
}
