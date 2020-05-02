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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        final EditText editText_name = findViewById(R.id.editText_name);
        final EditText editText_age = findViewById(R.id.editText_age);


        Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");

                String editText_nameValue = editText_name.getText().toString();
                String editText_ageValue = editText_age.getText().toString();
                try {
                    int editText_ageValueInt = Integer.parseInt(editText_ageValue);
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, getString(R.string.Message), Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Получено исключение", ex);
                }

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
            }
        });
        Button button_live = findViewById(R.id.button_live);
        button_live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал Жизненные показатели");

                Intent intent = new Intent(MainActivity.this, LiveActivity.class);
                startActivity(intent);
            }
        });
        Button button_tr = findViewById(R.id.button_tonometer);
        button_tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал Тонометр");
                
                Intent intent = new Intent(MainActivity.this, TonometerActivity.class);
                startActivity(intent);
            }
        });
    }
}
