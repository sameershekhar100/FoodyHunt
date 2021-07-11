package com.example.foodyhunt.RoomDatabase.DBComponents;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class FoodEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

//    @ColumnInfo(name = "catgory")
//    private String category;

//    @ColumnInfo(name = "area")
//    private String area;

    public FoodEntity(String title) {
        this.title = title;
//        this.category = category;
//        this.area = area;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

//    public String getCategory() {
//        return category;
//    }

//    public String getArea() {
//        return area;
//    }
}
