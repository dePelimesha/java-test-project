package net.itspartner.test.n4;

/**
 * Task:
 * 1) Implement interface BiggestNumberFinder to provide functionality of finding the biggest number from array
 * 2) Write unit tests for this class with JUnit
 */

public class Main implements BiggestNumberFinder {

    @Override
    public int findTheBiggestNumber(int[] numbers) {
        int maxValue = 0;

        for (int curNumber: numbers) {
            if (curNumber > maxValue) {
                maxValue = curNumber;
            }
        }

        return maxValue;
    }
}
