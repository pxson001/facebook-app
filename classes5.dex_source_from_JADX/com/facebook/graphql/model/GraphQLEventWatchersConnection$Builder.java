package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: imagePortrait */
public class GraphQLEventWatchersConnection$Builder extends Builder {
    public int f3677d;
    public ImmutableList<GraphQLEventWatchersEdge> f3678e;
    public ImmutableList<GraphQLActor> f3679f;
    @Nullable
    public GraphQLPageInfo f3680g;
    public int f3681h;
    public int f3682i;

    public GraphQLEventWatchersConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLEventWatchersConnection$Builder);
    }
}
