package com.example.myogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Cart_Activity extends AppCompatActivity {

    TextView tvDetailName, tvDetailPhoneNumber, tvDetailLaptop, tvDetailAddress, tvDetailPrice;
    Button btnBackToHome, btnOrderReceived;
    ImageView imgDetailLaptop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cart");

        tvDetailName = findViewById(R.id.tv_orderdetailName);
        tvDetailPhoneNumber = findViewById(R.id.tv_orderdetailPhone);
        tvDetailLaptop = findViewById(R.id.tv_orderdetailLaptop);
        tvDetailAddress = findViewById(R.id.tv_orderdetailsAddress);
        tvDetailPrice = findViewById(R.id.tv_orderdetailPrice);
        btnOrderReceived = findViewById(R.id.btn_orderdetail_orderReceived);
        btnBackToHome = findViewById(R.id.btn_orderdetail_backToHome);
        imgDetailLaptop = findViewById(R.id.img_detailLaptop);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("myUserPrefs", Context.MODE_PRIVATE);
        String oname = sp.getString("Name", "");
        String ophone = sp.getString("Phone", "");
        String ostreet = sp.getString("Street", "");
        String ocode = sp.getString("Postal Code", "");
        String ostate = sp.getString("State", "");

        tvDetailName.setText(oname);
        tvDetailPhoneNumber.setText(ophone);
        tvDetailAddress.setText(ostreet + ", " + ocode + " " + ostate);

        SharedPreferences sp2 = getApplicationContext().getSharedPreferences("sp2Pref", Context.MODE_PRIVATE);
        String pName = sp2.getString("pName", "");
        String pPrice = sp2.getString("pPrice", "");

        tvDetailLaptop.setText(pName);
        tvDetailPrice.setText(pPrice);

        if (TextUtils.isEmpty(pPrice)){

            AlertDialog.Builder dialogEmptyCart = new AlertDialog.Builder(Cart_Activity.this);
            dialogEmptyCart.setTitle("Empty");
            dialogEmptyCart.setMessage("Your cart is empty.");

            dialogEmptyCart.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(Cart_Activity.this, MainActivity.class));
                }
            });

            dialogEmptyCart.show();
        }

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cart_Activity.this, MainActivity.class));
            }
        });

        btnOrderReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Cart_Activity.this);
                builder.setTitle("Order Received");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Cart_Activity.this);
                        builder2.setTitle("Order Received");
                        builder2.setMessage("Thank you for buying with us. See you next time.");
                        builder2.setPositiveButton("Thank you", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences.Editor editor = sp.edit();
                                editor.remove("myUserPrefs");
                                editor.clear();
                                editor.apply();
                                SharedPreferences.Editor editor2 = sp2.edit();
                                editor2.remove("sp2Pref");
                                editor2.clear();
                                editor2.apply();

                                startActivity(new Intent(Cart_Activity.this, MainActivity.class));
                            }
                        });
                        builder2.show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });
        //  selection for cart
        //  Asus
        if (pName.equals("Asus ROG Strix G17")){
            tvDetailPrice.setText("RM10,999.00");
            imgDetailLaptop.setImageResource(R.drawable.asus_rog_strix_g17);
        }
        else if (pName.equals("Asus ROG Strix G15")){
            tvDetailPrice.setText("RM5,399.00");
            imgDetailLaptop.setImageResource(R.drawable.asus_rog_strix_g15);
        }
        else if (pName.equals("Asus TUF Gaming A17")){
            tvDetailPrice.setText("RM6,299.00");
            imgDetailLaptop.setImageResource(R.drawable.asus_tuf_gaming_a17);
        }
        else if (pName.equals("Asus TUF Gaming A15")){
            tvDetailPrice.setText("RM4,999.00");
            imgDetailLaptop.setImageResource(R.drawable.asus_tuf_gaming_a15);
        }
        else if (pName.equals("Asus Vivobook 15")){
            tvDetailPrice.setText("RM3,499.00");
            imgDetailLaptop.setImageResource(R.drawable.asus_vivobook_15);
        }
        //  Acer
        else if (pName.equals("Acer Predator Helios 300")){
            tvDetailPrice.setText("RM7,999.00");
            imgDetailLaptop.setImageResource(R.drawable.acer_predator_helios_300);
        }
        else if (pName.equals("Acer Everyday Aspire 3")){
            tvDetailPrice.setText("RM2,399.00");
            imgDetailLaptop.setImageResource(R.drawable.acer_everyday_aspire_3);
        }
        else if (pName.equals("Acer Swift 3")){
            tvDetailPrice.setText("RM3,399.00");
            imgDetailLaptop.setImageResource(R.drawable.acer_swift_3);
        }
        else if (pName.equals("Acer Swift X")){
            tvDetailPrice.setText("RM4,299.00");
            imgDetailLaptop.setImageResource(R.drawable.acer_swift_x);
        }
        else if (pName.equals("Acer Chromebook 311")){
            tvDetailPrice.setText("RM1,349.00");
            imgDetailLaptop.setImageResource(R.drawable.acer_chromebook_311);
        }
        //  Lenovo
        else if (pName.equals("Lenovo Legion 5")){
            tvDetailPrice.setText("RM4,004.00");
            imgDetailLaptop.setImageResource(R.drawable.lenovo_legion_5);
        }
        else if (pName.equals("Lenovo Legion 7")){
            tvDetailPrice.setText("RM9,516.00");
            imgDetailLaptop.setImageResource(R.drawable.lenovo_legion_7);
        }
        else if (pName.equals("Lenovo ThinkPad E15")){
            tvDetailPrice.setText("RM3,993.00");
            imgDetailLaptop.setImageResource(R.drawable.lenovo_thinkpad_e15);
        }
        else if (pName.equals("Lenovo Thinkpad X13 Yoga")){
            tvDetailPrice.setText("RM6,353.00");
            imgDetailLaptop.setImageResource(R.drawable.lenovo_thinkpad_x13_yoga);
        }
        else if (pName.equals("Lenovo IdeaPad 1")){
            tvDetailPrice.setText("RM2,054.00");
            imgDetailLaptop.setImageResource(R.drawable.lenovo_ideapad_1);
        }
        //  Dell
        else if (pName.equals("Dell XPS 15")){
            tvDetailPrice.setText("RM8,749.00");
            imgDetailLaptop.setImageResource(R.drawable.dell_xps_15);
        }
        else if (pName.equals("Dell XPS 13 2in1")){
            tvDetailPrice.setText("RM6,299.00");
            imgDetailLaptop.setImageResource(R.drawable.dell_xps_13_2in1);
        }
        else if (pName.equals("Dell Inspiron 14")){
            tvDetailPrice.setText("RM4,599.00");
            imgDetailLaptop.setImageResource(R.drawable.dell_inspiron_14);
        }
        else if (pName.equals("Dell Inspiron 14 2in1")){
            tvDetailPrice.setText("RM3,599.00");
            imgDetailLaptop.setImageResource(R.drawable.dell_inspiron_14_2in1);
        }
        else if (pName.equals("Dell Alienware x15 R2")){
            tvDetailPrice.setText("RM14,399.00");
            imgDetailLaptop.setImageResource(R.drawable.dell_alienware_x15_r2);
        }
        //  HP
        else if (pName.equals("Victus by HP")){
            tvDetailPrice.setText("RM3,799.00");
            imgDetailLaptop.setImageResource(R.drawable.victus_by_hp);
        }
        else if (pName.equals("OMEN by HP")){
                tvDetailPrice.setText("RM7,599.00");
                imgDetailLaptop.setImageResource(R.drawable.omen_by_hp);
        }
        else if (pName.equals("HP Pavilion Aero")){
            tvDetailPrice.setText("RM3,499.00");
            imgDetailLaptop.setImageResource(R.drawable.hp_pavilion_aero);
        }
        else if (pName.equals("HP Laptop 15s")){
            tvDetailPrice.setText("RM1,549.00");
            imgDetailLaptop.setImageResource(R.drawable.hp_15s);
        }
        else if (pName.equals("HP ENVY 16")){
            tvDetailPrice.setText("RM6,999.00");
            imgDetailLaptop.setImageResource(R.drawable.hp_envy_16);
        }
    }
}