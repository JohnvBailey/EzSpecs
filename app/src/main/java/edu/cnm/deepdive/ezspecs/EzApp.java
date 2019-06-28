package edu.cnm.deepdive.ezspecs;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.ezspecs.model.database.EzDataBase;

public class EzApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    new Thread(() -> {
      EzDataBase.getInstance(this).gamedao().delete();
    }).start();
  }
}
