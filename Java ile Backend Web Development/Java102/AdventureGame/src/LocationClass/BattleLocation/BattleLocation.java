package LocationClass.BattleLocation;

import LocationClass.Location;
import Main.Player;
import MonsterClass.Monster;

import java.util.Random;


public abstract class BattleLocation extends Location {
    private Monster monster;
    private int monsterCount;
    private String prize;

    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public BattleLocation(Player player, String name, Monster monster, String prize) {
        super(player, name);
        this.monster = monster;
        this.monsterCount = new Random().nextInt(3) + 1;
        this.prize = prize;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public boolean combat(int monsterCount) {

        for (int i = 1; i <= this.getMonsterCount(); i++) {
            this.getMonster().setHealth(getMonster().getDefaultHealth());
            this.getPlayer().printInfo();
            System.out.println("-----------------------------------");
            printMonsterInfo(i);

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("Hit or Run " + "\n" +
                        "H --> Hit " + "\n" +
                        "R --> Run ");
                String userChoice = Location.sc.nextLine();

                if (userChoice.equalsIgnoreCase("H")) {
                    System.out.println("You hit first:");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmorDefence();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        System.out.println("Monster's turn: ");
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Enemy was defeated!");

                this.getPlayer().setMoney(this.getPlayer().getMoney() + monster.getMoney());
                System.out.println("Current balance: " + this.getPlayer().getMoney());

            } else {
                return false;
            }
            System.out.println("-------------------");
        }

        return true;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public void printMonsterInfo(int i) {
        System.out.println(i + ". " + "Monster:" + this.getMonster().getClass().getSimpleName() + "\t" +
                "Monster's health: " + this.getMonster().getHealth() + "\t" +
                "Monster's damage: " + this.getMonster().getDamage());
    }

    public void afterHit() {
        System.out.println("Remaining health: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getClass().getSimpleName() + " health: " + this.getMonster().getHealth());
    }

    public void winPrize() {
        if (this.getPrize().equals("Food") && !this.getPlayer().getInventory().isFood()) {
            System.out.println("You have won the prize: " + this.getPrize());
            this.getPlayer().getInventory().setFood(true);
        } else if (this.getPrize().equals("Wood") && !this.getPlayer().getInventory().isFirewood()) {
            System.out.println("You have won the prize: " + this.getPrize());
            this.getPlayer().getInventory().setFirewood(true);
        } else if (this.getPrize().equals("Water") && !this.getPlayer().getInventory().isWater()) {
            System.out.println("You have won the prize: " + this.getPrize());
            this.getPlayer().getInventory().setWater(true);
        }
    }


    public boolean onLocation() {
        System.out.println("You are here now: " + this.getName() + "\n" +
                "Beware here lives " + this.getMonsterCount() + " " + this.getMonster().getClass().getSimpleName() + "s");
        System.out.println("Battle or Run " + "\n" +
                "B --> Battle " + "\n" +
                "R --> Run ");
        String userChoice = Location.sc.nextLine();
        switch (userChoice.toUpperCase()) {
            case "B":
                System.out.println("You have chosen battle " + this.getPlayer().getName());
                if (combat(this.getMonsterCount())) {
                    System.out.println(this.getPlayer().getName() + " killed all monsters in " + this.getName());
                    winPrize();
                    return true;
                }
                if (this.getPlayer().getHealth() <= 0) {
                    System.out.println("You are dead !");
                    return false;
                }
                break;
            case "R":
                System.out.println("You have chosen run " + this.getPlayer().getName());
                break;
        }

        return true;
    }
}

