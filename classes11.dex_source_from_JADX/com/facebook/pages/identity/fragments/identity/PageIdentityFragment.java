package com.facebook.pages.identity.fragments.identity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.ManualAnalyticsNavigationActivity;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.analytics.tagging.AnalyticsObjectProvider;
import com.facebook.analytics.tagging.AnalyticsObjectProvider.ObjectType;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fragmentfactory.FbChromeActivityFragmentFactory;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.device.yearclass.YearClass;
import com.facebook.feed.nux.FeedNuxBubbleManager;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.constants.PagesConstants.URL;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PagesInsightsContextItemClickEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PagesInsightsContextItemClickEventSubscriber;
import com.facebook.pages.common.sequencelogger.PageFirstStoriesSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PagesSequenceLoggerHelper;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageDataFetchType;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageHeaderDataListener;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQL.FetchSinglePageNotificationCountsQueryString;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLModels$PageNotificationCountsModel;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLModels$PageNotificationCountsModel.AdminInfoModel.ViewerModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment;
import com.facebook.pages.fb4a.admintabs.PageIdentityAdminTabsView;
import com.facebook.pages.fb4a.constants.PagesFb4aConstants.PagesFb4aTabs;
import com.facebook.pages.identity.fragments.about.PageAboutFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.GraphSearchQueryProvider;
import com.facebook.search.interfaces.GraphSearchTitleSupport;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.viewpager.ViewPagerWithCompositeOnPageChangeListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@GraphSearchTitleSupport
/* compiled from: pages_photos_tab */
public class PageIdentityFragment extends FbFragment implements ManualAnalyticsNavigationActivity, AnalyticsFragment, AnalyticsFragmentWithExtraData, AnalyticsObjectProvider, CanHandleBackPressed, PageHeaderDataListener, GraphSearchQueryProvider {
    public FbFragment f3949a;
    private Lazy<FbErrorReporter> aA;
    public AdminedPagesRamCache aB;
    private PageHeaderSequenceLoggerHelper aC;
    private DefaultAppChoreographer aD;
    public Context aE;
    private PageFirstStoriesSequenceLoggerHelper aF;
    private PagesSequenceLoggerHelper aG;
    private PageScopedEventBus aH;
    public PagesExperimentUtils aI;
    private Lazy<ClickableToastBuilder> aJ;
    private Lazy<FeedNuxBubbleManager> aK;
    public Lazy<GraphQLQueryExecutor> aL;
    public Lazy<Executor> aM;
    private Lazy<GatekeeperStore> aN;
    private Lazy<FbUriIntentHandler> aO;
    private PagesInsightsContextItemClickEventSubscriber aP;
    public FragmentManager aQ;
    public GraphQLEntityCardContextItemType aR;
    public long al;
    public String am;
    public String an;
    public ImmutableList<String> ao;
    public boolean ap;
    public boolean aq;
    public boolean ar;
    public int as;
    public boolean at;
    public Optional<SavedActivityResult> au = Absent.INSTANCE;
    public int av;
    private ViewGroup aw;
    private LayoutInflater ax;
    public FbChromeActivityFragmentFactory ay;
    public UriIntentMapper az;
    protected PageActivityFragment f3950b;
    public Fragment f3951c;
    public PageIdentityAdminTabsView f3952d;
    public ViewPagerWithCompositeOnPageChangeListener f3953e;
    public ViewGroup f3954f;
    public PageIdentityPagerAdapter f3955g;
    private ParcelUuid f3956h;
    public String f3957i;

    /* compiled from: pages_photos_tab */
    class C05402 implements Runnable {
        final /* synthetic */ PageIdentityFragment f3939a;

        C05402(PageIdentityFragment pageIdentityFragment) {
            this.f3939a = pageIdentityFragment;
        }

        public void run() {
            if (!this.f3939a.ar) {
                this.f3939a.f3953e.setOffscreenPageLimit(2);
            }
        }
    }

    /* compiled from: pages_photos_tab */
    public class C05413 implements FutureCallback<GraphQLResult<FetchNotificationCountsGraphQLModels$PageNotificationCountsModel>> {
        final /* synthetic */ PageIdentityFragment f3940a;

