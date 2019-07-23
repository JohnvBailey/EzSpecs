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

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.ezspecs.RecyclerViewAdapter.OnGameListener;
import edu.cnm.deepdive.ezspecs.model.entity.Game;
import edu.cnm.deepdive.ezspecs.viewmodel.GameViewModel;

/**
 * The Main Activity of the App, creates GameViewmodel that populates a recycler view with a list of games.
 */
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

  /**
   * Method that checks if an adapter object has been clicked. When two adapter objects have been clicked, user gets sent to results activity.
   * @param game
   * @param position
   */
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
