package game.lgracca.com.cutegame.model.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import game.lgracca.com.cutegame.model.entities.User;
import java.util.List;

@Dao
public interface UserDao {

  @Insert
  long insert(User user);

  @Query("SELECT * FROM User")
  List<User> select();
}
