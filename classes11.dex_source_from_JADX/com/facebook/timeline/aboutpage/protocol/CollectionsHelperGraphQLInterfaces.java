package com.facebook.timeline.aboutpage.protocol;

import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: MarketplaceLocationUpdated */
public class CollectionsHelperGraphQLInterfaces {

    /* compiled from: MarketplaceLocationUpdated */
    public interface CollectionsNodeIdFields {
        @Nullable
        String mo395c();
    }

    /* compiled from: MarketplaceLocationUpdated */
    public interface CollectionsNodePeekFields extends CollectionsNodeIdFields {
        @Nonnull
        ImmutableList<GraphQLTimelineAppCollectionStyle> mo396d();
    }

    /* compiled from: MarketplaceLocationUpdated */
    public interface AppCollectionDefaultFields extends CollectionsNodePeekFields {
        @Nullable
        String mo397b();
    }

    /* compiled from: MarketplaceLocationUpdated */
    public interface AppCollectionItemContainingMutationFields {
        @Nullable
        String mo384d();

        @Nullable
        String mo385g();
    }

    /* compiled from: MarketplaceLocationUpdated */
    public interface AppCollectionSuggestionContainingMutationFields {
        @Nullable
        String mo386b();

        @Nullable
        String mo387c();
    }

    /* compiled from: MarketplaceLocationUpdated */
    public interface CollectionsFirstFiveGroupMembersFields {
    }

    /* compiled from: MarketplaceLocationUpdated */
    public interface CollectionsAppSection {
        @Nullable
        DefaultImageFields mo388b();

        @Nullable
        String mo389c();

        @Nullable
        String mo390d();

        @Nullable
        String mo391g();

        @Nullable
        GraphQLTimelineAppSectionType nP_();

        @Nullable
        String nQ_();

        @Nullable
        String nR_();
    }
}
