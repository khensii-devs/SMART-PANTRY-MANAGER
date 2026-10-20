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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        editName = findViewById(R.id.editName);
        editQuantity = findViewById(R.id.editQuantity);
        editUnit = findViewById(R.id.editUnit);
        Button buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(v -> {
            // 1. Get the text from the boxes
            String name = editName.getText().toString().trim();
            String quantityStr = editQuantity.getText().toString().trim();
            String unit = editUnit.getText().toString().trim();

            // 2. Validation
            if (name.isEmpty() || quantityStr.isEmpty() || unit.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // 3. Convert quantity to a number
            double quantity;
            try {
                quantity = Double.parseDouble(quantityStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Quantity must be a number", Toast.LENGTH_SHORT).show();
                return;
            }

            // 4. Save to database
            AppDatabase db = AppDatabase.getInstance(this);
            PantryItem newItem = new PantryItem(name, quantity, unit, null);
            db.pantryDao().insert(newItem);

            // 5. Show success message and close this screen
            Toast.makeText(this, "Ingredient Added!", Toast.LENGTH_SHORT).show();
            finish(); // This takes the user back to the Pantry List
        });
    }
}