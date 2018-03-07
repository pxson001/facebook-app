package com.facebook.commerce.storefront.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView.LayoutParams;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.FbFragment;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceAnalyticsKey;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceModule;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceSubEvent;
import com.facebook.commerce.core.analytics.CommerceAnalyticsEventBuilder;
import com.facebook.commerce.core.analytics.CommerceLogger;
import com.facebook.commerce.core.analytics.CommerceLoggerProvider;
import com.facebook.commerce.core.analytics.CommercePerfLogger;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceMerchantSettingsModel;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.core.util.CommerceMerchantUtil;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.adapters.AbstractProductGroupingAdapter;
import com.facebook.commerce.storefront.adapters.CommerceCollectionsAdapter;
import com.facebook.commerce.storefront.adapters.StorefrontAdapter;
import com.facebook.commerce.storefront.adapters.StorefrontAdapter.C21821;
import com.facebook.commerce.storefront.adapters.StorefrontSingleCollectionAdapterProvider;
import com.facebook.commerce.storefront.fetcher.StorefrontCollectionGraphQLFetcher;
import com.facebook.commerce.storefront.fetcher.StorefrontGraphQLFetcher;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel.CollectionProductItemsModel;
import com.facebook.commerce.storefront.graphql.FetchStorefrontQuery.FetchStorefrontQueryString;
import com.facebook.commerce.storefront.graphql.FetchStorefrontQueryModels.FetchStorefrontQueryModel;
import com.facebook.commerce.storefront.ui.CollectionViewItemDecoration;
import com.facebook.commerce.storefront.ui.MerchantSubscriptionViewController;
import com.facebook.commerce.storefront.ui.StorefrontHeaderViewModel;
import com.facebook.commerce.storefront.ui.StorefrontHeaderViewModel.Builder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.1;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cpe_delta_info */
public class StorefrontFragment extends FbFragment implements PagesSurfaceTabFragment {
    @Inject
    public FbTitleBarSupplier f15738a;
    public boolean aA = false;
    private int aB;
    private int aC;
    public PagesSurfaceFragment aD;
    public ReactionHeaderTouchDelegateView aE;
    private ReactionHeaderViewWithTouchDelegate aF;
    public View aG;
    public int aH;
    private int aI;
    @Inject
    Clock al;
    @Inject
    StorefrontCollectionGraphQLFetcher am;
    @Inject
    @ForUiThread
    ExecutorService an;
    @Inject
    StorefrontSingleCollectionAdapterProvider ao;
    private LoadingIndicatorView ap;
    private RecyclerView aq;
    private LazyView<ViewGroup> ar;
    public HasTitleBar as;
    private CommerceLogger at;
    private Long au;
    @Nullable
    private String av;
    private boolean aw = false;
    private boolean ax = false;
    private CollectionViewItemDecoration ay;
    private StorefrontAdapter az;
    @Inject
    StorefrontGraphQLFetcher f15739b;
    @Inject
    TasksManager f15740c;
    @Inject
    AbstractFbErrorReporter f15741d;
    @Inject
    AnalyticsLogger f15742e;
    @Inject
    CommerceLoggerProvider f15743f;
    @Inject
    CommercePerfLogger f15744g;
    @Inject
    CommerceNavigationUtil f15745h;
    @Inject
    public MerchantSubscriptionViewController f15746i;

    /* compiled from: cpe_delta_info */
    class C21901 implements OnInflateRunner {
        final /* synthetic */ StorefrontFragment f15727a;

        /* compiled from: cpe_delta_info */
        class C21891 implements OnClickListener {
            final /* synthetic */ C21901 f15726a;

            C21891(C21901 c21901) {
                this.f15726a = c21901;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 634256284);
                StorefrontFragment.ar(this.f15726a.f15727a);
                Logger.a(2, EntryType.UI_INPUT_END, 236556539, a);
            }
        }

