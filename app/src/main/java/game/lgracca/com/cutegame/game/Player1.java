package game.lgracca.com.cutegame.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Player1 implements GameObject { // Implements GameObject Interface. Overrides draw and update methods.

  //Instance variables
  private Rect rectangle;
  private int color;

  public Rect getRectangle() {
    return rectangle;
  }

  public Player1(Rect rectangle, int color) { //Constructor that takes in the instance variables
    this.rectangle = rectangle;
    this.color = color;
  }

  @Override
  public void draw(Canvas canvas) {
    Paint paint = new Paint();
    paint.setColor(color);
    canvas.drawRect(rectangle, paint);
  }

  @Override
  public void update() {

  }

  public void update(Point point) { // New update method with a different signature.
    rectangle.set(point.x - rectangle.width()/2, // This point is at the center of the rectangle
        point.y - rectangle.height()/2,
        point.x + rectangle.width()/2, point.y + rectangle.height()/2);
  }
}

