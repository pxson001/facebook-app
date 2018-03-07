package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: error_text */
public class GraphQLOwnedEventsConnection$Builder extends Builder {
    public ImmutableList<GraphQLEvent> f4674d;
    @Nullable
    public GraphQLPageInfo f4675e;

    public GraphQLOwnedEventsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLOwnedEventsConnection$Builder);
    }

    public final GraphQLOwnedEventsConnection m9430a() {
        return new GraphQLOwnedEventsConnection(this);
    }
}
