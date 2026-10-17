
package com.example.smart_pantry_manager.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {PantryItem.class, Recipe.class, RecipeIngredient.class},
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PantryDao pantryDao();
    public abstract RecipeDao recipeDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "smart_pantry_db"
            ).allowMainThreadQueries().build(); // simple for assignment; note in report
        }
        return INSTANCE;
    }
}