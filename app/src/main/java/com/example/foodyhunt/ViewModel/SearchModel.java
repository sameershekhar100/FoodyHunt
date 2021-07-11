package com.example.foodyhunt.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodyhunt.APIiCalls.PlaceHolder;
import com.example.foodyhunt.APIiCalls.RetroInstance;
import com.example.foodyhunt.APIiCalls.RetroSchema.Food;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchModel extends ViewModel {
    private MutableLiveData<Food> liveData;
    public SearchModel() {
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<Food> getLiveData() {
        return liveData;
    }

    public void makeApiCall(String s){
        PlaceHolder placeHolder= RetroInstance.getRetroClient().create(PlaceHolder.class);
        Call<Food> call=placeHolder.getMyFood(s);
        call.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
//
                liveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                liveData.postValue(null);

            }
        });
    }
}
