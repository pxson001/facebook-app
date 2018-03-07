package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: hovercard */
public class GraphQLFeedTopicContent$Builder extends Builder {
    public ImmutableList<GraphQLExploreFeed> f3756d;

    public GraphQLFeedTopicContent$Builder() {
        Preconditions.checkState(this instanceof GraphQLFeedTopicContent$Builder);
    }

    public final GraphQLFeedTopicContent$Builder m7459a(ImmutableList<GraphQLExploreFeed> immutableList) {
        this.f3756d = immutableList;
        return this;
    }

    public final GraphQLFeedTopicContent m7460a() {
        return new GraphQLFeedTopicContent(this);
    }
}
