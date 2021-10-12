package LocationClass.BattleLocation;

import Main.Player;
import MonsterClass.Monster;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Forest");
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
