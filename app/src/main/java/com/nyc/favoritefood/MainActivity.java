package com.nyc.favoritefood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    private TextView logo;
    private EditText favorite_food;
    private Button submit_food, guess;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = (TextView) findViewById(R.id.logo);
        favorite_food = (EditText) findViewById(R.id.favorite_food);
        submit_food = (Button) findViewById(R.id.submit_food);
        guess = (Button) findViewById(R.id.guess);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        submit_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = login.edit();
                editor.putString("favorite food" + favorite_food.getText().toString() ,favorite_food.getText().toString());
                editor.commit();
                favorite_food.setText(null);

            }
        });

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,GuessActivity.class);
                intent.putExtra("pref_key",SHARED_PREFS_KEY);
                startActivity(intent);
            }
        });



    }
}
