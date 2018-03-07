package com.facebook.base.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: has_launched_preview_key */
class CachingServiceBinder$InternalServiceConnection implements ServiceConnection {
    final /* synthetic */ CachingServiceBinder f10846a;

    public CachingServiceBinder$InternalServiceConnection(CachingServiceBinder cachingServiceBinder) {
        this.f10846a = cachingServiceBinder;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CachingServiceBinder.b(this.f10846a, componentName, iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        CachingServiceBinder.b(this.f10846a, componentName, null);
    }
}
