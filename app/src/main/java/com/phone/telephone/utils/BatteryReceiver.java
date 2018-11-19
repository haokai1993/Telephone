package com.phone.telephone.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class BatteryReceiver extends BroadcastReceiver {
    private OnBatterLevel onbatterlevel;

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        int level = intent.getIntExtra("level", 0);
        onbatterlevel.setbatterlevel(level);
    }

    public interface OnBatterLevel {
        void setbatterlevel(int level);
    }

    public void setOnBatterLeven(OnBatterLevel batterLeven) {
        onbatterlevel = batterLeven;
    }


}
