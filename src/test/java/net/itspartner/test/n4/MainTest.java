package net.itspartner.test.n4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    private Main compare;
    private int[] firstArray = {4, 2, 5, 6, 3, 9};
    private int[] secondArray = {3, 1, 5, 4};
    private int[] thirdArray = {2, 8, 11, 3, 44};

    @Before
    public void setUp() {
        compare = new Main();
    }

    @After
    public void tearDown() {
        compare = null;
    }

    @Test
    public void testFindTheBiggestNumber() {
        assertEquals(9, compare.findTheBiggestNumber(firstArray));
        assertEquals(5, compare.findTheBiggestNumber(secondArray));
        assertEquals(44, compare.findTheBiggestNumber(thirdArray));
    }
}