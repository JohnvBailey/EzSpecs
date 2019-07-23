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
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.ezspecs.service.GoogleSignInService;

/**
 *Launch activity that requires user to sign in
 */
public class LoginActivity extends AppCompatActivity {
private static final int LOGIn_REQUEST_CODE = 1000;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    findViewById(R.id.sign_in).setOnClickListener((view)->signIn());
  }

  /**
   * Overides the onStart method to allow it to check if user is already signed in.
   * If use is signed in, launches main activity.
   */
  @Override
  protected void onStart() {
    super.onStart();
    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    if (account != null) {
      GoogleSignInService.getInstance().setAcount(account);
      switchToMain();
    }
  }
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
if (requestCode == LOGIn_REQUEST_CODE){
  try {
    Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
    GoogleSignInAccount account = task.getResult(ApiException.class);
    GoogleSignInService.getInstance().setAcount(account);
    switchToMain();
  } catch (ApiException e) {
    Toast.makeText(this, getString(R.string.authetication_error), Toast.LENGTH_LONG).show();
  }
}
  }
  private void signIn(){
    Intent intent = GoogleSignInService.getInstance().getClient().getSignInIntent();
    startActivityForResult(intent, LOGIn_REQUEST_CODE);
  }
  private void switchToMain(){
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }
}
