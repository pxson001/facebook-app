package com.facebook.pages.launchpoint.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilder;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilderProvider;
import com.facebook.controller.connectioncontroller.adapters.RecyclerViewConnectionAdapter;
import com.facebook.controller.connectioncontroller.adapters.RecyclerViewConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionCachePolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionCacheRetainingPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionFetchOperation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.ListViewConnectionListener;
import com.facebook.controller.connectioncontroller.common.SimpleConnectionConfiguration;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.device.ScreenUtil;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.launchpoint.adapters.PagesLaunchpointDiscoverFragmentAdapter;
import com.facebook.pages.launchpoint.adapters.PagesLaunchpointDiscoverFragmentAdapterProvider;
import com.facebook.pages.launchpoint.analytics.PagesLaunchpointFunnelActions;
import com.facebook.pages.launchpoint.graphql.FetchPagesLaunchpointDiscoverGraphQL.FetchPagesLaunchpointDiscoverQueryString;
import com.facebook.pages.launchpoint.graphql.FetchPagesLaunchpointDiscoverGraphQLModels.FetchPagesLaunchpointDiscoverQueryModel;
import com.facebook.pages.launchpoint.graphql.FetchPagesLaunchpointDiscoverGraphQLModels.FetchPagesLaunchpointDiscoverQueryModel.PagesYouMayLikeModel;
import com.facebook.pages.launchpoint.graphql.FetchPagesLaunchpointDiscoverGraphQLModels.FetchPagesLaunchpointDiscoverQueryModel.PagesYouMayLikeModel.NodesModel;
import com.facebook.pages.launchpoint.qe.ExperimentsForPagesLaunchpointModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterGridLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.GridSpacingItemDecoration;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_event_card_subscribe_calendar_nux */
public class PagesLaunchpointDiscoverFragment extends FbFragment {
    @Inject
    ConnectionControllerBuilderProvider f4326a;
    public SwipeRefreshLayout al;
    public PagesLaunchpointDiscoverFragmentAdapter am;
    public ConnectionController<NodesModel, Void> an;
    public boolean ao;
    public String ap;
    @Inject
    ScreenUtil f4327b;
    @Inject
    PagesLaunchpointDiscoverFragmentAdapterProvider f4328c;
    @Inject
    FunnelLoggerImpl f4329d;
    @Inject
    QuickPerformanceLogger f4330e;
    @Inject
    QeAccessor f4331f;
    private BetterGridLayoutManager f4332g;
    public LoadingIndicatorView f4333h;
    public BetterRecyclerView f4334i;

    /* compiled from: page_event_card_subscribe_calendar_nux */
    class C06041 implements OnRefreshListener {
        final /* synthetic */ PagesLaunchpointDiscoverFragment f4318a;

        C06041(PagesLaunchpointDiscoverFragment pagesLaunchpointDiscoverFragment) {
            this.f4318a = pagesLaunchpointDiscoverFragment;
        }

        public final void m5252a() {
            this.f4318a.an.a(this.f4318a.an.d().a(), ConnectionOrder.FIRST, 10, null);
        }
    }

    /* compiled from: page_event_card_subscribe_calendar_nux */
    class C06052 extends OnScrollListener {
        final /* synthetic */ PagesLaunchpointDiscoverFragment f4319a;

        C06052(PagesLaunchpointDiscoverFragment pagesLaunchpointDiscoverFragment) {
            this.f4319a = pagesLaunchpointDiscoverFragment;
        }

