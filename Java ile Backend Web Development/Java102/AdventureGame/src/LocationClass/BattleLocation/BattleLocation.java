package LocationClass.BattleLocation;

import LocationClass.Location;
import Main.Player;
import MonsterClass.Monster;

import java.util.Random;


public abstract class BattleLocation extends Location {
    private Monster monster;
    private int monsterCount;

    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public BattleLocation(Player player, String name, Monster monster) {
        super(player, name);
        this.monster = monster;
        this.monsterCount = new Random().nextInt(3) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void combat() {

    }

    public boolean onLocation() {
        System.out.println("You are here now: " + this.getName() + "\n" +
                "Beware here lives " + this.getMonsterCount() + " " + this.getMonster().getClass().getSimpleName() + "s");
        System.out.println("Battle or Run " + "\n" +
                "B --> Battle " + "\n" +
                "R --> Run ");
        String userChoice = Location.sc.nextLine();
        switch (userChoice.toUpperCase()){
            case "B":
                System.out.println("You have chosen battle" + this.getPlayer().getName());
                combat();
                break;
            case "R":
                System.out.println("You have chosen run" + this.getPlayer().getName());
                break;
            default:
                System.out.println("Please enter valid choice");
        }

        return true;
    }

    public abstract String battleLoc(Monster monster);
}
