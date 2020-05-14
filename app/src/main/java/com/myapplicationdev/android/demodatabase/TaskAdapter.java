package com.myapplicationdev.android.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    private Context context;
    private TextView tvId, tvDec,tvDate;
    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource,objects);
        // Store the food that is passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        Task s = task.get(position);
        tvId = (TextView) rowView.findViewById(R.id.textViewID);
        tvId.setText(s.getId());

        tvDec = (TextView) rowView.findViewById(R.id.textViewDes);
        tvDec.setText(s.getDescription());
        tvDate = (TextView) rowView.findViewById(R.id.textViewdate);
        tvDate.setText(s.getDate());
        return rowView;
    }
}
