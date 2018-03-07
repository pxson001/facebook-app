package com.google.android.gms.location.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzg extends IInterface {

    public abstract class zza extends Binder implements zzg {

        class zza implements zzg {
            private IBinder f6397a;

            zza(IBinder iBinder) {
                this.f6397a = iBinder;
            }

            public final void mo452a(FusedLocationProviderResult fusedLocationProviderResult) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                    if (fusedLocationProviderResult != null) {
                        obtain.writeInt(1);
                        fusedLocationProviderResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6397a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6397a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        }

        public static zzg m8870a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new zza(iBinder) : (zzg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                    mo452a(parcel.readInt() != 0 ? (FusedLocationProviderResult) FusedLocationProviderResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo452a(FusedLocationProviderResult fusedLocationProviderResult);
}
