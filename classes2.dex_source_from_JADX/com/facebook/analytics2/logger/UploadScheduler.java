package com.facebook.analytics2.logger;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: t_mt_resp */
public abstract class UploadScheduler {
    @GuardedBy("UploadScheduler.class")
    private static UploadScheduler f3515a;

    public abstract String mo760a();

    public abstract void mo761a(int i);

    public abstract void mo762a(int i, UploadJobConfig uploadJobConfig, long j, long j2);

    public abstract long mo763b(int i);

    public abstract ComponentName mo764b();

    public static synchronized UploadScheduler m5734a(Context context) {
        UploadScheduler uploadScheduler;
        synchronized (UploadScheduler.class) {
            if (f3515a == null) {
                if (VERSION.SDK_INT >= 21) {
                    f3515a = new LollipopUploadScheduler(context);
                } else {
                    f3515a = new PreLollipopUploadScheduler(context);
                }
            }
            uploadScheduler = f3515a;
        }
        return uploadScheduler;
    }
}
