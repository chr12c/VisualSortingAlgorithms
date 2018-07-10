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
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AnimationController extends BorderPane {

  public static final int WINDOW_WIDTH = 800;
  public static final int WINDOW_HEIGHT = 500;
  public static final int XGAP = 10;
  public static final int BUTTONROW_BOUNDARY = 100;

  public static int NO_OF_CNODES = 40;

  private static AbstractSort abstractSort;

  private Pane display;
  private HBox buttonRow;

  private Button sortButton;
  private Button randomButton;
  private ChoiceBox<AbstractSort> choiceBox;

  public AnimationController() {
    this.display = new Pane();
    this.buttonRow = new HBox();

    this.setCenter(display);
    this.setBottom(buttonRow);

    this.sortButton = new Button("Sort");
    this.randomButton = new Button("Random");
    this.choiceBox = new ChoiceBox<>();

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

      abstractSort = choiceBox.getSelectionModel().getSelectedItem();

      SequentialTransition sq = new SequentialTransition();

      sq.getChildren().addAll(abstractSort.startSort(randomCNodes.getCNodes()));

      sq.setOnFinished(e -> {
        randomButton.setDisable(false);
      });

      sq.play();

    });

    randomButton.setOnAction(event -> {
      sortButton.setDisable(false);
      display.getChildren().clear();

      RandomCNodes.randomCNodes();
      display.getChildren().addAll(Arrays.asList(randomCNodes.getCNodes()));
      System.out.println("randoming cnodes...done");
    });

    choiceBox.setItems(FXCollections.observableArrayList(
      abstractSortList
    ));

    //choiceBox.setValue(abstractSortList.get(5));
    choiceBox.getSelectionModel().select(5);

    choiceBox.setConverter(new StringConverter<AbstractSort>() {
      @Override
      public String toString(AbstractSort abstractSort) {
        if(abstractSort == null) {
          return "";
        } else {
          return abstractSort.getClass().getSimpleName();
        }
      }

      @Override
      public AbstractSort fromString(String s) {
        return null;
      }
    });

  }

}
