package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.maps.model.LatLngBounds;

public interface GeoDataApi {
    PendingResult<AutocompletePredictionBuffer> mo492a(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter);

    PendingResult<PlaceBuffer> mo493a(GoogleApiClient googleApiClient, String... strArr);
}
