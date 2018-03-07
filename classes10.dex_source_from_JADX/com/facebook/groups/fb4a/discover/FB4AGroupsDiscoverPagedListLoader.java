package com.facebook.groups.fb4a.discover;

import android.content.res.Resources;
import android.os.Parcelable;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.groups.discover.protocol.FetchSuggestedGroups.FetchSuggestedGroupsString;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FB4ADiscoverRowDataModel;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FB4ADiscoverRowDataModel.Builder;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FB4ADiscoverRowDataModel.NodeModel;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FetchSuggestedGroupsModel;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsModels.FetchSuggestedGroupsModel.GroupsYouShouldJoinModel.PageInfoModel;
import com.facebook.groups.fb4a.discover.FB4AGroupsDiscoverFragment.C31404;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: Trying to stop TimelineLoadingIndicatorClickProcessor that was not started */
public class FB4AGroupsDiscoverPagedListLoader {
    public static final Class f21939a = FB4AGroupsDiscoverPagedListLoader.class;
    public final TasksManager f21940b;
    public final GraphQLQueryExecutor f21941c;
    public final ScheduledExecutorService f21942d;
    public final FbNetworkManager f21943e;
    public final GraphQLSubscriptionHolder f21944f;
    public final List<FB4ADiscoverRowDataModel> f21945g = new ArrayList();
    private final int f21946h = 3;
    public FutureCallback<GraphQLResult<FB4ADiscoverRowDataModel>> f21947i;
    public C31404 f21948j;
    public String f21949k;
    public boolean f21950l;
    public FetchSuggestedGroupsString f21951m;
    public long f21952n = 500;
    public int f21953o = 0;
    public Resources f21954p;
    public float f21955q;
    public boolean f21956r;

    /* compiled from: Trying to stop TimelineLoadingIndicatorClickProcessor that was not started */
    public class C31421 implements FutureCallback<GraphQLResult<FB4ADiscoverRowDataModel>> {
        final /* synthetic */ FB4AGroupsDiscoverPagedListLoader f21933a;

