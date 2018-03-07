package com.facebook.location;

import android.location.Location;
import android.location.LocationManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.LocationManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerException.Type;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ￥ */
public class AndroidPlatformFbLocationManager extends BaseFbLocationManager {
    private final FbLocationStatusUtil f0a;
    private final ExecutorService f1b;
    public final LocationManager f2c;
    public FbLocationManagerParams f3d;
    public final AtomicBoolean f4e = new AtomicBoolean();
    public LocationManagerCallback f5f;

    public static AndroidPlatformFbLocationManager m1b(InjectorLike injectorLike) {
        return new AndroidPlatformFbLocationManager(FbLocationStatusUtil.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3863), LocationManagerMethodAutoProvider.b(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbLocationCache.b(injectorLike), AppStateManager.a(injectorLike));
    }

    @Inject
    public AndroidPlatformFbLocationManager(FbLocationStatusUtil fbLocationStatusUtil, Clock clock, ScheduledExecutorService scheduledExecutorService, Provider<ExecutorService> provider, LocationManager locationManager, PerformanceLogger performanceLogger, AnalyticsLogger analyticsLogger, FbLocationCache fbLocationCache, AppStateManager appStateManager) {
        super(fbLocationStatusUtil, clock, scheduledExecutorService, provider, performanceLogger, analyticsLogger, fbLocationCache, appStateManager);
        this.f0a = fbLocationStatusUtil;
        this.f1b = scheduledExecutorService;
        this.f2c = locationManager;
    }

    protected final FbLocationImplementation m3a() {
        return FbLocationImplementation.ANDROID_PLATFORM;
    }

    protected final synchronized void m4a(FbLocationManagerParams fbLocationManagerParams) {
        Object obj = null;
        synchronized (this) {
            Preconditions.checkState(!this.f4e.getAndSet(true), "operation already running");
            this.f3d = (FbLocationManagerParams) Preconditions.checkNotNull(fbLocationManagerParams);
            this.f5f = new LocationManagerCallback(this);
            try {
                ImmutableSet e = m2e();
                for (String lastKnownLocation : this.f2c.getProviders(true)) {
                    Object obj2;
                    ImmutableLocation a = m0a(this.f2c.getLastKnownLocation(lastKnownLocation));
                    if (a != null) {
                        a(a);
                        if (b(a) <= 900000) {
                            obj2 = 1;
                            obj = obj2;
                        }
                    }
                    obj2 = obj;
                    obj = obj2;
                }
                if (obj == null) {
                    d();
                }
                ExecutorDetour.a(this.f1b, new 1(this, e), 1374246986);
            } catch (FbLocationManagerException e2) {
                a(e2);
                this.f4e.set(false);
                this.f3d = null;
                this.f5f = null;
            }
        }
    }

    protected final synchronized void m5b() {
        if (this.f4e.getAndSet(false)) {
            this.f2c.removeUpdates(this.f5f);
            this.f5f = null;
            this.f3d = null;
        }
    }

    private ImmutableSet<String> m2e() {
        FbLocationStatus b = this.f0a.b(this.f3d.a);
        if (b.a != State.OKAY) {
            throw new FbLocationManagerException(Type.LOCATION_UNAVAILABLE);
        }
        try {
            if (this.f2c.getProvider("passive") == null) {
                return b.b;
            }
            return ImmutableSet.builder().b(b.b).c("passive").b();
        } catch (SecurityException e) {
            return b.b;
        }
    }

    @Nullable
    @VisibleForTesting
    static ImmutableLocation m0a(@Nullable Location location) {
        if (location == null) {
            return null;
        }
        if (!location.hasAccuracy()) {
            location.setAccuracy(3333.0f);
        }
        return ImmutableLocation.c(location);
    }
}
