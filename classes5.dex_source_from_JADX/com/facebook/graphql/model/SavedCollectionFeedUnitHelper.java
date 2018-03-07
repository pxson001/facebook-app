package com.facebook.graphql.model;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: TV_GENRE */
public class SavedCollectionFeedUnitHelper {
    private SavedCollectionFeedUnitHelper() {
    }

    public static ImmutableList<GraphQLSavedCollectionFeedUnitItem> m22573a(GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit) {
        ImmutableList<GraphQLSavedCollectionFeedUnitItem> u = graphQLSavedCollectionFeedUnit.u();
        return (u == null || u.isEmpty()) ? graphQLSavedCollectionFeedUnit.z() : u;
    }

    @Nullable
    public static GraphQLTextWithEntities m22574c(GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit) {
        GraphQLTextWithEntities C = graphQLSavedCollectionFeedUnit.C();
        return C != null ? C : graphQLSavedCollectionFeedUnit.A();
    }
}
