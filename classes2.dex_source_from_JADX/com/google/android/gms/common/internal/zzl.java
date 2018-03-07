package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl {
    private static final Object f18800a = new Object();
    private static zzl f18801b;

    public static zzl m26431a(Context context) {
        synchronized (f18800a) {
            if (f18801b == null) {
                f18801b = new zzm(context.getApplicationContext());
            }
        }
        return f18801b;
    }

    public abstract boolean mo3038a(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean mo3039a(String str, ServiceConnection serviceConnection, String str2);

    public abstract void mo3040b(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void mo3041b(String str, ServiceConnection serviceConnection, String str2);
}
