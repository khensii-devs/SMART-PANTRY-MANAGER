package com.example.smart_pantry_manager.data;

import java.util.Arrays;

public class SeedData {

    public static void seed(AppDatabase db) {
        // Check if we already have recipes to prevent duplicating them
        if (db.recipeDao().getRecipeCount() > 0) return;

        // 1. Tomato Pasta
        long r1 = db.recipeDao().insertRecipe(new Recipe("Tomato Pasta", "1. Boil pasta.\n2. Fry tomatoes and garlic.\n3. Mix and serve."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r1, "pasta", 100, "g"),
                new RecipeIngredient((int) r1, "tomato", 2, "pieces"),
                new RecipeIngredient((int) r1, "garlic", 1, "clove")
        ));

        // 2. Egg Omelette
        long r2 = db.recipeDao().insertRecipe(new Recipe("Egg Omelette", "1. Beat eggs.\n2. Fry in pan.\n3. Add cheese if you have it."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r2, "egg", 2, "pieces"),
                new RecipeIngredient((int) r2, "oil", 1, "tbsp")
        ));

        // 3. Cheese Sandwich
        long r3 = db.recipeDao().insertRecipe(new Recipe("Cheese Sandwich", "1. Butter the bread.\n2. Add cheese.\n3. Toast until golden."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r3, "bread", 2, "slices"),
                new RecipeIngredient((int) r3, "cheese", 2, "slices"),
                new RecipeIngredient((int) r3, "butter", 1, "tbsp")
        ));

        // 4. Scrambled Eggs
        long r4 = db.recipeDao().insertRecipe(new Recipe("Scrambled Eggs", "1. Whisk eggs.\n2. Cook in pan with butter.\n3. Stir continuously."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r4, "egg", 3, "pieces"),
                new RecipeIngredient((int) r4, "butter", 1, "tbsp"),
                new RecipeIngredient((int) r4, "milk", 50, "ml")
        ));

        // 5. Tuna Salad
        long r5 = db.recipeDao().insertRecipe(new Recipe("Tuna Salad", "1. Drain tuna.\n2. Mix with mayo.\n3. Serve on lettuce."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r5, "tuna", 1, "can"),
                new RecipeIngredient((int) r5, "mayonnaise", 2, "tbsp"),
                new RecipeIngredient((int) r5, "lettuce", 1, "cup")
        ));

        // 6. Rice and Beans
        long r6 = db.recipeDao().insertRecipe(new Recipe("Rice and Beans", "1. Boil rice.\n2. Heat beans.\n3. Mix together with spices."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r6, "rice", 1, "cup"),
                new RecipeIngredient((int) r6, "beans", 1, "can"),
                new RecipeIngredient((int) r6, "onion", 1, "piece")
        ));

        // 7. Chicken Salad
        long r7 = db.recipeDao().insertRecipe(new Recipe("Chicken Salad", "1. Cook chicken.\n2. Chop lettuce and tomato.\n3. Mix with dressing."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r7, "chicken", 200, "g"),
                new RecipeIngredient((int) r7, "lettuce", 2, "cups"),
                new RecipeIngredient((int) r7, "tomato", 1, "piece"),
                new RecipeIngredient((int) r7, "dressing", 2, "tbsp")
        ));

        // 8. Garlic Bread
        long r8 = db.recipeDao().insertRecipe(new Recipe("Garlic Bread", "1. Mix butter and garlic.\n2. Spread on bread.\n3. Bake until crispy."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r8, "bread", 4, "slices"),
                new RecipeIngredient((int) r8, "butter", 2, "tbsp"),
                new RecipeIngredient((int) r8, "garlic", 2, "cloves")
        ));

        // 9. Peanut Butter Sandwich
        long r9 = db.recipeDao().insertRecipe(new Recipe("Peanut Butter Sandwich", "1. Spread peanut butter on bread.\n2. Put slices together."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r9, "bread", 2, "slices"),
                new RecipeIngredient((int) r9, "peanut butter", 2, "tbsp")
        ));

        // 10. Tomato Soup
        long r10 = db.recipeDao().insertRecipe(new Recipe("Tomato Soup", "1. Blend tomatoes.\n2. Heat with stock.\n3. Add cream."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r10, "tomato", 4, "pieces"),
                new RecipeIngredient((int) r10, "stock", 1, "cup"),
                new RecipeIngredient((int) r10, "cream", 50, "ml")
        ));

        // 11. Mac and Cheese
        long r11 = db.recipeDao().insertRecipe(new Recipe("Mac and Cheese", "1. Boil pasta.\n2. Melt cheese with milk.\n3. Mix together."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r11, "pasta", 200, "g"),
                new RecipeIngredient((int) r11, "cheese", 100, "g"),
                new RecipeIngredient((int) r11, "milk", 100, "ml")
        ));

        // 12. Fruit Salad
        long r12 = db.recipeDao().insertRecipe(new Recipe("Fruit Salad", "1. Chop all fruit.\n2. Mix in a bowl.\n3. Add honey."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r12, "apple", 2, "pieces"),
                new RecipeIngredient((int) r12, "banana", 2, "pieces"),
                new RecipeIngredient((int) r12, "honey", 1, "tbsp")
        ));

        // 13. Beef Tacos
        long r13 = db.recipeDao().insertRecipe(new Recipe("Beef Tacos", "1. Cook beef.\n2. Warm tortillas.\n3. Add cheese and salsa."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r13, "beef", 250, "g"),
                new RecipeIngredient((int) r13, "tortilla", 3, "pieces"),
                new RecipeIngredient((int) r13, "cheese", 50, "g"),
                new RecipeIngredient((int) r13, "salsa", 2, "tbsp")
        ));

        // 14. Pancakes
        long r14 = db.recipeDao().insertRecipe(new Recipe("Pancakes", "1. Mix flour, egg, and milk.\n2. Fry on pan.\n3. Serve with syrup."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r14, "flour", 1, "cup"),
                new RecipeIngredient((int) r14, "egg", 1, "piece"),
                new RecipeIngredient((int) r14, "milk", 1, "cup"),
                new RecipeIngredient((int) r14, "syrup", 2, "tbsp")
        ));

        // 15. Yogurt Parfait
        long r15 = db.recipeDao().insertRecipe(new Recipe("Yogurt Parfait", "1. Layer yogurt and fruit.\n2. Top with granola."));
        db.recipeDao().insertIngredients(Arrays.asList(
                new RecipeIngredient((int) r15, "yogurt", 1, "cup"),
                new RecipeIngredient((int) r15, "berries", 0.5, "cup"),
                new RecipeIngredient((int) r15, "granola", 0.25, "cup")
        ));
    }
}