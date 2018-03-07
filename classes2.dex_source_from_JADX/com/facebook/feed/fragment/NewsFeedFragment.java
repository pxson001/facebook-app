package com.facebook.feed.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedcache.memory.FeedUnitCache.FeedUnitCacheSubscriber;
import com.facebook.api.feedcache.memory.FeedUnitCache.MutationType;
import com.facebook.api.feedtype.FeedType;
import com.facebook.attribution.AttributionIdService;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.appstartup.AppStartupTracker;
import com.facebook.common.appstate.OnBackgroundForegroundCallback;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.composer.minutiae.music.MusicBroadcastReceiver;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.api.Requires;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumpable;
import com.facebook.debug.dumpsys.DumpsysDumper;
import com.facebook.debug.feed.HomeStoriesViewController;
import com.facebook.debug.fps.TimeSinceTTI;
import com.facebook.debug.fps.TouchDelayLogger;
import com.facebook.debug.fps.TouchDelayLogger.TouchDelayRunnable;
import com.facebook.debug.fps.TouchDelayLoggerProvider;
import com.facebook.debug.log.BLog;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.animation.AnimationCallback;
import com.facebook.feed.annotations.ForNewsfeed;
import com.facebook.feed.data.FeedDataLoaderFactory;
import com.facebook.feed.data.FeedUnitSubscriber;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.firstlaunch.FirstLaunchTracker;
import com.facebook.feed.fragment.NewsFeedFragmentDataController.C05694;
import com.facebook.feed.fragment.NewsFeedFragmentDataController.C08963;
import com.facebook.feed.fragment.controllercallbacks.ErrorViewController.Callback;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedControllerCallbacksDispatcher;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedDispatcherFactory;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedViewController;
import com.facebook.feed.fragment.controllercallbacks.SwipeRefreshController;
import com.facebook.feed.fragment.controllercallbacks.TailLoaderController;
import com.facebook.feed.fragment.controllercallbacks.ViewportMonitorFragmentController;
import com.facebook.feed.fragment.debug.FreshFeedDebugViewController;
import com.facebook.feed.fragment.subscriber.BlacklistPageYouMayLikeItemEventSubscriber;
import com.facebook.feed.fragment.subscriber.SetNotifyMeSubscriber;
import com.facebook.feed.fragment.subscriber.XOutPlaceReviewItemEventSubscriberProvider;
import com.facebook.feed.inlinecomposer.multirow.ScrollAwayComposerController;
import com.facebook.feed.loader.FeedDataLoaderHelper;
import com.facebook.feed.loader.IFeedDataLoader;
import com.facebook.feed.loader.StoryRankingTimeTracker;
import com.facebook.feed.logging.FeedLeavingLogger;
import com.facebook.feed.logging.FeedUnitImpressionLoggerController;
import com.facebook.feed.logging.ViewBasedLoggingHandler;
import com.facebook.feed.logging.ViewportLoggingHandler;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.feed.nux.FeedNuxBubbleManager.BlockingCause;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.pill.FeedMoreStoriesPillUIController;
import com.facebook.feed.pill.FeedPillUIController;
import com.facebook.feed.rows.MultiRowFeedLifecycleSubscribers;
import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.tooltip.FeedReturnDetector;
import com.facebook.feed.ui.FeedLifecycleSubscribers;
import com.facebook.feed.ui.NewsFeedListViewAnimations;
import com.facebook.feed.ui.NewsFeedListViewPruner;
import com.facebook.feed.ui.NewsFeedRecyclerViewAdapterWrapper;
import com.facebook.feed.ui.NewsFeedRecyclerViewProxy;
import com.facebook.feed.ui.basefeedfragment.BaseFeedFragment;
import com.facebook.feed.util.ConnectivityChangedCallback;
import com.facebook.feed.util.composer.ComposerActivityReceiver;
import com.facebook.feed.util.composer.ComposerActivityReceiver.Listener;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.event.AppiraterEvents$FeedFragmentResumedEvent;
import com.facebook.feed.util.event.AppiraterEvents.FeedFragmentPausedEvent;
import com.facebook.feed.util.event.AppiraterEvents.FirstFeedScrollEvent;
import com.facebook.feed.util.event.C0484x233a295d;
import com.facebook.feed.util.event.DataSetEvents$DataSetUpdatedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents$ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents$ChangeRendererEventSubscriber;
import com.facebook.feed.util.event.HideEvents$StoryVisibilityEvent;
import com.facebook.feed.util.event.PeopleYouMayKnowEvents$BlacklistPeopleYouMayKnowItemEvent;
import com.facebook.feed.util.event.StoryEvents$FeedUnitMutatedEvent;
import com.facebook.feed.util.event.StoryEvents$FeedUnitMutatedEventSubscriber;
import com.facebook.feed.util.event.StoryEvents$FeedUnitSubscribeEvent;
import com.facebook.feed.util.event.StoryEvents$FeedUnitSubscribeEventSubscriber;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feed.workingrange.rows.FeedRangesExperiments;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.HasFeedUnit;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.http.prefs.delaybasedqp.DelayBasedQPViewController;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.search.interfaces.GraphSearchTitleSupport;
import com.facebook.sentry.SentryUtil;
import com.facebook.sentry.SentryUtil.SentryBlockTitle;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletColumnLayoutManager.ColumnWidthConfig;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ufiservices.event.UfiEvents$PageLikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents$PageLikeClickedEventSubscriber;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.player.PlayerActivityManager;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ScrollListenerWithThrottlingSupport;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnTouchDownListener;
import com.facebook.widget.listview.ScrollingViewProxyContainer;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Provider;

