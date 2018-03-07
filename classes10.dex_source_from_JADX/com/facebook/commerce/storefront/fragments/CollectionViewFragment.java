package com.facebook.commerce.storefront.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.IRefreshableFragment;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceModule;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.commerce.core.analytics.CommerceAnalyticsEventBuilder;
import com.facebook.commerce.core.analytics.CommerceLogger;
import com.facebook.commerce.core.analytics.CommerceLoggerProvider;
import com.facebook.commerce.core.analytics.CommercePerfLogger;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.adapters.CollectionViewCollectionAdapter;
import com.facebook.commerce.storefront.adapters.CollectionViewCollectionAdapterProvider;
import com.facebook.commerce.storefront.fetcher.StorefrontCollectionGraphQLFetcher;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel.CollectionProductItemsModel;
import com.facebook.commerce.storefront.ui.CollectionViewItemDecoration;
import com.facebook.commerce.storefront.util.CollectionViewHeaderUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Defaults;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: create conversation shortcut */
public class CollectionViewFragment extends FbFragment implements IRefreshableFragment {
    @Inject
    CommercePerfLogger f15717a;
    @Inject
    CollectionViewCollectionAdapterProvider al;
    private long am;
    public HasTitleBar an;
    private LoadingIndicatorView ao;
    private RecyclerView ap;
    private CollectionViewCollectionAdapter aq;
    private int ar;
    private CommerceLogger as;
    private final int at = 2;
    private boolean au;
    @Nullable
    public MerchantInfoViewData av;
    @Nullable
    public FetchStorefrontCollectionQueryModel aw;
    @Nullable
    public String ax;
    @Inject
    public FbTitleBarSupplier f15718b;
    @Inject
    AbstractFbErrorReporter f15719c;
    @Inject
    StorefrontCollectionGraphQLFetcher f15720d;
    @Inject
    SecureContextHelper f15721e;
    @Inject
    AnalyticsLogger f15722f;
    @Inject
    CommerceLoggerProvider f15723g;
    @Inject
    Clock f15724h;
    @Inject
    CommerceNavigationUtil f15725i;

    /* compiled from: create conversation shortcut */
    public class C21861 extends SpanSizeLookup {
        final /* synthetic */ CollectionViewFragment f15712b;

        public C21861(CollectionViewFragment collectionViewFragment) {
            this.f15712b = collectionViewFragment;
        }

        public final int m16156a(int i) {
            if (i == 0 && CollectionViewHeaderUtil.m16289a(this.f15712b.av)) {
                return 2;
            }
            return 1;
        }
    }

