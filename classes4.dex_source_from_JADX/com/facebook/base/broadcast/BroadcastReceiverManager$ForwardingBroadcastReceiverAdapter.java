package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import java.util.Collection;

/* compiled from: is_callable */
class BroadcastReceiverManager$ForwardingBroadcastReceiverAdapter<VAL> extends BroadcastReceiver {
    private final ForwardingBroadcastReceiver<VAL> f10092a;
    private final BroadcastReceiverManager<VAL> f10093b;
    private final Looper f10094c;

    public BroadcastReceiverManager$ForwardingBroadcastReceiverAdapter(ForwardingBroadcastReceiver<VAL> forwardingBroadcastReceiver, BroadcastReceiverManager<VAL> broadcastReceiverManager, Looper looper) {
        this.f10092a = (ForwardingBroadcastReceiver) Preconditions.checkNotNull(forwardingBroadcastReceiver);
        this.f10093b = (BroadcastReceiverManager) Preconditions.checkNotNull(broadcastReceiverManager);
        this.f10094c = (Looper) Preconditions.checkNotNull(looper);
    }

    public final void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 368015069);
        Collection a2 = this.f10093b.a(this.f10094c);
        if (a2 == null || a2.isEmpty()) {
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -596845534, a);
            return;
        }
        this.f10092a.a(a2, intent);
        LogUtils.a(intent, 1803864619, a);
    }
}
