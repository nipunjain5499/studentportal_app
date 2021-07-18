package com.example.numberotpsignin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class FacultyProfile extends AppCompatActivity {

    ImageView img1,img2;
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_profile);
        String facultyKey=getIntent().getStringExtra("facultyKey");
        email=findViewById(R.id.facultyEmail);
        DatabaseReference facultyInfo=FirebaseDatabase.getInstance().getReference("Faculty");
        facultyInfo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                  facultyassign facultyInfo=snapshot.child(facultyKey).getValue(facultyassign.class);

                        TextView facultyName=findViewById(R.id.facultyName);
                        TextView facultyContactNo=findViewById(R.id.facultyContactNo);
                        TextView facultyDepartment=findViewById(R.id.facultyDepartment);
                        TextView facultyDesignation=findViewById(R.id.facultyDesignation);
                        TextView facultyProctor=findViewById(R.id.facultyProctor);
                        LinearLayout facultyMySubjects=(LinearLayout) findViewById(R.id.facultySubjects);
                        LinearLayout facultyAssignSubjects=(LinearLayout) findViewById(R.id.facultyAssignSubjects);
                        facultyName.setText(facultyInfo.getName());
                        facultyContactNo.setText(facultyInfo.getContactno());
                        facultyDesignation.setText(facultyInfo.getDesignation());
                        facultyDepartment.setText(facultyInfo.getDepartment());
                        for(String temp:facultyInfo.getFacultyinterestedsub()){
                        TextView addFacultySubjects=new TextView(getApplicationContext());
                        facultyMySubjects.addView(addFacultySubjects);
                        addFacultySubjects.setText(temp);
                        }
                        if(facultyInfo.getAssignsubjects()==null){
                            TextView tx=new TextView(getApplicationContext());
                            tx.setText("No Assigned Subjects");
                            facultyAssignSubjects.addView(tx);
                        }
                        else {
                            for (Subjects temp : facultyInfo.getAssignsubjects()) {
                                TextView addFacultySubjects = new TextView(getApplicationContext());
                                facultyAssignSubjects.addView(addFacultySubjects);
                                addFacultySubjects.setText(temp.subjectname);
                            }
                        }
                ProctorClass m=facultyInfo.getAssignproctore();
                if(m.getProctore()) facultyProctor.setText(m.branch+" "+m.department+" "+m.semester);
                else facultyProctor.setText("Not a Proctor");
                        email.setText(facultyInfo.getEmail());
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        img1=(ImageView) findViewById(R.id.emailintent);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{email.getText().toString()});
                startActivity(intent);
            }
        });
        img2=findViewById(R.id.contacttodialer);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91"+facultyKey));
                startActivity(intent);

            }
        });
        Button b=findViewById(R.id.assignSubjects);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),AssignSubjectByHod.class);
                i.putExtra("facultyKey",facultyKey);
                startActivity(i);
            }
        });
        Button aP=findViewById(R.id.assignAsProctor);
        aP.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(),AssignProctore.class);
                i.putExtra("facultyKey",facultyKey);
                startActivity(i);
            }
        });
    }
}