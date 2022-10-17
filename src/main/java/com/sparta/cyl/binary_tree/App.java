package com.sparta.cyl.binary_tree;

public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(5);
        tree.addElementToTree(4);
        tree.addElementToTree(34);
        tree.addElementToTree(18);
        tree.addElementToTree(3);
        tree.addElementToTree(1);
        tree.addElementToTree(3);

        System.out.println(tree.findElement(18));
        System.out.println(tree.findElement(12));
    }
}
