package view;

import cnode.CNode;
import sortingalgorithms.*;

import javafx.animation.SequentialTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class AnimationController extends BorderPane {

  public static final int WINDOW_WIDTH = 800;
  public static final int WINDOW_HEIGHT = 500;

  public static final int XGAP = 10;
  public static final int NO_OF_CNODES = 16;
  public static final int BUTTONROW_BOUNDARY = 100;

  private Pane display;
  private HBox buttonRow;

  private Button button;
  {
    button = new Button("monkaS");
  }

  public AnimationController() {
    this.display = new Pane();
    this.buttonRow = new HBox();

    this.setCenter(display);
    this.setBottom(buttonRow);

    buttonRow.getChildren().add(button);

    ArrayList<CNode> cnodes = new ArrayList<>();   

    Random r = new Random(1);

    for (int i = 0; i < NO_OF_CNODES; i++) {
      cnodes.add(new CNode(1 + r.nextInt(16)));
      cnodes.get(i).setWidth(WINDOW_WIDTH / NO_OF_CNODES - XGAP);
      cnodes.get(i).setHeight(((WINDOW_HEIGHT - BUTTONROW_BOUNDARY) / NO_OF_CNODES) * cnodes.get(i).getValue());
      cnodes.get(i).setFill(Color.CRIMSON);
      cnodes.get(i).setX(i * (WINDOW_WIDTH / NO_OF_CNODES));
    }

/*
    for (int i = 0; i < NO_OF_CNODES; i++) {
      cnodes.add(new CNode(NO_OF_CNODES - i));
      cnodes.get(i).setWidth(WINDOW_WIDTH / NO_OF_CNODES - XGAP);
      cnodes.get(i).setHeight(((WINDOW_HEIGHT - BUTTONROW_BOUNDARY) / NO_OF_CNODES) * cnodes.get(i).getValue());
      cnodes.get(i).setFill(Color.CRIMSON);
      cnodes.get(i).setX(i * (WINDOW_WIDTH / NO_OF_CNODES));
    }
*/

    display.getChildren().addAll(cnodes);

    button.setOnAction(event -> {
      SequentialTransition sq = new SequentialTransition();

      //sq.getChildren().addAll(new BubbleSort().startSort(cnodes.toArray(new CNode[cnodes.size()])));
      sq.getChildren().addAll(new SelectionSort().startSort(cnodes.toArray(new CNode[cnodes.size()])));
      //sq.getChildren().addAll(new InsertionSort().startSort(cnodes.toArray(new CNode[cnodes.size()])));
      //sq.getChildren().addAll(new MergeSort().startSort(cnodes.toArray(new CNode[cnodes.size()])));
      //sq.getChildren().addAll(new QuickSort().startSort(cnodes.toArray(new CNode[cnodes.size()])));
      //sq.getChildren().addAll(new HeapSort().startSort(cnodes.toArray(new CNode[cnodes.size()])));

      sq.play();
    });
  }

}
