package com.facebook.graphql.deserializers;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.typecodes.GraphQLTypeCodes;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: place_topic_ids */
public class FeedUnitDeserializerResolver {
    public static int m4503a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        GraphQLObjectType a;
        if (jsonParser.g() == JsonToken.START_OBJECT) {
            jsonParser.c();
        }
        while (jsonParser.g() == JsonToken.FIELD_NAME) {
            jsonParser.c();
            if (jsonParser.i().equals("__type__")) {
                a = GraphQLObjectType.a(jsonParser);
                break;
            }
            while (jsonParser.g() != JsonToken.FIELD_NAME) {
                jsonParser.c();
            }
        }
        a = null;
        String e = a.e();
        short a2 = GraphQLTypeCodes.m9854a(e);
        if (a2 == (short) 0) {
            BLog.a("FeedUnitDeserializerResolver", "Could not resolve reference type for " + e);
            return 0;
        }
        int a3;
        switch (a2) {
            case (short) 1:
                a3 = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                a3 = GraphQLUserDeserializer.m6148a(jsonParser, flatBufferBuilder);
                break;
            case (short) 3:
                a3 = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                a3 = GraphQLViewerDeserializer.m6199a(jsonParser, flatBufferBuilder);
                break;
            case (short) 5:
                a3 = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                break;
            case (short) 6:
                a3 = GraphQLAdAccountDeserializer.m4522a(jsonParser, flatBufferBuilder);
                break;
            case (short) 7:
                a3 = GraphQLAdsInterestDeserializer.m4543a(jsonParser, flatBufferBuilder);
                break;
            case (short) 8:
                a3 = GraphQLResearchPollMultipleChoiceQuestionDeserializer.m5813a(jsonParser, flatBufferBuilder);
                break;
            case (short) 9:
                a3 = GraphQLResearchPollMultipleChoiceResponseDeserializer.m5818a(jsonParser, flatBufferBuilder);
                break;
            case (short) 10:
                a3 = GraphQLResearchPollSurveyDeserializer.m5830a(jsonParser, flatBufferBuilder);
                break;
            case (short) 11:
                a3 = GraphQLAYMTChannelDeserializer.m4505a(jsonParser, flatBufferBuilder);
                break;
            case (short) 12:
                a3 = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                break;
            case (short) 13:
                a3 = GraphQLContactDeserializer.m4677a(jsonParser, flatBufferBuilder);
                break;
            case (short) 14:
                a3 = GraphQLContactRecommendationFieldDeserializer.m4683a(jsonParser, flatBufferBuilder);
                break;
            case (short) 15:
                a3 = GraphQLExternalUrlDeserializer.m4867a(jsonParser, flatBufferBuilder);
                break;
            case (short) 17:
                a3 = GraphQLDiscoveryCardItemDeserializer.m4712a(jsonParser, flatBufferBuilder);
                break;
            case (short) 18:
                a3 = GraphQLInstantArticleDeserializer.m5262a(jsonParser, flatBufferBuilder);
                break;
            case (short) 19:
                a3 = GraphQLInstantArticleVersionDeserializer.m5265a(jsonParser, flatBufferBuilder);
                break;
            case (short) 20:
                a3 = GraphQLComposedDocumentDeserializer.m4668a(jsonParser, flatBufferBuilder);
                break;
            case (short) 21:
                a3 = GraphQLEditActionDeserializer.m4718a(jsonParser, flatBufferBuilder);
                break;
            case (short) 22:
                a3 = GraphQLEventDeserializer.m4792a(jsonParser, flatBufferBuilder);
                break;
            case (short) 23:
                a3 = GraphQLEventThemePhotoDeserializer.m4824a(jsonParser, flatBufferBuilder);
                break;
            case (short) 24:
                a3 = GraphQLEducationExperienceDeserializer.m4724a(jsonParser, flatBufferBuilder);
                break;
            case (short) 25:
                a3 = GraphQLWorkExperienceDeserializer.m6215a(jsonParser, flatBufferBuilder);
                break;
            case (short) 26:
                a3 = GraphQLExploreFeedDeserializer.m4861a(jsonParser, flatBufferBuilder);
                break;
            case (short) 27:
                a3 = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                break;
            case (short) 28:
                a3 = GraphQLLeadGenLegalContentCheckboxDeserializer.m5299a(jsonParser, flatBufferBuilder);
                break;
            case (short) 29:
                a3 = GraphQLLeadGenUserStatusDeserializer.m5312a(jsonParser, flatBufferBuilder);
                break;
            case (short) 30:
                a3 = GraphQLCustomizedStoryDeserializer.m4703a(jsonParser, flatBufferBuilder);
                break;
            case (short) 31:
                a3 = GraphQLStorySetItemDeserializer.m5982a(jsonParser, flatBufferBuilder);
                break;
            case (short) 32:
                a3 = GraphQLStorySetDeserializer.m5979a(jsonParser, flatBufferBuilder);
                break;
            case (short) 33:
                a3 = GraphQLArticleChainingFeedUnitDeserializer.m4585a(jsonParser, flatBufferBuilder);
                break;
            case (short) 34:
                a3 = GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer.m5065a(jsonParser, flatBufferBuilder);
                break;
            case (short) 35:
                a3 = GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer.m5554a(jsonParser, flatBufferBuilder);
                break;
            case (short) 36:
                a3 = GraphQLPeopleYouMayInviteFeedUnitDeserializer.m5581a(jsonParser, flatBufferBuilder);
                break;
            case (short) 37:
                a3 = GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer.m5563a(jsonParser, flatBufferBuilder);
                break;
            case (short) 38:
                a3 = GraphQLPeopleYouShouldFollowFeedUnitDeserializer.m5592a(jsonParser, flatBufferBuilder);
                break;
            case (short) 39:
                a3 = GraphQLResearchPollFeedUnitDeserializer.m5810a(jsonParser, flatBufferBuilder);
                break;
            case (short) 40:
                a3 = GraphQLStoryGallerySurveyFeedUnitDeserializer.m5967a(jsonParser, flatBufferBuilder);
                break;
            case (short) 41:
                a3 = GraphQLUnseenStoriesFeedUnitDeserializer.m6145a(jsonParser, flatBufferBuilder);
                break;
            case (short) 42:
                a3 = GraphQLVideoChainingFeedUnitDeserializer.m6173a(jsonParser, flatBufferBuilder);
                break;
            case (short) 43:
                a3 = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                break;
            case (short) 44:
                a3 = GraphQLCommentDeserializer.m4657a(jsonParser, flatBufferBuilder);
                break;
            case (short) 45:
                a3 = GraphQLFeedbackReactionInfoDeserializer.m4901a(jsonParser, flatBufferBuilder);
                break;
            case (short) 47:
                a3 = GraphQLGoodwillAnniversaryCampaignDeserializer.m4996a(jsonParser, flatBufferBuilder);
                break;
            case (short) 48:
                a3 = GraphQLGoodwillBirthdayCampaignDeserializer.m5002a(jsonParser, flatBufferBuilder);
                break;
            case (short) 49:
                a3 = GraphQLGoodwillFriendversaryCampaignDeserializer.m5011a(jsonParser, flatBufferBuilder);
                break;
            case (short) 51:
                a3 = GraphQLCulturalMomentDeserializer.m4697a(jsonParser, flatBufferBuilder);
                break;
            case (short) 52:
                a3 = GraphQLGreetingCardDeserializer.m5121a(jsonParser, flatBufferBuilder);
                break;
            case (short) 53:
                a3 = GraphQLGreetingCardTemplateDeserializer.m5136a(jsonParser, flatBufferBuilder);
                break;
            case (short) 54:
                a3 = GraphQLGroupDeserializer.m5157a(jsonParser, flatBufferBuilder);
                break;
            case (short) 57:
                a3 = GraphQLStructuredSurveyDeserializer.m6000a(jsonParser, flatBufferBuilder);
                break;
            case (short) 58:
                a3 = GraphQLStructuredSurveyQuestionDeserializer.m6003a(jsonParser, flatBufferBuilder);
                break;
            case (short) 59:
                a3 = GraphQLHashtagDeserializer.m5210a(jsonParser, flatBufferBuilder);
                break;
            case (short) 60:
                a3 = GraphQLLeadGenDeepLinkUserStatusDeserializer.m5286a(jsonParser, flatBufferBuilder);
                break;
            case (short) 61:
                a3 = GraphQLMailingAddressDeserializer.m5335a(jsonParser, flatBufferBuilder);
                break;
            case (short) 62:
                a3 = GraphQLMediaQuestionDeserializer.m5343a(jsonParser, flatBufferBuilder);
                break;
            case (short) 63:
                a3 = GraphQLMediaQuestionOptionDeserializer.m5346a(jsonParser, flatBufferBuilder);
                break;
            case (short) 65:
                a3 = GraphQLStickerDeserializer.m5945a(jsonParser, flatBufferBuilder);
                break;
            case (short) 66:
                a3 = GraphQLInlineActivityDeserializer.m5247a(jsonParser, flatBufferBuilder);
                break;
            case (short) 67:
                a3 = GraphQLTaggableActivityDeserializer.m6032a(jsonParser, flatBufferBuilder);
                break;
            case (short) 68:
                a3 = GraphQLTaggableActivityIconDeserializer.m6036a(jsonParser, flatBufferBuilder);
                break;
            case (short) 69:
                a3 = GraphQLMobileStoreObjectDeserializer.m5377a(jsonParser, flatBufferBuilder);
                break;
            case (short) 70:
                a3 = GraphQLExternalMusicAlbumDeserializer.m4864a(jsonParser, flatBufferBuilder);
                break;
            case (short) 72:
                a3 = GraphQLNegativeFeedbackActionDeserializer.m5412a(jsonParser, flatBufferBuilder);
                break;
            case (short) 73:
                a3 = GraphQLAppListDeserializer.m4570a(jsonParser, flatBufferBuilder);
                break;
            case (short) 74:
                a3 = GraphQLNoteDeserializer.m5441a(jsonParser, flatBufferBuilder);
                break;
            case (short) 75:
                a3 = GraphQLOpenGraphActionDeserializer.m5457a(jsonParser, flatBufferBuilder);
                break;
            case (short) 76:
                a3 = GraphQLOpenGraphObjectDeserializer.m5465a(jsonParser, flatBufferBuilder);
                break;
            case (short) 77:
                a3 = GraphQLCouponDeserializer.m4686a(jsonParser, flatBufferBuilder);
                break;
            case (short) 78:
                a3 = GraphQLSportsDataMatchDataDeserializer.m5924a(jsonParser, flatBufferBuilder);
                break;
            case (short) 79:
                a3 = GraphQLSportsDataMatchDataFactDeserializer.m5927a(jsonParser, flatBufferBuilder);
                break;
            case (short) 80:
                a3 = GraphQLPhotoEncodingDeserializer.m5606a(jsonParser, flatBufferBuilder);
                break;
            case (short) 81:
                a3 = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                break;
            case (short) 82:
                a3 = GraphQLAlbumDeserializer.m4549a(jsonParser, flatBufferBuilder);
                break;
            case (short) 84:
                a3 = GraphQLFaceBoxDeserializer.m4870a(jsonParser, flatBufferBuilder);
                break;
            case (short) 85:
                a3 = GraphQLVideoDeserializer.m6184a(jsonParser, flatBufferBuilder);
                break;
            case (short) 86:
                a3 = GraphQLPlaceListItemDeserializer.m5644a(jsonParser, flatBufferBuilder);
                break;
            case (short) 87:
                a3 = GraphQLPostChannelDeserializer.m5679a(jsonParser, flatBufferBuilder);
                break;
            case (short) 88:
                a3 = GraphQLPrivacyOptionDeserializer.a(jsonParser, flatBufferBuilder);
                break;
            case (short) 89:
                a3 = GraphQLProfileBadgeDeserializer.m5714a(jsonParser, flatBufferBuilder);
                break;
            case (short) 90:
                a3 = GraphQLQuestionOptionDeserializer.m5734a(jsonParser, flatBufferBuilder);
                break;
            case (short) 91:
                a3 = GraphQLQuickPromotionDeserializer.m5749a(jsonParser, flatBufferBuilder);
                break;
            case (short) 92:
                a3 = GraphQLSearchAwarenessSuggestionDeserializer.m5862a(jsonParser, flatBufferBuilder);
                break;
            case (short) 93:
                a3 = GraphQLGraphSearchQueryFilterDeserializer.m5089a(jsonParser, flatBufferBuilder);
                break;
            case (short) 94:
                a3 = GraphQLPhrasesAnalysisItemDeserializer.m5629a(jsonParser, flatBufferBuilder);
                break;
            case (short) 95:
                a3 = GraphQLGraphSearchQueryDeserializer.m5083a(jsonParser, flatBufferBuilder);
                break;
            case (short) 96:
                a3 = GraphQLSearchShortcutDeserializer.m5865a(jsonParser, flatBufferBuilder);
                break;
            case (short) 98:
                a3 = GraphQLFundraiserCampaignDeserializer.m4972a(jsonParser, flatBufferBuilder);
                break;
            case (short) 99:
                a3 = GraphQLFundraiserPageDeserializer.m4978a(jsonParser, flatBufferBuilder);
                break;
            case (short) 100:
                a3 = GraphQLSouvenirDeserializer.m5903a(jsonParser, flatBufferBuilder);
                break;
            case (short) 101:
                a3 = GraphQLSouvenirMediaElementDeserializer.m5912a(jsonParser, flatBufferBuilder);
                break;
            case (short) 102:
                a3 = GraphQLTimelineAppCollectionDeserializer.m6066a(jsonParser, flatBufferBuilder);
                break;
            case (short) 103:
                a3 = GraphQLTimelineAppCollectionItemDeserializer.m6071a(jsonParser, flatBufferBuilder);
                break;
            case (short) 104:
                a3 = GraphQLTimelineSectionDeserializer.m6083a(jsonParser, flatBufferBuilder);
                break;
            case (short) 105:
                a3 = GraphQLTimelineAppSectionDeserializer.m6080a(jsonParser, flatBufferBuilder);
                break;
            case (short) 106:
                a3 = GraphQLTrendingTopicDataDeserializer.m6127a(jsonParser, flatBufferBuilder);
                break;
            case (short) 107:
                a3 = GraphQLCarrierUpsellPromotionDeserializer.m4637a(jsonParser, flatBufferBuilder);
                break;
            case (short) 108:
                a3 = GraphQLNodeDeserializer.m5436a(jsonParser, flatBufferBuilder);
                break;
            case (short) 109:
                a3 = GraphQLFriendsConnectionDeserializer.m4945a(jsonParser, flatBufferBuilder);
                break;
            case (short) 110:
                a3 = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                break;
            case (short) 111:
                a3 = GraphQLCelebrationsFeedUnitDeserializer.m4640a(jsonParser, flatBufferBuilder);
                break;
            case (short) 112:
                a3 = GraphQLFriendsLocationsFeedUnitDeserializer.m4956a(jsonParser, flatBufferBuilder);
                break;
            case (short) 113:
                a3 = GraphQLGroupsYouShouldCreateFeedUnitDeserializer.m5194a(jsonParser, flatBufferBuilder);
                break;
            case (short) 114:
                a3 = GraphQLGroupsYouShouldJoinFeedUnitDeserializer.m5202a(jsonParser, flatBufferBuilder);
                break;
            case (short) 115:
                a3 = GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer.m5254a(jsonParser, flatBufferBuilder);
                break;
            case (short) 117:
                a3 = GraphQLMobilePageAdminPanelFeedUnitDeserializer.m5370a(jsonParser, flatBufferBuilder);
                break;
            case (short) 118:
                a3 = GraphQLPlaceReviewFeedUnitDeserializer.m5663a(jsonParser, flatBufferBuilder);
                break;
            case (short) 119:
                a3 = GraphQLPagesYouMayAdvertiseFeedUnitDeserializer.m5536a(jsonParser, flatBufferBuilder);
                break;
            case (short) 120:
                a3 = GraphQLPeopleYouMayKnowFeedUnitDeserializer.m5584a(jsonParser, flatBufferBuilder);
                break;
            case (short) 121:
                a3 = GraphQLCreativePagesYouMayLikeFeedUnitDeserializer.m4689a(jsonParser, flatBufferBuilder);
                break;
            case (short) 122:
                a3 = GraphQLPYMLWithLargeImageFeedUnitDeserializer.m5479a(jsonParser, flatBufferBuilder);
                break;
            case (short) 123:
                a3 = GraphQLPagesYouMayLikeFeedUnitDeserializer.m5543a(jsonParser, flatBufferBuilder);
                break;
            case (short) 124:
                a3 = GraphQLQuickPromotionFeedUnitDeserializer.m5752a(jsonParser, flatBufferBuilder);
                break;
            case (short) 125:
                a3 = GraphQLSavedCollectionFeedUnitDeserializer.m5851a(jsonParser, flatBufferBuilder);
                break;
            case (short) 126:
                a3 = GraphQLSocialWifiFeedUnitDeserializer.m5895a(jsonParser, flatBufferBuilder);
                break;
            case (short) 127:
                a3 = GraphQLHoldoutAdFeedUnitDeserializer.m5216a(jsonParser, flatBufferBuilder);
                break;
            case (short) 128:
                a3 = GraphQLSurveyFeedUnitDeserializer.m6023a(jsonParser, flatBufferBuilder);
                break;
            case (short) 129:
                a3 = GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer.m4999a(jsonParser, flatBufferBuilder);
                break;
            case (short) 130:
                a3 = GraphQLGreetingCardPromotionFeedUnitDeserializer.m5124a(jsonParser, flatBufferBuilder);
                break;
            case (short) 131:
                a3 = GraphQLClientBumpingPlaceHolderFeedUnitDeserializer.m4651a(jsonParser, flatBufferBuilder);
                break;
            case (short) 132:
                a3 = GraphQLEventCollectionFeedUnitDeserializer.m4776a(jsonParser, flatBufferBuilder);
                break;
            case (short) 133:
                a3 = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                break;
            case (short) 134:
                a3 = GraphQLEntityAtRangeDeserializer.m4746a(jsonParser, flatBufferBuilder);
                break;
            case (short) 135:
                a3 = GraphQLEntityDeserializer.m4763a(jsonParser, flatBufferBuilder);
                break;
            case (short) 136:
                a3 = GraphQLRedirectionInfoDeserializer.m5799a(jsonParser, flatBufferBuilder);
                break;
            case (short) 137:
                a3 = GraphQLAppStoreApplicationDeserializer.m4573a(jsonParser, flatBufferBuilder);
                break;
            case (short) 138:
                a3 = GraphQLAggregatedEntitiesAtRangeDeserializer.m4546a(jsonParser, flatBufferBuilder);
                break;
            case (short) 139:
                a3 = GraphQLAndroidAppConfigDeserializer.m4561a(jsonParser, flatBufferBuilder);
                break;
            case (short) 140:
                a3 = GraphQLImageAtRangeDeserializer.m5222a(jsonParser, flatBufferBuilder);
                break;
            case (short) 141:
                a3 = GraphQLEntityWithImageDeserializer.m4767a(jsonParser, flatBufferBuilder);
                break;
            case (short) 142:
                a3 = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                break;
            case (short) 143:
                a3 = GraphQLIconDeserializer.m5219a(jsonParser, flatBufferBuilder);
                break;
            case (short) 144:
                a3 = GraphQLPrivacyEducationInfoDeserializer.m5688a(jsonParser, flatBufferBuilder);
                break;
            case (short) 145:
                a3 = GraphQLReshareEducationInfoDeserializer.m5836a(jsonParser, flatBufferBuilder);
                break;
            case (short) 146:
                a3 = GraphQLTagExpansionEducationInfoDeserializer.m6026a(jsonParser, flatBufferBuilder);
                break;
            case (short) 147:
                a3 = GraphQLFullIndexEducationInfoDeserializer.m4969a(jsonParser, flatBufferBuilder);
                break;
            case (short) 148:
                a3 = GraphQLPrivacyOptionsContentConnectionDeserializer.m5697a(jsonParser, flatBufferBuilder);
                break;
            case (short) 149:
                a3 = GraphQLPrivacyOptionsContentEdgeDeserializer.m5700a(jsonParser, flatBufferBuilder);
                break;
            case (short) 150:
                a3 = GraphQLStorySaveInfoDeserializer.m5976a(jsonParser, flatBufferBuilder);
                break;
            case (short) 152:
                a3 = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                break;
            case (short) 153:
                a3 = GraphQLNegativeFeedbackActionsEdgeDeserializer.m5418a(jsonParser, flatBufferBuilder);
                break;
            case (short) 154:
                a3 = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                break;
            case (short) 155:
                a3 = GraphQLPostTranslatabilityDeserializer.m5682a(jsonParser, flatBufferBuilder);
                break;
            case (short) 156:
                a3 = GraphQLTranslationMetaDataDeserializer.m6121a(jsonParser, flatBufferBuilder);
                break;
            case (short) 157:
                a3 = GraphQLWithTagsConnectionDeserializer.m6205a(jsonParser, flatBufferBuilder);
                break;
            case (short) 158:
                a3 = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                break;
            case (short) 159:
                a3 = GraphQLRatingDeserializer.m5778a(jsonParser, flatBufferBuilder);
                break;
            case (short) 160:
                a3 = GraphQLPageVisitsConnectionDeserializer.m5533a(jsonParser, flatBufferBuilder);
                break;
            case (short) 161:
                a3 = GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6074a(jsonParser, flatBufferBuilder);
                break;
            case (short) 162:
                a3 = GraphQLSavedDashboardSectionDeserializer.m5859a(jsonParser, flatBufferBuilder);
                break;
            case (short) 163:
                a3 = GraphQLGeoRectangleDeserializer.m4993a(jsonParser, flatBufferBuilder);
                break;
            case (short) 164:
                a3 = GraphQLStreetAddressDeserializer.m5994a(jsonParser, flatBufferBuilder);
                break;
            case (short) 165:
                a3 = GraphQLPlaceRecommendationPostInfoDeserializer.m5660a(jsonParser, flatBufferBuilder);
                break;
            case (short) 166:
                a3 = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                break;
            case (short) 167:
                a3 = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                break;
            case (short) 168:
                a3 = GraphQLLeadGenDataDeserializer.m5283a(jsonParser, flatBufferBuilder);
                break;
            case (short) 169:
                a3 = GraphQLLeadGenInfoFieldDataDeserializer.m5294a(jsonParser, flatBufferBuilder);
                break;
            case (short) 170:
                a3 = GraphQLLeadGenPageDeserializer.m5305a(jsonParser, flatBufferBuilder);
                break;
            case (short) 171:
                a3 = GraphQLLeadGenPrivacyNodeDeserializer.m5309a(jsonParser, flatBufferBuilder);
                break;
            case (short) 172:
                a3 = GraphQLLeadGenLegalContentDeserializer.m5302a(jsonParser, flatBufferBuilder);
                break;
            case (short) 173:
                a3 = GraphQLLeadGenContextPageDeserializer.m5280a(jsonParser, flatBufferBuilder);
                break;
            case (short) 174:
                a3 = GraphQLLeadGenErrorNodeDeserializer.m5289a(jsonParser, flatBufferBuilder);
                break;
            case (short) 175:
                a3 = GraphQLEventCreateActionLinkDeserializer.m4782a(jsonParser, flatBufferBuilder);
                break;
            case (short) 176:
                a3 = GraphQLTemporalEventInfoDeserializer.m6053a(jsonParser, flatBufferBuilder);
                break;
            case (short) 177:
                a3 = GraphQLEventsPendingPostQueueActionLinkDeserializer.m4858a(jsonParser, flatBufferBuilder);
                break;
            case (short) 178:
                a3 = GraphQLEventTicketActionLinkDeserializer.m4827a(jsonParser, flatBufferBuilder);
                break;
            case (short) 179:
                a3 = GraphQLImageOverlayDeserializer.m5226a(jsonParser, flatBufferBuilder);
                break;
            case (short) 180:
                a3 = GraphQLOverlayActionLinkDeserializer.m5470a(jsonParser, flatBufferBuilder);
                break;
            case (short) 181:
                a3 = GraphQLGroupCreationSuggestionCallToActionInfoDeserializer.m5148a(jsonParser, flatBufferBuilder);
                break;
            case (short) 182:
                a3 = GraphQLGroupCreationSuggestionDeserializer.m5154a(jsonParser, flatBufferBuilder);
                break;
            case (short) 183:
                a3 = C0241x3cc57236.m5142a(jsonParser, flatBufferBuilder);
                break;
            case (short) 187:
                a3 = GraphQLLinkOpenActionLinkDeserializer.m5321a(jsonParser, flatBufferBuilder);
                break;
            case (short) 191:
                a3 = GraphQLStoryActionLinkDeserializer.m5948a(jsonParser, flatBufferBuilder);
                break;
            case (short) 192:
                a3 = GraphQLPageLikersConnectionDeserializer.m5509a(jsonParser, flatBufferBuilder);
                break;
            case (short) 193:
                a3 = GraphQLTopicDeserializer.m6113a(jsonParser, flatBufferBuilder);
                break;
            case (short) 194:
                a3 = GraphQLLinkTargetStoreDataDeserializer.m5324a(jsonParser, flatBufferBuilder);
                break;
            case (short) 195:
                a3 = C0239xb10bb428.m4576a(jsonParser, flatBufferBuilder);
                break;
            case (short) 196:
                a3 = GraphQLPrivacyRowInputDeserializer.a(jsonParser, flatBufferBuilder);
                break;
            case (short) 197:
                a3 = GraphQLPrivacyAudienceMemberDeserializer.a(jsonParser, flatBufferBuilder);
                break;
            case (short) 198:
                a3 = GraphQLEditHistoryConnectionDeserializer.m4721a(jsonParser, flatBufferBuilder);
                break;
            case (short) 199:
                a3 = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                break;
            case (short) 200:
                a3 = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                break;
            case (short) 201:
                a3 = GraphQLActivityTemplateTokenDeserializer.m4514a(jsonParser, flatBufferBuilder);
                break;
            case (short) 202:
                a3 = GraphQLStoryAttachmentDeserializer.m5953a(jsonParser, flatBufferBuilder);
                break;
            case (short) 203:
                a3 = GraphQLStoryHeaderDeserializer.m5970a(jsonParser, flatBufferBuilder);
                break;
            case (short) 204:
                a3 = GraphQLOpenGraphMetadataDeserializer.m5462a(jsonParser, flatBufferBuilder);
                break;
            case (short) 205:
                a3 = GraphQLFeedTopicContentDeserializer.m4882a(jsonParser, flatBufferBuilder);
                break;
            case (short) 206:
                a3 = GraphQLStoryTopicsContextDeserializer.m5988a(jsonParser, flatBufferBuilder);
                break;
            case (short) 207:
                a3 = GraphQLAttachmentPropertyDeserializer.m4588a(jsonParser, flatBufferBuilder);
                break;
            case (short) 208:
                a3 = GraphQLFeedbackReactionDeserializer.m4896a(jsonParser, flatBufferBuilder);
                break;
            case (short) 209:
                a3 = GraphQLReactorsOfContentConnectionDeserializer.m5787a(jsonParser, flatBufferBuilder);
                break;
            case (short) 210:
                a3 = GraphQLTopReactionsConnectionDeserializer.m6104a(jsonParser, flatBufferBuilder);
                break;
            case (short) 211:
                a3 = GraphQLTopReactionsEdgeDeserializer.m6107a(jsonParser, flatBufferBuilder);
                break;
            case (short) 212:
                a3 = GraphQLFeedbackRealTimeActivityInfoDeserializer.m4907a(jsonParser, flatBufferBuilder);
                break;
            case (short) 213:
                a3 = GraphQLFeedbackRealTimeActivityActorsConnectionDeserializer.m4904a(jsonParser, flatBufferBuilder);
                break;
            case (short) 214:
                a3 = GraphQLTopLevelCommentsConnectionDeserializer.m6101a(jsonParser, flatBufferBuilder);
                break;
            case (short) 215:
                a3 = GraphQLLikersOfContentConnectionDeserializer.m5318a(jsonParser, flatBufferBuilder);
                break;
            case (short) 216:
                a3 = GraphQLResharesOfContentConnectionDeserializer.m5839a(jsonParser, flatBufferBuilder);
                break;
            case (short) 217:
                a3 = GraphQLBylineFragmentDeserializer.m4632a(jsonParser, flatBufferBuilder);
                break;
            case (short) 218:
                a3 = GraphQLMediaSetMediaConnectionDeserializer.m5358a(jsonParser, flatBufferBuilder);
                break;
            case (short) 219:
                a3 = GraphQLAudioDeserializer.m4600a(jsonParser, flatBufferBuilder);
                break;
            case (short) 220:
                a3 = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                break;
            case (short) 221:
                a3 = GraphQLGreetingCardSlidesConnectionDeserializer.m5133a(jsonParser, flatBufferBuilder);
                break;
            case (short) 222:
                a3 = GraphQLGreetingCardSlideDeserializer.m5127a(jsonParser, flatBufferBuilder);
                break;
            case (short) 223:
                a3 = GraphQLGreetingCardSlidePhotosConnectionDeserializer.m5130a(jsonParser, flatBufferBuilder);
                break;
            case (short) 224:
                a3 = GraphQLVect2Deserializer.m6165a(jsonParser, flatBufferBuilder);
                break;
            case (short) 225:
                a3 = GraphQLGreetingCardTemplateThemeDeserializer.m5139a(jsonParser, flatBufferBuilder);
                break;
            case (short) 226:
                a3 = GraphQLMediaDeserializer.m5338a(jsonParser, flatBufferBuilder);
                break;
            case (short) 227:
                a3 = GraphQLSouvenirMediaConnectionDeserializer.m5906a(jsonParser, flatBufferBuilder);
                break;
            case (short) 228:
                a3 = GraphQLSouvenirMediaEdgeDeserializer.m5909a(jsonParser, flatBufferBuilder);
                break;
            case (short) 229:
                a3 = GraphQLSouvenirMediaElementMediaConnectionDeserializer.m5915a(jsonParser, flatBufferBuilder);
                break;
            case (short) 230:
                a3 = GraphQLSouvenirMediaElementMediaEdgeDeserializer.m5918a(jsonParser, flatBufferBuilder);
                break;
            case (short) 231:
                a3 = GraphQLMediaQuestionOptionsConnectionDeserializer.m5349a(jsonParser, flatBufferBuilder);
                break;
            case (short) 232:
                a3 = GraphQLMediaQuestionOptionsEdgeDeserializer.m5352a(jsonParser, flatBufferBuilder);
                break;
            case (short) 234:
                a3 = GraphQLGoodwillThrowbackDataPointsConnectionDeserializer.m5029a(jsonParser, flatBufferBuilder);
                break;
            case (short) 235:
                a3 = GraphQLGoodwillThrowbackDataPointDeserializer.m5026a(jsonParser, flatBufferBuilder);
                break;
            case (short) 236:
                a3 = GraphQLQuestionOptionsConnectionDeserializer.m5740a(jsonParser, flatBufferBuilder);
                break;
            case (short) 237:
                a3 = GraphQLQuestionOptionVotersConnectionDeserializer.m5737a(jsonParser, flatBufferBuilder);
                break;
            case (short) 239:
                a3 = GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer.m4662a(jsonParser, flatBufferBuilder);
                break;
            case (short) 240:
                a3 = GraphQLLocalContextAttachmentStyleInfoDeserializer.m5327a(jsonParser, flatBufferBuilder);
                break;
            case (short) 241:
                a3 = GraphQLPlaceOpenStatusFormatDeserializer.m5655a(jsonParser, flatBufferBuilder);
                break;
            case (short) 242:
                a3 = GraphQLTimeRangeDeserializer.m6061a(jsonParser, flatBufferBuilder);
                break;
            case (short) 243:
                a3 = GraphQLVideoGuidedTourDeserializer.m6187a(jsonParser, flatBufferBuilder);
                break;
            case (short) 244:
                a3 = GraphQLVideoGuidedTourKeyframeDeserializer.m6190a(jsonParser, flatBufferBuilder);
                break;
            case (short) 245:
                a3 = GraphQLPhotosphereMetadataDeserializer.m5623a(jsonParser, flatBufferBuilder);
                break;
            case (short) 246:
                a3 = GraphQLVideoChannelDeserializer.m6176a(jsonParser, flatBufferBuilder);
                break;
            case (short) 247:
                a3 = GraphQLSubstoriesConnectionDeserializer.m6014a(jsonParser, flatBufferBuilder);
                break;
            case (short) 248:
                a3 = GraphQLPageInfoDeserializer.m5506a(jsonParser, flatBufferBuilder);
                break;
            case (short) 249:
                a3 = GraphQLPagePostPromotionInfoDeserializer.m5518a(jsonParser, flatBufferBuilder);
                break;
            case (short) 250:
                a3 = GraphQLPageAdminInfoDeserializer.m5492a(jsonParser, flatBufferBuilder);
                break;
            case (short) 253:
                a3 = GraphQLAdGeoLocationDeserializer.m4525a(jsonParser, flatBufferBuilder);
                break;
            case (short) 255:
                a3 = GraphQLTimezoneInfoDeserializer.m6098a(jsonParser, flatBufferBuilder);
                break;
            case (short) 256:
                a3 = GraphQLBudgetRecommendationsConnectionDeserializer.m4621a(jsonParser, flatBufferBuilder);
                break;
            case (short) 257:
                a3 = GraphQLBudgetRecommendationsEdgeDeserializer.m4624a(jsonParser, flatBufferBuilder);
                break;
            case (short) 258:
                a3 = GraphQLBudgetRecommendationDataDeserializer.m4618a(jsonParser, flatBufferBuilder);
                break;
            case (short) 259:
                a3 = GraphQLBoostedComponentDeserializer.m4611a(jsonParser, flatBufferBuilder);
                break;
            case (short) 260:
                a3 = GraphQLTargetingDescriptionDeserializer.m6047a(jsonParser, flatBufferBuilder);
                break;
            case (short) 261:
                a3 = GraphQLTargetingDescriptionSentenceDeserializer.m6050a(jsonParser, flatBufferBuilder);
                break;
            case (short) 262:
                a3 = GraphQLStoryInsightsDeserializer.m5973a(jsonParser, flatBufferBuilder);
                break;
            case (short) 263:
                a3 = GraphQLPhoneNumberDeserializer.m5598a(jsonParser, flatBufferBuilder);
                break;
            case (short) 264:
                a3 = GraphQLBoostedComponentMessageDeserializer.m4614a(jsonParser, flatBufferBuilder);
                break;
            case (short) 266:
                a3 = GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer.m5486a(jsonParser, flatBufferBuilder);
                break;
            case (short) 267:
                a3 = GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer.m5489a(jsonParser, flatBufferBuilder);
                break;
            case (short) 268:
                a3 = GraphQLPYMLWithLargeImageFeedUnitItemDeserializer.m5482a(jsonParser, flatBufferBuilder);
                break;
            case (short) 269:
                a3 = GraphQLMutualFriendsConnectionDeserializer.m5380a(jsonParser, flatBufferBuilder);
                break;
            case (short) 270:
                a3 = GraphQLPrivateReplyContextDeserializer.m5708a(jsonParser, flatBufferBuilder);
                break;
            case (short) 271:
                a3 = GraphQLCommentsConnectionDeserializer.m4665a(jsonParser, flatBufferBuilder);
                break;
            case (short) 272:
                a3 = GraphQLNameDeserializer.m5383a(jsonParser, flatBufferBuilder);
                break;
            case (short) 273:
                a3 = GraphQLNamePartDeserializer.m5388a(jsonParser, flatBufferBuilder);
                break;
            case (short) 274:
                a3 = GraphQLInterestingRepliesConnectionDeserializer.m5274a(jsonParser, flatBufferBuilder);
                break;
            case (short) 275:
                a3 = GraphQLSeenByConnectionDeserializer.m5877a(jsonParser, flatBufferBuilder);
                break;
            case (short) 276:
                a3 = GraphQLPhotoFaceBoxesConnectionDeserializer.m5611a(jsonParser, flatBufferBuilder);
                break;
            case (short) 277:
                a3 = GraphQLPhotoTagsConnectionDeserializer.m5617a(jsonParser, flatBufferBuilder);
                break;
            case (short) 278:
                a3 = GraphQLPhotoTagsEdgeDeserializer.m5620a(jsonParser, flatBufferBuilder);
                break;
            case (short) 279:
                a3 = GraphQLPhotoTagDeserializer.m5614a(jsonParser, flatBufferBuilder);
                break;
            case (short) 280:
                a3 = GraphQLBoostedComponentActionLinkDeserializer.m4608a(jsonParser, flatBufferBuilder);
                break;
            case (short) 281:
                a3 = GraphQLErrorDeserializer.m4770a(jsonParser, flatBufferBuilder);
                break;
            case (short) 282:
                a3 = GraphQLRedSpaceStoryInfoDeserializer.m5796a(jsonParser, flatBufferBuilder);
                break;
            case (short) 283:
                a3 = GraphQLReactorsOfContentEdgeDeserializer.m5790a(jsonParser, flatBufferBuilder);
                break;
            case (short) 284:
                a3 = GraphQLInlineStyleAtRangeDeserializer.m5250a(jsonParser, flatBufferBuilder);
                break;
            case (short) 285:
                a3 = GraphQLPageMenuInfoDeserializer.m5512a(jsonParser, flatBufferBuilder);
                break;
            case (short) 286:
                a3 = GraphQLQuantityDeserializer.m5731a(jsonParser, flatBufferBuilder);
                break;
            case (short) 289:
                a3 = GraphQLFriendsEdgeDeserializer.m4948a(jsonParser, flatBufferBuilder);
                break;
            case (short) 290:
                a3 = GraphQLTaggableActivityAllIconsConnectionDeserializer.m6029a(jsonParser, flatBufferBuilder);
                break;
            case (short) 291:
                a3 = GraphQLTaggableActivitySuggestionsEdgeDeserializer.m6044a(jsonParser, flatBufferBuilder);
                break;
            case (short) 292:
                a3 = GraphQLPlaceFlowInfoDeserializer.m5641a(jsonParser, flatBufferBuilder);
                break;
            case (short) 293:
                a3 = GraphQLEntityCardContextItemsEdgeDeserializer.m4760a(jsonParser, flatBufferBuilder);
                break;
            case (short) 294:
                a3 = GraphQLEntityCardContextItemDeserializer.m4750a(jsonParser, flatBufferBuilder);
                break;
            case (short) 295:
                a3 = GraphQLEntityCardContextItemIconDeserializer.m4753a(jsonParser, flatBufferBuilder);
                break;
            case (short) 296:
                a3 = GraphQLEntityCardContextItemLinkDeserializer.m4756a(jsonParser, flatBufferBuilder);
                break;
            case (short) 297:
                a3 = GraphQLApproximateCountDeserializer.m4582a(jsonParser, flatBufferBuilder);
                break;
            case (short) 298:
                a3 = GraphQLEventCategoryDataDeserializer.m4773a(jsonParser, flatBufferBuilder);
                break;
            case (short) 299:
                a3 = GraphQLEventWatchersConnectionDeserializer.m4845a(jsonParser, flatBufferBuilder);
                break;
            case (short) 300:
                a3 = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                break;
            case (short) 301:
                a3 = GraphQLEventInviteesConnectionDeserializer.m4803a(jsonParser, flatBufferBuilder);
                break;
            case (short) 302:
                a3 = GraphQLMediaSetDeserializer.m5355a(jsonParser, flatBufferBuilder);
                break;
            case (short) 303:
                a3 = GraphQLEventHostsConnectionDeserializer.m4797a(jsonParser, flatBufferBuilder);
                break;
            case (short) 304:
                a3 = GraphQLEventHostsEdgeDeserializer.m4800a(jsonParser, flatBufferBuilder);
                break;
            case (short) 305:
                a3 = GraphQLEventViewerCapabilityDeserializer.m4842a(jsonParser, flatBufferBuilder);
                break;
            case (short) 306:
                a3 = GraphQLEventWatchersEdgeDeserializer.m4848a(jsonParser, flatBufferBuilder);
                break;
            case (short) 307:
                a3 = GraphQLEventMaybesConnectionDeserializer.m4810a(jsonParser, flatBufferBuilder);
                break;
            case (short) 308:
                a3 = GraphQLEventMaybesEdgeDeserializer.m4813a(jsonParser, flatBufferBuilder);
                break;
            case (short) 309:
                a3 = GraphQLEventMembersEdgeDeserializer.m4820a(jsonParser, flatBufferBuilder);
                break;
            case (short) 310:
                a3 = GraphQLEventDeclinesConnectionDeserializer.m4785a(jsonParser, flatBufferBuilder);
                break;
            case (short) 311:
                a3 = GraphQLEventInviteesEdgeDeserializer.m4806a(jsonParser, flatBufferBuilder);
                break;
            case (short) 312:
                a3 = GraphQLEventsConnectionDeserializer.m4852a(jsonParser, flatBufferBuilder);
                break;
            case (short) 313:
                a3 = GraphQLGroupMembersConnectionDeserializer.m5169a(jsonParser, flatBufferBuilder);
                break;
            case (short) 314:
                a3 = GraphQLGroupMembersEdgeDeserializer.m5172a(jsonParser, flatBufferBuilder);
                break;
            case (short) 315:
                a3 = GraphQLEventDeclinesEdgeDeserializer.m4788a(jsonParser, flatBufferBuilder);
                break;
            case (short) 316:
                a3 = GraphQLOwnedEventsConnectionDeserializer.m5476a(jsonParser, flatBufferBuilder);
                break;
            case (short) 317:
                a3 = GraphQLEventUserBlockResponsePayloadDeserializer.m4836a(jsonParser, flatBufferBuilder);
                break;
            case (short) 318:
                a3 = GraphQLPagesYouMayLikeFeedUnitItemDeserializer.m5549a(jsonParser, flatBufferBuilder);
                break;
            case (short) 319:
                a3 = GraphQLPagesYouMayLikeFeedUnitItemContentConnectionDeserializer.m5546a(jsonParser, flatBufferBuilder);
                break;
            case (short) 320:
                a3 = GraphQLPeopleYouMayKnowFeedUnitItemDeserializer.m5587a(jsonParser, flatBufferBuilder);
                break;
            case (short) 321:
                a3 = GraphQLSuggestedContentConnectionDeserializer.m6017a(jsonParser, flatBufferBuilder);
                break;
            case (short) 322:
                a3 = GraphQLSuggestedVideoConnectionDeserializer.m6020a(jsonParser, flatBufferBuilder);
                break;
            case (short) 323:
                a3 = GraphQLEventCollectionToItemConnectionDeserializer.m4779a(jsonParser, flatBufferBuilder);
                break;
            case (short) 324:
                a3 = GraphQLStorySetStoriesConnectionDeserializer.m5985a(jsonParser, flatBufferBuilder);
                break;
            case (short) 325:
                a3 = GraphQLFollowUpFeedUnitsConnectionDeserializer.m4922a(jsonParser, flatBufferBuilder);
                break;
            case (short) 326:
                a3 = GraphQLFollowUpFeedUnitsEdgeDeserializer.m4925a(jsonParser, flatBufferBuilder);
                break;
            case (short) 327:
                a3 = GraphQLFriendListFeedConnectionDeserializer.m4928a(jsonParser, flatBufferBuilder);
                break;
            case (short) 328:
                a3 = GraphQLFriendListFeedEdgeDeserializer.m4931a(jsonParser, flatBufferBuilder);
                break;
            case (short) 330:
                a3 = GraphQLHashtagFeedConnectionDeserializer.m5213a(jsonParser, flatBufferBuilder);
                break;
            case (short) 331:
                a3 = GraphQLNewsFeedEdgeDeserializer.m5424a(jsonParser, flatBufferBuilder);
                break;
            case (short) 332:
                a3 = GraphQLInstagramPhotosFromFriendsFeedUnitItemDeserializer.m5257a(jsonParser, flatBufferBuilder);
                break;
            case (short) 333:
                a3 = GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer.m5575a(jsonParser, flatBufferBuilder);
                break;
            case (short) 334:
                a3 = GraphQLPeopleYouMayInviteFeedUnitContactsEdgeDeserializer.m5578a(jsonParser, flatBufferBuilder);
                break;
            case (short) 335:
                a3 = C0245xd2646133.m5566a(jsonParser, flatBufferBuilder);
                break;
            case (short) 336:
                a3 = GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer.m5569a(jsonParser, flatBufferBuilder);
                break;
            case (short) 337:
                a3 = GraphQLUserWorkExperiencesConnectionDeserializer.m6159a(jsonParser, flatBufferBuilder);
                break;
            case (short) 338:
                a3 = GraphQLUserWorkExperiencesEdgeDeserializer.m6162a(jsonParser, flatBufferBuilder);
                break;
            case (short) 339:
                a3 = GraphQLUserEducationExperiencesConnectionDeserializer.m6153a(jsonParser, flatBufferBuilder);
                break;
            case (short) 340:
                a3 = GraphQLUserEducationExperiencesEdgeDeserializer.m6156a(jsonParser, flatBufferBuilder);
                break;
            case (short) 341:
                a3 = GraphQLPeopleToFollowConnectionDeserializer.m5572a(jsonParser, flatBufferBuilder);
                break;
            case (short) 342:
                a3 = GraphQLPeopleYouShouldFollowFeedUnitItemDeserializer.m5595a(jsonParser, flatBufferBuilder);
                break;
            case (short) 343:
                a3 = GraphQLPagesYouMayAdvertiseFeedUnitItemDeserializer.m5539a(jsonParser, flatBufferBuilder);
                break;
            case (short) 344:
                a3 = GraphQLPageBrowserCategoryInfoDeserializer.m5495a(jsonParser, flatBufferBuilder);
                break;
            case (short) 345:
                a3 = GraphQLGroupsYouShouldCreateFeedUnitItemDeserializer.m5197a(jsonParser, flatBufferBuilder);
                break;
            case (short) 346:
                a3 = C0242xc7519942.m5151a(jsonParser, flatBufferBuilder);
                break;
            case (short) 347:
                a3 = GraphQLGroupsYouShouldJoinFeedUnitItemDeserializer.m5205a(jsonParser, flatBufferBuilder);
                break;
            case (short) 348:
                a3 = C0243x81539b2b.m5557a(jsonParser, flatBufferBuilder);
                break;
            case (short) 349:
                a3 = C0244x53cdff0a.m5560a(jsonParser, flatBufferBuilder);
                break;
            case (short) 350:
                a3 = GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer.m4692a(jsonParser, flatBufferBuilder);
                break;
            case (short) 351:
                a3 = GraphQLSavedCollectionFeedUnitItemDeserializer.m5854a(jsonParser, flatBufferBuilder);
                break;
            case (short) 352:
                a3 = GraphQLSocialWifiFeedUnitItemDeserializer.m5898a(jsonParser, flatBufferBuilder);
                break;
            case (short) 353:
                a3 = GraphQLCelebrationsFeedUnitItemDeserializer.m4643a(jsonParser, flatBufferBuilder);
                break;
            case (short) 354:
                a3 = GraphQLStructuredSurveyQuestionsConnectionDeserializer.m6006a(jsonParser, flatBufferBuilder);
                break;
            case (short) 355:
                a3 = GraphQLStructuredSurveyResponseOptionDeserializer.m6009a(jsonParser, flatBufferBuilder);
                break;
            case (short) 356:
                a3 = GraphQLResearchPollQuestionRespondersConnectionDeserializer.m5821a(jsonParser, flatBufferBuilder);
                break;
            case (short) 357:
                a3 = GraphQLResearchPollQuestionResponsesConnectionDeserializer.m5824a(jsonParser, flatBufferBuilder);
                break;
            case (short) 358:
                a3 = GraphQLResearchPollResponseRespondersConnectionDeserializer.m5827a(jsonParser, flatBufferBuilder);
                break;
            case (short) 359:
                a3 = GraphQLResearchPollSurveyQuestionHistoryConnectionDeserializer.m5833a(jsonParser, flatBufferBuilder);
                break;
            case (short) 360:
                a3 = GraphQLFriendLocationFeedUnitItemDeserializer.m4934a(jsonParser, flatBufferBuilder);
                break;
            case (short) 361:
                a3 = GraphQLQuickPromotionFeedUnitItemDeserializer.m5755a(jsonParser, flatBufferBuilder);
                break;
            case (short) 362:
                a3 = GraphQLQuickPromotionCreativeDeserializer.m5746a(jsonParser, flatBufferBuilder);
                break;
            case (short) 363:
                a3 = GraphQLQuickPromotionActionDeserializer.m5743a(jsonParser, flatBufferBuilder);
                break;
            case (short) 364:
                a3 = GraphQLQuickPromotionTemplateDeserializer.m5763a(jsonParser, flatBufferBuilder);
                break;
            case (short) 365:
                a3 = GraphQLQPStringEnumTemplateParameterDeserializer.m5725a(jsonParser, flatBufferBuilder);
                break;
            case (short) 366:
                a3 = GraphQLQPTemplateParameterDeserializer.m5728a(jsonParser, flatBufferBuilder);
                break;
            case (short) 367:
                a3 = GraphQLGoodwillThrowbackPromotedStoriesConnectionDeserializer.m5059a(jsonParser, flatBufferBuilder);
                break;
            case (short) 368:
                a3 = GraphQLGoodwillThrowbackPromotedCampaignsConnectionDeserializer.m5056a(jsonParser, flatBufferBuilder);
                break;
            case (short) 369:
                a3 = C0240xd8bd97ec.m5005a(jsonParser, flatBufferBuilder);
                break;
            case (short) 370:
                a3 = GraphQLGoodwillThrowbackPromotionColorPaletteDeserializer.m5062a(jsonParser, flatBufferBuilder);
                break;
            case (short) 371:
                a3 = GraphQLPlaceReviewFeedUnitItemDeserializer.m5666a(jsonParser, flatBufferBuilder);
                break;
            case (short) 372:
                a3 = GraphQLMobilePageAdminPanelFeedUnitItemDeserializer.m5373a(jsonParser, flatBufferBuilder);
                break;
            case (short) 373:
                a3 = GraphQLAYMTTipDeserializer.m4511a(jsonParser, flatBufferBuilder);
                break;
            case (short) 374:
                a3 = GraphQLFeedbackContextDeserializer.m4889a(jsonParser, flatBufferBuilder);
                break;
            case (short) 376:
                a3 = GraphQLNewsFeedConnectionDeserializer.m5421a(jsonParser, flatBufferBuilder);
                break;
            case (short) 377:
                a3 = GraphQLDebugFeedConnectionDeserializer.m4706a(jsonParser, flatBufferBuilder);
                break;
            case (short) 378:
                a3 = GraphQLDebugFeedEdgeDeserializer.m4709a(jsonParser, flatBufferBuilder);
                break;
            case (short) 380:
                a3 = GraphQLStatelessLargeImagePLAsConnectionDeserializer.m5939a(jsonParser, flatBufferBuilder);
                break;
            case (short) 381:
                a3 = GraphQLStatelessLargeImagePLAsEdgeDeserializer.m5942a(jsonParser, flatBufferBuilder);
                break;
            case (short) 382:
                a3 = GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer.m4528a(jsonParser, flatBufferBuilder);
                break;
            case (short) 383:
                a3 = GraphQLAdditionalSuggestedPostAdItemsEdgeDeserializer.m4531a(jsonParser, flatBufferBuilder);
                break;
            case (short) 384:
                a3 = GraphQLFriendingPossibilitiesConnectionDeserializer.m4939a(jsonParser, flatBufferBuilder);
                break;
            case (short) 385:
                a3 = GraphQLFriendingPossibilitiesEdgeDeserializer.m4942a(jsonParser, flatBufferBuilder);
                break;
            case (short) 387:
                a3 = GraphQLInfoRequestFieldDeserializer.m5241a(jsonParser, flatBufferBuilder);
                break;
            case (short) 388:
                a3 = GraphQLReactionUnitDeserializer.m5784a(jsonParser, flatBufferBuilder);
                break;
            case (short) 389:
                a3 = GraphQLAttributionEntryDeserializer.m4592a(jsonParser, flatBufferBuilder);
                break;
            case (short) 390:
                a3 = GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer.m5933a(jsonParser, flatBufferBuilder);
                break;
            case (short) 391:
                a3 = GraphQLSportsDataMatchToFanFavoriteEdgeDeserializer.m5936a(jsonParser, flatBufferBuilder);
                break;
            case (short) 392:
                a3 = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                break;
            case (short) 393:
                a3 = GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5889a(jsonParser, flatBufferBuilder);
                break;
            case (short) 394:
                a3 = GraphQLSinglePublisherVideoChannelsEdgeDeserializer.m5892a(jsonParser, flatBufferBuilder);
                break;
            case (short) 395:
                a3 = GraphQLGoodwillHappyBirthdayCardDeserializer.m5014a(jsonParser, flatBufferBuilder);
                break;
            case (short) 396:
                a3 = GraphQLGoodwillHappyBirthdayStoriesConnectionDeserializer.m5017a(jsonParser, flatBufferBuilder);
                break;
            case (short) 397:
                a3 = GraphQLGoodwillHappyBirthdayStoriesEdgeDeserializer.m5020a(jsonParser, flatBufferBuilder);
                break;
            case (short) 398:
                a3 = GraphQLGoodwillThrowbackFriendversaryStoryDeserializer.m5044a(jsonParser, flatBufferBuilder);
                break;
            case (short) 399:
                a3 = GraphQLGoodwillThrowbackFriendListConnectionDeserializer.m5035a(jsonParser, flatBufferBuilder);
                break;
            case (short) 400:
                a3 = GraphQLGoodwillThrowbackFriendListEdgeDeserializer.m5038a(jsonParser, flatBufferBuilder);
                break;
            case (short) 401:
                a3 = GraphQLGoodwillThrowbackFriendversaryPromotionStoryDeserializer.m5041a(jsonParser, flatBufferBuilder);
                break;
            case (short) 402:
                a3 = GraphQLGoodwillThrowbackAnniversaryCampaignStoryDeserializer.m5023a(jsonParser, flatBufferBuilder);
                break;
            case (short) 403:
                a3 = GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer.m5053a(jsonParser, flatBufferBuilder);
                break;
            case (short) 404:
                a3 = GraphQLGoodwillThrowbackMissedMemoriesStoryDeserializer.m5047a(jsonParser, flatBufferBuilder);
                break;
            case (short) 405:
                a3 = GraphQLGoodwillThrowbackSectionDeserializer.m5068a(jsonParser, flatBufferBuilder);
                break;
            case (short) 408:
                a3 = GraphQLFeedHomeStoriesDeserializer.m4879a(jsonParser, flatBufferBuilder);
                break;
            case (short) 409:
                a3 = GraphQLFeedUnitEdgeDeserializer.m4885a(jsonParser, flatBufferBuilder);
                break;
            case (short) 410:
                a3 = GraphQLFindFriendsFeedUnitDeserializer.m4910a(jsonParser, flatBufferBuilder);
                break;
            case (short) 411:
                a3 = GraphQLFindGroupsFeedUnitDeserializer.m4913a(jsonParser, flatBufferBuilder);
                break;
            case (short) 412:
                a3 = GraphQLFindPagesFeedUnitDeserializer.m4916a(jsonParser, flatBufferBuilder);
                break;
            case (short) 413:
                a3 = GraphQLNoContentFeedUnitDeserializer.m5430a(jsonParser, flatBufferBuilder);
                break;
            case (short) 414:
                a3 = GraphQLEventsOccurringHereConnectionDeserializer.m4855a(jsonParser, flatBufferBuilder);
                break;
            case (short) 415:
                a3 = GraphQLUnknownFeedUnitDeserializer.m6139a(jsonParser, flatBufferBuilder);
                break;
            case (short) 416:
                a3 = GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer.m5182a(jsonParser, flatBufferBuilder);
                break;
            case (short) 418:
                a3 = GraphQLGroupMessageChattableMembersConnectionDeserializer.m5176a(jsonParser, flatBufferBuilder);
                break;
            case (short) 419:
                a3 = GraphQLGroupMessageChattableMembersEdgeDeserializer.m5179a(jsonParser, flatBufferBuilder);
                break;
            case (short) 420:
                a3 = GraphQLCollectionsRatingFeedUnitItemDeserializer.m4654a(jsonParser, flatBufferBuilder);
                break;
            case (short) 421:
                a3 = GraphQLMegaphoneDeserializer.m5364a(jsonParser, flatBufferBuilder);
                break;
            case (short) 422:
                a3 = GraphQLMegaphoneActionDeserializer.m5361a(jsonParser, flatBufferBuilder);
                break;
            case (short) 423:
                a3 = GraphQLStructuredSurveyConfiguredQuestionDeserializer.m5997a(jsonParser, flatBufferBuilder);
                break;
            case (short) 424:
                a3 = GraphQLFriendsWhoLikeConnectionDeserializer.m4959a(jsonParser, flatBufferBuilder);
                break;
            case (short) 428:
                a3 = GraphQLEventTimeRangeDeserializer.m4833a(jsonParser, flatBufferBuilder);
                break;
            case (short) 437:
                a3 = GraphQLGraphSearchResultDecorationDeserializer.m5106a(jsonParser, flatBufferBuilder);
                break;
            case (short) 438:
                a3 = GraphQLGraphSearchConnectedFriendsConnectionDeserializer.m5074a(jsonParser, flatBufferBuilder);
                break;
            case (short) 439:
                a3 = GraphQLGraphSearchConnectedFriendsEdgeDeserializer.m5077a(jsonParser, flatBufferBuilder);
                break;
            case (short) 440:
                a3 = GraphQLPlacesTileResultsConnectionDeserializer.m5673a(jsonParser, flatBufferBuilder);
                break;
            case (short) 441:
                a3 = GraphQLPlacesTileResultsEdgeDeserializer.m5676a(jsonParser, flatBufferBuilder);
                break;
            case (short) 442:
                a3 = GraphQLPageStarRatersConnectionDeserializer.m5521a(jsonParser, flatBufferBuilder);
                break;
            case (short) 443:
                a3 = GraphQLNearbySearchQueryDeserializer.m5406a(jsonParser, flatBufferBuilder);
                break;
            case (short) 444:
                a3 = GraphQLNearbySearchSuggestionDeserializer.m5409a(jsonParser, flatBufferBuilder);
                break;
            case (short) 445:
                a3 = GraphQLFriendsWhoVisitedConnectionDeserializer.m4962a(jsonParser, flatBufferBuilder);
                break;
            case (short) 446:
                a3 = GraphQLFriendsWhoVisitedEdgeDeserializer.m4965a(jsonParser, flatBufferBuilder);
                break;
            case (short) 447:
                a3 = GraphQLNearbyPlacesBrowsePlaceResultsConnectionDeserializer.m5403a(jsonParser, flatBufferBuilder);
                break;
            case (short) 448:
                a3 = GraphQLNotificationStoriesEdgeDeserializer.m5454a(jsonParser, flatBufferBuilder);
                break;
            case (short) 449:
                a3 = GraphQLNotifOptionRowDeserializer.m5444a(jsonParser, flatBufferBuilder);
                break;
            case (short) 450:
                a3 = GraphQLNotificationStoriesDeltaDeserializer.m5451a(jsonParser, flatBufferBuilder);
                break;
            case (short) 451:
                a3 = GraphQLAllScheduledPostsConnectionDeserializer.m4555a(jsonParser, flatBufferBuilder);
                break;
            case (short) 452:
                a3 = GraphQLPostedPhotosConnectionDeserializer.m5685a(jsonParser, flatBufferBuilder);
                break;
            case (short) 453:
                a3 = GraphQLBusinessInfoDeserializer.m4627a(jsonParser, flatBufferBuilder);
                break;
            case (short) 454:
                a3 = GraphQLAlbumsConnectionDeserializer.m4552a(jsonParser, flatBufferBuilder);
                break;
            case (short) 455:
                a3 = GraphQLFaceBoxTagSuggestionsConnectionDeserializer.m4873a(jsonParser, flatBufferBuilder);
                break;
            case (short) 456:
                a3 = GraphQLFaceBoxTagSuggestionsEdgeDeserializer.m4876a(jsonParser, flatBufferBuilder);
                break;
            case (short) 457:
                a3 = GraphQLPlaceSuggestionInfoDeserializer.m5670a(jsonParser, flatBufferBuilder);
                break;
            case (short) 458:
                a3 = GraphQLAudienceInfoDeserializer.m4597a(jsonParser, flatBufferBuilder);
                break;
            case (short) 459:
                a3 = GraphQLComposerPrivacyGuardrailInfoDeserializer.m4671a(jsonParser, flatBufferBuilder);
                break;
            case (short) 460:
                a3 = GraphQLPrivacyOptionsComposerEdgeDeserializer.m5694a(jsonParser, flatBufferBuilder);
                break;
            case (short) 461:
                a3 = GraphQLPrivacyOptionsComposerConnectionDeserializer.m5691a(jsonParser, flatBufferBuilder);
                break;
            case (short) 462:
                a3 = GraphQLLikedProfilesConnectionDeserializer.m5315a(jsonParser, flatBufferBuilder);
                break;
            case (short) 464:
                a3 = GraphQLTimelineSectionsConnectionDeserializer.m6092a(jsonParser, flatBufferBuilder);
                break;
            case (short) 465:
                a3 = GraphQLTimelineSectionUnitsConnectionDeserializer.m6086a(jsonParser, flatBufferBuilder);
                break;
            case (short) 466:
                a3 = GraphQLTimelineSectionUnitsEdgeDeserializer.m6089a(jsonParser, flatBufferBuilder);
                break;
            case (short) 467:
                a3 = GraphQLGraphSearchResultsConnectionDeserializer.m5109a(jsonParser, flatBufferBuilder);
                break;
            case (short) 468:
                a3 = GraphQLGraphSearchResultsEdgeDeserializer.m5112a(jsonParser, flatBufferBuilder);
                break;
            case (short) 469:
                a3 = GraphQLAllShareStoriesConnectionDeserializer.m4558a(jsonParser, flatBufferBuilder);
                break;
            case (short) 470:
                a3 = GraphQLSearchSuggestionUnitDeserializer.m5868a(jsonParser, flatBufferBuilder);
                break;
            case (short) 471:
                a3 = GraphQLGraphSearchSnippetDeserializer.m5116a(jsonParser, flatBufferBuilder);
                break;
            case (short) 472:
                a3 = GraphQLGraphSearchQueryFilterGroupDeserializer.m5092a(jsonParser, flatBufferBuilder);
                break;
            case (short) 473:
                a3 = GraphQLGraphSearchQueryFilterValueDeserializer.m5097a(jsonParser, flatBufferBuilder);
                break;
            case (short) 474:
                a3 = GraphQLGraphSearchQueryFilterValuesConnectionDeserializer.m5100a(jsonParser, flatBufferBuilder);
                break;
            case (short) 475:
                a3 = GraphQLGraphSearchQueryTitleDeserializer.m5103a(jsonParser, flatBufferBuilder);
                break;
            case (short) 476:
                a3 = GraphQLGraphSearchModulesConnectionDeserializer.m5080a(jsonParser, flatBufferBuilder);
                break;
            case (short) 477:
                a3 = GraphQLSportsDataMatchToFactsConnectionDeserializer.m5930a(jsonParser, flatBufferBuilder);
                break;
            case (short) 478:
                a3 = GraphQLEmotionalAnalysisDeserializer.m4734a(jsonParser, flatBufferBuilder);
                break;
            case (short) 479:
                a3 = GraphQLEmotionalAnalysisItemsConnectionDeserializer.m4740a(jsonParser, flatBufferBuilder);
                break;
            case (short) 480:
                a3 = GraphQLEmotionalAnalysisItemsEdgeDeserializer.m4743a(jsonParser, flatBufferBuilder);
                break;
            case (short) 481:
                a3 = GraphQLEmotionalAnalysisItemDeserializer.m4737a(jsonParser, flatBufferBuilder);
                break;
            case (short) 482:
                a3 = GraphQLPhrasesAnalysisDeserializer.m5626a(jsonParser, flatBufferBuilder);
                break;
            case (short) 483:
                a3 = GraphQLPhrasesAnalysisItemsConnectionDeserializer.m5632a(jsonParser, flatBufferBuilder);
                break;
            case (short) 484:
                a3 = GraphQLPhrasesAnalysisItemsEdgeDeserializer.m5635a(jsonParser, flatBufferBuilder);
                break;
            case (short) 485:
                a3 = GraphQLQuotesAnalysisDeserializer.m5766a(jsonParser, flatBufferBuilder);
                break;
            case (short) 486:
                a3 = GraphQLQuotesAnalysisItemsConnectionDeserializer.m5772a(jsonParser, flatBufferBuilder);
                break;
            case (short) 487:
                a3 = GraphQLQuotesAnalysisItemsEdgeDeserializer.m5775a(jsonParser, flatBufferBuilder);
                break;
            case (short) 488:
                a3 = GraphQLQuotesAnalysisItemDeserializer.m5769a(jsonParser, flatBufferBuilder);
                break;
            case (short) 489:
                a3 = GraphQLTrendingEntitiesEdgeDeserializer.m6124a(jsonParser, flatBufferBuilder);
                break;
            case (short) 490:
                a3 = GraphQLSearchSuggestionsConnectionDeserializer.m5871a(jsonParser, flatBufferBuilder);
                break;
            case (short) 491:
                a3 = GraphQLSearchSuggestionsEdgeDeserializer.m5874a(jsonParser, flatBufferBuilder);
                break;
            case (short) 494:
                a3 = GraphQLAppAdStoriesSideFeedConnectionDeserializer.m4564a(jsonParser, flatBufferBuilder);
                break;
            case (short) 495:
                a3 = GraphQLAppAdStoriesSideFeedEdgeDeserializer.m4567a(jsonParser, flatBufferBuilder);
                break;
            case (short) 496:
                a3 = GraphQLSideFeedConnectionDeserializer.m5880a(jsonParser, flatBufferBuilder);
                break;
            case (short) 497:
                a3 = GraphQLSideFeedEdgeDeserializer.m5883a(jsonParser, flatBufferBuilder);
                break;
            case (short) 498:
                a3 = GraphQLTimelineAppCollectionsConnectionDeserializer.m6077a(jsonParser, flatBufferBuilder);
                break;
            case (short) 499:
                a3 = GraphQLUnseenStoriesConnectionDeserializer.m6142a(jsonParser, flatBufferBuilder);
                break;
            case (short) 500:
                a3 = GraphQLInteractorsConnectionDeserializer.m5271a(jsonParser, flatBufferBuilder);
                break;
            case (short) 501:
                a3 = GraphQLVideoChannelFeedEdgeDeserializer.m6179a(jsonParser, flatBufferBuilder);
                break;
            case (short) 502:
                a3 = GraphQLStoryAttachmentStyleInfoDeserializer.m5958a(jsonParser, flatBufferBuilder);
                break;
            case (short) 503:
                a3 = GraphQLOverlayCallToActionInfoDeserializer.m5473a(jsonParser, flatBufferBuilder);
                break;
            case (short) 504:
                a3 = GraphQLAYMTNativeMobileActionDeserializer.m4508a(jsonParser, flatBufferBuilder);
                break;
            case (short) 505:
                a3 = GraphQLGoodwillCampaignDeserializer.m5008a(jsonParser, flatBufferBuilder);
                break;
            case (short) 506:
                a3 = GraphQLGoodwillThrowbackFeedUnitDeserializer.m5032a(jsonParser, flatBufferBuilder);
                break;
            case (short) 507:
                a3 = GraphQLNotifOptionRowDisplayDeserializer.m5448a(jsonParser, flatBufferBuilder);
                break;
            case (short) 508:
                a3 = GraphQLGraphSearchQueryFilterCustomValueDeserializer.m5086a(jsonParser, flatBufferBuilder);
                break;
            case (short) 509:
                a3 = GraphQLSideFeedUnitDeserializer.m5886a(jsonParser, flatBufferBuilder);
                break;
            case (short) 510:
                a3 = GraphQLReactionPostPivotComponentDeserializer.m5781a(jsonParser, flatBufferBuilder);
                break;
            case (short) 511:
                a3 = GraphQLFundraiserCharityDeserializer.m4975a(jsonParser, flatBufferBuilder);
                break;
            case (short) 512:
                a3 = GraphQLFundraiserPersonToCharityDeserializer.m4981a(jsonParser, flatBufferBuilder);
                break;
            case (short) 513:
                a3 = GraphQLSaleGroupsNearYouFeedUnitDeserializer.m5842a(jsonParser, flatBufferBuilder);
                break;
            case (short) 514:
                a3 = GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer.m5845a(jsonParser, flatBufferBuilder);
                break;
            case (short) 515:
                a3 = GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeDeserializer.m5848a(jsonParser, flatBufferBuilder);
                break;
            case (short) 518:
                a3 = GraphQLPlaceListItemsFromPlaceListConnectionDeserializer.m5652a(jsonParser, flatBufferBuilder);
                break;
            case (short) 519:
                a3 = GraphQLVideoTimestampedCommentsConnectionDeserializer.m6193a(jsonParser, flatBufferBuilder);
                break;
            case (short) 520:
                a3 = GraphQLVideoTimestampedCommentsEdgeDeserializer.m6196a(jsonParser, flatBufferBuilder);
                break;
            case (short) 521:
                a3 = GraphQLFundraiserToCharityDeserializer.m4987a(jsonParser, flatBufferBuilder);
                break;
            case (short) 522:
                a3 = GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer.m5760a(jsonParser, flatBufferBuilder);
                break;
            case (short) 523:
                a3 = GraphQLViewerVisitsConnectionDeserializer.m6202a(jsonParser, flatBufferBuilder);
                break;
            case (short) 524:
                a3 = GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer.m4984a(jsonParser, flatBufferBuilder);
                break;
            case (short) 525:
                a3 = GraphQLProductItemDeserializer.m5711a(jsonParser, flatBufferBuilder);
                break;
            case (short) 526:
                a3 = GraphQLEventViewActionLinkDeserializer.m4839a(jsonParser, flatBufferBuilder);
                break;
            case (short) 527:
                a3 = GraphQLMessengerContentSubscriptionOptionDeserializer.m5367a(jsonParser, flatBufferBuilder);
                break;
            case (short) 529:
                a3 = GraphQLLeadGenActionLinkDeserializer.m5277a(jsonParser, flatBufferBuilder);
                break;
            case (short) 530:
                a3 = GraphQLTrueTopicFeedOptionDeserializer.m6130a(jsonParser, flatBufferBuilder);
                break;
            case (short) 531:
                a3 = GraphQLTopicCustomizationStoryDeserializer.m6110a(jsonParser, flatBufferBuilder);
                break;
            case (short) 532:
                a3 = GraphQLTrueTopicFeedOptionsConnectionDeserializer.m6133a(jsonParser, flatBufferBuilder);
                break;
            case (short) 533:
                a3 = GraphQLTrueTopicFeedOptionsEdgeDeserializer.m6136a(jsonParser, flatBufferBuilder);
                break;
            case (short) 534:
                a3 = GraphQLTopicFeedOptionDeserializer.m6118a(jsonParser, flatBufferBuilder);
                break;
            case (short) 539:
                a3 = GraphQLGoodwillVideoCampaignDeserializer.m5071a(jsonParser, flatBufferBuilder);
                break;
            case (short) 540:
                a3 = GraphQLPageOutcomeButtonDeserializer.m5515a(jsonParser, flatBufferBuilder);
                break;
            case (short) 541:
                a3 = GraphQLInstreamVideoAdsConnectionDeserializer.m5268a(jsonParser, flatBufferBuilder);
                break;
            case (short) 542:
                a3 = GraphQLRelevantReactorsConnectionDeserializer.m5804a(jsonParser, flatBufferBuilder);
                break;
            case (short) 543:
                a3 = GraphQLRelevantReactorsEdgeDeserializer.m5807a(jsonParser, flatBufferBuilder);
                break;
            case (short) 544:
                a3 = GraphQLConfigurationDeserializer.m4674a(jsonParser, flatBufferBuilder);
                break;
            case (short) 545:
                a3 = GraphQLGroupConfigurationsConnectionDeserializer.m5145a(jsonParser, flatBufferBuilder);
                break;
            case (short) 546:
                a3 = GraphQLWorkCommunityTrendingFeedUnitDeserializer.m6208a(jsonParser, flatBufferBuilder);
                break;
            case (short) 547:
                a3 = GraphQLWorkCommunityTrendingFeedUnitItemDeserializer.m6211a(jsonParser, flatBufferBuilder);
                break;
            case (short) 548:
                a3 = GraphQLGroupMemberWelcomeCallToActionInfoDeserializer.m5166a(jsonParser, flatBufferBuilder);
                break;
            case (short) 549:
                a3 = GraphQLGroupTopStoriesFeedUnitDeserializer.m5185a(jsonParser, flatBufferBuilder);
                break;
            case (short) 550:
                a3 = GraphQLGroupTopStoriesFeedUnitStoriesConnectionDeserializer.m5188a(jsonParser, flatBufferBuilder);
                break;
            case (short) 551:
                a3 = GraphQLGroupTopStoriesFeedUnitStoriesEdgeDeserializer.m5191a(jsonParser, flatBufferBuilder);
                break;
            case (short) 552:
                a3 = GraphQLRedSpaceActivityDeserializer.m5793a(jsonParser, flatBufferBuilder);
                break;
            case (short) 553:
                a3 = GraphQLNativeTemplateViewDeserializer.m5400a(jsonParser, flatBufferBuilder);
                break;
            case (short) 554:
                a3 = GraphQLImportantReactorsConnectionDeserializer.m5231a(jsonParser, flatBufferBuilder);
                break;
            case (short) 555:
                a3 = GraphQLVideoAnnotationDeserializer.m6168a(jsonParser, flatBufferBuilder);
                break;
            case (short) 556:
                a3 = GraphQLTimelineStoriesConnectionDeserializer.m6095a(jsonParser, flatBufferBuilder);
                break;
            case (short) 557:
                a3 = GraphQLGroupMallAdsEducationInfoDeserializer.m5160a(jsonParser, flatBufferBuilder);
                break;
            case (short) 558:
                a3 = GraphQLProfileVideoDeserializer.m5722a(jsonParser, flatBufferBuilder);
                break;
            case (short) 559:
                a3 = GraphQLNoContentGoodFriendsFeedUnitDeserializer.m5433a(jsonParser, flatBufferBuilder);
                break;
            case (short) 560:
                a3 = GraphQLGroupMallHoistedStoriesActionLinkDeserializer.m5163a(jsonParser, flatBufferBuilder);
                break;
            case (short) 561:
                a3 = GraphQLDocumentElementDeserializer.m4715a(jsonParser, flatBufferBuilder);
                break;
            case (short) 562:
                a3 = GraphQLPageStoriesYouMissedFeedUnitDeserializer.m5524a(jsonParser, flatBufferBuilder);
                break;
            case (short) 563:
                a3 = GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionDeserializer.m5527a(jsonParser, flatBufferBuilder);
                break;
            case (short) 564:
                a3 = GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeDeserializer.m5530a(jsonParser, flatBufferBuilder);
                break;
            case (short) 565:
                a3 = GraphQLNmorTwoCTwoPCashResponseDeserializer.m5427a(jsonParser, flatBufferBuilder);
                break;
            case (short) 566:
                a3 = GraphQLPlaceListItemToRecommendingCommentsConnectionDeserializer.m5649a(jsonParser, flatBufferBuilder);
                break;
            case (short) 567:
                a3 = GraphQLGamesInstantPlayStyleInfoDeserializer.m4990a(jsonParser, flatBufferBuilder);
                break;
            case (short) 568:
                a3 = GraphQLEventTicketProviderDeserializer.m4830a(jsonParser, flatBufferBuilder);
                break;
            case (short) 569:
                a3 = GraphQLFriendsLocationsClusterDeserializer.m4952a(jsonParser, flatBufferBuilder);
                break;
            case (short) 570:
                a3 = GraphQLNativeTemplateBundleDeserializer.m5391a(jsonParser, flatBufferBuilder);
                break;
            case (short) 571:
                a3 = GraphQLNativeTemplateDefaultViewControllerDeserializer.m5394a(jsonParser, flatBufferBuilder);
                break;
            case (short) 572:
                a3 = GraphQLContactPointDeserializer.m4680a(jsonParser, flatBufferBuilder);
                break;
            case (short) 573:
                a3 = GraphQLNativeTemplateViewControllerDeserializer.m5397a(jsonParser, flatBufferBuilder);
                break;
            case (short) 574:
                a3 = GraphQLPageCallToActionDeserializer.m5498a(jsonParser, flatBufferBuilder);
                break;
            case (short) 575:
                a3 = GraphQLWriteReviewActionLinkDeserializer.m6219a(jsonParser, flatBufferBuilder);
                break;
            case (short) 576:
                a3 = GraphQLGoodwillThrowbackOriginalPostActionLinkDeserializer.m5050a(jsonParser, flatBufferBuilder);
                break;
            case (short) 577:
                a3 = GraphQLAdsExperienceInjectResponsePayloadDeserializer.m4537a(jsonParser, flatBufferBuilder);
                break;
            case (short) 578:
                a3 = GraphQLAdsExperienceDeclineResponsePayloadDeserializer.m4534a(jsonParser, flatBufferBuilder);
                break;
            case (short) 579:
                a3 = GraphQLAdsExperienceRemoveResponsePayloadDeserializer.m4540a(jsonParser, flatBufferBuilder);
                break;
            case (short) 580:
                a3 = GraphQLIncomingFriendRequestFeedUnitDeserializer.m5234a(jsonParser, flatBufferBuilder);
                break;
            case (short) 581:
                a3 = GraphQLIncomingFriendRequestFeedUnitItemDeserializer.m5237a(jsonParser, flatBufferBuilder);
                break;
            case (short) 582:
                a3 = GraphQLBackdatedTimeDeserializer.m4605a(jsonParser, flatBufferBuilder);
                break;
            case (short) 583:
                a3 = GraphQLClashUnitDeserializer.m4648a(jsonParser, flatBufferBuilder);
                break;
            case (short) 584:
                a3 = GraphQLEligibleClashUnitsConnectionDeserializer.m4728a(jsonParser, flatBufferBuilder);
                break;
            case (short) 585:
                a3 = GraphQLEligibleClashUnitsEdgeDeserializer.m4731a(jsonParser, flatBufferBuilder);
                break;
            default:
                a3 = GraphQLUnknownFeedUnitDeserializer.m6139a(jsonParser, flatBufferBuilder);
                break;
        }
        int i = a3;
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, a2, 0);
        flatBufferBuilder.b(1, i);
        return flatBufferBuilder.d();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m4504a(com.facebook.flatbuffers.MutableFlatBuffer r4, int r5, int r6, com.fasterxml.jackson.core.JsonGenerator r7, com.fasterxml.jackson.databind.SerializerProvider r8) {
        /*
        r3 = 0;
        r0 = r4.g(r5, r6);
        r1 = r4.a(r0, r3, r3);
        r2 = 1;
        r0 = r4.a(r0, r2, r3);
        switch(r1) {
            case 1: goto L_0x03a8;
            case 2: goto L_0x060f;
            case 3: goto L_0x0021;
            case 4: goto L_0x063c;
            case 5: goto L_0x02b2;
            case 6: goto L_0x0024;
            case 7: goto L_0x0039;
            case 8: goto L_0x04da;
            case 9: goto L_0x04dd;
            case 10: goto L_0x04e9;
            case 11: goto L_0x0015;
            case 12: goto L_0x005d;
            case 13: goto L_0x00b1;
            case 14: goto L_0x00b7;
            case 15: goto L_0x0162;
            case 16: goto L_0x0011;
            case 17: goto L_0x00d2;
            case 18: goto L_0x02d6;
            case 19: goto L_0x02d9;
            case 20: goto L_0x00a8;
            case 21: goto L_0x00d8;
            case 22: goto L_0x010b;
            case 23: goto L_0x0138;
            case 24: goto L_0x00de;
            case 25: goto L_0x064b;
            case 26: goto L_0x015c;
            case 27: goto L_0x055b;
            case 28: goto L_0x02fa;
            case 29: goto L_0x0303;
            case 30: goto L_0x00c9;
            case 31: goto L_0x0576;
            case 32: goto L_0x0573;
            case 33: goto L_0x0063;
            case 34: goto L_0x021f;
            case 35: goto L_0x03e1;
            case 36: goto L_0x03f6;
            case 37: goto L_0x03ea;
            case 38: goto L_0x0405;
            case 39: goto L_0x04d7;
            case 40: goto L_0x0567;
            case 41: goto L_0x060c;
            case 42: goto L_0x0627;
            case 43: goto L_0x0177;
            case 44: goto L_0x009f;
            case 45: goto L_0x0180;
            case 46: goto L_0x0011;
            case 47: goto L_0x01da;
            case 48: goto L_0x01e0;
            case 49: goto L_0x01e9;
            case 50: goto L_0x0011;
            case 51: goto L_0x00c3;
            case 52: goto L_0x0252;
            case 53: goto L_0x0261;
            case 54: goto L_0x0267;
            case 55: goto L_0x0011;
            case 56: goto L_0x0011;
            case 57: goto L_0x0585;
            case 58: goto L_0x058b;
            case 59: goto L_0x02a6;
            case 60: goto L_0x02ee;
            case 61: goto L_0x0318;
            case 62: goto L_0x031e;
            case 63: goto L_0x0321;
            case 64: goto L_0x0011;
            case 65: goto L_0x0558;
            case 66: goto L_0x02ca;
            case 67: goto L_0x05a3;
            case 68: goto L_0x05a9;
            case 69: goto L_0x033f;
            case 70: goto L_0x015f;
            case 71: goto L_0x0011;
            case 72: goto L_0x0360;
            case 73: goto L_0x0054;
            case 74: goto L_0x037b;
            case 75: goto L_0x038a;
            case 76: goto L_0x0390;
            case 77: goto L_0x00ba;
            case 78: goto L_0x0543;
            case 79: goto L_0x0546;
            case 80: goto L_0x0411;
            case 81: goto L_0x040e;
            case 82: goto L_0x003f;
            case 83: goto L_0x0011;
            case 84: goto L_0x0165;
            case 85: goto L_0x0621;
            case 86: goto L_0x0435;
            case 87: goto L_0x0453;
            case 88: goto L_0x0462;
            case 89: goto L_0x0480;
            case 90: goto L_0x048f;
            case 91: goto L_0x0498;
            case 92: goto L_0x0507;
            case 93: goto L_0x0234;
            case 94: goto L_0x0426;
            case 95: goto L_0x0231;
            case 96: goto L_0x050a;
            case 97: goto L_0x0011;
            case 98: goto L_0x01c2;
            case 99: goto L_0x01c8;
            case 100: goto L_0x052e;
            case 101: goto L_0x0537;
            case 102: goto L_0x05c1;
            case 103: goto L_0x05c4;
            case 104: goto L_0x05d0;
            case 105: goto L_0x05cd;
            case 106: goto L_0x05fa;
            case 107: goto L_0x008d;
            case 108: goto L_0x0378;
            case 109: goto L_0x01aa;
            case 110: goto L_0x0315;
            case 111: goto L_0x0090;
            case 112: goto L_0x01b3;
            case 113: goto L_0x029a;
            case 114: goto L_0x02a0;
            case 115: goto L_0x02d0;
            case 116: goto L_0x0011;
            case 117: goto L_0x0339;
            case 118: goto L_0x0444;
            case 119: goto L_0x03d2;
            case 120: goto L_0x03ff;
            case 121: goto L_0x00bd;
            case 122: goto L_0x039c;
            case 123: goto L_0x03d8;
            case 124: goto L_0x04a1;
            case 125: goto L_0x04fe;
            case 126: goto L_0x0528;
            case 127: goto L_0x02ac;
            case 128: goto L_0x059d;
            case 129: goto L_0x01dd;
            case 130: goto L_0x0255;
            case 131: goto L_0x0099;
            case 132: goto L_0x0111;
            case 133: goto L_0x05bb;
            case 134: goto L_0x00f6;
            case 135: goto L_0x00f3;
            case 136: goto L_0x04ce;
            case 137: goto L_0x0057;
            case 138: goto L_0x003c;
            case 139: goto L_0x004b;
            case 140: goto L_0x02b5;
            case 141: goto L_0x0105;
            case 142: goto L_0x0474;
            case 143: goto L_0x02af;
            case 144: goto L_0x045f;
            case 145: goto L_0x04ef;
            case 146: goto L_0x05a0;
            case 147: goto L_0x01bf;
            case 148: goto L_0x046b;
            case 149: goto L_0x046e;
            case 150: goto L_0x0570;
            case 151: goto L_0x0011;
            case 152: goto L_0x0363;
            case 153: goto L_0x0366;
            case 154: goto L_0x047d;
            case 155: goto L_0x0456;
            case 156: goto L_0x05f4;
            case 157: goto L_0x0642;
            case 158: goto L_0x042f;
            case 159: goto L_0x04b9;
            case 160: goto L_0x03cf;
            case 161: goto L_0x05c7;
            case 162: goto L_0x0504;
            case 163: goto L_0x01d7;
            case 164: goto L_0x0582;
            case 165: goto L_0x0441;
            case 166: goto L_0x0540;
            case 167: goto L_0x0192;
            case 168: goto L_0x02eb;
            case 169: goto L_0x02f4;
            case 170: goto L_0x02fd;
            case 171: goto L_0x0300;
            case 172: goto L_0x02f7;
            case 173: goto L_0x02e8;
            case 174: goto L_0x02f1;
            case 175: goto L_0x0117;
            case 176: goto L_0x05b8;
            case 177: goto L_0x0159;
            case 178: goto L_0x013b;
            case 179: goto L_0x02b8;
            case 180: goto L_0x0393;
            case 181: goto L_0x0273;
            case 182: goto L_0x0270;
            case 183: goto L_0x026a;
            case 184: goto L_0x0011;
            case 185: goto L_0x0011;
            case 186: goto L_0x0011;
            case 187: goto L_0x030c;
            case 188: goto L_0x0011;
            case 189: goto L_0x0011;
            case 190: goto L_0x0011;
            case 191: goto L_0x055e;
            case 192: goto L_0x03b7;
            case 193: goto L_0x05eb;
            case 194: goto L_0x030f;
            case 195: goto L_0x005a;
            case 196: goto L_0x0471;
            case 197: goto L_0x045c;
            case 198: goto L_0x00db;
            case 199: goto L_0x02c7;
            case 200: goto L_0x05ac;
            case 201: goto L_0x001e;
            case 202: goto L_0x0561;
            case 203: goto L_0x056a;
            case 204: goto L_0x038d;
            case 205: goto L_0x0171;
            case 206: goto L_0x057c;
            case 207: goto L_0x0066;
            case 208: goto L_0x017d;
            case 209: goto L_0x04c2;
            case 210: goto L_0x05e5;
            case 211: goto L_0x05e8;
            case 212: goto L_0x0186;
            case 213: goto L_0x0183;
            case 214: goto L_0x05e2;
            case 215: goto L_0x0309;
            case 216: goto L_0x04f2;
            case 217: goto L_0x008a;
            case 218: goto L_0x032d;
            case 219: goto L_0x006f;
            case 220: goto L_0x00c6;
            case 221: goto L_0x025e;
            case 222: goto L_0x0258;
            case 223: goto L_0x025b;
            case 224: goto L_0x061e;
            case 225: goto L_0x0264;
            case 226: goto L_0x031b;
            case 227: goto L_0x0531;
            case 228: goto L_0x0534;
            case 229: goto L_0x053a;
            case 230: goto L_0x053d;
            case 231: goto L_0x0324;
            case 232: goto L_0x0327;
            case 233: goto L_0x0011;
            case 234: goto L_0x01fb;
            case 235: goto L_0x01f8;
            case 236: goto L_0x0495;
            case 237: goto L_0x0492;
            case 238: goto L_0x0011;
            case 239: goto L_0x00a2;
            case 240: goto L_0x0312;
            case 241: goto L_0x043e;
            case 242: goto L_0x05be;
            case 243: goto L_0x0630;
            case 244: goto L_0x0633;
            case 245: goto L_0x0420;
            case 246: goto L_0x062a;
            case 247: goto L_0x0594;
            case 248: goto L_0x03b4;
            case 249: goto L_0x03c0;
            case 250: goto L_0x03ab;
            case 251: goto L_0x0011;
            case 252: goto L_0x0011;
            case 253: goto L_0x0027;
            case 254: goto L_0x0011;
            case 255: goto L_0x05df;
            case 256: goto L_0x0081;
            case 257: goto L_0x0084;
            case 258: goto L_0x007e;
            case 259: goto L_0x0075;
            case 260: goto L_0x05b2;
            case 261: goto L_0x05b5;
            case 262: goto L_0x056d;
            case 263: goto L_0x040b;
            case 264: goto L_0x007b;
            case 265: goto L_0x0011;
            case 266: goto L_0x03a2;
            case 267: goto L_0x03a5;
            case 268: goto L_0x039f;
            case 269: goto L_0x0342;
            case 270: goto L_0x0477;
            case 271: goto L_0x00a5;
            case 272: goto L_0x0345;
            case 273: goto L_0x0348;
            case 274: goto L_0x02e2;
            case 275: goto L_0x0516;
            case 276: goto L_0x0414;
            case 277: goto L_0x041a;
            case 278: goto L_0x041d;
            case 279: goto L_0x0417;
            case 280: goto L_0x0078;
            case 281: goto L_0x0108;
            case 282: goto L_0x04cb;
            case 283: goto L_0x04c5;
            case 284: goto L_0x02cd;
            case 285: goto L_0x03ba;
            case 286: goto L_0x048c;
            case 287: goto L_0x0011;
            case 288: goto L_0x0011;
            case 289: goto L_0x01ad;
            case 290: goto L_0x05a6;
            case 291: goto L_0x05af;
            case 292: goto L_0x0432;
            case 293: goto L_0x0102;
            case 294: goto L_0x00f9;
            case 295: goto L_0x00fc;
            case 296: goto L_0x00ff;
            case 297: goto L_0x0060;
            case 298: goto L_0x010e;
            case 299: goto L_0x014d;
            case 300: goto L_0x0132;
            case 301: goto L_0x0126;
            case 302: goto L_0x032a;
            case 303: goto L_0x0120;
            case 304: goto L_0x0123;
            case 305: goto L_0x014a;
            case 306: goto L_0x0150;
            case 307: goto L_0x012c;
            case 308: goto L_0x012f;
            case 309: goto L_0x0135;
            case 310: goto L_0x011a;
            case 311: goto L_0x0129;
            case 312: goto L_0x0153;
            case 313: goto L_0x0282;
            case 314: goto L_0x0285;
            case 315: goto L_0x011d;
            case 316: goto L_0x0399;
            case 317: goto L_0x0144;
            case 318: goto L_0x03db;
            case 319: goto L_0x03de;
            case 320: goto L_0x0402;
            case 321: goto L_0x0597;
            case 322: goto L_0x059a;
            case 323: goto L_0x0114;
            case 324: goto L_0x0579;
            case 325: goto L_0x0195;
            case 326: goto L_0x0198;
            case 327: goto L_0x019b;
            case 328: goto L_0x019e;
            case 329: goto L_0x0011;
            case 330: goto L_0x02a9;
            case 331: goto L_0x036c;
            case 332: goto L_0x02d3;
            case 333: goto L_0x03f9;
            case 334: goto L_0x03fc;
            case 335: goto L_0x03ed;
            case 336: goto L_0x03f0;
            case 337: goto L_0x0618;
            case 338: goto L_0x061b;
            case 339: goto L_0x0612;
            case 340: goto L_0x0615;
            case 341: goto L_0x03f3;
            case 342: goto L_0x0408;
            case 343: goto L_0x03d5;
            case 344: goto L_0x03ae;
            case 345: goto L_0x029d;
            case 346: goto L_0x0276;
            case 347: goto L_0x02a3;
            case 348: goto L_0x03e4;
            case 349: goto L_0x03e7;
            case 350: goto L_0x00c0;
            case 351: goto L_0x0501;
            case 352: goto L_0x052b;
            case 353: goto L_0x0093;
            case 354: goto L_0x058e;
            case 355: goto L_0x0591;
            case 356: goto L_0x04e0;
            case 357: goto L_0x04e3;
            case 358: goto L_0x04e6;
            case 359: goto L_0x04ec;
            case 360: goto L_0x01a1;
            case 361: goto L_0x04a4;
            case 362: goto L_0x049e;
            case 363: goto L_0x049b;
            case 364: goto L_0x04aa;
            case 365: goto L_0x0486;
            case 366: goto L_0x0489;
            case 367: goto L_0x0219;
            case 368: goto L_0x0216;
            case 369: goto L_0x01e3;
            case 370: goto L_0x021c;
            case 371: goto L_0x0447;
            case 372: goto L_0x033c;
            case 373: goto L_0x001b;
            case 374: goto L_0x017a;
            case 375: goto L_0x0011;
            case 376: goto L_0x0369;
            case 377: goto L_0x00cc;
            case 378: goto L_0x00cf;
            case 379: goto L_0x0011;
            case 380: goto L_0x0552;
            case 381: goto L_0x0555;
            case 382: goto L_0x002a;
            case 383: goto L_0x002d;
            case 384: goto L_0x01a4;
            case 385: goto L_0x01a7;
            case 386: goto L_0x0011;
            case 387: goto L_0x02c4;
            case 388: goto L_0x04bf;
            case 389: goto L_0x0069;
            case 390: goto L_0x054c;
            case 391: goto L_0x054f;
            case 392: goto L_0x057f;
            case 393: goto L_0x0522;
            case 394: goto L_0x0525;
            case 395: goto L_0x01ec;
            case 396: goto L_0x01ef;
            case 397: goto L_0x01f2;
            case 398: goto L_0x020a;
            case 399: goto L_0x0201;
            case 400: goto L_0x0204;
            case 401: goto L_0x0207;
            case 402: goto L_0x01f5;
            case 403: goto L_0x0213;
            case 404: goto L_0x020d;
            case 405: goto L_0x0222;
            case 406: goto L_0x0011;
            case 407: goto L_0x0011;
            case 408: goto L_0x016e;
            case 409: goto L_0x0174;
            case 410: goto L_0x0189;
            case 411: goto L_0x018c;
            case 412: goto L_0x018f;
            case 413: goto L_0x0372;
            case 414: goto L_0x0156;
            case 415: goto L_0x0606;
            case 416: goto L_0x028e;
            case 417: goto L_0x0011;
            case 418: goto L_0x0288;
            case 419: goto L_0x028b;
            case 420: goto L_0x009c;
            case 421: goto L_0x0330;
            case 422: goto L_0x0333;
            case 423: goto L_0x0588;
            case 424: goto L_0x01b6;
            case 425: goto L_0x0011;
            case 426: goto L_0x0011;
            case 427: goto L_0x0011;
            case 428: goto L_0x0141;
            case 429: goto L_0x0011;
            case 430: goto L_0x0011;
            case 431: goto L_0x0011;
            case 432: goto L_0x0011;
            case 433: goto L_0x0011;
            case 434: goto L_0x0011;
            case 435: goto L_0x0011;
            case 436: goto L_0x0011;
            case 437: goto L_0x0246;
            case 438: goto L_0x0228;
            case 439: goto L_0x022b;
            case 440: goto L_0x044d;
            case 441: goto L_0x0450;
            case 442: goto L_0x03c3;
            case 443: goto L_0x035a;
            case 444: goto L_0x035d;
            case 445: goto L_0x01b9;
            case 446: goto L_0x01bc;
            case 447: goto L_0x0357;
            case 448: goto L_0x0387;
            case 449: goto L_0x037e;
            case 450: goto L_0x0384;
            case 451: goto L_0x0045;
            case 452: goto L_0x0459;
            case 453: goto L_0x0087;
            case 454: goto L_0x0042;
            case 455: goto L_0x0168;
            case 456: goto L_0x016b;
            case 457: goto L_0x044a;
            case 458: goto L_0x006c;
            case 459: goto L_0x00ab;
            case 460: goto L_0x0468;
            case 461: goto L_0x0465;
            case 462: goto L_0x0306;
            case 463: goto L_0x0011;
            case 464: goto L_0x05d9;
            case 465: goto L_0x05d3;
            case 466: goto L_0x05d6;
            case 467: goto L_0x0249;
            case 468: goto L_0x024c;
            case 469: goto L_0x0048;
            case 470: goto L_0x050d;
            case 471: goto L_0x024f;
            case 472: goto L_0x023a;
            case 473: goto L_0x023d;
            case 474: goto L_0x0240;
            case 475: goto L_0x0243;
            case 476: goto L_0x022e;
            case 477: goto L_0x0549;
            case 478: goto L_0x00e7;
            case 479: goto L_0x00ed;
            case 480: goto L_0x00f0;
            case 481: goto L_0x00ea;
            case 482: goto L_0x0423;
            case 483: goto L_0x0429;
            case 484: goto L_0x042c;
            case 485: goto L_0x04ad;
            case 486: goto L_0x04b3;
            case 487: goto L_0x04b6;
            case 488: goto L_0x04b0;
            case 489: goto L_0x05f7;
            case 490: goto L_0x0510;
            case 491: goto L_0x0513;
            case 492: goto L_0x0011;
            case 493: goto L_0x0011;
            case 494: goto L_0x004e;
            case 495: goto L_0x0051;
            case 496: goto L_0x0519;
            case 497: goto L_0x051c;
            case 498: goto L_0x05ca;
            case 499: goto L_0x0609;
            case 500: goto L_0x02df;
            case 501: goto L_0x062d;
            case 502: goto L_0x0564;
            case 503: goto L_0x0396;
            case 504: goto L_0x0018;
            case 505: goto L_0x01e6;
            case 506: goto L_0x01fe;
            case 507: goto L_0x0381;
            case 508: goto L_0x0237;
            case 509: goto L_0x051f;
            case 510: goto L_0x04bc;
            case 511: goto L_0x01c5;
            case 512: goto L_0x01cb;
            case 513: goto L_0x04f5;
            case 514: goto L_0x04f8;
            case 515: goto L_0x04fb;
            case 516: goto L_0x0011;
            case 517: goto L_0x0011;
            case 518: goto L_0x043b;
            case 519: goto L_0x0636;
            case 520: goto L_0x0639;
            case 521: goto L_0x01d1;
            case 522: goto L_0x04a7;
            case 523: goto L_0x063f;
            case 524: goto L_0x01ce;
            case 525: goto L_0x047a;
            case 526: goto L_0x0147;
            case 527: goto L_0x0336;
            case 528: goto L_0x0011;
            case 529: goto L_0x02e5;
            case 530: goto L_0x05fd;
            case 531: goto L_0x05ee;
            case 532: goto L_0x0600;
            case 533: goto L_0x0603;
            case 534: goto L_0x05f1;
            case 535: goto L_0x0011;
            case 536: goto L_0x0011;
            case 537: goto L_0x0011;
            case 538: goto L_0x0011;
            case 539: goto L_0x0225;
            case 540: goto L_0x03bd;
            case 541: goto L_0x02dc;
            case 542: goto L_0x04d1;
            case 543: goto L_0x04d4;
            case 544: goto L_0x00ae;
            case 545: goto L_0x026d;
            case 546: goto L_0x0645;
            case 547: goto L_0x0648;
            case 548: goto L_0x027f;
            case 549: goto L_0x0291;
            case 550: goto L_0x0294;
            case 551: goto L_0x0297;
            case 552: goto L_0x04c8;
            case 553: goto L_0x0351;
            case 554: goto L_0x02bb;
            case 555: goto L_0x0624;
            case 556: goto L_0x05dc;
            case 557: goto L_0x0279;
            case 558: goto L_0x0483;
            case 559: goto L_0x0375;
            case 560: goto L_0x027c;
            case 561: goto L_0x00d5;
            case 562: goto L_0x03c6;
            case 563: goto L_0x03c9;
            case 564: goto L_0x03cc;
            case 565: goto L_0x036f;
            case 566: goto L_0x0438;
            case 567: goto L_0x01d4;
            case 568: goto L_0x013e;
            case 569: goto L_0x01b0;
            case 570: goto L_0x034b;
            case 571: goto L_0x034e;
            case 572: goto L_0x00b4;
            case 573: goto L_0x0354;
            case 574: goto L_0x03b1;
            case 575: goto L_0x064e;
            case 576: goto L_0x0210;
            case 577: goto L_0x0033;
            case 578: goto L_0x0030;
            case 579: goto L_0x0036;
            case 580: goto L_0x02be;
            case 581: goto L_0x02c1;
            case 582: goto L_0x0072;
            case 583: goto L_0x0096;
            case 584: goto L_0x00e1;
            case 585: goto L_0x00e4;
            default: goto L_0x0011;
        };
    L_0x0011:
        com.facebook.graphql.deserializers.GraphQLUnknownFeedUnitDeserializer.m6141a(r4, r0, r7);
        return;
    L_0x0015:
        com.facebook.graphql.deserializers.GraphQLAYMTChannelDeserializer.m4507a(r4, r0, r7, r8);
    L_0x0018:
        com.facebook.graphql.deserializers.GraphQLAYMTNativeMobileActionDeserializer.m4510a(r4, r0, r7, r8);
    L_0x001b:
        com.facebook.graphql.deserializers.GraphQLAYMTTipDeserializer.m4513b(r4, r0, r7, r8);
    L_0x001e:
        com.facebook.graphql.deserializers.GraphQLActivityTemplateTokenDeserializer.m4516a(r4, r0, r7);
    L_0x0021:
        com.facebook.graphql.deserializers.GraphQLActorDeserializer.m4521b(r4, r0, r7, r8);
    L_0x0024:
        com.facebook.graphql.deserializers.GraphQLAdAccountDeserializer.m4524a(r4, r0, r7, r8);
    L_0x0027:
        com.facebook.graphql.deserializers.GraphQLAdGeoLocationDeserializer.m4527a(r4, r0, r7);
    L_0x002a:
        com.facebook.graphql.deserializers.GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer.m4530a(r4, r0, r7, r8);
    L_0x002d:
        com.facebook.graphql.deserializers.GraphQLAdditionalSuggestedPostAdItemsEdgeDeserializer.m4533b(r4, r0, r7, r8);
    L_0x0030:
        com.facebook.graphql.deserializers.GraphQLAdsExperienceDeclineResponsePayloadDeserializer.m4536a(r4, r0, r7, r8);
    L_0x0033:
        com.facebook.graphql.deserializers.GraphQLAdsExperienceInjectResponsePayloadDeserializer.m4539a(r4, r0, r7, r8);
    L_0x0036:
        com.facebook.graphql.deserializers.GraphQLAdsExperienceRemoveResponsePayloadDeserializer.m4542a(r4, r0, r7, r8);
    L_0x0039:
        com.facebook.graphql.deserializers.GraphQLAdsInterestDeserializer.m4545a(r4, r0, r7);
    L_0x003c:
        com.facebook.graphql.deserializers.GraphQLAggregatedEntitiesAtRangeDeserializer.m4548b(r4, r0, r7, r8);
    L_0x003f:
        com.facebook.graphql.deserializers.GraphQLAlbumDeserializer.m4551b(r4, r0, r7, r8);
    L_0x0042:
        com.facebook.graphql.deserializers.GraphQLAlbumsConnectionDeserializer.m4554a(r4, r0, r7, r8);
    L_0x0045:
        com.facebook.graphql.deserializers.GraphQLAllScheduledPostsConnectionDeserializer.m4557a(r4, r0, r7);
    L_0x0048:
        com.facebook.graphql.deserializers.GraphQLAllShareStoriesConnectionDeserializer.m4560a(r4, r0, r7);
    L_0x004b:
        com.facebook.graphql.deserializers.GraphQLAndroidAppConfigDeserializer.m4563a(r4, r0, r7);
    L_0x004e:
        com.facebook.graphql.deserializers.GraphQLAppAdStoriesSideFeedConnectionDeserializer.m4566a(r4, r0, r7, r8);
    L_0x0051:
        com.facebook.graphql.deserializers.GraphQLAppAdStoriesSideFeedEdgeDeserializer.m4569b(r4, r0, r7, r8);
    L_0x0054:
        com.facebook.graphql.deserializers.GraphQLAppListDeserializer.m4572a(r4, r0, r7);
    L_0x0057:
        com.facebook.graphql.deserializers.GraphQLAppStoreApplicationDeserializer.m4575a(r4, r0, r7, r8);
    L_0x005a:
        com.facebook.graphql.deserializers.C0239xb10bb428.m4578a(r4, r0, r7, r8);
    L_0x005d:
        com.facebook.graphql.deserializers.GraphQLApplicationDeserializer.m4581a(r4, r0, r7, r8);
    L_0x0060:
        com.facebook.graphql.deserializers.GraphQLApproximateCountDeserializer.m4584a(r4, r0, r7);
    L_0x0063:
        com.facebook.graphql.deserializers.GraphQLArticleChainingFeedUnitDeserializer.m4587a(r4, r0, r7, r8);
    L_0x0066:
        com.facebook.graphql.deserializers.GraphQLAttachmentPropertyDeserializer.m4591b(r4, r0, r7, r8);
    L_0x0069:
        com.facebook.graphql.deserializers.GraphQLAttributionEntryDeserializer.m4596b(r4, r0, r7, r8);
    L_0x006c:
        com.facebook.graphql.deserializers.GraphQLAudienceInfoDeserializer.m4599a(r4, r0, r7, r8);
    L_0x006f:
        com.facebook.graphql.deserializers.GraphQLAudioDeserializer.m4602a(r4, r0, r7);
    L_0x0072:
        com.facebook.graphql.deserializers.GraphQLBackdatedTimeDeserializer.m4607a(r4, r0, r7);
    L_0x0075:
        com.facebook.graphql.deserializers.GraphQLBoostedComponentDeserializer.m4613a(r4, r0, r7, r8);
    L_0x0078:
        com.facebook.graphql.deserializers.GraphQLBoostedComponentActionLinkDeserializer.m4610a(r4, r0, r7, r8);
    L_0x007b:
        com.facebook.graphql.deserializers.GraphQLBoostedComponentMessageDeserializer.m4617b(r4, r0, r7, r8);
    L_0x007e:
        com.facebook.graphql.deserializers.GraphQLBudgetRecommendationDataDeserializer.m4620a(r4, r0, r7, r8);
    L_0x0081:
        com.facebook.graphql.deserializers.GraphQLBudgetRecommendationsConnectionDeserializer.m4623a(r4, r0, r7, r8);
    L_0x0084:
        com.facebook.graphql.deserializers.GraphQLBudgetRecommendationsEdgeDeserializer.m4626b(r4, r0, r7, r8);
    L_0x0087:
        com.facebook.graphql.deserializers.GraphQLBusinessInfoDeserializer.m4631b(r4, r0, r7, r8);
    L_0x008a:
        com.facebook.graphql.deserializers.GraphQLBylineFragmentDeserializer.m4636b(r4, r0, r7, r8);
    L_0x008d:
        com.facebook.graphql.deserializers.GraphQLCarrierUpsellPromotionDeserializer.m4639a(r4, r0, r7, r8);
    L_0x0090:
        com.facebook.graphql.deserializers.GraphQLCelebrationsFeedUnitDeserializer.m4642a(r4, r0, r7, r8);
    L_0x0093:
        com.facebook.graphql.deserializers.GraphQLCelebrationsFeedUnitItemDeserializer.m4647b(r4, r0, r7, r8);
    L_0x0096:
        com.facebook.graphql.deserializers.GraphQLClashUnitDeserializer.m4650a(r4, r0, r7);
    L_0x0099:
        com.facebook.graphql.deserializers.GraphQLClientBumpingPlaceHolderFeedUnitDeserializer.m4653a(r4, r0, r7);
    L_0x009c:
        com.facebook.graphql.deserializers.GraphQLCollectionsRatingFeedUnitItemDeserializer.m4656a(r4, r0, r7, r8);
    L_0x009f:
        com.facebook.graphql.deserializers.GraphQLCommentDeserializer.m4661b(r4, r0, r7, r8);
    L_0x00a2:
        com.facebook.graphql.deserializers.GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer.m4664a(r4, r0, r7, r8);
    L_0x00a5:
        com.facebook.graphql.deserializers.GraphQLCommentsConnectionDeserializer.m4667a(r4, r0, r7, r8);
    L_0x00a8:
        com.facebook.graphql.deserializers.GraphQLComposedDocumentDeserializer.m4670a(r4, r0, r7, r8);
    L_0x00ab:
        com.facebook.graphql.deserializers.GraphQLComposerPrivacyGuardrailInfoDeserializer.m4673a(r4, r0, r7, r8);
    L_0x00ae:
        com.facebook.graphql.deserializers.GraphQLConfigurationDeserializer.m4676a(r4, r0, r7);
    L_0x00b1:
        com.facebook.graphql.deserializers.GraphQLContactDeserializer.m4679a(r4, r0, r7, r8);
    L_0x00b4:
        com.facebook.graphql.deserializers.GraphQLContactPointDeserializer.m4682a(r4, r0, r7);
    L_0x00b7:
        com.facebook.graphql.deserializers.GraphQLContactRecommendationFieldDeserializer.m4685a(r4, r0, r7, r8);
    L_0x00ba:
        com.facebook.graphql.deserializers.GraphQLCouponDeserializer.m4688a(r4, r0, r7, r8);
    L_0x00bd:
        com.facebook.graphql.deserializers.GraphQLCreativePagesYouMayLikeFeedUnitDeserializer.m4691a(r4, r0, r7, r8);
    L_0x00c0:
        com.facebook.graphql.deserializers.GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer.m4696b(r4, r0, r7, r8);
    L_0x00c3:
        com.facebook.graphql.deserializers.GraphQLCulturalMomentDeserializer.m4699a(r4, r0, r7, r8);
    L_0x00c6:
        com.facebook.graphql.deserializers.GraphQLCurrencyQuantityDeserializer.m4702a(r4, r0, r7);
    L_0x00c9:
        com.facebook.graphql.deserializers.GraphQLCustomizedStoryDeserializer.m4705a(r4, r0, r7, r8);
    L_0x00cc:
        com.facebook.graphql.deserializers.GraphQLDebugFeedConnectionDeserializer.m4708a(r4, r0, r7, r8);
    L_0x00cf:
        com.facebook.graphql.deserializers.GraphQLDebugFeedEdgeDeserializer.m4711b(r4, r0, r7, r8);
    L_0x00d2:
        com.facebook.graphql.deserializers.GraphQLDiscoveryCardItemDeserializer.m4714a(r4, r0, r7);
    L_0x00d5:
        com.facebook.graphql.deserializers.GraphQLDocumentElementDeserializer.m4717a(r4, r0, r7, r8);
    L_0x00d8:
        com.facebook.graphql.deserializers.GraphQLEditActionDeserializer.m4720b(r4, r0, r7, r8);
    L_0x00db:
        com.facebook.graphql.deserializers.GraphQLEditHistoryConnectionDeserializer.m4723a(r4, r0, r7, r8);
    L_0x00de:
        com.facebook.graphql.deserializers.GraphQLEducationExperienceDeserializer.m4727b(r4, r0, r7, r8);
    L_0x00e1:
        com.facebook.graphql.deserializers.GraphQLEligibleClashUnitsConnectionDeserializer.m4730a(r4, r0, r7, r8);
    L_0x00e4:
        com.facebook.graphql.deserializers.GraphQLEligibleClashUnitsEdgeDeserializer.m4733b(r4, r0, r7, r8);
    L_0x00e7:
        com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisDeserializer.m4736a(r4, r0, r7, r8);
    L_0x00ea:
        com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisItemDeserializer.m4739a(r4, r0, r7, r8);
    L_0x00ed:
        com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisItemsConnectionDeserializer.m4742a(r4, r0, r7, r8);
    L_0x00f0:
        com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisItemsEdgeDeserializer.m4745b(r4, r0, r7, r8);
    L_0x00f3:
        com.facebook.graphql.deserializers.GraphQLEntityDeserializer.m4766b(r4, r0, r7, r8);
    L_0x00f6:
        com.facebook.graphql.deserializers.GraphQLEntityAtRangeDeserializer.m4749b(r4, r0, r7, r8);
    L_0x00f9:
        com.facebook.graphql.deserializers.GraphQLEntityCardContextItemDeserializer.m4752b(r4, r0, r7, r8);
    L_0x00fc:
        com.facebook.graphql.deserializers.GraphQLEntityCardContextItemIconDeserializer.m4755a(r4, r0, r7, r8);
    L_0x00ff:
        com.facebook.graphql.deserializers.GraphQLEntityCardContextItemLinkDeserializer.m4758a(r4, r0, r7);
    L_0x0102:
        com.facebook.graphql.deserializers.GraphQLEntityCardContextItemsEdgeDeserializer.m4762a(r4, r0, r7, r8);
    L_0x0105:
        com.facebook.graphql.deserializers.GraphQLEntityWithImageDeserializer.m4769a(r4, r0, r7, r8);
    L_0x0108:
        com.facebook.graphql.deserializers.GraphQLErrorDeserializer.m4772a(r4, r0, r7);
    L_0x010b:
        com.facebook.graphql.deserializers.GraphQLEventDeserializer.m4796b(r4, r0, r7, r8);
    L_0x010e:
        com.facebook.graphql.deserializers.GraphQLEventCategoryDataDeserializer.m4775a(r4, r0, r7);
    L_0x0111:
        com.facebook.graphql.deserializers.GraphQLEventCollectionFeedUnitDeserializer.m4778a(r4, r0, r7, r8);
    L_0x0114:
        com.facebook.graphql.deserializers.GraphQLEventCollectionToItemConnectionDeserializer.m4781a(r4, r0, r7, r8);
    L_0x0117:
        com.facebook.graphql.deserializers.GraphQLEventCreateActionLinkDeserializer.m4784a(r4, r0, r7, r8);
    L_0x011a:
        com.facebook.graphql.deserializers.GraphQLEventDeclinesConnectionDeserializer.m4787a(r4, r0, r7, r8);
    L_0x011d:
        com.facebook.graphql.deserializers.GraphQLEventDeclinesEdgeDeserializer.m4791b(r4, r0, r7, r8);
    L_0x0120:
        com.facebook.graphql.deserializers.GraphQLEventHostsConnectionDeserializer.m4799a(r4, r0, r7, r8);
    L_0x0123:
        com.facebook.graphql.deserializers.GraphQLEventHostsEdgeDeserializer.m4802b(r4, r0, r7, r8);
    L_0x0126:
        com.facebook.graphql.deserializers.GraphQLEventInviteesConnectionDeserializer.m4805a(r4, r0, r7, r8);
    L_0x0129:
        com.facebook.graphql.deserializers.GraphQLEventInviteesEdgeDeserializer.m4809b(r4, r0, r7, r8);
    L_0x012c:
        com.facebook.graphql.deserializers.GraphQLEventMaybesConnectionDeserializer.m4812a(r4, r0, r7, r8);
    L_0x012f:
        com.facebook.graphql.deserializers.GraphQLEventMaybesEdgeDeserializer.m4816b(r4, r0, r7, r8);
    L_0x0132:
        com.facebook.graphql.deserializers.GraphQLEventMembersConnectionDeserializer.m4819a(r4, r0, r7, r8);
    L_0x0135:
        com.facebook.graphql.deserializers.GraphQLEventMembersEdgeDeserializer.m4823b(r4, r0, r7, r8);
    L_0x0138:
        com.facebook.graphql.deserializers.GraphQLEventThemePhotoDeserializer.m4826a(r4, r0, r7, r8);
    L_0x013b:
        com.facebook.graphql.deserializers.GraphQLEventTicketActionLinkDeserializer.m4829a(r4, r0, r7, r8);
    L_0x013e:
        com.facebook.graphql.deserializers.GraphQLEventTicketProviderDeserializer.m4832a(r4, r0, r7, r8);
    L_0x0141:
        com.facebook.graphql.deserializers.GraphQLEventTimeRangeDeserializer.m4835a(r4, r0, r7);
    L_0x0144:
        com.facebook.graphql.deserializers.GraphQLEventUserBlockResponsePayloadDeserializer.m4838a(r4, r0, r7, r8);
    L_0x0147:
        com.facebook.graphql.deserializers.GraphQLEventViewActionLinkDeserializer.m4841a(r4, r0, r7, r8);
    L_0x014a:
        com.facebook.graphql.deserializers.GraphQLEventViewerCapabilityDeserializer.m4844a(r4, r0, r7);
    L_0x014d:
        com.facebook.graphql.deserializers.GraphQLEventWatchersConnectionDeserializer.m4847a(r4, r0, r7, r8);
    L_0x0150:
        com.facebook.graphql.deserializers.GraphQLEventWatchersEdgeDeserializer.m4851b(r4, r0, r7, r8);
    L_0x0153:
        com.facebook.graphql.deserializers.GraphQLEventsConnectionDeserializer.m4854a(r4, r0, r7, r8);
    L_0x0156:
        com.facebook.graphql.deserializers.GraphQLEventsOccurringHereConnectionDeserializer.m4857a(r4, r0, r7, r8);
    L_0x0159:
        com.facebook.graphql.deserializers.GraphQLEventsPendingPostQueueActionLinkDeserializer.m4860a(r4, r0, r7, r8);
    L_0x015c:
        com.facebook.graphql.deserializers.GraphQLExploreFeedDeserializer.m4863b(r4, r0, r7, r8);
    L_0x015f:
        com.facebook.graphql.deserializers.GraphQLExternalMusicAlbumDeserializer.m4866a(r4, r0, r7, r8);
    L_0x0162:
        com.facebook.graphql.deserializers.GraphQLExternalUrlDeserializer.m4869a(r4, r0, r7, r8);
    L_0x0165:
        com.facebook.graphql.deserializers.GraphQLFaceBoxDeserializer.m4872b(r4, r0, r7, r8);
    L_0x0168:
        com.facebook.graphql.deserializers.GraphQLFaceBoxTagSuggestionsConnectionDeserializer.m4875a(r4, r0, r7, r8);
    L_0x016b:
        com.facebook.graphql.deserializers.GraphQLFaceBoxTagSuggestionsEdgeDeserializer.m4878b(r4, r0, r7, r8);
    L_0x016e:
        com.facebook.graphql.deserializers.GraphQLFeedHomeStoriesDeserializer.m4881a(r4, r0, r7, r8);
    L_0x0171:
        com.facebook.graphql.deserializers.GraphQLFeedTopicContentDeserializer.m4884a(r4, r0, r7, r8);
    L_0x0174:
        com.facebook.graphql.deserializers.GraphQLFeedUnitEdgeDeserializer.m4888b(r4, r0, r7, r8);
    L_0x0177:
        com.facebook.graphql.deserializers.GraphQLFeedbackDeserializer.m4895b(r4, r0, r7, r8);
    L_0x017a:
        com.facebook.graphql.deserializers.GraphQLFeedbackContextDeserializer.m4891a(r4, r0, r7, r8);
    L_0x017d:
        com.facebook.graphql.deserializers.GraphQLFeedbackReactionDeserializer.m4898a(r4, r0, r7);
    L_0x0180:
        com.facebook.graphql.deserializers.GraphQLFeedbackReactionInfoDeserializer.m4903a(r4, r0, r7, r8);
    L_0x0183:
        com.facebook.graphql.deserializers.GraphQLFeedbackRealTimeActivityActorsConnectionDeserializer.m4906a(r4, r0, r7, r8);
    L_0x0186:
        com.facebook.graphql.deserializers.GraphQLFeedbackRealTimeActivityInfoDeserializer.m4909a(r4, r0, r7, r8);
    L_0x0189:
        com.facebook.graphql.deserializers.GraphQLFindFriendsFeedUnitDeserializer.m4912a(r4, r0, r7);
    L_0x018c:
        com.facebook.graphql.deserializers.GraphQLFindGroupsFeedUnitDeserializer.m4915a(r4, r0, r7);
    L_0x018f:
        com.facebook.graphql.deserializers.GraphQLFindPagesFeedUnitDeserializer.m4918a(r4, r0, r7);
    L_0x0192:
        com.facebook.graphql.deserializers.GraphQLFocusedPhotoDeserializer.m4921a(r4, r0, r7, r8);
    L_0x0195:
        com.facebook.graphql.deserializers.GraphQLFollowUpFeedUnitsConnectionDeserializer.m4924a(r4, r0, r7, r8);
    L_0x0198:
        com.facebook.graphql.deserializers.GraphQLFollowUpFeedUnitsEdgeDeserializer.m4927b(r4, r0, r7, r8);
    L_0x019b:
        com.facebook.graphql.deserializers.GraphQLFriendListFeedConnectionDeserializer.m4930a(r4, r0, r7, r8);
    L_0x019e:
        com.facebook.graphql.deserializers.GraphQLFriendListFeedEdgeDeserializer.m4933b(r4, r0, r7, r8);
    L_0x01a1:
        com.facebook.graphql.deserializers.GraphQLFriendLocationFeedUnitItemDeserializer.m4938b(r4, r0, r7, r8);
    L_0x01a4:
        com.facebook.graphql.deserializers.GraphQLFriendingPossibilitiesConnectionDeserializer.m4941a(r4, r0, r7, r8);
    L_0x01a7:
        com.facebook.graphql.deserializers.GraphQLFriendingPossibilitiesEdgeDeserializer.m4944b(r4, r0, r7, r8);
    L_0x01aa:
        com.facebook.graphql.deserializers.GraphQLFriendsConnectionDeserializer.m4947a(r4, r0, r7, r8);
    L_0x01ad:
        com.facebook.graphql.deserializers.GraphQLFriendsEdgeDeserializer.m4951b(r4, r0, r7, r8);
    L_0x01b0:
        com.facebook.graphql.deserializers.GraphQLFriendsLocationsClusterDeserializer.m4955b(r4, r0, r7, r8);
    L_0x01b3:
        com.facebook.graphql.deserializers.GraphQLFriendsLocationsFeedUnitDeserializer.m4958a(r4, r0, r7, r8);
    L_0x01b6:
        com.facebook.graphql.deserializers.GraphQLFriendsWhoLikeConnectionDeserializer.m4961a(r4, r0, r7, r8);
    L_0x01b9:
        com.facebook.graphql.deserializers.GraphQLFriendsWhoVisitedConnectionDeserializer.m4964a(r4, r0, r7, r8);
    L_0x01bc:
        com.facebook.graphql.deserializers.GraphQLFriendsWhoVisitedEdgeDeserializer.m4968b(r4, r0, r7, r8);
    L_0x01bf:
        com.facebook.graphql.deserializers.GraphQLFullIndexEducationInfoDeserializer.m4971a(r4, r0, r7);
    L_0x01c2:
        com.facebook.graphql.deserializers.GraphQLFundraiserCampaignDeserializer.m4974a(r4, r0, r7, r8);
    L_0x01c5:
        com.facebook.graphql.deserializers.GraphQLFundraiserCharityDeserializer.m4977a(r4, r0, r7, r8);
    L_0x01c8:
        com.facebook.graphql.deserializers.GraphQLFundraiserPageDeserializer.m4980a(r4, r0, r7, r8);
    L_0x01cb:
        com.facebook.graphql.deserializers.GraphQLFundraiserPersonToCharityDeserializer.m4983a(r4, r0, r7, r8);
    L_0x01ce:
        com.facebook.graphql.deserializers.GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer.m4986a(r4, r0, r7, r8);
    L_0x01d1:
        com.facebook.graphql.deserializers.GraphQLFundraiserToCharityDeserializer.m4989a(r4, r0, r7, r8);
    L_0x01d4:
        com.facebook.graphql.deserializers.GraphQLGamesInstantPlayStyleInfoDeserializer.m4992a(r4, r0, r7);
    L_0x01d7:
        com.facebook.graphql.deserializers.GraphQLGeoRectangleDeserializer.m4995a(r4, r0, r7);
    L_0x01da:
        com.facebook.graphql.deserializers.GraphQLGoodwillAnniversaryCampaignDeserializer.m4998a(r4, r0, r7, r8);
    L_0x01dd:
        com.facebook.graphql.deserializers.GraphQLGoodwillAnniversaryCampaignFeedUnitDeserializer.m5001a(r4, r0, r7, r8);
    L_0x01e0:
        com.facebook.graphql.deserializers.GraphQLGoodwillBirthdayCampaignDeserializer.m5004a(r4, r0, r7, r8);
    L_0x01e3:
        com.facebook.graphql.deserializers.C0240xd8bd97ec.m5007a(r4, r0, r7, r8);
    L_0x01e6:
        com.facebook.graphql.deserializers.GraphQLGoodwillCampaignDeserializer.m5010b(r4, r0, r7, r8);
    L_0x01e9:
        com.facebook.graphql.deserializers.GraphQLGoodwillFriendversaryCampaignDeserializer.m5013a(r4, r0, r7, r8);
    L_0x01ec:
        com.facebook.graphql.deserializers.GraphQLGoodwillHappyBirthdayCardDeserializer.m5016a(r4, r0, r7, r8);
    L_0x01ef:
        com.facebook.graphql.deserializers.GraphQLGoodwillHappyBirthdayStoriesConnectionDeserializer.m5019a(r4, r0, r7, r8);
    L_0x01f2:
        com.facebook.graphql.deserializers.GraphQLGoodwillHappyBirthdayStoriesEdgeDeserializer.m5022b(r4, r0, r7, r8);
    L_0x01f5:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackAnniversaryCampaignStoryDeserializer.m5025a(r4, r0, r7, r8);
    L_0x01f8:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackDataPointDeserializer.m5028b(r4, r0, r7, r8);
    L_0x01fb:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackDataPointsConnectionDeserializer.m5031a(r4, r0, r7, r8);
    L_0x01fe:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFeedUnitDeserializer.m5034a(r4, r0, r7, r8);
    L_0x0201:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendListConnectionDeserializer.m5037a(r4, r0, r7, r8);
    L_0x0204:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendListEdgeDeserializer.m5040b(r4, r0, r7, r8);
    L_0x0207:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendversaryPromotionStoryDeserializer.m5043a(r4, r0, r7, r8);
    L_0x020a:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendversaryStoryDeserializer.m5046a(r4, r0, r7, r8);
    L_0x020d:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackMissedMemoriesStoryDeserializer.m5049a(r4, r0, r7, r8);
    L_0x0210:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackOriginalPostActionLinkDeserializer.m5052a(r4, r0, r7);
    L_0x0213:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer.m5055a(r4, r0, r7);
    L_0x0216:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotedCampaignsConnectionDeserializer.m5058a(r4, r0, r7, r8);
    L_0x0219:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotedStoriesConnectionDeserializer.m5061a(r4, r0, r7, r8);
    L_0x021c:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotionColorPaletteDeserializer.m5064a(r4, r0, r7);
    L_0x021f:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotionFeedUnitDeserializer.m5067a(r4, r0, r7, r8);
    L_0x0222:
        com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackSectionDeserializer.m5070a(r4, r0, r7, r8);
    L_0x0225:
        com.facebook.graphql.deserializers.GraphQLGoodwillVideoCampaignDeserializer.m5073a(r4, r0, r7, r8);
    L_0x0228:
        com.facebook.graphql.deserializers.GraphQLGraphSearchConnectedFriendsConnectionDeserializer.m5076a(r4, r0, r7, r8);
    L_0x022b:
        com.facebook.graphql.deserializers.GraphQLGraphSearchConnectedFriendsEdgeDeserializer.m5079b(r4, r0, r7, r8);
    L_0x022e:
        com.facebook.graphql.deserializers.GraphQLGraphSearchModulesConnectionDeserializer.m5082a(r4, r0, r7, r8);
    L_0x0231:
        com.facebook.graphql.deserializers.GraphQLGraphSearchQueryDeserializer.m5085a(r4, r0, r7, r8);
    L_0x0234:
        com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterDeserializer.m5091a(r4, r0, r7, r8);
    L_0x0237:
        com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterCustomValueDeserializer.m5088a(r4, r0, r7);
    L_0x023a:
        com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterGroupDeserializer.m5096b(r4, r0, r7, r8);
    L_0x023d:
        com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterValueDeserializer.m5099b(r4, r0, r7, r8);
    L_0x0240:
        com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterValuesConnectionDeserializer.m5102a(r4, r0, r7, r8);
    L_0x0243:
        com.facebook.graphql.deserializers.GraphQLGraphSearchQueryTitleDeserializer.m5105a(r4, r0, r7);
    L_0x0246:
        com.facebook.graphql.deserializers.GraphQLGraphSearchResultDecorationDeserializer.m5108a(r4, r0, r7, r8);
    L_0x0249:
        com.facebook.graphql.deserializers.GraphQLGraphSearchResultsConnectionDeserializer.m5111a(r4, r0, r7, r8);
    L_0x024c:
        com.facebook.graphql.deserializers.GraphQLGraphSearchResultsEdgeDeserializer.m5115b(r4, r0, r7, r8);
    L_0x024f:
        com.facebook.graphql.deserializers.GraphQLGraphSearchSnippetDeserializer.m5120b(r4, r0, r7, r8);
    L_0x0252:
        com.facebook.graphql.deserializers.GraphQLGreetingCardDeserializer.m5123a(r4, r0, r7, r8);
    L_0x0255:
        com.facebook.graphql.deserializers.GraphQLGreetingCardPromotionFeedUnitDeserializer.m5126a(r4, r0, r7, r8);
    L_0x0258:
        com.facebook.graphql.deserializers.GraphQLGreetingCardSlideDeserializer.m5129b(r4, r0, r7, r8);
    L_0x025b:
        com.facebook.graphql.deserializers.GraphQLGreetingCardSlidePhotosConnectionDeserializer.m5132a(r4, r0, r7, r8);
    L_0x025e:
        com.facebook.graphql.deserializers.GraphQLGreetingCardSlidesConnectionDeserializer.m5135a(r4, r0, r7, r8);
    L_0x0261:
        com.facebook.graphql.deserializers.GraphQLGreetingCardTemplateDeserializer.m5138a(r4, r0, r7, r8);
    L_0x0264:
        com.facebook.graphql.deserializers.GraphQLGreetingCardTemplateThemeDeserializer.m5141a(r4, r0, r7);
    L_0x0267:
        com.facebook.graphql.deserializers.GraphQLGroupDeserializer.m5159a(r4, r0, r7, r8);
    L_0x026a:
        com.facebook.graphql.deserializers.C0241x3cc57236.m5144a(r4, r0, r7, r8);
    L_0x026d:
        com.facebook.graphql.deserializers.GraphQLGroupConfigurationsConnectionDeserializer.m5147a(r4, r0, r7, r8);
    L_0x0270:
        com.facebook.graphql.deserializers.GraphQLGroupCreationSuggestionDeserializer.m5156a(r4, r0, r7, r8);
    L_0x0273:
        com.facebook.graphql.deserializers.GraphQLGroupCreationSuggestionCallToActionInfoDeserializer.m5150a(r4, r0, r7, r8);
    L_0x0276:
        com.facebook.graphql.deserializers.C0242xc7519942.m5153a(r4, r0, r7, r8);
    L_0x0279:
        com.facebook.graphql.deserializers.GraphQLGroupMallAdsEducationInfoDeserializer.m5162a(r4, r0, r7);
    L_0x027c:
        com.facebook.graphql.deserializers.GraphQLGroupMallHoistedStoriesActionLinkDeserializer.m5165a(r4, r0, r7);
    L_0x027f:
        com.facebook.graphql.deserializers.GraphQLGroupMemberWelcomeCallToActionInfoDeserializer.m5168a(r4, r0, r7);
    L_0x0282:
        com.facebook.graphql.deserializers.GraphQLGroupMembersConnectionDeserializer.m5171a(r4, r0, r7, r8);
    L_0x0285:
        com.facebook.graphql.deserializers.GraphQLGroupMembersEdgeDeserializer.m5175b(r4, r0, r7, r8);
    L_0x0288:
        com.facebook.graphql.deserializers.GraphQLGroupMessageChattableMembersConnectionDeserializer.m5178a(r4, r0, r7, r8);
    L_0x028b:
        com.facebook.graphql.deserializers.GraphQLGroupMessageChattableMembersEdgeDeserializer.m5181b(r4, r0, r7, r8);
    L_0x028e:
        com.facebook.graphql.deserializers.GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer.m5184a(r4, r0, r7, r8);
    L_0x0291:
        com.facebook.graphql.deserializers.GraphQLGroupTopStoriesFeedUnitDeserializer.m5187a(r4, r0, r7, r8);
    L_0x0294:
        com.facebook.graphql.deserializers.GraphQLGroupTopStoriesFeedUnitStoriesConnectionDeserializer.m5190a(r4, r0, r7, r8);
    L_0x0297:
        com.facebook.graphql.deserializers.GraphQLGroupTopStoriesFeedUnitStoriesEdgeDeserializer.m5193b(r4, r0, r7, r8);
    L_0x029a:
        com.facebook.graphql.deserializers.GraphQLGroupsYouShouldCreateFeedUnitDeserializer.m5196a(r4, r0, r7, r8);
    L_0x029d:
        com.facebook.graphql.deserializers.GraphQLGroupsYouShouldCreateFeedUnitItemDeserializer.m5201b(r4, r0, r7, r8);
    L_0x02a0:
        com.facebook.graphql.deserializers.GraphQLGroupsYouShouldJoinFeedUnitDeserializer.m5204a(r4, r0, r7, r8);
    L_0x02a3:
        com.facebook.graphql.deserializers.GraphQLGroupsYouShouldJoinFeedUnitItemDeserializer.m5209b(r4, r0, r7, r8);
    L_0x02a6:
        com.facebook.graphql.deserializers.GraphQLHashtagDeserializer.m5212a(r4, r0, r7, r8);
    L_0x02a9:
        com.facebook.graphql.deserializers.GraphQLHashtagFeedConnectionDeserializer.m5215a(r4, r0, r7, r8);
    L_0x02ac:
        com.facebook.graphql.deserializers.GraphQLHoldoutAdFeedUnitDeserializer.m5218a(r4, r0, r7, r8);
    L_0x02af:
        com.facebook.graphql.deserializers.GraphQLIconDeserializer.m5221a(r4, r0, r7);
    L_0x02b2:
        com.facebook.graphql.deserializers.GraphQLImageDeserializer.a(r4, r0, r7);
    L_0x02b5:
        com.facebook.graphql.deserializers.GraphQLImageAtRangeDeserializer.m5225b(r4, r0, r7, r8);
    L_0x02b8:
        com.facebook.graphql.deserializers.GraphQLImageOverlayDeserializer.m5230b(r4, r0, r7, r8);
    L_0x02bb:
        com.facebook.graphql.deserializers.GraphQLImportantReactorsConnectionDeserializer.m5233a(r4, r0, r7, r8);
    L_0x02be:
        com.facebook.graphql.deserializers.GraphQLIncomingFriendRequestFeedUnitDeserializer.m5236a(r4, r0, r7, r8);
    L_0x02c1:
        com.facebook.graphql.deserializers.GraphQLIncomingFriendRequestFeedUnitItemDeserializer.m5240b(r4, r0, r7, r8);
    L_0x02c4:
        com.facebook.graphql.deserializers.GraphQLInfoRequestFieldDeserializer.m5243a(r4, r0, r7);
    L_0x02c7:
        com.facebook.graphql.deserializers.GraphQLInlineActivitiesConnectionDeserializer.m5246a(r4, r0, r7, r8);
    L_0x02ca:
        com.facebook.graphql.deserializers.GraphQLInlineActivityDeserializer.m5249b(r4, r0, r7, r8);
    L_0x02cd:
        com.facebook.graphql.deserializers.GraphQLInlineStyleAtRangeDeserializer.m5252a(r4, r0, r7);
    L_0x02d0:
        com.facebook.graphql.deserializers.GraphQLInstagramPhotosFromFriendsFeedUnitDeserializer.m5256a(r4, r0, r7, r8);
    L_0x02d3:
        com.facebook.graphql.deserializers.GraphQLInstagramPhotosFromFriendsFeedUnitItemDeserializer.m5261b(r4, r0, r7, r8);
    L_0x02d6:
        com.facebook.graphql.deserializers.GraphQLInstantArticleDeserializer.m5264a(r4, r0, r7, r8);
    L_0x02d9:
        com.facebook.graphql.deserializers.GraphQLInstantArticleVersionDeserializer.m5267a(r4, r0, r7, r8);
    L_0x02dc:
        com.facebook.graphql.deserializers.GraphQLInstreamVideoAdsConnectionDeserializer.m5270a(r4, r0, r7, r8);
    L_0x02df:
        com.facebook.graphql.deserializers.GraphQLInteractorsConnectionDeserializer.m5273a(r4, r0, r7, r8);
    L_0x02e2:
        com.facebook.graphql.deserializers.GraphQLInterestingRepliesConnectionDeserializer.m5276a(r4, r0, r7, r8);
    L_0x02e5:
        com.facebook.graphql.deserializers.GraphQLLeadGenActionLinkDeserializer.m5279a(r4, r0, r7, r8);
    L_0x02e8:
        com.facebook.graphql.deserializers.GraphQLLeadGenContextPageDeserializer.m5282a(r4, r0, r7, r8);
    L_0x02eb:
        com.facebook.graphql.deserializers.GraphQLLeadGenDataDeserializer.m5285a(r4, r0, r7, r8);
    L_0x02ee:
        com.facebook.graphql.deserializers.GraphQLLeadGenDeepLinkUserStatusDeserializer.m5288a(r4, r0, r7);
    L_0x02f1:
        com.facebook.graphql.deserializers.GraphQLLeadGenErrorNodeDeserializer.m5291a(r4, r0, r7);
    L_0x02f4:
        com.facebook.graphql.deserializers.GraphQLLeadGenInfoFieldDataDeserializer.m5296a(r4, r0, r7);
    L_0x02f7:
        com.facebook.graphql.deserializers.GraphQLLeadGenLegalContentDeserializer.m5304a(r4, r0, r7, r8);
    L_0x02fa:
        com.facebook.graphql.deserializers.GraphQLLeadGenLegalContentCheckboxDeserializer.m5301b(r4, r0, r7, r8);
    L_0x02fd:
        com.facebook.graphql.deserializers.GraphQLLeadGenPageDeserializer.m5308b(r4, r0, r7, r8);
    L_0x0300:
        com.facebook.graphql.deserializers.GraphQLLeadGenPrivacyNodeDeserializer.m5311a(r4, r0, r7);
    L_0x0303:
        com.facebook.graphql.deserializers.GraphQLLeadGenUserStatusDeserializer.m5314a(r4, r0, r7);
    L_0x0306:
        com.facebook.graphql.deserializers.GraphQLLikedProfilesConnectionDeserializer.m5317a(r4, r0, r7, r8);
    L_0x0309:
        com.facebook.graphql.deserializers.GraphQLLikersOfContentConnectionDeserializer.m5320a(r4, r0, r7, r8);
    L_0x030c:
        com.facebook.graphql.deserializers.GraphQLLinkOpenActionLinkDeserializer.m5323a(r4, r0, r7, r8);
    L_0x030f:
        com.facebook.graphql.deserializers.GraphQLLinkTargetStoreDataDeserializer.m5326a(r4, r0, r7, r8);
    L_0x0312:
        com.facebook.graphql.deserializers.GraphQLLocalContextAttachmentStyleInfoDeserializer.m5329a(r4, r0, r7, r8);
    L_0x0315:
        com.facebook.graphql.deserializers.GraphQLLocationDeserializer.m5332a(r4, r0, r7);
    L_0x0318:
        com.facebook.graphql.deserializers.GraphQLMailingAddressDeserializer.m5337a(r4, r0, r7, r8);
    L_0x031b:
        com.facebook.graphql.deserializers.GraphQLMediaDeserializer.m5342b(r4, r0, r7, r8);
    L_0x031e:
        com.facebook.graphql.deserializers.GraphQLMediaQuestionDeserializer.m5345a(r4, r0, r7, r8);
    L_0x0321:
        com.facebook.graphql.deserializers.GraphQLMediaQuestionOptionDeserializer.m5348a(r4, r0, r7);
    L_0x0324:
        com.facebook.graphql.deserializers.GraphQLMediaQuestionOptionsConnectionDeserializer.m5351a(r4, r0, r7, r8);
    L_0x0327:
        com.facebook.graphql.deserializers.GraphQLMediaQuestionOptionsEdgeDeserializer.m5354b(r4, r0, r7, r8);
    L_0x032a:
        com.facebook.graphql.deserializers.GraphQLMediaSetDeserializer.m5357a(r4, r0, r7, r8);
    L_0x032d:
        com.facebook.graphql.deserializers.GraphQLMediaSetMediaConnectionDeserializer.m5360a(r4, r0, r7, r8);
    L_0x0330:
        com.facebook.graphql.deserializers.GraphQLMegaphoneDeserializer.m5366a(r4, r0, r7, r8);
    L_0x0333:
        com.facebook.graphql.deserializers.GraphQLMegaphoneActionDeserializer.m5363a(r4, r0, r7);
    L_0x0336:
        com.facebook.graphql.deserializers.GraphQLMessengerContentSubscriptionOptionDeserializer.m5369a(r4, r0, r7, r8);
    L_0x0339:
        com.facebook.graphql.deserializers.GraphQLMobilePageAdminPanelFeedUnitDeserializer.m5372a(r4, r0, r7, r8);
    L_0x033c:
        com.facebook.graphql.deserializers.GraphQLMobilePageAdminPanelFeedUnitItemDeserializer.m5376b(r4, r0, r7, r8);
    L_0x033f:
        com.facebook.graphql.deserializers.GraphQLMobileStoreObjectDeserializer.m5379a(r4, r0, r7, r8);
    L_0x0342:
        com.facebook.graphql.deserializers.GraphQLMutualFriendsConnectionDeserializer.m5382a(r4, r0, r7, r8);
    L_0x0345:
        com.facebook.graphql.deserializers.GraphQLNameDeserializer.m5387b(r4, r0, r7, r8);
    L_0x0348:
        com.facebook.graphql.deserializers.GraphQLNamePartDeserializer.m5390a(r4, r0, r7);
    L_0x034b:
        com.facebook.graphql.deserializers.GraphQLNativeTemplateBundleDeserializer.m5393a(r4, r0, r7);
    L_0x034e:
        com.facebook.graphql.deserializers.GraphQLNativeTemplateDefaultViewControllerDeserializer.m5396a(r4, r0, r7, r8);
    L_0x0351:
        com.facebook.graphql.deserializers.GraphQLNativeTemplateViewDeserializer.m5402a(r4, r0, r7, r8);
    L_0x0354:
        com.facebook.graphql.deserializers.GraphQLNativeTemplateViewControllerDeserializer.m5399a(r4, r0, r7, r8);
    L_0x0357:
        com.facebook.graphql.deserializers.GraphQLNearbyPlacesBrowsePlaceResultsConnectionDeserializer.m5405a(r4, r0, r7, r8);
    L_0x035a:
        com.facebook.graphql.deserializers.GraphQLNearbySearchQueryDeserializer.m5408a(r4, r0, r7, r8);
    L_0x035d:
        com.facebook.graphql.deserializers.GraphQLNearbySearchSuggestionDeserializer.m5411a(r4, r0, r7, r8);
    L_0x0360:
        com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionDeserializer.m5414a(r4, r0, r7, r8);
    L_0x0363:
        com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(r4, r0, r7, r8);
    L_0x0366:
        com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionsEdgeDeserializer.m5420b(r4, r0, r7, r8);
    L_0x0369:
        com.facebook.graphql.deserializers.GraphQLNewsFeedConnectionDeserializer.m5423a(r4, r0, r7, r8);
    L_0x036c:
        com.facebook.graphql.deserializers.GraphQLNewsFeedEdgeDeserializer.m5426b(r4, r0, r7, r8);
    L_0x036f:
        com.facebook.graphql.deserializers.GraphQLNmorTwoCTwoPCashResponseDeserializer.m5429a(r4, r0, r7);
    L_0x0372:
        com.facebook.graphql.deserializers.GraphQLNoContentFeedUnitDeserializer.m5432a(r4, r0, r7);
    L_0x0375:
        com.facebook.graphql.deserializers.GraphQLNoContentGoodFriendsFeedUnitDeserializer.m5435a(r4, r0, r7);
    L_0x0378:
        com.facebook.graphql.deserializers.GraphQLNodeDeserializer.m5440b(r4, r0, r7, r8);
    L_0x037b:
        com.facebook.graphql.deserializers.GraphQLNoteDeserializer.m5443a(r4, r0, r7, r8);
    L_0x037e:
        com.facebook.graphql.deserializers.GraphQLNotifOptionRowDeserializer.m5447b(r4, r0, r7, r8);
    L_0x0381:
        com.facebook.graphql.deserializers.GraphQLNotifOptionRowDisplayDeserializer.m5450a(r4, r0, r7, r8);
    L_0x0384:
        com.facebook.graphql.deserializers.GraphQLNotificationStoriesDeltaDeserializer.m5453a(r4, r0, r7, r8);
    L_0x0387:
        com.facebook.graphql.deserializers.GraphQLNotificationStoriesEdgeDeserializer.m5456a(r4, r0, r7, r8);
    L_0x038a:
        com.facebook.graphql.deserializers.GraphQLOpenGraphActionDeserializer.m5461b(r4, r0, r7, r8);
    L_0x038d:
        com.facebook.graphql.deserializers.GraphQLOpenGraphMetadataDeserializer.m5464a(r4, r0, r7, r8);
    L_0x0390:
        com.facebook.graphql.deserializers.GraphQLOpenGraphObjectDeserializer.m5469b(r4, r0, r7, r8);
    L_0x0393:
        com.facebook.graphql.deserializers.GraphQLOverlayActionLinkDeserializer.m5472a(r4, r0, r7, r8);
    L_0x0396:
        com.facebook.graphql.deserializers.GraphQLOverlayCallToActionInfoDeserializer.m5475a(r4, r0, r7, r8);
    L_0x0399:
        com.facebook.graphql.deserializers.GraphQLOwnedEventsConnectionDeserializer.m5478a(r4, r0, r7, r8);
    L_0x039c:
        com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitDeserializer.m5481a(r4, r0, r7, r8);
    L_0x039f:
        com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitItemDeserializer.m5485b(r4, r0, r7, r8);
    L_0x03a2:
        com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer.m5488a(r4, r0, r7, r8);
    L_0x03a5:
        com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer.m5491b(r4, r0, r7, r8);
    L_0x03a8:
        com.facebook.graphql.deserializers.GraphQLPageDeserializer.m5505b(r4, r0, r7, r8);
    L_0x03ab:
        com.facebook.graphql.deserializers.GraphQLPageAdminInfoDeserializer.m5494a(r4, r0, r7, r8);
    L_0x03ae:
        com.facebook.graphql.deserializers.GraphQLPageBrowserCategoryInfoDeserializer.m5497a(r4, r0, r7);
    L_0x03b1:
        com.facebook.graphql.deserializers.GraphQLPageCallToActionDeserializer.m5500a(r4, r0, r7, r8);
    L_0x03b4:
        com.facebook.graphql.deserializers.GraphQLPageInfoDeserializer.m5508a(r4, r0, r7);
    L_0x03b7:
        com.facebook.graphql.deserializers.GraphQLPageLikersConnectionDeserializer.m5511a(r4, r0, r7, r8);
    L_0x03ba:
        com.facebook.graphql.deserializers.GraphQLPageMenuInfoDeserializer.m5514a(r4, r0, r7);
    L_0x03bd:
        com.facebook.graphql.deserializers.GraphQLPageOutcomeButtonDeserializer.m5517a(r4, r0, r7, r8);
    L_0x03c0:
        com.facebook.graphql.deserializers.GraphQLPagePostPromotionInfoDeserializer.m5520a(r4, r0, r7, r8);
    L_0x03c3:
        com.facebook.graphql.deserializers.GraphQLPageStarRatersConnectionDeserializer.m5523a(r4, r0, r7);
    L_0x03c6:
        com.facebook.graphql.deserializers.GraphQLPageStoriesYouMissedFeedUnitDeserializer.m5526a(r4, r0, r7, r8);
    L_0x03c9:
        com.facebook.graphql.deserializers.GraphQLPageStoriesYouMissedFeedUnitStoriesConnectionDeserializer.m5529a(r4, r0, r7, r8);
    L_0x03cc:
        com.facebook.graphql.deserializers.GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeDeserializer.m5532b(r4, r0, r7, r8);
    L_0x03cf:
        com.facebook.graphql.deserializers.GraphQLPageVisitsConnectionDeserializer.m5535a(r4, r0, r7);
    L_0x03d2:
        com.facebook.graphql.deserializers.GraphQLPagesYouMayAdvertiseFeedUnitDeserializer.m5538a(r4, r0, r7, r8);
    L_0x03d5:
        com.facebook.graphql.deserializers.GraphQLPagesYouMayAdvertiseFeedUnitItemDeserializer.m5542b(r4, r0, r7, r8);
    L_0x03d8:
        com.facebook.graphql.deserializers.GraphQLPagesYouMayLikeFeedUnitDeserializer.m5545a(r4, r0, r7, r8);
    L_0x03db:
        com.facebook.graphql.deserializers.GraphQLPagesYouMayLikeFeedUnitItemDeserializer.m5553b(r4, r0, r7, r8);
    L_0x03de:
        com.facebook.graphql.deserializers.GraphQLPagesYouMayLikeFeedUnitItemContentConnectionDeserializer.m5548a(r4, r0, r7, r8);
    L_0x03e1:
        com.facebook.graphql.deserializers.GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer.m5556a(r4, r0, r7, r8);
    L_0x03e4:
        com.facebook.graphql.deserializers.C0243x81539b2b.m5559a(r4, r0, r7, r8);
    L_0x03e7:
        com.facebook.graphql.deserializers.C0244x53cdff0a.m5562b(r4, r0, r7, r8);
    L_0x03ea:
        com.facebook.graphql.deserializers.GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer.m5565a(r4, r0, r7, r8);
    L_0x03ed:
        com.facebook.graphql.deserializers.C0245xd2646133.m5568a(r4, r0, r7, r8);
    L_0x03f0:
        com.facebook.graphql.deserializers.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer.m5571b(r4, r0, r7, r8);
    L_0x03f3:
        com.facebook.graphql.deserializers.GraphQLPeopleToFollowConnectionDeserializer.m5574a(r4, r0, r7, r8);
    L_0x03f6:
        com.facebook.graphql.deserializers.GraphQLPeopleYouMayInviteFeedUnitDeserializer.m5583a(r4, r0, r7, r8);
    L_0x03f9:
        com.facebook.graphql.deserializers.GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer.m5577a(r4, r0, r7, r8);
    L_0x03fc:
        com.facebook.graphql.deserializers.GraphQLPeopleYouMayInviteFeedUnitContactsEdgeDeserializer.m5580b(r4, r0, r7, r8);
    L_0x03ff:
        com.facebook.graphql.deserializers.GraphQLPeopleYouMayKnowFeedUnitDeserializer.m5586a(r4, r0, r7, r8);
    L_0x0402:
        com.facebook.graphql.deserializers.GraphQLPeopleYouMayKnowFeedUnitItemDeserializer.m5591b(r4, r0, r7, r8);
    L_0x0405:
        com.facebook.graphql.deserializers.GraphQLPeopleYouShouldFollowFeedUnitDeserializer.m5594a(r4, r0, r7, r8);
    L_0x0408:
        com.facebook.graphql.deserializers.GraphQLPeopleYouShouldFollowFeedUnitItemDeserializer.m5597b(r4, r0, r7, r8);
    L_0x040b:
        com.facebook.graphql.deserializers.GraphQLPhoneNumberDeserializer.m5600a(r4, r0, r7);
    L_0x040e:
        com.facebook.graphql.deserializers.GraphQLPhotoDeserializer.m5605b(r4, r0, r7, r8);
    L_0x0411:
        com.facebook.graphql.deserializers.GraphQLPhotoEncodingDeserializer.m5610b(r4, r0, r7, r8);
    L_0x0414:
        com.facebook.graphql.deserializers.GraphQLPhotoFaceBoxesConnectionDeserializer.m5613a(r4, r0, r7, r8);
    L_0x0417:
        com.facebook.graphql.deserializers.GraphQLPhotoTagDeserializer.m5616a(r4, r0, r7, r8);
    L_0x041a:
        com.facebook.graphql.deserializers.GraphQLPhotoTagsConnectionDeserializer.m5619a(r4, r0, r7, r8);
    L_0x041d:
        com.facebook.graphql.deserializers.GraphQLPhotoTagsEdgeDeserializer.m5622b(r4, r0, r7, r8);
    L_0x0420:
        com.facebook.graphql.deserializers.GraphQLPhotosphereMetadataDeserializer.m5625a(r4, r0, r7);
    L_0x0423:
        com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisDeserializer.m5628a(r4, r0, r7, r8);
    L_0x0426:
        com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisItemDeserializer.m5631a(r4, r0, r7, r8);
    L_0x0429:
        com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisItemsConnectionDeserializer.m5634a(r4, r0, r7, r8);
    L_0x042c:
        com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisItemsEdgeDeserializer.m5637b(r4, r0, r7, r8);
    L_0x042f:
        com.facebook.graphql.deserializers.GraphQLPlaceDeserializer.m5640a(r4, r0, r7, r8);
    L_0x0432:
        com.facebook.graphql.deserializers.GraphQLPlaceFlowInfoDeserializer.m5643a(r4, r0, r7);
    L_0x0435:
        com.facebook.graphql.deserializers.GraphQLPlaceListItemDeserializer.m5648b(r4, r0, r7, r8);
    L_0x0438:
        com.facebook.graphql.deserializers.GraphQLPlaceListItemToRecommendingCommentsConnectionDeserializer.m5651a(r4, r0, r7, r8);
    L_0x043b:
        com.facebook.graphql.deserializers.GraphQLPlaceListItemsFromPlaceListConnectionDeserializer.m5654a(r4, r0, r7, r8);
    L_0x043e:
        com.facebook.graphql.deserializers.GraphQLPlaceOpenStatusFormatDeserializer.m5659b(r4, r0, r7, r8);
    L_0x0441:
        com.facebook.graphql.deserializers.GraphQLPlaceRecommendationPostInfoDeserializer.m5662a(r4, r0, r7, r8);
    L_0x0444:
        com.facebook.graphql.deserializers.GraphQLPlaceReviewFeedUnitDeserializer.m5665a(r4, r0, r7, r8);
    L_0x0447:
        com.facebook.graphql.deserializers.GraphQLPlaceReviewFeedUnitItemDeserializer.m5669b(r4, r0, r7, r8);
    L_0x044a:
        com.facebook.graphql.deserializers.GraphQLPlaceSuggestionInfoDeserializer.m5672a(r4, r0, r7, r8);
    L_0x044d:
        com.facebook.graphql.deserializers.GraphQLPlacesTileResultsConnectionDeserializer.m5675a(r4, r0, r7, r8);
    L_0x0450:
        com.facebook.graphql.deserializers.GraphQLPlacesTileResultsEdgeDeserializer.m5678b(r4, r0, r7, r8);
    L_0x0453:
        com.facebook.graphql.deserializers.GraphQLPostChannelDeserializer.m5681a(r4, r0, r7, r8);
    L_0x0456:
        com.facebook.graphql.deserializers.GraphQLPostTranslatabilityDeserializer.m5684a(r4, r0, r7, r8);
    L_0x0459:
        com.facebook.graphql.deserializers.GraphQLPostedPhotosConnectionDeserializer.m5687a(r4, r0, r7, r8);
    L_0x045c:
        com.facebook.graphql.deserializers.GraphQLPrivacyAudienceMemberDeserializer.a(r4, r0, r7);
    L_0x045f:
        com.facebook.graphql.deserializers.GraphQLPrivacyEducationInfoDeserializer.m5690a(r4, r0, r7, r8);
    L_0x0462:
        com.facebook.graphql.deserializers.GraphQLPrivacyOptionDeserializer.a(r4, r0, r7, r8);
    L_0x0465:
        com.facebook.graphql.deserializers.GraphQLPrivacyOptionsComposerConnectionDeserializer.m5693a(r4, r0, r7, r8);
    L_0x0468:
        com.facebook.graphql.deserializers.GraphQLPrivacyOptionsComposerEdgeDeserializer.m5696b(r4, r0, r7, r8);
    L_0x046b:
        com.facebook.graphql.deserializers.GraphQLPrivacyOptionsContentConnectionDeserializer.m5699a(r4, r0, r7, r8);
    L_0x046e:
        com.facebook.graphql.deserializers.GraphQLPrivacyOptionsContentEdgeDeserializer.m5704b(r4, r0, r7, r8);
    L_0x0471:
        com.facebook.graphql.deserializers.GraphQLPrivacyRowInputDeserializer.a(r4, r0, r7);
    L_0x0474:
        com.facebook.graphql.deserializers.GraphQLPrivacyScopeDeserializer.m5707a(r4, r0, r7, r8);
    L_0x0477:
        com.facebook.graphql.deserializers.GraphQLPrivateReplyContextDeserializer.m5710a(r4, r0, r7, r8);
    L_0x047a:
        com.facebook.graphql.deserializers.GraphQLProductItemDeserializer.m5713a(r4, r0, r7, r8);
    L_0x047d:
        com.facebook.graphql.deserializers.GraphQLProfileDeserializer.m5721b(r4, r0, r7, r8);
    L_0x0480:
        com.facebook.graphql.deserializers.GraphQLProfileBadgeDeserializer.m5716a(r4, r0, r7, r8);
    L_0x0483:
        com.facebook.graphql.deserializers.GraphQLProfileVideoDeserializer.m5724a(r4, r0, r7, r8);
    L_0x0486:
        com.facebook.graphql.deserializers.GraphQLQPStringEnumTemplateParameterDeserializer.m5727a(r4, r0, r7);
    L_0x0489:
        com.facebook.graphql.deserializers.GraphQLQPTemplateParameterDeserializer.m5730a(r4, r0, r7);
    L_0x048c:
        com.facebook.graphql.deserializers.GraphQLQuantityDeserializer.m5733a(r4, r0, r7);
    L_0x048f:
        com.facebook.graphql.deserializers.GraphQLQuestionOptionDeserializer.m5736b(r4, r0, r7, r8);
    L_0x0492:
        com.facebook.graphql.deserializers.GraphQLQuestionOptionVotersConnectionDeserializer.m5739a(r4, r0, r7, r8);
    L_0x0495:
        com.facebook.graphql.deserializers.GraphQLQuestionOptionsConnectionDeserializer.m5742a(r4, r0, r7, r8);
    L_0x0498:
        com.facebook.graphql.deserializers.GraphQLQuickPromotionDeserializer.m5751a(r4, r0, r7, r8);
    L_0x049b:
        com.facebook.graphql.deserializers.GraphQLQuickPromotionActionDeserializer.m5745a(r4, r0, r7, r8);
    L_0x049e:
        com.facebook.graphql.deserializers.GraphQLQuickPromotionCreativeDeserializer.m5748b(r4, r0, r7, r8);
    L_0x04a1:
        com.facebook.graphql.deserializers.GraphQLQuickPromotionFeedUnitDeserializer.m5754a(r4, r0, r7, r8);
    L_0x04a4:
        com.facebook.graphql.deserializers.GraphQLQuickPromotionFeedUnitItemDeserializer.m5759b(r4, r0, r7, r8);
    L_0x04a7:
        com.facebook.graphql.deserializers.GraphQLQuickPromotionPeopleYouMayKnowFeedUnitDeserializer.m5762a(r4, r0, r7, r8);
    L_0x04aa:
        com.facebook.graphql.deserializers.GraphQLQuickPromotionTemplateDeserializer.m5765a(r4, r0, r7, r8);
    L_0x04ad:
        com.facebook.graphql.deserializers.GraphQLQuotesAnalysisDeserializer.m5768a(r4, r0, r7, r8);
    L_0x04b0:
        com.facebook.graphql.deserializers.GraphQLQuotesAnalysisItemDeserializer.m5771a(r4, r0, r7);
    L_0x04b3:
        com.facebook.graphql.deserializers.GraphQLQuotesAnalysisItemsConnectionDeserializer.m5774a(r4, r0, r7, r8);
    L_0x04b6:
        com.facebook.graphql.deserializers.GraphQLQuotesAnalysisItemsEdgeDeserializer.m5777b(r4, r0, r7, r8);
    L_0x04b9:
        com.facebook.graphql.deserializers.GraphQLRatingDeserializer.m5780a(r4, r0, r7);
    L_0x04bc:
        com.facebook.graphql.deserializers.GraphQLReactionPostPivotComponentDeserializer.m5783a(r4, r0, r7, r8);
    L_0x04bf:
        com.facebook.graphql.deserializers.GraphQLReactionUnitDeserializer.m5786a(r4, r0, r7, r8);
    L_0x04c2:
        com.facebook.graphql.deserializers.GraphQLReactorsOfContentConnectionDeserializer.m5789a(r4, r0, r7, r8);
    L_0x04c5:
        com.facebook.graphql.deserializers.GraphQLReactorsOfContentEdgeDeserializer.m5792b(r4, r0, r7, r8);
    L_0x04c8:
        com.facebook.graphql.deserializers.GraphQLRedSpaceActivityDeserializer.m5795a(r4, r0, r7, r8);
    L_0x04cb:
        com.facebook.graphql.deserializers.GraphQLRedSpaceStoryInfoDeserializer.m5798a(r4, r0, r7);
    L_0x04ce:
        com.facebook.graphql.deserializers.GraphQLRedirectionInfoDeserializer.m5803b(r4, r0, r7, r8);
    L_0x04d1:
        com.facebook.graphql.deserializers.GraphQLRelevantReactorsConnectionDeserializer.m5806a(r4, r0, r7, r8);
    L_0x04d4:
        com.facebook.graphql.deserializers.GraphQLRelevantReactorsEdgeDeserializer.m5809b(r4, r0, r7, r8);
    L_0x04d7:
        com.facebook.graphql.deserializers.GraphQLResearchPollFeedUnitDeserializer.m5812a(r4, r0, r7, r8);
    L_0x04da:
        com.facebook.graphql.deserializers.GraphQLResearchPollMultipleChoiceQuestionDeserializer.m5817b(r4, r0, r7, r8);
    L_0x04dd:
        com.facebook.graphql.deserializers.GraphQLResearchPollMultipleChoiceResponseDeserializer.m5820b(r4, r0, r7, r8);
    L_0x04e0:
        com.facebook.graphql.deserializers.GraphQLResearchPollQuestionRespondersConnectionDeserializer.m5823a(r4, r0, r7);
    L_0x04e3:
        com.facebook.graphql.deserializers.GraphQLResearchPollQuestionResponsesConnectionDeserializer.m5826a(r4, r0, r7, r8);
    L_0x04e6:
        com.facebook.graphql.deserializers.GraphQLResearchPollResponseRespondersConnectionDeserializer.m5829a(r4, r0, r7);
    L_0x04e9:
        com.facebook.graphql.deserializers.GraphQLResearchPollSurveyDeserializer.m5832a(r4, r0, r7, r8);
    L_0x04ec:
        com.facebook.graphql.deserializers.GraphQLResearchPollSurveyQuestionHistoryConnectionDeserializer.m5835a(r4, r0, r7, r8);
    L_0x04ef:
        com.facebook.graphql.deserializers.GraphQLReshareEducationInfoDeserializer.m5838a(r4, r0, r7);
    L_0x04f2:
        com.facebook.graphql.deserializers.GraphQLResharesOfContentConnectionDeserializer.m5841a(r4, r0, r7);
    L_0x04f5:
        com.facebook.graphql.deserializers.GraphQLSaleGroupsNearYouFeedUnitDeserializer.m5844a(r4, r0, r7, r8);
    L_0x04f8:
        com.facebook.graphql.deserializers.GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer.m5847a(r4, r0, r7, r8);
    L_0x04fb:
        com.facebook.graphql.deserializers.GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeDeserializer.m5850b(r4, r0, r7, r8);
    L_0x04fe:
        com.facebook.graphql.deserializers.GraphQLSavedCollectionFeedUnitDeserializer.m5853a(r4, r0, r7, r8);
    L_0x0501:
        com.facebook.graphql.deserializers.GraphQLSavedCollectionFeedUnitItemDeserializer.m5858b(r4, r0, r7, r8);
    L_0x0504:
        com.facebook.graphql.deserializers.GraphQLSavedDashboardSectionDeserializer.m5861a(r4, r0, r7);
    L_0x0507:
        com.facebook.graphql.deserializers.GraphQLSearchAwarenessSuggestionDeserializer.m5864a(r4, r0, r7);
    L_0x050a:
        com.facebook.graphql.deserializers.GraphQLSearchShortcutDeserializer.m5867a(r4, r0, r7);
    L_0x050d:
        com.facebook.graphql.deserializers.GraphQLSearchSuggestionUnitDeserializer.m5870a(r4, r0, r7, r8);
    L_0x0510:
        com.facebook.graphql.deserializers.GraphQLSearchSuggestionsConnectionDeserializer.m5873a(r4, r0, r7, r8);
    L_0x0513:
        com.facebook.graphql.deserializers.GraphQLSearchSuggestionsEdgeDeserializer.m5876b(r4, r0, r7, r8);
    L_0x0516:
        com.facebook.graphql.deserializers.GraphQLSeenByConnectionDeserializer.m5879a(r4, r0, r7, r8);
    L_0x0519:
        com.facebook.graphql.deserializers.GraphQLSideFeedConnectionDeserializer.m5882a(r4, r0, r7, r8);
    L_0x051c:
        com.facebook.graphql.deserializers.GraphQLSideFeedEdgeDeserializer.m5885b(r4, r0, r7, r8);
    L_0x051f:
        com.facebook.graphql.deserializers.GraphQLSideFeedUnitDeserializer.m5888a(r4, r0, r7, r8);
    L_0x0522:
        com.facebook.graphql.deserializers.GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5891a(r4, r0, r7, r8);
    L_0x0525:
        com.facebook.graphql.deserializers.GraphQLSinglePublisherVideoChannelsEdgeDeserializer.m5894b(r4, r0, r7, r8);
    L_0x0528:
        com.facebook.graphql.deserializers.GraphQLSocialWifiFeedUnitDeserializer.m5897a(r4, r0, r7, r8);
    L_0x052b:
        com.facebook.graphql.deserializers.GraphQLSocialWifiFeedUnitItemDeserializer.m5902b(r4, r0, r7, r8);
    L_0x052e:
        com.facebook.graphql.deserializers.GraphQLSouvenirDeserializer.m5905a(r4, r0, r7, r8);
    L_0x0531:
        com.facebook.graphql.deserializers.GraphQLSouvenirMediaConnectionDeserializer.m5908a(r4, r0, r7, r8);
    L_0x0534:
        com.facebook.graphql.deserializers.GraphQLSouvenirMediaEdgeDeserializer.m5911b(r4, r0, r7, r8);
    L_0x0537:
        com.facebook.graphql.deserializers.GraphQLSouvenirMediaElementDeserializer.m5914a(r4, r0, r7, r8);
    L_0x053a:
        com.facebook.graphql.deserializers.GraphQLSouvenirMediaElementMediaConnectionDeserializer.m5917a(r4, r0, r7, r8);
    L_0x053d:
        com.facebook.graphql.deserializers.GraphQLSouvenirMediaElementMediaEdgeDeserializer.m5920b(r4, r0, r7, r8);
    L_0x0540:
        com.facebook.graphql.deserializers.GraphQLSponsoredDataDeserializer.m5923a(r4, r0, r7, r8);
    L_0x0543:
        com.facebook.graphql.deserializers.GraphQLSportsDataMatchDataDeserializer.m5926a(r4, r0, r7, r8);
    L_0x0546:
        com.facebook.graphql.deserializers.GraphQLSportsDataMatchDataFactDeserializer.m5929b(r4, r0, r7, r8);
    L_0x0549:
        com.facebook.graphql.deserializers.GraphQLSportsDataMatchToFactsConnectionDeserializer.m5932a(r4, r0, r7, r8);
    L_0x054c:
        com.facebook.graphql.deserializers.GraphQLSportsDataMatchToFanFavoriteConnectionDeserializer.m5935a(r4, r0, r7, r8);
    L_0x054f:
        com.facebook.graphql.deserializers.GraphQLSportsDataMatchToFanFavoriteEdgeDeserializer.m5938b(r4, r0, r7, r8);
    L_0x0552:
        com.facebook.graphql.deserializers.GraphQLStatelessLargeImagePLAsConnectionDeserializer.m5941a(r4, r0, r7, r8);
    L_0x0555:
        com.facebook.graphql.deserializers.GraphQLStatelessLargeImagePLAsEdgeDeserializer.m5944b(r4, r0, r7, r8);
    L_0x0558:
        com.facebook.graphql.deserializers.GraphQLStickerDeserializer.m5947a(r4, r0, r7, r8);
    L_0x055b:
        com.facebook.graphql.deserializers.GraphQLStoryDeserializer.m5966b(r4, r0, r7, r8);
    L_0x055e:
        com.facebook.graphql.deserializers.GraphQLStoryActionLinkDeserializer.m5952b(r4, r0, r7, r8);
    L_0x0561:
        com.facebook.graphql.deserializers.GraphQLStoryAttachmentDeserializer.m5957b(r4, r0, r7, r8);
    L_0x0564:
        com.facebook.graphql.deserializers.GraphQLStoryAttachmentStyleInfoDeserializer.m5961b(r4, r0, r7, r8);
    L_0x0567:
        com.facebook.graphql.deserializers.GraphQLStoryGallerySurveyFeedUnitDeserializer.m5969a(r4, r0, r7, r8);
    L_0x056a:
        com.facebook.graphql.deserializers.GraphQLStoryHeaderDeserializer.m5972a(r4, r0, r7, r8);
    L_0x056d:
        com.facebook.graphql.deserializers.GraphQLStoryInsightsDeserializer.m5975a(r4, r0, r7);
    L_0x0570:
        com.facebook.graphql.deserializers.GraphQLStorySaveInfoDeserializer.m5978a(r4, r0, r7);
    L_0x0573:
        com.facebook.graphql.deserializers.GraphQLStorySetDeserializer.m5981a(r4, r0, r7, r8);
    L_0x0576:
        com.facebook.graphql.deserializers.GraphQLStorySetItemDeserializer.m5984a(r4, r0, r7, r8);
    L_0x0579:
        com.facebook.graphql.deserializers.GraphQLStorySetStoriesConnectionDeserializer.m5987a(r4, r0, r7, r8);
    L_0x057c:
        com.facebook.graphql.deserializers.GraphQLStoryTopicsContextDeserializer.m5990a(r4, r0, r7, r8);
    L_0x057f:
        com.facebook.graphql.deserializers.GraphQLStreamingImageDeserializer.m5993a(r4, r0, r7);
    L_0x0582:
        com.facebook.graphql.deserializers.GraphQLStreetAddressDeserializer.m5996a(r4, r0, r7);
    L_0x0585:
        com.facebook.graphql.deserializers.GraphQLStructuredSurveyDeserializer.m6002a(r4, r0, r7, r8);
    L_0x0588:
        com.facebook.graphql.deserializers.GraphQLStructuredSurveyConfiguredQuestionDeserializer.m5999a(r4, r0, r7, r8);
    L_0x058b:
        com.facebook.graphql.deserializers.GraphQLStructuredSurveyQuestionDeserializer.m6005b(r4, r0, r7, r8);
    L_0x058e:
        com.facebook.graphql.deserializers.GraphQLStructuredSurveyQuestionsConnectionDeserializer.m6008a(r4, r0, r7, r8);
    L_0x0591:
        com.facebook.graphql.deserializers.GraphQLStructuredSurveyResponseOptionDeserializer.m6013b(r4, r0, r7, r8);
    L_0x0594:
        com.facebook.graphql.deserializers.GraphQLSubstoriesConnectionDeserializer.m6016a(r4, r0, r7, r8);
    L_0x0597:
        com.facebook.graphql.deserializers.GraphQLSuggestedContentConnectionDeserializer.m6019a(r4, r0, r7, r8);
    L_0x059a:
        com.facebook.graphql.deserializers.GraphQLSuggestedVideoConnectionDeserializer.m6022a(r4, r0, r7, r8);
    L_0x059d:
        com.facebook.graphql.deserializers.GraphQLSurveyFeedUnitDeserializer.m6025a(r4, r0, r7, r8);
    L_0x05a0:
        com.facebook.graphql.deserializers.GraphQLTagExpansionEducationInfoDeserializer.m6028a(r4, r0, r7);
    L_0x05a3:
        com.facebook.graphql.deserializers.GraphQLTaggableActivityDeserializer.m6035b(r4, r0, r7, r8);
    L_0x05a6:
        com.facebook.graphql.deserializers.GraphQLTaggableActivityAllIconsConnectionDeserializer.m6031a(r4, r0, r7, r8);
    L_0x05a9:
        com.facebook.graphql.deserializers.GraphQLTaggableActivityIconDeserializer.m6040b(r4, r0, r7, r8);
    L_0x05ac:
        com.facebook.graphql.deserializers.GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(r4, r0, r7, r8);
    L_0x05af:
        com.facebook.graphql.deserializers.GraphQLTaggableActivitySuggestionsEdgeDeserializer.m6046a(r4, r0, r7, r8);
    L_0x05b2:
        com.facebook.graphql.deserializers.GraphQLTargetingDescriptionDeserializer.m6049a(r4, r0, r7);
    L_0x05b5:
        com.facebook.graphql.deserializers.GraphQLTargetingDescriptionSentenceDeserializer.m6052a(r4, r0, r7);
    L_0x05b8:
        com.facebook.graphql.deserializers.GraphQLTemporalEventInfoDeserializer.m6055a(r4, r0, r7, r8);
    L_0x05bb:
        com.facebook.graphql.deserializers.GraphQLTextWithEntitiesDeserializer.m6060b(r4, r0, r7, r8);
    L_0x05be:
        com.facebook.graphql.deserializers.GraphQLTimeRangeDeserializer.m6063a(r4, r0, r7);
    L_0x05c1:
        com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionDeserializer.m6070b(r4, r0, r7, r8);
    L_0x05c4:
        com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionItemDeserializer.m6073a(r4, r0, r7, r8);
    L_0x05c7:
        com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6076a(r4, r0, r7, r8);
    L_0x05ca:
        com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionsConnectionDeserializer.m6079a(r4, r0, r7, r8);
    L_0x05cd:
        com.facebook.graphql.deserializers.GraphQLTimelineAppSectionDeserializer.m6082a(r4, r0, r7, r8);
    L_0x05d0:
        com.facebook.graphql.deserializers.GraphQLTimelineSectionDeserializer.m6085b(r4, r0, r7, r8);
    L_0x05d3:
        com.facebook.graphql.deserializers.GraphQLTimelineSectionUnitsConnectionDeserializer.m6088a(r4, r0, r7, r8);
    L_0x05d6:
        com.facebook.graphql.deserializers.GraphQLTimelineSectionUnitsEdgeDeserializer.m6091b(r4, r0, r7, r8);
    L_0x05d9:
        com.facebook.graphql.deserializers.GraphQLTimelineSectionsConnectionDeserializer.m6094a(r4, r0, r7, r8);
    L_0x05dc:
        com.facebook.graphql.deserializers.GraphQLTimelineStoriesConnectionDeserializer.m6097a(r4, r0, r7, r8);
    L_0x05df:
        com.facebook.graphql.deserializers.GraphQLTimezoneInfoDeserializer.m6100a(r4, r0, r7);
    L_0x05e2:
        com.facebook.graphql.deserializers.GraphQLTopLevelCommentsConnectionDeserializer.m6103a(r4, r0, r7, r8);
    L_0x05e5:
        com.facebook.graphql.deserializers.GraphQLTopReactionsConnectionDeserializer.m6106a(r4, r0, r7, r8);
    L_0x05e8:
        com.facebook.graphql.deserializers.GraphQLTopReactionsEdgeDeserializer.m6109b(r4, r0, r7, r8);
    L_0x05eb:
        com.facebook.graphql.deserializers.GraphQLTopicDeserializer.m6117b(r4, r0, r7, r8);
    L_0x05ee:
        com.facebook.graphql.deserializers.GraphQLTopicCustomizationStoryDeserializer.m6112a(r4, r0, r7, r8);
    L_0x05f1:
        com.facebook.graphql.deserializers.GraphQLTopicFeedOptionDeserializer.m6120a(r4, r0, r7);
    L_0x05f4:
        com.facebook.graphql.deserializers.GraphQLTranslationMetaDataDeserializer.m6123a(r4, r0, r7);
    L_0x05f7:
        com.facebook.graphql.deserializers.GraphQLTrendingEntitiesEdgeDeserializer.m6126a(r4, r0, r7, r8);
    L_0x05fa:
        com.facebook.graphql.deserializers.GraphQLTrendingTopicDataDeserializer.m6129a(r4, r0, r7, r8);
    L_0x05fd:
        com.facebook.graphql.deserializers.GraphQLTrueTopicFeedOptionDeserializer.m6132a(r4, r0, r7, r8);
    L_0x0600:
        com.facebook.graphql.deserializers.GraphQLTrueTopicFeedOptionsConnectionDeserializer.m6135a(r4, r0, r7, r8);
    L_0x0603:
        com.facebook.graphql.deserializers.GraphQLTrueTopicFeedOptionsEdgeDeserializer.m6138b(r4, r0, r7, r8);
    L_0x0606:
        com.facebook.graphql.deserializers.GraphQLUnknownFeedUnitDeserializer.m6141a(r4, r0, r7);
    L_0x0609:
        com.facebook.graphql.deserializers.GraphQLUnseenStoriesConnectionDeserializer.m6144a(r4, r0, r7, r8);
    L_0x060c:
        com.facebook.graphql.deserializers.GraphQLUnseenStoriesFeedUnitDeserializer.m6147a(r4, r0, r7, r8);
    L_0x060f:
        com.facebook.graphql.deserializers.GraphQLUserDeserializer.m6152b(r4, r0, r7, r8);
    L_0x0612:
        com.facebook.graphql.deserializers.GraphQLUserEducationExperiencesConnectionDeserializer.m6155a(r4, r0, r7, r8);
    L_0x0615:
        com.facebook.graphql.deserializers.GraphQLUserEducationExperiencesEdgeDeserializer.m6158b(r4, r0, r7, r8);
    L_0x0618:
        com.facebook.graphql.deserializers.GraphQLUserWorkExperiencesConnectionDeserializer.m6161a(r4, r0, r7, r8);
    L_0x061b:
        com.facebook.graphql.deserializers.GraphQLUserWorkExperiencesEdgeDeserializer.m6164b(r4, r0, r7, r8);
    L_0x061e:
        com.facebook.graphql.deserializers.GraphQLVect2Deserializer.m6167a(r4, r0, r7);
    L_0x0621:
        com.facebook.graphql.deserializers.GraphQLVideoDeserializer.m6186a(r4, r0, r7, r8);
    L_0x0624:
        com.facebook.graphql.deserializers.GraphQLVideoAnnotationDeserializer.m6170a(r4, r0, r7);
    L_0x0627:
        com.facebook.graphql.deserializers.GraphQLVideoChainingFeedUnitDeserializer.m6175a(r4, r0, r7, r8);
    L_0x062a:
        com.facebook.graphql.deserializers.GraphQLVideoChannelDeserializer.m6178a(r4, r0, r7, r8);
    L_0x062d:
        com.facebook.graphql.deserializers.GraphQLVideoChannelFeedEdgeDeserializer.m6183b(r4, r0, r7, r8);
    L_0x0630:
        com.facebook.graphql.deserializers.GraphQLVideoGuidedTourDeserializer.m6189a(r4, r0, r7, r8);
    L_0x0633:
        com.facebook.graphql.deserializers.GraphQLVideoGuidedTourKeyframeDeserializer.m6192a(r4, r0, r7);
    L_0x0636:
        com.facebook.graphql.deserializers.GraphQLVideoTimestampedCommentsConnectionDeserializer.m6195a(r4, r0, r7, r8);
    L_0x0639:
        com.facebook.graphql.deserializers.GraphQLVideoTimestampedCommentsEdgeDeserializer.m6198b(r4, r0, r7, r8);
    L_0x063c:
        com.facebook.graphql.deserializers.GraphQLViewerDeserializer.m6201a(r4, r0, r7, r8);
    L_0x063f:
        com.facebook.graphql.deserializers.GraphQLViewerVisitsConnectionDeserializer.m6204a(r4, r0, r7);
    L_0x0642:
        com.facebook.graphql.deserializers.GraphQLWithTagsConnectionDeserializer.m6207a(r4, r0, r7, r8);
    L_0x0645:
        com.facebook.graphql.deserializers.GraphQLWorkCommunityTrendingFeedUnitDeserializer.m6210a(r4, r0, r7, r8);
    L_0x0648:
        com.facebook.graphql.deserializers.GraphQLWorkCommunityTrendingFeedUnitItemDeserializer.m6214b(r4, r0, r7, r8);
    L_0x064b:
        com.facebook.graphql.deserializers.GraphQLWorkExperienceDeserializer.m6218b(r4, r0, r7, r8);
    L_0x064e:
        com.facebook.graphql.deserializers.GraphQLWriteReviewActionLinkDeserializer.m6221a(r4, r0, r7, r8);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.deserializers.FeedUnitDeserializerResolver.a(com.facebook.flatbuffers.MutableFlatBuffer, int, int, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
    }
}
