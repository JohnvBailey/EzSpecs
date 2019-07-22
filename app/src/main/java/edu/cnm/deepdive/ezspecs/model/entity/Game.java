package edu.cnm.deepdive.ezspecs.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;
  private String title;
  private String image;
  private double incrementalValue;
  private transient boolean selected;

  public double getIncrementalValue() {
    return incrementalValue;
  }

  public void setIncrementalValue(double incrementalValue) {
    this.incrementalValue = incrementalValue;
  }

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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }


  @NonNull
  @Override
  public String toString() {
    return title;
  }
}


