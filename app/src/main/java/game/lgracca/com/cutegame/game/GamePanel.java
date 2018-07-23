package game.lgracca.com.cutegame.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

  private MainThread thread;
  private Rect rect = new Rect();
  private Player1 blob;
  private Point blobPoint;
  private ObstacleManager obstacleManager;
  private boolean playerMoving = false;
  private boolean gameOver = false;
  private long gameOverTime;

  public GamePanel(Context context) { //constructor that takes in context.
    super(context);

    getHolder().addCallback(this);

    thread = new MainThread(getHolder(), this);

    blob = new Player1(new Rect(100, 100, 200, 200 ), Color.MAGENTA);
    blobPoint = new Point(Constants.SCREEN_WIDTH/2, 3 * Constants.SCREEN_HEIGHT/4);
    blob.update(blobPoint);
    obstacleManager = new ObstacleManager(150, 450, 90, Color.WHITE);

    setFocusable(true);
  }

  public void reset() {
    blobPoint = new Point(Constants.SCREEN_WIDTH/2, 3 * Constants.SCREEN_HEIGHT/4);
    blob.update(blobPoint);
    obstacleManager = new ObstacleManager(150, 450, 90, Color.WHITE);
    playerMoving = false;
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    thread = new MainThread(getHolder(), this); // Restarting MainThread.
    thread.setRunning(true); // Make the game loop to start running.
    thread.start(); // Method inside the thread class which the main class will extend.

  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    boolean retry = true; // Stop the current thread.
    while(true) {
      try {
        thread.setRunning(false); // Set running to false to stop the game loop.
        thread.join(); // Will finish running the thread then terminate it.
      } catch (Exception e) { e.printStackTrace(); } //If there's an error the exception will catch it insdead of the game crashing.
      retry = false;                                 //Then it's going to print a stat trace in the debugger to see what went wrong.
    }
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) { //Will manage all the touch inputs.
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        if (!gameOver && blob.getRectangle().contains((int)event.getX(), (int)event.getY()))
          playerMoving = true;
        if (gameOver && System.currentTimeMillis() - gameOverTime >= 2000) {
          reset();
          gameOver = false;
        }
        break;
      case MotionEvent.ACTION_MOVE:
        if (!gameOver && playerMoving)
          blobPoint.set((int)event.getX(), (int)event.getY());
        break;
      case MotionEvent.ACTION_UP:
        playerMoving = false;
        break;
    }
    return true;
//    return super.onTouchEvent(event);
  }

  public void update() { // Will update the game frame by frame.
    if (!gameOver) {
      blob.update(blobPoint);
      obstacleManager.update();

      if (obstacleManager.Collision(blob)) {
        gameOver = true;
        gameOverTime = System.currentTimeMillis();
      }
    }
  }

  @Override
  public void draw(Canvas canvas) { // Will display the game.
    super.draw(canvas);

    canvas.drawColor(Color.BLACK);

    blob.draw(canvas);
    obstacleManager.draw(canvas);

    if (gameOver) {
      Paint paint = new Paint();
      paint.setTextSize(200);
      paint.setFakeBoldText(true);
      paint.setColor(Color.YELLOW);
      drawCenterText(canvas, paint, "Game Over");
    }
  }

  private void drawCenterText(Canvas canvas, Paint paint, String text) {
    paint.setTextAlign(Align.LEFT);
    canvas.getClipBounds(rect);
    int cHeight = rect.height();
    int cWidth = rect.width();
    paint.getTextBounds(text, 0, text.length(), rect);
    float x = cWidth / 2f - rect.width() / 2f - rect.left;
    float y = cHeight / 2f + rect.height() / 2f - rect.left;
    canvas.drawText(text, x, y, paint);
  }
}
