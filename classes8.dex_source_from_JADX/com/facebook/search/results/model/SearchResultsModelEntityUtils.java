package com.facebook.search.results.model;

import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.model.GraphQLNode;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* compiled from: SALE_POSTS */
public class SearchResultsModelEntityUtils {
    public static final ImmutableSet<GraphQLPageCallToActionType> f23360a = ImmutableSet.of(GraphQLPageCallToActionType.CALL_NOW, GraphQLPageCallToActionType.EMAIL, GraphQLPageCallToActionType.MESSAGE);

    @Nullable
    public static GraphQLPageCallToActionType m27079a(GraphQLNode graphQLNode) {
        if (graphQLNode.kN() != null && f23360a.contains(graphQLNode.kN().n())) {
            return graphQLNode.kN().n();
        }
        return null;
    }
}
