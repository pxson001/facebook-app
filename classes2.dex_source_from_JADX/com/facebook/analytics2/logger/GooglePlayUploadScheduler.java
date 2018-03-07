package com.facebook.analytics2.logger;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: t2045339 */
class GooglePlayUploadScheduler extends UploadScheduler {
    private final Context f3629a;
    private final ComponentName f3630b;

    public GooglePlayUploadScheduler(Context context) {
        this.f3629a = context;
        this.f3630b = new ComponentName(context, GooglePlayUploadService.class);
    }

    public final String mo760a() {
        return "gcm";
    }

    public final void mo762a(int i, UploadJobConfig uploadJobConfig, long j, long j2) {
        GooglePlayUploadService.m5890a(this.f3629a, i, uploadJobConfig, j, j2);
    }

    public final void mo761a(int i) {
        GooglePlayUploadService.m5888a(this.f3629a, i);
    }

    public final ComponentName mo764b() {
        return this.f3630b;
    }

    public final long mo763b(int i) {
        return Long.MAX_VALUE;
    }
}
