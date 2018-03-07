package com.facebook.friendsnearby.model;

import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.friendsnearby.perf.FriendsNearbyDashboardPerfLogger.Marker;
import com.facebook.friendsnearby.server.FriendsNearbyNewQuery.FriendsNearbyHighlightQueryString;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingQueryModel.PrivacySettingsModel;
import com.facebook.friendsnearby.ui.FriendsNearbyFragment;
import com.facebook.friendsnearby.ui.FriendsNearbyFragment.AnonymousClass23;
import com.facebook.friendsnearby.ui.FriendsNearbyFragment.AnonymousClass24;
import com.facebook.friendsnearby.ui.FriendsNearbyFragment.AnonymousClass25;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLBatchRequestProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.ImmutableLocation;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: _implicitlyLogged */
public class FriendsNearbySectionLoader {
    public final TasksManager<FriendsNearbyTask> f20560a;
    private final GraphQLBatchRequestProvider f20561b;
    public final GraphQLQueryExecutor f20562c;
    public final FriendsNearbyQueryBuilder f20563d;
    @ForUiThread
    private final Executor f20564e;

    /* compiled from: _implicitlyLogged */
    public class C29291 extends AbstractDisposableFutureCallback<GraphQLResult<FriendsNearbyContactsTabModel>> {
        final /* synthetic */ AnonymousClass24 f20552a;
        final /* synthetic */ FriendsNearbySectionLoader f20553b;

        public C29291(FriendsNearbySectionLoader friendsNearbySectionLoader, AnonymousClass24 anonymousClass24) {
            this.f20553b = friendsNearbySectionLoader;
            this.f20552a = anonymousClass24;
        }

        protected final void m20968a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            AnonymousClass24 anonymousClass24 = this.f20552a;
            FriendsNearbyContactsTabModel friendsNearbyContactsTabModel = (FriendsNearbyContactsTabModel) graphQLResult.e;
            anonymousClass24.f20862b.ar.m21027b(Marker.DASHBOARD_FETCH_DATA);
            anonymousClass24.f20862b.ar.m21027b(Marker.DASHBOARD_FETCH_DATA2);
            FriendsNearbyFragment.az(anonymousClass24.f20862b);
            FriendsNearbyFragment.aO(anonymousClass24.f20862b);
            anonymousClass24.f20862b.ba.m20880a(friendsNearbyContactsTabModel);
            anonymousClass24.f20861a.mo930h();
            if (anonymousClass24.f20862b.bd.isPresent()) {
                FriendsNearbyFragment friendsNearbyFragment = anonymousClass24.f20862b;
                friendsNearbyFragment.f20918f.a(FriendsNearbyTask.f20577k, new AnonymousClass25(friendsNearbyFragment, (ImmutableLocation) anonymousClass24.f20862b.bd.get()), new AbstractDisposableFutureCallback<OperationResult>(friendsNearbyFragment) {
                    final /* synthetic */ FriendsNearbyFragment f20865a;

                    {
                        this.f20865a = r1;
                    }

                    protected final void m21755a(Throwable th) {
                        BLog.a(FriendsNearbyFragment.f20913a, "Failed to save location to server", th);
                    }
                });
            }
        }

