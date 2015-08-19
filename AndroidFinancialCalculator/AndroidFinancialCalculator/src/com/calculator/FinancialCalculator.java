package com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class FinancialCalculator extends Activity
{
    
    EditText propertyValue;
    EditText interestRate;
    EditText term;
    TextView calculateResult;
    Button buttonCalculate;
    double num1,num2, num3, monthlyPayment;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        propertyValue = (EditText)findViewById(R.id.value1);
        interestRate = (EditText)findViewById(R.id.value2);
        term = (EditText)findViewById(R.id.value3);
        calculateResult = (TextView)findViewById(R.id.txtResult);
        buttonCalculate = (Button)findViewById(R.id.buttonCalculate);
        
        
        buttonCalculate.setOnClickListener(new OnClickListener() {	
	public void onClick(View v) {
	        num1 = Double.parseDouble(propertyValue.getText().toString());
		num2 = (Double.parseDouble(interestRate.getText().toString())/100)/12;
                num3 = Double.parseDouble(term.getText().toString())*12;
                monthlyPayment = calculatePayment(num1, num2, num3);
		calculateResult.setText(new DecimalFormat("##.##").format(monthlyPayment));
	}

            private double calculatePayment(double value, double interest, double term) {
                
                  double monthlyPayment = 
                      (value * interest) / (1 - Math.pow(1+interest, -term));
       
       return monthlyPayment;
           
            }
           
        });
    }
}
