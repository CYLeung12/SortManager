package com.sparta.cyl.sorter;

import com.sparta.cyl.logging.CustomLoggerConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSorter implements Sorter{
    private static final Logger logger = Logger.getLogger("Bubblesort-logger");

    @Override
    public int[] runSorter(int[] unsortedArray){
        CustomLoggerConfiguration.configureLogger(logger);

        int[] sortedArray = sort(unsortedArray);
        return sortedArray;
    }

    private static int[] sort(int[] arrayToBeSorted) {

        for (int c = 0; c < arrayToBeSorted.length ; c++) {
            logger.log(Level.FINE,  "Outer iteration for the " + (c+1) + " time.");
            boolean isSorted = true;
            for (int i = 0; i < arrayToBeSorted.length - 1 - c ; i++) {
                logger.log(Level.FINER,  "Inner iteration for the " + (i+1) + " time.");
                int temValue = arrayToBeSorted[i+1];
                swap(arrayToBeSorted, i, temValue);
                isSorted = false;
            }
            if (isSorted) return arrayToBeSorted;
}
        return arrayToBeSorted;
    }

    private static void swap(int[] numbers, int i, int temValue) {
        if (numbers[i] > numbers[i + 1]) {
            logger.log(Level.FINE,  (numbers[i] + " > "+ numbers[i + 1])+ " ,so their poistions are swapped.");
            numbers[i + 1] = numbers[i];
            numbers[i] = temValue;
        }
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}