# Sort Manager

This is a Java program project built during my training at Sparta Global Academy. It allows users to sort a randomised 
array with different sort algorithms. This project demonstrates some basic Java knowledge I have acquired from the 
first three weeks of the Spartan training, including core Java, software testing, logging, design pattern and SOLID 
principles.

## Usage

1. Run the main method on App.java
2. User will be presented a number of sort algorithms
```
Please select a sort method (enter 1, 2 or 3)
1. Bubble Sort
2. Merge Sort
3. Binary Tree Sort
```
3. Enter the choice via the command line
4. Enter the length of an array
5. An integer array will be randomly generated (value between 0 to 1000) 
6. The array will be sorted with the chosen sort algorithm
7. The sorting result and time taken will be displayed
```
The sorting will use Bubble Sort.
The original array:
[889, 646, 599, 914, 432, 254]

----Result----
Bubble Sort took 20618874 nanoseconds to sort the array.
The sorted array:
[254, 432, 599, 646, 889, 914]
```

## Program Structure

This program mainly follows the Model-view-controller (MVC) pattern to organise the code. The brief structure is 
described as follows.

### Model: sorter package

Includes the following classes:
* BubbleSorter - consists of methods to execute bubble sort
* MergeSorter - consists of methods to execute merge sort
* TreeSorter - consists of methods to execute binary tree sort
* Sorter - an interface implemented by all sorter

### View: view package

Includes the class:
* DisplayManager - responsible for printing messages, as well as taking and validating user inputs.

### Controller: start package

Includes the following classes:
* App - holds the main method
* SorterFactory - has factory method to return an sorter object
* SortLoader - for kick-starting the sorting and generating a randomised array


Apart from the three packages mentioned above, this program also has two packages holding the helping tools: 
"logging" package and "exception" package.