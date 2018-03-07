package com.facebook.feed.util;

import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.feed.hscroll.ExperimentsForFeedHScrollModule;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.NavigatedToTargetPageEvent;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.model.interfaces.AutoScrollableItemListFeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: phonebook_section_key */
public class HScrollAutoScrollController extends BaseViewportEventListener implements ViewportEventListener {
    public final EventsStream f10102a;
    public final ScheduledExecutorService f10103b;
    public final FeedUnitDataController f10104c;
    private final HScrollUnitCacheUtils f10105d;
    private final Clock f10106e;
    public HashMap<String, ScheduledFuture> f10107f;
    private final boolean f10108g;
    private boolean f10109h = false;
    public final QeAccessor f10110i;

    /* compiled from: phonebook_section_key */
    class C04261 implements Action<NavigatedToTargetPageEvent> {
        final /* synthetic */ HScrollAutoScrollController f10136a;

        C04261(HScrollAutoScrollController hScrollAutoScrollController) {
            this.f10136a = hScrollAutoScrollController;
        }

        public final void mo1977a(Object obj) {
            this.f10136a.f10104c.m14177a(((NavigatedToTargetPageEvent) obj).f10135a).f19501h = true;
        }
    }

    public static HScrollAutoScrollController m15203a(InjectorLike injectorLike) {
        return new HScrollAutoScrollController(ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), EventsStream.m15220a(injectorLike), FeedUnitDataController.m14175a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), HScrollUnitCacheUtils.m15234b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public HScrollAutoScrollController(ScheduledExecutorService scheduledExecutorService, EventsStream eventsStream, FeedUnitDataController feedUnitDataController, Clock clock, HScrollUnitCacheUtils hScrollUnitCacheUtils, QeAccessor qeAccessor) {
        this.f10103b = scheduledExecutorService;
        this.f10102a = eventsStream;
        this.f10104c = feedUnitDataController;
        this.f10106e = clock;
        this.f10105d = hScrollUnitCacheUtils;
        this.f10107f = Maps.m838c();
        this.f10110i = qeAccessor;
        this.f10108g = this.f10110i.mo596a(ExperimentsForFeedHScrollModule.f10122d, false);
        this.f10102a.m15229a(NavigatedToTargetPageEvent.class, new C04261(this));
    }

    public final void mo1972b(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        this.f10109h = true;
        if (obj instanceof GraphQLFeedUnitEdge) {
            FeedUnit c = ((GraphQLFeedUnitEdge) obj).mo2540c();
            if (m15214j(c) && this.f10104c.m14177a(c).f19511r <= 0 && this.f10104c.m14177a(c).f19499f && this.f10108g && this.f10104c.m14177a(c).f19502i == 0) {
                m15208d(c);
            }
        }
    }

    public final void mo1967a(ScrollingViewProxy scrollingViewProxy) {
        this.f10109h = false;
    }

    public final void mo1970a(Object obj) {
        if (obj instanceof GraphQLFeedUnitEdge) {
            m15204a(((GraphQLFeedUnitEdge) obj).mo2540c());
        }
    }

    public final void mo1973b(Object obj) {
        if (obj instanceof GraphQLFeedUnitEdge) {
            m15205b(((GraphQLFeedUnitEdge) obj).mo2540c());
        }
    }

