package MonsterClass;

public abstract class Monster {
    private int ıd, damage, health, money,defaultHealth;
    private String prize;

    public Monster(int ıd, int damage, int health, int money) {
        this.ıd = ıd;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.defaultHealth = health;
        this.prize = "";
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getId() {
        return ıd;
    }

    public void setId(int ıd) {
        this.ıd = ıd;
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

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.health < 0){
            this.health = 0;
        }

    }

    public int getMoney() {
        return money;
    }



    public void setMoney(int money) {
        this.money = money;
    }
}