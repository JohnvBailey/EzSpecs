package edu.cnm.deepdive.ezspecs;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.ezspecs.RecyclerViewAdapter.OnGameListener;
import edu.cnm.deepdive.ezspecs.model.entity.Game;
import edu.cnm.deepdive.ezspecs.viewmodel.GameViewModel;

public class MainActivity extends AppCompatActivity implements OnGameListener {

  private GameViewModel viewModel;
  private RecyclerView mRecyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager mLayoutManager;
  private Game from;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    viewModel = ViewModelProviders.of(this).get(GameViewModel.class);
    mRecyclerView = findViewById(R.id.recycler_view);
    mLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(mLayoutManager);
    viewModel.getGames().observe(this, (games) -> {

      mAdapter = new RecyclerViewAdapter(this, games, this);
      mRecyclerView.setAdapter(mAdapter);
    });

  }

  @Override
  public void onGameClicked(Game game, int position) {

    if (game == from) {
      from = null;
      game.setSelected(false);
      mAdapter.notifyItemChanged(position);

    } else if (from == null) {
      from = game;
      game.setSelected(true);
      mAdapter.notifyItemChanged(position);

    } else {
      Game to =  game;
      Game from = this.from;
      from.setSelected(false);
      mAdapter.notifyDataSetChanged();
      Intent intent = new Intent(this, ResultsActivity.class);
      intent.putExtra(ResultsActivity.FROM_GAME_ID,from.getId());
      intent.putExtra(ResultsActivity.TO_GAME_ID,to.getId());
      startActivity(intent);
    }

  }

}
