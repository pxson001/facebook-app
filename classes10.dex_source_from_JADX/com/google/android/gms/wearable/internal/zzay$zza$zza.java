package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

public class zzay$zza$zza implements zzay {
    private IBinder f13374a;

    public zzay$zza$zza(IBinder iBinder) {
        this.f13374a = iBinder;
    }

    public final void mo616a(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
            obtain.writeInt(i);
            this.f13374a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo617a(ParcelFileDescriptor parcelFileDescriptor, long j) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
            if (parcelFileDescriptor != null) {
                obtain.writeInt(1);
                parcelFileDescriptor.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeLong(j);
            this.f13374a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f13374a;
    }
}
