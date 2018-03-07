package com.facebook.selfupdate.remotepushtrigger;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: POST_BY_OTHERS */
class RemotePushTriggerWifiChangeMonitor$4 implements ActionReceiver {
    final /* synthetic */ RemotePushTriggerWifiChangeMonitor f12545a;

    RemotePushTriggerWifiChangeMonitor$4(RemotePushTriggerWifiChangeMonitor remotePushTriggerWifiChangeMonitor) {
        this.f12545a = remotePushTriggerWifiChangeMonitor;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1987386920);
        if (!this.f12545a.e.b()) {
            RemotePushTriggerWifiChangeMonitor.b(this.f12545a);
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 324453470, a);
    }
}
