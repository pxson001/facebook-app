package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

public class ILocationSourceDelegate$zza$zza implements ILocationSourceDelegate {
    private IBinder f6686a;

    public ILocationSourceDelegate$zza$zza(IBinder iBinder) {
        this.f6686a = iBinder;
    }

    public final void mo605a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            this.f6686a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo606a(zzh com_google_android_gms_maps_internal_zzh) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            obtain.writeStrongBinder(com_google_android_gms_maps_internal_zzh != null ? com_google_android_gms_maps_internal_zzh.asBinder() : null);
            this.f6686a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6686a;
    }
}
