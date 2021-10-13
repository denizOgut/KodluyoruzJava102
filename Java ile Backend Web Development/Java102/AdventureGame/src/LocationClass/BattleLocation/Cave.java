package LocationClass.BattleLocation;

import Main.Player;
import MonsterClass.Monster;
import MonsterClass.Zombie;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Cave", new Zombie());
    }

    @Override
    public void combat() {

    }

    @Override
    public String battleLoc(Monster monster) {
        return null;
    }
}
