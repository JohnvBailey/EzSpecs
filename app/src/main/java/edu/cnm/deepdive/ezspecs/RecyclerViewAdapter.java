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

public class RecyclerViewAdapter extends RecyclerView.Adapter<GameViewHolder> {

  private final Context context;
  private List<Game> games;
  private OnGameListener mOnGameListener;


  public RecyclerViewAdapter(Context context, List<Game> games,
      OnGameListener onGameListener) {
    this.context = context;
    this.games = games;
    mOnGameListener = onGameListener;

  }

  @NonNull
  @Override
  public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
    GameViewHolder gvh = new GameViewHolder(v, mOnGameListener);
    return gvh;

  }

  @Override
  public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
    Game game = games.get(position);
    holder.bind(game);
  }

  @Override
  public int getItemCount() {
    return games.size();
  }

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
