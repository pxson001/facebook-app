package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices$zza;

abstract class zzf$zza extends LocationServices$zza<Status> {
    public zzf$zza(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final Result m8872c(Status status) {
        return status;
    }
}
