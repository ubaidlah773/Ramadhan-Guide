package com.example.ramadhanguide;

import static com.example.ramadhanguide.R.*;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

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

        // Load the saved alarm time from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("AlarmPrefs", MODE_PRIVATE);
        int savedHour = sharedPreferences.getInt("hour", 0);
        int savedMinute = sharedPreferences.getInt("minute", 0);
        hourEditText.setText(String.format("%02d", savedHour));
        minuteEditText.setText(String.format("%02d", savedMinute));

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Alarm.this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.plusAlarm).setOnClickListener(v -> {
            setAlarm();
        });
    }


    @OptIn(markerClass = UnstableApi.class)
    private void setAlarm() {
        try {
            int hour = Integer.parseInt(hourEditText.getText().toString());
            int minute = Integer.parseInt(minuteEditText.getText().toString());

            // Save the alarm time to SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("AlarmPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("hour", hour);
            editor.putInt("minute", minute);
            editor.apply();

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);

            Intent intent = new Intent(this, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            if (alarmManager != null) {
                Log.d("Alarm", "Setting alarm at " + calendar.getTime());
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                Toast.makeText(this, "Alarm set successfully", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid time", Toast.LENGTH_SHORT).show();
        }
    }

}
