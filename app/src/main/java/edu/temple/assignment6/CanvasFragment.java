package edu.temple.assignment6;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    String color = "";

    public static final String COLOR_KEY = "color_name";


    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(String color) {
        CanvasFragment cf = new CanvasFragment();

        Bundle bundle = new Bundle();
        bundle.putString(COLOR_KEY, color);

        cf.setArguments(bundle);

        return cf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            color = getArguments().getString(COLOR_KEY);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        v.setBackgroundColor(Color.parseColor(color));

        return v;
    }

}
