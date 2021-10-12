package LocationClass.NormalLocation;

import ArsenalClass.ArmorClass.Armor;
import ArsenalClass.ArmorClass.HeavyArmor;
import ArsenalClass.ArmorClass.LightArmor;
import ArsenalClass.ArmorClass.MediumArmor;
import ArsenalClass.WeaponClass.Gun;
import ArsenalClass.WeaponClass.Rifle;
import ArsenalClass.WeaponClass.Sword;
import ArsenalClass.WeaponClass.Weapon;
import LocationClass.Location;
import Main.Inventory;
import Main.Player;


public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println(" Welcome to the ToolStore ");
        System.out.println(" 1-Weapons " + "\n" +
                " 2-Armors " + "\n" +
                " 3-Exit ");
        System.out.print("-->");
        int choice = Location.sc.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Please enter valid option");
            choice = Location.sc.nextInt();
        }
        switch (choice) {
            case 1:
                printWeapons();
                break;
            case 2:
                printArmors();
                break;
            case 3:
                System.out.println(" Hope to see you again soon adventurer ");

        }
        return true;
    }

    public void printArmors() {
        Armor[] armors = {new LightArmor(), new MediumArmor(), new HeavyArmor()};
        System.out.println("Armor classes shop:" + "\n" +
                "Light Armor block:  " + (armors[0].getBlock() + "\t" +
                "Light Armor money:  " + (armors[0].getMoney() + "\n" +
                "Medium Armor block: " + armors[1].getBlock() + "\t" +
                "Medium Armor money: " + armors[1].getMoney() + "\n" +
                "Heavy Armor block:  " + armors[2].getBlock() + "\t" +
                "Heavy Armor money:  " + armors[2].getMoney())));
        System.out.println("#################################################### ");
        System.out.println("Please choose the armor you want to buy" +"\n" +
                " 1-Light Armor  " +"\n" +
                " 2-Medium Armor "+"\n" +
                " 3-Heavy Armor  ");
        int armorChoice = Location.sc.nextInt();
        while (armorChoice < 1 || armorChoice > armors.length){
            System.out.println("Please enter valid number!");
            armorChoice = Location.sc.nextInt();
        }

        buyArmors(armors,armorChoice);
    }


    public void printWeapons() {
        Weapon[] weapons = {new Gun(), new Sword(), new Rifle()};
        System.out.println("Weapon classes shop:" + "\n" +
                "Gun damage: " + (weapons[0].getDamage() + "\t" +
                "Gun money: " + (weapons[0].getMoney() + "\n" +
                "Sword damage: " + weapons[1].getDamage() + "\t" +
                "Sword money: " + weapons[1].getMoney() + "\n" +
                "Rifle damage: " + weapons[2].getDamage() + "\t" +
                "Rifle money: " + weapons[2].getMoney())));
        System.out.println("#################################################### ");
        System.out.println("Please choose the weapon you want to buy" +"\n" +
                " 1-Gun   " +"\n" +
                " 2-Sword "+"\n" +
                " 3-Rifle ");
       int weaponChoice = Location.sc.nextInt();
       while (weaponChoice < 1 || weaponChoice > weapons.length){
           System.out.println("Please enter valid number!");
           weaponChoice = Location.sc.nextInt();
       }

       buyWeapons(weapons,weaponChoice);

    }
    public void buyWeapons(Weapon[] weapons, int weaponChoice){
        Inventory  ınventory = new Inventory();
        if (weapons[weaponChoice-1].getMoney() > getPlayer().getMoney()){
            System.out.println("You don't have enough money");
        }else{
            ınventory.setWeaponDamage(weapons[weaponChoice-1].getDamage());
            ınventory.setWeaponName(weapons[weaponChoice-1].getClass().getSimpleName());
            this.getPlayer().setMoney(getPlayer().getMoney()-weapons[weaponChoice-1].getMoney());
            this.getPlayer().setDamage(this.getPlayer().getDamage() + ınventory.getWeaponDamage());
            System.out.println("Remaining money: " + getPlayer().getMoney() + "\n" +
                    "Your new weapon set: " + ınventory.getWeaponName());



        }

    }


    public void buyArmors(Armor [] armors, int armorChoice){
        Inventory  ınventory = new Inventory();
        if (armors[armorChoice-1].getMoney() > getPlayer().getMoney()){
            System.out.println("You don't have enough money");
        }else{
            ınventory.setArmorDefence(armors[armorChoice-1].getBlock());
            ınventory.setArmorName(armors[armorChoice-1].getClass().getSimpleName());
            this.getPlayer().setMoney(getPlayer().getMoney()-armors[armorChoice-1].getMoney());
            this.getPlayer().setHealth(this.getPlayer().getHealth() + ınventory.getArmorDefence());
            System.out.println("Remaining money: " + getPlayer().getMoney() + "\n" +
                    "Your new armor set: " + getPlayer().getInventory().getArmorName());

            getPlayer().setHealth(getPlayer().getInventory().getArmorDefence());

        }

    }

}

