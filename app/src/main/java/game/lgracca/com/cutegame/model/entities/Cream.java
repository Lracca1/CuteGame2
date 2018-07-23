package game.lgracca.com.cutegame.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Cream {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "creams_id")
  private long id;

  @NonNull
  private Integer points;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Integer getPoints() {
    return points;
  }

  public void setPoints(@NonNull Integer points) {
    this.points = points;
  }
}
