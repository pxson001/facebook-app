package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchMarketplaceCrossGroupStoriesGraphQL.FetchCrossGroupForSalePostsIdsString;
import com.facebook.groups.feed.protocol.FetchMarketplaceCrossGroupStoriesGraphQLModels.FetchCrossGroupForSalePostsIdsModel;
import com.facebook.groups.feed.protocol.FetchMarketplaceCrossGroupStoriesGraphQLModels.FetchCrossGroupForSalePostsIdsModel.MarketplaceCrossGroupStoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: reaction_feed_story_id */
public class FetchCrossGroupForSalePostsIdsMethod implements StoryInvalidaterFetchIdsMethod<FetchCrossGroupForSalePostsIdsModel> {
    private final FeedType f5510a;
    private final DbFeedHomeStoriesHandler f5511b;

    public final ImmutableList mo285a(Object obj) {
        FetchCrossGroupForSalePostsIdsModel fetchCrossGroupForSalePostsIdsModel = (FetchCrossGroupForSalePostsIdsModel) obj;
        if (fetchCrossGroupForSalePostsIdsModel.m6840a() == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = fetchCrossGroupForSalePostsIdsModel.m6840a().m6836a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((NodesModel) a.get(i)).m6832b());
        }
        return builder.b();
    }

    @Inject
    public FetchCrossGroupForSalePostsIdsMethod(@Assisted FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5510a = feedType;
        this.f5511b = dbFeedHomeStoriesHandler;
    }

    public final FutureCallback<GraphQLResult<FetchCrossGroupForSalePostsIdsModel>> mo286b() {
        return new StoryInvalidaterCallback(this, this.f5510a, this.f5511b);
    }

    public final GraphQLRequest<FetchCrossGroupForSalePostsIdsModel> mo284a() {
        GraphQlQueryString fetchCrossGroupForSalePostsIdsString = new FetchCrossGroupForSalePostsIdsString();
        fetchCrossGroupForSalePostsIdsString.a("stories_to_fetch", String.valueOf(this.f5511b.e()));
        return GraphQLRequest.a(fetchCrossGroupForSalePostsIdsString);
    }
}
