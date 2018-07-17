import cnode.CNode;
import view.AnimationController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {

    AnimationController animationController = new AnimationController();
    animationController.setStyle("-fx-background-color: #1c1c1c");

    Scene scene = new Scene(animationController,
                            AnimationController.WINDOW_WIDTH,
                            AnimationController.WINDOW_HEIGHT);

    stage.setTitle("Visual Sorting Algorithms");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
