package com.sparta.cyl.display;

import java.util.Arrays;
import java.util.Scanner;

public class DisplayManager {

    public static int getUserInput(){
            Scanner input =new Scanner(System.in);
            System.out.println("Enter the number of elements you want to sort");
            int arraySize = input.nextInt();
            return arraySize;
        }

    public static void printUnsorrtedArray(int[] unsortedArray){
        System.out.println("The original array:");
        System.out.println(Arrays.toString(unsortedArray));

    }
    public static void printSortedArry(int[] sortedArray){
        System.out.println("The sorted array:");
        System.out.println(Arrays.toString(sortedArray));
    }



}

