package edu.cnm.deepdive.reflections.controllers;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import edu.cnm.deepdive.reflections.R;
import edu.cnm.deepdive.reflections.ReflectionsAdapter;
import edu.cnm.deepdive.reflections.database.AppDatabase;
import edu.cnm.deepdive.reflections.database.Reflection;
import edu.cnm.deepdive.reflections.database.ReflectionDAO;

public class ReflectionsListActivity extends AppCompatActivity {

  private ListView listView;
  private ReflectionsAdapter reflectionsAdapter;
  private AppDatabase appDatabase;
  private Reflection[] reflections;
  private FloatingActionButton addButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reflections_list);
    listView = findViewById(R.id.reflections_list_view);
    reflectionsAdapter = new ReflectionsAdapter(getApplicationContext(), 0);
    // FIXME: move db object and transactions to ViewModel helper class
//    appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
//                                                            "reflection").build();
//    reflections = appDatabase.reflectionDAO().getAll();
    listView.setAdapter(reflectionsAdapter);
    addButton = findViewById(R.id.reflections_fab);
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openNewReflection();
      }
    });
  }

  private void openNewReflection() {
    startActivity(new Intent(getApplicationContext(), NewReflectionActivity.class));
  }
}
