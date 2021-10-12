package LocationClass.BattleLocation;

import Main.Player;
import MonsterClass.Monster;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River");
    }

    @Override
    public void combat() {
    }

    @Override
    public boolean onLocation() {
        return false;
    }

    @Override
    public String battleLoc(Monster monster) {
        return null;
    }
}
