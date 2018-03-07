package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: TargetingDescription */
public class GraphQLWithTagsConnection$Builder extends Builder {
    public ImmutableList<GraphQLActor> f13456d;

    public GraphQLWithTagsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLWithTagsConnection$Builder);
    }

    public final GraphQLWithTagsConnection$Builder m22494a(ImmutableList<GraphQLActor> immutableList) {
        this.f13456d = immutableList;
        return this;
    }

    public final GraphQLWithTagsConnection m22495a() {
        return new GraphQLWithTagsConnection(this);
    }
}
