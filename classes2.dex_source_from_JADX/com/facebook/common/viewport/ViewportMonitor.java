package com.facebook.common.viewport;

import android.support.v4.util.SimpleArrayMap;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: photo_id */
public class ViewportMonitor implements OnScrollListener {
    public final SimpleArrayMap<Object, Object> f10058a;
    private final SimpleArrayMap<Object, Object> f10059b;
    public final List<ViewportEventListener> f10060c;
    public int f10061d = -1;
    public int f10062e = -1;
    public boolean f10063f = true;
    public final SimpleArrayMap<Object, Object> f10064g;
    public final QeAccessor f10065h;
    public final AbstractFbErrorReporter f10066i;
    private final DefaultAndroidThreadUtil f10067j;

    public static ViewportMonitor m15145b(InjectorLike injectorLike) {
        return new ViewportMonitor(QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    public static ViewportMonitor m15142a(InjectorLike injectorLike) {
        return m15145b(injectorLike);
    }

    @Inject
    public ViewportMonitor(QeAccessor qeAccessor, AbstractFbErrorReporter abstractFbErrorReporter, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f10065h = qeAccessor;
        this.f10060c = Lists.m1296a();
        this.f10064g = new SimpleArrayMap();
        this.f10058a = new SimpleArrayMap();
        this.f10059b = new SimpleArrayMap();
        this.f10066i = abstractFbErrorReporter;
        this.f10067j = defaultAndroidThreadUtil;
    }

    public final void m15147a(ViewportEventListener viewportEventListener) {
        if (!this.f10060c.contains(viewportEventListener)) {
            this.f10060c.add(viewportEventListener);
        }
    }

    public final void m15153b(ViewportEventListener viewportEventListener) {
        this.f10060c.remove(viewportEventListener);
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        if (this.f10063f && i != -1) {
            TracerDetour.a("ViewportMonitor.onScroll", -688344764);
            try {
                int i4 = this.f10061d;
                int i5 = this.f10062e;
                this.f10061d = i;
                this.f10062e = (i + i2) - 1;
                this.f10059b.clear();
                int s = scrollingViewProxy.mo2404s();
                int i6 = 0;
                Object obj = null;
                int i7 = this.f10061d;
                while (i6 < i2 && i7 < s) {
                    Object g = scrollingViewProxy.mo2389g(i7);
                    if (i7 < i4 || i7 > i5) {
                        m15144a(scrollingViewProxy, g, this.f10061d, i6);
                    }
                    if (g == null || g.equals(obj)) {
                        g = obj;
                    } else {
                        if (this.f10064g.put(g, Boolean.valueOf(true)) == null) {
                            m15151a(g);
                        }
                        if (this.f10059b.put(g, Boolean.valueOf(true)) == null) {
                            m15143a(scrollingViewProxy, g, i6);
                        }
                    }
                    i6++;
                    i7++;
                    obj = g;
                }
                int i8 = i4;
                while (i8 <= i5 && i8 < i3) {
                    if (i8 < this.f10061d || i8 > this.f10062e) {
                        obj = scrollingViewProxy.mo2389g(i8);
                        m15146b(scrollingViewProxy, obj, i8 - this.f10061d);
                        if (!(this.f10059b.containsKey(obj) || this.f10064g.remove(obj) == null)) {
                            m15155b(obj);
                        }
                    }
                    i8++;
                }
                TracerDetour.a(779810944);
            } catch (Throwable th) {
                TracerDetour.a(217169432);
            }
        }
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
    }

    public final void m15152a(boolean z, ScrollingViewProxy scrollingViewProxy) {
        this.f10067j.m1654a("ViewportMonitor should only be used on the UI thread");
        if (z) {
            m15148a(scrollingViewProxy);
        } else {
            m15156c(scrollingViewProxy);
        }
        this.f10063f = z;
    }

    public final void m15148a(final ScrollingViewProxy scrollingViewProxy) {
        Object obj;
        if (scrollingViewProxy == null || scrollingViewProxy.ix_() == null) {
            obj = 1;
        } else if (scrollingViewProxy.ix_() instanceof BetterListView) {
            if (scrollingViewProxy.mo2400o() == null) {
                r1 = 1;
            } else {
                obj = null;
            }
        } else if (!(scrollingViewProxy.ix_() instanceof BetterRecyclerView)) {
            this.f10066i.m2340a("ViewportMonitor#hasNullAdapter()", "Unexpected scrollingViewProxy view type when attempting to check backing adapter state" + scrollingViewProxy.ix_());
            r1 = 1;
        } else if (((BetterRecyclerView) scrollingViewProxy.ix_()).f11831o == null) {
            r1 = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            scrollingViewProxy.mo2360a(new Runnable(this) {
                final /* synthetic */ ViewportMonitor f14078b;

                public void run() {
                    if (this.f14078b.f10063f || !this.f14078b.f10065h.mo596a(ExperimentsForNewsFeedAbTestModule.f5124y, false)) {
                        this.f14078b.f10061d = scrollingViewProxy.mo2402q();
                        if (this.f14078b.f10061d != -1) {
                            this.f14078b.f10062e = scrollingViewProxy.mo2403r();
                            this.f14078b.f10058a.a(this.f14078b.f10064g);
                            int i = this.f14078b.f10061d;
                            while (i <= this.f14078b.f10062e && i < scrollingViewProxy.mo2404s()) {
                                Object g = scrollingViewProxy.mo2389g(i);
                                if (this.f14078b.f10064g.put(g, Boolean.valueOf(true)) == null) {
                                    this.f14078b.m15151a(g);
                                }
                                this.f14078b.f10058a.remove(g);
                                i++;
                            }
                            int size = this.f14078b.f10058a.size();
                            for (i = 0; i < size; i++) {
                                Object b = this.f14078b.f10058a.b(i);
                                if (this.f14078b.f10064g.remove(b) != null) {
                                    this.f14078b.m15155b(b);
                                }
                            }
                            this.f14078b.f10058a.clear();
                        }
                    }
                }
            });
        }
    }

    public final void m15154b(ScrollingViewProxy scrollingViewProxy) {
        int size = this.f10060c.size();
        for (int i = 0; i < size; i++) {
            ((ViewportEventListener) this.f10060c.get(i)).mo1967a(scrollingViewProxy);
        }
    }

    public final void m15156c(ScrollingViewProxy scrollingViewProxy) {
        if (scrollingViewProxy.mo2404s() != 0) {
            this.f10061d = scrollingViewProxy.mo2402q();
            this.f10062e = scrollingViewProxy.mo2403r();
            int s = scrollingViewProxy.mo2404s();
            if (this.f10061d != -1) {
                int i = this.f10061d;
                while (i <= this.f10062e && i < s) {
                    Object g = scrollingViewProxy.mo2389g(i);
                    if (this.f10064g.remove(g) != null) {
                        m15155b(g);
                    }
                    i++;
                }
            }
            this.f10064g.clear();
            int size = this.f10060c.size();
            for (s = 0; s < size; s++) {
                ((ViewportEventListener) this.f10060c.get(s)).mo1971b(scrollingViewProxy);
            }
        }
    }

    private void m15143a(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        int size = this.f10060c.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ViewportEventListener) this.f10060c.get(i2)).mo1968a(scrollingViewProxy, obj, i);
        }
    }

    @VisibleForTesting
    public final void m15151a(Object obj) {
        int size = this.f10060c.size();
        for (int i = 0; i < size; i++) {
            ((ViewportEventListener) this.f10060c.get(i)).mo1970a(obj);
        }
    }

    private void m15144a(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i, int i2) {
        int size = this.f10060c.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ViewportEventListener) this.f10060c.get(i3)).mo1969a(scrollingViewProxy, obj, i, i2);
        }
    }

    @VisibleForTesting
    public final void m15155b(Object obj) {
        int size = this.f10060c.size();
        for (int i = 0; i < size; i++) {
            ((ViewportEventListener) this.f10060c.get(i)).mo1973b(obj);
        }
    }

    private void m15146b(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i) {
        int size = this.f10060c.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ViewportEventListener) this.f10060c.get(i2)).mo1972b(scrollingViewProxy, obj, i);
        }
    }
}
