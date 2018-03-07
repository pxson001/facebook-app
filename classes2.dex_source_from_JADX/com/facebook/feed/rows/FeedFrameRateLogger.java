package com.facebook.feed.rows;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.SparseIntArray;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.fps.BaseFrameRateLoggerCallback;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.debug.fps.FrameRateBlameMarkers.Marker;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.frameblame.GetViewFrameBlameMarker;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: omnistore */
public class FeedFrameRateLogger {
    private static FeedFrameRateLogger f11229m;
    private static final Object f11230n = new Object();
    public final FrameRateLogger f11231a;
    public final ListItemRowController f11232b;
    public final QuickPerformanceLogger f11233c;
    public final QeAccessor f11234d;
    public final FrameRateBlameMarkers f11235e;
    public final Resources f11236f;
    public SparseIntArray f11237g;
    public int f11238h;
    public int f11239i;
    public long f11240j;
    public long f11241k;
    public boolean f11242l;

    /* compiled from: omnistore */
    public class C04701 extends BaseFrameRateLoggerCallback {
        public final /* synthetic */ FeedFrameRateLogger f11311a;

        public C04701(FeedFrameRateLogger feedFrameRateLogger) {
            this.f11311a = feedFrameRateLogger;
        }

        public final void mo2124a() {
            this.f11311a.f11240j = SystemClock.uptimeMillis();
            if (m16606e()) {
                this.f11311a.f11233c.mo462b(655510);
            }
        }

        public final void mo2127b() {
            if (m16606e()) {
                if (this.f11311a.f11242l) {
                    this.f11311a.f11233c.mo468b(655510, (short) 2);
                } else {
                    this.f11311a.f11233c.mo476d(655510);
                }
            }
            this.f11311a.f11242l = false;
            FeedFrameRateLogger feedFrameRateLogger = this.f11311a;
            feedFrameRateLogger.f11239i += this.f11311a.f11238h;
            feedFrameRateLogger = this.f11311a;
            feedFrameRateLogger.f11241k += SystemClock.uptimeMillis() - this.f11311a.f11240j;
        }

        public final void mo2125a(int i) {
            TracerDetour.a("FrameRateLoggerCallback.onFrameRendered", -357667112);
            try {
                Marker a = this.f11311a.f11235e.m16547a();
                if (a == null || !(a instanceof GetViewFrameBlameMarker)) {
                    TracerDetour.a(-1004566890);
                    return;
                }
                int d = ((GetViewFrameBlameMarker) a).m26964d();
                this.f11311a.f11237g.put(d, this.f11311a.f11237g.get(d) + i);
                TracerDetour.a(1956448430);
            } catch (Throwable th) {
                TracerDetour.a(1071693880);
            }
        }

        public final void mo2128c() {
            TracerDetour.a("FrameRateLoggerCallback.onTwoPlusStall", 753469316);
            try {
                this.f11311a.f11242l = true;
            } finally {
                TracerDetour.a(-469948204);
            }
        }

        private boolean m16606e() {
            return this.f11311a.f11234d.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6716f, false);
        }

        public final void mo2126a(HoneyClientEventFast honeyClientEventFast) {
            if (this.f11311a.f11241k != 0) {
                honeyClientEventFast.m17382a("avg_scroll_speed", ((long) (SizeUtil.m19196b(this.f11311a.f11236f, (float) this.f11311a.f11239i) * 10000)) / this.f11311a.f11241k);
            }
            SparseIntArray sparseIntArray = this.f11311a.f11237g;
            int size = sparseIntArray.size();
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            while (i < size) {
                int valueAt = sparseIntArray.valueAt(i);
                if (valueAt > i2) {
                    i3 = sparseIntArray.keyAt(i);
                } else {
                    valueAt = i2;
                }
                i++;
                i2 = valueAt;
            }
            int i4 = i3;
            if (i4 != -1 && this.f11311a.f11237g.get(i4) != 0) {
                String canonicalName;
                ViewType a = this.f11311a.f11232b.m16557a(i4);
                Class enclosingClass = a.getClass().getEnclosingClass();
                if (enclosingClass == null) {
                    canonicalName = a.getClass().getCanonicalName();
                } else {
                    canonicalName = enclosingClass.getCanonicalName();
                }
                honeyClientEventFast.m17385a("worst_row_key", canonicalName);
            }
        }

        public final void mo2129d() {
            this.f11311a.f11237g.clear();
            this.f11311a.f11239i = 0;
            this.f11311a.f11241k = 0;
        }
    }

    private static FeedFrameRateLogger m16543b(InjectorLike injectorLike) {
        return new FeedFrameRateLogger(ResourcesMethodAutoProvider.m6510a(injectorLike), FrameRateBlameMarkers.m16545a(injectorLike), ListItemRowController.m16554a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class));
    }

    public static FeedFrameRateLogger m16541a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedFrameRateLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f11230n) {
                FeedFrameRateLogger feedFrameRateLogger;
                if (a2 != null) {
                    feedFrameRateLogger = (FeedFrameRateLogger) a2.mo818a(f11230n);
                } else {
                    feedFrameRateLogger = f11229m;
                }
                if (feedFrameRateLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m16543b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f11230n, b3);
                        } else {
                            f11229m = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedFrameRateLogger;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FeedFrameRateLogger(Resources resources, FrameRateBlameMarkers frameRateBlameMarkers, ListItemRowController listItemRowController, QuickPerformanceLogger quickPerformanceLogger, QeAccessor qeAccessor, FrameRateLoggerProvider frameRateLoggerProvider) {
        this.f11236f = resources;
        this.f11235e = frameRateBlameMarkers;
        this.f11233c = quickPerformanceLogger;
        this.f11234d = qeAccessor;
        this.f11231a = frameRateLoggerProvider.m16560a(Boolean.valueOf(true), "news_feed_scroll", Absent.INSTANCE);
        this.f11232b = listItemRowController;
        this.f11237g = new SparseIntArray();
    }

    public final void m16544a(int i) {
        Preconditions.checkArgument(i >= 0);
        this.f11238h = i;
        this.f11231a.m16574b();
    }
}
