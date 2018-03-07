package com.facebook.trace;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: segment_id */
class DebugTraceUploader$1 implements ActionReceiver {
    final /* synthetic */ DebugTraceUploader f5086a;

    DebugTraceUploader$1(DebugTraceUploader debugTraceUploader) {
        this.f5086a = debugTraceUploader;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 957024316);
        if (((FbNetworkManager) this.f5086a.c.get()).v()) {
            DebugTraceUploader.d(this.f5086a);
            this.f5086a.i.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -783223591, a);
    }
}
