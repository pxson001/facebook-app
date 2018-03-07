package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzr$zza$zza implements zzr {
    private IBinder f6710a;

    public zzr$zza$zza(IBinder iBinder) {
        this.f6710a = iBinder;
    }

    public final void mo714a(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            if (streetViewPanoramaCamera != null) {
                obtain.writeInt(1);
                streetViewPanoramaCamera.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6710a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6710a;
    }
}
