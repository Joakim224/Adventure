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
        room1.createItem("lantern", "can light up the room, if only you had some oil");

        room2.setWest(room1);
        room2.setEast(room3);
        room2.createItem("ring", "gives you a strange feeling");

        room3.setSouth(room6);
        room3.setWest(room2);
        room3.createFood("apple", "gives healthpoints: ", 10);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.createMeleeWeapon("sword", "deals 15 attack damage each attack", 15);

        room5.setSouth(room8);
        room5.createEnemy("Raptors", "spits fireballs at you - has 100 hp & deals 25 dmg", 100, new RangedWeapon("fireballs", "deals 25 dmg", 25, 10), room5);

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.createFood("stew", "gives healthpoints: ", 15);
        room6.createEnemy("Gromp", "big ass frog - has 35 hp & deals 20 dmg", 35, new MeleeWeapon("claws", "Deals 20 dmg", 20), room6);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.createItem("key", "opens the door to 'The Throne Room'");

        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room8.createFood("potion", "restores 20 points of health", 20);
        room8.createRangedWeapon("bow", "deals 25 damage with each arrow", 25, 5);


        room9.setWest(room8);
        room9.setNorth(room6);
        room9.createItem("orb", "has a strange aura");

        starterRoom = room1;
    }
}