package Restart;

import java.util.Scanner;

public class Transactions extends Money {
    public Transactions(int inputMoney, double totalMoney, double change, double moneySpent) {
        super(inputMoney, totalMoney, change, moneySpent);
    }

    public Transactions() {
        super();
    }
}
//    double allMoney = getTotalMoney();
//    Scanner keyboard = new Scanner(System.in);
//    public Object feedMoney() {
//
//        System.out.print("How much money would you like to add? : ");
//        String moneyAsString = keyboard.nextLine();
//        boolean repeater = false;
//        while (!repeater) {
//            if (moneyAsString.contains(".")) {
//                System.out.println("Sorry we only accept Positive amounts of cash in whole dollar amounts");
//                System.out.println("Please try again");
//                repeater = true;
//            } else {
//                Integer insertMoney = (Integer.parseInt(moneyAsString));
//
//                if (insertMoney > 0) {
//                    double total = insertMoney;
//                    allMoney = total + allMoney;
//                    setTotalMoney(allMoney);
//                    return getTotalMoney();
//
//                } else {
//                    System.out.println("Sorry we only accept Positive amounts of cash in whole dollar amounts");
//                    System.out.println("Please try again");
//                    repeater = true;
//
//                }
//            }
//
//
//        }
//        return getTotalMoney();
//
//    }
//    public Object purchaseItem (Integer inputMoney, double totalMoney) {
//
//        Inventory purchase = new Inventory();
//        purchase.inventoryList();
//        System.out.print("What is your selection?: ");
//        String purchaseChoice = keyboard.nextLine().toUpperCase();
//        boolean repeat=false;
//        while (!repeat)
//
//        if ((purchase.itemData.containsKey(purchaseChoice))) {
//
//
//            double leftMoney = allMoney - purchase.itemData.get(purchaseChoice).getPrice();
//            setTotalMoney(leftMoney);
//            System.out.println();
//            System.out.println(purchase.itemData.get(purchaseChoice));
//
//            repeat = true;
//        }else{
//            System.out.println("Sorry that isnt a selectable item");
//            System.out.println("Please try again");
//            repeat = true;
//
//
//        } return totalMoney;
//
//
//    }
//}


