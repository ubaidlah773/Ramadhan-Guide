package com.example.ramadhanguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.icu.util.IslamicCalendar;
import android.icu.util.ULocale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        TextView monthIslamic = findViewById(R.id.monthIslamic);
        TextView monthCard = findViewById(R.id.monthCard);
        TextView yearIslamic = findViewById(R.id.yearIslamic);
        TextView dayNumber = findViewById(R.id.dayNumber);
        TextView dayOffCounter = findViewById(R.id.dayOffCounter);

        //Button
        ImageButton btnAlarm = findViewById(R.id.btnAlarm);
        ImageButton btnTarawih = findViewById(R.id.btnTarawih);
        ImageButton btnTadarus = findViewById(R.id.btnTadarus);

        ULocale locale = new ULocale("ar_SA");
        IslamicCalendar islamicCalendar = new IslamicCalendar(locale);

        int year = islamicCalendar.get(IslamicCalendar.YEAR);
        int month = islamicCalendar.get(IslamicCalendar.MONTH);
        int day = islamicCalendar.get(IslamicCalendar.DAY_OF_MONTH);
        int daysInMonth = islamicCalendar.getActualMaximum(IslamicCalendar.DAY_OF_MONTH);

        // Islamic month names
        String[] islamicMonths = {
                "Muharram", "Safar", "Rabiul Awal", "Rabiul Akhir",
                "Jumadil Awal", "Jumadil Akhir", "Rajab", "Sya'ban",
                "Ramadhan", "Syawal", "Dzulqa'dah", "Dzulhijjah"
        };

        // Month
        monthIslamic.setText(islamicMonths[month]);
        // Year
        yearIslamic.setText(String.valueOf(year));
        // Date
        dayNumber.setText(String.valueOf(day));
        // Day Counter
        dayOffCounter.setText(String.valueOf(daysInMonth));

        //set Month on Card
        monthCard.setText(islamicMonths[month]);


        //Button
        btnAlarm.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Alarm.class);
            startActivity(intent);
        });

        btnTarawih.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Tarawih.class);
            startActivity(intent);
        });

        btnTadarus.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Tadarus.class);
            startActivity(intent);
        });

    }
}
