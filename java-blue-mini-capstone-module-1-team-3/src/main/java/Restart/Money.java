package Restart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Money {
    private int inputMoney;
    private double totalMoney;
    private double change;
    private double moneySpent;
    File log = new File("log.txt");
    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));
    DecimalFormat df = new DecimalFormat("0.00");

    public Money(int inputMoney, double totalMoney, double change, double moneySpent) {
        this.inputMoney = inputMoney;
        this.totalMoney = totalMoney;
        this.change = change;
        this.moneySpent = moneySpent;
    }

    public Money() {

    }


    double allMoney = getTotalMoney();
    Scanner keyboard = new Scanner(System.in);
    String moneyAsString;
    int totalQuartersToReturn = 0;
    int totalDimesToReturn = 0;
    int totalNickelsToReturn = 0;


    public Object feedMoney() {

        System.out.print("How much money would you like to add? : ");
        moneyAsString = keyboard.nextLine();
        boolean repeater = false;
        while (!repeater) {
            if (moneyAsString.contains(".")) {
                System.out.println("Sorry we only accept Positive amounts of cash in whole dollar amounts");
                System.out.println("Please try again");
                repeater = true;
            } else {
                Integer insertMoney = (Integer.parseInt(moneyAsString));

                if (insertMoney > 0) {
                    double total = insertMoney;
                    allMoney = total + allMoney;
                    setTotalMoney(allMoney);
                    if (!log.exists()){
                        try {
                            log.createNewFile();
                            try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {
                                pw.println(dateTime + " Money Inserted: $" + df.format(insertMoney) + " Total Money: $" + df.format(allMoney));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {  try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {
                        pw.println(dateTime + " Money Inserted: $" + df.format(insertMoney) + " Total Money: $" + df.format(allMoney));;

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    }

                    return getTotalMoney();

                } else {
                    System.out.println("Sorry we only accept Positive amounts of cash in whole dollar amounts");
                    System.out.println("Please try again");
                    repeater = true;

                }
            }


        }
        return getTotalMoney();

    }

    public Object purchaseItem() {

        Inventory purchase = new Inventory();
        purchase.inventoryList();
        System.out.print("What is your selection?: ");
        String purchaseChoice = keyboard.nextLine().toUpperCase();
        boolean repeat = false;
        while (!repeat)

            if ((purchase.itemData.containsKey(purchaseChoice))) {


                double leftMoney = getTotalMoney() - purchase.itemData.get(purchaseChoice).getPrice();
                if(leftMoney >= 0 && purchase.itemData.get(purchaseChoice).getInventory() > 0) {
                    allMoney = allMoney - purchase.itemData.get(purchaseChoice).getPrice();
                    setTotalMoney(leftMoney);
                    purchase.itemData.get(purchaseChoice).buyItem();
                    System.out.println();
                    System.out.print(purchase.itemData.get(purchaseChoice));
                    System.out.println(purchase.itemData.get(purchaseChoice).getSound());
                    System.out.println("********************************");
                    repeat = true;
                    if (!log.exists()){
                        try {
                            log.createNewFile();
                            try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {
                                pw.println(dateTime + " Item Purchased: " + purchase.itemData.get(purchaseChoice) + " Total Money: $" + df.format(allMoney));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {  try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {
                        pw.println(dateTime + " Item Purchased: " + purchase.itemData.get(purchaseChoice) + " Total Money: $" + df.format(allMoney));

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    }

                }else {
                    System.out.println("Sorry we cannot complete that transaction for you");
                    System.out.println("********************************");
                    repeat = true;
                }
            } else {
                System.out.println("Sorry that isnt a selectable item");
                System.out.println("Please try again");
                repeat = true;


            }
        return totalMoney;


    }

    public Object returnChange(){

        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        totalQuartersToReturn = 0;
        totalDimesToReturn = 0;
        totalNickelsToReturn = 0;
        double allMoneyAsPennies = allMoney *100;

        while (allMoneyAsPennies > 0) {
            if (allMoneyAsPennies>= quarter) {
                totalQuartersToReturn++;
                allMoneyAsPennies -= quarter;
            } else if (allMoneyAsPennies >= dime) {
                totalDimesToReturn++;
                allMoneyAsPennies -= dime;
            } else if (allMoneyAsPennies >= nickel) {
                totalNickelsToReturn++;
                allMoneyAsPennies -= nickel;
            }
        }
        if (!log.exists()){
            try {
                log.createNewFile();
                try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {
                    pw.println(dateTime + " Money Returned: $" + df.format(allMoney) + " Total Money: $0");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {  try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {
            pw.println(dateTime + " Money Returned: $" + df.format(allMoney) + " Total Money: $0");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        }
        allMoney = 0;
        System.out.println();
        System.out.println("Your change is " + totalQuartersToReturn + " quarters, " + totalDimesToReturn
                + " dimes, " + "and " + totalNickelsToReturn + " nickel.");
        System.out.println("See yaaa!");
        System.out.println("********************************");


        return new StartMenu();

    }







    public int getInputMoney() {
        return inputMoney;
    }

    public void setInputMoney(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }



}
