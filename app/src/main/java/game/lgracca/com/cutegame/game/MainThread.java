package game.lgracca.com.cutegame.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread { //
  public static final int MAX_FPS = 30; // FPS(frames per second) - capping FPS to 30.
  private double averageFPS;            // Storing average FPS.
  private SurfaceHolder surfaceHolder;
  private GamePanel gamePanel;
  private boolean running;
  public static Canvas canvas; // To draw with.

  public void setRunning(boolean running) { //setter for running.
    this.running = running;
  }

  public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) { // Constructor that takes in methods in GamePanel class.
    super();
    this.surfaceHolder = surfaceHolder;
    this.gamePanel = gamePanel;
  }

  @Override
  public void run() { // Run method is the game loop.
    long startTime;
    long timeMillis = 1000/MAX_FPS;
    long waitTime;
    int frameCount = 0;
    long totalTime = 0;
    long targetTime = 1000/MAX_FPS;

    while (running) {
      startTime = System.nanoTime();
      canvas = null;
      try {
        canvas = this.surfaceHolder.lockCanvas();
        synchronized (surfaceHolder) {
          this.gamePanel.update(); //Changes the coordinate location of objects that are being moved every time it is moved.
          this.gamePanel.draw(canvas); //Draws the objects at the right place as it moves.
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally { //Compiles whether everything succeeds or all else fails.
        if (canvas != null) {
          try {
            surfaceHolder.unlockCanvasAndPost(canvas);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
        timeMillis = (System.nanoTime() - startTime/1000000);
        waitTime = targetTime - timeMillis;
        try {
          if (waitTime > 0)
            this.sleep(waitTime); // Capping the frame rate.
        } catch (Exception e) {
          e.printStackTrace();
        }
        totalTime += System.nanoTime() - startTime;
        frameCount++;
        if (frameCount == MAX_FPS) {
          averageFPS = 1000/((totalTime/frameCount)/1000000); //conversions to get average FPS
          frameCount = 0;
          totalTime = 0;
          System.out.println(averageFPS); //Shows the average FPS.
        }
      }
    }
  }
}