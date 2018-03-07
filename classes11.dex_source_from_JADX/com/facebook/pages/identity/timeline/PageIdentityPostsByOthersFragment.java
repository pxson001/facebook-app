package com.facebook.pages.identity.timeline;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.pages.common.pageviewercontext.ViewerContextWaiter;
import com.facebook.pages.common.sequencelogger.PageFirstPostsByOthersStoriesSequenceLoggerHelper;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.pages.data.graphql.fragments.PostsByOthersFragmentGraphQL.PostsByOthersFragmentQueryString;
import com.facebook.pages.data.graphql.fragments.PostsByOthersFragmentGraphQLModels.PostsByOthersFragmentQueryModel;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.refreshableview.RefreshableListViewContainer;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_information */
public class PageIdentityPostsByOthersFragment extends PageIdentityTimelineFragment implements AnalyticsFragment {
    public MultiAdapterListAdapter aA;
    public PageIdentityPostsByOthersPublisherAdapter aB;
    private MultiRowAdapter aC;
    private RefreshableListViewContainer aD;
    public FbNetworkManager aE;
    private FeedNetworkConnectivityReceiver aF;
    public View aG;
    public GenericNotificationBanner aH;
    private AnalyticsTagger aI;
    private Lazy<FbErrorReporter> aJ;
    public ImmutableList<String> al;
    public String am;
    public String an;
    public boolean ao;
    public boolean ap;
    public boolean aq = true;
    public boolean ar = true;
    public GraphQLQueryExecutor as;
    private TasksManager<PagesAsyncTaskType> at;
    public ListenableFuture<GraphQLResult<PostsByOthersFragmentQueryModel>> au;
    private Lazy<ViewerContextManager> av;
    private Lazy<ViewerContextUtil> aw;
    private ExecutorService ax;
    private PageFirstPostsByOthersStoriesSequenceLoggerHelper ay;
    private ScrollingViewProxy az;
    private AdminedPagesRamCache f4194g;
    private Product f4195h;
    public long f4196i;

    /* compiled from: page_information */
    class C05741 implements OnClickListener {
        final /* synthetic */ PageIdentityPostsByOthersFragment f4187a;

