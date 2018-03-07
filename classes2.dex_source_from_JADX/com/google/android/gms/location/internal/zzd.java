package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzd implements FusedLocationProviderApi {
    public final Location mo2986a(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.m25073a(googleApiClient).mo3023r();
        } catch (Exception e) {
            return null;
        }
    }

    public final PendingResult<Status> mo2987a(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.mo3056b(new 10(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> mo2988a(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.mo3056b(new 8(this, googleApiClient, locationRequest, pendingIntent));
    }

    public final PendingResult<Status> mo2989a(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        return googleApiClient.mo3056b(new 1(this, googleApiClient, locationRequest, locationListener));
    }
}
