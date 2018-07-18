# Visual Sorting Algorithms

![HeapSortDemo](https://raw.githubusercontent.com/chriszq/VisualSortingAlgorithms/assets/HeapSort_demo.gif "Heap Sort Demo")

Sorting algoritms animated using JavaFX. The actual sorting speed is not necessarily correlated with how long it takes to animate the algorithm, for example sometimes it could show numbers being swapped one by one or it could show a group of numbers moving simultaneously.

## Available algorithms
- Bubble sort
- Selection sort
- Insertion sort
- Merge sort
- Quicksort
- Heap sort

## Adding a new sorting algorithm
This is quite straightforward and just requires putting together a list of types extending `Transition`. Each of these should record how you want to present the animations in each step (or bundling multiple steps into a single `ParallelTransition`). Then it's just a matter of playing back all of these objects in a single `SequentialTransition`.

## Prerequisites
Java 8 or higher.
