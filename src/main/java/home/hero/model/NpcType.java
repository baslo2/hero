package home.hero.model;

public enum NpcType {

    DOKTOR("doktor"),
    BLACKSMITH("blacksmoth"),
    MERCHANT("merchant");

    private String type;

    private NpcType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
