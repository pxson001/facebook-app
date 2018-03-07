package com.facebook.reaction.protocol.graphql;

import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFundraiserSupportersConnectionType;
import com.facebook.graphql.enums.GraphQLNearbyFriendsNuxType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPagePhotoSourceType;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.EventModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.GroupModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.PageModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.ProfileModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.StoryModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionComposerActionFieldsModel.ComposerInlineActivityModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionComposerActionFieldsModel.EventSpaceModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionEventInviteFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionEventMessageOnlyFriendActionFieldsModel.FriendModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionFundraiserActionFieldsModel.FundraiserCampaignModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionGenericOpenGraphObjectActionFieldsModel.ActionOgObjectModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionOpenNearbyPlacesActionFieldsModel.PlacesQueryLocationPageModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionOpenPageAlbumActionFragmentModel.AlbumModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionOpenPlaysActionFieldsModel.MatchPageModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionOpenVideoChannelFieldsModel.VideoChannelModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionReplacementUnitFieldsModel.ReplacementUnitModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionSeePageCommerceProductsFieldsModel.CollectionModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionSendMessageAsPageFieldsModel.ThreadKeyModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionViewCommentActionFieldsModel.CommentModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionViewEventGuestListActionFieldsModel.EventModel.EventViewerCapabilityModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionViewFundraiserSupportersActionFieldsModel.FundraiserModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: field_text */
public class ReactionActionsGraphQLInterfaces {

    /* compiled from: field_text */
    public interface ReactionComposerActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionEventMessageOnlyFriendActionFields {

        /* compiled from: field_text */
        public interface Event {
        }
    }

    /* compiled from: field_text */
    public interface ReactionFundraiserActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionGenericOpenGraphObjectActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionOpenNearbyPlacesActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionOpenPageAlbumActionFragment {
    }

    /* compiled from: field_text */
    public interface ReactionOpenPlaysActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionOpenVideoChannelFields {
    }

    /* compiled from: field_text */
    public interface ReactionReplacementUnitFields {
    }

    /* compiled from: field_text */
    public interface ReactionSeePageCommerceProductsFields {
    }

    /* compiled from: field_text */
    public interface ReactionSendMessageAsPageFields {
    }

    /* compiled from: field_text */
    public interface ReactionViewCommentActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionViewEventGuestListActionFields {

        /* compiled from: field_text */
        public interface Event {
            @Nullable
            GraphQLConnectionStyle mo834b();

            @Nullable
            GraphQLEventPrivacyType mo835c();

            @Nullable
            String fC_();

            @Nullable
            EventViewerCapabilityModel fD_();

            @Nullable
            String mo838g();

            @Nullable
            GraphQLEventGuestStatus mo839k();
        }
    }

    /* compiled from: field_text */
    public interface ReactionViewFundraiserSupportersActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionActionFatFields extends ReactionComposerActionFields, ReactionEventMessageOnlyFriendActionFields, ReactionFundraiserActionFields, ReactionGenericOpenGraphObjectActionFields, ReactionOpenNearbyPlacesActionFields, ReactionOpenPageAlbumActionFragment, ReactionOpenPlaysActionFields, ReactionOpenVideoChannelFields, ReactionReplacementUnitFields, ReactionSeePageCommerceProductsFields, ReactionSendMessageAsPageFields, ReactionViewCommentActionFields, ReactionViewEventGuestListActionFields, ReactionViewFundraiserSupportersActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionCommerceActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionStoriesActionFields {
    }

    /* compiled from: field_text */
    public interface ReactionStoryAttachmentActionCommonFragment extends ReactionActionFatFields {
        @Nullable
        GroupModel mo849A();

        @Nullable
        GraphQLEventWatchStatus mo850B();

        @Nullable
        DefaultLocationFields mo851C();

        @Nullable
        MatchPageModel mo852D();

        @Nullable
        GraphQLNearbyFriendsNuxType mo853E();

        @Nullable
        PageModel mo854F();

        @Nullable
        String mo855G();

        @Nullable
        GraphQLPagePhotoSourceType mo856H();

        @Nullable
        String mo857I();

        @Nullable
        PlacesQueryLocationPageModel mo858J();

        @Nullable
        String mo859K();

        @Nullable
        String mo860L();

        @Nullable
        ProfileModel mo861M();

        @Nullable
        String mo862N();

        @Nullable
        String mo863O();

        @Nonnull
        ImmutableList<? extends RelatedUsers> mo864P();

        @Nullable
        ReplacementUnitModel mo865Q();

        @Nullable
        PageServiceItemModel mo866R();

        @Nullable
        String mo867S();

        @Nullable
        String mo868T();

        @Nullable
        String mo869U();

        @Nullable
        StoryModel mo870V();

        boolean mo871W();

        @Nullable
        String mo872X();

        @Nullable
        ReactionEventInviteFieldsModel mo873Y();

        @Nullable
        String mo874Z();

        @Nullable
        GraphQLObjectType mo875a();

        @Nullable
        ThreadKeyModel aa();

        @Nullable
        String ab();

        @Nullable
        String ac();

        @Nullable
        VideoChannelModel ad();

        @Nullable
        DefaultTextWithEntitiesFields mo880b();

        @Nullable
        DefaultTextWithEntitiesFields mo881c();

        @Nullable
        ReactionImageFields mo882d();

        boolean fS_();

        @Nullable
        ActionOgObjectModel fT_();

        @Nullable
        DefaultTextWithEntitiesFields fU_();

        @Nullable
        DefaultTextWithEntitiesFields mo886g();

        @Nullable
        GraphQLReactionStoryActionStyle mo887j();

        @Nullable
        AlbumModel mo888k();

        boolean mo889l();

        @Nullable
        CollectionModel mo890m();

        @Nullable
        CommentModel mo891n();

        @Nullable
        String mo892o();

        @Nullable
        ComposerInlineActivityModel mo893p();

        @Nullable
        GraphQLFundraiserSupportersConnectionType mo894q();

        @Nullable
        String mo895r();

        @Nullable
        GraphQLPhotosByCategoryEntryPoint mo896s();

        @Nullable
        EventModel mo897t();

        @Nullable
        EventSpaceModel mo898u();

        @Nonnull
        ImmutableList<? extends ReactionWeatherSettingsPlaceItemFragment> mo899v();

        @Nullable
        FriendModel mo900w();

        @Nullable
        String mo901x();

        @Nullable
        FundraiserModel mo902y();

        @Nullable
        FundraiserCampaignModel mo903z();
    }
}
