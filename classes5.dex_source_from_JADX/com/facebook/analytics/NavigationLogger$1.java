package com.facebook.analytics;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.logger.AnalyticsEventNames.AppStateNames;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: timestamp_precise */
class NavigationLogger$1 implements ActionReceiver {
    final /* synthetic */ NavigationLogger f1869a;

    NavigationLogger$1(NavigationLogger navigationLogger) {
        this.f1869a = navigationLogger;
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 958141962);
        String stringExtra = intent.getStringExtra("chat_heads".toString());
        if (stringExtra == null || !(stringExtra.equals("open") || stringExtra.equals("close"))) {
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1856592622, a);
            return;
        }
        HoneyClientEvent a2;
        if (stringExtra.equals("open") && !this.f1869a.y) {
            a2 = NavigationLogger.a(this.f1869a, this.f1869a.a.a(), AppStateNames.BACKGROUNDED);
            a2.c = "chat_heads";
            NavigationLogger.a(this.f1869a, a2);
            this.f1869a.y = true;
        } else if (stringExtra.equals("close") && this.f1869a.y) {
            a2 = NavigationLogger.a(this.f1869a, this.f1869a.a.a(), AppStateNames.FOREGROUNDED);
            a2.c = "chat_heads";
            NavigationLogger.b(this.f1869a, a2);
            this.f1869a.y = false;
        }
        LogUtils.e(-509151492, a);
    }
}
