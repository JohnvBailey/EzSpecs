package edu.cnm.deepdive.ezspecs.model.database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
    import androidx.room.Room;
    import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.ezspecs.model.dao.GameDao;
import edu.cnm.deepdive.ezspecs.model.entity.Game;

@Database (entities = {Game.class},version = 1,exportSchema = true)
public abstract class EzDataBase extends RoomDatabase {

  public abstract GameDao gamedao();




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
    fortnite.setImage("fortnite");
    fortnite.setIncrementalValue(4);
    db.gamedao().insert(fortnite);

    Game apex = new Game();
    apex.setTitle("Apex Legends");
    apex.setImage("apex");
    apex.setIncrementalValue(3);
    db.gamedao().insert(apex);

    Game overwatch = new Game();
    overwatch.setTitle("Overwatch");
    overwatch.setImage("overwatch");
    overwatch.setIncrementalValue(2);
    db.gamedao().insert(overwatch);

    Game csgo = new Game();
    csgo.setTitle("CounterStrike: Global Offensive");
    csgo.setImage("counterstrike");
    csgo.setIncrementalValue(1);
    db.gamedao().insert(csgo);

    Game pubg = new Game();
    pubg.setTitle("PlayerUnknown's Battlegrounds");
    pubg.setImage("pubg");
    pubg.setIncrementalValue(0.1423);
    db.gamedao().insert(pubg);

    Game paladins = new Game();
    paladins.setTitle("Paladins");
    paladins.setImage("paladins");
    paladins.setIncrementalValue(.5);
    db.gamedao().insert(paladins);
    return null;
  }
}

}
