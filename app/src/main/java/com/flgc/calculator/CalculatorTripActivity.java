package com.flgc.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorTripActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator_trip);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btBackTrip = findViewById(R.id.btBack);
        btBackTrip.setOnClickListener(this);

        Button btCalculateTrip = findViewById(R.id.btCalculate);
        btCalculateTrip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btCalculate){
            toCalculatorTrip();
        } else if (view.getId() == R.id.btBack) {
            finish();
        }
    }

    private void toCalculatorTrip(){
        EditText etNumberOne = findViewById(R.id.etDistance);
        EditText etNumberTwo = findViewById(R.id.etAverageKilometersPerLiter);
        EditText etNumberThree = findViewById(R.id.etPricePerLiterFuel);

        int n1 = Integer.parseInt(etNumberOne.getText().toString());
        int n2 = Integer.parseInt(etNumberTwo.getText().toString());
        int n3 = Integer.parseInt(etNumberThree.getText().toString());

        /* (Distance / Average Kilometers Liter) * Price Per Liter */
        int result = 0;
        result = ((n1 / n2) * n3);

        Toast.makeText(CalculatorTripActivity.this, "The Amount Spent on Travel Will Be U$: ".
                        concat(String.valueOf(result)),
                Toast.LENGTH_LONG).show();
    }
}