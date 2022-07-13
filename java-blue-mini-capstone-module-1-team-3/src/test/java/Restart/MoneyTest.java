package Restart;


 import org.junit.Assert;
 import org.junit.Test;

public class MoneyTest {
    Money feedMoney = new Money();

    @Test
    public void feedMoney0() {

        feedMoney.allMoney = 0;
       Object output = feedMoney.getTotalMoney();
        Assert.assertEquals(0.0, output);

    }
    @Test
    public void feedMoney5() {

        feedMoney.allMoney = 5;
        Object output = feedMoney.allMoney;
        Assert.assertEquals(5.0, output);

    }
    @Test
    public void feedMoneyNull() {

        feedMoney.moneyAsString = " ";
        Object output = feedMoney.getTotalMoney();
        Assert.assertEquals(0.0 , output);

    }
}
