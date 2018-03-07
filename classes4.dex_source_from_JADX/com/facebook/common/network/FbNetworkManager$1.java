package com.facebook.common.network;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: is_using_contextual */
class FbNetworkManager$1 implements ActionReceiver {
    final /* synthetic */ FbNetworkManager f9778a;

    FbNetworkManager$1(FbNetworkManager fbNetworkManager) {
        this.f9778a = fbNetworkManager;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1776747736);
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        int intExtra = intent.getIntExtra("inetCondition", -1);
        Object obj = (this.f9778a.l == null || intExtra != this.f9778a.l.b()) ? 1 : null;
        synchronized (this.f9778a.t) {
            try {
                FbNetworkManager.a(this.f9778a, FbNetworkManager.w(this.f9778a));
                FbNetworkManager.a(this.f9778a, null);
                FbNetworkManager.b(this.f9778a, null);
                FbNetworkManager.c(this.f9778a, null);
            } finally {
                LogUtils.e(1942874592, a);
            }
        }
        FbNetworkManager.a(this.f9778a, Boolean.valueOf(FbNetworkManager.y(this.f9778a)));
        FbNetworkManager.a(this.f9778a, intExtra);
        this.f9778a.a(networkInfo);
        FbNetworkManager.a(this.f9778a, networkInfo, intExtra);
        if (!broadcastReceiverLike.isInitialStickyBroadcast()) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                FbNetworkManager.x(this.f9778a);
            }
            if (obj != null) {
                FbNetworkManager.b(this.f9778a, intExtra);
            }
            LogUtils.e(857565173, a);
        }
    }
}
