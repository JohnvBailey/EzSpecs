package edu.cnm.deepdive.ezspecs;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Primordial extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_primordial);

    SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
    String FirstTime = preferences.getString("FirstTimeInstall", "");

    if (FirstTime.equals("Yes")){
      Intent intent = new Intent(Primordial.this, MainActivity.class);
          startActivity(intent);

    }else{
      SharedPreferences.Editor editor = preferences.edit();
      editor.putString("First Time Install", "Yes");
      editor.apply();
    }
  }

}
