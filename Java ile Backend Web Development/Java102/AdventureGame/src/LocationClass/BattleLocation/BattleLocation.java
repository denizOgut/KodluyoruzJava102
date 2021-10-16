package LocationClass.BattleLocation;

import ArsenalClass.ArmorClass.Armor;
import ArsenalClass.ArmorClass.HeavyArmor;
import ArsenalClass.ArmorClass.LightArmor;
import ArsenalClass.ArmorClass.MediumArmor;
import ArsenalClass.WeaponClass.Gun;
import ArsenalClass.WeaponClass.Rifle;
import ArsenalClass.WeaponClass.Sword;
import ArsenalClass.WeaponClass.Weapon;
import LocationClass.Location;
import Main.Player;
import MonsterClass.Monster;
import MonsterClass.Snake;


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
        if (this.getMonster().getClass().getName().equals(Snake.class.getName())) {
            this.monsterCount = new Random().nextInt(5) + 1;
        }

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
            printMonsterInfo(i);
            boolean flag = isRandomTurns();
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("Hit or Run " + "\n" +
                        "H --> Hit " + "\n" +
                        "R --> Run ");
                String userChoice = Location.sc.nextLine();

                if (userChoice.equalsIgnoreCase("H")) {
                    if (flag) {
                        System.out.println("You hit: ");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                        afterHit();
                    }
                    if (this.getMonster().getHealth() > 0) {
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmorDefence();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        System.out.println("Monster's turn: ");
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                    if (!flag) {
                        System.out.println("You hit: ");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Enemy was defeated!");
                if (!this.getMonster().getClass().getName().equals(Snake.class.getName())) {
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + monster.getMoney());
                    System.out.println("Current balance: " + this.getPlayer().getMoney());
                } else {
                    setMineZonePrize();
                }


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

    public void setMineZonePrize() {
        switch (this.monster.getPrize()) {
            case "Weapon":
                this.setWeaponPrize();
                break;
            case "Armor":
                this.setArmorPrize();
                break;
            case "Money":
                this.setMoneyPrize();
                break;
            case "Nothing":
                System.out.println("Unlucky , " + getPlayer().getName() + " got nothing!");
                break;
        }
    }

    private void setWeaponPrize() {
        Weapon weapon;
        Random random = new Random();
        double choice = random.nextDouble();
        if (choice < 0.5) {
            weapon = new Gun();
            System.out.println("You have won Gun !");
            if (this.getPlayer().getInventory().getWeaponName().equals("Fist")) {
                this.getPlayer().setDamage(this.getPlayer().getDamage() + weapon.getDamage());
                this.getPlayer().getInventory().setWeaponName(weapon.getClass().getSimpleName());
            } else {
                System.out.println("Your weapon stats is better than dropped loot");
            }
        } else if (choice > 0.5 && choice < 0.8) {
            weapon = new Sword();
            System.out.println("You have won Sword !");
            if (this.getPlayer().getInventory().getWeaponName().equals("Fist") || this.getPlayer().getInventory().getWeaponName().equals("Gun")) {
                if (this.getPlayer().getInventory().getWeaponName().equals("Fist")) {
                    this.getPlayer().setDamage(this.getPlayer().getDamage() + weapon.getDamage());
                }

                if (this.getPlayer().getInventory().getWeaponName().equals("Gun")) {
                    this.getPlayer().setDamage((this.getPlayer().getDamage() + weapon.getDamage()) - 1);
                }

                this.getPlayer().getInventory().setWeaponName(weapon.getClass().getSimpleName());

            } else if (this.getPlayer().getInventory().getWeaponName().equals("Sword")) {
                System.out.println("Your weapon stats equal to dropped loot");
            } else {
                System.out.println("Your weapon stats are better");
            }

        } else {
            weapon = new Rifle();
            System.out.println("You have won Rifle !");
            if (!this.getPlayer().getInventory().getWeaponName().equals("Rifle")) {
                if (this.getPlayer().getInventory().getWeaponName().equals("Fist")) {
                    this.getPlayer().setDamage(this.getPlayer().getDamage() + weapon.getDamage());
                } else if (this.getPlayer().getInventory().getWeaponName().equals("Gun")) {
                    this.getPlayer().setDamage((this.getPlayer().getDamage() + weapon.getDamage()) - 1);
                } else {
                    this.getPlayer().setDamage((this.getPlayer().getDamage() + weapon.getDamage()) - 3);
                }
                this.getPlayer().getInventory().setWeaponName(weapon.getClass().getSimpleName());
            } else {
                System.out.println("You have dropped the same weapon");
            }
        }
    }

    private void setArmorPrize() {
        Armor armor;
        Random random = new Random();
        double choice = random.nextDouble();
        if (choice < 0.5) {
            armor = new LightArmor();
            System.out.println("You have won LightArmor !");
            if (this.getPlayer().getInventory().getArmorName().equals("Robe")) {
                this.getPlayer().getInventory().setArmorDefence(armor.getBlock());
                this.getPlayer().getInventory().setArmorName(armor.getClass().getSimpleName());
            } else {
                System.out.println("Your Armor stats is better than dropped loot");
            }
        } else if (choice > 0.5 && choice < 0.8) {
            armor = new MediumArmor();
            System.out.println("You have won MediumArmor !");
            if (this.getPlayer().getInventory().getArmorName().equals("Robe") || this.getPlayer().getInventory().getArmorName().equals("LightArmor")) {
                if (this.getPlayer().getInventory().getWeaponName().equals("Robe")) {
                    this.getPlayer().getInventory().setArmorDefence(armor.getBlock());
                }

                if (this.getPlayer().getInventory().getArmorName().equals("LightArmor")) {
                    this.getPlayer().getInventory().setArmorDefence(armor.getBlock() - 1);
                }

                this.getPlayer().getInventory().setArmorName(armor.getClass().getSimpleName());

            } else if (this.getPlayer().getInventory().getArmorName().equals("MediumArmor")) {
                System.out.println("Your armor stats equal to dropped loot");
            } else {
                System.out.println("Your armor stats are better");
            }

        } else {
            armor = new HeavyArmor();
            System.out.println("You have won HeavyArmor !");
            if (!this.getPlayer().getInventory().getArmorName().equals("HeavyArmor")) {
                if (this.getPlayer().getInventory().getArmorName().equals("Robe")) {
                    this.getPlayer().getInventory().setArmorDefence(armor.getBlock());
                } else if (this.getPlayer().getInventory().getArmorName().equals("LightArmor")) {
                    this.getPlayer().getInventory().setArmorDefence(armor.getBlock() - 1);
                } else {
                    this.getPlayer().getInventory().setArmorDefence(armor.getBlock() - 3);
                }
                this.getPlayer().getInventory().setArmorName(armor.getClass().getSimpleName());
            } else {
                System.out.println("You have dropped the same armor set");
            }
        }
    }

    private void setMoneyPrize() {
        int balance = this.getPlayer().getMoney();
        Random random = new Random();
        double choice = random.nextDouble();
        if (choice < 0.2) {
            this.getPlayer().setMoney(balance + 10);
            System.out.println("Current balance: " + this.getPlayer().getMoney());
        } else if (choice > 0.2 && choice < 0.5) {
            this.getPlayer().setMoney(balance + 5);
            System.out.println("Current balance: " + this.getPlayer().getMoney());
        } else {
            this.getPlayer().setMoney(balance + 1);
            System.out.println("Current balance: " + this.getPlayer().getMoney());
        }
    }

    public boolean isRandomTurns() {
        Random r = new Random();
        return r.nextBoolean();
    }
}


