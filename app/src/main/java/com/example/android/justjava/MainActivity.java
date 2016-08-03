package com.example.android.justjava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean check = checkBox1.isChecked();
        boolean check2 = checkBox2.isChecked();
        int price = calculatePrice(check,check2);
        String summary = createOrderSummary(price,check,check2);
        displayMessage(summary);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int num) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(num));
    }

    /**
     * This method increments the given quantity value and displays on the screen.
     */
    public void increment(View view) {

        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the given quantity value and displays on the screen.
     */
    public void decrement(View view) {

        quantity -= 1;
        displayQuantity(quantity);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     *
     * @return the total price
     */
    private int calculatePrice(boolean check, boolean check2) {

        int price = quantity * 5;
        if (check == true)
            price += 1;
        if (check2 == true)
            price += 2;
        return price;
    }

    /**
     * creates a summary of the order placed
     *
     * @param price of the order
     * @return String that consists of the name quantity total and thank you
     */
    private String createOrderSummary(int price, boolean check, boolean check2) {
        String checkText, checkText2 , userName = "";
        if (check == true)
                checkText = "true";
        else
            checkText = "false";

        if (check == true)
            checkText2 = "true";
        else
            checkText2 = "false";

        EditText editText = (EditText) findViewById(R.id.name_field);
        userName = editText.getText().toString();

        return "Name: " + userName + "\n"
                +"Add whipped cream? "+checkText+"\n"
                +"Add Chocolate ? "+checkText+"\n" + "Quantity: " + String.valueOf(quantity) + "\n" + "Total: " + String.valueOf(price) + "\n" + "Thank you !";

    }
}