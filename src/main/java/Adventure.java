public class Adventure {
    private Player player;
    private Map map = new Map();

    public Adventure() {
        map.createMap();
        player = new Player(100);
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Player getPlayer() {
        return player;
    }

    public void createMap() {
        map.createMap();
    }


    public String currentRoomDescription() {
        return player.getCurrentRoom().getName() +
                player.getCurrentRoom().getDescription() + ("\n") +
                player.getCurrentRoom().getItems() + ("\nEnemies:") +
                player.getCurrentRoom().getEnemies();
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


    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public ReturnMessage eatFood(String itemName) {
        return player.eatFood(itemName);
    }

    public void PrintInventory() {
        player.printInventory();
    }

    public ReturnMessage equipWeapon(String itemName) {
        return player.equipWeapon(itemName);
    }

    public ReturnMessage unEquipWeapon(String itemName) {
        return player.unEquipWeapon();
    }

    public ReturnMessage attack(String enemyName) {
        return player.attack(enemyName);
    }
}