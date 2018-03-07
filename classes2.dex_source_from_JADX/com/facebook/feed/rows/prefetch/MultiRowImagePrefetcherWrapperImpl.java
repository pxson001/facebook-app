package com.facebook.feed.rows.prefetch;

import android.util.LruCache;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.feed.rows.core.RowIdentifier;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.inject.Assisted;
import com.facebook.photos.prefetch.DefaultPrefetcher;
import com.facebook.photos.prefetch.DefaultPrefetcherFactory;
import com.facebook.photos.prefetch.ImageFetcher;
import com.facebook.photos.prefetch.PrefetchParams;
import com.facebook.photos.prefetch.ScrollState;
import com.facebook.photos.prefetch.qe.ExperimentsForPrefetchModule;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: pages_android_call_to_action */
public class MultiRowImagePrefetcherWrapperImpl implements MultiRowImagePrefetcherWrapper {
    public final DefaultAndroidThreadUtil f10444a;
    public final MonotonicClock f10445b;
    public final Object f10446c;
    public final DefaultPrefetcher f10447d;
    public final LruCache<RowKey, List<PrefetchParams>> f10448e = new LruCache(HTTPTransportCallback.BODY_BYTES_RECEIVED);
    private final OnScrollListener f10449f = new ScrollListener(this);
    private final ScheduledExecutorService f10450g;
    private final PrefetchRegistrationRunnable f10451h = new PrefetchRegistrationRunnable(this);
    @GuardedBy("mLock")
    public final Map<RowKey, List<PrefetchParams>> f10452i = new HashMap(32);
    public RowIdentifier f10453j;
    public boolean f10454k;
    @GuardedBy("mLock")
    private ScheduledFuture<?> f10455l;
    public long f10456m;

    /* compiled from: pages_android_call_to_action */
    class ScrollListener implements OnScrollListener {
        final /* synthetic */ MultiRowImagePrefetcherWrapperImpl f10457a;

        public ScrollListener(MultiRowImagePrefetcherWrapperImpl multiRowImagePrefetcherWrapperImpl) {
            this.f10457a = multiRowImagePrefetcherWrapperImpl;
        }

        public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f10457a.f10444a.m1649a();
            if (ScrollState.getFromListViewScrollState(i) == ScrollState.IDLE) {
                MultiRowImagePrefetcherWrapperImpl.m15528a(this.f10457a, scrollingViewProxy.mo2402q(), (scrollingViewProxy.mo2403r() - scrollingViewProxy.mo2402q()) + 1);
                return;
            }
            this.f10457a.f10456m = this.f10457a.f10445b.now();
        }

