package com.example.foodyhunt.APIiCalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

public static Retrofit retrofit;
public static Retrofit getRetroClient(){
    if(retrofit==null){
        retrofit=new Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
    return retrofit;
}
}
