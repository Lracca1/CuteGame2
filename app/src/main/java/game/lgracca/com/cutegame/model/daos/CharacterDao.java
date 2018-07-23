package game.lgracca.com.cutegame.model.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import game.lgracca.com.cutegame.model.entities.Character;
import java.util.List;

@Dao
public interface CharacterDao {

  @Insert
  long insert(Character character);

  @Query("SELECT * FROM character WHERE name = :name")
  List<Character> select();
}
