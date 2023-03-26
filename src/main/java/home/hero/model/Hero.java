package home.hero.model;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import home.hero.WorldInitializer;
import home.hero.area.BattleArea;
import home.hero.stuff.AbstractStuff;

public final class Hero extends AbstractPersonage {

    // TODO replace by some util class
    // buttoms for move
    private static final String MOVE_UP = "w";
    private static final String MOVE_DOWN = "s";
    private static final String MOVE_LEFT = "a";
    private static final String MOVE_RIGHT = "d";
    private static final String QUIT = "q";

    // where is stay hero in BattleArea(start position x=9;y=0)
    private int x = 9;
    private int y = 0;

    private int exp;
    private HeroType heroType;

    private static Hero instance;

    private Hero() {
    }

    public static Hero getInstance() {
        if (instance == null) {
            instance = new Hero();
        }
        return instance;
    }

    public void addStuff(AbstractStuff someStuff) {
        if (super.getInventar().length != 0) {
            super.setInventar(new AbstractStuff[10]);
        }

        int inventaryPlace = 0;
        for (var place : super.getInventar()) {
            if (place != null) {
                inventaryPlace++;
                continue;
            }
            super.getInventar()[inventaryPlace] = someStuff;
        }
    }

    // TODO make interactive
    public void showInventar() {
        int inventaryPlace = 1;
        for (var stuf : super.getInventar()) {
            System.out.println(inventaryPlace + ")" + stuf.getName() + ";");
        }
    }

    // TODO think to do somethink with npcs and tryCounter
    public static void move(Scanner scanner, List<NpcWithActivity> npcs,
            int tryCounter) {
        String move = scanner.next();
        Hero hero = getInstance();
        switch (move) {
            case Hero.MOVE_UP: {
                hero.setX(hero.getX() - 1);
                break;
            }
            case Hero.MOVE_DOWN: {
                hero.setX(hero.getX() + 1);
                break;
            }
            case Hero.MOVE_LEFT: {
                hero.setY(hero.getY() - 1);
                break;
            }
            case Hero.MOVE_RIGHT: {
                hero.setY(hero.getY() + 1);
                break;
            }
            case Hero.QUIT: {
                WorldInitializer.choseWay(scanner, npcs, tryCounter);
                break;
            }
            default: {
                throw new IllegalArgumentException(
                        "Unexpected value: " + scanner.next());
            }
        }

        int x = hero.getX();
        int y = hero.getY();
        if (x < 0) {
            processBorderCrossing("UP", hero::setX, 0, scanner, npcs,
                    tryCounter);
        } else if (x > 9) {
            processBorderCrossing("DOWN", hero::setX, 9, scanner, npcs,
                    tryCounter);
        } else if (y < 0) {
            processBorderCrossing("LEFT", hero::setY, 0, scanner, npcs,
                    tryCounter);
        } else if (y > 9) {
            processBorderCrossing("RIGHT", hero::setY, 9, scanner, npcs,
                    tryCounter);
        }
    }

    private static void processBorderCrossing(String side,
            Consumer<Integer> setter, int number, Scanner scanner,
            List<NpcWithActivity> npcs, int tryCount) {
        System.out.println(
                "you can't move %s, please move another side.".formatted(side));
        setter.accept(number);
        BattleArea.showMap();
        System.out.println("press 'w', 'a', 's', 'd' to move your hero:");
        Hero.move(scanner, npcs, tryCount);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public HeroType getCharapterType() {
        return heroType;
    }

    public void setCharapterType(HeroType heroType) {
        this.heroType = heroType;
    }
}