    private void m15204a(FeedUnit feedUnit) {
        if (m15214j(feedUnit)) {
            if (this.f10104c.m14177a(feedUnit).f19501h && this.f10110i.mo596a(ExperimentsForFeedHScrollModule.f10121c, false)) {
                m15206b(feedUnit, this.f10110i.mo575a(ExperimentsForFeedHScrollModule.f10126h, 500));
            }
            ScheduledFuture scheduledFuture = (ScheduledFuture) this.f10107f.get(feedUnit.mo2507g());
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.f10107f.remove(feedUnit.mo2507g());
            }
        }
    }

    private void m15205b(FeedUnit feedUnit) {
        if ((this.f10109h || this.f10108g) && m15214j(feedUnit)) {
            this.f10104c.m14177a(feedUnit).f19511r = 0;
            if (!this.f10104c.m14177a(feedUnit).f19501h) {
                if (!this.f10107f.containsKey(feedUnit.mo2507g()) || ((ScheduledFuture) this.f10107f.get(feedUnit.mo2507g())).isDone()) {
                    m15207c(feedUnit);
                }
            }
        }
    }

    private void m15207c(FeedUnit feedUnit) {
        long f = m15210f(feedUnit);
        if (this.f10108g) {
            long e = m15209e(feedUnit);
            f = e == 0 ? 0 : -1;
            this.f10105d.m15236a(feedUnit, (int) (e / 1000));
        }
        if (!this.f10110i.mo596a(ExperimentsForFeedHScrollModule.f10132n, false) && f >= 0) {
            this.f10107f.put(feedUnit.mo2507g(), this.f10103b.schedule(new GoToNextPageRunnable(this, (ScrollableItemListFeedUnit) feedUnit), f, TimeUnit.MILLISECONDS));
        }
    }

    private void m15208d(FeedUnit feedUnit) {
        long a = this.f10106e.mo211a() - this.f10104c.m14177a(feedUnit).f19494a;
        this.f10104c.m14177a(feedUnit).f19511r = a;
        if (this.f10110i.mo596a(ExperimentsForFeedHScrollModule.f10132n, false) && a >= this.f10110i.mo575a(ExperimentsForFeedHScrollModule.f10130l, 300) && a <= this.f10110i.mo575a(ExperimentsForFeedHScrollModule.f10129k, 3000)) {
            m15206b(feedUnit, (long) (((float) a) * this.f10110i.mo571a(ExperimentsForFeedHScrollModule.f10134p, 0.1f)));
        }
        this.f10105d.m15236a(feedUnit, (int) (m15210f(feedUnit) / 1000));
    }

    private void m15206b(FeedUnit feedUnit, long j) {
        this.f10104c.m14177a(feedUnit).f19501h = false;
        this.f10103b.schedule(new 2(this, feedUnit), j, TimeUnit.MILLISECONDS);
    }

    private long m15209e(FeedUnit feedUnit) {
        long a = ((long) (this.f10104c.m14177a(feedUnit).f19502i * 1000)) - (this.f10106e.mo211a() - this.f10104c.m14177a(feedUnit).f19494a);
        return a > 0 ? a : 0;
    }

    private long m15210f(FeedUnit feedUnit) {
        long a;
        if (m15211g(feedUnit)) {
            a = this.f10110i.mo575a(ExperimentsForFeedHScrollModule.f10127i, 0);
            if (a > 0) {
                return a;
            }
        } else if (m15213i(feedUnit)) {
            a = this.f10110i.mo575a(ExperimentsForFeedHScrollModule.f10124f, 0);
            if (a > 0) {
                return a;
            }
        } else if (m15212h(feedUnit)) {
            a = this.f10110i.mo575a(ExperimentsForFeedHScrollModule.f10123e, 0);
            if (a > 0) {
                return a;
            }
        }
        return this.f10110i.mo575a(ExperimentsForFeedHScrollModule.f10125g, 10000);
    }

    private static boolean m15211g(FeedUnit feedUnit) {
        return (feedUnit instanceof GraphQLPYMLWithLargeImageFeedUnit) || (feedUnit instanceof GraphQLCreativePagesYouMayLikeFeedUnit);
    }

    private static boolean m15212h(FeedUnit feedUnit) {
        return (feedUnit instanceof GraphQLStorySet) && !StorySetHelper.c((GraphQLStorySet) feedUnit);
    }

    private static boolean m15213i(FeedUnit feedUnit) {
        return (feedUnit instanceof GraphQLStorySet) && StorySetHelper.c((GraphQLStorySet) feedUnit);
    }

    private boolean m15214j(FeedUnit feedUnit) {
        if (!this.f10110i.mo596a(ExperimentsForFeedHScrollModule.f10119a, false) || !(feedUnit instanceof AutoScrollableItemListFeedUnit)) {
            return false;
        }
        boolean a = this.f10110i.mo596a(ExperimentsForFeedHScrollModule.f10133o, false);
        boolean a2 = this.f10110i.mo596a(ExperimentsForFeedHScrollModule.f10128j, false);
        boolean a3 = this.f10110i.mo596a(ExperimentsForFeedHScrollModule.f10131m, false);
        if ((a && m15211g(feedUnit)) || ((a2 && m15212h(feedUnit)) || (a3 && m15213i(feedUnit)))) {
            return true;
        }
        return false;
    }
}
