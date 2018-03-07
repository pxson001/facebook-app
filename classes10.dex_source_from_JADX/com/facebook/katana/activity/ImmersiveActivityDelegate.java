package com.facebook.katana.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsEventNames;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.apptab.state.TabTag;
import com.facebook.apptab.ui.chrome.FinishHandler;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.activity.AndroidFullscreenInputWorkaround;
import com.facebook.base.activity.AndroidFullscreenInputWorkaround.1;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.ContentFragmentContainer;
import com.facebook.base.fragment.FbFragment;
import com.facebook.checkpoint.CheckpointBroadcaster;
import com.facebook.checkpoint.CheckpointBroadcaster.2;
import com.facebook.checkpoint.api.CheckpointMutation.CheckpointCancelMutationString;
import com.facebook.common.activitycleaner.ActivityStackManager;
import com.facebook.common.activitycleaner.ActivityStackManager.OnApplicationEnteredListener;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.title.IndicatorBarController;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder;
import com.facebook.debug.log.BLog;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.IndicatorVisibilityListener;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.InfoDismissalReason;
import com.facebook.earlyfetch.EarlyFetchController;
import com.facebook.feed.NewsFeedIntentUriBuilder;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.data.FeedDataLoaderInitializer;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.feed.ui.fullscreenvideoplayer.FullScreenVideoInflater;
import com.facebook.friending.jewel.FriendRequestsFragment;
import com.facebook.graphql.calls.CheckpointCancelInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.intentchecker.OfflineIntentManager;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.perf.MainActivityToFragmentCreatePerfLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.ui.QuickPromotionFragment.QuickPromotionFragmentHost;
import com.facebook.search.fragment.GraphSearchFragment;
import com.facebook.search.model.awareness.AwarenessGraphSearchConfiguration;
import com.facebook.search.model.awareness.AwarenessGraphSearchConfiguration.AwarenessUnitType;
import com.facebook.search.titlebar.GraphSearchTitleBarController;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox.SearchBoxType;
import com.facebook.tablet.abtest.SideshowCompatibleContainer;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletColumnLayoutManager.ColumnWidthConfig;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.SideshowHost;
import com.facebook.tablet.sideshow.TypedSideshowFragmentContainer;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.statusbar.StatusBarUtil;
import com.facebook.ui.titlebar.search.Fb4aSearchTitleBar;
import com.facebook.uicontrib.fab.FabView;
import com.facebook.uicontrib.fab.FabViewHost;
import com.facebook.video.channelfeed.ChannelFeedInflater;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseInflator;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.LazyView;
import com.facebook.widget.OnDispatchDrawListener;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxyContainer;
import com.facebook.widget.recycle.ViewPoolCleaner;
import com.facebook.widget.titlebar.FadingContentViewProvider;
import com.facebook.widget.titlebar.FadingTitlebarContent;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.ui.ZeroIndicatorController;
import com.facebook.zero.ui.ZeroIndicatorController.Listener;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: SDKIDFA */
public class ImmersiveActivityDelegate extends Fb4aChromeActivityDelegate implements FinishHandler, ContentFragmentContainer, QuickPromotionFragmentHost, TypedSideshowFragmentContainer, FabViewHost, ViewPoolCleaner, FadingTitlebarContent {
    private static final ImmutableList<String> f24239Q = ImmutableList.of("chromeless:content:fragment:tag", "MediaGalleryDialogFragment_MEDIA_GALLERY", "MediaGalleryDialogFragment_PHOTOS_FEED");
    private static final Class<?> f24240a = ImmersiveActivityDelegate.class;
    private MonotonicClock f24241A;
    private boolean f24242B = false;
    private boolean f24243C = false;
    private boolean f24244D = false;
    private Fragment f24245E;
    public InteractionTTILogger f24246F;
    private ZeroIndicatorController f24247G;
    private Listener f24248H;
    private Lazy<IndicatorBarController> f24249I;
    public DialtoneManualSwitcherController f24250J;
    private IndicatorVisibilityListener f24251K;
    private IndicatorVisibilityListener f24252L;
    private FbZeroFeatureVisibilityHelper f24253M;
    private EarlyFetchController f24254N;
    private Lazy<DataSavingsConfirmationDialogBuilder> f24255O;
    private boolean f24256P = false;
    private String f24257R;
    private ColumnWidthConfig f24258S;
    private int f24259T = 2131558429;
    private LazyView<FabView> f24260U;
    private Provider<TriState> f24261V;
    private CheckpointBroadcaster f24262W;
    private boolean f24263X;
    private boolean f24264Y;
    private TopicFeedsTestUtil f24265Z;
    private StatusBarUtil aa;
    private Fb4aSearchTitleBar ab;
    private boolean ac;
    private AndroidFullscreenInputWorkaround ad;
    public boolean ae = false;
    private QeAccessor af;
    private Lazy<RecyclableViewPoolManager> ag;
    private ActivityStackManager f24266b;
    private FragmentManager f24267c;
    private Provider<ComponentName> f24268d;
    private FbMainTabActivityIntentHelper f24269e;
    private Lazy<InternalIntentSigner> f24270f;
    public Handler f24271g;
    private FragmentFactoryMap f24272h;
    private FeedPerfLogger f24273i;
    private Lazy<PerformanceLogger> f24274j;
    private Lazy<NewsFeedIntentUriBuilder> f24275k;
    public Lazy<GraphSearchTitleBarController> f24276l;
    private SecureContextHelper f24277m;
    private AnalyticsLogger f24278n;
    public Lazy<NavigationLogger> f24279o;
    private OfflineIntentManager f24280p;
    private FullScreenVideoInflater f24281q;
    private ChannelFeedInflater f24282r;
    private VideoWatchAndBrowseInflator f24283s;
    private MainActivityToFragmentCreatePerfLogger f24284t;
    private FeedDataLoaderInitializer f24285u;
    private TabletColumnLayoutManager f24286v;
    private TabletExperimentConfiguration f24287w;
    private FrameLayout f24288x;
    private boolean f24289y;
    private ContentFragmentType f24290z;

    /* compiled from: SDKIDFA */
    class C34791 implements OnApplicationEnteredListener {
        final /* synthetic */ ImmersiveActivityDelegate f24228a;

        C34791(ImmersiveActivityDelegate immersiveActivityDelegate) {
            this.f24228a = immersiveActivityDelegate;
        }