@Requires
@GraphSearchTitleSupport
/* compiled from: processName has null PrivateProcessName - cannot infer root module */
public class NewsFeedFragment extends BaseFeedFragment implements OnTouchListener, AnalyticsFragment, FeedUnitCacheSubscriber, FragmentWithDebugInfo, OnBackgroundForegroundCallback, ViewCreatedDestroyedCallbacks, DumpsysDumpable, AnimationCallback, Callback, SwipeRefreshController.Callback, TailLoaderController.Callback, AdapterCreatedCallback, ConnectivityChangedCallback, OnDrawListener, ScrollableListContainer, OnScrollListener, ScrollingViewProxyContainer, ScrollCallback {
    private static final Class<?> f9002b = NewsFeedFragment.class;
    private static final int f9003c = 2131233363;
    private static final int f9004d = 2131233365;
    @Inject
    volatile Provider<ScrollAwayComposerController> f9005a = UltralightRuntime.f367a;
    @Inject
    private QuickExperimentController aA;
    @CrossFbProcessBroadcast
    @Inject
    private BaseFbBroadcastManager aB;
    @Inject
    private LongClickTracker aC;
    @Inject
    private AbstractFbErrorReporter aD;
    @Inject
    public FeedEventBus aE;
    @Inject
    public FeedStoryMutator aF;
    @Inject
    private FbEventSubscriberListManager aG;
    @Inject
    private DefaultBlueServiceOperationFactory aH;
    @Inject
    private StartupPerfLogger aI;
    @Inject
    private ViewBasedLoggingHandler aJ;
    @Inject
    private ViewportLoggingHandler aK;
    @Inject
    private VideoPlayerManager aL;
    @Inject
    private PlayerActivityManager aM;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FeedDebugWriter> aN = UltralightRuntime.f368b;
    @Inject
    private FbSharedPreferences aO;
    @Inject
    private ComposerActivityReceiver aP;
    @Inject
    @LoggedInUser
    private Provider<User> aQ;
    @Inject
    @ForNewsfeed
    private FeedLifecycleSubscribers aR;
    @Inject
    private FeedPillUIController aS;
    @Inject
    private FeedMoreStoriesPillUIController aT;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DelayBasedQPViewController> aU = UltralightRuntime.f368b;
    @Inject
    private Provider<HomeStoriesViewController> aV;
    @Inject
    private Provider<FreshFeedDebugViewController> aW;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DumpsysDumper> aX = UltralightRuntime.f368b;
    @Inject
    private FeedUnitImpressionLoggerController aY;
    @Inject
    private FeedReturnDetector aZ;
    public NewsFeedRecyclerViewAdapterWrapper al;
    private CustomFrameLayout am;
    private OnScrollListener an;
    public boolean ao = false;
    public View ap;
    public View aq;
    private ViewGroup ar;
    private HomeStoriesViewController as;
    public FeedType at;
    private boolean au;
    private NewsFeedListViewAnimations av;
    public boolean aw = false;
    private TouchDelayLogger ax;
    @Inject
    private AnalyticsTagger ay;
    @Inject
    public Clock az;
    @Inject
    private NewsFeedDispatcherFactory bA;
    @Inject
    private DefaultAndroidThreadUtil bB;
    @Inject
    private StoryRankingTimeTracker bC;
    public FeedPerfLogger bD;
    public NewsFeedControllerCallbacksDispatcher bE;
    public NewsFeedFragmentDataController bF;
    public final Handler bG = new Handler(Looper.getMainLooper());
    public final Runnable bH = new C04011(this);
    @Inject
    public FeedDataLoaderHelper ba;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<StoryMutationHelper> bb = UltralightRuntime.f368b;
    @Inject
    private FeedLeavingLogger bc;
    @Inject
    private TouchDelayLoggerProvider bd;
    @Inject
    private TabletExperimentConfiguration be;
    @Inject
    private TabletColumnLayoutManager bf;
    @Inject
    public QeAccessor bg;
    @Inject
    private XOutPlaceReviewItemEventSubscriberProvider bh;
    @Inject
    private QuickPerformanceLogger bi;
    @Inject
    private SetNotifyMeSubscriber bj;
    @Inject
    private SecureContextHelper bk;
    @Inject
    private AppStartupTracker bl;
    @Inject
    public FeedUnitCache bm;
    @Inject
    public FeedUnitSubscriber bn;
    @Inject
    private ErrorMessageGenerator bo;
    @Inject
    private ErrorDialogs bp;
    @Inject
    private Resources bq;
    @Inject
    private Toaster br;
    @Inject
    private Provider<FirstLaunchTracker> bs;
    @Inject
    public Provider<InterstitialStartHelper> bt;
    @Inject
    private StoryVisibilitySubscriberProvider bu;
    @Inject
    private ThrottledOnScrollListenerFactory bv;
    @Inject
    private TimeSinceTTI bw;
    @Inject
    private GatekeeperStoreImpl bx;
    @Inject
    private Provider<NewsFeedFragmentDataController> by;
    @Inject
    private FeedRenderUtils bz;
    public int f9006e = -1;
    public int f9007f = -1;
    public int f9008g = -1;
    public NewsFeedViewController f9009h;
    public NewsFeedRecyclerViewProxy f9010i;

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    public class Builder implements Parcelable {
        public static final Creator<Builder> CREATOR = new C04001();
        public FeedType f8999a;
        public String f9000b;
        public boolean f9001c = true;

        /* compiled from: processName has null PrivateProcessName - cannot infer root module */
        final class C04001 implements Creator<Builder> {
            C04001() {
            }

            public final Object createFromParcel(Parcel parcel) {
                boolean z;
                Builder builder = new Builder();
                builder.f8999a = (FeedType) parcel.readParcelable(Builder.class.getClassLoader());
                Builder builder2 = builder;
                builder2.f9000b = parcel.readString();
                builder = builder2;
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                builder.f9001c = z;
                return builder;
            }

            public final Object[] newArray(int i) {
                return new Builder[i];
            }
        }

        public final NewsFeedFragment m13850d() {
            Preconditions.checkNotNull(this.f8999a);
            Fragment newsFeedFragment = new NewsFeedFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("feed_type", this.f8999a);
            if (this.f9000b != null) {
                bundle.putString("list_name", this.f9000b);
            }
            bundle.putBoolean("should_update_title_bar", this.f9001c);
            newsFeedFragment.m271g(bundle);
            return newsFeedFragment;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f8999a, i);
            parcel.writeString(this.f9000b);
            parcel.writeInt(this.f9001c ? 1 : 0);
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class C04011 implements Runnable {
        final /* synthetic */ NewsFeedFragment f9019a;

        C04011(NewsFeedFragment newsFeedFragment) {
            this.f9019a = newsFeedFragment;
        }

        public void run() {
            if (!this.f9019a.hn_()) {
                return;
            }
            if (this.f9019a.f9010i.mo2399n()) {
                NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.f9019a.bE;
                if (newsFeedControllerCallbacksDispatcher.f11153G != null) {
                    ViewportMonitorFragmentController viewportMonitorFragmentController = newsFeedControllerCallbacksDispatcher.f11153G;
                    viewportMonitorFragmentController.f10052a.m15152a(true, viewportMonitorFragmentController.f10056e.mo1997n());
                }
                NewsFeedFragmentDataController newsFeedFragmentDataController = this.f9019a.bF;
                if (newsFeedFragmentDataController.f11508c.m9686d()) {
                    newsFeedFragmentDataController.f11508c.m9693i();
                    newsFeedFragmentDataController.m16847u();
                }
                return;
            }
            this.f9019a.aB();
            this.f9019a.f9010i.mo2382e(0);
            HandlerDetour.b(this.f9019a.bG, this.f9019a.bH, 200, -1629249948);
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class PageLikeClickSubscriber extends UfiEvents$PageLikeClickedEventSubscriber {
        final /* synthetic */ NewsFeedFragment f11615a;
        private final MutationCallback<FeedUnit> f11616b = new C04831(this);

        /* compiled from: processName has null PrivateProcessName - cannot infer root module */
        class C04831 implements MutationCallback<FeedUnit> {
            final /* synthetic */ PageLikeClickSubscriber f11617a;

            C04831(PageLikeClickSubscriber pageLikeClickSubscriber) {
                this.f11617a = pageLikeClickSubscriber;
            }

            public final void mo2181a(Object obj) {
                this.f11617a.f11615a.aE.mo651a(new StoryEvents$FeedUnitMutatedEvent((FeedUnit) obj));
            }

            public final void mo2182a(Object obj, ServiceException serviceException) {
                this.f11617a.f11615a.aE.mo651a(new StoryEvents$FeedUnitMutatedEvent((FeedUnit) obj));
            }

            public final /* bridge */ /* synthetic */ void mo2183b(Object obj) {
            }

            public final /* bridge */ /* synthetic */ void mo2184c(Object obj) {
            }
        }

        public PageLikeClickSubscriber(NewsFeedFragment newsFeedFragment) {
            this.f11615a = newsFeedFragment;
        }

        public final void mo650b(FbEvent fbEvent) {
            UfiEvents$PageLikeClickedEvent ufiEvents$PageLikeClickedEvent = (UfiEvents$PageLikeClickedEvent) fbEvent;
            FeedProps feedProps = ufiEvents$PageLikeClickedEvent.f11641a;
            if (feedProps.f13444a instanceof GraphQLStorySet) {
                feedProps = feedProps.m19803a(StorySetHelper.a((GraphQLStorySet) feedProps.f13444a));
            }
            if (feedProps.f13444a instanceof GraphQLStory) {
                ((StoryMutationHelper) this.f11615a.bb.get()).m14531a(ufiEvents$PageLikeClickedEvent.f11642b, feedProps, "newsfeed_page_like", "native_newsfeed", "newsfeed_ufi", ufiEvents$PageLikeClickedEvent.f11644d, false, this.f11616b);
            }
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class ChangeRendererEventSubscriber extends HideEvents$ChangeRendererEventSubscriber {
        final /* synthetic */ NewsFeedFragment f11621a;

        public ChangeRendererEventSubscriber(NewsFeedFragment newsFeedFragment) {
            this.f11621a = newsFeedFragment;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f11621a.m13875a(true);
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class FeedUnitMutatedEventSubscriber extends StoryEvents$FeedUnitMutatedEventSubscriber {
        final /* synthetic */ NewsFeedFragment f11622a;

        public FeedUnitMutatedEventSubscriber(NewsFeedFragment newsFeedFragment) {
            this.f11622a = newsFeedFragment;
        }

        public final void mo650b(FbEvent fbEvent) {
            this.f11622a.ay().mo1379a(((StoryEvents$FeedUnitMutatedEvent) fbEvent).f11651a);
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class FeedUnitSubscribeEventSubscriber extends StoryEvents$FeedUnitSubscribeEventSubscriber {
        final /* synthetic */ NewsFeedFragment f11623a;

        public FeedUnitSubscribeEventSubscriber(NewsFeedFragment newsFeedFragment) {
            this.f11623a = newsFeedFragment;
        }

        public final void mo650b(FbEvent fbEvent) {
            StoryEvents$FeedUnitSubscribeEvent storyEvents$FeedUnitSubscribeEvent = (StoryEvents$FeedUnitSubscribeEvent) fbEvent;
            if (storyEvents$FeedUnitSubscribeEvent.f11652a instanceof GraphQLStory) {
                GraphQLFeedUnitEdge c = this.f11623a.ax().m9683c(((GraphQLStory) storyEvents$FeedUnitSubscribeEvent.f11652a).m22350c());
                if (c != null) {
                    this.f11623a.bn.m14619a(ImmutableList.of(c));
                    return;
                }
                return;
            }
            this.f11623a.bm.m10569c(storyEvents$FeedUnitSubscribeEvent.f11652a);
            this.f11623a.bn.m14619a(this.f11623a.ax().m9669a(storyEvents$FeedUnitSubscribeEvent.f11652a.mo2507g()));
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class BlacklistPeopleYouMayKnowItemEventSubscriber extends C0484x233a295d {
        final /* synthetic */ NewsFeedFragment f11624a;

        public BlacklistPeopleYouMayKnowItemEventSubscriber(NewsFeedFragment newsFeedFragment) {
            this.f11624a = newsFeedFragment;
        }

        public final void mo650b(FbEvent fbEvent) {
            PeopleYouMayKnowEvents$BlacklistPeopleYouMayKnowItemEvent peopleYouMayKnowEvents$BlacklistPeopleYouMayKnowItemEvent = (PeopleYouMayKnowEvents$BlacklistPeopleYouMayKnowItemEvent) fbEvent;
            for (GraphQLFeedUnitEdge c : this.f11624a.ax().m9669a(peopleYouMayKnowEvents$BlacklistPeopleYouMayKnowItemEvent.f11653a)) {
                FeedUnit c2 = c.mo2540c();
                if (c2 instanceof PeopleYouMayKnowFeedUnit) {
                    c2 = this.f11624a.aF.m10616a((PeopleYouMayKnowFeedUnit) c2, peopleYouMayKnowEvents$BlacklistPeopleYouMayKnowItemEvent.f11654b);
                    this.f11624a.aE.mo651a(new StoryEvents$FeedUnitMutatedEvent(c2));
                    this.f11624a.aE.mo651a(new StoryEvents$FeedUnitSubscribeEvent(c2));
                }
            }
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class C04852 implements Listener {
        final /* synthetic */ NewsFeedFragment f11660a;

        C04852(NewsFeedFragment newsFeedFragment) {
            this.f11660a = newsFeedFragment;
        }

        public final boolean mo1936a(long j, GraphQLStory graphQLStory) {
            return this.f11660a.ba.m14502a(this.f11660a.at, j, graphQLStory);
        }

        public final void mo1935a(GraphQLStory graphQLStory) {
            if (this.f11660a.aE()) {
                NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.f11660a.bE;
                if (newsFeedControllerCallbacksDispatcher.f11187o != null) {
                    newsFeedControllerCallbacksDispatcher.f11187o.f9751a.m14780a(BlockingCause.IS_POSTING);
                }
                ListViewState aA = this.f11660a.aA();
                this.f11660a.ay().mo1379a((FeedUnit) graphQLStory);
                this.f11660a.m13869a(aA);
                if (graphQLStory.m22326L() == null) {
                    this.f11660a.gB_();
                }
            }
        }

        public final void mo1938b(GraphQLStory graphQLStory) {
            NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.f11660a.bE;
            if (newsFeedControllerCallbacksDispatcher.f11187o != null) {
                newsFeedControllerCallbacksDispatcher.f11187o.f9751a.m14784b(BlockingCause.IS_POSTING);
            }
            FetchTimeMsHelper.m22313a(graphQLStory, this.f11660a.az.mo211a());
            this.f11660a.ay().mo1379a((FeedUnit) graphQLStory);
            this.f11660a.bn.m14619a(this.f11660a.ax().f5628d.m9713a());
        }

        public final void mo1934a() {
            NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.f11660a.bE;
            if (newsFeedControllerCallbacksDispatcher.f11187o != null) {
                newsFeedControllerCallbacksDispatcher.f11187o.f9751a.m14784b(BlockingCause.IS_POSTING);
            }
            if (this.f11660a.bF.ai) {
                this.f11660a.mo1901e();
            }
        }

        public final void mo1937b() {
            this.f11660a.mo1901e();
            NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.f11660a.bE;
            if (newsFeedControllerCallbacksDispatcher.f11187o != null) {
                newsFeedControllerCallbacksDispatcher.f11187o.f9751a.m14784b(BlockingCause.IS_POSTING);
            }
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class FeedScrollListener implements ScrollListenerWithThrottlingSupport {
        final /* synthetic */ NewsFeedFragment f11667a;

        public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            TracerDetour.a("NewsFeedFragment.FeedScrollListener.onScroll", 1462000115);
            try {
                if (!this.f11667a.ao && i > 1) {
                    this.f11667a.aE.mo651a(new FirstFeedScrollEvent());
                    this.f11667a.ao = true;
                }
                if (!(FeedRangesExperiments.m19961b(this.f11667a.bg) || (this.f11667a.f9006e == i && this.f11667a.f9007f == i + i2 && this.f11667a.f9008g == i3))) {
                    this.f11667a.f9006e = i;
                    this.f11667a.f9007f = i + i2;
                    this.f11667a.f9008g = i3;
                    TracerDetour.a("NewsFeedFragment.removeFeedUnitIfHidden", -1958082244);
                    try {
                        NewsFeedFragment.m13857b(this.f11667a, scrollingViewProxy, this.f11667a.f9006e - 1);
                        int i4 = this.f11667a;
                        NewsFeedFragment.m13857b(i4, scrollingViewProxy, this.f11667a.f9007f);
                        TracerDetour.a(i4);
                    } finally {
                        TracerDetour.a(1282686430);
                    }
                }
                this.f11667a.bF.m16831a(scrollingViewProxy);
            } finally {
                TracerDetour.a(1461601964);
            }
        }

        public FeedScrollListener(NewsFeedFragment newsFeedFragment) {
            this.f11667a = newsFeedFragment;
        }

        public final int mo1974a() {
            return this.f11667a.bg.mo572a(ExperimentsForNewsFeedAbTestModule.ac, -1);
        }

        public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class C05613 implements OnTouchDownListener {
        final /* synthetic */ NewsFeedFragment f13800a;

        C05613(NewsFeedFragment newsFeedFragment) {
            this.f13800a = newsFeedFragment;
        }

        public final void mo2672a(ScrollingViewProxy scrollingViewProxy) {
            NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.f13800a.bE;
            if (newsFeedControllerCallbacksDispatcher.f11187o != null) {
                newsFeedControllerCallbacksDispatcher.f11187o.f9751a.m14782a(true);
            }
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    public class C05634 {
        public final /* synthetic */ NewsFeedFragment f13807a;

        C05634(NewsFeedFragment newsFeedFragment) {
            this.f13807a = newsFeedFragment;
        }
    }

    /* compiled from: processName has null PrivateProcessName - cannot infer root module */
    class C05685 implements OnClickListener {
        final /* synthetic */ NewsFeedFragment f13836a;

        C05685(NewsFeedFragment newsFeedFragment) {
            this.f13836a = newsFeedFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1934104756);
            this.f13836a.aB();
            this.f13836a.bF.m16845r();
            Logger.a(2, EntryType.UI_INPUT_END, 1786010483, a);
        }
    }

    private CustomFrameLayout m13852a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        TracerDetour.a("NewsFeedFragment.inflateNewsFeed", 164170170);
        try {
            String a = this.bD.m3344a("FragmentViewInflate", aF());
            int d = this.bD.m3360d(aF());
            this.aI.m3458h(d, a);
            CustomFrameLayout customFrameLayout = (CustomFrameLayout) layoutInflater.inflate(((ScrollAwayComposerController) this.f9005a.get()).m15504a() ? 2130904428 : 2130904424, viewGroup, false);
            this.aI.m3459i(d, a);
            return customFrameLayout;
        } finally {
            TracerDetour.a(-602354967);
        }
    }

    private static <T extends InjectableComponentWithContext> void m13853a(Class<T> cls, T t) {
        m13854a((Object) t, t.getContext());
    }

    private static void m13854a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NewsFeedFragment) obj).m13855a(IdBasedProvider.m1811a(injectorLike, 1396), AnalyticsTagger.m11473a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), QuickExperimentControllerImpl.m10166a(injectorLike), CrossProcessFbBroadcastManager.m3644a(injectorLike), LongClickTracker.m14087a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FeedEventBus.m4573a(injectorLike), FeedStoryMutator.m10578a(injectorLike), FbEventSubscriberListManager.m14130a(injectorLike), DefaultBlueServiceOperationFactory.m3780a(injectorLike), StartupPerfLogger.m3406a(injectorLike), ViewBasedLoggingHandler.m14137a(injectorLike), ViewportLoggingHandler.m14224a(injectorLike), VideoPlayerManager.m13903a(injectorLike), PlayerActivityManager.m12995a(injectorLike), IdBasedLazy.m1808a(injectorLike, 5851), FbSharedPreferencesImpl.m1826a(injectorLike), ComposerActivityReceiver.m14421a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3595), MultiRowFeedLifecycleSubscribers.m14463a(injectorLike), FeedPillUIController.m14467a(injectorLike), FeedMoreStoriesPillUIController.m14485a(injectorLike), IdBasedLazy.m1808a(injectorLike, 7204), IdBasedProvider.m1811a(injectorLike, 5455), IdBasedProvider.m1811a(injectorLike, 1373), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5454), FeedUnitImpressionLoggerController.m14182a(injectorLike), FeedReturnDetector.m14488a(injectorLike), FeedDataLoaderHelper.m14500a(injectorLike), IdBasedLazy.m1808a(injectorLike, 986), FeedLeavingLogger.m14504a(injectorLike), (TouchDelayLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TouchDelayLoggerProvider.class), TabletExperimentConfiguration.m7856a(injectorLike), TabletColumnLayoutManager.m8710a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (XOutPlaceReviewItemEventSubscriberProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(XOutPlaceReviewItemEventSubscriberProvider.class), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), SetNotifyMeSubscriber.m14511a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), AppStartupTracker.m9073a(injectorLike), FeedUnitCache.m10541a(injectorLike), FeedUnitSubscriber.m14610a(injectorLike), ErrorMessageGenerator.m14516a(injectorLike), ErrorDialogs.m14522a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), Toaster.m6449a(injectorLike), IdBasedProvider.m1811a(injectorLike, 1339), IdBasedProvider.m1811a(injectorLike, 2352), (StoryVisibilitySubscriberProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StoryVisibilitySubscriberProvider.class), ThrottledOnScrollListenerFactory.m14478a(injectorLike), TimeSinceTTI.m14650a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), IdBasedProvider.m1811a(injectorLike, 1342), FeedRenderUtils.m14652a(injectorLike), NewsFeedDispatcherFactory.m14659a(injectorLike), DefaultAndroidThreadUtil.m1645a(injectorLike), StoryRankingTimeTracker.m15516a(injectorLike));
    }

    public final void m13869a(ListViewState listViewState) {
        TracerDetour.a("NewsFeedFragment.restoreListViewState", 625342704);
        try {
            if (this.f9010i != null) {
                int a = listViewState.m25155a().mo2993a();
                if (a >= 0) {
                    this.f9010i.mo2378d(a, listViewState.m25156b());
                }
                TracerDetour.a(1964935760);
            }
        } finally {
            TracerDetour.a(951873616);
        }
    }

    public final void mo1888a(DumpsysContext dumpsysContext) {
        dumpsysContext.f.a(this.al, dumpsysContext);
    }

    private void m13855a(Provider<ScrollAwayComposerController> provider, AnalyticsTagger analyticsTagger, Clock clock, QuickExperimentController quickExperimentController, FbBroadcastManager fbBroadcastManager, LongClickTracker longClickTracker, FbErrorReporter fbErrorReporter, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, FbEventSubscriberListManager fbEventSubscriberListManager, BlueServiceOperationFactory blueServiceOperationFactory, StartupPerfLogger startupPerfLogger, ViewBasedLoggingHandler viewBasedLoggingHandler, ViewportLoggingHandler viewportLoggingHandler, VideoPlayerManager videoPlayerManager, PlayerActivityManager playerActivityManager, com.facebook.inject.Lazy<FeedDebugWriter> lazy, FbSharedPreferences fbSharedPreferences, ComposerActivityReceiver composerActivityReceiver, Provider<User> provider2, FeedLifecycleSubscribers feedLifecycleSubscribers, FeedPillUIController feedPillUIController, FeedMoreStoriesPillUIController feedMoreStoriesPillUIController, com.facebook.inject.Lazy<DelayBasedQPViewController> lazy2, Provider<HomeStoriesViewController> provider3, Provider<FreshFeedDebugViewController> provider4, com.facebook.inject.Lazy<DumpsysDumper> lazy3, FeedUnitImpressionLoggerController feedUnitImpressionLoggerController, FeedReturnDetector feedReturnDetector, FeedDataLoaderHelper feedDataLoaderHelper, com.facebook.inject.Lazy<StoryMutationHelper> lazy4, FeedLeavingLogger feedLeavingLogger, TouchDelayLoggerProvider touchDelayLoggerProvider, TabletExperimentConfiguration tabletExperimentConfiguration, TabletColumnLayoutManager tabletColumnLayoutManager, QeAccessor qeAccessor, XOutPlaceReviewItemEventSubscriberProvider xOutPlaceReviewItemEventSubscriberProvider, QuickPerformanceLogger quickPerformanceLogger, SetNotifyMeSubscriber setNotifyMeSubscriber, SecureContextHelper secureContextHelper, AppStartupTracker appStartupTracker, FeedUnitCache feedUnitCache, FeedUnitSubscriber feedUnitSubscriber, ErrorMessageGenerator errorMessageGenerator, ErrorDialogs errorDialogs, Resources resources, Toaster toaster, Provider<FirstLaunchTracker> provider5, Provider<InterstitialStartHelper> provider6, StoryVisibilitySubscriberProvider storyVisibilitySubscriberProvider, ThrottledOnScrollListenerFactory throttledOnScrollListenerFactory, TimeSinceTTI timeSinceTTI, GatekeeperStore gatekeeperStore, Provider<NewsFeedFragmentDataController> provider7, FeedRenderUtils feedRenderUtils, NewsFeedDispatcherFactory newsFeedDispatcherFactory, AndroidThreadUtil androidThreadUtil, StoryRankingTimeTracker storyRankingTimeTracker) {
        this.f9005a = provider;
        this.ay = analyticsTagger;
        this.az = clock;
        this.aA = quickExperimentController;
        this.aB = fbBroadcastManager;
        this.aC = longClickTracker;
        this.aD = fbErrorReporter;
        this.aE = feedEventBus;
        this.aF = feedStoryMutator;
        this.aG = fbEventSubscriberListManager;
        this.aH = blueServiceOperationFactory;
        this.aI = startupPerfLogger;
        this.aJ = viewBasedLoggingHandler;
        this.aK = viewportLoggingHandler;
        this.aL = videoPlayerManager;
        this.aM = playerActivityManager;
        this.aN = lazy;
        this.aO = fbSharedPreferences;
        this.aP = composerActivityReceiver;
        this.aQ = provider2;
        this.aR = feedLifecycleSubscribers;
        this.aS = feedPillUIController;
        this.aT = feedMoreStoriesPillUIController;
        this.aU = lazy2;
        this.aV = provider3;
        this.aW = provider4;
        this.aX = lazy3;
        this.aY = feedUnitImpressionLoggerController;
        this.aZ = feedReturnDetector;
        this.ba = feedDataLoaderHelper;
        this.bb = lazy4;
        this.bc = feedLeavingLogger;
        this.bd = touchDelayLoggerProvider;
        this.be = tabletExperimentConfiguration;
        this.bf = tabletColumnLayoutManager;
        this.bg = qeAccessor;
        this.bh = xOutPlaceReviewItemEventSubscriberProvider;
        this.bi = quickPerformanceLogger;
        this.bj = setNotifyMeSubscriber;
        this.bk = secureContextHelper;
        this.bl = appStartupTracker;
        this.bm = feedUnitCache;
        this.bn = feedUnitSubscriber;
        this.bo = errorMessageGenerator;
        this.bp = errorDialogs;
        this.bq = resources;
        this.br = toaster;
        this.bs = provider5;
        this.bt = provider6;
        this.bu = storyVisibilitySubscriberProvider;
        this.bv = throttledOnScrollListenerFactory;
        this.bw = timeSinceTTI;
        this.bx = gatekeeperStore;
        this.by = provider7;
        this.bz = feedRenderUtils;
        this.bA = newsFeedDispatcherFactory;
        this.bB = androidThreadUtil;
        this.bC = storyRankingTimeTracker;
    }

    public final void mo20e(Bundle bundle) {
        super.mo20e(bundle);
        bundle.putParcelable("feed_type", this.at);
        this.bF.m16825a(bundle);
    }

    private FeedType aF() {
        if (this.at == null && this.f131s != null) {
            this.at = (FeedType) this.f131s.getParcelable("feed_type");
        }
        return this.at != null ? this.at : FeedType.f5039b;
    }

    public final void mo1859c(@Nullable Bundle bundle) {
        aL();
        super.mo1859c(bundle);
        TracerDetour.a("NewsfeedFragment.injectMe", -1695003731);
        try {
            m13853a(NewsFeedFragment.class, (InjectableComponentWithContext) this);
            Holder holder = new Holder();
            Holder holder2 = new Holder();
            this.bE = this.bA.m14662a(this, this.bC, holder, holder2, aF());
            this.bE.m16481a((Fragment) this, bundle);
            if (this.bF == null) {
                this.bF = (NewsFeedFragmentDataController) this.by.get();
            }
            this.bF.m16828a(this, this, aF(), this.bn, this.aE, this.bC, getContext(), bundle, this.bE);
            holder.m15525a(ay());
            holder2.m15525a(ax());
            this.bm.m10555a((FeedUnitCacheSubscriber) this);
            this.bF.m16843n();
            this.aG.m14133a(this.bj);
            this.aG.m14133a(new PageLikeClickSubscriber(this));
            this.aG.m14133a(this.bu.m14649a(ay()));
            this.aG.m14133a(new ChangeRendererEventSubscriber(this));
            this.aG.m14133a(new FeedUnitMutatedEventSubscriber(this));
            this.aG.m14133a(new FeedUnitSubscribeEventSubscriber(this));
            this.aG.m14133a(new BlacklistPeopleYouMayKnowItemEventSubscriber(this));
            this.aG.m14133a(new BlacklistPageYouMayLikeItemEventSubscriber(this, this.aE, this.aF));
            this.aG.m14133a(this.bh.m14510a(this));
            this.aG.m14131a(this.aE);
            this.bj.m14512a(ay());
            ComponentName componentName = new ComponentName(getContext(), MusicBroadcastReceiver.class);
            PackageManager packageManager = getContext().getPackageManager();
            if (this.bg.mo596a(ExperimentsForFeedUtilComposerAbtestModule.f11333G, false) && packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
            aG();
            this.ax = this.bd.m14509a("news_feed_touch");
            this.an = m13864a(new FeedScrollListener(this));
        } finally {
            TracerDetour.a(460691689);
        }
    }

    public final OnScrollListener m13864a(OnScrollListener onScrollListener) {
        return this.bv.m14481b(onScrollListener);
    }

    private void aG() {
        this.aP.m14430a(new C04852(this), ax().f5628d);
    }

    public final void mo1891a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo1891a(str, fileDescriptor, printWriter, strArr);
        if (this.al != null) {
            mo1888a(new DumpsysContext(str, fileDescriptor, printWriter, strArr, (DumpsysDumper) this.aX.get()));
        }
    }

    public final boolean gD_() {
        FeedUnitCollection ax = ax();
        TimeSinceTTI timeSinceTTI = this.bw;
        if (timeSinceTTI.f9597a == 0) {
            timeSinceTTI.f9597a = timeSinceTTI.f9598b.now();
        }
        if (this.f9010i.mo2401p() <= 0) {
            return false;
        }
        int i;
        AppStartupTracker appStartupTracker = this.bl;
        FeedType aF = aF();
        if (ax == null) {
            i = 0;
        } else {
            i = ax.mo1374a();
        }
        appStartupTracker.f5188c = false;
        if (appStartupTracker.f5186a.m3355a(aF, i)) {
            return true;
        }
        return false;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2121095774);
        super.mi_();
        NewsFeedFragmentDataController newsFeedFragmentDataController = this.bF;
        NewsFeedListViewPruner newsFeedListViewPruner = newsFeedFragmentDataController.f11511i;
        if (!newsFeedListViewPruner.f11535g.contains(newsFeedFragmentDataController)) {
            newsFeedListViewPruner.f11535g.add(newsFeedFragmentDataController);
        }
        newsFeedFragmentDataController.f11512j.f11543c = newsFeedFragmentDataController;
        newsFeedFragmentDataController.ad.mo2369b(newsFeedFragmentDataController.f11511i);
        newsFeedFragmentDataController.ad.mo2369b(newsFeedFragmentDataController.ab);
        Bundle bundle = this.f131s;
        HasTitleBar hasTitleBar = (HasTitleBar) mo817a(HasTitleBar.class);
        if (hasTitleBar != null && bundle.getBoolean("should_update_title_bar", true)) {
            if (bundle.containsKey("list_name")) {
                hasTitleBar.a_(bundle.getString("list_name"));
            } else if (FeedType.f5038a.equals(aF())) {
                hasTitleBar.y_(f9004d);
            } else {
                hasTitleBar.y_(f9003c);
            }
            hasTitleBar.kg_();
        }
        LogUtils.f(-1345782257, a);
    }

    public final String am_() {
        return this.at == null ? FeedPerfLogger.m3342x() : this.at.f5045h;
    }

    public final void aq() {
        super.aq();
        this.bn.m14622d();
        this.aJ.m14145a();
        this.aK.m14249a();
        this.aY.m14194a();
    }

    public final void mo1884G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1121517872);
        this.bj.f9528i = true;
        FeedPerfLogger feedPerfLogger = this.bD;
        feedPerfLogger.f1663C = feedPerfLogger.f1677l.now();
        super.mo1884G();
        if (this.as != null) {
            this.as.b();
        }
        this.bF.m16842i();
        this.aC.m14089a();
        new StringBuilder("Resuming NNFragment for feed ").append(aF());
        if (BuildConstants.i) {
            this.aD.mo345c("news_feed_implementation", "native_feed");
        }
        if (this.aE != null) {
            this.aG.m14131a(this.aE);
            this.aE.mo651a(new AppiraterEvents$FeedFragmentResumedEvent(ao()));
        }
        if (this.bg.mo596a(ExperimentsForHttpQeModule.al, false)) {
            DelayBasedQPViewController delayBasedQPViewController = (DelayBasedQPViewController) this.aU.get();
            Context ao = ao();
            if (delayBasedQPViewController.a == null) {
                delayBasedQPViewController.a = new TextView(ao);
                delayBasedQPViewController.a.setText("2G Empathy Enabled");
                delayBasedQPViewController.a.setTextSize(2, 8.0f);
                delayBasedQPViewController.a.setGravity(17);
                int a2 = SizeUtil.m19191a(ao, 5.0f);
                int a3 = SizeUtil.m19191a(ao, 2.0f);
                delayBasedQPViewController.a.setPadding(a2, a3, a2, a3);
                if (VERSION.SDK_INT >= 16) {
                    delayBasedQPViewController.a.setBackground(new ColorDrawable(-1));
                }
                delayBasedQPViewController.a.setTextColor(-16777216);
                ao.getWindow().addContentView(delayBasedQPViewController.a, new LayoutParams(-2, -2, 1));
            }
            delayBasedQPViewController.a(delayBasedQPViewController.b.mo286a(InternalHttpPrefKeys.f2518m, false));
        }
        if (this.aO.mo286a(DebugLoggingPrefKeys.f2810h, false)) {
            if (this.as == null) {
                this.as = (HomeStoriesViewController) this.aV.get();
            }
            this.as.a(ao());
        }
        aI();
        this.aR.mo1939a();
        this.bn.m14622d();
        this.aZ.m14493a(getClass());
        this.bD.m3351a(aF(), !ax().m9703v());
        this.f9010i.mo2367b((OnDrawListener) this);
        LogUtils.f(-1668118230, a);
    }

    private void aI() {
        User user = (User) this.aQ.get();
        if (user != null) {
            String d = user.m5840d();
            if (d != null) {
                try {
                    AttributionIdService.m20243a(getContext().getApplicationContext(), Long.parseLong(d));
                } catch (Throwable e) {
                    BLog.b(f9002b, e, "Not a UserId: %s", new Object[]{d});
                }
            }
        }
    }

    public final void mo1885H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1520852674);
        this.bj.f9528i = false;
        FeedPerfLogger feedPerfLogger = this.bD;
        FeedType aF = aF();
        feedPerfLogger.f1675j.m3460j(feedPerfLogger.m3360d(aF), feedPerfLogger.m3344a("FragmentCreate", aF));
        if (BuildConstants.i) {
            this.aD.mo337a("news_feed_implementation");
        }
        if (this.as != null) {
            HomeStoriesViewController homeStoriesViewController = this.as;
            if (homeStoriesViewController.d) {
                homeStoriesViewController.d = false;
                homeStoriesViewController.b.cancel();
                homeStoriesViewController.b = null;
            }
        }
        this.aZ.m14495b(getClass());
        if (this.aE != null) {
            this.aE.mo651a(new FeedFragmentPausedEvent());
            this.aG.m14134b(this.aE);
        }
        HandlerDetour.a(this.bG, this.bH);
        this.bn.m14621c();
        super.mo1885H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1924895319, a);
    }

