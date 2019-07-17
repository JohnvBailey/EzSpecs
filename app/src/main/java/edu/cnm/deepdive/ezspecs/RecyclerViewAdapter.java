package edu.cnm.deepdive.ezspecs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.gameViewHolder> {
private ArrayList<RecyclerButtons> mbuttonList;
  public static class gameViewHolder extends RecyclerView.ViewHolder{
    public ImageView mimageView;
    public TextView mtextView;


    public gameViewHolder(@NonNull View itemView) {
      super(itemView);
      mimageView = itemView.findViewById(R.id.imageview);
      mtextView = itemView.findViewById(R.id.textView);
    }
  }

public RecyclerViewAdapter(ArrayList<RecyclerButtons> buttonList){
    mbuttonList = buttonList;
}
  @NonNull
  @Override
  public gameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
  View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
  gameViewHolder gvh = new gameViewHolder(v);
  return gvh;

  }

  @Override
  public void onBindViewHolder(@NonNull gameViewHolder holder, int position) {
    RecyclerButtons currentButton = mbuttonList.get(position);

    holder.mimageView.setImageResource(currentButton.getgameCover());
    holder.mtextView.setText(currentButton.getgameName());

  }

  @Override
  public int getItemCount() {
    return mbuttonList.size();
  }
}
