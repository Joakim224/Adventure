public class Weapon extends Item {
    private int damage;

    public Weapon(String itemName, String itemDescription, int damage){
        super(itemName, itemDescription);
        this.damage = damage;
    }
}
