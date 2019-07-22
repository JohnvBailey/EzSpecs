package edu.cnm.deepdive.ezspecs;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.ezspecs.model.entity.Game;
import edu.cnm.deepdive.ezspecs.viewmodel.GameViewModel;

/**
 * This class opens the activity that gets users input of their mouse sensitivity from
 */
public class ResultsActivity extends AppCompatActivity {

  public static final String TO_GAME_ID = "to_game_id";
  public static final String FROM_GAME_ID = "from_game_id";

  private Long fromGameId;
  private Long toGameId;
  private TextView computedSensitivity;
  private EditText sensitivityinput;
  private Button button;
  private GameViewModel viewModel;
  private Game from;
  private Game to;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_results);
    computedSensitivity = findViewById(R.id.computedsensitivity);
    sensitivityinput = findViewById(R.id.sensitivityinput);
    button = findViewById(R.id.button10);

    Bundle args = getIntent().getExtras();
    fromGameId = args.getLong(FROM_GAME_ID);
    toGameId = args.getLong(TO_GAME_ID);
    getGameDetails();
    sensitivityinput.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {}

      @Override
      public void afterTextChanged(Editable s) {
        if (s != null && !s.toString().trim().isEmpty() && from != null && to !=null){
          double result = Double.parseDouble(s.toString().trim()) * from.getIncrementalValue() / to.getIncrementalValue();
          computedSensitivity.setText(String.format("%.2f", result));
        }
        else{
          computedSensitivity.setText("");
        }
      }
    });

  }

  private void getGameDetails() {
    viewModel = ViewModelProviders.of(this).get(GameViewModel.class);
    viewModel.findGameById(fromGameId).observe(this, (game) -> {
      from = game;
     //Todo display graphic of Fromgame
    });
    viewModel.findGameById(toGameId).observe(this, (game) -> {
      to = game;
      //ToDO display graphic of Togame

    });
  }
}
