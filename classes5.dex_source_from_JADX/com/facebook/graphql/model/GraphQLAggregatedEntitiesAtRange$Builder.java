package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: journal.tmp */
public class GraphQLAggregatedEntitiesAtRange$Builder extends Builder {
    public int f3314d;
    public int f3315e;
    public int f3316f;
    public ImmutableList<GraphQLEntity> f3317g;

    public GraphQLAggregatedEntitiesAtRange$Builder() {
        Preconditions.checkState(this instanceof GraphQLAggregatedEntitiesAtRange$Builder);
    }

    public final GraphQLAggregatedEntitiesAtRange m6497a() {
        return new GraphQLAggregatedEntitiesAtRange(this);
    }
}
