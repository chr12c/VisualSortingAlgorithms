package sortingalgorithms;

import cnode.CNode;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public abstract class AbstractSort {

  final Color START_COLOR = Color.CRIMSON;
  final Color SELECT_COLOR = Color.CYAN;
  final Color SORTED_COLOR = Color.ROYALBLUE;

  ParallelTransition colorCNode(CNode[] arr, Color color, int...a) {
    ParallelTransition pt = new ParallelTransition();
    
    for (int i = 0; i < a.length; i++) {
      FillTransition ft = new FillTransition();
      ft.setShape(arr[a[i]]);
      ft.setToValue(color);
      pt.getChildren().add(ft);
    }
    return pt;
  }

  ParallelTransition colorCNode(List<CNode> list, Color color) {
    ParallelTransition pt = new ParallelTransition();
    
    for (CNode c : list) {
      FillTransition ft = new FillTransition();
      ft.setShape(c);
      ft.setToValue(color);
      pt.getChildren().add(ft);
    }

    return pt;
  }

  ParallelTransition swap(CNode[] arr, int i, int j) {
    ParallelTransition pt = new ParallelTransition();

    int dxFactor = j - i;

    pt.getChildren().addAll(arr[i].moveX(50 * dxFactor), arr[j].moveX(-50 * dxFactor));

    CNode tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;

    return pt;
  }

  abstract ArrayList<Transition> startSort(CNode[] arr);
}