        protected final void m20969a(Throwable th) {
            AnonymousClass24 anonymousClass24 = this.f20552a;
            anonymousClass24.f20862b.ar.m21028c(Marker.DASHBOARD_FETCH_DATA);
            anonymousClass24.f20862b.ar.m21028c(Marker.DASHBOARD_FETCH_DATA2);
            FriendsNearbyFragment.az(anonymousClass24.f20862b);
            FriendsNearbyFragment.aO(anonymousClass24.f20862b);
            anonymousClass24.f20862b.al.a("friends_nearby_fetch_failed", th);
        }
    }

    /* compiled from: _implicitlyLogged */
    class C29302 implements Function<GraphQLResult<FriendsNearbyLocationSharingQueryModel>, DashboardModel> {
        final /* synthetic */ FriendsNearbySectionLoader f20554a;

        C29302(FriendsNearbySectionLoader friendsNearbySectionLoader) {
            this.f20554a = friendsNearbySectionLoader;
        }

        public Object apply(Object obj) {
            Object obj2;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (((FriendsNearbyLocationSharingQueryModel) graphQLResult.e).m21336j().m21321c()) {
                obj2 = null;
            } else {
                PrivacySettingsModel k = ((FriendsNearbyLocationSharingQueryModel) graphQLResult.e).m21337k();
            }
            return new DashboardModel(Optional.of(((FriendsNearbyLocationSharingQueryModel) graphQLResult.e).m21334a()), Optional.of(((FriendsNearbyLocationSharingQueryModel) graphQLResult.e).m21336j()), Optional.fromNullable(obj2), Absent.INSTANCE, Absent.INSTANCE);
        }
    }

    /* compiled from: _implicitlyLogged */
    class C29313 implements Function<GraphQLResult<FriendsNearbyContactsTabModel>, DashboardModel> {
        final /* synthetic */ FriendsNearbySectionLoader f20555a;

        C29313(FriendsNearbySectionLoader friendsNearbySectionLoader) {
            this.f20555a = friendsNearbySectionLoader;
        }

        public Object apply(Object obj) {
            return new DashboardModel(Absent.INSTANCE, Absent.INSTANCE, Absent.INSTANCE, Optional.of(((GraphQLResult) obj).e), Absent.INSTANCE);
        }
    }

    /* compiled from: _implicitlyLogged */
    class C29324 implements Function<GraphQLResult, DashboardModel> {
        final /* synthetic */ FriendsNearbySectionLoader f20556a;

        C29324(FriendsNearbySectionLoader friendsNearbySectionLoader) {
            this.f20556a = friendsNearbySectionLoader;
        }

        public Object apply(Object obj) {
            return new DashboardModel(Absent.INSTANCE, Absent.INSTANCE, Absent.INSTANCE, Absent.INSTANCE, Optional.of(ImmutableList.copyOf(((GraphQLResult) obj).e())));
        }
    }

    @Inject
    public FriendsNearbySectionLoader(@Assisted TasksManager tasksManager, GraphQLBatchRequestProvider graphQLBatchRequestProvider, GraphQLQueryExecutor graphQLQueryExecutor, FriendsNearbyQueryBuilder friendsNearbyQueryBuilder, Executor executor) {
        this.f20561b = graphQLBatchRequestProvider;
        this.f20560a = tasksManager;
        this.f20562c = graphQLQueryExecutor;
        this.f20563d = friendsNearbyQueryBuilder;
        this.f20564e = executor;
    }

    public final void m20973a(ImmutableList<String> immutableList, State state, Optional<ImmutableLocation> optional, final InitialDataCallback initialDataCallback) {
        Preconditions.checkNotNull(initialDataCallback, "no callback");
        GraphQLBatchRequest a = GraphQLBatchRequestProvider.a("FriendsNearbySection");
        RequestObservable a2 = a.a(this.f20563d.m20946a(state, (Optional) optional)).a(this.f20564e).a(new C29302(this));
        RequestObservable a3 = a.a(this.f20563d.m20947a((Optional) optional)).a(this.f20564e).a(new C29313(this));
        RequestObservable b = RequestObservable.b();
        if (!(immutableList == null || immutableList.isEmpty())) {
            FriendsNearbyQueryBuilder friendsNearbyQueryBuilder = this.f20563d;
            GraphQlQueryString friendsNearbyHighlightQueryString = new FriendsNearbyHighlightQueryString();
            friendsNearbyHighlightQueryString.a("ids", immutableList).a("pic_size", friendsNearbyQueryBuilder.f20530a);
            b = a.a(GraphQLRequest.a(friendsNearbyHighlightQueryString)).a(this.f20564e).a(new C29324(this));
        }
        RequestObservable.a(a2, a3, b).a(this.f20564e).a(new RequestObserver<DashboardModel>(this) {
            final /* synthetic */ FriendsNearbySectionLoader f20558b;
            private boolean f20559c = true;

            public final void m20971a(Object obj) {
                DashboardModel dashboardModel = (DashboardModel) obj;
                if (this.f20559c) {
                    initialDataCallback.m21752a(dashboardModel);
                } else {
                    initialDataCallback.m21753b(dashboardModel);
                }
                this.f20559c = false;
            }

            public final void m20970a() {
                AnonymousClass23 anonymousClass23 = initialDataCallback;
                anonymousClass23.f20858b.ar.m21027b(Marker.DASHBOARD_FETCH_DATA1);
                anonymousClass23.f20858b.be = anonymousClass23.f20858b.aq.a();
                if (anonymousClass23.f20860d) {
                    anonymousClass23.f20857a.mo930h();
                } else if (anonymousClass23.f20858b.bM == anonymousClass23.f20859c) {
                    anonymousClass23.f20857a.mo932j();
                }
            }

            public final void m20972a(Throwable th) {
                AnonymousClass23 anonymousClass23 = initialDataCallback;
                anonymousClass23.f20857a.mo932j();
                anonymousClass23.f20858b.al.a("friends_nearby_fetch_failed", th);
                anonymousClass23.f20858b.ar.m21028c(Marker.DASHBOARD_FETCH_DATA1);
            }
        });
        this.f20562c.a(a);
    }
}
