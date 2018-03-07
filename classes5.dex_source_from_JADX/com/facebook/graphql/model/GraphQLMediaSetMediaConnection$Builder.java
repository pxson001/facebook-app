package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: family_request */
public class GraphQLMediaSetMediaConnection$Builder extends Builder {
    public int f4487d;
    public ImmutableList<GraphQLMedia> f4488e;
    @Nullable
    public GraphQLPageInfo f4489f;

    public GraphQLMediaSetMediaConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLMediaSetMediaConnection$Builder);
    }

    public final GraphQLMediaSetMediaConnection m9068a() {
        return new GraphQLMediaSetMediaConnection(this);
    }
}
