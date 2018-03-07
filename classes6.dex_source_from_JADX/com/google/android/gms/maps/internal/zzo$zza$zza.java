package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

public class zzo$zza$zza implements zzo {
    private IBinder f6707a;

    public zzo$zza$zza(IBinder iBinder) {
        this.f6707a = iBinder;
    }

    public final boolean mo712a() {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            this.f6707a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6707a;
    }
}
