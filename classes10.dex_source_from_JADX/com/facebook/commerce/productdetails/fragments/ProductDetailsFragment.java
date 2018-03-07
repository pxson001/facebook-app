package com.facebook.commerce.productdetails.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.IRefreshableFragment;
import com.facebook.commerce.core.analytics.CommerceAnalytics;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceAnalyticsKey;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceModule;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceSubEvent;
import com.facebook.commerce.core.analytics.CommerceLogger;
import com.facebook.commerce.core.analytics.CommerceLoggerProvider;
import com.facebook.commerce.core.analytics.CommercePerfLogger;
import com.facebook.commerce.core.event.CommerceEvent.CommerceEventMessageToBuyClicked;
import com.facebook.commerce.core.event.CommerceEventBus;
import com.facebook.commerce.core.event.CommerceEventSubscriber;
import com.facebook.commerce.core.util.CommerceMerchantUtil;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.productdetails.adapter.ProductDetailsAdapter;
import com.facebook.commerce.productdetails.adapter.ProductGroupAdapterRows;
import com.facebook.commerce.productdetails.adapter.ProductGroupAdapterRows.ProductGroupViewType;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQuery.FetchProductGroupQueryString;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.ui.userinteractions.ProductGroupUserInteractionsView;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Method;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.util.PortraitOrientationController;
import com.facebook.pages.common.viewercontextutils.PageViewerContextLifecycleHelper;
import com.facebook.pages.common.viewercontextutils.PageViewerContextLifecycleHelper.PageViewerContextLifecycleCallback;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: deleteMessagesResult */
public class ProductDetailsFragment extends FbFragment implements IRefreshableFragment {
    @Inject
    CommercePerfLogger f15148a;
    @Inject
    PageViewerContextLifecycleHelper al;
    @Inject
    AbstractFbErrorReporter am;
    @Inject
    Lazy<CommerceNavigationUtil> an;
    public long ao;
    private CommerceRefType ap;
    private ViewGroup aq;
    private BetterListView ar;
    private PortraitOrientationController as;
    public CommerceLogger at;
    private final CommerceEventSubscriber<CommerceEventMessageToBuyClicked> au = new C21144(this);
    @Inject
    CommerceLoggerProvider f15149b;
    @Inject
    FbTitleBarSupplier f15150c;
    @Inject
    TasksManager f15151d;
    @Inject
    GraphQLQueryExecutor f15152e;
    @Inject
    ProductDetailsAdapter f15153f;
    @Inject
    GraphQLImageHelper f15154g;
    @Inject
    ScreenUtil f15155h;
    @Inject
    CommerceEventBus f15156i;

    /* compiled from: deleteMessagesResult */
    class C21101 implements Callable<ListenableFuture<GraphQLResult<FetchProductGroupQueryModel>>> {
        final /* synthetic */ ProductDetailsFragment f15141a;

        public Object call() {
            GraphQlQueryString fetchProductGroupQueryString = new FetchProductGroupQueryString();
            GraphQLImageHelper graphQLImageHelper = this.f15141a.f15154g;
            graphQLImageHelper = this.f15141a.f15154g;
            graphQLImageHelper = this.f15141a.f15154g;
            GraphQlQueryString a = fetchProductGroupQueryString.a("product_item_id", Long.valueOf(this.f15141a.ao)).a("profile_pic_size", GraphQLImageHelper.a(this.f15141a.jW_().getDimensionPixelSize(2131427458))).a("recommended_product_image_size", String.valueOf(GraphQLImageHelper.a(this.f15141a.jW_().getDimensionPixelSize(2131429731)))).a("product_item_image_size", String.valueOf(GraphQLImageHelper.a((Math.min(this.f15141a.f15155h.c(), this.f15141a.f15155h.d()) * ProductGroupUserInteractionsView.f15344a) / 100)));
            String str = "supported_section_types";
            Builder builder = new Builder();
            ImmutableList immutableList = ProductGroupAdapterRows.f15131f;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                builder.c(((ProductGroupViewType) immutableList.get(i)).mo756a());
            }
            a.a(str, builder.b());
            return this.f15141a.f15152e.a(GraphQLRequest.a(fetchProductGroupQueryString));
        }

