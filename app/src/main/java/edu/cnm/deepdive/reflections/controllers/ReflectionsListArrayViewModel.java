package edu.cnm.deepdive.reflections.controllers;

import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.content.Context;
import edu.cnm.deepdive.reflections.database.AppDatabase;
import edu.cnm.deepdive.reflections.database.Reflection;

public class ReflectionsListArrayViewModel extends ViewModel {

  private AppDatabase appDatabase;

  // ViewModel object instantiates db object
 ReflectionsListArrayViewModel(Context context) {
    appDatabase = Room.databaseBuilder(context, AppDatabase.class, "reflection").build();
  }

  // DAO getAll() method returns Reflection[] holding all records from Reflection entity
  public Reflection[] getReflections() {
   return appDatabase.reflectionDAO().getAll();
  }
}
