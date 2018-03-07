package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTextWithEntities.Builder;

/* compiled from: access_token */
public class GraphQLTextWithEntitiesMutator {
    public static GraphQLTextWithEntities m19782a(GraphQLTextWithEntities graphQLTextWithEntities, String str) {
        Builder builder = new Builder();
        if (graphQLTextWithEntities != null) {
            builder = Builder.a(graphQLTextWithEntities);
        }
        builder.i = str;
        return builder.a();
    }
}
