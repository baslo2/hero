package home.hero.area;

import java.util.ArrayList;
import java.util.List;

import home.hero.model.NpcType;
import home.hero.model.NpcWithActivity;

// TODO make a singletone
public final class Village {

    private List<NpcWithActivity> Npc;

    public List<NpcWithActivity> getNpc() {
        return Npc;
    }

    public void setNpc(List<NpcWithActivity> Npc) {
        this.Npc = Npc;
    }

    public static Village createVillage() {
        var village = new Village();

        var npcList = new ArrayList<NpcWithActivity>();
        var doctor = NpcWithActivity.createNpc(NpcType.DOKTOR);
        var blacksmith = NpcWithActivity.createNpc(NpcType.BLACKSMITH);
        var merchant = NpcWithActivity.createNpc(NpcType.MERCHANT);
        npcList.add(doctor);
        npcList.add(blacksmith);
        npcList.add(merchant);

        village.setNpc(npcList);

        return village;
    }
}
