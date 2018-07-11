package sortingalgorithms;

import cnode.CNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MergeSort extends AbstractSort {

  private CNode[] tmp;

  private ArrayList<Transition> merge(CNode[] arr, int p, int q, int r) {
    ArrayList<Transition> transitions = new ArrayList<>();

    List<CNode> tmpList = new ArrayList<>();

    for (int i = p; i <= r; i++) {
      tmp[i] = arr[i];
      tmpList.add(tmp[i]);
    }

    int i = p;
    int j = q + 1;
    int k = p;

    while (i <= q && j <= r) {
      if (tmp[i].getValue() <= tmp[j].getValue()) {
        arr[k++] = tmp[i++];
      } else {
        arr[k++] = tmp[j++];
      }
    }

    while (i <= q) {
      arr[k++] = tmp[i++];
    }

    while (j <= r) {
      arr[k++] = tmp[j++];
    }

    transitions.add(colorCNode(tmpList, SELECT_COLOR));

    ParallelTransition pt = new ParallelTransition(); 

    for (int x = p; x <= r; x++) {
      for (int y = p; y <= r; y++) {
        if (tmp[x].equals(arr[y])) {
          pt.getChildren().add(tmp[x].moveX(DX * (y - x)));
        }
      }
    }

    transitions.add(pt);
    transitions.add(colorCNode(tmpList, SELECT_COLOR));

    return transitions;
  }

  private ArrayList<Transition> mergeSort(CNode[] arr, int p, int r) {
    ArrayList<Transition> transitions = new ArrayList<>();

    if (p < r) {
      int q = (p + r) / 2;
      transitions.addAll(mergeSort(arr, p, q));
      transitions.addAll(mergeSort(arr, q + 1, r));
      transitions.addAll(merge(arr, p, q, r));
    }

    return transitions;
  }

  @Override
  public ArrayList<Transition> startSort(CNode[] arr) {
    ArrayList<Transition> transitions = new ArrayList<>();

    this.tmp = new CNode[arr.length];

    transitions.addAll(mergeSort(arr, 0, arr.length - 1));

    transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));

    return transitions;
  }

}
