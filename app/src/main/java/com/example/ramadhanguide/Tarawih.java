package com.example.ramadhanguide;
import android.content.Intent;
import android.widget.ImageButton;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.icu.util.IslamicCalendar;
import android.icu.util.ULocale;
import android.widget.TextView;

public class Tarawih extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarawih);
        ImageButton btnBackTarawih = findViewById(R.id.backTarawih);

        ULocale locale = new ULocale("ar_SA");
        IslamicCalendar islamicCalendar = new IslamicCalendar(locale);
        int month = islamicCalendar.get(IslamicCalendar.MONTH);
        int day = islamicCalendar.get(IslamicCalendar.DAY_OF_MONTH);
        String[] islamicMonths = {
                "Muharram", "Safar", "Rabiul Awal", "Rabiul Akhir",
                "Jumadil Awal", "Jumadil Akhir", "Rajab", "Sya'ban",
                "Ramadhan", "Syawal", "Dzulqa'dah", "Dzulhijjah"
        };

        TextView tarawihDayTextView = findViewById(R.id.tarawihDay);
        String tarawihDayText = (day + " " + islamicMonths[month]); // Concatenate day and month
        tarawihDayTextView.setText(tarawihDayText);

        btnBackTarawih.setOnClickListener(v -> {
            Intent intent = new Intent(Tarawih.this, MainActivity.class);
            startActivity(intent);
        });
    }

}
