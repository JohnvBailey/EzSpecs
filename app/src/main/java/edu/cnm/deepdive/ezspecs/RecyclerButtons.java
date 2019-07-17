package edu.cnm.deepdive.ezspecs;

public class RecyclerButtons {
  private int mgameCover;
  private String mgameName;

  public RecyclerButtons(int gameCover, String gameName){
    mgameCover = gameCover;
    mgameName = gameName;

  }
  public int getgameCover(){
    return mgameCover;
  }
  public String getgameName(){
    return mgameName;
  }



}
