public class Adventure {
    private Room currentRoom;
    private String player;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void createRoom() {
        Room room1 = new Room("room1", "description");
        Room room2 = new Room("room2", "description");
        Room room3 = new Room("room3", "description");
        Room room4 = new Room("room4", "description");
        Room room5 = new Room("room5", "description");
        Room room6 = new Room("room6", "description");
        Room room7 = new Room("room7", "description");
        Room room8 = new Room("room8", "description");
        Room room9 = new Room("room9", "description");
        currentRoom = room1;
    }


    public String getPlayer() {
        return player;
    }

}
