package com.facebook.selfupdate.remotepushtrigger;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: POST_BY_OTHERS */
class RemotePushTriggerWifiChangeMonitor$3 implements ActionReceiver {
    final /* synthetic */ RemotePushTriggerWifiChangeMonitor f12544a;

    RemotePushTriggerWifiChangeMonitor$3(RemotePushTriggerWifiChangeMonitor remotePushTriggerWifiChangeMonitor) {
        this.f12544a = remotePushTriggerWifiChangeMonitor;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1782158076);
        RemotePushTriggerWifiChangeMonitor remotePushTriggerWifiChangeMonitor = this.f12544a;
        if (!remotePushTriggerWifiChangeMonitor.e.b()) {
            DeviceConditionHelper deviceConditionHelper = remotePushTriggerWifiChangeMonitor.b;
            deviceConditionHelper.l.remove(remotePushTriggerWifiChangeMonitor.i);
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 653873147, a);
    }
}
