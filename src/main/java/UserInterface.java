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
                "  )(   ) _ (  )__)     ( (__  /(  )\\  \\  /  )__)      )__)  )  (  )___/ )(__  )(_)(  )   / )__)  )   /\n" +
                " (__) (_) (_)(____)     \\___)(__)(__)  \\/  (____)    (____)(_/\\_)(__)  (____)(_____)(_)\\_)(____)(_)\\_)\n" + "\n ");
        System.out.println();
        System.out.println("Menu: " +
                "\nType GO + the direction you want to move towards (North, South, East, West)" +
                "\nType HELP to display instructions and information about possible commands" +
                "\nType LOOK to see look around you" +
                "\nType EXIT to exit the game");
        direction();
    }

    public void direction() {
        String input = "";
        while (!input.equals("exit")) {
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "go south":
                    System.out.println("Going South");
                    adventure.goSouth();
                    System.out.println(adventure.getCurrentRoom().getName()+adventure.getCurrentRoom().getDescription());
                    break;
                case "go north":
                    System.out.println("Going North");
                    adventure.goNorth();
                    System.out.println(adventure.getCurrentRoom().getName()+adventure.getCurrentRoom().getDescription());
                    break;

                case "go west":
                    System.out.println("Going West");
                    adventure.goWest();
                    System.out.println(adventure.getCurrentRoom().getName() + adventure.getCurrentRoom().getDescription());

                    break;

                case "go east":
                    System.out.println("Going East");
                    adventure.goEast();
                    System.out.println(adventure.getCurrentRoom().getName()+adventure.getCurrentRoom().getDescription());
                    break;

                case "help":
                    System.out.println("Instructions:"+
                            "\nType GO + the direction you want to move towards (North, South, East, West)" +
                            "\nType LOOK to see current room" +
                            "\nType EXIT to exit the game");
                    break;

                case "look":
                    System.out.println(adventure.currentRoom().getName());
                    System.out.println(adventure.currentRoom().getDescription());
                    break;

                case "exit":
                    endProgram();
                    return;

                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
        }
    }
    public void endProgram() {
        System.out.println("Game ended.");
    }
}
