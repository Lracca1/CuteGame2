package game.lgracca.com.cutegame.model.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import game.lgracca.com.cutegame.model.entities.Character;
import java.util.List;

/**
 * CharacterDao interface has an insert and query methods to help create a database table.
 */
@Dao
public interface CharacterDao {

  @Insert
  long insert(Character character);

  @Query("SELECT * FROM character")
  List<Character> select();
}
