package com.sparta.cyl.start;

import com.sparta.cyl.display.DisplayManager;
import com.sparta.cyl.exception.ArraySizeLessThanZeroException;

import java.util.Arrays;
import java.util.Random;

public class ArrayLoader {

   public static int[] generateArray(){
       int arraySize = DisplayManager.getUserInput();

       Random random = new Random();

        int[] unsortedArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            unsortedArray[i] = random.nextInt(1001);
        }
        return unsortedArray;
    }
}

