package com.phone.telephone;

import android.content.Intent;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCall, btnMsg, btnwifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        btnCall = findViewById(R.id.btn_call_history);
        btnCall.setOnClickListener(this);
        btnMsg = findViewById(R.id.btn_call_msg);
        btnMsg.setOnClickListener(this);
        btnwifi = findViewById(R.id.btn_call_wifi);
        btnwifi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_call_history:
                Intent contactIntent = new Intent();
                contactIntent.setAction(Intent.ACTION_CALL_BUTTON);
                startActivity(contactIntent);
                break;
            case R.id.btn_call_msg:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("vnd.android-dir/mms-sms");
//                intent.setData(Uri.parse("content://mms-sms/conversations/13681869795"));
                startActivity(intent);
                break;
            case R.id.btn_call_wifi:
                Intent i = new Intent();
                if (Build.VERSION.SDK_INT >= 11) { //Honeycomb
                    i.setClassName("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity");
                } else {//other versions
                    i.setClassName("com.android.settings", "com.android.settings.wifi.WifiSettings");
                }
                startActivity(i);
                break;
        }
    }
}
