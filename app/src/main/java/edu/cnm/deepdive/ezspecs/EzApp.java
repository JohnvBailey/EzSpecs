package edu.cnm.deepdive.ezspecs;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class EzApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
