package com.sparta.cyl.sorter;
import com.sparta.cyl.start.ArrayLoader;
import com.sparta.cyl.display.DisplayManager;

import java.util.Arrays;
import java.util.Scanner;

public class Bubblesorter{
    public static void run(){
        int[] unsortedArray = ArrayLoader.generateArray();
        DisplayManager.printUnsorrtedArray(unsortedArray);
        int[] sortedArray = sort(unsortedArray);
        DisplayManager.printSortedArry(sortedArray);
    }

    private static int[] sort(int[] arrayToBeSorted) {

        for (int c = 0; c < arrayToBeSorted.length ; c++) {
            boolean isSorted = true;
            for (int i = 0; i < arrayToBeSorted.length - 1 - c ; i++) {
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


