package com.facebook.device;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.device.DeviceConditionHelper.WifiState;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: interesting_replies */
class DeviceConditionHelper$2 implements ActionReceiver {
    final /* synthetic */ DeviceConditionHelper f10227a;

    DeviceConditionHelper$2(DeviceConditionHelper deviceConditionHelper) {
        this.f10227a = deviceConditionHelper;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 398018967);
        try {
            if (((NetworkInfo) intent.getParcelableExtra("networkInfo")).isConnected()) {
                DeviceConditionHelper.a(this.f10227a, WifiState.WIFI_UNKNOWN);
            } else {
                DeviceConditionHelper.a(this.f10227a, WifiState.WIFI_OFF);
            }
            LogUtils.e(-803916207, a);
        } catch (Throwable e) {
            DeviceConditionHelper.a(this.f10227a, WifiState.WIFI_UNKNOWN);
            this.f10227a.f.a(DeviceConditionHelper.class.getSimpleName(), e);
            LogUtils.e(1703064931, a);
        }
    }
}
