package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCommercePageSetting;
import com.facebook.graphql.enums.GraphQLCommercePageType;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPagePaymentOption;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLReactionRequestedUnit;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: nux_megaphone */
public class GraphQLPageDeserializer {
    public static int m5501a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[194];
        boolean[] zArr = new boolean[72];
        boolean[] zArr2 = new boolean[49];
        int[] iArr2 = new int[9];
        double[] dArr = new double[1];
        Enum[] enumArr = new Enum[13];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("about")) {
                    iArr[0] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("activity_admin_info")) {
                    iArr[1] = GraphQLPageAdminInfoDeserializer.m5492a(jsonParser, flatBufferBuilder);
                } else if (i.equals("address")) {
                    iArr[2] = GraphQLStreetAddressDeserializer.m5994a(jsonParser, flatBufferBuilder);
                } else if (i.equals("admin_info")) {
                    iArr[3] = GraphQLPageAdminInfoDeserializer.m5492a(jsonParser, flatBufferBuilder);
                } else if (i.equals("albums")) {
                    iArr[4] = GraphQLAlbumsConnectionDeserializer.m4552a(jsonParser, flatBufferBuilder);
                } else if (i.equals("android_urls")) {
                    iArr[6] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attribution")) {
                    iArr[7] = GraphQLAttributionEntryDeserializer.m4595b(jsonParser, flatBufferBuilder);
                } else if (i.equals("author_text")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("away_toggle_expiration")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("best_description")) {
                    iArr[10] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("blurredCoverPhoto")) {
                    iArr[11] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("business_info")) {
                    iArr[12] = GraphQLBusinessInfoDeserializer.m4630b(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_see_viewer_montage_thread")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_claim")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_get_notification")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_like")) {
                    zArr[4] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_message")) {
                    zArr[5] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_post")) {
                    zArr[6] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_post_photo_to_timeline")) {
                    zArr[7] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("can_viewer_rate")) {
                    zArr[8] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("categories")) {
                    iArr[21] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("category_icon")) {
                    iArr[22] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("category_names")) {
                    iArr[23] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("category_type")) {
                    zArr[9] = true;
                    enumArr[0] = GraphQLPageCategoryType.fromString(jsonParser.o());
                } else if (i.equals("city")) {
                    iArr[25] = m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("commerce_page_settings")) {
                    iArr[26] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLCommercePageSetting.class);
                } else if (i.equals("commerce_page_type")) {
                    zArr[10] = true;
                    enumArr[1] = GraphQLCommercePageType.fromString(jsonParser.o());
                } else if (i.equals("contact")) {
                    iArr[28] = GraphQLContactDeserializer.m4677a(jsonParser, flatBufferBuilder);
                } else if (i.equals("contextual_name")) {
                    iArr[29] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("cover_photo")) {
                    iArr[30] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("display_name")) {
                    iArr[31] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("does_viewer_like")) {
                    zArr[11] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("email_addresses")) {
                    iArr[33] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("entity_card_subtitle")) {
                    iArr[34] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("events_calendar_can_viewer_subscribe")) {
                    zArr[12] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("events_calendar_subscriber_count")) {
                    zArr[13] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("events_calendar_subscription_status")) {
                    zArr[14] = true;
                    enumArr[2] = GraphQLEventsCalendarSubscriptionStatus.fromString(jsonParser.o());
                } else if (i.equals("events_occurring_here")) {
                    iArr[38] = GraphQLEventsOccurringHereConnectionDeserializer.m4855a(jsonParser, flatBufferBuilder);
                } else if (i.equals("expressed_as_place")) {
                    zArr[15] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("featured_video")) {
                    iArr[40] = GraphQLVideoDeserializer.m6184a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[41] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("firstSection")) {
                    iArr[42] = GraphQLTimelineSectionsConnectionDeserializer.m6092a(jsonParser, flatBufferBuilder);
                } else if (i.equals("followup_feed_units")) {
                    iArr[43] = GraphQLFollowUpFeedUnitsConnectionDeserializer.m4922a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends_who_like")) {
                    iArr[44] = GraphQLFriendsWhoLikeConnectionDeserializer.m4959a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends_who_visited")) {
                    iArr[45] = GraphQLFriendsWhoVisitedConnectionDeserializer.m4962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("full_name")) {
                    iArr[46] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("hours")) {
                    iArr[48] = GraphQLTimeRangeDeserializer.m6065b(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[49] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("imageHighOrig")) {
                    iArr[50] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[51] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("instant_articles_enabled")) {
                    zArr[16] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("is_always_open")) {
                    zArr[17] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("is_away_toggle_on")) {
                    zArr[18] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("is_banned_by_page_viewer")) {
                    zArr[19] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("is_commerce")) {
                    zArr[20] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("is_eligible_for_page_verification")) {
                    zArr[21] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("is_message_blocked_by_viewer")) {
                    zArr[22] = true;
                    zArr2[17] = jsonParser.H();
                } else if (i.equals("is_messenger_promotion_blocked_by_viewer")) {
                    zArr[23] = true;
                    zArr2[18] = jsonParser.H();
                } else if (i.equals("is_messenger_user")) {
                    zArr[24] = true;
                    zArr2[19] = jsonParser.H();
                } else if (i.equals("is_owned")) {
                    zArr[25] = true;
                    zArr2[20] = jsonParser.H();
                } else if (i.equals("is_permanently_closed")) {
                    zArr[26] = true;
                    zArr2[21] = jsonParser.H();
                } else if (i.equals("is_place_map_hidden")) {
                    zArr[27] = true;
                    zArr2[22] = jsonParser.H();
                } else if (i.equals("is_service_page")) {
                    zArr[28] = true;
                    zArr2[23] = jsonParser.H();
                } else if (i.equals("is_verified")) {
                    zArr[29] = true;
                    zArr2[24] = jsonParser.H();
                } else if (i.equals("is_verified_page")) {
                    zArr[30] = true;
                    zArr2[25] = jsonParser.H();
                } else if (i.equals("is_viewer_notified_about")) {
                    zArr[31] = true;
                    zArr2[26] = jsonParser.H();
                } else if (i.equals("liked_profiles")) {
                    iArr[68] = GraphQLLikedProfilesConnectionDeserializer.m5315a(jsonParser, flatBufferBuilder);
                } else if (i.equals("live_video_subscription_status")) {
                    zArr[32] = true;
                    enumArr[3] = GraphQLLiveVideoSubscriptionStatus.fromString(jsonParser.o());
                } else if (i.equals("location")) {
                    iArr[70] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("map_bounding_box")) {
                    iArr[71] = GraphQLGeoRectangleDeserializer.m4993a(jsonParser, flatBufferBuilder);
                } else if (i.equals("map_zoom_level")) {
                    zArr[33] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("menu_info")) {
                    iArr[73] = GraphQLPageMenuInfoDeserializer.m5512a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message_permalink")) {
                    iArr[74] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("montage_thread_fbid")) {
                    iArr[75] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("music_object")) {
                    iArr[76] = GraphQLOpenGraphObjectDeserializer.m5465a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[77] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name_search_tokens")) {
                    iArr[78] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("neighborhood_name")) {
                    iArr[79] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("new_activity_count")) {
                    zArr[34] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("open_graph_composer_preview")) {
                    iArr[81] = GraphQLStoryAttachmentDeserializer.m5953a(jsonParser, flatBufferBuilder);
                } else if (i.equals("overall_rating")) {
                    zArr[35] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("overall_star_rating")) {
                    iArr[83] = GraphQLRatingDeserializer.m5778a(jsonParser, flatBufferBuilder);
                } else if (i.equals("owned_events")) {
                    iArr[84] = GraphQLOwnedEventsConnectionDeserializer.m5476a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pageProfilePicture")) {
                    iArr[85] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_likers")) {
                    iArr[86] = GraphQLPageLikersConnectionDeserializer.m5509a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_nux")) {
                    zArr[36] = true;
                    enumArr[4] = GraphQLReactionRequestedUnit.fromString(jsonParser.o());
                } else if (i.equals("page_payment_options")) {
                    iArr[88] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLPagePaymentOption.class);
                } else if (i.equals("page_visits")) {
                    iArr[89] = GraphQLPageVisitsConnectionDeserializer.m5533a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pending_claims_count")) {
                    zArr[37] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("permanently_closed_status")) {
                    zArr[38] = true;
                    enumArr[5] = GraphQLPermanentlyClosedStatus.fromString(jsonParser.o());
                } else if (i.equals("phone_number")) {
                    iArr[92] = GraphQLPhoneNumberDeserializer.m5598a(jsonParser, flatBufferBuilder);
                } else if (i.equals("placeProfilePicture")) {
                    iArr[93] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_open_status")) {
                    iArr[94] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_open_status_type")) {
                    zArr[39] = true;
                    enumArr[6] = GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o());
                } else if (i.equals("place_topic_id")) {
                    iArr[96] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("place_type")) {
                    zArr[40] = true;
                    enumArr[7] = GraphQLPlaceType.fromString(jsonParser.o());
                } else if (i.equals("posted_item_privacy_scope")) {
                    iArr[98] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("posted_photos")) {
                    iArr[99] = GraphQLPostedPhotosConnectionDeserializer.m5685a(jsonParser, flatBufferBuilder);
                } else if (i.equals("price_range_description")) {
                    iArr[100] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_option")) {
                    iArr[101] = GraphQLPrivacyOptionDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageLarge")) {
                    iArr[102] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[103] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture32")) {
                    iArr[104] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[105] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture60")) {
                    iArr[106] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture74")) {
                    iArr[107] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureAsCover")) {
                    iArr[108] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[109] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[110] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[111] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_large")) {
                    iArr[112] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_medium")) {
                    iArr[113] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_small")) {
                    iArr[114] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[115] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[41] = true;
                    zArr2[27] = jsonParser.H();
                } else if (i.equals("raters")) {
                    iArr[117] = GraphQLPageStarRatersConnectionDeserializer.m5521a(jsonParser, flatBufferBuilder);
                } else if (i.equals("recent_claims_count")) {
                    zArr[42] = true;
                    iArr2[5] = jsonParser.E();
                } else if (i.equals("rectangular_profile_picture")) {
                    iArr[119] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("redirection_info")) {
                    iArr[120] = GraphQLRedirectionInfoDeserializer.m5802b(jsonParser, flatBufferBuilder);
                } else if (i.equals("related_article_title")) {
                    iArr[121] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("representative_place_photos")) {
                    iArr[122] = GraphQLPhotoDeserializer.m5604b(jsonParser, flatBufferBuilder);
                } else if (i.equals("requestee_id")) {
                    iArr[123] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("requester_id")) {
                    iArr[124] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("review_context")) {
                    iArr[125] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("review_story")) {
                    iArr[126] = GraphQLContactRecommendationFieldDeserializer.m4683a(jsonParser, flatBufferBuilder);
                } else if (i.equals("saved_collection")) {
                    iArr[127] = GraphQLTimelineAppCollectionDeserializer.m6066a(jsonParser, flatBufferBuilder);
                } else if (i.equals("secondary_subscribe_status")) {
                    zArr[43] = true;
                    enumArr[8] = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("short_category_names")) {
                    iArr[129] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("should_ask_for_menu")) {
                    zArr[44] = true;
                    zArr2[28] = jsonParser.H();
                } else if (i.equals("should_show_message_button")) {
                    zArr[45] = true;
                    zArr2[29] = jsonParser.H();
                } else if (i.equals("should_show_recent_activity_entry_point")) {
                    zArr[46] = true;
                    zArr2[30] = jsonParser.H();
                } else if (i.equals("should_show_recent_checkins_entry_point")) {
                    zArr[47] = true;
                    zArr2[31] = jsonParser.H();
                } else if (i.equals("should_show_recent_mentions_entry_point")) {
                    zArr[48] = true;
                    zArr2[32] = jsonParser.H();
                } else if (i.equals("should_show_recent_reviews_entry_point")) {
                    zArr[49] = true;
                    zArr2[33] = jsonParser.H();
                } else if (i.equals("should_show_recent_shares_entry_point")) {
                    zArr[50] = true;
                    zArr2[34] = jsonParser.H();
                } else if (i.equals("should_show_reviews_on_profile")) {
                    zArr[51] = true;
                    zArr2[35] = jsonParser.H();
                } else if (i.equals("show_video_hub")) {
                    zArr[52] = true;
                    zArr2[36] = jsonParser.H();
                } else if (i.equals("single_publisher_video_channels")) {
                    iArr[139] = GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5889a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sports_match_data")) {
                    iArr[140] = GraphQLSportsDataMatchDataDeserializer.m5924a(jsonParser, flatBufferBuilder);
                } else if (i.equals("spotlight_locals_snippets")) {
                    iArr[141] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("spotlight_snippets_message")) {
                    iArr[142] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicBig")) {
                    iArr[143] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicHuge")) {
                    iArr[144] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicSmall")) {
                    iArr[145] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[146] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("subscribe_status")) {
                    zArr[53] = true;
                    enumArr[9] = GraphQLSubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("super_category_type")) {
                    zArr[54] = true;
                    enumArr[10] = GraphQLPageSuperCategoryType.fromString(jsonParser.o());
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[149] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("timeline_pinned_unit")) {
                    iArr[150] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("timeline_sections")) {
                    iArr[151] = GraphQLTimelineSectionsConnectionDeserializer.m6092a(jsonParser, flatBufferBuilder);
                } else if (i.equals("top_category_name")) {
                    iArr[152] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("top_headline_object")) {
                    iArr[153] = GraphQLNodeDeserializer.m5436a(jsonParser, flatBufferBuilder);
                } else if (i.equals("topic_image")) {
                    iArr[154] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("trending_topic_data")) {
                    iArr[155] = GraphQLTrendingTopicDataDeserializer.m6127a(jsonParser, flatBufferBuilder);
                } else if (i.equals("trending_topic_name")) {
                    iArr[156] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("unique_keyword")) {
                    iArr[157] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("unread_count")) {
                    zArr[55] = true;
                    iArr2[6] = jsonParser.E();
                } else if (i.equals("url")) {
                    iArr[159] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("username")) {
                    iArr[160] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("verification_status")) {
                    zArr[56] = true;
                    enumArr[11] = GraphQLPageVerificationBadge.fromString(jsonParser.o());
                } else if (i.equals("video_channel_can_viewer_follow")) {
                    zArr[57] = true;
                    zArr2[37] = jsonParser.H();
                } else if (i.equals("video_channel_can_viewer_subscribe")) {
                    zArr[58] = true;
                    zArr2[38] = jsonParser.H();
                } else if (i.equals("video_channel_curator_profile")) {
                    iArr[164] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_has_new")) {
                    zArr[59] = true;
                    zArr2[39] = jsonParser.H();
                } else if (i.equals("video_channel_has_viewer_subscribed")) {
                    zArr[60] = true;
                    zArr2[40] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_following")) {
                    zArr[61] = true;
                    zArr2[41] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_pinned")) {
                    zArr[62] = true;
                    zArr2[42] = jsonParser.H();
                } else if (i.equals("video_channel_max_new_count")) {
                    zArr[63] = true;
                    iArr2[7] = jsonParser.E();
                } else if (i.equals("video_channel_new_count")) {
                    zArr[64] = true;
                    iArr2[8] = jsonParser.E();
                } else if (i.equals("video_channel_subtitle")) {
                    iArr[171] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_title")) {
                    iArr[172] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_acts_as_profile")) {
                    zArr[65] = true;
                    zArr2[43] = jsonParser.H();
                } else if (i.equals("viewer_profile_permissions")) {
                    iArr[174] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_recommendation")) {
                    iArr[175] = GraphQLContactRecommendationFieldDeserializer.m4683a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_saved_state")) {
                    zArr[66] = true;
                    enumArr[12] = GraphQLSavedState.fromString(jsonParser.o());
                } else if (i.equals("viewer_star_rating")) {
                    iArr[177] = GraphQLRatingDeserializer.m5778a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_timeline_collections_containing")) {
                    iArr[178] = GraphQLTimelineAppCollectionDeserializer.m6069b(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_timeline_collections_supported")) {
                    iArr[179] = GraphQLTimelineAppCollectionDeserializer.m6069b(jsonParser, flatBufferBuilder);
                } else if (i.equals("websites")) {
                    iArr[180] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("should_show_username")) {
                    zArr[67] = true;
                    zArr2[44] = jsonParser.H();
                } else if (i.equals("viewer_visits")) {
                    iArr[182] = GraphQLViewerVisitsConnectionDeserializer.m6202a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_logo")) {
                    iArr[183] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_icon")) {
                    iArr[184] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_viewer_subscribed_to_messenger_content")) {
                    zArr[68] = true;
                    zArr2[45] = jsonParser.H();
                } else if (i.equals("can_viewer_follow")) {
                    zArr[69] = true;
                    zArr2[46] = jsonParser.H();
                } else if (i.equals("locally_updated_containing_collection_id")) {
                    iArr[187] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("page_thumbnail_uri")) {
                    iArr[188] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("timeline_stories")) {
                    iArr[189] = GraphQLTimelineStoriesConnectionDeserializer.m6095a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_video")) {
                    iArr[190] = GraphQLProfileVideoDeserializer.m5722a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_messenger_platform_bot")) {
                    zArr[70] = true;
                    zArr2[47] = jsonParser.H();
                } else if (i.equals("page_call_to_action")) {
                    iArr[192] = GraphQLPageCallToActionDeserializer.m5498a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_eligible_for_commercial_break")) {
                    zArr[71] = true;
                    zArr2[48] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(194);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        if (zArr[0]) {
            flatBufferBuilder.a(9, iArr2[0], 0);
        }
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        if (zArr[1]) {
            flatBufferBuilder.a(13, zArr2[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(14, zArr2[1]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(15, zArr2[2]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(16, zArr2[3]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(17, zArr2[4]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(18, zArr2[5]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(19, zArr2[6]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(20, zArr2[7]);
        }
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        if (zArr[9]) {
            flatBufferBuilder.a(24, enumArr[0]);
        }
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        if (zArr[10]) {
            flatBufferBuilder.a(27, enumArr[1]);
        }
        flatBufferBuilder.b(28, iArr[28]);
        flatBufferBuilder.b(29, iArr[29]);
        flatBufferBuilder.b(30, iArr[30]);
        flatBufferBuilder.b(31, iArr[31]);
        if (zArr[11]) {
            flatBufferBuilder.a(32, zArr2[8]);
        }
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        if (zArr[12]) {
            flatBufferBuilder.a(35, zArr2[9]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(36, iArr2[1], 0);
        }
        if (zArr[14]) {
            flatBufferBuilder.a(37, enumArr[2]);
        }
        flatBufferBuilder.b(38, iArr[38]);
        if (zArr[15]) {
            flatBufferBuilder.a(39, zArr2[10]);
        }
        flatBufferBuilder.b(40, iArr[40]);
        flatBufferBuilder.b(41, iArr[41]);
        flatBufferBuilder.b(42, iArr[42]);
        flatBufferBuilder.b(43, iArr[43]);
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(46, iArr[46]);
        flatBufferBuilder.b(48, iArr[48]);
        flatBufferBuilder.b(49, iArr[49]);
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(51, iArr[51]);
        if (zArr[16]) {
            flatBufferBuilder.a(52, zArr2[11]);
        }
        if (zArr[17]) {
            flatBufferBuilder.a(53, zArr2[12]);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(54, zArr2[13]);
        }
        if (zArr[19]) {
            flatBufferBuilder.a(55, zArr2[14]);
        }
        if (zArr[20]) {
            flatBufferBuilder.a(56, zArr2[15]);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(57, zArr2[16]);
        }
        if (zArr[22]) {
            flatBufferBuilder.a(58, zArr2[17]);
        }
        if (zArr[23]) {
            flatBufferBuilder.a(59, zArr2[18]);
        }
        if (zArr[24]) {
            flatBufferBuilder.a(60, zArr2[19]);
        }
        if (zArr[25]) {
            flatBufferBuilder.a(61, zArr2[20]);
        }
        if (zArr[26]) {
            flatBufferBuilder.a(62, zArr2[21]);
        }
        if (zArr[27]) {
            flatBufferBuilder.a(63, zArr2[22]);
        }
        if (zArr[28]) {
            flatBufferBuilder.a(64, zArr2[23]);
        }
        if (zArr[29]) {
            flatBufferBuilder.a(65, zArr2[24]);
        }
        if (zArr[30]) {
            flatBufferBuilder.a(66, zArr2[25]);
        }
        if (zArr[31]) {
            flatBufferBuilder.a(67, zArr2[26]);
        }
        flatBufferBuilder.b(68, iArr[68]);
        if (zArr[32]) {
            flatBufferBuilder.a(69, enumArr[3]);
        }
        flatBufferBuilder.b(70, iArr[70]);
        flatBufferBuilder.b(71, iArr[71]);
        if (zArr[33]) {
            flatBufferBuilder.a(72, iArr2[2], 0);
        }
        flatBufferBuilder.b(73, iArr[73]);
        flatBufferBuilder.b(74, iArr[74]);
        flatBufferBuilder.b(75, iArr[75]);
        flatBufferBuilder.b(76, iArr[76]);
        flatBufferBuilder.b(77, iArr[77]);
        flatBufferBuilder.b(78, iArr[78]);
        flatBufferBuilder.b(79, iArr[79]);
        if (zArr[34]) {
            flatBufferBuilder.a(80, iArr2[3], 0);
        }
        flatBufferBuilder.b(81, iArr[81]);
        if (zArr[35]) {
            flatBufferBuilder.a(82, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(83, iArr[83]);
        flatBufferBuilder.b(84, iArr[84]);
        flatBufferBuilder.b(85, iArr[85]);
        flatBufferBuilder.b(86, iArr[86]);
        if (zArr[36]) {
            flatBufferBuilder.a(87, enumArr[4]);
        }
        flatBufferBuilder.b(88, iArr[88]);
        flatBufferBuilder.b(89, iArr[89]);
        if (zArr[37]) {
            flatBufferBuilder.a(90, iArr2[4], 0);
        }
        if (zArr[38]) {
            flatBufferBuilder.a(91, enumArr[5]);
        }
        flatBufferBuilder.b(92, iArr[92]);
        flatBufferBuilder.b(93, iArr[93]);
        flatBufferBuilder.b(94, iArr[94]);
        if (zArr[39]) {
            flatBufferBuilder.a(95, enumArr[6]);
        }
        flatBufferBuilder.b(96, iArr[96]);
        if (zArr[40]) {
            flatBufferBuilder.a(97, enumArr[7]);
        }
        flatBufferBuilder.b(98, iArr[98]);
        flatBufferBuilder.b(99, iArr[99]);
        flatBufferBuilder.b(100, iArr[100]);
        flatBufferBuilder.b(101, iArr[101]);
        flatBufferBuilder.b(102, iArr[102]);
        flatBufferBuilder.b(103, iArr[103]);
        flatBufferBuilder.b(104, iArr[104]);
        flatBufferBuilder.b(105, iArr[105]);
        flatBufferBuilder.b(106, iArr[106]);
        flatBufferBuilder.b(107, iArr[107]);
        flatBufferBuilder.b(108, iArr[108]);
        flatBufferBuilder.b(109, iArr[109]);
        flatBufferBuilder.b(110, iArr[110]);
        flatBufferBuilder.b(111, iArr[111]);
        flatBufferBuilder.b(112, iArr[112]);
        flatBufferBuilder.b(113, iArr[113]);
        flatBufferBuilder.b(114, iArr[114]);
        flatBufferBuilder.b(115, iArr[115]);
        if (zArr[41]) {
            flatBufferBuilder.a(116, zArr2[27]);
        }
        flatBufferBuilder.b(117, iArr[117]);
        if (zArr[42]) {
            flatBufferBuilder.a(118, iArr2[5], 0);
        }
        flatBufferBuilder.b(119, iArr[119]);
        flatBufferBuilder.b(120, iArr[120]);
        flatBufferBuilder.b(121, iArr[121]);
        flatBufferBuilder.b(122, iArr[122]);
        flatBufferBuilder.b(123, iArr[123]);
        flatBufferBuilder.b(124, iArr[124]);
        flatBufferBuilder.b(125, iArr[125]);
        flatBufferBuilder.b(126, iArr[126]);
        flatBufferBuilder.b(127, iArr[127]);
        if (zArr[43]) {
            flatBufferBuilder.a(128, enumArr[8]);
        }
        flatBufferBuilder.b(129, iArr[129]);
        if (zArr[44]) {
            flatBufferBuilder.a(130, zArr2[28]);
        }
        if (zArr[45]) {
            flatBufferBuilder.a(131, zArr2[29]);
        }
        if (zArr[46]) {
            flatBufferBuilder.a(132, zArr2[30]);
        }
        if (zArr[47]) {
            flatBufferBuilder.a(133, zArr2[31]);
        }
        if (zArr[48]) {
            flatBufferBuilder.a(134, zArr2[32]);
        }
        if (zArr[49]) {
            flatBufferBuilder.a(135, zArr2[33]);
        }
        if (zArr[50]) {
            flatBufferBuilder.a(136, zArr2[34]);
        }
        if (zArr[51]) {
            flatBufferBuilder.a(137, zArr2[35]);
        }
        if (zArr[52]) {
            flatBufferBuilder.a(138, zArr2[36]);
        }
        flatBufferBuilder.b(139, iArr[139]);
        flatBufferBuilder.b(140, iArr[140]);
        flatBufferBuilder.b(141, iArr[141]);
        flatBufferBuilder.b(142, iArr[142]);
        flatBufferBuilder.b(143, iArr[143]);
        flatBufferBuilder.b(144, iArr[144]);
        flatBufferBuilder.b(145, iArr[145]);
        flatBufferBuilder.b(146, iArr[146]);
        if (zArr[53]) {
            flatBufferBuilder.a(147, enumArr[9]);
        }
        if (zArr[54]) {
            flatBufferBuilder.a(148, enumArr[10]);
        }
        flatBufferBuilder.b(149, iArr[149]);
        flatBufferBuilder.b(150, iArr[150]);
        flatBufferBuilder.b(151, iArr[151]);
        flatBufferBuilder.b(152, iArr[152]);
        flatBufferBuilder.b(153, iArr[153]);
        flatBufferBuilder.b(154, iArr[154]);
        flatBufferBuilder.b(155, iArr[155]);
        flatBufferBuilder.b(156, iArr[156]);
        flatBufferBuilder.b(157, iArr[157]);
        if (zArr[55]) {
            flatBufferBuilder.a(158, iArr2[6], 0);
        }
        flatBufferBuilder.b(159, iArr[159]);
        flatBufferBuilder.b(160, iArr[160]);
        if (zArr[56]) {
            flatBufferBuilder.a(161, enumArr[11]);
        }
        if (zArr[57]) {
            flatBufferBuilder.a(162, zArr2[37]);
        }
        if (zArr[58]) {
            flatBufferBuilder.a(163, zArr2[38]);
        }
        flatBufferBuilder.b(164, iArr[164]);
        if (zArr[59]) {
            flatBufferBuilder.a(165, zArr2[39]);
        }
        if (zArr[60]) {
            flatBufferBuilder.a(166, zArr2[40]);
        }
        if (zArr[61]) {
            flatBufferBuilder.a(167, zArr2[41]);
        }
        if (zArr[62]) {
            flatBufferBuilder.a(168, zArr2[42]);
        }
        if (zArr[63]) {
            flatBufferBuilder.a(169, iArr2[7], 0);
        }
        if (zArr[64]) {
            flatBufferBuilder.a(170, iArr2[8], 0);
        }
        flatBufferBuilder.b(171, iArr[171]);
        flatBufferBuilder.b(172, iArr[172]);
        if (zArr[65]) {
            flatBufferBuilder.a(173, zArr2[43]);
        }
        flatBufferBuilder.b(174, iArr[174]);
        flatBufferBuilder.b(175, iArr[175]);
        if (zArr[66]) {
            flatBufferBuilder.a(176, enumArr[12]);
        }
        flatBufferBuilder.b(177, iArr[177]);
        flatBufferBuilder.b(178, iArr[178]);
        flatBufferBuilder.b(179, iArr[179]);
        flatBufferBuilder.b(180, iArr[180]);
        if (zArr[67]) {
            flatBufferBuilder.a(181, zArr2[44]);
        }
        flatBufferBuilder.b(182, iArr[182]);
        flatBufferBuilder.b(183, iArr[183]);
        flatBufferBuilder.b(184, iArr[184]);
        if (zArr[68]) {
            flatBufferBuilder.a(185, zArr2[45]);
        }
        if (zArr[69]) {
            flatBufferBuilder.a(186, zArr2[46]);
        }
        flatBufferBuilder.b(187, iArr[187]);
        flatBufferBuilder.b(188, iArr[188]);
        flatBufferBuilder.b(189, iArr[189]);
        flatBufferBuilder.b(190, iArr[190]);
        if (zArr[70]) {
            flatBufferBuilder.a(191, zArr2[47]);
        }
        flatBufferBuilder.b(192, iArr[192]);
        if (zArr[71]) {
            flatBufferBuilder.a(193, zArr2[48]);
        }
        return flatBufferBuilder.d();
    }

    public static int m5504b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5501a(jsonParser, flatBufferBuilder)));
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return flatBufferBuilder.a(iArr, true);
    }

    public static MutableFlatBuffer m5502a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5501a(jsonParser, flatBufferBuilder);
        if (1 != 0) {
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, s, 0);
            flatBufferBuilder.b(1, a);
            a = flatBufferBuilder.d();
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        return mutableFlatBuffer;
    }

    public static void m5503a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5505b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5505b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("about");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("activity_admin_info");
            GraphQLPageAdminInfoDeserializer.m5494a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("address");
            GraphQLStreetAddressDeserializer.m5996a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("admin_info");
            GraphQLPageAdminInfoDeserializer.m5494a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("albums");
            GraphQLAlbumsConnectionDeserializer.m4554a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("android_urls");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 6), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("attribution");
            GraphQLAttributionEntryDeserializer.m4594a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("author_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        g = mutableFlatBuffer.a(i, 9, 0);
        if (g != 0) {
            jsonGenerator.a("away_toggle_expiration");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("best_description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("business_info");
            GraphQLBusinessInfoDeserializer.m4629a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("can_see_viewer_montage_thread");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("can_viewer_claim");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("can_viewer_get_notification");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("can_viewer_like");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 17);
        if (a) {
            jsonGenerator.a("can_viewer_message");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 18);
        if (a) {
            jsonGenerator.a("can_viewer_post");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 19);
        if (a) {
            jsonGenerator.a("can_viewer_post_photo_to_timeline");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 20);
        if (a) {
            jsonGenerator.a("can_viewer_rate");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 21) != 0) {
            jsonGenerator.a("categories");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 21), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("category_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("category_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 23), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 24, (short) 0) != (short) 0) {
            jsonGenerator.a("category_type");
            jsonGenerator.b(((GraphQLPageCategoryType) mutableFlatBuffer.a(i, 24, GraphQLPageCategoryType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("city");
            m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 26) != 0) {
            jsonGenerator.a("commerce_page_settings");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 26), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 27, (short) 0) != (short) 0) {
            jsonGenerator.a("commerce_page_type");
            jsonGenerator.b(((GraphQLCommercePageType) mutableFlatBuffer.a(i, 27, GraphQLCommercePageType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("contact");
            GraphQLContactDeserializer.m4679a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 29) != 0) {
            jsonGenerator.a("contextual_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 29));
        }
        g = mutableFlatBuffer.g(i, 30);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 31) != 0) {
            jsonGenerator.a("display_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 31));
        }
        a = mutableFlatBuffer.a(i, 32);
        if (a) {
            jsonGenerator.a("does_viewer_like");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 33) != 0) {
            jsonGenerator.a("email_addresses");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 33), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 34);
        if (g != 0) {
            jsonGenerator.a("entity_card_subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 35);
        if (a) {
            jsonGenerator.a("events_calendar_can_viewer_subscribe");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 36, 0);
        if (g != 0) {
            jsonGenerator.a("events_calendar_subscriber_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 37, (short) 0) != (short) 0) {
            jsonGenerator.a("events_calendar_subscription_status");
            jsonGenerator.b(((GraphQLEventsCalendarSubscriptionStatus) mutableFlatBuffer.a(i, 37, GraphQLEventsCalendarSubscriptionStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 38);
        if (g != 0) {
            jsonGenerator.a("events_occurring_here");
            GraphQLEventsOccurringHereConnectionDeserializer.m4857a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 39);
        if (a) {
            jsonGenerator.a("expressed_as_place");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 40);
        if (g != 0) {
            jsonGenerator.a("featured_video");
            GraphQLVideoDeserializer.m6186a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 41);
        if (g != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 42);
        if (g != 0) {
            jsonGenerator.a("firstSection");
            GraphQLTimelineSectionsConnectionDeserializer.m6094a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("followup_feed_units");
            GraphQLFollowUpFeedUnitsConnectionDeserializer.m4924a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("friends_who_like");
            GraphQLFriendsWhoLikeConnectionDeserializer.m4961a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("friends_who_visited");
            GraphQLFriendsWhoVisitedConnectionDeserializer.m4964a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 46) != 0) {
            jsonGenerator.a("full_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 46));
        }
        g = mutableFlatBuffer.g(i, 48);
        if (g != 0) {
            jsonGenerator.a("hours");
            GraphQLTimeRangeDeserializer.m6064a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 49) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 49));
        }
        g = mutableFlatBuffer.g(i, 50);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 51);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 52);
        if (a) {
            jsonGenerator.a("instant_articles_enabled");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 53);
        if (a) {
            jsonGenerator.a("is_always_open");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 54);
        if (a) {
            jsonGenerator.a("is_away_toggle_on");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 55);
        if (a) {
            jsonGenerator.a("is_banned_by_page_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 56);
        if (a) {
            jsonGenerator.a("is_commerce");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 57);
        if (a) {
            jsonGenerator.a("is_eligible_for_page_verification");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 58);
        if (a) {
            jsonGenerator.a("is_message_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 59);
        if (a) {
            jsonGenerator.a("is_messenger_promotion_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 60);
        if (a) {
            jsonGenerator.a("is_messenger_user");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 61);
        if (a) {
            jsonGenerator.a("is_owned");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 62);
        if (a) {
            jsonGenerator.a("is_permanently_closed");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 63);
        if (a) {
            jsonGenerator.a("is_place_map_hidden");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 64);
        if (a) {
            jsonGenerator.a("is_service_page");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 65);
        if (a) {
            jsonGenerator.a("is_verified");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 66);
        if (a) {
            jsonGenerator.a("is_verified_page");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 67);
        if (a) {
            jsonGenerator.a("is_viewer_notified_about");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 68);
        if (g != 0) {
            jsonGenerator.a("liked_profiles");
            GraphQLLikedProfilesConnectionDeserializer.m5317a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 69, (short) 0) != (short) 0) {
            jsonGenerator.a("live_video_subscription_status");
            jsonGenerator.b(((GraphQLLiveVideoSubscriptionStatus) mutableFlatBuffer.a(i, 69, GraphQLLiveVideoSubscriptionStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 70);
        if (g != 0) {
            jsonGenerator.a("location");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 71);
        if (g != 0) {
            jsonGenerator.a("map_bounding_box");
            GraphQLGeoRectangleDeserializer.m4995a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 72, 0);
        if (g != 0) {
            jsonGenerator.a("map_zoom_level");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 73);
        if (g != 0) {
            jsonGenerator.a("menu_info");
            GraphQLPageMenuInfoDeserializer.m5514a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 74) != 0) {
            jsonGenerator.a("message_permalink");
            jsonGenerator.b(mutableFlatBuffer.c(i, 74));
        }
        if (mutableFlatBuffer.g(i, 75) != 0) {
            jsonGenerator.a("montage_thread_fbid");
            jsonGenerator.b(mutableFlatBuffer.c(i, 75));
        }
        g = mutableFlatBuffer.g(i, 76);
        if (g != 0) {
            jsonGenerator.a("music_object");
            GraphQLOpenGraphObjectDeserializer.m5469b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 77) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 77));
        }
        if (mutableFlatBuffer.g(i, 78) != 0) {
            jsonGenerator.a("name_search_tokens");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 78), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 79) != 0) {
            jsonGenerator.a("neighborhood_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 79));
        }
        g = mutableFlatBuffer.a(i, 80, 0);
        if (g != 0) {
            jsonGenerator.a("new_activity_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 81);
        if (g != 0) {
            jsonGenerator.a("open_graph_composer_preview");
            GraphQLStoryAttachmentDeserializer.m5957b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        double a2 = mutableFlatBuffer.a(i, 82, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("overall_rating");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 83);
        if (g != 0) {
            jsonGenerator.a("overall_star_rating");
            GraphQLRatingDeserializer.m5780a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 84);
        if (g != 0) {
            jsonGenerator.a("owned_events");
            GraphQLOwnedEventsConnectionDeserializer.m5478a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 85);
        if (g != 0) {
            jsonGenerator.a("pageProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 86);
        if (g != 0) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnectionDeserializer.m5511a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 87, (short) 0) != (short) 0) {
            jsonGenerator.a("page_nux");
            jsonGenerator.b(((GraphQLReactionRequestedUnit) mutableFlatBuffer.a(i, 87, GraphQLReactionRequestedUnit.class)).name());
        }
        if (mutableFlatBuffer.g(i, 88) != 0) {
            jsonGenerator.a("page_payment_options");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 88), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 89);
        if (g != 0) {
            jsonGenerator.a("page_visits");
            GraphQLPageVisitsConnectionDeserializer.m5535a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 90, 0);
        if (g != 0) {
            jsonGenerator.a("pending_claims_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 91, (short) 0) != (short) 0) {
            jsonGenerator.a("permanently_closed_status");
            jsonGenerator.b(((GraphQLPermanentlyClosedStatus) mutableFlatBuffer.a(i, 91, GraphQLPermanentlyClosedStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 92);
        if (g != 0) {
            jsonGenerator.a("phone_number");
            GraphQLPhoneNumberDeserializer.m5600a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 93);
        if (g != 0) {
            jsonGenerator.a("placeProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 94);
        if (g != 0) {
            jsonGenerator.a("place_open_status");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 95, (short) 0) != (short) 0) {
            jsonGenerator.a("place_open_status_type");
            jsonGenerator.b(((GraphQLPageOpenHoursDisplayDecisionEnum) mutableFlatBuffer.a(i, 95, GraphQLPageOpenHoursDisplayDecisionEnum.class)).name());
        }
        if (mutableFlatBuffer.g(i, 96) != 0) {
            jsonGenerator.a("place_topic_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 96));
        }
        if (mutableFlatBuffer.a(i, 97, (short) 0) != (short) 0) {
            jsonGenerator.a("place_type");
            jsonGenerator.b(((GraphQLPlaceType) mutableFlatBuffer.a(i, 97, GraphQLPlaceType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 98);
        if (g != 0) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 99);
        if (g != 0) {
            jsonGenerator.a("posted_photos");
            GraphQLPostedPhotosConnectionDeserializer.m5687a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 100) != 0) {
            jsonGenerator.a("price_range_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 100));
        }
        g = mutableFlatBuffer.g(i, 101);
        if (g != 0) {
            jsonGenerator.a("privacy_option");
            GraphQLPrivacyOptionDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 102);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 103);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 104);
        if (g != 0) {
            jsonGenerator.a("profilePicture32");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 105);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 106);
        if (g != 0) {
            jsonGenerator.a("profilePicture60");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 107);
        if (g != 0) {
            jsonGenerator.a("profilePicture74");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 108);
        if (g != 0) {
            jsonGenerator.a("profilePictureAsCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 109);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 110);
        if (g != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 111);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 112);
        if (g != 0) {
            jsonGenerator.a("profile_pic_large");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 113);
        if (g != 0) {
            jsonGenerator.a("profile_pic_medium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 114);
        if (g != 0) {
            jsonGenerator.a("profile_pic_small");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 115);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 116);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 117);
        if (g != 0) {
            jsonGenerator.a("raters");
            GraphQLPageStarRatersConnectionDeserializer.m5523a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 118, 0);
        if (g != 0) {
            jsonGenerator.a("recent_claims_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 119);
        if (g != 0) {
            jsonGenerator.a("rectangular_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 120);
        if (g != 0) {
            jsonGenerator.a("redirection_info");
            GraphQLRedirectionInfoDeserializer.m5801a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 121) != 0) {
            jsonGenerator.a("related_article_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 121));
        }
        g = mutableFlatBuffer.g(i, 122);
        if (g != 0) {
            jsonGenerator.a("representative_place_photos");
            GraphQLPhotoDeserializer.m5603a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 123) != 0) {
            jsonGenerator.a("requestee_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 123));
        }
        if (mutableFlatBuffer.g(i, 124) != 0) {
            jsonGenerator.a("requester_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 124));
        }
        g = mutableFlatBuffer.g(i, 125);
        if (g != 0) {
            jsonGenerator.a("review_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 126);
        if (g != 0) {
            jsonGenerator.a("review_story");
            GraphQLContactRecommendationFieldDeserializer.m4685a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 127);
        if (g != 0) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollectionDeserializer.m6070b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 128, (short) 0) != (short) 0) {
            jsonGenerator.a("secondary_subscribe_status");
            jsonGenerator.b(((GraphQLSecondarySubscribeStatus) mutableFlatBuffer.a(i, 128, GraphQLSecondarySubscribeStatus.class)).name());
        }
        if (mutableFlatBuffer.g(i, 129) != 0) {
            jsonGenerator.a("short_category_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 129), jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 130);
        if (a) {
            jsonGenerator.a("should_ask_for_menu");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 131);
        if (a) {
            jsonGenerator.a("should_show_message_button");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 132);
        if (a) {
            jsonGenerator.a("should_show_recent_activity_entry_point");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 133);
        if (a) {
            jsonGenerator.a("should_show_recent_checkins_entry_point");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 134);
        if (a) {
            jsonGenerator.a("should_show_recent_mentions_entry_point");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 135);
        if (a) {
            jsonGenerator.a("should_show_recent_reviews_entry_point");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 136);
        if (a) {
            jsonGenerator.a("should_show_recent_shares_entry_point");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 137);
        if (a) {
            jsonGenerator.a("should_show_reviews_on_profile");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 138);
        if (a) {
            jsonGenerator.a("show_video_hub");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 139);
        if (g != 0) {
            jsonGenerator.a("single_publisher_video_channels");
            GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5891a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 140);
        if (g != 0) {
            jsonGenerator.a("sports_match_data");
            GraphQLSportsDataMatchDataDeserializer.m5926a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 141) != 0) {
            jsonGenerator.a("spotlight_locals_snippets");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 141), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 142);
        if (g != 0) {
            jsonGenerator.a("spotlight_snippets_message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 143);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicBig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 144);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicHuge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 145);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 146);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 147, (short) 0) != (short) 0) {
            jsonGenerator.a("subscribe_status");
            jsonGenerator.b(((GraphQLSubscribeStatus) mutableFlatBuffer.a(i, 147, GraphQLSubscribeStatus.class)).name());
        }
        if (mutableFlatBuffer.a(i, 148, (short) 0) != (short) 0) {
            jsonGenerator.a("super_category_type");
            jsonGenerator.b(((GraphQLPageSuperCategoryType) mutableFlatBuffer.a(i, 148, GraphQLPageSuperCategoryType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 149);
        if (g != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 150);
        if (g != 0) {
            jsonGenerator.a("timeline_pinned_unit");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 151);
        if (g != 0) {
            jsonGenerator.a("timeline_sections");
            GraphQLTimelineSectionsConnectionDeserializer.m6094a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 152) != 0) {
            jsonGenerator.a("top_category_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 152));
        }
        g = mutableFlatBuffer.g(i, 153);
        if (g != 0) {
            jsonGenerator.a("top_headline_object");
            GraphQLNodeDeserializer.m5440b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 154);
        if (g != 0) {
            jsonGenerator.a("topic_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 155);
        if (g != 0) {
            jsonGenerator.a("trending_topic_data");
            GraphQLTrendingTopicDataDeserializer.m6129a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 156) != 0) {
            jsonGenerator.a("trending_topic_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 156));
        }
        if (mutableFlatBuffer.g(i, 157) != 0) {
            jsonGenerator.a("unique_keyword");
            jsonGenerator.b(mutableFlatBuffer.c(i, 157));
        }
        g = mutableFlatBuffer.a(i, 158, 0);
        if (g != 0) {
            jsonGenerator.a("unread_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 159) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 159));
        }
        if (mutableFlatBuffer.g(i, 160) != 0) {
            jsonGenerator.a("username");
            jsonGenerator.b(mutableFlatBuffer.c(i, 160));
        }
        if (mutableFlatBuffer.a(i, 161, (short) 0) != (short) 0) {
            jsonGenerator.a("verification_status");
            jsonGenerator.b(((GraphQLPageVerificationBadge) mutableFlatBuffer.a(i, 161, GraphQLPageVerificationBadge.class)).name());
        }
        a = mutableFlatBuffer.a(i, 162);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_follow");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 163);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_subscribe");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 164);
        if (g != 0) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 165);
        if (a) {
            jsonGenerator.a("video_channel_has_new");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 166);
        if (a) {
            jsonGenerator.a("video_channel_has_viewer_subscribed");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 167);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_following");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 168);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_pinned");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 169, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_max_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 170, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 171);
        if (g != 0) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 172);
        if (g != 0) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 173);
        if (a) {
            jsonGenerator.a("viewer_acts_as_profile");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 174) != 0) {
            jsonGenerator.a("viewer_profile_permissions");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 174), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 175);
        if (g != 0) {
            jsonGenerator.a("viewer_recommendation");
            GraphQLContactRecommendationFieldDeserializer.m4685a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 176, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 176, GraphQLSavedState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 177);
        if (g != 0) {
            jsonGenerator.a("viewer_star_rating");
            GraphQLRatingDeserializer.m5780a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 178);
        if (g != 0) {
            jsonGenerator.a("viewer_timeline_collections_containing");
            GraphQLTimelineAppCollectionDeserializer.m6068a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 179);
        if (g != 0) {
            jsonGenerator.a("viewer_timeline_collections_supported");
            GraphQLTimelineAppCollectionDeserializer.m6068a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 180) != 0) {
            jsonGenerator.a("websites");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 180), jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 181);
        if (a) {
            jsonGenerator.a("should_show_username");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 182);
        if (g != 0) {
            jsonGenerator.a("viewer_visits");
            GraphQLViewerVisitsConnectionDeserializer.m6204a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 183);
        if (g != 0) {
            jsonGenerator.a("page_logo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 184);
        if (g != 0) {
            jsonGenerator.a("page_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 185);
        if (a) {
            jsonGenerator.a("is_viewer_subscribed_to_messenger_content");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 186);
        if (a) {
            jsonGenerator.a("can_viewer_follow");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 187) != 0) {
            jsonGenerator.a("locally_updated_containing_collection_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 187));
        }
        g = mutableFlatBuffer.g(i, 188);
        if (g != 0) {
            jsonGenerator.a("page_thumbnail_uri");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 189);
        if (g != 0) {
            jsonGenerator.a("timeline_stories");
            GraphQLTimelineStoriesConnectionDeserializer.m6097a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 190);
        if (g != 0) {
            jsonGenerator.a("profile_video");
            GraphQLProfileVideoDeserializer.m5724a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 191);
        if (a) {
            jsonGenerator.a("is_messenger_platform_bot");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 192);
        if (g != 0) {
            jsonGenerator.a("page_call_to_action");
            GraphQLPageCallToActionDeserializer.m5500a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 193);
        if (a) {
            jsonGenerator.a("is_eligible_for_commercial_break");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
