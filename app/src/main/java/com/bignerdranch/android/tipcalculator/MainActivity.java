package com.bignerdranch.android.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private Button calculateButton;
    private TextView textOut;
    private EditText tipEditText;
    private EditText billEditText;
    private EditText stateEditText;
    private EditText peopleEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateButton = findViewById(R.id.calculate_button);
        tipEditText = findViewById(R.id.edit_tip);
        billEditText = findViewById(R.id.edit_bill);
        stateEditText = findViewById(R.id.edit_state);
        peopleEditText = findViewById(R.id.edit_people);
        textOut = findViewById(R.id.outputText);

        //add click listener for button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //take string from edit boxes
                String billStr = billEditText.getText().toString();
                String tipStr = tipEditText.getText().toString();
                String stateStr = stateEditText.getText().toString();
                String peopleStr = peopleEditText.getText().toString();

                //convert from string to doubles
                double billTotal = 0;
                if(billTotal > 0) {
                    billTotal = Double.parseDouble(billStr);
                } else {
                    textOut.setText("Please enter a positive number.");
                }
                double tipTotal = 0;
                if(tipTotal > 0 && tipTotal < 100){
                    tipTotal = Double.parseDouble(tipStr);
                } else {
                    textOut.setText("Please enter a valid percentage");
                }
                double peopleTotal = 0;
                if(peopleTotal > 0){
                    peopleTotal = Double.parseDouble(peopleStr);
                } else {
                    textOut.setText("Please enter a valid percentag");
                }

                //calculate tip amount
                //call tip calculator to calculate tip
                //make an object of TipCalculator

                    TipCalculator tipObj = new TipCalculator(billTotal, tipTotal, peopleTotal, stateStr);
                    double tipAmount = tipObj.calPerPerson(tipObj.calTip());
                    double billAmount = tipObj.calPerPerson(tipObj.calBill());

                    //display string
                    NumberFormat nf = NumberFormat.getCurrencyInstance();
                    String displayTip = nf.format(tipAmount);
                    String displayBill = nf.format(billAmount);
                    String output = "Bill amount: " + displayBill + "\n" + "Tip amount: " + displayTip + "\n";

                    //display the result in textview
                    textOut.setText(output);


            }
        });

    }
}
