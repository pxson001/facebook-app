package com.facebook.video.exoserviceclient;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.exoserviceclient.ExoServiceClient.ConnectionStatus;

/* compiled from: perf_always_log_image */
class ExoServiceClient$2 implements ActionReceiver {
    final /* synthetic */ ExoServiceClient f5146a;

    ExoServiceClient$2(ExoServiceClient exoServiceClient) {
        this.f5146a = exoServiceClient;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1271866117);
        ConnectionStatus i = ExoServiceClient.i(this.f5146a);
        String str = ExoServiceClient.a;
        if (i == ConnectionStatus.NONE || !(i == this.f5146a.p || this.f5146a.p == ConnectionStatus.NONE)) {
            str = ExoServiceClient.a;
            ConnectionStatus connectionStatus = this.f5146a.p;
            this.f5146a.d();
        }
        this.f5146a.p = i;
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2125169641, a);
    }
}
