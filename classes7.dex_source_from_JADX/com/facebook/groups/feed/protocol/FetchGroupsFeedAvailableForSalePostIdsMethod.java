package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIds.FetchGroupsFeedAvailableForSalePostIdsString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedAvailableForSalePostIdsModel.GroupForsaleAvailableStoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: question_context */
public class FetchGroupsFeedAvailableForSalePostIdsMethod implements StoryInvalidaterFetchIdsMethod<FetchGroupsFeedAvailableForSalePostIdsModel> {
    private final FeedType f5620a;
    private final DbFeedHomeStoriesHandler f5621b;

    public final ImmutableList mo285a(Object obj) {
        FetchGroupsFeedAvailableForSalePostIdsModel fetchGroupsFeedAvailableForSalePostIdsModel = (FetchGroupsFeedAvailableForSalePostIdsModel) obj;
        if (fetchGroupsFeedAvailableForSalePostIdsModel.m6624j() == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = fetchGroupsFeedAvailableForSalePostIdsModel.m6624j().m6616a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((NodesModel) a.get(i)).m6612b());
        }
        return builder.b();
    }

    @Inject
    public FetchGroupsFeedAvailableForSalePostIdsMethod(@Assisted FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5620a = feedType;
        this.f5621b = dbFeedHomeStoriesHandler;
    }

    public final GraphQLRequest<FetchGroupsFeedAvailableForSalePostIdsModel> mo284a() {
        String str = ((GroupsFeedTypeValueParams) this.f5620a.f).f5695a;
        GraphQlQueryString fetchGroupsFeedAvailableForSalePostIdsString = new FetchGroupsFeedAvailableForSalePostIdsString();
        fetchGroupsFeedAvailableForSalePostIdsString.a("group_id", str).a("stories_to_fetch", String.valueOf(this.f5621b.e()));
        return GraphQLRequest.a(fetchGroupsFeedAvailableForSalePostIdsString);
    }

    public final FutureCallback<GraphQLResult<FetchGroupsFeedAvailableForSalePostIdsModel>> mo286b() {
        return new StoryInvalidaterCallback(this, this.f5620a, this.f5621b);
    }
}
