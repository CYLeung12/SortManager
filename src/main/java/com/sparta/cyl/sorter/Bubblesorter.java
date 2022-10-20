package com.sparta.cyl.sorter;
import com.sparta.cyl.logging.CustomLoggerConfiguration;
import com.sparta.cyl.start.ArrayLoader;
import com.sparta.cyl.display.DisplayManager;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bubblesorter implements Sorter{
    private static final Logger logger = Logger.getLogger("Bubblesort-logger");

    @Override
    public void runSorter(){
        CustomLoggerConfiguration.configureLogger(logger);

        int[] unsortedArray = ArrayLoader.generateArray();
        DisplayManager.printUnsorrtedArray(unsortedArray);
        int[] sortedArray = sort(unsortedArray);
        DisplayManager.printSortedArry(sortedArray);
    }

    private static int[] sort(int[] arrayToBeSorted) {

        for (int c = 0; c < arrayToBeSorted.length ; c++) {
            logger.log(Level.FINE,  "Outer iteration fo the " + (c+1) + " time.");
            boolean isSorted = true;
            for (int i = 0; i < arrayToBeSorted.length - 1 - c ; i++) {
                logger.log(Level.FINER,  "Inner iteration fo the " + (i+1) + " time.");
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
            numbers[i + 1] = numbers[i];
            numbers[i] = temValue;
        }
    }

}


