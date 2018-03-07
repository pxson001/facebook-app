package com.google.android.gms.location.places.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;

class zzh$zza$zza implements zzh {
    private IBinder f6571a;

    zzh$zza$zza(IBinder iBinder) {
        this.f6571a = iBinder;
    }

    public final void mo520a(PlacePhotoMetadataResult placePhotoMetadataResult) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            if (placePhotoMetadataResult != null) {
                obtain.writeInt(1);
                placePhotoMetadataResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6571a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void mo521a(PlacePhotoResult placePhotoResult) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            if (placePhotoResult != null) {
                obtain.writeInt(1);
                placePhotoResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6571a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6571a;
    }
}
