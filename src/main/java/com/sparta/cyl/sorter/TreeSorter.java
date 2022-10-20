package com.sparta.cyl.sorter;

import com.sparta.cyl.display.DisplayManager;

import java.util.ArrayList;

public class TreeSorter implements Sorter {
    private Node rootNode = null;
   //couldn't figure out how to convert the inorder traversal to an array in "treeSort" method
   // So I created a global arraylist to store the value. Not a good approach.
    private static ArrayList<Integer> treeToArray = new ArrayList<Integer>();

    public TreeSorter() {}
    public TreeSorter(int element) {  //can't have a tree without a root node
        this.rootNode = new Node(element);
    }

    @Override
    public void runSorter(){
        int[] unsortedArray = {45,3,8,7,19,10};
        DisplayManager.printUnsorrtedArray(unsortedArray);
        TreeSorter tree = new TreeSorter(unsortedArray[0]);
        tree.addElements(unsortedArray);
        treeSort(tree.rootNode, unsortedArray,0);
        int[] sortedArray = treeToArray.stream().mapToInt(i->i).toArray();
    }

    private void addElements(int[] unsortedArray) {
        for (int i = 1; i < unsortedArray.length; i++){
            addElement(unsortedArray[i]);
        }
    }


    private static void treeSort(Node node, int[] arr, int index) {
        if (node == null)
            return;

        treeSort(node.getLeftChild(), arr, index);
        treeToArray.add(node.getValue());
        treeSort(node.getRightChild(), arr, index);
    }

    private void addElement(int element){
        addNodeToTree(rootNode, element);
    }

    //add node to the tree
    private Node addNodeToTree(Node node, int element){
        if (element <= node.getValue()){   //i want to be the left child
            if(node.isLeftChildEmpty()){  //is there room for me?
                node.setLeftChild(new Node(element));  //i am now the left child
            }
            else {
                addNodeToTree(node.getLeftChild(), element);  //this is where the recursion happens
            }
        } else if (element > node.getValue()){
            if (node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
            }
            else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
        return node;
    }

    private boolean findElement(int element){
        Node node = findNote(element);
        if (node != null){
            return true;
        }
        else return false;
    }

    private Node findNote(int element){
        Node node = rootNode;
        while (node != null){
            if (element == node.getValue())
                return node;
            if (element < node.getValue()){
                node = node.getLeftChild();
            }else if (element > node.getValue()){
                node = node.getRightChild();
            }
        }
        return null;
    }

    private class Node {
        private final int value;
        private TreeSorter.Node leftChild;  //Object type so can be null
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
