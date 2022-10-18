package com.sparta.cyl.start;

import com.sparta.cyl.sorter.Bubblesorter;
import com.sparta.cyl.sorter.MergeSorter;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        int[] test = {101, 34234, 233, 34,1,546,56,87};
        //[34, 1, 56, 87, 546]
//            MergeSorter.run();
        Bubblesorter.run();
    }
}
