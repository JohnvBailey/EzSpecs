package edu.cnm.deepdive.ezspecs.model.dao;

import androidx.lifecycle.LiveData;
    import androidx.room.Dao;
    import androidx.room.Delete;
    import androidx.room.Insert;
    import androidx.room.Query;
    import edu.cnm.deepdive.ezspecs.model.entity.Game;
    import java.util.List;
@Dao
public interface GameDao {

  @Insert
  long insert(Game game);

  @Query("SELECT * FROM game")
  LiveData<List<Game>> getAll();
  @Query("SELECT* FROM game WHERE game_id = :id")
  LiveData<Game> findById(Long id);

  @Delete
  int delete(Game... games);

}

