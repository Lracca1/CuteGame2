package game.lgracca.com.cutegame.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(indices = {
        @Index(value = "username", unique = true),
        @Index(value = "email", unique = true)})

/**
 * User class consists of primarykey, id, email, username, password, setters, and getters
 * for the user table.
 */
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  /**
   * Creates the unique email of the user.
   */
  @NonNull
  private String email;

  /**
   * Creates a unique username of the user.
   */
  @NonNull
  private String username;

  /**
   * Creates password of the user.
   */
  @NonNull
  private String password;

  /**
   *
   * @return returns id of the user table.
   */
  public long getId() {
    return id;
  }

  /**
   *
   * @param id setter for user id in the game.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   *
   * @return a getter that returns the email of the user.
   */
  @NonNull
  public String getEmail() {
    return email;
  }

  /**
   *
   * @param email setter for user email in the game.
   */
  public void setEmail(@NonNull String email) {
    this.email = email;
  }

  /**
   *
   * @return a getter for the username of the user and returns the username.
   */
  @NonNull
  public String getUsername() {
    return username;
  }

  /**
   *
   * @param username setter for user username in the game.
   */
  public void setUsername(@NonNull String username) {
    this.username = username;
  }


  /**
   *
   * @return a getter of the password of a user.
   */
  @NonNull
  public String getPassword() {
    return password;
  }

  /**
   *
   * @param password setter for user password in the game.
   */
  public void setPassword(@NonNull String password) {
    this.password = password;
  }
}
