package game.lgracca.com.cutegame.model.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import game.lgracca.com.cutegame.model.entities.Cream;
import java.util.List;

@Dao
public interface CreamDao {

  @Insert
  long insert(Cream cream);

  @Query("SELECT * FROM Cream WHERE points = :points")
  List<Cream> select();
}
