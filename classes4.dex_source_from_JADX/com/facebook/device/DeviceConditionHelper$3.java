package com.facebook.device;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.device.DeviceConditionHelper.WifiState;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: interesting_replies */
class DeviceConditionHelper$3 implements ActionReceiver {
    final /* synthetic */ DeviceConditionHelper f10243a;

    DeviceConditionHelper$3(DeviceConditionHelper deviceConditionHelper) {
        this.f10243a = deviceConditionHelper;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2071805913);
        DeviceConditionHelper.a(this.f10243a, WifiState.WIFI_UNKNOWN);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1522789687, a);
    }
}
