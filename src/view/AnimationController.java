package view;

import cnode.CNode;
import util.RandomCNodes;
import sortingalgorithms.*;

import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
  {
    sortButton = new Button("Sort");
    randomButton = new Button("Random");

    choiceBox = new ChoiceBox<>();
  }

  private ChoiceBox<AbstractSort> choiceBox;

  public AnimationController() {
    this.display = new Pane();
    this.buttonRow = new HBox();

    this.setCenter(display);
    this.setBottom(buttonRow);

    buttonRow.getChildren().add(sortButton);
    buttonRow.getChildren().add(randomButton);
    buttonRow.getChildren().add(choiceBox);

    List<AbstractSort> abstractSortList = new ArrayList<>();
    abstractSortList.add(new BubbleSort());
    abstractSortList.add(new SelectionSort());
    abstractSortList.add(new InsertionSort());
    abstractSortList.add(new MergeSort());
    abstractSortList.add(new QuickSort());
    abstractSortList.add(new HeapSort());

    RandomCNodes randomCNodes = new RandomCNodes();
    RandomCNodes.randomCNodes();
    display.getChildren().addAll(Arrays.asList(randomCNodes.getCNodes()));

    sortButton.setOnAction(event -> {
      sortButton.setDisable(true);
      randomButton.setDisable(true);

      abstractSort = choiceBox.getValue();
      SequentialTransition sq = new SequentialTransition();

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
      System.out.println("randoming cnodes...");
    });

    choiceBox.setItems(FXCollections.observableArrayList(
      abstractSortList
    ));

  }

}
