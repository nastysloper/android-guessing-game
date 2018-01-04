package com.nastysloper.numberguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int num1;
    private int num2;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickNumbers();
    }

    public void pickNumbers() {

        Button lbutton = findViewById(R.id.leftButton);
        Button rButton = findViewById(R.id.rightButton);
        Random randy = new Random();
        num1 = randy.nextInt(10);
        num2 = randy.nextInt(10);
        while (num1 == num2) {
            num2 = randy.nextInt(10);
        }
        lbutton.setText(String.valueOf(num1));
        rButton.setText(String.valueOf(num2));
    }

    public void leftButtonClick(View view) {
        if (num1 > num2) {
            Toast.makeText(this, "you choose correctly!", Toast.LENGTH_SHORT).show();
            points++;
            TextView pointsBox = (TextView) findViewById(R.id.pointsBox);
            String s = String.valueOf(points);
            pointsBox.setText(s);
        } else {
            Toast.makeText(this, "oops not that one!", Toast.LENGTH_SHORT).show();
            points--;
            TextView pointsBox = (TextView) findViewById(R.id.pointsBox);
            String s = String.valueOf(points);
            pointsBox.setText(s);
        }
        pickNumbers();
    }

    public void rightButtonClick(View view) {
        if (num2 > num1) {
            Toast.makeText(this, "you chose correctly!", Toast.LENGTH_SHORT).show();
            points++;
            TextView pointsBox = (TextView) findViewById(R.id.pointsBox);
            pointsBox.setText(String.valueOf(points));
        } else {
            Toast.makeText(this, "oops not that one!", Toast.LENGTH_SHORT).show();
            points--;
            TextView pointsBox = (TextView) findViewById(R.id.pointsBox);
            pointsBox.setText(String.valueOf(points));
        }
        pickNumbers();
    }
}
