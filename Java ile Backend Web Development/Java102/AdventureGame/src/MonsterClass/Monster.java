package MonsterClass;

public abstract class Monster {
    private int ıd, damage, health, money,defaultHealth;

    public Monster(int ıd, int damage, int health, int money) {
        this.ıd = ıd;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.defaultHealth = health;
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

    public void setHealth(int health) {
        if (this.health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }



    public void setMoney(int money) {
        this.money = money;
    }
}