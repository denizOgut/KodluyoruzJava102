package LocationClass.BattleLocation;

import Main.Player;
import MonsterClass.Monster;
import MonsterClass.Vampire;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(),"Wood");
    }


}
