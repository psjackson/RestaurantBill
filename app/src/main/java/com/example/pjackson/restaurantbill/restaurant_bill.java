package com.example.pjackson.restaurantbill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class restaurant_bill extends AppCompatActivity {
    double costOfMeal;
    double tip;
    double totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_bill);
        final EditText mealCost = findViewById(R.id.txtBill);
        final Spinner group = findViewById(R.id.txtGroup);
        Button charges = findViewById(R.id.btnCharge);
            charges.setOnClickListener(new View.OnClickListener() {
                TextView resultTip = (findViewById(R.id.txtResultTip));
                TextView resultTotal = (findViewById(R.id.txtResultTotal));
                @Override
                public void onClick(View view) {
                    String tipAmount = group.getSelectedItem().toString();
                    costOfMeal = Double.parseDouble(mealCost.getText().toString());
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    switch (tipAmount) {
                        case "5%":
                            tip = costOfMeal * 0.05;
                            break;
                        case "10%":
                            tip = costOfMeal * 0.10;
                            break;
                        case "15%":
                            tip = costOfMeal * 0.15;
                            break;
                        case "20%":
                            tip = costOfMeal * 0.20;
                            break;
                        case "25%":
                            tip = costOfMeal * 0.25;
                            break;
                    }
                    totalBill = tip + costOfMeal;
                    String displayTip = "A " + tipAmount + " tip on a $" + costOfMeal + " meal is: " + currency.format(tip) + ".";
                    String displayTotal = "The total cost of your meal is: " + currency.format(totalBill)+ ".";
                    resultTip.setText(displayTip);
                    resultTotal.setText(displayTotal);
                }
            });





    }
}
