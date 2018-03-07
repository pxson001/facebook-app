package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.zze;

public interface zzi extends IInterface {

    public abstract class zza extends Binder implements zzi {

        public class zza implements zzi {
            private IBinder f6701a;

            public zza(IBinder iBinder) {
                this.f6701a = iBinder;
            }

            public final void mo535a(LatLng latLng) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapClickListener");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6701a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6701a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    LatLng a;
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
                    if (parcel.readInt() != 0) {
                        zze com_google_android_gms_maps_model_zze = LatLng.CREATOR;
                        a = zze.m9932a(parcel);
                    } else {
                        a = null;
                    }
                    mo535a(a);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMapClickListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo535a(LatLng latLng);
}
