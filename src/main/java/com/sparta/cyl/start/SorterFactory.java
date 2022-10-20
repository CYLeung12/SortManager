package com.sparta.cyl.start;

import com.sparta.cyl.sorter.Bubblesorter;
import com.sparta.cyl.sorter.MergeSorter;
import com.sparta.cyl.sorter.Sorter;
import com.sparta.cyl.sorter.binary_tree.TreeSorter;

public class SorterFactory {
    public static Sorter getSorter(int sorterType){
        return switch (sorterType){
            case 1 -> new Bubblesorter();
            case 2 -> new MergeSorter();
            case 3 -> new TreeSorter();
            default -> null;
        };
    }
}
