package com.facebook.analytics2.logger;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: t_mt_req */
class PreLollipopUploadScheduler extends UploadScheduler {
    private final Context f3516a;
    @Nullable
    private UploadScheduler f3517b;

    public PreLollipopUploadScheduler(Context context) {
        this.f3516a = context;
    }

    public final String mo760a() {
        return m5740c().mo760a();
    }

    public final void mo762a(int i, UploadJobConfig uploadJobConfig, long j, long j2) {
        m5740c().mo762a(i, uploadJobConfig, j, j2);
    }

    public final void mo761a(int i) {
        m5740c().mo761a(i);
    }

    public final ComponentName mo764b() {
        return m5740c().mo764b();
    }

    public final long mo763b(int i) {
        return m5740c().mo763b(i);
    }

    @Nonnull
    private synchronized UploadScheduler m5740c() {
        if (this.f3517b == null) {
            this.f3517b = m5741d();
        }
        return this.f3517b;
    }

    private UploadScheduler m5741d() {
        if (m5742e()) {
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.f56b;
            int a = GoogleApiAvailability.m148a(this.f3516a);
            switch (a) {
                case 0:
                    this.f3517b = new GooglePlayUploadScheduler(this.f3516a);
                    break;
                default:
                    new StringBuilder("Falling back to non-GMS alarm scheduling due to connection result of ").append(ConnectionResult.m31392a(a));
                    this.f3517b = new AlarmBasedUploadScheduler(this.f3516a);
                    break;
            }
        }
        this.f3517b = new AlarmBasedUploadScheduler(this.f3516a);
        return this.f3517b;
    }

    private boolean m5742e() {
        try {
            PackageItemInfo applicationInfo = this.f3516a.getPackageManager().getApplicationInfo(this.f3516a.getPackageName(), HTTPTransportCallback.BODY_BYTES_RECEIVED);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return false;
            }
            return applicationInfo.metaData.containsKey("com.google.android.gms.version");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
