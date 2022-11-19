package com.sparta.cyl.view;

import com.sparta.cyl.exception.ArraySizeLessThanZeroException;
import com.sparta.cyl.exception.SwitchChoiceInvalidException;
import com.sparta.cyl.sorter.Sorter;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayManager {
    static Scanner input =new Scanner(System.in);

    public static int getUserInput(){
        int arraySize = 0;

        while (true) {
            System.out.println("Please enter the length of the number array.");
            try {
                arraySize = input.nextInt();
                input.nextLine();
                if (arraySize < 1)
                   throw new ArraySizeLessThanZeroException("The length must be larger or equal than 1.");
                else break;
            } catch (InputMismatchException d) {
                System.out.println("Invalid input, please try again.");
                input.nextLine();
            } catch (ArraySizeLessThanZeroException e){
                System.out.println("The length must be larger or equal than 1.");
            }
        }
            return arraySize;
        }

    public static void printUnsortedArray(int[] unsortedArray, Sorter sorter){
        System.out.println("The sorting will use " + sorter + ".");
        System.out.println("The original array:");
        System.out.println(Arrays.toString(unsortedArray));

    }
    public static void printSortedArray(int[] sortedArray){
        System.out.println("The sorted array:");
        System.out.println(Arrays.toString(sortedArray));

    }

    public static void printTime(Sorter sorter, long timeElapsed){
        System.out.println(("\n----Result----\n" + sorter + " took " + timeElapsed + " nanoseconds to sort the array" +
                "."));
    }


    public static int menu(){
        int menuInput = 0;
        while (true) {
            System.out.println("Please select a sort method (enter 1, 2 or 3)");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Binary Tree Sort");

            try {
                menuInput = input.nextInt();
                input.nextLine();
                if (menuInput < 1 || menuInput > 3){
                    throw new SwitchChoiceInvalidException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine();
            } catch (SwitchChoiceInvalidException e){
                System.out.println("Invalid input. Please enter 1, 2 or 3");
            }
        }

        return switch (menuInput) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + menuInput);
        };
    }



}

