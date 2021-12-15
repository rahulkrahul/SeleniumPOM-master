/**
 * https://www.softwaretestingmaterial.com/soft-assert/
 * Softassertion: In the softAssert() method, I have used SoftAssert class and intentionally passing value false in the assertTrue() method to make it fail
 */
package Samples;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    @Test
    public void softAssert(){
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("softAssert Method Was Started");
        softAssertion.assertTrue(false,"true");
        System.out.println("softAssert Method Was Executed");
        softAssertion.assertAll();
    }

    @Test
    public void hardAssert(){
        System.out.println("hardAssert Method Was Started");
        Assert.assertTrue(false);
        System.out.println("hardAssert Method Was Executed");
    }
}