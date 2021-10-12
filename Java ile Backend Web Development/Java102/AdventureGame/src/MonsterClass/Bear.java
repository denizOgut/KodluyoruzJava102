package MonsterClass;

import java.util.Random;

public class Bear extends Monster{
    public Bear() {
        super.setId(3);
        super.setDamage(7);
        super.setHealth(20);
        super.setMoney(12);
        super.setMonsterCount(new Random().nextInt(3) + 1);

    }
}
