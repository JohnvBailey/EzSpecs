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

  public LiveData<Game> findGameById(long id) {
   return EzDataBase.getInstance(getApplication()).gamedao().findById(id);
  }

}
