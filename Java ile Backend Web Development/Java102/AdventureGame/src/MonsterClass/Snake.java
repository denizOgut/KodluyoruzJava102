package MonsterClass;

import ArsenalClass.ArmorClass.Armor;
import ArsenalClass.WeaponClass.Weapon;

import java.util.Random;

public class Snake extends Monster{
    private String prize;

    public String getPrize() {
        return prize;
    }

    public String setPrize() {
        double choice = Math.random();
        if (choice < 0.15) {
            this.prize = "Weapon";
        } else if (choice > 0.15 && choice < 0.30) {
            this.prize = "Armor";
        } else if (choice > 0.30 && choice < 0.55) {
            this.prize = "Money";
        } else {
            this.prize = "Nothing";

        }

        return this.prize;
    }

    public Snake() {
        super(4, new Random().nextInt(6) + 3, 12, 0);
        this.prize = setPrize();

    }
}