        public final void m5253a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (this.f4319a.an.d().c().d && this.f4319a.f4334i.getLastVisiblePosition() >= (this.f4319a.am.aZ_() - 1) - 2) {
                this.f4319a.an.b(10, null);
            }
        }
    }

    /* compiled from: page_event_card_subscribe_calendar_nux */
    class C06063 implements OnDrawListener {
        final /* synthetic */ PagesLaunchpointDiscoverFragment f4320a;

        C06063(PagesLaunchpointDiscoverFragment pagesLaunchpointDiscoverFragment) {
            this.f4320a = pagesLaunchpointDiscoverFragment;
        }

        public final boolean gD_() {
            if (this.f4320a.f4334i.getLayoutManager().v() <= 0) {
                return false;
            }
            this.f4320a.f4330e.b(1245315, (short) 2);
            this.f4320a.ao = true;
            return true;
        }
    }

    /* compiled from: page_event_card_subscribe_calendar_nux */
    class ConnectionConfiguration implements SimpleConnectionConfiguration<NodesModel, Void, FetchPagesLaunchpointDiscoverQueryModel> {
        private ScreenUtil f4321a;

        public final TypedGraphQlQueryString m5255a(ConnectionFetchOperation connectionFetchOperation, Object obj) {
            return (TypedGraphQlQueryString) new FetchPagesLaunchpointDiscoverQueryString().a("count", Integer.valueOf(connectionFetchOperation.e)).a("profile_pic_size", Integer.valueOf(this.f4321a.c() / 2)).a("cursor", connectionFetchOperation.d);
        }

        public ConnectionConfiguration(ScreenUtil screenUtil) {
            this.f4321a = screenUtil;
        }

        public final ConnectionPage<NodesModel> m5254a(GraphQLResult<FetchPagesLaunchpointDiscoverQueryModel> graphQLResult) {
            PagesYouMayLikeModel a = ((FetchPagesLaunchpointDiscoverQueryModel) graphQLResult.e).m5342a();
            return new ConnectionPage(a.m5337a(), a.m5338j());
        }
    }

    /* compiled from: page_event_card_subscribe_calendar_nux */
    class PagesLaunchpointDiscoverConnectionListener extends RecyclerViewConnectionListener<NodesModel> {
        final /* synthetic */ PagesLaunchpointDiscoverFragment f4322a;

        public final void m5256a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            if (connectionLocation.c != LocationType.INITIAL) {
                return;
            }
            if (this.f4322a.an.d().d() == 0) {
                this.f4322a.f4333h.a();
                this.f4322a.f4333h.setVisibility(0);
                return;
            }
            this.f4322a.al.setRefreshing(true);
        }

        public PagesLaunchpointDiscoverConnectionListener(PagesLaunchpointDiscoverFragment pagesLaunchpointDiscoverFragment) {
            this.f4322a = pagesLaunchpointDiscoverFragment;
        }

        public final void m5259b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f4322a.f4333h.setVisibility(8);
            this.f4322a.f4333h.b();
            if (this.f4322a.al != null) {
                this.f4322a.al.setRefreshing(false);
            }
        }

        public final void m5257a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
            this.f4322a.f4333h.setVisibility(8);
            this.f4322a.f4333h.b();
            if (this.f4322a.al != null) {
                this.f4322a.al.setRefreshing(false);
            }
        }

        protected final RecyclerViewConnectionAdapter<NodesModel> m5258b() {
            return this.f4322a.am;
        }

        protected final ConnectionController<NodesModel, ?> m5260c() {
            return this.f4322a.an;
        }
    }

    /* compiled from: page_event_card_subscribe_calendar_nux */
    class PagesLaunchpointFunnelListener extends ListViewConnectionListener<NodesModel> {
        final /* synthetic */ PagesLaunchpointDiscoverFragment f4323a;

        public PagesLaunchpointFunnelListener(PagesLaunchpointDiscoverFragment pagesLaunchpointDiscoverFragment) {
            this.f4323a = pagesLaunchpointDiscoverFragment;
        }

        public final void m5261a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f4323a.f4329d.a(FunnelRegistry.M, PagesLaunchpointFunnelActions.f4315i, connectionLocation.c.toString());
        }

        public final void m5264b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f4323a.f4329d.a(FunnelRegistry.M, PagesLaunchpointFunnelActions.f4316j, connectionLocation.c.toString());
        }

        public final void m5262a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
            this.f4323a.f4329d.a(FunnelRegistry.M, PagesLaunchpointFunnelActions.f4317k, connectionLocation.c.toString());
        }

        protected final void m5263a(boolean z) {
        }
    }

    /* compiled from: page_event_card_subscribe_calendar_nux */
    class PagesLaunchpointScrollLoadListener extends ListViewConnectionListener<NodesModel> {
        final /* synthetic */ PagesLaunchpointDiscoverFragment f4324a;

        public PagesLaunchpointScrollLoadListener(PagesLaunchpointDiscoverFragment pagesLaunchpointDiscoverFragment) {
            this.f4324a = pagesLaunchpointDiscoverFragment;
        }

        public final void m5265a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            int hashCode = Objects.hashCode(new Object[]{connectionLocation, connectionOrder});
            this.f4324a.f4330e.e(1245316, hashCode);
            this.f4324a.f4330e.b(1245316, hashCode, this.f4324a.ap);
            this.f4324a.f4330e.b(1245316, hashCode, connectionLocation.c.toString());
        }

        public final void m5268b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f4324a.f4330e.b(1245316, Objects.hashCode(new Object[]{connectionLocation, connectionOrder}), (short) 2);
        }

        public final void m5266a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
            this.f4324a.f4330e.b(1245316, Objects.hashCode(new Object[]{connectionLocation, connectionOrder}), (short) 97);
        }

        protected final void m5267a(boolean z) {
        }
    }

    /* compiled from: page_event_card_subscribe_calendar_nux */
    class PagesLaunchpointTTIListener extends ListViewConnectionListener<NodesModel> {
        final /* synthetic */ PagesLaunchpointDiscoverFragment f4325a;

        public PagesLaunchpointTTIListener(PagesLaunchpointDiscoverFragment pagesLaunchpointDiscoverFragment) {
            this.f4325a = pagesLaunchpointDiscoverFragment;
        }

        public final void m5269a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            if (!this.f4325a.ao) {
                this.f4325a.f4330e.a(1245315, (short) 102);
            }
        }

        public final void m5272b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        }

        public final void m5270a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
            if (!this.f4325a.ao) {
                this.f4325a.f4330e.b(1245315, (short) 97);
                this.f4325a.ao = true;
            }
        }

        protected final void m5271a(boolean z) {
        }
    }

    public static void m5274a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesLaunchpointDiscoverFragment) obj).m5273a((ConnectionControllerBuilderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ConnectionControllerBuilderProvider.class), ScreenUtil.a(fbInjector), (PagesLaunchpointDiscoverFragmentAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PagesLaunchpointDiscoverFragmentAdapterProvider.class), FunnelLoggerImpl.a(fbInjector), QuickPerformanceLoggerMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m5273a(ConnectionControllerBuilderProvider connectionControllerBuilderProvider, ScreenUtil screenUtil, PagesLaunchpointDiscoverFragmentAdapterProvider pagesLaunchpointDiscoverFragmentAdapterProvider, FunnelLoggerImpl funnelLoggerImpl, QuickPerformanceLogger quickPerformanceLogger, QeAccessor qeAccessor) {
        this.f4326a = connectionControllerBuilderProvider;
        this.f4327b = screenUtil;
        this.f4328c = pagesLaunchpointDiscoverFragmentAdapterProvider;
        this.f4329d = funnelLoggerImpl;
        this.f4330e = quickPerformanceLogger;
        this.f4331f = qeAccessor;
    }

    public final void m5277c(Bundle bundle) {
        super.c(bundle);
        Class cls = PagesLaunchpointDiscoverFragment.class;
        m5274a((Object) this, getContext());
        this.ao = false;
        this.ap = this.f4331f.a(ExperimentsForPagesLaunchpointModule.f4361a, "memory");
        this.f4330e.b(1245315);
        this.f4330e.a(1245315, this.ap);
        this.f4329d.a(FunnelRegistry.M);
        this.f4329d.a(FunnelRegistry.M, this.ap);
        ConnectionCachePolicy connectionCachePolicy = this.ap.equals("memory") ? ConnectionCachePolicy.MEMORY_ONLY : ConnectionCachePolicy.MEMORY_DISK;
        ConnectionControllerBuilder a = this.f4326a.a("/page/discover/", new ConnectionConfiguration(this.f4327b));
        a.f = connectionCachePolicy;
        ConnectionControllerBuilder connectionControllerBuilder = a;
        connectionControllerBuilder.h = ConnectionCacheRetainingPolicy.a;
        this.an = connectionControllerBuilder.a();
        this.an.a(new PagesLaunchpointDiscoverConnectionListener(this));
        this.an.a(new PagesLaunchpointFunnelListener(this));
        this.an.a(new PagesLaunchpointTTIListener(this));
        this.an.a(new PagesLaunchpointScrollLoadListener(this));
    }

    public final View m5275a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1680178301);
        View inflate = layoutInflater.inflate(2130906114, viewGroup, false);
        this.al = (FbSwipeRefreshLayout) inflate.findViewById(2131561342);
        this.al.e = new C06041(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -23305132, a);
        return inflate;
    }

    public final void m5276a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f4334i = (BetterRecyclerView) e(2131565715);
        this.f4332g = new BetterGridLayoutManager(getContext(), 2);
        this.f4334i.setLayoutManager(this.f4332g);
        PagesLaunchpointDiscoverFragmentAdapterProvider pagesLaunchpointDiscoverFragmentAdapterProvider = this.f4328c;
        this.am = new PagesLaunchpointDiscoverFragmentAdapter(FbUriIntentHandler.a(pagesLaunchpointDiscoverFragmentAdapterProvider), NumberTruncationUtil.a(pagesLaunchpointDiscoverFragmentAdapterProvider), FunnelLoggerImpl.a(pagesLaunchpointDiscoverFragmentAdapterProvider), RawLikeHelper.b(pagesLaunchpointDiscoverFragmentAdapterProvider), getContext());
        this.f4334i.setAdapter(this.am);
        this.f4334i.a(new GridSpacingItemDecoration(jW_().getDimensionPixelSize(2131427416)));
        this.f4333h = (LoadingIndicatorView) e(2131565716);
        this.f4334i.setOnScrollListener(new C06052(this));
        this.f4334i.a(new C06063(this));
        this.f4330e.a(1245315, (short) 24);
        this.an.b(10, null);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 174925111);
        super.mY_();
        if (this.al != null) {
            this.al.e = null;
            this.al = null;
        }
        this.an.b();
        this.f4329d.b(FunnelRegistry.M);
        this.f4330e.d(1245315);
        this.f4330e.e(1245316);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1513731128, a);
    }

    public final void m5278g(boolean z) {
        if (this.f4329d != null) {
            if (z) {
                this.f4329d.b(FunnelRegistry.M, PagesLaunchpointFunnelActions.f4313g);
            } else {
                this.f4329d.b(FunnelRegistry.M, PagesLaunchpointFunnelActions.f4314h);
            }
        }
        super.g(z);
    }
}
