public class Adventure {
    private Room currentRoom;
    private String player;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void createRoom() {
        Room room1 = new Room("Cave entrance", "You are in a dark cold cave, you can hear dripping noises in the near distance");
        Room room2 = new Room("Echoing abyss", "As you step into the Echoing Abyss room, you are immediately struck by an overwhelming sense of awe and mystery.");
        Room room3 = new Room("Crystal tunnel", "The sound of water dripping on the crystals makes for an ominous sound. You wonder what kind of crystals they are.");
        Room room4 = new Room("Emerald chamber", "Emerald is all over the walls and ceiling. The light from ur flashlight makes the whole room shine green.");
        Room room5 = new Room("The throne room", "This room looks different from the others. The ceiling and walls are all filled with symbols and patterns. At the far end a big thrown");
        Room room6 = new Room("Luminous lagoon", "This room is filled with water. You have no idea how deep and you dont dare jump in to check.");
        Room room7 = new Room("The echo chamber", "You enter a huge room in the cave. The room is so big you can't even see the ceiling. All sounds bounce off the walls and echo for");
        Room room8 = new Room("The relic repository", "This room is filled with random trinkets and shiny objects. You suspect this might have been used as a storage in the past.");
        Room room9 = new Room("The Enigma's Epilogue", "This appears to be the ending of the cave. You can see no light and no way out. Only option is to head back.");
        currentRoom = room1;
        room1.setSouth(room4);
        room1.setEast(room2);
        room1.setNorth(null);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setSouth(room6);
        room3.setWest(room4);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        room9.setWest(room8);
        room9.setNorth(room6);
    }

    public String getPlayer() {
        return player;
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
}


