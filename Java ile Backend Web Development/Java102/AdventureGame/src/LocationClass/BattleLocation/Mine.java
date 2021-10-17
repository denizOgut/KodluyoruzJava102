package LocationClass.BattleLocation;

import Main.Player;
import MonsterClass.Monster;
import MonsterClass.Snake;

public class Mine extends BattleLocation{
    public Mine(Player player) {
        super(player, "Mine", new Snake(), new Snake().getPrize());
    }
}
