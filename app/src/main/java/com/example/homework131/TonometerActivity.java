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
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Date;

public class TonometerActivity extends AppCompatActivity {
    private static final String TAG = "MyApp_Tonometer";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonometer);

        init();

    }

    private void init() {
        final EditText editText_sys = findViewById(R.id.editText_sys);
        final EditText editText_dia = findViewById(R.id.editText_dia);
        final EditText editText_pulse = findViewById(R.id.editText_pulse);
        final CheckBox checkBox_td = findViewById(R.id.checkBox_td);
        final CalendarView calendarView = findViewById(R.id.calendarView);

        Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");

                String editText_sysValue = editText_sys.getText().toString();
                int editText_sysValueInt = Integer.parseInt(editText_sysValue);
                String editText_diaValue = editText_dia.getText().toString();
                int editText_diaValueInt = Integer.parseInt(editText_diaValue);
                String editText_pulseValue = editText_pulse.getText().toString();
                int editText_pulseValueInt = Integer.parseInt(editText_pulseValue);
                long millisec = calendarView.getDate();
                Date date = new Date(millisec);
                boolean checked = checkBox_td.isChecked();

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TonometerActivity.this);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
            }
        });
        Button button_start = findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал Стартовый экран");

                Intent intent = new Intent(TonometerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button button_live = findViewById(R.id.button_live);
        button_live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал Жизненные показатели");

                Intent intent = new Intent(TonometerActivity.this, LiveActivity.class);
                startActivity(intent);
            }
        });
    }
}
