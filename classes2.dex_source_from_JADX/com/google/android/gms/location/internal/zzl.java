package com.google.android.gms.location.internal;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public class zzl extends zzb {
    public final zzk f18777e;

    public zzl(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, com_google_android_gms_common_internal_zzf);
        this.f18777e = new zzk(context, this.f18778d);
    }

    public final void mo3022a() {
        synchronized (this.f18777e) {
            if (mo3032b()) {
                try {
                    this.f18777e.m26605b();
                    this.f18777e.m26606c();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.mo3022a();
        }
    }

    public final void m26382a(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg com_google_android_gms_location_internal_zzg) {
        synchronized (this.f18777e) {
            this.f18777e.m26604a(locationRequest, locationListener, looper, com_google_android_gms_location_internal_zzg);
        }
    }

    public final Location mo3023r() {
        return this.f18777e.m26603a();
    }
}
