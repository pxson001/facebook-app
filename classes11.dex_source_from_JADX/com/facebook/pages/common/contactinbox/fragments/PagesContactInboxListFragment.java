package com.facebook.pages.common.contactinbox.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPageLeadGenInfoState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQL.PagesContactInboxGraphQLString;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PageContactUsLeadFieldsModel;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PagesContactInboxGraphQLModel.AdminInfoModel.PageContactUsLeadsModel;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxCache;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxTimeUtils;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.ui.PagesEmptyView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.DividerDecorator;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: step_fail */
public class PagesContactInboxListFragment extends PagesContactInboxBaseFragment {
    @Inject
    TasksManager f1390a;
    public SwipeRefreshLayout al;
    public BetterLinearLayoutManager am;
    public View an;
    public PagesEmptyView ao;
    public PagesContactInboxRequestsAdapter ap;
    private boolean aq = true;
    public boolean ar = false;
    public String as;
    public boolean at = false;
    private final OnClickListener au = new C01851(this);
    public final OnScrollListener av = new C01862(this);
    @Inject
    GraphQLQueryExecutor f1391b;
    @Inject
    PagesContactInboxRequestsAdapterProvider f1392c;
    @Inject
    Lazy<PagesAnalytics> f1393d;
    @Inject
    Lazy<PagesContactInboxTimeUtils> f1394e;
    @Inject
    PagesContactInboxCache f1395f;
    public long f1396g;
    public String f1397h;
    public BetterRecyclerView f1398i;

    /* compiled from: step_fail */
    class C01851 implements OnClickListener {
        final /* synthetic */ PagesContactInboxListFragment f1384a;

        C01851(PagesContactInboxListFragment pagesContactInboxListFragment) {
            this.f1384a = pagesContactInboxListFragment;
        }

