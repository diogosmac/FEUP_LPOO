package com.aor.refactoring.example5;

public class RightCommand implements Command {
    public RightCommand() {}

    @Override
    public void executeCommand(Turtle turtle) {
        if (turtle.getDirection() == 'N') turtle.setDirection('E');
        else if (turtle.getDirection() == 'E') turtle.setDirection('S');
        else if (turtle.getDirection() == 'S') turtle.setDirection('W');
        else if (turtle.getDirection() == 'W') turtle.setDirection('N');
    }
}
