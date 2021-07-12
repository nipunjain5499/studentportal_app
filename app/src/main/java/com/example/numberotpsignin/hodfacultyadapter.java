package com.example.numberotpsignin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
          holder.t1.setText(helperclass.name);
          holder.t2.setText(helperclass.contactno);
          holder.t3.setText(helperclass.getDepartment());
//          holder.itemView.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                //  Intent i=new Intent(view.getContext(),FacultyProfile.class);
//              //    i.putExtra("faculty",helperclass.contactno);
//
//               //  view.getContext().startActivity(i);
//              }
//          });
    }

    @Override
    public int getItemCount() {
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

