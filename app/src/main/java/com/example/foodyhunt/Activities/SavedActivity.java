package com.example.foodyhunt.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyhunt.Adaptars.ISavedAdapter;
import com.example.foodyhunt.Adaptars.SavedAdapter;
import com.example.foodyhunt.RoomDatabase.DBComponents.FoodEntity;
import com.example.foodyhunt.R;
import com.example.foodyhunt.ViewModel.SavedModel;

import java.util.ArrayList;
import java.util.List;

public class SavedActivity extends AppCompatActivity implements ISavedAdapter {
    RecyclerView savedFood;
    ArrayList<FoodEntity> arrayList = new ArrayList<>();
    SavedAdapter savedAdapter =new SavedAdapter(this,this);
    SavedModel savedModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        Intent intent=getIntent();
        String food=intent.getStringExtra("food");
        savedFood = findViewById(R.id.savedCollection);
        savedFood.setLayoutManager(new LinearLayoutManager(this));

        savedFood.setAdapter(savedAdapter);
        savedModel=new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication())).get(SavedModel.class);
        savedModel.getMallNotes().observe(this, new Observer<List<FoodEntity>>() {
            @Override
            public void onChanged(List<FoodEntity> foodEntities) {
                savedAdapter.update(foodEntities);

            }
        });
        if (!(food ==null)){
            add(food);
        }
    }

    void add(String food){
        FoodEntity foodEntity=new FoodEntity(food);

        savedModel.insert(foodEntity);
    }

    @Override
    public void onItemClicked(FoodEntity foodEntity) {
        savedModel.delete(foodEntity);
    }
}