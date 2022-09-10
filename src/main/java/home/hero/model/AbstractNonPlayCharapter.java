package home.hero.model;

public abstract class AbstractNonPlayCharapter {

    private String name;
    private NpcType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NpcType getType() {
        return type;
    }

    public void setType(NpcType type) {
        this.type = type;
    }
}
