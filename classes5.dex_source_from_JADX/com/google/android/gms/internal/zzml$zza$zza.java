package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

class zzml$zza$zza implements zzml {
    private IBinder f6885a;

    zzml$zza$zza(IBinder iBinder) {
        this.f6885a = iBinder;
    }

    public final void mo842a(Status status) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.api.internal.IStatusCallback");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6885a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6885a;
    }
}
