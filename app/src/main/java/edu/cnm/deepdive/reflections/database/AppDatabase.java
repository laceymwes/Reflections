package edu.cnm.deepdive.reflections.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Reflection.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
  public abstract ReflectionDAO reflectionDAO();

  private static AppDatabase instance;


  public static AppDatabase getInstance(Context context) {
    if (instance == null) {
      instance = Room.databaseBuilder(context, AppDatabase.class, "reflections-database").build();
      return instance;
    }
    return instance;
  }
}
