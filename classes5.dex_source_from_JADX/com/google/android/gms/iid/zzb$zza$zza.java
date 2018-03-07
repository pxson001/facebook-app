package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

public class zzb$zza$zza implements zzb {
    private IBinder f6812a;

    public zzb$zza$zza(IBinder iBinder) {
        this.f6812a = iBinder;
    }

    public final void mo811a(Message message) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            if (message != null) {
                obtain.writeInt(1);
                message.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6812a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6812a;
    }
}
