package com.example.smart_pantry_manager;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Switch switchAlerts = findViewById(R.id.switchAlerts);
        switchAlerts.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Alerts Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Alerts Disabled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}