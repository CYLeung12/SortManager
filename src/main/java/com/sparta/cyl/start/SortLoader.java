package com.sparta.cyl.start;

import com.sparta.cyl.display.DisplayManager;
import com.sparta.cyl.logging.CustomLoggerConfiguration;
import com.sparta.cyl.sorter.Sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortLoader {
    private static final Logger logger = Logger.getLogger("SortLoader-logger");

   public static void start(){
       int userChoice = DisplayManager.menu();
       Sorter sorter = SorterFactory.getSorter(userChoice);
       int arraySize = DisplayManager.getUserInput();
       int[] unsortedArray = generateArray(arraySize);
       DisplayManager.printUnsortedArray(unsortedArray, sorter);
       long startTime = System.nanoTime();
       int[] sortedArray = sorter.runSorter(unsortedArray);
       long endTime = System.nanoTime();
       DisplayManager.printResult(sortedArray, sorter, endTime-startTime);
   }


    public static int[] generateArray(int arraySize){
       Random random = new Random();

        int[] unsortedArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            unsortedArray[i] = random.nextInt(1001);
        }
        return unsortedArray;

    }


}

