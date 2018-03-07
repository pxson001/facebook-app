package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.os.Looper;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: is_callable */
class BroadcastReceiverManager$BroadcastReceiverHolder<VAL> {
    public final BroadcastReceiver f10095a;
    public final Looper f10096b;
    public final List<VAL> f10097c = new ArrayList(4);

    public BroadcastReceiverManager$BroadcastReceiverHolder(BroadcastReceiver broadcastReceiver, Looper looper, VAL val) {
        this.f10095a = (BroadcastReceiver) Preconditions.checkNotNull(broadcastReceiver);
        this.f10096b = looper;
        this.f10097c.add(val);
    }
}
