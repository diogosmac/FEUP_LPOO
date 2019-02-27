import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    private boolean end;
    private Arena arena;

    public Game() {

        try {

            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);
            this.screen.startScreen();
            this.screen.doResizeIfNecessary();
            this.arena = new Arena();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void draw() throws IOException {

        this.screen.clear();
        this.arena.draw(screen.newTextGraphics());
        this.screen.refresh();

    }

    private void processKey(KeyStroke key) throws IOException {
        arena.processKey(key);
    }

    public void run() throws IOException {

        while (true) {
            this.draw();
            KeyStroke key = this.screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                this.screen.close();
            }
            if (key.getKeyType() == KeyType.EOF) {
                break;
            }
            this.processKey(key);
        }

    }

}
