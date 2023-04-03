package com.example.sqllitedatafatchonrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqllitedatafatchonrecyclerview.databinding.ItemviewBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private ArrayList name_id,dept_id,city_id;

    public MyAdapter(Context context, ArrayList name_id, ArrayList dept_id, ArrayList city_id) {
        this.context = context;
        this.name_id = name_id;
        this.dept_id = dept_id;
        this.city_id = city_id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemview,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvName.setText(String.valueOf(name_id.get(position)));
        holder.binding.tvDpt.setText(String.valueOf(dept_id.get(position)));
        holder.binding.tvCity.setText(String.valueOf(city_id.get(position)));

    }


    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemviewBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ItemviewBinding.bind(itemView);
        }
    }
}
