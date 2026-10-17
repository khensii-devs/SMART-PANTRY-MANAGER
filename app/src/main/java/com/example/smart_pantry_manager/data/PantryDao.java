package com.example.smart_pantry_manager.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PantryDao {

    @Insert
    long insert(PantryItem item);

    @Update
    void update(PantryItem item);

    @Delete
    void delete(PantryItem item);

    @Query("SELECT * FROM pantry_items ORDER BY name ASC")
    List<PantryItem> getAllItems();

    @Query("SELECT * FROM pantry_items WHERE LOWER(name) = LOWER(:name) LIMIT 1")
    PantryItem findByName(String name);
}