        public void onClick(View view) {
            boolean z = false;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -588519817);
            PagesContactInboxRequestsAdapter pagesContactInboxRequestsAdapter = this.f1384a.ap;
            BetterRecyclerView betterRecyclerView = this.f1384a.f1398i;
            PageContactUsLeadFieldsModel e = pagesContactInboxRequestsAdapter.m2050e(RecyclerView.d(view));
            if (e != null) {
                PagesAnalytics pagesAnalytics = (PagesAnalytics) this.f1384a.f1393d.get();
                long j = this.f1384a.f1396g;
                boolean z2 = e.m2071p() == GraphQLPageLeadGenInfoState.UNREAD;
                if (e.m2071p() == GraphQLPageLeadGenInfoState.RESPONDED) {
                    z = true;
                }
                pagesAnalytics.a(j, z2, z, (int) ((PagesContactInboxTimeUtils) this.f1384a.f1394e.get()).m2136a(e.m2068m() * 1000), e.m2070o());
                this.f1384a.m2018a(this.f1384a, PagesContactInboxRequestDetailFragment.m2037a(e, String.valueOf(this.f1384a.f1396g), this.f1384a.f1397h));
            }
            LogUtils.a(1249925177, a);
        }
    }

    /* compiled from: step_fail */
    class C01862 extends OnScrollListener {
        final /* synthetic */ PagesContactInboxListFragment f1385a;

        C01862(PagesContactInboxListFragment pagesContactInboxListFragment) {
            this.f1385a = pagesContactInboxListFragment;
        }

        public final void m2019a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            boolean z = this.f1385a.am.D() - this.f1385a.am.n() < 3;
            if (!this.f1385a.at && z) {
                this.f1385a.at = true;
                this.f1385a.an.setVisibility(0);
                PagesContactInboxListFragment.m2023a(this.f1385a, false);
            }
        }
    }

    /* compiled from: step_fail */
    class C01873 implements OnRefreshListener {
        final /* synthetic */ PagesContactInboxListFragment f1386a;

        C01873(PagesContactInboxListFragment pagesContactInboxListFragment) {
            this.f1386a = pagesContactInboxListFragment;
        }

        public final void m2020a() {
            PagesContactInboxListFragment.m2026b(this.f1386a);
        }
    }

    /* compiled from: step_fail */
    class C01884 implements Callable<ListenableFuture<GraphQLResult<PagesContactInboxGraphQLModel>>> {
        final /* synthetic */ PagesContactInboxListFragment f1387a;

        C01884(PagesContactInboxListFragment pagesContactInboxListFragment) {
            this.f1387a = pagesContactInboxListFragment;
        }

        public Object call() {
            GraphQLQueryExecutor graphQLQueryExecutor = this.f1387a.f1391b;
            PagesContactInboxListFragment pagesContactInboxListFragment = this.f1387a;
            GraphQlQueryString pagesContactInboxGraphQLString = new PagesContactInboxGraphQLString();
            pagesContactInboxGraphQLString.a("page_id", Long.valueOf(pagesContactInboxListFragment.f1396g));
            pagesContactInboxGraphQLString.a("after_cursor", pagesContactInboxListFragment.as);
            pagesContactInboxGraphQLString.a("first_count", Integer.valueOf(20));
            return graphQLQueryExecutor.a(GraphQLRequest.a(pagesContactInboxGraphQLString));
        }
    }

    public static void m2025a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PagesContactInboxListFragment) obj).m2024a(TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (PagesContactInboxRequestsAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagesContactInboxRequestsAdapterProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 8930), IdBasedLazy.a(injectorLike, 8911), PagesContactInboxCache.m2129a(injectorLike));
    }

    public final void m2031c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PagesContactInboxListFragment.class;
        m2025a((Object) this, getContext());
        this.f1396g = this.s.getLong("arg_page_id");
        Preconditions.checkState(this.f1396g > 0);
    }

    public final View m2029a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 590227664);
        View inflate = layoutInflater.inflate(2130906106, viewGroup, false);
        this.al = (SwipeRefreshLayout) inflate.findViewById(2131565692);
        this.al.e = new C01873(this);
        this.an = inflate.findViewById(2131565690);
        this.ao = (PagesEmptyView) inflate.findViewById(2131565691);
        this.ao.setImageResource(2130837799);
        this.f1398i = (BetterRecyclerView) inflate.findViewById(2131565693);
        this.ap = this.f1392c.m2051a(this.au);
        this.am = new BetterLinearLayoutManager(getContext());
        if (!(this.aq || this.f1395f.f1458a == null)) {
            this.an.setVisibility(8);
            Bundle bundle2 = this.f1395f.f1458a;
            this.am.a(bundle2.getParcelable("state_layout_manager"));
            PagesContactInboxRequestsAdapter pagesContactInboxRequestsAdapter = this.ap;
            List<PageContactUsLeadFieldsModel> b = FlatBufferModelHelper.b(bundle2, "state_item_list");
            pagesContactInboxRequestsAdapter.f1423c.clear();
            for (PageContactUsLeadFieldsModel add : b) {
                pagesContactInboxRequestsAdapter.f1423c.add(add);
            }
            pagesContactInboxRequestsAdapter.notifyDataSetChanged();
            this.f1398i.a(this.av);
        }
        this.f1398i.setAdapter(this.ap);
        this.f1398i.setLayoutManager(this.am);
        this.f1398i.a(new DividerDecorator(jW_().getColor(2131361983), getContext().getResources().getDimensionPixelSize(2131427379)));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1254839641, a);
        return inflate;
    }

    public final void m2030a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.aq) {
            m2026b(this);
            this.f1398i.setVisibility(8);
            this.an.setVisibility(0);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1294287755);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131241666);
            hasTitleBar.kg_();
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1200369314, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1376096138);
        Bundle bundle = new Bundle();
        PagesContactInboxRequestsAdapter pagesContactInboxRequestsAdapter = this.ap;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(pagesContactInboxRequestsAdapter.f1423c);
        FlatBufferModelHelper.a(bundle, "state_item_list", arrayList);
        bundle.putParcelable("state_layout_manager", this.am.f());
        this.f1395f.f1458a = bundle;
        this.aq = false;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1618450094, a);
    }

    public final void m2028I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1848744108);
        this.f1395f.m2133b();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1685145634, a);
    }

    public static void m2026b(PagesContactInboxListFragment pagesContactInboxListFragment) {
        pagesContactInboxListFragment.f1395f.m2133b();
        pagesContactInboxListFragment.ar = false;
        pagesContactInboxListFragment.as = null;
        pagesContactInboxListFragment.at = false;
        m2023a(pagesContactInboxListFragment, true);
    }

    public static void m2027g(PagesContactInboxListFragment pagesContactInboxListFragment, int i) {
        pagesContactInboxListFragment.f1398i.setVisibility(8);
        pagesContactInboxListFragment.ao.setVisibility(0);
        pagesContactInboxListFragment.ao.setMessage(i);
    }

    public static void m2023a(PagesContactInboxListFragment pagesContactInboxListFragment, final boolean z) {
        Object obj;
        if (!z) {
            pagesContactInboxListFragment.an.setVisibility(8);
            if (pagesContactInboxListFragment.ar) {
                pagesContactInboxListFragment.ap.m2049b(true);
            } else {
                return;
            }
        }
        Callable c01884 = new C01884(pagesContactInboxListFragment);
        TasksManager tasksManager = pagesContactInboxListFragment.f1390a;
        if (z) {
            obj = "pages_fetch_contact_inbox_request_messages_list";
        } else {
            obj = "pages_fetch_contact_inbox_more_request_messages";
        }
        tasksManager.a(obj, c01884, new AbstractDisposableFutureCallback<GraphQLResult<PagesContactInboxGraphQLModel>>(pagesContactInboxListFragment) {
            final /* synthetic */ PagesContactInboxListFragment f1389b;

            protected final void m2021a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f1389b.an.setVisibility(8);
                if (graphQLResult == null || graphQLResult.e == null || Strings.isNullOrEmpty(((PagesContactInboxGraphQLModel) graphQLResult.e).m2099j()) || ((PagesContactInboxGraphQLModel) graphQLResult.e).m2096a() == null || ((PagesContactInboxGraphQLModel) graphQLResult.e).m2096a().m2091a() == null || ((PagesContactInboxGraphQLModel) graphQLResult.e).m2096a().m2091a().m2087j() == null) {
                    PagesContactInboxListFragment.ar(this.f1389b);
                    return;
                }
                PageContactUsLeadsModel a = ((PagesContactInboxGraphQLModel) graphQLResult.e).m2096a().m2091a();
                PagesContactInboxListFragment pagesContactInboxListFragment;
                ImmutableList a2;
                PagesContactInboxRequestsAdapter pagesContactInboxRequestsAdapter;
                if (z) {
                    this.f1389b.al.setRefreshing(false);
                    this.f1389b.f1397h = ((PagesContactInboxGraphQLModel) graphQLResult.e).m2099j();
                    if (a.m2086a().isEmpty()) {
                        PagesContactInboxListFragment.m2027g(this.f1389b, 2131241668);
                        return;
                    }
                    pagesContactInboxListFragment = this.f1389b;
                    a2 = a.m2086a();
                    pagesContactInboxListFragment.ao.setVisibility(8);
                    pagesContactInboxListFragment.f1398i.setVisibility(0);
                    pagesContactInboxRequestsAdapter = pagesContactInboxListFragment.ap;
                    if (a2 != null) {
                        pagesContactInboxRequestsAdapter.f1423c.clear();
                        pagesContactInboxRequestsAdapter.f1423c.addAll(a2);
                        pagesContactInboxRequestsAdapter.notifyDataSetChanged();
                    }
                    pagesContactInboxListFragment.f1398i.a(pagesContactInboxListFragment.av);
                } else {
                    pagesContactInboxListFragment = this.f1389b;
                    a2 = a.m2086a();
                    pagesContactInboxRequestsAdapter = pagesContactInboxListFragment.ap;
                    if (a2 != null) {
                        pagesContactInboxRequestsAdapter.f1423c.addAll(a2);
                        pagesContactInboxRequestsAdapter.notifyDataSetChanged();
                    }
                    this.f1389b.ap.m2049b(false);
                }
                this.f1389b.ar = a.m2087j().m2082j();
                this.f1389b.as = a.m2087j().m2080a();
                if (!this.f1389b.ar) {
                    this.f1389b.f1398i.b(this.f1389b.av);
                }
                if (this.f1389b.at) {
                    this.f1389b.at = false;
                }
            }

            protected final void m2022a(Throwable th) {
                PagesContactInboxListFragment.ar(this.f1389b);
            }
        });
    }

    private void m2024a(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, PagesContactInboxRequestsAdapterProvider pagesContactInboxRequestsAdapterProvider, Lazy<PagesAnalytics> lazy, Lazy<PagesContactInboxTimeUtils> lazy2, PagesContactInboxCache pagesContactInboxCache) {
        this.f1390a = tasksManager;
        this.f1391b = graphQLQueryExecutor;
        this.f1392c = pagesContactInboxRequestsAdapterProvider;
        this.f1393d = lazy;
        this.f1394e = lazy2;
        this.f1395f = pagesContactInboxCache;
    }

    public static void ar(PagesContactInboxListFragment pagesContactInboxListFragment) {
        m2027g(pagesContactInboxListFragment, 2131241667);
    }
}
