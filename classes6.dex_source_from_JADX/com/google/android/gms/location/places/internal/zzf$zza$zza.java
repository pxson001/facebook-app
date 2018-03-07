package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;

public class zzf$zza$zza implements zzf {
    private IBinder f6569a;

    public zzf$zza$zza(IBinder iBinder) {
        this.f6569a = iBinder;
    }

    public final void mo494a(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (nearbyAlertRequest != null) {
                obtain.writeInt(1);
                nearbyAlertRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (pendingIntent != null) {
                obtain.writeInt(1);
                pendingIntent.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6569a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo495a(PlaceFilter placeFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (placeFilter != null) {
                obtain.writeInt(1);
                placeFilter.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6569a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo496a(PlaceReport placeReport, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (placeReport != null) {
                obtain.writeInt(1);
                placeReport.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6569a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo497a(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (placeRequest != null) {
                obtain.writeInt(1);
                placeRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (pendingIntent != null) {
                obtain.writeInt(1);
                pendingIntent.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6569a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo498a(PlacesParams placesParams, PendingIntent pendingIntent, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (pendingIntent != null) {
                obtain.writeInt(1);
                pendingIntent.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6569a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6569a;
    }

    public final void mo499b(PlacesParams placesParams, PendingIntent pendingIntent, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (pendingIntent != null) {
                obtain.writeInt(1);
                pendingIntent.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6569a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
