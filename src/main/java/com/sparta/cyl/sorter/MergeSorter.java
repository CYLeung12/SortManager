package com.sparta.cyl.sorter;

import com.sparta.cyl.logging.CustomLoggerConfiguration;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSorter implements Sorter {
    private static final Logger logger = Logger.getLogger("MergeSort-logger");


    @Override
    public int[] runSorter(int[] unsortedArray){
        CustomLoggerConfiguration.configureLogger(logger);

        int[] sortedArray = mergeSort(unsortedArray);
        return sortedArray;
    }

    private static int[] mergeSort(int[] arrayToBeSorted) {
        int arrayLen = arrayToBeSorted.length;

        if (arrayLen < 2)
            return arrayToBeSorted;

        int mid = arrayLen / 2;

        int[] leftArray = new int[mid];
        int[] rightArray = new int[arrayLen - mid];

        int rightArrayStart = 0;
        for (int i = 0; i < mid; i++){
            leftArray[i] = arrayToBeSorted[i];
            logger.log(Level.FINE, "At "+ i + " iteration, leftArray:"+ Arrays.toString(leftArray));
        }
        for (int i = mid; i < arrayLen; i++){
            rightArray[rightArrayStart] = arrayToBeSorted[i];
            logger.log(Level.FINE, "At "+ i + " iteration, rightArray:"+ Arrays.toString(rightArray));
            rightArrayStart++;
        }


        mergeSort(leftArray);
        mergeSort(rightArray);
        return merge(leftArray, rightArray, arrayToBeSorted);

    }
    private static int[] merge(int[] leftArray, int[] rightArray, int[] sortedArray){
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mergedArrayIndex = 0;

        while (leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize){


            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]){
                sortedArray[mergedArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            }else {
                sortedArray[mergedArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            mergedArrayIndex++;
        }

        while (leftArrayIndex < leftArraySize){
            sortedArray[mergedArrayIndex] = leftArray[leftArrayIndex];
            mergedArrayIndex++;
            leftArrayIndex++;
        }

        while (rightArrayIndex < rightArraySize){
            sortedArray[mergedArrayIndex] = rightArray[rightArrayIndex];
            mergedArrayIndex++;
            rightArrayIndex++;
        }

        return sortedArray;


    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}


