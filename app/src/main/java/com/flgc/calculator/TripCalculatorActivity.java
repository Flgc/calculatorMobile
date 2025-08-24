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

public class TripCalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trip_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btBack = findViewById(R.id.btBackHome);
        btBack.setOnClickListener(this);

        Button btCalculate = findViewById(R.id.btCalculateTrip);
        btCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btCalculateTrip){
            toCalculatorTrip();
        } else if (view.getId() == R.id.btBackHome) {
            finish();
        }
    }

    private void toCalculatorTrip(){
        EditText etNumberOne = findViewById(R.id.etDistance);
        EditText etNumberTwo = findViewById(R.id.etAverangeKilometers);
        EditText etNumberThree = findViewById(R.id.etPricePerLiter);

        int n1 = Integer.parseInt(etNumberOne.getText().toString());
        int n2 = Integer.parseInt(etNumberTwo.getText().toString());
        int n3 = Integer.parseInt(etNumberThree.getText().toString());

        /* (Distance / Average Kilometers Liter) * Price Per Liter */
        int result = 0;
        result = ((n1 / n2) * n3);

        Toast.makeText(TripCalculatorActivity.this, "The Amount Spent on Travel Will Be: ".
                concat(String.valueOf(result)),
                Toast.LENGTH_LONG).show();
    }
}