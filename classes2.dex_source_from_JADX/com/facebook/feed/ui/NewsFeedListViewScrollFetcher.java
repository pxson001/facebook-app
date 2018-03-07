package com.facebook.feed.ui;

import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.fragment.NewsFeedFragmentDataController;
import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.ScrollDirectionTrackingListener;
import com.facebook.widget.listview.ScrollDirectionTrackingListener.ScrollDirection;
import com.facebook.widget.listview.ScrollListenerWithThrottlingSupport;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;

/* compiled from: offers_resend */
public class NewsFeedListViewScrollFetcher extends ScrollDirectionTrackingListener implements ScrollListenerWithThrottlingSupport {
    protected final FeedPerfLogger f11541a;
    public NewsFeedRecyclerViewAdapterWrapper f11542b;
    public NewsFeedFragmentDataController f11543c;
    protected IFeedDataLoader f11544d;
    private final QeAccessor f11545e;
    private int f11546f;
    private int f11547g;
    private int f11548h;

    public static NewsFeedListViewScrollFetcher m16859a(InjectorLike injectorLike) {
        return new NewsFeedListViewScrollFetcher(FeedPerfLogger.m3326a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public NewsFeedListViewScrollFetcher(FeedPerfLogger feedPerfLogger, QeAccessor qeAccessor) {
        this.f11541a = feedPerfLogger;
        this.f11545e = qeAccessor;
    }

    private void m16860a(boolean z) {
        if (this.f11543c != null) {
            this.f11543c.m16834a(z, this.f11546f);
        }
    }

    public final void m16864a(IFeedDataLoader iFeedDataLoader) {
        this.f11544d = iFeedDataLoader;
    }

    public final int mo1974a() {
        return this.f11545e.mo572a(ExperimentsForNewsFeedAbTestModule.ae, -1);
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        super.mo1263a(scrollingViewProxy, i, i2, i3);
        this.f11546f = i3;
        this.f11548h = i2;
        this.f11547g = (i + i2) - 1;
        m16866c();
    }

    public final void m16866c() {
        TracerDetour.a("NewsFeedListViewScrollFetcher.maybeFetch", -430604800);
        try {
            if (this.f11542b == null || this.f11544d == null) {
                TracerDetour.a(-1469038859);
                return;
            }
            this.f11541a.m3357b(this.f11547g);
            if (m16861d() || (ScrollDirection.SCROLLING_DOWN == m16858b() && m16862e())) {
                m16860a(m16861d());
            }
            TracerDetour.a(1052828737);
        } catch (Throwable th) {
            TracerDetour.a(657159866);
        }
    }

    private boolean m16861d() {
        return this.f11547g >= this.f11546f + -1;
    }

    private boolean m16862e() {
        if (this.f11548h <= 0 || this.f11546f <= 0) {
            return false;
        }
        if (this.f11544d.mo1315c().mo1374a() == 0) {
            return true;
        }
        int a = this.f11544d.mo1315c().mo1374a() - 1;
        int s = this.f11544d.mo1308s();
        if (this.f11542b.s_(Math.max(this.f11542b.m20017b(), Math.min(this.f11547g, this.f11542b.m20022d()))) < Math.max(a - s, 0)) {
            return false;
        }
        return true;
    }
}
