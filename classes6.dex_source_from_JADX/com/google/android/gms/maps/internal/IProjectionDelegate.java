package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.gms.maps.model.zze;
import com.google.android.gms.maps.model.zzp;

public interface IProjectionDelegate extends IInterface {

    public abstract class zza extends Binder implements IProjectionDelegate {

        class zza implements IProjectionDelegate {
            private IBinder f6689a;

            zza(IBinder iBinder) {
                this.f6689a = iBinder;
            }

            public final zzd mo632a(LatLng latLng) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6689a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd a = com.google.android.gms.dynamic.zzd.zza.a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final LatLng mo633a(zzd com_google_android_gms_dynamic_zzd) {
                LatLng latLng = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    this.f6689a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        zze com_google_android_gms_maps_model_zze = LatLng.CREATOR;
                        latLng = zze.m9932a(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return latLng;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final VisibleRegion mo634a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    VisibleRegion a;
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    this.f6689a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        zzp com_google_android_gms_maps_model_zzp = VisibleRegion.CREATOR;
                        a = zzp.m9942a(obtain2);
                    } else {
                        a = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return a;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6689a;
            }
        }

        public static IProjectionDelegate m9451a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IProjectionDelegate)) ? new zza(iBinder) : (IProjectionDelegate) queryLocalInterface;
        }
    }

    zzd mo632a(LatLng latLng);

    LatLng mo633a(zzd com_google_android_gms_dynamic_zzd);

    VisibleRegion mo634a();
}
