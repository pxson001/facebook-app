package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzae;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    static final Object f255a = new Object();
    static WakeLock f256b;
    static Boolean f257c;

    public static boolean m544a(Context context) {
        zzx.m104a((Object) context);
        if (f257c != null) {
            return f257c.booleanValue();
        }
        boolean a = zzae.m363a(context, AppMeasurementReceiver.class, false);
        f257c = Boolean.valueOf(a);
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r9, android.content.Intent r10) {
        /*
        r8 = this;
        r0 = 2;
        r1 = com.facebook.loom.logger.LogEntry.EntryType.LIFECYCLE_BROADCAST_RECEIVER_START;
        r2 = -779063743; // 0xffffffffd1906e41 float:-7.7540631E10 double:NaN;
        r1 = com.facebook.loom.logger.Logger.a(r0, r1, r2);
        r0 = com.google.android.gms.measurement.internal.zzt.m72a(r9);
        r2 = r0.m93f();
        r0 = r10.getAction();
        r3 = com.google.android.gms.measurement.internal.zzc.m123B();
        if (r3 == 0) goto L_0x004d;
    L_0x001c:
        r3 = r2.m350t();
        r4 = "Device AppMeasurementReceiver got";
        r3.m356a(r4, r0);
    L_0x0025:
        r3 = "com.google.android.gms.measurement.UPLOAD";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0078;
    L_0x002d:
        r0 = com.google.android.gms.measurement.AppMeasurementService.m637a(r9);
        r3 = new android.content.Intent;
        r4 = com.google.android.gms.measurement.AppMeasurementService.class;
        r3.<init>(r9, r4);
        r4 = "com.google.android.gms.measurement.UPLOAD";
        r3.setAction(r4);
        r4 = f255a;
        monitor-enter(r4);
        r9.startService(r3);	 Catch:{ all -> 0x008a }
        if (r0 != 0) goto L_0x0057;
    L_0x0045:
        monitor-exit(r4);	 Catch:{ all -> 0x008a }
        r0 = 956125117; // 0x38fd4fbd float:1.20788325E-4 double:4.723885734E-315;
        com.facebook.tools.dextr.runtime.LogUtils.a(r10, r0, r1);
    L_0x004c:
        return;
    L_0x004d:
        r3 = r2.m350t();
        r4 = "Local AppMeasurementReceiver got";
        r3.m356a(r4, r0);
        goto L_0x0025;
    L_0x0057:
        r0 = "power";
        r0 = r9.getSystemService(r0);	 Catch:{ SecurityException -> 0x007f }
        r0 = (android.os.PowerManager) r0;	 Catch:{ SecurityException -> 0x007f }
        r3 = f256b;	 Catch:{ SecurityException -> 0x007f }
        if (r3 != 0) goto L_0x0070;
    L_0x0063:
        r3 = 1;
        r5 = "AppMeasurement WakeLock";
        r0 = r0.newWakeLock(r3, r5);	 Catch:{ SecurityException -> 0x007f }
        f256b = r0;	 Catch:{ SecurityException -> 0x007f }
        r3 = 0;
        r0.setReferenceCounted(r3);	 Catch:{ SecurityException -> 0x007f }
    L_0x0070:
        r0 = f256b;	 Catch:{ SecurityException -> 0x007f }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.acquire(r6);	 Catch:{ SecurityException -> 0x007f }
    L_0x0077:
        monitor-exit(r4);	 Catch:{  }
    L_0x0078:
        r0 = 270391010; // 0x101dd6e2 float:3.112833E-29 double:1.33590909E-315;
        com.facebook.tools.dextr.runtime.LogUtils.a(r10, r0, r1);
        goto L_0x004c;
    L_0x007f:
        r0 = move-exception;
        r0 = r2.m348o();	 Catch:{  }
        r2 = "AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.";
        r0.m355a(r2);	 Catch:{  }
        goto L_0x0077;
    L_0x008a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{  }
        r2 = -134154914; // 0xfffffffff800f55e float:-1.0462354E34 double:NaN;
        com.facebook.tools.dextr.runtime.LogUtils.a(r10, r2, r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurementReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
