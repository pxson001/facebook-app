package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ICameraUpdateFactoryDelegate extends IInterface {

    public abstract class zza extends Binder implements ICameraUpdateFactoryDelegate {

        class zza implements ICameraUpdateFactoryDelegate {
            private IBinder f6684a;

            zza(IBinder iBinder) {
                this.f6684a = iBinder;
            }

            public final zzd mo539a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    this.f6684a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo540a(float f) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    obtain.writeFloat(f);
                    this.f6684a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo541a(float f, float f2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.f6684a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo542a(float f, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    obtain.writeFloat(f);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f6684a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo543a(CameraPosition cameraPosition) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (cameraPosition != null) {
                        obtain.writeInt(1);
                        cameraPosition.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6684a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo544a(LatLng latLng) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6684a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo545a(LatLng latLng, float f) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeFloat(f);
                    this.f6684a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo546a(LatLngBounds latLngBounds, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f6684a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo547a(LatLngBounds latLngBounds, int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f6684a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6684a;
            }

            public final zzd mo548b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    this.f6684a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final zzd mo549b(float f) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
                    obtain.writeFloat(f);
                    this.f6684a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ICameraUpdateFactoryDelegate m9277a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICameraUpdateFactoryDelegate)) ? new zza(iBinder) : (ICameraUpdateFactoryDelegate) queryLocalInterface;
        }
    }

    zzd mo539a();

    zzd mo540a(float f);

    zzd mo541a(float f, float f2);

    zzd mo542a(float f, int i, int i2);

    zzd mo543a(CameraPosition cameraPosition);

    zzd mo544a(LatLng latLng);

    zzd mo545a(LatLng latLng, float f);

    zzd mo546a(LatLngBounds latLngBounds, int i);

    zzd mo547a(LatLngBounds latLngBounds, int i, int i2, int i3);

    zzd mo548b();

    zzd mo549b(float f);
}
