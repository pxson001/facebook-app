package com.facebook.common.network;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.manager.UploadManager.2;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: show_profile_crop_overlay */
class NetworkMonitor$2 implements ActionReceiver {
    final /* synthetic */ State f2717a;
    final /* synthetic */ 2 f2718b;
    final /* synthetic */ NetworkMonitor f2719c;

    NetworkMonitor$2(NetworkMonitor networkMonitor, State state, 2 2) {
        this.f2719c = networkMonitor;
        this.f2717a = state;
        this.f2718b = 2;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1474072042);
        int intExtra = intent.getIntExtra("INET_CONDITION", 0);
        switch (NetworkMonitor$3.f2720a[this.f2717a.ordinal()]) {
            case 1:
                if (this.f2719c.b.d()) {
                    this.f2718b.a(intExtra);
                    break;
                }
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (!this.f2719c.b.d()) {
                    this.f2718b.a(intExtra);
                    break;
                }
                break;
        }
        LogUtils.e(-345081055, a);
    }
}
