public class Map {
    private Room starterRoom;

    public Room getStarterRoom() {
        return starterRoom;
    }

    public void createMap() {
        Room room1 = new Room("Cave entrance: ", "You are in a dark cold cave, you can hear dripping noises in the near distance. ");
        Room room2 = new Room("Echoing abyss: ", "As you step into the Echoing Abyss room, you are immediately struck by an overwhelming sense of awe and mystery. ");
        Room room3 = new Room("Crystal tunnel: ", "The sound of water dripping on the crystals makes for an ominous sound. You wonder what kind of crystals they are. ");
        Room room4 = new Room("Emerald chamber: ", "Emerald is all over the walls and ceiling. The light from ur flashlight makes the whole room shine green. ");
        Room room5 = new Room("The throne room: ", "This room looks different from the others. The ceiling and walls are all filled with symbols and patterns. At the far end of the room is a big shiny throne. ");
        Room room6 = new Room("Luminous lagoon: ", "This room is filled with water. You have no idea how deep and you dont dare jump in to check. ");
        Room room7 = new Room("The echo chamber: ", "You enter a huge room in the cave. The room is so big you can't even see the ceiling. All sounds bounce off the walls and echo for. ");
        Room room8 = new Room("The relic repository: ", "This room is filled with random trinkets and shiny objects. You suspect this might have been used as a storage in the past. ");
        Room room9 = new Room("The Enigma's Epilogue: ", "This appears to be the ending of the cave. You can see no light and no way out. Only option is to head back. ");

        room1.setSouth(room4);
        room1.setEast(room2);
        room1.createItem("lantern", "lights up the current room you're in");

        room2.setWest(room1);
        room2.setEast(room3);
        room2.createItem("ring", "gives plus 15 ability power and 70 health points");

        room3.setSouth(room6);
        room3.setWest(room2);
        room3.createFood("apple", "gives 10 points of health", 10);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.createItem("sword", "deals 15 attack damage each attack");

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.createFood("stew", "gives 15 points of health", 15);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.createItem("key", "opens the door to 'The Throne Room'");

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room8.createItem("potion", "restores 20 points of health");

        room9.setWest(room8);
        room9.setNorth(room6);
        room9.createItem("orb", "gives plus 70 ability power and 50 health points");

        starterRoom = room1;


    }
}