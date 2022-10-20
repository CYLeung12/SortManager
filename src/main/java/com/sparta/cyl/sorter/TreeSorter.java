package com.sparta.cyl.sorter;


import com.sparta.cyl.logging.CustomLoggerConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreeSorter implements Sorter {
    private static final Logger logger = Logger.getLogger("TreeSort-logger");
    private Node rootNode = null;
    //couldn't figure out how to convert the inorder traversal to an array in "treeSort" method
   // So I created a global List to store the value. Not a good approach.
    private static List<Integer> treeToArray;

    public TreeSorter() {}
    public TreeSorter(int element) {  //can't have a tree without a root node
        this.rootNode = new Node(element);
    }


    public int[] runSorter(int[] unsortedArray){
        CustomLoggerConfiguration.configureLogger(logger);

        treeToArray = new ArrayList<Integer>();
        TreeSorter tree = new TreeSorter(unsortedArray[0]);
        tree.addElements(unsortedArray);
        treeSort(tree.rootNode, unsortedArray);
        int[] sortedArray = treeToArray.stream().mapToInt(i->i).toArray();   //make the output format aligned with
        // other sorters as Array instead of ArrayList
        return sortedArray;
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
        logger.log(Level.INFO, "Node value: " + node.getValue());
        logger.log(Level.WARNING, "Find a better way to put the value into an array");
        treeToArray.add(node.getValue());
        treeSort(node.getRightChild(), arr);
    }

    private void addElement(int element){
        addNodeToTree(rootNode, element);
    }

    private void addNodeToTree(Node node, int element){
        logger.log(Level.INFO, "Node: " + node.getValue() + "; element: " + element);
        if (element <= node.getValue()){
            if(node.isLeftChildEmpty()){
                node.setLeftChild(new Node(element));
            }
            else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()){
            if (node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
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

    public List<Integer> getTreeToArray() {
        return treeToArray;
    }

    private class Node {
        private final int value;
        private TreeSorter.Node leftChild;
        private TreeSorter.Node  rightChild;

        public Node(int value) {
            this.value = value;
        }

        public void setLeftChild(TreeSorter.Node  leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(TreeSorter.Node rightChild) {
            this.rightChild = rightChild;
        }

        public int getValue() {
            return value;
        }

        public TreeSorter.Node getLeftChild()  {
            return leftChild;
        }

        public TreeSorter.Node  getRightChild() {
            return rightChild;
        }

        public boolean isLeftChildEmpty(){
            if (leftChild == null)
                return true;
            else return false;
        }

        public boolean isRightChildEmpty(){
            if (rightChild == null)
                return true;
            else  return false;
        }
    }


}
