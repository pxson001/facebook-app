package com.google.android.gms.location.places.personalized;

import android.os.IBinder;
import android.os.Parcel;

class zza$zza$zza implements zza {
    private IBinder f6607a;

    zza$zza$zza(IBinder iBinder) {
        this.f6607a = iBinder;
    }

    public final void mo527a(PlaceAliasResult placeAliasResult) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
            if (placeAliasResult != null) {
                obtain.writeInt(1);
                placeAliasResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6607a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6607a;
    }

    public final void mo528b(PlaceAliasResult placeAliasResult) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
            if (placeAliasResult != null) {
                obtain.writeInt(1);
                placeAliasResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6607a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
