package lt.viko.eif.jkulbokas.console;

import java.util.Scanner;

/**
 * Class that stores the program's main menu
 */
public class MainMenu {

    public void start(){

        Scanner scanner = new Scanner(System.in);
        MenuOption menuOption = new MenuOption();

        while(true){
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("                 RECIPE FINDER");
            System.out.println();
            System.out.println("            1. Search for recipe");
            System.out.println("            2. Check saved recipes");
            System.out.println("            0. Exit");
            System.out.println("------------------------------------------------");
            System.out.println("            What is your choice?");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    menuOption.searchRecipes();
                    break;
                case 2:
                    menuOption.viewSavedRecipes();
                    break;
                case 0:
                    System.exit(0);
                    return;
                default:
                    System.out.println("There is no such choice");
                    break;
            }
        }


    }
}
