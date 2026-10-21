package com.example.smart_pantry_manager;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smart_pantry_manager.data.AppDatabase;
import com.example.smart_pantry_manager.data.Recipe;
import com.example.smart_pantry_manager.data.RecipeIngredient;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // 1. Get the recipe ID passed from the previous screen
        int recipeId = getIntent().getIntExtra("RECIPE_ID", -1);

        if (recipeId != -1) {
            AppDatabase db = AppDatabase.getInstance(this);
            Recipe recipe = db.recipeDao().getRecipeById(recipeId);
            List<RecipeIngredient> ingredients = db.recipeDao().getIngredientsForRecipe(recipeId);

            // 2. Populate the UI
            TextView nameText = findViewById(R.id.detailRecipeName);
            TextView ingredientsText = findViewById(R.id.detailIngredients);
            TextView stepsText = findViewById(R.id.detailSteps);

            if (recipe != null) {
                nameText.setText(recipe.name);
                stepsText.setText(recipe.steps);

                // Build the ingredients string
                StringBuilder sb = new StringBuilder();
                for (RecipeIngredient ing : ingredients) {
                    sb.append("- ").append(ing.quantity).append(" ").append(ing.unit)
                            .append(" of ").append(ing.ingredientName).append("\n");
                }
                ingredientsText.setText(sb.toString().trim());
            }
        }
    }
}