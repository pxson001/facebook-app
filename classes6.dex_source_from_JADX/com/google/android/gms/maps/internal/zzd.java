package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.zzf;

public interface zzd extends IInterface {

    public abstract class zza extends Binder implements zzd {

        public class zza implements zzd {
            private IBinder f6696a;

            public zza(IBinder iBinder) {
                this.f6696a = iBinder;
            }

            public final com.google.android.gms.dynamic.zzd mo531a(zzf com_google_android_gms_maps_model_internal_zzf) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(com_google_android_gms_maps_model_internal_zzf != null ? com_google_android_gms_maps_model_internal_zzf.asBinder() : null);
                    this.f6696a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    com.google.android.gms.dynamic.zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6696a;
            }

            public final com.google.android.gms.dynamic.zzd mo532b(zzf com_google_android_gms_maps_model_internal_zzf) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(com_google_android_gms_maps_model_internal_zzf != null ? com_google_android_gms_maps_model_internal_zzf.asBinder() : null);
                    this.f6696a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    com.google.android.gms.dynamic.zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            com.google.android.gms.dynamic.zzd a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    a = mo531a(com.google.android.gms.maps.model.internal.zzf.zza.m9861a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    a = mo532b(com.google.android.gms.maps.model.internal.zzf.zza.m9861a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    com.google.android.gms.dynamic.zzd mo531a(zzf com_google_android_gms_maps_model_internal_zzf);

    com.google.android.gms.dynamic.zzd mo532b(zzf com_google_android_gms_maps_model_internal_zzf);
}
