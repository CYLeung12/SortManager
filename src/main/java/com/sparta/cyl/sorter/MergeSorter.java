package com.sparta.cyl.sorter;

import com.sparta.cyl.logging.CustomLoggerConfiguration;
import com.sparta.cyl.logging.SorterLogger;
import com.sparta.cyl.view.DisplayManager;

import java.util.Arrays;
import java.util.logging.Level;


public class MergeSorter implements Sorter {
    public MergeSorter(){
        SorterLogger.logger.log(Level.INFO, "--------------------Run Merge Sort--------------------");
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

    private static int[] sort(int[] unsortedArray) {
        int arrayLength = unsortedArray.length;
        int midLength = arrayLength / 2;
        int[] newArray = new int[arrayLength];
        int[] leftArray = new int[midLength];
        int[] rightArray = new int[arrayLength - midLength];

        if (arrayLength < 2)
            return unsortedArray;

        for (int i = 0; i < midLength; i++){
            leftArray[i] = unsortedArray[i];
        }

        int rightArrayStart = 0;
        for (int i = midLength; i < arrayLength; i++){
            rightArray[rightArrayStart++] = unsortedArray[i];
        }

        SorterLogger.logger.log(Level.INFO,
                "Split Right Array "+ Arrays.toString(rightArray) + "; Split Left Array "+ Arrays.toString(leftArray));


        return merge(sort(leftArray), sort(rightArray), unsortedArray);
    }

    private static int[] merge(int[] leftArray, int[] rightArray, int[] unsortedArray){
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mergedArrayIndex = 0;

        while (leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize){
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]){
                unsortedArray[mergedArrayIndex++] = leftArray[leftArrayIndex++];
            }else {
                unsortedArray[mergedArrayIndex++] = rightArray[rightArrayIndex++];
            }
        }

        while (leftArrayIndex < leftArraySize){
            unsortedArray[mergedArrayIndex++] = leftArray[leftArrayIndex++];
        }

        while (rightArrayIndex < rightArraySize){
            unsortedArray[mergedArrayIndex++] = rightArray[rightArrayIndex++];
        }
        SorterLogger.logger.log(Level.INFO,
                "Merged array "+ Arrays.toString(unsortedArray));

        return unsortedArray;
    }
    @Override
    public String toString() {
        return "Merge Sort";
    }
}


