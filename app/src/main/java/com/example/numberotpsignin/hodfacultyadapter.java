package com.example.numberotpsignin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class hodfacultyadapter extends RecyclerView.Adapter<hodfacultyadapter.holder> {
    ArrayList<facultyassign> facultydata;

    public hodfacultyadapter(ArrayList<facultyassign> facultydata) {
        this.facultydata = facultydata;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.hod_facultylistitem,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        facultyassign helperclass=facultydata.get(position);
          holder.t1.setText(helperclass.getName());
          holder.t2.setText(helperclass.getContactno());
          holder.t3.setText(helperclass.getDepartment());
          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  AppCompatActivity activity=(AppCompatActivity) view.getContext();
                  activity.getSupportFragmentManager().beginTransaction()
                          .replace(R.id.nav_host_fragment_content_hod,new FacultyProfile(helperclass.getContactno()));
              }
          });
    }

    @Override public int getItemCount() {
        return facultydata.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public holder(@NonNull @NotNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.facultyName);
            t2=(TextView)itemView.findViewById(R.id.facultyContactNumber);
            t3=(TextView)itemView.findViewById(R.id.facultyDepartment);

        }
    }


    }

