package edu.cnm.deepdive.reflections.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import edu.cnm.deepdive.reflections.R;
import edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment.ElevatorPitchFragment;
import edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment.GoldenCircleFragment;
import edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment.HomeworkFragment;
import edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment.ReflectionFragment;
import edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment.ReflectionsFragment;
import edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment.NewReflectionFragment;
import edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment.ReflectionsFragment.OnFragmentInteractionListener;
import edu.cnm.deepdive.reflections.database.Reflection;
import edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment.MenuFragment;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements
    OnFragmentInteractionListener {

  private MenuFragment menuFragment;
  private ReflectionsFragment reflectionsFragment;
  private ReflectionFragment reflectionFragment;
  private HomeworkFragment homeworkFragment;
  private ElevatorPitchFragment elevatorPitchFragment;
  private GoldenCircleFragment goldenCircleFragment;
  private NewReflectionFragment newReflectionFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    menuFragment = MenuFragment.newInstance();
    new Timer().schedule(new TimerTask() {
      public void run() {
        setContentView(R.layout.main_fragment_layout);
        getSupportFragmentManager().beginTransaction()
            .add(R.id.fragment_container, menuFragment).commit();
      }
    }, 5000);
    reflectionsFragment = ReflectionsFragment.newInstance();
    homeworkFragment = HomeworkFragment.newInstance();
    elevatorPitchFragment = ElevatorPitchFragment.newInstance();
    goldenCircleFragment = GoldenCircleFragment.newInstance();

  }

  // Item has been selected from list on ReflectionsFragment
  @Override
  public void onReflectionSelection(Reflection reflection) {
    // open selected reflection with RefelctionFragment
  }

  // FAB has been selected on ReflectionsFragment
  @Override
  public void onNewReflectionSelection(){
    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_container, newReflectionFragment).commit();
  }

  @Override
  public void onReflectionListSelection() {
    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_container, reflectionsFragment).commit();
  }

  @Override
  public void onHomeworkListSelection() {
    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_container, homeworkFragment).commit();
  }

  @Override
  public void onElevatorPitchSelection() {
    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_container, homeworkFragment).commit();
  }

  @Override
  public void onGoldenCircleSelection(){

  }


}
