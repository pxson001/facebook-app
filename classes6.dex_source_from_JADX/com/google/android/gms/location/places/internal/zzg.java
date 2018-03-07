package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.IInterface;
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

public interface zzg extends IInterface {
    void mo500a(AddPlaceRequest addPlaceRequest, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo501a(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent);

    void mo502a(PlaceFilter placeFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo503a(PlaceReport placeReport, PlacesParams placesParams);

    void mo504a(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent);

    void mo505a(UserDataType userDataType, LatLngBounds latLngBounds, List<String> list, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo506a(PlacesParams placesParams, PendingIntent pendingIntent);

    void mo507a(PlaceAlias placeAlias, PlacesParams placesParams, zza com_google_android_gms_location_places_personalized_zza);

    void mo508a(PlaceAlias placeAlias, String str, String str2, PlacesParams placesParams, zza com_google_android_gms_location_places_personalized_zza);

    void mo509a(LatLng latLng, PlaceFilter placeFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo510a(LatLngBounds latLngBounds, int i, String str, PlaceFilter placeFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo511a(String str, int i, int i2, int i3, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh);

    void mo512a(String str, int i, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo513a(String str, PlacesParams placesParams, zzh com_google_android_gms_location_places_internal_zzh);

    void mo514a(String str, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo515a(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo516a(List<String> list, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo517b(PlacesParams placesParams, PendingIntent pendingIntent);

    void mo518b(String str, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo519b(List<String> list, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);
}
