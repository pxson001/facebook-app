package com.facebook.reaction.protocol.graphql;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLReactionUnitCollapseState;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionPageFieldsWithPlaceTipsInfoModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionAggregateUnitFragmentModel.ReactionAggregatedUnitsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitExpirationConditionFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponent;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: filetype */
public class FetchReactionGraphQLInterfaces {

    /* compiled from: filetype */
    public interface ReactionAggregateUnitFragment {
    }

    /* compiled from: filetype */
    public interface ReactionStories {
        @Nonnull
        ImmutableList<? extends Edges> mo828a();

        @Nullable
        DefaultPageInfoFields mo829c();

        @Nullable
        String mo830d();
    }

    /* compiled from: filetype */
    public interface ReactionStoryTopicAttachmentFragment {
    }

    /* compiled from: filetype */
    public interface ReactionStoryFragment {
    }

    /* compiled from: filetype */
    public interface ReactionUnitBadgedProfilesComponentFragment {
    }

    /* compiled from: filetype */
    public interface ReactionUnitDefaultFields extends ReactionStoryFragment {
        @Nullable
        GraphQLObjectType mo814b();

        @Nullable
        GraphQLReactionUnitCollapseState mo815c();

        @Nullable
        String mo816d();

        @Nullable
        String fv_();

        @Nullable
        ReactionUnitHeaderFieldsModel fw_();

        @Nullable
        ReactionAttachmentsModel fx_();

        @Nullable
        ReactionPageFieldsWithPlaceTipsInfoModel mo820g();

        @Nullable
        String mo821j();

        @Nullable
        ReactionUnitExpirationConditionFragmentModel mo822k();

        int mo823l();

        @Nullable
        GraphQLReactionUnitStyle mo824m();

        @Nullable
        String mo825n();

        @Nullable
        DefaultTextWithEntitiesFields mo826o();

        @Nullable
        SizeAwareMedia mo827p();
    }

    /* compiled from: filetype */
    public interface ReactionUnitFragment extends ReactionAggregateUnitFragment, ReactionUnitDefaultFields {
        @Nullable
        GraphQLObjectType mo814b();

        @Nullable
        GraphQLReactionUnitCollapseState mo815c();

        @Nullable
        String mo816d();

        @Nullable
        String fv_();

        @Nullable
        ReactionUnitHeaderFieldsModel fw_();

        @Nullable
        ReactionAttachmentsModel fx_();

        @Nullable
        ReactionPageFieldsWithPlaceTipsInfoModel mo820g();

        @Nullable
        String mo821j();

        @Nullable
        ReactionUnitExpirationConditionFragmentModel mo822k();

        int mo823l();

        @Nullable
        GraphQLReactionUnitStyle mo824m();

        @Nullable
        String mo825n();

        @Nullable
        DefaultTextWithEntitiesFields mo826o();

        @Nullable
        SizeAwareMedia mo827p();

        boolean mo831q();

        @Nullable
        ReactionAggregatedUnitsModel mo832r();

        @Nonnull
        ImmutableList<? extends ReactionUnitComponent> mo833s();
    }
}
