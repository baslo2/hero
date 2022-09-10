package home.hero;

import java.util.Scanner;

public class Launcher {

    // for menu
    private static final int NEW_GAME = 1;
    private static final int LOAD_GAME = 2;
    private static final int EXIT = 3;

    private static int tryCounter = 0;

    public static void launch() {
        // TODO make scanner and tryCounter some like a singleton
        try (var scanner = new Scanner(System.in)) {
            openMenu(scanner, tryCounter);
            WorldInitializer.init(scanner, tryCounter);
        }
    }

    // TODO process incorrect menu values
    private static void openMenu(Scanner scanner, int tryCounter) {
        System.out.println("Chouse some one of:\n 1.New game\n 2.Load game\n 3.EXIT\n");
        switch (scanner.nextInt()) {
            case NEW_GAME:
                tryCounter = 0;
                HeroInitializer.init(scanner, tryCounter);
                break;
            case LOAD_GAME:
                // TODO add logic and remove this
                System.out.println("This is option don't work yet");
                ++tryCounter;
                if (tryCounter < 3) {
                    openMenu(scanner, tryCounter);
                }
                System.exit(1);
                break;
            case EXIT:
                System.exit(1);
                break;
        }
    }
}
