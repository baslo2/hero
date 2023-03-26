package home.hero.model;

import home.hero.stuff.AbstractStuff;

public abstract class AbstractPersonage {

    private String name;

    private int level;
    private int lowestDamage;
    private int apperDamage;
    private int health;
    private int armor;
    private int mana;
    private int atackSpeed;

    private int gold;
    private AbstractStuff[] inventar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLowestDamage() {
        return lowestDamage;
    }

    public void setLowestDamage(int atackDamage) {
        this.lowestDamage = atackDamage;
    }

    public int getApperDamage() {
        return apperDamage;
    }

    public void setApperDamage(int apperDamage) {
        this.apperDamage = apperDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAtackSpeed() {
        return atackSpeed;
    }

    public void setAtackSpeed(int atackSpeed) {
        this.atackSpeed = atackSpeed;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public AbstractStuff[] getInventar() {
        return inventar;
    }

    public void setInventar(AbstractStuff[] inventar) {
        this.inventar = inventar;
    }

}