        public final void m25515a() {
            this.f24228a.m25568G();
        }
    }

    /* compiled from: SDKIDFA */
    class C34802 implements Listener {
        final /* synthetic */ ImmersiveActivityDelegate f24229a;

        C34802(ImmersiveActivityDelegate immersiveActivityDelegate) {
            this.f24229a = immersiveActivityDelegate;
        }

        public final void m25516a() {
            this.f24229a.ae = true;
            this.f24229a.m25536a((int) this.f24229a.x().getDimension(2131427385), ZeroFeatureKey.FB4A_INDICATOR);
        }

        public final void m25517b() {
            this.f24229a.ae = false;
            this.f24229a.m25536a(0, ZeroFeatureKey.FB4A_INDICATOR);
        }
    }

    /* compiled from: SDKIDFA */
    class C34813 implements IndicatorVisibilityListener {
        final /* synthetic */ ImmersiveActivityDelegate f24230a;

        C34813(ImmersiveActivityDelegate immersiveActivityDelegate) {
            this.f24230a = immersiveActivityDelegate;
        }

        public final void m25518a() {
            this.f24230a.ae = true;
            int dimension = (int) this.f24230a.x().getDimension(2131427386);
            if (this.f24230a.f24250J.i()) {
                float f = (float) dimension;
                Resources x = this.f24230a.x();
                DialtoneManualSwitcherController dialtoneManualSwitcherController = this.f24230a.f24250J;
                dimension = (int) (f + x.getDimension(2131428113));
            }
            this.f24230a.m25536a(dimension, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
        }

        public final void m25519b() {
            this.f24230a.ae = false;
            this.f24230a.m25536a(0, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
        }
    }

    /* compiled from: SDKIDFA */
    class C34824 implements IndicatorVisibilityListener {
        final /* synthetic */ ImmersiveActivityDelegate f24231a;

        C34824(ImmersiveActivityDelegate immersiveActivityDelegate) {
            this.f24231a = immersiveActivityDelegate;
        }

        public final void m25520a() {
            this.f24231a.ae = true;
            ImmersiveActivityDelegate immersiveActivityDelegate = this.f24231a;
            float dimension = this.f24231a.x().getDimension(2131427386);
            Resources x = this.f24231a.x();
            DialtoneManualSwitcherController dialtoneManualSwitcherController = this.f24231a.f24250J;
            immersiveActivityDelegate.m25548b((int) (dimension + x.getDimension(2131428113)), ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
        }

        public final void m25521b() {
            int i = 0;
            this.f24231a.ae = false;
            ImmersiveActivityDelegate immersiveActivityDelegate = this.f24231a;
            if (this.f24231a.f24250J.h()) {
                i = (int) this.f24231a.x().getDimension(2131427386);
            }
            immersiveActivityDelegate.m25548b(i, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
        }
    }

    /* compiled from: SDKIDFA */
    class C34835 implements OnClickListener {
        final /* synthetic */ ImmersiveActivityDelegate f24232a;

        C34835(ImmersiveActivityDelegate immersiveActivityDelegate) {
            this.f24232a = immersiveActivityDelegate;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1540251741);
            ImmersiveActivityDelegate.m25524J(this.f24232a);
            Logger.a(2, EntryType.UI_INPUT_END, 1306602868, a);
        }
    }

    /* compiled from: SDKIDFA */
    class C34857 implements OnClickListener {
        final /* synthetic */ ImmersiveActivityDelegate f24235a;

        C34857(ImmersiveActivityDelegate immersiveActivityDelegate) {
            this.f24235a = immersiveActivityDelegate;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -200273193);
            Fragment A = this.f24235a.mo1045A();
            ((NavigationLogger) this.f24235a.f24279o.get()).a("tap_search_button");
            ((GraphSearchTitleBarController) this.f24235a.f24276l.get()).a(A, AnalyticsEventNames.ContentFragmentType.IMMERSIVE);
            Logger.a(2, EntryType.UI_INPUT_END, 448297676, a);
        }
    }

    /* compiled from: SDKIDFA */
    class C34879 implements Runnable {
        final /* synthetic */ ImmersiveActivityDelegate f24238a;

        C34879(ImmersiveActivityDelegate immersiveActivityDelegate) {
            this.f24238a = immersiveActivityDelegate;
        }

        public void run() {
            this.f24238a.f24246F.a(this.f24238a.a);
        }
    }

    @Deprecated
    private static <T> void m25543a(Class<T> cls, T t, Context context) {
        m25544a((Object) t, context);
    }

    public static void m25544a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ImmersiveActivityDelegate) obj).m25539a(ActivityStackManager.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 11), FeedPerfLogger.a(fbInjector), (FragmentFactoryMap) FragmentFactoryMapImpl.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 5817), IdBasedLazy.a(fbInjector, 10889), Handler_ForUiThreadMethodAutoProvider.a(fbInjector), FbMainTabActivityIntentHelper.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2400), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), OfflineIntentManager.a(fbInjector), FullScreenVideoInflater.a(fbInjector), ChannelFeedInflater.a(fbInjector), VideoWatchAndBrowseInflator.a(fbInjector), MainActivityToFragmentCreatePerfLogger.a(fbInjector), InteractionTTILogger.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 137), FeedDataLoaderInitializer.a(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), TabletColumnLayoutManager.a(fbInjector), TabletExperimentConfiguration.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2952), EarlyFetchController.a(fbInjector), ZeroIndicatorController.a(fbInjector), IdBasedLazy.a(fbInjector, 614), DialtoneManualSwitcherController.a(fbInjector), FbZeroFeatureVisibilityHelper.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 5452), String_LoggedInUserIdMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 814), CheckpointBroadcaster.a(fbInjector), TopicFeedsTestUtil.a(fbInjector), StatusBarUtil.a(fbInjector), IdBasedLazy.a(fbInjector, 3581), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public final void m25579c(android.content.Intent r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003b in list [B:14:0x002e]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.f24246F;
        if (r1 == 0) goto L_0x003c;
    L_0x0005:
        r0 = 1;
        r1 = r0;
    L_0x0007:
        if (r1 == 0) goto L_0x0016;
    L_0x0009:
        r0 = r5.f24246F;
        r2 = r5.mZ_();
        r2 = r2.toString();
        r0.q(r2);
    L_0x0016:
        r0 = r5.m25560f(r6);	 Catch:{ all -> 0x0144 }
        if (r0 != 0) goto L_0x002c;	 Catch:{ all -> 0x0144 }
    L_0x001c:
        r0 = r5.f24280p;	 Catch:{ all -> 0x0144 }
        if (r0 == 0) goto L_0x003e;	 Catch:{ all -> 0x0144 }
    L_0x0020:
        r0 = r5.f24280p;	 Catch:{ all -> 0x0144 }
        r2 = r5.mZ_();	 Catch:{ all -> 0x0144 }
        r0 = r0.a(r2, r6);	 Catch:{ all -> 0x0144 }
        if (r0 == 0) goto L_0x003e;
    L_0x002c:
        if (r1 == 0) goto L_0x003b;
    L_0x002e:
        r0 = r5.f24246F;
        r1 = r5.mZ_();
        r1 = r1.toString();
        r0.r(r1);
    L_0x003b:
        return;
    L_0x003c:
        r1 = r0;
        goto L_0x0007;
    L_0x003e:
        r0 = r5.f24284t;	 Catch:{  }
        if (r0 == 0) goto L_0x0047;	 Catch:{  }
    L_0x0042:
        r0 = r5.f24284t;	 Catch:{  }
        r0.a(r6);	 Catch:{  }
    L_0x0047:
        r0 = r5.f24254N;	 Catch:{  }
        if (r0 == 0) goto L_0x0052;	 Catch:{  }
    L_0x004b:
        if (r6 == 0) goto L_0x0052;	 Catch:{  }
    L_0x004d:
        r0 = r5.f24254N;	 Catch:{  }
        r0.a(r6);	 Catch:{  }
    L_0x0052:
        if (r6 == 0) goto L_0x0085;	 Catch:{  }
    L_0x0054:
        r0 = r6.getData();	 Catch:{  }
        if (r0 == 0) goto L_0x0085;	 Catch:{  }
    L_0x005a:
        r0 = r6.getData();	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r2 = com.facebook.common.fblinks.FBLinks.eu;	 Catch:{  }
        r0 = r0.contains(r2);	 Catch:{  }
        if (r0 == 0) goto L_0x0085;	 Catch:{  }
    L_0x006a:
        r0 = r5.f24255O;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder) r0;	 Catch:{  }
        r0.a();	 Catch:{  }
        if (r1 == 0) goto L_0x003b;
    L_0x0077:
        r0 = r5.f24246F;
        r1 = r5.mZ_();
        r1 = r1.toString();
        r0.r(r1);
        goto L_0x003b;
    L_0x0085:
        if (r6 == 0) goto L_0x00bc;
    L_0x0087:
        r0 = r6.getData();	 Catch:{  }
        if (r0 == 0) goto L_0x00bc;	 Catch:{  }
    L_0x008d:
        r0 = r6.getData();	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r2 = com.facebook.common.fblinks.FBLinks.ev;	 Catch:{  }
        r0 = r0.contains(r2);	 Catch:{  }
        if (r0 == 0) goto L_0x00bc;	 Catch:{  }
    L_0x009d:
        r0 = r5.f24255O;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder) r0;	 Catch:{  }
        r2 = r5.mZ_();	 Catch:{  }
        r0.a(r2);	 Catch:{  }
        if (r1 == 0) goto L_0x003b;
    L_0x00ae:
        r0 = r5.f24246F;
        r1 = r5.mZ_();
        r1 = r1.toString();
        r0.r(r1);
        goto L_0x003b;
    L_0x00bc:
        if (r6 == 0) goto L_0x00ff;
    L_0x00be:
        r0 = r6.getData();	 Catch:{  }
        if (r0 == 0) goto L_0x00ff;	 Catch:{  }
    L_0x00c4:
        r0 = r6.getData();	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r2 = com.facebook.common.fblinks.FBLinks.ew;	 Catch:{  }
        r0 = r0.contains(r2);	 Catch:{  }
        if (r0 == 0) goto L_0x00ff;	 Catch:{  }
    L_0x00d4:
        r0 = r5.f24255O;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (com.facebook.datasensitivity.confirmation.DataSavingsConfirmationDialogBuilder) r0;	 Catch:{  }
        r2 = r5.mZ_();	 Catch:{  }
        r3 = r5.mZ_();	 Catch:{  }
        r4 = 2131558437; // 0x7f0d0025 float:1.874219E38 double:1.053129796E-314;	 Catch:{  }
        r3 = r3.findViewById(r4);	 Catch:{  }
        r0.a(r2, r3);	 Catch:{  }
        if (r1 == 0) goto L_0x003b;
    L_0x00f0:
        r0 = r5.f24246F;
        r1 = r5.mZ_();
        r1 = r1.toString();
        r0.r(r1);
        goto L_0x003b;
    L_0x00ff:
        super.c(r6);	 Catch:{  }
        r0 = r6.getFlags();	 Catch:{  }
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;	 Catch:{  }
        r0 = r0 & r2;	 Catch:{  }
        if (r0 == 0) goto L_0x012d;	 Catch:{  }
    L_0x010b:
        r0 = r5.mZ_();	 Catch:{  }
        r2 = 0;	 Catch:{  }
        r3 = 0;	 Catch:{  }
        r0.overridePendingTransition(r2, r3);	 Catch:{  }
        if (r1 == 0) goto L_0x011c;	 Catch:{  }
    L_0x0116:
        r0 = r5.f24246F;	 Catch:{  }
        r2 = 0;	 Catch:{  }
        r0.a(r2);	 Catch:{  }
    L_0x011c:
        if (r1 == 0) goto L_0x003b;
    L_0x011e:
        r0 = r5.f24246F;
        r1 = r5.mZ_();
        r1 = r1.toString();
        r0.r(r1);
        goto L_0x003b;
    L_0x012d:
        r0 = com.facebook.katana.activity.AnimationType.SLIDE_LEFT_IN;	 Catch:{  }
        r0 = r0.resource;	 Catch:{  }
        r2 = com.facebook.katana.activity.AnimationType.DROP_OUT;	 Catch:{  }
        r2 = r2.resource;	 Catch:{  }
        r3 = r5.mZ_();	 Catch:{  }
        r3.overridePendingTransition(r0, r2);	 Catch:{  }
        if (r1 == 0) goto L_0x011c;	 Catch:{  }
    L_0x013e:
        r2 = r5.f24246F;	 Catch:{  }
        r2.a(r0);	 Catch:{  }
        goto L_0x011c;
    L_0x0144:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0154;
    L_0x0147:
        r1 = r5.f24246F;
        r2 = r5.mZ_();
        r2 = r2.toString();
        r1.r(r2);
    L_0x0154:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.activity.ImmersiveActivityDelegate.c(android.content.Intent):void");
    }

    private void m25525K() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(v().getDecorView().getWindowToken(), 0);
        }
    }

    @Inject
    private void m25539a(ActivityStackManager activityStackManager, AnalyticsLogger analyticsLogger, Provider<ComponentName> provider, FeedPerfLogger feedPerfLogger, FragmentFactoryMap fragmentFactoryMap, Lazy<NewsFeedIntentUriBuilder> lazy, Lazy<GraphSearchTitleBarController> lazy2, Handler handler, FbMainTabActivityIntentHelper fbMainTabActivityIntentHelper, Lazy<InternalIntentSigner> lazy3, SecureContextHelper secureContextHelper, OfflineIntentManager offlineIntentManager, FullScreenVideoInflater fullScreenVideoInflater, ChannelFeedInflater channelFeedInflater, VideoWatchAndBrowseInflator videoWatchAndBrowseInflator, MainActivityToFragmentCreatePerfLogger mainActivityToFragmentCreatePerfLogger, InteractionTTILogger interactionTTILogger, Lazy<NavigationLogger> lazy4, FeedDataLoaderInitializer feedDataLoaderInitializer, MonotonicClock monotonicClock, TabletColumnLayoutManager tabletColumnLayoutManager, TabletExperimentConfiguration tabletExperimentConfiguration, Lazy<PerformanceLogger> lazy5, EarlyFetchController earlyFetchController, ZeroIndicatorController zeroIndicatorController, Lazy<IndicatorBarController> lazy6, DialtoneManualSwitcherController dialtoneManualSwitcherController, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper, Lazy<DataSavingsConfirmationDialogBuilder> lazy7, String str, Provider<TriState> provider2, CheckpointBroadcaster checkpointBroadcaster, TopicFeedsTestUtil topicFeedsTestUtil, StatusBarUtil statusBarUtil, Lazy<RecyclableViewPoolManager> lazy8, QeAccessor qeAccessor) {
        this.f24266b = activityStackManager;
        this.f24278n = analyticsLogger;
        this.f24268d = provider;
        this.f24273i = feedPerfLogger;
        this.f24272h = fragmentFactoryMap;
        this.f24275k = lazy;
        this.f24276l = lazy2;
        this.f24271g = handler;
        this.f24269e = fbMainTabActivityIntentHelper;
        this.f24270f = lazy3;
        this.f24277m = secureContextHelper;
        this.f24280p = offlineIntentManager;
        this.f24281q = fullScreenVideoInflater;
        this.f24282r = channelFeedInflater;
        this.f24283s = videoWatchAndBrowseInflator;
        this.f24284t = mainActivityToFragmentCreatePerfLogger;
        this.f24246F = interactionTTILogger;
        this.f24279o = lazy4;
        this.f24285u = feedDataLoaderInitializer;
        this.f24241A = monotonicClock;
        this.f24286v = tabletColumnLayoutManager;
        this.f24287w = tabletExperimentConfiguration;
        this.f24274j = lazy5;
        this.f24254N = earlyFetchController;
        this.f24247G = zeroIndicatorController;
        this.f24249I = lazy6;
        this.f24250J = dialtoneManualSwitcherController;
        this.f24253M = fbZeroFeatureVisibilityHelper;
        this.f24255O = lazy7;
        this.f24257R = str;
        this.f24261V = provider2;
        this.f24262W = checkpointBroadcaster;
        this.f24265Z = topicFeedsTestUtil;
        this.aa = statusBarUtil;
        this.ag = lazy8;
        this.af = qeAccessor;
    }

    protected final void mo1046b(@Nullable Bundle bundle) {
        long uptimeMillis = SystemClock.uptimeMillis();
        super.mo1046b(bundle);
        Class cls = ImmersiveActivityDelegate.class;
        m25544a((Object) this, this.a);
        if (this.f24287w.e() || this.f24287w.h()) {
            e(2130904843);
            this.f24288x = (FrameLayout) c(2131562126);
        } else {
            e(2130904842);
        }
        int intExtra = w().getIntExtra("fragment_background_color_id", 0);
        if (intExtra != 0) {
            c(2131558429).setBackgroundResource(intExtra);
        }
        this.f24267c = kO_();
        if (bundle != null) {
            this.f24242B = bundle.getBoolean("last_on_stack", false);
            m25522H();
        } else {
            m25537a(uptimeMillis);
        }
        if (this.f24266b.h() == 0) {
            this.f24242B = true;
        }
        this.f24266b.k = new C34791(this);
        this.f24260U = new LazyView((ViewStub) c(2131559221));
        this.f24246F.a(f24240a.getSimpleName(), uptimeMillis);
        this.ab = (Fb4aSearchTitleBar) c(2131558563);
    }

    protected final void m25571a(Intent intent) {
        m25537a(SystemClock.uptimeMillis());
        super.a(intent);
    }

    @Nullable
    public final ContentFragmentType m25589q() {
        return this.f24290z;
    }

    @Nullable
    public final ColumnWidthConfig m25591s() {
        return this.f24258S;
    }

    private void m25537a(long j) {
        if (!((PerformanceLogger) this.f24274j.get()).h(655412, "NNF_PermalinkFromAndroidNotificationColdLoad")) {
            MarkerConfig a = new MarkerConfig(655409, "NNF_PermalinkFromAndroidNotificationWarmLoad").a(new String[]{"story_view", TabTag.Notifications.analyticsTag, TabTag.Feed.analyticsTag});
            a.g = j;
            ((PerformanceLogger) this.f24274j.get()).c(a);
        }
        m25522H();
    }

    private void m25522H() {
        if (this.f24261V.get() == TriState.YES) {
            ((IndicatorBarController) this.f24249I.get()).f = (ViewStub) c(2131561010);
            this.f24247G.n = ((IndicatorBarController) this.f24249I.get()).a;
            this.f24250J.a((ViewStub) c(2131561006));
        }
        this.f24248H = new C34802(this);
        this.f24251K = new C34813(this);
        this.f24252L = new C34824(this);
    }

    protected final void m25566B() {
        this.d = this.f24281q;
        this.e = this.f24282r;
        this.f = this.f24283s;
    }

    protected final void m25567C() {
        final Fb4aSearchTitleBar fb4aSearchTitleBar = (Fb4aSearchTitleBar) c(2131558563);
        this.g = fb4aSearchTitleBar;
        this.f24209a.a = fb4aSearchTitleBar;
        fb4aSearchTitleBar.setHasBackButton(false);
        fb4aSearchTitleBar.a(new C34835(this));
        int intExtra = w().getIntExtra("title_bar_background_color_id", 0);
        if (intExtra > 0) {
            fb4aSearchTitleBar.setBackgroundResource(intExtra);
        }
        TitleBarButtonSpec titleBarButtonSpec = (TitleBarButtonSpec) w().getParcelableExtra("title_bar_secondary_button_spec");
        fb4aSearchTitleBar.setPrimaryButton((TitleBarButtonSpec) w().getParcelableExtra("title_bar_primary_button_spec"));
        fb4aSearchTitleBar.setSecondaryButton(titleBarButtonSpec);
        if (w().getIntExtra("target_fragment", 0) != ContentFragmentType.SEARCH_FRAGMENT.ordinal()) {
            fb4aSearchTitleBar.j = new C34857(this);
            fb4aSearchTitleBar.setSearchButtonVisible(w().getBooleanExtra("title_bar_search_button_visible", true));
        } else if (w().getBooleanExtra("search_titles_app_diable_animation", false)) {
            fb4aSearchTitleBar.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ ImmersiveActivityDelegate f24234b;

                public void onGlobalLayout() {
                    fb4aSearchTitleBar.b(true);
                    CustomViewUtils.a(fb4aSearchTitleBar, this);
                }
            });
        }
    }

    private void m25542a(ColumnWidthConfig columnWidthConfig) {
        if (this.f24289y && this.f24288x != null && columnWidthConfig != null) {
            if (columnWidthConfig.a()) {
                ((LayoutParams) this.f24288x.getLayoutParams()).width = columnWidthConfig.g();
                this.f24288x.setVisibility(0);
                this.f24288x.setPadding(this.f24288x.getPaddingLeft(), this.f24288x.getPaddingTop(), columnWidthConfig.e, this.f24288x.getPaddingBottom());
                return;
            }
            this.f24288x.setVisibility(8);
        }
    }

    protected final void m25584g() {
        Object obj = this.f24246F != null ? 1 : null;
        if (obj != null) {
            this.f24246F.i(this.a.toString());
        }
        if (this.f24263X) {
            CheckpointBroadcaster checkpointBroadcaster = this.f24262W;
            if (!(StringUtil.a(checkpointBroadcaster.b) || checkpointBroadcaster.d)) {
                CheckpointCancelInputData checkpointCancelInputData = new CheckpointCancelInputData();
                checkpointCancelInputData.a("flow_id", checkpointBroadcaster.b);
                GraphQlCallInput graphQlCallInput = checkpointCancelInputData;
                GraphQlQueryString checkpointCancelMutationString = new CheckpointCancelMutationString();
                checkpointCancelMutationString.a("input", graphQlCallInput);
                Futures.a(((GraphQLQueryExecutor) checkpointBroadcaster.j.get()).a(GraphQLRequest.a(checkpointCancelMutationString)), new 2(checkpointBroadcaster), checkpointBroadcaster.i);
            }
            checkpointBroadcaster = this.f24262W;
            checkpointBroadcaster.b = null;
            checkpointBroadcaster.c = false;
            checkpointBroadcaster.d = false;
        }
        super.g();
        if (D() && this.c.a()) {
            this.c.f();
        }
        if (obj != null) {
            this.f24246F.j(this.a.toString());
        }
        if (this.f24250J != null) {
            this.f24250J.a(InfoDismissalReason.NAVIGATION);
        }
    }

    protected final void m25585i() {
        this.f24246F.g(this.a.toString());
        super.i();
        if (D() && this.c.a()) {
            this.c.e();
        }
        this.f24247G.b();
        this.f24247G.o = null;
        this.f24250J.b();
        this.f24250J.c(this.f24251K);
        this.f24250J.d(this.f24252L);
        if (this.f24253M.b() != null) {
            ((IndicatorBarController) this.f24249I.get()).e();
        }
        this.f24246F.h(this.a.toString());
    }

    protected final void m25586j() {
        this.f24246F.e(f24240a.getSimpleName());
        super.j();
        if (D() && this.c.a()) {
            this.c.d();
        }
        if (mo1045A() != null) {
            m25523I(this);
        }
        m25530P();
        if (this.f24245E != null && this.f24267c.c()) {
            m25552c(this.f24245E);
        }
        ZeroIndicatorController zeroIndicatorController = this.f24247G;
        zeroIndicatorController.o = this.f24248H;
        zeroIndicatorController.p = ZeroFeatureKey.FB4A_INDICATOR;
        this.f24247G.a();
        this.f24250J.a(this.f24251K);
        this.f24250J.b(this.f24252L);
        this.f24250J.a();
        if (this.f24253M.b() != null) {
            ((IndicatorBarController) this.f24249I.get()).c();
        }
        this.f24246F.f(f24240a.getSimpleName());
    }

    protected final void m25583f() {
        this.f24246F.c(f24240a.getSimpleName());
        super.f();
        if (D() && this.c.a()) {
            this.c.c();
        }
        this.f24246F.d(f24240a.getSimpleName());
    }

    protected final void m25581d(Bundle bundle) {
        if (this.f24242B) {
            bundle.putBoolean("last_on_stack", true);
        }
        super.d(bundle);
    }

    protected final void m25580c(@Nullable Bundle bundle) {
        super.c(bundle);
        if (bundle == null) {
            m25554d(w());
        }
    }

    protected final void m25587m() {
        if (this.f24266b != null) {
            this.f24266b.c();
        }
        if (this.ac && this.ad != null) {
            this.ad.b();
            this.ad = null;
        }
        this.f24288x = null;
        super.m();
    }

    public final void m25568G() {
        Intent w = w();
        if (w != null && w.getExtras() != null) {
            long d = this.f24266b.d();
            if (d == 0) {
                return;
            }
            if (w.hasExtra("target_tab_name") && TabTag.Notifications.name().equals(w.getStringExtra("target_tab_name"))) {
                this.f24244D = true;
                this.f24266b.m = TabTag.Notifications.fblink;
                this.f24266b.c(this.a);
            } else if (w.hasExtra("target_tab_name") && TabTag.VideoHome.name().equals(w.getStringExtra("target_tab_name"))) {
                this.f24244D = true;
                this.f24266b.m = TabTag.VideoHome.fblink;
                this.f24266b.c(this.a);
            } else if (this.f24265Z.j() && this.f24241A.now() - d >= this.f24265Z.k() * 60000) {
                this.f24266b.m = TabTag.Feed.fblink;
                m25529O();
            }
        }
    }

    public final void m25582e() {
        if (this.ag != null) {
            ((RecyclableViewPoolManager) this.ag.get()).a();
        }
    }

    private void m25554d(@Nonnull Intent intent) {
        final Intent a = this.f24269e.a(intent);
        if (!this.f24269e.a(this.a, a)) {
            Runnable c34879;
            if (a.hasExtra("target_tab_name") && TabTag.fromNameSafe(a.getStringExtra("target_tab_name")) != null) {
                TabTag fromName = TabTag.fromName(a.getStringExtra("target_tab_name"));
                this.f24266b.m = fromName.fblink;
            }
            if (a.hasExtra("notification_launch_source")) {
                HoneyClientEventFast a2 = this.f24278n.a("notification_launched", false);
                if (a2.a()) {
                    a2.a("notification_launch_source", a.getStringExtra("notification_launch_source"));
                    a2.b();
                }
            }
            if (a.hasExtra("is_from_get_notified_notification")) {
                ((NavigationLogger) this.f24279o.get()).a("tap_system_tray_notification");
            }
            if (a.getBooleanExtra("inflate_fragment_before_animation", false) || (a.getFlags() & 65536) != 0) {
                m25556e(this, a);
                m25523I(this);
                c34879 = new C34879(this);
            } else {
                c34879 = new Runnable(this) {
                    final /* synthetic */ ImmersiveActivityDelegate f24237b;

                    public void run() {
                        this.f24237b.f24246F.a(this.f24237b.a);
                        ImmersiveActivityDelegate.m25556e(this.f24237b, a);
                        ImmersiveActivityDelegate.m25523I(this.f24237b);
                    }
                };
            }
            this.f24209a.a.a(new OnDispatchDrawListener(this) {
                final /* synthetic */ ImmersiveActivityDelegate f24227b;

                public final boolean m25514a() {
                    HandlerDetour.a(this.f24227b.f24271g, c34879, -1809976297);
                    return true;
                }
            });
        }
    }

    public static void m25556e(@Nonnull ImmersiveActivityDelegate immersiveActivityDelegate, Intent intent) {
        int intExtra = intent.getIntExtra("target_fragment", -1);
        if (intExtra == -1) {
            intExtra = ContentFragmentType.FACEWEB_FRAGMENT.ordinal();
            intent.putExtra("target_fragment", intExtra);
        }
        IFragmentFactory a = immersiveActivityDelegate.f24272h.a(intExtra);
        String stringExtra = intent.getStringExtra("extra_launch_uri");
        immersiveActivityDelegate.f24246F.m(stringExtra);
        if (intExtra == ContentFragmentType.FACEWEB_FRAGMENT.ordinal() && stringExtra != null && Uri.parse(stringExtra).getQueryParameterNames().contains("dismiss")) {
            immersiveActivityDelegate.m25529O();
            return;
        }
        if (intExtra == ContentFragmentType.SEARCH_FRAGMENT.ordinal()) {
            if ("awareness_tutorial_nux".equals(intent.getStringExtra("config"))) {
                intent.putExtra("search_awareness_config", new AwarenessGraphSearchConfiguration(AwarenessUnitType.TUTORIAL_NUX));
            }
        }
        immersiveActivityDelegate.f24263X = intent.getBooleanExtra("arg_is_checkpoint", false);
        immersiveActivityDelegate.f24264Y = intent.getBooleanExtra("arg_is_blocking_checkpoint", false);
        Fragment a2 = a.a(intent);
        if (a2 == null) {
            immersiveActivityDelegate.p();
            immersiveActivityDelegate.f24246F.a();
            return;
        }
        InteractionTTILogger interactionTTILogger = immersiveActivityDelegate.f24246F;
        a2.getClass().getSimpleName();
        interactionTTILogger.n(stringExtra);
        immersiveActivityDelegate.f24284t.a();
        a2.g(true);
        if (immersiveActivityDelegate.f24267c.c()) {
            immersiveActivityDelegate.m25552c(a2);
        } else {
            immersiveActivityDelegate.f24245E = a2;
        }
    }

    private ColumnWidthConfig m25547b(Fragment fragment) {
        if ((fragment instanceof SideshowCompatibleContainer) && this.f24287w.e()) {
            this.f24290z = ((SideshowCompatibleContainer) fragment).d();
            return this.f24286v.b();
        } else if (this.f24287w.h()) {
            return this.f24286v.b();
        } else {
            return null;
        }
    }

    private void m25538a(Fragment fragment, ColumnWidthConfig columnWidthConfig, int i) {
        ScrollingViewProxy scrollingViewProxy = null;
        if (fragment instanceof ScrollableListContainer) {
            scrollingViewProxy = ((ScrollableListContainer) fragment).n();
        } else if (fragment instanceof ScrollingViewProxyContainer) {
            scrollingViewProxy = ((ScrollingViewProxyContainer) fragment).n();
        }
        if (scrollingViewProxy == null && (fragment instanceof ScrollingViewProxyContainer)) {
            scrollingViewProxy = ((ScrollingViewProxyContainer) fragment).n();
        }
        if (scrollingViewProxy != null) {
            scrollingViewProxy.a(columnWidthConfig.c, x().getDimensionPixelOffset(2131430869), columnWidthConfig.d, scrollingViewProxy.f());
            scrollingViewProxy.a(false);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.a.findViewById(i);
        frameLayout.setPadding(columnWidthConfig.c, x().getDimensionPixelOffset(2131430869), columnWidthConfig.d, frameLayout.getPaddingBottom());
        frameLayout.setClipToPadding(false);
    }

    private void m25552c(Fragment fragment) {
        this.f24246F.o(fragment.getClass().getSimpleName());
        this.f24245E = null;
        this.f24259T = 2131558429;
        this.f24258S = m25547b(fragment);
        if (this.f24258S != null) {
            this.f24259T = 2131562125;
            this.f24289y = true;
            m25542a(this.f24258S);
            if (fragment instanceof FadingContentViewProvider) {
                ((FadingContentViewProvider) fragment).p();
            }
        }
        FragmentTransaction a = this.f24267c.a();
        a.b(this.f24259T, fragment);
        if (this.f24289y) {
            a.b(2131562126, Fragment.a(this.a, SideshowHost.class.getName()));
        }
        a.b();
        this.f24267c.b();
        if (this.f24289y) {
            m25538a(fragment, this.f24258S, this.f24259T);
        }
        this.f24246F.p(fragment.getClass().getSimpleName());
    }

    public static void m25523I(ImmersiveActivityDelegate immersiveActivityDelegate) {
        HoneyClientEventFast a = immersiveActivityDelegate.f24278n.a("immersive_activity_create", false);
        if (a.a()) {
            a.a("activity_stack_depth", immersiveActivityDelegate.f24266b.h());
            String valueOf = String.valueOf(immersiveActivityDelegate.a.getComponentName());
            if (immersiveActivityDelegate.mo1045A() != null) {
                valueOf = immersiveActivityDelegate.mo1045A().getClass().getName();
            }
            a.a("fragment_name", valueOf);
            a.b();
        }
        ((NavigationLogger) immersiveActivityDelegate.f24279o.get()).a(immersiveActivityDelegate.a);
    }

    public static void m25524J(ImmersiveActivityDelegate immersiveActivityDelegate) {
        immersiveActivityDelegate.m25525K();
        immersiveActivityDelegate.f24243C = true;
        immersiveActivityDelegate.m25557e(true);
    }

    public final void m25590r() {
        m25557e(false);
    }

    private void m25557e(boolean z) {
        Object obj;
        if (this.c == null || !this.c.b()) {
            Fragment A = A();
            int i;
            if (z && (A instanceof GraphSearchFragment) && ((GraphSearchFragment) A).as.a(true)) {
                i = 1;
            } else if ((A instanceof CanHandleBackPressed) && ((CanHandleBackPressed) A).O_()) {
                i = 1;
            } else {
                obj = null;
            }
        } else {
            obj = 1;
        }
        if (obj == null) {
            if (!this.f24263X || !this.f24264Y) {
                String str;
                String str2 = "immersive_system_back_pressed";
                ((NavigationLogger) this.f24279o.get()).a("tap_back_button");
                if (this.f24243C) {
                    ((NavigationLogger) this.f24279o.get()).a("tap_top_left_nav");
                    str = "titlebar_back_pressed";
                    this.f24243C = false;
                } else {
                    str = str2;
                }
                HoneyClientEventFast a = this.f24278n.a(str, false);
                if (a.a()) {
                    a.a("activity_stack_depth", this.f24266b.h());
                    a.b();
                }
                if (m25526L()) {
                    this.f24266b.m = TabTag.Feed.fblink;
                }
                if (w() == null) {
                    BLog.a(f24240a, "Activity with no stored intent being processed as an Immersive Activity.");
                    m25529O();
                }
                if (this.f24244D) {
                    m25529O();
                }
                if (w().getBooleanExtra("extra_back_to_home", false)) {
                    m25529O();
                } else if (kO_().f() == 0 && this.f24242B && w().hasExtra("target_tab_name") && TabTag.isNotificationsTabTagName(w().getStringExtra("target_tab_name"))) {
                    m25529O();
                }
                if (this.f24266b.b.size() == 2) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null && this.f24266b.m.equals(TabTag.Feed.fblink)) {
                    this.f24273i.e(false);
                }
                super.r();
            }
        }
    }

    private boolean m25526L() {
        return m25528N() && m25527M();
    }

    private boolean m25527M() {
        return this.af.a(ExperimentsForNewsFeedAbTestModule.e, false);
    }

    private boolean m25528N() {
        Intent w = w();
        if (w == null) {
            return false;
        }
        String stringExtra = w.getStringExtra("notification_source");
        if (stringExtra == null || !stringExtra.equals(NotificationSource.PUSH.name())) {
            return false;
        }
        return true;
    }

    private void m25529O() {
        Parcelable a = ((NewsFeedIntentUriBuilder) this.f24275k.get()).a(this.a, FBLinks.bT);
        String name = TabTag.fromFbLink(this.f24266b.m).name();
        a.putExtra("target_tab_name", name);
        a.putExtra("jump_to_top", true);
        Intent intent = new Intent();
        intent.putExtra("tabbar_target_intent", a);
        intent.putExtra("extra_launch_uri", this.f24266b.m);
        intent.putExtra("POP_TO_ROOT", true);
        intent.setComponent((ComponentName) this.f24268d.get());
        ((InternalIntentSigner) this.f24270f.get()).a(intent);
        this.f24277m.a(intent, this.a);
        if (name.equals(TabTag.Feed.name())) {
            this.f24285u.b();
            this.f24273i.e(true);
        }
        p();
    }

    private void m25530P() {
        if (h()) {
            ((NavigationLogger) this.f24279o.get()).a("system_triggered").a("video", true);
            return;
        }
        FragmentManager kO_ = kO_();
        if (kO_ != null) {
            Fragment fragment = null;
            int size = f24239Q.size();
            for (int i = 0; i < size; i++) {
                fragment = kO_.a((String) f24239Q.get(i));
                if (fragment != null) {
                    break;
                }
            }
            if (fragment != null && (fragment instanceof AnalyticsActivity)) {
                ((NavigationLogger) this.f24279o.get()).a("system_triggered").a(((AnalyticsActivity) fragment).am_(), true);
            }
        }
    }

    public final void m25572a(Intent intent, int i) {
        Object obj = this.f24246F != null ? 1 : null;
        if (obj != null) {
            this.f24246F.s(this.a.toString());
        }
        super.a(intent, i);
        if (obj != null) {
            this.f24246F.a(this.a.toString(), intent);
        }
    }

    private boolean m25560f(Intent intent) {
        if ((intent.hasExtra("force_create_new_activity") && intent.getBooleanExtra("force_create_new_activity", false)) || !intent.hasExtra("extra_launch_uri") || w() == null || !w().hasExtra("extra_launch_uri")) {
            return false;
        }
        if (StringUtil.a(new CharSequence[]{intent.getStringExtra("extra_launch_uri"), w().getStringExtra("extra_launch_uri")}) || !intent.getStringExtra("extra_launch_uri").equals(w().getStringExtra("extra_launch_uri"))) {
            return false;
        }
        return true;
    }

    public final void m25570a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        Fragment A = mo1045A();
        if (A != null) {
            A.a(i, i2, intent);
        }
    }

    public final void m25588p() {
        super.p();
        if (w().getBooleanExtra("search_titles_app_diable_animation", false)) {
            this.a.overridePendingTransition(0, 0);
        } else {
            this.a.overridePendingTransition(AnimationType.RISE_IN.resource, AnimationType.SLIDE_RIGHT_OUT.resource);
        }
    }

    public final void c_(boolean z) {
        if (z) {
            p();
        }
    }

    public final void m25575b() {
        p();
    }

    private void m25531Q() {
        m25534T();
        c(2131558429).setPadding(0, 0, 0, 0);
    }

    private void m25532R() {
        c(2131558429).setPadding(0, x().getDimensionPixelSize(2131428150), 0, 0);
    }

    private void m25533S() {
        Fb4aSearchTitleBar fb4aSearchTitleBar = (Fb4aSearchTitleBar) c(2131558563);
        fb4aSearchTitleBar.a(SearchBoxType.IMMERSIVE);
        fb4aSearchTitleBar.setSearchButtonVisible(false);
        fb4aSearchTitleBar.setButtonSpecs(null);
    }

    private void m25536a(int i, ZeroFeatureKey zeroFeatureKey) {
        if (m25546a(zeroFeatureKey)) {
            m25548b(i, zeroFeatureKey);
            if (zeroFeatureKey.equals(ZeroFeatureKey.FB4A_INDICATOR)) {
                ((IndicatorBarController) this.f24249I.get()).b();
            } else if (zeroFeatureKey.equals(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE)) {
                ((IndicatorBarController) this.f24249I.get()).a(this.f24250J);
            }
        }
    }

    private void m25561g(int i) {
        if (VERSION.SDK_INT >= 21) {
            v().setStatusBarColor(i);
        }
    }

    private boolean m25546a(ZeroFeatureKey zeroFeatureKey) {
        ZeroFeatureKey b = this.f24253M.b();
        if (b == null || (b.equals(zeroFeatureKey) && (b.equals(ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE) || b.equals(ZeroFeatureKey.FB4A_INDICATOR)))) {
            return true;
        }
        return false;
    }

    private void m25548b(int i, ZeroFeatureKey zeroFeatureKey) {
        if (m25546a(zeroFeatureKey)) {
            c(2131559634).setPadding(0, i, 0, 0);
        }
    }

    public final void m25573a(Configuration configuration) {
        super.a(configuration);
        if (this.f24256P) {
            m25531Q();
        } else {
            m25532R();
        }
        this.f24258S = m25547b(mo1045A());
        if (this.f24258S != null) {
            this.f24289y = true;
            m25538a(mo1045A(), this.f24258S, 2131562125);
            m25542a(this.f24258S);
        } else if (this.f24288x != null) {
            this.f24288x.setVisibility(8);
        }
    }

    protected final Fragment mo1045A() {
        return kO_().a(this.f24259T);
    }

    public final void e_(boolean z) {
        this.f24256P = z;
        int i = z ? 2130772554 : 2130772558;
        if (this.ae) {
            m25561g(ContextUtils.c(this.a, 2130772558, 0));
        } else {
            this.ab.a(z);
            m25559f(z);
            m25561g(ContextUtils.c(this.a, i, 0));
        }
        if (z) {
            m25531Q();
        } else {
            m25532R();
        }
    }

    public final void m25578b(boolean z) {
        if (this.f24256P && z) {
            m25533S();
        }
    }

    @Nullable
    public final FbFragment m25569a() {
        Fragment A = mo1045A();
        return A instanceof FbFragment ? (FbFragment) A : null;
    }

    public String toString() {
        String str = "No content fragment loaded";
        if (mo1045A() != null) {
            str = mo1045A().getClass().getName();
        }
        return "ImmersiveActivity[" + str + "]";
    }

    public final void m25574a(FriendRequestsFragment friendRequestsFragment) {
        if (friendRequestsFragment.kS_()) {
            ((FabView) this.f24260U.a()).setGlyphID(2130839877);
            ((FabView) this.f24260U.a()).setContentDescription(friendRequestsFragment.d());
            ((FabView) this.f24260U.a()).setOnClickListener(friendRequestsFragment.e());
            ((FabView) this.f24260U.a()).setVisibility(0);
        } else if (this.f24260U.b()) {
            ((FabView) this.f24260U.a()).setVisibility(8);
        }
    }

    public final void m25577b(FriendRequestsFragment friendRequestsFragment) {
        if (this.f24260U.b()) {
            ((FabView) this.f24260U.a()).setOnClickListener(null);
        }
    }

    private void m25559f(boolean z) {
        if (VERSION.SDK_INT >= 21) {
            this.ac = z;
            if (z) {
                v().getDecorView().setSystemUiVisibility(1280);
                this.ad = new AndroidFullscreenInputWorkaround(this.a);
                AndroidFullscreenInputWorkaround androidFullscreenInputWorkaround = this.ad;
                androidFullscreenInputWorkaround.f = new 1(androidFullscreenInputWorkaround);
                androidFullscreenInputWorkaround.a.getViewTreeObserver().addOnGlobalLayoutListener(androidFullscreenInputWorkaround.f);
                androidFullscreenInputWorkaround.c = (FrameLayout.LayoutParams) androidFullscreenInputWorkaround.a.getLayoutParams();
                return;
            }
            if (this.ad != null) {
                this.ad.b();
                this.ad = null;
            }
            v().getDecorView().setSystemUiVisibility(256);
        }
    }

    private int m25534T() {
        return VERSION.SDK_INT >= 21 ? this.aa.a(this.a.getWindow()) : 0;
    }
}
