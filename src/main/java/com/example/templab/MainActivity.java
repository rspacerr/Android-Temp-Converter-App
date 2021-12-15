package com.example.templab;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView finalView;
    private Button calculateButton;
    private EditText tempBox;
    private RadioButton fahrenheitButton;
    private RadioButton celsiusButton;
    private boolean cChecked;
    private boolean fChecked;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.toCelsiusButton:
                if (checked)
                    cChecked = true;
                    fChecked = false;
                    break;
            case R.id.toFahrenheitButton:
                if (checked)
                    fChecked = true;
                    cChecked = false;
                    break;
            default:
                cChecked = false;
                fChecked = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finalView = findViewById(R.id.final_view);
        tempBox = findViewById(R.id.temp_box);
        calculateButton = (Button) findViewById(R.id.calculate_button);
        fahrenheitButton = findViewById(R.id.toFahrenheitButton);
        celsiusButton = findViewById(R.id.toCelsiusButton);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tempBox.getText().toString().isEmpty())
                    finalView.setText("Error");
                else if (cChecked) {
                    double input = Double.parseDouble(tempBox.getText().toString());
                    finalView.setText("Temperature: " + ConverterUtil.convertFahrenheitToCelsius(input));
                }
                else if (fChecked) {
                    double input = Double.parseDouble(tempBox.getText().toString());
                    finalView.setText("Temperature: " + ConverterUtil.convertCelsiusToFahrenheit(input));
                }
                else {
                    finalView.setText("Error");
                }
            }
        });
    }
}