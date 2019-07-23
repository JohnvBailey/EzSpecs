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
package edu.cnm.deepdive.ezspecs;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.ezspecs.RecyclerViewAdapter.GameViewHolder;
import edu.cnm.deepdive.ezspecs.RecyclerViewAdapter.OnGameListener;
import edu.cnm.deepdive.ezspecs.model.entity.Game;
import java.util.List;

/**
 * Class that creates a Recyclerview Adapter from an array of games.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<GameViewHolder> {

  private final Context context;
  private List<Game> games;
  private OnGameListener mOnGameListener;

  /**
   * attaches onGameListner to RecyclerView Adapter
   * @param context
   * @param games
   * @param onGameListener
   */

  public RecyclerViewAdapter(Context context, List<Game> games,
      OnGameListener onGameListener) {
    this.context = context;
    this.games = games;
    mOnGameListener = onGameListener;

  }

  /**
   * Creates a view holder that inflates Card_View XMlL
   * @param parent
   * @param viewType
   * @return
   */
  @NonNull
  @Override
  public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
    GameViewHolder gvh = new GameViewHolder(v, mOnGameListener);
    return gvh;

  }

  /**
   * binds a game object to a holder position
   * @param holder
   * @param position
   */
  @Override
  public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
    Game game = games.get(position);
    holder.bind(game);
  }

  /**
   * creates the size of the ViewHolder
   * @return
   */
  @Override
  public int getItemCount() {
    return games.size();
  }

  /**
   * Creates the Created the recycler view with the objects from
   */
  class GameViewHolder extends RecyclerView.ViewHolder implements
      View.OnClickListener {

    private ImageView mimageView;
    private ImageView selected;
    private TextView mtextView;
    private OnGameListener mOnGameListener;
    private Game game;

    GameViewHolder(@NonNull View itemView, OnGameListener onGameListener) {
      super(itemView);
      mimageView = itemView.findViewById(R.id.imageview);
      mtextView = itemView.findViewById(R.id.textView);
      selected = itemView.findViewById(R.id.selected);
      mOnGameListener = onGameListener;
      itemView.setOnClickListener(this);
    }

    private void bind(Game game) {
      this.game = game;
      mtextView.setText(game.getTitle());
      if (game.getImage() != null) {
        Resources res = context.getResources();
        int id = res.getIdentifier(game.getImage(), "drawable", context.getPackageName());
        mimageView.setImageResource(id);

      }else {
        mimageView.setImageResource(android.R.color.transparent);
      }
      if (game.isSelected()){
        selected.setImageResource(R.drawable.ic_from);
      }else {
        selected.setImageResource(android.R.color.transparent);
      }
    }

    @Override
    public void onClick(View v) {
      mOnGameListener.onGameClicked(game, getAdapterPosition());
    }



  }

  public interface OnGameListener {

    void onGameClicked(Game game, int position);
  }

}
