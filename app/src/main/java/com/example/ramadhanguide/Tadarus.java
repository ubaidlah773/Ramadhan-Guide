package com.example.ramadhanguide;
import android.content.Intent;
import android.widget.ImageButton;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Tadarus extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tadarus);

        ImageButton btnBack = findViewById(R.id.backTadarus);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Tadarus.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