        C21101(ProductDetailsFragment productDetailsFragment) {
            this.f15141a = productDetailsFragment;
        }
    }

    /* compiled from: deleteMessagesResult */
    class C21122 extends AbstractDisposableFutureCallback<GraphQLResult<FetchProductGroupQueryModel>> {
        final /* synthetic */ ProductDetailsFragment f15144a;

        C21122(ProductDetailsFragment productDetailsFragment) {
            this.f15144a = productDetailsFragment;
        }

        protected final void m15671a(Object obj) {
            Object obj2;
            final FetchProductGroupQueryModel fetchProductGroupQueryModel = (FetchProductGroupQueryModel) ((GraphQLResult) obj).e;
            ProductDetailsFragment.m15677a(this.f15144a, fetchProductGroupQueryModel);
            PageViewerContextLifecycleHelper pageViewerContextLifecycleHelper = this.f15144a.al;
            C21111 c21111 = new PageViewerContextLifecycleCallback(this) {
                final /* synthetic */ C21122 f15143b;

                public final void m15670a(@Nullable ViewerContext viewerContext) {
                    if (viewerContext != null) {
                        ProductDetailsFragment.m15677a(this.f15143b.f15144a, fetchProductGroupQueryModel);
                    }
                }

                public final void m15669a() {
                }
            };
            if (fetchProductGroupQueryModel == null || fetchProductGroupQueryModel.m15822t() == null || StringUtil.a(fetchProductGroupQueryModel.m15822t().m15772l()) || fetchProductGroupQueryModel.m15814l() == null || !CommerceMerchantUtil.a(fetchProductGroupQueryModel.m15814l().m15697a(), fetchProductGroupQueryModel.m15814l().m15702k())) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                pageViewerContextLifecycleHelper.a(fetchProductGroupQueryModel.m15822t().m15772l(), c21111);
            }
            CommercePerfLogger commercePerfLogger = this.f15144a.f15148a;
            if (commercePerfLogger.a.f(7077891)) {
                commercePerfLogger.a.b(7077891, (short) 2);
            }
        }

        protected final void m15672a(Throwable th) {
        }
    }

    /* compiled from: deleteMessagesResult */
    class C21144 extends CommerceEventSubscriber<CommerceEventMessageToBuyClicked> {
        final /* synthetic */ ProductDetailsFragment f15147a;

        C21144(ProductDetailsFragment productDetailsFragment) {
            this.f15147a = productDetailsFragment;
        }

        public final void m15675b(FbEvent fbEvent) {
            CommerceLogger commerceLogger = this.f15147a.at;
            CommerceProductSectionType commerceProductSectionType = CommerceProductSectionType.PRODUCT_DETAILS_PAGE;
            HashMap hashMap = new HashMap();
            hashMap.put(CommerceAnalyticsKey.EVENT.value, CommerceSubEvent.MESSAGE_TO_BUY_CLICK.value);
            hashMap.put(CommerceAnalyticsKey.SECTION_TYPE.value, commerceProductSectionType.value);
            hashMap.put(CommerceAnalyticsKey.LOGGING_EVENT_TIME.value, Long.valueOf(commerceLogger.o.now()));
            commerceLogger.m.add(hashMap);
        }

        public final Class<CommerceEventMessageToBuyClicked> m15674a() {
            return CommerceEventMessageToBuyClicked.class;
        }
    }

    public static void m15678a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProductDetailsFragment) obj).m15676a(CommercePerfLogger.a(fbInjector), (CommerceLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CommerceLoggerProvider.class), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), ProductDetailsAdapter.m15641b(fbInjector), GraphQLImageHelper.a(fbInjector), ScreenUtil.a(fbInjector), CommerceEventBus.a(fbInjector), PageViewerContextLifecycleHelper.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), IdBasedLazy.a(fbInjector, 5054));
    }

    private void m15676a(CommercePerfLogger commercePerfLogger, CommerceLoggerProvider commerceLoggerProvider, FbTitleBarSupplier fbTitleBarSupplier, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, ProductDetailsAdapter productDetailsAdapter, GraphQLImageHelper graphQLImageHelper, ScreenUtil screenUtil, CommerceEventBus commerceEventBus, PageViewerContextLifecycleHelper pageViewerContextLifecycleHelper, FbErrorReporter fbErrorReporter, Lazy<CommerceNavigationUtil> lazy) {
        this.f15148a = commercePerfLogger;
        this.f15149b = commerceLoggerProvider;
        this.f15150c = fbTitleBarSupplier;
        this.f15151d = tasksManager;
        this.f15152e = graphQLQueryExecutor;
        this.f15153f = productDetailsAdapter;
        this.f15154g = graphQLImageHelper;
        this.f15155h = screenUtil;
        this.f15156i = commerceEventBus;
        this.al = pageViewerContextLifecycleHelper;
        this.am = fbErrorReporter;
        this.an = lazy;
    }

    public final void m15683c(Bundle bundle) {
        super.c(bundle);
        Class cls = ProductDetailsFragment.class;
        m15678a((Object) this, getContext());
        this.f15148a.a.b(7077891);
        Bundle bundle2 = this.s;
        this.ao = bundle2.getLong("product_item_id");
        Preconditions.checkArgument(this.ao > 0, "Invalid item id: " + this.ao);
        this.ap = (CommerceRefType) bundle2.getSerializable("product_ref_type");
        if (this.ap == null) {
            this.ap = CommerceRefType.UNKNOWN;
        }
        this.al.a();
        this.as = new PortraitOrientationController();
        a(this.as);
    }

    public final View m15681a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 261020411);
        this.aq = (ViewGroup) layoutInflater.inflate(2130906407, viewGroup, false);
        this.at = this.f15149b.a(CommerceEvent.VIEW_PRODUCT_DETAILS, CommerceModule.COMMERCE_DETAILS_PAGE, this.ap, Long.valueOf((long) CommerceAnalytics.a(this.ap)));
        this.at.l = String.valueOf(Long.valueOf(this.ao));
        m15679b();
        aq();
        View view = this.aq;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1998202238, a);
        return view;
    }

    private void m15679b() {
        this.ar = (BetterListView) this.aq.findViewById(16908298);
        this.ar.setDividerHeight(0);
        this.ar.c();
        this.ar.setVerticalScrollBarEnabled(false);
        this.ar.setBroadcastInteractionChanges(true);
        this.ar.setEmptyView(this.aq.findViewById(16908292));
        this.ar.setAdapter(this.f15153f);
    }

    public final void m15684e() {
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1581277187);
        super.mY_();
        this.f15151d.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1709391523, a);
    }

    public final void m15680I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 565264579);
        super.I();
        this.al.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -721850085, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -239436469);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
        }
        this.at.a();
        this.f15156i.a(this.au);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 845040973, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1229676483);
        super.mj_();
        this.at.b();
        this.f15156i.b(this.au);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1190370672, a);
    }

    public final void m15682a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1 && i == 9254) {
            Method method = (Method) intent.getSerializableExtra("result_mutation_method");
            if (method != null) {
                if (method == Method.DELETE) {
                    o().finish();
                } else if (method == Method.CREATE || method == Method.EDIT) {
                    aq();
                }
            }
        }
    }

    private void aq() {
        this.f15151d.a("fetch_product_group", new C21101(this), new C21122(this));
    }

    public static void m15677a(ProductDetailsFragment productDetailsFragment, final FetchProductGroupQueryModel fetchProductGroupQueryModel) {
        Object obj;
        ((FbTitleBar) productDetailsFragment.f15150c.get()).setTitle(fetchProductGroupQueryModel.m15821s());
        if (fetchProductGroupQueryModel == null || fetchProductGroupQueryModel.m15814l() == null || !fetchProductGroupQueryModel.m15814l().m15702k() || StringUtil.c(fetchProductGroupQueryModel.m15820r()) || fetchProductGroupQueryModel.m15822t() == null || fetchProductGroupQueryModel.m15822t().m15772l() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            HasTitleBar hasTitleBar = (HasTitleBar) productDetailsFragment.a(HasTitleBar.class);
            if (hasTitleBar != null) {
                TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
                a.g = productDetailsFragment.b(2131241873);
                hasTitleBar.a(a.a());
                hasTitleBar.a(new OnToolbarButtonListener(productDetailsFragment) {
                    final /* synthetic */ ProductDetailsFragment f15146b;

                    public final void m15673a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                        if (this.f15146b.al.f == null) {
                            this.f15146b.am.b(ProductDetailsFragment.class.getSimpleName(), "Page ViewerContext not available on Edit.");
                        } else {
                            ((CommerceNavigationUtil) this.f15146b.an.get()).a(Long.parseLong(fetchProductGroupQueryModel.m15822t().m15772l()), Optional.of(fetchProductGroupQueryModel.m15820r()), true, 9254, this.f15146b, this.f15146b.al.f);
                        }
                    }
                });
            }
        }
        productDetailsFragment.f15153f.m15644a(fetchProductGroupQueryModel);
    }
}
