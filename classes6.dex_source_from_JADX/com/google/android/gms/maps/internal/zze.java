package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;

public interface zze extends IInterface {

    public abstract class zza extends Binder implements zze {

        public class zza implements zze {
            private IBinder f6697a;

            public zza(IBinder iBinder) {
                this.f6697a = iBinder;
            }

            public final void mo534a(CameraPosition cameraPosition) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                    if (cameraPosition != null) {
                        obtain.writeInt(1);
                        cameraPosition.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6697a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6697a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnCameraChangeListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    CameraPosition a;
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                    if (parcel.readInt() != 0) {
                        com.google.android.gms.maps.model.zza com_google_android_gms_maps_model_zza = CameraPosition.CREATOR;
                        a = com.google.android.gms.maps.model.zza.m9928a(parcel);
                    } else {
                        a = null;
                    }
                    mo534a(a);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo534a(CameraPosition cameraPosition);
}
