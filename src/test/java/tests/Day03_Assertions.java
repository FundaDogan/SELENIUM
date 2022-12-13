package tests;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {

    /*
        What is assertion in testing?
        Assertion is done to check if expected result is equal to actual result.

        expected == actual -> pass
        expected != actual -> fail

        assertEquals("expected","actual");

        assertTrue(true); -> pass
        assertTrue(false); -> fail
     */

    @Test
    public void assertions(){

        Assert.assertEquals(5,5);
        Assert.assertEquals("java","java");
        Assert.assertEquals("java".contains("j"),true); //pass

       // -----------------

        Assert.assertTrue("java".contains("j")); // pass

        Assert.assertFalse("Java".contains("j"));// pass




    }
}
