package home.hero;

import java.util.Scanner;

import home.hero.model.Hero;
import home.hero.model.HeroType;

public final class HeroInitializer {

    private static final int START_LEVEL = 1;
    private static final int START_EXP = 0;
    private static final int START_ATTACK_DAMAGE = 5;
    private static final int START_HEALTH = 80;
    private static final int START_ATTACK_SPEED = 30;

    public static void init(Scanner scanner, int tryCounter) {
        tryCounter = 0;
        Hero.getInstance();
        fillUpHero(scanner, tryCounter);
    }

    private static void fillUpHero(Scanner scanner, int tryCounter) {
        giveName(scanner, tryCounter);
        chouseType(scanner, tryCounter);
        Hero hero = Hero.getInstance();
        hero.setLevel(START_LEVEL);
        hero.setExp(START_EXP);
        hero.setAtackDamage(START_ATTACK_DAMAGE);
        hero.setHealth(START_HEALTH);
        hero.setAtackSpeed(START_ATTACK_SPEED);
        tryCounter = 0;
    }

    private static void giveName(Scanner scanner, int tryCounter) {
        System.out.println("What is your name?");
        var name = scanner.next();
        if (name.isBlank() && name.length() < 3) {
            ++tryCounter;
            System.out.println("You write incorect name, please try again");
            if (tryCounter > 2) {
                System.exit(1);
            }
            giveName(scanner, tryCounter);
        }
        tryCounter = 0;
        Hero hero = Hero.getInstance();
        hero.setName(name);
    }

    private static void chouseType(Scanner scanner, int tryCounter) {
        System.out.println("Chouse your type, if you wont chouse:\n" + HeroType.WARRIOR.getType() + " pres "
                + HeroType.WARRIOR.getTypeNumber() + "\n" + HeroType.ARCHER.getType() + " press "
                + HeroType.ARCHER.getTypeNumber() + "\n" + HeroType.MAG.getType() + " press "
                + HeroType.MAG.getTypeNumber());

        int typeNumber = scanner.nextInt();
        HeroType type = HeroType.getHeroType(typeNumber);

        if (type == null) {
            while (tryCounter < 3) {
                System.out.println("You press wrong number: " + typeNumber + "\nPlyase try againe. You have try: "
                        + (3 - tryCounter));
                System.out.println();
                ++tryCounter;
                chouseType(scanner, tryCounter);
            }
            System.out.println("Ok i understood you. Good bye, and good luck!");
            System.exit(1);
        }
        Hero hero = Hero.getInstance();
        hero.setCharapterType(type);
    }

    private HeroInitializer() {
    }
}
