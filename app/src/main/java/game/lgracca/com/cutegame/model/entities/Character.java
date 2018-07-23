package game.lgracca.com.cutegame.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "character",
    indices = {@Index(value = "name", unique = true)})

/**
 * Character class consists of primarykey, id, name, setters, and getters for the
 * character table.
 */
public class Character {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "character_id")
  private long id;

  /**
   * creates a unique name of the character in the game.
   */
  @NonNull
  private String name;

  /**
   *
   * @return returns id of the character in the game.
   */
  public long getId() {
    return id;
  }

  /**
   *
   * @param id setter for the id of the character in the game.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   *
   * @return a getter that returns the name of the character in the game.
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   *
   * @param name setter for the name of the character in the game.
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }
}
