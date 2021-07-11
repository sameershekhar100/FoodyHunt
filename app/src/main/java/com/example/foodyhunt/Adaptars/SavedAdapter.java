package com.example.foodyhunt.Adaptars;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyhunt.RoomDatabase.DBComponents.FoodEntity;
import com.example.foodyhunt.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SavedAdapter extends RecyclerView.Adapter<SavedAdapter.foodHolder> {
ArrayList<FoodEntity> savedList=new ArrayList<>();

    public ISavedAdapter listener;
    Context mContext;
    public SavedAdapter(Context context,ISavedAdapter listener){
        this.mContext=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public foodHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.saved_item, parent, false);
        foodHolder viewHolder = new foodHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull foodHolder holder, int position) {
        FoodEntity string=savedList.get(position);
        holder.delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("abcd", "we have "+savedList.get(position));
                listener.onItemClicked(savedList.get(position));
            }
        });
        holder.textView.setText(string.getTitle());
    }



    @Override
    public int getItemCount() {
        return savedList.size();
    }

    public void update(List<FoodEntity> arr){
        savedList.clear();
        savedList.addAll(arr);

        notifyDataSetChanged();
    }

    class foodHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView delButton;
        public foodHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            this.textView=itemView.findViewById(R.id.food_item);
            delButton=itemView.findViewById(R.id.delete);
        }
    }
}

