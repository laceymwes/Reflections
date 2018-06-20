package edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import edu.cnm.deepdive.reflections.R;
import edu.cnm.deepdive.reflections.ReflectionsAdapter;
import edu.cnm.deepdive.reflections.database.AppDatabase;
import edu.cnm.deepdive.reflections.database.Reflection;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link ReflectionsFragment.OnFragmentInteractionListener} interface to handle interaction events.
 * Use the {@link ReflectionsFragment#newInstance} factory method to create an instance of this
 * fragment.
 */
public class ReflectionsFragment extends Fragment {

  private ListView listView;
  private ReflectionsAdapter reflectionsAdapter;
  private Reflection[] reflections;
  private FloatingActionButton addButton;
  private AppDatabase appDatabase;

  private OnFragmentInteractionListener mListener;

  public ReflectionsFragment() {
    // Required empty public constructor
  }

  public static ReflectionsFragment newInstance() {
    return new ReflectionsFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_reflections, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    listView = view.findViewById(R.id.reflections_list_view);
    reflectionsAdapter = new ReflectionsAdapter(getContext(), R.layout.reflection_list_item);
    listView.setAdapter(reflectionsAdapter);
    listView.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
        // Send the event to the host activity
        Reflection reflection = reflections[position];
        mListener.onReflectionSelection(reflection);
      }
    });
    addButton = view.findViewById(R.id.reflections_fab);
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mListener.onNewReflectionSelection();
      }
    });
    appDatabase = AppDatabase.getInstance(getContext());
    new RetrieveAsync().execute(appDatabase);
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

    void onReflectionSelection(Reflection reflection);
    void onNewReflectionSelection();
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
