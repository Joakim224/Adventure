import java.util.ArrayList;

public class Player {
    private int health;
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private Weapon currentWeapon;
    private boolean hasKey;

    public Player(int health) {
        this.health = health;
        this.inventory = new ArrayList<>();
        this.hasKey = false;
    }

    public int getHealth() {
        return health;
    }

    public void setPlayerHealth(int health) {
        this.health = health;
    }

    public void takeKey() {
        hasKey = true;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


    public boolean goSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return true;
        } else {
            System.out.println("The path is blocked!");
            return false;
        }
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        } else {
            System.out.println("The path is blocked!");
            return false;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return true;
        } else {
            System.out.println("The path is blocked!");
            return false;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            return true;
        } else {
            System.out.println("The path is blocked!");
            return false;
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public Item searchInventory(String name) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }


    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty...");
        } else {
            for (Item item : inventory)
                System.out.println(item);
        }
    }

    public Item takeItem(String itemName) {
        Item takenItem = getCurrentRoom().removeItem(itemName);

        if (takenItem != null) {
            addItem(takenItem);
        }
        return takenItem;
    }

    public Item dropItem(String itemName) {
        Item droppedItem;
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                droppedItem = item;
                removeItem(droppedItem);
                currentRoom.addItem(item);
                return droppedItem;

            }
        }
        return null;
    }

    public ReturnMessage eatFood(String itemName) {
        Item item = searchInventory(itemName);
        if (item instanceof Food) {
            removeItem(item);
            health += ((Food) item).getHealpoints();
            if (health > 100) {
                setPlayerHealth(100);
            }
            if (health < 0) {
                System.out.println("You died.");
                System.exit(0);
            }
            return ReturnMessage.OK;
        } else {
            if (item == null) {
                return ReturnMessage.NOT_FOUND;
            }
        }
        return ReturnMessage.CANT;
    }

    public ReturnMessage equipWeapon(String itemName) {
        Item equippedItem = searchInventory(itemName);
        if (equippedItem instanceof Weapon) {
            currentWeapon = (Weapon) equippedItem;
            removeItem(equippedItem);
            return ReturnMessage.OK;
        } else {
            if (equippedItem == null) {
                return ReturnMessage.NOT_FOUND;
            }
        }
        return ReturnMessage.CANT;
    }

    public ReturnMessage unEquipWeapon() {
        if (currentWeapon != null) {
            addItem(currentWeapon);
            return ReturnMessage.OK;
        } else {
            return ReturnMessage.CANT;
        }
    }

    public ReturnMessage attack(String enemyName) {
        Enemy enemy = currentRoom.searchEnemies(enemyName);
        if (enemy != null) {
            if (currentWeapon != null) {
                if (currentWeapon instanceof MeleeWeapon) {
                    enemy.hit(currentWeapon.getDamage());
                    if (!enemy.enemyDead()) {
                        setPlayerHealth(health - enemy.getWeapon().getDamage());
                        System.out.println("You dealt " + currentWeapon.getDamage() + " damage to " + enemyName);
                        System.out.println("You take " + enemy.getWeapon().getDamage() + " damage from " + enemyName);
                        return ReturnMessage.OK;
                    }
                }
                if (currentWeapon instanceof RangedWeapon) {
                    RangedWeapon rangedWeapon = (RangedWeapon) currentWeapon;
                    int currentAmmo = rangedWeapon.getAmmo();
                    if (currentAmmo > 0) {
                        rangedWeapon.setAmmo(currentAmmo - 1);
                        enemy.hit(currentWeapon.getDamage());
                        if (!enemy.enemyDead()) {
                            setPlayerHealth(health - enemy.getWeapon().getDamage());
                            System.out.println("You dealt " + currentWeapon.getDamage() + " damage to " + enemyName);
                            System.out.println("You take " + enemy.getWeapon().getDamage() + " damage from " + enemyName);
                        }

                        return ReturnMessage.OK;
                    } else {
                        System.out.println("Out of ammo!");
                        return ReturnMessage.CANT;
                    }
                } else {
                    return ReturnMessage.NOT_FOUND;
                }
            } else {
                System.out.println("You don't have a weapon equipped");
                return ReturnMessage.CANT;
            }
        }
        return ReturnMessage.CANT;
    }
}
