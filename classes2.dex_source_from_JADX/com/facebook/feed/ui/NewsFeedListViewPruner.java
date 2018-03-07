package com.facebook.feed.ui;

import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.fragment.NewsFeedFragmentDataController;
import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.listview.ScrollDirectionTrackingListener;
import com.facebook.widget.listview.ScrollDirectionTrackingListener.ScrollDirection;
import com.facebook.widget.listview.ScrollingViewProxy;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s */
public class NewsFeedListViewPruner extends ScrollDirectionTrackingListener {
    protected final NewsFeedXConfigReader f11529a;
    public NewsFeedRecyclerViewAdapterWrapper f11530b;
    protected IFeedDataLoader f11531c;
    private int f11532d;
    private int f11533e;
    private Boolean f11534f;
    public final ArrayList<OnPruneListener> f11535g = new ArrayList(2);
    public final QeAccessor f11536h;

    public static NewsFeedListViewPruner m16849a(InjectorLike injectorLike) {
        return new NewsFeedListViewPruner(NewsFeedXConfigReader.m8187a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public NewsFeedListViewPruner(NewsFeedXConfigReader newsFeedXConfigReader, QeAccessor qeAccessor) {
        this.f11529a = newsFeedXConfigReader;
        this.f11536h = qeAccessor;
    }

    public final void m16853a(IFeedDataLoader iFeedDataLoader) {
        this.f11531c = iFeedDataLoader;
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (m16852e().booleanValue() && i == 0) {
            this.f11532d = scrollingViewProxy.mo2404s();
            this.f11533e = scrollingViewProxy.mo2403r();
            m16851c();
        }
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        super.mo1263a(scrollingViewProxy, i, i2, i3);
        if (!m16852e().booleanValue()) {
            this.f11532d = i3;
            this.f11533e = i + i2;
            m16851c();
        }
    }

    private void m16851c() {
        if (this.f11531c != null && this.f11530b != null && this.f11531c.mo1315c() != null && !this.f11531c.mo1306p() && this.f11530b.mo2512e() != 0 && ScrollDirection.SCROLLING_UP == m16858b()) {
            try {
                if (m16848a(this.f11532d) - m16848a(this.f11533e) > this.f11529a.m8194f()) {
                    m16850b(m16848a(this.f11533e) + this.f11529a.m8195g());
                }
            } catch (IndexOutOfBoundsException e) {
            }
        }
    }

    private int m16848a(int i) {
        return this.f11530b.s_(Math.max(this.f11530b.m20017b(), Math.min(i, this.f11530b.m20022d())));
    }

    private void m16850b(int i) {
        this.f11531c.mo1315c().m9684c(i);
        if (this.f11536h.mo596a(ExperimentsForNewsFeedAbTestModule.ab, false)) {
            this.f11531c.mo1307r();
        }
        int size = this.f11535g.size();
        for (int i2 = 0; i2 < size; i2++) {
            NewsFeedFragmentDataController newsFeedFragmentDataController = (NewsFeedFragmentDataController) this.f11535g.get(i2);
            newsFeedFragmentDataController.f11502V.m14620b();
            NewsFeedFragmentDataController.m16795I(newsFeedFragmentDataController);
        }
    }

    private Boolean m16852e() {
        if (this.f11534f == null) {
            this.f11534f = Boolean.valueOf(this.f11536h.mo596a(ExperimentsForNewsFeedAbTestModule.f5099Z, false));
        }
        return this.f11534f;
    }
}
