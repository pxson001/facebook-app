package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.HashSet;
import java.util.Set;

public abstract class GcmTaskService extends Service {
    private final Set<String> f3636a = new HashSet();
    private int f3637b;

    public static void m5899a(GcmTaskService gcmTaskService, String str) {
        synchronized (gcmTaskService.f3636a) {
            gcmTaskService.f3636a.remove(str);
            if (gcmTaskService.f3636a.size() == 0) {
                gcmTaskService.stopSelf(gcmTaskService.f3637b);
            }
        }
    }

    public abstract int mo768a(TaskParams taskParams);

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 305765908);
        intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
        if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("tag");
            Parcelable parcelableExtra = intent.getParcelableExtra("callback");
            Bundle bundle = (Bundle) intent.getParcelableExtra("extras");
            if (parcelableExtra == null || !(parcelableExtra instanceof PendingCallback)) {
                Log.e("GcmTaskService", getPackageName() + " " + stringExtra + ": Could not process request, invalid callback.");
                Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1111906587, a);
            } else {
                synchronized (this.f3636a) {
                    try {
                        this.f3636a.add(stringExtra);
                        stopSelf(this.f3637b);
                        this.f3637b = i2;
                    } catch (Throwable th) {
                        LogUtils.d(2060217621, a);
                    }
                }
                new zza(this, stringExtra, ((PendingCallback) parcelableExtra).a(), bundle).start();
                LogUtils.d(-366060944, a);
            }
        } else {
            if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(intent.getAction())) {
                synchronized (this.f3636a) {
                    try {
                        this.f3637b = i2;
                        if (this.f3636a.size() == 0) {
                            stopSelf(this.f3637b);
                        }
                    } catch (Throwable th2) {
                        LogUtils.d(1017099790, a);
                    }
                }
            }
            LogUtils.d(-366060944, a);
        }
        return 2;
    }
}
