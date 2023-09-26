import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure adventure = new Adventure();


    public void startProgram() {
        welcome();
    }

    public void welcome() {
        System.out.println("WELCOME TO THE CAVE EXPLORER: 1.0" + "\n ");
        System.out.println("Menu: " +
                "\nType GO + the direction you want to move towards (North,South,East,West). " +
                "\nType HELP to display instructions and information about possible commands." +
                "\nType LOOK to see current room " +
                "\nType EXIT to exit the game.");
        direction();
    }

    public void direction() {
        adventure.createRoom();
        String input = "";
        while (!input.equals("exit")) {
            input = scanner.nextLine();
            switch (input) {
                case "go south":
                    adventure.goSouth();
                    System.out.println("Going South to " + adventure.getCurrentRoom().getName()+adventure.getCurrentRoom().getDescription());
                    break;
                case "go north":
                    System.out.println("Going North" + adventure.getCurrentRoom().getDescription());
                    adventure.goNorth();
                    break;

                case "go west":
                    adventure.goWest();
                    System.out.println("Going West" + adventure.getCurrentRoom().getDescription());
                    break;

                case "go east":
                    adventure.goEast();
                    System.out.println("Going East" + adventure.getCurrentRoom().getDescription());
                    break;

                case "exit":
                    endProgram();
                    return;

                case "look":
                    System.out.println(adventure.getCurrentRoom().getName());
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    break;

                case "help":
                    System.out.println("Instructions");

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
