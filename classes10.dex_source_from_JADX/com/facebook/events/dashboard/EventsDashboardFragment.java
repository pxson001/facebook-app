package com.facebook.events.dashboard;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.common.TtiVia;
import com.facebook.events.dashboard.CaspianEventsDashboardBucketAdapter.C22987;
import com.facebook.events.dashboard.EventsDashboardFragmentController.C23241;
import com.facebook.events.dashboard.EventsDashboardFragmentController.C23252;
import com.facebook.events.dashboard.EventsDashboardFragmentController.InviteCountChangeListener;
import com.facebook.events.dashboard.EventsDashboardPagerAdapter.EventsBadgePagerAdapter;
import com.facebook.events.dashboard.EventsDashboardSequenceLogger.LoadingState;
import com.facebook.events.dashboard.EventsPager.C23715;
import com.facebook.events.dashboard.EventsPager.C23726;
import com.facebook.events.dashboard.EventsPager.EventsDashboardPagerTaskType;
import com.facebook.events.dashboard.EventsPager.EventsPagerCallback;
import com.facebook.events.dashboard.EventsPager.EventsPagerEarlyFetchFutureHolder;
import com.facebook.events.dashboard.birthdays.BirthdaysPager;
import com.facebook.events.dashboard.birthdays.BirthdaysPager.BirthdaysPagerCallback;
import com.facebook.events.dashboard.birthdays.EventsUpcomingBirthdaysListViewHelper;
import com.facebook.events.dashboard.subscriptions.EventsSubscriptionsPager;
import com.facebook.events.dashboard.subscriptions.EventsSubscriptionsPager.EventsSubscriptionsCallback;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsPager;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsPager.C24172;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsPager.C24183;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsPager.EventsSuggestionsCallback;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsPager.EventsSuggestionsFetcherTask;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsCommonContract.EventsCommonTable.Columns;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel.EventCountsModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchSubscribedEventsModel.SubscribedProfileCalendarEventsModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.SuggestedEventCutModel;
import com.facebook.events.logging.BirthdayReminderLogger;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.google.common.base.Absent;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: commerce_merchant_settings_id */
public class EventsDashboardFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    EventsDashboardCaspianPagerController f16636a;
    @Inject
    EventsUpcomingBirthdaysListViewHelper aA;
    @Inject
    RapidFeedbackController aB;
    public EventsDashboardFragmentController aC;
    public EventsPager aD;
    @Nullable
    private BetterListView aE;
    private FbSwipeRefreshLayout aF;
    private EventAnalyticsParams aG;
    public FrameRateLogger aH;
    public int aI;
    public boolean aJ;
    public String aK;
    public String aL;
    public DashboardFilterType aM;
    private DashboardFilterType aN;
    public int aO;
    private FragmentMode aP;
    public Long aQ;
    public Long aR;
    private EventsSubscriptionsCallback aS;
    private EventsSuggestionsCallback aT;
    private OnRefreshListener aU;
    private OnScrollListener aV;
    private boolean aW;
    private boolean aX;
    public TtiVia aY;
    public final EnumMap<PostInteractivityTask, Runnable> aZ = new EnumMap(PostInteractivityTask.class);
    @Inject
    public FrameRateLoggerProvider al;
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService am;
    @Inject
    public CaspianEventsDashboardBucketAdapter an;
    @Inject
    EventEventLogger ao;
    @Inject
    EventsDashboardPerformanceLogger ap;
    @Inject
    public EventsDashboardSequenceLogger aq;
    @Inject
    GraphQLQueryExecutor ar;
    @Inject
    TasksManager as;
    @Inject
    Lazy<EventsSubscriptionsPager> at;
    @Inject
    Lazy<EventsSuggestionsPager> au;
    @Inject
    ReactionSessionManager av;
    @Inject
    public GatekeeperStoreImpl aw;
    @Inject
    public BirthdayReminderLogger ax;
    @Inject
    EventsDashboardFragmentControllerProvider ay;
    @Inject
    EventsDashboardPagerAdapter az;
    @Inject
    ActionItemInvite f16637b;
    private ListenableFuture<Cursor> ba;
    private Cursor bb;
    private EventsPagerCallback bc = new C23131(this);
    private EventsPagerCallback bd = new C23162(this);
    @Inject
    EventsCommonContract f16638c;
    @Inject
    EventsDashboardEarlyFetcher f16639d;
    @Inject
    Provider<EventsPager> f16640e;
    @Inject
    BirthdaysPager f16641f;
    @Inject
    EventsDashboardController f16642g;
    @Inject
    EmptyUpcomingEventsState f16643h;
    @Inject
    FbNetworkManager f16644i;

    /* compiled from: commerce_merchant_settings_id */
    public class AnonymousClass18 implements Runnable {
        final /* synthetic */ List f16615a;
        final /* synthetic */ int f16616b;
        final /* synthetic */ EventsDashboardFragment f16617c;

        public AnonymousClass18(EventsDashboardFragment eventsDashboardFragment, List list, int i) {
            this.f16617c = eventsDashboardFragment;
            this.f16615a = list;
            this.f16616b = i;
        }

        public void run() {
            EventsDashboardFragment.m17044b(this.f16617c, this.f16615a, this.f16616b);
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    class C23131 implements EventsPagerCallback {
        final /* synthetic */ EventsDashboardFragment f16620a;

        /* compiled from: commerce_merchant_settings_id */
        class C23112 implements Runnable {
            final /* synthetic */ C23131 f16602a;

            C23112(C23131 c23131) {
                this.f16602a = c23131;
            }

            public void run() {
                EventsDashboardFragment.as(this.f16602a.f16620a);
            }
        }

        C23131(EventsDashboardFragment eventsDashboardFragment) {
            this.f16620a = eventsDashboardFragment;
        }

        public final void mo787a(final boolean z, final int i, final Long l) {
            if (this.f16620a.aY == TtiVia.DB_FETCH) {
                this.f16620a.aZ.put(PostInteractivityTask.ON_EVENTS_FROM_GRAPHQL, new Runnable(this) {
                    final /* synthetic */ C23131 f16601d;

                    public void run() {
                        EventsDashboardFragment.m17036a(this.f16601d.f16620a, z, i, l);
                    }
                });
            } else {
                EventsDashboardFragment.m17036a(this.f16620a, z, i, l);
            }
        }

        public final void mo786a() {
            if (this.f16620a.aY == TtiVia.DB_FETCH) {
                this.f16620a.aZ.put(PostInteractivityTask.ON_EVENTS_FROM_GRAPHQL, new C23112(this));
            } else {
                EventsDashboardFragment.as(this.f16620a);
            }
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    class C23162 implements EventsPagerCallback {
        final /* synthetic */ EventsDashboardFragment f16626a;

        /* compiled from: commerce_merchant_settings_id */
        class C23152 implements Runnable {
            final /* synthetic */ C23162 f16625a;

            C23152(C23162 c23162) {
                this.f16625a = c23162;
            }

            public void run() {
                EventsDashboardFragment.as(this.f16625a.f16626a);
            }
        }

        C23162(EventsDashboardFragment eventsDashboardFragment) {
            this.f16626a = eventsDashboardFragment;
        }

        public final void mo787a(final boolean z, final int i, final Long l) {
            if (this.f16626a.aY == TtiVia.DB_FETCH) {
                this.f16626a.aZ.put(PostInteractivityTask.ON_EVENTS_FROM_GRAPHQL, new Runnable(this) {
                    final /* synthetic */ C23162 f16624d;

                    public void run() {
                        EventsDashboardFragment.m17045b(this.f16624d.f16626a, z, i, l);
                    }
                });
            } else {
                EventsDashboardFragment.m17045b(this.f16626a, z, i, l);
            }
        }

        public final void mo786a() {
            if (this.f16626a.aY == TtiVia.DB_FETCH) {
                this.f16626a.aZ.put(PostInteractivityTask.ON_EVENTS_FROM_GRAPHQL, new C23152(this));
            } else {
                EventsDashboardFragment.as(this.f16626a);
            }
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    class C23173 extends AbstractDisposableFutureCallback<GraphQLResult<FetchEventCountsQueryModel>> {
        final /* synthetic */ EventsDashboardFragment f16627a;

        C23173(EventsDashboardFragment eventsDashboardFragment) {
            this.f16627a = eventsDashboardFragment;
        }

        protected final void m17019a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((FetchEventCountsQueryModel) graphQLResult.e).a() != null) {
                EventCountsModel a = ((FetchEventCountsQueryModel) graphQLResult.e).a();
                this.f16627a.an.f16459B = a;
                EventsDashboardFragmentController eventsDashboardFragmentController = this.f16627a.aC;
                if (eventsDashboardFragmentController.f16655c != null) {
                    eventsDashboardFragmentController.f16655c.mo782a(a.a());
                }
            }
        }

        protected final void m17020a(Throwable th) {
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    class C23184 implements BirthdaysPagerCallback {
        final /* synthetic */ EventsDashboardFragment f16628a;

        C23184(EventsDashboardFragment eventsDashboardFragment) {
            this.f16628a = eventsDashboardFragment;
        }

        public final void mo788a(boolean z, String str, String str2, @Nonnull List<EventUserWithBirthdayFragmentModel> list) {
            EventsDashboardFragment eventsDashboardFragment = this.f16628a;
            if (eventsDashboardFragment.aY == null) {
                eventsDashboardFragment.an.m16912a((List) list, eventsDashboardFragment.aL);
            } else {
                eventsDashboardFragment.aZ.put(PostInteractivityTask.ON_BIRTHDAYS, new C23217(eventsDashboardFragment, list));
            }
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    public class C23206 implements LoaderCallbacks<Cursor> {
        final /* synthetic */ EventsDashboardFragment f16631a;

        public C23206(EventsDashboardFragment eventsDashboardFragment) {
            this.f16631a = eventsDashboardFragment;
        }

        public final void m17023a(Loader loader, Object obj) {
            EventsDashboardFragment.m17032a(this.f16631a, (Cursor) obj, DashboardFilterType.values()[loader.m]);
            EventsDashboardFragment.aC(this.f16631a);
        }

        public final Loader<Cursor> n_(int i) {
            DashboardFilterType dashboardFilterType = DashboardFilterType.values()[i];
            return new EventsCursorLoader(this.f16631a.getContext(), EventsDashboardFragment.m17027a(this.f16631a, dashboardFilterType), null, null, null, EventsDashboardFragment.m17041b(this.f16631a, dashboardFilterType));
        }

        public final void gA_() {
            this.f16631a.aO = 0;
            this.f16631a.an.m16910a(null, (ImmutableSet) RegularImmutableSet.a, null, false);
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    public class C23217 implements Runnable {
        final /* synthetic */ List f16632a;
        final /* synthetic */ EventsDashboardFragment f16633b;

        public C23217(EventsDashboardFragment eventsDashboardFragment, List list) {
            this.f16633b = eventsDashboardFragment;
            this.f16632a = list;
        }

        public void run() {
            this.f16633b.an.m16912a(this.f16632a, this.f16633b.aL);
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    class C23228 extends SimpleOnPageChangeListener {
        final /* synthetic */ EventsDashboardFragment f16634a;

        C23228(EventsDashboardFragment eventsDashboardFragment) {
            this.f16634a = eventsDashboardFragment;
        }

        public final void m17024a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            DashboardFilterType dashboardFilterType;
            EventsDashboardPagerAdapter eventsDashboardPagerAdapter = this.f16634a.az;
            if (i < 0 || i >= eventsDashboardPagerAdapter.f16695d.length) {
                dashboardFilterType = null;
            } else {
                dashboardFilterType = eventsDashboardPagerAdapter.f16695d[i];
            }
            DashboardFilterType dashboardFilterType2 = dashboardFilterType;
            if (dashboardFilterType2 != null) {
                this.f16634a.ao.m18141c(dashboardFilterType2.name());
            }
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    class C23239 implements InviteCountChangeListener {
        final /* synthetic */ EventsDashboardFragment f16635a;

        C23239(EventsDashboardFragment eventsDashboardFragment) {
            this.f16635a = eventsDashboardFragment;
        }

        public final void mo782a(int i) {
            EventsBadgePagerAdapter eventsBadgePagerAdapter = this.f16635a.az.f16697f;
            if (eventsBadgePagerAdapter.f16691b != i) {
                eventsBadgePagerAdapter.f16691b = i;
                eventsBadgePagerAdapter.a();
            }
        }

        public final int mo781a() {
            return this.f16635a.az.f16697f.f16691b;
        }
    }

    /* compiled from: commerce_merchant_settings_id */
    public enum FragmentMode {
        STANDALONE,
        SECONDARY_NAVIGATION
    }

    /* compiled from: commerce_merchant_settings_id */
    public enum PostInteractivityTask {
        ON_EVENTS_FROM_GRAPHQL,
        ON_SUBSCRIPTIONS,
        ON_SUGGESTIONS,
        ON_BIRTHDAYS
    }

    /* compiled from: commerce_merchant_settings_id */
    enum Tasks {
        FIRST_DB_FETCH,
        FETCH_EVENT_COUNTS
    }

    public static void m17038a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsDashboardFragment) obj).m17031a(EventsDashboardCaspianPagerController.m16972a(injectorLike), ActionItemInvite.m18355a(injectorLike), EventsCommonContract.a(injectorLike), EventsDashboardEarlyFetcher.m16980a(injectorLike), IdBasedProvider.a(injectorLike, 5559), BirthdaysPager.m17291a(injectorLike), EventsDashboardController.m16975a(injectorLike), EmptyUpcomingEventsState.m16925a(injectorLike), FbNetworkManager.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), CaspianEventsDashboardBucketAdapter.m16886a(injectorLike), EventEventLogger.m18116a(injectorLike), EventsDashboardPerformanceLogger.m17093a(injectorLike), EventsDashboardSequenceLogger.m17147a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.a(injectorLike), IdBasedLazy.a(injectorLike, 5580), IdBasedLazy.a(injectorLike, 5583), ReactionSessionManager.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), BirthdayReminderLogger.m18107a(injectorLike), (EventsDashboardFragmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsDashboardFragmentControllerProvider.class), EventsDashboardPagerAdapter.m17086a(injectorLike), EventsUpcomingBirthdaysListViewHelper.m17333a(injectorLike), RapidFeedbackController.a(injectorLike));
    }

    private void m17031a(EventsDashboardCaspianPagerController eventsDashboardCaspianPagerController, ActionItemInvite actionItemInvite, EventsCommonContract eventsCommonContract, EventsDashboardEarlyFetcher eventsDashboardEarlyFetcher, Provider<EventsPager> provider, BirthdaysPager birthdaysPager, EventsDashboardController eventsDashboardController, EmptyUpcomingEventsState emptyUpcomingEventsState, FbNetworkManager fbNetworkManager, FrameRateLoggerProvider frameRateLoggerProvider, ListeningExecutorService listeningExecutorService, CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter, EventEventLogger eventEventLogger, EventsDashboardPerformanceLogger eventsDashboardPerformanceLogger, EventsDashboardSequenceLogger eventsDashboardSequenceLogger, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Lazy<EventsSubscriptionsPager> lazy, Lazy<EventsSuggestionsPager> lazy2, ReactionSessionManager reactionSessionManager, GatekeeperStore gatekeeperStore, BirthdayReminderLogger birthdayReminderLogger, EventsDashboardFragmentControllerProvider eventsDashboardFragmentControllerProvider, EventsDashboardPagerAdapter eventsDashboardPagerAdapter, EventsUpcomingBirthdaysListViewHelper eventsUpcomingBirthdaysListViewHelper, RapidFeedbackController rapidFeedbackController) {
        this.f16636a = eventsDashboardCaspianPagerController;
        this.f16637b = actionItemInvite;
        this.f16638c = eventsCommonContract;
        this.f16639d = eventsDashboardEarlyFetcher;
        this.f16640e = provider;
        this.f16641f = birthdaysPager;
        this.f16642g = eventsDashboardController;
        this.f16643h = emptyUpcomingEventsState;
        this.f16644i = fbNetworkManager;
        this.al = frameRateLoggerProvider;
        this.am = listeningExecutorService;
        this.an = caspianEventsDashboardBucketAdapter;
        this.ao = eventEventLogger;
        this.ap = eventsDashboardPerformanceLogger;
        this.aq = eventsDashboardSequenceLogger;
        this.ar = graphQLQueryExecutor;
        this.as = tasksManager;
        this.at = lazy;
        this.au = lazy2;
        this.av = reactionSessionManager;
        this.aw = gatekeeperStore;
        this.ax = birthdayReminderLogger;
        this.ay = eventsDashboardFragmentControllerProvider;
        this.az = eventsDashboardPagerAdapter;
        this.aA = eventsUpcomingBirthdaysListViewHelper;
        this.aB = rapidFeedbackController;
    }

    public static EventsDashboardFragment m17029a(Bundle bundle, String str, String str2) {
        bundle.putString("extra_dashboard_filter_type", str2);
        return m17028a(bundle, str);
    }

    public static EventsDashboardFragment m17028a(Bundle bundle, String str) {
        EventsDashboardFragment eventsDashboardFragment = new EventsDashboardFragment();
        bundle.putString("extra_key_fragment_mode", FragmentMode.STANDALONE.name());
        if (str != null) {
            bundle.putString("extra_ref_module", str.toString());
        }
        eventsDashboardFragment.g(bundle);
        return eventsDashboardFragment;
    }

    public static EventsDashboardFragment m17040b(Bundle bundle, String str, String str2) {
        bundle.putString("extra_dashboard_filter_type", str2);
        return m17039b(bundle, str);
    }

    public static EventsDashboardFragment m17039b(Bundle bundle, String str) {
        EventsDashboardFragment eventsDashboardFragment = new EventsDashboardFragment();
        bundle.putString("extra_key_fragment_mode", FragmentMode.SECONDARY_NAVIGATION.name());
        if (str != null) {
            bundle.putString("extra_ref_module", str.toString());
        }
        eventsDashboardFragment.g(bundle);
        return eventsDashboardFragment;
    }

    public static void as(EventsDashboardFragment eventsDashboardFragment) {
        if (eventsDashboardFragment.at()) {
            eventsDashboardFragment.aF.setRefreshing(false);
            if (eventsDashboardFragment.f16644i.d()) {
                eventsDashboardFragment.aC.m17067a(NotificationBannerType.FAILURE_LOADING_EVENTS);
            } else {
                eventsDashboardFragment.aC.m17067a(NotificationBannerType.NO_CONNECTION);
            }
        }
    }

    public static void m17036a(EventsDashboardFragment eventsDashboardFragment, boolean z, int i, Long l) {
        boolean z2 = true;
        if (eventsDashboardFragment.at()) {
            eventsDashboardFragment.aC.m17070h();
            eventsDashboardFragment.aF.setRefreshing(false);
            eventsDashboardFragment.an.m16915b(z);
            if (z) {
                if (i <= 0) {
                    z2 = false;
                }
                eventsDashboardFragment.aW = z2;
                aC(eventsDashboardFragment);
            } else {
                eventsDashboardFragment.aW = true;
                if (i == 0) {
                    eventsDashboardFragment.an.m16913a(true);
                    eventsDashboardFragment.aq.m17151a(LoadingState.RENDERING);
                    eventsDashboardFragment.m17030a(eventsDashboardFragment.av(), true);
                    eventsDashboardFragment.f16643h.m16927a();
                }
            }
            if (l != null) {
                eventsDashboardFragment.aQ = l;
            }
        }
    }

    public static void m17045b(EventsDashboardFragment eventsDashboardFragment, boolean z, int i, Long l) {
        boolean z2 = true;
        if (eventsDashboardFragment.at()) {
            eventsDashboardFragment.aC.m17070h();
            eventsDashboardFragment.aF.setRefreshing(false);
            eventsDashboardFragment.an.m16915b(z);
            if (z) {
                if (i <= 0) {
                    z2 = false;
                }
                eventsDashboardFragment.aX = z2;
                aC(eventsDashboardFragment);
            } else {
                eventsDashboardFragment.aX = true;
                if (i == 0) {
                    eventsDashboardFragment.an.m16913a(true);
                    eventsDashboardFragment.m17030a(DashboardFilterType.PAST, true);
                }
            }
            if (l != null) {
                eventsDashboardFragment.aR = l;
            }
        }
    }

    public final void m17056e() {
        this.as.a(Tasks.FETCH_EVENT_COUNTS, this.ar.a(GraphQLRequest.a(EventsGraphQL.a()).a(GraphQLCachePolicy.c)), new C23173(this));
    }

    private boolean at() {
        return this.aE != null;
    }

    public final void m17055c(Bundle bundle) {
        boolean z;
        FragmentMode valueOf;
        DashboardFilterType valueOf2;
        Object a;
        String a2;
        super.c(bundle);
        Class cls = EventsDashboardFragment.class;
        m17038a((Object) this, getContext());
        Bundle bundle2 = this.s;
        EventsDashboardCaspianPagerController eventsDashboardCaspianPagerController = this.f16636a;
        if (bundle2 == null || !bundle2.getBoolean("force_tabbed_dashboard", false)) {
            z = false;
        } else {
            z = true;
        }
        eventsDashboardCaspianPagerController.f16565b = z;
        Bundle bundle3 = this.s;
        if (bundle != null && bundle.containsKey("extra_key_fragment_mode")) {
            valueOf = FragmentMode.valueOf(bundle.getString("extra_key_fragment_mode"));
        } else if (bundle3 == null || !bundle3.containsKey("extra_key_fragment_mode")) {
            valueOf = FragmentMode.STANDALONE;
        } else {
            valueOf = FragmentMode.valueOf(bundle3.getString("extra_key_fragment_mode"));
        }
        this.aP = valueOf;
        bundle3 = this.s;
        if (bundle != null && bundle.containsKey("extra_dashboard_filter_type")) {
            valueOf2 = DashboardFilterType.valueOf(bundle.getString("extra_dashboard_filter_type"));
        } else if (bundle3 == null || !bundle3.containsKey("extra_dashboard_filter_type")) {
            valueOf2 = DashboardFilterType.UPCOMING;
        } else {
            valueOf2 = DashboardFilterType.valueOf(bundle3.getString("extra_dashboard_filter_type"));
        }
        this.aM = valueOf2;
        switch (this.aP) {
            case SECONDARY_NAVIGATION:
                this.aC = this.ay.m17072a(this, this.aM, Boolean.valueOf(true));
                this.aC.m17066a();
                break;
            case STANDALONE:
                this.aC = this.ay.m17072a(this, this.aM, Boolean.valueOf(false));
                this.aC.m17066a();
                this.aq.m17150a();
                break;
        }
        this.aJ = this.aw.a(643, false);
        if (this.aJ) {
            this.aH = this.al.a(Boolean.valueOf(false), "events_dashboard_scroll", Absent.INSTANCE);
        }
        if (this.aM != DashboardFilterType.BIRTHDAYS) {
            this.aY = TtiVia.DB_FETCH;
        }
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131431107);
        EventsPagerEarlyFetchFutureHolder eventsPagerEarlyFetchFutureHolder = (EventsPagerEarlyFetchFutureHolder) this.f16639d.b(EventsDashboardEarlyFetcher.f16575a);
        if (eventsPagerEarlyFetchFutureHolder != null) {
            this.aD = eventsPagerEarlyFetchFutureHolder.f16909b;
            this.f16642g.f16571d = this.aD;
            a = this.aD.m17277a(eventsPagerEarlyFetchFutureHolder, this.bc);
        } else {
            this.aD = (EventsPager) this.f16640e.get();
            this.f16642g.f16571d = this.aD;
            a = this.aD.m17276a(dimensionPixelSize, this.bc);
        }
        this.aZ.put(PostInteractivityTask.ON_EVENTS_FROM_GRAPHQL, a);
        if (this.aM != DashboardFilterType.BIRTHDAYS) {
            ListenableFuture a3;
            final DashboardFilterType dashboardFilterType = this.aM;
            this.aq.m17151a(LoadingState.DB_FETCH);
            if (this.aM != DashboardFilterType.UPCOMING || eventsPagerEarlyFetchFutureHolder == null || eventsPagerEarlyFetchFutureHolder.f16908a == null) {
                a3 = this.am.a(new Callable<Cursor>(this) {
                    final /* synthetic */ EventsDashboardFragment f16630b;

                    public Object call() {
                        Cursor query = this.f16630b.getContext().getContentResolver().query(EventsDashboardFragment.m17027a(this.f16630b, dashboardFilterType), null, null, null, EventsDashboardFragment.m17041b(this.f16630b, dashboardFilterType));
                        if (query != null) {
                            query.getCount();
                        }
                        return query;
                    }
                });
            } else {
                a3 = eventsPagerEarlyFetchFutureHolder.f16908a;
            }
            this.ba = a3;
        }
        this.an.f16479k = this;
        LoaderCallbacks c23206 = new C23206(this);
        EventsDashboardController eventsDashboardController = this.f16642g;
        DashboardFilterType dashboardFilterType2 = this.aM;
        eventsDashboardController.f16568a = this;
        eventsDashboardController.f16569b = c23206;
        eventsDashboardController.f16570c = dashboardFilterType2;
        eventsDashboardController.f16572e = false;
        o().getIntent();
        if (bundle == null || bundle.getString("birthday_view_waterfall_id_param") == null) {
            a2 = this.ax.m18111a("");
        } else {
            a2 = bundle.getString("birthday_view_waterfall_id_param");
        }
        this.aL = a2;
        this.f16641f.m17293a(3, null, null, new GregorianCalendar(TimeZone.getDefault()), new C23184(this));
        aF();
        aG();
        this.aG = this.aC.f16654b;
        this.an.f16463F = this.aG;
        this.f16637b.f17957a = this.aG;
    }

    private String aE() {
        String string = this.s.getString("extra_ref_module");
        return string != null ? string : "unknown";
    }

    private DashboardFilterType av() {
        return this.f16642g.f16570c;
    }

    public static void aw(EventsDashboardFragment eventsDashboardFragment) {
        eventsDashboardFragment.f16642g.m16978a();
    }

    public static void m17032a(EventsDashboardFragment eventsDashboardFragment, Cursor cursor, DashboardFilterType dashboardFilterType) {
        try {
            boolean z;
            eventsDashboardFragment.aO = cursor == null ? 0 : cursor.getCount();
            if (eventsDashboardFragment.aO > 0) {
                z = true;
                if (dashboardFilterType == DashboardFilterType.UPCOMING) {
                    eventsDashboardFragment.f16643h.m16928b();
                }
            } else {
                z = dashboardFilterType == DashboardFilterType.PAST ? eventsDashboardFragment.aX : eventsDashboardFragment.aW;
            }
            if (z) {
                eventsDashboardFragment.aq.m17151a(LoadingState.RENDERING);
            }
            eventsDashboardFragment.an.m16910a(cursor, eventsDashboardFragment.aC.m17071i(), dashboardFilterType, z);
            eventsDashboardFragment.m17030a(dashboardFilterType, z);
        } finally {
            if (!(eventsDashboardFragment.bb == cursor || eventsDashboardFragment.bb == null)) {
                eventsDashboardFragment.bb.close();
                eventsDashboardFragment.bb = null;
            }
        }
    }

    public static Uri m17027a(EventsDashboardFragment eventsDashboardFragment, DashboardFilterType dashboardFilterType) {
        switch (dashboardFilterType) {
            case PAST:
                return eventsDashboardFragment.f16638c.e;
            case INVITED:
                return eventsDashboardFragment.f16638c.f;
            case HOSTING:
                return eventsDashboardFragment.f16638c.g;
            default:
                return eventsDashboardFragment.f16638c.d;
        }
    }

    static /* synthetic */ String m17041b(EventsDashboardFragment eventsDashboardFragment, DashboardFilterType dashboardFilterType) {
        String e;
        if (dashboardFilterType == DashboardFilterType.PAST) {
            e = Columns.H.e();
        } else {
            e = null;
        }
        return e;
    }

    public final void m17057e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("extra_dashboard_filter_type", av().name());
        bundle.putString("birthday_view_waterfall_id_param", this.aL);
    }

    public final View m17050a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1918876388);
        this.aq.m17151a(LoadingState.CREATE_VIEW);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131625810));
        if (aH()) {
            View inflate = cloneInContext.inflate(2130904136, viewGroup, false);
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1579138352, a);
            return inflate;
        }
        inflate = cloneInContext.inflate(2130903519, viewGroup, false);
        LogUtils.f(705168148, a);
        return inflate;
    }

    public final void m17052a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (this.aP == FragmentMode.SECONDARY_NAVIGATION) {
            m17042b(view, bundle);
        } else {
            m17046c(view, bundle);
        }
    }

    private void m17042b(View view, Bundle bundle) {
        EventsDashboardPagerAdapter eventsDashboardPagerAdapter = this.az;
        if (this.f16636a.m16974a()) {
            eventsDashboardPagerAdapter.f16695d = EventsDashboardPagerAdapter.f16693b;
        } else {
            eventsDashboardPagerAdapter.f16695d = EventsDashboardPagerAdapter.f16692a;
        }
        eventsDashboardPagerAdapter.f16696e = new EventsDashboardListViewHolder[eventsDashboardPagerAdapter.f16695d.length];
        eventsDashboardPagerAdapter.f16697f = new EventsBadgePagerAdapter(eventsDashboardPagerAdapter);
        ViewPager viewPager = (ViewPager) e(2131560260);
        viewPager.setAdapter(this.az);
        this.az.f16698g = this;
        TabbedViewPagerIndicator tabbedViewPagerIndicator = (TabbedViewPagerIndicator) e(2131560259);
        tabbedViewPagerIndicator.setViewPager(viewPager);
        tabbedViewPagerIndicator.l = new C23228(this);
        if (this.aM != DashboardFilterType.UPCOMING) {
            EventsDashboardPagerAdapter eventsDashboardPagerAdapter2 = this.az;
            viewPager.setCurrentItem(Arrays.asList(eventsDashboardPagerAdapter2.f16695d).indexOf(this.aM));
        }
        this.aC.m17068b();
        this.aC.f16655c = new C23239(this);
        this.aV = aB();
        this.aU = aA();
        ay();
    }

    private void m17046c(View view, Bundle bundle) {
        this.aC.m17068b();
        this.aF = (FbSwipeRefreshLayout) e(2131561513);
        this.aF.setColorSchemeResources(new int[]{2131361916});
        this.aF.e = aA();
        this.aE = (BetterListView) e(2131561514);
        this.aE.setStickyHeaderEnabled(false);
        m17047c(this.aE);
        aq();
        this.aE.setAdapter(this.an);
        this.aC.f16655c = new InviteCountChangeListener(this) {
            final /* synthetic */ EventsDashboardFragment f16603a;

            {
                this.f16603a = r1;
            }

            public final void mo782a(int i) {
                CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter = this.f16603a.an;
                if (caspianEventsDashboardBucketAdapter.f16477i != null) {
                    caspianEventsDashboardBucketAdapter.f16477i.setBadge(i);
                }
            }

            public final int mo781a() {
                CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter = this.f16603a.an;
                return caspianEventsDashboardBucketAdapter.f16477i == null ? 0 : caspianEventsDashboardBucketAdapter.f16477i.f16560j;
            }
        };
        ay();
    }

    private void ay() {
        this.aq.m17153b(LoadingState.CREATE_VIEW);
        if (this.aM != DashboardFilterType.BIRTHDAYS && this.ba != null) {
            if (this.ba.isDone()) {
                m17043b(this, (Cursor) FutureUtils.a(this.ba), this.aM);
            } else if (!this.ba.isCancelled()) {
                this.as.a(Tasks.FIRST_DB_FETCH, this.ba, new AbstractDisposableFutureCallback<Cursor>(this) {
                    final /* synthetic */ EventsDashboardFragment f16604a;

                    {
                        this.f16604a = r1;
                    }

                    protected final void m17004a(Object obj) {
                        EventsDashboardFragment.m17043b(this.f16604a, (Cursor) obj, this.f16604a.aM);
                    }

                    protected final void m17005a(Throwable th) {
                        EventsDashboardFragment.m17032a(this.f16604a, null, this.f16604a.aM);
                    }
                });
            }
            this.ba = null;
        }
    }

    public final void m17053a(BetterListView betterListView, FbSwipeRefreshLayout fbSwipeRefreshLayout, DashboardFilterType dashboardFilterType) {
        this.aE = betterListView;
        this.aF = fbSwipeRefreshLayout;
        if (dashboardFilterType == DashboardFilterType.BIRTHDAYS) {
            az();
        } else {
            m17037a(this.aE);
        }
        this.f16642g.m16979a(dashboardFilterType);
        if (dashboardFilterType != DashboardFilterType.BIRTHDAYS) {
            aw(this);
        }
    }

    public final void m17054b(BetterListView betterListView, FbSwipeRefreshLayout fbSwipeRefreshLayout, DashboardFilterType dashboardFilterType) {
        DashboardFilterType dashboardFilterType2 = this.f16642g.f16570c;
        if (dashboardFilterType != dashboardFilterType2) {
            this.aE = betterListView;
            this.aF = fbSwipeRefreshLayout;
            if (dashboardFilterType == DashboardFilterType.BIRTHDAYS) {
                az();
            } else if (dashboardFilterType2 == DashboardFilterType.BIRTHDAYS) {
                m17037a(this.aE);
            }
            this.f16642g.m16979a(dashboardFilterType);
            if (dashboardFilterType != DashboardFilterType.BIRTHDAYS) {
                aw(this);
            }
        }
    }

    private void az() {
        this.aA.m17337a(this, this.aE, this.aF);
        this.ao.m18128a(DashboardFilterType.BIRTHDAYS.name(), 0, aE(), this.aG.b.f.getParamValue());
        m17056e();
    }

    private void m17037a(BetterListView betterListView) {
        this.aF.e = this.aU;
        this.aI = 0;
        betterListView.setOnScrollListener(this.aV);
        betterListView.setAdapter(this.an);
    }

    public static void m17043b(EventsDashboardFragment eventsDashboardFragment, Cursor cursor, DashboardFilterType dashboardFilterType) {
        eventsDashboardFragment.aq.m17153b(LoadingState.DB_FETCH);
        int count = cursor == null ? 0 : cursor.getCount();
        if (count == 0 && dashboardFilterType == DashboardFilterType.UPCOMING) {
            eventsDashboardFragment.aW = eventsDashboardFragment.f16643h.m16929c();
        }
        if (count > 0 || eventsDashboardFragment.aW) {
            eventsDashboardFragment.bb = cursor;
            m17032a(eventsDashboardFragment, cursor, dashboardFilterType);
            return;
        }
        eventsDashboardFragment.aK = "cold";
        if (cursor != null) {
            cursor.close();
        }
        eventsDashboardFragment.aY = TtiVia.GRAPHQL;
        aw(eventsDashboardFragment);
        m17033a(eventsDashboardFragment, PostInteractivityTask.ON_EVENTS_FROM_GRAPHQL);
    }

    public static void m17033a(EventsDashboardFragment eventsDashboardFragment, PostInteractivityTask postInteractivityTask) {
        if (eventsDashboardFragment.aZ.containsKey(postInteractivityTask)) {
            ((Runnable) eventsDashboardFragment.aZ.get(postInteractivityTask)).run();
            eventsDashboardFragment.aZ.remove(postInteractivityTask);
        }
    }

    private OnRefreshListener aA() {
        return new OnRefreshListener(this) {
            final /* synthetic */ EventsDashboardFragment f16605a;

            {
                this.f16605a = r1;
            }

            public final void m17006a() {
                this.f16605a.aQ = null;
                this.f16605a.aR = null;
                this.f16605a.aD.m17278a();
                EventsDashboardFragment.m17035a(this.f16605a, true);
                this.f16605a.m17056e();
            }
        };
    }

    public final void aq() {
        if (at()) {
            BetterListView betterListView = this.aE;
            final BetterListView betterListView2 = this.aE;
            betterListView.a(new OnDrawListener(this) {
                final /* synthetic */ EventsDashboardFragment f16609b;

                public final boolean gD_() {
                    boolean z = false;
                    if (!this.f16609b.an.f16492x) {
                        return false;
                    }
                    if (this.f16609b.aK == null) {
                        this.f16609b.aK = "warm";
                    }
                    this.f16609b.ap.m17096a(this.f16609b.aK);
                    this.f16609b.aq.m17153b(LoadingState.RENDERING);
                    this.f16609b.aq.m17152b();
                    if (this.f16609b.aY == TtiVia.DB_FETCH) {
                        z = true;
                    }
                    this.f16609b.aY = null;
                    betterListView2.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass13 f16607b;

                        public void run() {
                            if (z) {
                                EventsDashboardFragment.aw(this.f16607b.f16609b);
                                EventsDashboardFragment.m17033a(this.f16607b.f16609b, PostInteractivityTask.ON_EVENTS_FROM_GRAPHQL);
                            }
                            EventsDashboardFragment.m17033a(this.f16607b.f16609b, PostInteractivityTask.ON_SUBSCRIPTIONS);
                            EventsDashboardFragment.m17033a(this.f16607b.f16609b, PostInteractivityTask.ON_SUGGESTIONS);
                            EventsDashboardFragment.m17033a(this.f16607b.f16609b, PostInteractivityTask.ON_BIRTHDAYS);
                            this.f16607b.f16609b.m17056e();
                        }
                    });
                    return true;
                }
            });
        }
    }

    private void m17047c(BetterListView betterListView) {
        this.aI = 0;
        betterListView.setOnScrollListener(aB());
    }

    private OnScrollListener aB() {
        return new OnScrollListener(this) {
            final /* synthetic */ EventsDashboardFragment f16610a;

            {
                this.f16610a = r1;
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (this.f16610a.aJ) {
                    if (this.f16610a.aI == 0) {
                        this.f16610a.aH.a();
                    } else if (i == 0 && this.f16610a.aH.q) {
                        this.f16610a.aH.b();
                    }
                }
                this.f16610a.aI = i;
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                EventsDashboardFragment.aC(this.f16610a);
            }
        };
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1475226043);
        super.mi_();
        this.aC.m17069c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1305941809, a);
    }

    public final void m17048G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 153503084);
        FbTitleBar fbTitleBar = (FbTitleBar) this.aC.f16657e.get();
        if (fbTitleBar != null) {
            fbTitleBar.setTitle(2131237122);
        }
        super.G();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -357691024, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1435284124);
        this.ap.m17097b();
        this.aE = null;
        this.aF = null;
        EventsDashboardFragmentController eventsDashboardFragmentController = this.aC;
        eventsDashboardFragmentController.f16664l.b(eventsDashboardFragmentController.f16665m);
        eventsDashboardFragmentController.f16664l.b(eventsDashboardFragmentController.f16667o);
        eventsDashboardFragmentController.f16653a = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 341763774, a);
    }

    public final void m17051a(int i, int i2, Intent intent) {
        switch (i) {
            case 106:
                if (i2 == 0) {
                    this.aB.a("1556604017999292", getContext());
                    break;
                }
                break;
            case 501:
                this.f16637b.m18366a(i, i2, intent);
                return;
            case 1756:
                if (i2 != -1) {
                    return;
                }
                if (this.f16642g.f16570c == DashboardFilterType.BIRTHDAYS) {
                    EventsUpcomingBirthdaysListViewHelper eventsUpcomingBirthdaysListViewHelper = this.aA;
                    if (!(eventsUpcomingBirthdaysListViewHelper.f17017i == null || intent == null || i != 1756)) {
                        PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
                        if (publishPostParams != null) {
                            eventsUpcomingBirthdaysListViewHelper.f17017i.m17310a(String.valueOf(publishPostParams.targetId), publishPostParams.originalPostTime);
                        }
                    }
                    return;
                }
                this.av.b(((PublishPostParams) intent.getParcelableExtra("publishPostParams")).composerSessionId, this);
                return;
        }
        super.a(i, i2, intent);
    }

    public final String am_() {
        return "event_dashboard";
    }

    public final void m17049I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -286669990);
        EventsPager eventsPager = this.aD;
        EventsProvider.a(eventsPager.f16915b, eventsPager.f16916c, 48, eventsPager.f16919f);
        ((EventsSubscriptionsPager) this.at.get()).m17509a();
        ((EventsSuggestionsPager) this.au.get()).m17541a();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1874408055, a);
    }

    public static void aC(EventsDashboardFragment eventsDashboardFragment) {
        if (eventsDashboardFragment.aD()) {
            m17035a(eventsDashboardFragment, false);
        }
    }

    private boolean aD() {
        if (!at() || av() == DashboardFilterType.BIRTHDAYS) {
            return false;
        }
        int firstVisiblePosition = this.aE.getFirstVisiblePosition();
        int lastVisiblePosition = this.aE.getLastVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= this.aE.getCount() || lastVisiblePosition < 0 || lastVisiblePosition >= this.aE.getCount()) {
            return false;
        }
        if (this.an.m16923e(firstVisiblePosition, lastVisiblePosition)) {
            return true;
        }
        Event d = this.an.m16921d(firstVisiblePosition, lastVisiblePosition);
        if (d == null) {
            return false;
        }
        long K = d.K();
        if (av() == DashboardFilterType.PAST) {
            if (this.aR == null || this.aR.longValue() > K) {
                return true;
            }
            return false;
        } else if (this.aQ == null || this.aQ.longValue() < K) {
            return true;
        } else {
            return false;
        }
    }

    public static void m17035a(EventsDashboardFragment eventsDashboardFragment, boolean z) {
        if (z) {
            eventsDashboardFragment.aF.setRefreshing(true);
        }
        int dimensionPixelSize = eventsDashboardFragment.jW_().getDimensionPixelSize(2131431107);
        if (eventsDashboardFragment.av() == DashboardFilterType.PAST) {
            EventsPager eventsPager = eventsDashboardFragment.aD;
            EventsPagerCallback eventsPagerCallback = eventsDashboardFragment.bd;
            if (!eventsPager.f16921h.a(EventsDashboardPagerTaskType.FETCH_PAST_EVENTS)) {
                if (!eventsPager.f16927n) {
                    eventsPager.f16927n = true;
                    eventsPager.f16926m = null;
                    eventsPager.f16928o = true;
                } else if (!eventsPager.f16928o) {
                    if (eventsPagerCallback != null) {
                        eventsPagerCallback.mo787a(eventsPager.f16928o, 0, null);
                        return;
                    }
                    return;
                }
                eventsPager.f16921h.a(EventsDashboardPagerTaskType.FETCH_PAST_EVENTS, new C23715(eventsPager, dimensionPixelSize), new C23726(eventsPager, eventsPagerCallback));
                return;
            }
            return;
        }
        eventsDashboardFragment.aD.m17279b(dimensionPixelSize, eventsDashboardFragment.bc);
    }

    private void m17030a(@Nonnull DashboardFilterType dashboardFilterType, boolean z) {
        if (this.aN != dashboardFilterType && z) {
            this.aN = dashboardFilterType;
            if (aH() || D()) {
                this.ao.m18128a(dashboardFilterType.name(), this.aO, aE(), this.aG.b.f.getParamValue());
            }
            if (aH()) {
                this.ap.m17099c(av().name());
            }
        }
    }

    private void aF() {
        if (this.aT == null) {
            this.aT = new EventsSuggestionsCallback(this) {
                final /* synthetic */ EventsDashboardFragment f16611a;

                {
                    this.f16611a = r1;
                }

                public final void mo784a(@Nonnull SuggestedEventCutModel suggestedEventCutModel) {
                    EventsDashboardFragment.m17034a(this.f16611a, suggestedEventCutModel);
                }

                public final void mo783a() {
                    EventsDashboardFragment.m17034a(this.f16611a, null);
                }
            };
        }
        EventsSuggestionsPager eventsSuggestionsPager = (EventsSuggestionsPager) this.au.get();
        EventsSuggestionsCallback eventsSuggestionsCallback = this.aT;
        eventsSuggestionsPager.f17228b.a(EventsSuggestionsFetcherTask.FETCH_EVENTS_SUGGESTIONS_CUTS, new C24172(eventsSuggestionsPager, 5, 6), new C24183(eventsSuggestionsPager, eventsSuggestionsCallback));
    }

    public static void m17034a(EventsDashboardFragment eventsDashboardFragment, final SuggestedEventCutModel suggestedEventCutModel) {
        if (eventsDashboardFragment.aY == null) {
            eventsDashboardFragment.an.m16911a(suggestedEventCutModel);
            ((EventsSuggestionsPager) eventsDashboardFragment.au.get()).f17231e = eventsDashboardFragment.an.f16484p;
            return;
        }
        eventsDashboardFragment.aZ.put(PostInteractivityTask.ON_SUGGESTIONS, new Runnable(eventsDashboardFragment) {
            final /* synthetic */ EventsDashboardFragment f16613b;

            public void run() {
                this.f16613b.an.m16911a(suggestedEventCutModel);
                ((EventsSuggestionsPager) this.f16613b.au.get()).f17231e = this.f16613b.an.f16484p;
            }
        });
    }

    private void aG() {
        if (this.aS == null) {
            this.aS = new EventsSubscriptionsCallback(this) {
                final /* synthetic */ EventsDashboardFragment f16614a;

                {
                    this.f16614a = r1;
                }

                public final void mo785a(@Nonnull List<NodesModel> list, int i, String str, boolean z) {
                    EventsDashboardFragment eventsDashboardFragment = this.f16614a;
                    if (eventsDashboardFragment.aY == null) {
                        EventsDashboardFragment.m17044b(eventsDashboardFragment, (List) list, i);
                    } else {
                        eventsDashboardFragment.aZ.put(PostInteractivityTask.ON_SUBSCRIPTIONS, new AnonymousClass18(eventsDashboardFragment, list, i));
                    }
                }
            };
        }
        ((EventsSubscriptionsPager) this.at.get()).m17510a(0, 15, null, this.aS);
    }

    public static void m17044b(EventsDashboardFragment eventsDashboardFragment, List list, int i) {
        if (!list.isEmpty()) {
            EventsDashboardFragmentController eventsDashboardFragmentController = eventsDashboardFragment.aC;
            eventsDashboardFragmentController.f16663k.a(eventsDashboardFragmentController.f16656d);
            eventsDashboardFragmentController.f16663k.b = 1;
            if (eventsDashboardFragmentController.f16663k.c()) {
                View e = eventsDashboardFragmentController.f16658f.e(2131560258);
                if (e instanceof ViewStub) {
                    ViewStub viewStub = (ViewStub) e;
                    viewStub.setLayoutResource(2130904168);
                    Megaphone megaphone = (Megaphone) viewStub.inflate();
                    megaphone.setShowSecondaryButton(false);
                    megaphone.setVisibility(0);
                    megaphone.m = new C23241(eventsDashboardFragmentController, megaphone);
                    megaphone.setOnPrimaryButtonClickListener(new C23252(eventsDashboardFragmentController, megaphone));
                }
            }
        }
        if (i > 0 || !list.isEmpty()) {
            CaspianEventsDashboardBucketAdapter caspianEventsDashboardBucketAdapter = eventsDashboardFragment.an;
            caspianEventsDashboardBucketAdapter.f16488t = list;
            caspianEventsDashboardBucketAdapter.f16489u = i;
            caspianEventsDashboardBucketAdapter.f16485q = caspianEventsDashboardBucketAdapter.f16466I.m16435a(caspianEventsDashboardBucketAdapter.f16464G, caspianEventsDashboardBucketAdapter.f16463F, Lists.a(list, new C22987(caspianEventsDashboardBucketAdapter)), ActionSource.MOBILE_SUBSCRIPTIONS_DASHBOARD, ActionMechanism.DASHBOARD_SUBSCRIPTIONS_CARD, null);
            AdapterDetour.a(caspianEventsDashboardBucketAdapter, 1475749099);
            ((EventsSubscriptionsPager) eventsDashboardFragment.at.get()).f17188f = eventsDashboardFragment.an.f16485q;
        }
    }

    public final void ar() {
        if (at()) {
            this.aE.smoothScrollToPosition(this.an.m16922e());
        }
    }

    private boolean aH() {
        return this.aP == FragmentMode.STANDALONE;
    }
}
