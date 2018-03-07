package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.zzn;

public class zzi$zza$zza implements zzi {
    private IBinder f6836a;

    public zzi$zza$zza(IBinder iBinder) {
        this.f6836a = iBinder;
    }

    public final Tile mo846a(int i, int i2, int i3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            Tile a;
            obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeInt(i3);
            this.f6836a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                zzn com_google_android_gms_maps_model_zzn = Tile.CREATOR;
                a = zzn.m9940a(obtain2);
            } else {
                a = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return a;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6836a;
    }
}
