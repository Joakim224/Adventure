public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;
    private Room room;

    public Enemy(String name, String description, int health, Weapon weapon, Room room){
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
        this.room = room;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getHealth(){
        return health;
    }
    public Weapon getWeapon(){
        return weapon;
    }

    public boolean EnemyDead() {
        if (health < 1) {
            room.removeEnemy(name);
            room.addItem(weapon);
            return true;
        } else {
            return false;
        }
    }
}
