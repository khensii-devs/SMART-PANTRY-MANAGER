package com.example.smart_pantry_manager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.smart_pantry_manager.data.AppDatabase;
import com.example.smart_pantry_manager.data.PantryItem;

public class AddEditItemActivity extends AppCompatActivity {

    private EditText editName, editQuantity, editUnit;
    private PantryItem existingItem = null; // Keeps track if we are editing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        editName = findViewById(R.id.editName);
        editQuantity = findViewById(R.id.editQuantity);
        editUnit = findViewById(R.id.editUnit);
        Button buttonSave = findViewById(R.id.buttonSave);

        // CHECK IF WE ARE EDITING AN EXISTING ITEM
        if (getIntent().hasExtra("ITEM_ID")) {
            int itemId = getIntent().getIntExtra("ITEM_ID", -1);
            AppDatabase db = AppDatabase.getInstance(this);
            // Find the item in the database
            for (PantryItem item : db.pantryDao().getAllItems()) {
                if (item.id == itemId) {
                    existingItem = item;
                    break;
                }
            }

            // Fill the text boxes with the existing data
            if (existingItem != null) {
                editName.setText(existingItem.name);
                editQuantity.setText(String.valueOf(existingItem.quantity));
                editUnit.setText(existingItem.unit);
                buttonSave.setText("Update Ingredient");
            }
        }

        buttonSave.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String quantityStr = editQuantity.getText().toString().trim();
            String unit = editUnit.getText().toString().trim();

            if (name.isEmpty() || quantityStr.isEmpty() || unit.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double quantity;
            try {
                quantity = Double.parseDouble(quantityStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Quantity must be a number", Toast.LENGTH_SHORT).show();
                return;
            }

            AppDatabase db = AppDatabase.getInstance(this);

            if (existingItem != null) {
                // UPDATE EXISTING ITEM
                existingItem.name = name;
                existingItem.quantity = quantity;
                existingItem.unit = unit;
                db.pantryDao().update(existingItem);
                Toast.makeText(this, "Ingredient Updated!", Toast.LENGTH_SHORT).show();
            } else {
                // CREATE NEW ITEM
                PantryItem newItem = new PantryItem(name, quantity, unit, null);
                db.pantryDao().insert(newItem);
                Toast.makeText(this, "Ingredient Added!", Toast.LENGTH_SHORT).show();
            }

            finish(); // Go back to the Pantry List
        });
    }
}