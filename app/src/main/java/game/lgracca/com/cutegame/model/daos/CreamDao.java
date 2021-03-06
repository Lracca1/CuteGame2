package game.lgracca.com.cutegame.model.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import game.lgracca.com.cutegame.model.entities.Cream;
import java.util.List;

/**
 * CreamDao interface has an insert and query methods to help create a database table.
 */
@Dao
public interface CreamDao {

  @Insert
  long insert(Cream cream);

  @Query("SELECT * FROM Cream")
  List<Cream> select();
}
