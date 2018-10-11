package com.example.sammitafoya.exercisebuildertest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Exercises exercises;
    public LayoutInflater layoutInflater;
    public LinearLayout linearLayout;
    public String listToEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        exercises = new Exercises();

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        linearLayout = findViewById(R.id.linearLayout);

       listToEmail = " ";
    }

    public void computeExerciseList(View view) {
       TextView  exerciseView = (TextView) layoutInflater.inflate(R.layout.single_exercise_layout, null);

       exerciseView.setText(exercises.getExerciseList());

       Log.i("Sammi",exercises.getExerciseList());

       linearLayout.addView(exerciseView);

       listToEmail += exercises.getExerciseList() + "\n";

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void email(View view) {
        String subject = "List of Exercises";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:samantha_tafoya@redlands.edu"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, listToEmail);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void clear(View view) {
        linearLayout.removeAllViews();
    }
}
