package com.google.android.gms.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzc extends IInterface {

    public abstract class zza extends Binder implements zzc {

        public class zza implements zzc {
            private IBinder f6616a;

            public zza(IBinder iBinder) {
                this.f6616a = iBinder;
            }

            public final void mo485a(LocationAvailability locationAvailability) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
                    if (locationAvailability != null) {
                        obtain.writeInt(1);
                        locationAvailability.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6616a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo486a(LocationResult locationResult) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
                    if (locationResult != null) {
                        obtain.writeInt(1);
                        locationResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6616a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6616a;
            }
        }
    }

    void mo485a(LocationAvailability locationAvailability);

    void mo486a(LocationResult locationResult);
}
