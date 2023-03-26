package home.hero;

import java.util.List;
import java.util.Scanner;

import home.hero.area.BattleArea;
import home.hero.area.Village;
import home.hero.model.Hero;
import home.hero.model.NpcWithActivity;

public final class WorldInitializer {

    private static final int DOKTOR = 1;
    private static final int BLACKSMITH = 2;
    private static final int MERCHANT = 3;
    private static final int SHOW_MAP = 4;

    public static void init(Scanner scanner, int tryCounter) {
        var village = Village.createVillage();
        List<NpcWithActivity> npcs = village.getNpc();

        choseWay(scanner, npcs, tryCounter);
    }

    public static void choseWay(Scanner scanner, List<NpcWithActivity> npcs,
            int tryCounter) {
        System.out.println("Press the number to choose the way:");
        for (int index = 0; index < npcs.size(); index++) {
            int number = index + 1;
            System.out.println(number + " " + npcs.get(index).getName());
        }
        System.out.println("4 Go to batle area");

        // TODO make logic like in Hero.chouseType
        switch (scanner.nextInt()) {
            case DOKTOR:
                // TODO add logic and remove this
                System.out.println("this NPC didn_t done");
                ++tryCounter;
                if (tryCounter < 3) {
                    init(scanner, tryCounter);
                }
                System.exit(1);
                break;

            case BLACKSMITH:
                // TODO add logic and remove this
                System.out.println("this NPC didn_t done");
                ++tryCounter;
                if (tryCounter < 3) {
                    init(scanner, tryCounter);
                }
                System.exit(1);
                break;

            case MERCHANT:
                // TODO add logic and remove this
                System.out.println("this NPC didn_t done");
                ++tryCounter;
                if (tryCounter < 3) {
                    init(scanner, tryCounter);
                }
                System.exit(1);
                break;

            case SHOW_MAP:
                WorldInitializer.movementMechanics(scanner, npcs, tryCounter);
                break;
        }
    }

    private static void movementMechanics(Scanner scanner,
            List<NpcWithActivity> npcs, int tryCounter) {
        while (true) {
            BattleArea.showMap();
            System.out.println(
                    "press 'w', 'a', 's', 'd' to move your hero or 'q' to go village:");
            Hero.move(scanner, npcs, tryCounter);
        }
    }
}
