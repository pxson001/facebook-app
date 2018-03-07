package com.facebook.gametime.ui.plays;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimeSportsPlaysQueryString;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeSportsPlaysQueryModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeSportsPlaysQueryModel.SportsMatchDataModel.FactsModel.EdgesModel;
import com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlaysRootPartDefinition;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: StartParams */
public class GametimePlaysFragment extends FbFragment {
    @Inject
    Context f25326a;
    @Nullable
    public String al;
    public boolean am;
    private boolean an;
    private String ao;
    public GametimePlaysCollection ap;
    public FbSwipeRefreshLayout aq;
    private BetterRecyclerView ar;
    public boolean as;
    private RecyclerViewProxy at;
    @Inject
    GametimePlaysEnvironmentProvider f25327b;
    @Inject
    GraphQLQueryExecutor f25328c;
    @Inject
    Lazy<GametimeSportsPlaysRootPartDefinition> f25329d;
    @Inject
    MultiRowAdapterBuilder f25330e;
    @Inject
    MultipleRowsStoriesRecycleCallback f25331f;
    @Inject
    TasksManager f25332g;
    private MultiRowAdapter f25333h;
    private RequestCallback f25334i;

    /* compiled from: StartParams */
    class C30201 implements OnRefreshListener {
        final /* synthetic */ GametimePlaysFragment f25318a;

        C30201(GametimePlaysFragment gametimePlaysFragment) {
            this.f25318a = gametimePlaysFragment;
        }

        public final void m27224a() {
            this.f25318a.ap.f25315a.clear();
            GametimePlaysFragment.m27233a(this.f25318a, null);
        }
    }

    /* compiled from: StartParams */
    class C30212 implements OnScrollListener {
        final /* synthetic */ GametimePlaysFragment f25319a;

        C30212(GametimePlaysFragment gametimePlaysFragment) {
            this.f25319a = gametimePlaysFragment;
        }

