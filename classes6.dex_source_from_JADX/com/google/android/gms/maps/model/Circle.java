package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzb;

public final class Circle {
    private final zzb f6725a;

    public Circle(zzb com_google_android_gms_maps_model_internal_zzb) {
        this.f6725a = (zzb) zzx.a(com_google_android_gms_maps_model_internal_zzb);
    }

    public final void m9652a(double d) {
        try {
            this.f6725a.mo745a(d);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9653a(LatLng latLng) {
        try {
            this.f6725a.mo748a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9654a(boolean z) {
        try {
            this.f6725a.mo749a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.f6725a.mo750a(((Circle) obj).f6725a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f6725a.mo761j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
