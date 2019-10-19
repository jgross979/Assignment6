package edu.temple.assignment6;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteFragment extends Fragment {

    //Parent of the fragment. Not to be confused with parent from onItemSelected
    Context par;


    public PaletteFragment() {
        // Required empty public constructor
    }


    public static PaletteFragment newInstance() {
        return new PaletteFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        //Find the spinner in the view
        final Spinner spinner = v.findViewById(R.id.spinner);

        //Get colors from the color string array
        String[] colors = getResources().getStringArray(R.array.color_array);

        //Create new color adapter using the colors array
        ColorAdapter adapter = new ColorAdapter(par, colors);

        //Set the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    view.setBackgroundColor(Color.parseColor("white"));
                }else{
                    //Create intent and start CanvasActivity
                    String selected = (String) parent.getItemAtPosition(position);
                    view.setBackgroundColor(Color.parseColor("white"));
                    //Send message to parent that a color was selected, and send the color in a string
                    ((OnFragmentInteractionListener) par).onColorChange(selected);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.par = context;

    }

    public interface OnFragmentInteractionListener {
        public void onColorChange(String color);
    }
}
