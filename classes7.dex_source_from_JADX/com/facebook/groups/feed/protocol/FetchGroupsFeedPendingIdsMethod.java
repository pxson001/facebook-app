package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIds.FetchGroupsFeedPendingPostIdsString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedPendingPostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedPendingPostIdsModel.GroupPendingStoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: qe_group_name */
public class FetchGroupsFeedPendingIdsMethod implements StoryInvalidaterFetchIdsMethod<FetchGroupsFeedPendingPostIdsModel> {
    private final FeedType f5665a;
    private final DbFeedHomeStoriesHandler f5666b;

    public final ImmutableList mo285a(Object obj) {
        FetchGroupsFeedPendingPostIdsModel fetchGroupsFeedPendingPostIdsModel = (FetchGroupsFeedPendingPostIdsModel) obj;
        if (fetchGroupsFeedPendingPostIdsModel.m6690j() == null || fetchGroupsFeedPendingPostIdsModel.m6690j().m6682a() == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = fetchGroupsFeedPendingPostIdsModel.m6690j().m6682a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((NodesModel) a.get(i)).m6678b());
        }
        return builder.b();
    }

    @Inject
    public FetchGroupsFeedPendingIdsMethod(@Assisted FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5665a = feedType;
        this.f5666b = dbFeedHomeStoriesHandler;
    }

    public final GraphQLRequest<FetchGroupsFeedPendingPostIdsModel> mo284a() {
        String str = ((GroupsFeedTypeValueParams) this.f5665a.f).f5695a;
        GraphQlQueryString fetchGroupsFeedPendingPostIdsString = new FetchGroupsFeedPendingPostIdsString();
        fetchGroupsFeedPendingPostIdsString.a("group_id", str).a("stories_to_fetch", String.valueOf(this.f5666b.e()));
        return GraphQLRequest.a(fetchGroupsFeedPendingPostIdsString);
    }

    public final FutureCallback<GraphQLResult<FetchGroupsFeedPendingPostIdsModel>> mo286b() {
        return new StoryInvalidaterCallback(this, this.f5665a, this.f5666b);
    }
}
