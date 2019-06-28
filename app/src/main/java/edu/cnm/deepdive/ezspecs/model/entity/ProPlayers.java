package edu.cnm.deepdive.ezspecs.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
    @ForeignKey(entity = Game.class,parentColumns = "game_id", childColumns = "progame_id")
})
public class ProPlayers {
 @PrimaryKey
  private Long id;
 @ColumnInfo(name = "progame_id", index = true)
 private Long gameid;
  private String Proname;
  private String Settings;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getGameId() {
    return gameid;
  }

  public void setGameId(Long gameId) {
    this.gameid = gameId;
  }

  public String getProname() {
    return Proname;
  }

  public void setProname(String proname) {
    Proname = proname;
  }

  public String getSettings() {
    return Settings;
  }

  public void setSettings(String settings) {
    Settings = settings;
  }

  public Long getGameid() {
    return gameid;
  }

  public void setGameid(Long gameid) {
    this.gameid = gameid;
  }
}
