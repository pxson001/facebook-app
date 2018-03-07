package com.facebook.graphql.model;

import com.google.common.collect.ImmutableList;

/* compiled from: TV_SHOW */
public class PYMLWithLargeImageFeedUnitHelper {
    private PYMLWithLargeImageFeedUnitHelper() {
    }

    public static GraphQLPYMLWithLargeImageFeedUnitItem m22566a(GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit) {
        ImmutableList x = graphQLPYMLWithLargeImageFeedUnit.x();
        if (x == null || graphQLPYMLWithLargeImageFeedUnit.ac_() >= x.size()) {
            return null;
        }
        return (GraphQLPYMLWithLargeImageFeedUnitItem) x.get(graphQLPYMLWithLargeImageFeedUnit.ac_());
    }
}
