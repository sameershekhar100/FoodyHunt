package com.example.foodyhunt.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.foodyhunt.RoomDatabase.DBComponents.FoodEntity;
import com.example.foodyhunt.RoomDatabase.SavedFoodRepository;

import java.util.List;

public class SavedModel extends AndroidViewModel {

    private SavedFoodRepository mRepository;
    LiveData<List<FoodEntity>> savedFood;

    public SavedModel(@NonNull Application application) {
        super(application);
        mRepository=new SavedFoodRepository(application);
        savedFood=mRepository.allNotes;
    }

    public LiveData<List<FoodEntity>> getMallNotes() {
        return savedFood;
    }

    public void insert(FoodEntity food){
        mRepository.insert(food);
    }

    public void delete(FoodEntity food){
        mRepository.delete(food);
    }

}
