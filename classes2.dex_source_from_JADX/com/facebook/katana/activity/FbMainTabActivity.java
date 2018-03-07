package com.facebook.katana.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsEventNames.ContentFragmentType;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.apptab.interfaces.AppTabHost;
import com.facebook.apptab.state.NavigationConfig;
import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.apptab.state.TabTag;
import com.facebook.apptab.ui.AppTabBarBroadcaster;
import com.facebook.apptab.ui.BadgableGlyphView;
import com.facebook.apptab.ui.FbHeaderLayoutManager;
import com.facebook.apptab.ui.TabView;
import com.facebook.apptab.ui.nux.AppTabInterstitialController;
import com.facebook.apptab.ui.nux.FbMainTabActivityNuxController;
import com.facebook.apptab.ui.nux.FbMainTabActivityNuxController.1;
import com.facebook.apptab.ui.nux.FbMainTabActivityNuxController.State;
import com.facebook.apptab.ui.nux.MainTabNuxController;
import com.facebook.auth.annotations.IsMeUserAnEmployee;
import com.facebook.auth.annotations.IsMeUserTrustedTester;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.entry.BackstageOnboardInterstitialController;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.app.SplashScreenStartedActivity;
import com.facebook.base.broadcast.BackgroundBroadcastThread;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager$ReceiverBuilder;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.ContentFragmentContainer;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.bugreporter.activity.ActivityWithDebugInfo;
import com.facebook.checkpoint.CheckpointBroadcaster;
import com.facebook.common.activity.IFbMainTabActivity;
import com.facebook.common.activitycleaner.ActivityStackManager;
import com.facebook.common.activitycleaner.ActivityStackManager.Entry;
import com.facebook.common.activitycleaner.ActivityStackManager.OnApplicationEnteredListener;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer$Priority;
import com.facebook.common.appchoreographer.AppChoreographer$ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.idleexecutor.DefaultIdleExecutor;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.title.IndicatorBarController;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.common.ui.util.DisplayUtils;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder;
import com.facebook.device.ScreenUtil;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.IndicatorVisibilityListener;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.InfoDismissalReason;
import com.facebook.divebar.DivebarController;
import com.facebook.divebar.DivebarController.DivebarState;
import com.facebook.divebar.DivebarController.DivebarType;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl.DivebarStateListenerWrapper;
import com.facebook.earlyfetch.EarlyFetchController;
import com.facebook.exoplayer.VideoPlayerService;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.broadcaster.NewsFeedBroadcaster;
import com.facebook.feed.data.FeedDataLoaderInitializer;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.fragment.NewsFeedFragment.6;
import com.facebook.feed.fragment.NewsFeedFragmentDsmController;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.feed.ui.fullscreenvideoplayer.FullScreenVideoInflater;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.fig.abtest.ExperimentsForFigAbTestModule;
import com.facebook.friending.jewel.FriendRequestsFragment;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.growth.sem.SemTrackingLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.katana.dbl.AuthLoginHelper;
import com.facebook.katana.fragment.FbChromeFragment;
import com.facebook.katana.intent.Fb4aInternalIntentSigner;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.katana.login.ComponentName_WorkOnboardingFlowComponentMethodAutoProvider;
import com.facebook.katana.login.LoginActivityComponent;
import com.facebook.katana.login.WorkOnboardingFlowComponent;
import com.facebook.katana.prefs.NotificationPrefKeys;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.marketplace.tab.abtest.ExperimentsForMarketplaceTabAbtestModule;
import com.facebook.messages.ipc.peer.MessageNotificationPeer;
import com.facebook.messages.ipc.peer.MessageNotificationPeerContract;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.activity.DivebarEnabledActivity;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.messaging.forcemessenger.ExperimentsForForceMessengerModule;
import com.facebook.messaging.forcemessenger.ForceMessenger;
import com.facebook.multiprocess.peer.state.PeerStateObserver;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.common.JewelCounters.OnJewelCountChangeListener;
import com.facebook.notifications.jewel.JewelCountFetcher;
import com.facebook.notifications.util.MarketplaceBadgeCountManager;
import com.facebook.notifications.util.RedSpaceBadgeCountManager;
import com.facebook.notifications.widget.NotificationsFragment;
import com.facebook.offlinemode.intentchecker.OfflineIntentManager;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.perf.MainActivityToFragmentCreatePerfLogger;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.quickpromotion.logger.QuickPromotionLogger.LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelper;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.entry.RedSpaceDivebarButtonSpecUtil;
import com.facebook.redspace.entry.RedSpaceEntryDescriptionHelper;
import com.facebook.redspace.entry.RedSpaceEntryPointCapability;
import com.facebook.redspace.nux.RedSpaceDivebarInterstitialController;
import com.facebook.saved.common.nux.SavedBookmarksNuxInterstitialController;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.VideoSearchExperimentHelper;
import com.facebook.search.quickpromotion.AwarenessType;
import com.facebook.search.quickpromotion.QuickPromotionSearchBarTooltipController;
import com.facebook.search.quickpromotion.SearchAwarenessController;
import com.facebook.search.quickpromotion.SearchAwarenessOptOutController;
import com.facebook.search.quickpromotion.SearchAwarenessSuggestionUnitSubscriber;
import com.facebook.search.quickpromotion.SearchBarFormattedTooltipController;
import com.facebook.search.quickpromotion.SearchQPTooltipController;
import com.facebook.search.titlebar.GraphSearchTitleBarController;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox.SearchBoxType;
import com.facebook.selfupdate.SelfUpdateChecker;
import com.facebook.selfupdate.SelfUpdateManager;
import com.facebook.sequencelogger.Fb4aSequences;
import com.facebook.sounds.configurator.AudioConfigurator;
import com.facebook.sounds.configurator.prefs.AudioConfiguratorPrefKeys;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tablet.IsTablet;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletColumnLayoutManager.ColumnWidthConfig;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.TypedSideshowFragmentContainer;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ufiservices.flyout.UFIPopoverFragment;
import com.facebook.ui.drawers.DrawerController;
import com.facebook.ui.flyout.IFlyoutInterface;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnSizeChangedListener;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ui.titlebar.search.DivebarButtonSpecUtil;
import com.facebook.ui.titlebar.search.Fb4aSearchTitleBar;
import com.facebook.uicontrib.fab.FabView;
import com.facebook.uicontrib.fab.FabViewHost;
import com.facebook.video.channelfeed.ChannelFeedInflater;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.video.videohome.liveupdates.BroadcastStatusUpdateManager;
import com.facebook.video.videohome.liveupdates.BroadcastStatusUpdateManager.VideoTracker;
import com.facebook.video.videohome.liveupdates.LiveUpdatesManager;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.metadata.VideoHomeBadgeUpdater;
import com.facebook.video.videohome.metadata.VideoHomeMetadataFetcher;
import com.facebook.video.videohome.nux.VideoHomeTabToolTipNuxController;
import com.facebook.video.videohome.prefs.VideoHomePrefKeys;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsGraphQLHelper;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseInflator;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.CustomViewPager.OnAttachStateChangeListener;
import com.facebook.widget.LazyView;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.recycle.ViewPoolCleaner;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitlebarHost;
import com.facebook.work.postloginnux.PostLoginNuxManager;
import com.facebook.work.workprefkeys.WorkSetupProfilePrefKeys;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.ui.ZeroIndicatorController;
import com.facebook.zero.ui.ZeroIndicatorController.Listener;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: system_id */
public class FbMainTabActivity extends FbFragmentActivity implements AnalyticsActivityWithExtraData, AppTabHost, SplashScreenStartedActivity, ContentFragmentContainer, ActivityWithDebugInfo, IFbMainTabActivity, FullScreenVideoPlayerHost, DivebarEnabledActivity, TypedSideshowFragmentContainer, FabViewHost, ViewPoolCleaner, TitlebarHost {
    public static final Class<FbMainTabActivity> bk = FbMainTabActivity.class;
    private static final ImmutableList<String> bl = ImmutableList.of("chromeless:content:fragment:tag", "PhotoAnimationDialogFragment_MEDIA_GALLERY", "PhotoAnimationDialogFragment_PHOTOS_FEED");
    private static boolean bm = false;
    @Inject
    Lazy<GraphSearchTitleBarController> f3679A;
    @Inject
    RTLUtil f3680B;
    @Inject
    Lazy<SecureContextHelper> f3681C;
    @Inject
    Lazy<DivebarController> f3682D;
    @Inject
    JewelCounters f3683E;
    @Inject
    JewelCountFetcher f3684F;
    @Inject
    MonotonicClock f3685G;
    @Inject
    Clock f3686H;
    @Inject
    Lazy<DrawerController> f3687I;
    @Inject
    Fb4aTitleBarSupplier f3688J;
    @Inject
    FbHeaderLayoutManager f3689K;
    @Inject
    Lazy<FbErrorReporter> f3690L;
    @Inject
    Lazy<InterstitialStartHelper> f3691M;
    @Inject
    TabBarStateManager f3692N;
    @Inject
    ThemeTransitionHelper f3693O;
    @Inject
    AppTabInterstitialController f3694P;
    @Inject
    Lazy<FullScreenVideoInflater> f3695Q;
    @Inject
    Lazy<ChannelFeedInflater> f3696R;
    @Inject
    Lazy<VideoWatchAndBrowseInflator> f3697S;
    @Inject
    Lazy<OfflineIntentManager> f3698T;
    @Inject
    Lazy<EarlyFetchController> f3699U;
    @Inject
    QuickPerformanceLogger f3700V;
    @Inject
    Lazy<RecyclableViewPoolManager> f3701W;
    @Inject
    @LoggedInUserId
    Provider<String> f3702X;
    @Inject
    Lazy<FbUriIntentHandler> f3703Y;
    @Inject
    GatekeeperStoreImpl f3704Z;
    @Inject
    IndicatorBarController aA;
    @Inject
    NewsFeedFragmentDsmController aB;
    @Inject
    ScreenUtil aC;
    @Inject
    TabletExperimentConfiguration aD;
    @Inject
    TabletColumnLayoutManager aE;
    @Inject
    Lazy<SearchAwarenessSuggestionUnitSubscriber> aF;
    @Inject
    SearchAwarenessController aG;
    @Inject
    FbSharedPreferences aH;
    @Inject
    Lazy<SoftInputDetector> aI;
    @Inject
    @MessageNotificationPeer
    StatefulPeerManagerImpl aJ;
    @Inject
    ViewAccessibilityHelper aK;
    @Inject
    NewsFeedBroadcaster aL;
    @Inject
    PerfTestConfig aM;
    @Inject
    Lazy<ForceMessenger> aN;
    @Inject
    Lazy<MarketplaceBadgeCountManager> aO;
    @Inject
    Lazy<RapidFeedbackController> aP;
    @Inject
    Lazy<RedSpaceBadgeCountManager> aQ;
    @Inject
    Lazy<RedSpaceEntryPointCapability> aR;
    @Inject
    Lazy<RedSpaceEntryDescriptionHelper> aS;
    @Inject
    Lazy<VideoHomeMetadataFetcher> aT;
    @Inject
    QeAccessor aU;
    @Inject
    @DefaultIdleExecutor
    DefaultProcessIdleExecutor aV;
    @Inject
    Lazy<SemTrackingLogger> aW;
    @Inject
    TodayExperimentController aX;
    @Inject
    TopicFeedsTestUtil aY;
    @Inject
    @IsTablet
    Boolean aZ;
    @Inject
    VideoSearchExperimentHelper aa;
    @Inject
    @IsMeUserAnEmployee
    Provider<TriState> ab;
    @Inject
    @IsMeUserTrustedTester
    Provider<TriState> ac;
    @Inject
    Lazy<TabQuickPromotionLauncher> ad;
    @Inject
    ActivityStackManager ae;
    @Inject
    ViewPermalinkIntentFactory af;
    @Inject
    Lazy<LayoutInflater> ag;
    @Inject
    FbZeroFeatureVisibilityHelper ah;
    @Inject
    AuthLoginHelper ai;
    @Inject
    FbMainTabActivityIntentHelper aj;
    @Inject
    InternalIntentSigner ak;
    @Inject
    FeedDataLoaderInitializer al;
    @Inject
    FbLocationCache am;
    @Inject
    DialtoneController an;
    @Inject
    Lazy<BlueServiceOperationFactory> ao;
    @Inject
    @ForUiThread
    Lazy<ExecutorService> ap;
    @Inject
    @IsWorkBuild
    Boolean aq;
    @Inject
    Lazy<PostLoginNuxManager> ar;
    @Inject
    DefaultAppChoreographer as;
    @Inject
    Provider<InterstitialManager> at;
    @Inject
    Lazy<MemoryTrimmableRegistry> au;
    @Inject
    Lazy<SelfUpdateChecker> av;
    @Inject
    Lazy<SelfUpdateManager> aw;
    @Inject
    ZeroIndicatorController ax;
    @Inject
    DialtoneManualSwitcherController ay;
    @Inject
    ScreenPowerState az;
    public Fb4aSearchTitleBar bA;
    public LinearLayout bB;
    private View bC;
    public CustomViewPager bD;
    public MyFragmentPagerAdapter bE;
    private ImmersiveVideoPlayer bF;
    private boolean bG = false;
    public boolean bH;
    public boolean bI;
    public boolean bJ;
    public int bK;
    public int bL = -1;
    private int bM;
    public int bN = 0;
    private View bO;
    private MemoryTrimmable bP;
    private int bQ = -1;
    private int bR = -1;
    private boolean bS = false;
    public boolean bT;
    private AudioConfigurator bU;
    public CaspianTabProgressCoordinator bV;
    public boolean bW = false;
    public boolean bX = false;
    private Listener bY;
    private IndicatorVisibilityListener bZ;
    @Inject
    Context ba;
    @Inject
    AppStateManager bb;
    @Inject
    MainActivityToFragmentCreatePerfLogger bc;
    @Inject
    InteractionTTILogger bd;
    @Inject
    DivebarButtonSpecUtil be;
    @Inject
    Lazy<DataSavingsConfirmationDialogBuilder> bf;
    @Inject
    Lazy<SpringSystem> bg;
    @Inject
    @WorkOnboardingFlowComponent
    ComponentName bh;
    @LoginActivityComponent
    @Inject
    ComponentName bi;
    @Inject
    CheckpointBroadcaster bj;
    private TriState bn = TriState.UNSET;
    private TriState bo = TriState.UNSET;
    private boolean bp = false;
    public NavigationConfig bq;
    private SelfRegistrableReceiverImpl br;
    private SelfRegistrableReceiverImpl bs;
    private boolean bt = false;
    public List<TabTag> bu;
    private ImmutableMap<Jewel, TabTag> bv;
    private OnJewelCountChangeListener bw;
    public Map<String, TabView> bx = Maps.m838c();
    public String by;
    private String bz;
    private IndicatorVisibilityListener ca;
    private boolean cb;
    private boolean cc;
    private final Handler cd = new Handler();
    private final PeerStateObserver ce = new C02201(this);
    private long cf = SystemClock.uptimeMillis();
    private final PerfStats cg = PerfStats.a();
    private Spring ch;
    public LazyView<FabView> ci;
    private ComponentName cj = null;
    private boolean ck;
    private boolean cl;
    @Inject
    Lazy<VideoHomeLoggingUtils> f3705p;
    @Inject
    StartupPerfLogger f3706q;
    @Inject
    FeedPerfLogger f3707r;
    @Inject
    Lazy<Fb4aUriIntentMapper> f3708s;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f3709t;
    @Inject
    AppTabBarBroadcaster f3710u;
    @Inject
    @BackgroundBroadcastThread
    Handler f3711v;
    @Inject
    Lazy<AnalyticsLogger> f3712w;
    @Inject
    Lazy<NavigationLogger> f3713x;
    @Inject
    Lazy<PerformanceLogger> f3714y;
    @Inject
    Lazy<InteractionLogger> f3715z;

