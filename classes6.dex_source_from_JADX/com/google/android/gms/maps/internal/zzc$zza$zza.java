package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.zza;

public class zzc$zza$zza implements zzc {
    private IBinder f6695a;

    public zzc$zza$zza(IBinder iBinder) {
        this.f6695a = iBinder;
    }

    public final ICameraUpdateFactoryDelegate mo695a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.f6695a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            ICameraUpdateFactoryDelegate a = zza.m9277a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IMapViewDelegate mo696a(zzd com_google_android_gms_dynamic_zzd, GoogleMapOptions googleMapOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            if (googleMapOptions != null) {
                obtain.writeInt(1);
                googleMapOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6695a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            IMapViewDelegate a = IMapViewDelegate.zza.m9444a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IStreetViewPanoramaViewDelegate mo697a(zzd com_google_android_gms_dynamic_zzd, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            if (streetViewPanoramaOptions != null) {
                obtain.writeInt(1);
                streetViewPanoramaOptions.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f6695a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            IStreetViewPanoramaViewDelegate a = IStreetViewPanoramaViewDelegate.zza.m9536a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo698a(zzd com_google_android_gms_dynamic_zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            this.f6695a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo699a(zzd com_google_android_gms_dynamic_zzd, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            obtain.writeInt(i);
            this.f6695a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6695a;
    }

    public final IMapFragmentDelegate mo700b(zzd com_google_android_gms_dynamic_zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            this.f6695a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            IMapFragmentDelegate a = IMapFragmentDelegate.zza.m9421a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final com.google.android.gms.maps.model.internal.zza mo701b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            this.f6695a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            com.google.android.gms.maps.model.internal.zza a = com.google.android.gms.maps.model.internal.zza.zza.m9715a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IStreetViewPanoramaFragmentDelegate mo702c(zzd com_google_android_gms_dynamic_zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
            obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
            this.f6695a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            IStreetViewPanoramaFragmentDelegate a = IStreetViewPanoramaFragmentDelegate.zza.m9517a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
