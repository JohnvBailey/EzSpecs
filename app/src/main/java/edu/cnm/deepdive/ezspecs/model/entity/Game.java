package edu.cnm.deepdive.ezspecs.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {

  @PrimaryKey
  private long id;
  private String title;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}


