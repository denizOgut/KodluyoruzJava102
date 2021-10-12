package LocationClass.BattleLocation;

import Main.Player;
import MonsterClass.Monster;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Cave");
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
