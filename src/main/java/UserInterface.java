import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface() {
        adventure = new Adventure();
        adventure.createMap();
    }

    public void startProgram() {
        welcome();
    }

    public void welcome() {
        System.out.println(" ____  _   _  ____       ___    __    _  _  ____      ____  _  _  ____  __    _____  ____  ____  ____ \n" +
                "(_  _)( )_( )( ___)     / __)  /__\\  ( \\/ )( ___)    ( ___)( \\/ )(  _ \\(  )  (  _  )(  _ \\( ___)(  _ \\\n" +
                "  )(   ) _ (  )__)     ( (__  /(  )\\  \\  /  )__)      )__)  ) / (  )___/ )(__  )(_)(  )   / )__)  )   /\n" +
                " (__) (_) (_)(____)     \\___)(__)(__)  \\/  (____)    (____)(_/\\_)(__)  (____)(_____)(_)\\_)(____)(_)\\_)\n" + "\n ");
        System.out.println();
        System.out.println("Menu: " +
                "\nType GO + the direction you want to move towards (North, South, East, West)" +
                "\nType HELP to display instructions and information about possible commands" +
                "\nType LOOK to look around the current room you're in" +
                "\nType EXIT to exit the game");
        direction();
    }

    public void direction() {
        String input = " ";
        while (!input.equals("exit")) {
            input = scanner.nextLine().trim().toLowerCase();
            String[] commands = input.split("\\s+");
            String command = commands[0];

            if (commands.length == 1) {

                switch (command) {
                    case "north", "n": {
                        adventure.goNorth();
                        System.out.println(adventure.currentRoomDescription());
                        break;
                    }
                    case "south", "s": {
                        adventure.goSouth();
                        System.out.println(adventure.currentRoomDescription());
                        break;

                    }
                    case "east", "e": {
                        adventure.goEast();
                        System.out.println(adventure.currentRoomDescription());
                        break;

                    }
                    case "west", "w": {
                        adventure.goWest();
                        System.out.println(adventure.currentRoomDescription());
                        break;
                    }

                    case "help", "h": {
                        System.out.println("Commands:" +
                                "\nGO            go north, go south, go east, go west - you can also use N, S, E and W" +
                                "\nEXIT          to exit the program" +
                                "\nLOOK          to take another look around the room" +
                                "\nTAKE          to pickup an object from a room" +
                                "\nDROP          to drop an item inside a room" +
                                "\nEAT           to eat a food item from your inventory" +
                                "\nINVENTORY     to look in your inventory" +
                                "\nHEALTH        to get your current hp" +
                                "\nEQUIP/UNEQUIP to equip or unequip weapons from your inventory" +
                                "\nATTACk        to attack with your equipped weapon");
                        break;
                    }
                    case "look": {
                        System.out.println(adventure.currentRoomDescription());
                        break;
                    }
                    case "exit": {
                        System.exit(0);
                    }
                    case "inventory": {
                        adventure.PrintInventory();
                        break;
                    }
                    case "HEALTH", "health": {
                        System.out.println("You currently have " + adventure.getPlayer().getHealth() + " health");
                        break;
                    }
                    case "attack": {
                        ReturnMessage attack = adventure.attack();
                        switch (attack) {
                            case OK:
                                break;
                            case CANT:
                                break;
                            case NOT_FOUND:
                                break;
                        }
                        break;
                    }
                    default:
                        System.out.println("Invalid input, type 'help' for list of commands");
                }
            }
            if (commands.length == 2)
                switch (commands[0]) {

                    case "go": {
                        switch (commands[1]) {
                            case "north", "n": {
                                adventure.goNorth();
                                System.out.println(adventure.currentRoomDescription());
                                break;
                            }
                            case "south", "s": {
                                adventure.goSouth();
                                System.out.println(adventure.currentRoomDescription());
                                break;

                            }
                            case "east", "e": {
                                adventure.goEast();
                                System.out.println(adventure.currentRoomDescription());
                                break;

                            }
                            case "west", "w": {
                                adventure.goWest();
                                System.out.println(adventure.currentRoomDescription());
                                break;

                            }
                            default:
                                System.out.println("Invalid input, type 'help' for list of commands");
                        }
                        break;
                    }
                    case "TAKE", "take": {
                        Item itemTaken = adventure.takeItem(commands[1]);
                        if (itemTaken != null) {
                            System.out.println("You pick up a: " + commands[1]);
                        } else {
                            System.out.println("There is no item in the room of that name.");
                        }
                        break;
                    }
                    case "equip", "Equip": {
                        ReturnMessage itemEquip = adventure.equipWeapon(commands[1]);
                        switch (itemEquip) {
                            case OK:
                                System.out.println("You equip " + commands[1]);
                                adventure.getPlayer().equipWeapon(commands[1]);
                                break;
                            case CANT:
                                System.out.println("You cant equip " + commands[1]);
                                break;
                            case NOT_FOUND:
                                System.out.println("No " + commands[1] + " was found in your inventory ");
                                break;
                        }
                        break;
                    }
                    case "unequip", "unEquip": {
                        ReturnMessage itemunEquip = adventure.unEquipWeapon(commands[1]);
                        switch (itemunEquip) {
                            case OK:
                                System.out.println("You unequip " + commands[1]);
                                adventure.getPlayer().unEquipWeapon();
                                break;
                            case CANT:
                                System.out.println("You cant unequip " + commands[1]);
                                break;
                            case NOT_FOUND:
                                System.out.println("No " + commands[1] + " was found in your inventory ");
                                break;
                        }
                        break;
                    }
                    case "DROP", "drop": {
                        Item itemDropped = adventure.dropItem(commands[1]);
                        if (itemDropped != null) {
                            System.out.println("You drop a: " + commands[1]);
                        } else {
                            System.out.println("There is no item in your inventory of that name.");
                        }
                        break;
                    }
                    case "Eat", "eat": {
                        ReturnMessage itemEaten = adventure.eatFood(commands[1]);
                        switch (itemEaten) {
                            case OK:
                                System.out.println("Eating " + commands[1]);
                                System.out.println("You now have " + adventure.getPlayer().getHealth() + " healthpoints");
                                break;
                            case CANT:
                                System.out.println("You can't eat " + commands[1]);
                                break;
                            case NOT_FOUND:
                                System.out.println("No " + commands[1] + " was found in your inventory");
                                break;
                        }
                        break;
                    }
                    default:
                        System.out.println("Invalid input, type 'help' for list of commands");

                }
        }
    }
}