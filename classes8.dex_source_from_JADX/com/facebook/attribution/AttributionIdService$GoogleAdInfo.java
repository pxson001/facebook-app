package com.facebook.attribution;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: is_deleted_client = ? AND is_unarchived_client = ? */
final class AttributionIdService$GoogleAdInfo implements IInterface {
    private IBinder f10627a;

    AttributionIdService$GoogleAdInfo(IBinder iBinder) {
        this.f10627a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f10627a;
    }

    public final String m12556a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f10627a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m12557b() {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeInt(1);
            this.f10627a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
