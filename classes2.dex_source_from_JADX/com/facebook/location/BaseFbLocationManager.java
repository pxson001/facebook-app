package com.facebook.location;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.location.FbLocationManagerException.Type;
import com.facebook.location.FbLocationOperation.LocationCallback;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: last_username */
public abstract class BaseFbLocationManager {
    private final FbLocationStatusUtil f17798a;
    private final Clock f17799b;
    private final ScheduledExecutorService f17800c;
    private final Provider<ExecutorService> f17801d;
    private final PerformanceLogger f17802e;
    private final AnalyticsLogger f17803f;
    private final FbLocationCache f17804g;
    public final AppStateManager f17805h;
    public FbLocationManagerParams f17806i;
    public LocationCallback f17807j;
    private CallerContext f17808k;
    public ExecutorService f17809l;
    public final AtomicBoolean f17810m = new AtomicBoolean();
    private ScheduledFuture f17811n;
    private ImmutableLocation f17812o;
    private long f17813p;
    public int f17814q;

    /* compiled from: last_username */
    class C07171 implements Runnable {
        final /* synthetic */ BaseFbLocationManager f17835a;

        C07171(BaseFbLocationManager baseFbLocationManager) {
            this.f17835a = baseFbLocationManager;
        }

        public void run() {
            this.f17835a.m25034e();
        }
    }

    /* compiled from: last_username */
    enum PerfEvent {
        ANY_LOCATION(3342337),
        CITY_GRANULARITY(3342338),
        BLOCK_GRANULARITY(3342339),
        EXACT_GRANULARITY(3342340);
        
        final String perfLoggerName;
        final int perfMarkerId;

        private PerfEvent(int i) {
            this.perfLoggerName = "FbLocationManager." + toString();
            this.perfMarkerId = i;
        }
    }

    protected abstract FbLocationImplementation mo2971a();

    protected abstract void mo2972a(FbLocationManagerParams fbLocationManagerParams);

    protected abstract void mo2973b();

    BaseFbLocationManager(FbLocationStatusUtil fbLocationStatusUtil, Clock clock, ScheduledExecutorService scheduledExecutorService, Provider<ExecutorService> provider, PerformanceLogger performanceLogger, AnalyticsLogger analyticsLogger, FbLocationCache fbLocationCache, AppStateManager appStateManager) {
        this.f17798a = fbLocationStatusUtil;
        this.f17799b = clock;
        this.f17800c = scheduledExecutorService;
        this.f17801d = provider;
        this.f17802e = performanceLogger;
        this.f17803f = analyticsLogger;
        this.f17804g = fbLocationCache;
        this.f17805h = appStateManager;
    }

    public final synchronized void m25047a(FbLocationManagerParams fbLocationManagerParams, LocationCallback locationCallback, CallerContext callerContext) {
        boolean z = true;
        synchronized (this) {
            if (this.f17810m.getAndSet(true)) {
                z = false;
            }
            Preconditions.checkState(z);
            this.f17806i = (FbLocationManagerParams) Preconditions.checkNotNull(fbLocationManagerParams);
            this.f17807j = (LocationCallback) Preconditions.checkNotNull(locationCallback);
            this.f17808k = (CallerContext) Preconditions.checkNotNull(callerContext);
            this.f17813p = this.f17799b.mo211a();
            if (this.f17809l == null) {
                this.f17809l = (ExecutorService) this.f17801d.get();
            }
            if (this.f17798a.m8258a(this.f17806i.f17827a) != State.OKAY) {
                m25028a(Type.LOCATION_UNAVAILABLE);
                m25031b(new FbLocationManagerException(Type.LOCATION_UNAVAILABLE));
            } else {
                m25035f();
                m25039i();
                mo2972a(fbLocationManagerParams);
            }
        }
    }

    public final synchronized void m25052c() {
        if (this.f17810m.getAndSet(false)) {
            m25037g();
            mo2973b();
            m25041k();
            m25042l();
            m25038h(this);
        }
    }

    public final synchronized void m25049a(ExecutorService executorService) {
        Preconditions.checkState(!this.f17810m.get(), "Must call this before operation starts");
        this.f17809l = executorService;
    }

    protected final synchronized void m25048a(ImmutableLocation immutableLocation) {
        this.f17804g.m8248a(immutableLocation);
        if (this.f17810m.get()) {
            m25036f(immutableLocation);
            m25033c(immutableLocation);
        }
    }

    protected final synchronized void m25045a(FbLocationManagerException fbLocationManagerException) {
        m25037g();
        m25040j();
        m25031b(fbLocationManagerException);
    }

    private synchronized void m25034e() {
        mo2973b();
        m25040j();
        m25028a(Type.TIMEOUT);
        m25031b(new FbLocationManagerException(Type.TIMEOUT));
    }

    private void m25035f() {
        if (this.f17806i.f17830d.isPresent()) {
            this.f17811n = this.f17800c.schedule(new C07171(this), ((Long) this.f17806i.f17830d.get()).longValue(), TimeUnit.MILLISECONDS);
        }
    }

    private void m25037g() {
        if (this.f17811n != null) {
            this.f17811n.cancel(false);
            this.f17811n = null;
        }
    }

    private void m25033c(ImmutableLocation immutableLocation) {
        Object obj;
        if (this.f17806i.f17828b.isPresent() && m25050b(immutableLocation) > ((Long) this.f17806i.f17828b.get()).longValue()) {
            obj = null;
        } else if (!this.f17806i.f17829c.isPresent() || ((Float) immutableLocation.m11986c().get()).floatValue() <= ((Float) this.f17806i.f17829c.get()).floatValue()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && m25030a(this.f17812o, immutableLocation)) {
            m25037g();
            this.f17812o = immutableLocation;
            ExecutorDetour.a(this.f17809l, new 2(this, immutableLocation), -1771421133);
        }
    }

