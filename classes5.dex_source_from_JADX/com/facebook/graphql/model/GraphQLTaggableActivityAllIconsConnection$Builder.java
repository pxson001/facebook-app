package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: UNSUB */
public class GraphQLTaggableActivityAllIconsConnection$Builder extends Builder {
    public int f13252d;
    public ImmutableList<GraphQLTaggableActivityIcon> f13253e;

    public GraphQLTaggableActivityAllIconsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLTaggableActivityAllIconsConnection$Builder);
    }

    public final GraphQLTaggableActivityAllIconsConnection m22041a() {
        return new GraphQLTaggableActivityAllIconsConnection(this);
    }
}
