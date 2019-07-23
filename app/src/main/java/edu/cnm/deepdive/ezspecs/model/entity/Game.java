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
package edu.cnm.deepdive.ezspecs.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This class is an {@link Entity} class for th {@link Entity} has {@link androidx.room.ForeignKey}
 *
 */
@Entity
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;
  private String title;
  private String image;
  private double incrementalValue;
  private transient boolean selected;

  /**
   *
   * @return returns incrementalvalue from {@link Game}
   */
  public double getIncrementalValue() {
    return incrementalValue;
  }

  /**
   * assigns an incremental value as a double
   * @param incrementalValue
   */

  public void setIncrementalValue(double incrementalValue) {
    this.incrementalValue = incrementalValue;
  }

  /**
   *
   * @return game Id as a long
   */
  public long getId() {
    return id;
  }

  /**
   * sets the id of the game
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * returns title as a string
   * @return
   */
  public String getTitle() {
    return title;
  }

  /**
   * sets title  for game
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * returns Image as string
   */
  public String getImage() {
    return image;
  }

  /**
   * set image to game
   * @param image
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * method to tell holder if view is selected
   * @return
   */
  public boolean isSelected() {
    return selected;
  }

  /**
   * sets
   * @param selected
   */
  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  /**
   * ensures title is set as string
   * @return
   */
  @NonNull
  @Override
  public String toString() {
    return title;
  }
}


