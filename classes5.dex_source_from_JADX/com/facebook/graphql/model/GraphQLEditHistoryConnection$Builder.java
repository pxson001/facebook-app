package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: ios_nearby_friends_self_view_unknown_region */
public class GraphQLEditHistoryConnection$Builder extends Builder {
    public int f3514d;
    public ImmutableList<GraphQLEditAction> f3515e;

    public GraphQLEditHistoryConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLEditHistoryConnection$Builder);
    }

    public final GraphQLEditHistoryConnection m6963a() {
        return new GraphQLEditHistoryConnection(this);
    }
}
