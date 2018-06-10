package edu.cnm.deepdive.reflections.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.ArrayList;

@Dao // Data Access Object
public interface ReflectionDAO {

  @Query("SELECT * FROM reflection")
  ArrayList<Reflection> getAll(); // Retrieve all reflection data

  @Insert
  void insertAll(Reflection ... reflection); // Add new reflections on exercises
}
