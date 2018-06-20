package edu.cnm.deepdive.reflections.edu.cnm.deepdive.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.reflections.R;

public class MenuFragment extends Fragment {



  private OnFragmentInteractionListener mListener;

  public MenuFragment() {
    // Required empty public constructor
  }


  public static MenuFragment newInstance() {
    return new MenuFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_menu, container, false);
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

    void onReflectionListSelction();
    void onHomeworkListSelection();
    void onElevatorPitchSelection();
    void onGoldenCircleSelection();

  }
}
