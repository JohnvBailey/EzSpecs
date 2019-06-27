package edu.cnm.deepdive.ezspecs.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.ezspecs.model.entity.ConversionFactory;
import java.util.List;

@Dao
public interface ConversionFactoryDao {
  @Insert
  long insert(ConversionFactory conversionFactory);

  @Query("SELECT * FROM ConversionFactory")
  LiveData<List<ConversionFactory>> getAll();

}


