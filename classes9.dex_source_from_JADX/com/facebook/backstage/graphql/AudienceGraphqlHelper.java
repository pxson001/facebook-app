package com.facebook.backstage.graphql;

import android.net.Uri;
import com.facebook.backstage.consumption.audience.AudienceControlDataProvider.C04631;
import com.facebook.backstage.data.AudienceControlData;
import com.facebook.backstage.graphql.FBBackstageQuery.FBBackstageWhiteListedFriendsQueryString;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageAllFriendsQueryModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageAllFriendsQueryModel.FriendsModel.EdgesModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageWhiteListedFriendsQueryModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageWhiteListedFriendsQueryModel.BackstageWhitelistedFriendsModel.NodesModel;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: resize of  */
public class AudienceGraphqlHelper {
    public static final String f5197a = AudienceGraphqlHelper.class.getSimpleName();
    public final GraphQLQueryExecutor f5198b;
    public final Executor f5199c;
    public final Executor f5200d;

    /* compiled from: resize of  */
    public class C05551 implements FutureCallback<GraphQLResult<FBBackstageAllFriendsQueryModel>> {
        final /* synthetic */ boolean f5194a;
        final /* synthetic */ C04631 f5195b;
        final /* synthetic */ AudienceGraphqlHelper f5196c;

        public C05551(AudienceGraphqlHelper audienceGraphqlHelper, boolean z, C04631 c04631) {
            this.f5196c = audienceGraphqlHelper;
            this.f5194a = z;
            this.f5195b = c04631;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            final Builder builder = new Builder();
            ImmutableList a = ((FBBackstageAllFriendsQueryModel) graphQLResult.e).m5115a().m5111a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                builder.c(new AudienceControlData(edgesModel.m5106a().m5100j(), edgesModel.m5106a().m5102l(), Uri.parse(edgesModel.m5106a().m5103m().m5093a()), Uri.parse(edgesModel.m5106a().m5101k().m5088a())));
            }
            Futures.a(this.f5196c.f5198b.a(GraphQLRequest.a(new FBBackstageWhiteListedFriendsQueryString()).a(this.f5194a ? GraphQLCachePolicy.d : GraphQLCachePolicy.a)), new FutureCallback<GraphQLResult<FBBackstageWhiteListedFriendsQueryModel>>(this) {
                final /* synthetic */ C05551 f5193b;

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    Set hashSet = new HashSet(((FBBackstageWhiteListedFriendsQueryModel) graphQLResult.e).m5490a().m5485a().size());
                    ImmutableList a = ((FBBackstageWhiteListedFriendsQueryModel) graphQLResult.e).m5490a().m5485a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        hashSet.add(((NodesModel) a.get(i)).m5481j());
                    }
                    C04631 c04631 = this.f5193b.f5195b;
                    ImmutableList b = builder.b();
                    if (c04631.f4656a != null) {
                        c04631.f4656a.mo156a(b, hashSet);
                    }
                    c04631.f4657b.f4663c = hashSet;
                }

                public void onFailure(Throwable th) {
                    BLog.b(AudienceGraphqlHelper.f5197a, "failed white list", th);
                }
            }, this.f5196c.f5199c);
        }

        public void onFailure(Throwable th) {
            BLog.b(AudienceGraphqlHelper.f5197a, "failed all friends", th);
        }
    }

    @Inject
    public AudienceGraphqlHelper(GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, Executor executor2) {
        this.f5198b = graphQLQueryExecutor;
        this.f5199c = executor;
        this.f5200d = executor2;
    }
}
