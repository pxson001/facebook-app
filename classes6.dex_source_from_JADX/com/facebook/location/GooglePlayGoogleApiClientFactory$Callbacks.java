package com.facebook.location;

import android.os.Bundle;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: د.ب. */
public final class GooglePlayGoogleApiClientFactory$Callbacks implements ConnectionCallbacks, OnConnectionFailedListener {
    public final SettableFuture<GoogleApiClient> f42a = SettableFuture.f();
    public GoogleApiClient f43b;

    public final void m31a(Bundle bundle) {
        if (!(this.f42a.isDone() || this.f43b == null)) {
            FutureDetour.a(this.f42a, this.f43b, 1986339832);
        }
        this.f43b = null;
    }

    public final void m30a(int i) {
        this.f43b = null;
        if (!this.f42a.isDone()) {
            this.f42a.a(new RuntimeException("onConnectionSuspended: " + i));
        }
    }

    public final void m32a(ConnectionResult connectionResult) {
        this.f43b = null;
        if (!this.f42a.isDone()) {
            this.f42a.a(new RuntimeException("onConnectionFailed: " + connectionResult.toString()));
        }
    }
}
