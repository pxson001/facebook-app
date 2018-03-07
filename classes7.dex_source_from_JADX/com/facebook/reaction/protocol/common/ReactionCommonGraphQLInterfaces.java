package com.facebook.reaction.protocol.common;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionProfileFieldsModel.CoverPhotoModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: find_friends_view_shown */
public class ReactionCommonGraphQLInterfaces {

    /* compiled from: find_friends_view_shown */
    public interface ReactionFacepileProfile {
        @Nullable
        GraphQLObjectType mo770b();

        @Nullable
        String mo771c();

        @Nullable
        ReactionImageFields mo772d();
    }

    /* compiled from: find_friends_view_shown */
    public interface ReactionImageFields {
        @Nullable
        String mo773b();
    }

    /* compiled from: find_friends_view_shown */
    public interface ReactionPageFields {
    }

    /* compiled from: find_friends_view_shown */
    public interface ReactionPlaceTipsPageFields {
    }

    /* compiled from: find_friends_view_shown */
    public interface ReactionProfileFields {
        @Nullable
        GraphQLObjectType mo774b();

        boolean mo775c();

        boolean mo776d();

        @Nonnull
        ImmutableList<String> eJ_();

        boolean eK_();

        @Nullable
        String eL_();

        @Nullable
        CoverPhotoModel mo780g();

        @Nullable
        String mo781j();

        @Nullable
        ReactionImageFields mo782k();

        @Nullable
        String mo783l();

        @Nullable
        GraphQLSavedState mo784m();
    }

    /* compiled from: find_friends_view_shown */
    public interface ReactionTextWithEntitiesWithImages extends DefaultTextWithEntitiesFields {
        @Nullable
        String mo785a();

        @Nonnull
        ImmutableList<? extends ImageRanges> mo786b();
    }
}
