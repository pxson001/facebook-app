package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzo;
import com.google.android.gms.measurement.internal.zzt;
import com.google.android.gms.measurement.internal.zzu;

public final class AppMeasurementService extends Service {
    private static Boolean f316b;
    public final Handler f317a = new Handler();

    private static void m636a() {
        try {
            synchronized (AppMeasurementReceiver.f255a) {
                WakeLock wakeLock = AppMeasurementReceiver.f256b;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean m637a(Context context) {
        zzx.m104a((Object) context);
        if (f316b != null) {
            return f316b.booleanValue();
        }
        boolean a = zzae.m362a(context, AppMeasurementService.class);
        f316b = Boolean.valueOf(a);
        return a;
    }

    private zzo m638b() {
        return zzt.m72a((Context) this).m93f();
    }

    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            m638b().f203d.m355a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzu(zzt.m72a((Context) this));
        }
        m638b().f206h.m356a("onBind received unknown action", action);
        return null;
    }

    public final void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 446228471);
        super.onCreate();
        zzo f = zzt.m72a((Context) this).m93f();
        if (zzd.f66a) {
            f.f211m.m355a("Device AppMeasurementService is starting up");
        } else {
            f.f211m.m355a("Local AppMeasurementService is starting up");
        }
        LogUtils.d(2075071480, a);
    }

    public final void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -918645687);
        zzo f = zzt.m72a((Context) this).m93f();
        if (zzd.f66a) {
            f.f211m.m355a("Device AppMeasurementService is shutting down");
        } else {
            f.f211m.m355a("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
        LogUtils.d(1999411279, a);
    }

    public final void onRebind(Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1979186544);
        if (intent == null) {
            m638b().f203d.m355a("onRebind called with null intent");
            Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -273310809, a);
            return;
        }
        m638b().f211m.m356a("onRebind called. action", intent.getAction());
        LogUtils.d(-1186990381, a);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -759224375);
        m636a();
        zzt a2 = zzt.m72a((Context) this);
        zzo f = a2.m93f();
        String action = intent.getAction();
        if (zzd.f66a) {
            f.f211m.m357a("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        } else {
            f.f211m.m357a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a2.m94g().m555a(new 1(this, a2, i2, f));
            LogUtils.d(-1634944886, a);
        } else {
            LogUtils.d(1570463719, a);
        }
        return 2;
    }

    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            m638b().f203d.m355a("onUnbind called with null intent");
        } else {
            m638b().f211m.m356a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
