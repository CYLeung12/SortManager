package com.sparta.cyl.sorter;


import com.sparta.cyl.logging.CustomLoggerConfiguration;
import com.sparta.cyl.logging.SorterLogger;
import com.sparta.cyl.start.SortLoader;
import com.sparta.cyl.view.DisplayManager;

import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreeSorter implements Sorter {
    private static final Logger logger = Logger.getLogger("TreeSort-logger");
    private Node rootNode = null;
    //couldn't figure out how to convert the value to an array inside "treeSort" method
   // So I had to create a global array to store the value. Should have a better approach.
    private static int[] treeToArray;
    private static int indexForTreeToArray;

    public TreeSorter() {
        SorterLogger.logger.log(Level.INFO, "--------------------Run Tree Sort--------------------");

    }
    public TreeSorter(int element) {
        this.rootNode = new Node(element);
    }


    public int[] runSorter(int[] unsortedArray){
        CustomLoggerConfiguration.configureLogger(SorterLogger.logger);

        treeToArray = new int[unsortedArray.length];
        indexForTreeToArray = 0;

        TreeSorter tree = new TreeSorter(unsortedArray[0]);
        tree.addElements(unsortedArray);
        long startTime = System.nanoTime();
        treeSort(tree.rootNode, unsortedArray);
        long endTime = System.nanoTime();
        timer(endTime-startTime);
        return treeToArray;
    }

    @Override
    public void timer(long timeElapsed){
        DisplayManager.printTime(this, timeElapsed);
    }

    private void addElements(int[] unsortedArray) {
        for (int i = 1; i < unsortedArray.length; i++){
            addElement(unsortedArray[i]);
        }
    }

    private static void treeSort(Node node, int[] arr) {
        if (node == null)
            return;
        treeSort(node.getLeftChild(), arr);
        treeToArray[indexForTreeToArray++] = node.getValue();
        SorterLogger.logger.log(Level.INFO,
                node.getValue() + " is stored in array" );
        treeSort(node.getRightChild(), arr);
    }

    private void addElement(int element){
        addNodeToTree(rootNode, element);
    }

    private void addNodeToTree(Node node, int element){
        if (element <= node.getValue()){
            if(node.isLeftChildEmpty()){
                node.setLeftChild(new Node(element));
                SorterLogger.logger.log(Level.INFO,
                        "element " + element + " is put the left of Node " + node.getValue());
            }
            else {

                addNodeToTree(node.getLeftChild(), element);
            }
        } else {
            if (node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
                SorterLogger.logger.log(Level.INFO,
                        "element " + element + " is put the right of Node " + node.getValue());
            }
            else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    @Override
    public String toString() {
        return "Binary Tree Sort";
    }


    private static class Node {
        private final int value;
        private TreeSorter.Node leftChild;
        private TreeSorter.Node  rightChild;

        private Node(int value) {
            this.value = value;
        }

        private void setLeftChild(TreeSorter.Node  leftChild) {
            this.leftChild = leftChild;
        }

        private void setRightChild(TreeSorter.Node rightChild) {
            this.rightChild = rightChild;
        }

        private int getValue() {
            return value;
        }

        private TreeSorter.Node getLeftChild()  {
            return leftChild;
        }

        private TreeSorter.Node  getRightChild() {
            return rightChild;
        }

        private boolean isLeftChildEmpty(){
            return leftChild == null;
        }

        private boolean isRightChildEmpty(){
            return rightChild == null;
        }
    }


}
