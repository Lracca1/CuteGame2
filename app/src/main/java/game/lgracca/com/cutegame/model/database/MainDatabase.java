package game.lgracca.com.cutegame.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import game.lgracca.com.cutegame.model.daos.CharacterDao;
import game.lgracca.com.cutegame.model.daos.CreamDao;
import game.lgracca.com.cutegame.model.daos.UserDao;
import game.lgracca.com.cutegame.model.entities.Character;
import game.lgracca.com.cutegame.model.entities.Cream;
import game.lgracca.com.cutegame.model.entities.User;

/**
 * MainDatabase abstract class extends RoomDatabase to create database for the game.
 */
@Database(entities = {Character.class, Cream.class, User.class}, version = 1, exportSchema = true)
public abstract class MainDatabase extends RoomDatabase{

    private static final String DATABASE_NAME = "main_db";

    private static MainDatabase instance = null;

  /**
   *
   * @param context
   * @return returns instance
   */
    public static MainDatabase getInstance(Context context) {
      if (instance == null) {
        instance = Room
            .databaseBuilder(context.getApplicationContext(), MainDatabase.class, DATABASE_NAME)
            .build();
      }
      return instance;
    }

  /**
   *
   * @return returnce insctance from different classes.
   */
  public abstract CharacterDao getCharacterDao();
    public abstract CreamDao getCreamDao();
    public abstract UserDao getUserDao();

    public void forgetInstance(Context context) {
      instance = null;
    }
  }

