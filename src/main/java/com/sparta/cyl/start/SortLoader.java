package com.sparta.cyl.start;

import com.sparta.cyl.logging.CustomLoggerConfiguration;
import com.sparta.cyl.logging.SorterLogger;
import com.sparta.cyl.view.DisplayManager;
import com.sparta.cyl.sorter.Sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortLoader {

   public static void start(){
       CustomLoggerConfiguration.configureLogger(SorterLogger.logger);
       int userChoice = DisplayManager.menu();
       Sorter sorter = SorterFactory.getSorter(userChoice);
       int arraySize = DisplayManager.getUserInput();
       int[] unsortedArray = generateArray(arraySize);
       DisplayManager.printUnsortedArray(unsortedArray, sorter);
       int[] sortedArray = sorter.runSorter(unsortedArray);
       DisplayManager.printSortedArray(sortedArray);
       SorterLogger.logger.log(Level.INFO, "Sorted array: " + Arrays.toString(sortedArray));
   }


    public static int[] generateArray(int arraySize){
       Random random = new Random();

        int[] unsortedArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            unsortedArray[i] = random.nextInt(1001);
        }
        SorterLogger.logger.log(Level.INFO, "Random array to be sorted: " + Arrays.toString(unsortedArray));
        return unsortedArray;

    }


}

