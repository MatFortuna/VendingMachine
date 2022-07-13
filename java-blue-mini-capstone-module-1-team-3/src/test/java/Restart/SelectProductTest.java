package Restart;

import org.junit.Assert;
import org.junit.Test;

public class SelectProductTest {
    Inventory products = new Inventory();
   Money buy = new Money();

    @Test
    public  void snackSubtract() {
        products.inventoryList();
        buy.allMoney = 5;
        double itemSubtract = buy.allMoney -products.itemData.get("A3").getPrice();

        Assert.assertEquals(2.25, itemSubtract, 0);

    }
    @Test
    public  void snackCost() {
        products.inventoryList();

       double itemCost = products.itemData.get("A3").getPrice();

        Assert.assertEquals(2.75, itemCost, 0);

    }
    @Test
    public  void snackAvailable() {
        products.inventoryList();
        Snacks item = new Snacks("A3", "Grain Waves", 2.75, "Chip", "Crunch, Crunch, Yum!", 5);
        item.buyItem();
        Assert.assertEquals(4, item.getInventory());

    }
    @Test
    public  void snack0() {
        products.inventoryList();
        Snacks item = new Snacks("A3", "Grain Waves", 2.75, "Chip", "Crunch, Crunch, Yum!", 5);
        item.buyItem();
        item.buyItem();
        item.buyItem();
        item.buyItem();
        item.buyItem();
        Assert.assertEquals(0, item.getInventory());

    }

}
