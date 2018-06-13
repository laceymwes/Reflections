package edu.cnm.deepdive.reflections.controllers;

import edu.cnm.deepdive.reflections.database.Reflection;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import edu.cnm.deepdive.reflections.R;
import edu.cnm.deepdive.reflections.database.AppDatabase;

public class NewReflectionActivity extends AppCompatActivity {

  private Button saveButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_reflection);
    saveButton = findViewById(R.id.reflection_save_button);
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        insert();
        startActivity(new Intent(getApplicationContext(), ReflectionsListActivity.class));
      }
    });
  }

  private void insert() {
    EditText date = findViewById(R.id.date_edit_text);
    EditText exercise = findViewById(R.id.exercise_name_edit_text);
    EditText reflection = findViewById(R.id.reflection_edit_text);
//    AppDatabase appDatabase = new DbBuildAsync().doInBackground(getApplicationContext());
//    new InsertAsync().backgroundHelper(appDatabase, new Reflection (date.getText().toString(),
//                                                                exercise.getText().toString(),
//                                                            reflection.getText().toString()));
  }
}
