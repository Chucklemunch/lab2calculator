package com.cs407.lab2calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void onButtonClick(View view) {
        int[] buttonId = new int[]{findViewById(R.id.addButton).getId(), findViewById(R.id.subButton).getId(),
                findViewById(R.id.multButton).getId(), findViewById(R.id.divButton).getId()};
        Integer operand1;
        Integer operand2;
        Integer result = 0;
        String resultString = "";

        Log.i("Button", ((Object) view.getId()).toString());
        EditText int1 = (EditText) findViewById(R.id.int1);
        EditText int2 = (EditText) findViewById(R.id.int2);
        Log.d("NUMS", int1.getText() + ", " + int2.getText());

        operand1 = Integer.parseInt(int1.getText().toString());
        operand2 = Integer.parseInt(int2.getText().toString());
        int viewId = view.getId();

        if (viewId == buttonId[0]) {
            Log.d("Button", "ADD");
            result = operand1 + operand2;
        } else if (viewId == buttonId[1]) {
            Log.d("Button", "SUB");
            result = operand1 - operand2;
        } else if (viewId == buttonId[2]) {
            Log.d("Button", "MULT");
            result = operand1.intValue() * operand2.intValue();
        } else if (viewId == buttonId[3]) {
            Log.d("Button", "DIV");
            if (operand2.intValue() == 0) {
                resultString = "DIVIDE BY ZERO ERROR";
            } else {
                result = operand1 / operand2;
            }
        }

        if (resultString.equals("")) {
            resultString = result.toString();
        }
        Log.d("RESULT", resultString);

        // Resets inputs
        int1.setText("Enter an integer");
        int2.setText("Enter an integer");

        // Views results
        goToResult(resultString);
    }

    public void goToResult(String result) {
        Intent intent = new Intent(this, CalcResult.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}