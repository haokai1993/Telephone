package com.phone.telephone;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.phone.telephone.utils.BatteryReceiver;
import com.phone.telephone.view.BaseActivity;
import com.phone.telephone.view.ContactsActivity;
import com.phone.telephone.weight.BatteryView;

import java.util.List;

public class MainActivity extends BaseActivity {
    private TextView tvdate, tvsim, tvbatter;
    private BatteryView batteryView;
    private BatteryReceiver mBatteryReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarVisibility(this, false);
        setContentView(R.layout.activity_main);
        initView();
        PermissionUtils.permission(PermissionConstants.CONTACTS).rationale(new PermissionUtils.OnRationaleListener() {
            @Override
            public void rationale(ShouldRequest shouldRequest) {
            }
        }).callback(new PermissionUtils.FullCallback() {
            @Override
            public void onGranted(List<String> permissionsGranted) {
            }

            @Override
            public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {

            }
        }).request();
    }

    public void initView() {
        mBatteryReceiver = new BatteryReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mBatteryReceiver, intentFilter);
        tvsim = findViewById(R.id.tv_sim);
        tvbatter = findViewById(R.id.tv_batter_show);
        batteryView = findViewById(R.id.battery_level);
        if (PhoneUtils.isSimCardReady()) {
            tvsim.setText(PhoneUtils.getSimOperatorByMnc());
        } else {
            tvsim.setText(getResources().getString(R.string.no_sim));
        }
        mBatteryReceiver.setOnBatterLeven(new BatteryReceiver.OnBatterLevel() {
            @Override
            public void setbatterlevel(int level) {
                Log.i("haokai", "" + level);
                batteryView.setPower(level);
                tvbatter.setText(level + "%");
            }
        });
        findViewById(R.id.tv_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.tv_constact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactsActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBatteryReceiver != null) {
            unregisterReceiver(mBatteryReceiver);
            mBatteryReceiver = null;
        }
    }
}
