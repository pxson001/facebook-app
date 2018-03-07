package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;
import java.util.Map;

public class zzk {
    public final zzp<zzi> f18925a;
    private final Context f18926b;
    private ContentProviderClient f18927c = null;
    private boolean f18928d = false;
    private Map<LocationListener, zzc> f18929e = new HashMap();
    private Map<Object, zza> f18930f = new HashMap();

    public zzk(Context context, zzp<zzi> com_google_android_gms_location_internal_zzp_com_google_android_gms_location_internal_zzi) {
        this.f18926b = context;
        this.f18925a = com_google_android_gms_location_internal_zzp_com_google_android_gms_location_internal_zzi;
    }

    private zzc m26601a(LocationListener locationListener, Looper looper) {
        zzc com_google_android_gms_location_internal_zzk_zzc;
        synchronized (this.f18929e) {
            com_google_android_gms_location_internal_zzk_zzc = (zzc) this.f18929e.get(locationListener);
            if (com_google_android_gms_location_internal_zzk_zzc == null) {
                com_google_android_gms_location_internal_zzk_zzc = new zzc(locationListener, looper);
            }
            this.f18929e.put(locationListener, com_google_android_gms_location_internal_zzk_zzc);
        }
        return com_google_android_gms_location_internal_zzk_zzc;
    }

    private void m26602a(boolean z) {
        this.f18925a.mo3043a();
        ((zzi) this.f18925a.mo3044b()).a(z);
        this.f18928d = z;
    }

    public final Location m26603a() {
        this.f18925a.mo3043a();
        try {
            return ((zzi) this.f18925a.mo3044b()).b(this.f18926b.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void m26604a(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg com_google_android_gms_location_internal_zzg) {
        this.f18925a.mo3043a();
        ((zzi) this.f18925a.mo3044b()).a(new LocationRequestUpdateData(1, 1, LocationRequestInternal.a(locationRequest), m26601a(locationListener, looper).asBinder(), null, null, com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null));
    }

    public final void m26605b() {
        try {
            synchronized (this.f18929e) {
                for (zzc com_google_android_gms_location_internal_zzk_zzc : this.f18929e.values()) {
                    if (com_google_android_gms_location_internal_zzk_zzc != null) {
                        ((zzi) this.f18925a.mo3044b()).a(LocationRequestUpdateData.a(com_google_android_gms_location_internal_zzk_zzc, null));
                    }
                }
                this.f18929e.clear();
            }
            synchronized (this.f18930f) {
                for (zza com_google_android_gms_location_internal_zzk_zza : this.f18930f.values()) {
                    if (com_google_android_gms_location_internal_zzk_zza != null) {
                        ((zzi) this.f18925a.mo3044b()).a(LocationRequestUpdateData.a(com_google_android_gms_location_internal_zzk_zza, null));
                    }
                }
                this.f18930f.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final void m26606c() {
        if (this.f18928d) {
            try {
                m26602a(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
