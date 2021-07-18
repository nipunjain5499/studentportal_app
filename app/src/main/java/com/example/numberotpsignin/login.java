package com.example.numberotpsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            Button b1=findViewById(R.id.studentLogin);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(view.getContext(),ActualStudentActivity.class));

                }
            });
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment1, new frag1())
//                    .commit();


    }
}