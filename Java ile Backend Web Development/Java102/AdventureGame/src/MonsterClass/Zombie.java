package MonsterClass;

import java.util.Random;

public class Zombie extends Monster{

    public Zombie() {
        super.setId(1);
        super.setDamage(3);
        super.setHealth(10);
        super.setMoney(4);
        super.setMonsterCount(new Random().nextInt(3) + 1);
    }
}
