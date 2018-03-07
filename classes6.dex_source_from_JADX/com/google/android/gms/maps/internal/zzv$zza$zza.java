package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

class zzv$zza$zza implements zzv {
    private IBinder f6714a;

    zzv$zza$zza(IBinder iBinder) {
        this.f6714a = iBinder;
    }

    public final void mo718a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            obtain.writeStrongBinder(iStreetViewPanoramaDelegate != null ? iStreetViewPanoramaDelegate.asBinder() : null);
            this.f6714a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6714a;
    }
}
