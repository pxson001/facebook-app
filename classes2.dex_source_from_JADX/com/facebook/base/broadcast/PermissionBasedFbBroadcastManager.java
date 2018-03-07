package com.facebook.base.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: updateUnreadCount */
public class PermissionBasedFbBroadcastManager extends BaseFbBroadcastManager {
    protected final Context f1819a;
    protected final String f1820b;

    public PermissionBasedFbBroadcastManager(Context context, String str, @Nullable Lazy<MultiplexBackgroundWorkObserver> lazy) {
        super(lazy);
        this.f1819a = (Context) Preconditions.checkNotNull(context);
        this.f1820b = (String) Preconditions.checkNotNull(str);
    }

    protected final void mo405a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, @Nullable Handler handler) {
        this.f1819a.registerReceiver(broadcastReceiver, intentFilter, this.f1820b, handler);
    }

    protected final void mo404a(BroadcastReceiver broadcastReceiver) {
        this.f1819a.unregisterReceiver(broadcastReceiver);
    }

    public void mo406a(Intent intent) {
        this.f1819a.sendBroadcast(intent, this.f1820b);
    }
}
