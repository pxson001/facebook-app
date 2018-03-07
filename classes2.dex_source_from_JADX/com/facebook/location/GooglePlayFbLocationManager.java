package com.facebook.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0115xfdf5bd2;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerException.Type;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: last_video_asset_count_log_time */
public class GooglePlayFbLocationManager extends BaseFbLocationManager {
    private static final Class<?> f17788a = GooglePlayFbLocationManager.class;
    private final GooglePlayGoogleApiClientFactory f17789b;
    private final ExecutorService f17790c;
    public final PerformanceLogger f17791d;
    private final AbstractFbErrorReporter f17792e;
    private final Handler f17793f;
    public FbLocationManagerParams f17794g;
    public GoogleApiClient f17795h;
    public final ClientCallback f17796i = new ClientCallback(this);
    public boolean f17797j;

    /* compiled from: last_video_asset_count_log_time */
    class ClientCallback implements ConnectionCallbacks, OnConnectionFailedListener, LocationListener {
        final /* synthetic */ GooglePlayFbLocationManager f17816a;

        public ClientCallback(GooglePlayFbLocationManager googlePlayFbLocationManager) {
            this.f17816a = googlePlayFbLocationManager;
        }

        public final void mo39a(@Nullable Bundle bundle) {
            this.f17816a.m25016e();
        }

        public final void mo38a(int i) {
            this.f17816a.m25018f();
        }

        public final void mo40a(ConnectionResult connectionResult) {
            GooglePlayFbLocationManager.m25011a(this.f17816a, connectionResult);
        }

        public final void mo2974a(Location location) {
            ImmutableLocation c = ImmutableLocation.m11982c(location);
            if (c != null) {
                this.f17816a.m25048a(c);
            }
        }
    }

    /* compiled from: last_video_asset_count_log_time */
    class C07581 implements Runnable {
        final /* synthetic */ GooglePlayFbLocationManager f19063a;

        C07581(GooglePlayFbLocationManager googlePlayFbLocationManager) {
            this.f19063a = googlePlayFbLocationManager;
        }

        public void run() {
            synchronized (this.f19063a) {
                if (this.f19063a.f17797j) {
                    GooglePlayFbLocationManager.m25010a(this.f19063a, PerfEvent.CLIENT_CONNECT);
                    this.f19063a.f17795h.mo3058c();
                    return;
                }
            }
        }
    }

    /* compiled from: last_video_asset_count_log_time */
    public enum PerfEvent {
        CLIENT_CONNECT(3342341);
        
        public final String perfLoggerName;
        public final int perfMarkerId;

        private PerfEvent(int i) {
            this.perfLoggerName = "GooglePlayFbLocationManager." + toString();
            this.perfMarkerId = i;
        }
    }

