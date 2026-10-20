package com.example.smart_pantry_manager;

import com.example.smart_pantry_manager.data.PantryItem;
import com.example.smart_pantry_manager.data.Recipe;
import com.example.smart_pantry_manager.data.RecipeIngredient;

import java.util.List;

public class IngredientMatcher {

    // Normalizes names so "Tomato" and "tomatoes" match
    public static String normalize(String name) {
        if (name == null) return "";
        String norm = name.toLowerCase().trim();
        if (norm.endsWith("es")) {
            norm = norm.substring(0, norm.length() - 2);
        } else if (norm.endsWith("s")) {
            norm = norm.substring(0, norm.length() - 1);
        }
        return norm;
    }

    // THE STRICT MATCHING RULE
    public static boolean canMakeRecipe(Recipe recipe, List<RecipeIngredient> requiredIngredients, List<PantryItem> pantry) {
        for (RecipeIngredient req : requiredIngredients) {
            String reqName = normalize(req.ingredientName);
            boolean foundEnough = false;

            for (PantryItem item : pantry) {
                if (normalize(item.name).equals(reqName)) {
                    // Check quantity (if they have more than or equal to what's needed)
                    if (item.quantity >= req.quantity) {
                        foundEnough = true;
                        break;
                    }
                }
            }
            // If we didn't find this ingredient in sufficient quantity, the recipe fails
            if (!foundEnough) {
                return false;
            }
        }
        // If we checked every ingredient and found them all, return true!
        return true;
    }
}