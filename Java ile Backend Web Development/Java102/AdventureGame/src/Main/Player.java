package Main;

import CharacterClass.Archer;
import CharacterClass.Character;
import CharacterClass.Kngiht;
import CharacterClass.Samurai;
import LocationClass.Location;
import LocationClass.NormalLocation.SafeHouse;
import LocationClass.NormalLocation.ToolStore;


import java.util.Scanner;

public class Player {

    private String name;
    private int damage, health, money;
    private Inventory inventory;



    public Player() {

        this.selectChar();
        this.selectLocation();
        this.inventory = new Inventory();

    }

    public void selectChar() {
        Scanner sc = new Scanner(System.in);
        Character[] character = {new Samurai(), new Archer(), new Kngiht()};
        System.out.println("Welcome to the game adventurer. Please enter your name: ");
        this.name = sc.nextLine();

        System.out.println("=======================================================================");

        System.out.println("Character classes stats:" + "\n" +
                "Samurai id: " + (character[0].getId() + "\t" +
                "Samurai damage: " + (character[0].getDamage() + "\t" +
                "Samurai health: " + (character[0].getHealth() + "\t" +
                "Samurai money: " + (character[0].getMoney() + "\n" +
                "Archer id: " + character[1].getId() + "\t" +
                "Archer damage: " + character[1].getDamage() + "\t" +
                "Archer health: " + character[1].getHealth() + "\t" +
                "Archer money: " + character[1].getMoney() + "\n" +
                "Knight id: " + character[2].getId() + "\t" +
                "Knight damage: " + character[2].getDamage() + "\t" +
                "Knight health: " + character[2].getHealth() + "\t" +
                "Knight money: " + character[2].getMoney())))));
        System.out.println("=======================================================================");
        System.out.println(" Please choose your character:" + "\n" +
                "1-Samurai" + "\n" +
                "2-Archer" + "\n" +
                "3-Knight");
        System.out.println("=======================================================================");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                this.setDamage(character[0].getDamage());
                this.setHealth(character[0].getHealth());
                this.setMoney(character[0].getMoney());
                break;
            case 2:
                this.setDamage(character[1].getDamage());
                this.setHealth(character[1].getHealth());
                this.setMoney(character[1].getMoney());
                break;
            case 3:
                this.setDamage(character[2].getDamage());
                this.setHealth(character[2].getHealth());
                this.setMoney(character[2].getMoney());
                break;
            default:
                System.out.println("Please enter valid number!");
        }

        printInfo();

    }


    public void selectLocation(){
        Scanner sc = new Scanner(System.in);
         Location location = null;
        // while (true) {
             System.out.println("Starting Zones:" + "\n" +
                     "1-Safe House --> You can rest here" + "\n" +
                     "2-ToolStore --> You can buy arsenal");
             System.out.println("=======================================================================");
             int choice = sc.nextInt();
             switch (choice) {
                 case 1:
                     location = new SafeHouse(this);

                     break;
                 case 2:
                     location = new ToolStore(this);

                     break;
                 default:
                     System.out.println("Please enter valid number!");
                     break;
             }

             if (!location.onLocation()){
                System.out.println("You are dead");
                //break;
            }
         //}

    }

    public void printInfo(){
        System.out.println("Player name: " + this.getName() + "\t" + "Player damage: " + this.getDamage() + "\t" +
                "Player health: " + this.getHealth() + "\t" +
                "Player money: " + this.getMoney());
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
