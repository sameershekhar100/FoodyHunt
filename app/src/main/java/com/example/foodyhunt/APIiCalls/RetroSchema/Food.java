package com.example.foodyhunt.APIiCalls.RetroSchema;

import com.example.foodyhunt.APIiCalls.RetroSchema.Meal;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Food {
    @SerializedName("meals")
    @Expose
    private ArrayList<Meal> foods;



//    private String category;
//
//    private String area;


    public ArrayList<Meal> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Meal> foods) {
        this.foods = foods;
    }
}
