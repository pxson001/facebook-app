package com.facebook.goodfriends.data;

import com.facebook.composer.privacy.common.ComposerFixedPrivacyData;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.feed.goodfriends.composer.ComposerGoodFriendsPrivacyDelegate.1;
import com.facebook.goodfriends.protocol.GoodFriendsMetaDataQuery.GoodFriendsMetadataQueryString;
import com.facebook.goodfriends.protocol.GoodFriendsMetaDataQueryModels.GoodFriendsMetadataQueryModel;
import com.facebook.goodfriends.protocol.GoodFriendsMetaDataQueryModels.GoodFriendsMetadataQueryModel.FriendListsModel.NodesModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: mSmallPictureUrl */
public class GoodFriendsMetadataFetcher {
    public final GraphQLQueryExecutor f10923a;
    public final Executor f10924b;
    public final Executor f10925c;

    @Inject
    public GoodFriendsMetadataFetcher(GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, Executor executor2) {
        this.f10923a = graphQLQueryExecutor;
        this.f10924b = executor;
        this.f10925c = executor2;
    }

    public final void m17456a(boolean z, final 1 1) {
        GraphQLCachePolicy graphQLCachePolicy;
        if (z) {
            graphQLCachePolicy = GraphQLCachePolicy.d;
        } else {
            graphQLCachePolicy = GraphQLCachePolicy.a;
        }
        final C06771 c06771 = new FutureCallback<GraphQLResult<GoodFriendsMetadataQueryModel>>(this) {
            final /* synthetic */ GoodFriendsMetadataFetcher f10920b;

            public void onSuccess(Object obj) {
                final NodesModel nodesModel = (NodesModel) ((GoodFriendsMetadataQueryModel) ((GraphQLResult) obj).e).m17562a().m17559a().get(0);
                ExecutorDetour.a(this.f10920b.f10924b, new Runnable(this) {
                    final /* synthetic */ C06771 f10916b;

                    public void run() {
                        1 1 = 1;
                        Long.parseLong(nodesModel.m17552j());
                        nodesModel.m17554l();
                        nodesModel.m17553k().m17539a();
                        GraphQLPrivacyOption m = nodesModel.m17555m();
                        Builder builder = new Builder(1.a.a);
                        builder.d = m.c();
                        ComposerFixedPrivacyData a = builder.a();
                        ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder(1.a);
                        builder2.b = false;
                        1.b.a(builder2.a(a).a());
                    }
                }, 1296402732);
            }

            public void onFailure(final Throwable th) {
                ExecutorDetour.a(this.f10920b.f10924b, new Runnable(this) {
                    final /* synthetic */ C06771 f10918b;

                    public void run() {
                    }
                }, -912434948);
            }
        };
        GraphQLRequest a = GraphQLRequest.a(new GoodFriendsMetadataQueryString()).a(graphQLCachePolicy).a(900);
        a.b = true;
        Futures.a(this.f10923a.a(a), new FutureCallback<GraphQLResult<GoodFriendsMetadataQueryModel>>(this) {
            final /* synthetic */ GoodFriendsMetadataFetcher f10922b;

            public void onSuccess(Object obj) {
                c06771.onSuccess((GraphQLResult) obj);
            }

            public void onFailure(Throwable th) {
                c06771.onFailure(th);
            }
        }, this.f10925c);
    }
}
