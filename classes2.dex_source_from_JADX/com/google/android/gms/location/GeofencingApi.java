package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface GeofencingApi {
    PendingResult<Status> mo2990a(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent);
}
