package com.facebook.location;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0115xfdf5bd2;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationManagerException.Type;
import com.facebook.location.FbLocationManagerParams.Builder;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: layout is not valid for scroll away composer */
public class FbLocationOperation extends AbstractFuture<ImmutableLocation> {
    private final FbLocationStatusUtil f17752a;
    private final BaseFbLocationManager f17753b;
    private final FbLocationCache f17754c;
    private final Clock f17755d;
    private final ScheduledExecutorService f17756e;
    private FbLocationOperationParams f17757f;
    @GuardedBy("this")
    private boolean f17758g;
    @GuardedBy("this")
    private LocationCallback f17759h;
    @GuardedBy("this")
    private ScheduledFuture f17760i;
    @GuardedBy("this")
    private ImmutableLocation f17761j;

    /* compiled from: layout is not valid for scroll away composer */
    public class LocationCallback {
        public final /* synthetic */ FbLocationOperation f17817a;

        public LocationCallback(FbLocationOperation fbLocationOperation) {
            this.f17817a = fbLocationOperation;
        }
    }

    /* compiled from: layout is not valid for scroll away composer */
    class C07161 implements Runnable {
        final /* synthetic */ FbLocationOperation f17818a;

        C07161(FbLocationOperation fbLocationOperation) {
            this.f17818a = fbLocationOperation;
        }

        public void run() {
            FbLocationOperation.m24982g(this.f17818a);
        }
    }

    public static FbLocationOperation m24978b(InjectorLike injectorLike) {
        return new FbLocationOperation(FbLocationStatusUtil.m8253a(injectorLike), LocationModule.m21685a(IdBasedProvider.m1811a(injectorLike, 703), GooglePlayServicesUtil.m24988a(injectorLike), FbZeroFeatureVisibilityHelper.m7916a(injectorLike), IdBasedProvider.m1811a(injectorLike, 2484), IdBasedProvider.m1811a(injectorLike, 7449), IdBasedProvider.m1811a(injectorLike, 2490), PerfTestConfig.m2936a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike)), FbLocationCache.m8244b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), C0115xfdf5bd2.m3569a(injectorLike));
    }

    @Inject
    public FbLocationOperation(FbLocationStatusUtil fbLocationStatusUtil, BaseFbLocationManager baseFbLocationManager, FbLocationCache fbLocationCache, Clock clock, ScheduledExecutorService scheduledExecutorService) {
        this.f17752a = fbLocationStatusUtil;
        this.f17753b = baseFbLocationManager;
        this.f17754c = fbLocationCache;
        this.f17755d = clock;
        this.f17756e = scheduledExecutorService;
    }

    public final synchronized void m24986a(FbLocationOperationParams fbLocationOperationParams, CallerContext callerContext) {
        boolean z = true;
        synchronized (this) {
            Preconditions.checkState(!this.f17758g, "already running");
            if (isDone()) {
                z = false;
            }
            Preconditions.checkState(z, "already done");
            this.f17757f = (FbLocationOperationParams) Preconditions.checkNotNull(fbLocationOperationParams);
            if (this.f17752a.m8257a() != State.OKAY) {
                mo222a(new FbLocationManagerException(Type.LOCATION_UNAVAILABLE));
            } else {
                Object a = this.f17754c.m8247a(this.f17757f.f16482b, this.f17757f.f16483c);
                if (a != null) {
                    this.f17761j = a;
                    mo221a(a);
                } else {
                    this.f17758g = true;
                    this.f17759h = new LocationCallback(this);
                    this.f17753b.m25049a(this.f17756e);
                    m24983h();
                    this.f17753b.m25047a(m24985j(), this.f17759h, callerContext);
                }
            }
        }
    }

    @Nullable
    public final synchronized ImmutableLocation m24987f() {
        boolean z = this.f17758g || isDone();
        Preconditions.checkState(z, "must be started");
        return this.f17761j;
    }

    public static synchronized void m24977a(FbLocationOperation fbLocationOperation, ImmutableLocation immutableLocation) {
        synchronized (fbLocationOperation) {
            if (fbLocationOperation.f17758g) {
                fbLocationOperation.f17761j = immutableLocation;
                if (fbLocationOperation.m24981c(immutableLocation) <= fbLocationOperation.f17757f.f16482b && ((Float) immutableLocation.m11986c().get()).floatValue() <= fbLocationOperation.f17757f.f16483c) {
                    fbLocationOperation.m24979b(immutableLocation);
                }
            }
        }
    }

    public static synchronized void m24982g(FbLocationOperation fbLocationOperation) {
        synchronized (fbLocationOperation) {
            if (fbLocationOperation.f17758g) {
                if (fbLocationOperation.f17761j != null) {
                    fbLocationOperation.m24979b(fbLocationOperation.f17761j);
                } else {
                    fbLocationOperation.m24980b(new FbLocationManagerException(Type.TIMEOUT));
                }
            }
        }
    }

    public static synchronized void m24976a(FbLocationOperation fbLocationOperation, FbLocationManagerException fbLocationManagerException) {
        synchronized (fbLocationOperation) {
            if (fbLocationOperation.f17758g) {
                fbLocationOperation.m24980b((Throwable) fbLocationManagerException);
            }
        }
    }

    private void m24979b(ImmutableLocation immutableLocation) {
        this.f17758g = false;
        this.f17753b.m25052c();
        m24984i();
        mo221a((Object) immutableLocation);
    }

    private void m24980b(Throwable th) {
        this.f17758g = false;
        this.f17753b.m25052c();
        m24984i();
        mo222a(th);
    }

    private void m24983h() {
        this.f17760i = this.f17756e.schedule(new C07161(this), this.f17757f.f16484d, TimeUnit.MILLISECONDS);
    }

    private void m24984i() {
        if (this.f17760i != null) {
            this.f17760i.cancel(false);
            this.f17760i = null;
        }
    }

    private FbLocationManagerParams m24985j() {
        Builder builder = new Builder(this.f17757f.f16481a);
        builder.f17822d = Optional.of(Long.valueOf(this.f17757f.f16484d));
        builder = builder;
        builder.f17820b = this.f17757f.f16485e;
        builder = builder;
        builder.f17821c = this.f17757f.f16486f;
        builder = builder;
        builder.f17823e = this.f17757f.f16487g;
        builder = builder;
        builder.f17824f = 0.0f;
        builder = builder;
        builder.f17825g = this.f17757f.f16488h;
        builder = builder;
        builder.f17826h = this.f17757f.f16489i;
        return new FbLocationManagerParams(builder);
    }

    private long m24981c(ImmutableLocation immutableLocation) {
        return this.f17755d.mo211a() - ((Long) immutableLocation.m11990g().get()).longValue();
    }
}
