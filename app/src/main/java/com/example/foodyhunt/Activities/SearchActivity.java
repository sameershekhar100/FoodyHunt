package com.example.foodyhunt.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodyhunt.APIiCalls.RetroSchema.Food;
import com.example.foodyhunt.R;
import com.example.foodyhunt.RoomDatabase.FoodDatabse;
import com.example.foodyhunt.ViewModel.FoodModel;
import com.example.foodyhunt.ViewModel.SearchModel;

public class SearchActivity extends AppCompatActivity {
    TextView textView;
    SearchModel searchModel;
    ImageView searchImg;
    EditText e1;
    String s="";
    Button b1;
    Food mfood=new Food();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        textView=findViewById(R.id.text);
        e1=findViewById(R.id.editText);
        b1=findViewById(R.id.search);
        searchImg=findViewById(R.id.imageView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();

            }
        });


    }

    void makeCall() {

        s=e1.getText().toString();
        searchModel=new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication())).get(SearchModel.class);
        searchModel.getLiveData().observe(this, new Observer<Food>() {
            @Override
            public void onChanged(Food food) {
                mfood=food;
                textView.setText(food.getFoods().get(0).getStrMeal());
                searchImg.setVisibility(View.VISIBLE);
                Glide.with(SearchActivity.this).load(food.getFoods().get(0).getStrMealThumb()).into(searchImg);
            }
        });
        searchModel.makeApiCall(s);
    }
}