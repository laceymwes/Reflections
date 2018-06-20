package edu.cnm.deepdive.reflections;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import edu.cnm.deepdive.reflections.database.Reflection;

public class ReflectionsAdapter extends ArrayAdapter<Reflection> {

  public ReflectionsAdapter(Context context, int resource) {
    super(context, resource);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    Reflection reflection = getItem(position);
    LayoutInflater layoutInflater = LayoutInflater.from(getContext());
    ViewGroup itemView = (ViewGroup) layoutInflater.inflate(R.layout.reflection_list_item, null);
    TextView itemName = itemView.findViewById(R.id.list_item_name);
    itemName.setText(reflection.getExerciseName());
    return itemView;
  }


}
