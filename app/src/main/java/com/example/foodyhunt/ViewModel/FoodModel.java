package com.example.foodyhunt.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodyhunt.APIiCalls.RetroSchema.Food;
import com.example.foodyhunt.APIiCalls.PlaceHolder;
import com.example.foodyhunt.APIiCalls.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodModel extends ViewModel {
    private MutableLiveData<Food> liveData;
    private MutableLiveData<Food> liveData2;

    public FoodModel() {
        liveData=new MutableLiveData<>();
        liveData2=new MutableLiveData<>();
    }

//    public MutableLiveData<Food> getLiveData() {
//        return liveData;
//    }

    public MutableLiveData<Food> getLiveData2() {
        return liveData2;
    }

//    public void makeApiCall(String s){
//        PlaceHolder placeHolder= RetroInstance.getRetroClient().create(PlaceHolder.class);
//        Call<Food> call=placeHolder.getMyFood(s);
//        call.enqueue(new Callback<Food>() {
//            @Override
//            public void onResponse(Call<Food> call, Response<Food> response) {
////
//                liveData.postValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Food> call, Throwable t) {
//                liveData.postValue(null);
//
//            }
//        });
//    }
    public void makeApiCall2(){
        PlaceHolder placeHolder= RetroInstance.getRetroClient().create(PlaceHolder.class);
        Call<Food> call=placeHolder.getFood();
        call.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
//
                liveData2.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                liveData2.postValue(null);

            }
        });
    }

}
