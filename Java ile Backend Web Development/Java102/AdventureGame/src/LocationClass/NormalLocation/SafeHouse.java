package LocationClass.NormalLocation;

import Main.Player;

public class SafeHouse extends NormalLocation {


    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in SafeHouse" + "\n" +
                "Your health is restored");
        return true;
    }
}
