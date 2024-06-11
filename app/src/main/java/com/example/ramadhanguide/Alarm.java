package com.example.ramadhanguide;
import android.content.Intent;
import android.widget.ImageButton;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Alarm extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

        ImageButton btnBack = findViewById(R.id.backAlarm);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Alarm.this, MainActivity.class);
            startActivity(intent);
        });
    }

}
