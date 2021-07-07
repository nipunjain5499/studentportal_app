package com.example.numberotpsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            setTitle("Main");
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent=new Intent(getApplicationContext(),login.class);
//                startActivity(intent);

//                Intent intent=new Intent(getApplicationContext(),Student.class);
//                startActivity(intent);
//                finish();
                Intent intent=new Intent(getApplicationContext(),FetchDetails.class);
               startActivity(intent);

            }
        },2500);

    }
}