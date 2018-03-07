package com.facebook.feed.friending;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.environment.HasRefresh;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.RefreshTriggerEvents$FriendRequestEventSubscriber;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: placefeed?placeid=%s */
public class FeedRefreshTrigger<E extends HasRefresh> {
    private static FeedRefreshTrigger f9774g;
    private static final Object f9775h = new Object();
    private final FeedEventBus f9776a;
    public final MonotonicClock f9777b;
    private final QeAccessor f9778c;
    private final RefreshTriggerEventSubscriber f9779d = new RefreshTriggerEventSubscriber(this);
    public long f9780e;
    public long f9781f;

    /* compiled from: placefeed?placeid=%s */
    class RefreshTriggerEventSubscriber extends RefreshTriggerEvents$FriendRequestEventSubscriber {
        final /* synthetic */ FeedRefreshTrigger f9782a;

        public RefreshTriggerEventSubscriber(FeedRefreshTrigger feedRefreshTrigger) {
            this.f9782a = feedRefreshTrigger;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f9782a.f9781f = this.f9782a.f9777b.now();
        }
    }

    private static FeedRefreshTrigger m14794b(InjectorLike injectorLike) {
        return new FeedRefreshTrigger(FeedEventBus.m4573a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public FeedRefreshTrigger(FeedEventBus feedEventBus, MonotonicClock monotonicClock, QeAccessor qeAccessor) {
        this.f9776a = feedEventBus;
        this.f9777b = monotonicClock;
        this.f9778c = qeAccessor;
    }

    public final void m14796a() {
        if (m14795d()) {
            this.f9776a.m4568a(this.f9779d);
            this.f9780e = this.f9777b.now();
            this.f9781f = -1;
        }
    }

    public final void m14797a(E e) {
        if (m14795d()) {
            if ((this.f9781f > this.f9780e ? 1 : null) != null) {
                e.mo2458l();
            }
        }
    }

    public static FeedRefreshTrigger m14793a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedRefreshTrigger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9775h) {
                FeedRefreshTrigger feedRefreshTrigger;
                if (a2 != null) {
                    feedRefreshTrigger = (FeedRefreshTrigger) a2.mo818a(f9775h);
                } else {
                    feedRefreshTrigger = f9774g;
                }
                if (feedRefreshTrigger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14794b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9775h, b3);
                        } else {
                            f9774g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedRefreshTrigger;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m14798b() {
        if (m14795d()) {
            this.f9780e = this.f9777b.now();
        }
    }

    public final void m14799c() {
        if (m14795d()) {
            this.f9776a.m4569b(this.f9779d);
        }
    }

    private boolean m14795d() {
        return this.f9778c.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForNewsFeedAbTestModule.aa, false);
    }
}
