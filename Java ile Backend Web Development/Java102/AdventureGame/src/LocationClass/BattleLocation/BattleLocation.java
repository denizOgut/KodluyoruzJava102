package LocationClass.BattleLocation;

import LocationClass.Location;
import Main.Player;
import MonsterClass.Monster;

public abstract class BattleLocation extends Location {
    private Monster monster;

    public BattleLocation(Player player, String name) {
        super(player, name);
    }

    public abstract void combat();
    public abstract boolean onLocation();
    public abstract String battleLoc(Monster monster);
}
