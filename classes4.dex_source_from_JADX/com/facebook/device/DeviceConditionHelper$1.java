package com.facebook.device;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.device.DeviceConditionHelper.WifiState;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: interesting_replies */
class DeviceConditionHelper$1 implements ActionReceiver {
    final /* synthetic */ DeviceConditionHelper f10215a;

    DeviceConditionHelper$1(DeviceConditionHelper deviceConditionHelper) {
        this.f10215a = deviceConditionHelper;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1136420427);
        if (!intent.getBooleanExtra("connected", false)) {
            DeviceConditionHelper.a(this.f10215a, WifiState.WIFI_OFF);
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1751066510, a);
    }
}
