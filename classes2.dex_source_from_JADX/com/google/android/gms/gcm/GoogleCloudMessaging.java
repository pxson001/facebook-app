package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import com.google.android.gms.iid.zzc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleCloudMessaging {
    public static int f3667a = 5000000;
    public static int f3668b = 6500000;
    public static int f3669c = 7000000;
    private static final AtomicInteger f3670g = new AtomicInteger(1);
    final Messenger f3671d = new Messenger(new 1(this, Looper.getMainLooper()));
    public Context f3672e;
    public Map<String, Handler> f3673f = Collections.synchronizedMap(new HashMap());
    public final BlockingQueue<Intent> f3674h = new LinkedBlockingQueue();

    public static int m5940b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzc.m5941a(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }
}
