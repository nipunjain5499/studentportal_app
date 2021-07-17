package com.example.numberotpsignin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class AssignProctore extends AppCompatActivity {
    EditText aPB,aPS,aPD;
    Button assign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_proctore);
        String facultykey=getIntent().getStringExtra("facultyKey");
        aPB=findViewById(R.id.assignProctoreBranch);
        aPD=findViewById(R.id.assignProctoreDepartment);
        aPS=findViewById(R.id.assignProctoreSemester);

        assign=findViewById(R.id.assignButton);
        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProctorClass ap = new ProctorClass(
                        aPB.getText().toString(),
                        true,
                        aPS.getText().toString(),
                        aPD.getText().toString()
                );
                DatabaseReference db = FirebaseDatabase.getInstance().getReference("Faculty");
                db.child(facultykey).child("assignproctore").setValue(ap);
            }
            });

    }
}