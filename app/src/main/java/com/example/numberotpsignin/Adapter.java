package com.example.numberotpsignin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.holder> {

    ArrayList<Helperclass> data;

    public Adapter(ArrayList<Helperclass> data) {
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.hodstudentsitemview,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Adapter.holder holder, int position) {
        Helperclass helperclass=data.get(position);
        holder.t1.setText(helperclass.roll_number);
        holder.t2.setText(helperclass.name);
        holder.t3.setText(helperclass.course);

//      holder.t1.setText(helperclass.name);
//        holder.t2.setText(helperclass.father_name);
//        holder.t3.setText(helperclass.course);
//        holder.t4.setText(helperclass.roll_number);
//        holder.t5.setText(helperclass.email);
//        holder.t6.setText(helperclass.contact_no);
//        holder.t7.setText(helperclass.address);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class holder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4,t5,t6,t7;

    public holder(@NonNull @NotNull View itemView) {
        super(itemView);
        t1=(TextView)itemView.findViewById(R.id.tv1);
        t2=(TextView)itemView.findViewById(R.id.tv2);
        t3=(TextView)itemView.findViewById(R.id.tv3);
//        t4=(TextView)itemView.findViewById(R.id.tv4);
//        t5=(TextView)itemView.findViewById(R.id.tv5);
//        t6=(TextView)itemView.findViewById(R.id.tv6);
//        t7=(TextView)itemView.findViewById(R.id.tv7);
    }
}
}