    /* compiled from: system_id */
    class C02201 implements PeerStateObserver {
        final /* synthetic */ FbMainTabActivity f3834a;

        C02201(FbMainTabActivity fbMainTabActivity) {
            this.f3834a = fbMainTabActivity;
        }

        public final void mo882a(Uri uri, boolean z) {
        }
    }

    /* compiled from: system_id */
    class C03012 implements OnSizeChangedListener {
        final /* synthetic */ FbMainTabActivity f7118a;

        /* compiled from: system_id */
        class C03991 implements Runnable {
            final /* synthetic */ C03012 f8964a;

            C03991(C03012 c03012) {
                this.f8964a = c03012;
            }

            public void run() {
                this.f8964a.f7118a.bD.requestLayout();
            }
        }

        C03012(FbMainTabActivity fbMainTabActivity) {
            this.f7118a = fbMainTabActivity;
        }

        public final void mo1641a() {
            this.f7118a.bD.post(new C03991(this));
        }
    }

    /* compiled from: system_id */
    class MyFragmentPagerAdapter extends FragmentStatePagerAdapterThatAllowsAccessToFragments {
        final /* synthetic */ FbMainTabActivity f8045a;
        private final Set<String> f8046b = Sets.m1313a();
        private Handler f8047c;
        private Runnable f8048d;
        private AbstractFbErrorReporter f8049e;
        private volatile boolean f8050f = true;

        public MyFragmentPagerAdapter(final FbMainTabActivity fbMainTabActivity, AbstractFbErrorReporter abstractFbErrorReporter) {
            this.f8045a = fbMainTabActivity;
            super(fbMainTabActivity.kO_());
            this.f8049e = abstractFbErrorReporter;
            this.f8047c = new Handler(Looper.getMainLooper());
            this.f8048d = new Runnable(this) {
                final /* synthetic */ MyFragmentPagerAdapter f8058b;

                public void run() {
                    this.f8058b.f8045a.m6068b(this.f8058b.f8045a.getIntent());
                }
            };
        }

        public final void m12632a(String str) {
            try {
                this.f8050f = false;
                FbMainTabActivity.m6025e(this.f8045a, str);
                for (int i = 0; i < mo1711b(); i++) {
                    if (m12643b(i) != null) {
                        String name = ((TabTag) this.f8045a.bu.get(i)).name();
                        if (!name.equals(str)) {
                            this.f8046b.add(name);
                        }
                    }
                }
                kR_();
            } finally {
                this.f8050f = true;
            }
        }

        public final void m12635b(String str) {
            try {
                this.f8050f = false;
                for (int i = 0; i < mo1711b(); i++) {
                    if (m12643b(i) != null) {
                        String name = ((TabTag) this.f8045a.bu.get(i)).name();
                        if (!(name.equals(str) || name.equals(TabTag.Feed.name()))) {
                            this.f8045a.m6022d(name);
                            this.f8046b.add(name);
                        }
                    }
                }
                kR_();
            } finally {
                this.f8050f = true;
            }
        }

        public final void mo1709a(Parcelable parcelable, ClassLoader classLoader) {
            if (parcelable != null) {
                Bundle bundle = (Bundle) parcelable;
                bundle.setClassLoader(classLoader);
                if (((NavigationConfig) bundle.getParcelable("tabs")).equals(this.f8045a.bq)) {
                    super.mo1709a(parcelable, classLoader);
                }
            }
        }

        public final Parcelable gG_() {
            Bundle bundle = (Bundle) super.gG_();
            if (bundle != null) {
                bundle.putParcelable("tabs", this.f8045a.bq);
            }
            return bundle;
        }

        public final Fragment mo1708a(int i) {
            TabTag tabTag = (TabTag) this.f8045a.bu.get(i);
            String name = tabTag.name();
            if (tabTag.contentFragmentType != null) {
                Intent intent = new Intent();
                intent.putExtra("target_fragment", tabTag.contentFragmentType.ordinal());
                intent.putExtra("extra_launch_uri", tabTag.fblink);
                FbChromeFragment fbChromeFragment = (FbChromeFragment) Fragment.m221a(this.f8045a, FbChromeFragment.class.getName(), FbMainTabActivity.m5974a(intent, name));
                this.f8045a.m5992a(fbChromeFragment, i);
                return fbChromeFragment;
            }
            throw new IllegalStateException("Tab is not mapped to a fragment.");
        }

        public final void mo1710a(ViewGroup viewGroup, int i, Object obj) {
            m12638a(i, obj, this.f8050f);
            this.f8046b.remove(((TabTag) this.f8045a.bu.get(i)).name());
        }

        public final int mo1711b() {
            return this.f8045a.bu.size();
        }

        public final int mo1707a(Object obj) {
            int i = 0;
            while (i < mo1711b()) {
                Fragment b = m12643b(i);
                String name = ((TabTag) this.f8045a.bu.get(i)).name();
                if (b == obj) {
                    return this.f8046b.contains(name) ? -2 : -1;
                } else {
                    i++;
                }
            }
            throw new IllegalStateException("getItemPosition() called for fragment that was not created by this adapter");
        }

        public final void mo1712b(ViewGroup viewGroup) {
            super.mo1712b(viewGroup);
            HandlerDetour.a(this.f8047c, this.f8048d, 719186519);
        }
    }

    /* compiled from: system_id */
    class C03453 implements OnAttachStateChangeListener {
        final /* synthetic */ FbMainTabActivity f8060a;

        C03453(FbMainTabActivity fbMainTabActivity) {
            this.f8060a = fbMainTabActivity;
        }

        public final void mo1718a() {
            this.f8060a.bH = true;
            if (this.f8060a.getIntent().hasExtra("target_tab_name")) {
                this.f8060a.m6068b(this.f8060a.getIntent());
            }
            ((InterstitialStartHelper) this.f8060a.f3691M.get()).m13673a(this.f8060a, new InterstitialTrigger(Action.TAB_NAVIGATION_ATTACHED));
        }

        public final void mo1719b() {
            this.f8060a.bH = false;
        }
    }

    /* compiled from: system_id */
    class C03464 implements Runnable {
        final /* synthetic */ FbMainTabActivity f8061a;

        C03464(FbMainTabActivity fbMainTabActivity) {
            this.f8061a = fbMainTabActivity;
        }

        public void run() {
            TracerDetour.a("CreatePagesOtherThanImmediatelyOffscreen", -1688680699);
            try {
                this.f8061a.bD.setOnlyCreatePagesImmediatelyOffscreen(false);
            } finally {
                TracerDetour.a(-1946160047);
            }
        }
    }

    /* compiled from: system_id */
    public class CaspianTabProgressCoordinator {
        final /* synthetic */ FbMainTabActivity f8068a;
        private ViewGroup f8069b;

        public CaspianTabProgressCoordinator(FbMainTabActivity fbMainTabActivity, ViewGroup viewGroup) {
            this.f8068a = fbMainTabActivity;
            this.f8069b = viewGroup;
        }

        public final void m12674a(int i) {
            m12675a(i, 0.0f, i);
        }

        private void m12672a(int i, float f) {
            m12675a(i, f, i);
        }

        public final void m12675a(int i, float f, int i2) {
            this.f8068a.f3693O.m7805a(i, f, i2, this.f8068a);
            FbMainTabActivity.ar(this.f8068a);
            int size = this.f8068a.bu.size();
            if (this.f8068a.f3680B.m6557a()) {
                i = (size - i) - 1;
            }
            int i3 = 0;
            while (i3 < size) {
                BadgableGlyphView c = m12673c(i3);
                if (i3 == i) {
                    c.setSelectionPercentage(1.0f - f);
                } else if ((i3 != i + 1 || i + 1 >= size || this.f8068a.f3680B.m6557a()) && !(i3 == i - 1 && i - 1 >= 0 && this.f8068a.f3680B.m6557a())) {
                    c.setSelectionPercentage(0.0f);
                } else {
                    c.setSelectionPercentage(f);
                }
                i3++;
            }
            if (i + 1 != this.f8068a.bu.size() && f != 0.0f) {
            }
        }

        public final void m12676b(int i) {
            if (i == 0) {
                if (TabTag.Feed == TabTag.fromName(this.f8068a.by)) {
                    FeedPerfLogger feedPerfLogger = this.f8068a.f3707r;
                    if (!feedPerfLogger.f1672L) {
                        feedPerfLogger.f1676k.mo510a(Fb4aSequences.f2225j);
                        feedPerfLogger.f1674i.mo469b(655448, (short) 2, 0);
                        feedPerfLogger.f1676k.mo518b(Fb4aSequences.f2225j);
                    }
                }
                int i2 = this.f8068a.bL;
                m12675a(i2, 0.0f, i2);
                FbMainTabActivity.af(this.f8068a);
                FbMainTabActivity.ae(this.f8068a);
            }
        }

        private TabView m12673c(int i) {
            return (TabView) this.f8069b.getChildAt(i);
        }
    }

    /* compiled from: system_id */
    class C03495 implements OnPageChangeListener {
        int f8070a = 0;
        boolean f8071b = true;
        boolean f8072c = true;
        final /* synthetic */ FbMainTabActivity f8073d;

        C03495(FbMainTabActivity fbMainTabActivity) {
            this.f8073d = fbMainTabActivity;
        }

        public final void mo1723a(int i, float f, int i2) {
            this.f8073d.bV.m12675a(i, f, this.f8073d.bK == 1 ? -1 : this.f8070a);
            if (!this.f8071b) {
                if ((!this.f8072c && i == this.f8070a) || (this.f8072c && i == this.f8070a - 1)) {
                    TabTag tabTag = (TabTag) this.f8073d.bu.get(this.f8070a);
                    if (tabTag.loadTabTabPerfMarkerNameNoAnim != null) {
                        PerformanceLogger performanceLogger = (PerformanceLogger) this.f8073d.f3714y.get();
                        MarkerConfig a = new MarkerConfig(tabTag.loadTabTabPerfMarkerIdNoAnim, tabTag.loadTabTabPerfMarkerNameNoAnim).m3388a(tabTag.analyticsTag);
                        a.f1705n = true;
                        performanceLogger.mo391c(a);
                    }
                    this.f8071b = true;
                }
            }
        }

        public final void e_(int i) {
            TabTag tabTag = (TabTag) this.f8073d.bu.get(i);
            this.f8071b = false;
            this.f8070a = i;
            this.f8072c = this.f8070a > this.f8073d.bL;
            if (tabTag.loadTabTabPerfMarkerName != null) {
                PerformanceLogger performanceLogger = (PerformanceLogger) this.f8073d.f3714y.get();
                MarkerConfig a = new MarkerConfig(tabTag.loadTabTabPerfMarkerId, tabTag.loadTabTabPerfMarkerName).m3388a(tabTag.analyticsTag);
                a.f1705n = true;
                performanceLogger.mo391c(a);
            }
            this.f8073d.m6010b(TabTag.Feed.equals(tabTag));
            String name = tabTag.name();
            if (tabTag == TabTag.RedSpace || tabTag == TabTag.VideoHome) {
                this.f8073d.m6073c(tabTag.name());
            }
            if (TabTag.isNotificationsTabTag(tabTag)) {
                FbMainTabActivity.m5948D(this.f8073d);
            }
            View view = (TabView) this.f8073d.bx.get(name);
            if (view != null) {
                this.f8073d.aK.m8777a(view);
            }
            Fragment f = FbMainTabActivity.m6027f(this.f8073d, this.f8073d.by);
            if (f != null) {
                f.mo1860g(false);
            }
            FbChromeFragment p = this.f8073d.mo813p();
            if (p != null) {
                p.m13745a(true);
                f = p.aq();
                if (f instanceof FriendRequestsFragment) {
                    this.f8073d.mo787a((FriendRequestsFragment) f);
                } else {
                    FbMainTabActivity.aE(this.f8073d);
                }
            }
            this.f8073d.bN = i;
            this.f8073d.by = name;
            this.f8073d.bL = i;
            this.f8073d.ae.f2125m = FBLinks.bT;
            if (this.f8073d.bK == 0) {
                FbMainTabActivity.m5966S(this.f8073d);
            }
            MainTabNuxController mainTabNuxController = this.f8073d.f3694P.f4255b;
            switch (1.a[mainTabNuxController.f4257a.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    FbMainTabActivityNuxController.m7882a(mainTabNuxController, State.SHOWN_MORE);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    int i2;
                    TabTag tabTag2 = TabTag.Bookmark;
                    if (mainTabNuxController.f4260b == null) {
                        i2 = -1;
                    } else {
                        i2 = mainTabNuxController.f4260b.indexOf(tabTag2);
                    }
                    if (i == i2) {
                        FbMainTabActivityNuxController.m7882a(mainTabNuxController, State.HIDDEN);
                        break;
                    }
                    break;
            }
            ((TabQuickPromotionLauncher) this.f8073d.ad.get()).a((TabTag) this.f8073d.bu.get(i), p);
            KeyboardUtils.a(this.f8073d);
            this.f8073d.ay.m8414a(InfoDismissalReason.NAVIGATION);
        }

        public final void mo1724b(int i) {
            this.f8073d.bV.m12676b(i);
            if (this.f8073d.bK == 1 && i == 2) {
                this.f8073d.bI = true;
            }
            this.f8073d.bK = i;
            if (i == 0) {
                FbMainTabActivity.m5962O(this.f8073d);
                FbMainTabActivity.m5966S(this.f8073d);
                FbMainTabActivity.af(this.f8073d);
                FbMainTabActivity.ae(this.f8073d);
            }
        }
    }

    /* compiled from: system_id */
    class C03526 extends OnJewelCountChangeListener {
        final /* synthetic */ FbMainTabActivity f8083a;

        C03526(FbMainTabActivity fbMainTabActivity) {
            this.f8083a = fbMainTabActivity;
        }

        public final void mo1726a(Jewel jewel, int i) {
            this.f8083a.m5993a(jewel, i);
        }
    }

    /* compiled from: system_id */
    class C03567 implements OnApplicationEnteredListener {
        final /* synthetic */ FbMainTabActivity f8311a;

        C03567(FbMainTabActivity fbMainTabActivity) {
            this.f8311a = fbMainTabActivity;
        }

        public final void mo1729a() {
            FbMainTabActivity.m5967T(this.f8311a);
        }
    }

    /* compiled from: system_id */
    public class C03578 {
        final /* synthetic */ FbMainTabActivity f8312a;

        C03578(FbMainTabActivity fbMainTabActivity) {
            this.f8312a = fbMainTabActivity;
        }

        public final void m12830a() {
            this.f8312a.bD.post(new 1(this));
        }
    }

    /* compiled from: system_id */
    class C03589 implements Listener {
        final /* synthetic */ FbMainTabActivity f8313a;

        C03589(FbMainTabActivity fbMainTabActivity) {
            this.f8313a = fbMainTabActivity;
        }

        public final void mo1258a() {
            this.f8313a.m5979a((int) this.f8313a.getResources().getDimension(2131427385), ZeroFeatureKey.FB4A_INDICATOR);
        }

        public final void mo1259b() {
            this.f8313a.m5979a(0, ZeroFeatureKey.FB4A_INDICATOR);
        }
    }

