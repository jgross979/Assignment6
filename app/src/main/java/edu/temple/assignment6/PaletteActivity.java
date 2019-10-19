package edu.temple.assignment6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.OnFragmentInteractionListener {

    FragmentManager fm;
    CanvasFragment cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cf = new CanvasFragment();

        fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.container_1, new PaletteFragment())
                .commit();

    }

    @Override
    public void onColorChange(String color){
        CanvasFragment newFragment = CanvasFragment.newInstance(color);
        fm.beginTransaction()
                .replace(R.id.container_2, newFragment)
                .addToBackStack(null)
                .commit();
    }

}