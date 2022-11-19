package com.sparta.cyl.sorter;

import com.sparta.cyl.logging.CustomLoggerConfiguration;
import com.sparta.cyl.logging.SorterLogger;
import com.sparta.cyl.view.DisplayManager;

import java.util.Arrays;
import java.util.logging.Level;


public class BubbleSorter implements Sorter{
    public BubbleSorter(){
        SorterLogger.logger.log(Level.INFO, "--------------------Run Bubble Sort--------------------");
    }
    @Override
    public int[] runSorter(int[] unsortedArray){
        CustomLoggerConfiguration.configureLogger(SorterLogger.logger);
        long startTime = System.nanoTime();
        int[] sortedArray = sort(unsortedArray);
        long endTime = System.nanoTime();
        timer(endTime-startTime);
        return sortedArray;
    }

    @Override
    public void timer(long timeElapsed){
        DisplayManager.printTime(this, timeElapsed);
    }

    private static int[] sort(int[] arrayToBeSorted) {

        for (int c = 0; c < arrayToBeSorted.length ; c++) {

            boolean isSorted = true;
            for (int i = 0; i < arrayToBeSorted.length - 1 - c ; i++) {
                int temValue = arrayToBeSorted[i+1];
                swap(arrayToBeSorted, i, temValue);
                isSorted = false;
            }
            SorterLogger.logger.log(Level.FINE,  "Is array sorted? " + isSorted);
            if (isSorted) return arrayToBeSorted;
}
        return arrayToBeSorted;
    }

    private static void swap(int[] arrayToBeSorted, int i, int temValue) {
        if (arrayToBeSorted[i] > arrayToBeSorted[i + 1]) {
            SorterLogger.logger.log(Level.FINE,  (arrayToBeSorted[i] + " > "+ arrayToBeSorted[i + 1])+ " ,so their positions" +
                " are " +
                    "swapped.");
            arrayToBeSorted[i + 1] = arrayToBeSorted[i];
            arrayToBeSorted[i] = temValue;
            SorterLogger.logger.log(Level.FINE,  "Current array: " + Arrays.toString(arrayToBeSorted));
        }
        SorterLogger.logger.log(Level.FINE,  (arrayToBeSorted[i] + " <= "+ arrayToBeSorted[i + 1])+ " ,so their " +
                "positions" +
                " are " +
                "unchanged.");
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}