package edu.cnm.deepdive.reflections.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.reflections.R;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    new Timer().schedule(new TimerTask() {
      public void run() {
        startActivity(new Intent(MainActivity.this, ReflectionsListActivity.class));
      }
    }, 5000);
  }
}
