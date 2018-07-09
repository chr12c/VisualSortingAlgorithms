package sortingalgorithms;

import cnode.CNode;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class SelectionSort extends AbstractSort {

  private static final Color MININDX_COLOR = Color.ORANGE;
  private static final Color NEW_MININDX_COLOR = Color.LIGHTGREEN;

  private ParallelTransition colorCNode(CNode[] arr, int a, int b, Color colorA, Color colorB) {
    ParallelTransition pt = new ParallelTransition();

    pt.getChildren().addAll(colorCNode(arr, colorA, a), colorCNode(arr, colorB, b));

    return pt;
  }

  @Override
  public ArrayList<Transition> startSort(CNode[] arr) {
    ArrayList<Transition> transitions = new ArrayList<>();
    int minIndx;

    for (int i = 0; i < arr.length - 1; i++) {
      minIndx = i;
      transitions.add(colorCNode(arr, NEW_MININDX_COLOR, minIndx));

      for (int j = i + 1; j < arr.length; j++) {
        transitions.add(colorCNode(arr, SELECT_COLOR, j));
        if (arr[j].getValue() < arr[minIndx].getValue()) {
          if (minIndx == i) {
            transitions.add(colorCNode(arr, minIndx, j, MININDX_COLOR, NEW_MININDX_COLOR));
          } else {
            transitions.add(colorCNode(arr, minIndx, j, Color.CRIMSON, NEW_MININDX_COLOR));
          }
          minIndx = j;
        } else {
          transitions.add(colorCNode(arr, START_COLOR, j));
        }
      }

      if (minIndx != i) {
        transitions.add(swap(arr, i, minIndx));
      }

        transitions.add(colorCNode(arr, START_COLOR, i, minIndx));
    }

    transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));

    return transitions;
  }
}
