package com.facebook.device_id;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: schedule_publish_time */
class UniqueDeviceIdBroadcastSender$LocalBroadcastReceiver$1 implements ActionReceiver {
    UniqueDeviceIdBroadcastSender$LocalBroadcastReceiver$1() {
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -48709075);
        AppInitLockHelper.a(context);
        UniqueDeviceIdBroadcastSender.l(UniqueDeviceIdBroadcastSender.b(FbInjector.get(context)));
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1383952002, a);
    }
}
