package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: flight_gate_label */
public class GraphQLImportantReactorsConnection$Builder extends Builder {
    public ImmutableList<GraphQLActor> f4284d;

    public GraphQLImportantReactorsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLImportantReactorsConnection$Builder);
    }

    public final GraphQLImportantReactorsConnection m8634a() {
        return new GraphQLImportantReactorsConnection(this);
    }
}
