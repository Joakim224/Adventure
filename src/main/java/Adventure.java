public class Adventure {
    private Room currentroom;

    public Room getCurrentroom() {
        return currentroom;
    }

    public void createRoom() {
        Room room1 = new Room("room1", "...");
        Room room2 = new Room("room2", "...");
        Room room3 = new Room("room3", "...");
        Room room4 = new Room("room4", "...");
        Room room5 = new Room("room5", "...");
        Room room6 = new Room("room6", "...");
        Room room7 = new Room("room7", "...");
        Room room8 = new Room("room8", "...");
        Room room9 = new Room("room9", "...");
        currentroom = room1;
    }

}
