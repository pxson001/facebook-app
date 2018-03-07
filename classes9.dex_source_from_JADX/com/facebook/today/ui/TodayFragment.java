package com.facebook.today.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.CollectionUtil;
import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.notifications.GraphQLNotificationsContract;
import com.facebook.location.FbLocationCache;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.loader.NotificationsLoader;
import com.facebook.notifications.loader.UnseenNotificationsLoader;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.util.NotificationsFragmentTouchUtil;
import com.facebook.notifications.util.NotificationsLastUpdatedUtil;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionItem;
import com.facebook.reaction.common.ReactionViewTypeConstants;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.reaction.ui.fragment.BaseFullscreenReactionFragment;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import com.facebook.springs.SpringSystem;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletColumnLayoutManager.ColumnWidthConfig;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.today.abtest.ExperimentsForTodayAbTestModule;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.today.analytics.TodayAnalyticsLogger;
import com.facebook.today.analytics.TodayAnalyticsLogger.Event;
import com.facebook.today.analytics.TodayAnalyticsLoggerProvider;
import com.facebook.today.notifications.TodayNotificationsHolder;
import com.facebook.today.notifications.TodayNotificationsUtil;
import com.facebook.today.prefs.TodayPrefKeys;
import com.facebook.today.push.TodayFbPushDataHandler;
import com.facebook.today.ui.TodayReactionSessionBuilder.C01211;
import com.facebook.today.ui.notificationslist.TodayNotificationPillController;
import com.facebook.today.ui.notificationslist.TodayNotificationPillControllerProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: turn_password */
public class TodayFragment extends BaseFullscreenReactionFragment implements LoaderCallbacks<List<NotificationsEdgeFields>>, OnDrawListener, ScrollableListContainer {
    private static final String aN = TodayFragment.class.getSimpleName();
    @Inject
    ResourceManager aA;
    @Inject
    TabletExperimentConfiguration aB;
    @Inject
    TabletColumnLayoutManager aC;
    @Inject
    Toaster aD;
    @Inject
    TodayFbPushDataHandler aE;
    @Inject
    TodayMixedRecyclerViewAdapterProvider aF;
    @Inject
    TodayAnalyticsLoggerProvider aG;
    @Inject
    TodayExperimentController aH;
    @Inject
    TodayNotificationsHolder aI;
    @Inject
    TodayNotificationsUtil aJ;
    @Inject
    public TodayNotificationPillControllerProvider aK;
    @Inject
    TodayReactionSessionBuilder aL;
    @Inject
    ViewerContextManager aM;
    private RecyclerViewProxy aO;
    private boolean aP = true;
    private boolean aQ = false;
    private boolean aR = false;
    private SelfRegistrableReceiverImpl aS;
    private int aT = -1;
    private long aU;
    public TodayAnalyticsLogger aV;
    private TodayFragmentOnScrollListener aW;
    public TodayNotificationPillController aX;
    @Inject
    AbstractFbErrorReporter am;
    @Inject
    FbLocationCache an;
    @Inject
    FbNetworkManager ao;
    @Inject
    FbSharedPreferences ap;
    @Inject
    GraphQLNotificationsContentProviderHelper aq;
    @Inject
    GraphQLNotificationsContract ar;
    @Inject
    MonotonicClock as;
    @Inject
    NetworkMonitor at;
    @Inject
    NotificationsFragmentTouchUtil au;
    @Inject
    NotificationsLastUpdatedUtil av;
    @Inject
    DefaultNotificationsRenderer aw;
    @Inject
    NotificationsRowWithActionHelper ax;
    @Inject
    PerformanceLogger ay;
    @Inject
    ReactionSessionManager az;

    /* compiled from: turn_password */
    class C01161 implements Runnable {
        final /* synthetic */ TodayFragment f1248a;

        C01161(TodayFragment todayFragment) {
            this.f1248a = todayFragment;
        }

        public void run() {
            this.f1248a.aD();
        }
    }

    /* compiled from: turn_password */
    class C01172 extends DataSetObserver {
        final /* synthetic */ TodayFragment f1249a;

        C01172(TodayFragment todayFragment) {
            this.f1249a = todayFragment;
        }

