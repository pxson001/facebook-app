package com.facebook.graphql.model.mutator;

import com.facebook.graphql.model.GraphQLPage;
import com.google.common.base.Preconditions;

/* compiled from: TT0; */
public class GraphQLPageMutator {
    public final GraphQLPage f13498a;

    private GraphQLPageMutator(GraphQLPage graphQLPage) {
        this.f13498a = graphQLPage;
    }

    public static GraphQLPageMutator m22630a(GraphQLPage graphQLPage) {
        Preconditions.checkNotNull(graphQLPage);
        return new GraphQLPageMutator((GraphQLPage) graphQLPage.f());
    }

    public final GraphQLPageMutator m22631a(boolean z) {
        this.f13498a.a(z);
        return this;
    }
}
