import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    public boolean end;

    public Arena() {
        this(80, 24);
    }

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
        this.end = false;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            Coin coin = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            boolean check = true;
            for (Coin c : coins) {
                if (c.getPosition().equals(coin.getPosition())) {
                    check = false;
                    break;
                }
            }
            if (hero.getPosition().equals(coin.getPosition())) {
                check = false;
            }
            if (check) {
                coins.add(coin);
            }
            else {
                i--;
            }

        }

        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Monster monster = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            boolean check = true;
            for (Monster m : monsters) {
                if (m.getPosition().equals(monster.getPosition())) {
                    check = false;
                    break;
                }
            }
            if (hero.getPosition().equals(monster.getPosition())) {
                check = false;
            }
            if (check) {
                monsters.add(monster);
            }
            else {
                i--;
            }

        }

        return monsters;
    }

    private boolean canElementMove(Position position) {
        if (position.getX() < 1 || position.getX() > width - 2) {
            return false;
        }
        if (position.getY() < 1 || position.getY() > height - 2) {
            return false;
        }

        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }

        return true;
    }

    private void moveHero(Position position) {
        if (canElementMove(position)) {
            hero.setPosition(position);
        }
        retrieveCoins();
    }

    private void moveMonsters() {
        Random random = new Random();
        for (Monster m : monsters) {
            int dir = random.nextInt(4) + 1;
            switch(dir) {
                case 1:
                    if (canElementMove(m.moveUp()))
                        m.setPosition(m.moveUp());
                    break;

                case 2:
                    if (canElementMove(m.moveDown()))
                        m.setPosition(m.moveDown());
                    break;

                case 3:
                    if (canElementMove(m.moveLeft()))
                        m.setPosition(m.moveLeft());
                    break;

                case 4:
                    if (canElementMove(m.moveRight()))
                        m.setPosition(m.moveRight());
                    break;

                default: break;
            }
        }
    }

    private boolean verifyMonsterCollisions() {
        for (Monster monster : monsters) {
            if (hero.getPosition().equals(monster.getPosition())) {
                return true;
            }
        }
        return false;
    }

    private void retrieveCoins() {
        for (Coin coin : coins) {
            if (hero.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }

    public void processKey(KeyStroke key) throws IOException {

        // System.out.println(key);

        moveMonsters();

        if (verifyMonsterCollisions()) {
            end = true;
            System.out.println("You are dead. Thanks Obama.");
        }

        switch(key.getKeyType()) {

            case Character:
                if (key.getCharacter() == 'q') {
                    end = true;
                }
                break;

            case ArrowUp:
                moveHero(hero.moveUp());
                break;

            case ArrowDown:
                moveHero(hero.moveDown());
                break;

            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;

            case ArrowRight:
                moveHero(hero.moveRight());
                break;

            default:
                break;

        }

        if (verifyMonsterCollisions()) {
            end = true;
            System.out.println("You are dead. Thanks Obama.");
        }


    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        // graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');

        for (Coin coin : coins) {
            coin.draw(graphics);
        }

        this.hero.draw(graphics);

        for (Monster monster : monsters) {
            monster.draw(graphics);
        }

        for (Wall wall : walls) {
            wall.draw(graphics);
        }
    }

}
