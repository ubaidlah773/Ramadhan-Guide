package com.example.ramadhanguide;
import android.content.Intent;
import android.widget.ImageButton;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Tarawih extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarawih);
        ImageButton btnBackTarawih = findViewById(R.id.backTarawih);

        btnBackTarawih.setOnClickListener(v -> {
            Intent intent = new Intent(Tarawih.this, MainActivity.class);
            startActivity(intent);
        });
    }

}
