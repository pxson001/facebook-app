package com.facebook.reaction.protocol.graphql;

import com.facebook.graphql.enums.GraphQLAcornLocationType;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLReactionCoreButtonGlyphAlignment;
import com.facebook.graphql.enums.GraphQLReactionCoreImageTextImageSize;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.enums.GraphQLSelectedActionState;
import com.facebook.graphql.enums.GraphQLVideoChannelFeedUnitPruneBehavior;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultTimeRangeFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLInterfaces.PageServiceItem;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionTextWithEntitiesWithImages;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.PlaceInfoBlurbFieldsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionGeoRectangleFieldsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionPageContextRowsPlaceholderComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionReviewUnitComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitComponentBaseFields;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitFriendRequestListComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitFriendRequestListComponentFragment.FriendingPossibilities;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitGametimeFanFavoriteComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitGametimeTableComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitGametimeTableComponentFragment.TypedData;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitPhotoComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitReviewComposerComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionReviewUnitComponentFragmentModel.SpotlightStoryPreviewModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionUnitGametimeFanFavoriteComponentFragmentModel.AwayVotingPageModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionUnitGametimeFanFavoriteComponentFragmentModel.HomeVotingPageModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.ReactionUnitPhotoComponentFragmentModel.PhotoModel;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentBorderSpecFieldsModel;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentMarginSpecFieldsModel;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentPaddingSpecFieldsModel;
import com.facebook.reaction.protocol.corecomponents.ReactionCoreComponentSpecsGraphQLModels.ReactionCoreComponentTextSpecFieldsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitBadgedProfilesComponentFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitBadgedProfilesComponentFragment.BadgableProfiles;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionAPlaceForFooterCardComponentFragmentModel.FaviconModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionAPlaceForHeaderCardComponentFragmentModel.ProfileImageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionAPlaceForStoryCardComponentFragmentModel.HeroImageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionCrisisActionComponentFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPageMessageBlockComponentFragmentModel.CustomerDataModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPageVeryResponsiveToMessagesComponentFragmentModel.BadgeIconModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionProfileFrameComponentFragmentModel.ExampleFrameImageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionProfileFrameComponentFragmentModel.ProfilePhotoModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.BackgroundImageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.IconModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.ImageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.LocationModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MatchModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.PageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.SubMessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.TertiaryMessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCrisisActionWithComponentFragmentModel.NegativeComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCrisisActionWithComponentFragmentModel.PositiveComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitInfoRowComponentFragmentModel.PrimaryIconModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitPagePhotoAlbumComponentFragmentModel.AlbumModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitWeatherConditionComponentFragmentModel.HighTemperatureModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitWeatherConditionComponentFragmentModel.LowTemperatureModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitWeatherConditionComponentFragmentModel.TemperatureModel;
import com.facebook.topics.protocol.TopicFavoritesQueryInterfaces.VideoTopicFragment;
import com.facebook.video.videohome.protocol.VideoHomeQueryModels.VideoHomeCreatorYouShouldFollowModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: fetch_successful_too_late */
public class ReactionUnitComponentsGraphQLInterfaces {

    /* compiled from: fetch_successful_too_late */
    public interface ReactionAPlaceForFooterCardComponentFragment {

        /* compiled from: fetch_successful_too_late */
        public interface BackgroundImage {
            int mo922a();

            @Nullable
            String mo923b();

            int mo924c();
        }

        @Nullable
        BackgroundImage fX_();

        @Nullable
        String mo913j();

        @Nullable
        FaviconModel mo914k();