        public C31421(FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader) {
            this.f21933a = fB4AGroupsDiscoverPagedListLoader;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null && ((FB4ADiscoverRowDataModel) graphQLResult.e).m22260a() != null) {
                for (int i = 0; i < this.f21933a.f21945g.size(); i++) {
                    NodeModel a = ((FB4ADiscoverRowDataModel) graphQLResult.e).m22260a();
                    NodeModel a2 = ((FB4ADiscoverRowDataModel) this.f21933a.f21945g.get(i)).m22260a();
                    if (a.m22249m().equals(a2.m22249m()) && a.m22251o() != a2.m22251o()) {
                        List list = this.f21933a.f21945g;
                        Builder builder = new Builder();
                        list.set(i, Builder.m22190a((FB4ADiscoverRowDataModel) graphQLResult.e).m22191a());
                        FB4AGroupsDiscoverPagedListLoader.m23067h(this.f21933a);
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            BLog.b(FB4AGroupsDiscoverPagedListLoader.f21939a, th.getMessage());
        }
    }

    /* compiled from: Trying to stop TimelineLoadingIndicatorClickProcessor that was not started */
    class C31432 extends AbstractDisposableFutureCallback<GraphQLResult<FetchSuggestedGroupsModel>> {
        final /* synthetic */ FB4AGroupsDiscoverPagedListLoader f21934a;

        C31432(FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader) {
            this.f21934a = fB4AGroupsDiscoverPagedListLoader;
        }

        protected final void m23061a(Throwable th) {
        }
    }

    /* compiled from: Trying to stop TimelineLoadingIndicatorClickProcessor that was not started */
    public class C31464 implements Runnable {
        final /* synthetic */ FB4AGroupsDiscoverPagedListLoader f21938a;

        public C31464(FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader) {
            this.f21938a = fB4AGroupsDiscoverPagedListLoader;
        }

        public void run() {
            this.f21938a.m23070d();
        }
    }

    /* compiled from: Trying to stop TimelineLoadingIndicatorClickProcessor that was not started */
    enum Tasks {
        FETCH_GROUPS
    }

    private void m23062a(ServiceException serviceException) {
        Parcelable parcelable = (Parcelable) serviceException.result.k();
        if ((parcelable instanceof GraphQLError) && ((GraphQLError) parcelable).code == 1675011) {
            m23068i();
        }
    }

    @Inject
    public FB4AGroupsDiscoverPagedListLoader(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, ScheduledExecutorService scheduledExecutorService, FbNetworkManager fbNetworkManager, GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        this.f21940b = tasksManager;
        this.f21941c = graphQLQueryExecutor;
        this.f21942d = scheduledExecutorService;
        this.f21943e = fbNetworkManager;
        this.f21944f = graphQLSubscriptionHolder;
    }

    public final void m23070d() {
        final GraphQLCachePolicy graphQLCachePolicy = GraphQLCachePolicy.c;
        this.f21956r = false;
        this.f21940b.a(Tasks.FETCH_GROUPS, new Callable<GraphQLQueryFuture<GraphQLResult<FetchSuggestedGroupsModel>>>(this) {
            final /* synthetic */ FB4AGroupsDiscoverPagedListLoader f21937b;

            /* compiled from: Trying to stop TimelineLoadingIndicatorClickProcessor that was not started */
            class C31441 implements FutureCallback<GraphQLResult<FetchSuggestedGroupsModel>> {
                final /* synthetic */ C31453 f21935a;

                C31441(C31453 c31453) {
                    this.f21935a = c31453;
                }

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    synchronized (this.f21935a.f21937b) {
                        if (this.f21935a.f21937b.f21949k == null) {
                            this.f21935a.f21937b.f21945g.clear();
                        }
                        FB4AGroupsDiscoverPagedListLoader.m23063a(this.f21935a.f21937b, graphQLResult);
                    }
                }

                public void onFailure(Throwable th) {
                    synchronized (this.f21935a.f21937b) {
                        FB4AGroupsDiscoverPagedListLoader.m23064a(this.f21935a.f21937b, th);
                    }
                }
            }

            public Object call() {
                FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader = this.f21937b;
                fB4AGroupsDiscoverPagedListLoader.f21951m = new FetchSuggestedGroupsString();
                if (fB4AGroupsDiscoverPagedListLoader.f21949k != null) {
                    fB4AGroupsDiscoverPagedListLoader.f21951m.a("after_cursor", fB4AGroupsDiscoverPagedListLoader.f21949k);
                }
                fB4AGroupsDiscoverPagedListLoader.f21951m.a("profile_image_size", Float.valueOf(fB4AGroupsDiscoverPagedListLoader.f21955q));
                fB4AGroupsDiscoverPagedListLoader.f21951m.a("item_count", "7");
                fB4AGroupsDiscoverPagedListLoader.f21951m.a("member_count", Integer.valueOf(3));
                fB4AGroupsDiscoverPagedListLoader.f21951m.a("cover_photo_size", Float.valueOf(fB4AGroupsDiscoverPagedListLoader.f21955q));
                GraphQLQueryFuture a = this.f21937b.f21941c.a(GraphQLRequest.a(this.f21937b.f21951m).a(graphQLCachePolicy));
                Futures.a(a, new C31441(this), this.f21937b.f21942d);
                return a;
            }
        }, new C31432(this));
    }

    public static void m23063a(FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader, GraphQLResult graphQLResult) {
        fB4AGroupsDiscoverPagedListLoader.m23069k();
        if (((FetchSuggestedGroupsModel) graphQLResult.e).m22284a() == null || ((FetchSuggestedGroupsModel) graphQLResult.e).m22284a().m22275a() == 0) {
            fB4AGroupsDiscoverPagedListLoader.f21950l = true;
            m23067h(fB4AGroupsDiscoverPagedListLoader);
            return;
        }
        fB4AGroupsDiscoverPagedListLoader.m23065b(graphQLResult);
    }

    public static void m23064a(FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader, Throwable th) {
        if (th instanceof ServiceException) {
            fB4AGroupsDiscoverPagedListLoader.m23062a((ServiceException) th);
        }
        if (fB4AGroupsDiscoverPagedListLoader.f21953o >= 3 || !fB4AGroupsDiscoverPagedListLoader.f21943e.d()) {
            fB4AGroupsDiscoverPagedListLoader.f21950l = true;
            fB4AGroupsDiscoverPagedListLoader.f21956r = true;
            m23067h(fB4AGroupsDiscoverPagedListLoader);
            return;
        }
        Long.valueOf(fB4AGroupsDiscoverPagedListLoader.f21952n);
        fB4AGroupsDiscoverPagedListLoader.f21942d.schedule(new C31464(fB4AGroupsDiscoverPagedListLoader), fB4AGroupsDiscoverPagedListLoader.f21952n, TimeUnit.MILLISECONDS);
        fB4AGroupsDiscoverPagedListLoader.f21953o++;
        fB4AGroupsDiscoverPagedListLoader.f21952n *= 2;
    }

