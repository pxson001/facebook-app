package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: SEGMENT_UPLOADING_FAILURE */
class DeviceBasedLoginActivity$2 implements ActionReceiver {
    final /* synthetic */ DeviceBasedLoginActivity f24173a;

    DeviceBasedLoginActivity$2(DeviceBasedLoginActivity deviceBasedLoginActivity) {
        this.f24173a = deviceBasedLoginActivity;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1903677069);
        this.f24173a.K = true;
        DeviceBasedLoginActivity.k(this.f24173a);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1053525554, a);
    }
}
