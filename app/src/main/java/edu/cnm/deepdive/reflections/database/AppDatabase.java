package edu.cnm.deepdive.reflections.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Reflection.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
  public abstract ReflectionDAO reflectionDAO();
}
