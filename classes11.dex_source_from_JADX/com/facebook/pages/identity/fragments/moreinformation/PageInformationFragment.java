package com.facebook.pages.identity.fragments.moreinformation;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.broadcast.SafeLocalBroadcastReceiver;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLAttributionEntry;
import com.facebook.graphql.model.GraphQLAttributionEntry.Builder;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.pages.fb4a.vertex_attribution.PagesVertexAttributionView;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQL.FetchPageInformationDataQueryString;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageAttributionModel;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel.PageFeaturedAdminInfoModel.EdgesModel;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel.PageInfoSectionsModel;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.ScrollingAwareScrollView;
import com.facebook.widget.ScrollingAwareScrollView.OnScrollListener;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pages_browser_fetch_initial_recommended_pages */
public class PageInformationFragment extends FbFragment implements AnalyticsFragment, PagesSurfaceTabFragment {
    public static final int[] aQ = new int[2];
    @Inject
    GraphQLQueryExecutor f4010a;
    private View aA;
    private LinearLayout aB;
    private long aC = 0;
    public long aD;
    public PageInformationDataModel aE;
    public SafeLocalBroadcastReceiver aF;
    public PageLoadingState aG;
    public LayoutInflater aH;
    public ReactionHeaderTouchDelegateView aI;
    private ReactionHeaderViewWithTouchDelegate aJ;
    public View aK;
    public PagesSurfaceFragment aL;
    public boolean aM = false;
    public int aN;
    private int aO;
    private int aP = -1;
    public boolean aR = false;
    public boolean aS = true;
    public ListenableFuture<GraphQLResult<PageInformationDataModel>> aT;
    @Inject
    Lazy<Toaster> al;
    @Inject
    GraphQLImageHelper am;
    @Inject
    QeAccessor an;
    private View ao;
    private PageInformationActionSheet ap;
    private PageInformationHoursCardView aq;
    private PageInformationBusinessInfoView ar;
    private PageInformationSuggestEditCard as;
    private PageInformationReportProblemCard at;
    private PagesVertexAttributionView au;
    public LinearLayout av;
    public ScrollingAwareScrollView aw;
    private LinearLayout ax;
    private ProgressBar ay;
    private View az;
    @Inject
    InteractionLogger f4011b;
    @Inject
    MonotonicClock f4012c;
    @Inject
    TasksManager f4013d;
    @Inject
    public FbTitleBarSupplier f4014e;
    @Inject
    FbNetworkManager f4015f;
    @Inject
    ScreenUtil f4016g;
    @Inject
    Lazy<FbErrorReporter> f4017h;
    @Inject
    Lazy<PagesAnalytics> f4018i;

    /* compiled from: pages_browser_fetch_initial_recommended_pages */
    class C05491 implements OnScrollListener {
        final /* synthetic */ PageInformationFragment f4004a;

        C05491(PageInformationFragment pageInformationFragment) {
            this.f4004a = pageInformationFragment;
        }

        public final void m4926a(int i, int i2) {
            if (this.f4004a.aI != null && (!this.f4004a.aR || this.f4004a.aS)) {
                Pair a = PagesScrollUtils.a(this.f4004a.aK, this.f4004a.aw, i < this.f4004a.aI.getMeasuredHeight() ? 0 : 1, PageInformationFragment.aQ, this.f4004a.f4016g.d());
                this.f4004a.aR = ((Boolean) a.a).booleanValue();
                if (this.f4004a.aR) {
                    this.f4004a.E_(((Integer) a.b).intValue());
                    this.f4004a.aS = false;
                }
            }
            if (this.f4004a.aN != i && this.f4004a.aL != null && this.f4004a.aI != null && this.f4004a.D()) {
                if (i < this.f4004a.aI.getMeasuredHeight()) {
                    this.f4004a.aL.m5039a(this.f4004a.aw, 0);
                } else {
                    this.f4004a.aL.m5039a(this.f4004a.aw, 1);
                }
                this.f4004a.aN = i;
            }
        }
    }

    /* compiled from: pages_browser_fetch_initial_recommended_pages */
    class C05513 implements Function<PageAttributionModel, GraphQLAttributionEntry> {
        final /* synthetic */ PageInformationFragment f4006a;

