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
import edu.cnm.deepdive.reflections.controllers.ReflectionsFragment.OnFragmentInteractionListener;
import edu.cnm.deepdive.reflections.database.AppDatabase;
import edu.cnm.deepdive.reflections.database.Reflection;
import java.sql.Ref;
import java.util.Timer;
import java.util.TimerTask;

public class ReflectionsListActivity extends AppCompatActivity implements
    OnFragmentInteractionListener {


  @Override
  public void onReflectionSelection(Reflection reflection) {
    // open selected reflection with RefelctionFragment
  }

  @Override
  public void onNewReflectionSelection(){

  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    new Timer().schedule(new TimerTask() {
      public void run() {
        // TODO Attach MenuFragment;
      }
    }, 5000);


  }

  private void openNewReflection() {
    startActivity(new Intent(getApplicationContext(), NewReflectionActivity.class));
  }


}