        public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            if (this.f10457a.f10445b.now() - this.f10457a.f10456m >= 2000) {
                MultiRowImagePrefetcherWrapperImpl.m15528a(this.f10457a, i, i2);
                this.f10457a.f10456m = this.f10457a.f10445b.now();
            }
        }
    }

    /* compiled from: pages_android_call_to_action */
    class PrefetchRegistrationRunnable implements Runnable {
        final /* synthetic */ MultiRowImagePrefetcherWrapperImpl f10458a;

        public PrefetchRegistrationRunnable(MultiRowImagePrefetcherWrapperImpl multiRowImagePrefetcherWrapperImpl) {
            this.f10458a = multiRowImagePrefetcherWrapperImpl;
        }

        public void run() {
            this.f10458a.f10444a.m1649a();
            synchronized (this.f10458a.f10446c) {
                for (RowKey rowKey : this.f10458a.f10452i.keySet()) {
                    List list = (List) this.f10458a.f10452i.get(rowKey);
                    if (!(list == null || list.isEmpty())) {
                        List list2 = (List) this.f10458a.f10448e.get(rowKey);
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.f10458a.f10448e.put(rowKey, list2);
                        }
                        list2.addAll(list);
                    }
                }
                this.f10458a.f10452i.clear();
                if (this.f10458a.f10454k) {
                    this.f10458a.f10447d.m16440a();
                }
                this.f10458a.f10455l = null;
            }
        }
    }

    /* compiled from: pages_android_call_to_action */
    public class DataProvider {
        public final /* synthetic */ MultiRowImagePrefetcherWrapperImpl f10459a;

        public DataProvider(MultiRowImagePrefetcherWrapperImpl multiRowImagePrefetcherWrapperImpl) {
            this.f10459a = multiRowImagePrefetcherWrapperImpl;
        }

        public final List<PrefetchParams> m15541a(int i) {
            RowKey a = this.f10459a.f10453j.mo2531a(i);
            return a != null ? (List) this.f10459a.f10448e.get(a) : null;
        }
    }

    @Inject
    public MultiRowImagePrefetcherWrapperImpl(DefaultAndroidThreadUtil defaultAndroidThreadUtil, MonotonicClock monotonicClock, @Assisted DefaultPrefetcherFactory defaultPrefetcherFactory, ScheduledExecutorService scheduledExecutorService) {
        this.f10444a = defaultAndroidThreadUtil;
        this.f10445b = monotonicClock;
        DataProvider dataProvider = new DataProvider(this);
        ImageFetcher imageFetcher = defaultPrefetcherFactory.f10443f.mo596a(ExperimentsForPrefetchModule.f10460a, false) ? (ImageFetcher) defaultPrefetcherFactory.f10441d.get() : defaultPrefetcherFactory.f10443f.mo596a(ExperimentsForPrefetchModule.f10461b, false) ? (ImageFetcher) defaultPrefetcherFactory.f10440c.get() : (ImageFetcher) defaultPrefetcherFactory.f10439b.get();
        this.f10447d = new DefaultPrefetcher(DefaultAndroidThreadUtil.m1646b(defaultPrefetcherFactory.f10438a), defaultPrefetcherFactory.f10442e, dataProvider, imageFetcher);
        this.f10450g = scheduledExecutorService;
        this.f10446c = new Object();
    }

    public final OnScrollListener mo1998a() {
        return this.f10449f;
    }

    public final void mo2000a(RowKey rowKey, PrefetchParams prefetchParams) {
        synchronized (this.f10446c) {
            List list = (List) this.f10452i.get(rowKey);
            if (list == null) {
                list = new ArrayList();
                this.f10452i.put(rowKey, list);
            }
            list.add(prefetchParams);
            if (this.f10455l == null) {
                this.f10455l = this.f10450g.schedule(this.f10451h, 250, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void mo1999a(RowIdentifier rowIdentifier) {
        this.f10453j = rowIdentifier;
    }

    public final void mo2001a(ScrollingViewProxy scrollingViewProxy) {
        boolean z = false;
        this.f10444a.m1649a();
        Preconditions.checkState(!this.f10454k);
        if (this.f10453j != null) {
            z = true;
        }
        Preconditions.checkState(z);
        this.f10454k = true;
        DefaultPrefetcher defaultPrefetcher = this.f10447d;
        defaultPrefetcher.f11084a.m1649a();
        Preconditions.checkState(!defaultPrefetcher.f11092i);
        defaultPrefetcher.f11092i = true;
        int q = scrollingViewProxy.mo2402q();
        m15528a(this, q, (scrollingViewProxy.mo2403r() - q) + 1);
    }

    public final void mo2002b() {
        this.f10444a.m1649a();
        Preconditions.checkState(this.f10454k);
        this.f10454k = false;
        this.f10447d.m16442c();
    }

    public static void m15528a(MultiRowImagePrefetcherWrapperImpl multiRowImagePrefetcherWrapperImpl, int i, int i2) {
        TracerDetour.a("MultiRowImagePrefetcherWrapperImpl::updateVisibleItems", 1612390332);
        try {
            multiRowImagePrefetcherWrapperImpl.f10447d.m16441a(i, (i + i2) - 1);
        } finally {
            TracerDetour.a(-917236351);
        }
    }
}
