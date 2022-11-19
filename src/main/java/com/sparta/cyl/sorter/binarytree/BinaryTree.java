package com.sparta.cyl.sorter.binarytree;

import com.sparta.cyl.logging.CustomLoggerConfiguration;
import com.sparta.cyl.logging.SorterLogger;
import com.sparta.cyl.sorter.Sorter;
import com.sparta.cyl.view.DisplayManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTree {

    private static final Logger logger = Logger.getLogger("TreeSort-logger");
    private Node rootNode = null;
    private int nodeCount = 1;
    //couldn't figure out how to convert the value to an array inside "treeSort" method
   // So I had to create a global array to store the value. Should have a better approach.



    public BinaryTree() {
        SorterLogger.logger.log(Level.INFO, "--------------------Run Tree Sort--------------------");
    }
    public BinaryTree(int[] arr) {
        this.rootNode = new Node(arr[0]);
        addElements(arr);
    }


//    public int[] runSorter(int[] unsortedArray){
//        CustomLoggerConfiguration.configureLogger(SorterLogger.logger);
//        BinaryTree tree = new BinaryTree(unsortedArray);
//        return getArray(tree);
//
//    }
//
//    public int[] getArray(BinaryTree tree){
//        int[] treeToArray = new int[tree.nodeCount];
//        long startTime = System.nanoTime();
//        treeSort(tree.rootNode, treeToArray);
//        long endTime = System.nanoTime();
//        timer(endTime-startTime);
//        return treeToArray;
//    }
//
//    private void treeSort(Node node, int[] arr) {
//        if (node == null)
//            return;
//        treeSort(node.getLeftChild(), arr);
//        arr[indexForTreeToArray++] = node.getValue();
//        SorterLogger.logger.log(Level.INFO,
//                node.getValue() + " is stored in array" );
//        treeSort(node.getRightChild(), arr);
//    }


//    @Override
//    public void timer(long timeElapsed){
//        DisplayManager.printTime(this, timeElapsed);
//    }
//
    private void addElements(int[] unsortedArray) {
        for (int i = 1; i < unsortedArray.length; i++){
            addElement(unsortedArray[i]);
        }
    }


    private void addElement(int element){
        addNodeToTree(rootNode, element);
        nodeCount++;
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

    public Node getRootNode() {
        return rootNode;
    }

    public int getNodeCount() {
        return nodeCount;
    }


    @Override
    public String toString() {
        return "Binary Tree Sort";
    }


    static class Node {
        private final int value;
        private Node leftChild;
        private Node  rightChild;

        private Node(int value) {
            this.value = value;
        }

        private void setLeftChild(Node  leftChild) {
            this.leftChild = leftChild;
        }

        private void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        int getValue() {
            return value;
        }

        Node getLeftChild()  {
            return leftChild;
        }

        Node  getRightChild() {
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
