import java.util.ArrayList;

public class Player {
    private int health;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setPlayerHealth(int health) {
        this.health = health;
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
            health += ((Food)item).getHealpoints();
            return ReturnMessage.OK;
        } else {
            if (item == null) {
                return ReturnMessage.NOT_FOUND;
            }
        }
        return ReturnMessage.CANT;
    }
}