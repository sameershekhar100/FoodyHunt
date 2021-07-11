package com.example.foodyhunt.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.foodyhunt.APIiCalls.RetroSchema.Food;
import com.example.foodyhunt.R;
import com.example.foodyhunt.ViewModel.FoodModel;

public class MainActivity extends AppCompatActivity {

    TextView randomfood;
    FoodModel foodModel;
    ImageView foodImg;
    ProgressBar progressBar;
    Button searchFood, savedFood, addFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomfood = findViewById(R.id.randomFood);
        savedFood = findViewById(R.id.save);
        searchFood = findViewById(R.id.search);
        addFood = findViewById(R.id.saveFood);
        progressBar = findViewById(R.id.progress);
        foodImg = findViewById(R.id.foodImg);
        randomfoodGenerator();
        Intent intent = new Intent(getApplicationContext(), SavedActivity.class);

        searchFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SearchActivity.class));
            }
        });
        savedFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("food", randomfood.getText().toString() + "");
                addFood.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Food added", Toast.LENGTH_SHORT).show();

            }
        });
    }


    void randomfoodGenerator() {
        progressBar.setVisibility(View.VISIBLE);
        foodModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication())).get(FoodModel.class);
        foodModel.getLiveData2().observe(this, new Observer<Food>() {
            @Override
            public void onChanged(Food food) {
                randomfood.setText(food.getFoods().get(0).getStrMeal());
                Glide.with(MainActivity.this).load(food.getFoods().get(0).getStrMealThumb()).into(foodImg);
                progressBar.setVisibility(View.GONE);
            }
        });
        foodModel.makeApiCall2();
    }


}