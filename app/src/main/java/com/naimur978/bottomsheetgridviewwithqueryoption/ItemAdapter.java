package com.naimur978.bottomsheetgridviewwithqueryoption;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<ModelClass> mList;


    ItemAdapter(List<ModelClass> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClass item = this.mList.get(position);

        holder.txtFoodName.setText(item.getName());
        Picasso.get().load(item.image).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView txtFoodName;


        MyViewHolder(View itemView) {
            super(itemView);
            imageView =  itemView.findViewById(R.id.imageView);
            txtFoodName =  itemView.findViewById(R.id.txtFoodName);
        }


    }


}