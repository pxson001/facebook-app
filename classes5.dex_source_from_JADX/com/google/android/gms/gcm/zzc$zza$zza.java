package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;

public class zzc$zza$zza implements zzc {
    private IBinder f6809a;

    public zzc$zza$zza(IBinder iBinder) {
        this.f6809a = iBinder;
    }

    public final void mo810a(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
            obtain.writeInt(i);
            this.f6809a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6809a;
    }
}
