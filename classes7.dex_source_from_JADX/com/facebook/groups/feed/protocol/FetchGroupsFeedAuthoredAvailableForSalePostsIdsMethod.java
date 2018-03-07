package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIds.FetchGroupsFeedAuthoredAvailableForSalePostIdsString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredAvailableForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: queue_params */
public class FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethod implements StoryInvalidaterFetchIdsMethod<FetchGroupsFeedAuthoredAvailableForSalePostIdsModel> {
    private final FeedType f5614a;
    private final DbFeedHomeStoriesHandler f5615b;

    public final ImmutableList mo285a(Object obj) {
        FetchGroupsFeedAuthoredAvailableForSalePostIdsModel fetchGroupsFeedAuthoredAvailableForSalePostIdsModel = (FetchGroupsFeedAuthoredAvailableForSalePostIdsModel) obj;
        if (fetchGroupsFeedAuthoredAvailableForSalePostIdsModel.m6558j() == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = fetchGroupsFeedAuthoredAvailableForSalePostIdsModel.m6558j().m6550a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((NodesModel) a.get(i)).m6546b());
        }
        return builder.b();
    }

    @Inject
    public FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethod(@Assisted FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5614a = feedType;
        this.f5615b = dbFeedHomeStoriesHandler;
    }

    public final GraphQLRequest<FetchGroupsFeedAuthoredAvailableForSalePostIdsModel> mo284a() {
        String str = ((GroupsFeedTypeValueParams) this.f5614a.f).f5695a;
        GraphQlQueryString fetchGroupsFeedAuthoredAvailableForSalePostIdsString = new FetchGroupsFeedAuthoredAvailableForSalePostIdsString();
        fetchGroupsFeedAuthoredAvailableForSalePostIdsString.a("group_id", str).a("stories_to_fetch", String.valueOf(this.f5615b.e()));
        return GraphQLRequest.a(fetchGroupsFeedAuthoredAvailableForSalePostIdsString);
    }

    public final FutureCallback<GraphQLResult<FetchGroupsFeedAuthoredAvailableForSalePostIdsModel>> mo286b() {
        return new StoryInvalidaterCallback(this, this.f5614a, this.f5615b);
    }
}
