package home.hero.area;

import home.hero.model.Hero;

public final class BattleArea {

    private static final String BLANK_ZONE = "[ ]";
    private static final String PLAYER_MARK = "[H]";

    public static void showMap() {
        var map = new String[10][10];

        // fill map by blank zone
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = BLANK_ZONE;
            }
        }

        // put hero on start position
        map[Hero.getInstance().getX()][Hero.getInstance().getY()] = PLAYER_MARK;

        // print filled map
        for (String[] line : map) {
            System.out.println();
            for (String zone : line) {
                System.out.print(zone);
            }
        }
        System.out.println();
    }
}
