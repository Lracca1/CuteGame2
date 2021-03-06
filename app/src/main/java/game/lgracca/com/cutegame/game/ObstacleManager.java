package game.lgracca.com.cutegame.game;

import android.graphics.Canvas;
import java.util.ArrayList;

public class ObstacleManager {
  // higher index = lower on screen = higher y value
  private ArrayList<Obstacle> obstacles;
  private int playerGap;
  private int obstacleGap;
  private int obstacleHeight;
  private int color;

  private long startTime;

  public ObstacleManager(int playerGap, int obstacleGap, int obstacleHeight, int color) {
    this.playerGap = playerGap;
    this.obstacleGap = obstacleGap;
    this.obstacleHeight = obstacleHeight;
    this.color = color;

    startTime = System.currentTimeMillis();

    obstacles = new ArrayList<>();

    populateObstacles();
  }

  public boolean Collision(Player1 player) {
    for (Obstacle obstacle : obstacles) {
      if (obstacle.Collision(player))
        return true;
    }
    return false;
  }

  private void populateObstacles() {
    int currentY = -10 * Constants.SCREEN_HEIGHT/3;
    while(currentY < 0) {
      int xStart = (int)(Math.random() * (Constants.SCREEN_WIDTH - playerGap));
      obstacles.add(new Obstacle(obstacleHeight, color, xStart, currentY, playerGap));
      currentY += obstacleHeight + obstacleGap;
    }
  }

  public void update() {
    int elapsedTime = (int) (System.currentTimeMillis() - startTime);
    startTime = System.currentTimeMillis();
    float speed = Constants.SCREEN_HEIGHT/10000.0f;
    for (Obstacle obstacle : obstacles) {
      obstacle.incrementY(speed * elapsedTime);
    }

    if(obstacles.get(obstacles.size() - 1).getRectangle().top >= Constants.SCREEN_HEIGHT) {
      int xStart = (int)(Math.random() * (Constants.SCREEN_WIDTH - playerGap));
      obstacles.add(0, new Obstacle(obstacleHeight, color, xStart,
          obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap, playerGap));
      obstacles.remove(obstacles.size() - 1);
    }
  }

  public void draw(Canvas canvas) {
    for (Obstacle obstacle : obstacles)
      obstacle.draw(canvas);
  }
}
