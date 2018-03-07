package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;

public class zzf implements GeofencingApi {
    public final PendingResult<Status> mo2990a(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.mo3056b(new 1(this, googleApiClient, geofencingRequest, pendingIntent));
    }
}