        public C05413(PageIdentityFragment pageIdentityFragment) {
            this.f3940a = pageIdentityFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((FetchNotificationCountsGraphQLModels$PageNotificationCountsModel) graphQLResult.e).m3721j() != null && ((FetchNotificationCountsGraphQLModels$PageNotificationCountsModel) graphQLResult.e).m3721j().m3705a() != null) {
                long a;
                ViewerModel a2 = ((FetchNotificationCountsGraphQLModels$PageNotificationCountsModel) graphQLResult.e).m3721j().m3705a();
                if (a2.m3701a() != null) {
                    a = ((long) a2.m3701a().m3688a()) + 0;
                } else {
                    a = 0;
                }
                if (a2.m3702j() != null) {
                    a += (long) a2.m3702j().m3694a();
                }
                if (this.f3940a.f3952d != null) {
                    this.f3940a.f3952d.setActivityBadgeCount(a);
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: pages_photos_tab */
    public /* synthetic */ class C05424 {
        public static final /* synthetic */ int[] f3941a = new int[GraphQLEntityCardContextItemType.values().length];

        static {
            try {
                f3941a[GraphQLEntityCardContextItemType.ADMIN_WEEKLY_NEW_LIKES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3941a[GraphQLEntityCardContextItemType.ADMIN_WEEKLY_POST_REACH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: pages_photos_tab */
    public class PageIdentityPagerAdapter extends FragmentPagerAdapter {
        public final /* synthetic */ PageIdentityFragment f3945a;

        /* compiled from: pages_photos_tab */
        public class C05431 {
            final /* synthetic */ PageIdentityPagerAdapter f3942a;

            C05431(PageIdentityPagerAdapter pageIdentityPagerAdapter) {
                this.f3942a = pageIdentityPagerAdapter;
            }

            public final void m4870a(@Nullable ImmutableList<String> immutableList, Optional<String> optional) {
                this.f3942a.f3945a.m4880a((ImmutableList) immutableList);
            }
        }

        /* compiled from: pages_photos_tab */
        public class C05442 {
            public final /* synthetic */ PageIdentityPagerAdapter f3943a;

            C05442(PageIdentityPagerAdapter pageIdentityPagerAdapter) {
                this.f3943a = pageIdentityPagerAdapter;
            }
        }

        /* compiled from: pages_photos_tab */
        class C05453 implements Runnable {
            final /* synthetic */ PageIdentityPagerAdapter f3944a;

            C05453(PageIdentityPagerAdapter pageIdentityPagerAdapter) {
                this.f3944a = pageIdentityPagerAdapter;
            }

            public void run() {
                if (this.f3944a.f3945a.mx_()) {
                    this.f3944a.f3945a.f3953e.setOffscreenPageLimit(2);
                }
            }
        }

        public PageIdentityPagerAdapter(PageIdentityFragment pageIdentityFragment, FragmentManager fragmentManager) {
            this.f3945a = pageIdentityFragment;
            super(fragmentManager);
        }

        public final void m4876b(ViewGroup viewGroup) {
            super.b(viewGroup);
            PageIdentityFragment pageIdentityFragment = this.f3945a;
            if (pageIdentityFragment.f3949a != null && pageIdentityFragment.au.isPresent()) {
                pageIdentityFragment.f3949a.a(((SavedActivityResult) pageIdentityFragment.au.get()).f3946a, ((SavedActivityResult) pageIdentityFragment.au.get()).f3947b, ((SavedActivityResult) pageIdentityFragment.au.get()).f3948c);
                pageIdentityFragment.au = Absent.INSTANCE;
            }
        }

        public final Object m4873a(ViewGroup viewGroup, int i) {
            Object a = super.a(viewGroup, i);
            if (i == 0) {
                this.f3945a.f3949a = (FbFragment) a;
                if (this.f3945a.f3949a instanceof PageAboutFragment) {
                    PageAboutFragment pageAboutFragment = (PageAboutFragment) this.f3945a.f3949a;
                    pageAboutFragment.bX = new C05431(this);
                    pageAboutFragment.m4850a(this.f3945a.f3954f);
                    pageAboutFragment.bY = new C05442(this);
                } else if (this.f3945a.f3949a instanceof PagesSurfaceFragment) {
                    this.f3945a.m4889a(this.f3945a.f3954f);
                    ((PagesSurfaceFragment) this.f3945a.f3949a).aX = this.f3945a.f3952d;
                }
            } else if (i == 1) {
                this.f3945a.f3950b = (PageActivityFragment) a;
                if (this.f3945a.ao != null) {
                    this.f3945a.f3950b.m3753a(this.f3945a.ao);
                }
            } else if (i == 2) {
                this.f3945a.ar = true;
                HandlerDetour.a(new Handler(Looper.getMainLooper()), new C05453(this), -509165523);
            }
            return a;
        }

        public final Fragment m4872a(int i) {
            Bundle bundle = this.f3945a.s;
            bundle.putBoolean("extra_in_admin_container_frag", true);
            switch (i) {
                case 0:
                    String name = PageAboutFragment.class.getName();
                    if (this.f3945a.ap) {
                        name = PagesSurfaceFragment.class.getName();
                    }
                    return Fragment.a(this.f3945a.getContext(), name, bundle);
                case 1:
                    return Fragment.a(this.f3945a.getContext(), PageActivityFragment.class.getName(), bundle);
                case 2:
                    Fragment fragment;
                    PageIdentityFragment pageIdentityFragment = this.f3945a;
                    if (pageIdentityFragment.f3951c != null) {
                        fragment = pageIdentityFragment.f3951c;
                    } else {
                        String a;
                        switch (C05424.f3941a[pageIdentityFragment.aR.ordinal()]) {
                            case 1:
                                a = StringFormatUtil.a(URL.w, new Object[]{Long.valueOf(pageIdentityFragment.al)});
                                pageIdentityFragment.aR = GraphQLEntityCardContextItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                                break;
                            case 2:
                                a = StringFormatUtil.a(URL.x, new Object[]{Long.valueOf(pageIdentityFragment.al)});
                                pageIdentityFragment.aR = GraphQLEntityCardContextItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                                break;
                            default:
                                a = StringFormatUtil.a(URL.a, new Object[]{Long.valueOf(pageIdentityFragment.al)});
                                break;
                        }
                        pageIdentityFragment.f3951c = pageIdentityFragment.ay.a(pageIdentityFragment.az.a(pageIdentityFragment.getContext(), a));
                        Bundle bundle2 = pageIdentityFragment.f3951c.s;
                        bundle2.putBoolean("parent_control_title_bar", true);
                        bundle2.putBoolean("no_title", true);
                        bundle2.putBoolean("hide_drop_shadow", true);
                        fragment = pageIdentityFragment.f3951c;
                    }
                    return fragment;
                default:
                    throw new UnsupportedOperationException("Fragment index out of bounds: " + i);
            }
        }

        public final int m4875b() {
            if (this.f3945a.at) {
                return 3;
            }
            return 1;
        }

        public final int m4871a(Object obj) {
            if (obj == this.f3945a.f3949a) {
                return -1;
            }
            if (this.f3945a.as > 0) {
                PageIdentityFragment pageIdentityFragment = this.f3945a;
                pageIdentityFragment.as--;
                return -2;
            } else if ((obj instanceof PageActivityFragment) || this.f3945a.aR == GraphQLEntityCardContextItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                return -1;
            } else {
                return -2;
            }
        }

        public final void m4874a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, i, obj);
            if (i == 2) {
                this.f3945a.ar = false;
            }
        }
    }

    /* compiled from: pages_photos_tab */
    public class SavedActivityResult {
        public final int f3946a;
        public final int f3947b;
        public final Intent f3948c;

        public SavedActivityResult(int i, int i2, Intent intent) {
            this.f3946a = i;
            this.f3947b = i2;
            this.f3948c = intent;
        }
    }

    public static void m4881a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityFragment) obj).m4877a(FbChromeActivityFragmentFactory.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), AdminedPagesRamCache.a(fbInjector), PageHeaderSequenceLoggerHelper.a(fbInjector), DefaultAppChoreographer.a(fbInjector), (Context) fbInjector.getInstance(Context.class), PageFirstStoriesSequenceLoggerHelper.a(fbInjector), PagesSequenceLoggerHelper.a(fbInjector), PageScopedEventBus.a(fbInjector), PagesExperimentUtils.a(fbInjector), IdBasedLazy.a(fbInjector, 3585), IdBasedLazy.a(fbInjector, 1448), IdBasedLazy.a(fbInjector, 2164), IdBasedSingletonScopeProvider.b(fbInjector, 2128), IdBasedSingletonScopeProvider.b(fbInjector, 616), IdBasedSingletonScopeProvider.b(fbInjector, 3863));
    }

    @Inject
    private void m4877a(FbChromeActivityFragmentFactory fbChromeActivityFragmentFactory, UriIntentMapper uriIntentMapper, Lazy<FbErrorReporter> lazy, AdminedPagesRamCache adminedPagesRamCache, PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper, AppChoreographer appChoreographer, Context context, PageFirstStoriesSequenceLoggerHelper pageFirstStoriesSequenceLoggerHelper, PagesSequenceLoggerHelper pagesSequenceLoggerHelper, PageScopedEventBus pageScopedEventBus, PagesExperimentUtils pagesExperimentUtils, Lazy<ClickableToastBuilder> lazy2, Lazy<FeedNuxBubbleManager> lazy3, Lazy<GraphQLQueryExecutor> lazy4, Lazy<GatekeeperStore> lazy5, Lazy<FbUriIntentHandler> lazy6, Lazy<Executor> lazy7) {
        this.ay = fbChromeActivityFragmentFactory;
        this.az = uriIntentMapper;
        this.aA = lazy;
        this.aB = adminedPagesRamCache;
        this.aC = pageHeaderSequenceLoggerHelper;
        this.aD = appChoreographer;
        this.aE = context;
        this.aF = pageFirstStoriesSequenceLoggerHelper;
        this.aG = pagesSequenceLoggerHelper;
        this.aH = pageScopedEventBus;
        this.aJ = lazy2;
        this.aK = lazy3;
        this.aL = lazy4;
        this.aM = lazy7;
        this.aI = pagesExperimentUtils;
        this.aO = lazy6;
        this.aN = lazy5;
    }

    public final void m4894c(@Nullable Bundle bundle) {
        super.c(bundle);
        Activity ao = ao();
        if (ao == null) {
            ((AbstractFbErrorReporter) this.aA.get()).b(getClass().getSimpleName(), "Hosting activity is null.");
            return;
        }
        ao.getTheme().applyStyle(2131625518, true);
        Class cls = PageIdentityFragment.class;
        m4881a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.f3956h = (ParcelUuid) bundle2.getParcelable("page_fragment_uuid");
        if (this.f3956h == null) {
            ((AbstractFbErrorReporter) this.aA.get()).b(getClass().getSimpleName(), "UUID is not passed in as args");
        } else {
            this.f3957i = this.f3956h.toString();
        }
        if (this.f3957i != null) {
            this.aC.a(this.f3957i).d(this.f3957i);
        }
        this.aF.a();
        this.aG.a.a(PageSequences.f);
        this.aG.a("PageCreateToFetchCards", PageSequences.f);
        this.aG.a("PageCreateToFirstCardLoad", PageSequences.f);
        this.al = bundle2.getLong("com.facebook.katana.profile.id", -1);
        this.am = String.valueOf(this.al);
        Preconditions.checkArgument(this.al > 0, "Invalid page id: " + this.al);
        this.aR = GraphQLEntityCardContextItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        if ("fbpage_new_message".equals(bundle2.getString("tracking_notification_type"))) {
            this.av = 1;
        }
        Preconditions.checkNotNull(Long.valueOf(this.al));
        AdminedPagesPrefetchNode b = this.aB.b(this.am);
        if (b != null) {
            this.an = b.a.d();
        }
        this.ap = this.aI.e();
        if (bundle != null) {
            if (bundle.containsKey("extra_viewer_profile_permissions")) {
                this.ao = ImmutableList.copyOf(bundle.getStringArrayList("extra_viewer_profile_permissions"));
                this.at = m4882a(this.ao, Permission.BASIC_ADMIN);
            }
            if (bundle.containsKey("extra_page_name")) {
                this.an = bundle.getString("extra_page_name");
            }
        }
        PagesFb4aTabs pagesFb4aTabs = (PagesFb4aTabs) bundle2.getSerializable("extra_page_tab");
        if (pagesFb4aTabs == PagesFb4aTabs.ACTIVITY) {
            this.av = 1;
        } else if (pagesFb4aTabs == PagesFb4aTabs.INSIGHTS) {
            this.av = 2;
        }
        this.aP = new PagesInsightsContextItemClickEventSubscriber(this, this.f3956h) {
            final /* synthetic */ PageIdentityFragment f3938b;

            public final void m4869b(FbEvent fbEvent) {
                PagesInsightsContextItemClickEvent pagesInsightsContextItemClickEvent = (PagesInsightsContextItemClickEvent) fbEvent;
                if (this.f3938b.f3955g != null && this.f3938b.f3953e != null) {
                    if (this.f3938b.f3951c != null) {
                        this.f3938b.aQ.a().a(this.f3938b.f3951c).b();
                        this.f3938b.f3951c = null;
                    }
                    this.f3938b.aR = pagesInsightsContextItemClickEvent.b;
                    this.f3938b.f3955g.kR_();
                    this.f3938b.f3953e.setCurrentItem(2);
                }
            }
        };
    }

    public final void mo53a(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult, PageDataFetchType pageDataFetchType) {
        FetchPageHeaderQueryModel fetchPageHeaderQueryModel = (FetchPageHeaderQueryModel) graphQLResult.e;
        ImmutableList af = fetchPageHeaderQueryModel.af();
        Optional.of(fetchPageHeaderQueryModel.N() != null ? fetchPageHeaderQueryModel.N().b() : null);
        m4880a(af);
        m4879a(this, fetchPageHeaderQueryModel.D());
        GraphQLRequest a = GraphQLRequest.a((FetchSinglePageNotificationCountsQueryString) new FetchSinglePageNotificationCountsQueryString().a("page_id", this.am)).a(RequestPriority.NON_INTERACTIVE).a(GraphQLCachePolicy.c);
        a.b = true;
        Futures.a(((GraphQLQueryExecutor) this.aL.get()).a(a), new C05413(this), (Executor) this.aM.get());
    }

    public final View m4886a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2042718725);
        this.ax = LayoutInflater.from(this.aE);
        this.f3954f = (ViewGroup) this.ax.inflate(2130904443, viewGroup, false);
        View view = this.f3954f;
        this.aq = false;
        this.ar = false;
        this.as = 0;
        this.aQ = s();
        this.f3955g = new PageIdentityPagerAdapter(this, this.aQ);
        this.f3953e = (ViewPagerWithCompositeOnPageChangeListener) FindViewUtil.b(view, 2131562209);
        this.f3953e.setAdapter(this.f3955g);
        if (this.ap) {
            this.f3953e.a = false;
        }
        this.f3952d = (PageIdentityAdminTabsView) FindViewUtil.b(view, 2131562208);
        this.f3952d.setViewPager(this.f3953e);
        this.f3952d.m3904a(this.al, this.f3957i);
        view = this.f3954f;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1739038705, a);
        return view;
    }

    public final String am_() {
        return "pages_public_view";
    }

    public final Map<String, Object> m4893c() {
        Map<String, Object> c = Maps.c();
        c.put("profile_id", Long.valueOf(this.al));
        return c;
    }

    public final ObjectType m4887a() {
        return ObjectType.PAGES;
    }

    public final String m4895d() {
        return this.am;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1971510786);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1285897411, a);
    }

    public final void m4884H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 466660913);
        super.H();
        this.aC.b(this.f3957i);
        this.aH.b(this.aP);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1848686443, a);
    }

    public final void m4896e(Bundle bundle) {
        super.e(bundle);
        if (this.ao != null) {
            bundle.putStringArrayList("extra_viewer_profile_permissions", Lists.a(this.ao));
        }
        if (!StringUtil.a(this.an)) {
            bundle.putString("extra_page_name", this.an);
        }
    }

    public final void m4883G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1886417974);
        super.G();
        this.aH.a(this.aP);
        ax();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 995259969, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -572618926);
        if (this.f3953e != null) {
            this.f3953e.setAdapter(null);
            this.f3953e = null;
        }
        this.f3955g = null;
        this.f3952d = null;
        if (!(this.aK == null || this.aw == null)) {
            ((FeedNuxBubbleManager) this.aK.get()).a(this.aw);
        }
        if (this.f3949a != null && (this.f3949a instanceof PageAboutFragment)) {
            ((PageAboutFragment) this.f3949a).bX = null;
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -40275615, a);
    }

    public final void m4885I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1274905620);
        super.I();
        this.aC.b(this.f3957i);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1115161989, a);
    }

    public final boolean O_() {
        if (this.f3949a instanceof CanHandleBackPressed) {
            return ((CanHandleBackPressed) this.f3949a).O_();
        }
        return false;
    }

    public final GraphSearchQuery m4898q() {
        if (((GatekeeperStoreImpl) this.aN.get()).a(SearchAbTestGatekeepers.q, false)) {
            return GraphSearchQuery.a(ScopedEntityType.PAGE, this.am, this.an, ScopedSearchStyle.TAB, true);
        }
        return GraphSearchQuery.a(ScopedEntityType.PAGE, this.am, this.an, null, true);
    }

    public final void m4889a(ViewGroup viewGroup) {
        this.aw = viewGroup;
        if (this.aK != null) {
            ((FeedNuxBubbleManager) this.aK.get()).a(this.aw, new InterstitialTrigger(Action.PAGE_STORY));
            ar();
        }
    }

    private void ar() {
        ((FeedNuxBubbleManager) this.aK.get()).b = 0;
        ((FeedNuxBubbleManager) this.aK.get()).a = jW_().getDimensionPixelSize(2131428115);
    }

    protected final <T> T m4892b(Class<? extends T> cls) {
        if (cls == null || !cls.isAssignableFrom(PageIdentityAdminTabsView.class)) {
            return super.b(cls);
        }
        return this.f3952d;
    }

    private static boolean m4882a(ImmutableList<String> immutableList, Permission permission) {
        if (immutableList != null) {
            return new ProfilePermissions(immutableList).a(permission);
        }
        return false;
    }

    public final void m4888a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            if (!(intent == null || !intent.hasExtra("show_snackbar_extra") || this.f3954f.getContext() == null)) {
                View view = this.f3954f;
                Object stringExtra = intent.getStringExtra("show_snackbar_extra");
                SpannableStringBuilder append = new SpannableStringBuilder().append(stringExtra);
                append.setSpan(new ForegroundColorSpan(-1), 0, stringExtra.length(), 33);
                Snackbar.a(view, append, 0).b();
            }
            if (this.f3949a != null) {
                this.f3949a.a(i, i2, intent);
            } else {
                this.au = Optional.of(new SavedActivityResult(i, i2, intent));
            }
        } else if (i2 == 0 && this.f3949a != null) {
            this.f3949a.a(i, i2, intent);
        }
    }

    public final void m4897g(boolean z) {
        super.g(z);
        if (!z) {
            Activity ao = ao();
            if (ao != null) {
                ao.closeContextMenu();
            }
        }
        if (z && this.aK != null) {
            ((FeedNuxBubbleManager) this.aK.get()).a(this.aw, new InterstitialTrigger(Action.PAGE_STORY));
            ar();
        }
    }

    public final void mo54a(Throwable th) {
    }

    private void m4880a(@Nullable ImmutableList<String> immutableList) {
        this.ao = immutableList != null ? ImmutableList.copyOf(immutableList) : null;
        this.at = m4882a(this.ao, Permission.BASIC_ADMIN);
        if (this.at) {
            Object obj;
            if (!this.aq) {
                this.f3952d.setVisibility(0);
                this.f3955g.kR_();
                this.aq = true;
            }
            if (this.av != 0) {
                this.f3953e.setCurrentItem(this.av);
                this.av = 0;
            }
            if (this.ar || !this.at || YearClass.a(this.aE) < 2012) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.aD.a("Preloading Page admin tabs", new C05402(this), Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
            }
        } else if (this.aq) {
            this.f3952d.setVisibility(8);
            this.as = 2;
            this.f3955g.kR_();
            this.aq = false;
        }
    }

    public static void m4879a(PageIdentityFragment pageIdentityFragment, String str) {
        if (!Strings.isNullOrEmpty(str)) {
            pageIdentityFragment.an = str;
            pageIdentityFragment.ax();
        }
    }

    private void ax() {
        if (!Strings.isNullOrEmpty(this.an)) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.setCustomTitle(null);
                hasTitleBar.kg_();
                hasTitleBar.a_(this.an);
            }
        }
    }
}
