package Main;

import CharacterClass.Archer;
import CharacterClass.Character;
import CharacterClass.Kngiht;
import CharacterClass.Samurai;
import LocationClass.BattleLocation.Cave;
import LocationClass.BattleLocation.Forest;
import LocationClass.BattleLocation.River;
import LocationClass.Location;
import LocationClass.NormalLocation.SafeHouse;
import LocationClass.NormalLocation.ToolStore;


import java.util.Objects;
import java.util.Scanner;

public class Player {

    private String name;
    private int damage, health, money, defaultHealth;
    private Inventory inventory;


    public Player() {

        this.selectChar();
        this.selectLocation();

    }

    public void selectChar() {
        this.inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        classList();
        System.out.println("Welcome to the game adventurer. Please enter your name: ");
        this.name = sc.nextLine();
        welcomeScreen();
        System.out.print("-->");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                this.setDamage(classList()[0].getDamage());
                this.setHealth(classList()[0].getHealth());
                this.setMoney(classList()[0].getMoney());
                this.setDefaultHealth(classList()[0].getHealth());
                break;
            case 2:
                this.setDamage(classList()[1].getDamage());
                this.setHealth(classList()[1].getHealth());
                this.setMoney(classList()[1].getMoney());
                this.setDefaultHealth(classList()[1].getHealth());
                break;
            case 3:
                this.setDamage(classList()[2].getDamage());
                this.setHealth(classList()[2].getHealth());
                this.setMoney(classList()[2].getMoney());
                this.setDefaultHealth(classList()[2].getHealth());
                break;
            default:
                System.out.println("Please enter valid number!");
        }

        printInfo();

    }


    public void selectLocation() {
        Scanner sc = new Scanner(System.in);
        Location location = null;
        boolean showLocationMenu = true;
        while (showLocationMenu) {
            System.out.println("Starting Zones:" + "\n" +
                    "0-Exit --> You can quit" + "\n" +
                    "1-Safe House --> You can rest here" + "\n" +
                    "2-ToolStore --> You can buy arsenal" + "\n" +
                    "3-Cave --> < Prize:Food >Enter the Cave , beware zombies roaming !" + "\n" +
                    "4-Forest --> < Prize:Wood > Enter the Forest , beware bears roaming !" + "\n" +
                    "5-River --> < Prize:Water > Enter the River , beware vampires roaming !");
            System.out.println("=======================================================================");
            System.out.print("-->");
            int choice = sc.nextInt();
            while (choice < 0 || choice > 5) {
                System.out.print("Please enter valid number! ");
                choice = sc.nextInt();
            }
            switch (choice) {
                case 0:
                    System.out.println("Hope to see you again soon adventurer. ");
                    location = null;
                    showLocationMenu = false;
                    break;
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new ToolStore(this);
                    break;
                case 3:
                    location = new Cave(this);
                    break;
                case 4:
                    location = new Forest(this);
                    break;
                case 5:
                    location = new River(this);
                    break;

            }


            if (location != null && !location.onLocation()) {
                System.out.println("Game Over !");
                break;
            }

            if (location.getClass().getName().equals("SafeHouse") && isPrize()) {
                System.out.println("You have fulfilled all the conditions and won the game!");
                break;
            }


        }

    }

    public void printInfo() {

        System.out.println("Player name: " + this.getName() + "\t" + "Player damage: " + this.getDamage() + "\t" +
                "Player health: " + this.getHealth() + "\t" +
                "Player money: " + this.getMoney() + "\t" +
                "Player armor set: " + this.getInventory().getArmorName() + "\t" +
                "Player weapon set: " + this.getInventory().getWeaponName());
    }

    public Character[] classList() {
        Character[] character = {new Samurai(), new Archer(), new Kngiht()};
        return character;
    }

    public void welcomeScreen() {
        classList();
        System.out.println("=======================================================================");
        System.out.println("Character classes stats:" + "\n" +
                "Samurai id: " + (classList()[0].getId() + "\t" +
                "Samurai damage: " + (classList()[0].getDamage() + "\t" +
                "Samurai health: " + (classList()[0].getHealth() + "\t" +
                "Samurai money: " + (classList()[0].getMoney() + "\n" +
                "Archer id: " + classList()[1].getId() + "\t" +
                "Archer damage: " + classList()[1].getDamage() + "\t" +
                "Archer health: " + classList()[1].getHealth() + "\t" +
                "Archer money: " + classList()[1].getMoney() + "\n" +
                "Knight id: " + classList()[2].getId() + "\t" +
                "Knight damage: " + classList()[2].getDamage() + "\t" +
                "Knight health: " + classList()[2].getHealth() + "\t" +
                "Knight money: " + classList()[2].getMoney())))));
        System.out.println("=======================================================================");
        System.out.println(" Please choose your character:" + "\n" +
                "1-Samurai" + "\n" +
                "2-Archer" + "\n" +
                "3-Knight");
        System.out.println("=======================================================================");

    }

    public boolean isPrize() {
        return this.getInventory().isWater() == true && this.getInventory().isFirewood() == true && this.getInventory().isFood() == true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
