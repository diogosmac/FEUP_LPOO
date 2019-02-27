import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position;

    public Hero() {
        this(10, 10);
    }

    public Hero(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position moveUp() {
        return new Position(this.position.getX(), this.position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(this.position.getX(), this.position.getY() + 1);
    }

    public Position moveLeft() {
        return new Position(this.position.getX() - 1, this.position.getY());
    }

    public Position moveRight() {
        return new Position(this.position.getX() + 1, this.position.getY());
    }

    public void draw(Screen screen) {
        screen.setCharacter(this.position.getX(), this.position.getY(), new TextCharacter('X'));
    }
}
