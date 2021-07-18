package com.example.numberotpsignin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.net.Inet4Address;
import java.util.ArrayList;

public class AssignSubjectByHod extends AppCompatActivity {

    LinearLayout linearLayout;
    Button btn1,btn2;
    ArrayList<Subjects> arr;
    DatabaseReference mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_subject_by_hod);
        linearLayout=findViewById(R.id.assignSubjectsByHod);
        btn1=findViewById(R.id.addSubjects);
        btn2=findViewById(R.id.save);
        arr=new ArrayList<>();
        String facultyKey=getIntent().getStringExtra("facultyKey");
        mref= FirebaseDatabase.getInstance().getReference("Faculty");
        mref.child(facultyKey).child("assignsubjects").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                Subjects s=snapshot.getValue(Subjects.class);
                final View v= LayoutInflater.from(getApplicationContext()).inflate(R.layout.fragment_assign__subjectsbyhod,null);
                linearLayout.addView(v);
                final EditText subjectName=(EditText) v.findViewById(R.id.subjectName);
                final EditText programme=v.findViewById(R.id.programme);
                final EditText course=v.findViewById(R.id.course);
                final EditText semester=v.findViewById(R.id.semester);
                subjectName.setText(s.getSubjectname());
                programme.setText(s.programme);
                course.setText(s.course);
                semester.setText(s.sem);
                arr.add(s);
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v= LayoutInflater.from(getApplicationContext()).inflate(R.layout.fragment_assign__subjectsbyhod,null);
                linearLayout.addView(v);
                final EditText subjectName=(EditText) v.findViewById(R.id.subjectName);
                        subjectName.setEnabled(true);
                v.findViewById(R.id.programme).setEnabled(true);
                v.findViewById(R.id.course).setEnabled(true);
                v.findViewById(R.id.semester).setEnabled(true);
               Button remove= (Button)v.findViewById(R.id.remove);
               remove.setText("cancel");
                Button update= (Button)v.findViewById(R.id.updateOrSave);
                update.setText("Save");
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Button b=(Button)view;
                        final EditText subjectName=(EditText) v.findViewById(R.id.subjectName);
                        final EditText programme=v.findViewById(R.id.programme);
                        final EditText course=v.findViewById(R.id.course);
                        final EditText semester=v.findViewById(R.id.semester);

                        Subjects newSubject=new Subjects(
                                subjectName.getText().toString(),
                                programme.getText().toString(),
                                course.getText().toString(),
                                semester.getText().toString()
                                );

                        if(b.getText().toString().equalsIgnoreCase("Save")){
                            arr.add(newSubject);
                            mref.child(facultyKey).child("assignsubjects").setValue(arr);
                            Intent i=new Intent(getApplicationContext(),AssignSubjectByHod.class);
                            i.putExtra("facultyKey",facultyKey);
                            startActivity(i);
                            finish();
                        }
                    }
                });
            }
        });
        btn2.setText("BACK");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(),FacultyProfile.class);
                i.putExtra("facultyKey",facultyKey);
                startActivity(i);
            }
        });

    }
}