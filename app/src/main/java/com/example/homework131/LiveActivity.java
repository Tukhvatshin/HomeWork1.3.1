package com.example.homework131;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LiveActivity extends AppCompatActivity {
    private static final String TAG = "MyApp_Live";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_activity);

        init();

    }

    private void init() {
        final EditText editText_weight = findViewById(R.id.editText_weight);
        final EditText editText_step = findViewById(R.id.editText_step);

        Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");

                String editText_weightValue = editText_weight.getText().toString();
                int editText_weightValueInt = Integer.parseInt(editText_weightValue);
                String editText_stepValue = editText_step.getText().toString();
                int editText_stepValueInt = Integer.parseInt(editText_stepValue);

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LiveActivity.this);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
            }
        });
        Button button_start = findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал Стартовый экран");

                Intent intent = new Intent(LiveActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_tonometer = findViewById(R.id.button_tonometer);
        button_tonometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал Тонометр");

                Intent intent = new Intent(LiveActivity.this, TonometerActivity.class);
                startActivity(intent);
            }
        });
    }
}
