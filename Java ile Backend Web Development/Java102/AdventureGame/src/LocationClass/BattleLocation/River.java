package LocationClass.BattleLocation;

import Main.Player;
import MonsterClass.Bear;
import MonsterClass.Monster;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear());
    }

    @Override
    public void combat() {
    }

    @Override
    public String battleLoc(Monster monster) {
        return null;
    }
}
