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
                    case "help", "h": {
                        System.out.println("Commands:" +
                                "\nGO           go north, go south, go east, go west - you can also use N, S, E and W" +
                                "\nEXIT         to exit the program" +
                                "\nLOOK         to take another look around the room" +
                                "\nTAKE         to pickup an object from a room" +
                                "\nDROP         to drop an item inside a room" +
                                "\nINVENTORY    to look in your inventory");
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
                        System.out.println("In your inventory is:");
                        adventure.PrintInventory();
                        break;

                    }
                    default: System.out.println("Invalid input, type 'help' for list of commands");
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
                                System.out.println("Invalid input");
                        }
                        break;
                    }

                    case "TAKE", "take":{
                        Item itemTaken = adventure.takeItem(commands[1]);
                        if (itemTaken != null) {
                            System.out.println("You pick up a: " + input);
                        } else {
                            System.out.println("There is no item in the room of that name.");
                        }
                        break;
                    }
                    case "DROP", "drop": {
                        Item itemDropped = adventure.dropItem(commands[1]);
                        if (itemDropped != null) {
                            System.out.println("You drop a: " + input);
                        } else {
                            System.out.println("There is no item in your inventory of that name.");
                        }
                        break;
                    }
                        default:
                            System.out.println("Invalid input, type 'help' for list of commands");

                }

        }
    }
}


