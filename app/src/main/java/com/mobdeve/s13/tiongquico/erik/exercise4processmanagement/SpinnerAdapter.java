package com.mobdeve.s13.tiongquico.erik.exercise4processmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

/* * * * * * * * * * * * * * * * * * *
 *  EVERYTHING HERE ARE STUFF YOU    *
 *  DON'T HAVE TO BE CONCERNED WITH! *
 * * * * * * * * * * * * * * * * * * */

/**
 * This class handles the custom spinner's adapter.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    public SpinnerAdapter(Context context, int textViewResourceId, String[] objects) {
        super(context, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomDropDownView(position, convertView, parent);
    }

    public View getCustomDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dropdown = inflater.inflate(R.layout.spinner_dropdown, parent, false);

        TextView entry = (TextView) dropdown.findViewById(R.id.tv_spinner_dropdown_entry);
        entry.setText(getItem(position));

        return entry;
    }
}
