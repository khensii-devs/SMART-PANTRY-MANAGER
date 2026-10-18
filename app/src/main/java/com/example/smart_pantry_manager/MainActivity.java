package com.example.smart_pantry_manager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.smart_pantry_manager.data.AppDatabase;
import com.example.smart_pantry_manager.data.SeedData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- DATABASE SEEDING ---
        AppDatabase db = AppDatabase.getInstance(this);
        SeedData.seed(db);

        // PRINT TO LOGCAT TO VERIFY
        System.out.println("DATABASE CHECK: Total recipes in DB = " + db.recipeDao().getRecipeCount());
    }
}