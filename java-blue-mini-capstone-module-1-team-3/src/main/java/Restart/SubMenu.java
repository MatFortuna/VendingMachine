package Restart;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SubMenu {
    DecimalFormat df = new DecimalFormat("0.00");
    public boolean purchaseMenu() {
        Scanner Keyboard = new Scanner(System.in);
        Money feed = new Money();
        boolean isValid = false;
        while (!isValid) {

            System.out.println("Current Money Provided: $" + (df.format(feed.getTotalMoney())));
            System.out.println("```");
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            System.out.print("What is your selection? ");

            String menuChoice = Keyboard.nextLine().trim();

            if (menuChoice.equals("1")) {

                feed.feedMoney();


            }
            else if (menuChoice.equals("2")) {
                Inventory itemData = new Inventory();
                itemData.inventoryList();
                for (String l : itemData.itemData.keySet()){
                    System.out.println(itemData.itemData.get(l));

                }
                  feed.purchaseItem();


            }
            else if (menuChoice.equals("3")) {
                feed.returnChange();
               StartMenu restart = new StartMenu();
               restart.menu();



            } else {
                System.out.println("Incorrect Input");
                isValid = true;
                return purchaseMenu();
            }
        } return isValid;
    }
}

