package com.example.smart_pantry_manager.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pantry_items")
public class PantryItem {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;       // e.g. "tomato"
    public double quantity;   // e.g. 3.0
    public String unit;       // e.g. "pieces", "g", "ml"
    public String expiryDate; // optional, format "yyyy-MM-dd", nullable

    public PantryItem(String name, double quantity, String unit, String expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expiryDate = expiryDate;
    }
}