    private void m25031b(FbLocationManagerException fbLocationManagerException) {
        ExecutorDetour.a(this.f17809l, new 3(this, fbLocationManagerException), 1705216549);
    }

    private boolean m25030a(@Nullable ImmutableLocation immutableLocation, ImmutableLocation immutableLocation2) {
        if (immutableLocation == null || m25032b(immutableLocation, immutableLocation2)) {
            return true;
        }
        Object obj;
        if (((Float) immutableLocation.m11986c().get()).floatValue() < ((Float) immutableLocation2.m11986c().get()).floatValue()) {
            obj = null;
        } else {
            obj = this.f17806i.f17834h * ((Float) immutableLocation.m11986c().get()).floatValue() >= ((Float) immutableLocation2.m11986c().get()).floatValue() ? 1 : null;
        }
        if (obj != null && !m25032b(immutableLocation2, immutableLocation)) {
            return true;
        }
        if (LocationComparisonUtil.b(immutableLocation, immutableLocation2) <= this.f17806i.f17831e || LocationComparisonUtil.a(immutableLocation, immutableLocation2) <= this.f17806i.f17832f) {
            return false;
        }
        return true;
    }

    private boolean m25032b(ImmutableLocation immutableLocation, ImmutableLocation immutableLocation2) {
        if (((Long) immutableLocation.m11990g().get()).longValue() > ((Long) immutableLocation2.m11990g().get()).longValue()) {
            return false;
        }
        return ((Long) immutableLocation2.m11990g().get()).longValue() - ((Long) immutableLocation.m11990g().get()).longValue() >= this.f17806i.f17833g;
    }

    public final long m25050b(ImmutableLocation immutableLocation) {
        return this.f17799b.mo211a() - ((Long) immutableLocation.m11990g().get()).longValue();
    }

    public static void m25038h(BaseFbLocationManager baseFbLocationManager) {
        baseFbLocationManager.f17806i = null;
        baseFbLocationManager.f17807j = null;
        baseFbLocationManager.f17808k = null;
        baseFbLocationManager.f17812o = null;
        baseFbLocationManager.f17813p = 0;
        baseFbLocationManager.f17814q = 0;
    }

    private void m25039i() {
        for (PerfEvent perfEvent : PerfEvent.values()) {
            MarkerConfig markerConfig = new MarkerConfig(perfEvent.perfMarkerId, perfEvent.perfLoggerName);
            markerConfig.m3387a(m25043m());
            this.f17802e.mo391c(markerConfig);
        }
    }

    private void m25036f(ImmutableLocation immutableLocation) {
        m25026a(PerfEvent.ANY_LOCATION);
        if (m25029a(immutableLocation, 900000, 1000.0f)) {
            m25026a(PerfEvent.CITY_GRANULARITY);
        }
        if (m25029a(immutableLocation, 300000, 250.0f)) {
            m25026a(PerfEvent.BLOCK_GRANULARITY);
        }
        if (m25029a(immutableLocation, 60000, 40.0f)) {
            m25026a(PerfEvent.EXACT_GRANULARITY);
        }
    }

    private boolean m25029a(ImmutableLocation immutableLocation, long j, float f) {
        return m25050b(immutableLocation) <= j && ((Float) immutableLocation.m11986c().get()).floatValue() <= f;
    }

    private void m25026a(PerfEvent perfEvent) {
        this.f17802e.mo389c(perfEvent.perfMarkerId, perfEvent.perfLoggerName);
    }

    private void m25040j() {
        for (PerfEvent perfEvent : PerfEvent.values()) {
            this.f17802e.mo397f(perfEvent.perfMarkerId, perfEvent.perfLoggerName);
        }
    }

    private void m25041k() {
        for (PerfEvent perfEvent : PerfEvent.values()) {
            this.f17802e.mo385b(perfEvent.perfMarkerId, perfEvent.perfLoggerName);
        }
    }

    protected final void m25053d() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb_location_no_recent_cached");
        honeyClientEvent.f3099c = "location";
        this.f17803f.mo526a(honeyClientEvent.m5090b("caller_context_class", this.f17808k.f5181b).m5090b("caller_context_tag", this.f17808k.m9067b()).m5086a("impl", mo2971a()));
    }

    private void m25042l() {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("fb_location_stop");
        honeyClientEvent.f3099c = "location";
        honeyClientEvent = honeyClientEvent;
        m25025a((HoneyClientEvent) honeyClientEvent);
        this.f17803f.mo526a(honeyClientEvent);
    }

    private void m25028a(Type type) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb_location_error");
        honeyClientEvent.f3099c = "location";
        HoneyAnalyticsEvent a = honeyClientEvent.m5086a("error_type", (Object) type);
        m25025a((HoneyClientEvent) a);
        this.f17803f.mo526a(a);
    }

    private void m25025a(HoneyClientEvent honeyClientEvent) {
        long a = this.f17799b.mo211a() - this.f17813p;
        honeyClientEvent.m5084a("duration_ms", a).m5083a("num_locations_returned", this.f17814q);
        honeyClientEvent.m5088a(m25043m());
        LocationStats.a.a(this.f17808k.f5181b, this.f17806i.f17827a, a);
    }

    private Map<String, String> m25043m() {
        Map<String, String> c = Maps.m838c();
        c.put("caller_context_class", this.f17808k.f5181b);
        c.put("caller_context_tag", this.f17808k.m9067b());
        c.put("param_priority", this.f17806i.f17827a.name());
        c.put("param_interval_ms", Long.toString(this.f17806i.f17831e));
        c.put("is_active", Boolean.toString(this.f17805h.m2264l()));
        return c;
    }
}
