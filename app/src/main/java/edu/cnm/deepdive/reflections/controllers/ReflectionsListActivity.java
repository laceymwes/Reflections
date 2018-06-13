package edu.cnm.deepdive.reflections.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import edu.cnm.deepdive.reflections.R;
import edu.cnm.deepdive.reflections.ReflectionsAdapter;
import edu.cnm.deepdive.reflections.database.AppDatabase;
import edu.cnm.deepdive.reflections.database.Reflection;
import java.sql.Ref;

public class ReflectionsListActivity extends AppCompatActivity {

  private ListView listView;
  private ReflectionsAdapter reflectionsAdapter;
  private Reflection[] reflections;
  private FloatingActionButton addButton;
  private AppDatabase appDatabase;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reflections_list);
    listView = findViewById(R.id.reflections_list_view);
    reflectionsAdapter = new ReflectionsAdapter(getApplicationContext(), 0);
    listView.setAdapter(reflectionsAdapter);
    addButton = findViewById(R.id.reflections_fab);
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        openNewReflection();
      }
    });
    //new DBAsyncTask().execute(getApplicationContext());
    appDatabase =AppDatabase.getInstance(getApplicationContext());
    new RetrieveAsync().execute(appDatabase);

  }

  private void openNewReflection() {
    startActivity(new Intent(getApplicationContext(), NewReflectionActivity.class));
  }

  private class DBAsyncTask extends AsyncTask<Context, Void , AppDatabase> {


    @Override
    protected AppDatabase doInBackground(Context... contexts) {
      return AppDatabase.getInstance(contexts[0]);
    }

    @Override
    protected void onPostExecute(AppDatabase backgroundDatabase) {
      appDatabase = backgroundDatabase;
      return;
    }
  }

  private class RetrieveAsync extends AsyncTask<AppDatabase, Void, Reflection[]> {

    @Override
    protected Reflection[] doInBackground(AppDatabase... backgroundDatabases) {
      return appDatabase.reflectionDAO().getAll();

    }

    @Override
    protected void onPostExecute(Reflection[] backgroundReflections) {
      reflections = backgroundReflections;
      reflectionsAdapter.addAll(reflections);
      return;
    }
  }
}
