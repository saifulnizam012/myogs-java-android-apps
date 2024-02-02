package com.example.myogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Asus_rog extends AppCompatActivity {

    TextView tvLaptopName, tvPrice;
    SharedPreferences sp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asus_rog);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button btnCheck = findViewById(R.id.btn_save);

        tvLaptopName = findViewById(R.id.tv_laptopDetailName);
        tvPrice = findViewById(R.id.tv_price);

        sp3 = getSharedPreferences("sp2Pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp3.edit();

        String Aname = tvLaptopName.getText().toString();
        String Aprice = tvPrice.getText().toString();

        editor2.putString("pName",Aname);
        editor2.putString("pPrice", Aprice);
        editor2.commit();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Asus_rog.this);
                builder.setTitle("Check Stocks");
                builder.setMessage("This phone still available. You want to purchase?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        startActivity(new Intent(Asus_rog.this, BuyDetail_Activity.class));
                    }
                }).setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();

            }
        });

        Button btnBuy = findViewById(R.id.btn_returnToCart);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Asus_rog.this, BuyDetail_Activity.class));
            }
        });
    }   //  onCreate
}