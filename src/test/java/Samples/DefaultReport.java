/**
 * Default testng report script - verify testng output file
 *
 */
package Samples;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class DefaultReport {
    //To make it pass
    @Test
    public void passTest(){
        Assert.assertTrue(true);
    }
    //To make it fail
    @Test
    public void failTest(){
        Assert.assertTrue(false);
    }
    //To make it skip
    @Test
    public void skipTest(){
        throw new SkipException("Skipping - This is not ready for testing ");
    }
}
