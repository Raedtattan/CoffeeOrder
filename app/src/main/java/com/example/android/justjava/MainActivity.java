/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantaty = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedcreamcheckbox = (CheckBox) findViewById(R.id.whippedcream);
        boolean haswhippedceam = whippedcreamcheckbox.isChecked();
        CheckBox chocolatecheckbox = (CheckBox) findViewById(R.id.chocolate);
        boolean haschocolate = chocolatecheckbox.isChecked();
        EditText getName = (EditText) findViewById(R.id.entername);
        String name = getName.getText().toString();
        createOfOrderSummry(quantaty,haswhippedceam , haschocolate , name);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    public void increment(View view) {
        if(quantaty >= 99){
            Toast.makeText(MainActivity.this ,"You Can't have more than 100 Coffee" ,Toast.LENGTH_LONG).show();
            return;
        }
            quantaty = quantaty +1;
            display(quantaty);
    }
    public void decrement(View view) {
        if(quantaty <= 1 ){
           Toast.makeText(MainActivity.this ,"You Can't have less than 1 Coffee" ,Toast.LENGTH_LONG).show();
            return;
        }
        quantaty = quantaty - 1;
        display(quantaty);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    private int calculatePrice( boolean addWhippedCream , boolean addChocolate){
        int baseprice = 5;
        if (addWhippedCream ){
            baseprice = baseprice +1;
        }
        if(addChocolate ){
            baseprice = baseprice +2;
        }

        return quantaty * baseprice;
    }
    private  void createOfOrderSummry(int number, boolean addWhippedCream , boolean addChocolate , String name) {
        int price = calculatePrice( addWhippedCream , addChocolate);
        String Message  ="Name :" +name+"\n"+"Add Whepped Cream:"+addWhippedCream+"\n"+"Add Chocolate:"+addChocolate+"\n"+"Quantaty:"+quantaty +"\n"+"Total:"+price+"\n"+"Thank You !" ;
        displayMessage(Message);
    }


}
