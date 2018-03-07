package com.facebook.graphql.model.mutator;

import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.google.common.base.Preconditions;

/* compiled from: TT1; */
public class GraphQLLikersOfContentConnectionMutator {
    public final GraphQLLikersOfContentConnection f13497a;

    private GraphQLLikersOfContentConnectionMutator(GraphQLLikersOfContentConnection graphQLLikersOfContentConnection) {
        this.f13497a = (GraphQLLikersOfContentConnection) graphQLLikersOfContentConnection.f();
    }

    public static GraphQLLikersOfContentConnectionMutator m22628a(GraphQLLikersOfContentConnection graphQLLikersOfContentConnection) {
        Preconditions.checkNotNull(graphQLLikersOfContentConnection);
        return new GraphQLLikersOfContentConnectionMutator(graphQLLikersOfContentConnection);
    }

    public final GraphQLLikersOfContentConnectionMutator m22629a(int i) {
        this.f13497a.a(i);
        return this;
    }
}
