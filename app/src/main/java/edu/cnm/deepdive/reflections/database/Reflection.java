package edu.cnm.deepdive.reflections.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity
public class Reflection {

  public Reflection(String date, String exerciseName, String reflection) {
    setDate(date);
    setExerciseName(exerciseName);
    setReflection(reflection);
  }

  @NonNull
  @PrimaryKey
  private String exerciseName;

  @ColumnInfo(name = "date")
  private String date;

  @ColumnInfo(name = "reflection")
  private String reflection;

  public String getExerciseName() {
    return exerciseName;
  }

  public void setExerciseName(String exerciseName) {
    this.exerciseName = exerciseName;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getReflection() {
    return reflection;
  }

  public void setReflection(String reflection) {
    this.reflection = reflection;
  }
}
