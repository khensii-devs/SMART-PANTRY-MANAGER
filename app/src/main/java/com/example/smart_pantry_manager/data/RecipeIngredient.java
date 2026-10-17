package com.example.smart_pantry_manager.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe_ingredients")
public class RecipeIngredient {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int recipeId;       // foreign key to Recipe.id
    public String ingredientName;
    public double quantity;
    public String unit;

    public RecipeIngredient(int recipeId, String ingredientName,
                            double quantity, String unit) {
        this.recipeId = recipeId;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.unit = unit;
    }
}