package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;

public class zzlz implements ConnectionCallbacks, OnConnectionFailedListener {
    public final Api<?> f18774a;
    private final int f18775b;
    public zzmi f18776c;

    public zzlz(Api<?> api, int i) {
        this.f18774a = api;
        this.f18775b = i;
    }

    private void m26377a() {
        zzx.m105a(this.f18776c, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public final void mo38a(int i) {
        m26377a();
        this.f18776c.m26790a(i);
    }

    public final void mo39a(Bundle bundle) {
        m26377a();
        this.f18776c.m26791a(bundle);
    }

    public final void mo40a(ConnectionResult connectionResult) {
        m26377a();
        this.f18776c.m26793a(connectionResult, this.f18774a, this.f18775b);
    }
}
