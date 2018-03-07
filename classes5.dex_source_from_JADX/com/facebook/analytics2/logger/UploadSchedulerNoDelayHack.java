package com.facebook.analytics2.logger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.facebook.analytics2.logger.UploadServiceLogic.FallbackConfig;
import com.facebook.analytics2.logger.UploadServiceLogic.StartServiceParams;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: terms_of_service_url */
class UploadSchedulerNoDelayHack {
    private static final long f2075a = TimeUnit.SECONDS.toMillis(90);
    private static UploadSchedulerNoDelayHack f2076b;
    private PowerManager f2077c;

    /* compiled from: terms_of_service_url */
    public class WakeLockReleaseHandler {
        public final WakeLock f2074a;

        public WakeLockReleaseHandler(WakeLock wakeLock) {
            this.f2074a = wakeLock;
        }
    }

    public static UploadSchedulerNoDelayHack m2780a() {
        UploadSchedulerNoDelayHack uploadSchedulerNoDelayHack;
        synchronized (UploadSchedulerNoDelayHack.class) {
            if (f2076b == null) {
                f2076b = new UploadSchedulerNoDelayHack();
            }
            uploadSchedulerNoDelayHack = f2076b;
        }
        return uploadSchedulerNoDelayHack;
    }

    private UploadSchedulerNoDelayHack() {
    }

    private PowerManager m2779a(Context context) {
        PowerManager powerManager;
        synchronized (UploadSchedulerNoDelayHack.class) {
            if (this.f2077c == null) {
                this.f2077c = (PowerManager) context.getApplicationContext().getSystemService("power");
            }
            powerManager = this.f2077c;
        }
        return powerManager;
    }

    public final void m2781a(Context context, String str, UploadJobConfig uploadJobConfig, Bundle bundle, int i, @Nullable FallbackConfig fallbackConfig) {
        if (fallbackConfig == null || (fallbackConfig.a >= 0 && fallbackConfig.b >= 0)) {
            ComponentName b = UploadScheduler.a(context).b();
            WakeLock newWakeLock = m2779a(context).newWakeLock(1, "JobSchedulerHack-" + b.getShortClassName() + "-client-" + String.valueOf(i));
            newWakeLock.setReferenceCounted(false);
            Intent putExtras = new Intent().setComponent(b).setAction(str).putExtras(StartServiceParams.a(new WakeLockReleaseHandler(newWakeLock), bundle, str, uploadJobConfig, i, fallbackConfig).a());
            newWakeLock.acquire(f2075a);
            context.startService(putExtras);
            return;
        }
        throw new IllegalStateException("fallback delay ms must be >= 0");
    }
}
