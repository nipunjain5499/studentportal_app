package com.example.numberotpsignin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

public class FetchDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Helperclass> helperclasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_details);

        recyclerView=(RecyclerView)findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // String arr[]={"abhi,rajesh,17cse15,cse,abhistyagi@gmail.com,9599642920,a-29 MG uttam nagar","nipun,xyz,17cse35,cse,nipun@gmail.com,95888778787,a-29 MG uttam nagar"};

        helperclasses=new ArrayList<>();
//        Helperclass helperclass1= new Helperclass("abcd","defg","fgij","hdhhd","iiii","oooo","aaaa");
//        Helperclass helperclass2= new Helperclass("abcdgg","defg","fgij","hdhhd","iiii","oooo","aaaa");
//        Helperclass helperclass3= new Helperclass("abcddg","defg","fgij","hdhhd","iiii","oooo","aaaa");
//        Helperclass helperclass4= new Helperclass("abcdfd","defg","fgij","hdhhd","iiii","oooo","aaaa");
//        Helperclass helperclass5= new Helperclass("abcddvgr","defg","fgij","hdhhd","iiii","oooo","aaaa");
//        helperclasses.add(helperclass1);
//        helperclasses.add(helperclass2);
//        helperclasses.add(helperclass3);
//        helperclasses.add(helperclass4);
//        helperclasses.add(helperclass5);

        recyclerView.setAdapter(new Adapter(helperclasses));

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference().child("Student");


        ChildEventListener childEventListener= new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                Helperclass helper=snapshot.getValue(Helperclass.class);
                helperclasses.add(helper);
                recyclerView.getAdapter().notifyDataSetChanged();

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
        };

          ref.addChildEventListener(childEventListener);

    }
}