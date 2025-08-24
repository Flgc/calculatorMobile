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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Button to navigate to the second screen - home */
        Button btEnter = findViewById(R.id.btEnter);
        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeScreen = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeScreen);
                finish();
            }
        }
        );

        /* Button to navigate to the fourth screen - tripCalculator */
        Button btTrip = findViewById(R.id.btTrip);
        btTrip.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent tripScreen = new Intent(MainActivity.
                                                   this, CalculatorTripActivity.class);
                                           startActivity(tripScreen);
                                           finish();
                                       }
                                   }
        );
    }
}