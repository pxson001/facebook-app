package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.location.places.personalized.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public class zzg$zza$zza implements zzg {
    private IBinder f6570a;

    public zzg$zza$zza(IBinder iBinder) {
        this.f6570a = iBinder;
    }

    public final void mo500a(AddPlaceRequest addPlaceRequest, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (addPlaceRequest != null) {
                obtain.writeInt(1);
                addPlaceRequest.writeToParcel(obtain, 0);
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
            this.f6570a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo501a(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
            this.f6570a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo502a(PlaceFilter placeFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
            this.f6570a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo503a(PlaceReport placeReport, PlacesParams placesParams) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
            this.f6570a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo504a(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
            this.f6570a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo505a(UserDataType userDataType, LatLngBounds latLngBounds, List<String> list, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (userDataType != null) {
                obtain.writeInt(1);
                userDataType.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (latLngBounds != null) {
                obtain.writeInt(1);
                latLngBounds.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStringList(list);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6570a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo506a(PlacesParams placesParams, PendingIntent pendingIntent) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
            this.f6570a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo507a(PlaceAlias placeAlias, PlacesParams placesParams, zza com_google_android_gms_location_places_personalized_zza) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placeAlias != null) {
                obtain.writeInt(1);
                placeAlias.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_personalized_zza != null ? com_google_android_gms_location_places_personalized_zza.asBinder() : null);
            this.f6570a.transact(21, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo508a(PlaceAlias placeAlias, String str, String str2, PlacesParams placesParams, zza com_google_android_gms_location_places_personalized_zza) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placeAlias != null) {
                obtain.writeInt(1);
                placeAlias.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeString(str2);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_personalized_zza != null ? com_google_android_gms_location_places_personalized_zza.asBinder() : null);
            this.f6570a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo509a(LatLng latLng, PlaceFilter placeFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (latLng != null) {
                obtain.writeInt(1);
                latLng.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
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
            this.f6570a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo510a(LatLngBounds latLngBounds, int i, String str, PlaceFilter placeFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (latLngBounds != null) {
                obtain.writeInt(1);
                latLngBounds.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeString(str);
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
            this.f6570a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo511a(String str, int i, int i2, int i3, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeInt(i3);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzh != null ? com_google_android_gms_location_places_internal_zzh.asBinder() : null);
            this.f6570a.transact(20, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo512a(String str, int i, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obtain.writeString(str);
            obtain.writeInt(i);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6570a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo513a(String str, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obtain.writeString(str);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzh != null ? com_google_android_gms_location_places_internal_zzh.asBinder() : null);
            this.f6570a.transact(19, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo514a(String str, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obtain.writeString(str);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6570a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo515a(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obtain.writeString(str);
            if (latLngBounds != null) {
                obtain.writeInt(1);
                latLngBounds.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (autocompleteFilter != null) {
                obtain.writeInt(1);
                autocompleteFilter.writeToParcel(obtain, 0);
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
            this.f6570a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo516a(List<String> list, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obtain.writeStringList(list);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6570a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f6570a;
    }

    public final void mo517b(PlacesParams placesParams, PendingIntent pendingIntent) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
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
            this.f6570a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo518b(String str, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obtain.writeString(str);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6570a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void mo519b(List<String> list, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            obtain.writeStringList(list);
            if (placesParams != null) {
                obtain.writeInt(1);
                placesParams.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(com_google_android_gms_location_places_internal_zzi != null ? com_google_android_gms_location_places_internal_zzi.asBinder() : null);
            this.f6570a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
