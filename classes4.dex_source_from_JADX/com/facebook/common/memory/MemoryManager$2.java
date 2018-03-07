package com.facebook.common.memory;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: mutateLiveScribeParamsKey */
class MemoryManager$2 implements ActionReceiver {
    final /* synthetic */ MemoryManager f7329a;

    MemoryManager$2(MemoryManager memoryManager) {
        this.f7329a = memoryManager;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 90107346);
        this.f7329a.b();
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 84537503, a);
    }
}
