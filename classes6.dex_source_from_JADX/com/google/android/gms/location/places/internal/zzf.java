package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.IInterface;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;

public interface zzf extends IInterface {
    void mo494a(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent, zzi com_google_android_gms_location_places_internal_zzi);

    void mo495a(PlaceFilter placeFilter, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo496a(PlaceReport placeReport, PlacesParams placesParams, zzi com_google_android_gms_location_places_internal_zzi);

    void mo497a(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent, zzi com_google_android_gms_location_places_internal_zzi);

    void mo498a(PlacesParams placesParams, PendingIntent pendingIntent, zzi com_google_android_gms_location_places_internal_zzi);

    void mo499b(PlacesParams placesParams, PendingIntent pendingIntent, zzi com_google_android_gms_location_places_internal_zzi);
}
