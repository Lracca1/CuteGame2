package game.lgracca.com.cutegame.game;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/**
 * GameActivity class extends the app Activity. It makes the game screen to full screen.
 */
public class GameActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN); //Getting rid of the toolbar at the top and making it full screen.
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    Constants.SCREEN_WIDTH = displayMetrics.widthPixels;
    Constants.SCREEN_HEIGHT = displayMetrics.heightPixels;

    setContentView(new GamePanel(this));
  }
}
