package com.sparta.cyl.sorter.binary_tree;

public class BinaryTree {
    //public method for using the tree
    //private methods for helping (hard work)
    //hiding the node - elements are the numbers in the nodes
    private final Node rootNode;

    public BinaryTree(int element) {  //can't have a tree without a root node
        this.rootNode = new Node(element);
    }


    public static void run(){
        int [] test = {12,778,34,2,999};

    }

    public void addElementToTree(int element){
        addNodeToTree(rootNode, element);
    }


    //add node to the tree
    private void addNodeToTree(Node node, int element){
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
