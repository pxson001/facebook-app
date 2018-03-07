package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchPaginatedRelatedStoryParams;
import com.facebook.feed.protocol.FetchPaginatedRelatedStoryQuery.FetchPaginatedRelatedStoryQueryString;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;

/* compiled from: minutiae_object_tag */
public class FetchPaginatedRelatedStoryMethod extends AbstractPersistedGraphQlApiMethod<FetchPaginatedRelatedStoryParams, GraphQLStorySet> {
    private final GraphQLStoryHelper f10322c;
    private final GraphQLImageHelper f10323d;
    private final FetchFeedQueryUtil f10324e;

    public final GraphQlQueryString m16276f(Object obj) {
        FetchPaginatedRelatedStoryParams fetchPaginatedRelatedStoryParams = (FetchPaginatedRelatedStoryParams) obj;
        GraphQlQueryString fetchPaginatedRelatedStoryQueryString = new FetchPaginatedRelatedStoryQueryString();
        this.f10324e.a(fetchPaginatedRelatedStoryQueryString);
        this.f10324e.b(fetchPaginatedRelatedStoryQueryString);
        fetchPaginatedRelatedStoryQueryString.a("node_id", fetchPaginatedRelatedStoryParams.a).a("profile_pic_swipe_size_param", this.f10322c.l()).a("pymk_size_param", this.f10322c.g()).a("ad_media_type", this.f10323d.a()).a("after_cursor_param", fetchPaginatedRelatedStoryParams.b).a("num_next_related_stories", String.valueOf(fetchPaginatedRelatedStoryParams.c));
        return fetchPaginatedRelatedStoryQueryString;
    }

    @Inject
    public FetchPaginatedRelatedStoryMethod(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, FetchFeedQueryUtil fetchFeedQueryUtil, GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
        this.f10322c = graphQLStoryHelper;
        this.f10323d = graphQLImageHelper;
        this.f10324e = fetchFeedQueryUtil;
    }

    public final Object m16274a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return (GraphQLStorySet) this.b.a(jsonParser, GraphQLStorySet.class, "PaginatedRelatedStory");
    }

    public final int m16275b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
