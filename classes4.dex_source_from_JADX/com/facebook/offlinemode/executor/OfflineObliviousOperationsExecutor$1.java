package com.facebook.offlinemode.executor;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.common.OfflineModeHelper$ProcessQueueTrigger;

/* compiled from: getHeadersForVideo-PARTIAL */
class OfflineObliviousOperationsExecutor$1 implements ActionReceiver {
    final /* synthetic */ OfflineObliviousOperationsExecutor f11153a;

    OfflineObliviousOperationsExecutor$1(OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor) {
        this.f11153a = offlineObliviousOperationsExecutor;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -233431375);
        if (this.f11153a.g.d()) {
            OfflineObliviousOperationsExecutor.a(this.f11153a, OfflineModeHelper$ProcessQueueTrigger.CONNECTIVITY_CHANGED);
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -808446906, a);
    }
}
