abstract class Weapon extends Item {
    private int damage;
    private int ammo;

    public Weapon(String itemName, String itemDescription, int damage) {
        super(itemName, itemDescription);
        this.damage = damage;
    }

    public int getAmmo() {
        return ammo;
    }

    public int getDamage() {
        return damage;
    }
}