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
package edu.cnm.deepdive.ezspecs.service;

import android.app.Application;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

// This is a singleton class, private constructor, static method to return single instance of this class.

/**
 * The class is used to inkoke a call to the Google Sign in OAuth client, a service class.
 */
public class GoogleSignInService {
  private static Application context;
  private GoogleSignInAccount acount;
  private GoogleSignInClient client;

  private GoogleSignInService(){
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .build();
    client = GoogleSignIn.getClient(context, options);

  }

  /**
   * sets context as {@linkGooglesigninService}
   * @param context
   */

  public static void setContext(Application context) {
    GoogleSignInService.context = context;
  }

  /**
   * getter for google sign in client
   * @return
   */
  public GoogleSignInClient getClient() {
    return client;
  }

  /**
   * getter for GoogleSignIn Account
   * @return
   */
  public GoogleSignInAccount getAcount() {
    return acount;
  }

  /**
   * setter for google signInAccount
   * @param acount
   */
  public void setAcount(GoogleSignInAccount acount) {
    this.acount = acount;
  }

  /**
   * creates instance of GoogleInService
   * @return
   */
  public static GoogleSignInService getInstance(){
    return InstanceHolder.INSTANCE;
  }
  private static class InstanceHolder {
    private static final GoogleSignInService INSTANCE = new GoogleSignInService();
  }
}
