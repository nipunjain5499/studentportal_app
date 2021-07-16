package com.example.numberotpsignin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class FacultyProfile extends Fragment {

    ImageView img1,img2;
    private String facultyKey;
    TextView facultyemail;

    public FacultyProfile(String facultyKey) {
        this.facultyKey = facultyKey;
    }
    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_faculty_profile);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_faculty_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // String facultyKey=getIntent().getStringExtra("facultyKey");
       // String facultyKey=getView().getContext().getString(toString("facultyKey"));
        DatabaseReference facultyInfo=FirebaseDatabase.getInstance().getReference("Faculty");
        facultyInfo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                facultyassign facultyInfo=snapshot.child(facultyKey).getValue(facultyassign.class);
                img1=(ImageView) view.findViewById(R.id.contacttodialer);
                img2=(ImageView) view.findViewById(R.id.emailintent);
                TextView facultyName=view.findViewById(R.id.facultyName);
                TextView facultyContactNo=view.findViewById(R.id.facultyContactNo);
                TextView facultyDepartment=view.findViewById(R.id.facultyDepartment);
                TextView facultyDesignation=view.findViewById(R.id.facultyDesignation);
                LinearLayout facultyMySubjects=(LinearLayout) view.findViewById(R.id.facultySubjects);
                LinearLayout facultyAssignSubjects=(LinearLayout) view.findViewById(R.id.facultyAssignSubjects);
                facultyName.setText(facultyInfo.getName());
                facultyContactNo.setText(facultyInfo.getContactno());
                facultyDesignation.setText(facultyInfo.getDesignation());
                facultyDepartment.setText(facultyInfo.getDepartment());
                for(String temp:facultyInfo.getFacultyinterestedsub()){
                    TextView addFacultySubjects=new TextView(getContext());
                    facultyMySubjects.addView(addFacultySubjects);
                    addFacultySubjects.setText(temp);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        TextView facultyContactNo=view.findViewById(R.id.facultyContactNo);
//        img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+facultyContactNo));
//                startActivity(intent);
//            }
//        });
//
//        facultyemail=(TextView) view.findViewById(R.id.facultyEmail);
//        img2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String recipient=facultyemail.getText().toString().trim();
//                Intent intent=new Intent(Intent.ACTION_SEND);
//                intent.setData(Uri.parse("mailto:"));
//                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{recipient});
//                try{
//                   startActivity(intent);
//                }
//                catch (Exception e){
//                    Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

    }


  //  }
}
