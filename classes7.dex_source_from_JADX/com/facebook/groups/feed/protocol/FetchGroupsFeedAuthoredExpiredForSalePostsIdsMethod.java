package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIds.FetchGroupsFeedAuthoredExpiredForSalePostIdsString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredExpiredForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: queueType */
public class FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethod implements StoryInvalidaterFetchIdsMethod<FetchGroupsFeedAuthoredExpiredForSalePostIdsModel> {
    private final FeedType f5616a;
    private final DbFeedHomeStoriesHandler f5617b;

    public final ImmutableList mo285a(Object obj) {
        FetchGroupsFeedAuthoredExpiredForSalePostIdsModel fetchGroupsFeedAuthoredExpiredForSalePostIdsModel = (FetchGroupsFeedAuthoredExpiredForSalePostIdsModel) obj;
        if (fetchGroupsFeedAuthoredExpiredForSalePostIdsModel.m6580j() == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = fetchGroupsFeedAuthoredExpiredForSalePostIdsModel.m6580j().m6572a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((NodesModel) a.get(i)).m6568b());
        }
        return builder.b();
    }

    @Inject
    public FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethod(@Assisted FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5616a = feedType;
        this.f5617b = dbFeedHomeStoriesHandler;
    }

    public final GraphQLRequest<FetchGroupsFeedAuthoredExpiredForSalePostIdsModel> mo284a() {
        String str = ((GroupsFeedTypeValueParams) this.f5616a.f).f5695a;
        GraphQlQueryString fetchGroupsFeedAuthoredExpiredForSalePostIdsString = new FetchGroupsFeedAuthoredExpiredForSalePostIdsString();
        fetchGroupsFeedAuthoredExpiredForSalePostIdsString.a("group_id", str).a("stories_to_fetch", String.valueOf(this.f5617b.e()));
        return GraphQLRequest.a(fetchGroupsFeedAuthoredExpiredForSalePostIdsString);
    }

    public final FutureCallback<GraphQLResult<FetchGroupsFeedAuthoredExpiredForSalePostIdsModel>> mo286b() {
        return new StoryInvalidaterCallback(this, this.f5616a, this.f5617b);
    }
}
