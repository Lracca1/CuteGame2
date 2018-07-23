package game.lgracca.com.cutegame.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
/**
 * Cream class consists of primarykey, id, points, setters, and getters for the
 * cream table.
 */
public class Cream {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "creams_id")
  private long id;

  /**
   * The cream in the game gives points to the player.
   */
  @NonNull
  private Integer points;

  /**
   *
   * @return returns id of the cream table.
   */
  public long getId() {
    return id;
  }

  /**
   *
   * @param id setter for the cream id of the cream table.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   *
   * @return getter for points in the game that returns the points.
   */
  @NonNull
  public Integer getPoints() {
    return points;
  }

  /**
   *
   * @param points setter for the points of the cream table.
   */
  public void setPoints(@NonNull Integer points) {
    this.points = points;
  }
}
