package sortingalgorithms;

import cnode.CNode;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class BubbleSort extends AbstractSort {

  private boolean swapped;
  private ArrayList<Transition> transitions;

  public BubbleSort() {
    this.transitions = new ArrayList<>();
  }

  private ArrayList<Transition> compareCNode(CNode[] arr, int a, int b) {
    ArrayList<Transition> transitions = new ArrayList<>();

    transitions.add(colorCNode(arr, SELECT_COLOR, a, b));

    if (arr[a].getValue() > arr[b].getValue()) {
      transitions.add(swap(arr, a, b));
      swapped = true;
    } 

    transitions.add(colorCNode(arr, START_COLOR, a, b));

    return transitions;
  }

  private void bubbleSort(CNode[] arr) {
    for (int i = 0; i < arr.length; i++) {
      swapped = false;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        this.transitions.addAll(compareCNode(arr, j, j + 1));
      }

      if (!swapped) {
        break;
      }
    }

  }

  @Override
  public ArrayList<Transition> startSort(CNode[] arr) {
    bubbleSort(arr);

    this.transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));

    return this.transitions;

  }

}
