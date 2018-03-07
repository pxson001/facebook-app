package com.facebook.location;

import android.app.PendingIntent;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.location.FbLocationContinuousListenerException.Type;
import com.facebook.location.FbLocationContinuousListenerParams.Priority;
import com.facebook.location.FbLocationStatus.State;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ৳ */
public class GooglePlayFbLocationContinuousListener implements FbLocationContinuousListener {
    private final FbLocationStatusUtil f34a;
    private final GooglePlayGoogleApiClientFactory f35b;
    private final AbstractFbErrorReporter f36c;

    /* compiled from: ৳ */
    public abstract class ClientCallbacks implements ConnectionCallbacks, OnConnectionFailedListener {
        public GoogleApiClient f26a;
    }

    /* compiled from: ৳ */
    /* synthetic */ class C00043 {
        static final /* synthetic */ int[] f32a = new int[State.values().length];
        static final /* synthetic */ int[] f33b = new int[Priority.values().length];

        static {
            try {
                f33b[Priority.NO_POWER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f33b[Priority.LOW_POWER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f33b[Priority.BALANCED_POWER_AND_ACCURACY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f33b[Priority.HIGH_ACCURACY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f32a[State.OKAY.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f32a[State.LOCATION_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f32a[State.LOCATION_UNSUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f32a[State.PERMISSION_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    @Inject
    public GooglePlayFbLocationContinuousListener(FbLocationStatusUtil fbLocationStatusUtil, GooglePlayGoogleApiClientFactory googlePlayGoogleApiClientFactory, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f34a = fbLocationStatusUtil;
        this.f35b = googlePlayGoogleApiClientFactory;
        this.f36c = abstractFbErrorReporter;
    }

    public final void m29a(final PendingIntent pendingIntent, final FbLocationContinuousListenerParams fbLocationContinuousListenerParams) {
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(fbLocationContinuousListenerParams);
        State a = this.f34a.a();
        switch (C00043.f32a[a.ordinal()]) {
            case 1:
            case 2:
                ClientCallbacks c00021 = new ClientCallbacks(this) {
                    final /* synthetic */ GooglePlayFbLocationContinuousListener f29c;

                    public final void m13a(Bundle bundle) {
                        GooglePlayFbLocationContinuousListener.m24a(this.f29c, this.f26a, GooglePlayFbLocationContinuousListener.m19a(fbLocationContinuousListenerParams), pendingIntent, this);
                        this.f29c.m25a(this.f26a);
                    }

                    public final void m12a(int i) {
                        GooglePlayFbLocationContinuousListener.m20a(this.f29c);
                    }

                    public final void m14a(ConnectionResult connectionResult) {
                        GooglePlayFbLocationContinuousListener.m21a(this.f29c, connectionResult);
                    }
                };
                GoogleApiClient a2 = this.f35b.a(c00021, c00021, LocationServices.a);
                c00021.f26a = a2;
                m26a(a2, c00021);
                return;
            case 3:
                throw new FbLocationContinuousListenerException(Type.LOCATION_UNSUPPORTED);
            case 4:
                throw new FbLocationContinuousListenerException(Type.PERMISSION_DENIED);
            default:
                throw new IllegalArgumentException("unknown location state: " + a);
        }
    }

    public final void m28a(final PendingIntent pendingIntent) {
        ClientCallbacks c00032 = new ClientCallbacks(this) {
            final /* synthetic */ GooglePlayFbLocationContinuousListener f31b;

            public final void m16a(Bundle bundle) {
                GooglePlayFbLocationContinuousListener.m22a(this.f31b, this.f26a, pendingIntent, this);
                this.f31b.m25a(this.f26a);
            }

            public final void m15a(int i) {
                GooglePlayFbLocationContinuousListener.m20a(this.f31b);
            }

            public final void m17a(ConnectionResult connectionResult) {
                GooglePlayFbLocationContinuousListener.m21a(this.f31b, connectionResult);
            }
        };
        GoogleApiClient a = this.f35b.a(c00032, c00032, LocationServices.a);
        c00032.f26a = a;
        m26a(a, c00032);
    }

    @Nullable
    public final ImmutableLocation m27a(Intent intent) {
        FusedLocationProviderApi fusedLocationProviderApi = LocationServices.b;
        return ImmutableLocation.c((Location) intent.getParcelableExtra("com.google.android.location.LOCATION"));
    }

    public static void m20a(GooglePlayFbLocationContinuousListener googlePlayFbLocationContinuousListener) {
        googlePlayFbLocationContinuousListener.f36c.a("fb_location_continuous_listener_google_play", "Client disconnected unexpectedly");
    }

    public static void m21a(@Nullable GooglePlayFbLocationContinuousListener googlePlayFbLocationContinuousListener, ConnectionResult connectionResult) {
        googlePlayFbLocationContinuousListener.f36c.a("fb_location_continuous_listener_google_play", "Client connection failed: " + connectionResult);
    }

    @VisibleForTesting
    static LocationRequest m19a(FbLocationContinuousListenerParams fbLocationContinuousListenerParams) {
        LocationRequest a = LocationRequest.m8848a().m8852a(m18a(fbLocationContinuousListenerParams.a)).m8853a(fbLocationContinuousListenerParams.b);
        long j = fbLocationContinuousListenerParams.c;
        LocationRequest.m8851c(j);
        a.f6327d = true;
        a.f6326c = j;
        a = a;
        float f = fbLocationContinuousListenerParams.d;
        LocationRequest.m8849b(f);
        a.f6330g = f;
        return a;
    }

    private static int m18a(Priority priority) {
        switch (C00043.f33b[priority.ordinal()]) {
            case 1:
                return 105;
            case 2:
                return 104;
            case 3:
                return 102;
            case 4:
                return 100;
            default:
                throw new IllegalArgumentException("Unknown priority: " + priority);
        }
    }

    private void m26a(GoogleApiClient googleApiClient, ClientCallbacks clientCallbacks) {
        Preconditions.checkNotNull(googleApiClient);
        try {
            googleApiClient.c();
        } catch (Throwable e) {
            GooglePlayServicesExceptionUtil.m33a(e);
            this.f36c.a("fb_location_continuous_listener_google_play", "Google exception on connect", e);
            clientCallbacks.a(null);
        }
    }

    private void m25a(GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(googleApiClient);
        try {
            googleApiClient.e();
        } catch (Throwable e) {
            GooglePlayServicesExceptionUtil.m33a(e);
            this.f36c.a("fb_location_continuous_listener_google_play", "Google exception on disconnect", e);
        }
    }

    public static void m24a(GooglePlayFbLocationContinuousListener googlePlayFbLocationContinuousListener, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent, ClientCallbacks clientCallbacks) {
        Preconditions.checkNotNull(googleApiClient);
        try {
            LocationServices.b.a(googleApiClient, locationRequest, pendingIntent);
        } catch (Throwable e) {
            GooglePlayServicesExceptionUtil.m33a(e);
            googlePlayFbLocationContinuousListener.f36c.a("fb_location_continuous_listener_google_play", "Google exception on request", e);
            clientCallbacks.a(1);
        }
    }

    public static void m22a(GooglePlayFbLocationContinuousListener googlePlayFbLocationContinuousListener, GoogleApiClient googleApiClient, PendingIntent pendingIntent, ClientCallbacks clientCallbacks) {
        Preconditions.checkNotNull(googleApiClient);
        try {
            LocationServices.b.a(googleApiClient, pendingIntent);
        } catch (Throwable e) {
            GooglePlayServicesExceptionUtil.m33a(e);
            googlePlayFbLocationContinuousListener.f36c.a("fb_location_continuous_listener_google_play", "Google exception on remove", e);
            clientCallbacks.a(1);
        }
    }
}