    public static GooglePlayFbLocationManager m25012b(InjectorLike injectorLike) {
        return new GooglePlayFbLocationManager(FbLocationStatusUtil.m8253a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), C0115xfdf5bd2.m3569a(injectorLike), GooglePlayGoogleApiClientFactory.m25054b(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3863), Handler_ForNonUiThreadMethodAutoProvider.m5523b(injectorLike), DelegatingPerformanceLogger.m2803a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FbLocationCache.m8244b(injectorLike), AppStateManager.m2245a(injectorLike));
    }

    @Inject
    public GooglePlayFbLocationManager(FbLocationStatusUtil fbLocationStatusUtil, Clock clock, ScheduledExecutorService scheduledExecutorService, GooglePlayGoogleApiClientFactory googlePlayGoogleApiClientFactory, Provider<ExecutorService> provider, Handler handler, PerformanceLogger performanceLogger, AnalyticsLogger analyticsLogger, FbErrorReporter fbErrorReporter, FbLocationCache fbLocationCache, AppStateManager appStateManager) {
        super(fbLocationStatusUtil, clock, scheduledExecutorService, provider, performanceLogger, analyticsLogger, fbLocationCache, appStateManager);
        this.f17793f = handler;
        this.f17789b = googlePlayGoogleApiClientFactory;
        this.f17790c = scheduledExecutorService;
        this.f17791d = performanceLogger;
        this.f17792e = fbErrorReporter;
    }

    protected final FbLocationImplementation mo2971a() {
        return FbLocationImplementation.GOOGLE_PLAY;
    }

    protected final synchronized void mo2972a(FbLocationManagerParams fbLocationManagerParams) {
        boolean z = true;
        synchronized (this) {
            if (this.f17797j) {
                z = false;
            }
            Preconditions.checkState(z);
            this.f17797j = true;
            this.f17794g = (FbLocationManagerParams) Preconditions.checkNotNull(fbLocationManagerParams);
            this.f17795h = this.f17789b.m25056a(this.f17796i, this.f17796i, LocationServices.f17838a, this.f17793f);
            ExecutorDetour.a(this.f17790c, new C07581(this), 1880515442);
        }
    }

    protected final synchronized void mo2973b() {
        if (this.f17797j) {
            m25020g();
        }
    }

    private synchronized void m25016e() {
        if (this.f17797j) {
            m25013b(PerfEvent.CLIENT_CONNECT);
            ImmutableLocation c = ImmutableLocation.m11982c(LocationServices.f17839b.mo2986a(this.f17795h));
            Object obj = null;
            if (c != null) {
                m25048a(c);
                if (m25050b(c) <= 900000) {
                    obj = 1;
                }
            }
            if (obj == null) {
                m25053d();
            }
            ExecutorDetour.a(this.f17790c, new 2(this), -1897834561);
        } else {
            m25020g();
        }
    }

    public static synchronized void m25011a(GooglePlayFbLocationManager googlePlayFbLocationManager, ConnectionResult connectionResult) {
        synchronized (googlePlayFbLocationManager) {
            if (googlePlayFbLocationManager.f17797j) {
                googlePlayFbLocationManager.m25015c(PerfEvent.CLIENT_CONNECT);
                googlePlayFbLocationManager.f17795h.mo3051a(googlePlayFbLocationManager.f17796i);
                googlePlayFbLocationManager.f17795h = null;
                googlePlayFbLocationManager.m25020g();
                BLog.a(f17788a, "Client connection failed: %s", new Object[]{connectionResult});
                if (!m25014b(connectionResult)) {
                    googlePlayFbLocationManager.f17792e.m2340a("location_manager_google_play", "Client connection failed from resolvable error: " + connectionResult);
                }
                googlePlayFbLocationManager.m25045a(new FbLocationManagerException(Type.UNKNOWN_ERROR));
            }
        }
    }

    private synchronized void m25018f() {
        if (this.f17797j) {
            this.f17795h.mo3051a(this.f17796i);
            this.f17795h = null;
            m25020g();
            BLog.a(f17788a, "Client disconnected unexpectedly");
            m25045a(new FbLocationManagerException(Type.UNKNOWN_ERROR));
        }
    }

    private void m25020g() {
        this.f17797j = false;
        this.f17794g = null;
        if (this.f17795h != null) {
            PerfEvent perfEvent = PerfEvent.CLIENT_CONNECT;
            this.f17791d.mo385b(perfEvent.perfMarkerId, perfEvent.perfLoggerName);
            this.f17795h.mo3051a(this.f17796i);
            this.f17795h.mo3061e();
            this.f17795h = null;
        }
    }

    static /* synthetic */ LocationRequest m25009a(GooglePlayFbLocationManager googlePlayFbLocationManager, FbLocationManagerParams fbLocationManagerParams) {
        LocationRequest a = LocationRequest.a();
        a.a(GooglePlayServicesParamUtil.a(fbLocationManagerParams.f17827a));
        a.a(fbLocationManagerParams.f17831e);
        return a;
    }

    private static boolean m25014b(ConnectionResult connectionResult) {
        return connectionResult.f23273c == 8 || connectionResult.f23273c == 7;
    }

    public static void m25010a(GooglePlayFbLocationManager googlePlayFbLocationManager, PerfEvent perfEvent) {
        googlePlayFbLocationManager.f17791d.mo392d(perfEvent.perfMarkerId, perfEvent.perfLoggerName);
    }

    private void m25013b(PerfEvent perfEvent) {
        this.f17791d.mo389c(perfEvent.perfMarkerId, perfEvent.perfLoggerName);
    }

    private void m25015c(PerfEvent perfEvent) {
        this.f17791d.mo397f(perfEvent.perfMarkerId, perfEvent.perfLoggerName);
    }
}
