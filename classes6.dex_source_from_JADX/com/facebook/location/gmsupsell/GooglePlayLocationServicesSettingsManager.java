package com.facebook.location.gmsupsell;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.GooglePlayGoogleApiClientFactory;
import com.facebook.location.GooglePlayServicesParamUtil;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {result= */
public class GooglePlayLocationServicesSettingsManager {
    public static final Class<?> f85a = GooglePlayLocationServicesSettingsManager.class;
    private final GooglePlayGoogleApiClientFactory f86b;
    private final Provider<Boolean> f87c;
    public final Context f88d;

    /* compiled from: {result= */
    public class LocationSettingsRequestParams {
        public Priority f80a = Priority.HIGH_ACCURACY;
        public boolean f81b = true;
        public boolean f82c = false;
    }

    /* compiled from: {result= */
    public class LocationStatusResult {
        private final LocationSettingsResult f83a;
        public StatusCode f84b;

        public LocationStatusResult(StatusCode statusCode, LocationSettingsResult locationSettingsResult) {
            this.f84b = statusCode;
            this.f83a = locationSettingsResult;
        }

        public final boolean m56a(Activity activity, int i) {
            if (this.f84b != StatusCode.EASY_RESOLUTION_POSSIBLE) {
                return false;
            }
            this.f84b = StatusCode.EASY_RESOLUTION_ATTEMPTED;
            try {
                this.f83a.cp_().a(activity, i);
                return true;
            } catch (Throwable e) {
                BLog.b(GooglePlayLocationServicesSettingsManager.f85a, e, "Error starting google play services location dialog", new Object[0]);
                return false;
            }
        }
    }

    /* compiled from: {result= */
    public enum StatusCode {
        LOCATION_SETTINGS_OK,
        EASY_RESOLUTION_UNAVAILABLE,
        EASY_RESOLUTION_POSSIBLE,
        EASY_RESOLUTION_ATTEMPTED,
        UNKNOWN;

        public static StatusCode fromLocationSettingsResultStatus(int i) {
            switch (i) {
                case 0:
                    return LOCATION_SETTINGS_OK;
                case 6:
                    return EASY_RESOLUTION_POSSIBLE;
                case 8502:
                    return EASY_RESOLUTION_UNAVAILABLE;
                default:
                    return UNKNOWN;
            }
        }
    }

    public static GooglePlayLocationServicesSettingsManager m59b(InjectorLike injectorLike) {
        return new GooglePlayLocationServicesSettingsManager(GooglePlayGoogleApiClientFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 4040), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public GooglePlayLocationServicesSettingsManager(GooglePlayGoogleApiClientFactory googlePlayGoogleApiClientFactory, Provider<Boolean> provider, Context context) {
        this.f86b = googlePlayGoogleApiClientFactory;
        this.f87c = provider;
        this.f88d = context;
    }

    public final ListenableFuture<LocationStatusResult> m60a(final LocationSettingsRequestParams locationSettingsRequestParams) {
        Preconditions.checkNotNull(locationSettingsRequestParams);
        if (((Boolean) this.f87c.get()).booleanValue()) {
            return Futures.b(this.f86b.a(LocationServices.a), new AsyncFunction<GoogleApiClient, LocationStatusResult>(this) {
                final /* synthetic */ GooglePlayLocationServicesSettingsManager f76b;

                public final ListenableFuture m54a(Object obj) {
                    GoogleApiClient googleApiClient = (GoogleApiClient) obj;
                    Preconditions.checkNotNull(googleApiClient);
                    return GooglePlayLocationServicesSettingsManager.m57a(this.f76b, googleApiClient, locationSettingsRequestParams);
                }
            }, MoreExecutors.a());
        }
        return Futures.a(new IllegalStateException("GK check failed"));
    }

    public static ListenableFuture m57a(GooglePlayLocationServicesSettingsManager googlePlayLocationServicesSettingsManager, final GoogleApiClient googleApiClient, LocationSettingsRequestParams locationSettingsRequestParams) {
        if (googleApiClient.f()) {
            boolean z;
            PendingResult a;
            final SettableFuture f;
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.m8852a(GooglePlayServicesParamUtil.m34a(locationSettingsRequestParams.f80a));
            Builder builder = new Builder();
            builder.f6336a.add(locationRequest);
            Builder builder2 = builder;
            builder2.f6337b = locationSettingsRequestParams.f81b;
            builder = builder2;
            if (locationSettingsRequestParams.f82c) {
                Object obj;
                PackageManager packageManager = googlePlayLocationServicesSettingsManager.f88d.getPackageManager();
                boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.bluetooth");
                boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.bluetooth_le");
                int checkPermission = packageManager.checkPermission("android.permission.BLUETOOTH", googlePlayLocationServicesSettingsManager.f88d.getPackageName());
                int checkPermission2 = packageManager.checkPermission("android.permission.BLUETOOTH_ADMIN", googlePlayLocationServicesSettingsManager.f88d.getPackageName());
                if (hasSystemFeature && hasSystemFeature2 && checkPermission == 0 && checkPermission2 == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    z = true;
                    builder.f6338c = z;
                    a = LocationServices.d.a(googleApiClient, builder.m8855a());
                    f = SettableFuture.f();
                    a.a(new ResultCallback<LocationSettingsResult>(googlePlayLocationServicesSettingsManager) {
                        final /* synthetic */ GooglePlayLocationServicesSettingsManager f79c;

                        public final void m55a(Result result) {
                            LocationSettingsResult locationSettingsResult = (LocationSettingsResult) result;
                            try {
                                googleApiClient.e();
                                FutureDetour.a(f, GooglePlayLocationServicesSettingsManager.m58b(locationSettingsResult), 1608342050);
                            } catch (Throwable e) {
                                f.a(e);
                            }
                        }
                    });
                    return f;
                }
            }
            z = false;
            builder.f6338c = z;
            a = LocationServices.d.a(googleApiClient, builder.m8855a());
            f = SettableFuture.f();
            a.a(/* anonymous class already generated */);
            return f;
        }
        throw new IllegalStateException("Google Api Client unexpectedly disconnected");
    }

    public static LocationStatusResult m58b(LocationSettingsResult locationSettingsResult) {
        Preconditions.checkNotNull(locationSettingsResult);
        return new LocationStatusResult(StatusCode.fromLocationSettingsResultStatus(locationSettingsResult.cp_().g), locationSettingsResult);
    }
}