        @Nullable
        DefaultTextWithEntitiesFields mo926l();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionAPlaceForHeaderCardComponentFragment {

        /* compiled from: fetch_successful_too_late */
        public interface BackgroundImage {
            int mo927a();

            @Nullable
            String mo928b();

            int mo929c();
        }

        @Nullable
        String mo913j();

        @Nullable
        DefaultTextWithEntitiesFields mo930l();

        @Nullable
        BackgroundImage mo931m();

        @Nullable
        String mo915n();

        @Nullable
        ProfileImageModel mo916o();

        double mo917p();

        @Nullable
        DefaultTextWithEntitiesFields mo932q();

        @Nullable
        String mo918r();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionAPlaceForStoryCardComponentFragment {
        @Nullable
        DefaultTextWithEntitiesFields mo933l();

        @Nullable
        HeroImageModel mo919s();

        @Nullable
        String mo920t();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionGroupDescriptionComponentFragment {
        @Nullable
        String aC();

        boolean ba();

        @Nullable
        LinkableTextWithEntities dj();

        @Nullable
        DefaultTextWithEntitiesFields mo1122g();

        @Nullable
        DefaultTextWithEntitiesFields mo932q();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel mo921v();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionPageMessageBlockComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionPageVeryResponsiveToMessagesComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionProfileFrameComponentFragment {
        @Nullable
        ExampleFrameImageModel au();

        @Nullable
        ProfilePhotoModel bZ();

        @Nullable
        LinkableTextWithEntities dj();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel mo921v();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionSegmentedProgressBarComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitCommentComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitCountsComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitImageWithOverlayComponentFragement {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitInfoRowComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitMapAndBreadcrumbsComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitMessageAndBreadcrumbsComponentFragment {

        /* compiled from: fetch_successful_too_late */
        public interface Breadcrumbs {
            @Nullable
            ReactionStoryAttachmentActionFragmentModel mo1129a();

            @Nullable
            DefaultTextWithEntitiesFields mo1130b();
        }
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitPageMapComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitPageMapWithNavigationComponentFragment {

        /* compiled from: fetch_successful_too_late */
        public interface Location {
            double mo1131a();

            double mo1132b();
        }

        /* compiled from: fetch_successful_too_late */
        public interface Page {
        }
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitPagePhotoAlbumComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitPlaceInfoBlurbWithBreadcrumbsComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitPostPivotComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitVideoChannelFeedUnitComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitWeatherConditionComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitComponentFields extends ReactionPageContextRowsPlaceholderComponentFragment, ReactionReviewUnitComponentFragment, ReactionUnitComponentBaseFields, ReactionUnitFriendRequestListComponentFragment, ReactionUnitGametimeFanFavoriteComponentFragment, ReactionUnitGametimeTableComponentFragment, ReactionUnitPhotoComponentFragment, ReactionUnitReviewComposerComponentFragment, ReactionUnitBadgedProfilesComponentFragment, ReactionAPlaceForFooterCardComponentFragment, ReactionAPlaceForHeaderCardComponentFragment, ReactionAPlaceForStoryCardComponentFragment, ReactionGroupDescriptionComponentFragment, ReactionPageMessageBlockComponentFragment, ReactionPageVeryResponsiveToMessagesComponentFragment, ReactionProfileFrameComponentFragment, ReactionSegmentedProgressBarComponentFragment, ReactionUnitCommentComponentFragment, ReactionUnitCountsComponentFragment, ReactionUnitImageWithOverlayComponentFragement, ReactionUnitInfoRowComponentFragment, ReactionUnitMapAndBreadcrumbsComponentFragment, ReactionUnitMessageAndBreadcrumbsComponentFragment, ReactionUnitPageMapComponentFragment, ReactionUnitPageMapWithNavigationComponentFragment, ReactionUnitPagePhotoAlbumComponentFragment, ReactionUnitPlaceInfoBlurbWithBreadcrumbsComponentFragment, ReactionUnitPostPivotComponentFragment, ReactionUnitVideoChannelFeedUnitComponentFragment, ReactionUnitWeatherConditionComponentFragment, C1053x66a50df0, C1054xec1e7570, C1055xca1d6695 {
        int mo934A();

        int mo935B();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel mo936C();

        @Nullable
        DefaultTextWithEntitiesFields mo937D();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel mo938E();

        @Nullable
        AwayVotingPageModel mo939F();

        @Nullable
        String mo940G();

        @Nullable
        BackgroundImageModel mo941H();

        @Nonnull
        ImmutableList<? extends BadgableProfiles> mo942I();

        @Nullable
        BadgeIconModel mo943J();

        @Nullable
        DefaultTextWithEntitiesFields mo944K();

        @Nullable
        GraphQLBoostedComponentStatus mo945L();

        @Nullable
        String mo946M();

        boolean mo947N();

        @Nonnull
        ImmutableList<? extends Breadcrumbs> mo948O();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel mo949P();

        @Nullable
        DefaultTextWithEntitiesFields mo950Q();

        @Nullable
        DefaultLocationFields mo951R();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel mo952S();

        @Nullable
        CommentModel mo953T();

        @Nullable
        String mo954U();

        @Nullable
        String mo955V();

        @Nonnull
        ImmutableList<? extends ContextList> mo956W();

        double mo957X();

        @Nullable
        String mo958Y();

        @Nullable
        ReactionCoreComponentBorderSpecFieldsModel mo959Z();

        @Nullable
        GraphQLReactionUnitComponentStyle mo848a();

        @Nullable
        DefaultTextWithEntitiesFields aA();

        @Nonnull
        ImmutableList<? extends FriendingPossibilities> aB();

        @Nullable
        String aC();

        boolean aD();

        boolean aE();

        boolean aG();

        @Nullable
        DefaultTextWithEntitiesFields aH();

        @Nullable
        ReactionImageFields aI();

        @Nullable
        DefaultTextWithEntitiesFields aJ();

        @Nullable
        HighTemperatureModel aK();

        @Nullable
        String aL();

        @Nullable
        HomeVotingPageModel aM();

        @Nonnull
        ImmutableList<? extends DefaultTimeRangeFields> aN();

        @Nullable
        IconModel aO();

        @Nullable
        ReactionImageFields aP();

        @Nullable
        ReactionImageFields aQ();

        @Nullable
        ReactionImageFields aR();

        @Nullable
        ImageModel aS();

        @Nullable
        String aT();

        @Nullable
        ReactionImageFields aU();

        @Nullable
        ReactionImageFields aV();

        @Nonnull
        ImmutableList<? extends ReactionImageFields> aW();

        @Nonnull
        ImmutableList<? extends ImagesWithOverlay> aX();

        @Nullable
        DefaultTextWithEntitiesFields aY();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel aZ();

        @Nullable
        GraphQLReactionCoreButtonGlyphAlignment aa();

        @Nullable
        GraphQLReactionCoreImageTextImageSize ab();

        @Nullable
        ReactionCoreComponentMarginSpecFieldsModel ac();

        @Nullable
        ReactionCoreComponentPaddingSpecFieldsModel ad();

        @Nullable
        ReactionImageFields ae();

        @Nullable
        ReactionImageFields af();

        @Nonnull
        ImmutableList<? extends Counts> ag();

        @Nullable
        ReactionImageFields ah();

        @Nullable
        CustomerDataModel ai();

        @Nullable
        DefaultTextWithEntitiesFields aj();

        @Nullable
        DefaultTextWithEntitiesFields ak();

        @Nullable
        String al();

        @Nullable
        DefaultTextWithEntitiesFields am();

        @Nullable
        ReactionImageFields an();

        @Nullable
        DefaultTextWithEntitiesFields ao();

        @Nonnull
        ImmutableList<? extends DefaultTextWithEntitiesFields> ap();

        @Nullable
        GraphQLPageOpenHoursDisplayDecisionEnum aq();

        @Nullable
        String ar();

        @Nullable
        DefaultTextWithEntitiesFields as();

        @Nullable
        ExampleFrameImageModel au();

        @Nullable
        VideoTopicFragment av();

        @Nonnull
        ImmutableList<? extends Facepile> aw();

        @Nullable
        GraphQLStory ax();

        @Nullable
        DefaultTextWithEntitiesFields ay();

        @Nullable
        DefaultTextWithEntitiesFields az();

        @Nullable
        DefaultTextWithEntitiesFields mo906b();

        int bA();

        @Nullable
        DefaultTextWithEntitiesFields bB();

        int bC();

        @Nullable
        DefaultTextWithEntitiesFields bD();

        @Nullable
        DefaultTextWithEntitiesFields bE();

        boolean bF();

        @Nonnull
        ImmutableList<? extends ReactionUnitOpenAlbumActionsFragment> bG();

        @Nullable
        DefaultTextWithEntitiesFields bH();

        @Nullable
        PageModel bI();

        double bJ();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel bK();

        @Nullable
        DefaultTextWithEntitiesFields bL();

        @Nullable
        PhotoModel bM();

        @Nonnull
        ImmutableList<GraphQLStoryAttachment> bN();

        @Nonnull
        ImmutableList<? extends SizeAwareMedia> bO();

        @Nullable
        DefaultTextWithEntitiesFields bP();

        @Nullable
        ReactionImageFields bQ();

        @Nonnull
        ImmutableList<? extends PlaceInfoBlurbBreadcrumbs> bR();

        @Nullable
        PlaceInfoBlurbFieldsModel bS();

        double bT();

        @Nullable
        PlaceInfoBlurbFieldsModel bU();

        @Nullable
        GraphQLPlaceType bV();

        @Nonnull
        ImmutableList<? extends GametimeDataFactFragment> bW();

        @Nullable
        String bX();

        @Nullable
        PrimaryIconModel bY();

        @Nullable
        ProfilePhotoModel bZ();

        boolean ba();

        boolean bb();

        boolean bc();

        boolean bd();

        boolean be();

        boolean bf();

        @Nullable
        LinkableTextWithEntities bg();

        @Nullable
        String bh();

        @Nullable
        LinkableTextWithEntities bi();

        @Nullable
        String bj();

        @Nullable
        String bk();

        @Nullable
        String bl();

        double bm();

        @Nullable
        LocationModel bn();

        @Nullable
        ReactionTextWithEntitiesWithImages bo();

        @Nullable
        GraphQLAcornLocationType bp();

        @Nonnull
        ImmutableList<? extends Locations> bq();

        @Nullable
        LowTemperatureModel br();

        @Nullable
        DefaultTextWithEntitiesFields bs();

        @Nullable
        ReactionGeoRectangleFieldsModel bt();

        @Nullable
        MatchModel bu();

        @Nullable
        MessageModel bv();

        @Nullable
        DefaultTextWithEntitiesFields bw();

        @Nullable
        DefaultTextWithEntitiesFields bx();

        @Nullable
        DefaultTextWithEntitiesFields by();

        @Nullable
        String bz();

        @Nullable
        ReactionCoreComponentTextSpecFieldsModel mo909c();

        @Nullable
        SpotlightStoryPreviewModel cA();

        @Nullable
        DefaultTextWithEntitiesFields cB();

        @Nullable
        String cC();

        @Nullable
        ReactionStoryAttachmentStoryFragmentModel cD();

        double cE();

        @Nullable
        SubMessageModel cG();

        @Nullable
        DefaultTextWithEntitiesFields cH();

        @Nullable
        DefaultTextWithEntitiesFields cI();

        @Nullable
        DefaultTextWithEntitiesFields cJ();

        @Nullable
        DefaultTextWithEntitiesFields cK();

        @Nullable
        DefaultTextWithEntitiesFields cL();

        @Nullable
        TemperatureModel cM();

        @Nullable
        DefaultTextWithEntitiesFields cN();

        @Nullable
        TertiaryMessageModel cO();

        @Nullable
        DefaultTextWithEntitiesFields cP();

        @Nullable
        String cQ();

        @Nullable
        String cR();

        long cS();

        @Nullable
        String cT();

        @Nullable
        DefaultTextWithEntitiesFields cU();

        int cV();

        @Nullable
        DefaultTextWithEntitiesFields cW();

        @Nonnull
        ImmutableList<? extends TypedData> cX();

        @Nonnull
        ImmutableList<String> cY();

        @Nullable
        DefaultTextWithEntitiesFields cZ();

        @Nonnull
        ImmutableList<? extends Profiles> ca();

        @Nullable
        String cb();

        @Nonnull
        ImmutableList<? extends ProgressSegments> cc();

        @Nullable
        String cd();

        @Nullable
        GraphQLVideoChannelFeedUnitPruneBehavior ce();

        @Nullable
        ReactionTextWithEntitiesWithImages cf();

        double cg();

        @Nullable
        DefaultTextWithEntitiesFields ch();

        double ci();

        double cj();

        @Nullable
        DefaultTextWithEntitiesFields ck();

        @Nullable
        DefaultTextWithEntitiesFields cl();

        @Nullable
        LinkableTextWithEntities cm();

        @Nullable
        String cn();

        @Nullable
        DefaultTextWithEntitiesFields co();

        @Nullable
        String cp();

        @Nullable
        String cq();

        double cr();

        @Nullable
        DefaultTextWithEntitiesFields cs();

        @Nullable
        DefaultTextWithEntitiesFields ct();

        @Nonnull
        ImmutableList<? extends ReactionStoryAttachmentActionFragment> cu();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel cv();

        @Nullable
        PageServiceItemModel cw();

        @Nonnull
        ImmutableList<? extends PageServiceItem> cx();

        boolean cy();

        @Nullable
        GametimeDataFactFragment cz();

        @Nullable
        DefaultTextWithEntitiesFields mo910d();

        @Nullable
        VideoDetailFragmentModel da();

        @Nullable
        VideoHomeCreatorYouShouldFollowModel db();

        @Nullable
        ReactionImageFields dc();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel dd();

        @Nullable
        DefaultTextWithEntitiesFields de();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel df();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel dg();

        @Nullable
        String dh();

        int di();

        @Nullable
        ReactionCoreComponentTextSpecFieldsModel fY_();

        @Nullable
        ReactionCoreComponentTextSpecFieldsModel fZ_();

        @Nullable
        String mo913j();

        @Nullable
        FaviconModel mo914k();

        @Nullable
        String mo915n();

        @Nullable
        ProfileImageModel mo916o();

        double mo917p();

        @Nullable
        String mo918r();

        @Nullable
        HeroImageModel mo919s();

        @Nullable
        String mo920t();

        @Nullable
        GraphQLObjectType mo1123u();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel mo921v();

        @Nonnull
        ImmutableList<? extends ReactionStoryAttachmentActionFragment> mo1124w();

        @Nullable
        AlbumModel mo1125x();

        @Nullable
        DefaultTextWithEntitiesFields mo1126y();

        @Nullable
        DefaultTextWithEntitiesFields mo1127z();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitStaticAggregationComponentFields {
        boolean aD();

        boolean aF();

        boolean aG();

        @Nullable
        ReactionStoryAttachmentActionFragmentModel at();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitStaticAggregationComponentFragmentDepth2 extends ReactionUnitStaticAggregationComponentFields {
        @Nonnull
        ImmutableList<? extends ReactionUnitSubComponent> cF();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionPaginatedComponentFragment {
        @Nullable
        PaginatedComponentsModel dk();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionTabSwitcherComponentFragment {
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitStaticAggregationComponentFragmentDepth1 extends ReactionUnitStaticAggregationComponentFields {
        @Nonnull
        ImmutableList<? extends ReactionUnitComponentFields> fW_();
    }

    /* compiled from: fetch_successful_too_late */
    public interface ReactionUnitCrisisActionWithComponentFragment {
        @Nullable
        ReactionCrisisActionComponentFragmentModel cF();

        @Nullable
        NegativeComponentModel dk();

        @Nullable
        ReactionCrisisActionComponentFragmentModel dl();

        @Nullable
        PositiveComponentModel dm();

        @Nullable
        GraphQLSelectedActionState dn();
    }
}
