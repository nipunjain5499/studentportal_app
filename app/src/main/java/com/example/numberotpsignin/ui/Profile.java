package com.example.numberotpsignin.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.numberotpsignin.R;

import org.jetbrains.annotations.NotNull;


public class Profile extends Fragment {

    TextView hodname,hodemail,hodcontact,department,designation;


    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hodname=view.findViewById(R.id.hodName);
        hodcontact=view.findViewById(R.id.hodContactNo);
        hodemail=view.findViewById(R.id.hodEmail);
        department=view.findViewById(R.id.hodDepartment);
        designation=view.findViewById(R.id.hodDesignation);
        hodname.setText("Dr. Neetu Sharma");
        hodemail.setText("hod.gangainstitute@gmail.com");
        hodcontact.setText("9599638273");
        designation.setText("Head of Department");
        department.setText("Computer Science");

    }
}