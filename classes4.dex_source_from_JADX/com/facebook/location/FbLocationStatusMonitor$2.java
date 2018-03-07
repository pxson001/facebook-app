package com.facebook.location;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: is_on_wifi */
class FbLocationStatusMonitor$2 implements ActionReceiver {
    final /* synthetic */ FbLocationStatusMonitor f9942a;

    FbLocationStatusMonitor$2(FbLocationStatusMonitor fbLocationStatusMonitor) {
        this.f9942a = fbLocationStatusMonitor;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 814104493);
        if (!broadcastReceiverLike.isInitialStickyBroadcast()) {
            FbLocationStatusMonitor.d(this.f9942a);
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1555616009, a);
    }
}
