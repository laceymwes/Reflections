package edu.cnm.deepdive.reflections.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;

@Entity
public class Reflection {

  @PrimaryKey
  private String exerciseName;

  @ColumnInfo(name = "date")
  private Date date;

  @ColumnInfo(name = "reflection")
  private String reflection;

  public String getExerciseName() {
    return exerciseName;
  }

  public void setExerciseName(String exerciseName) {
    this.exerciseName = exerciseName;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getReflection() {
    return reflection;
  }

  public void setReflection(String reflection) {
    this.reflection = reflection;
  }
}
