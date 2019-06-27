package edu.cnm.deepdive.ezspecs.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.ezspecs.model.entity.Game;
import java.util.List;

public interface GameDao {

  @Insert
  long insert(Game game);

  @Query("SELECT * FROM Game")
  LiveData<List<Game>> getAll();

}

