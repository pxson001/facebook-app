package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIds.FetchGroupsFeedAuthoredSoldForSalePostIdsString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAuthoredSoldForSalePostIdsModel.GroupOwnerAuthoredStoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: queueEntityId cannot be null nor empty */
public class FetchGroupsFeedAuthoredSoldForSalePostsIdsMethod implements StoryInvalidaterFetchIdsMethod<FetchGroupsFeedAuthoredSoldForSalePostIdsModel> {
    private final FeedType f5618a;
    private final DbFeedHomeStoriesHandler f5619b;

    public final ImmutableList mo285a(Object obj) {
        FetchGroupsFeedAuthoredSoldForSalePostIdsModel fetchGroupsFeedAuthoredSoldForSalePostIdsModel = (FetchGroupsFeedAuthoredSoldForSalePostIdsModel) obj;
        if (fetchGroupsFeedAuthoredSoldForSalePostIdsModel.m6602j() == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = fetchGroupsFeedAuthoredSoldForSalePostIdsModel.m6602j().m6594a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((NodesModel) a.get(i)).m6590b());
        }
        return builder.b();
    }

    @Inject
    public FetchGroupsFeedAuthoredSoldForSalePostsIdsMethod(@Assisted FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5618a = feedType;
        this.f5619b = dbFeedHomeStoriesHandler;
    }

    public final GraphQLRequest<FetchGroupsFeedAuthoredSoldForSalePostIdsModel> mo284a() {
        String str = ((GroupsFeedTypeValueParams) this.f5618a.f).f5695a;
        GraphQlQueryString fetchGroupsFeedAuthoredSoldForSalePostIdsString = new FetchGroupsFeedAuthoredSoldForSalePostIdsString();
        fetchGroupsFeedAuthoredSoldForSalePostIdsString.a("group_id", str).a("stories_to_fetch", String.valueOf(this.f5619b.e()));
        return GraphQLRequest.a(fetchGroupsFeedAuthoredSoldForSalePostIdsString);
    }

    public final FutureCallback<GraphQLResult<FetchGroupsFeedAuthoredSoldForSalePostIdsModel>> mo286b() {
        return new StoryInvalidaterCallback(this, this.f5618a, this.f5619b);
    }
}
