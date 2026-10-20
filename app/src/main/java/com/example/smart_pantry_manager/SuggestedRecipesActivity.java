package com.example.smart_pantry_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_pantry_manager.data.AppDatabase;
import com.example.smart_pantry_manager.data.PantryItem;
import com.example.smart_pantry_manager.data.Recipe;
import com.example.smart_pantry_manager.data.RecipeIngredient;

import java.util.ArrayList;
import java.util.List;

public class SuggestedRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_recipes);

        AppDatabase db = AppDatabase.getInstance(this);
        List<PantryItem> pantry = db.pantryDao().getAllItems();
        List<Recipe> allRecipes = db.recipeDao().getAllRecipes();

        List<Recipe> matchedRecipes = new ArrayList<>();

        // Run the strict matching logic for EVERY recipe
        for (Recipe recipe : allRecipes) {
            List<RecipeIngredient> required = db.recipeDao().getIngredientsForRecipe(recipe.id);
            if (IngredientMatcher.canMakeRecipe(recipe, required, pantry)) {
                matchedRecipes.add(recipe);
            }
        }

        // Setup UI
        RecyclerView recyclerView = findViewById(R.id.recipesRecyclerView);
        TextView emptyText = findViewById(R.id.emptyText);

        if (matchedRecipes.isEmpty()) {
            emptyText.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            emptyText.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new RecipeAdapter(matchedRecipes));
        }
    }

    // Simple inner adapter for the recipes list
    private static class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
        private final List<Recipe> recipes;

        RecipeAdapter(List<Recipe> recipes) { this.recipes = recipes; }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(recipes.get(position).name);
        }

        @Override
        public int getItemCount() { return recipes.size(); }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            ViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1);
            }
        }
    }
}