package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: UPSELL_FAILURE */
public class GraphQLSubstoriesConnection$Builder extends Builder {
    public int f13227d;
    public ImmutableList<GraphQLStory> f13228e;
    @Nullable
    public GraphQLPageInfo f13229f;
    public int f13230g;

    public GraphQLSubstoriesConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLSubstoriesConnection$Builder);
    }

    public static GraphQLSubstoriesConnection$Builder m22001a(GraphQLSubstoriesConnection graphQLSubstoriesConnection) {
        GraphQLSubstoriesConnection$Builder graphQLSubstoriesConnection$Builder = new GraphQLSubstoriesConnection$Builder();
        graphQLSubstoriesConnection.h();
        graphQLSubstoriesConnection$Builder.f13227d = graphQLSubstoriesConnection.a();
        graphQLSubstoriesConnection$Builder.f13228e = graphQLSubstoriesConnection.j();
        graphQLSubstoriesConnection$Builder.f13229f = graphQLSubstoriesConnection.k();
        graphQLSubstoriesConnection$Builder.f13230g = graphQLSubstoriesConnection.l();
        Builder.a(graphQLSubstoriesConnection$Builder, graphQLSubstoriesConnection);
        return graphQLSubstoriesConnection$Builder;
    }

    public final GraphQLSubstoriesConnection m22002a() {
        return new GraphQLSubstoriesConnection(this);
    }
}
