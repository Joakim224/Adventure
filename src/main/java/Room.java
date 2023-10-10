import java.util.ArrayList;

public class Room {
    private Room east;
    private Room south;
    private Room north;
    private Room west;
    private String description;
    private String name;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public Room(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public Room getWest() {
        return west;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getNorth() {
        return north;
    }


    public void setWest(Room west) {
        this.west = west;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void createItem(String name, String description) {
        items.add(new Item(name, description));
    }

    public void createFood(String name, String description, int healPoints) {
        items.add(new Food(name, description, healPoints));
    }

    public void createMeleeWeapon(String name, String description, int damage) {
        items.add(new MeleeWeapon(name, description, damage));
    }

    public void createRangedWeapon(String name, String description, int damage, int ammo) {
        items.add(new RangedWeapon(name, description, damage, ammo));
    }

    public void createEnemy(String name, String description, int health, Weapon weapon, Room room) {
        enemies.add(new Enemy(name, description, health, weapon, room));
    }

    public String getItems() {
        return "In the room you see... " + items.toString() + " ";
    }

    public Item removeItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equals(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Enemy removeEnemy(String enemyName) {
        for (Enemy enemy : enemies) {
            if (enemy.getEnemyName().equals(enemyName)) {
                enemies.remove(enemy);
                return enemy;
            }
        }
        return null;
    }

    public Enemy searchEnemies(String name) {
        for (Enemy enemy : enemies) {
            if (enemy.getEnemyName().equalsIgnoreCase(name)) {
                return enemy;
            } else {
                System.out.println("There is no enemy in the room with that name.");
            }
        }
        return null;
    }
}