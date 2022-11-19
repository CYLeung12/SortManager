package com.sparta.cyl.sorter.binarytree;

import com.sparta.cyl.logging.CustomLoggerConfiguration;
import com.sparta.cyl.logging.SorterLogger;
import com.sparta.cyl.sorter.Sorter;
import com.sparta.cyl.view.DisplayManager;

import java.util.logging.Level;

public class BinaryTreeSorter implements Sorter {
    public int[] runSorter(int[] unsortedArray){
        CustomLoggerConfiguration.configureLogger(SorterLogger.logger);
        BinaryTree tree = new BinaryTree(unsortedArray);
        return getArray(tree);
    }

    public int[] getArray(BinaryTree tree){
        int[] treeToArray = new int[tree.getNodeCount()];
        long startTime = System.nanoTime();
        treeSort(tree.getRootNode(), treeToArray);
        long endTime = System.nanoTime();
        timer(endTime-startTime);
        return treeToArray;
    }

    private static int index =0;

    private void treeSort(BinaryTree.Node node, int[] arr) {
        if (node == null)
            return;
        treeSort(node.getLeftChild(), arr);
        arr[index++] = node.getValue();
        SorterLogger.logger.log(Level.INFO,
                node.getValue() + " is stored in array" );
        treeSort(node.getRightChild(), arr);
    }

    @Override
    public void timer(long timeElapsed){
        DisplayManager.printTime(this, timeElapsed);
    }

    @Override
    public String toString() {
        return "Binary Tree Sort";
    }


}
