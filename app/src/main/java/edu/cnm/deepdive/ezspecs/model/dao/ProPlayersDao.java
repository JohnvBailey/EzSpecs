package edu.cnm.deepdive.ezspecs.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.ezspecs.model.entity.ProPlayers;
import java.util.List;

public interface ProPlayersDao {

  @Insert
  long insert(ProPlayers Proplayers);

  @Query("SELECT * FROM proplayers")
  LiveData<List<ProPlayers>> getAll();

}
