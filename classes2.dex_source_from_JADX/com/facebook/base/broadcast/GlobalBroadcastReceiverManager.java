package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: sim_operator_name */
public class GlobalBroadcastReceiverManager<T> extends BroadcastReceiverManager<T> {
    private final Context f4740a;

    public GlobalBroadcastReceiverManager(Context context, ForwardingBroadcastReceiver<T> forwardingBroadcastReceiver, IntentFilter intentFilter) {
        super(forwardingBroadcastReceiver, intentFilter);
        this.f4740a = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
    }

    protected final void mo1251a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable String str, @Nullable Handler handler) {
        this.f4740a.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    protected final void mo1250a(BroadcastReceiver broadcastReceiver) {
        this.f4740a.unregisterReceiver(broadcastReceiver);
    }
}
