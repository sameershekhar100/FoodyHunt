package com.example.foodyhunt.RoomDatabase.DBComponents;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FoodEntity foodEntity);

    @Delete
    void delete(FoodEntity foodEntity);

    @Query("SELECT * FROM food_table ORDER BY title ASC")
    LiveData<List<FoodEntity>> getAllFood();


}
