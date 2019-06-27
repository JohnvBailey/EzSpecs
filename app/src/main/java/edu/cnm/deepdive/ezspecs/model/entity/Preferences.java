package edu.cnm.deepdive.ezspecs.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Preferences {
  @PrimaryKey
  private long Id;
  private String MouseDpi;
  private String Resolution;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  public String getMouseDpi() {
    return MouseDpi;
  }

  public void setMouseDpi(String mouseDpi) {
    MouseDpi = mouseDpi;
  }

  public String getResolution() {
    return Resolution;
  }

  public void setResolution(String resolution) {
    Resolution = resolution;
  }

}
