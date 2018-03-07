package com.facebook.analytics2.logger;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: wifi_in_range_duration */
class AlarmBasedUploadScheduler extends UploadScheduler {
    private final Context f89a;
    private final ComponentName f90b;

    public AlarmBasedUploadScheduler(Context context) {
        this.f89a = context;
        this.f90b = new ComponentName(context, AlarmBasedUploadService.class);
    }

    public final String m96a() {
        return "alarm";
    }

    public final void m98a(int i, UploadJobConfig uploadJobConfig, long j, long j2) {
        AlarmBasedUploadService.a(this.f89a, i, uploadJobConfig, j, j2);
    }

    public final void m97a(int i) {
        AlarmBasedUploadService.a(this.f89a, i);
    }

    public final ComponentName m100b() {
        return this.f90b;
    }

    public final long m99b(int i) {
        return Long.MAX_VALUE;
    }
}
