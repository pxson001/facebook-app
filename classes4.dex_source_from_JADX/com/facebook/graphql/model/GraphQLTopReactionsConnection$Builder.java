package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: rtc_video_key_frame_interval */
public class GraphQLTopReactionsConnection$Builder extends Builder {
    public ImmutableList<GraphQLTopReactionsEdge> f3162d;

    public GraphQLTopReactionsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLTopReactionsConnection$Builder);
    }

    public final GraphQLTopReactionsConnection m3402a() {
        return new GraphQLTopReactionsConnection(this);
    }
}
