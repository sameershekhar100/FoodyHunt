package com.example.foodyhunt.RoomDatabase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.foodyhunt.RoomDatabase.DBComponents.FoodDao;
import com.example.foodyhunt.RoomDatabase.DBComponents.FoodEntity;

import java.util.List;

 public class SavedFoodRepository {
    FoodDao foodDao;
   public LiveData<List<FoodEntity>> allNotes;

    public SavedFoodRepository(Application application) {
        FoodDatabse db = FoodDatabse.getDatabase(application);
        foodDao = db.getDao();
        allNotes = foodDao.getAllFood();

    }

    public void insert(FoodEntity food) {
        FoodDatabse.databaseWriteExecutor.execute(() -> {
            foodDao.insert(food);
        });
    }

    public void delete(FoodEntity food) {
        FoodDatabse.databaseWriteExecutor.execute(() -> {
            foodDao.delete(food);
        });
    }


 }

