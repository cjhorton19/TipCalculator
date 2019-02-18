package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.tipcalculator.R;

public class MainActivity extends AppCompatActivity {


    //data members
    private Button calculateButton;
    private EditText tipEditText;
    private EditText billEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add codes to manage button
        //link data members to resources
        calculateButton = findViewById(R.id.calculate_button);
        tipEditText = findViewById(R.id.edit_tip);
        billEditText = findViewById(R.id.edit_bill);

        //add click listener for button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //the onClick method will be called after we click the button
            public void onClick(View v) {
             //take strings from edit boxes
              String billStr = billEditText.getText().toString();
              String tipStr = tipEditText.getText().toString();

              //convert from strings to doubles
                double billTotal = Double.parseDouble(billStr);
                double tipPercent = Double.parseDouble(tipStr);

                //calculate tip Amount
                //double tipAmount = tipTotal*billTotal;
                //call TipCalculator to calculate tip
                //make an object of TipCalculator
                TipCalculator tipObj = new TipCalculator(tipPercent,billTotal);
                double tipAmount = tipObj.calTip();

                //display string
                String display = "$" + tipAmount;


                //display the result in Toast
                Toast.makeText(MainActivity.this, display, Toast.LENGTH_SHORT).show();

            }
        });




    }


}
