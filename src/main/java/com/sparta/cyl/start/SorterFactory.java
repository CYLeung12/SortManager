package com.sparta.cyl.start;

import com.sparta.cyl.sorter.BubbleSorter;
import com.sparta.cyl.sorter.MergeSorter;
import com.sparta.cyl.sorter.Sorter;

import com.sparta.cyl.sorter.binarytree.BinaryTree;
import com.sparta.cyl.sorter.binarytree.BinaryTreeSorter;

import java.util.logging.Logger;

public class SorterFactory {
    public static Sorter getSorter(int sorterType){
        return switch (sorterType){
            case 1 -> new BubbleSorter();
            case 2 -> new MergeSorter();
            case 3 -> new BinaryTreeSorter();
            default -> null;
        };
    }
}
