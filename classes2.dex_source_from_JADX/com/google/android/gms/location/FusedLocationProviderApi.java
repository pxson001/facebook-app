package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface FusedLocationProviderApi {
    Location mo2986a(GoogleApiClient googleApiClient);

    PendingResult<Status> mo2987a(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> mo2988a(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent);

    PendingResult<Status> mo2989a(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener);
}
