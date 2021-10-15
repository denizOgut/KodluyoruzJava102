package LocationClass.BattleLocation;

import Main.Player;
import MonsterClass.Monster;
import MonsterClass.Zombie;

public class Cave extends BattleLocation{

    public Cave(Player player) {
        super(player, "Cave", new Zombie(),"Food");
    }


}
