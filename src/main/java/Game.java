import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    private Hero hero;
    private boolean end;

    public Game() {

        try {

            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);
            this.screen.startScreen();
            this.screen.doResizeIfNecessary();

            this.hero = new Hero(10, 10);
            this.end = false;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void draw() throws IOException {

        this.screen.clear();
        this.hero.draw(this.screen);
        this.screen.refresh();

    }

    private void moveHero(Position position) {
        hero.setPosition(position);
    }


    public void run() throws IOException {

        while (true) {
            this.draw();
            KeyStroke key = this.screen.readInput();
            if (key.getKeyType() == KeyType.EOF) {
                break;
            }
            this.processKey(key);
        }

    }

    private void processKey(KeyStroke key) throws IOException {

        // System.out.println(key);

        switch(key.getKeyType()) {

            case Character:
                if (key.getCharacter() == 'q') {
                    this.screen.close();
                }

                break;

            case ArrowUp:
                this.hero.setPosition(this.hero.moveUp());
                break;

            case ArrowDown:
                this.hero.setPosition(this.hero.moveDown());
                break;

            case ArrowLeft:
                this.hero.setPosition(this.hero.moveLeft());
                break;

            case ArrowRight:
                this.hero.setPosition(this.hero.moveRight());
                break;

            default:
                break;

        }

    }

}
