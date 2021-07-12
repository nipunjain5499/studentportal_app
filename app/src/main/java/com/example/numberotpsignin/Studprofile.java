package com.example.numberotpsignin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Studprofile extends Fragment {

    Button bt;
    EditText e1,e2,e3,e4,e5,e6,e7;
    ArrayList <Helperclass> helperclasses;

    public Studprofile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_studprofile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bt=(Button) view.findViewById(R.id.submitbtn);
        e1=(EditText) view.findViewById(R.id.ed1);
        e2=(EditText) view.findViewById(R.id.ed2);
        e3=(EditText) view.findViewById(R.id.ed3);
        e4=(EditText) view.findViewById(R.id.ed4);
        e5=(EditText) view.findViewById(R.id.ed5);
        e6=(EditText) view.findViewById(R.id.ed6);
        e7=(EditText) view.findViewById(R.id.ed7);
        TextView e8=(TextView) view.findViewById(R.id.tv2);

        helperclasses = new ArrayList<>();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                //  DatabaseReference myRef = database.getReference("Nipun");// stud ki node banegi db mein
                DatabaseReference myref = database.getReference().child("Student");
                String name=e1.getText().toString();
                String father_name=e2.getText().toString();
                String course=e3.getText().toString();
                String rollno=e4.getText().toString();
                String email=e5.getText().toString();
                String no=e6.getText().toString();
                String address=e7.getText().toString();
                String cno=e8.getText().toString();

                Helperclass helperclass1= new Helperclass(name,father_name,course,rollno,email,no,address,cno);
                myref.child(rollno).setValue(helperclass1);

//                Helperclass helperclass= new Helperclass("abcd","defg","fgij","hdhhd","iiii","oooo","aaaa");
//                Helperclass helperclass2= new Helperclass("abcdgg","defg","fgij","hdhhd","iiii","oooo","aaaa");
//                Helperclass helperclass3= new Helperclass("abcddg","defg","fgij","hdhhd","iiii","oooo","aaaa");
//                Helperclass helperclass4= new Helperclass("abcdfd","defg","fgij","hdhhd","iiii","oooo","aaaa");
//                Helperclass helperclass5= new Helperclass("abcddvgr","defg","fgij","hdhhd","iiii","oooo","aaaa");
//                helperclasses.add(helperclass);
//                helperclasses.add(helperclass2);
//                helperclasses.add(helperclass3);
//                helperclasses.add(helperclass4);
//                helperclasses.add(helperclass5);
//                myref.child("nnjnjhjxhjjn").setValue(helperclasses);


//                myref.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
//                        Helperclass helperclass=snapshot.child("2").getValue(Helperclass.class); // here valueeventlis...  send the reflectiuon of Helperclass to the firebase
//                        System.out.println(helperclass.name);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull @NotNull DatabaseError error) {
//
//                    }
//                });

            }
        });

    }


    // Read from the database
//myRef.addValueEventListener(new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            // This method is called once with the initial value and again
//            // whenever data at this location is updated.
//            String value = dataSnapshot.getValue(String.class);
//            Log.d(TAG, "Value is: " + value);
//        }
//
//        @Override
//        public void onCancelled(DatabaseError error) {
//            // Failed to read value
//            Log.w(TAG, "Failed to read value.", error.toException());
//        }
//    });

}