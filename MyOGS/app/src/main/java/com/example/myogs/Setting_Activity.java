package com.example.myogs;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Setting_Activity extends AppCompatActivity {

    TextView tvRingtone;
    LinearLayout llNotification, llRingtone;
    Switch switchNotification;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String SP_RINGTONE = "ringtone";
    String SP_NOTIFICATION = "notification";

    String[] values = {"Whistle", "Bell", "Melody", "Knock"};

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tvRingtone = findViewById(R.id.tv_ringtone);
        switchNotification = findViewById(R.id.switch_notification_sound);
        llNotification = findViewById(R.id.ll_notification_sound);
        llRingtone = findViewById(R.id.ll_ringtone);
        sharedPref = getSharedPreferences("app_settings", MODE_PRIVATE);
        editor = sharedPref.edit();

        switchNotification.setChecked(sharedPref.getBoolean(SP_NOTIFICATION, false));
        tvRingtone.setText(values[sharedPref.getInt(SP_RINGTONE,0)]);

        switchNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean(SP_NOTIFICATION,b);
                editor.commit();
            }
        });

        llNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean switchState = switchNotification.isChecked();
                switchNotification.setChecked(!switchState);
                editor.putBoolean(SP_NOTIFICATION, !switchState);
                editor.commit();
            }
        });

        llRingtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowRingtoneOptions();
            }
        });
    }

    private void ShowRingtoneOptions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Setting_Activity.this);
        builder.setTitle("Select Sounds");
        builder.setSingleChoiceItems(values, sharedPref.getInt(SP_RINGTONE, 0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        editor.putInt(SP_RINGTONE,0);
                        editor.commit();
                        break;
                    case 1:
                        editor.putInt(SP_RINGTONE,1);
                        editor.commit();
                        break;
                    case 2:
                        editor.putInt(SP_RINGTONE,2);
                        editor.commit();
                        break;
                    case 3:
                        editor.putInt(SP_RINGTONE,3);
                        editor.commit();
                        break;
                }
                alertDialog.dismiss();
                tvRingtone.setText(values[sharedPref.getInt(SP_RINGTONE,0)]);
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
}