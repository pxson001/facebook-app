package com.facebook.groups.feed.protocol;

import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIds.FetchGroupsStoriesMallIdsString;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsStoriesMallIdsModel;
import com.facebook.groups.feed.protocol.FetchGroupsFeedIdsModels.FetchGroupsStoriesMallIdsModel.GroupStoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: pymi_about_invites */
public class FetchGroupsStoriesMallIdsMethod implements StoryInvalidaterFetchIdsMethod<FetchGroupsStoriesMallIdsModel> {
    private final FeedType f5669a;
    private final DbFeedHomeStoriesHandler f5670b;

    public final ImmutableList mo285a(Object obj) {
        FetchGroupsStoriesMallIdsModel fetchGroupsStoriesMallIdsModel = (FetchGroupsStoriesMallIdsModel) obj;
        if (fetchGroupsStoriesMallIdsModel.m6757j() == null || fetchGroupsStoriesMallIdsModel.m6757j().m6749a() == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = fetchGroupsStoriesMallIdsModel.m6757j().m6749a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a.get(i);
            if (nodesModel.m6745k() != null) {
                builder.c(nodesModel.m6745k());
            } else if (nodesModel.m6744j() != null) {
                builder.c(nodesModel.m6744j());
            }
        }
        return builder.b();
    }

    @Inject
    public FetchGroupsStoriesMallIdsMethod(@Assisted FeedType feedType, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler) {
        this.f5669a = feedType;
        this.f5670b = dbFeedHomeStoriesHandler;
    }

    public final GraphQLRequest<FetchGroupsStoriesMallIdsModel> mo284a() {
        String str = ((GroupsFeedTypeValueParams) this.f5669a.f).f5695a;
        GraphQlQueryString fetchGroupsStoriesMallIdsString = new FetchGroupsStoriesMallIdsString();
        fetchGroupsStoriesMallIdsString.a("group_id", str).a("stories_to_fetch", String.valueOf(this.f5670b.e()));
        return GraphQLRequest.a(fetchGroupsStoriesMallIdsString);
    }

    public final FutureCallback<GraphQLResult<FetchGroupsStoriesMallIdsModel>> mo286b() {
        return new StoryInvalidaterCallback(this, this.f5669a, this.f5670b);
    }
}
