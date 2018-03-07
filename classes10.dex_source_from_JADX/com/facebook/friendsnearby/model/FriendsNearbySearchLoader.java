package com.facebook.friendsnearby.model;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel.EdgesModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySearchQueryModel.FriendsModel.EdgesModel.NodeModel;
import com.facebook.friendsnearby.ui.FriendsNearbyFragment.AnonymousClass21;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import java.util.List;
import javax.inject.Inject;

/* compiled from: _n.jpg */
public class FriendsNearbySearchLoader {
    public static final Class<?> f20538a = FriendsNearbySearchLoader.class;
    public static final List<String> f20539b = ImmutableList.of("mutual_importance");
    public final TasksManager<FriendsNearbyTask> f20540c;
    public final GraphQLQueryExecutor f20541d;
    private final String f20542e;
    public final String f20543f;
    public ImmutableSet<String> f20544g = RegularImmutableSet.a;
    public PageState f20545h = PageState.INITIAL;
    public String f20546i = null;
    public String f20547j;
    public Builder<FriendsNearbyRow> f20548k;
    private FriendsNearbyNewListRowProvider f20549l;

    /* compiled from: _n.jpg */
    public class C29251 extends AbstractDisposableFutureCallback<GraphQLResult<FriendsNearbySearchQueryModel>> {
        final /* synthetic */ AnonymousClass21 f20534a;
        final /* synthetic */ FriendsNearbySearchLoader f20535b;

        public C29251(FriendsNearbySearchLoader friendsNearbySearchLoader, AnonymousClass21 anonymousClass21) {
            this.f20535b = friendsNearbySearchLoader;
            this.f20534a = anonymousClass21;
        }

        protected final void m20949a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                FriendsNearbySearchQueryModel friendsNearbySearchQueryModel = (FriendsNearbySearchQueryModel) graphQLResult.e;
                FriendsNearbySection b = FriendsNearbySearchLoader.m20953b(this.f20535b, friendsNearbySearchQueryModel);
                this.f20535b.f20546i = FriendsNearbySearchLoader.m20953b(this.f20535b, friendsNearbySearchQueryModel);
                if (this.f20535b.f20546i == null) {
                    this.f20535b.f20545h = PageState.COMPLETE;
                } else {
                    this.f20535b.f20545h = PageState.HAS_MORE;
                }
                if (this.f20534a != null) {
                    this.f20534a.m21746a(b);
                }
            }
        }

        protected final void m20950a(Throwable th) {
            this.f20535b.f20545h = PageState.ERROR;
            BLog.b(FriendsNearbySearchLoader.f20538a, "Failed to load more friends", th);
            if (this.f20534a != null) {
                this.f20534a.m21745a();
            }
        }
    }

    /* compiled from: _n.jpg */
    public class C29262 extends AbstractDisposableFutureCallback<GraphQLResult<FriendsNearbySearchQueryModel>> {
        final /* synthetic */ AnonymousClass21 f20536a;
        final /* synthetic */ FriendsNearbySearchLoader f20537b;

        public C29262(FriendsNearbySearchLoader friendsNearbySearchLoader, AnonymousClass21 anonymousClass21) {
            this.f20537b = friendsNearbySearchLoader;
            this.f20536a = anonymousClass21;
        }

        protected final void m20951a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                FriendsNearbySearchQueryModel friendsNearbySearchQueryModel = (FriendsNearbySearchQueryModel) graphQLResult.e;
                FriendsNearbySection b = FriendsNearbySearchLoader.m20953b(this.f20537b, friendsNearbySearchQueryModel);
                this.f20537b.f20546i = FriendsNearbySearchLoader.m20953b(this.f20537b, friendsNearbySearchQueryModel);
                if (this.f20537b.f20546i == null) {
                    this.f20537b.f20545h = PageState.COMPLETE;
                } else {
                    this.f20537b.f20545h = PageState.HAS_MORE;
                }
                if (this.f20536a != null) {
                    this.f20536a.m21747b(b);
                }
            }
        }

        protected final void m20952a(Throwable th) {
            this.f20537b.f20545h = PageState.ERROR;
            if (this.f20536a != null) {
                this.f20536a.m21745a();
            }
        }
    }

    /* compiled from: _n.jpg */
    public enum PageState {
        INITIAL,
        HAS_MORE,
        LOADING,
        ERROR,
        COMPLETE
    }

    static /* synthetic */ String m20954b(FriendsNearbySearchLoader friendsNearbySearchLoader, FriendsNearbySearchQueryModel friendsNearbySearchQueryModel) {
        String str = null;
        if (friendsNearbySearchQueryModel != null) {
            FriendsModel a = friendsNearbySearchQueryModel.m21500a();
            if (a != null) {
                DefaultPageInfoFieldsModel j = a.m21496j();
                if (j != null) {
                    str = j.a();
                }
            }
        }
        return str;
    }

    @Inject
    public FriendsNearbySearchLoader(@Assisted TasksManager tasksManager, Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, Context context, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider) {
        this.f20543f = String.valueOf(resources.getDimensionPixelSize(2131434232));
        this.f20540c = tasksManager;
        this.f20542e = context.getString(2131242009);
        this.f20541d = graphQLQueryExecutor;
        this.f20549l = friendsNearbyNewListRowProvider;
    }

    public static FriendsNearbySection m20953b(FriendsNearbySearchLoader friendsNearbySearchLoader, FriendsNearbySearchQueryModel friendsNearbySearchQueryModel) {
        if (friendsNearbySearchQueryModel == null) {
            return new FriendsNearbySearchSection(friendsNearbySearchLoader.f20542e, RegularImmutableList.a);
        }
        FriendsModel a = friendsNearbySearchQueryModel.m21500a();
        if (a == null) {
            return new FriendsNearbySearchSection(friendsNearbySearchLoader.f20542e, RegularImmutableList.a);
        }
        ImmutableList a2 = a.m21495a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            NodeModel a3 = ((EdgesModel) a2.get(i)).m21490a();
            if (a3 != null) {
                if (a3.m21485l() != null) {
                    boolean z;
                    String str = friendsNearbySearchLoader.f20542e;
                    if (a3 == null || a3.m21483j() == null) {
                        z = false;
                    } else {
                        z = friendsNearbySearchLoader.f20544g.contains(a3.m21483j());
                    }
                    FriendsNearbyNewListRow a4 = FriendsNearbyNewListRow.m20899a(a3, str, z, friendsNearbySearchLoader.f20549l);
                    if (a4 != null) {
                        friendsNearbySearchLoader.f20548k.c(a4);
                    }
                } else {
                    FriendsNearbyInviteRow a5 = FriendsNearbyInviteRow.m20843a(a3, "friends_nearby_search_section");
                    if (a5 != null) {
                        friendsNearbySearchLoader.f20548k.c(a5);
                    }
                }
            }
        }
        return new FriendsNearbySearchSection(friendsNearbySearchLoader.f20542e, friendsNearbySearchLoader.f20548k.b());
    }
}
