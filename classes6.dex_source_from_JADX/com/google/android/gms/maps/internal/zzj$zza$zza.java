package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

public class zzj$zza$zza implements zzj {
    private IBinder f6702a;

    public zzj$zza$zza(IBinder iBinder) {
        this.f6702a = iBinder;
    }

    public final void mo707a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            this.f6702a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6702a;
    }
}
