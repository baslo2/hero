package home.hero.model;

public enum HeroType {

    WARRIOR("Warrior", 1),
    ARCHER("Archer", 2),
    MAG("Mag", 3);

    private String type;
    private final int typeNumber;

    private HeroType(String type, int typeNumber) {
        this.type = type;
        this.typeNumber = typeNumber;
    }

    public String getType() {
        return type;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public static HeroType getHeroType(int typeNumber) {
        for (HeroType heroType : HeroType.values()) {
            if (typeNumber == heroType.getTypeNumber()) {
                return heroType;
            }
        }
        return null;
    }
}
