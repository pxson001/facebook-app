package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;

public interface zzi extends IInterface {

    public abstract class zza extends Binder implements zzi {

        class zza implements zzi {
            private IBinder f6572a;

            zza(IBinder iBinder) {
                this.f6572a = iBinder;
            }

            public final void mo522a(Status status) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6572a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo523a(DataHolder dataHolder) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6572a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6572a;
            }

            public final void mo524b(DataHolder dataHolder) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6572a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo525c(DataHolder dataHolder) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6572a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public final void mo526d(DataHolder dataHolder) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6572a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            DataHolder dataHolder = null;
            zze com_google_android_gms_common_data_zze;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_data_zze = DataHolder.CREATOR;
                        dataHolder = zze.a(parcel);
                    }
                    mo523a(dataHolder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_data_zze = DataHolder.CREATOR;
                        dataHolder = zze.a(parcel);
                    }
                    mo524b(dataHolder);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_data_zze = DataHolder.CREATOR;
                        dataHolder = zze.a(parcel);
                    }
                    mo525c(dataHolder);
                    return true;
                case 4:
                    Status status;
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (parcel.readInt() != 0) {
                        status = (Status) Status.CREATOR.createFromParcel(parcel);
                    }
                    mo522a(status);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_common_data_zze = DataHolder.CREATOR;
                        dataHolder = zze.a(parcel);
                    }
                    mo526d(dataHolder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo522a(Status status);

    void mo523a(DataHolder dataHolder);

    void mo524b(DataHolder dataHolder);

    void mo525c(DataHolder dataHolder);

    void mo526d(DataHolder dataHolder);
}
