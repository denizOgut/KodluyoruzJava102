package MonsterClass;

import java.util.Random;

public class Vampire extends Monster {

    public Vampire() {
        super.setId(2);
        super.setDamage(4);
        super.setHealth(14);
        super.setMoney(7);
        super.setMonsterCount(new Random().nextInt(3) + 1);
    }

}
