package game.lgracca.com.cutegame.game;

import android.graphics.Canvas;

public interface GameObject { // Contains methods to pass on to other classes.

  public void draw(Canvas canvas);
  public void update();
}
