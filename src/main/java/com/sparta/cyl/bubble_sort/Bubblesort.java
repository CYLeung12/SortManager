//package com.sparta.cyl.bubblesort;
//import java.util.Arrays;
//import java.util.Scanner;
//
////printArray(numbers);
//public class Bubblesort implements Inputable, Printable{
//    public static void start(){
//        Bubblesort Bubblesort1 = new Bubblesort();
//
//        int[] unsortedNumber = Bubblesort1.userInput();
//        System.out.println("The original array:");
//        Bubblesort1.print(unsortedNumber);
//        int[] sortedNumber = sort(unsortedNumber);
//        System.out.println("The sorted array:");
//        Bubblesort1.print(sortedNumber);
//
//    }
//
//    public static int[] sort(int[] unsortedArray) {
//
//        for (int c = 0; c < unsortedArray.length ; c++) {
//            for (int i = 0; i < unsortedArray.length - 1 - c ; i++) {
//                int temValue = unsortedArray[i+1];
//                swap(unsortedArray, i, temValue);
//            }
//}
//
//        return unsortedArray;
//
//    }
//
//    public static void swap(int[] numbers, int i, int temValue) {
//        if (numbers[i] > numbers[i + 1]) {
//            numbers[i + 1] = numbers[i];
//            numbers[i] = temValue;
//        }
//    }
//
//    @Override
//    public int[] userInput() {
//
//
//        Scanner input =new Scanner(System.in);
//        System.out.println("Enter the number of elements you want to sort");
//        int arraySize = input.nextInt();
//        int[] arrayForBubblesort = new int[arraySize];
//
//        for (int i = 0; i <arraySize;i++){
//            System.out.println("Enter the " + (i+1) + " number of the array:");
//            arrayForBubblesort[i] = input.nextInt();
//        }
//
//        return arrayForBubblesort;
//    }
//
//    @Override
//    public void print(int[] numberArray) {
//            System.out.println(Arrays.toString(numberArray));
//
//    }
//
//}
//
//
