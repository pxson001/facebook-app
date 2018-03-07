package com.facebook.location;

import android.app.PendingIntent;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.debug.log.BLog;
import com.facebook.location.FbLocationContinuousListenerException.Type;
import com.facebook.location.FbLocationContinuousListenerParams.Priority;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TECHNICAL_INSTITUTE */
public class AndroidPlatformFbLocationContinuousListener implements FbLocationContinuousListener {
    private static final Class<?> f14221a = AndroidPlatformFbLocationContinuousListener.class;
    private final FbLocationStatusUtil f14222b;
    private final LocationManager f14223c;
    private final FbZeroFeatureVisibilityHelper f14224d;

    /* compiled from: TECHNICAL_INSTITUTE */
    /* synthetic */ class C13711 {
        static final /* synthetic */ int[] f14220a = new int[Priority.values().length];

        static {
            try {
                f14220a[Priority.LOW_POWER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14220a[Priority.BALANCED_POWER_AND_ACCURACY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14220a[Priority.HIGH_ACCURACY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public AndroidPlatformFbLocationContinuousListener(FbLocationStatusUtil fbLocationStatusUtil, LocationManager locationManager, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper) {
        this.f14222b = fbLocationStatusUtil;
        this.f14223c = locationManager;
        this.f14224d = fbZeroFeatureVisibilityHelper;
    }

    public final void m23574a(PendingIntent pendingIntent, FbLocationContinuousListenerParams fbLocationContinuousListenerParams) {
        FbLocationContinuousListenerException fbLocationContinuousListenerException;
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(fbLocationContinuousListenerParams);
        if (this.f14222b.b().a != State.OKAY) {
            throw new FbLocationContinuousListenerException(Type.LOCATION_UNAVAILABLE);
        } else if (fbLocationContinuousListenerParams.a == Priority.NO_POWER) {
            try {
                this.f14223c.requestLocationUpdates("passive", fbLocationContinuousListenerParams.c, fbLocationContinuousListenerParams.d, pendingIntent);
            } catch (Throwable th) {
                BLog.a(f14221a, "Could not start passive listening", th);
                fbLocationContinuousListenerException = new FbLocationContinuousListenerException(Type.TEMPORARY_ERROR, th);
            }
        } else {
            try {
                this.f14223c.requestLocationUpdates(fbLocationContinuousListenerParams.b, fbLocationContinuousListenerParams.d, m23570a(fbLocationContinuousListenerParams), pendingIntent);
            } catch (Throwable th2) {
                BLog.a(f14221a, "Could not start continuous listening", th2);
                fbLocationContinuousListenerException = new FbLocationContinuousListenerException(Type.TEMPORARY_ERROR, th2);
            }
        }
    }

    public final void m23573a(PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        try {
            this.f14223c.removeUpdates(pendingIntent);
        } catch (Throwable th) {
        }
    }

    @Nullable
    public final ImmutableLocation m23572a(Intent intent) {
        return ImmutableLocation.c((Location) intent.getParcelableExtra("location"));
    }

    private Criteria m23570a(FbLocationContinuousListenerParams fbLocationContinuousListenerParams) {
        Criteria criteria = new Criteria();
        criteria.setCostAllowed(!this.f14224d.a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL));
        criteria.setPowerRequirement(m23569a(fbLocationContinuousListenerParams.a));
        criteria.setAccuracy(m23571b(fbLocationContinuousListenerParams.a));
        return criteria;
    }

    private static int m23569a(Priority priority) {
        switch (C13711.f14220a[priority.ordinal()]) {
            case 1:
                return 1;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return 2;
            case 3:
                return 3;
            default:
                throw new IllegalArgumentException("NO_POWER handled by passive location directly");
        }
    }

    private static int m23571b(Priority priority) {
        switch (C13711.f14220a[priority.ordinal()]) {
            case 1:
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return 2;
            case 3:
                return 1;
            default:
                throw new IllegalArgumentException("NO_POWER handled by passive location directly");
        }
    }
}
