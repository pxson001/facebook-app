package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public class zzq implements SettingsApi {
    public final PendingResult<LocationSettingsResult> mo2991a(GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest) {
        return googleApiClient.mo3047a(new 1(this, googleApiClient, locationSettingsRequest, null));
    }
}
