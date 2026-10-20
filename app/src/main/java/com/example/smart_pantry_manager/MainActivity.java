package com.example.smart_pantry_manager;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_pantry_manager.data.AppDatabase;
import com.example.smart_pantry_manager.data.PantryItem;
import com.example.smart_pantry_manager.data.SeedData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PantryAdapter adapter;
    private AppDatabase db;

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

        // 1. Setup database and seed recipes
        db = AppDatabase.getInstance(this);
        SeedData.seed(db);

        // 2. Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.pantryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. Load pantry items
        List<PantryItem> items = db.pantryDao().getAllItems();
        adapter = new PantryAdapter(items);
        recyclerView.setAdapter(adapter);

        // 4. Make the + button open the Add Screen (Step 7)
        findViewById(R.id.addItemButton).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddEditItemActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the list when we return to this screen
        if (adapter != null) {
            adapter.setPantryList(db.pantryDao().getAllItems());
        }
    }
}