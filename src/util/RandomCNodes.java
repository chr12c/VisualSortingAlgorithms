package util;

import cnode.CNode;
import view.AnimationController;

import java.util.Random;

import javafx.scene.paint.Color;

public class RandomCNodes {

  private static CNode[] cnodes;

  public RandomCNodes() {
    this.cnodes = new CNode[AnimationController.NO_OF_CNODES];
  }

  public static CNode[] getCNodes() {
    return cnodes;
  }

  public static void randomCNodes() {
    Random r = new Random();

    for (int i = 0; i < cnodes.length; i++) {
      cnodes[i] = new CNode(1 + r.nextInt(cnodes.length));
      cnodes[i].setX(i * (AnimationController.WINDOW_WIDTH / cnodes.length));
      cnodes[i].setFill(Color.CRIMSON);//define START_COLOR in AnimationController?
      setCNodeDim(cnodes[i]);
    }

  }

  private static void setCNodeDim(CNode cnode) {
    cnode.setWidth(AnimationController.WINDOW_WIDTH / cnodes.length -
                    AnimationController.XGAP);
    cnode.setHeight(((AnimationController.WINDOW_HEIGHT - AnimationController.BUTTONROW_BOUNDARY) 
                      / cnodes.length)*
                      cnode.getValue());
  }
}
