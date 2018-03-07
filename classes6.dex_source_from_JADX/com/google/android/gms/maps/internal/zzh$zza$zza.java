package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

public class zzh$zza$zza implements zzh {
    private IBinder f6700a;

    public zzh$zza$zza(IBinder iBinder) {
        this.f6700a = iBinder;
    }

    public final void mo705a(Location location) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            if (location != null) {
                obtain.writeInt(1);
                location.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6700a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo706a(zzd com_google_android_gms_dynamic_zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            this.f6700a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6700a;
    }
}
