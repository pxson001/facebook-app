package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public class zzlv$zza$zza implements zzlv {
    private IBinder f6828a;

    public zzlv$zza$zza(IBinder iBinder) {
        this.f6828a = iBinder;
    }

    public final void mo822a(Status status) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6828a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6828a;
    }
}