    private void m23065b(GraphQLResult<FetchSuggestedGroupsModel> graphQLResult) {
        PageInfoModel k = ((FetchSuggestedGroupsModel) graphQLResult.e).m22284a().m22280k();
        this.f21949k = k.m22271a();
        this.f21950l = !k.m22273j();
        m23066c(graphQLResult);
        m23067h(this);
    }

    private void m23066c(GraphQLResult<FetchSuggestedGroupsModel> graphQLResult) {
        ImmutableList j = ((FetchSuggestedGroupsModel) graphQLResult.e).m22284a().m22279j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel = (FB4ADiscoverRowDataModel) j.get(i);
            if (!(fB4ADiscoverRowDataModel == null || fB4ADiscoverRowDataModel.m22260a() == null || fB4ADiscoverRowDataModel.m22260a().m22249m() == null)) {
                Set hashSet = new HashSet();
                hashSet.add(fB4ADiscoverRowDataModel.m22260a().m22249m());
                this.f21944f.a(this.f21947i, fB4ADiscoverRowDataModel.m22260a().m22249m(), new GraphQLResult(fB4ADiscoverRowDataModel, graphQLResult.freshness, graphQLResult.clientTimeMs, hashSet));
            }
            this.f21945g.add(fB4ADiscoverRowDataModel);
        }
    }

    public static void m23067h(FB4AGroupsDiscoverPagedListLoader fB4AGroupsDiscoverPagedListLoader) {
        if (fB4AGroupsDiscoverPagedListLoader.f21948j != null) {
            C31404 c31404 = fB4AGroupsDiscoverPagedListLoader.f21948j;
            List list = fB4AGroupsDiscoverPagedListLoader.f21945g;
            if (c31404.f21921a.f21924a.f21950l && !c31404.f21921a.f21924a.f21956r) {
                c31404.f21921a.f21925b.m23052a(false);
            }
            FB4AGroupsDiscoverAdapter fB4AGroupsDiscoverAdapter = c31404.f21921a.f21925b;
            fB4AGroupsDiscoverAdapter.f21914d = list;
            AdapterDetour.a(fB4AGroupsDiscoverAdapter, -685837514);
            if (c31404.f21921a.f21925b.m23053a()) {
                FB4AGroupsDiscoverFragment fB4AGroupsDiscoverFragment = c31404.f21921a;
                if (fB4AGroupsDiscoverFragment.f21930g != null) {
                    fB4AGroupsDiscoverFragment.f21930g.setVisibility(8);
                }
                fB4AGroupsDiscoverFragment.f21931h.b();
                fB4AGroupsDiscoverFragment.e(2131561759).setVisibility(0);
            } else if (c31404.f21921a.f21926c.d()) {
                FB4AGroupsDiscoverFragment.ar(c31404.f21921a);
            } else if (c31404.f21921a.f21931h.f()) {
                c31404.f21921a.f21931h.a(c31404.f21921a.f21931h.getContext().getResources().getString(2131230811), c31404.f21921a.al);
            }
            fB4AGroupsDiscoverAdapter = c31404.f21921a.f21925b;
            boolean d = c31404.f21921a.f21926c.d();
            fB4AGroupsDiscoverAdapter.f21911a = c31404.f21921a.al;
            if (d != fB4AGroupsDiscoverAdapter.f21912b) {
                fB4AGroupsDiscoverAdapter.f21912b = d;
                AdapterDetour.a(fB4AGroupsDiscoverAdapter, -775658594);
            }
        }
    }

    private void m23068i() {
        this.f21940b.c(Tasks.FETCH_GROUPS);
        this.f21950l = false;
        this.f21949k = null;
        m23069k();
    }

    private void m23069k() {
        this.f21952n = 500;
        this.f21953o = 0;
    }
}
