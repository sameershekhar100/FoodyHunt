package com.example.foodyhunt.APIiCalls;


import com.example.foodyhunt.APIiCalls.RetroSchema.Food;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceHolder {
    @GET("random.php")
    Call<Food> getFood();

    @GET("search.php")
    Call<Food> getMyFood(@Query("s") String foodName);
}
