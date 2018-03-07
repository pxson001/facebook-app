package com.google.android.gms.location.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsResult;

public interface zzj extends IInterface {

    public abstract class zza extends Binder implements zzj {

        public class zza implements zzj {
            private IBinder f6400a;

            public zza(IBinder iBinder) {
                this.f6400a = iBinder;
            }

            public final void mo484a(LocationSettingsResult locationSettingsResult) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.ISettingsCallbacks");
                    if (locationSettingsResult != null) {
                        obtain.writeInt(1);
                        locationSettingsResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6400a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6400a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.internal.ISettingsCallbacks");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.location.internal.ISettingsCallbacks");
                    mo484a(parcel.readInt() != 0 ? (LocationSettingsResult) LocationSettingsResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.internal.ISettingsCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo484a(LocationSettingsResult locationSettingsResult);
}
