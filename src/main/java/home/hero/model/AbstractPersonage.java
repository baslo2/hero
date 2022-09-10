package home.hero.model;

public abstract class AbstractPersonage {

    private String name;
    private String type;
    private int level;
    private int atackDamage;
    private int health;
    private int atackSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAtackDamage() {
        return atackDamage;
    }

    public void setAtackDamage(int atackDamage) {
        this.atackDamage = atackDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAtackSpeed() {
        return atackSpeed;
    }

    public void setAtackSpeed(int atackSpeed) {
        this.atackSpeed = atackSpeed;
    }
}
