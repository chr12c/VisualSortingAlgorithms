package util;

import cnode.CNode;
import view.AnimationController;

import java.util.Random;

import javafx.scene.paint.Color;

public class RandomCNodes {

  public RandomCNodes() {

  }

  public static CNode[] randomCNodes(int n) {
    CNode[] arr = new CNode[n];
    Random r = new Random();

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new CNode(1 + r.nextInt(arr.length));
      arr[i].setX(i * (AnimationController.WINDOW_WIDTH / arr.length));
      arr[i].setFill(Color.CRIMSON);
      setCNodeDim(arr[i], arr.length);
    }
    return arr;
 
  }

  private static void setCNodeDim(CNode cnode, int n) {
    cnode.setWidth(AnimationController.WINDOW_WIDTH / n -
                    AnimationController.XGAP);
    cnode.setHeight(((AnimationController.WINDOW_HEIGHT - AnimationController.BUTTONROW_BOUNDARY) 
                      / n) *
                      cnode.getValue());
  }
}
