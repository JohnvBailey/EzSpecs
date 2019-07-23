/*
   Copyright 2019 John Bailey

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package edu.cnm.deepdive.ezspecs.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.ezspecs.model.database.EzDataBase;
import edu.cnm.deepdive.ezspecs.model.entity.Game;
import java.util.List;

/**
 * A class the creates a view model that observes live data, from the {@link edu.cnm.deepdive.ezspecs.model.dao.GameDao}
 */
public class GameViewModel extends AndroidViewModel {

  private LiveData<List<Game>> games;

  /**
   *
   * @param application
   */
  public GameViewModel(@NonNull Application application) {
    super(application);
  }

  /**
   * creates an array of games
   * @return
   */
  public LiveData<List<Game>> getGames() {
    if(games == null) {
      games = EzDataBase.getInstance(getApplication()).gamedao().getAll();
    }
    return games;
  }

  /**
   * finds games in the array by thier Id
   * @param id
   * @return
   */
  public LiveData<Game> findGameById(long id) {
   return EzDataBase.getInstance(getApplication()).gamedao().findById(id);
  }

}
