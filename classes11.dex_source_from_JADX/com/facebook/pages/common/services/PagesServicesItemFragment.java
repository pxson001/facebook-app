package com.facebook.pages.common.services;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.PageViewReferrer;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageDataFetchType;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageHeaderDataListener;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherControllerProvider;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.pages.identity.protocol.graphql.SingleServiceGraphQL.SingleServiceGraphQLString;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: review_type */
public class PagesServicesItemFragment extends FbFragment implements PageHeaderDataListener {
    @Inject
    public TasksManager f2378a;
    private PagesServiceItemLarge al;
    private ScrollView am;
    private ProgressBar an;
    public String ao;
    private String ap;
    public String aq;
    private boolean ar = false;
    private PageHeaderFetcherController as;
    private PageHeaderData at;
    public PageServiceItemModel au;
    @Inject
    public GraphQLQueryExecutor f2379b;
    @Inject
    Lazy<FbErrorReporter> f2380c;
    @Inject
    public ScreenUtil f2381d;
    @Inject
    PageCallToActionUtil f2382e;
    @Inject
    PageHeaderFetcherControllerProvider f2383f;
    @Inject
    Toaster f2384g;
    @Inject
    FbUriIntentHandler f2385h;
    private ContentView f2386i;

    /* compiled from: review_type */
    public class C03021 extends AbstractDisposableFutureCallback<GraphQLResult<PageServiceItemModel>> {
        final /* synthetic */ PagesServicesItemFragment f2376a;

        public C03021(PagesServicesItemFragment pagesServicesItemFragment) {
            this.f2376a = pagesServicesItemFragment;
        }

