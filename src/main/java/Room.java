import java.util.ArrayList;

public class Room {
    private Room east;
    private Room south;
    private Room north;
    private Room west;
    private String description;
    private String name;
    private ArrayList<Item> items = new ArrayList<>();

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

    public void addItem(String name, String description) {
        items.add(new Item(name, description));
    }

    public String getItems() {
        return "In the room you see... " + items.toString();
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

    public Item addItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equals(itemName)) {
                items.add(item);
                return item;
            }
        }
        return null;
    }

}
