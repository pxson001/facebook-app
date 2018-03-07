package com.facebook.graphql.model;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: lead_gen_data_id */
public class FeedUnitSerializer extends JsonSerializer<FeedUnit> {
    public final void m6334a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Class cls;
        FeedUnit feedUnit = (FeedUnit) obj;
        String e = new GraphQLObjectType(feedUnit.jK_()).e();
        Object obj2 = -1;
        switch (e.hashCode()) {
            case -2066307870:
                if (e.equals("PeopleYouMayKnowFeedUnit")) {
                    obj2 = 33;
                    break;
                }
                break;
            case -1917069369:
                if (e.equals("SavedCollectionFeedUnit")) {
                    obj2 = 20;
                    break;
                }
                break;
            case -1889837793:
                if (e.equals("PagesYouMayAdvertiseFeedUnit")) {
                    obj2 = 14;
                    break;
                }
                break;
            case -1746223584:
                if (e.equals("PeopleYouMayInviteFeedUnit")) {
                    obj2 = 32;
                    break;
                }
                break;
            case -1608991266:
                if (e.equals("FindFriendsFeedUnit")) {
                    obj2 = 41;
                    break;
                }
                break;
            case -1528092760:
                if (e.equals("MobilePageAdminPanelFeedUnit")) {
                    obj2 = 26;
                    break;
                }
                break;
            case -1526076857:
                if (e.equals("GoodwillThrowbackPromotionFeedUnit")) {
                    obj2 = 36;
                    break;
                }
                break;
            case -1459322407:
                if (e.equals("ArticleChainingFeedUnit")) {
                    obj2 = 22;
                    break;
                }
                break;
            case -1415982150:
                if (e.equals("NoContentFeedUnit")) {
                    obj2 = 38;
                    break;
                }
                break;
            case -1396660317:
                if (e.equals("PagesYouMayLikeFeedUnit")) {
                    obj2 = 15;
                    break;
                }
                break;
            case -1375500085:
                if (e.equals("FriendsLocationsFeedUnit")) {
                    obj2 = 9;
                    break;
                }
                break;
            case -1322509030:
                if (e.equals("EventCollectionFeedUnit")) {
                    obj2 = 23;
                    break;
                }
                break;
            case -1275526754:
                if (e.equals("SaleGroupsNearYouFeedUnit")) {
                    obj2 = 18;
                    break;
                }
                break;
            case -1231984970:
                if (e.equals("PeopleYouShouldFollowFeedUnit")) {
                    obj2 = 42;
                    break;
                }
                break;
            case -1190325796:
                if (e.equals("SurveyFeedUnit")) {
                    obj2 = 4;
                    break;
                }
                break;
            case -1183381502:
                if (e.equals("NoContentGoodFriendsFeedUnit")) {
                    obj2 = 39;
                    break;
                }
                break;
            case -1182375855:
                if (e.equals("TopicCustomizationStory")) {
                    obj2 = 43;
                    break;
                }
                break;
            case -1181166899:
                if (e.equals("FindPagesFeedUnit")) {
                    obj2 = 40;
                    break;
                }
                break;
            case -1148667268:
                if (e.equals("ResearchPollFeedUnit")) {
                    obj2 = 5;
                    break;
                }
                break;
            case -1080337823:
                if (e.equals("UnseenStoriesFeedUnit")) {
                    obj2 = 24;
                    break;
                }
                break;
            case -1012424648:
                if (e.equals("QuickPromotionPeopleYouMayKnowFeedUnit")) {
                    obj2 = 35;
                    break;
                }
                break;
            case -943698815:
                if (e.equals("PlaceReviewFeedUnit")) {
                    obj2 = 12;
                    break;
                }
                break;
            case -875190709:
                if (e.equals("CelebrationsFeedUnit")) {
                    obj2 = 2;
                    break;
                }
                break;
            case -862531932:
                if (e.equals("SocialWifiFeedUnit")) {
                    obj2 = 6;
                    break;
                }
                break;
            case -818421799:
                if (e.equals("StoryGallerySurveyFeedUnit")) {
                    obj2 = 25;
                    break;
                }
                break;
            case -768185132:
                if (e.equals("CustomizedStory")) {
                    obj2 = 28;
                    break;
                }
                break;
            case -659919312:
                if (e.equals("PYMLWithLargeImageFeedUnit")) {
                    obj2 = 30;
                    break;
                }
                break;
            case -563086408:
                if (e.equals("PageStoriesYouMissedFeedUnit")) {
                    obj2 = 13;
                    break;
                }
                break;
            case -491890118:
                if (e.equals("InstagramPhotosFromFriendsFeedUnit")) {
                    obj2 = 7;
                    break;
                }
                break;
            case -240759564:
                if (e.equals("HoldoutAdFeedUnit")) {
                    obj2 = 3;
                    break;
                }
                break;
            case 74545917:
                if (e.equals("PaginatedGroupsYouShouldJoinFeedUnit")) {
                    obj2 = 27;
                    break;
                }
                break;
            case 80218325:
                if (e.equals("Story")) {
                    obj2 = null;
                    break;
                }
                break;
            case 88250206:
                if (e.equals("VideoChainingFeedUnit")) {
                    obj2 = 21;
                    break;
                }
                break;
            case 336198388:
                if (e.equals("CreativePagesYouMayLikeFeedUnit")) {
                    obj2 = 29;
                    break;
                }
                break;
            case 341326393:
                if (e.equals("GoodwillThrowbackFriendversaryStory")) {
                    obj2 = 37;
                    break;
                }
                break;
            case 391633076:
                if (e.equals("ClientBumpingPlaceHolderFeedUnit")) {
                    obj2 = 31;
                    break;
                }
                break;
            case 422860284:
                if (e.equals("GreetingCardPromotionFeedUnit")) {
                    obj2 = 8;
                    break;
                }
                break;
            case 1112886300:
                if (e.equals("GroupsYouShouldCreateFeedUnit")) {
                    obj2 = 17;
                    break;
                }
                break;
            case 1257701471:
                if (e.equals("GroupTopStoriesFeedUnit")) {
                    obj2 = 19;
                    break;
                }
                break;
            case 1641611192:
                if (e.equals("QuickPromotionFeedUnit")) {
                    obj2 = 10;
                    break;
                }
                break;
            case 1700442483:
                if (e.equals("GoodwillAnniversaryCampaignFeedUnit")) {
                    obj2 = 11;
                    break;
                }
                break;
            case 1710363082:
                if (e.equals("GroupsYouShouldJoinFeedUnit")) {
                    obj2 = 16;
                    break;
                }
                break;
            case 1782386509:
                if (e.equals("StorySet")) {
                    obj2 = 1;
                    break;
                }
                break;
            case 2028208271:
                if (e.equals("PaginatedPeopleYouMayKnowFeedUnit")) {
                    obj2 = 34;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                cls = GraphQLStory.class;
                break;
            case 1:
                cls = GraphQLStorySet.class;
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                cls = GraphQLCelebrationsFeedUnit.class;
                break;
            case 3:
                cls = GraphQLHoldoutAdFeedUnit.class;
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                cls = GraphQLSurveyFeedUnit.class;
                break;
            case 5:
                cls = GraphQLResearchPollFeedUnit.class;
                break;
            case 6:
                cls = GraphQLSocialWifiFeedUnit.class;
                break;
            case 7:
                cls = GraphQLInstagramPhotosFromFriendsFeedUnit.class;
                break;
            case 8:
                cls = GraphQLGreetingCardPromotionFeedUnit.class;
                break;
            case 9:
                cls = GraphQLFriendsLocationsFeedUnit.class;
                break;
            case 10:
                cls = GraphQLQuickPromotionFeedUnit.class;
                break;
            case 11:
                cls = GraphQLGoodwillAnniversaryCampaignFeedUnit.class;
                break;
            case 12:
                cls = GraphQLPlaceReviewFeedUnit.class;
                break;
            case 13:
                cls = GraphQLPageStoriesYouMissedFeedUnit.class;
                break;
            case 14:
                cls = GraphQLPagesYouMayAdvertiseFeedUnit.class;
                break;
            case 15:
                cls = GraphQLPagesYouMayLikeFeedUnit.class;
                break;
            case 16:
                cls = GraphQLGroupsYouShouldJoinFeedUnit.class;
                break;
            case 17:
                cls = GraphQLGroupsYouShouldCreateFeedUnit.class;
                break;
            case 18:
                cls = GraphQLSaleGroupsNearYouFeedUnit.class;
                break;
            case 19:
                cls = GraphQLGroupTopStoriesFeedUnit.class;
                break;
            case 20:
                cls = GraphQLSavedCollectionFeedUnit.class;
                break;
            case 21:
                cls = GraphQLVideoChainingFeedUnit.class;
                break;
            case 22:
                cls = GraphQLArticleChainingFeedUnit.class;
                break;
            case 23:
                cls = GraphQLEventCollectionFeedUnit.class;
                break;
            case 24:
                cls = GraphQLUnseenStoriesFeedUnit.class;
                break;
            case 25:
                cls = GraphQLStoryGallerySurveyFeedUnit.class;
                break;
            case 26:
                cls = GraphQLMobilePageAdminPanelFeedUnit.class;
                break;
            case 27:
                cls = GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class;
                break;
            case 28:
                cls = GraphQLCustomizedStory.class;
                break;
            case 29:
                cls = GraphQLCreativePagesYouMayLikeFeedUnit.class;
                break;
            case 30:
                cls = GraphQLPYMLWithLargeImageFeedUnit.class;
                break;
            case 31:
                cls = GraphQLClientBumpingPlaceHolderFeedUnit.class;
                break;
            case 32:
                cls = GraphQLPeopleYouMayInviteFeedUnit.class;
                break;
            case 33:
                cls = GraphQLPeopleYouMayKnowFeedUnit.class;
                break;
            case 34:
                cls = GraphQLPaginatedPeopleYouMayKnowFeedUnit.class;
                break;
            case 35:
                cls = GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.class;
                break;
            case 36:
                cls = GraphQLGoodwillThrowbackPromotionFeedUnit.class;
                break;
            case 37:
                cls = GraphQLGoodwillThrowbackFriendversaryStory.class;
                break;
            case 38:
                cls = GraphQLNoContentFeedUnit.class;
                break;
            case 39:
            case 40:
                cls = GraphQLFindPagesFeedUnit.class;
                break;
            case 41:
                cls = GraphQLFindFriendsFeedUnit.class;
                break;
            case 42:
                cls = GraphQLPeopleYouShouldFollowFeedUnit.class;
                break;
            case 43:
                cls = GraphQLTopicCustomizationStory.class;
                break;
            default:
                cls = GraphQLUnknownFeedUnit.class;
                break;
        }
        FbSerializerProvider.a(cls).a(feedUnit, jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(FeedUnit.class, new FeedUnitSerializer());
    }

    public static void m6333a(JsonGenerator jsonGenerator, FeedUnit feedUnit) {
        FbSerializerProvider.a(FeedUnit.class).a(feedUnit, jsonGenerator, null);
    }
}
