package com.facebook.location;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.facebook.inject.InjectorLike;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: last_upload_attempt */
public class GooglePlayGoogleApiClientFactory {
    private final Context f17815a;

    public static GooglePlayGoogleApiClientFactory m25054b(InjectorLike injectorLike) {
        return new GooglePlayGoogleApiClientFactory((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public GooglePlayGoogleApiClientFactory(Context context) {
        this.f17815a = context;
    }

    public final GoogleApiClient m25055a(ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, Api api) {
        return m25056a(connectionCallbacks, onConnectionFailedListener, api, null);
    }

    public final GoogleApiClient m25056a(ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, Api api, @Nullable Handler handler) {
        Preconditions.checkNotNull(connectionCallbacks);
        Preconditions.checkNotNull(onConnectionFailedListener);
        Builder a = new Builder(this.f17815a).m25138a(connectionCallbacks).m25139a(onConnectionFailedListener).m25137a(api);
        if (handler != null) {
            zzx.m105a((Object) handler, (Object) "Handler must not be null");
            a.f17901n = handler.getLooper();
        }
        return a.m25141b();
    }

    public final ListenableFuture<GoogleApiClient> m25057a(Api api) {
        Callbacks callbacks = new Callbacks();
        GoogleApiClient a = m25055a(callbacks, callbacks, api);
        callbacks.b = a;
        a.mo3058c();
        return callbacks.a;
    }
}
