package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: first_question */
public class GraphQLInlineActivitiesConnection$Builder extends Builder {
    public ImmutableList<GraphQLInlineActivity> f4306d;

    public GraphQLInlineActivitiesConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLInlineActivitiesConnection$Builder);
    }

    public final GraphQLInlineActivitiesConnection m8684a() {
        return new GraphQLInlineActivitiesConnection(this);
    }
}
