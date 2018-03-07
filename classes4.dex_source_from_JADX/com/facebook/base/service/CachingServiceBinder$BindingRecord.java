package com.facebook.base.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: has_launched_preview_key */
class CachingServiceBinder$BindingRecord {
    public final ComponentName f10840a;
    public final CachingServiceBinder$InternalServiceConnection f10841b;
    public final Set<ServiceConnection> f10842c = Sets.a();
    public final int f10843d;
    public boolean f10844e;
    public IBinder f10845f;

    public CachingServiceBinder$BindingRecord(ComponentName componentName, CachingServiceBinder$InternalServiceConnection cachingServiceBinder$InternalServiceConnection, int i) {
        this.f10840a = (ComponentName) Preconditions.checkNotNull(componentName);
        this.f10841b = (CachingServiceBinder$InternalServiceConnection) Preconditions.checkNotNull(cachingServiceBinder$InternalServiceConnection);
        this.f10843d = i;
    }
}
