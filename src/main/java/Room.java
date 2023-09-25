public class Room {
    private Room east;
    private Room south;
    private Room north;
    private Room west;
    private String description;
    private String name;


    public Room(String name, String description) {
        this.description = description;
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
}
