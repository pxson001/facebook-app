package com.facebook.commerce.publishing.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.commerce.core.ui.ProductItemViewBinder;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.publishing.adapter.AdminShopAdapter;
import com.facebook.commerce.publishing.adapter.AdminShopAdapterDataProvider;
import com.facebook.commerce.publishing.adapter.AdminShopAdapterProvider;
import com.facebook.commerce.publishing.constants.AdminShopConstants;
import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Method;
import com.facebook.commerce.publishing.event.CommercePublishingMutationEvent.Status;
import com.facebook.commerce.publishing.event.ProductItemMutationEvent;
import com.facebook.commerce.publishing.event.ProductItemMutationEvent.ProductItemMutationEventSubscriber;
import com.facebook.commerce.publishing.fetcher.AdminEditShopFetcher;
import com.facebook.commerce.publishing.fetcher.AdminEditShopFetcher.C21431;
import com.facebook.commerce.publishing.fetcher.AdminEditShopFetcher.C21442;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.commerce.publishing.graphql.CommerceStoreDeleteMutation.CommerceStoreDeleteMutationString;
import com.facebook.commerce.publishing.graphql.CommerceStoreUpdateMutation.CommerceStoreUpdateMutationString;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQuery.FetchCommerceStoreQueryString;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryModels.FetchCommerceStoreQueryModel;
import com.facebook.commerce.publishing.mutator.ProductItemPendingMutationsCache;
import com.facebook.commerce.publishing.ui.AdminProductItemViewModelCreator;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.graphql.calls.CommerceMerchantDeactivateInputData;
import com.facebook.graphql.calls.CommerceStoreUpdateInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.viewercontextutils.PageViewerContextLifecycleHelper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cymk_notice_shown */
public class AdminEditShopFragment extends FbFragment implements CanHandleBackPressed {
    public static final String al = AdminEditShopFragment.class.getSimpleName();
    @Inject
    CommerceNavigationUtil f15560a;
    private RecyclerView am;
    private ProgressBar an;
    public DialogBasedProgressIndicator ao;
    private long ap;
    private boolean aq;
    private AdminShopAdapter ar;
    public AdminShopAdapterDataProvider as;
    public final FbEventSubscriberListManager at = new FbEventSubscriberListManager();
    @Inject
    public TasksManager f15561b;
    @Inject
    public AdminEditShopFetcher f15562c;
    @Inject
    AdminShopAdapterProvider f15563d;
    @Inject
    Toaster f15564e;
    @Inject
    CommercePublishingEventBus f15565f;
    @Inject
    ProductItemPendingMutationsCache f15566g;
    @Inject
    PageViewerContextLifecycleHelper f15567h;
    @Inject
    AbstractFbErrorReporter f15568i;

    /* compiled from: cymk_notice_shown */
    public class C21541 extends OnToolbarButtonListener {
        final /* synthetic */ AdminEditShopFragment f15550a;

        public C21541(AdminEditShopFragment adminEditShopFragment) {
            this.f15550a = adminEditShopFragment;
        }