        C05513(PageInformationFragment pageInformationFragment) {
            this.f4006a = pageInformationFragment;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLAttributionEntry graphQLAttributionEntry;
            PageAttributionModel pageAttributionModel = (PageAttributionModel) obj;
            if (pageAttributionModel == null) {
                graphQLAttributionEntry = null;
            } else {
                GraphQLTextWithEntities graphQLTextWithEntities;
                Builder builder = new Builder();
                DefaultTextWithEntitiesLongFields a = pageAttributionModel.a();
                if (a == null) {
                    graphQLTextWithEntities = null;
                } else {
                    GraphQLTextWithEntities.Builder builder2 = new GraphQLTextWithEntities.Builder();
                    if (a.b() != null) {
                        ImmutableList.Builder builder3 = ImmutableList.builder();
                        for (int i = 0; i < a.b().size(); i++) {
                            GraphQLEntityAtRange graphQLEntityAtRange;
                            Ranges ranges = (Ranges) a.b().get(i);
                            if (ranges == null) {
                                graphQLEntityAtRange = null;
                            } else {
                                GraphQLEntity graphQLEntity;
                                GraphQLEntityAtRange.Builder builder4 = new GraphQLEntityAtRange.Builder();
                                DefaultTextWithEntitiesEntityFields a2 = ranges.a();
                                if (a2 == null) {
                                    graphQLEntity = null;
                                } else {
                                    GraphQLEntity.Builder builder5 = new GraphQLEntity.Builder();
                                    builder5.S = a2.b();
                                    builder5.d = a2.c();
                                    builder5.m = a2.d();
                                    builder5.u = a2.C_();
                                    builder5.O = a2.g();
                                    builder5.P = a2.D_();
                                    graphQLEntity = builder5.a();
                                }
                                builder4.d = graphQLEntity;
                                builder4.e = ranges.b();
                                builder4.f = ranges.c();
                                graphQLEntityAtRange = builder4.a();
                            }
                            builder3.c(graphQLEntityAtRange);
                        }
                        builder2.h = builder3.b();
                    }
                    builder2.i = a.a();
                    graphQLTextWithEntities = builder2.a();
                }
                builder.d = graphQLTextWithEntities;
                builder.f = pageAttributionModel.b();
                builder.g = pageAttributionModel.c();
                graphQLAttributionEntry = builder.a();
            }
            return graphQLAttributionEntry;
        }
    }

    /* compiled from: pages_browser_fetch_initial_recommended_pages */
    class C05524 implements Callable<ListenableFuture<GraphQLResult<PageInformationDataModel>>> {
        final /* synthetic */ PageInformationFragment f4007a;

        C05524(PageInformationFragment pageInformationFragment) {
            this.f4007a = pageInformationFragment;
        }

        public Object call() {
            GraphQLImageHelper graphQLImageHelper = this.f4007a.am;
            GraphQLRequest a = GraphQLRequest.a((FetchPageInformationDataQueryString) new FetchPageInformationDataQueryString().a("page_id", String.valueOf(this.f4007a.aD)).a("num_of_featured_admins", "20").a("featured_admin_profile_image_size", String.valueOf(GraphQLImageHelper.a(this.f4007a.jW_().getDimensionPixelSize(2131427440)).intValue())));
            this.f4007a.aT = this.f4007a.f4010a.a(a);
            return this.f4007a.aT;
        }
    }

    /* compiled from: pages_browser_fetch_initial_recommended_pages */
    class FetchPageInformationFutureCallback extends AbstractDisposableFutureCallback<GraphQLResult<PageInformationDataModel>> {
        final /* synthetic */ PageInformationFragment f4009a;

        public FetchPageInformationFutureCallback(PageInformationFragment pageInformationFragment) {
            this.f4009a = pageInformationFragment;
        }

        protected final void m4928a(Object obj) {
            PageInformationDataModel pageInformationDataModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            PageInformationFragment.m4932a(this.f4009a, PageLoadingState.LOADED);
            ((PagesAnalytics) this.f4009a.f4018i.get()).a(NetworkSuccessEvent.EVENT_PAGE_INFO_LOADED, this.f4009a.aD);
            PageInformationFragment pageInformationFragment = this.f4009a;
            if (graphQLResult == null) {
                pageInformationDataModel = null;
            } else {
                pageInformationDataModel = (PageInformationDataModel) graphQLResult.e;
            }
            pageInformationFragment.aE = pageInformationDataModel;
            this.f4009a.m4945e();
            this.f4009a.aS = true;
        }

