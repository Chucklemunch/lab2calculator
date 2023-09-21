package com.cs407.lab2calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalcResult extends AppCompatActivity {

    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_result);
        TextView resultView = findViewById(R.id.calcResult);
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        resultView.setText(result);
    }
}