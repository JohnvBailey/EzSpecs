package edu.cnm.deepdive.ezspecs.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {
        @Index(value = {"game_1_id", "game_2_id", "conversion"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(entity = Game.class, parentColumns = "id", childColumns = "game_1_id"),
        @ForeignKey(entity = Game.class, parentColumns = "id", childColumns = "game_2_id")

    })

public class ConversionFactory {

  @PrimaryKey
  private long id;
  @ColumnInfo(name = "game_1_id", index = true)
  private long game1Id;
  @ColumnInfo(name = "game_2_id", index = true)
  private long game2Id;
  private String conversion;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getGame1Id() {
    return game1Id;
  }

  public void setGame1Id(long game1Id) {
    this.game1Id = game1Id;
  }

  public long getGame2Id() {
    return game2Id;
  }

  public void setGame2Id(long game2Id) {
    this.game2Id = game2Id;
  }

  public String getConversion() {
    return conversion;
  }

  public void setConversion(String conversion) {
    this.conversion = conversion;
  }
}





