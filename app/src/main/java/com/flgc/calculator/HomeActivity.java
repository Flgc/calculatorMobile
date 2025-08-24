package com.flgc.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btSum = findViewById(R.id.btSum);
        btSum.setOnClickListener(this);

        Button btMultiplication = findViewById(R.id.btMultiplication);
        btMultiplication.setOnClickListener(this);

        Button btDivision = findViewById(R.id.btDivision);
        btDivision.setOnClickListener(this);

        Button btSubtraction = findViewById(R.id.btSubtraction);
        btSubtraction.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent screenCalculator = new Intent(HomeActivity.this, CalculatorActivity.class);
        if (view.getId() == R.id.btSum){
            screenCalculator.putExtra("Operation", "Make The Sum");
        } else if (view.getId() == R.id.btDivision) {
            screenCalculator.putExtra("Operation", "Make The Division");
        } else if (view.getId() == R.id.btMultiplication){
            screenCalculator.putExtra("Operation", "Make The Multiplication");
        } else if (view.getId() == R.id.btSubtraction) {
            screenCalculator.putExtra("Operation", "Make The Subtraction");
        }

        startActivity(screenCalculator);
    }
}