        public final void m27225a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m27226a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            GametimePlaysFragment gametimePlaysFragment = this.f25319a;
            if (!GametimePlaysFragment.m27235b(gametimePlaysFragment).isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 5 > i3 && !gametimePlaysFragment.as && gametimePlaysFragment.am) {
                GametimePlaysFragment.m27233a(gametimePlaysFragment, gametimePlaysFragment.al);
            }
        }
    }

    /* compiled from: StartParams */
    class C30223 implements Runnable {
        final /* synthetic */ GametimePlaysFragment f25320a;

        C30223(GametimePlaysFragment gametimePlaysFragment) {
            this.f25320a = gametimePlaysFragment;
        }

        public void run() {
            GametimePlaysFragment.m27235b(this.f25320a).notifyDataSetChanged();
        }
    }

    /* compiled from: StartParams */
    class RequestCallback extends AbstractDisposableFutureCallback<GraphQLResult<GametimeSportsPlaysQueryModel>> {
        final /* synthetic */ GametimePlaysFragment f25325a;

        public RequestCallback(GametimePlaysFragment gametimePlaysFragment) {
            this.f25325a = gametimePlaysFragment;
        }

        protected final void m27229a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e == null || ((GametimeSportsPlaysQueryModel) graphQLResult.e).m27020j() == null || ((GametimeSportsPlaysQueryModel) graphQLResult.e).m27020j().m27012j() == null) {
                this.f25325a.as = false;
                this.f25325a.aq.setRefreshing(false);
                return;
            }
            Collection arrayList = new ArrayList();
            ImmutableList a = ((GametimeSportsPlaysQueryModel) graphQLResult.e).m27020j().m27012j().m27003a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                if (edgesModel.m26999a() != null) {
                    arrayList.add(edgesModel.m26999a());
                }
            }
            this.f25325a.ap.f25315a.addAll(arrayList);
            DefaultPageInfoFieldsModel j = ((GametimeSportsPlaysQueryModel) graphQLResult.e).m27020j().m27012j().m27004j();
            if (j != null) {
                this.f25325a.am = j.b();
                this.f25325a.al = j.a();
            }
            GametimePlaysFragment.m27235b(this.f25325a).notifyDataSetChanged();
            this.f25325a.as = false;
            this.f25325a.aq.setRefreshing(false);
        }

        protected final void m27231a(CancellationException cancellationException) {
            this.f25325a.as = false;
            this.f25325a.aq.setRefreshing(false);
        }

        protected final void m27230a(Throwable th) {
            this.f25325a.as = false;
            this.f25325a.aq.setRefreshing(false);
        }
    }

    public static void m27234a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GametimePlaysFragment) obj).m27232a((Context) fbInjector.getInstance(Context.class), (GametimePlaysEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GametimePlaysEnvironmentProvider.class), GraphQLQueryExecutor.a(fbInjector), IdBasedLazy.a(fbInjector, 6773), MultiRowAdapterBuilder.b(fbInjector), MultipleRowsStoriesRecycleCallback.a(fbInjector), TasksManager.b(fbInjector));
    }

    private void m27232a(Context context, GametimePlaysEnvironmentProvider gametimePlaysEnvironmentProvider, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<GametimeSportsPlaysRootPartDefinition> lazy, MultiRowAdapterBuilder multiRowAdapterBuilder, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, TasksManager tasksManager) {
        this.f25326a = context;
        this.f25327b = gametimePlaysEnvironmentProvider;
        this.f25328c = graphQLQueryExecutor;
        this.f25329d = lazy;
        this.f25330e = multiRowAdapterBuilder;
        this.f25331f = multipleRowsStoriesRecycleCallback;
        this.f25332g = tasksManager;
    }

    public final void m27238c(Bundle bundle) {
        Class cls = GametimePlaysFragment.class;
        m27234a((Object) this, getContext());
        super.c(bundle);
        this.f25334i = new RequestCallback(this);
        this.al = null;
        this.am = false;
        this.an = this.s.getBoolean("scoring_plays");
        this.ao = this.s.getString("page_id");
        this.ap = new GametimePlaysCollection();
        this.as = false;
    }

    public final View m27237a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -68744515);
        View inflate = LayoutInflater.from(getContext()).inflate(2130904576, viewGroup, false);
        this.ar = (BetterRecyclerView) FindViewUtil.b(inflate, 16908298);
        this.ar.setLayoutManager(new BetterLinearLayoutManager(getContext()));
        this.aq = (FbSwipeRefreshLayout) FindViewUtil.b(inflate, 2131562498);
        this.aq.e = new C30201(this);
        this.at = new RecyclerViewProxy(this.ar);
        this.at.b(false);
        this.at.d(true);
        this.at.f(FindViewUtil.b(inflate, 16908292));
        this.at.a(new C30212(this));
        this.at.a(m27235b(this));
        this.at.a(this.f25331f.a());
        m27233a(this, this.al);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1411672121, a);
        return inflate;
    }

    public static MultiRowAdapter m27235b(GametimePlaysFragment gametimePlaysFragment) {
        if (gametimePlaysFragment.f25333h != null) {
            return gametimePlaysFragment.f25333h;
        }
        Context context = gametimePlaysFragment.getContext();
        FeedListType feedListType = GametimePlaysFeedListType.f25317a;
        Runnable c30223 = new C30223(gametimePlaysFragment);
        final BetterRecyclerView betterRecyclerView = gametimePlaysFragment.ar;
        AnyEnvironment gametimePlaysEnvironment = new GametimePlaysEnvironment(context, feedListType, c30223, new Delegate(gametimePlaysFragment) {
            final /* synthetic */ GametimePlaysFragment f25324b;

            public final void m27228a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
                betterRecyclerView.a(new RecyclerView.OnScrollListener(this) {
                    final /* synthetic */ C30244 f25322b;

                    public final void m27227a(RecyclerView recyclerView, int i, int i2) {
                        super.a(recyclerView, i, i2);
                        hasScrollListenerSupportImpl.b();
                    }
                });
            }
        });
        Builder a = gametimePlaysFragment.f25330e.a(gametimePlaysFragment.f25329d, gametimePlaysFragment.ap);
        a.f = gametimePlaysEnvironment;
        gametimePlaysFragment.f25333h = a.e();
        return gametimePlaysFragment.f25333h;
    }

    public final void m27236I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 141768349);
        this.f25333h.jc_();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -584574494, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1246078719);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            String string = this.s.getString("show_more_title");
            if (string != null) {
                hasTitleBar.a_(string);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1425651975, a);
    }

    public static void m27233a(GametimePlaysFragment gametimePlaysFragment, String str) {
        gametimePlaysFragment.as = true;
        GametimeSportsPlaysQueryString gametimeSportsPlaysQueryString = (GametimeSportsPlaysQueryString) new GametimeSportsPlaysQueryString().a("count", Integer.valueOf(10)).a("scoring_plays", Boolean.valueOf(gametimePlaysFragment.an)).a("page_id", gametimePlaysFragment.ao).a("reaction_profile_image_size_medium", Integer.valueOf(gametimePlaysFragment.f25326a.getResources().getDimensionPixelSize(2131431429)));
        gametimeSportsPlaysQueryString.a("afterCursor", str);
        gametimePlaysFragment.f25332g.a("GAMETIME_PLAYS", gametimePlaysFragment.f25328c.a(GraphQLRequest.a(gametimeSportsPlaysQueryString)), gametimePlaysFragment.f25334i);
    }
}
