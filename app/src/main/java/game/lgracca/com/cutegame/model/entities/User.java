package game.lgracca.com.cutegame.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(indices = {
        @Index(value = "username", unique = true),
        @Index(value = "email", unique = true)})

public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @NonNull
  private String email;

  @NonNull
  private String username;

  @NonNull
  private String password;
}