        public final void m16042a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            AdminEditShopFragment.at(this.f15550a);
        }
    }

    /* compiled from: cymk_notice_shown */
    public class C21562 extends ProductItemMutationEventSubscriber {
        final /* synthetic */ AdminEditShopFragment f15553a;

        public C21562(AdminEditShopFragment adminEditShopFragment) {
            this.f15553a = adminEditShopFragment;
        }

        public final void m16043b(FbEvent fbEvent) {
            ProductItemMutationEvent productItemMutationEvent = (ProductItemMutationEvent) fbEvent;
            int i = 0;
            if (productItemMutationEvent.a != Status.FAILED) {
                if (productItemMutationEvent.a == Status.SUCCESS) {
                    switch (C21617.f15559a[productItemMutationEvent.b.ordinal()]) {
                        case 1:
                            i = 2131239284;
                            break;
                        case 2:
                            i = 2131239285;
                            break;
                        case 3:
                            i = 2131239286;
                            break;
                        default:
                            break;
                    }
                }
            }
            i = 2131239287;
            final int i2 = i;
            this.f15553a.o().runOnUiThread(new Runnable(this) {
                final /* synthetic */ C21562 f15552b;

                public void run() {
                    AdminEditShopFragment.m16050a(this.f15552b.f15553a, false, i2);
                }
            });
        }
    }

    /* compiled from: cymk_notice_shown */
    public class C21573 extends AbstractDisposableFutureCallback {
        final /* synthetic */ AdminEditShopFragment f15554a;

        public C21573(AdminEditShopFragment adminEditShopFragment) {
            this.f15554a = adminEditShopFragment;
        }

        protected final void m16044a(Object obj) {
            this.f15554a.ao.b();
            this.f15554a.f15564e.b(new ToastBuilder(2131239301));
            this.f15554a.o().finish();
        }

        protected final void m16045a(Throwable th) {
            this.f15554a.ao.b();
            this.f15554a.f15564e.b(new ToastBuilder(2131234805));
        }
    }

    /* compiled from: cymk_notice_shown */
    public class C21595 implements OnClickListener {
        final /* synthetic */ AdminEditShopFragment f15557a;

        public C21595(AdminEditShopFragment adminEditShopFragment) {
            this.f15557a = adminEditShopFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AdminEditShopFragment adminEditShopFragment = this.f15557a;
            adminEditShopFragment.ao.a();
            TasksManager tasksManager = adminEditShopFragment.f15561b;
            Task task = Task.DELETE_SHOP_MUTATION;
            AdminEditShopFetcher adminEditShopFetcher = adminEditShopFragment.f15562c;
            String h = adminEditShopFragment.as.m16004h();
            Preconditions.checkNotNull(h);
            CommerceMerchantDeactivateInputData commerceMerchantDeactivateInputData = new CommerceMerchantDeactivateInputData();
            commerceMerchantDeactivateInputData.a("commerce_merchant_settings_id", h);
            ListenableFuture a = GraphQLQueryExecutor.a(adminEditShopFetcher.f15523a.a(GraphQLRequest.a((CommerceStoreDeleteMutationString) new CommerceStoreDeleteMutationString().a("input", commerceMerchantDeactivateInputData))));
            Futures.a(a, new C21431(adminEditShopFetcher));
            tasksManager.a(task, a, new C21573(adminEditShopFragment));
        }
    }

    /* compiled from: cymk_notice_shown */
    public class C21606 implements OnClickListener {
        final /* synthetic */ AdminEditShopFragment f15558a;

        public C21606(AdminEditShopFragment adminEditShopFragment) {
            this.f15558a = adminEditShopFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: cymk_notice_shown */
    public /* synthetic */ class C21617 {
        public static final /* synthetic */ int[] f15559a = new int[Method.values().length];

        static {
            try {
                f15559a[Method.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15559a[Method.EDIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15559a[Method.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: cymk_notice_shown */
    public enum Task {
        DELETE_SHOP_MUTATION,
        FETCH_COMMERCE_STORE_QUERY
    }

    public static void m16051a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AdminEditShopFragment) obj).m16048a(CommerceNavigationUtil.a(fbInjector), TasksManager.b(fbInjector), new AdminEditShopFetcher(GraphQLQueryExecutor.a(fbInjector), GraphQLCacheManager.a(fbInjector), CommercePublishingEventBus.a(fbInjector)), (AdminShopAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AdminShopAdapterProvider.class), Toaster.b(fbInjector), CommercePublishingEventBus.a(fbInjector), ProductItemPendingMutationsCache.a(fbInjector), PageViewerContextLifecycleHelper.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
    }

    public final void m16058c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AdminEditShopFragment.class;
        m16051a((Object) this, getContext());
        this.ap = this.s.getLong(AdminShopConstants.f15509a);
        this.aq = this.s.getBoolean("extra_finish_on_launch_view_shop");
        this.as = new AdminShopAdapterDataProvider();
        AdminShopAdapterProvider adminShopAdapterProvider = this.f15563d;
        this.ar = new AdminShopAdapter((Context) adminShopAdapterProvider.getInstance(Context.class), LayoutInflaterMethodAutoProvider.b(adminShopAdapterProvider), ProductItemViewBinder.a(adminShopAdapterProvider), new AdminProductItemViewModelCreator(), this.as);
        this.ar.f15461k = this;
        if (bundle != null) {
            this.as.f15467e = ((Bundle) Preconditions.checkNotNull(bundle.getBundle("admin_shop_adapter_data_provider_state_root"))).getString("admin_shop_adapter_data_provider_state_root.edited_intro_summary");
        }
        this.at.a(new C21562(this));
        this.at.a(this.f15565f);
        this.f15567h.a();
        this.f15567h.a(Long.toString(this.ap));
    }

    public final void m16056a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.am = (RecyclerView) e(2131559427);
        this.am.setAdapter(this.ar);
        this.an = (ProgressBar) e(2131559418);
        this.ao = new DialogBasedProgressIndicator(getContext(), 2131239302);
    }

    public final View m16054a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1843722541);
        View inflate = layoutInflater.inflate(2130903182, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1180554590, a);
        return inflate;
    }

    public final void m16053I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 48965567);
        this.at.b(this.f15565f);
        this.f15567h.b();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1994379190, a);
    }

    public final boolean O_() {
        au();
        return false;
    }

    private void m16048a(CommerceNavigationUtil commerceNavigationUtil, TasksManager tasksManager, AdminEditShopFetcher adminEditShopFetcher, AdminShopAdapterProvider adminShopAdapterProvider, Toaster toaster, CommercePublishingEventBus commercePublishingEventBus, ProductItemPendingMutationsCache productItemPendingMutationsCache, PageViewerContextLifecycleHelper pageViewerContextLifecycleHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f15560a = commerceNavigationUtil;
        this.f15561b = tasksManager;
        this.f15562c = adminEditShopFetcher;
        this.f15563d = adminShopAdapterProvider;
        this.f15564e = toaster;
        this.f15565f = commercePublishingEventBus;
        this.f15566g = productItemPendingMutationsCache;
        this.f15567h = pageViewerContextLifecycleHelper;
        this.f15568i = abstractFbErrorReporter;
    }

    public static void at(AdminEditShopFragment adminEditShopFragment) {
        adminEditShopFragment.au();
        if (adminEditShopFragment.aq) {
            adminEditShopFragment.o().finish();
        } else {
            adminEditShopFragment.f15560a.a(Long.toString(adminEditShopFragment.ap), null, true);
        }
    }

    private void au() {
        if (this.as.m16002f()) {
            String k;
            AdminEditShopFetcher adminEditShopFetcher = this.f15562c;
            AdminShopAdapterDataProvider adminShopAdapterDataProvider = this.as;
            if (adminShopAdapterDataProvider.f15463a != null) {
                k = adminShopAdapterDataProvider.f15463a.k();
            } else {
                k = null;
            }
            String str = k;
            String e = this.as.m16001e();
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(e);
            CommerceStoreUpdateInputData commerceStoreUpdateInputData = new CommerceStoreUpdateInputData();
            commerceStoreUpdateInputData.a("id", str);
            GraphQlCallInput graphQlCallInput = commerceStoreUpdateInputData;
            graphQlCallInput.a("intro_summary", e);
            Futures.a(GraphQLQueryExecutor.a(adminEditShopFetcher.f15523a.a(GraphQLRequest.a((CommerceStoreUpdateMutationString) new CommerceStoreUpdateMutationString().a("input", graphQlCallInput).a("scale", GraphQlQueryDefaults.a()).a("COMMERCE_SMALL_IMAGE_SIZE", Integer.valueOf(50)).a("COMMERCE_MEDIUM_IMAGE_SIZE", Integer.valueOf(230))))), new C21442(adminEditShopFetcher));
            this.f15564e.a(new ToastBuilder(2131239279));
        }
    }

    private boolean aw() {
        if (this.f15567h.f != null) {
            return true;
        }
        this.f15568i.b(AdminEditShopFragment.class.getSimpleName(), "No Page ViewerContext available.");
        return false;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1920132572);
        super.mi_();
        m16052b(this, true);
        m16050a(this, true, 0);
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131234806);
            Builder a2 = TitleBarButtonSpec.a();
            a2.g = b(2131239295);
            hasTitleBar.a(a2.a());
            hasTitleBar.a(new C21541(this));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1079235624, a);
    }

    public final void m16059e(Bundle bundle) {
        super.e(bundle);
        AdminShopAdapterDataProvider adminShopAdapterDataProvider = this.as;
        Bundle bundle2 = new Bundle();
        bundle2.putString("admin_shop_adapter_data_provider_state_root.edited_intro_summary", adminShopAdapterDataProvider.f15467e);
        bundle.putBundle("admin_shop_adapter_data_provider_state_root", bundle2);
    }

    public static void m16049a(AdminEditShopFragment adminEditShopFragment, boolean z) {
        int i;
        int i2 = 8;
        ProgressBar progressBar = adminEditShopFragment.an;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        progressBar.setVisibility(i);
        RecyclerView recyclerView = adminEditShopFragment.am;
        if (!z) {
            i2 = 0;
        }
        recyclerView.setVisibility(i2);
    }

    public static void m16050a(AdminEditShopFragment adminEditShopFragment, boolean z, final int i) {
        m16049a(adminEditShopFragment, z);
        TasksManager tasksManager = adminEditShopFragment.f15561b;
        Task task = Task.FETCH_COMMERCE_STORE_QUERY;
        AdminEditShopFetcher adminEditShopFetcher = adminEditShopFragment.f15562c;
        GraphQLRequest a = GraphQLRequest.a((FetchCommerceStoreQueryString) new FetchCommerceStoreQueryString().a("page_id", String.valueOf(adminEditShopFragment.ap)).a("scale", GraphQlQueryDefaults.a()).a("COMMERCE_MEDIUM_IMAGE_SIZE", Integer.valueOf(230)).a("COMMERCE_SMALL_IMAGE_SIZE", Integer.valueOf(50)));
        a.a(RequestPriority.INTERACTIVE);
        tasksManager.a(task, GraphQLQueryExecutor.a(adminEditShopFetcher.f15523a.a(a)), new AbstractDisposableFutureCallback<FetchCommerceStoreQueryModel>(adminEditShopFragment) {
            final /* synthetic */ AdminEditShopFragment f15556b;

            protected final void m16046a(Object obj) {
                FetchCommerceStoreQueryModel fetchCommerceStoreQueryModel = (FetchCommerceStoreQueryModel) obj;
                AdminEditShopFragment.m16049a(this.f15556b, false);
                AdminEditShopFragment.m16052b(this.f15556b, false);
                AdminShopAdapterDataProvider adminShopAdapterDataProvider = this.f15556b.as;
                adminShopAdapterDataProvider.f15463a = fetchCommerceStoreQueryModel.a();
                if (adminShopAdapterDataProvider.f15466d != null) {
                    adminShopAdapterDataProvider.f15466d.notifyDataSetChanged();
                }
                if (this.f15556b.y && i != 0) {
                    this.f15556b.f15564e.a(new ToastBuilder(i));
                }
            }

            protected final void m16047a(Throwable th) {
                BLog.a(AdminEditShopFragment.al, "fail to fetch commerce store query", th);
                AdminEditShopFragment.m16049a(this.f15556b, false);
            }
        });
    }

    public static void m16052b(AdminEditShopFragment adminEditShopFragment, boolean z) {
        AdminShopAdapterDataProvider adminShopAdapterDataProvider = adminEditShopFragment.as;
        ImmutableList a = adminEditShopFragment.f15566g.a();
        ImmutableMap b = adminEditShopFragment.f15566g.b();
        adminShopAdapterDataProvider.f15464b = a;
        adminShopAdapterDataProvider.f15465c = b;
        if (z && adminShopAdapterDataProvider.f15466d != null) {
            adminShopAdapterDataProvider.f15466d.notifyDataSetChanged();
        }
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -534174959);
        super.mj_();
        this.f15561b.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -261293347, a);
    }

    public final void m16055a() {
        if (aw()) {
            this.f15560a.a(this.ap, this.as.m15998b(), this.as.m16000c(), this.f15567h.f, this.as.m16003g());
        }
    }

    public final void m16057a(AdminCommerceProductItem adminCommerceProductItem) {
        if (aw()) {
            this.f15560a.a(this.ap, this.as.m15998b(), adminCommerceProductItem, this.as.m16000c(), this.f15567h.f);
        }
    }
}
