package com.facebook.wifiscan;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: d263 */
class WifiScanOperation$1 implements ActionReceiver {
    final /* synthetic */ WifiScanOperation f16189a;

    WifiScanOperation$1(WifiScanOperation wifiScanOperation) {
        this.f16189a = wifiScanOperation;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1591434814);
        if (broadcastReceiverLike.isInitialStickyBroadcast()) {
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -531113264, a);
            return;
        }
        WifiScanOperation.f(this.f16189a);
        LogUtils.e(-1304500853, a);
    }
}