    public final View mo1857a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1254977430);
        this.bD.m3359c(aF());
        if (bundle != null && bundle.containsKey("feed_type")) {
            this.at = (FeedType) bundle.getParcelable("feed_type");
        }
        this.am = m13852a(layoutInflater, viewGroup);
        View view = this.am;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1437696060, a);
        return view;
    }

    public final void mo1886a(View view) {
        this.ar = (ViewGroup) this.am.findViewById(2131562162);
        this.ap = this.am.findViewById(2131562157);
        this.aq = this.am.findViewById(2131562165);
        this.ay.m11477a(this.am, am_(), (Fragment) this);
        this.f9010i = (NewsFeedRecyclerViewProxy) this.f9009h.mo1997n();
        this.bF.ad = this.f9010i;
        aN();
        this.f9010i.mo2387f(this.am.findViewById(16908292));
        this.f9010i.mo2349a((OnTouchListener) this);
        this.f9010i.mo2358a(new C05613(this));
        if (this.bg.mo596a(ExperimentsForNewsFeedAbTestModule.f5083J, false)) {
            this.av = new NewsFeedListViewAnimations(this.f9010i, this.ap, this.aS, this.aq, this.aT, new C05634(this));
        } else {
            this.av = new NewsFeedListViewAnimations(this.f9010i, this.ap, this.aS);
        }
        this.av.f13806d = this.bE;
        this.bF.af = this.av;
        NewsFeedFragmentDataController newsFeedFragmentDataController = this.bF;
        newsFeedFragmentDataController.aa = this.am;
        if (newsFeedFragmentDataController.aj) {
            newsFeedFragmentDataController.f11507b.mo1320n();
            newsFeedFragmentDataController.f11507b.mo1294a(newsFeedFragmentDataController.al);
        }
        this.f9010i.mo2367b((OnDrawListener) this);
        if (this.bF.aj && ((FirstLaunchTracker) this.bs.get()).m20235b()) {
            ((InterstitialStartHelper) this.bt.get()).m13673a(m278o(), new InterstitialTrigger(Action.FIRST_NEWSFEED_AFTER_LOGIN));
        }
        aJ();
        this.aq.setOnClickListener(new C05694(this.bF));
        this.bD.m3354a(this.bF.aj, aF());
    }

    private void aJ() {
        if (this.bg.mo596a(ExperimentsForNewsFeedAbTestModule.ak, false)) {
            this.ap.setOnClickListener(new C08963(this.bF));
        } else {
            this.ap.setOnClickListener(new C05685(this));
        }
        this.ar.removeView(this.ap);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.ap.getLayoutParams();
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(marginLayoutParams.leftMargin, 0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        layoutParams.gravity = 1;
        this.ap.setLayoutParams(layoutParams);
        this.am.addView(this.ap);
        if (this.bF.m16846t()) {
            this.av.m20216a(true);
        }
    }

    private void aL() {
        this.bD = FeedPerfLogger.m3326a(an());
        this.bD.m3350a(aF());
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 762320296);
        super.mj_();
        NewsFeedFragmentDataController newsFeedFragmentDataController = this.bF;
        newsFeedFragmentDataController.ad.mo2374c(newsFeedFragmentDataController.f11511i);
        newsFeedFragmentDataController.ad.mo2374c(newsFeedFragmentDataController.ab);
        newsFeedFragmentDataController.f11511i.f11535g.remove(newsFeedFragmentDataController);
        newsFeedFragmentDataController.f11512j.f11543c = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 374160937, a);
    }

    public final void mo1900b(boolean z) {
        this.bF.mo1900b(z);
    }

    public final void au() {
        this.bF.au();
    }

    public final void av() {
        this.bF.av();
    }

    public final void m13866a(FetchFeedCause fetchFeedCause) {
        this.bF.m16836b(fetchFeedCause);
    }

    public final void aw() {
        this.bF.aw();
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.al = (NewsFeedRecyclerViewAdapterWrapper) hasMultiRow;
        this.bF.m16829a(this.al);
    }

    public final void kF_() {
        this.al = null;
        this.bF.m16829a(null);
    }

    public final ScrollingViewProxy mo1909n() {
        return this.f9010i;
    }

    @Nullable
    public final FeedUnitCollection ax() {
        if (this.bF == null) {
            return null;
        }
        return this.bF.f11508c;
    }

    public final LegacyFeedUnitUpdater ay() {
        return ax().f5627a;
    }

    public final void mo1899b(View view) {
        if (view != this.aT.f9497b) {
            this.aT.m14486c();
        } else if (view != this.aS.f9475g) {
            this.aS.m14476d();
        }
    }

    public final void kG_() {
        if (this.f9010i != null) {
            this.f9010i.mo2387f(null);
            HandlerDetour.a(this.bG, this.bH);
        }
        this.bc.m14508a(ax(), this.f9010i.m18035D(), true);
        this.bF.m16840g();
        super.mY_();
        this.bF.m16825a(null);
        this.aS.m14477e();
        this.aT.m14487d();
        if (this.f9010i != null) {
            try {
                this.f9010i.mo2339a(null);
                this.f9010i.mo2409x();
                this.f9010i.mo2410y();
            } catch (Throwable e) {
                if (this.aL != null) {
                    this.aD.mo345c("feed_adapter_video_state", this.aL.m13934b());
                }
                this.aD.m2346a("feed_adapter_exception", e);
                throw e;
            }
        }
        this.f9010i = null;
        this.am.findViewById(2131562157).setOnClickListener(null);
        this.av = null;
        this.am = null;
    }

    public final void mo1856I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1372560337);
        FeedUnitCacheSubscriber feedUnitCacheSubscriber = this.bF;
        feedUnitCacheSubscriber.f11515m.m4411a(NewsFeedFragmentDataController.f11478f.toString(), Event.RELEASED_LOADER, feedUnitCacheSubscriber.f11507b.mo1312a());
        feedUnitCacheSubscriber.f11518p.m10566b(feedUnitCacheSubscriber);
        FeedDataLoaderFactory feedDataLoaderFactory = feedUnitCacheSubscriber.f11513k;
        IFeedDataLoader iFeedDataLoader = feedUnitCacheSubscriber.f11507b;
        iFeedDataLoader.mo1295b();
        if (!Objects.equal(iFeedDataLoader.mo1318l(), feedDataLoaderFactory.f5029d.m4200a())) {
            iFeedDataLoader.mo1317j();
        }
        feedUnitCacheSubscriber.f11507b.mo1297b(feedUnitCacheSubscriber);
        feedUnitCacheSubscriber.f11507b.mo1316i();
        feedUnitCacheSubscriber.f11507b.mo1292a(null);
        feedUnitCacheSubscriber.f11506Z.f10423f = null;
        this.bn.m14617a();
        this.bn.m14623e();
        if (this.aP != null) {
            this.aP.mo1933b();
        }
        this.bm.m10566b((FeedUnitCacheSubscriber) this);
        super.mo1856I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1295565844, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (aE()) {
            aN();
        }
    }

    private void aN() {
        if (this.be.m7858a()) {
            ColumnWidthConfig b = this.bf.m8718b(FragmentConstants$ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT);
            this.f9010i.ix_().setPadding(b.f7374c, this.f9010i.mo2388g(), b.f7375d, this.f9010i.mo2385f());
        }
    }

    @Deprecated
    public final void m13875a(boolean z) {
        if (z && this.al != null && this.f9010i != null) {
            TracerDetour.a("NewsfeedFragment.updateFeedView", -649407867);
            try {
                ListViewState aA = aA();
                this.bi.mo462b(655438);
                TracerDetour.a("NewsfeedFragment.onFeedAdapterDataChanged", -1881072936);
                int i;
                try {
                    i = this.al;
                    i.notifyDataSetChanged();
                    TracerDetour.a(i);
                    this.bi.mo468b(655438, (short) 2);
                    m13869a(aA);
                } finally {
                    i = 1933419057;
                    TracerDetour.a(1933419057);
                    this.bi.mo468b(655438, (short) 2);
                }
            } finally {
                TracerDetour.a(-1936379509);
            }
        }
    }

    public final void mo1901e() {
        this.bF.m16836b(FetchFeedCause.AUTO_REFRESH);
    }

    public final ListViewState aA() {
        int i = 0;
        int E = this.f9010i.m18036E();
        if (E == -1) {
            return ListViewState.f17921a;
        }
        Marker b = this.al.mo2509b(E);
        View f = this.f9010i.mo2386f(0);
        if (f != null) {
            i = f.getTop();
        }
        return new ListViewState(b, i);
    }

    public final void mo1860g(boolean z) {
        super.mo1860g(z);
        if (!(!this.au || z || this.f9010i == null)) {
            this.bc.m14508a(ax(), this.f9010i.m18035D(), false);
        }
        this.au = z;
        if (this.bF != null && !z) {
            NewsFeedFragmentDataController newsFeedFragmentDataController = this.bF;
            if (newsFeedFragmentDataController.ae != null) {
                newsFeedFragmentDataController.ae.b();
            }
        }
    }

    public static void m13857b(NewsFeedFragment newsFeedFragment, ScrollingViewProxy scrollingViewProxy, int i) {
        if (i >= 0 && i < scrollingViewProxy.mo2404s()) {
            Object g = scrollingViewProxy.mo2389g(i);
            if (g instanceof HasFeedUnit) {
                FeedUnitCommon c = ((HasFeedUnit) g).mo2540c();
                if ((c instanceof HideableUnit) && ((HideableUnit) c).mo2879o() == StoryVisibility.HIDDEN && newsFeedFragment.aE != null) {
                    newsFeedFragment.aE.mo651a(new HideEvents$StoryVisibilityEvent(c.mo2507g(), null, null, StoryVisibility.GONE, 1));
                    newsFeedFragment.aE.mo651a(new HideEvents$ChangeRendererEvent());
                }
            }
        }
    }

    protected final void ar() {
        if (this.bn != null) {
            this.bn.m14622d();
        }
    }

    protected final void as() {
        if (this.bn != null) {
            this.bn.m14621c();
        }
    }

    public Map<String, String> getDebugInfo() {
        return ((FeedDebugWriter) this.aN.get()).a(this.f9006e, this.f9007f, this.al, aF());
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchDelayLogger touchDelayLogger = this.ax;
        int i = touchDelayLogger.f11666f;
        touchDelayLogger.f11666f = motionEvent.getAction();
        if (motionEvent.getAction() == 2 && i == 1 && touchDelayLogger.f11662b.m3563a("feed_touch_perf") && touchDelayLogger.f11665e.nextInt(10000) == 0) {
            ExecutorDetour.a(touchDelayLogger.f11661a, new TouchDelayRunnable(touchDelayLogger, SystemClock.uptimeMillis() - motionEvent.getEventTime()), 1707368138);
        }
        HandlerDetour.a(this.bG, this.bH);
        return false;
    }

    public final void aB() {
        this.aM.m12998a(EventTriggerType.BY_MANAGER);
        NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = this.bE;
        if (newsFeedControllerCallbacksDispatcher.f11153G != null) {
            ViewportMonitorFragmentController viewportMonitorFragmentController = newsFeedControllerCallbacksDispatcher.f11153G;
            viewportMonitorFragmentController.f10052a.m15152a(false, viewportMonitorFragmentController.f10056e.mo1997n());
        }
    }

    public final void gB_() {
        this.bB.m1654a("scrollToTop should be called on the UI thread");
        FeedUnitCollection ax = ax();
        if (!(ax == null || ax.m9690f())) {
            ax().m9692h();
        }
        if (aE()) {
            if (this.bg.mo596a(ExperimentsForNewsFeedAbTestModule.ak, false)) {
                aB();
            }
            int i = 5;
            if (this.al.mo2512e() != 0) {
                i = this.al.t_(Math.min(this.al.mo2512e() - 1, i));
                if (this.f9010i.mo2402q() > i) {
                    this.f9010i.mo2391h(i);
                }
            }
            HandlerDetour.b(this.bG, this.bH, 0, -1019678992);
        }
    }

    public final boolean gC_() {
        return this.f9010i != null && this.f9010i.mo2399n();
    }

    public final boolean aD() {
        if (!this.f9010i.mo2399n()) {
            if ((this.f9010i.mo2402q() < this.al.m20017b() ? 1 : null) == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean aE() {
        return this.f9010i != null;
    }

    public final void mo1890a(FeedUnit feedUnit) {
        this.aE.mo651a(new DataSetEvents$DataSetUpdatedEvent());
    }

    public final void mo1887a(MutationType mutationType, Throwable th) {
        if (this.f137y && mutationType == MutationType.LIKE) {
            ServiceException a = ServiceException.a(th);
            CharSequence a2 = this.bo.m14520a(a, true, true);
            if (this.bo.m14521b(a)) {
                ErrorDialogs errorDialogs = this.bp;
                ErrorDialogParamsBuilder a3 = ErrorDialogParams.a(this.bq).a(SentryBlockTitle.SENTRY_LIKE_BLOCK.getTitleId());
                a3.c = a2;
                ErrorDialogParamsBuilder c = a3.c(2131230784);
                c.e = SentryUtil.a;
                errorDialogs.m14524a(c.l());
            } else if (a.errorCode != ErrorCode.CONNECTION_FAILURE) {
                this.br.m6456b(new ToastBuilder(a2));
            }
        }
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        this.bF.m16832a(scrollingViewProxy, i);
        this.an.mo1262a(scrollingViewProxy, i);
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        this.an.mo1263a(scrollingViewProxy, i, i2, i3);
    }

    public final void kH_() {
        if (this.f9010i != null) {
            this.bc.m14508a(ax(), this.f9010i.m18035D(), true);
        }
        this.bF.m16844p();
    }

    public final void kI_() {
        this.bF.m16841h();
        if (this.f137y && this.au && this.f9010i != null) {
            boolean z;
            FeedPerfLogger feedPerfLogger = this.bD;
            boolean o = this.bF.f11507b.mo1305o();
            FeedType aF = aF();
            if (this.aw || aD()) {
                z = true;
            } else {
                z = false;
            }
            if (feedPerfLogger.m3356a(o, aF, z)) {
                this.f9010i.mo2367b(new 7(this));
            }
        }
    }
}
