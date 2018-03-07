package com.facebook.graphql.model;

import com.facebook.graphql.model.GraphQLEntity.Builder;
import com.google.common.base.Function;

/* compiled from: force_in_app_browser */
public final class GraphQLHelper$4 implements Function<GraphQLActor, GraphQLEntity> {
    public final Object apply(Object obj) {
        GraphQLActor graphQLActor = (GraphQLActor) obj;
        Builder builder = new Builder();
        builder.m = graphQLActor.H();
        builder = builder;
        builder.u = graphQLActor.aa();
        builder = builder;
        builder.D = graphQLActor.ai();
        builder = builder;
        builder.S = graphQLActor.b();
        builder = builder;
        builder.P = graphQLActor.aw();
        return builder.a();
    }
}