        public void onInvalidated() {
            this.f1249a.at.k();
        }

        public void onChanged() {
            this.f1249a.at.k();
        }
    }

    /* compiled from: turn_password */
    public class C01183 implements OnClickListener {
        final /* synthetic */ TodayFragment f1250a;

        public C01183(TodayFragment todayFragment) {
            this.f1250a = todayFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -148303154);
            this.f1250a.gB_();
            this.f1250a.aX.b();
            TodayAnalyticsLogger todayAnalyticsLogger = this.f1250a.aV;
            AnalyticsLogger analyticsLogger = todayAnalyticsLogger.f1163a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.NOTIFICATION_PILL_CLICK.name);
            honeyClientEvent.c = "today";
            honeyClientEvent = honeyClientEvent;
            honeyClientEvent.f = todayAnalyticsLogger.f1165c.a;
            analyticsLogger.a(honeyClientEvent.b("session_id", todayAnalyticsLogger.f1165c.a).a("surface", todayAnalyticsLogger.f1165c.c));
            Logger.a(2, EntryType.UI_INPUT_END, -206134626, a);
        }
    }

    /* compiled from: turn_password */
    class C01194 implements Runnable {
        final /* synthetic */ TodayFragment f1251a;

        C01194(TodayFragment todayFragment) {
            this.f1251a = todayFragment;
        }

        public void run() {
            this.f1251a.at.k();
        }
    }

    /* compiled from: turn_password */
    class TodayFragmentOnScrollListener implements OnScrollListener {
        final /* synthetic */ TodayFragment f1252a;

        public TodayFragmentOnScrollListener(TodayFragment todayFragment) {
            this.f1252a = todayFragment;
        }

        public final void m1394a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f1252a.au.a(scrollingViewProxy, i);
        }

        public final void m1395a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        }
    }

    public static void m1397a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TodayFragment) obj).m1396a((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbLocationCache.a(injectorLike), FbNetworkManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GraphQLNotificationsContentProviderHelper.a(injectorLike), GraphQLNotificationsContract.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), NetworkMonitor.a(injectorLike), NotificationsFragmentTouchUtil.a(injectorLike), NotificationsLastUpdatedUtil.a(injectorLike), DefaultNotificationsRenderer.a(injectorLike), NotificationsRowWithActionHelper.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), ReactionSessionManager.a(injectorLike), ResourceManager.a(injectorLike), TabletExperimentConfiguration.a(injectorLike), TabletColumnLayoutManager.a(injectorLike), Toaster.a(injectorLike), TodayFbPushDataHandler.m1390a(injectorLike), (TodayMixedRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TodayMixedRecyclerViewAdapterProvider.class), (TodayAnalyticsLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TodayAnalyticsLoggerProvider.class), TodayExperimentController.a(injectorLike), TodayNotificationsHolder.m1361a(injectorLike), TodayNotificationsUtil.m1372a(injectorLike), (TodayNotificationPillControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TodayNotificationPillControllerProvider.class), TodayReactionSessionBuilder.m1421a(injectorLike), ViewerContextManagerProvider.a(injectorLike));
    }

    public final void m1403a(Loader loader, Object obj) {
        List<NotificationsEdgeFields> list = (List) obj;
        this.aQ = true;
        this.aI.f1211j = this.T.getMeasuredHeight();
        this.aI.f1209h = this.aw.a(getContext());
        if ((list == null || list.isEmpty()) && this.aP) {
            this.aJ.m1379a(SyncSource.FRAGMENT_LOADED);
            this.aP = false;
        }
        switch (loader.m) {
            case 189:
                int i;
                this.aI.m1366a((List) list);
                TodayNotificationPillController todayNotificationPillController = this.aX;
                int aK = aK();
                if (list.isEmpty()) {
                    i = 0;
                } else {
                    NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) list.get(0);
                    i = (notificationsEdgeFields == null || notificationsEdgeFields.k() == null || !notificationsEdgeFields.k().au().equals(GraphQLStorySeenState.UNSEEN_AND_UNREAD)) ? 0 : 1;
                }
                if (!(i == 0 || aK <= todayNotificationPillController.f1374a || todayNotificationPillController.f1374a == -1 || todayNotificationPillController.f1375b == null)) {
                    todayNotificationPillController.f1375b.a().setOnClickListener(todayNotificationPillController.f1377d);
                    todayNotificationPillController.a();
                }
                this.h.b(7274503, (short) 2);
                this.aJ.m1381a((List) list, this.aI.f1210i);
                break;
            case 190:
                this.aI.f1210i = list.size();
                TodayNotificationsHolder todayNotificationsHolder = this.aI;
                for (NotificationsEdgeFields notificationsEdgeFields2 : list) {
                    if (!todayNotificationsHolder.f1203b.containsKey(notificationsEdgeFields2.k().g())) {
                        todayNotificationsHolder.f1203b.put(notificationsEdgeFields2.k().g(), Integer.valueOf(todayNotificationsHolder.f1212k.size()));
                        todayNotificationsHolder.f1212k.add(notificationsEdgeFields2);
                    }
                }
                todayNotificationsHolder.m1371g();
                loader.r();
                break;
        }
        be();
    }

    public final void m1408c(@Nullable Bundle bundle) {
        Class cls = TodayFragment.class;
        m1397a((Object) this, getContext());
        super.c(bundle);
        E().a(189, null, this);
        ReactionSession reactionSession = this.av;
        if (reactionSession != null) {
            TodayAnalyticsLoggerProvider todayAnalyticsLoggerProvider = this.aG;
            this.aV = new TodayAnalyticsLogger(reactionSession, AnalyticsLoggerMethodAutoProvider.a(todayAnalyticsLoggerProvider), ReactionAnalyticsLogger.a(todayAnalyticsLoggerProvider));
        }
        this.aS = this.at.a(State.CONNECTED, new C01161(this));
    }

    public final void m1405a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        TodayNotificationsHolder todayNotificationsHolder = this.aI;
        todayNotificationsHolder.f1202a.registerObserver(new C01172(this));
    }

    protected final ReactionSession ax() {
        TodayReactionSessionBuilder todayReactionSessionBuilder = this.aL;
        String uuid = SafeUUIDGenerator.a().toString();
        ReactionSession a = todayReactionSessionBuilder.f1267d.a(uuid, Surface.ANDROID_TODAY);
        todayReactionSessionBuilder.f1267d.c(uuid);
        a.A = new C01211(todayReactionSessionBuilder, uuid);
        return a;
    }

    protected final void aC() {
    }

    public final View m1402a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1808159809);
        ReactionSession b = this.aL.m1424b();
        ReactionSession reactionSession = this.av;
        if (reactionSession == null) {
            this.am.a(SoftError.b("Today Fragment reaction session was null", "Reaction session should never be null when called from onCreateView()"));
            reactionSession = b;
        }
        View a2 = a(viewGroup, reactionSession);
        m1406a(b);
        TodayNotificationPillControllerProvider todayNotificationPillControllerProvider = this.aK;
        this.aX = new TodayNotificationPillController(a2, SpringSystem.b(todayNotificationPillControllerProvider), ViewHelperViewAnimatorFactory.a(todayNotificationPillControllerProvider));
        this.aX.f1377d = new C01183(this);
        be();
        bg();
        m1411n().a(this);
        this.au.a(m1411n());
        this.au.a(m1411n(), (RecyclerView) getCardViewGroup());
        this.aW = new TodayFragmentOnScrollListener(this);
        m1411n().b(this.aW);
        this.aq.d();
        if (D()) {
            this.aR = true;
        }
        bd();
        LogUtils.f(-534201425, a);
        return a2;
    }

    protected final AbstractReactionRecyclerViewAdapter m1407b(Context context) {
        return this.aF.m1420a(context, aP(), aO(), this);
    }

    public final void m1399G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1526815907);
        super.G();
        this.ay.b(655408, "NNF_PermalinkNotificationLoad");
        TodayNotificationsHolder todayNotificationsHolder = this.aI;
        TodayNotificationsUtil todayNotificationsUtil = this.aJ;
        boolean z = false;
        if (todayNotificationsUtil.f1215a.a() - todayNotificationsUtil.f1217c.a(TodayPrefKeys.f1233e, 0) < 600000) {
            z = todayNotificationsUtil.f1217c.a(TodayPrefKeys.f1236h, false);
        }
        todayNotificationsHolder.m1367a(z);
        if (D()) {
            aZ();
            this.aU = this.as.now();
        }
        this.ax.i = new C01194(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1992732096, a);
    }

    public final boolean gD_() {
        if (this.aR && this.aQ) {
            this.h.b(7274501, (short) 2);
            this.aR = false;
        }
        return false;
    }

    public final void m1400H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 993430736);
        bj();
        bl();
        if (D()) {
            aY();
            this.aJ.m1378a(this.as.now() - this.aU);
        }
        TodayNotificationsUtil todayNotificationsUtil = this.aJ;
        todayNotificationsUtil.f1217c.edit().putBoolean(TodayPrefKeys.f1236h, this.aI.m1368a()).a(TodayPrefKeys.f1233e, todayNotificationsUtil.f1215a.a()).commit();
        this.ax.i = null;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2115498265, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 256536085);
        super.mj_();
        this.ax.a(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -76411025, a);
    }

    public final void m1401I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -689909868);
        if (this.aI != null) {
            TodayNotificationsHolder todayNotificationsHolder = this.aI;
            todayNotificationsHolder.f1206e.b(todayNotificationsHolder.f1207f);
            todayNotificationsHolder.f1202a.unregisterAll();
        }
        if (this.aS != null) {
            this.aS.c();
        }
        if (m1411n() != null) {
            m1411n().c(this.aW);
            m1411n().x();
        }
        TodayFbPushDataHandler todayFbPushDataHandler = this.aE;
        todayFbPushDataHandler.f1246b = new Handler();
        todayFbPushDataHandler.f1247c = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1259926279, a);
    }

    public final void m1410g(boolean z) {
        boolean D = D();
        super.g(z);
        if (mx_() && z && this.av.u() == null) {
            this.aJ.m1379a(SyncSource.FRAGMENT_LOADED);
            if (bc()) {
                bl();
                m1406a(this.av);
            } else {
                super.aC();
            }
        }
        if (mx_() && D != z) {
            if (!(z || getInteractionTracker() == null)) {
                aY();
                this.aJ.m1378a(this.as.now() - this.aU);
            }
            if (z) {
                aZ();
                if (E().b(190) == null) {
                    E().a(190, null, this);
                }
                this.aJ.m1380a(this.at, this.aI.m1370e(), D());
                this.aU = this.as.now();
            }
            this.aR = z;
        } else if (this.ax != null) {
            this.ax.a(null);
        }
    }

    private void aY() {
        if (getInteractionTracker() != null) {
            getInteractionTracker().g();
            this.aV.f1166d = true;
            getInteractionTracker().d(this.as.now());
            getInteractionTracker().c();
            getInteractionTracker().a();
        }
    }

    private void aZ() {
        int l = this.ap.l();
        int n = this.ap.n();
        if (l == -1 || n == -1 || this.at.e() == 0) {
            this.am.a(aN, "Today rendered with no views or no data");
            return;
        }
        while (l <= n) {
            int f = this.at.f(l);
            getInteractionTracker().a(this.at.e(f).k(), f, l);
            l++;
        }
        getInteractionTracker().a(this.as.now());
    }

    public final void kQ_() {
        Object obj;
        this.ay = false;
        aJ();
        ReactionSession reactionSession = this.av;
        if (reactionSession == null || !reactionSession.A()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m1406a(this.av);
        }
        be();
        this.h.b(7274497, (short) 2);
        this.h.b(7274499, (short) 2);
        this.h.b(7274500, (short) 2);
    }

    public final void kp_() {
        this.ay = false;
        bl();
        if (this.ao.d()) {
            this.aD.a(new ToastBuilder(jW_().getString(2131230758)));
        } else {
            this.aD.a(new ToastBuilder(jW_().getString(2131230759)));
        }
        be();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.at.a(configuration);
    }

    private void bj() {
        this.h.d(7274501);
        this.h.d(7274503);
    }

    private void bl() {
        this.h.d(7274497);
        this.h.d(7274499);
        this.h.d(7274500);
    }

    public final String am_() {
        return "today";
    }

    public final Loader<List<NotificationsEdgeFields>> n_(int i) {
        Context ao = ao();
        ViewerContext d = this.aM.d();
        switch (i) {
            case 189:
                if (d != null) {
                    int d2 = this.aJ.m1384d();
                    this.aI.f1210i = d2;
                    return new NotificationsLoader(ao, this.aq, ao.getContentResolver(), this.ar.b, d, this.aJ.m1376a((Activity) ao, d2), false, this.av);
                }
                break;
            case 190:
                break;
        }
        if (d != null) {
            UnseenNotificationsLoader unseenNotificationsLoader = new UnseenNotificationsLoader(ao, this.aq, ao.getContentResolver(), this.av, this.ar.b, d);
            unseenNotificationsLoader.i = true;
            return unseenNotificationsLoader;
        }
        return null;
    }

    protected final void m1406a(ReactionSession reactionSession) {
        Object obj;
        if (this.aq.o != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            super.a(reactionSession);
            return;
        }
        this.at.b(reactionSession);
        ImmutableList p = reactionSession.p();
        int size = p.size();
        for (int i = 0; i < size; i++) {
            this.at.a((ReactionStories) p.get(i));
        }
    }

    public final void gA_() {
        TodayNotificationsHolder todayNotificationsHolder = this.aI;
        todayNotificationsHolder.f1212k.clear();
        todayNotificationsHolder.m1371g();
        bj();
    }

    public final void m1409e() {
        if (this.av != null && this.av.q) {
            au();
        } else if (bc()) {
            kp_();
        } else {
            if (!kq_()) {
                this.h.d(7274499);
            }
            this.h.b(7274503);
            this.h.b(7274500);
            super.e();
            E().b(189, null, this);
            TodayNotificationsHolder todayNotificationsHolder = this.aI;
            todayNotificationsHolder.f1208g = false;
            todayNotificationsHolder.f1213l = false;
            this.aJ.m1379a(SyncSource.PULL_TO_REFRESH);
            this.ax.a(null);
            this.aJ.m1377a();
        }
    }

    protected final void m1404a(RecyclerView recyclerView) {
        if (this.aA > this.aw.a(getContext())) {
            TodayAnalyticsLogger todayAnalyticsLogger = this.aV;
            long j = (long) this.aA;
            if (todayAnalyticsLogger.f1166d) {
                todayAnalyticsLogger.f1164b.a.a(ReactionAnalyticsLogger.a(ReactionAnalyticsLogger.Event.REACTION_FORWARD_SCROLL, todayAnalyticsLogger.f1165c.a, "reaction_attachment", todayAnalyticsLogger.f1165c.c).a("scrolled_offset", j));
                todayAnalyticsLogger.f1166d = false;
            }
        }
        if (aK() == this.aT) {
            this.aX.b();
        }
    }

    public final void gB_() {
        m1411n().e(0);
        this.aJ.m1379a(SyncSource.FRAGMENT_LOADED);
    }

    public final boolean gC_() {
        return m1411n().n();
    }

    public final ScrollingViewProxy m1411n() {
        if (this.aO == null) {
            this.aO = new RecyclerViewProxy((BetterRecyclerView) getCardViewGroup());
        }
        return this.aO;
    }

    private void m1396a(AbstractFbErrorReporter abstractFbErrorReporter, FbLocationCache fbLocationCache, FbNetworkManager fbNetworkManager, FbSharedPreferences fbSharedPreferences, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, GraphQLNotificationsContract graphQLNotificationsContract, MonotonicClock monotonicClock, NetworkMonitor networkMonitor, NotificationsFragmentTouchUtil notificationsFragmentTouchUtil, NotificationsLastUpdatedUtil notificationsLastUpdatedUtil, DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsRowWithActionHelper notificationsRowWithActionHelper, PerformanceLogger performanceLogger, ReactionSessionManager reactionSessionManager, ResourceManager resourceManager, TabletExperimentConfiguration tabletExperimentConfiguration, TabletColumnLayoutManager tabletColumnLayoutManager, Toaster toaster, TodayFbPushDataHandler todayFbPushDataHandler, TodayMixedRecyclerViewAdapterProvider todayMixedRecyclerViewAdapterProvider, TodayAnalyticsLoggerProvider todayAnalyticsLoggerProvider, TodayExperimentController todayExperimentController, TodayNotificationsHolder todayNotificationsHolder, TodayNotificationsUtil todayNotificationsUtil, TodayNotificationPillControllerProvider todayNotificationPillControllerProvider, TodayReactionSessionBuilder todayReactionSessionBuilder, ViewerContextManager viewerContextManager) {
        this.am = abstractFbErrorReporter;
        this.an = fbLocationCache;
        this.ao = fbNetworkManager;
        this.ap = fbSharedPreferences;
        this.aq = graphQLNotificationsContentProviderHelper;
        this.ar = graphQLNotificationsContract;
        this.as = monotonicClock;
        this.at = networkMonitor;
        this.au = notificationsFragmentTouchUtil;
        this.av = notificationsLastUpdatedUtil;
        this.aw = defaultNotificationsRenderer;
        this.ax = notificationsRowWithActionHelper;
        this.ay = performanceLogger;
        this.az = reactionSessionManager;
        this.aA = resourceManager;
        this.aB = tabletExperimentConfiguration;
        this.aC = tabletColumnLayoutManager;
        this.aD = toaster;
        this.aE = todayFbPushDataHandler;
        this.aF = todayMixedRecyclerViewAdapterProvider;
        this.aG = todayAnalyticsLoggerProvider;
        this.aH = todayExperimentController;
        this.aI = todayNotificationsHolder;
        this.aJ = todayNotificationsUtil;
        this.aK = todayNotificationPillControllerProvider;
        this.aL = todayReactionSessionBuilder;
        this.aM = viewerContextManager;
    }

    public final boolean aD() {
        if (bc()) {
            return false;
        }
        this.ay = true;
        this.az.f(getSessionId());
        this.aJ.m1379a(SyncSource.BACKGROUND);
        return true;
    }

    private boolean bc() {
        if (!this.aH.b.a(ExperimentsForTodayAbTestModule.h, false)) {
            return false;
        }
        return this.aA.a(this.aA.a());
    }

    private void bd() {
        if (this.aB.a()) {
            ColumnWidthConfig b = this.aC.b(ContentFragmentType.TODAY_FRAGMENT);
            m1411n().ix_().setPadding(b.c, m1411n().g(), b.d, m1411n().f());
        }
    }

    private void be() {
        int i;
        boolean e = this.aI.m1370e();
        AbstractReactionRecyclerViewAdapter abstractReactionRecyclerViewAdapter = this.at;
        if (abstractReactionRecyclerViewAdapter == null) {
            i = -1;
        } else {
            i = 0;
            loop0:
            while (i < abstractReactionRecyclerViewAdapter.e()) {
                ReactionItem e2 = abstractReactionRecyclerViewAdapter.e(i);
                if (!(e2 == null || e2.k() == null)) {
                    ImmutableList s = e2.k().s();
                    if (CollectionUtil.a(s)) {
                        continue;
                    } else {
                        int size = s.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i2);
                            if (reactionUnitComponentModel != null && GraphQLReactionUnitComponentStyle.NOTIFICATIONS_LIST.equals(reactionUnitComponentModel.a())) {
                                break loop0;
                            }
                        }
                        continue;
                    }
                }
                i++;
            }
            i = -1;
        }
        this.aT = i;
        boolean a = this.aJ.m1382a(this.aT);
        this.aX.f1374a = this.aT;
        if (!e) {
            b(true);
            m1398g(8);
        } else if (a) {
            b(false);
            ay();
            m1398g(0);
            if (!kq_() || bf()) {
                au();
            }
            this.aJ.m1380a(this.at, this.aI.m1370e(), D());
        } else if (!a) {
            b(false);
            ay();
            m1398g(8);
            au();
        }
    }

    private boolean bf() {
        if (this.at != null && this.at.getItemViewType(this.at.aZ_()) == ReactionViewTypeConstants.b) {
            return true;
        }
        return false;
    }

    private void bg() {
        if (D()) {
            this.h.b(7274501);
            this.h.b(7274497);
        }
    }

    private void m1398g(int i) {
        if (this.T != null) {
            View findViewById = this.T.findViewById(2131561342);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
        }
    }
}
