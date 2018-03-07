package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzd extends IInterface {

    public abstract class zza extends Binder implements zzd {

        class zza implements zzd {
            private IBinder f6795a;

            zza(IBinder iBinder) {
                this.f6795a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6795a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static zzd m12697a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
