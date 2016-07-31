package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        int price = calculatePrice();
        String summary  = createOrderSummary(price);
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
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     *
     * @return the total price
     */
    private int calculatePrice() {

        return quantity * 5;
    }

    /**
     * creates a summary of the order placed
     * @param price of the order
     * @return String that consists of the name quantity total and thank you
     */
    private String createOrderSummary(int price)
    {
        return "Name: Kaptain Kumar" + "\n"  + "Quantity: "+String.valueOf(quantity) +"\n"  + "Total: " + String.valueOf(price) + "\n" +"Thank you !";

    }
}