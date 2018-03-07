package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.internal.zzh.zza;

public final class zzl$zza extends zza {
    private zzb<Status> f6404a;

    public zzl$zza(zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        this.f6404a = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
    }

    public final void mo453a(int i, PendingIntent pendingIntent) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }

    public final void mo454a(int i, String[] strArr) {
        if (this.f6404a == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            return;
        }
        this.f6404a.a(LocationStatusCodes.m8857b(LocationStatusCodes.m8856a(i)));
        this.f6404a = null;
    }

    public final void mo455b(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }
}
