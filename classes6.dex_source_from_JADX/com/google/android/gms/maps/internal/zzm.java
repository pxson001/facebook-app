package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.zzf;

public interface zzm extends IInterface {

    public abstract class zza extends Binder implements zzm {

        public class zza implements zzm {
            private IBinder f6705a;

            public zza(IBinder iBinder) {
                this.f6705a = iBinder;
            }

            public final boolean mo529a(zzf com_google_android_gms_maps_model_internal_zzf) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    obtain.writeStrongBinder(com_google_android_gms_maps_model_internal_zzf != null ? com_google_android_gms_maps_model_internal_zzf.asBinder() : null);
                    this.f6705a.transact(1, obtain, obtain2, 0);
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

            public IBinder asBinder() {
                return this.f6705a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    boolean a = mo529a(com.google.android.gms.maps.model.internal.zzf.zza.m9861a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean mo529a(zzf com_google_android_gms_maps_model_internal_zzf);
}
