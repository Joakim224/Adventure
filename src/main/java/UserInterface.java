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
            String[] inputSplit = input.split("\\s+");
            String command = inputSplit[0];

        String argument = "";
            for (int i = 1; i < inputSplit.length; i++) {
                argument += inputSplit[1] + " ";
            }
        argument = argument.trim().toLowerCase();

            /*if (inputSplit.length > 1) {
                input = inputSplit[1];
            }*/


            switch (command) {
                case "go":
                    switch (argument) {
                        case "go south", "s", "S", "south":
                            System.out.println("Going South");
                            adventure.goSouth();
                            System.out.println(adventure.getCurrentRoom().getName() + adventure.getCurrentRoom().getDescription() + adventure.getCurrentRoom().getItems());
                            break;
                        case "go north", "n", "N", "north":
                            System.out.println("Going North");
                            adventure.goNorth();
                            System.out.println(adventure.getCurrentRoom().getName() + adventure.getCurrentRoom().getDescription() + adventure.getCurrentRoom().getItems());
                            break;

                        case "go west", "w", "W", "west":
                            System.out.println("Going West");
                            adventure.goWest();
                            System.out.println(adventure.getCurrentRoom().getName() + adventure.getCurrentRoom().getDescription() + adventure.getCurrentRoom().getItems());

                            break;

                        case "go east", "e", "E", "east":
                            System.out.println("Going East");
                            adventure.goEast();
                            System.out.println(adventure.getCurrentRoom().getName() + adventure.getCurrentRoom().getDescription() + adventure.getCurrentRoom().getItems());
                            break;

                        case "HELP", "help":
                            System.out.println("Instructions:" +
                                    "\nType GO + the direction you want to move towards (North, South, East, West)" +
                                    "\nType LOOK to see current room" +
                                    "\nType INVENTORY to see what you currently have in your inventory" +
                                    "\nType EXIT to exit the game");
                            break;

                        case "LOOK", "look":
                            System.out.println(adventure.currentRoom().getName());
                            System.out.println(adventure.currentRoom().getDescription());
                            System.out.println(adventure.currentRoom().getItems());
                            break;

                        case "TAKE", "take":
                            Item itemTaken = adventure.takeItem(input);
                            if (itemTaken != null) {
                                System.out.println("You pick up a: " + input);
                            } else {
                                System.out.println("There is no item in the room of that name.");
                            }
                            break;

                        case "DROP", "drop":
                            Item itemDropped = adventure.dropItem(input);
                            if (itemDropped != null) {
                                System.out.println("You drop a: " + input);
                            } else {
                                System.out.println("There is no item in your inventory of that name.");
                            }
                            break;

                        case "INVENTORY", "Inventory", "inventory":
                            System.out.println("In your inventory is: ");
                            adventure.PrintInventory();
                            break;

                        case "EXIT", "exit":
                            endProgram();
                            return;

                        default:
                            System.out.println("Invalid choice, try again");
                            break;
                    }
            }
        }
    }

    public void endProgram() {
        System.out.println("Game ended.");
    }
}