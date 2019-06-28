package edu.cnm.deepdive.ezspecs.model.database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
    import androidx.room.Database;
    import androidx.room.Room;
    import androidx.room.RoomDatabase;
    import androidx.room.RoomMasterTable;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.ezspecs.model.dao.ConversionFactoryDao;
import edu.cnm.deepdive.ezspecs.model.dao.GameDao;
import edu.cnm.deepdive.ezspecs.model.dao.ProPlayersDao;
import edu.cnm.deepdive.ezspecs.model.entity.ConversionFactory;
    import edu.cnm.deepdive.ezspecs.model.entity.Game;
    import edu.cnm.deepdive.ezspecs.model.entity.Preferences;
    import edu.cnm.deepdive.ezspecs.model.entity.ProPlayers;

@Database (entities = {Game.class, Preferences.class, ProPlayers.class, ConversionFactory.class},version = 1,exportSchema = true)
public abstract class EzDataBase extends RoomDatabase {

  public abstract GameDao gamedao();
  public abstract ConversionFactoryDao conversionFactoryDao();
  public abstract ProPlayersDao proPlayersDao();



    private static EzDataBase INSTANCE;

  public static EzDataBase getInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (EzDataBase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
              EzDataBase.class, "ez_room")
              .addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                  super.onCreate(db);
                  new PopulateDbTask(INSTANCE).execute();
                }
              }).build();
        }
      }
    }
    return INSTANCE;
  }

private static class PopulateDbTask extends AsyncTask<Void, Void, Void> {

  private final EzDataBase db;

  PopulateDbTask(EzDataBase db){
    this.db = db;
  }

  @Override
  protected Void doInBackground(Void... voids) {
   Game fortnite = new Game();
    fortnite.setTitle("Fortnite");
    db.gamedao().insert(fortnite);

    Game apex = new Game();
    apex.setTitle("apex");
    db.gamedao().insert(apex);

    Game overwatch = new Game();
    overwatch.setTitle("OverWatch");
    db.gamedao().insert(overwatch);

    Game csgo = new Game();
    csgo.setTitle("CsGo");
    db.gamedao().insert(csgo);

    Game pubg = new Game();
    pubg.setTitle("pubg");
    db.gamedao().insert(pubg);

    Game paladins = new Game();
    paladins.setTitle("Paladins");
    db.gamedao().insert(paladins);
    return null;
  }
}

}
