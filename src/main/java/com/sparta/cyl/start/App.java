package com.sparta.cyl.start;

import com.sparta.cyl.display.DisplayManager;
import com.sparta.cyl.sorter.Bubblesorter;
import com.sparta.cyl.sorter.Sorter;
import com.sparta.cyl.sorter.binary_tree.TreeSorter;

public class App
{
    public static void main( String[] args )
    {
        Sorter sorter = SorterFactory.getSorter(DisplayManager.menu());
        sorter.run();
    }
}
