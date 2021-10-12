package ArsenalClass.WeaponClass;

public abstract class Weapon {
    private int id,damage,money;

    public int getId() {
        return id;
    }

    public Weapon() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