    public static void m16164a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CollectionViewFragment) obj).m16162a(CommercePerfLogger.a(injectorLike), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StorefrontCollectionGraphQLFetcher.m16149b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (CommerceLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommerceLoggerProvider.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), CommerceNavigationUtil.a(injectorLike), (CollectionViewCollectionAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollectionViewCollectionAdapterProvider.class));
    }

    private void m16162a(CommercePerfLogger commercePerfLogger, FbTitleBarSupplier fbTitleBarSupplier, AbstractFbErrorReporter abstractFbErrorReporter, StorefrontCollectionGraphQLFetcher storefrontCollectionGraphQLFetcher, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, CommerceLoggerProvider commerceLoggerProvider, Clock clock, CommerceNavigationUtil commerceNavigationUtil, CollectionViewCollectionAdapterProvider collectionViewCollectionAdapterProvider) {
        this.f15717a = commercePerfLogger;
        this.f15718b = fbTitleBarSupplier;
        this.f15719c = abstractFbErrorReporter;
        this.f15720d = storefrontCollectionGraphQLFetcher;
        this.f15721e = secureContextHelper;
        this.f15722f = analyticsLogger;
        this.f15723g = commerceLoggerProvider;
        this.f15724h = clock;
        this.f15725i = commerceNavigationUtil;
        this.al = collectionViewCollectionAdapterProvider;
    }

    public static CollectionViewFragment m16161a(long j, boolean z, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("collection_id", j);
        bundle.putBoolean("is_adunit", z);
        bundle.putString("merchant_page_id", str);
        CollectionViewFragment collectionViewFragment = new CollectionViewFragment();
        collectionViewFragment.g(bundle);
        return collectionViewFragment;
    }

    public final void m16166c(Bundle bundle) {
        super.c(bundle);
        Class cls = CollectionViewFragment.class;
        m16164a((Object) this, getContext());
        this.f15717a.a.b(7077889);
        Bundle bundle2 = this.s;
        this.am = bundle2.getLong("collection_id");
        this.au = bundle2.getBoolean("is_adunit");
        this.ax = bundle2.getString("merchant_page_id");
        Preconditions.checkArgument(this.am > 0, "Invalid collection id: " + this.am);
    }

    public final void m16167e() {
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -953406961);
        super.mi_();
        ((FbTitleBar) this.f15718b.get()).setTitle(b(2131234809));
        this.an = (HasTitleBar) a(HasTitleBar.class);
        if (this.an != null) {
            this.an.c(true);
        }
        this.as.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1868721053, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1253644221);
        super.mj_();
        this.as.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1534725559, a);
    }

    public final View m16165a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long longValue;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1302804611);
        View inflate = layoutInflater.inflate(2130903608, viewGroup, false);
        if (StringUtil.a(this.ax)) {
            longValue = ((Long) Defaults.DEFAULTS.get(Preconditions.checkNotNull(Long.TYPE))).longValue();
        } else {
            longValue = Long.parseLong(this.ax);
        }
        this.as = this.f15723g.a(CommerceEvent.VIEW_PRODUCT_COLLECTION, CommerceModule.COMMERCE_STOREFRONT, this.au ? CommerceRefType.SHARE : CommerceRefType.PAGE, Long.valueOf(longValue));
        this.as.k = String.valueOf(Long.valueOf(this.am));
        this.ao = (LoadingIndicatorView) inflate.findViewById(2131560407);
        this.ao.a();
        this.ao.setVisibility(0);
        this.ap = (RecyclerView) inflate.findViewById(2131560408);
        ar();
        LogUtils.f(-1552361715, a);
        return inflate;
    }

    private void ar() {
        final long a = this.f15724h.a();
        this.f15720d.m16153a(this.ax, this.am, new AbstractDisposableFutureCallback<MerchantInfoViewData>(this) {
            final /* synthetic */ CollectionViewFragment f15714b;

            protected final void m16157a(Object obj) {
                MerchantInfoViewData merchantInfoViewData = (MerchantInfoViewData) obj;
                if (merchantInfoViewData == null) {
                    m16158a(new IllegalStateException("Null or empty merchant query response from server"));
                }
                this.f15714b.av = merchantInfoViewData;
                CollectionViewFragment.m16163a(this.f15714b, a);
            }

            protected final void m16158a(Throwable th) {
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchStorefrontCollectionQueryModel>>(this) {
            final /* synthetic */ CollectionViewFragment f15716b;

            protected final void m16159a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null) {
                    m16160a(new IllegalStateException("Null or empty collection query response from server"));
                    return;
                }
                this.f15716b.aw = (FetchStorefrontCollectionQueryModel) graphQLResult.e;
                CollectionViewFragment.m16163a(this.f15716b, a);
                CommercePerfLogger commercePerfLogger = this.f15716b.f15717a;
                if (commercePerfLogger.a.f(7077889)) {
                    commercePerfLogger.a.b(7077889, (short) 2);
                }
            }

            protected final void m16160a(Throwable th) {
            }
        });
    }

    public static void m16163a(CollectionViewFragment collectionViewFragment, long j) {
        Object obj;
        Object obj2;
        Object obj3 = 1;
        if (collectionViewFragment.ax == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (collectionViewFragment.av == null) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj != obj2 || collectionViewFragment.aw == null) {
            obj3 = null;
        }
        if (obj3 != null) {
            collectionViewFragment.f15722f.a(CommerceAnalyticsEventBuilder.a(collectionViewFragment.am, collectionViewFragment.aw.m16226a().m16220a().size(), collectionViewFragment.f15724h.a() - j, collectionViewFragment.au));
            collectionViewFragment.as();
        }
    }

    private void as() {
        this.aq = this.al.m16119a(getContext(), this.am, this.au, this.av);
        this.ap.setAdapter(this.aq);
        RecyclerView recyclerView = this.ap;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, 1, false);
        gridLayoutManager.h = new C21861(this);
        recyclerView.setLayoutManager(gridLayoutManager);
        this.ar = 0;
        if (CollectionViewHeaderUtil.m16289a(this.av)) {
            this.ar = 1;
        }
        this.ap.a(new CollectionViewItemDecoration(this.ar, 2));
        CollectionViewCollectionAdapter collectionViewCollectionAdapter = this.aq;
        CollectionProductItemsModel a = this.aw.m16226a();
        collectionViewCollectionAdapter.f15658j = a;
        collectionViewCollectionAdapter.f15659k = a.m16220a().size();
        collectionViewCollectionAdapter.notifyDataSetChanged();
        this.ao.b();
        this.ao.setVisibility(8);
    }
}
