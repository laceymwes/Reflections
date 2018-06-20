package edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import edu.cnm.deepdive.reflections.R;
import edu.cnm.deepdive.reflections.controller.MainActivity;
import edu.cnm.deepdive.reflections.database.AppDatabase;
import edu.cnm.deepdive.reflections.database.Reflection;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link NewReflectionFragment.OnFragmentInteractionListener} interface to handle interaction
 * events. Use the {@link NewReflectionFragment#newInstance} factory method to create an instance of
 * this fragment.
 */
public class NewReflectionFragment extends Fragment {

  private Button saveButton;
  private AppDatabase appDatabase;

  private OnFragmentInteractionListener mListener;

  public NewReflectionFragment() {
    // Required empty public constructor
  }

  // TODO: Rename and change types and number of parameters
  public static NewReflectionFragment newInstance() {
    return new NewReflectionFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_new_reflection, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    saveButton = view.findViewById(R.id.reflection_save_button);
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new InsertAsync().execute();
        startActivity(new Intent(getContext(), MainActivity.class));
      }
    });
    appDatabase = AppDatabase.getInstance(getContext());
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  public interface OnFragmentInteractionListener {

    void saveReflection();
  }

  private class InsertAsync extends AsyncTask<Void, Void, Void> {

    private Reflection newReflection;

    @Override
    protected void onPreExecute() {
      EditText date = findViewById(R.id.date_edit_text);
      EditText exercise = findViewById(R.id.exercise_name_edit_text);
      EditText reflection = findViewById(R.id.reflection_edit_text);
      newReflection = new Reflection(date.getText().toString(),
          exercise.getText().toString(),
          reflection.getText().toString());
    }

    @Override
    public Void doInBackground(Void... voids) {
      appDatabase.reflectionDAO().insertAll(newReflection);
      return null;
    }

  }
}
