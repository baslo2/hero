package home.hero.model;

import java.util.Scanner;
import java.util.function.Consumer;

import home.hero.area.BattleArea;

public final class Hero extends AbstractPersonage {

    // TODO replace by some util class
    // buttoms for move
    private static final String MOVE_UP = "w";
    private static final String MOVE_DOWN = "s";
    private static final String MOVE_LEFT = "a";
    private static final String MOVE_RIGHT = "d";

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

    public static void move(Scanner scanner) {
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
            default: {
                throw new IllegalArgumentException("Unexpected value: " + scanner.next());
            }
        }

        int x = hero.getX();
        int y = hero.getY();
        if (x < 0) {
            processBorderCrossing("UP", hero::setX, 0, scanner);
        } else if (x > 9) {
            processBorderCrossing("DOWN", hero::setX, 9, scanner);
        } else if (y < 0) {
            processBorderCrossing("LEFT", hero::setY, 0, scanner);
        } else if (y > 9) {
            processBorderCrossing("RIGHT", hero::setY, 9, scanner);
        }
    }

    private static void processBorderCrossing(String side, Consumer<Integer> setter, int number, Scanner scanner) {
        System.out.println("you can't move %s, please move another side.".formatted(side));
        setter.accept(number);
        BattleArea.showMap();
        System.out.println("press 'w', 'a', 's', 'd' to move your hero:");
        Hero.move(scanner);
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
