package view;

import cnode.CNode;
import util.RandomCNodes;
import sortingalgorithms.*;

import javafx.animation.SequentialTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AnimationController extends BorderPane {

  public static final int WINDOW_WIDTH = 800;
  public static final int WINDOW_HEIGHT = 500;

  public static final int XGAP = 10;
  public static int NO_OF_CNODES = 40;
  public static final int BUTTONROW_BOUNDARY = 100;

  private static AbstractSort abstractSort;

  private Pane display;
  private HBox buttonRow;

  private Button sortButton;
  private Button randomButton;
  private Button mergeButton;
  private Button heapButton;
  {
    sortButton = new Button("Sort");
    randomButton = new Button("Random numbers");
    mergeButton = new Button("select merge sort");
    heapButton = new Button("select heap sort");
  }

  public AnimationController() {
    this.display = new Pane();
    this.buttonRow = new HBox();

    this.setCenter(display);
    this.setBottom(buttonRow);

    buttonRow.getChildren().add(sortButton);
    buttonRow.getChildren().add(randomButton);
    buttonRow.getChildren().add(mergeButton);
    buttonRow.getChildren().add(heapButton);

    RandomCNodes randomCNodes = new RandomCNodes();
    RandomCNodes.randomCNodes();
    display.getChildren().addAll(Arrays.asList(randomCNodes.getCNodes()));

    sortButton.setOnAction(event -> {
      sortButton.setDisable(true);
      randomButton.setDisable(true);
      SequentialTransition sq = new SequentialTransition();

      //sq.getChildren().addAll(new BubbleSort().startSort(randomCNodes.getCNodes()));
      //sq.getChildren().addAll(new SelectionSort().startSort(randomCNodes.getCNodes()));
      //sq.getChildren().addAll(new InsertionSort().startSort(randomCNodes.getCNodes()));
      //sq.getChildren().addAll(new MergeSort().startSort(randomCNodes.getCNodes()));
      //sq.getChildren().addAll(new QuickSort().startSort(randomCNodes.getCNodes()));
      //sq.getChildren().addAll(new HeapSort().startSort(randomCNodes.getCNodes()));
      sq.getChildren().addAll(abstractSort.startSort(randomCNodes.getCNodes()));

      sq.setOnFinished(e -> {
        sortButton.setDisable(false);
        randomButton.setDisable(false);
      });
      sq.play();
    });

    randomButton.setOnAction(event -> {
      display.getChildren().clear();

      RandomCNodes.randomCNodes();
      display.getChildren().addAll(Arrays.asList(randomCNodes.getCNodes()));
      System.out.println("placeoholder text!!!");
    });

    mergeButton.setOnAction(event ->{
      abstractSort = new MergeSort(); 
      System.out.println("turning abstract sort into merge sort");
    });

    heapButton.setOnAction(event ->{
      abstractSort = new HeapSort(); 
      System.out.println("turning abstract sort into heap sort");
    });
  }

}
