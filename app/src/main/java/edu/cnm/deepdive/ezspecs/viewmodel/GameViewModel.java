package edu.cnm.deepdive.ezspecs.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.ezspecs.model.database.EzDataBase;
import edu.cnm.deepdive.ezspecs.model.entity.Game;
import java.util.List;

public class GameViewModel extends AndroidViewModel {

  private LiveData<List<Game>> games;

  public GameViewModel(@NonNull Application application) {
    super(application);
  }

  public LiveData<List<Game>> getGames() {
    if(games == null) {
      games = EzDataBase.getInstance(getApplication()).gamedao().getAll();
    }
    return games;
  }

 /* public void addAlarm(final Game game) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        EzDataBase = EzDataBase.getInstance(getApplication());
        ().insert(game);
      }
    }).start();
  }
  public LiveData<Alarm> getAlarm(Long id) {
    AlarmDatabase db = AlarmDatabase.getInstance((getApplication()));
    return db.alarmDao().findById(id);
  }
*/
}
