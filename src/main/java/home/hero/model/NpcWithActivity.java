package home.hero.model;

public final class NpcWithActivity extends AbstractNonPlayCharapter {

    public static NpcWithActivity createNpc(NpcType type) {
        NpcWithActivity npc = new NpcWithActivity();
        npc.setType(type);
        npc.setName(npc.getType().toString());
        return npc;
    }
}
