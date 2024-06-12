package com.example.ramadhanguide;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;


public class Tadarus extends AppCompatActivity{

    private static final String PREF_NAME = "FrameLayoutStates";
    private static final String STATE_PREFIX = "state_";
    private SharedPreferences sharedPreferences;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tadarus);

        ImageButton btnBack = findViewById(R.id.backTadarus);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);


        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Tadarus.this, MainActivity.class);
            startActivity(intent);
        });
        // Get references to FrameLayouts
        FrameLayout frameLayout1 = findViewById(R.id.fl1);
        FrameLayout frameLayout2 = findViewById(R.id.fl2);
        FrameLayout frameLayout3 = findViewById(R.id.fl3);
        FrameLayout frameLayout4 = findViewById(R.id.fl4);
        FrameLayout frameLayout5 = findViewById(R.id.fl5);

        // Set OnClickListener for each FrameLayout
        frameLayout1.setOnClickListener(view -> toggleBackgroundColor(frameLayout1, "frameLayout1"));
        frameLayout2.setOnClickListener(view -> toggleBackgroundColor(frameLayout2, "frameLayout2"));
        frameLayout3.setOnClickListener(view -> toggleBackgroundColor(frameLayout3, "frameLayout3"));
        frameLayout4.setOnClickListener(view -> toggleBackgroundColor(frameLayout4, "frameLayout4"));
        frameLayout5.setOnClickListener(view -> toggleBackgroundColor(frameLayout5, "frameLayout5"));

        // Retrieve and set the saved states of FrameLayouts
        restoreFrameLayoutState(frameLayout1, "frameLayout1");
        restoreFrameLayoutState(frameLayout2, "frameLayout2");
        restoreFrameLayoutState(frameLayout3, "frameLayout3");
        restoreFrameLayoutState(frameLayout4, "frameLayout4");
        restoreFrameLayoutState(frameLayout5, "frameLayout5");
    }


    private void toggleBackgroundColor(FrameLayout frameLayout, String frameLayoutKey) {
        boolean currentState = !sharedPreferences.getBoolean(STATE_PREFIX + frameLayoutKey, false);
        int color = currentState ? Color.parseColor("#40A578") : Color.TRANSPARENT;
        ColorStateList colorStateList = ColorStateList.valueOf(color);
        frameLayout.setBackgroundTintList(colorStateList);
        sharedPreferences.edit().putBoolean(STATE_PREFIX + frameLayoutKey, currentState).apply();
    }

    private void restoreFrameLayoutState(FrameLayout frameLayout, String frameLayoutKey) {
        boolean currentState = sharedPreferences.getBoolean(STATE_PREFIX + frameLayoutKey, false);
        int color = currentState ? Color.parseColor("#40A578") : Color.TRANSPARENT;
        ColorStateList colorStateList = ColorStateList.valueOf(color);
        frameLayout.setBackgroundTintList(colorStateList);
    }
}
