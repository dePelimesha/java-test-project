    package net.itspartner.test.n4;

    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;

    import static org.junit.Assert.*;

    public class MainTest {

        private BiggestNumberFinder finder;
        private int[] firstArray = {4, 2, 5, 6, 3, 9};
        private int[] secondArray = {3, 1, 5, 4};
        private int[] thirdArray = {2, 8, 11, 3, 44};

        @Before
        public void setUp() {
            finder = new Main();
        }

        @After
        public void tearDown() {
            finder = null;
        }

        @Test
        public void testFindTheBiggestNumber() {
            assertEquals(9, finder.findTheBiggestNumber(firstArray));
            assertEquals(5, finder.findTheBiggestNumber(secondArray));
            assertEquals(44, finder.findTheBiggestNumber(thirdArray));
        }
    }
