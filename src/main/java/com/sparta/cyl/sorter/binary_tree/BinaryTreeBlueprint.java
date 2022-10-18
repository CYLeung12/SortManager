package com.sparta.cyl.sorter.binary_tree;

public interface BinaryTreeBlueprint {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(final int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element); //throws ChildNotFoundException;

    int getRightChild(int element); //throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();


}
