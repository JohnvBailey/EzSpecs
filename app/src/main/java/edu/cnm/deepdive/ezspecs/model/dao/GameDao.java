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
package edu.cnm.deepdive.ezspecs.model.dao;

import androidx.lifecycle.LiveData;
    import androidx.room.Dao;
    import androidx.room.Delete;
    import androidx.room.Insert;
    import androidx.room.Query;
    import edu.cnm.deepdive.ezspecs.model.entity.Game;
    import java.util.List;

/**
 * {@link Dao} Interface used to interact with {@link Game}, contains methods for Innserting, deleting,  and finding games by Id.
 */


@Dao
public interface GameDao {

  /**
   * method to insert a single game into the database.
   * @param game
   * @return
   */
  @Insert
  long insert(Game game);

  /**
   * get all games from data base
   * @return
   */
  @Query("SELECT * FROM game")
  LiveData<List<Game>> getAll();

  /**
   * Method to select a choice by its id
   * @param  id of game, as a long
   * @return  game by id
   */
  @Query("SELECT* FROM game WHERE game_id = :id")
  LiveData<Game> findById(Long id);

  /**
   * Method that selects all {@link Game}
   * @param games
   * @return
   */
  @Delete
  int delete(Game... games);

}

