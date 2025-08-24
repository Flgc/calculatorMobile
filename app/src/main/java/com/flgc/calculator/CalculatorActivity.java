package com.flgc.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(this);

        Button btCalculate = findViewById(R.id.btCalculate);
        btCalculate.setOnClickListener(this);

        TextView tvTitle = findViewById(R.id.tvTitle);

        String title = getIntent().getStringExtra("Operation");
        operation = title;
        tvTitle.setText(title.concat(" Numbers"));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btCalculate){
            toCalculator();
        } else if (view.getId() == R.id.btBack) {
            finish();
        }
    }

    private void toCalculator(){
        EditText etNumberOne = findViewById(R.id.etFirstNumber);
        EditText etNumberTwo = findViewById(R.id.etSecondNumber);

        int n1 = Integer.parseInt(etNumberOne.getText().toString());
        int n2 = Integer.parseInt(etNumberTwo.getText().toString());

        int result = 0;
        switch (operation){
            case "Make The Sum":
                result = n1 + n2;
                break;
            case "Make The Division":
                result = n1 / n2;
                break;
            case "Make The Multiplication":
                result = n1 * n2;
                break;
            case "Make The Subtraction":
                result = n1 - n2;
        }

        Toast.makeText(CalculatorActivity.this, "Result: ".
                concat(String.valueOf(result)),
                Toast.LENGTH_LONG).show();
    }
}