        protected final void m4929a(Throwable th) {
            PageInformationFragment.m4932a(this.f4009a, PageLoadingState.ERROR);
            ((PagesAnalytics) this.f4009a.f4018i.get()).a(NetworkFailureEvent.EVENT_PAGE_INFO_LOAD_ERROR, this.f4009a.aD);
            ((AbstractFbErrorReporter) this.f4009a.f4017h.get()).a("page_information_data_fetch_fail", th);
        }
    }

    /* compiled from: pages_browser_fetch_initial_recommended_pages */
    enum PageLoadingState {
        LOADING,
        LOADED,
        ERROR
    }

    public static void m4933a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageInformationFragment) obj).m4931a(GraphQLQueryExecutor.a(fbInjector), InteractionLogger.a(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), TasksManager.b(fbInjector), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), FbNetworkManager.a(fbInjector), ScreenUtil.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedSingletonScopeProvider.b(fbInjector, 8930), IdBasedLazy.a(fbInjector, 3588), GraphQLImageHelper.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m4931a(GraphQLQueryExecutor graphQLQueryExecutor, InteractionLogger interactionLogger, MonotonicClock monotonicClock, TasksManager tasksManager, FbTitleBarSupplier fbTitleBarSupplier, FbNetworkManager fbNetworkManager, ScreenUtil screenUtil, Lazy<FbErrorReporter> lazy, Lazy<PagesAnalytics> lazy2, Lazy<Toaster> lazy3, GraphQLImageHelper graphQLImageHelper, QeAccessor qeAccessor) {
        this.f4010a = graphQLQueryExecutor;
        this.f4011b = interactionLogger;
        this.f4012c = monotonicClock;
        this.f4013d = tasksManager;
        this.f4014e = fbTitleBarSupplier;
        this.f4015f = fbNetworkManager;
        this.f4016g = screenUtil;
        this.f4017h = lazy;
        this.f4018i = lazy2;
        this.al = lazy3;
        this.am = graphQLImageHelper;
        this.an = qeAccessor;
    }

    public static PageInformationFragment m4930a(long j, boolean z) {
        PageInformationFragment pageInformationFragment = new PageInformationFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", j);
        bundle.putBoolean("extra_is_inside_page_surface_tab", z);
        pageInformationFragment.g(bundle);
        return pageInformationFragment;
    }

    public final void m4944c(Bundle bundle) {
        Class cls = PageInformationFragment.class;
        m4933a((Object) this, getContext());
        super.c(bundle);
        if (bundle == null || !bundle.containsKey("com.facebook.katana.profile.id")) {
            m4934n(this.s);
        } else {
            m4934n(bundle);
        }
    }

    public final void m4946e(Bundle bundle) {
        super.e(bundle);
        if (this.aE != null) {
            bundle.putLong("com.facebook.katana.profile.id", this.aD);
            FlatBufferModelHelper.a(bundle, "extra_page_data", this.aE);
        }
        bundle.putBoolean("extra_is_inside_page_surface_tab", this.aM);
    }

    public final View m4937a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 291365983);
        this.aH = layoutInflater;
        this.ao = layoutInflater.inflate(2130903093, viewGroup, false);
        this.ap = (PageInformationActionSheet) FindViewUtil.b(this.ao, 2131559231);
        this.aq = (PageInformationHoursCardView) FindViewUtil.b(this.ao, 2131559229);
        this.ar = (PageInformationBusinessInfoView) FindViewUtil.b(this.ao, 2131559230);
        this.as = (PageInformationSuggestEditCard) FindViewUtil.b(this.ao, 2131559236);
        this.at = (PageInformationReportProblemCard) FindViewUtil.b(this.ao, 2131559238);
        this.aw = (ScrollingAwareScrollView) FindViewUtil.b(this.ao, 2131559227);
        this.ax = (LinearLayout) FindViewUtil.b(this.ao, 2131559228);
        this.av = (LinearLayout) FindViewUtil.b(this.ao, 2131559232);
        this.ay = (ProgressBar) FindViewUtil.b(this.ao, 2131559239);
        this.az = FindViewUtil.b(this.ao, 2131559240);
        this.aA = FindViewUtil.b(this.ao, 2131559241);
        this.au = (PagesVertexAttributionView) FindViewUtil.b(this.ao, 2131559237);
        this.aK = FindViewUtil.b(this.ao, 2131559242);
        this.aB = (LinearLayout) FindViewUtil.b(this.ao, 2131559233);
        E_(this.aP);
        if (this.aE == null || this.aT == null || this.aT.isCancelled()) {
            au(this);
        } else if (this.aT == null || this.aT.isDone()) {
            m4945e();
        }
        View view = this.ao;
        LogUtils.f(1258706776, a);
        return view;
    }

    public final void m4939a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.aw.a(new C05491(this));
        if (this.aM) {
            this.aw.setVerticalScrollBarEnabled(false);
            this.ax.setPadding(0, 0, 0, 0);
        }
        at();
        D_(this.aO);
    }

    private void m4934n(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        this.aD = bundle.getLong("com.facebook.katana.profile.id", -1);
        Preconditions.checkArgument(this.aD > 0, "Invalid page id: " + this.aD);
        this.aE = (PageInformationDataModel) FlatBufferModelHelper.a(bundle, "extra_page_data");
        this.aM = bundle.getBoolean("extra_is_inside_page_surface_tab", false);
        this.aF = new SafeLocalBroadcastReceiver(this, getContext(), new IntentFilter("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED")) {
            final /* synthetic */ PageInformationFragment f4005a;

            public final void m4927a(Context context, Intent intent) {
                if (this.f4005a.f4015f.d() && this.f4005a.aG.equals(PageLoadingState.ERROR)) {
                    PageInformationFragment.au(this.f4005a);
                }
            }
        };
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2138415973);
        super.mY_();
        this.aF = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -586664438, a);
    }

    public final void m4941a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aL = pagesSurfaceFragment;
    }

    public final void m4947j() {
        if (this.aT != null) {
            this.aT.cancel(true);
        }
        au(this);
    }

    public final void m4942a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.aJ = reactionHeaderViewWithTouchDelegate;
        at();
    }

    public final void D_(int i) {
        this.aO = i;
        PagesScrollUtils.a(this.aw, this.aO);
    }

    public final void E_(int i) {
        if (this.aP < 0 || i <= this.aP) {
            this.aP = i;
            if (this.aK != null) {
                this.aK.setLayoutParams(new LayoutParams(-1, this.aP));
            }
        }
    }

    public final void m4940a(C05581 c05581) {
    }

    public final String am_() {
        return "page_information";
    }

    public final void m4935G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -492438392);
        super.G();
        if (this.aF != null) {
            this.aF.a();
        }
        if (this.aT != null && this.aT.isCancelled()) {
            au(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1443726500, a);
    }

    public final void m4936H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 304571928);
        super.H();
        if (this.f4013d != null) {
            this.f4013d.c();
        }
        if (this.aF != null) {
            this.aF.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1162432286, a);
    }

    public final void m4945e() {
        if (this.aE != null) {
            int i;
            if (!StringUtil.a(this.aE.r())) {
                String r = this.aE.r();
                if (!this.aM) {
                    HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
                    FbTitleBar fbTitleBar = (FbTitleBar) this.f4014e.get();
                    if (hasTitleBar != null) {
                        hasTitleBar.a_(r);
                    } else if (fbTitleBar != null) {
                        fbTitleBar.setTitle(r);
                    }
                }
            }
            if ((this.aE.l() == null || this.aE.l().isEmpty()) && (this.aE.y() == null || this.aE.y().isEmpty())) {
                this.ap.setVisibility(8);
            } else {
                this.ap.setVisibility(0);
                this.ap.setPageData(this.aE);
            }
            List n = this.aE.n();
            if (!GraphQLPermanentlyClosedStatus.NOT_PERMANENTLY_CLOSED.equals(this.aE.v()) || n == null || n.isEmpty()) {
                this.aq.setVisibility(8);
            } else {
                this.aq.setVisibility(0);
                this.aq.m4960a(n, this.aE.q());
            }
            ImmutableList k = this.aE.k();
            if (k == null || k.isEmpty()) {
                this.ar.setVisibility(8);
            } else {
                this.ar.setVisibility(0);
                this.ar.setData(this.aE);
            }
            GraphQLPlaceType w = this.aE.w();
            boolean z;
            if (this.aE.x().isEmpty()) {
                z = false;
            } else {
                z = new ProfilePermissions(this.aE.x()).a(Permission.BASIC_ADMIN);
            }
            if (!this.aE.m() || w == GraphQLPlaceType.RESIDENCE || r0) {
                this.as.setVisibility(8);
            } else {
                this.as.setVisibility(0);
                this.as.m4968a(this.aE.o(), this.aE.r());
            }
            this.at.setupOnClickReportBug(this.aD);
            this.av.removeAllViews();
            ImmutableList t = this.aE.t();
            int size = t.size();
            for (i = 0; i < size; i++) {
                PageInformationGenericAboutCardView pageInformationGenericAboutCardView = (PageInformationGenericAboutCardView) this.aH.inflate(2130906049, null);
                pageInformationGenericAboutCardView.setSectionData((PageInfoSectionsModel) t.get(i));
                this.av.addView(pageInformationGenericAboutCardView);
            }
            if (!(this.aE.p() || this.aE.j() == null || this.aE.j().isEmpty())) {
                this.au.setVisibility(0);
                this.au.setAttribtutions(ImmutableList.copyOf(Lists.a(this.aE.j(), new C05513(this))));
            }
            if (!(this.aE.s() == null || this.aE.s().a() == null || this.aE.s().a().isEmpty() || !this.an.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.m, false))) {
                for (i = 0; i < this.aE.s().a().size(); i++) {
                    PageInformationFeaturedAdminView pageInformationFeaturedAdminView = new PageInformationFeaturedAdminView(getContext());
                    pageInformationFeaturedAdminView.m4925a(((EdgesModel) this.aE.s().a().get(i)).a());
                    this.aB.addView(pageInformationFeaturedAdminView);
                }
                this.aB.setVisibility(0);
            }
            m4932a(this, PageLoadingState.LOADED);
            this.ao.requestLayout();
        }
    }

    public final void m4938a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 10102:
                    ((Toaster) this.al.get()).b(new ToastBuilder(b(2131235448)));
                    ((PagesAnalytics) this.f4018i.get()).a(NetworkSuccessEvent.EVENT_SUGGEST_EDIT_SUCCESS, Long.parseLong(this.aE.o()));
                    return;
                default:
                    return;
            }
        }
    }

    public final void m4943c(int i) {
        this.aw.scrollBy(0, i);
    }

    private void at() {
        if (this.aJ != null && this.ax != null) {
            if (this.aI != null) {
                this.ax.removeView(this.aI);
            }
            this.aI = new ReactionHeaderTouchDelegateView(this.aJ);
            this.aI.c = true;
            this.ax.addView(this.aI, 0);
            this.aJ.a(this.aI);
            this.aw.setBackgroundResource(0);
            this.ax.setBackgroundResource(0);
        }
    }

    public static void au(PageInformationFragment pageInformationFragment) {
        m4932a(pageInformationFragment, PageLoadingState.LOADING);
        pageInformationFragment.f4013d.a(PagesAsyncTaskType.FETCH_PAGE_INFORMATION_DATA, new C05524(pageInformationFragment), new FetchPageInformationFutureCallback(pageInformationFragment));
    }

    public static void m4932a(PageInformationFragment pageInformationFragment, PageLoadingState pageLoadingState) {
        pageInformationFragment.aG = pageLoadingState;
        switch (pageInformationFragment.aG) {
            case LOADING:
                if (InteractionLogger.a(pageInformationFragment.ay)) {
                    pageInformationFragment.aC = pageInformationFragment.f4012c.now();
                    pageInformationFragment.f4011b.a(true);
                }
                pageInformationFragment.ay.setVisibility(0);
                pageInformationFragment.az.setVisibility(8);
                pageInformationFragment.aA.setVisibility(8);
                return;
            case ERROR:
                if (pageInformationFragment.aC != 0 && pageInformationFragment.f4011b.a(pageInformationFragment.f4012c.now() - pageInformationFragment.aC, pageInformationFragment.ay)) {
                    pageInformationFragment.aC = 0;
                }
                pageInformationFragment.ay.setVisibility(8);
                pageInformationFragment.az.setVisibility(0);
                pageInformationFragment.aA.setVisibility(8);
                return;
            default:
                if (pageInformationFragment.aC != 0 && pageInformationFragment.f4011b.a(pageInformationFragment.f4012c.now() - pageInformationFragment.aC, pageInformationFragment.ay)) {
                    pageInformationFragment.aC = 0;
                }
                pageInformationFragment.ay.setVisibility(8);
                pageInformationFragment.az.setVisibility(8);
                pageInformationFragment.aA.setVisibility(0);
                return;
        }
    }
}
