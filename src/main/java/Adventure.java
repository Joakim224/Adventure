public class Adventure {
    private Player player = new Player();
    private Map map = new Map();

    public Adventure() {
        map.createMap();
        player = new Player();
        player.setCurrentRoom(map.getStarterRoom());
    }

    public void createMap() {
        map.createMap();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public String currentRoomDescription() {
        return player.getCurrentRoom().getName() + player.getCurrentRoom().getDescription() + player.getCurrentRoom().getItems();
    }

    public boolean goSouth() {
        return player.goSouth();
    }

    public boolean goNorth() {
        return player.goNorth();
    }

    public boolean goWest() {
        return player.goWest();
    }


    public boolean goEast() {
        return player.goEast();
    }

    public Room currentRoom() {
        return player.getCurrentRoom();
    }

    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public void PrintInventory() {
        player.printInventory();
    }

    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }
}