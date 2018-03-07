package com.facebook.pages.identity.timeline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentActivity;
import android.widget.ListAdapter;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.logging.ViewBasedLoggingHandler;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEventSubscriber;
import com.facebook.friends.FriendingClient;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.context.TimelinePageContext;
import com.facebook.pages.common.context.TimelinePageContext.PageProfilePermissionsProvider;
import com.facebook.pages.common.logging.analytics.ActionEvent;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.BaseTimelineFragment;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher.ViewCallback;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcherProvider;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.feed.parts.TimelineFeedUnitRootPartDefinition;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams.QueryType;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.timeline.rows.TimelineFeedType;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents;
import com.facebook.ufiservices.event.FlyoutEvents.PostCommentEvent;
import com.facebook.ufiservices.event.FlyoutEvents.PostCommentEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.ShareStoryPublishEvent;
import com.facebook.ufiservices.event.UfiEvents.ShareStoryPublishEventSubscriber;
import com.facebook.ui.futures.FuturesManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: page_optimistic_post_failed */
public abstract class PageIdentityTimelineFragment extends BaseTimelineFragment<MultiAdapterListAdapter> implements AnalyticsFragment, ViewCallback {
    private FbEventSubscriberListManager aA;
    private TimelineStoriesDataFetcher aB;
    private TimelinePageContext aC;
    public PageIdentityTimelineEnvironment aD;
    private long aE;
    public ProgressDialog aF;
    private QeAccessor aG;
    private ViewportMonitor aH;
    private FeedLoggingViewportEventListener aI;
    private ViewBasedLoggingHandler aJ;
    private TimelineFeedType aK;
    private BaseFbBroadcastManager aL;
    private SelfRegistrableReceiverImpl aM;
    private final ActionReceiver aN = new C05811(this);
    public InteractionLogger al;
    public MonotonicClock am;
    private FeedEventBus an;
    private FlyoutEventBus ao;
    public Toaster ap;
    private TimelineStoriesDataFetcherProvider aq;
    private Lazy<FriendingClient> ar;
    private String as;
    public TimelineAllSectionsData at;
    private MultiRowAdapterBuilder au;
    private Lazy<TimelineFeedUnitRootPartDefinition> av;
    private PageIdentityTimelineEnvironmentProvider aw;
    private Provider<GatekeeperStore> ax;
    public long ay = 0;
    private FbEventSubscriberListManager az;
    public ComposerPublishServiceHelper f4159d;
    protected DefaultAndroidThreadUtil f4160e;
    protected PagesAnalytics f4161f;
    private Provider<MultipleRowsStoriesRecycleCallback> f4162g;
    private FuturesManager f4163h;
    private AbstractFbErrorReporter f4164i;

    /* compiled from: page_optimistic_post_failed */
    class C05811 implements ActionReceiver {
        final /* synthetic */ PageIdentityTimelineFragment f4211a;

