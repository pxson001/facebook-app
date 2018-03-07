package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;

public abstract class zzmk extends BroadcastReceiver {
    protected Context f6883a;

    zzmk() {
    }

    public static <T extends zzmk> T m12843a(Context context, T t) {
        return m12844a(context, t, GoogleApiAvailability.b);
    }

    public static <T extends zzmk> T m12844a(Context context, T t, GoogleApiAvailability googleApiAvailability) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(t, intentFilter);
        t.f6883a = context;
        if (GooglePlayServicesUtil.a(context, "com.google.android.gms")) {
            return t;
        }
        t.mo841a();
        t.m12846b();
        return null;
    }

    protected abstract void mo841a();

    public final synchronized void m12846b() {
        if (this.f6883a != null) {
            this.f6883a.unregisterReceiver(this);
        }
        this.f6883a = null;
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2110431130);
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            mo841a();
            m12846b();
        }
        LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 728158488, a);
    }
}
