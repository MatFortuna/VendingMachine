package Restart;

import java.util.Scanner;

public class StartMenu {
    public boolean menu() {
        boolean isValid = false;
        while (!isValid) {
            Scanner Keyboard = new Scanner(System.in);
            System.out.println("```");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.print("What is your selection? ");

            String menuChoice = Keyboard.nextLine();

            if (menuChoice.equals("1")) {
                Inventory itemData = new Inventory();
                itemData.inventoryList();
                for (String l : itemData.itemData.keySet()){
                    System.out.println(itemData.itemData.get(l));
                }
            }
            else if (menuChoice.equals("2")) {
                SubMenu purchaseMenu = new SubMenu();
                purchaseMenu.purchaseMenu();

            }
           else if (menuChoice.equals( "3")) {
                System.out.println("Goodbye.");
                    System.exit(0);
            } else {
                System.out.println("Incorrect Input");
                isValid = true;
            }
        }  return isValid;
    }
}
