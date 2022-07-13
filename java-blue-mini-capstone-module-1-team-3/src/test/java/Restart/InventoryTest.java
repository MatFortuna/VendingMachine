package Restart;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class InventoryTest {
    Inventory inventoryTest = new Inventory();

    @Test
    public void inventory() {

        inventoryTest.inventoryList();
       String output = inventoryTest.itemData.get("A3").toString();
        Assert.assertEquals("A3 Grain Waves $2.75 ", output );

    }
    @Test
    public void inventoryNull() {
        inventoryTest.inventoryList();
        Snacks output = inventoryTest.itemData.get(null);
        Assert.assertEquals(null, output);

    }
    @Test
    public void inventoryNoKey() {

        inventoryTest.inventoryList();
        Snacks output = inventoryTest.itemData.get("A5");
        Assert.assertEquals(null, output );

    }

}