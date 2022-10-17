package com.sparta.cyl.controller;

import com.sparta.cyl.display.DisplayManager;

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
       System.out.println(Arrays.toString(unsortedArray));
        return unsortedArray;
    }
}

