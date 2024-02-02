package com.example.myogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShippingDetails_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_details);
        getSupportActionBar().setTitle("Shipping Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvShipName, tvShipPhone, tvShipStreet, tvShipCode, tvShipState;
        Button btnConfirm;

        tvShipName = findViewById(R.id.tv_shipName);
        tvShipPhone = findViewById(R.id.tv_shipPhone);
        tvShipStreet = findViewById(R.id.tv_shipStreet);
        tvShipCode = findViewById(R.id.tv_shipCode);
        tvShipState = findViewById(R.id.tv_shipState);

        btnConfirm = findViewById(R.id.btn_returnToCart);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("myUserPrefs", Context.MODE_PRIVATE);

        String sname = sp.getString("Name", "");
        String sphone = sp.getString("Phone", "");
        String sstreet = sp.getString("Street", "");
        String scode = sp.getString("Postal Code", "");
        String sstate = sp.getString("State", "");

        tvShipName.setText(sname);
        tvShipPhone.setText(sphone);
        tvShipStreet.setText(sstreet);
        tvShipCode.setText(scode);
        tvShipState.setText(sstate);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ShippingDetails_Activity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure want to order?\nThis action cannot be undo later.");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(ShippingDetails_Activity.this, Order_Activity.class));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();


            }
        });

    }
}
