package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.PointOfInterest;

public class zzq$zza$zza implements zzq {
    private IBinder f6709a;

    public zzq$zza$zza(IBinder iBinder) {
        this.f6709a = iBinder;
    }

    public final void mo713a(PointOfInterest pointOfInterest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnPoiClickListener");
            if (pointOfInterest != null) {
                obtain.writeInt(1);
                pointOfInterest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6709a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6709a;
    }
}
