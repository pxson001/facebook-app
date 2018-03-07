package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;

class zzaw$zza$zza implements zzaw {
    private IBinder f13372a;

    zzaw$zza$zza(IBinder iBinder) {
        this.f13372a = iBinder;
    }

    public final void mo614a(int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f13372a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f13372a;
    }
}