        C05811(PageIdentityTimelineFragment pageIdentityTimelineFragment) {
            this.f4211a = pageIdentityTimelineFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1562271165);
            Result valueOf = Result.valueOf(intent.getStringExtra("extra_result"));
            if (this.f4211a.aF != null && this.f4211a.aF.isShowing()) {
                this.f4211a.aF.dismiss();
            }
            if (this.f4211a.ay != 0) {
                this.f4211a.al.a(this.f4211a.am.now() - this.f4211a.ay);
                this.f4211a.ay = 0;
            }
            if (valueOf == Result.SUCCESS) {
                this.f4211a.e();
            } else if (valueOf == Result.EXCEPTION) {
                this.f4211a.ap.b(new ToastBuilder(2131234530));
            }
            LogUtils.e(1581363978, a);
        }
    }

    /* compiled from: page_optimistic_post_failed */
    class C05832 implements Delegate {
        final /* synthetic */ PageIdentityTimelineFragment f4214a;

        C05832(PageIdentityTimelineFragment pageIdentityTimelineFragment) {
            this.f4214a = pageIdentityTimelineFragment;
        }

        public final void m5197a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
            this.f4214a.n().b(new BaseProxyOnScrollListener(this) {
                final /* synthetic */ C05832 f4213b;

                public final void m5196a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                    hasScrollListenerSupportImpl.b();
                }
            });
        }
    }

    /* compiled from: page_optimistic_post_failed */
    class C05843 extends LikeClickedEventSubscriber {
        final /* synthetic */ PageIdentityTimelineFragment f4215a;

        C05843(PageIdentityTimelineFragment pageIdentityTimelineFragment) {
            this.f4215a = pageIdentityTimelineFragment;
        }

        public final void m5198b(FbEvent fbEvent) {
            LikeClickedEvent likeClickedEvent = (LikeClickedEvent) fbEvent;
            Feedbackable a = this.f4215a.at.a(likeClickedEvent.a, likeClickedEvent.b);
            if (a != null && (a instanceof GraphQLStory)) {
                PageIdentityTimelineFragment.m5111a(this.f4215a, TapEvent.EVENT_LIKE_STORY, ((GraphQLStory) a).c());
            }
        }
    }

    /* compiled from: page_optimistic_post_failed */
    class C05854 extends ShareStoryPublishEventSubscriber {
        final /* synthetic */ PageIdentityTimelineFragment f4216a;

        C05854(PageIdentityTimelineFragment pageIdentityTimelineFragment) {
            this.f4216a = pageIdentityTimelineFragment;
        }

        public final void m5199b(FbEvent fbEvent) {
            ShareStoryPublishEvent shareStoryPublishEvent = (ShareStoryPublishEvent) fbEvent;
            Feedbackable a = this.f4216a.at.a(shareStoryPublishEvent.a, shareStoryPublishEvent.b);
            if (a != null && (a instanceof GraphQLStory)) {
                PageIdentityTimelineFragment.m5111a(this.f4216a, ActionEvent.EVENT_SHARE_STORY, ((GraphQLStory) a).c());
            }
        }
    }

    /* compiled from: page_optimistic_post_failed */
    class C05865 extends StoryDeleteEventSubscriber {
        final /* synthetic */ PageIdentityTimelineFragment f4217a;

        C05865(PageIdentityTimelineFragment pageIdentityTimelineFragment) {
            this.f4217a = pageIdentityTimelineFragment;
        }

        public final void m5200b(FbEvent fbEvent) {
            this.f4217a.e();
        }
    }

    /* compiled from: page_optimistic_post_failed */
    class C05876 extends FlyoutEvents.LikeClickedEventSubscriber {
        final /* synthetic */ PageIdentityTimelineFragment f4218a;

        C05876(PageIdentityTimelineFragment pageIdentityTimelineFragment) {
            this.f4218a = pageIdentityTimelineFragment;
        }

        public final void m5201b(FbEvent fbEvent) {
            FlyoutEvents.LikeClickedEvent likeClickedEvent = (FlyoutEvents.LikeClickedEvent) fbEvent;
            if (likeClickedEvent.a != null) {
                Feedbackable a = this.f4218a.at.a(null, likeClickedEvent.a.j());
                if (a != null && (a instanceof GraphQLStory)) {
                    PageIdentityTimelineFragment.m5111a(this.f4218a, TapEvent.EVENT_LIKE_STORY, ((GraphQLStory) a).c());
                }
            }
        }
    }

    /* compiled from: page_optimistic_post_failed */
    class C05887 extends PostCommentEventSubscriber {
        final /* synthetic */ PageIdentityTimelineFragment f4219a;

        C05887(PageIdentityTimelineFragment pageIdentityTimelineFragment) {
            this.f4219a = pageIdentityTimelineFragment;
        }

        public final void m5202b(FbEvent fbEvent) {
            PostCommentEvent postCommentEvent = (PostCommentEvent) fbEvent;
            if (postCommentEvent.a != null) {
                Feedbackable a = this.f4219a.at.a(null, postCommentEvent.a.j());
                if (a != null && (a instanceof GraphQLStory)) {
                    PageIdentityTimelineFragment.m5111a(this.f4219a, ActionEvent.EVENT_COMMENT_STORY, ((GraphQLStory) a).c());
                }
            }
        }
    }

    public static void m5113a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityTimelineFragment) obj).m5112a(FuturesManager.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), InteractionLogger.a(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), ComposerPublishServiceHelper.a(fbInjector), DefaultAndroidThreadUtil.a(fbInjector), FeedEventBus.a(fbInjector), FlyoutEventBus.a(fbInjector), PagesAnalytics.a(fbInjector), Toaster.a(fbInjector), (TimelineStoriesDataFetcherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TimelineStoriesDataFetcherProvider.class), IdBasedLazy.a(fbInjector, 2073), ViewportMonitor.a(fbInjector), FeedLoggingViewportEventListener.a(fbInjector), ViewBasedLoggingHandler.a(fbInjector), String_LoggedInUserIdMethodAutoProvider.a(fbInjector), TimelineAllSectionsData.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 1489), IdBasedSingletonScopeProvider.a(fbInjector, 2128), MultiRowAdapterBuilder.a(fbInjector), IdBasedLazy.a(fbInjector, 11235), (PageIdentityTimelineEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PageIdentityTimelineEnvironmentProvider.class), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public abstract void aJ();

    protected abstract Runnable aK();

    @Inject
    private void m5112a(FuturesManager futuresManager, FbErrorReporter fbErrorReporter, InteractionLogger interactionLogger, MonotonicClock monotonicClock, ComposerPublishServiceHelper composerPublishServiceHelper, AndroidThreadUtil androidThreadUtil, FeedEventBus feedEventBus, FlyoutEventBus flyoutEventBus, PagesAnalytics pagesAnalytics, Toaster toaster, TimelineStoriesDataFetcherProvider timelineStoriesDataFetcherProvider, Lazy<FriendingClient> lazy, ViewportMonitor viewportMonitor, FeedLoggingViewportEventListener feedLoggingViewportEventListener, ViewBasedLoggingHandler viewBasedLoggingHandler, String str, TimelineAllSectionsData timelineAllSectionsData, Provider<MultipleRowsStoriesRecycleCallback> provider, Provider<GatekeeperStore> provider2, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<TimelineFeedUnitRootPartDefinition> lazy2, PageIdentityTimelineEnvironmentProvider pageIdentityTimelineEnvironmentProvider, FbBroadcastManager fbBroadcastManager, QeAccessor qeAccessor) {
        this.f4163h = futuresManager;
        this.f4164i = fbErrorReporter;
        this.al = interactionLogger;
        this.am = monotonicClock;
        this.f4159d = composerPublishServiceHelper;
        this.f4160e = androidThreadUtil;
        this.an = feedEventBus;
        this.ao = flyoutEventBus;
        this.f4161f = pagesAnalytics;
        this.ap = toaster;
        this.aq = timelineStoriesDataFetcherProvider;
        this.ar = lazy;
        this.aH = viewportMonitor;
        this.aI = feedLoggingViewportEventListener;
        this.as = str;
        this.at = timelineAllSectionsData;
        this.ax = provider2;
        this.au = multiRowAdapterBuilder;
        this.av = lazy2;
        this.aw = pageIdentityTimelineEnvironmentProvider;
        this.f4162g = provider;
        this.aJ = viewBasedLoggingHandler;
        this.aL = fbBroadcastManager;
        this.aG = qeAccessor;
    }

    public void mo111c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PageIdentityTimelineFragment.class;
        m5113a((Object) this, getContext());
        this.az = new FbEventSubscriberListManager();
        this.aA = new FbEventSubscriberListManager();
        this.aH.a(this.aI);
    }

    protected final void m5118a(long j, ParcelUuid parcelUuid, String str, PageProfilePermissionsProvider pageProfilePermissionsProvider) {
        long parseLong;
        this.aE = j;
        try {
            parseLong = Long.parseLong(this.as);
        } catch (NumberFormatException e) {
            parseLong = -1;
            this.f4164i.a("page_timeline_invalid_meuser", "logged in user: " + this.as);
        }
        this.aC = TimelinePageContext.m2142a(parseLong, this.aE, null, parcelUuid, str, pageProfilePermissionsProvider);
        this.aK = new TimelineFeedType(this.aC);
        this.aD = this.aw.m5195a(getContext(), this.aK, this.aC, aK(), aI());
        FragmentActivity o = o();
        this.aB = this.aq.a(o == null ? null : o.getApplicationContext(), this, this.aC, QueryType.PAGE, this.at, null, null, CallerContext.a(getClass(), am_()));
        a(null);
        this.aM = this.aL.a().a("com.facebook.STREAM_PUBLISH_COMPLETE", this.aN).a();
        this.aM.b();
    }

    protected final MultiRowAdapter aL() {
        Builder a = this.au.a(this.av, this.at);
        a.f = this.aD;
        return a.e();
    }

    private Delegate aI() {
        return new C05832(this);
    }

    public final void m5117a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1756:
                case 1758:
                    if (!intent.getBooleanExtra("is_uploading_media", false)) {
                        this.aF = ProgressDialog.a(getContext(), b(2131235433), b(i == 1758 ? 2131234542 : 2131234541), true);
                        this.ay = this.am.now();
                        this.al.a(true);
                        this.f4159d.c(intent);
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final void aN() {
        ScrollingViewProxy n = n();
        n.a((ListAdapter) ax());
        n.a(((MultipleRowsStoriesRecycleCallback) this.f4162g.get()).a());
        n.b(this);
        aO();
        aD();
        aE();
    }

    public final TimelineAllSectionsData at() {
        return this.at;
    }

    @Nullable
    protected final TimelineStoriesDataFetcher av() {
        return this.aB;
    }

    protected final ViewportMonitor ay() {
        return this.aH;
    }

    protected final FriendingClient az() {
        return (FriendingClient) this.ar.get();
    }

    protected final TimelineContext aA() {
        return this.aC;
    }

    public void mo101G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -459127053);
        super.G();
        if (this.aA != null) {
            this.aA.a(this.ao);
        }
        if (this.az != null) {
            this.az.a(this.an);
        }
        this.aH.a(((GatekeeperStoreImpl) this.ax.get()).a(PagesFb4aAbTestGatekeepers.e, false), n());
        this.aI.a("pages_native_timeline");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1179961176, a);
    }

    public void mo102H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -688399562);
        super.H();
        if (this.f4163h != null) {
            this.f4163h.a();
        }
        if (this.aA != null) {
            this.aA.b(this.ao);
        }
        if (this.az != null) {
            this.az.b(this.an);
        }
        this.aH.c(n());
        this.aI.a("unknown");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 815702548, a);
    }

    public final void m5121a(ScrollingViewProxy scrollingViewProxy, int i) {
        super.a(scrollingViewProxy, i);
        switch (i) {
            case 0:
                this.aH.b(scrollingViewProxy);
                return;
            default:
                return;
        }
    }

    public final void m5122a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        super.a(scrollingViewProxy, i, i2, i3);
        this.aH.a(scrollingViewProxy, i, i2, i3);
    }

    public static void m5111a(PageIdentityTimelineFragment pageIdentityTimelineFragment, PageAnalyticsEvent pageAnalyticsEvent, String str) {
        pageIdentityTimelineFragment.f4161f.a(pageIdentityTimelineFragment.am_(), pageAnalyticsEvent, pageIdentityTimelineFragment.aE, str);
    }

    protected final void aO() {
        this.az.a(new C05843(this));
        this.az.a(new C05854(this));
        this.az.a(new C05865(this));
        this.aA.a(new C05876(this));
        this.aA.a(new C05887(this));
    }

    public void mo104a(TimelineSectionFetchParams timelineSectionFetchParams) {
    }

    public void mo105a(TimelineSectionFetchParams timelineSectionFetchParams, DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
        g();
        this.f4161f.a(am_(), NetworkSuccessEvent.EVENT_SECTION_LOADED, this.aE);
    }

    public void mo110b(TimelineSectionFetchParams timelineSectionFetchParams) {
        aJ();
        this.f4161f.a(am_(), NetworkFailureEvent.EVENT_SECTION_LOAD_ERROR, this.aE);
    }

    public String am_() {
        return "pages_native_timeline";
    }

    public void mo103I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 64987845);
        if (this.aB != null) {
            this.aB.b();
        }
        if (this.f4163h != null) {
            this.f4163h.a();
        }
        if (this.aA != null) {
            this.aA.b(this.ao);
        }
        if (this.az != null) {
            this.az.b(this.an);
        }
        this.aB = null;
        this.f4164i = null;
        this.f4163h = null;
        if (this.aM != null) {
            this.aM.c();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1940952048, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -425669392);
        super.mj_();
        this.aB.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1054759000, a);
    }
}
