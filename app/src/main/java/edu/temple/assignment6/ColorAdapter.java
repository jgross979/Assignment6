package edu.temple.assignment6;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ColorAdapter extends BaseAdapter {

    String[] colors;
    Context context;

    public ColorAdapter(Context context, String... colors) {
        this.colors = colors;
        this.context = context;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextView text;

        if (convertView != null && convertView instanceof TextView) {
            text = (TextView) convertView;
        } else {
            text = new TextView(context);
        }

        //Position 0 will be a message that does not change any colors
        if (position == 0) {
            text.setText(R.string.choose_color);
            text.setBackgroundColor(Color.parseColor("white"));
        } else {
            final String color = colors[position];
            text.setText(color);
            text.setBackgroundColor(Color.parseColor(chooseColor(color)));
        }

        text.setTextSize(25);

        return text;
    }


    public static String chooseColor(String color) {
        if (color.equals("Blue") || color.equals("Azul")) {
            return "Blue";
        } else if (color.equals("Green") || color.equals("Verde")) {
            return "Green";
        } else if (color.equals("Cyan") || color.equals("Cian")) {
            return "Cyan";
        } else if (color.equals("Yellow") || color.equals("Amarillo")) {
            return "Yellow";
        } else if (color.equals("Gray") || color.equals("Gris")) {
            return "Gray";
        } else if (color.equals("Magenta")) {
            return "Magenta";
        } else if (color.equals("Teal") || color.equals("Verde Azulado")) {
            return "Teal";
        } else if (color.equals("Aqua") || color.equals("Agua")) {
            return "Aqua";
        } else if (color.equals("Navy") || color.equals("Armada")) {
            return "Navy";
        } else if (color.equals("Fuchsia") || color.equals("Fucsia")) {
            return "Fuchsia";
        }

        return color;

    }

}