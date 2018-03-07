package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v7.widget.LinearLayoutCompat;

public interface zzl extends IInterface {

    public abstract class zza extends Binder implements zzl {

        class zza implements zzl {
            private IBinder f7085a;

            zza(IBinder iBinder) {
                this.f7085a = iBinder;
            }

            public final void mo848a(AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7085a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo849a(EventParcel eventParcel, AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7085a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo850a(EventParcel eventParcel, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (eventParcel != null) {
                        obtain.writeInt(1);
                        eventParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f7085a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void mo851a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (userAttributeParcel != null) {
                        obtain.writeInt(1);
                        userAttributeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7085a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f7085a;
            }

            public final void mo852b(AppMetadata appMetadata) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7085a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
        }

        public static zzl m13091a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzl)) ? new zza(iBinder) : (zzl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AppMetadata appMetadata = null;
            zzj com_google_android_gms_measurement_internal_zzj;
            zzb com_google_android_gms_measurement_internal_zzb;
            zzb com_google_android_gms_measurement_internal_zzb2;
            switch (i) {
                case 1:
                    EventParcel a;
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_measurement_internal_zzj = EventParcel.CREATOR;
                        a = zzj.m13080a(parcel);
                    } else {
                        a = null;
                    }
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_measurement_internal_zzb = AppMetadata.CREATOR;
                        appMetadata = zzb.m13076a(parcel);
                    }
                    mo849a(a, appMetadata);
                    parcel2.writeNoException();
                    return true;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    UserAttributeParcel a2;
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (parcel.readInt() != 0) {
                        zzad com_google_android_gms_measurement_internal_zzad = UserAttributeParcel.CREATOR;
                        a2 = zzad.m13075a(parcel);
                    } else {
                        a2 = null;
                    }
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_measurement_internal_zzb = AppMetadata.CREATOR;
                        appMetadata = zzb.m13076a(parcel);
                    }
                    mo851a(a2, appMetadata);
                    parcel2.writeNoException();
                    return true;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_measurement_internal_zzb2 = AppMetadata.CREATOR;
                        appMetadata = zzb.m13076a(parcel);
                    }
                    mo848a(appMetadata);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    EventParcel a3;
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_measurement_internal_zzj = EventParcel.CREATOR;
                        a3 = zzj.m13080a(parcel);
                    }
                    mo850a(a3, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_measurement_internal_zzb2 = AppMetadata.CREATOR;
                        appMetadata = zzb.m13076a(parcel);
                    }
                    mo852b(appMetadata);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo848a(AppMetadata appMetadata);

    void mo849a(EventParcel eventParcel, AppMetadata appMetadata);

    void mo850a(EventParcel eventParcel, String str, String str2);

    void mo851a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata);

    void mo852b(AppMetadata appMetadata);
}