        protected final void m3334a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                PagesServicesItemFragment.m3341g(this.f2376a, 2131235517);
                return;
            }
            this.f2376a.au = (PageServiceItemModel) graphQLResult.e;
            PagesServicesItemFragment.ar(this.f2376a);
        }

        protected final void m3335a(Throwable th) {
            ((AbstractFbErrorReporter) this.f2376a.f2380c.get()).a("PagesServicesItemFragment", th);
            PagesServicesItemFragment.m3341g(this.f2376a, 2131235517);
        }
    }

    /* compiled from: review_type */
    class C03032 implements OnClickListener {
        final /* synthetic */ PagesServicesItemFragment f2377a;

        C03032(PagesServicesItemFragment pagesServicesItemFragment) {
            this.f2377a = pagesServicesItemFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2008100902);
            this.f2377a.f2385h.a(this.f2377a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, this.f2377a.ao));
            Logger.a(2, EntryType.UI_INPUT_END, 319817019, a);
        }
    }

    public static void m3339a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesServicesItemFragment) obj).m3338a(TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), ScreenUtil.a(fbInjector), PageCallToActionUtil.a(fbInjector), (PageHeaderFetcherControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PageHeaderFetcherControllerProvider.class), Toaster.b(fbInjector), FbUriIntentHandler.a(fbInjector));
    }

    private void m3338a(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<FbErrorReporter> lazy, ScreenUtil screenUtil, PageCallToActionUtil pageCallToActionUtil, PageHeaderFetcherControllerProvider pageHeaderFetcherControllerProvider, Toaster toaster, FbUriIntentHandler fbUriIntentHandler) {
        this.f2378a = tasksManager;
        this.f2379b = graphQLQueryExecutor;
        this.f2380c = lazy;
        this.f2381d = screenUtil;
        this.f2382e = pageCallToActionUtil;
        this.f2383f = pageHeaderFetcherControllerProvider;
        this.f2384g = toaster;
        this.f2385h = fbUriIntentHandler;
    }

    public final void m3348c(Bundle bundle) {
        super.c(bundle);
        Class cls = PagesServicesItemFragment.class;
        m3339a((Object) this, getContext());
        this.ao = this.s.getString("com.facebook.katana.profile.id");
        this.ap = this.s.getString("profile_name");
        this.aq = this.s.getString("page_service_id_extra");
        this.ar = this.s.getBoolean("extra_service_launched_from_page");
        this.as = this.f2383f.m3467a(this, Long.valueOf(Long.parseLong(this.ao)), PageViewReferrer.PAGE, SafeUUIDGenerator.a().toString());
        this.at = new PageHeaderData(Long.parseLong(this.ao), null);
    }

    public final View m3344a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 144090056);
        View inflate = layoutInflater.inflate(2130906130, viewGroup, false);
        this.am = (ScrollView) inflate.findViewById(2131565748);
        this.f2386i = (ContentView) inflate.findViewById(2131565749);
        this.al = (PagesServiceItemLarge) inflate.findViewById(2131565750);
        this.an = (ProgressBar) inflate.findViewById(2131559418);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 941978793, a);
        return inflate;
    }

    public final void m3345a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.as.m3465a(PageDataFetchType.DEFAULT);
        GraphQLQueryExecutor graphQLQueryExecutor = this.f2379b;
        GraphQlQueryString singleServiceGraphQLString = new SingleServiceGraphQLString();
        singleServiceGraphQLString.a("service_id", this.aq);
        int c = this.f2381d.c();
        singleServiceGraphQLString.a("page_service_image_width", Integer.valueOf(c));
        singleServiceGraphQLString.a("page_service_image_height", Integer.valueOf((int) (((float) c) / 1.0f)));
        this.f2378a.a("fetch_single_page_service", graphQLQueryExecutor.a(GraphQLRequest.a(singleServiceGraphQLString)), new C03021(this));
    }

    public final void m3342G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -676511904);
        super.G();
        this.as.m3466b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1439281126, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 217387297);
        super.mi_();
        m3340b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1501359903, a);
    }

    public final void m3343I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -687424745);
        super.I();
        if (this.as != null) {
            this.as.m3464a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1475848623, a);
    }

    private void m3340b() {
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(Strings.isNullOrEmpty(this.ap) ? jW_().getString(2131235511) : this.ap);
        }
    }

    public final void mo53a(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult, PageDataFetchType pageDataFetchType) {
        if (graphQLResult != null && graphQLResult.e != null) {
            this.at.a((FetchPageHeaderQueryModel) graphQLResult.e, graphQLResult.freshness);
            this.ap = ((FetchPageHeaderQueryModel) graphQLResult.e).D();
            m3340b();
            ar(this);
        }
    }

    public final void mo54a(Throwable th) {
        m3341g(this, 2131235517);
    }

    public static void ar(PagesServicesItemFragment pagesServicesItemFragment) {
        if (pagesServicesItemFragment.al != null && pagesServicesItemFragment.au != null && pagesServicesItemFragment.at.c()) {
            pagesServicesItemFragment.al.m3304a(PagesServiceUtils.m3305a(pagesServicesItemFragment.au), pagesServicesItemFragment.au.eC_(), pagesServicesItemFragment.au.c(), pagesServicesItemFragment.au.b(), pagesServicesItemFragment.f2382e.a(pagesServicesItemFragment.at, ImmutableList.of(GraphQLPageCallToActionType.CALL_NOW, GraphQLPageCallToActionType.MESSAGE)), pagesServicesItemFragment.at);
            pagesServicesItemFragment.am.setVisibility(0);
            pagesServicesItemFragment.an.setVisibility(8);
            if (!pagesServicesItemFragment.ar && pagesServicesItemFragment.at.e != null) {
                pagesServicesItemFragment.f2386i.setThumbnailUri(pagesServicesItemFragment.at.i());
                pagesServicesItemFragment.f2386i.setTitleText(pagesServicesItemFragment.at.e.D());
                if (pagesServicesItemFragment.at.e.X()) {
                    pagesServicesItemFragment.f2386i.setSubtitleText(pagesServicesItemFragment.at.e.ac());
                }
                pagesServicesItemFragment.f2386i.setVisibility(0);
                pagesServicesItemFragment.f2386i.setOnClickListener(new C03032(pagesServicesItemFragment));
            }
        }
    }

    public static void m3341g(PagesServicesItemFragment pagesServicesItemFragment, int i) {
        pagesServicesItemFragment.f2384g.a(new ToastBuilder(i));
    }
}
