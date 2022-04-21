package com.example.p2g2t222mini_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<RollHistoryItem> historyList;
    Context context;

    public RecyclerViewAdapter(List<RollHistoryItem> historyList, Context context) {
        this.historyList = historyList;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleText.setText(historyList.get(position).getDiceName());
        holder.subTitleText.setText(historyList.get(position).getRollAmount());
        Glide.with(context).load(historyList.get(position).getDiceImage()).into(holder.listImage);


    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView listImage;
        TextView titleText;
        TextView subTitleText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            listImage = itemView.findViewById(R.id.iddumbboi);
            titleText = itemView.findViewById(R.id.ListTitle);
            subTitleText = itemView.findViewById(R.id.ListSubTitle);
        }
    }
}
