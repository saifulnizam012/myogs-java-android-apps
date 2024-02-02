package com.example.myogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class BuyDetail_Activity extends AppCompatActivity {

    EditText etDetailName, etDetailPhone, etDetailStreet, etDetailPostalCode, etDetailState;
    String dname, dphone, dstreet, dcode, dstate;
    Button btnSave, btnProceed;
    SharedPreferences sp;
    FirebaseAuth bAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Buy Details");

        etDetailName = findViewById(R.id.et_detailName);
        etDetailPhone = findViewById(R.id.et_detailPhone);
        etDetailStreet = findViewById(R.id.et_detailStreet);
        etDetailPostalCode = findViewById(R.id.et_detailPostalCode);
        etDetailState = findViewById(R.id.et_detailState);

        btnSave = findViewById(R.id.btn_save);
        btnProceed = findViewById(R.id.btn_returnToCart);
        bAuth = FirebaseAuth.getInstance();

        sp = getSharedPreferences("myUserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dname = etDetailName.getText().toString();
                dphone = etDetailPhone.getText().toString();
                dstreet = etDetailStreet.getText().toString();
                dcode = etDetailPostalCode.getText().toString();
                dstate = etDetailState.getText().toString();

                if (bAuth.getCurrentUser() != null){
                    removePref();
                }


                if (TextUtils.isEmpty(dname) && TextUtils.isEmpty(dphone) && TextUtils.isEmpty(dstreet) && TextUtils.isEmpty(dcode) && TextUtils.isEmpty(dstate)){
                    etDetailName.setError("Name is Required");
                    etDetailPhone.setError("Phone Number is Required");
                    etDetailStreet.setError("Street Name is Required");
                    etDetailPostalCode.setError("Postal Code is Required");
                    etDetailState.setError("State is Required");
                    return;
                }

                if (TextUtils.isEmpty(dname)){
                    etDetailName.setError("Name is Required");
                    return;
                }

                if (TextUtils.isEmpty(dphone)){
                    etDetailPhone.setError("Phone Number is Required");
                    return;
                }

                if (TextUtils.isEmpty(dstreet)){
                    etDetailStreet.setError("Street Name is Required");
                    return;
                }

                if (TextUtils.isEmpty(dcode)){
                    etDetailPostalCode.setError("Postal Code is Required");
                    return;
                }

                if (TextUtils.isEmpty(dstate)){
                    etDetailState.setError("State is Required");
                    return;
                }

                editor.putString("Name", dname);
                editor.putString("Phone", dphone);
                editor.putString("Street", dstreet);
                editor.putString("Postal Code", dcode);
                editor.putString("State", dstate);
                editor.commit();
                Toast.makeText(BuyDetail_Activity.this, "Information Saved.", Toast.LENGTH_SHORT).show();
            }
        });

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(dname) && TextUtils.isEmpty(dphone) && TextUtils.isEmpty(dstreet) && TextUtils.isEmpty(dcode) && TextUtils.isEmpty(dstate)){

                    AlertDialog.Builder builder = new  AlertDialog.Builder(BuyDetail_Activity.this);
                    builder.setTitle("Confirmation");
                    builder.setMessage("You want to use your previous details?");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            String checkName = sp.getString("Name", null);

                            if(checkName == null){

                                AlertDialog.Builder builder = new  AlertDialog.Builder(BuyDetail_Activity.this);
                                builder.setTitle("Error !");
                                builder.setMessage("You cannot proceed with an empty data.");

                                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });

                                builder.show();
                            }
                            else
                                startActivity(new Intent(BuyDetail_Activity.this, ShippingDetails_Activity.class));

                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

//                            editor.remove("myUserPrefs");
//                            editor.clear();
//                            editor.apply();

                        }
                    });

                    builder.show();

                }
                else
                    startActivity(new Intent(BuyDetail_Activity.this, ShippingDetails_Activity.class));

            }
        });


    }   //  onCreate

    public void removePref(){

        sp = getSharedPreferences("myUserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("myUserPrefs");
        editor.clear();
        editor.apply();
    }
}
