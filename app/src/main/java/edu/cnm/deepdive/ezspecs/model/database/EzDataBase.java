package edu.cnm.deepdive.ezspecs.model.database;

import android.content.Context;
    import androidx.core.content.ContextCompat;
    import androidx.room.Database;
    import androidx.room.Room;
    import androidx.room.RoomDatabase;
    import androidx.room.RoomMasterTable;
    import edu.cnm.deepdive.ezspecs.model.entity.ConversionFactory;
    import edu.cnm.deepdive.ezspecs.model.entity.Game;
    import edu.cnm.deepdive.ezspecs.model.entity.Preferences;
    import edu.cnm.deepdive.ezspecs.model.entity.ProPlayers;

@Database (entities = {Game.class, Preferences.class, ProPlayers.class, ConversionFactory.class},version = 1,exportSchema = true)


public abstract class EzDataBase extends RoomDatabase {
  private static EzDataBase INSTANCE;

  public static EzDataBase getInstance(Context context){
    if (INSTANCE == null){
      INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
          EzDataBase.class, "Ez_room").build();
    }
    return INSTANCE;
  }
}
