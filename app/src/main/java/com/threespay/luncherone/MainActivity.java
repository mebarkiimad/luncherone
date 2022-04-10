package com.threespay.luncherone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public  enum  Transaction {
        PAYMENT,
        REFUND,
        CANCEL
    }
private Button button;
private static final String TRANSACTION_ACTION = "com.threespay.lunchertwo.MainActivity";
private static final Double AMOUNT = 2000.0;
private static final String CURRENCY = "DZD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.btn_invoke);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
if(view.getId() == R.id.btn_invoke){
    Intent sendIntent = new Intent();
    sendIntent.setAction(TRANSACTION_ACTION);
    sendIntent.putExtra("TRANSACTION",String.valueOf(Transaction.PAYMENT));
    sendIntent.putExtra("AMOUNT",String.valueOf(AMOUNT));
    sendIntent.putExtra("CURRENCY",CURRENCY);
    sendIntent.setType("text/plain");

// Try to invoke the intent.
    try {
        startActivity(sendIntent);
    } catch (ActivityNotFoundException e) {
        // Define what your app should do if no activity can handle the intent.
    }

}
    }
}