package com.example.alzreminder_caregiver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseObject myFirstClass = new ParseObject("MyFirstClass");
        myFirstClass.put("name", "I'm able to save objects!");
        myFirstClass.saveInBackground();
    }
}