        C21901(StorefrontFragment storefrontFragment) {
            this.f15727a = storefrontFragment;
        }

        public final void m16169a(View view) {
            view.findViewById(2131567670).setOnClickListener(new C21891(this));
        }
    }

    /* compiled from: cpe_delta_info */
    class C21912 implements OnClickListener {
        final /* synthetic */ StorefrontFragment f15728a;

        C21912(StorefrontFragment storefrontFragment) {
            this.f15728a = storefrontFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2041211880);
            StorefrontFragment.ar(this.f15728a);
            Logger.a(2, EntryType.UI_INPUT_END, 376139737, a);
        }
    }

    /* compiled from: cpe_delta_info */
    class C21923 extends OnScrollListener {
        final /* synthetic */ StorefrontFragment f15729a;

        C21923(StorefrontFragment storefrontFragment) {
            this.f15729a = storefrontFragment;
        }

        public final void m16170a(RecyclerView recyclerView, int i) {
        }

        public final void m16171a(RecyclerView recyclerView, int i, int i2) {
            int l = ((LinearLayoutManager) recyclerView.getLayoutManager()).l();
            StorefrontFragment storefrontFragment = this.f15729a;
            if (recyclerView.getChildAt(0) != null && storefrontFragment.aD != null) {
                int top = recyclerView.getChildAt(0).getTop();
                if (storefrontFragment.aD != null && storefrontFragment.aH != top && storefrontFragment.D()) {
                    storefrontFragment.aD.a(recyclerView, l);
                    storefrontFragment.aH = top;
                }
            }
        }
    }

    /* compiled from: cpe_delta_info */
    class C21934 extends AbstractDisposableFutureCallback<GraphQLResult<FetchStorefrontQueryModel>> {
        final /* synthetic */ StorefrontFragment f15730a;

        C21934(StorefrontFragment storefrontFragment) {
            this.f15730a = storefrontFragment;
        }

        protected final void m16172a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                StorefrontFragment storefrontFragment = this.f15730a;
                IllegalStateException illegalStateException = new IllegalStateException("Null storefront query response from server");
                return;
            }
            StorefrontFragment.m16190a(this.f15730a, (FetchStorefrontQueryModel) graphQLResult.e);
        }

        protected final void m16173a(Throwable th) {
            StorefrontFragment storefrontFragment = this.f15730a;
        }
    }

    /* compiled from: cpe_delta_info */
    public class C21945 extends OnToolbarButtonListener {
        final /* synthetic */ StorefrontFragment f15731a;

        public C21945(StorefrontFragment storefrontFragment) {
            this.f15731a = storefrontFragment;
        }

        public final void m16174a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            StorefrontFragment.ar(this.f15731a);
        }
    }

    /* compiled from: cpe_delta_info */
    public final class C21956 implements Predicate<CommerceCollectionsModel> {
        public final boolean apply(@Nullable Object obj) {
            CommerceCollectionsModel commerceCollectionsModel = (CommerceCollectionsModel) obj;
            return (commerceCollectionsModel == null || commerceCollectionsModel.j() == null || commerceCollectionsModel.j().j() == null || !commerceCollectionsModel.j().j().isEmpty()) ? false : true;
        }
    }

    /* compiled from: cpe_delta_info */
    enum Tasks {
        STOREFRONT_FETCH,
        COLLECTION_FETCH
    }

    public static void m16192a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StorefrontFragment) obj).m16191a((FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), StorefrontGraphQLFetcher.m16154b(injectorLike), TasksManager.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (CommerceLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommerceLoggerProvider.class), CommercePerfLogger.a(injectorLike), CommerceNavigationUtil.a(injectorLike), MerchantSubscriptionViewController.m16277b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), StorefrontCollectionGraphQLFetcher.m16149b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (StorefrontSingleCollectionAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StorefrontSingleCollectionAdapterProvider.class));
    }

    private void m16191a(FbTitleBarSupplier fbTitleBarSupplier, StorefrontGraphQLFetcher storefrontGraphQLFetcher, TasksManager tasksManager, AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger, CommerceLoggerProvider commerceLoggerProvider, CommercePerfLogger commercePerfLogger, CommerceNavigationUtil commerceNavigationUtil, MerchantSubscriptionViewController merchantSubscriptionViewController, Clock clock, StorefrontCollectionGraphQLFetcher storefrontCollectionGraphQLFetcher, ExecutorService executorService, StorefrontSingleCollectionAdapterProvider storefrontSingleCollectionAdapterProvider) {
        this.f15738a = fbTitleBarSupplier;
        this.f15739b = storefrontGraphQLFetcher;
        this.f15740c = tasksManager;
        this.f15741d = abstractFbErrorReporter;
        this.f15742e = analyticsLogger;
        this.f15743f = commerceLoggerProvider;
        this.f15744g = commercePerfLogger;
        this.f15745h = commerceNavigationUtil;
        this.f15746i = merchantSubscriptionViewController;
        this.al = clock;
        this.am = storefrontCollectionGraphQLFetcher;
        this.an = executorService;
        this.ao = storefrontSingleCollectionAdapterProvider;
    }

    public static StorefrontFragment m16182a(Long l, @Nullable String str, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putLong("page_id", l.longValue());
        bundle.putString("arg_init_product_id", str);
        bundle.putBoolean("extra_finish_on_launch_edit_shop", z);
        bundle.putBoolean("extra_is_inside_page_surface_tab", z2);
        StorefrontFragment storefrontFragment = new StorefrontFragment();
        storefrontFragment.g(bundle);
        return storefrontFragment;
    }

    public final void m16203c(Bundle bundle) {
        boolean z = false;
        super.c(bundle);
        Class cls = StorefrontFragment.class;
        m16192a((Object) this, getContext());
        this.f15744g.a.b(7077890);
        Bundle bundle2 = this.s;
        this.au = Long.valueOf(bundle2.getLong("page_id"));
        this.av = bundle2.getString("arg_init_product_id");
        this.ax = bundle2.getBoolean("extra_finish_on_launch_edit_shop");
        this.aA = bundle2.getBoolean("extra_is_inside_page_surface_tab", false);
        this.aI = jW_().getDimensionPixelSize(2131427418);
        if (this.au.longValue() > 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "Invalid page id: " + this.au);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -899140140);
        super.mi_();
        if (!this.aA) {
            ((FbTitleBar) this.f15738a.get()).setTitle(b(2131234809));
            this.as = (HasTitleBar) a(HasTitleBar.class);
            if (this.as != null) {
                this.as.c(true);
            }
        }
        this.at.a();
        CommerceLogger commerceLogger = this.at;
        CommerceProductSectionType commerceProductSectionType = CommerceProductSectionType.PAGE_STOREFRONT_ENTRY_GRID;
        HashMap hashMap = new HashMap();
        hashMap.put(CommerceAnalyticsKey.EVENT.value, CommerceSubEvent.DID_OPEN_STOREFRONT_FROM_PAGE_HEADER.value);
        hashMap.put(CommerceAnalyticsKey.SECTION_TYPE.value, commerceProductSectionType.value);
        hashMap.put(CommerceAnalyticsKey.LOGGING_EVENT_TIME.value, Long.valueOf(commerceLogger.o.now()));
        commerceLogger.m.add(hashMap);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 401455979, a);
    }

    public final void m16198G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 113714290);
        super.G();
        if (this.aw) {
            aq();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -540893343, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1117182007);
        super.mj_();
        this.at.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2094972221, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1863400517);
        super.mY_();
        this.f15740c.c();
        this.az = null;
        this.ay = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 87879405, a);
    }

    public final View m16199a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1028911041);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130907244, viewGroup, false);
        this.at = this.f15743f.a(CommerceEvent.VIEW_PRODUCT_STOREFRONT, CommerceModule.COMMERCE_STOREFRONT, CommerceRefType.PAGE, this.au);
        this.ap = (LoadingIndicatorView) viewGroup2.findViewById(2131560407);
        this.ar = new LazyView((ViewStub) viewGroup2.findViewById(2131567671), new C21901(this));
        m16186a(viewGroup2);
        if (!this.aA) {
            viewGroup2.setBackgroundResource(2131361920);
        }
        aq();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -10593067, a);
        return viewGroup2;
    }

    private void m16186a(ViewGroup viewGroup) {
        this.aq = (RecyclerView) viewGroup.findViewById(2131567672);
        this.az = new StorefrontAdapter(getContext(), new Builder().m16287a(), null);
        this.az.f15678f = new C21912(this);
        if (this.aA) {
            m16194b();
        }
        StorefrontAdapter storefrontAdapter = this.az;
        if (this.aE != null) {
            if (this.aE.getParent() != null) {
                ((ViewGroup) this.aE.getParent()).removeView(this.aE);
            }
            storefrontAdapter.f15676d = (View) Preconditions.checkNotNull(this.aE);
        }
        if (this.aG != null) {
            if (this.aG.getParent() != null) {
                ((ViewGroup) this.aG.getParent()).removeView(this.aG);
            }
            storefrontAdapter.f15677e = (View) Preconditions.checkNotNull(this.aG);
        }
        this.aq.setAdapter(this.az);
        RecyclerView recyclerView = this.aq;
        StorefrontAdapter storefrontAdapter2 = this.az;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(storefrontAdapter2.f15673a, 2, 1, false);
        gridLayoutManager.h = new C21821(storefrontAdapter2);
        recyclerView.setLayoutManager(gridLayoutManager);
        D_(this.aB);
    }

    private void m16194b() {
        as();
        this.aG = new View(getContext());
        E_(this.aC);
        this.aq.a(new C21923(this));
    }

    private void aq() {
        this.ap.a();
        this.ap.setVisibility(0);
        StorefrontGraphQLFetcher storefrontGraphQLFetcher = this.f15739b;
        long longValue = this.au.longValue();
        GraphQlQueryString fetchStorefrontQueryString = new FetchStorefrontQueryString();
        fetchStorefrontQueryString.a("page_id", Long.valueOf(longValue));
        fetchStorefrontQueryString.a("collection_count", Integer.valueOf(10));
        fetchStorefrontQueryString.a("COMMERCE_SMALL_IMAGE_SIZE", Integer.valueOf(50));
        fetchStorefrontQueryString.a("COMMERCE_LARGE_IMAGE_SIZE", Integer.valueOf(720));
        fetchStorefrontQueryString.a("COMMERCE_MEDIUM_IMAGE_SIZE", Integer.valueOf(230));
        this.f15740c.a(Tasks.STOREFRONT_FETCH, storefrontGraphQLFetcher.f15711a.a(GraphQLRequest.a(fetchStorefrontQueryString)), new C21934(this));
    }

    public static void m16190a(StorefrontFragment storefrontFragment, FetchStorefrontQueryModel fetchStorefrontQueryModel) {
        storefrontFragment.ap.b();
        storefrontFragment.ap.setVisibility(8);
        storefrontFragment.m16195b(fetchStorefrontQueryModel);
        CommercePerfLogger commercePerfLogger = storefrontFragment.f15744g;
        if (commercePerfLogger.a.f(7077890)) {
            commercePerfLogger.a.b(7077890, (short) 2);
        }
    }

    private void m16195b(FetchStorefrontQueryModel fetchStorefrontQueryModel) {
        if (fetchStorefrontQueryModel != null) {
            if (fetchStorefrontQueryModel.m16247k() == null) {
                if (this.aw) {
                    o().finish();
                }
                this.aq.setVisibility(8);
                return;
            }
            boolean z;
            if (fetchStorefrontQueryModel == null || fetchStorefrontQueryModel.m16247k() == null || fetchStorefrontQueryModel.m16247k().j() == null || !fetchStorefrontQueryModel.m16247k().j().m()) {
                z = false;
            } else {
                z = true;
            }
            this.aw = z;
            Object obj;
            if (Iterables.e(fetchStorefrontQueryModel.m16247k().a(), new C21956())) {
                if (this.aA || fetchStorefrontQueryModel == null || fetchStorefrontQueryModel.m16247k() == null || fetchStorefrontQueryModel.m16247k().a() == null || !m16193a(fetchStorefrontQueryModel.m16247k())) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    ((ViewGroup) this.ar.a()).setVisibility(0);
                    return;
                } else {
                    this.aq.setVisibility(8);
                    return;
                }
            }
            this.ar.c();
            this.aq.setVisibility(0);
            MerchantInfoViewData g = m16197g(fetchStorefrontQueryModel);
            if (fetchStorefrontQueryModel == null || fetchStorefrontQueryModel.m16247k() == null || fetchStorefrontQueryModel.m16247k().j() == null) {
                this.f15746i.m16279a(null, false, false);
            } else {
                CommerceMerchantSettingsModel j = fetchStorefrontQueryModel.m16247k().j();
                this.f15746i.m16279a(j.j(), j.k(), CommerceMerchantUtil.a(j.l()));
            }
            if (m16196c(fetchStorefrontQueryModel.m16247k()) && !this.aA) {
                TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                a.g = b(2131234815);
                this.as.a(a.a());
                this.as.a(new C21945(this));
            }
            Preconditions.checkNotNull(fetchStorefrontQueryModel.m16247k());
            Preconditions.checkNotNull(fetchStorefrontQueryModel.m16247k().a());
            if (fetchStorefrontQueryModel.m16247k().a().size() == 2) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                m16185a(Long.parseLong(((CommerceCollectionsModel) fetchStorefrontQueryModel.m16247k().a().get(1)).k()), m16181a(fetchStorefrontQueryModel.m16247k().a()), g, fetchStorefrontQueryModel.m16247k());
                return;
            }
            StorefrontHeaderViewModel a2 = m16183a((CommerceCollectionsModel) fetchStorefrontQueryModel.m16247k().a().get(0), g).m16287a();
            AbstractProductGroupingAdapter commerceCollectionsAdapter = new CommerceCollectionsAdapter(getContext(), g);
            commerceCollectionsAdapter.f15662c = fetchStorefrontQueryModel.m16247k().a();
            m16188a(commerceCollectionsAdapter, a2);
        }
    }

    @Nullable
    private static CommerceCollectionsModel m16181a(ImmutableList<CommerceCollectionsModel> immutableList) {
        boolean z;
        int i = 1;
        if (immutableList.size() == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (((CommerceCollectionsModel) immutableList.get(0)).j() == null || ((CommerceCollectionsModel) immutableList.get(0)).j().a() <= 0) {
            i = 0;
        }
        return i != 0 ? (CommerceCollectionsModel) immutableList.get(0) : null;
    }

    public static boolean m16193a(@Nullable CommerceStoreFragmentModel commerceStoreFragmentModel) {
        return (commerceStoreFragmentModel == null || commerceStoreFragmentModel.j() == null || !CommerceMerchantUtil.a(commerceStoreFragmentModel.j().l(), commerceStoreFragmentModel.j().m())) ? false : true;
    }

    private static MerchantInfoViewData m16197g(FetchStorefrontQueryModel fetchStorefrontQueryModel) {
        String str = "";
        if (!(fetchStorefrontQueryModel == null || fetchStorefrontQueryModel.m16249m() == null)) {
            str = fetchStorefrontQueryModel.m16249m();
        }
        String str2 = "";
        if (!(fetchStorefrontQueryModel == null || fetchStorefrontQueryModel.m16251o() == null || fetchStorefrontQueryModel.m16251o().a() == null)) {
            str2 = fetchStorefrontQueryModel.m16251o().a();
        }
        String str3 = "";
        if (!(fetchStorefrontQueryModel == null || fetchStorefrontQueryModel.m16246j() == null || fetchStorefrontQueryModel.m16246j().get(0) == null)) {
            str3 = (String) fetchStorefrontQueryModel.m16246j().get(0);
        }
        int i = -1;
        if (!(fetchStorefrontQueryModel == null || fetchStorefrontQueryModel.m16250n() == null)) {
            i = fetchStorefrontQueryModel.m16250n().a();
        }
        String str4 = "";
        if (fetchStorefrontQueryModel != null) {
            str4 = fetchStorefrontQueryModel.m16248l();
        }
        String str5 = "";
        if (!(fetchStorefrontQueryModel == null || fetchStorefrontQueryModel.m16247k() == null || fetchStorefrontQueryModel.m16247k().k() == null)) {
            str5 = fetchStorefrontQueryModel.m16247k().k();
        }
        return new MerchantInfoViewData(str, str2, str3, i, str4, str5);
    }

    public static boolean m16196c(@Nullable CommerceStoreFragmentModel commerceStoreFragmentModel) {
        return (commerceStoreFragmentModel == null || commerceStoreFragmentModel.j() == null || !commerceStoreFragmentModel.j().m()) ? false : true;
    }

    public static void ar(StorefrontFragment storefrontFragment) {
        if (storefrontFragment.ax) {
            storefrontFragment.o().finish();
            return;
        }
        CommerceNavigationUtil commerceNavigationUtil = storefrontFragment.f15745h;
        FragmentActivity o = storefrontFragment.o();
        Intent a = commerceNavigationUtil.c.a(o, StringFormatUtil.formatStrLocaleSafe(FBLinks.eC, String.valueOf(storefrontFragment.au)));
        a.putExtra("extra_finish_on_launch_view_shop", true);
        commerceNavigationUtil.b.a(a, o);
    }

    private void m16185a(long j, @Nullable CommerceCollectionsModel commerceCollectionsModel, @Nullable MerchantInfoViewData merchantInfoViewData, @Nullable CommerceStoreFragmentModel commerceStoreFragmentModel) {
        final long a = this.al.a();
        final long j2 = j;
        final CommerceCollectionsModel commerceCollectionsModel2 = commerceCollectionsModel;
        final MerchantInfoViewData merchantInfoViewData2 = merchantInfoViewData;
        final CommerceStoreFragmentModel commerceStoreFragmentModel2 = commerceStoreFragmentModel;
        this.f15740c.a(Tasks.COLLECTION_FETCH, this.am.m16152a(j), new AbstractDisposableFutureCallback<FetchStorefrontCollectionQueryModel>(this) {
            final /* synthetic */ StorefrontFragment f15737f;

            protected final void m16175a(@Nullable Object obj) {
                FetchStorefrontCollectionQueryModel fetchStorefrontCollectionQueryModel = (FetchStorefrontCollectionQueryModel) obj;
                if (fetchStorefrontCollectionQueryModel == null) {
                    m16176a(new IllegalStateException("Null collection query response from server"));
                } else if (this.f15737f.y) {
                    this.f15737f.m16184a(a, j2, fetchStorefrontCollectionQueryModel, commerceCollectionsModel2, merchantInfoViewData2, commerceStoreFragmentModel2);
                }
            }

            protected final void m16176a(Throwable th) {
                BLog.b(StorefrontFragment.class, "Could not fetch collection", th);
            }
        });
    }

    private void m16184a(long j, long j2, FetchStorefrontCollectionQueryModel fetchStorefrontCollectionQueryModel, @Nullable CommerceCollectionsModel commerceCollectionsModel, @Nullable MerchantInfoViewData merchantInfoViewData, @Nullable CommerceStoreFragmentModel commerceStoreFragmentModel) {
        if (fetchStorefrontCollectionQueryModel.m16226a() != null) {
            this.f15742e.a(CommerceAnalyticsEventBuilder.a(j2, fetchStorefrontCollectionQueryModel.m16226a().m16220a().size(), this.al.a() - j, false));
            m16187a(merchantInfoViewData, commerceCollectionsModel, fetchStorefrontCollectionQueryModel.m16226a(), j2, commerceStoreFragmentModel);
        }
    }

    private void m16187a(MerchantInfoViewData merchantInfoViewData, CommerceCollectionsModel commerceCollectionsModel, CollectionProductItemsModel collectionProductItemsModel, long j, @Nullable CommerceStoreFragmentModel commerceStoreFragmentModel) {
        Builder a = m16183a(commerceCollectionsModel, merchantInfoViewData);
        if (this.aA) {
            a.f15826c = m16196c(commerceStoreFragmentModel);
        }
        StorefrontHeaderViewModel a2 = a.m16287a();
        AbstractProductGroupingAdapter a3 = this.ao.m16143a(ao(), m16193a(commerceStoreFragmentModel));
        a3.f15691g = collectionProductItemsModel;
        a3.f15693i = collectionProductItemsModel.m16220a().size();
        a3.f15692h = j;
        a3.notifyDataSetChanged();
        if (this.ay == null) {
            this.ay = new CollectionViewItemDecoration(2, 2);
            this.aq.a(this.ay);
        }
        m16188a(a3, a2);
    }

    private void m16188a(AbstractProductGroupingAdapter abstractProductGroupingAdapter, StorefrontHeaderViewModel storefrontHeaderViewModel) {
        this.az.f15674b = (AbstractProductGroupingAdapter) Preconditions.checkNotNull(abstractProductGroupingAdapter);
        this.az.f15675c = (StorefrontHeaderViewModel) Preconditions.checkNotNull(storefrontHeaderViewModel);
        this.az.notifyDataSetChanged();
        D_(this.aB);
    }

    private Builder m16183a(CommerceCollectionsModel commerceCollectionsModel, MerchantInfoViewData merchantInfoViewData) {
        Builder builder = new Builder();
        builder.f15829f = Optional.fromNullable(commerceCollectionsModel);
        builder = builder;
        builder.f15831h = Optional.fromNullable(this.av);
        builder = builder;
        builder.f15830g = Optional.fromNullable(merchantInfoViewData.f);
        builder = builder;
        builder.f15828e = Optional.fromNullable(this.f15746i);
        builder = builder;
        if (this.aA) {
            builder.m16286a(null);
            builder.f15827d = Optional.of(Integer.valueOf(this.aI));
        } else {
            builder.m16286a(merchantInfoViewData);
        }
        return builder;
    }

    public final void mo767a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aD = pagesSurfaceFragment;
    }

    public final void mo769j() {
    }

    public final void D_(int i) {
        this.aB = i;
        PagesScrollUtils.a(this.aq, this.aB);
    }

    public final void E_(int i) {
        this.aC = i;
        if (this.aG != null) {
            this.aG.setLayoutParams(new LayoutParams(-1, this.aC));
        }
    }

    public final void mo768a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.aF = reactionHeaderViewWithTouchDelegate;
        as();
    }

    public final void mo766a(1 1) {
    }

    private void as() {
        if (this.aE == null) {
            if (this.aF == null) {
                this.aE = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.aE = new ReactionHeaderTouchDelegateView(this.aF);
                this.aF.a(this.aE);
            }
            this.aE.c = true;
        } else if (this.aF != null) {
            this.aE.a = this.aF;
            this.aF.a(this.aE);
            this.aE.requestLayout();
        }
    }
}
