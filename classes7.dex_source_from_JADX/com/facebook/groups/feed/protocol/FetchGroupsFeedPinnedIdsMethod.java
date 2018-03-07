package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIds.FetchGroupsFeedPinnedPostIdsString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedPinnedPostIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsFeedPinnedPostIdsModel.GroupPinnedStoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: pyml_hide_feed_unit */
public class FetchGroupsFeedPinnedIdsMethod implements StoryInvalidaterFetchIdsMethod<FetchGroupsFeedPinnedPostIdsModel> {
    private final FeedType f5667a;
    private final DbFeedHomeStoriesHandler f5668b;

    public final ImmutableList mo285a(Object obj) {
        FetchGroupsFeedPinnedPostIdsModel fetchGroupsFeedPinnedPostIdsModel = (FetchGroupsFeedPinnedPostIdsModel) obj;
        if (fetchGroupsFeedPinnedPostIdsModel.m6712j() == null || fetchGroupsFeedPinnedPostIdsModel.m6712j().m6704a() == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = fetchGroupsFeedPinnedPostIdsModel.m6712j().m6704a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((NodesModel) a.get(i)).m6700b());
        }
        return builder.b();
    }

    @Inject
    public FetchGroupsFeedPinnedIdsMethod(@Assisted FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5667a = feedType;
        this.f5668b = dbFeedHomeStoriesHandler;
    }

    public final GraphQLRequest<FetchGroupsFeedPinnedPostIdsModel> mo284a() {
        String str = ((GroupsFeedTypeValueParams) this.f5667a.f).f5695a;
        GraphQlQueryString fetchGroupsFeedPinnedPostIdsString = new FetchGroupsFeedPinnedPostIdsString();
        fetchGroupsFeedPinnedPostIdsString.a("group_id", str).a("stories_to_fetch", String.valueOf(this.f5668b.e()));
        return GraphQLRequest.a(fetchGroupsFeedPinnedPostIdsString);
    }

    public final FutureCallback<GraphQLResult<FetchGroupsFeedPinnedPostIdsModel>> mo286b() {
        return new StoryInvalidaterCallback(this, this.f5667a, this.f5668b);
    }
}
