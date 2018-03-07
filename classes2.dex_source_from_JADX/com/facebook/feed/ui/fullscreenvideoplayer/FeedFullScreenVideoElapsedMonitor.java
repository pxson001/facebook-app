package com.facebook.feed.ui.fullscreenvideoplayer;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feedplugins.saved.nux.SavedVideoQuickReturnTooltipTrigger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: messenger_sticker_inline_download_android */
public class FeedFullScreenVideoElapsedMonitor {
    private static final String f13725a = FeedFullScreenVideoElapsedMonitor.class.getSimpleName();
    private static FeedFullScreenVideoElapsedMonitor f13726g;
    private static final Object f13727h = new Object();
    private final MonotonicClock f13728b;
    private final AbstractFbErrorReporter f13729c;
    public final Set<ElapsedTimeListener> f13730d = Sets.m1313a();
    private FeedFullScreenParams f13731e;
    private Long f13732f;

    private static FeedFullScreenVideoElapsedMonitor m20161b(InjectorLike injectorLike) {
        return new FeedFullScreenVideoElapsedMonitor(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public FeedFullScreenVideoElapsedMonitor(MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13729c = abstractFbErrorReporter;
        this.f13728b = monotonicClock;
    }

    public final void m20163a(FeedFullScreenParams feedFullScreenParams) {
        if (1 != 0) {
            if (this.f13731e == null && this.f13732f == null) {
                this.f13731e = feedFullScreenParams;
                this.f13732f = Long.valueOf(this.f13728b.now());
                return;
            }
            this.f13729c.m2340a(f13725a, "onEnterFullScreen() is called twice before exit");
            this.f13731e = null;
            this.f13732f = null;
        }
    }

    public static FeedFullScreenVideoElapsedMonitor m20160a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedFullScreenVideoElapsedMonitor b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13727h) {
                FeedFullScreenVideoElapsedMonitor feedFullScreenVideoElapsedMonitor;
                if (a2 != null) {
                    feedFullScreenVideoElapsedMonitor = (FeedFullScreenVideoElapsedMonitor) a2.mo818a(f13727h);
                } else {
                    feedFullScreenVideoElapsedMonitor = f13726g;
                }
                if (feedFullScreenVideoElapsedMonitor == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m20161b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13727h, b3);
                        } else {
                            f13726g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedFullScreenVideoElapsedMonitor;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m20162a() {
        if (1 != 0) {
            if (this.f13731e == null || this.f13732f == null) {
                this.f13729c.m2340a(f13725a, "onExitFullScreen() is called before entering full screen");
                return;
            }
            for (SavedVideoQuickReturnTooltipTrigger a : this.f13730d) {
                a.m20156a(this.f13731e, this.f13728b.now() - this.f13732f.longValue());
            }
            this.f13731e = null;
            this.f13732f = null;
        }
    }
}
