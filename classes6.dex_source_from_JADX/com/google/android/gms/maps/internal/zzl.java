package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzl extends IInterface {

    public abstract class zza extends Binder implements zzl {

        class zza implements zzl {
            private IBinder f6704a;

            zza(IBinder iBinder) {
                this.f6704a = iBinder;
            }

            public final void mo538a(IGoogleMapDelegate iGoogleMapDelegate) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    obtain.writeStrongBinder(iGoogleMapDelegate != null ? iGoogleMapDelegate.asBinder() : null);
                    this.f6704a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6704a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    mo538a(com.google.android.gms.maps.internal.IGoogleMapDelegate.zza.m9388a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo538a(IGoogleMapDelegate iGoogleMapDelegate);
}
