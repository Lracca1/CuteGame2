package game.lgracca.com.cutegame.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Cream Class consist of code that will let cream appear on the screen randomly.
 * couldn't make it work.
 */
public class Cream {

  private Rect rectangle;
  private int color;
  private Rect rect = new Rect();
  private int creamX; // Stores X pos of our food
  private int creamY; // Stores Y pos of our food

  // Used to determine random position of food
  private final int RANDOMPOSITION = 40;

  public Cream(Rect rect, int green) {
  }

  public void createCream() {

    // Set our food's x & y position to a random position

    int location = (int) (Math.random() * RANDOMPOSITION);
    creamX = ((location * GamePanel.generateViewId()));

    location = (int) (Math.random() * RANDOMPOSITION);
    creamY = ((location * GamePanel.generateViewId()));

    if ((creamX == rect.left) && (creamX == rect.right) &&
        (creamY == rect.top) && (creamY == rect.bottom)) {
      createCream();
    }
  }

  public int getCreamX() {

    return creamX;
  }

  public int getCreamY() {
    return creamY;
  }

  public boolean Collision2(Player1 player) {
    return  Rect.intersects(rectangle,player.getRectangle());
  }
  public void draw(Canvas canvas) {
    Paint paint = new Paint();
    paint.setColor(color);
    canvas.drawRect(rectangle, paint);
  }
}
