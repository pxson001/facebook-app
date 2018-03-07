package com.facebook.analytics2.logger;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.facebook.analytics2.logger.UploadServiceLogic.FallbackConfig;
import com.facebook.analytics2.logger.UploadServiceLogic.StartServiceParams;
import com.facebook.analytics2.logger.UploadServiceLogic.StopServiceCallback;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: tab_dest_name */
public class AlarmBasedUploadService extends Service {
    private static final long f3379a = TimeUnit.MINUTES.toMillis(5);
    private static final long f3380b = TimeUnit.HOURS.toMillis(6);
    @GuardedBy("AlarmBasedUploadService.class")
    @Nullable
    private static AlarmManager f3381d;
    @Nullable
    private UploadServiceLogic f3382c;

    private static synchronized AlarmManager m5591a(Context context) {
        AlarmManager alarmManager;
        synchronized (AlarmBasedUploadService.class) {
            if (f3381d == null) {
                f3381d = (AlarmManager) context.getSystemService("alarm");
            }
            alarmManager = f3381d;
        }
        return alarmManager;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1346410516);
        this.f3382c = new UploadServiceLogic(this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 192141211, a);
    }

    public static void m5594a(Context context, int i, UploadJobConfig uploadJobConfig, long j, long j2) {
        long j3;
        if (j < f3379a) {
            j3 = f3379a;
        } else {
            j3 = Math.min(f3380b, 2 * j);
        }
        m5591a(context).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getService(context, 0, new Intent(context, AlarmBasedUploadService.class).setAction(m5592a(i)).putExtras(StartServiceParams.a(null, null, null, uploadJobConfig, i, new FallbackConfig(j3, j3 + (j2 - j))).a()), 134217728));
    }

    public static void m5593a(Context context, int i) {
        PendingIntent service = PendingIntent.getService(context, 0, new Intent().setComponent(new ComponentName(context, AlarmBasedUploadService.class)).setAction(m5592a(i)), 536870912);
        if (service != null) {
            m5591a(context).cancel(service);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1376750835);
        if (intent != null && intent.getAction().startsWith("com.facebook.analytics2.logger.UPLOAD_NOW")) {
            intent.setAction("com.facebook.analytics2.logger.UPLOAD_NOW");
        }
        int a2 = ((UploadServiceLogic) Assertions.m5471b(this.f3382c)).a(intent, new StopServiceCallback(this, i2));
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -103674956, a);
        return a2;
    }

    private static String m5592a(int i) {
        return "com.facebook.analytics2.logger.UPLOAD_NOW-" + i;
    }
}
