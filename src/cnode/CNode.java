package cnode;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CNode extends Rectangle {

  private int value;

  public CNode(int n) {
    this.value = n;
  }

  public int getValue() {
    return this.value;
  }

  public TranslateTransition moveX(int x) {
    TranslateTransition t = new TranslateTransition();
    t.setNode(this);
    t.setDuration(Duration.millis(100));
    t.setByX(x);

    return t; 
  }

}
