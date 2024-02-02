package com.example.myogs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ContactusFragment extends Fragment {

    Button btnCall, btnEmail, btnDirection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contactus, container, false);

        btnCall = v.findViewById(R.id.btn_call);
        btnEmail = v.findViewById(R.id.btn_email);
        btnDirection = v.findViewById(R.id.btn_direction);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 0389213892"));
                startActivity(callIntent);

                if (callIntent.resolveActivity(getContext().getPackageManager()) != null){
                    Toast.makeText(getContext(), "Directing to dial...", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getContext(), "Sorry, there is no apps can handle this action and data.", Toast.LENGTH_SHORT).show();

            }
        });


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MyOGS: An Inquiry Email");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello MyOGS's admin, this is the inquiry email from me.");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"myogs99@gmail.com"});

                if(emailIntent.resolveActivity(getContext().getPackageManager())!=null) {   //verify the apps either exist or not for intent
                    Toast.makeText(getContext(), "Directing to mail...", Toast.LENGTH_SHORT).show();
                    startActivity(emailIntent);
                }
                else
                    Toast.makeText(getContext(), "Sorry, there is no apps can handle this action and data.", Toast.LENGTH_SHORT).show();

            }
        });


        btnDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/2.919612,101.7756043/ukm/@2.9249577,101.7739606,16z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x31cdc926aaaaaaab:0xed49c9d40bf42563!2m2!1d101.7774194!2d2.930255");

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);


            }
        });

        return v;
    }
}
