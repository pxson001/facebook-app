package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzf;

public final class Marker {
    private final zzf f6756a;

    public Marker(zzf com_google_android_gms_maps_model_internal_zzf) {
        this.f6756a = (zzf) zzx.a(com_google_android_gms_maps_model_internal_zzf);
    }

    public final void m9660a() {
        try {
            this.f6756a.mo789a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9661a(BitmapDescriptor bitmapDescriptor) {
        try {
            this.f6756a.mo792a(bitmapDescriptor.m9648a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9662a(LatLng latLng) {
        try {
            this.f6756a.mo793a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9663a(String str) {
        try {
            this.f6756a.mo800b(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final LatLng m9664b() {
        try {
            return this.f6756a.mo802c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String m9665c() {
        try {
            return this.f6756a.mo805e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9666d() {
        try {
            this.f6756a.mo807g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void m9667e() {
        try {
            this.f6756a.mo808h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.f6756a.mo796a(((Marker) obj).f6756a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f6756a.mo811k();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
