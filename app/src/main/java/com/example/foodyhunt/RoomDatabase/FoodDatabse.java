package com.example.foodyhunt.RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodyhunt.RoomDatabase.DBComponents.FoodDao;
import com.example.foodyhunt.RoomDatabase.DBComponents.FoodEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



    @Database(entities = {FoodEntity.class}, version = 1, exportSchema = false)
    public abstract class FoodDatabse extends RoomDatabase {
        public abstract FoodDao getDao();

        private static volatile FoodDatabse INSTANCE;
        private static final int NUMBER_OF_THREADS = 4;
        static final ExecutorService databaseWriteExecutor =
                Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        static FoodDatabse getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (FoodDatabse.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                FoodDatabse.class, "food_database")
                                .build();
                    }
                }
            }
            return INSTANCE;
        }
    }

