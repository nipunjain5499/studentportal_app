package com.example.numberotpsignin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class faculty extends AppCompatActivity {

    Button btn1;
    TextView addMoreSubjects;
    EditText sub1,e1,e2,e3,e4,e5;
    LinearLayout linearLayout;
    ArrayList <EditText> inputSubjects;
    ArrayList<Subjects> subjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        setTitle("Faculty");
        addMoreSubjects=findViewById(R.id.addMoreSubjects);
        linearLayout=(LinearLayout)findViewById(R.id.interestedSubjects);
        sub1=findViewById(R.id.subject1);
        btn1=findViewById(R.id.facultysubmit);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        e3=findViewById(R.id.ed3);
        e4=findViewById(R.id.ed4);
        e5=findViewById(R.id.ed5);
        inputSubjects=new ArrayList<>();
        subjects=new ArrayList<>();
        addMoreSubjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText subject=new EditText(getApplicationContext());
                subject.setHint("Add Subject");
                if(!inputSubjects.isEmpty()){
                    EditText editText=inputSubjects.get(inputSubjects.size()-1);
                    if(!editText.getText().toString().isEmpty()) {
                        linearLayout.addView(subject);
                        inputSubjects.add(subject);
                    }
                }
                else if(!sub1.getText().toString().isEmpty()) {
                    linearLayout.addView(subject);
                    inputSubjects.add(subject);
                }

            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> submitsubjects=new ArrayList<>();
                String name=e1.getText().toString();
                String designation=e2.getText().toString();
                String department=e3.getText().toString();
                String contact=e4.getText().toString();
                String email=e5.getText().toString();
                if(!inputSubjects.isEmpty()) {
                    submitsubjects.add(sub1.getText().toString());
                    for(EditText temp:inputSubjects){
                        submitsubjects.add(temp.getText().toString());
                    }
                }
                else{
                    submitsubjects.add(sub1.getText().toString());
                }
                facultyassign facultyassign=new facultyassign(name,designation,department,contact,false,null,submitsubjects,email);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference().child("Faculty");
                myref.child(contact).setValue(facultyassign);
                view.setEnabled(false);
            }
        });

    }
}
