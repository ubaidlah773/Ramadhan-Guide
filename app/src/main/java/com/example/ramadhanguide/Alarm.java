package com.example.ramadhanguide;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    private ImageButton btnBack;
    private EditText hourEditText, minuteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

        btnBack = findViewById(R.id.backAlarm);
        hourEditText = findViewById(R.id.hour);
        minuteEditText = findViewById(R.id.minutes);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Alarm.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.plusAlarm).setOnClickListener(v -> {
            setAlarm();
        });
    }

    private void setAlarm() {
        try {
            int hour = Integer.parseInt(hourEditText.getText().toString());
            int minute = Integer.parseInt(minuteEditText.getText().toString());

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);

            Intent intent = new Intent(this, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            if (alarmManager != null) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                Toast.makeText(this, "Alarm set successfully", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid time", Toast.LENGTH_SHORT).show();
        }
    }
}
