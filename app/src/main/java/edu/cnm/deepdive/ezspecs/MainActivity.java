package edu.cnm.deepdive.ezspecs;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  private Button fortnite;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    fortnite = (Button) findViewById(R.id.fortnitebutton);
    fortnite.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        openTargetGameActivity();
      }
    });
  }
  private void openTargetGameActivity(){
    Intent intent = new Intent(this, TargetGameActivity.class);
    startActivity(intent);
  }
}