        C05741(PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment) {
            this.f4187a = pageIdentityPostsByOthersFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2072145312);
            this.f4187a.aG.setVisibility(8);
            this.f4187a.m5180e();
            Logger.a(2, EntryType.UI_INPUT_END, 217259782, a);
        }
    }

    /* compiled from: page_information */
    class C05763 extends OnRefreshListener {
        final /* synthetic */ PageIdentityPostsByOthersFragment f4189a;

        C05763(PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment) {
            this.f4189a = pageIdentityPostsByOthersFragment;
        }

        public final void m5161b(boolean z) {
            if (z) {
                this.f4189a.m5180e();
            }
        }
    }

    /* compiled from: page_information */
    class C05774 implements Runnable {
        final /* synthetic */ PageIdentityPostsByOthersFragment f4190a;

        C05774(PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment) {
            this.f4190a = pageIdentityPostsByOthersFragment;
        }

        public void run() {
            AdapterDetour.a(this.f4190a.aA, -1914022278);
        }
    }

    /* compiled from: page_information */
    class C05785 implements Callable<ListenableFuture<GraphQLResult<PostsByOthersFragmentQueryModel>>> {
        final /* synthetic */ PageIdentityPostsByOthersFragment f4191a;

        C05785(PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment) {
            this.f4191a = pageIdentityPostsByOthersFragment;
        }

        public Object call() {
            PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment = this.f4191a;
            GraphQlQueryString postsByOthersFragmentQueryString = new PostsByOthersFragmentQueryString();
            postsByOthersFragmentQueryString.a("page_id", Long.valueOf(pageIdentityPostsByOthersFragment.f4196i));
            postsByOthersFragmentQueryString.a("need_profile_pic", Boolean.valueOf(pageIdentityPostsByOthersFragment.ar));
            postsByOthersFragmentQueryString.a("need_profile_permission", Boolean.valueOf(pageIdentityPostsByOthersFragment.aq));
            GraphQLRequest a = GraphQLRequest.a(postsByOthersFragmentQueryString);
            this.f4191a.au = this.f4191a.as.a(a);
            return this.f4191a.au;
        }
    }

    /* compiled from: page_information */
    class C05796 extends AbstractDisposableFutureCallback<GraphQLResult<PostsByOthersFragmentQueryModel>> {
        final /* synthetic */ PageIdentityPostsByOthersFragment f4192a;

        C05796(PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment) {
            this.f4192a = pageIdentityPostsByOthersFragment;
        }

        protected final void m5162a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                PostsByOthersFragmentQueryModel postsByOthersFragmentQueryModel = (PostsByOthersFragmentQueryModel) graphQLResult.e;
                this.f4192a.ao = postsByOthersFragmentQueryModel.m3675a();
                this.f4192a.ap = postsByOthersFragmentQueryModel.m3676j();
                if (this.f4192a.ar && postsByOthersFragmentQueryModel.m3677k() != null) {
                    this.f4192a.an = postsByOthersFragmentQueryModel.m3677k().m3668a();
                }
                if (this.f4192a.aq) {
                    this.f4192a.al = postsByOthersFragmentQueryModel.m3678l();
                    PageIdentityPostsByOthersFragment.aS(this.f4192a);
                }
                PageIdentityPostsByOthersPublisherAdapter pageIdentityPostsByOthersPublisherAdapter = this.f4192a.aB;
                String str = this.f4192a.an;
                boolean z = this.f4192a.ao;
                boolean z2 = this.f4192a.ap;
                boolean b = ProfilePermissions.b(this.f4192a.al);
                pageIdentityPostsByOthersPublisherAdapter.f4202f = str;
                pageIdentityPostsByOthersPublisherAdapter.f4203g = z;
                pageIdentityPostsByOthersPublisherAdapter.f4204h = z2;
                pageIdentityPostsByOthersPublisherAdapter.f4205i = b;
                AdapterDetour.a(this.f4192a.aB, -1879837964);
            }
        }

        protected final void m5163a(Throwable th) {
        }
    }

    /* compiled from: page_information */
    class C05807 implements ViewerContextWaiter {
        final /* synthetic */ PageIdentityPostsByOthersFragment f4193a;

        C05807(PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment) {
            this.f4193a = pageIdentityPostsByOthersFragment;
        }

        public final void m5165a(ViewerContext viewerContext) {
            PageIdentityPostsByOthersFragment.m5169a(this.f4193a, viewerContext);
        }

        public final void m5164a() {
        }

        public final void m5167b(ViewerContext viewerContext) {
            PageIdentityPostsByOthersFragment.m5169a(this.f4193a, viewerContext);
        }

        public final void m5166b() {
        }
    }

    public static void m5170a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityPostsByOthersFragment) obj).m5168a(AdminedPagesRamCache.a(fbInjector), FbNetworkManager.a(fbInjector), AnalyticsTagger.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), PageFirstPostsByOthersStoriesSequenceLoggerHelper.a(fbInjector), ProductMethodAutoProvider.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), TasksManager.b(fbInjector), IdBasedLazy.a(fbInjector, 375), IdBasedLazy.a(fbInjector, 9011), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    @Inject
    private void m5168a(AdminedPagesRamCache adminedPagesRamCache, FbNetworkManager fbNetworkManager, AnalyticsTagger analyticsTagger, GraphQLQueryExecutor graphQLQueryExecutor, PageFirstPostsByOthersStoriesSequenceLoggerHelper pageFirstPostsByOthersStoriesSequenceLoggerHelper, Product product, Lazy<FbErrorReporter> lazy, TasksManager tasksManager, Lazy<ViewerContextManager> lazy2, Lazy<ViewerContextUtil> lazy3, ExecutorService executorService) {
        this.f4194g = adminedPagesRamCache;
        this.aE = fbNetworkManager;
        this.aI = analyticsTagger;
        this.as = graphQLQueryExecutor;
        this.ay = pageFirstPostsByOthersStoriesSequenceLoggerHelper;
        this.f4195h = product;
        this.aJ = lazy;
        this.at = tasksManager;
        this.av = lazy2;
        this.aw = lazy3;
        this.ax = executorService;
    }

    public final void mo111c(Bundle bundle) {
        ParcelUuid parcelUuid;
        super.mo111c(bundle);
        Class cls = PageIdentityPostsByOthersFragment.class;
        m5170a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.f4196i = bundle2.getLong("com.facebook.katana.profile.id", -1);
        this.am = bundle2.getString("extra_page_name");
        this.al = RegularImmutableList.a;
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) this.f4194g.b(String.valueOf(this.f4196i));
        if (adminedPagesPrefetchNode != null) {
            NodesModel nodesModel = adminedPagesPrefetchNode.a;
            if (nodesModel.g() != null) {
                this.al = nodesModel.g();
                this.aq = false;
                aS(this);
            }
            if (!(nodesModel.km_() == null || nodesModel.km_().a() == null)) {
                this.an = nodesModel.km_().a();
                this.ar = false;
            }
        }
        Preconditions.checkArgument(this.f4196i > 0, "Invalid page id: " + this.f4196i);
        if (bundle != null) {
            parcelUuid = (ParcelUuid) bundle.getParcelable("fragment_uuid");
        } else {
            parcelUuid = new ParcelUuid(SafeUUIDGenerator.a());
        }
        m5118a(this.f4196i, parcelUuid, "others", new PageProfilePermissionsProviderImpl(new ProfilePermissions(this.al), this.aJ));
    }

    public final View m5174a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1150854112);
        View inflate = layoutInflater.inflate(2130904444, viewGroup, false);
        this.aI.a(inflate, "page_timeline", this);
        this.az = new ListViewProxy((BetterListView) inflate.findViewById(2131562211));
        this.aG = inflate.findViewById(2131560227);
        this.aH = (GenericNotificationBanner) inflate.findViewById(2131560231);
        this.aD = (RefreshableListViewContainer) inflate.findViewById(2131562210);
        this.aB = new PageIdentityPostsByOthersPublisherAdapter(layoutInflater, "pages_posts_by_others_module_name", this.f4196i, this.am, this.f4195h, this.an, this.ao, this.ap, ProfilePermissions.b(this.al));
        this.aC = aL();
        this.aA = MultiAdapterListAdapter.a(new FbListAdapter[]{this.aB, this.aC});
        aR();
        this.aG.findViewById(2131561897).setOnClickListener(new C05741(this));
        this.aF = new FeedNetworkConnectivityReceiver(this, o()) {
            final /* synthetic */ PageIdentityPostsByOthersFragment f4188a;

            public final void m5160a(Context context, Intent intent) {
                boolean d = this.f4188a.aE.d();
                if (this.f4188a.aG != null && this.f4188a.aG.getVisibility() != 0) {
                    if (d) {
                        this.f4188a.aH.a();
                    } else {
                        this.f4188a.aH.a(NotificationBannerType.NO_CONNECTION);
                    }
                }
            }
        };
        this.aD.setOnRefreshListener(new C05763(this));
        aN();
        aO();
        aD();
        aE();
        m5180e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -633240493, a);
        return inflate;
    }

    public final ScrollingViewProxy m5186n() {
        return this.az;
    }

    protected final BasicAdapter ax() {
        return this.aA;
    }

    protected final String aB() {
        return "pages_identity_ufi";
    }

    protected final int m5182g(int i) {
        return this.aC.s_(i);
    }

    public final void mo101G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1800896794);
        super.mo101G();
        if (this.aF != null) {
            this.aF.a();
        }
        if (this.au != null && this.au.isCancelled()) {
            aR();
        }
        if (!Strings.isNullOrEmpty(this.am)) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.setCustomTitle(null);
                hasTitleBar.kg_();
                hasTitleBar.a_(this.am);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 202128538, a);
    }

    public final void m5181e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("fragment_uuid", aA().d);
    }

    public final void mo102H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 944925548);
        super.mo102H();
        if (this.at != null) {
            this.at.c();
        }
        this.ay.b();
        if (this.aF != null) {
            this.aF.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1138133339, a);
    }

    public final void m5180e() {
        TimelineStoriesDataFetcher av = av();
        if (av != null) {
            av.b();
            av.a(false);
        }
    }

    public final void mo103I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1404182208);
        super.mo103I();
        if (this.aC != null) {
            this.aC.jc_();
        }
        if (this.aD != null) {
            this.aD.destroyDrawingCache();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 66843404, a);
    }

    public final void m5183g() {
        if (this.aH != null) {
            if (this.aE.d()) {
                this.aH.a();
            } else {
                this.aH.a(NotificationBannerType.NO_CONNECTION);
            }
        }
        aC();
        if (this.aD != null) {
            this.aD.f();
        }
    }

    public final void aJ() {
        if (this.aG != null) {
            if (this.aA.getCount() == 0) {
                this.aG.setVisibility(0);
            } else {
                this.aG.setVisibility(8);
            }
        }
        if (!(this.aG == null || this.aG.getVisibility() == 0)) {
            this.aH.a(this.aE.d() ? NotificationBannerType.FETCH_PAGE_FAILED : NotificationBannerType.NO_CONNECTION);
        }
        if (this.aD != null) {
            this.aD.f();
        }
    }

    public final String am_() {
        return "pages_posts_by_others_module_name";
    }

    public final void m5184i() {
    }

    public final void m5185j() {
    }

    public final void mX_() {
    }

    public final void mo104a(TimelineSectionFetchParams timelineSectionFetchParams) {
        if (timelineSectionFetchParams.g) {
            PageFirstPostsByOthersStoriesSequenceLoggerHelper pageFirstPostsByOthersStoriesSequenceLoggerHelper = this.ay;
            int size = pageFirstPostsByOthersStoriesSequenceLoggerHelper.c.size();
            for (int i = 0; i < size; i++) {
                pageFirstPostsByOthersStoriesSequenceLoggerHelper.a.a((AbstractSequenceDefinition) pageFirstPostsByOthersStoriesSequenceLoggerHelper.c.get(i), null);
            }
        }
    }

    public final void m5175a(DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
    }

    public final void mo105a(TimelineSectionFetchParams timelineSectionFetchParams, DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
        m5183g();
        if (timelineSectionFetchParams.h) {
            Map c = Maps.c();
            c.put("data_freshness", dataFreshnessResult.toString());
            PageFirstPostsByOthersStoriesSequenceLoggerHelper pageFirstPostsByOthersStoriesSequenceLoggerHelper = this.ay;
            boolean a = ProfilePermissions.a(this.al);
            ImmutableMap copyOf = ImmutableMap.copyOf(c);
            if (pageFirstPostsByOthersStoriesSequenceLoggerHelper.b != Product.PAA) {
                if (a) {
                    if (pageFirstPostsByOthersStoriesSequenceLoggerHelper.a.e(PageSequences.m) != null) {
                        pageFirstPostsByOthersStoriesSequenceLoggerHelper.a.d(PageSequences.m);
                    }
                } else if (pageFirstPostsByOthersStoriesSequenceLoggerHelper.a.e(PageSequences.n) != null) {
                    pageFirstPostsByOthersStoriesSequenceLoggerHelper.a.d(PageSequences.n);
                }
            }
            int size = pageFirstPostsByOthersStoriesSequenceLoggerHelper.c.size();
            for (int i = 0; i < size; i++) {
                AbstractSequenceDefinition abstractSequenceDefinition = (AbstractSequenceDefinition) pageFirstPostsByOthersStoriesSequenceLoggerHelper.c.get(i);
                if (pageFirstPostsByOthersStoriesSequenceLoggerHelper.a.e(abstractSequenceDefinition) != null) {
                    pageFirstPostsByOthersStoriesSequenceLoggerHelper.a.b(abstractSequenceDefinition, copyOf);
                }
            }
        }
    }

    public final void mo110b(TimelineSectionFetchParams timelineSectionFetchParams) {
        if (timelineSectionFetchParams.g) {
            this.ay.b();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aC.notifyDataSetChanged();
    }

    protected final Runnable aK() {
        return new C05774(this);
    }

    private void aR() {
        this.at.a(PagesAsyncTaskType.FETCH_PAGE_POSTS_BY_OTHERS_FRAGMENT_DATA, new C05785(this), new C05796(this));
    }

    public static void aS(PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment) {
        if (pageIdentityPostsByOthersFragment.al != null && ProfilePermissions.b(pageIdentityPostsByOthersFragment.al)) {
            ((ViewerContextUtil) pageIdentityPostsByOthersFragment.aw.get()).a(String.valueOf(pageIdentityPostsByOthersFragment.f4196i), new C05807(pageIdentityPostsByOthersFragment), pageIdentityPostsByOthersFragment.ax);
        }
    }

    public static void m5169a(@Nullable PageIdentityPostsByOthersFragment pageIdentityPostsByOthersFragment, ViewerContext viewerContext) {
        if (pageIdentityPostsByOthersFragment.av == null) {
            return;
        }
        if (viewerContext == null || viewerContext.mIsPageContext) {
            ((ViewerContextManager) pageIdentityPostsByOthersFragment.av.get()).a(viewerContext);
        } else {
            ((AbstractFbErrorReporter) pageIdentityPostsByOthersFragment.aJ.get()).b("PageViewerContext", "ViewerContextUtil fetched non-page ViewerContext");
        }
    }
}
