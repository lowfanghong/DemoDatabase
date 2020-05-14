package com.myapplicationdev.android.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert;
    Button btnGetTasks;
    TextView tvResults;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.button);
        btnGetTasks = findViewById(R.id.button2);
        tvResults = findViewById(R.id.textView);
        lv = findViewById(R.id.lv);

        DBHelper db = new DBHelper(MainActivity.this);

        aa = new TaskAdapter(this, R.layout.row, tasks);
        lv.setAdapter(aa);


        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<Task> newTask = db.getTasks();

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }

                tvResults.setText(txt);
                tasks.clear();
                for (int i=0;i< newTask.size();i++){
                    tasks.add( newTask.get(i));
                }
                aa.notifyDataSetChanged();
            }
        });

    }
}
