package com.nyc.favoritefood;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuessActivity extends AppCompatActivity {
    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    private Button submit_guess;
    private EditText guess_food;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        submit_guess = (Button) findViewById(R.id.submit_guess);
        guess_food = (EditText) findViewById(R.id.guess_food);
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);


        submit_guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checkFood = "favorite food" + guess_food.getText().toString();
                if (guess_food.getText().toString().equalsIgnoreCase(login.getString(checkFood,null))) {
                    Toast.makeText(getApplicationContext(), guess_food.getText().toString() + " was in there!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), guess_food.getText().toString() + " was not in there!", Toast.LENGTH_SHORT).show();

                }
                guess_food.setText(null);

            }
        });

    }
}
