package com.facebook.push.c2dm;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: hue */
class C2DMBroadcastReceiver$C2DMActionReceiver implements ActionReceiver {
    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -262040210);
        new StringBuilder("received intent with action: ").append(intent.getAction());
        C2DMService.a(context, intent);
        broadcastReceiverLike.setResult(-1, null, null);
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -23101384, a);
    }
}
