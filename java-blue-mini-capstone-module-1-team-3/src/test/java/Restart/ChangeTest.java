package Restart;

import org.junit.Assert;
import org.junit.Test;

public class ChangeTest {
    Money test = new Money();

    @Test
    public  void moneyBack25() {
        test.allMoney = 1.40;
        test.returnChange();
       int output = test.totalQuartersToReturn;
        Assert.assertEquals( 5, output);

    }

    @Test
    public  void moneyBack10() {
        test.allMoney = 1.40;
        test.returnChange();
        int output = test.totalDimesToReturn;
        Assert.assertEquals( 1, output);

    }
    @Test
    public  void moneyBack5() {
        test.allMoney = 1.40;
        test.returnChange();
        int output = test.totalNickelsToReturn;
        Assert.assertEquals( 1, output);

    }

}
