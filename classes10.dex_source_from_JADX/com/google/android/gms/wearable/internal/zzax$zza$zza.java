package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

public class zzax$zza$zza implements zzax {
    private IBinder f13373a;

    public zzax$zza$zza(IBinder iBinder) {
        this.f13373a = iBinder;
    }

    public final void mo615a(ParcelFileDescriptor parcelFileDescriptor) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IFileDescriptorReceiver");
            if (parcelFileDescriptor != null) {
                obtain.writeInt(1);
                parcelFileDescriptor.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f13373a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f13373a;
    }
}
