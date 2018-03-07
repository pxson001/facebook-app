package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: index value outside legal index range [0.. */
public class GraphQLEventMaybesConnection$Builder extends Builder {
    public int f3636d;
    public ImmutableList<GraphQLEventMaybesEdge> f3637e;
    @Nullable
    public GraphQLPageInfo f3638f;
    public int f3639g;
    public int f3640h;

    public GraphQLEventMaybesConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLEventMaybesConnection$Builder);
    }
}
