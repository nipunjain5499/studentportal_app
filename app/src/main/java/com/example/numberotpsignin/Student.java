package com.example.numberotpsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.stud, new Studprofile())
                .commit();

    }
}