    /* compiled from: system_id */
    class FragmentStackDebugInfo {
        final int f8670a;
        final String f8671b;

        public FragmentStackDebugInfo(int i, String str) {
            this.f8670a = i;
            this.f8671b = str;
        }
    }

    private static <T extends Context> void m5994a(Class<T> cls, T t) {
        m5995a((Object) t, (Context) t);
    }

    private static void m5995a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FbMainTabActivity) obj).m5985a(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3709), StartupPerfLogger.m3406a(injectorLike), FeedPerfLogger.m3326a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2436), LocalFbBroadcastManager.m2946a(injectorLike), AppTabBarBroadcaster.m6550a(injectorLike), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2952), IdBasedSingletonScopeProvider.m1810b(injectorLike, 134), IdBasedLazy.m1808a(injectorLike, 10889), RTLUtil.m6553a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 968), IdBasedLazy.m1808a(injectorLike, 1109), JewelCounters.m6558a(injectorLike), JewelCountFetcher.m6564a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3553), Fb4aTitleBarSupplier.m6583a(injectorLike), FbHeaderLayoutManager.m6588a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedLazy.m1808a(injectorLike, 2352), TabBarStateManager.m6591a(injectorLike), ThemeTransitionHelper.m7797a(injectorLike), AppTabInterstitialController.m7868a(injectorLike), IdBasedLazy.m1808a(injectorLike, 6077), IdBasedLazy.m1808a(injectorLike, 11586), IdBasedLazy.m1808a(injectorLike, 11718), IdBasedSingletonScopeProvider.m1810b(injectorLike, 8762), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1120), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3581), IdBasedProvider.m1811a(injectorLike, 4442), IdBasedSingletonScopeProvider.m1810b(injectorLike, 616), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), VideoSearchExperimentHelper.m7892a(injectorLike), IdBasedProvider.m1811a(injectorLike, 640), IdBasedProvider.m1811a(injectorLike, 642), IdBasedLazy.m1808a(injectorLike, 7320), ActivityStackManager.m4298a(injectorLike), ViewPermalinkIntentFactory.m7896a(injectorLike), IdBasedLazy.m1808a(injectorLike, 60), FbZeroFeatureVisibilityHelper.m7916a(injectorLike), AuthLoginHelper.m8065a(injectorLike), FbMainTabActivityIntentHelper.m8233a(injectorLike), Fb4aInternalIntentSigner.m7903a(injectorLike), FeedDataLoaderInitializer.m8175a(injectorLike), FbLocationCache.m8243a(injectorLike), DialtoneControllerImpl.m8272a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1144), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3863), Boolean_IsWorkBuildMethodAutoProvider.m4525a(injectorLike), IdBasedLazy.m1808a(injectorLike, 11780), DefaultAppChoreographer.m1621a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2360), IdBasedSingletonScopeProvider.m1810b(injectorLike, 580), IdBasedLazy.m1808a(injectorLike, 3411), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3414), ZeroIndicatorController.m8358a(injectorLike), DialtoneManualSwitcherController.m8378a(injectorLike), ScreenPowerState.m8540a(injectorLike), IndicatorBarController.m8560a(injectorLike), NewsFeedFragmentDsmController.m8592a(injectorLike), ScreenUtil.m8695a(injectorLike), TabletExperimentConfiguration.m7856a(injectorLike), TabletColumnLayoutManager.m8710a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3384), SearchAwarenessController.m8743a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedLazy.m1808a(injectorLike, 615), StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.m4828a(injectorLike), ViewAccessibilityHelper.m8774a(injectorLike), NewsFeedBroadcaster.m8781a(injectorLike), PerfTestConfig.m2936a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2619), IdBasedLazy.m1808a(injectorLike, 7487), IdBasedLazy.m1808a(injectorLike, 3253), IdBasedSingletonScopeProvider.m1810b(injectorLike, 10165), IdBasedLazy.m1808a(injectorLike, 3269), IdBasedLazy.m1808a(injectorLike, 10182), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3711), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2209), TodayExperimentController.m8720a(injectorLike), TopicFeedsTestUtil.m8785a(injectorLike), Boolean_IsTabletMethodAutoProvider.m7864a(injectorLike), (Context) injectorLike.getInstance(Context.class), AppStateManager.m2245a(injectorLike), MainActivityToFragmentCreatePerfLogger.m8805a(injectorLike), InteractionTTILogger.m4228a(injectorLike), DivebarButtonSpecUtil.m8810a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5452), IdBasedLazy.m1808a(injectorLike, 3433), ComponentName_WorkOnboardingFlowComponentMethodAutoProvider.m8835a(injectorLike), ComponentName_LoginActivityComponentMethodAutoProvider.m8837a(injectorLike), CheckpointBroadcaster.m8842a(injectorLike));
    }

    private void m5985a(Lazy<VideoHomeLoggingUtils> lazy, StartupPerfLogger startupPerfLogger, FeedPerfLogger feedPerfLogger, Lazy<Fb4aUriIntentMapper> lazy2, FbBroadcastManager fbBroadcastManager, AppTabBarBroadcaster appTabBarBroadcaster, Handler handler, Lazy<AnalyticsLogger> lazy3, Lazy<NavigationLogger> lazy4, Lazy<PerformanceLogger> lazy5, Lazy<InteractionLogger> lazy6, Lazy<GraphSearchTitleBarController> lazy7, RTLUtil rTLUtil, Lazy<SecureContextHelper> lazy8, Lazy<DivebarController> lazy9, JewelCounters jewelCounters, JewelCountFetcher jewelCountFetcher, MonotonicClock monotonicClock, Clock clock, Lazy<DrawerController> lazy10, Fb4aTitleBarSupplier fb4aTitleBarSupplier, FbHeaderLayoutManager fbHeaderLayoutManager, Lazy<FbErrorReporter> lazy11, Lazy<InterstitialStartHelper> lazy12, TabBarStateManager tabBarStateManager, ThemeTransitionHelper themeTransitionHelper, AppTabInterstitialController appTabInterstitialController, Lazy<FullScreenVideoInflater> lazy13, Lazy<ChannelFeedInflater> lazy14, Lazy<VideoWatchAndBrowseInflator> lazy15, Lazy<OfflineIntentManager> lazy16, Lazy<EarlyFetchController> lazy17, QuickPerformanceLogger quickPerformanceLogger, Lazy<RecyclableViewPoolManager> lazy18, Provider<String> provider, Lazy<FbUriIntentHandler> lazy19, GatekeeperStore gatekeeperStore, VideoSearchExperimentHelper videoSearchExperimentHelper, Provider<TriState> provider2, Provider<TriState> provider3, Lazy<TabQuickPromotionLauncher> lazy20, ActivityStackManager activityStackManager, ViewPermalinkIntentFactory viewPermalinkIntentFactory, Lazy<LayoutInflater> lazy21, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper, AuthLoginHelper authLoginHelper, FbMainTabActivityIntentHelper fbMainTabActivityIntentHelper, InternalIntentSigner internalIntentSigner, FeedDataLoaderInitializer feedDataLoaderInitializer, FbLocationCache fbLocationCache, DialtoneController dialtoneController, Lazy<BlueServiceOperationFactory> lazy22, Lazy<ExecutorService> lazy23, Boolean bool, Lazy<PostLoginNuxManager> lazy24, AppChoreographer appChoreographer, Provider<InterstitialManager> provider4, Lazy<MemoryTrimmableRegistry> lazy25, Lazy<SelfUpdateChecker> lazy26, Lazy<SelfUpdateManager> lazy27, ZeroIndicatorController zeroIndicatorController, DialtoneManualSwitcherController dialtoneManualSwitcherController, ScreenPowerState screenPowerState, IndicatorBarController indicatorBarController, NewsFeedFragmentDsmController newsFeedFragmentDsmController, ScreenUtil screenUtil, TabletExperimentConfiguration tabletExperimentConfiguration, TabletColumnLayoutManager tabletColumnLayoutManager, Lazy<SearchAwarenessSuggestionUnitSubscriber> lazy28, SearchAwarenessController searchAwarenessController, FbSharedPreferences fbSharedPreferences, Lazy<SoftInputDetector> lazy29, StatefulPeerManager statefulPeerManager, ViewAccessibilityHelper viewAccessibilityHelper, NewsFeedBroadcaster newsFeedBroadcaster, PerfTestConfig perfTestConfig, Lazy<ForceMessenger> lazy30, Lazy<MarketplaceBadgeCountManager> lazy31, Lazy<RapidFeedbackController> lazy32, Lazy<RedSpaceBadgeCountManager> lazy33, Lazy<RedSpaceEntryPointCapability> lazy34, Lazy<RedSpaceEntryDescriptionHelper> lazy35, Lazy<VideoHomeMetadataFetcher> lazy36, QeAccessor qeAccessor, IdleExecutor idleExecutor, Lazy<SemTrackingLogger> lazy37, TodayExperimentController todayExperimentController, TopicFeedsTestUtil topicFeedsTestUtil, Boolean bool2, Context context, AppStateManager appStateManager, MainActivityToFragmentCreatePerfLogger mainActivityToFragmentCreatePerfLogger, InteractionTTILogger interactionTTILogger, DivebarButtonSpecUtil divebarButtonSpecUtil, Lazy<DataSavingsConfirmationDialogBuilder> lazy38, Lazy<SpringSystem> lazy39, ComponentName componentName, ComponentName componentName2, CheckpointBroadcaster checkpointBroadcaster) {
        this.f3705p = lazy;
        this.f3706q = startupPerfLogger;
        this.f3707r = feedPerfLogger;
        this.f3708s = lazy2;
        this.f3709t = fbBroadcastManager;
        this.f3710u = appTabBarBroadcaster;
        this.f3711v = handler;
        this.f3712w = lazy3;
        this.f3713x = lazy4;
        this.f3714y = lazy5;
        this.f3715z = lazy6;
        this.f3679A = lazy7;
        this.f3680B = rTLUtil;
        this.f3681C = lazy8;
        this.f3682D = lazy9;
        this.f3683E = jewelCounters;
        this.f3684F = jewelCountFetcher;
        this.f3685G = monotonicClock;
        this.f3686H = clock;
        this.f3687I = lazy10;
        this.f3688J = fb4aTitleBarSupplier;
        this.f3689K = fbHeaderLayoutManager;
        this.f3690L = lazy11;
        this.f3691M = lazy12;
        this.f3692N = tabBarStateManager;
        this.f3693O = themeTransitionHelper;
        this.f3694P = appTabInterstitialController;
        this.f3695Q = lazy13;
        this.f3696R = lazy14;
        this.f3697S = lazy15;
        this.f3698T = lazy16;
        this.f3699U = lazy17;
        this.f3700V = quickPerformanceLogger;
        this.f3701W = lazy18;
        this.f3702X = provider;
        this.f3703Y = lazy19;
        this.f3704Z = gatekeeperStore;
        this.aa = videoSearchExperimentHelper;
        this.ab = provider2;
        this.ac = provider3;
        this.ad = lazy20;
        this.ae = activityStackManager;
        this.af = viewPermalinkIntentFactory;
        this.ag = lazy21;
        this.ah = fbZeroFeatureVisibilityHelper;
        this.ai = authLoginHelper;
        this.aj = fbMainTabActivityIntentHelper;
        this.ak = internalIntentSigner;
        this.al = feedDataLoaderInitializer;
        this.am = fbLocationCache;
        this.an = dialtoneController;
        this.ao = lazy22;
        this.ap = lazy23;
        this.aq = bool;
        this.ar = lazy24;
        this.as = appChoreographer;
        this.at = provider4;
        this.au = lazy25;
        this.av = lazy26;
        this.aw = lazy27;
        this.ax = zeroIndicatorController;
        this.ay = dialtoneManualSwitcherController;
        this.az = screenPowerState;
        this.aA = indicatorBarController;
        this.aB = newsFeedFragmentDsmController;
        this.aC = screenUtil;
        this.aD = tabletExperimentConfiguration;
        this.aE = tabletColumnLayoutManager;
        this.aF = lazy28;
        this.aG = searchAwarenessController;
        this.aH = fbSharedPreferences;
        this.aI = lazy29;
        this.aJ = statefulPeerManager;
        this.aK = viewAccessibilityHelper;
        this.aL = newsFeedBroadcaster;
        this.aM = perfTestConfig;
        this.aN = lazy30;
        this.aO = lazy31;
        this.aP = lazy32;
        this.aQ = lazy33;
        this.aR = lazy34;
        this.aS = lazy35;
        this.aT = lazy36;
        this.aU = qeAccessor;
        this.aV = idleExecutor;
        this.aW = lazy37;
        this.aX = todayExperimentController;
        this.aY = topicFeedsTestUtil;
        this.aZ = bool2;
        this.ba = context;
        this.bb = appStateManager;
        this.bc = mainActivityToFragmentCreatePerfLogger;
        this.bd = interactionTTILogger;
        this.be = divebarButtonSpecUtil;
        this.bf = lazy38;
        this.bg = lazy39;
        this.bh = componentName;
        this.bi = componentName2;
        this.bj = checkpointBroadcaster;
    }

    private void m6047t() {
        Intent component = new Intent().setComponent(this.bi);
        component.addFlags(67108864);
        startActivity(component);
        finish();
    }

    private void m6049u() {
        boolean z = false;
        if (!this.aH.mo286a(WorkSetupProfilePrefKeys.c, false)) {
            z = true;
        }
        if (z) {
            Intent component = new Intent().setComponent(this.bh);
            component.addFlags(67108864);
            ((SecureContextHelper) this.f3681C.get()).mo662a(component, this);
            finish();
        }
    }

    private void m6051v() {
        Intent intent = getIntent();
        if (intent != null && !this.ak.mo1179b(intent)) {
            setIntent(new Intent(intent.getAction(), intent.getData()));
        }
    }

    @Nullable
    public final FragmentConstants$ContentFragmentType mo814q() {
        if (this.by == null) {
            return null;
        }
        TabTag fromNameSafe = TabTag.fromNameSafe(this.by);
        if (fromNameSafe != null) {
            return fromNameSafe.contentFragmentType;
        }
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aU.mo596a(ExperimentsForFb4aActivityModule.f8838a, false)) {
            getWindow().setFormat(1);
        }
    }

    @Nullable
    public final ColumnWidthConfig mo815s() {
        if (mo813p() != null) {
            return mo813p().aA;
        }
        return null;
    }

    public final void m6074d() {
        this.ck = true;
    }

    public final void m6062a(int i, int i2, int i3, boolean z) {
        this.ck = false;
        if (i3 > 0 || z || i != i2) {
            this.cl = true;
        }
    }

    protected final void mo790b(@Nullable Bundle bundle) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        super.mo790b(bundle);
        TracerDetour.a("FbMainTabActivity.injectMe", 609450539);
        try {
            m5994a(FbMainTabActivity.class, (Context) this);
            if (this.ai.m8069a()) {
                m6051v();
                if (FbMainTabActivityIntentHelper.m8236c(getIntent())) {
                    ColdStartPrimingInformation.a().h();
                    this.f3707r.m3346a(this.cf);
                    this.al.m8178a();
                    ((SemTrackingLogger) this.aW.get()).m10720a();
                    ((InteractionLogger) this.f3715z.get()).m6502a();
                    ((NavigationLogger) this.f3713x.get()).m5498a("cold_start");
                }
                if (this.aq.booleanValue()) {
                    m6049u();
                }
                m5997a("MainTabActivityEndToEnd", this.cf, this.cg);
                m5996a("MainTabActivityPreOnCreate", this.cf);
                m6009b("MainTabActivityPreOnCreate", uptimeMillis);
                m5996a("MainTabActivityOnCreate", uptimeMillis);
                m6033h("MainTabActivityViewInflation");
                TracerDetour.a("FbMainTabActivity.setContentView", 729180282);
                this.bT = this.aU.mo596a(ExperimentsForFigAbTestModule.f6361a, false);
                try {
                    int i;
                    int color;
                    Intent intent;
                    if (this.aD.m7863i()) {
                        i = 2130905153;
                    } else if (this.bT) {
                        i = 2130905152;
                    } else {
                        i = 2130905151;
                    }
                    setContentView(i);
                    m6035i("MainTabActivityViewInflation");
                    m6033h("MainTabActivityOnCreatePostInflation");
                    this.bq = this.f3692N.m6594a();
                    this.bO = mo2563a(2131563651);
                    this.bB = (LinearLayout) mo2563a(2131563652);
                    if (!this.aZ.booleanValue()) {
                        this.bC = mo2563a(2131563653);
                    }
                    this.bA = (Fb4aSearchTitleBar) mo2563a(2131558563);
                    this.bD = (CustomViewPager) mo2563a(2131563650);
                    this.bA.setOnSizeChangedListener(new C03012(this));
                    this.aJ.m4871a(MessageNotificationPeerContract.f2842h, this.ce);
                    this.f3689K.m6590a(this.bO);
                    this.bS = this.aa.m7894a();
                    this.bu = this.bq.f7048a;
                    Preconditions.checkArgument(!this.bu.isEmpty());
                    List<TabTag> a = this.f3680B.m6557a() ? Lists.m1301a(this.bu) : this.bu;
                    for (TabTag a2 : a) {
                        m5980a(a2);
                    }
                    m6058y();
                    aA();
                    ap();
                    this.aG.m8749a(this.bA.getSearchBox().getSearchEditText());
                    m5951E();
                    m5952F();
                    this.bM = this.f3680B.m6557a() ? (this.bq.f7048a.size() - 1) + 0 : 0;
                    this.bE = new MyFragmentPagerAdapter(this, (AbstractFbErrorReporter) this.f3690L.get());
                    this.bD.setAdapter(this.bE);
                    this.bD.setOnAttachStateChangeListener(new C03453(this));
                    this.bQ = this.bu.indexOf(TabTag.VideoHome);
                    if (this.bQ >= 0) {
                        color = getResources().getColor(2131362141);
                        this.f3693O.m7804a(this.bB, color).m7804a(this.bA, getResources().getColor(this.bS ? 2131362141 : 2131362144)).m7804a(this.bO, color).m7803a(this.bQ);
                    }
                    this.bR = a.indexOf(TabTag.Marketplace);
                    boolean z = bundle == null;
                    this.bD.setOnlyCreatePagesImmediatelyOffscreen(z);
                    this.bD.setOffscreenPageLimit(this.bE.mo1711b() - 1);
                    this.bD.setCurrentItem(this.bM);
                    if (z) {
                        this.as.m1634a("Viewpager CreatePagesOtherThanImmediatelyOffscreen", new C03464(this), AppChoreographer$Priority.APPLICATION_LOADED_UI_IDLE, AppChoreographer$ThreadType.UI);
                    }
                    m5959L();
                    Iterator it = this.bv.keySet().iterator();
                    while (it.hasNext()) {
                        Jewel jewel = (Jewel) it.next();
                        m5981a((TabTag) this.bv.get(jewel), this.f3683E.m6560a(jewel), false);
                    }
                    BadgableGlyphView badgablePrimaryActionButtonView = this.bA.getBadgablePrimaryActionButtonView();
                    if (badgablePrimaryActionButtonView != null) {
                        badgablePrimaryActionButtonView.setUnreadCount(this.f3683E.m6560a(Jewel.INBOX));
                    }
                    if (ax()) {
                        badgablePrimaryActionButtonView = this.bA.getBadgableSecondaryActionButtonView();
                        if (badgablePrimaryActionButtonView != null) {
                            badgablePrimaryActionButtonView.setUnreadCount(this.f3683E.m6560a(Jewel.BACKSTAGE));
                        }
                    }
                    if (((RedSpaceEntryPointCapability) this.aR.get()).m7793a()) {
                        BadgableGlyphView badgableSecondaryActionButtonView = this.bA.getBadgableSecondaryActionButtonView();
                        if (badgableSecondaryActionButtonView != null) {
                            badgableSecondaryActionButtonView.setUseSmallUnreadCountCap(true);
                            color = this.f3683E.m6560a(Jewel.REDSPACE);
                            badgableSecondaryActionButtonView.setUnreadCount(color);
                            badgableSecondaryActionButtonView.setContentDescription(((RedSpaceEntryDescriptionHelper) this.aS.get()).a(color));
                        }
                    }
                    m5957J();
                    this.by = ((TabTag) this.bu.get(this.bM)).name();
                    this.bL = this.bM;
                    this.bz = this.by;
                    ((TabView) this.bx.get(this.by)).setSelected(true);
                    this.bV = new CaspianTabProgressCoordinator(this, ag());
                    this.bD.setOnPageChangeListener(new C03495(this));
                    this.bD.setIsSwipingEnabled(this.aU.mo596a(ExperimentsForFigAbTestModule.f6362b, true));
                    m5958K();
                    this.bw = new C03526(this);
                    if (this.aX.m8728c()) {
                        this.f3684F.m6569a(true);
                    }
                    this.f3683E.m6562a(this.bw);
                    this.f3684F.m6568a();
                    if (this.aH.mo286a(AudioConfiguratorPrefKeys.f8138b, false)) {
                        ah();
                    }
                    if (bundle == null) {
                        intent = getIntent();
                        Intent a3 = this.aj.m8240a(intent);
                        if (this.af.m7902a(intent) || a3 != intent || intent.hasExtra("com.facebook.katana.profile.id") || intent.hasExtra("faceweb_modal") || intent.hasExtra("extra_launch_uri")) {
                            m6014c(intent);
                        }
                    } else if (bundle.getBoolean("open_divebar")) {
                        m6053w();
                    }
                    this.f3694P.m7874a(this.bD, this.bu);
                    aC(this);
                    m5960M(this);
                    this.cc = true;
                    this.ae.m4302a(new C03567(this));
                    this.aB.m8594a((ViewStub) mo2563a(2131563654));
                    this.aB.m8595a(new C03578(this));
                    this.aA.m8567a((ViewStub) mo2563a(2131561010));
                    this.ax.m8366a(this.aA.m8568a());
                    this.bY = new C03589(this);
                    this.ay.m8412a((ViewStub) mo2563a(2131561006));
                    this.bZ = new IndicatorVisibilityListener(this) {
                        final /* synthetic */ FbMainTabActivity f8314a;

                        {
                            this.f8314a = r1;
                        }

                        public final void mo1260a() {
                            int dimension = (int) this.f8314a.getResources().getDimension(2131427386);
                            if (this.f8314a.ay.m8424i()) {
                                float f = (float) dimension;
                                Resources resources = this.f8314a.getResources();
                                DialtoneManualSwitcherController dialtoneManualSwitcherController = this.f8314a.ay;
                                dimension = (int) (f + resources.getDimension(2131428113));
                            }
                            this.f8314a.m5979a(dimension, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
                        }

                        public final void mo1261b() {
                            this.f8314a.m5979a(0, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
                        }
                    };
                    this.ca = new IndicatorVisibilityListener(this) {
                        final /* synthetic */ FbMainTabActivity f8315a;

                        {
                            this.f8315a = r1;
                        }

                        public final void mo1260a() {
                            FbMainTabActivity fbMainTabActivity = this.f8315a;
                            float dimension = this.f8315a.getResources().getDimension(2131427386);
                            Resources resources = this.f8315a.getResources();
                            DialtoneManualSwitcherController dialtoneManualSwitcherController = this.f8315a.ay;
                            fbMainTabActivity.m6006b((int) (dimension + resources.getDimension(2131428113)), ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
                        }

                        public final void mo1261b() {
                            this.f8315a.m6006b(this.f8315a.ay.m8423h() ? (int) this.f8315a.getResources().getDimension(2131427386) : 0, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
                        }
                    };
                    if (this.f3704Z.m2189a(1143, false)) {
                        ((FbUriIntentHandler) this.f3703Y.get()).m8632a(this.ba, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, this.f3702X.get()));
                    }
                    if (VERSION.SDK_INT >= 16 && this.f3704Z.m2189a(854, false)) {
                        intent = new Intent(this.ba, VideoPlayerService.class);
                        try {
                            this.cj = startService(intent);
                        } catch (SecurityException e) {
                            this.cj = startService(intent);
                        }
                    }
                    if (this.f3704Z.m2189a(15, false)) {
                        this.as.m1634a("Prefetching backstage data", new 12(this), AppChoreographer$Priority.APPLICATION_LOADED_LOW_PRIORITY, AppChoreographer$ThreadType.BACKGROUND);
                    }
                    m6035i("MainTabActivityOnCreatePostInflation");
                    m6035i("MainTabActivityOnCreate");
                } finally {
                    TracerDetour.a(-100633998);
                }
            } else {
                m6047t();
            }
        } finally {
            TracerDetour.a(-1134639689);
        }
    }

    private void m6053w() {
        m6055x();
        ((DrawerBasedDivebarControllerImpl) this.f3682D.get()).kZ_();
    }

    private void m6055x() {
        if (!((DrawerBasedDivebarControllerImpl) this.f3682D.get()).m12922e()) {
            ((DrawerBasedDivebarControllerImpl) this.f3682D.get()).m12887a((Activity) this);
        }
        if (!this.bG) {
            if (((DrawerController) this.f3687I.get()).m12952b()) {
                ((DrawerController) this.f3687I.get()).m12948a(new 13(this));
            }
            DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl = (DrawerBasedDivebarControllerImpl) this.f3682D.get();
            14 14 = new 14(this);
            if (drawerBasedDivebarControllerImpl.m12922e()) {
                if (drawerBasedDivebarControllerImpl.f8373j != null) {
                    drawerBasedDivebarControllerImpl.f8389d.m12950b(drawerBasedDivebarControllerImpl.f8373j);
                    drawerBasedDivebarControllerImpl.f8373j = null;
                }
                if (14 != null) {
                    drawerBasedDivebarControllerImpl.f8373j = new DivebarStateListenerWrapper(14);
                    drawerBasedDivebarControllerImpl.f8389d.m12948a(drawerBasedDivebarControllerImpl.f8373j);
                }
            }
            this.bG = true;
        }
    }

    private void m6058y() {
        if (ax()) {
            BackstageOnboardInterstitialController backstageOnboardInterstitialController = (BackstageOnboardInterstitialController) ((InterstitialManager) this.at.get()).m8120a("4063", BackstageOnboardInterstitialController.class);
            if (backstageOnboardInterstitialController != null) {
                boolean z = true;
                if (!(backstageOnboardInterstitialController.b.mo286a(StacksConstants.m, true) && backstageOnboardInterstitialController.e())) {
                    z = false;
                }
                if (z) {
                    View badgableSecondaryActionButtonView = this.bA.getBadgableSecondaryActionButtonView();
                    Tooltip tooltip = new Tooltip(backstageOnboardInterstitialController.c);
                    tooltip.a(backstageOnboardInterstitialController.c.getResources().getString(2131239896));
                    tooltip.c(badgableSecondaryActionButtonView);
                    tooltip.t = -1;
                    tooltip.H = new BackstageOnboardInterstitialController.1(backstageOnboardInterstitialController);
                    tooltip.d();
                }
            }
        }
    }

    private void m6005b(int i) {
        if (this.bp && i > 0) {
            BadgableGlyphView badgableSecondaryActionButtonView = this.bA.getBadgableSecondaryActionButtonView();
            if (badgableSecondaryActionButtonView != null && ((RedSpaceDivebarInterstitialController) ((InterstitialManager) this.at.get()).m8120a("4093", RedSpaceDivebarInterstitialController.class)) != null) {
                ((InterstitialStartHelper) this.f3691M.get()).m13672a(this.ba, new InterstitialTrigger(Action.REDSPACE_BADGE_LOAD), RedSpaceDivebarInterstitialController.class, badgableSecondaryActionButtonView);
            }
        }
    }

    private void m6059z() {
        if (((TabView) this.bx.get(TabTag.VideoHome.name())) != null) {
            FbSharedPreferences fbSharedPreferences = this.aH;
            fbSharedPreferences.edit().mo1274a(VideoHomePrefKeys.f22153b, fbSharedPreferences.mo276a(VideoHomePrefKeys.f22153b, 0) + 1).commit();
        }
    }

    private void m5942A() {
        TabView tabView = (TabView) this.bx.get(TabTag.VideoHome.name());
        if (tabView != null) {
            VideoHomeTabToolTipNuxController videoHomeTabToolTipNuxController = (VideoHomeTabToolTipNuxController) ((InterstitialManager) this.at.get()).m8120a("4111", VideoHomeTabToolTipNuxController.class);
            if (videoHomeTabToolTipNuxController != null) {
                videoHomeTabToolTipNuxController.f22157c = tabView;
                HandlerDetour.b(this.cd, new Runnable(this) {
                    final /* synthetic */ FbMainTabActivity f22158a;

                    {
                        this.f22158a = r1;
                    }

                    public void run() {
                        ((InterstitialStartHelper) this.f22158a.f3691M.get()).m13672a(this.f22158a.ba, new InterstitialTrigger(Action.VIDEO_HOME_TAB_TOOLTIP), InterstitialController.class, null);
                    }
                }, 1000, -1325837747);
            }
        }
    }

    private void m5945B() {
        if (((TabView) this.bx.get(TabTag.Bookmark.name())) != null && ((SavedBookmarksNuxInterstitialController) ((InterstitialManager) this.at.get()).m8120a("3907", SavedBookmarksNuxInterstitialController.class)) != null) {
            HandlerDetour.b(this.cd, new Runnable(this) {
                final /* synthetic */ FbMainTabActivity f8669a;

                {
                    this.f8669a = r1;
                }

                public void run() {
                    ((InterstitialStartHelper) this.f8669a.f3691M.get()).m13672a(this.f8669a.ba, new InterstitialTrigger(Action.SAVED_MAIN_TAB_VISIBLE), InterstitialController.class, null);
                }
            }, 1000, -1977761235);
        }
    }

    private void m5984a(DivebarState divebarState) {
        if (divebarState == DivebarState.CLOSED && ((DrawerBasedDivebarControllerImpl) this.f3682D.get()).m12898l() == DivebarType.DEFAULT_DIVEBAR) {
            ((RapidFeedbackController) this.aP.get()).m14997a("1685150328371343", (Context) this);
        }
    }

    private void m5946C() {
        if (mo797j() && this.f3704Z.m2189a(856, false)) {
            ((RapidFeedbackController) this.aP.get()).m14997a("1565141090400626", (Context) this);
        }
    }

    public static void m5948D(FbMainTabActivity fbMainTabActivity) {
        if (fbMainTabActivity.f3704Z.m2189a(810, false) && !fbMainTabActivity.aH.mo286a(NotificationPrefKeys.e, false)) {
            ((RapidFeedbackController) fbMainTabActivity.aP.get()).m14997a("407346402789425", (Context) fbMainTabActivity);
            fbMainTabActivity.aH.edit().putBoolean(NotificationPrefKeys.e, true).commit();
        }
    }

    private void m5951E() {
        QuickPromotionDefinition quickPromotionDefinition;
        SearchAwarenessController searchAwarenessController = this.aG;
        View view = this.bA.f6594q.f7436e;
        SearchQPTooltipController searchQPTooltipController = (SearchQPTooltipController) searchAwarenessController.f4887j.get();
        searchQPTooltipController.f7854f = (InterstitialIntentController) searchQPTooltipController.f7850b.m8118a(QuickPromotionSearchBarTooltipController.f7856a, QuickPromotionSearchBarTooltipController.class);
        if (searchQPTooltipController.f7854f == null) {
            quickPromotionDefinition = null;
        } else {
            Intent a = searchQPTooltipController.f7854f.mo1687a(searchQPTooltipController.f7849a);
            if (a == null) {
                quickPromotionDefinition = null;
            } else {
                quickPromotionDefinition = (QuickPromotionDefinition) a.getExtras().get("qp_definition");
            }
        }
        QuickPromotionDefinition quickPromotionDefinition2 = quickPromotionDefinition;
        if (searchQPTooltipController.f7854f != null && quickPromotionDefinition2 != null) {
            Tooltip tooltip;
            CharSequence charSequence = quickPromotionDefinition2.title;
            CharSequence charSequence2 = quickPromotionDefinition2.content;
            if (TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(charSequence2)) {
                searchQPTooltipController.f7853e.m2340a("SearchAwareness", "title and description are empty for tooltip.");
                tooltip = null;
            } else {
                tooltip = new Tooltip(searchQPTooltipController.f7849a, 2);
                tooltip.a(charSequence);
                tooltip.b(charSequence2);
                tooltip.a(Position.BELOW);
                tooltip.t = -1;
                tooltip.f(view);
            }
            if (tooltip != null) {
                QuickPromotionViewHelper a2 = searchQPTooltipController.f7851c.m12392a(quickPromotionDefinition2, searchQPTooltipController.f7854f.mo1173b(), quickPromotionDefinition2.c(), null);
                a2.a();
                a2.a(new LayoutInfo());
            }
        }
    }

    private void m5952F() {
        if (this.aU != null) {
            if (this.aU.mo596a(ExperimentsForSearchAbTestModule.au, false) && this.aF != null) {
                ((SearchAwarenessSuggestionUnitSubscriber) this.aF.get()).f19656d = this.aG;
                this.cb = true;
            }
            this.aG.m8748a();
        }
    }

    private void m6010b(boolean z) {
        if (this.cb && this.aF != null) {
            if (z) {
                ((SearchAwarenessSuggestionUnitSubscriber) this.aF.get()).m27384a();
                return;
            }
            SearchAwarenessSuggestionUnitSubscriber searchAwarenessSuggestionUnitSubscriber = (SearchAwarenessSuggestionUnitSubscriber) this.aF.get();
            if (searchAwarenessSuggestionUnitSubscriber.f19655c != null) {
                searchAwarenessSuggestionUnitSubscriber.f19654b.m9388a(Collections.singleton(searchAwarenessSuggestionUnitSubscriber.f19655c));
                searchAwarenessSuggestionUnitSubscriber.f19655c = null;
            }
        }
    }

    private void m5954G() {
        SearchBarFormattedTooltipController searchBarFormattedTooltipController = (SearchBarFormattedTooltipController) this.aG.f4885h.get(GraphQLSearchAwarenessTemplatesEnum.FORMATTED_TOOLTIP);
        if (searchBarFormattedTooltipController != null) {
            if (searchBarFormattedTooltipController.m != null && searchBarFormattedTooltipController.m.r) {
                searchBarFormattedTooltipController.m.l();
            }
            if (SearchBarFormattedTooltipController.b(searchBarFormattedTooltipController)) {
                SearchAwarenessOptOutController searchAwarenessOptOutController = searchBarFormattedTooltipController.g;
                AwarenessType awarenessType = AwarenessType.LEARNING_NUX;
                if (searchAwarenessOptOutController.h != null) {
                    searchAwarenessOptOutController.h.dismiss();
                }
            }
        }
    }

    private void m5955H() {
        if (this.aU.mo596a(ExperimentsForRedSpaceExperimentsModule.f7063h, false)) {
            ((RedSpaceBadgeCountManager) this.aQ.get()).a();
        }
    }

    private void m5956I() {
        if (this.aU.mo596a(ExperimentsForRedSpaceExperimentsModule.f7063h, false)) {
            ((RedSpaceBadgeCountManager) this.aQ.get()).b();
        }
    }

    private void m5957J() {
        TracerDetour.a("FbMainTabActivity.onCreateSetupMemoryFragmentTimmer", -548121185);
        try {
            this.bP = new MemoryTrimmable(this) {
                final /* synthetic */ FbMainTabActivity f8066a;

                {
                    this.f8066a = r1;
                }

                public final void mo1395a(MemoryTrimType memoryTrimType) {
                    if (memoryTrimType != MemoryTrimType.OnAppBackgrounded) {
                        this.f8066a.as.m1634a("Killing inactive tabs due to " + memoryTrimType.name(), new 1(this), AppChoreographer$Priority.APPLICATION_LOADED_HIGH_PRIORITY, AppChoreographer$ThreadType.UI);
                    }
                }
            };
            ((MemoryTrimmableRegistry) this.au.get()).mo1390a(this.bP);
        } finally {
            TracerDetour.a(-2042621461);
        }
    }

    private void m5958K() {
        TracerDetour.a("FbMainTabActivity.onCreateSetupBroadcastReceiver", 611289814);
        try {
            this.ae.m4303b();
            FbBroadcastManager$ReceiverBuilder a = this.f3709t.m2951a().mo506a("broadcast_new_fragment_transaction_in_current_tab", new ActionReceiver(this) {
                final /* synthetic */ FbMainTabActivity f8076a;

                {
                    this.f8076a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -945646906, Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -821004462));
                }
            }).mo506a("broadcast_after_fragment_pushed_in_current_tab", new ActionReceiver(this) {
                final /* synthetic */ FbMainTabActivity f8077a;

                {
                    this.f8077a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -270818996);
                    FbMainTabActivity.m5965R(this.f8077a);
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -710956193, a);
                }
            }).mo506a("com.facebook.feed.util.NAVIGATE_TO_FEED_INTERACTION", new ActionReceiver(this) {
                final /* synthetic */ FbMainTabActivity f8078a;

                {
                    this.f8078a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1491902714);
                    this.f8078a.al.m8179b();
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 126861105, a);
                }
            }).mo506a("com.facebook.checkpoint.USER_IN_CHECKPOINT", new ActionReceiver(this) {
                final /* synthetic */ FbMainTabActivity f8079a;

                {
                    this.f8079a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1258703141);
                    this.f8079a.f3708s.get();
                    String a2 = Fb4aUriIntentMapper.m8641a(Uri.parse("/checkpoint/block"));
                    this.f8079a.bj.f4935c = true;
                    ((FbUriIntentHandler) this.f8079a.f3703Y.get()).m8633a(this.f8079a.ba, a2, intent.getExtras());
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -246958113, a);
                }
            }).mo506a("com.facebook.apptab.ui.TAB_WAITING_FOR_DRAW", new ActionReceiver(this) {
                final /* synthetic */ FbMainTabActivity f8080a;

                {
                    this.f8080a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1725860460);
                    FbMainTabActivity.m5960M(this.f8080a);
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 780397748, a);
                }
            });
            if (!this.aU.mo596a(ExperimentsForFigAbTestModule.f6363c, false)) {
                a.mo506a("com.facebook.feed.util.NEWS_FEED_NEW_STORIES", new 23(this));
            }
            this.br = a.mo503a();
            this.br.m3296b();
            this.bs = this.f3709t.m2951a().mo506a(AppStateManager.f1110b, new ActionReceiver(this) {
                final /* synthetic */ FbMainTabActivity f8081a;

                {
                    this.f8081a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1347374615);
                    ((InterstitialStartHelper) this.f8081a.f3691M.get()).m13673a(this.f8081a, new InterstitialTrigger(Action.APP_FOREGROUND));
                    this.f8081a.m5946C();
                    FbMainTabActivity.aC(this.f8081a);
                    if (this.f8081a.aU.mo596a(ExperimentsForRedSpaceExperimentsModule.f7063h, false)) {
                        this.f8081a.aV.mo269a(new 1(this));
                    }
                    if (FbMainTabActivity.al(this.f8081a)) {
                        ((VideoHomeLoggingUtils) this.f8081a.f3705p.get()).i = this.f8081a.f3686H.mo211a();
                        ((VideoHomeMetadataFetcher) this.f8081a.aT.get()).m30030c();
                    }
                    if (FbMainTabActivity.am(this.f8081a)) {
                        ((MarketplaceBadgeCountManager) this.f8081a.aO.get()).a();
                    }
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -530353852, a);
                }
            }).mo506a(AppStateManager.f1111c, new ActionReceiver(this) {
                final /* synthetic */ FbMainTabActivity f8082a;

                {
                    this.f8082a = r1;
                }

                public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                    int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -46808282);
                    if (FbMainTabActivity.al(this.f8082a)) {
                        VideoHomeMetadataFetcher videoHomeMetadataFetcher = (VideoHomeMetadataFetcher) this.f8082a.aT.get();
                        videoHomeMetadataFetcher.f22134c = false;
                        if (videoHomeMetadataFetcher.f22132a != null) {
                            videoHomeMetadataFetcher.f22132a.a();
                            videoHomeMetadataFetcher.f22132a = null;
                        }
                    }
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1533494670, a);
                }
            }).mo505a(this.f3711v).mo503a();
            this.bs.m3296b();
        } finally {
            TracerDetour.a(2123616667);
        }
    }

    private void m5959L() {
        Builder builder = ImmutableMap.builder();
        builder.m609b(Jewel.FRIEND_REQUESTS, TabTag.FriendRequests);
        builder.m609b(Jewel.NOTIFICATIONS, TabTag.Notifications);
        if (this.bq.f7048a.contains(TabTag.RedSpace)) {
            builder.m609b(Jewel.REDSPACE, TabTag.RedSpace);
        }
        if (this.bq.f7048a.contains(TabTag.VideoHome)) {
            builder.m609b(Jewel.VIDEO_HOME, TabTag.VideoHome);
        }
        if (this.bq.f7048a.contains(TabTag.NotificationsFriending)) {
            builder.m609b(Jewel.NOTIFICATIONS_FRIENDING, TabTag.NotificationsFriending);
        }
        if (this.bq.f7048a.contains(TabTag.Marketplace)) {
            builder.m609b(Jewel.MARKETPLACE, TabTag.Marketplace);
        }
        this.bv = builder.m610b();
    }

    public static void m5960M(FbMainTabActivity fbMainTabActivity) {
        if (fbMainTabActivity.bW) {
            m5961N(fbMainTabActivity);
            return;
        }
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) fbMainTabActivity.mo2563a(2131563652);
        customLinearLayout.m8507a(new OnDispatchDrawListener(fbMainTabActivity) {
            final /* synthetic */ FbMainTabActivity f8310a;

            {
                this.f8310a = r1;
            }

            public final boolean mo1728a() {
                FbMainTabActivity.m5961N(this.f8310a);
                this.f8310a.bW = true;
                return true;
            }
        });
        customLinearLayout.invalidate();
    }

    public static void m5961N(FbMainTabActivity fbMainTabActivity) {
        if (!fbMainTabActivity.f3706q.m3462l(655485, "MainTabActivityChromeDrawn")) {
            fbMainTabActivity.f3706q.m3429a(655485, "MainTabActivityChromeDrawn");
        }
        fbMainTabActivity.f3710u.f3953a.m2955a("com.facebook.apptab.ui.MAINTAB_CHROME_DRAWN");
    }

    public static void m5962O(FbMainTabActivity fbMainTabActivity) {
        if (fbMainTabActivity.mo813p() != null && fbMainTabActivity.mo813p().m13748e() != null) {
            Rect rect = new Rect();
            fbMainTabActivity.mo813p().m13748e().getGlobalVisibleRect(rect);
            fbMainTabActivity.bD.scrollBy(rect.left, 0);
            if (rect.left != 0) {
                HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("harrison_scroll_correction");
                honeyClientEvent.m5083a("scrolled_by", rect.left);
                ((AnalyticsLogger) fbMainTabActivity.f3712w.get()).mo526a(honeyClientEvent);
            }
        }
    }

    private void m5963P() {
        Class cls = FbMainTabActivity.class;
        int i = 0;
        for (Entry b : this.ae.f2114b) {
            int i2;
            if (b.m12860b().getClass().equals(cls)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        int i3 = i;
        if (!bm && i3 > 2) {
            ((AbstractFbErrorReporter) this.f3690L.get()).m2340a(bk.getSimpleName(), "multiple FbMainTabActivities: " + i3);
            bm = true;
        }
    }

    @Nullable
    public final FbFragment mo783a() {
        return mo813p();
    }

    private FragmentStackDebugInfo m5964Q() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.bu != null) {
            int i = 1;
            for (TabTag tabTag : this.bu) {
                if (i == 0) {
                    stringBuilder.append('\n');
                }
                String name = tabTag.name();
                stringBuilder.append(name);
                if (name.equals(this.by)) {
                    stringBuilder.append(" (current)");
                }
                stringBuilder.append(": ");
                FbChromeFragment f = m6027f(this, name);
                if (f != null) {
                    Fragment aq = f.aq();
                    if (aq != null) {
                        stringBuilder.append(aq.getClass().getSimpleName());
                        i = 0;
                    } else {
                        stringBuilder.append("Chrome fragment loaded, content fragment not loaded.");
                    }
                }
                i = 0;
            }
        }
        return new FragmentStackDebugInfo(0, stringBuilder.toString());
    }

    public static void m5965R(FbMainTabActivity fbMainTabActivity) {
        if (fbMainTabActivity.f3690L != null) {
            FragmentStackDebugInfo Q = fbMainTabActivity.m5964Q();
            ((AbstractFbErrorReporter) fbMainTabActivity.f3690L.get()).mo345c("harrison_fragment_count", Integer.toString(Q.f8670a));
            ((AbstractFbErrorReporter) fbMainTabActivity.f3690L.get()).mo345c("harrison_fragment_stacks", Q.f8671b);
            ((AbstractFbErrorReporter) fbMainTabActivity.f3690L.get()).mo345c("harrison_current_tab", fbMainTabActivity.by != null ? fbMainTabActivity.by : "None");
        }
    }

    public static void m5966S(FbMainTabActivity fbMainTabActivity) {
        if (Objects.equal(fbMainTabActivity.bz, fbMainTabActivity.by)) {
            fbMainTabActivity.m6022d(fbMainTabActivity.by);
            return;
        }
        fbMainTabActivity.bz = fbMainTabActivity.by;
        for (int i = 0; i < fbMainTabActivity.bu.size(); i++) {
            TabTag tabTag = (TabTag) fbMainTabActivity.bu.get(i);
            String name = tabTag.name();
            FbChromeFragment f = m6027f(fbMainTabActivity, name);
            if (f != null) {
                TabView tabView = (TabView) fbMainTabActivity.bx.get(name);
                if (tabView != null) {
                    fbMainTabActivity.m5983a(tabTag, tabView);
                }
                fbMainTabActivity.m5992a(f, i);
            }
        }
        Fragment p = fbMainTabActivity.mo813p();
        if (p != null) {
            p.mo1860g(true);
        }
    }

    private void m6022d(String str) {
        if (!StringUtil.m3589a((CharSequence) str)) {
            ((TabView) this.bx.get(str)).m11623a(getString(TabTag.fromName(str).descriptorResourceId), this.bL == this.bu.indexOf(TabTag.fromName(str)));
        }
    }

    public static void m6025e(FbMainTabActivity fbMainTabActivity, String str) {
        for (int i = 0; i < fbMainTabActivity.bu.size(); i++) {
            String name = ((TabTag) fbMainTabActivity.bu.get(i)).name();
            if (!Objects.equal(str, name)) {
                fbMainTabActivity.m6022d(name);
            }
        }
    }

    private void m5992a(FbChromeFragment fbChromeFragment, int i) {
        int i2;
        if (this.bL != -1) {
            if (i == this.bL) {
                i2 = 2;
            } else if (i == this.bL - 1 || i == this.bL + 1) {
                i2 = 1;
            }
            if (fbChromeFragment.al == i2) {
                fbChromeFragment.al = i2;
                if (fbChromeFragment.hn_()) {
                    if (fbChromeFragment.al != 2 || fbChromeFragment.al == 1) {
                        fbChromeFragment.m13745a(false);
                    }
                    return;
                }
            }
        }
        i2 = 0;
        if (fbChromeFragment.al == i2) {
            fbChromeFragment.al = i2;
            if (fbChromeFragment.hn_()) {
                if (fbChromeFragment.al != 2) {
                }
                fbChromeFragment.m13745a(false);
            }
        }
    }

    public static void m5967T(FbMainTabActivity fbMainTabActivity) {
        if (fbMainTabActivity.bp && fbMainTabActivity.m5968U()) {
            fbMainTabActivity.ab();
        }
    }

    private boolean m5968U() {
        long d = this.ae.m4307d();
        if (d == 0 || !m5969V()) {
            return this.bn.asBoolean(false);
        }
        if (this.f3685G.now() - d > m5972Y()) {
            this.bn = TriState.YES;
        }
        return this.bn.asBoolean(false);
    }

    private boolean m5969V() {
        return m5970W() && m5971X();
    }

    private boolean m5970W() {
        return this.by.equals(TabTag.Notifications.name()) || this.by.equals(TabTag.FriendRequests.name()) || this.by.equals(TabTag.Bookmark.name());
    }

    private boolean m5971X() {
        return this.aU.mo596a(ExperimentsForNewsFeedAbTestModule.f5106g, false);
    }

    private long m5972Y() {
        return ((long) this.aU.mo572a(ExperimentsForNewsFeedAbTestModule.f5105f, 0)) * 1000;
    }

    private void m5973Z() {
        if (this.bo.asBoolean(false)) {
            aa();
        }
        this.bo = TriState.UNSET;
    }

    private void aa() {
        if (mo797j()) {
            NewsFeedFragment m = mo800m();
            if (m.aE()) {
                if (!m.ax().m9690f()) {
                    m.ax().m9692h();
                }
                m.ax().m9693i();
                m.bF.m16847u();
                m.f9010i.mo2391h(0);
                m.aw = true;
                m.f9010i.mo2367b(new 6(m));
            }
        }
    }

    public final void m6078i() {
        this.bD.setCurrentItem(this.bu.indexOf(TabTag.Feed));
        this.bn = TriState.UNSET;
        if (ac()) {
            NewsFeedSwitcherFragment newsFeedSwitcherFragment = (NewsFeedSwitcherFragment) mo813p().aq();
            if (newsFeedSwitcherFragment.at != null && !newsFeedSwitcherFragment.ar()) {
                NewsFeedSwitcherFragment.g(newsFeedSwitcherFragment, NewsFeedSwitcherFragment.a(newsFeedSwitcherFragment, newsFeedSwitcherFragment.aE.b));
            }
        }
    }

    private void ab() {
        aB();
        m6078i();
        aa();
    }

    private boolean ac() {
        return mo813p() != null && (mo813p().aq() instanceof NewsFeedSwitcherFragment);
    }

    private void ad() {
        if (mo797j()) {
            FeedUnitCollection ax = mo800m().ax();
            if (ax != null) {
                ax.m9696m();
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("clearCacheResetFeedLoader", true);
        Futures.m2458a(BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.ao.get(), "feed_clear_cache", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.m9060a(getClass()), -1288840474).mo3452a(), new 27(this), (Executor) this.ap.get());
    }

    public static void ae(FbMainTabActivity fbMainTabActivity) {
        FbChromeFragment p = fbMainTabActivity.mo813p();
        if (p != null && p.aq() != null && (p.aq() instanceof NotificationsFragment)) {
            ((NotificationsFragment) p.aq()).e();
        }
    }

    public static void af(FbMainTabActivity fbMainTabActivity) {
        if (fbMainTabActivity.bX && fbMainTabActivity.mo797j()) {
            fbMainTabActivity.mo800m().mo1901e();
            fbMainTabActivity.bX = false;
        }
    }

    public final boolean mo797j() {
        FbChromeFragment p = mo813p();
        if (p == null || p.aq() == null) {
            return false;
        }
        if (p.aq() instanceof NewsFeedFragment) {
            return true;
        }
        return (p.aq() instanceof NewsFeedSwitcherFragment) && ((NewsFeedSwitcherFragment) p.aq()).ar();
    }

    public final NewsFeedFragment mo800m() {
        if (!mo797j()) {
            return null;
        }
        FbChromeFragment p = mo813p();
        if (p.aq() instanceof NewsFeedFragment) {
            return (NewsFeedFragment) p.aq();
        }
        NewsFeedFragment newsFeedFragment;
        NewsFeedSwitcherFragment newsFeedSwitcherFragment = (NewsFeedSwitcherFragment) p.aq();
        if (newsFeedSwitcherFragment.ar()) {
            newsFeedFragment = (NewsFeedFragment) newsFeedSwitcherFragment.au.a(0);
        } else {
            newsFeedFragment = null;
        }
        return newsFeedFragment;
    }

    private ViewGroup ag() {
        return this.bB;
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        int i3 = 65535 & i;
        Fragment p = mo813p();
        if (p != null && p.aq() != null) {
            p.mo1858a(i3, i2, intent);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f3704Z.m2189a(413, false)) {
            this.bE.m12635b(this.by);
        }
        bundle.putBoolean("open_divebar", ((DrawerBasedDivebarControllerImpl) this.f3682D.get()).kX_());
        super.onSaveInstanceState(bundle);
    }

    private void m5981a(TabTag tabTag, int i, boolean z) {
        m5982a(tabTag, i, z, null);
    }

    private void m5982a(TabTag tabTag, int i, boolean z, @Nullable Boolean bool) {
        FbChromeFragment p = mo813p();
        if (i <= 0 || p == null || !Objects.equal(tabTag.name(), ((TabTag) this.bu.get(this.bD.f6409k)).name()) || z) {
            TabView tabView = (TabView) this.bx.get(tabTag.name());
            if (tabView != null) {
                if (tabTag == TabTag.VideoHome) {
                    boolean z2;
                    if (((VideoHomeMetadataFetcher) this.aT.get()).f22150t < 99) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    tabView.f7160d = z2;
                } else if (bool != null) {
                    tabView.f7160d = bool.booleanValue();
                }
                tabView.setUnreadCount(i);
                m5983a(tabTag, tabView);
                Object obj = (tabTag == TabTag.Notifications || tabTag == TabTag.NotificationsFriending) ? 1 : null;
                if (!(i == 0 || obj == null)) {
                    HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("jewel_lit_up");
                    honeyClientEvent.m5090b("jewel_name", tabTag.name());
                    honeyClientEvent.m5083a("jewel_count", i);
                    ((AnalyticsLogger) this.f3712w.get()).mo526a(honeyClientEvent);
                }
                if (tabTag == TabTag.Marketplace) {
                    ((MarketplaceBadgeCountManager) this.aO.get()).a();
                }
            }
        }
    }

    private void ah() {
        TracerDetour.a("FbMainTabActivity.setupAudioConfigurator", 719096568);
        try {
            ViewGroup viewGroup = (ViewGroup) FbRootViewUtil.m13815a(this.ba);
            this.bU = (AudioConfigurator) ((ViewGroup) ((LayoutInflater) this.ag.get()).inflate(2130903319, viewGroup, false)).findViewById(2131559750);
            viewGroup.addView(this.bU);
            this.bU.setFbSharedPreferences(this.aH);
            this.bU.setVisibility(0);
        } finally {
            TracerDetour.a(-1608096902);
        }
    }

    public static void ai(FbMainTabActivity fbMainTabActivity) {
        ViewGroup viewGroup = (ViewGroup) FbRootViewUtil.m13815a(fbMainTabActivity.ba);
        if (viewGroup.findViewById(2131568420) == null) {
            ((LayoutInflater) fbMainTabActivity.ag.get()).inflate(2130907712, viewGroup, true);
        }
    }

    protected final void mo784a(Intent intent) {
        super.mo784a(intent);
        m6014c(intent);
    }

    private void m6014c(Intent intent) {
        TracerDetour.a("FbMainTabActivity.handleNewIntent", 548977818);
        try {
            Intent a = this.aj.m8240a(intent);
            if (this.f3682D.get() != null) {
                if (a.getBooleanExtra("open_divebar", false)) {
                    ((DrawerBasedDivebarControllerImpl) this.f3682D.get()).m12888a(a);
                    m6053w();
                } else {
                    ((DrawerBasedDivebarControllerImpl) this.f3682D.get()).m12894g();
                }
            }
            if (a.getBooleanExtra("refresh_feed", false) && mo797j()) {
                mo800m().m13866a(FetchFeedCause.PULL_TO_REFRESH);
            }
            if (this.aj.m8242b(a)) {
                m6068b(a);
            }
            TracerDetour.a(-1639492758);
        } catch (Throwable th) {
            TracerDetour.a(-1612877982);
        }
    }

    public final void m6068b(Intent intent) {
        intent.setExtrasClassLoader(getClass().getClassLoader());
        String stringExtra = intent.getStringExtra("target_tab_name");
        if (m6071b(stringExtra)) {
            this.bn = TriState.NO;
            this.bV.m12674a(this.bD.f6409k);
        }
        if (!intent.hasExtra("POP_TO_ROOT") || stringExtra == null || !stringExtra.equals(TabTag.Feed.name())) {
            return;
        }
        if (intent.hasExtra("clear_feed_cache")) {
            ad();
        } else if (intent.hasExtra("jump_to_top")) {
            aa();
        }
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1306493802);
        m6033h("MainTabActivityOnResume");
        TracerDetour.a("FbMainTabActivity.onResume", -405771022);
        try {
            super.onResume();
            aD();
            m5973Z();
            m6010b(TabTag.Feed.name().equals(this.by));
            m5945B();
            m6059z();
            m5942A();
            m5955H();
            m5960M(this);
            if (m5968U()) {
                ab();
            }
            this.bp = true;
            this.aJ.m4871a(MessageNotificationPeerContract.f2842h, this.ce);
            if (this.bF != null && this.bF.a()) {
                this.bF.d();
            }
            aj();
            m5963P();
            m5965R(this);
            aw();
            this.bV.m12674a(this.bD.getCurrentItem());
            this.aB.mo1264c();
            this.ax.m8367a(this.bY).m8365a(ZeroFeatureKey.FB4A_INDICATOR);
            this.ax.m8368a();
            this.ay.m8413a(this.bZ);
            this.ay.m8416b(this.ca);
            this.ay.m8411a();
            this.aA.m8572c();
            if (!this.ck) {
                if (this.cl) {
                    this.f3707r.m3345a();
                }
                this.f3707r.m3363e();
            }
            m6035i("MainTabActivityOnResume");
            m6035i("MainTabActivityEndToEnd");
        } finally {
            TracerDetour.a(1085674073);
            LogUtils.c(1601061803, a);
        }
    }

    private void aj() {
        if (al(this)) {
            ((VideoHomeMetadataFetcher) this.aT.get()).m30031e();
        }
    }

    @Nullable
    public final FbChromeFragment mo813p() {
        return this.bE != null ? (FbChromeFragment) this.bE.m12643b(this.bD.f6409k) : null;
    }

    public final boolean mo788a(FbFragment fbFragment) {
        return mo813p() == fbFragment;
    }

    @Nullable
    public static FbChromeFragment m6027f(FbMainTabActivity fbMainTabActivity, String str) {
        if (fbMainTabActivity.bE == null) {
            return null;
        }
        return (FbChromeFragment) fbMainTabActivity.bE.m12643b(fbMainTabActivity.m6030g(str));
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1383177204);
        this.bd.m4264g(bk.getSimpleName());
        if (!this.ck) {
            this.f3707r.m3345a();
        }
        this.bp = false;
        super.onPause();
        this.bW = false;
        this.aJ.m4873a(this.ce);
        if (this.bF != null && this.bF.a()) {
            this.bF.e();
        }
        this.bn = TriState.UNSET;
        this.aB.mo1265d();
        this.ax.m8369b();
        this.ax.f4614o = null;
        this.ay.m8415b();
        this.ay.m8418c(this.bZ);
        this.ay.m8420d(this.ca);
        this.aA.m8574e();
        this.bd.m4265h(bk.getSimpleName());
        m6010b(false);
        m5956I();
        ak();
        m5954G();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1775171472, a);
    }

    private void ak() {
        if (al(this)) {
            VideoHomeMetadataFetcher videoHomeMetadataFetcher = (VideoHomeMetadataFetcher) this.aT.get();
            if (videoHomeMetadataFetcher.f22133b != null) {
                VideoHomeSubscriptionsGraphQLHelper videoHomeSubscriptionsGraphQLHelper = (VideoHomeSubscriptionsGraphQLHelper) videoHomeMetadataFetcher.f22136f.get();
                GraphQLSubscriptionHandle graphQLSubscriptionHandle = videoHomeMetadataFetcher.f22133b;
                Set hashSet = new HashSet();
                hashSet.add(graphQLSubscriptionHandle);
                videoHomeSubscriptionsGraphQLHelper.f22160b.m9388a(hashSet);
                videoHomeMetadataFetcher.f22133b = null;
            }
            LiveUpdatesManager liveUpdatesManager = (LiveUpdatesManager) videoHomeMetadataFetcher.f22143m.get();
            if (liveUpdatesManager.f22169b.f9151b) {
                BroadcastStatusUpdateManager broadcastStatusUpdateManager = (BroadcastStatusUpdateManager) liveUpdatesManager.f22168a.get();
                if (broadcastStatusUpdateManager.f22176g != null) {
                    broadcastStatusUpdateManager.f22176g.m3297c();
                    broadcastStatusUpdateManager.f22176g = null;
                }
                if (!broadcastStatusUpdateManager.f22173d.isEmpty()) {
                    Map hashMap = new HashMap(broadcastStatusUpdateManager.f22173d.size());
                    for (VideoTracker videoTracker : broadcastStatusUpdateManager.f22173d.values()) {
                        if (videoTracker.d != null) {
                            hashMap.put(videoTracker.b, videoTracker.d);
                            videoTracker.d = null;
                        }
                    }
                    hashMap.keySet();
                    ((VideoHomeSubscriptionsGraphQLHelper) broadcastStatusUpdateManager.f22172c.get()).f22160b.m9388a(new HashSet(hashMap.values()));
                }
            }
        }
    }

    public static boolean al(FbMainTabActivity fbMainTabActivity) {
        return fbMainTabActivity.aU.mo596a(ExperimentsForVideoHomeAbTestModule.f7002p, false);
    }

    public static boolean am(FbMainTabActivity fbMainTabActivity) {
        return fbMainTabActivity.aU.mo596a(ExperimentsForMarketplaceTabAbtestModule.f7031a, false);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.bF != null) {
            this.bF.u_(i);
        }
        if (i == 82) {
            FbChromeFragment p = mo813p();
            if (p != null) {
                Fragment aq = p.aq();
                if ((aq instanceof ImmersiveReactFragment) && ((ImmersiveReactFragment) aq).a()) {
                    return true;
                }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    private void m5980a(final TabTag tabTag) {
        TracerDetour.a("addTab(%s)", tabTag.name(), -409263569);
        LoomLogger.a(LoomLoggerDetour.a(-279973905), "addTab", tabTag.name());
        try {
            TabView tabView = new TabView(this);
            tabView.setupTabTag(tabTag);
            if (tabTag.equals(TabTag.Feed) && an()) {
                tabView.setOnLongClickListener(new 28(this));
            }
            if (TabTag.isNotificationsTabTag(tabTag) && an()) {
                tabView.setOnLongClickListener(new 29(this));
            }
            if (tabTag.equals(TabTag.Bookmark) && an()) {
                tabView.setOnLongClickListener(new 30(this));
            }
            if (tabTag.equals(TabTag.VideoHome) && an()) {
                tabView.setOnLongClickListener(new 31(this));
            }
            if (tabTag.equals(TabTag.Notifications)) {
                ImmutableLocation a = this.am.m8245a();
                if (a != null) {
                    double b = a.m11985b();
                    if (b >= 60.0d) {
                        tabView.setTabIconImageResource(TabTag.Notifications_japan.drawableResourceId);
                    } else if (b >= -30.0d) {
                        tabView.setTabIconImageResource(TabTag.Notifications_east.drawableResourceId);
                    }
                }
            }
            tabView.setId(tabTag.tabViewId);
            tabView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FbMainTabActivity f7350b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1046260287);
                    this.f7350b.bJ = true;
                    ((NavigationLogger) this.f7350b.f3713x.get()).m5498a("tap_top_jewel_bar");
                    String name = ((TabTag) this.f7350b.bu.get(this.f7350b.bD.f6409k)).name();
                    this.f7350b.m6071b(tabTag.name());
                    if (!FbMainTabActivity.m6011b(tabTag)) {
                        this.f7350b.m6073c(tabTag.name());
                    }
                    if (name.equals(tabTag.name())) {
                        AppTabBarBroadcaster appTabBarBroadcaster = this.f7350b.f3710u;
                        appTabBarBroadcaster.f3953a.mo406a(new Intent().setAction("com.facebook.apptab.ui.TAB_BAR_ITEM_TAP").putExtra("tab_bar_tap", tabTag.name()));
                    } else {
                        if (tabTag.equals(TabTag.Feed)) {
                            this.f7350b.aL.m8783a();
                        }
                        if (TabTag.VideoHome.name().equals(name)) {
                            ((RapidFeedbackController) this.f7350b.aP.get()).m14997a("996145670432082", this.f7350b.ba);
                        }
                    }
                    LogUtils.a(2083884224, a);
                }
            });
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
            m5983a(tabTag, tabView);
            this.bB.addView(tabView, layoutParams);
            this.bx.put(tabTag.name(), tabView);
        } finally {
            TracerDetour.a(-1090980211);
        }
    }

    private boolean an() {
        return this.ab.get() == TriState.YES || this.ac.get() == TriState.YES;
    }

    private static boolean m6011b(TabTag tabTag) {
        return tabTag == TabTag.Feed;
    }

    public static boolean ao(FbMainTabActivity fbMainTabActivity) {
        return ((ForceMessenger) fbMainTabActivity.aN.get()).a();
    }

    private void m5983a(@Nonnull TabTag tabTag, @Nonnull TabView tabView) {
        tabView.m11623a(getString(tabTag.descriptorResourceId), this.bL == this.bu.indexOf(tabTag));
    }

    public final boolean m6071b(@Nullable String str) {
        int g = m6030g(str);
        if (g == -1) {
            return false;
        }
        this.bD.setCurrentItem(g);
        return true;
    }

    private void ap() {
        TracerDetour.a("FbMainTabActivity.onCreateSetupTitleBar", -492019482);
        try {
            this.f3688J.m6586a(this.bA);
            this.bA.setOnSearchClickListener(new OnClickListener(this) {
                final /* synthetic */ FbMainTabActivity f7377a;

                {
                    this.f7377a = r1;
                }

                public void onClick(View view) {
                    Fragment aq;
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1151677461);
                    MainTabNuxController mainTabNuxController = this.f7377a.f3694P.f4255b;
                    if (mainTabNuxController.m7891h()) {
                        FbMainTabActivityNuxController.m7882a(mainTabNuxController, State.HIDDEN);
                    }
                    ((NavigationLogger) this.f7377a.f3713x.get()).m5498a("tap_search_bar");
                    if (this.f7377a.mo813p() != null) {
                        aq = this.f7377a.mo813p().aq();
                    } else {
                        aq = null;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("title_bar_primary_button_spec", this.f7377a.bA.getPrimaryButtonSpec());
                    bundle.putParcelable("title_bar_secondary_button_spec", this.f7377a.bA.getSecondaryButtonSpec());
                    bundle.putBoolean("is_awareness_unit_eligible_intent_flag", TabTag.Feed.equals(this.f7377a.bu.get(this.f7377a.bD.f6409k)));
                    ((GraphSearchTitleBarController) this.f7377a.f3679A.get()).a(aq, ContentFragmentType.MAINTAB, bundle);
                    Logger.a(2, EntryType.UI_INPUT_END, 1194344907, a);
                }
            });
            this.bA.mo1610f();
            this.bA.m11432a(SearchBoxType.DEFAULT);
            if (this.aq.booleanValue()) {
                as();
            } else {
                at();
            }
            this.bA.setTitle(((TabTag) this.bu.get(this.bD.getCurrentItem())).descriptorResourceId);
        } finally {
            TracerDetour.a(-1665742179);
        }
    }

    private boolean aq() {
        return (this.bQ == -1 && this.bR == -1) ? false : true;
    }

    public static void ar(FbMainTabActivity fbMainTabActivity) {
        if (fbMainTabActivity.aq()) {
            int i = fbMainTabActivity.bD.f6409k;
            if (!fbMainTabActivity.bS) {
                fbMainTabActivity.bA.setTitle(((TabTag) fbMainTabActivity.bu.get(i)).descriptorResourceId);
                fbMainTabActivity.bA.m11435c(i == fbMainTabActivity.bQ);
            }
            if (fbMainTabActivity.bS && i == fbMainTabActivity.bQ) {
                fbMainTabActivity.bA.m11439i();
            } else if (i == fbMainTabActivity.bR) {
                fbMainTabActivity.bA.m11440j();
            } else {
                fbMainTabActivity.bA.mo1611h();
            }
        }
    }

    private void as() {
        34 34 = new 34(this);
        this.bA.setPrimaryButton(av());
        this.bA.setActionButtonOnClickListener(34);
    }

    private void at() {
        OnActionButtonClickListener anonymousClass35 = new OnActionButtonClickListener(this) {
            final /* synthetic */ FbMainTabActivity f7572a;

            {
                this.f7572a = r1;
            }

            public final void mo1673a(View view) {
                if (!FbMainTabActivity.ao(this.f7572a)) {
                    this.f7572a.f3683E.m6561a(Jewel.INBOX, 0);
                }
                if ((((ForceMessenger) this.f7572a.aN.get()).c() || ((ForceMessenger) this.f7572a.aN.get()).b()) && this.f7572a.aU.mo596a(ExperimentsForForceMessengerModule.a, false)) {
                    ((SecureContextHelper) this.f7572a.f3681C.get()).mo662a(new Intent("android.intent.action.VIEW", Uri.parse(MessengerLinks.c + "accounts/triggersso")), this.f7572a.ba);
                    return;
                }
                ((SecureContextHelper) this.f7572a.f3681C.get()).mo665b(((Fb4aUriIntentMapper) this.f7572a.f3708s.get()).mo1267a(this.f7572a.ba, FBLinks.f2140O), this.f7572a.ba);
            }
        };
        OnActionButtonClickListener anonymousClass36 = new OnActionButtonClickListener(this) {
            final /* synthetic */ FbMainTabActivity f7573a;

            {
                this.f7573a = r1;
            }

            public final void mo1673a(View view) {
                this.f7573a.m6053w();
            }
        };
        List a = Lists.m1296a();
        a.add(av());
        a.add(au());
        this.bA.setButtonSpecs(a);
        this.bA.m11452a(anonymousClass35, anonymousClass36);
    }

    private TitleBarButtonSpec au() {
        TitleBarButtonSpec a;
        DivebarButtonSpecUtil divebarButtonSpecUtil = this.be;
        Resources resources = getResources();
        if (divebarButtonSpecUtil.f4923a.f4924a.m7793a()) {
            RedSpaceDivebarButtonSpecUtil redSpaceDivebarButtonSpecUtil = divebarButtonSpecUtil.f4923a;
            TitleBarButtonSpec.Builder a2 = TitleBarButtonSpec.m12181a();
            a2.f7603j = redSpaceDivebarButtonSpecUtil.f4926c.m8817a();
            a2 = a2;
            a2.f7602i = 2130839884;
            a = a2.m12183a();
        } else {
            TitleBarButtonSpec.Builder a3 = TitleBarButtonSpec.m12181a();
            a3.f7603j = resources.getString(2131233826);
            a3 = a3;
            a3.f7602i = 2130837998;
            a = a3.m12183a();
        }
        return a;
    }

    private TitleBarButtonSpec av() {
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.m12181a();
        a.f7603j = getString(2131236462);
        a = a;
        a.f7602i = AppGlyphResolver.m12184a();
        return a.m12183a();
    }

    private void aw() {
        if (mo813p() != null && this.bt) {
            this.bt = false;
            this.bA.m11434b(false);
        }
    }

    private int m6030g(@Nullable String str) {
        int i = 0;
        if (str == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.bu.size(); i2++) {
            if (((TabTag) this.bu.get(i2)).name().equals(str)) {
                return i2;
            }
        }
        if (TabTag.isNotificationsTabTagName(str)) {
            while (i < this.bu.size()) {
                if (TabTag.isNotificationsTabTag((TabTag) this.bu.get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public final void m6073c(String str) {
        TabTag valueOf = TabTag.valueOf(str);
        m5981a(valueOf, 0, false);
        if (valueOf == TabTag.Feed) {
            this.bN = 0;
        } else if (valueOf == TabTag.RedSpace) {
            ((RedSpaceBadgeCountManager) this.aQ.get()).d();
        } else if (valueOf == TabTag.VideoHome) {
            ((VideoHomeBadgeUpdater) ((VideoHomeMetadataFetcher) this.aT.get()).f22140j.get()).d();
        } else if (valueOf == TabTag.Marketplace) {
            ((MarketplaceBadgeCountManager) this.aO.get()).b();
        }
    }

    private void m5993a(Jewel jewel, int i) {
        BadgableGlyphView badgablePrimaryActionButtonView;
        if (this.bv.containsKey(jewel)) {
            m5981a((TabTag) this.bv.get(jewel), i, false);
        }
        if (jewel.equals(Jewel.INBOX)) {
            badgablePrimaryActionButtonView = this.bA.getBadgablePrimaryActionButtonView();
        } else if (jewel.equals(Jewel.BACKSTAGE) && ax()) {
            badgablePrimaryActionButtonView = this.bA.getBadgableSecondaryActionButtonView();
        } else if (jewel.equals(Jewel.REDSPACE) && ((RedSpaceEntryPointCapability) this.aR.get()).m7793a()) {
            BadgableGlyphView badgableSecondaryActionButtonView = this.bA.getBadgableSecondaryActionButtonView();
            if (badgableSecondaryActionButtonView != null) {
                badgableSecondaryActionButtonView.setContentDescription(((RedSpaceEntryDescriptionHelper) this.aS.get()).a(i));
            }
            m6005b(i);
            badgablePrimaryActionButtonView = badgableSecondaryActionButtonView;
        } else {
            badgablePrimaryActionButtonView = null;
        }
        if (badgablePrimaryActionButtonView != null) {
            badgablePrimaryActionButtonView.setUnreadCount(i);
        }
    }

    private boolean ax() {
        return this.f3704Z.m2189a(15, false);
    }

    private static Bundle m5974a(Intent intent, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("launched_from_tab", true);
        bundle.putBoolean("passed_from_tab", true);
        bundle.putString("current_tab_name_in_focus", str);
        bundle.putParcelable("tab_root_intent", intent);
        return bundle;
    }

    public static void m6020d(FbMainTabActivity fbMainTabActivity, int i) {
        Object obj;
        if (fbMainTabActivity.bI) {
            ((NavigationLogger) fbMainTabActivity.f3713x.get()).m5498a("swipe");
            obj = "swipe";
        } else if (fbMainTabActivity.bJ) {
            obj = "tap";
        } else {
            obj = "other";
        }
        fbMainTabActivity.bI = false;
        fbMainTabActivity.bJ = false;
        String name = ((TabTag) fbMainTabActivity.bu.get(i)).name();
        String name2 = ((TabTag) fbMainTabActivity.bu.get(fbMainTabActivity.bL)).name();
        FbChromeFragment f = m6027f(fbMainTabActivity, name);
        if (f != null && f.aq() != null) {
            ((NavigationLogger) fbMainTabActivity.f3713x.get()).m5504a((Activity) fbMainTabActivity, ImmutableMap.of("tab_src_position", String.valueOf(fbMainTabActivity.bL), "tab_dest_position", String.valueOf(i), "tab_src_name", name2, "tab_dest_name", name, "tab_change_action", obj));
        }
    }

    public void onBackPressed() {
        ((NavigationLogger) this.f3713x.get()).m5498a("tap_back_button");
        if (!((DrawerBasedDivebarControllerImpl) this.f3682D.get()).kY_()) {
            if ((this.bF == null || !this.bF.b()) && !az() && !ay()) {
                if (this.bD != null && !this.by.equals(TabTag.Feed.name())) {
                    this.bD.setCurrentItem(m6030g(TabTag.Feed.name()));
                    this.aL.m8783a();
                } else if (PerfTestConfigBase.f1508c || !moveTaskToBack(true)) {
                    super.onBackPressed();
                } else {
                    this.bo = TriState.YES;
                }
            }
        }
    }

    private boolean ay() {
        FbChromeFragment p = mo813p();
        if (p == null) {
            return false;
        }
        Fragment aq = p.aq();
        return aq != null && (aq instanceof CanHandleBackPressed) && ((CanHandleBackPressed) aq).O_();
    }

    private boolean az() {
        if (m5976a(kO_(), "chromeless:content:fragment:tag") instanceof IFlyoutInterface) {
            return true;
        }
        return false;
    }

    private static Fragment m5976a(FragmentManager fragmentManager, String str) {
        Fragment a = fragmentManager.mo841a(str);
        return (a == null || !a.m282z()) ? null : a;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.cc) {
            this.f3682D.get();
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131428128);
            DisplayUtils.m13107a(this.bB, dimensionPixelSize);
            aA();
            if (!this.aZ.booleanValue() && this.bT) {
                ((FrameLayout.LayoutParams) this.bD.getLayoutParams()).setMargins(0, 0, 0, dimensionPixelSize);
                ((FrameLayout.LayoutParams) this.bC.getLayoutParams()).setMargins(0, 0, 0, dimensionPixelSize);
            }
        }
    }

    private void aA() {
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131428126);
        resources.getDimensionPixelSize(2131428125);
        int size = this.bu.size();
        ColumnWidthConfig b = this.aE.m8718b(FragmentConstants$ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT);
        if (this.aD.m7863i()) {
            int dimensionPixelOffset;
            dimensionPixelSize = (dimensionPixelSize * size) + ((size - 1) * resources.getDimensionPixelSize(2131429225));
            View a = mo2563a(2131563657);
            a.setPadding(b.m12010h(), a.getPaddingTop(), b.m12011i(), a.getPaddingBottom());
            this.bB.getLayoutParams().width = dimensionPixelSize;
            if (b.m12008a()) {
                dimensionPixelOffset = resources.getDimensionPixelOffset(2131429227) + b.f7373b;
            } else {
                dimensionPixelOffset = Math.max((((this.aC.m8702c() - dimensionPixelSize) - b.m12010h()) - b.m12011i()) - resources.getDimensionPixelSize(2131429224), resources.getDimensionPixelSize(2131429223));
            }
            this.bA.getLayoutParams().width = dimensionPixelOffset;
        }
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -622515855);
        if (this.ch != null) {
            this.ch.m7831m();
        }
        if (this.br != null) {
            this.br.m3297c();
        }
        if (this.bs != null) {
            this.bs.m3297c();
        }
        if (this.ae != null) {
            this.ae.m4305c();
        }
        if (!(this.f3683E == null || this.bw == null)) {
            this.f3683E.m6563b(this.bw);
        }
        this.bF = null;
        if (this.f3690L != null) {
            AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) this.f3690L.get();
            if (abstractFbErrorReporter != null) {
                abstractFbErrorReporter.mo337a("harrison_fragment_count");
                abstractFbErrorReporter.mo337a("harrison_fragment_stacks");
                abstractFbErrorReporter.mo337a("harrison_current_tab");
            }
        }
        if (this.cj != null) {
            stopService(new Intent(this.ba, VideoPlayerService.class));
        }
        m6010b(false);
        if (this.bA != null) {
            this.bA.mo1243g();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2147307134, a);
    }

    @Nullable
    public final DrawerBasedDivebarControllerImpl mo794f() {
        return this.f3682D != null ? (DrawerBasedDivebarControllerImpl) this.f3682D.get() : null;
    }

    public Map<String, String> getDebugInfo() {
        Builder builder = ImmutableMap.builder();
        FbChromeFragment p = mo813p();
        if (p != null) {
            Map debugInfo = p.getDebugInfo();
            if (debugInfo != null) {
                builder.m608a(debugInfo);
            }
        }
        FragmentStackDebugInfo Q = m5964Q();
        builder.m609b("harrison_fragment_stacks", Q.f8671b);
        builder.m609b("harrison_fragment_count", String.valueOf(Q.f8670a));
        return builder.m610b();
    }

    public final boolean mo796h() {
        return this.bF != null && this.bF.a();
    }

    public final ImmersiveVideoPlayer mo799l() {
        this.bF = ((ChannelFeedInflater) this.f3696R.get()).a(this);
        return this.bF;
    }

    public final ImmersiveVideoPlayer mo798k() {
        this.bF = ((FullScreenVideoInflater) this.f3695Q.get()).a(this);
        return this.bF;
    }

    public final ImmersiveVideoPlayer mo801n() {
        this.bF = ((VideoWatchAndBrowseInflator) this.f3697S.get()).a(this);
        return this.bF;
    }

    public final boolean mo802o() {
        if (this.bF == null || !this.bF.a()) {
            return false;
        }
        return this.bF.b();
    }

    public void startActivityForResult(Intent intent, int i) {
        Object obj = this.bd != null ? 1 : null;
        if (obj != null) {
            this.bd.m4276s(bk.getSimpleName());
        }
        super.startActivityForResult(intent, i);
        if (obj != null) {
            this.bd.m4251a(bk.getSimpleName(), intent);
        }
    }

    public void startActivity(Intent intent) {
        String str = null;
        if (this.bd != null) {
            str = 1;
        }
        if (str != null) {
            this.bd.m4274q(bk.getSimpleName());
        }
        try {
            if (this.f3698T == null || !((OfflineIntentManager) this.f3698T.get()).a(this, intent, this.bD)) {
                if (this.bc != null) {
                    this.bc.m8809a(intent);
                }
                if (!(this.f3699U == null || intent == null)) {
                    ((EarlyFetchController) this.f3699U.get()).m28206a(intent);
                }
                if (intent != null && intent.getData() != null && intent.getData().toString().contains(FBLinks.eu)) {
                    ((DataSavingsConfirmationDialogBuilder) this.bf.get()).a();
                    if (str != null) {
                        this.bd.m4275r(bk.getSimpleName());
                    }
                } else if (intent != null && intent.getData() != null && intent.getData().toString().contains(FBLinks.ev)) {
                    ((DataSavingsConfirmationDialogBuilder) this.bf.get()).a(this);
                    if (str != null) {
                        this.bd.m4275r(bk.getSimpleName());
                    }
                } else if (intent == null || intent.getData() == null || !intent.getData().toString().contains(FBLinks.ew)) {
                    if (mo813p() != null && intent.getIntExtra("target_fragment", 0) == FragmentConstants$ContentFragmentType.SEARCH_FRAGMENT.ordinal()) {
                        intent.putExtra("search_titles_app_diable_animation", true);
                        intent.putExtra("inflate_fragment_before_animation", true);
                        intent.addFlags(65536);
                        this.bt = true;
                        super.startActivity(intent);
                        overridePendingTransition(0, 0);
                        if (str != null) {
                            this.bd.m4246a(0);
                        }
                    } else if ((intent.getFlags() & 65536) != 0) {
                        super.startActivity(intent);
                        overridePendingTransition(0, 0);
                        if (str != null) {
                            this.bd.m4246a(0);
                        }
                    } else {
                        super.startActivity(intent);
                        int i = AnimationType.SLIDE_LEFT_IN.resource;
                        overridePendingTransition(i, AnimationType.DROP_OUT.resource);
                        if (str != null) {
                            this.bd.m4246a(i);
                        }
                    }
                    if (str != null) {
                        this.bd.m4275r(bk.getSimpleName());
                    }
                } else {
                    ((DataSavingsConfirmationDialogBuilder) this.bf.get()).a(this, findViewById(2131558437));
                    if (str != null) {
                        this.bd.m4275r(bk.getSimpleName());
                    }
                }
            }
        } finally {
            String str2 = str;
            if (str != null) {
                this.bd.m4275r(bk.getSimpleName());
            }
        }
    }

    public final void mo785a(TabTag tabTag, Tooltip tooltip) {
        TabView tabView = (TabView) this.bx.get(tabTag.name());
        if ((tabView instanceof View) && this.bH) {
            tooltip.f(tabView);
        }
    }

    public final void mo786a(Tooltip tooltip) {
        this.bA.m11451a(tooltip);
    }

    private void aB() {
        if (this.bF != null && this.bF.a()) {
            this.bF.setVisibility(4);
        }
        FragmentManager kO_ = kO_();
        if (kO_ != null) {
            Fragment a = kO_.mo841a("chromeless:content:fragment:tag");
            if (a == null) {
                a = kO_.mo841a("PhotoAnimationDialogFragment_MEDIA_GALLERY");
            }
            if (a instanceof UFIPopoverFragment) {
                ((UFIPopoverFragment) a).mE_();
            } else if (a != null) {
                kO_.mo842a().mo1844a(a).mo1847b();
            }
        }
    }

    public static void aC(FbMainTabActivity fbMainTabActivity) {
        TracerDetour.a("FbMainTabActivity.checkForDirectUpdate", 940600822);
        try {
            if (((SelfUpdateChecker) fbMainTabActivity.av.get()).m12687a()) {
                ((SelfUpdateManager) fbMainTabActivity.aw.get()).m12706a();
            }
            ((SelfUpdateManager) fbMainTabActivity.aw.get()).m12707a((Activity) fbMainTabActivity);
        } finally {
            TracerDetour.a(2092067862);
        }
    }

    public final String am_() {
        if (mo813p() == null) {
            return "unknown";
        }
        Fragment aq = mo813p().aq();
        if (aq == null || !(aq instanceof AnalyticsFragment)) {
            return "unknown";
        }
        return ((AnalyticsFragment) aq).am_();
    }

    public final Map<String, Object> mo792c() {
        if (mo813p() == null) {
            return null;
        }
        Fragment aq = mo813p().aq();
        return (aq == null || !(aq instanceof AnalyticsFragmentWithExtraData)) ? null : ((AnalyticsFragmentWithExtraData) aq).mo792c();
    }

    private void aD() {
        if (this.f3682D.get() != null && ((DrawerBasedDivebarControllerImpl) this.f3682D.get()).kX_()) {
            ((NavigationLogger) this.f3713x.get()).m5498a("system_triggered").m5511a(((DrawerBasedDivebarControllerImpl) this.f3682D.get()).m12898l().getAnalyticsTag(), false);
        } else if (this.bF == null || !this.bF.a()) {
            FragmentManager kO_ = kO_();
            if (kO_ != null) {
                int size = bl.size();
                Fragment fragment = null;
                for (int i = 0; i < size; i++) {
                    fragment = kO_.mo841a((String) bl.get(i));
                    if (fragment != null) {
                        break;
                    }
                }
                if (fragment != null && (fragment instanceof AnalyticsActivity)) {
                    ((NavigationLogger) this.f3713x.get()).m5498a("system_triggered").m5511a(((AnalyticsActivity) fragment).am_(), true);
                }
            }
        } else {
            ((NavigationLogger) this.f3713x.get()).m5498a("system_triggered").m5511a("video", true);
        }
    }

    public final void mo793e() {
        if (this.f3701W != null) {
            ((RecyclableViewPoolManager) this.f3701W.get()).a();
        }
    }

    private void m6033h(String str) {
        m5998a(str, false);
    }

    private void m5998a(String str, boolean z) {
        if (this.f3706q.m3462l(655361, "NNFColdStart")) {
            this.f3706q.m3434a(655485, str, z);
        } else if (this.f3706q.m3462l(655364, "NNFWarmStart")) {
            this.f3706q.m3440b(655486, str);
        }
    }

    private void m5996a(String str, long j) {
        m5997a(str, j, null);
    }

    private void m5997a(String str, long j, PerfStats perfStats) {
        if (this.f3706q.m3462l(655361, "NNFColdStart")) {
            this.f3706q.m3432a(655485, str, null, null, j, perfStats, null);
        } else if (this.f3706q.m3462l(655364, "NNFWarmStart")) {
            this.f3706q.m3431a(655486, str, null, null, j);
        }
    }

    private void m6035i(String str) {
        if (this.f3706q.m3462l(655361, "NNFColdStart")) {
            this.f3706q.m3446c(655485, str);
        } else if (this.f3706q.m3462l(655364, "NNFWarmStart")) {
            this.f3706q.m3456f(655486, str);
        }
    }

    private void m6009b(String str, long j) {
        if (this.f3706q.m3462l(655361, "NNFColdStart")) {
            this.f3706q.m3442b(655485, str, null, null, j);
        } else if (this.f3706q.m3462l(655364, "NNFWarmStart")) {
            this.f3706q.m3448c(655486, str, null, null, j);
        }
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1497013015);
        super.onStart();
        if (this.bF != null && this.bF.a()) {
            this.bF.c();
        }
        if (this.aq.booleanValue()) {
            this.bD.post(new 37(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1713155945, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 93429117);
        Object obj = this.bd != null ? 1 : null;
        if (obj != null) {
            this.bd.m4266i(bk.getSimpleName());
        }
        super.onStop();
        if (this.bF != null && this.bF.a()) {
            this.bF.f();
        }
        if (obj != null) {
            this.bd.m4267j(bk.getSimpleName());
        }
        if (this.az != null && this.az.m8544a() && this.bb != null && this.bb.m2266o()) {
            this.ay.m8414a(InfoDismissalReason.NAVIGATION);
        }
        if (this.aq == Boolean.TRUE) {
            PostLoginNuxManager postLoginNuxManager = (PostLoginNuxManager) this.ar.get();
            if (postLoginNuxManager.j != null) {
                postLoginNuxManager.j.cancel(true);
            }
        }
        LogUtils.c(870280226, a);
    }

    private void m5979a(int i, ZeroFeatureKey zeroFeatureKey) {
        if (m6001a(zeroFeatureKey)) {
            if (zeroFeatureKey.equals(ZeroFeatureKey.FB4A_INDICATOR)) {
                this.aA.m8570b();
            } else if (zeroFeatureKey.equals(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE)) {
                this.aA.m8569a(this.ay);
            }
            m6006b(i, zeroFeatureKey);
        }
    }

    private boolean m6001a(ZeroFeatureKey zeroFeatureKey) {
        ZeroFeatureKey b = this.ah.m7925b();
        if (b == null || (b.equals(zeroFeatureKey) && (b.equals(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE) || b.equals(ZeroFeatureKey.FB4A_INDICATOR)))) {
            return true;
        }
        return false;
    }

    private void m6006b(int i, ZeroFeatureKey zeroFeatureKey) {
        if (m6001a(zeroFeatureKey)) {
            this.bO.setPadding(0, i, 0, 0);
            this.bD.post(new Runnable(this) {
                final /* synthetic */ FbMainTabActivity f8769a;

                {
                    this.f8769a = r1;
                }

                public void run() {
                    this.f8769a.bD.requestLayout();
                }
            });
        }
    }

    public final void mo787a(FriendRequestsFragment friendRequestsFragment) {
        aG();
        if (!m6016c(friendRequestsFragment)) {
            return;
        }
        if (friendRequestsFragment.kS_()) {
            FabView fabView = (FabView) this.ci.m12095a();
            fabView.setGlyphID(2130839877);
            fabView.setContentDescription(friendRequestsFragment.d());
            fabView.setOnClickListener(friendRequestsFragment.e());
            aF();
            return;
        }
        aE(this);
    }

    public final void mo791b(FriendRequestsFragment friendRequestsFragment) {
        if (this.ci != null && this.ci.m12097b() && m6016c(friendRequestsFragment)) {
            ((FabView) this.ci.m12095a()).setOnClickListener(null);
        }
    }

    public static void aE(FbMainTabActivity fbMainTabActivity) {
        fbMainTabActivity.aG();
        if (fbMainTabActivity.ch.m7827g(0.0d)) {
            aH(fbMainTabActivity);
        }
        fbMainTabActivity.ch.m7818b(0.0d);
    }

    private void aF() {
        aG();
        ((FabView) this.ci.m12095a()).setVisibility(0);
        this.ch.m7818b(1.0d);
    }

    private void aG() {
        TypedValue typedValue = new TypedValue();
        this.ba.getTheme().resolveAttribute(2130772539, typedValue, true);
        int i = typedValue.data;
        if (this.ci == null) {
            this.ci = new LazyView((ViewStub) mo2563a(2131559221), new 39(this, i));
        }
        if (this.ch == null) {
            this.ch = ((SpringSystem) this.bg.get()).m7838a().m7814a(SpringConfig.m7842a(40.0d, 7.0d)).m7813a(0.0d).m7818b(0.0d).m7830l();
            this.ch.m7815a(new SpringListener(this));
        }
    }

    public static void aH(FbMainTabActivity fbMainTabActivity) {
        if (fbMainTabActivity.ci.m12097b()) {
            FabView fabView = (FabView) fbMainTabActivity.ci.m12095a();
            fabView.setVisibility(8);
            fabView.setOnClickListener(null);
        }
    }

    private boolean m6016c(FriendRequestsFragment friendRequestsFragment) {
        Fragment p = mo813p();
        p = (p == null || !p.mx_()) ? null : p.aq();
        return friendRequestsFragment == p;
    }
}
