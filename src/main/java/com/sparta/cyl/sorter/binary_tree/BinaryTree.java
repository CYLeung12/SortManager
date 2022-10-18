package com.sparta.cyl.sorter.binary_tree;

import com.sparta.cyl.display.DisplayManager;
import com.sparta.cyl.start.ArrayLoader;

import java.util.Arrays;

public class BinaryTree {

    //public method for using the tree
    //private methods for helping (hard work)
    //hiding the node - elements are the numbers in the nodes
    private final Node rootNode;

    public BinaryTree(int element) {  //can't have a tree without a root node
        this.rootNode = new Node(element);
    }

    public static void run(){
        int[] unsortedArray = ArrayLoader.generateArray();
        DisplayManager.printUnsorrtedArray(unsortedArray);
        BinaryTree tree = new BinaryTree(unsortedArray[0]);
        tree.addElements(unsortedArray);
        System.out.println(Arrays.toString(tree.treeSort(tree.rootNode)));


    }

    private void addElements(int[] unsortedArray) {
        for (int i = 1; i < unsortedArray.length; i++){
            addElementToTree(unsortedArray[i]);
        }
    }

    public int getNumberOfElement(Node node){
        if (node == null)
            return 0;
        else {
            return 1 + getNumberOfElement(node.getLeftChild()) + getNumberOfElement(node.getRightChild());
        }
    };

    public int[] treeSort(Node node){
        int element = 0;
        int[] test = new int[4];
        int s = 0;

       if (node != null){
           treeSort(node.getLeftChild());
           element = node.getValue();
           System.out.println(element);
           test[s] = element;
           s++;
           treeSort(node.getRightChild());
       }
       return test;



    }



    public void addElementToTree(int element){
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


}
