package net.itspartner.test.n4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MainTest1 {
    private int expectedValue;
    private int[] numbers;

    @Parameterized.Parameters
    public static Collection initialize() {
        return Arrays.asList(new Object[][]{
                {9, new int[]{4, 2, 5, 6, 3, 9}},
                {5, new int[]{3, 1, 5, 4}},
                {44, new int[]{2, 8, 11, 3, 44}}
        });
    }

    public MainTest1(int expectedValue, int[] numbers) {
        this.expectedValue = expectedValue;
        this.numbers = numbers;
    }

    @Test
    public void testFindTheBiggestNumber() {
        Main compare = new Main();
        assertEquals(expectedValue, compare.findTheBiggestNumber(numbers));
    }
}