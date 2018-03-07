package com.facebook.video.exoserviceclient;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: perf_always_log_image */
class ExoServiceClient$3 implements ActionReceiver {
    final /* synthetic */ ExoServiceClient f5147a;

    ExoServiceClient$3(ExoServiceClient exoServiceClient) {
        this.f5147a = exoServiceClient;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1828568520);
        ExoServiceClient.k(this.f5147a);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -199696297, a);
    }
}
