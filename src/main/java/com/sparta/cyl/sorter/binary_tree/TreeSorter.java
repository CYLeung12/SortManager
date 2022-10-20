package com.sparta.cyl.sorter.binary_tree;

import com.sparta.cyl.display.DisplayManager;
import com.sparta.cyl.sorter.Sorter;
import com.sparta.cyl.start.ArrayLoader;

public class TreeSorter implements Sorter {
    private Node rootNode = null;
    public TreeSorter() {

    }
    public TreeSorter(int element) {  //can't have a tree without a root node
        this.rootNode = new Node(element);
    }

    @Override
    public void run(){
        int[] unsortedArray = ArrayLoader.generateArray();
        DisplayManager.printUnsorrtedArray(unsortedArray);
        TreeSorter tree = new TreeSorter(unsortedArray[0]);
        tree.addElements(unsortedArray);
        tree.treeSort(tree.rootNode);
    }

    private void addElements(int[] unsortedArray) {
        for (int i = 1; i < unsortedArray.length; i++){
            addElement(unsortedArray[i]);
        }
    }
    
    public int getNumberOfElements(Node node){
        if (node == null)
            return 0;
        else {
            return 1 + getNumberOfElements(node.getLeftChild()) + getNumberOfElements(node.getRightChild());
        }
    };

    public int[] treeSort(Node node){
        int element = 0;
        int[] test = new int[4];


       if (node != null){
           treeSort(node.getLeftChild());
           element = node.getValue();
           System.out.println(element);
           treeSort(node.getRightChild());
       }
       return test;
    }




    public void addElement(int element){
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

    public boolean findElement(int element){
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


    public class Node {
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
