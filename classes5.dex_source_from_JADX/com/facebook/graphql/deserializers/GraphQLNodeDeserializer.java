package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAdsExperienceStatusEnum;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLCommerceCheckoutStyle;
import com.facebook.graphql.enums.GraphQLCommercePageType;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLCouponClaimLocation;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventType;
import com.facebook.graphql.enums.GraphQLEventVisibility;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupCommercePriceType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType;
import com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus;
import com.facebook.graphql.enums.GraphQLMovieBotMovieListStyle;
import com.facebook.graphql.enums.GraphQLMusicType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPagePaymentOption;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLQuestionPollAnswersState;
import com.facebook.graphql.enums.GraphQLQuestionResponseMethod;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLShipmentTrackingEventType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.enums.GraphQLTimelineContactItemType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: offsetY */
public class GraphQLNodeDeserializer {
    public static int m5436a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[629];
        boolean[] zArr = new boolean[173];
        boolean[] zArr2 = new boolean[86];
        int[] iArr2 = new int[30];
        long[] jArr = new long[10];
        double[] dArr = new double[8];
        Enum[] enumArr = new Enum[39];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("accent_image")) {
                    iArr[1] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("action_links")) {
                    iArr[2] = GraphQLStoryActionLinkDeserializer.m5951b(jsonParser, flatBufferBuilder);
                } else if (i.equals("action_style")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLEventActionStyle.fromString(jsonParser.o());
                } else if (i.equals("actions")) {
                    iArr[4] = GraphQLOpenGraphActionDeserializer.m5460b(jsonParser, flatBufferBuilder);
                } else if (i.equals("activity_admin_info")) {
                    iArr[5] = GraphQLPageAdminInfoDeserializer.m5492a(jsonParser, flatBufferBuilder);
                } else if (i.equals("actor")) {
                    iArr[6] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("actors")) {
                    iArr[7] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("additional_accent_images")) {
                    iArr[8] = GraphQLImageDeserializer.b(jsonParser, flatBufferBuilder);
                } else if (i.equals("address")) {
                    iArr[9] = GraphQLStreetAddressDeserializer.m5994a(jsonParser, flatBufferBuilder);
                } else if (i.equals("admin_info")) {
                    iArr[10] = GraphQLPageAdminInfoDeserializer.m5492a(jsonParser, flatBufferBuilder);
                } else if (i.equals("agree_to_privacy_text")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("aircraft_type_label")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("album")) {
                    iArr[13] = GraphQLAlbumDeserializer.m4549a(jsonParser, flatBufferBuilder);
                } else if (i.equals("album_release_date")) {
                    zArr[1] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("albums")) {
                    iArr[15] = GraphQLAlbumsConnectionDeserializer.m4552a(jsonParser, flatBufferBuilder);
                } else if (i.equals("all_contacts")) {
                    iArr[16] = GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer.m5575a(jsonParser, flatBufferBuilder);
                } else if (i.equals("all_groups")) {
                    iArr[17] = C0243x81539b2b.m5557a(jsonParser, flatBufferBuilder);
                } else if (i.equals("all_share_stories")) {
                    iArr[19] = GraphQLAllShareStoriesConnectionDeserializer.m4558a(jsonParser, flatBufferBuilder);
                } else if (i.equals("all_stories")) {
                    iArr[20] = GraphQLStorySetStoriesConnectionDeserializer.m5985a(jsonParser, flatBufferBuilder);
                } else if (i.equals("all_substories")) {
                    iArr[21] = GraphQLSubstoriesConnectionDeserializer.m6014a(jsonParser, flatBufferBuilder);
                } else if (i.equals("all_users")) {
                    iArr[22] = C0245xd2646133.m5566a(jsonParser, flatBufferBuilder);
                } else if (i.equals("amount")) {
                    iArr[23] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("android_app_config")) {
                    iArr[24] = GraphQLAndroidAppConfigDeserializer.m4561a(jsonParser, flatBufferBuilder);
                } else if (i.equals("android_small_screen_phone_threshold")) {
                    zArr[2] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("android_store_url")) {
                    iArr[26] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("android_urls")) {
                    iArr[27] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("animated_gif")) {
                    iArr[28] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("animated_image")) {
                    iArr[29] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("app_center_categories")) {
                    iArr[30] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("app_center_cover_image")) {
                    iArr[31] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("app_icon")) {
                    iArr[32] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("app_section_actor")) {
                    iArr[33] = GraphQLUserDeserializer.m6148a(jsonParser, flatBufferBuilder);
                } else if (i.equals("app_section_message")) {
                    iArr[34] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("app_section_time_created")) {
                    iArr[35] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("app_store_application")) {
                    iArr[36] = GraphQLAppStoreApplicationDeserializer.m4573a(jsonParser, flatBufferBuilder);
                } else if (i.equals("application")) {
                    iArr[37] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("application_name")) {
                    iArr[38] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("arrival_time_label")) {
                    iArr[39] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("artist_names")) {
                    iArr[40] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("associated_pages")) {
                    iArr[41] = GraphQLProfileDeserializer.m5720b(jsonParser, flatBufferBuilder);
                } else if (i.equals("atom_size")) {
                    zArr[3] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("attached_action_links")) {
                    iArr[43] = GraphQLStoryActionLinkDeserializer.m5951b(jsonParser, flatBufferBuilder);
                } else if (i.equals("attached_story")) {
                    iArr[44] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attachments")) {
                    iArr[45] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("attribution")) {
                    iArr[46] = GraphQLAttributionEntryDeserializer.m4595b(jsonParser, flatBufferBuilder);
                } else if (i.equals("audio_url")) {
                    iArr[47] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("author_text")) {
                    iArr[48] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("average_star_rating")) {
                    zArr[4] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("base_price_label")) {
                    iArr[50] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("base_url")) {
                    iArr[51] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("bio_text")) {
                    iArr[52] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("bitrate")) {
                    zArr[5] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("blurredCoverPhoto")) {
                    iArr[54] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("boarding_time_label")) {
                    iArr[55] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("boarding_zone_label")) {
                    iArr[56] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("booking_number_label")) {
                    iArr[57] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("broadcast_status")) {
                    zArr[6] = true;
                    enumArr[1] = GraphQLVideoBroadcastStatus.fromString(jsonParser.o());
                } else if (i.equals("bubble_type")) {
                    zArr[7] = true;
                    enumArr[2] = GraphQLMessengerCommerceBubbleType.fromString(jsonParser.o());
                } else if (i.equals("business_info")) {
                    iArr[60] = GraphQLBusinessInfoDeserializer.m4630b(jsonParser, flatBufferBuilder);
                } else if (i.equals("bylines")) {
                    iArr[61] = GraphQLBylineFragmentDeserializer.m4635b(jsonParser, flatBufferBuilder);
                } else if (i.equals("cabin_type_label")) {
                    iArr[62] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("cache_id")) {
                    iArr[63] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("campaign")) {
                    iArr[64] = GraphQLFundraiserCampaignDeserializer.m4972a(jsonParser, flatBufferBuilder);
                } else if (i.equals("campaign_title")) {
                    iArr[65] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("can_guests_invite_friends")) {
                    zArr[8] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_post_be_moderated")) {
                    zArr[9] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_see_voice_switcher")) {
                    zArr[10] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_add_tags")) {
                    zArr[11] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_append_photos")) {
                    zArr[12] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_change_availability")) {
                    zArr[13] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_change_guest_status")) {
                    zArr[14] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("can_viewer_claim")) {
                    zArr[15] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("can_viewer_comment")) {
                    zArr[16] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("can_viewer_comment_with_photo")) {
                    zArr[17] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("can_viewer_comment_with_sticker")) {
                    zArr[18] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("can_viewer_comment_with_video")) {
                    zArr[19] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("can_viewer_create_post")) {
                    zArr[20] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("can_viewer_delete")) {
                    zArr[21] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("can_viewer_edit")) {
                    zArr[22] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("can_viewer_edit_post_media")) {
                    zArr[23] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("can_viewer_edit_post_privacy")) {
                    zArr[24] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("can_viewer_edit_tag")) {
                    zArr[25] = true;
                    zArr2[17] = jsonParser.H();
                } else if (i.equals("can_viewer_get_notification")) {
                    zArr[26] = true;
                    zArr2[18] = jsonParser.H();
                } else if (i.equals("can_viewer_join")) {
                    zArr[27] = true;
                    zArr2[19] = jsonParser.H();
                } else if (i.equals("can_viewer_like")) {
                    zArr[28] = true;
                    zArr2[20] = jsonParser.H();
                } else if (i.equals("can_viewer_message")) {
                    zArr[29] = true;
                    zArr2[21] = jsonParser.H();
                } else if (i.equals("can_viewer_post")) {
                    zArr[30] = true;
                    zArr2[22] = jsonParser.H();
                } else if (i.equals("can_viewer_rate")) {
                    zArr[31] = true;
                    zArr2[23] = jsonParser.H();
                } else if (i.equals("can_viewer_react")) {
                    zArr[32] = true;
                    zArr2[24] = jsonParser.H();
                } else if (i.equals("can_viewer_subscribe")) {
                    zArr[33] = true;
                    zArr2[25] = jsonParser.H();
                } else if (i.equals("canvas_url")) {
                    iArr[93] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("carrier_tracking_url")) {
                    iArr[94] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("categories")) {
                    iArr[95] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("category_names")) {
                    iArr[96] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("category_type")) {
                    zArr[34] = true;
                    enumArr[3] = GraphQLPageCategoryType.fromString(jsonParser.o());
                } else if (i.equals("checkin_cta_label")) {
                    iArr[99] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("checkin_url")) {
                    iArr[100] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("city")) {
                    iArr[101] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("claim_time")) {
                    zArr[35] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("collection_names")) {
                    iArr[103] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("comments")) {
                    iArr[104] = GraphQLCommentsConnectionDeserializer.m4665a(jsonParser, flatBufferBuilder);
                } else if (i.equals("comments_mirroring_domain")) {
                    iArr[105] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("commerce_checkout_style")) {
                    zArr[36] = true;
                    enumArr[4] = GraphQLCommerceCheckoutStyle.fromString(jsonParser.o());
                } else if (i.equals("commerce_featured_item")) {
                    zArr[37] = true;
                    zArr2[26] = jsonParser.H();
                } else if (i.equals("commerce_page_type")) {
                    zArr[38] = true;
                    enumArr[5] = GraphQLCommercePageType.fromString(jsonParser.o());
                } else if (i.equals("commerce_product_visibility")) {
                    zArr[39] = true;
                    enumArr[6] = GraphQLCommerceProductVisibility.fromString(jsonParser.o());
                } else if (i.equals("concise_description")) {
                    iArr[110] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("connection_style")) {
                    zArr[40] = true;
                    enumArr[7] = GraphQLConnectionStyle.fromString(jsonParser.o());
                } else if (i.equals("coordinates")) {
                    iArr[112] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("copy_right")) {
                    iArr[113] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("coupon_claim_location")) {
                    zArr[41] = true;
                    enumArr[8] = GraphQLCouponClaimLocation.fromString(jsonParser.o());
                } else if (i.equals("cover_photo")) {
                    iArr[115] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("cover_url")) {
                    iArr[116] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("created_for_group")) {
                    iArr[117] = GraphQLGroupDeserializer.m5157a(jsonParser, flatBufferBuilder);
                } else if (i.equals("created_time")) {
                    zArr[42] = true;
                    jArr[2] = jsonParser.F();
                } else if (i.equals("creation_story")) {
                    iArr[119] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creation_time")) {
                    zArr[43] = true;
                    jArr[3] = jsonParser.F();
                } else if (i.equals("creator")) {
                    iArr[122] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("cultural_moment_image")) {
                    iArr[123] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("current_price")) {
                    iArr[124] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("data_points")) {
                    iArr[125] = GraphQLGoodwillThrowbackDataPointsConnectionDeserializer.m5029a(jsonParser, flatBufferBuilder);
                } else if (i.equals("delayed_delivery_time_for_display")) {
                    iArr[126] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("departure_label")) {
                    iArr[127] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("departure_time_label")) {
                    iArr[128] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("description")) {
                    iArr[129] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("destination_address")) {
                    iArr[130] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("destination_location")) {
                    iArr[131] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("disclaimer_accept_button_text")) {
                    iArr[132] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("disclaimer_continue_button_text")) {
                    iArr[133] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("display_duration")) {
                    iArr[134] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("display_explanation")) {
                    iArr[135] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("display_reactions")) {
                    zArr[44] = true;
                    zArr2[27] = jsonParser.H();
                } else if (i.equals("display_total")) {
                    iArr[137] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("distance")) {
                    zArr[45] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("distance_unit")) {
                    iArr[139] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("does_viewer_like")) {
                    zArr[46] = true;
                    zArr2[28] = jsonParser.H();
                } else if (i.equals("download_url")) {
                    iArr[141] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("duration_ms")) {
                    zArr[47] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("edit_history")) {
                    iArr[143] = GraphQLEditHistoryConnectionDeserializer.m4721a(jsonParser, flatBufferBuilder);
                } else if (i.equals("email_addresses")) {
                    iArr[144] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("emotional_analysis")) {
                    iArr[145] = GraphQLEmotionalAnalysisDeserializer.m4734a(jsonParser, flatBufferBuilder);
                } else if (i.equals("employer")) {
                    iArr[146] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("end_timestamp")) {
                    zArr[48] = true;
                    jArr[4] = jsonParser.F();
                } else if (i.equals("error_codes")) {
                    iArr[148] = GraphQLLeadGenErrorNodeDeserializer.m5293b(jsonParser, flatBufferBuilder);
                } else if (i.equals("error_message_brief")) {
                    iArr[149] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("error_message_detail")) {
                    iArr[150] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("estimated_delivery_time_for_display")) {
                    iArr[151] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("eventCategoryLabel")) {
                    iArr[152] = GraphQLEventCategoryDataDeserializer.m4773a(jsonParser, flatBufferBuilder);
                } else if (i.equals("eventProfilePicture")) {
                    iArr[153] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("eventUrl")) {
                    iArr[154] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event_coordinates")) {
                    iArr[155] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_cover_photo")) {
                    iArr[156] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_creator")) {
                    iArr[157] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_description")) {
                    iArr[158] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_hosts")) {
                    iArr[159] = GraphQLEventHostsConnectionDeserializer.m4797a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_kind")) {
                    zArr[49] = true;
                    enumArr[9] = GraphQLEventPrivacyType.fromString(jsonParser.o());
                } else if (i.equals("event_members")) {
                    iArr[161] = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_place")) {
                    iArr[162] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_privacy_type")) {
                    zArr[50] = true;
                    enumArr[10] = GraphQLEventPrivacyType.fromString(jsonParser.o());
                } else if (i.equals("event_title")) {
                    iArr[164] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event_type")) {
                    zArr[51] = true;
                    enumArr[11] = GraphQLEventType.fromString(jsonParser.o());
                } else if (i.equals("event_viewer_capability")) {
                    iArr[166] = GraphQLEventViewerCapabilityDeserializer.m4842a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_visibility")) {
                    zArr[52] = true;
                    enumArr[12] = GraphQLEventVisibility.fromString(jsonParser.o());
                } else if (i.equals("expiration_date")) {
                    zArr[53] = true;
                    jArr[5] = jsonParser.F();
                } else if (i.equals("expiration_time")) {
                    zArr[54] = true;
                    jArr[6] = jsonParser.F();
                } else if (i.equals("explicit_place")) {
                    iArr[170] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("expressed_as_place")) {
                    zArr[55] = true;
                    zArr2[29] = jsonParser.H();
                } else if (i.equals("external_url")) {
                    iArr[172] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("favicon")) {
                    iArr[173] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fb_data_policy_setting_description")) {
                    iArr[174] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fb_data_policy_url")) {
                    iArr[175] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("feed_topic_content")) {
                    iArr[176] = GraphQLFeedTopicContentDeserializer.m4882a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feed_unit_preview")) {
                    iArr[177] = FeedUnitDeserializerResolver.m4503a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[178] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("filter_values")) {
                    iArr[179] = GraphQLGraphSearchQueryFilterValuesConnectionDeserializer.m5100a(jsonParser, flatBufferBuilder);
                } else if (i.equals("filtered_claim_count")) {
                    zArr[56] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("first_metaline")) {
                    iArr[181] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("flight_date_label")) {
                    iArr[182] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("flight_gate_label")) {
                    iArr[183] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("flight_label")) {
                    iArr[184] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("flight_status_label")) {
                    iArr[185] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("flight_terminal_label")) {
                    iArr[186] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("follow_up_action_text")) {
                    iArr[188] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("follow_up_action_url")) {
                    iArr[189] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("followup_feed_units")) {
                    iArr[190] = GraphQLFollowUpFeedUnitsConnectionDeserializer.m4922a(jsonParser, flatBufferBuilder);
                } else if (i.equals("formatted_base_price")) {
                    iArr[191] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("formatted_tax")) {
                    iArr[192] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("formatted_total")) {
                    iArr[193] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("friendEventMaybesFirst5")) {
                    iArr[194] = GraphQLEventMaybesConnectionDeserializer.m4810a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventMembersFirst5")) {
                    iArr[195] = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventWatchersFirst5")) {
                    iArr[196] = GraphQLEventWatchersConnectionDeserializer.m4845a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends")) {
                    iArr[197] = GraphQLFriendsConnectionDeserializer.m4945a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendship_status")) {
                    zArr[57] = true;
                    enumArr[13] = GraphQLFriendshipStatus.fromString(jsonParser.o());
                } else if (i.equals("fundraiser_for_charity_text")) {
                    iArr[199] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fundraiser_page")) {
                    iArr[200] = GraphQLFundraiserPageDeserializer.m4978a(jsonParser, flatBufferBuilder);
                } else if (i.equals("global_share")) {
                    iArr[201] = GraphQLExternalUrlDeserializer.m4867a(jsonParser, flatBufferBuilder);
                } else if (i.equals("global_usage_summary_sentence")) {
                    iArr[202] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("graph_api_write_id")) {
                    iArr[203] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("greeting_card_template")) {
                    iArr[204] = GraphQLGreetingCardTemplateDeserializer.m5136a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_commerce_item_description")) {
                    iArr[205] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_members")) {
                    iArr[206] = GraphQLGroupMembersConnectionDeserializer.m5169a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_owner_authored_stories")) {
                    iArr[207] = GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer.m5182a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_photorealistic_icon")) {
                    iArr[208] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("guided_tour")) {
                    iArr[209] = GraphQLVideoGuidedTourDeserializer.m6187a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_comprehensive_title")) {
                    zArr[58] = true;
                    zArr2[30] = jsonParser.H();
                } else if (i.equals("has_viewer_claimed")) {
                    zArr[59] = true;
                    zArr2[31] = jsonParser.H();
                } else if (i.equals("hdAtomSize")) {
                    zArr[60] = true;
                    iArr2[5] = jsonParser.E();
                } else if (i.equals("hdBitrate")) {
                    zArr[61] = true;
                    iArr2[6] = jsonParser.E();
                } else if (i.equals("hideable_token")) {
                    iArr[214] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("hours")) {
                    iArr[215] = GraphQLTimeRangeDeserializer.m6065b(jsonParser, flatBufferBuilder);
                } else if (i.equals("html_source")) {
                    iArr[216] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("icon")) {
                    iArr[217] = GraphQLIconDeserializer.m5219a(jsonParser, flatBufferBuilder);
                } else if (i.equals("iconImageLarge")) {
                    iArr[218] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[219] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[220] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHigh")) {
                    iArr[221] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("imageHighOrig")) {
                    iArr[222] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("image_margin")) {
                    iArr[223] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image_url")) {
                    iArr[225] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("implicit_place")) {
                    iArr[226] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("initial_view_heading_degrees")) {
                    zArr[62] = true;
                    iArr2[7] = jsonParser.E();
                } else if (i.equals("initial_view_pitch_degrees")) {
                    zArr[63] = true;
                    iArr2[8] = jsonParser.E();
                } else if (i.equals("initial_view_roll_degrees")) {
                    zArr[64] = true;
                    iArr2[9] = jsonParser.E();
                } else if (i.equals("inline_activities")) {
                    iArr[230] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("insights")) {
                    iArr[231] = GraphQLStoryInsightsDeserializer.m5973a(jsonParser, flatBufferBuilder);
                } else if (i.equals("instant_article")) {
                    iArr[232] = GraphQLInstantArticleDeserializer.m5262a(jsonParser, flatBufferBuilder);
                } else if (i.equals("instant_articles_enabled")) {
                    zArr[65] = true;
                    zArr2[32] = jsonParser.H();
                } else if (i.equals("is_active")) {
                    zArr[66] = true;
                    zArr2[33] = jsonParser.H();
                } else if (i.equals("is_all_day")) {
                    zArr[67] = true;
                    zArr2[34] = jsonParser.H();
                } else if (i.equals("is_always_open")) {
                    zArr[68] = true;
                    zArr2[35] = jsonParser.H();
                } else if (i.equals("is_banned_by_page_viewer")) {
                    zArr[69] = true;
                    zArr2[36] = jsonParser.H();
                } else if (i.equals("is_canceled")) {
                    zArr[70] = true;
                    zArr2[37] = jsonParser.H();
                } else if (i.equals("is_current_location")) {
                    zArr[71] = true;
                    zArr2[38] = jsonParser.H();
                } else if (i.equals("is_disturbing")) {
                    zArr[72] = true;
                    zArr2[39] = jsonParser.H();
                } else if (i.equals("is_eligible_for_page_verification")) {
                    zArr[73] = true;
                    zArr2[40] = jsonParser.H();
                } else if (i.equals("is_event_draft")) {
                    zArr[74] = true;
                    zArr2[41] = jsonParser.H();
                } else if (i.equals("is_expired")) {
                    zArr[75] = true;
                    zArr2[42] = jsonParser.H();
                } else if (i.equals("is_live_streaming")) {
                    zArr[76] = true;
                    zArr2[43] = jsonParser.H();
                } else if (i.equals("is_music_item")) {
                    zArr[77] = true;
                    zArr2[44] = jsonParser.H();
                } else if (i.equals("is_on_sale")) {
                    zArr[78] = true;
                    zArr2[45] = jsonParser.H();
                } else if (i.equals("is_owned")) {
                    zArr[79] = true;
                    zArr2[46] = jsonParser.H();
                } else if (i.equals("is_permanently_closed")) {
                    zArr[80] = true;
                    zArr2[47] = jsonParser.H();
                } else if (i.equals("is_playable")) {
                    zArr[81] = true;
                    zArr2[48] = jsonParser.H();
                } else if (i.equals("is_privacy_locked")) {
                    zArr[82] = true;
                    zArr2[49] = jsonParser.H();
                } else if (i.equals("is_service_page")) {
                    zArr[83] = true;
                    zArr2[50] = jsonParser.H();
                } else if (i.equals("is_sold")) {
                    zArr[84] = true;
                    zArr2[51] = jsonParser.H();
                } else if (i.equals("is_spherical")) {
                    zArr[85] = true;
                    zArr2[52] = jsonParser.H();
                } else if (i.equals("is_stopped")) {
                    zArr[86] = true;
                    zArr2[53] = jsonParser.H();
                } else if (i.equals("is_used")) {
                    zArr[87] = true;
                    zArr2[54] = jsonParser.H();
                } else if (i.equals("is_verified")) {
                    zArr[88] = true;
                    zArr2[55] = jsonParser.H();
                } else if (i.equals("is_viewer_notified_about")) {
                    zArr[89] = true;
                    zArr2[56] = jsonParser.H();
                } else if (i.equals("is_viewer_subscribed")) {
                    zArr[90] = true;
                    zArr2[57] = jsonParser.H();
                } else if (i.equals("item_price")) {
                    iArr[260] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("item_type")) {
                    zArr[91] = true;
                    enumArr[14] = GraphQLTimelineContactItemType.fromString(jsonParser.o());
                } else if (i.equals("landing_page_cta")) {
                    iArr[262] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("landing_page_redirect_instruction")) {
                    iArr[263] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("lead_gen_data")) {
                    iArr[264] = GraphQLLeadGenDataDeserializer.m5283a(jsonParser, flatBufferBuilder);
                } else if (i.equals("lead_gen_deep_link_user_status")) {
                    iArr[265] = GraphQLLeadGenDeepLinkUserStatusDeserializer.m5286a(jsonParser, flatBufferBuilder);
                } else if (i.equals("legacy_api_post_id")) {
                    iArr[266] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("legacy_api_story_id")) {
                    iArr[267] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("like_sentence")) {
                    iArr[268] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("likers")) {
                    iArr[269] = GraphQLLikersOfContentConnectionDeserializer.m5318a(jsonParser, flatBufferBuilder);
                } else if (i.equals("link_media")) {
                    iArr[270] = GraphQLMediaDeserializer.m5338a(jsonParser, flatBufferBuilder);
                } else if (i.equals("list_feed")) {
                    iArr[271] = GraphQLFriendListFeedConnectionDeserializer.m4928a(jsonParser, flatBufferBuilder);
                } else if (i.equals("list_title")) {
                    iArr[272] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("live_viewer_count")) {
                    zArr[92] = true;
                    iArr2[10] = jsonParser.E();
                } else if (i.equals("live_viewer_count_read_only")) {
                    zArr[93] = true;
                    iArr2[11] = jsonParser.E();
                } else if (i.equals("location")) {
                    iArr[275] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("logo")) {
                    iArr[276] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("logo_image")) {
                    iArr[277] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("map_points")) {
                    iArr[278] = GraphQLLocationDeserializer.m5334b(jsonParser, flatBufferBuilder);
                } else if (i.equals("map_zoom_level")) {
                    zArr[94] = true;
                    iArr2[12] = jsonParser.E();
                } else if (i.equals("media")) {
                    iArr[280] = GraphQLMediaSetMediaConnectionDeserializer.m5358a(jsonParser, flatBufferBuilder);
                } else if (i.equals("media_elements")) {
                    iArr[281] = GraphQLSouvenirMediaConnectionDeserializer.m5906a(jsonParser, flatBufferBuilder);
                } else if (i.equals("media_question_option_order")) {
                    iArr[282] = GraphQLMediaQuestionOptionsConnectionDeserializer.m5349a(jsonParser, flatBufferBuilder);
                } else if (i.equals("media_question_photos")) {
                    iArr[283] = GraphQLPhotoDeserializer.m5604b(jsonParser, flatBufferBuilder);
                } else if (i.equals("media_question_type")) {
                    iArr[284] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("media_set")) {
                    iArr[285] = GraphQLMediaSetDeserializer.m5355a(jsonParser, flatBufferBuilder);
                } else if (i.equals("menu_info")) {
                    iArr[286] = GraphQLPageMenuInfoDeserializer.m5512a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message")) {
                    iArr[287] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message_id")) {
                    iArr[288] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("message_permalink")) {
                    iArr[289] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("messenger_contact")) {
                    iArr[290] = GraphQLContactDeserializer.m4677a(jsonParser, flatBufferBuilder);
                } else if (i.equals("modified_time")) {
                    zArr[95] = true;
                    jArr[7] = jsonParser.F();
                } else if (i.equals("movie_list_style")) {
                    zArr[96] = true;
                    enumArr[15] = GraphQLMovieBotMovieListStyle.fromString(jsonParser.o());
                } else if (i.equals("multiShareAttachmentWithImageFields")) {
                    iArr[294] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("music_object")) {
                    iArr[295] = GraphQLOpenGraphObjectDeserializer.m5465a(jsonParser, flatBufferBuilder);
                } else if (i.equals("music_title")) {
                    iArr[296] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("music_type")) {
                    zArr[97] = true;
                    enumArr[16] = GraphQLMusicType.fromString(jsonParser.o());
                } else if (i.equals("musicians")) {
                    iArr[298] = GraphQLOpenGraphObjectDeserializer.m5468b(jsonParser, flatBufferBuilder);
                } else if (i.equals("mutual_friends")) {
                    iArr[299] = GraphQLMutualFriendsConnectionDeserializer.m5380a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[300] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[301] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("neighborhood_name")) {
                    iArr[302] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("open_graph_composer_preview")) {
                    iArr[303] = GraphQLStoryAttachmentDeserializer.m5953a(jsonParser, flatBufferBuilder);
                } else if (i.equals("open_graph_metadata")) {
                    iArr[304] = GraphQLOpenGraphMetadataDeserializer.m5462a(jsonParser, flatBufferBuilder);
                } else if (i.equals("open_graph_node")) {
                    iArr[305] = m5436a(jsonParser, flatBufferBuilder);
                } else if (i.equals("options")) {
                    iArr[306] = GraphQLQuestionOptionsConnectionDeserializer.m5740a(jsonParser, flatBufferBuilder);
                } else if (i.equals("order_id")) {
                    iArr[307] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("order_payment_method")) {
                    iArr[308] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("overall_rating")) {
                    zArr[98] = true;
                    dArr[2] = jsonParser.G();
                } else if (i.equals("overall_star_rating")) {
                    iArr[310] = GraphQLRatingDeserializer.m5778a(jsonParser, flatBufferBuilder);
                } else if (i.equals("owner")) {
                    iArr[311] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("owning_page")) {
                    iArr[312] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page")) {
                    iArr[313] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_likers")) {
                    iArr[314] = GraphQLPageLikersConnectionDeserializer.m5509a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_payment_options")) {
                    iArr[315] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLPagePaymentOption.class);
                } else if (i.equals("page_rating")) {
                    zArr[99] = true;
                    iArr2[13] = jsonParser.E();
                } else if (i.equals("parent_group")) {
                    iArr[317] = GraphQLGroupDeserializer.m5157a(jsonParser, flatBufferBuilder);
                } else if (i.equals("partner_logo")) {
                    iArr[318] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("passenger_name_label")) {
                    iArr[319] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("passenger_names_label")) {
                    iArr[320] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("passenger_seat_label")) {
                    iArr[321] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("payment_id")) {
                    iArr[322] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("payment_request_id")) {
                    iArr[323] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("permanently_closed_status")) {
                    zArr[100] = true;
                    enumArr[17] = GraphQLPermanentlyClosedStatus.fromString(jsonParser.o());
                } else if (i.equals("photo")) {
                    iArr[326] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("photo_items")) {
                    iArr[327] = GraphQLMediaSetMediaConnectionDeserializer.m5358a(jsonParser, flatBufferBuilder);
                } else if (i.equals("photos")) {
                    iArr[328] = GraphQLPhotoDeserializer.m5604b(jsonParser, flatBufferBuilder);
                } else if (i.equals("phrases_analysis")) {
                    iArr[329] = GraphQLPhrasesAnalysisDeserializer.m5626a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pickup_note")) {
                    iArr[330] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place")) {
                    iArr[331] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_list_items")) {
                    iArr[332] = GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer.m4662a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_list_title")) {
                    iArr[333] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("place_open_status")) {
                    iArr[334] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_open_status_type")) {
                    zArr[101] = true;
                    enumArr[18] = GraphQLPageOpenHoursDisplayDecisionEnum.fromString(jsonParser.o());
                } else if (i.equals("place_recommendation_info")) {
                    iArr[336] = GraphQLPlaceRecommendationPostInfoDeserializer.m5660a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_type")) {
                    zArr[102] = true;
                    enumArr[19] = GraphQLPlaceType.fromString(jsonParser.o());
                } else if (i.equals("plain_body")) {
                    iArr[338] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("play_count")) {
                    zArr[103] = true;
                    iArr2[14] = jsonParser.E();
                } else if (i.equals("playableUrlHdString")) {
                    iArr[340] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playableUrlRtmpString")) {
                    iArr[341] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("playable_duration_in_ms")) {
                    zArr[104] = true;
                    iArr2[15] = jsonParser.E();
                } else if (i.equals("playable_url")) {
                    iArr[343] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("pnr_number")) {
                    iArr[344] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("poll_answers_state")) {
                    zArr[105] = true;
                    enumArr[20] = GraphQLQuestionPollAnswersState.fromString(jsonParser.o());
                } else if (i.equals("post_approval_required")) {
                    zArr[106] = true;
                    zArr2[58] = jsonParser.H();
                } else if (i.equals("post_promotion_info")) {
                    iArr[347] = GraphQLBoostedComponentDeserializer.m4611a(jsonParser, flatBufferBuilder);
                } else if (i.equals("posted_photos")) {
                    iArr[348] = GraphQLPostedPhotosConnectionDeserializer.m5685a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preferredPlayableUrlString")) {
                    iArr[349] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("previewTemplateAtPlace")) {
                    iArr[351] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateNoTags")) {
                    iArr[352] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateWithPeople")) {
                    iArr[353] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateWithPeopleAtPlace")) {
                    iArr[354] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateWithPerson")) {
                    iArr[355] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateWithPersonAtPlace")) {
                    iArr[356] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preview_image")) {
                    iArr[357] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preview_urls")) {
                    iArr[358] = GraphQLAudioDeserializer.m4604b(jsonParser, flatBufferBuilder);
                } else if (i.equals("price_amount")) {
                    iArr[359] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("price_currency")) {
                    iArr[360] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("price_type")) {
                    zArr[107] = true;
                    enumArr[21] = GraphQLGroupCommercePriceType.fromString(jsonParser.o());
                } else if (i.equals("primary_button_text")) {
                    iArr[362] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("primary_image")) {
                    iArr[363] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("primary_object_node")) {
                    iArr[364] = m5436a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_option")) {
                    iArr[365] = GraphQLPrivacyOptionDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_scope")) {
                    iArr[366] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_setting_description")) {
                    iArr[367] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profileImageLarge")) {
                    iArr[368] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[369] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureAsCover")) {
                    iArr[370] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[371] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[372] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[373] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[108] = true;
                    zArr2[59] = jsonParser.H();
                } else if (i.equals("progress_text")) {
                    iArr[375] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("projection_type")) {
                    iArr[376] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("promotion_info")) {
                    iArr[377] = GraphQLPagePostPromotionInfoDeserializer.m5518a(jsonParser, flatBufferBuilder);
                } else if (i.equals("purchase_summary_label")) {
                    iArr[378] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("quote")) {
                    iArr[379] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("quotes_analysis")) {
                    iArr[380] = GraphQLQuotesAnalysisDeserializer.m5766a(jsonParser, flatBufferBuilder);
                } else if (i.equals("rating")) {
                    iArr[381] = GraphQLRatingDeserializer.m5778a(jsonParser, flatBufferBuilder);
                } else if (i.equals("reactors")) {
                    iArr[382] = GraphQLReactorsOfContentConnectionDeserializer.m5787a(jsonParser, flatBufferBuilder);
                } else if (i.equals("receipt_id")) {
                    iArr[383] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("receipt_url")) {
                    iArr[384] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("receiver")) {
                    iArr[385] = GraphQLUserDeserializer.m6148a(jsonParser, flatBufferBuilder);
                } else if (i.equals("rectangular_profile_picture")) {
                    iArr[386] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("redemption_code")) {
                    iArr[387] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("redemption_url")) {
                    iArr[388] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("redirection_info")) {
                    iArr[389] = GraphQLRedirectionInfoDeserializer.m5802b(jsonParser, flatBufferBuilder);
                } else if (i.equals("redspace_story")) {
                    iArr[390] = GraphQLRedSpaceStoryInfoDeserializer.m5796a(jsonParser, flatBufferBuilder);
                } else if (i.equals("referenced_sticker")) {
                    iArr[391] = GraphQLStickerDeserializer.m5945a(jsonParser, flatBufferBuilder);
                } else if (i.equals("remixable_photo_uri")) {
                    iArr[392] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("represented_profile")) {
                    iArr[393] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("requestee")) {
                    iArr[394] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("requester")) {
                    iArr[395] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("response_method")) {
                    zArr[109] = true;
                    enumArr[22] = GraphQLQuestionResponseMethod.fromString(jsonParser.o());
                } else if (i.equals("ride_display_name")) {
                    iArr[397] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("root_share_story")) {
                    iArr[398] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sale_price")) {
                    iArr[399] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("save_info")) {
                    iArr[400] = GraphQLStorySaveInfoDeserializer.m5976a(jsonParser, flatBufferBuilder);
                } else if (i.equals("saved_collection")) {
                    iArr[401] = GraphQLTimelineAppCollectionDeserializer.m6066a(jsonParser, flatBufferBuilder);
                } else if (i.equals("school")) {
                    iArr[402] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("school_class")) {
                    iArr[403] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("second_metaline")) {
                    iArr[404] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("secondary_subscribe_status")) {
                    zArr[110] = true;
                    enumArr[23] = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("section_type")) {
                    zArr[111] = true;
                    enumArr[24] = GraphQLTimelineAppSectionType.fromString(jsonParser.o());
                } else if (i.equals("secure_sharing_text")) {
                    iArr[407] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("seen_by")) {
                    iArr[408] = GraphQLSeenByConnectionDeserializer.m5877a(jsonParser, flatBufferBuilder);
                } else if (i.equals("seen_state")) {
                    zArr[112] = true;
                    enumArr[25] = GraphQLStorySeenState.fromString(jsonParser.o());
                } else if (i.equals("select_text_hint")) {
                    iArr[410] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("seller")) {
                    iArr[411] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("seller_info")) {
                    iArr[412] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("send_description")) {
                    iArr[413] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sender")) {
                    iArr[414] = GraphQLUserDeserializer.m6148a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sent_text")) {
                    iArr[415] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("service_type_description")) {
                    iArr[416] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("share_cta_label")) {
                    iArr[417] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("share_story")) {
                    iArr[418] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("shareable")) {
                    iArr[419] = GraphQLEntityDeserializer.m4763a(jsonParser, flatBufferBuilder);
                } else if (i.equals("shipdate_for_display")) {
                    iArr[420] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("shipment_tracking_event_type")) {
                    zArr[113] = true;
                    enumArr[26] = GraphQLShipmentTrackingEventType.fromString(jsonParser.o());
                } else if (i.equals("shortSummary")) {
                    iArr[422] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("short_secure_sharing_text")) {
                    iArr[423] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("should_intercept_delete_post")) {
                    zArr[114] = true;
                    zArr2[60] = jsonParser.H();
                } else if (i.equals("should_open_single_publisher")) {
                    zArr[115] = true;
                    zArr2[61] = jsonParser.H();
                } else if (i.equals("should_show_message_button")) {
                    zArr[116] = true;
                    zArr2[62] = jsonParser.H();
                } else if (i.equals("should_show_recent_activity_entry_point")) {
                    zArr[117] = true;
                    zArr2[63] = jsonParser.H();
                } else if (i.equals("should_show_recent_checkins_entry_point")) {
                    zArr[118] = true;
                    zArr2[64] = jsonParser.H();
                } else if (i.equals("should_show_recent_mentions_entry_point")) {
                    zArr[119] = true;
                    zArr2[65] = jsonParser.H();
                } else if (i.equals("should_show_recent_reviews_entry_point")) {
                    zArr[120] = true;
                    zArr2[66] = jsonParser.H();
                } else if (i.equals("should_show_recent_shares_entry_point")) {
                    zArr[121] = true;
                    zArr2[67] = jsonParser.H();
                } else if (i.equals("should_show_reviews_on_profile")) {
                    zArr[122] = true;
                    zArr2[68] = jsonParser.H();
                } else if (i.equals("show_mark_as_sold_button")) {
                    zArr[123] = true;
                    zArr2[69] = jsonParser.H();
                } else if (i.equals("skip_experiments")) {
                    zArr[124] = true;
                    zArr2[70] = jsonParser.H();
                } else if (i.equals("slides")) {
                    iArr[435] = GraphQLGreetingCardSlidesConnectionDeserializer.m5133a(jsonParser, flatBufferBuilder);
                } else if (i.equals("snippet")) {
                    iArr[436] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("social_context")) {
                    iArr[437] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("social_usage_summary_sentence")) {
                    iArr[438] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("source")) {
                    iArr[439] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("source_address")) {
                    iArr[440] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("source_location")) {
                    iArr[441] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("souvenir_cover_photo")) {
                    iArr[442] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sphericalFullscreenAspectRatio")) {
                    zArr[125] = true;
                    dArr[3] = jsonParser.G();
                } else if (i.equals("sphericalInlineAspectRatio")) {
                    zArr[126] = true;
                    dArr[4] = jsonParser.G();
                } else if (i.equals("sphericalPlayableUrlHdString")) {
                    iArr[445] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sphericalPlayableUrlSdString")) {
                    iArr[446] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sphericalPreferredFov")) {
                    zArr[127] = true;
                    iArr2[16] = jsonParser.E();
                } else if (i.equals("split_flow_landing_page_hint_text")) {
                    iArr[448] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("split_flow_landing_page_hint_title")) {
                    iArr[449] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sponsored_data")) {
                    iArr[450] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sports_match_data")) {
                    iArr[451] = GraphQLSportsDataMatchDataDeserializer.m5924a(jsonParser, flatBufferBuilder);
                } else if (i.equals("square_logo")) {
                    iArr[452] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("start_timestamp")) {
                    zArr[128] = true;
                    jArr[8] = jsonParser.F();
                } else if (i.equals("status")) {
                    iArr[454] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("status_text")) {
                    iArr[455] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("status_type")) {
                    zArr[129] = true;
                    enumArr[27] = GraphQLMessengerRetailItemStatus.fromString(jsonParser.o());
                } else if (i.equals("story")) {
                    iArr[457] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("story_attachment")) {
                    iArr[458] = GraphQLStoryAttachmentDeserializer.m5953a(jsonParser, flatBufferBuilder);
                } else if (i.equals("story_header")) {
                    iArr[459] = GraphQLStoryHeaderDeserializer.m5970a(jsonParser, flatBufferBuilder);
                } else if (i.equals("structured_survey")) {
                    iArr[460] = GraphQLStructuredSurveyDeserializer.m6000a(jsonParser, flatBufferBuilder);
                } else if (i.equals("submit_card_instruction_text")) {
                    iArr[461] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("subscribe_status")) {
                    zArr[130] = true;
                    enumArr[28] = GraphQLSubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("substories_grouping_reasons")) {
                    iArr[463] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLSubstoriesGroupingReason.class);
                } else if (i.equals("substory_count")) {
                    zArr[131] = true;
                    iArr2[17] = jsonParser.E();
                } else if (i.equals("suffix")) {
                    iArr[465] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("suggested_event_context_sentence")) {
                    iArr[466] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("summary")) {
                    iArr[467] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("super_category_type")) {
                    zArr[132] = true;
                    enumArr[29] = GraphQLPageSuperCategoryType.fromString(jsonParser.o());
                } else if (i.equals("supplemental_social_story")) {
                    iArr[469] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("supported_reactions")) {
                    iArr[470] = GraphQLFeedbackReactionDeserializer.m4900b(jsonParser, flatBufferBuilder);
                } else if (i.equals("survey_start_url")) {
                    iArr[471] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("target_url")) {
                    iArr[473] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("taxes_label")) {
                    iArr[474] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("terms")) {
                    iArr[475] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("text")) {
                    iArr[476] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("theme")) {
                    iArr[477] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("themeListImage")) {
                    iArr[478] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("thirdPartyOwner")) {
                    iArr[479] = GraphQLOpenGraphMetadataDeserializer.m5462a(jsonParser, flatBufferBuilder);
                } else if (i.equals("third_metaline")) {
                    iArr[480] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("thread_image")) {
                    iArr[481] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("throwback_media")) {
                    iArr[482] = GraphQLMediaDeserializer.m5341b(jsonParser, flatBufferBuilder);
                } else if (i.equals("throwback_media_attachments")) {
                    iArr[483] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("time_range")) {
                    iArr[484] = GraphQLEventTimeRangeDeserializer.m4833a(jsonParser, flatBufferBuilder);
                } else if (i.equals("time_range_sentence")) {
                    iArr[485] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("timestamp_precise")) {
                    iArr[486] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("timezone")) {
                    iArr[487] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tint_color")) {
                    iArr[488] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("title")) {
                    iArr[489] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("titleForSummary")) {
                    iArr[490] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("to")) {
                    iArr[491] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("top_headline_object")) {
                    iArr[492] = m5436a(jsonParser, flatBufferBuilder);
                } else if (i.equals("top_level_comments")) {
                    iArr[493] = GraphQLTopLevelCommentsConnectionDeserializer.m6101a(jsonParser, flatBufferBuilder);
                } else if (i.equals("top_reactions")) {
                    iArr[494] = GraphQLTopReactionsConnectionDeserializer.m6104a(jsonParser, flatBufferBuilder);
                } else if (i.equals("topic_image")) {
                    iArr[495] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("topics_context")) {
                    iArr[496] = GraphQLStoryTopicsContextDeserializer.m5988a(jsonParser, flatBufferBuilder);
                } else if (i.equals("total")) {
                    iArr[497] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("total_label")) {
                    iArr[498] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tracking")) {
                    iArr[499] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tracking_event_description")) {
                    iArr[500] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tracking_event_time_for_display")) {
                    iArr[501] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tracking_number")) {
                    iArr[502] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("translatability_for_viewer")) {
                    iArr[503] = GraphQLPostTranslatabilityDeserializer.m5682a(jsonParser, flatBufferBuilder);
                } else if (i.equals("translated_body_for_viewer")) {
                    iArr[504] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("translated_message_for_viewer")) {
                    iArr[505] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("translation_metadata")) {
                    iArr[506] = GraphQLTranslationMetaDataDeserializer.m6121a(jsonParser, flatBufferBuilder);
                } else if (i.equals("trending_topic_data")) {
                    iArr[507] = GraphQLTrendingTopicDataDeserializer.m6127a(jsonParser, flatBufferBuilder);
                } else if (i.equals("trending_topic_name")) {
                    iArr[508] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("unique_keyword")) {
                    iArr[510] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("unread_count")) {
                    zArr[133] = true;
                    iArr2[18] = jsonParser.E();
                } else if (i.equals("unsubscribe_description")) {
                    iArr[512] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("update_type")) {
                    iArr[513] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[514] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("username")) {
                    iArr[515] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("value")) {
                    iArr[516] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("verification_status")) {
                    zArr[134] = true;
                    enumArr[30] = GraphQLPageVerificationBadge.fromString(jsonParser.o());
                } else if (i.equals("via")) {
                    iArr[518] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel")) {
                    iArr[519] = GraphQLVideoChannelDeserializer.m6176a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_list_description")) {
                    iArr[520] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_list_title")) {
                    iArr[521] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("view_boarding_pass_cta_label")) {
                    iArr[522] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("view_details_cta_label")) {
                    iArr[523] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_acts_as_page")) {
                    iArr[524] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_does_not_like_sentence")) {
                    iArr[526] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_feedback_reaction_key")) {
                    zArr[135] = true;
                    iArr2[19] = jsonParser.E();
                } else if (i.equals("viewer_guest_status")) {
                    zArr[136] = true;
                    enumArr[31] = GraphQLEventGuestStatus.fromString(jsonParser.o());
                } else if (i.equals("viewer_has_pending_invite")) {
                    zArr[137] = true;
                    zArr2[71] = jsonParser.H();
                } else if (i.equals("viewer_has_voted")) {
                    zArr[138] = true;
                    zArr2[72] = jsonParser.H();
                } else if (i.equals("viewer_inviters")) {
                    iArr[531] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_join_state")) {
                    zArr[139] = true;
                    enumArr[32] = GraphQLGroupJoinState.fromString(jsonParser.o());
                } else if (i.equals("viewer_likes_sentence")) {
                    iArr[534] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_profile_permissions")) {
                    iArr[535] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_readstate")) {
                    zArr[140] = true;
                    zArr2[73] = jsonParser.H();
                } else if (i.equals("viewer_recommendation")) {
                    iArr[537] = GraphQLContactRecommendationFieldDeserializer.m4683a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_saved_state")) {
                    zArr[141] = true;
                    enumArr[33] = GraphQLSavedState.fromString(jsonParser.o());
                } else if (i.equals("viewer_timeline_collections_containing")) {
                    iArr[539] = GraphQLTimelineAppCollectionDeserializer.m6069b(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_timeline_collections_supported")) {
                    iArr[540] = GraphQLTimelineAppCollectionDeserializer.m6069b(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_watch_status")) {
                    zArr[142] = true;
                    enumArr[34] = GraphQLEventWatchStatus.fromString(jsonParser.o());
                } else if (i.equals("visibility_sentence")) {
                    iArr[542] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("websites")) {
                    iArr[543] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("webview_base_url")) {
                    iArr[544] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("with_tags")) {
                    iArr[545] = GraphQLWithTagsConnectionDeserializer.m6205a(jsonParser, flatBufferBuilder);
                } else if (i.equals("work_project")) {
                    iArr[546] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message_cta_label")) {
                    iArr[547] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("currency")) {
                    iArr[548] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("transaction_discount")) {
                    zArr[143] = true;
                    iArr2[20] = jsonParser.E();
                } else if (i.equals("transaction_status")) {
                    zArr[144] = true;
                    enumArr[35] = GraphQLPageProductTransactionOrderStatusEnum.fromString(jsonParser.o());
                } else if (i.equals("transaction_status_display")) {
                    iArr[554] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("transaction_subtotal_cost")) {
                    zArr[145] = true;
                    iArr2[21] = jsonParser.E();
                } else if (i.equals("transaction_total_cost")) {
                    zArr[146] = true;
                    iArr2[22] = jsonParser.E();
                } else if (i.equals("event_promotion_status")) {
                    zArr[147] = true;
                    enumArr[36] = GraphQLBoostedPostStatus.fromString(jsonParser.o());
                } else if (i.equals("all_sale_groups")) {
                    iArr[558] = GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer.m5845a(jsonParser, flatBufferBuilder);
                } else if (i.equals("list_items")) {
                    iArr[559] = GraphQLPlaceListItemsFromPlaceListConnectionDeserializer.m5652a(jsonParser, flatBufferBuilder);
                } else if (i.equals("non_specific_place_to_search")) {
                    iArr[560] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("charity")) {
                    iArr[561] = GraphQLFundraiserCharityDeserializer.m4975a(jsonParser, flatBufferBuilder);
                } else if (i.equals("header_photo")) {
                    iArr[562] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("amount_raised_text")) {
                    iArr[563] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("campaign_goal_text")) {
                    iArr[564] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("has_goal_amount")) {
                    zArr[148] = true;
                    zArr2[74] = jsonParser.H();
                } else if (i.equals("percent_of_goal_reached")) {
                    zArr[149] = true;
                    dArr[5] = jsonParser.G();
                } else if (i.equals("viewer_edit_post_feature_capabilities")) {
                    iArr[567] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLEditPostFeatureCapability.class);
                } else if (i.equals("should_show_username")) {
                    zArr[150] = true;
                    zArr2[75] = jsonParser.H();
                } else if (i.equals("big_profile_image")) {
                    iArr[569] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tiny_profile_image")) {
                    iArr[570] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("donors")) {
                    iArr[571] = GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer.m4984a(jsonParser, flatBufferBuilder);
                } else if (i.equals("social_context_text")) {
                    iArr[572] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("parent_story")) {
                    iArr[573] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("receipt_image")) {
                    iArr[574] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("claim_status")) {
                    iArr[575] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("offer_code")) {
                    iArr[576] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("messenger_content_subscription_option")) {
                    iArr[577] = GraphQLMessengerContentSubscriptionOptionDeserializer.m5367a(jsonParser, flatBufferBuilder);
                } else if (i.equals("price_range_description")) {
                    iArr[578] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("query_function")) {
                    iArr[579] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("query_role")) {
                    iArr[580] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("query_title")) {
                    iArr[581] = GraphQLGraphSearchQueryTitleDeserializer.m5103a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_follow")) {
                    zArr[151] = true;
                    zArr2[76] = jsonParser.H();
                } else if (i.equals("formatted_shipping_address")) {
                    iArr[583] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_viewer_subscribed_to_messenger_content")) {
                    zArr[152] = true;
                    zArr2[77] = jsonParser.H();
                } else if (i.equals("feedback_context")) {
                    iArr[585] = GraphQLFeedbackContextDeserializer.m4889a(jsonParser, flatBufferBuilder);
                } else if (i.equals("buyer_email")) {
                    iArr[586] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("buyer_name")) {
                    iArr[587] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tickets_count")) {
                    zArr[153] = true;
                    iArr2[23] = jsonParser.E();
                } else if (i.equals("important_reactors")) {
                    iArr[589] = GraphQLImportantReactorsConnectionDeserializer.m5231a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_acts_as_person")) {
                    iArr[590] = GraphQLUserDeserializer.m6148a(jsonParser, flatBufferBuilder);
                } else if (i.equals("product_latitude")) {
                    zArr[154] = true;
                    dArr[6] = jsonParser.G();
                } else if (i.equals("product_longitude")) {
                    zArr[155] = true;
                    dArr[7] = jsonParser.G();
                } else if (i.equals("video_captions_locales")) {
                    iArr[593] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("accessibility_caption")) {
                    iArr[594] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("scheduled_publish_timestamp")) {
                    zArr[156] = true;
                    jArr[9] = jsonParser.F();
                } else if (i.equals("has_viewer_viewed")) {
                    zArr[157] = true;
                    zArr2[78] = jsonParser.H();
                } else if (i.equals("has_viewer_watched_video")) {
                    zArr[158] = true;
                    zArr2[79] = jsonParser.H();
                } else if (i.equals("height")) {
                    zArr[159] = true;
                    iArr2[24] = jsonParser.E();
                } else if (i.equals("imageVideoThumbnail")) {
                    iArr[599] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_looping")) {
                    zArr[160] = true;
                    zArr2[80] = jsonParser.H();
                } else if (i.equals("is_video_broadcast")) {
                    zArr[161] = true;
                    zArr2[81] = jsonParser.H();
                } else if (i.equals("loop_count")) {
                    zArr[162] = true;
                    iArr2[25] = jsonParser.E();
                } else if (i.equals("playable_duration")) {
                    zArr[163] = true;
                    iArr2[26] = jsonParser.E();
                } else if (i.equals("playlist")) {
                    iArr[604] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("supports_time_slices")) {
                    zArr[164] = true;
                    zArr2[82] = jsonParser.H();
                } else if (i.equals("width")) {
                    zArr[165] = true;
                    iArr2[27] = jsonParser.E();
                } else if (i.equals("locally_updated_containing_collection_id")) {
                    iArr[607] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profile_video")) {
                    iArr[608] = GraphQLProfileVideoDeserializer.m5722a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message_markdown_html")) {
                    iArr[609] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("ad_preview_id")) {
                    iArr[610] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("ad_sharing_status")) {
                    zArr[166] = true;
                    enumArr[37] = GraphQLAdsExperienceStatusEnum.fromString(jsonParser.o());
                } else if (i.equals("experimental_freeform_price")) {
                    iArr[612] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("notifications_enabled")) {
                    zArr[167] = true;
                    zArr2[83] = jsonParser.H();
                } else if (i.equals("estimated_results")) {
                    zArr[168] = true;
                    iArr2[28] = jsonParser.E();
                } else if (i.equals("pending_places_for_attachment")) {
                    iArr[615] = GraphQLPageDeserializer.m5504b(jsonParser, flatBufferBuilder);
                } else if (i.equals("short_name")) {
                    iArr[616] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("structured_name")) {
                    iArr[617] = GraphQLNameDeserializer.m5383a(jsonParser, flatBufferBuilder);
                } else if (i.equals("transaction_payment_receipt_display")) {
                    iArr[618] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("page_call_to_action")) {
                    iArr[619] = GraphQLPageCallToActionDeserializer.m5498a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_edit_attachment")) {
                    zArr[169] = true;
                    zArr2[84] = jsonParser.H();
                } else if (i.equals("source_name")) {
                    iArr[621] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("dominant_color")) {
                    iArr[622] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("latest_version")) {
                    iArr[623] = GraphQLInstantArticleVersionDeserializer.m5265a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_full_size")) {
                    zArr[170] = true;
                    iArr2[29] = jsonParser.E();
                } else if (i.equals("visibility")) {
                    zArr[171] = true;
                    enumArr[38] = GraphQLGroupVisibility.fromString(jsonParser.o());
                } else if (i.equals("native_link")) {
                    iArr[626] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("cultural_moment_video")) {
                    iArr[627] = GraphQLVideoDeserializer.m6184a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_report")) {
                    zArr[172] = true;
                    zArr2[85] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(629);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, enumArr[0]);
        }
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        if (zArr[1]) {
            flatBufferBuilder.a(14, jArr[0], 0);
        }
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        if (zArr[2]) {
            flatBufferBuilder.a(25, iArr2[0], 0);
        }
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        flatBufferBuilder.b(29, iArr[29]);
        flatBufferBuilder.b(30, iArr[30]);
        flatBufferBuilder.b(31, iArr[31]);
        flatBufferBuilder.b(32, iArr[32]);
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
        flatBufferBuilder.b(36, iArr[36]);
        flatBufferBuilder.b(37, iArr[37]);
        flatBufferBuilder.b(38, iArr[38]);
        flatBufferBuilder.b(39, iArr[39]);
        flatBufferBuilder.b(40, iArr[40]);
        flatBufferBuilder.b(41, iArr[41]);
        if (zArr[3]) {
            flatBufferBuilder.a(42, iArr2[1], 0);
        }
        flatBufferBuilder.b(43, iArr[43]);
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(46, iArr[46]);
        flatBufferBuilder.b(47, iArr[47]);
        flatBufferBuilder.b(48, iArr[48]);
        if (zArr[4]) {
            flatBufferBuilder.a(49, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(51, iArr[51]);
        flatBufferBuilder.b(52, iArr[52]);
        if (zArr[5]) {
            flatBufferBuilder.a(53, iArr2[2], 0);
        }
        flatBufferBuilder.b(54, iArr[54]);
        flatBufferBuilder.b(55, iArr[55]);
        flatBufferBuilder.b(56, iArr[56]);
        flatBufferBuilder.b(57, iArr[57]);
        if (zArr[6]) {
            flatBufferBuilder.a(58, enumArr[1]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(59, enumArr[2]);
        }
        flatBufferBuilder.b(60, iArr[60]);
        flatBufferBuilder.b(61, iArr[61]);
        flatBufferBuilder.b(62, iArr[62]);
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        flatBufferBuilder.b(65, iArr[65]);
        if (zArr[8]) {
            flatBufferBuilder.a(66, zArr2[0]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(68, zArr2[1]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(69, zArr2[2]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(70, zArr2[3]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(71, zArr2[4]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(72, zArr2[5]);
        }
        if (zArr[14]) {
            flatBufferBuilder.a(73, zArr2[6]);
        }
        if (zArr[15]) {
            flatBufferBuilder.a(74, zArr2[7]);
        }
        if (zArr[16]) {
            flatBufferBuilder.a(75, zArr2[8]);
        }
        if (zArr[17]) {
            flatBufferBuilder.a(76, zArr2[9]);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(77, zArr2[10]);
        }
        if (zArr[19]) {
            flatBufferBuilder.a(78, zArr2[11]);
        }
        if (zArr[20]) {
            flatBufferBuilder.a(79, zArr2[12]);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(80, zArr2[13]);
        }
        if (zArr[22]) {
            flatBufferBuilder.a(81, zArr2[14]);
        }
        if (zArr[23]) {
            flatBufferBuilder.a(82, zArr2[15]);
        }
        if (zArr[24]) {
            flatBufferBuilder.a(83, zArr2[16]);
        }
        if (zArr[25]) {
            flatBufferBuilder.a(84, zArr2[17]);
        }
        if (zArr[26]) {
            flatBufferBuilder.a(85, zArr2[18]);
        }
        if (zArr[27]) {
            flatBufferBuilder.a(86, zArr2[19]);
        }
        if (zArr[28]) {
            flatBufferBuilder.a(87, zArr2[20]);
        }
        if (zArr[29]) {
            flatBufferBuilder.a(88, zArr2[21]);
        }
        if (zArr[30]) {
            flatBufferBuilder.a(89, zArr2[22]);
        }
        if (zArr[31]) {
            flatBufferBuilder.a(90, zArr2[23]);
        }
        if (zArr[32]) {
            flatBufferBuilder.a(91, zArr2[24]);
        }
        if (zArr[33]) {
            flatBufferBuilder.a(92, zArr2[25]);
        }
        flatBufferBuilder.b(93, iArr[93]);
        flatBufferBuilder.b(94, iArr[94]);
        flatBufferBuilder.b(95, iArr[95]);
        flatBufferBuilder.b(96, iArr[96]);
        if (zArr[34]) {
            flatBufferBuilder.a(97, enumArr[3]);
        }
        flatBufferBuilder.b(99, iArr[99]);
        flatBufferBuilder.b(100, iArr[100]);
        flatBufferBuilder.b(101, iArr[101]);
        if (zArr[35]) {
            flatBufferBuilder.a(102, jArr[1], 0);
        }
        flatBufferBuilder.b(103, iArr[103]);
        flatBufferBuilder.b(104, iArr[104]);
        flatBufferBuilder.b(105, iArr[105]);
        if (zArr[36]) {
            flatBufferBuilder.a(106, enumArr[4]);
        }
        if (zArr[37]) {
            flatBufferBuilder.a(107, zArr2[26]);
        }
        if (zArr[38]) {
            flatBufferBuilder.a(108, enumArr[5]);
        }
        if (zArr[39]) {
            flatBufferBuilder.a(109, enumArr[6]);
        }
        flatBufferBuilder.b(110, iArr[110]);
        if (zArr[40]) {
            flatBufferBuilder.a(111, enumArr[7]);
        }
        flatBufferBuilder.b(112, iArr[112]);
        flatBufferBuilder.b(113, iArr[113]);
        if (zArr[41]) {
            flatBufferBuilder.a(114, enumArr[8]);
        }
        flatBufferBuilder.b(115, iArr[115]);
        flatBufferBuilder.b(116, iArr[116]);
        flatBufferBuilder.b(117, iArr[117]);
        if (zArr[42]) {
            flatBufferBuilder.a(118, jArr[2], 0);
        }
        flatBufferBuilder.b(119, iArr[119]);
        if (zArr[43]) {
            flatBufferBuilder.a(120, jArr[3], 0);
        }
        flatBufferBuilder.b(122, iArr[122]);
        flatBufferBuilder.b(123, iArr[123]);
        flatBufferBuilder.b(124, iArr[124]);
        flatBufferBuilder.b(125, iArr[125]);
        flatBufferBuilder.b(126, iArr[126]);
        flatBufferBuilder.b(127, iArr[127]);
        flatBufferBuilder.b(128, iArr[128]);
        flatBufferBuilder.b(129, iArr[129]);
        flatBufferBuilder.b(130, iArr[130]);
        flatBufferBuilder.b(131, iArr[131]);
        flatBufferBuilder.b(132, iArr[132]);
        flatBufferBuilder.b(133, iArr[133]);
        flatBufferBuilder.b(134, iArr[134]);
        flatBufferBuilder.b(135, iArr[135]);
        if (zArr[44]) {
            flatBufferBuilder.a(136, zArr2[27]);
        }
        flatBufferBuilder.b(137, iArr[137]);
        if (zArr[45]) {
            flatBufferBuilder.a(138, dArr[1], 0.0d);
        }
        flatBufferBuilder.b(139, iArr[139]);
        if (zArr[46]) {
            flatBufferBuilder.a(140, zArr2[28]);
        }
        flatBufferBuilder.b(141, iArr[141]);
        if (zArr[47]) {
            flatBufferBuilder.a(142, iArr2[3], 0);
        }
        flatBufferBuilder.b(143, iArr[143]);
        flatBufferBuilder.b(144, iArr[144]);
        flatBufferBuilder.b(145, iArr[145]);
        flatBufferBuilder.b(146, iArr[146]);
        if (zArr[48]) {
            flatBufferBuilder.a(147, jArr[4], 0);
        }
        flatBufferBuilder.b(148, iArr[148]);
        flatBufferBuilder.b(149, iArr[149]);
        flatBufferBuilder.b(150, iArr[150]);
        flatBufferBuilder.b(151, iArr[151]);
        flatBufferBuilder.b(152, iArr[152]);
        flatBufferBuilder.b(153, iArr[153]);
        flatBufferBuilder.b(154, iArr[154]);
        flatBufferBuilder.b(155, iArr[155]);
        flatBufferBuilder.b(156, iArr[156]);
        flatBufferBuilder.b(157, iArr[157]);
        flatBufferBuilder.b(158, iArr[158]);
        flatBufferBuilder.b(159, iArr[159]);
        if (zArr[49]) {
            flatBufferBuilder.a(160, enumArr[9]);
        }
        flatBufferBuilder.b(161, iArr[161]);
        flatBufferBuilder.b(162, iArr[162]);
        if (zArr[50]) {
            flatBufferBuilder.a(163, enumArr[10]);
        }
        flatBufferBuilder.b(164, iArr[164]);
        if (zArr[51]) {
            flatBufferBuilder.a(165, enumArr[11]);
        }
        flatBufferBuilder.b(166, iArr[166]);
        if (zArr[52]) {
            flatBufferBuilder.a(167, enumArr[12]);
        }
        if (zArr[53]) {
            flatBufferBuilder.a(168, jArr[5], 0);
        }
        if (zArr[54]) {
            flatBufferBuilder.a(169, jArr[6], 0);
        }
        flatBufferBuilder.b(170, iArr[170]);
        if (zArr[55]) {
            flatBufferBuilder.a(171, zArr2[29]);
        }
        flatBufferBuilder.b(172, iArr[172]);
        flatBufferBuilder.b(173, iArr[173]);
        flatBufferBuilder.b(174, iArr[174]);
        flatBufferBuilder.b(175, iArr[175]);
        flatBufferBuilder.b(176, iArr[176]);
        flatBufferBuilder.b(177, iArr[177]);
        flatBufferBuilder.b(178, iArr[178]);
        flatBufferBuilder.b(179, iArr[179]);
        if (zArr[56]) {
            flatBufferBuilder.a(180, iArr2[4], 0);
        }
        flatBufferBuilder.b(181, iArr[181]);
        flatBufferBuilder.b(182, iArr[182]);
        flatBufferBuilder.b(183, iArr[183]);
        flatBufferBuilder.b(184, iArr[184]);
        flatBufferBuilder.b(185, iArr[185]);
        flatBufferBuilder.b(186, iArr[186]);
        flatBufferBuilder.b(188, iArr[188]);
        flatBufferBuilder.b(189, iArr[189]);
        flatBufferBuilder.b(190, iArr[190]);
        flatBufferBuilder.b(191, iArr[191]);
        flatBufferBuilder.b(192, iArr[192]);
        flatBufferBuilder.b(193, iArr[193]);
        flatBufferBuilder.b(194, iArr[194]);
        flatBufferBuilder.b(195, iArr[195]);
        flatBufferBuilder.b(196, iArr[196]);
        flatBufferBuilder.b(197, iArr[197]);
        if (zArr[57]) {
            flatBufferBuilder.a(198, enumArr[13]);
        }
        flatBufferBuilder.b(199, iArr[199]);
        flatBufferBuilder.b(200, iArr[200]);
        flatBufferBuilder.b(201, iArr[201]);
        flatBufferBuilder.b(202, iArr[202]);
        flatBufferBuilder.b(203, iArr[203]);
        flatBufferBuilder.b(204, iArr[204]);
        flatBufferBuilder.b(205, iArr[205]);
        flatBufferBuilder.b(206, iArr[206]);
        flatBufferBuilder.b(207, iArr[207]);
        flatBufferBuilder.b(208, iArr[208]);
        flatBufferBuilder.b(209, iArr[209]);
        if (zArr[58]) {
            flatBufferBuilder.a(210, zArr2[30]);
        }
        if (zArr[59]) {
            flatBufferBuilder.a(211, zArr2[31]);
        }
        if (zArr[60]) {
            flatBufferBuilder.a(212, iArr2[5], 0);
        }
        if (zArr[61]) {
            flatBufferBuilder.a(213, iArr2[6], 0);
        }
        flatBufferBuilder.b(214, iArr[214]);
        flatBufferBuilder.b(215, iArr[215]);
        flatBufferBuilder.b(216, iArr[216]);
        flatBufferBuilder.b(217, iArr[217]);
        flatBufferBuilder.b(218, iArr[218]);
        flatBufferBuilder.b(219, iArr[219]);
        flatBufferBuilder.b(220, iArr[220]);
        flatBufferBuilder.b(221, iArr[221]);
        flatBufferBuilder.b(222, iArr[222]);
        flatBufferBuilder.b(223, iArr[223]);
        flatBufferBuilder.b(225, iArr[225]);
        flatBufferBuilder.b(226, iArr[226]);
        if (zArr[62]) {
            flatBufferBuilder.a(227, iArr2[7], 0);
        }
        if (zArr[63]) {
            flatBufferBuilder.a(228, iArr2[8], 0);
        }
        if (zArr[64]) {
            flatBufferBuilder.a(229, iArr2[9], 0);
        }
        flatBufferBuilder.b(230, iArr[230]);
        flatBufferBuilder.b(231, iArr[231]);
        flatBufferBuilder.b(232, iArr[232]);
        if (zArr[65]) {
            flatBufferBuilder.a(233, zArr2[32]);
        }
        if (zArr[66]) {
            flatBufferBuilder.a(234, zArr2[33]);
        }
        if (zArr[67]) {
            flatBufferBuilder.a(235, zArr2[34]);
        }
        if (zArr[68]) {
            flatBufferBuilder.a(236, zArr2[35]);
        }
        if (zArr[69]) {
            flatBufferBuilder.a(237, zArr2[36]);
        }
        if (zArr[70]) {
            flatBufferBuilder.a(238, zArr2[37]);
        }
        if (zArr[71]) {
            flatBufferBuilder.a(239, zArr2[38]);
        }
        if (zArr[72]) {
            flatBufferBuilder.a(240, zArr2[39]);
        }
        if (zArr[73]) {
            flatBufferBuilder.a(241, zArr2[40]);
        }
        if (zArr[74]) {
            flatBufferBuilder.a(242, zArr2[41]);
        }
        if (zArr[75]) {
            flatBufferBuilder.a(243, zArr2[42]);
        }
        if (zArr[76]) {
            flatBufferBuilder.a(244, zArr2[43]);
        }
        if (zArr[77]) {
            flatBufferBuilder.a(245, zArr2[44]);
        }
        if (zArr[78]) {
            flatBufferBuilder.a(246, zArr2[45]);
        }
        if (zArr[79]) {
            flatBufferBuilder.a(247, zArr2[46]);
        }
        if (zArr[80]) {
            flatBufferBuilder.a(248, zArr2[47]);
        }
        if (zArr[81]) {
            flatBufferBuilder.a(249, zArr2[48]);
        }
        if (zArr[82]) {
            flatBufferBuilder.a(250, zArr2[49]);
        }
        if (zArr[83]) {
            flatBufferBuilder.a(252, zArr2[50]);
        }
        if (zArr[84]) {
            flatBufferBuilder.a(253, zArr2[51]);
        }
        if (zArr[85]) {
            flatBufferBuilder.a(254, zArr2[52]);
        }
        if (zArr[86]) {
            flatBufferBuilder.a(255, zArr2[53]);
        }
        if (zArr[87]) {
            flatBufferBuilder.a(256, zArr2[54]);
        }
        if (zArr[88]) {
            flatBufferBuilder.a(257, zArr2[55]);
        }
        if (zArr[89]) {
            flatBufferBuilder.a(258, zArr2[56]);
        }
        if (zArr[90]) {
            flatBufferBuilder.a(259, zArr2[57]);
        }
        flatBufferBuilder.b(260, iArr[260]);
        if (zArr[91]) {
            flatBufferBuilder.a(261, enumArr[14]);
        }
        flatBufferBuilder.b(262, iArr[262]);
        flatBufferBuilder.b(263, iArr[263]);
        flatBufferBuilder.b(264, iArr[264]);
        flatBufferBuilder.b(265, iArr[265]);
        flatBufferBuilder.b(266, iArr[266]);
        flatBufferBuilder.b(267, iArr[267]);
        flatBufferBuilder.b(268, iArr[268]);
        flatBufferBuilder.b(269, iArr[269]);
        flatBufferBuilder.b(270, iArr[270]);
        flatBufferBuilder.b(271, iArr[271]);
        flatBufferBuilder.b(272, iArr[272]);
        if (zArr[92]) {
            flatBufferBuilder.a(273, iArr2[10], 0);
        }
        if (zArr[93]) {
            flatBufferBuilder.a(274, iArr2[11], 0);
        }
        flatBufferBuilder.b(275, iArr[275]);
        flatBufferBuilder.b(276, iArr[276]);
        flatBufferBuilder.b(277, iArr[277]);
        flatBufferBuilder.b(278, iArr[278]);
        if (zArr[94]) {
            flatBufferBuilder.a(279, iArr2[12], 0);
        }
        flatBufferBuilder.b(280, iArr[280]);
        flatBufferBuilder.b(281, iArr[281]);
        flatBufferBuilder.b(282, iArr[282]);
        flatBufferBuilder.b(283, iArr[283]);
        flatBufferBuilder.b(284, iArr[284]);
        flatBufferBuilder.b(285, iArr[285]);
        flatBufferBuilder.b(286, iArr[286]);
        flatBufferBuilder.b(287, iArr[287]);
        flatBufferBuilder.b(288, iArr[288]);
        flatBufferBuilder.b(289, iArr[289]);
        flatBufferBuilder.b(290, iArr[290]);
        if (zArr[95]) {
            flatBufferBuilder.a(292, jArr[7], 0);
        }
        if (zArr[96]) {
            flatBufferBuilder.a(293, enumArr[15]);
        }
        flatBufferBuilder.b(294, iArr[294]);
        flatBufferBuilder.b(295, iArr[295]);
        flatBufferBuilder.b(296, iArr[296]);
        if (zArr[97]) {
            flatBufferBuilder.a(297, enumArr[16]);
        }
        flatBufferBuilder.b(298, iArr[298]);
        flatBufferBuilder.b(299, iArr[299]);
        flatBufferBuilder.b(300, iArr[300]);
        flatBufferBuilder.b(301, iArr[301]);
        flatBufferBuilder.b(302, iArr[302]);
        flatBufferBuilder.b(303, iArr[303]);
        flatBufferBuilder.b(304, iArr[304]);
        flatBufferBuilder.b(305, iArr[305]);
        flatBufferBuilder.b(306, iArr[306]);
        flatBufferBuilder.b(307, iArr[307]);
        flatBufferBuilder.b(308, iArr[308]);
        if (zArr[98]) {
            flatBufferBuilder.a(309, dArr[2], 0.0d);
        }
        flatBufferBuilder.b(310, iArr[310]);
        flatBufferBuilder.b(311, iArr[311]);
        flatBufferBuilder.b(312, iArr[312]);
        flatBufferBuilder.b(313, iArr[313]);
        flatBufferBuilder.b(314, iArr[314]);
        flatBufferBuilder.b(315, iArr[315]);
        if (zArr[99]) {
            flatBufferBuilder.a(316, iArr2[13], 0);
        }
        flatBufferBuilder.b(317, iArr[317]);
        flatBufferBuilder.b(318, iArr[318]);
        flatBufferBuilder.b(319, iArr[319]);
        flatBufferBuilder.b(320, iArr[320]);
        flatBufferBuilder.b(321, iArr[321]);
        flatBufferBuilder.b(322, iArr[322]);
        flatBufferBuilder.b(323, iArr[323]);
        if (zArr[100]) {
            flatBufferBuilder.a(325, enumArr[17]);
        }
        flatBufferBuilder.b(326, iArr[326]);
        flatBufferBuilder.b(327, iArr[327]);
        flatBufferBuilder.b(328, iArr[328]);
        flatBufferBuilder.b(329, iArr[329]);
        flatBufferBuilder.b(330, iArr[330]);
        flatBufferBuilder.b(331, iArr[331]);
        flatBufferBuilder.b(332, iArr[332]);
        flatBufferBuilder.b(333, iArr[333]);
        flatBufferBuilder.b(334, iArr[334]);
        if (zArr[101]) {
            flatBufferBuilder.a(335, enumArr[18]);
        }
        flatBufferBuilder.b(336, iArr[336]);
        if (zArr[102]) {
            flatBufferBuilder.a(337, enumArr[19]);
        }
        flatBufferBuilder.b(338, iArr[338]);
        if (zArr[103]) {
            flatBufferBuilder.a(339, iArr2[14], 0);
        }
        flatBufferBuilder.b(340, iArr[340]);
        flatBufferBuilder.b(341, iArr[341]);
        if (zArr[104]) {
            flatBufferBuilder.a(342, iArr2[15], 0);
        }
        flatBufferBuilder.b(343, iArr[343]);
        flatBufferBuilder.b(344, iArr[344]);
        if (zArr[105]) {
            flatBufferBuilder.a(345, enumArr[20]);
        }
        if (zArr[106]) {
            flatBufferBuilder.a(346, zArr2[58]);
        }
        flatBufferBuilder.b(347, iArr[347]);
        flatBufferBuilder.b(348, iArr[348]);
        flatBufferBuilder.b(349, iArr[349]);
        flatBufferBuilder.b(351, iArr[351]);
        flatBufferBuilder.b(352, iArr[352]);
        flatBufferBuilder.b(353, iArr[353]);
        flatBufferBuilder.b(354, iArr[354]);
        flatBufferBuilder.b(355, iArr[355]);
        flatBufferBuilder.b(356, iArr[356]);
        flatBufferBuilder.b(357, iArr[357]);
        flatBufferBuilder.b(358, iArr[358]);
        flatBufferBuilder.b(359, iArr[359]);
        flatBufferBuilder.b(360, iArr[360]);
        if (zArr[107]) {
            flatBufferBuilder.a(361, enumArr[21]);
        }
        flatBufferBuilder.b(362, iArr[362]);
        flatBufferBuilder.b(363, iArr[363]);
        flatBufferBuilder.b(364, iArr[364]);
        flatBufferBuilder.b(365, iArr[365]);
        flatBufferBuilder.b(366, iArr[366]);
        flatBufferBuilder.b(367, iArr[367]);
        flatBufferBuilder.b(368, iArr[368]);
        flatBufferBuilder.b(369, iArr[369]);
        flatBufferBuilder.b(370, iArr[370]);
        flatBufferBuilder.b(371, iArr[371]);
        flatBufferBuilder.b(372, iArr[372]);
        flatBufferBuilder.b(373, iArr[373]);
        if (zArr[108]) {
            flatBufferBuilder.a(374, zArr2[59]);
        }
        flatBufferBuilder.b(375, iArr[375]);
        flatBufferBuilder.b(376, iArr[376]);
        flatBufferBuilder.b(377, iArr[377]);
        flatBufferBuilder.b(378, iArr[378]);
        flatBufferBuilder.b(379, iArr[379]);
        flatBufferBuilder.b(380, iArr[380]);
        flatBufferBuilder.b(381, iArr[381]);
        flatBufferBuilder.b(382, iArr[382]);
        flatBufferBuilder.b(383, iArr[383]);
        flatBufferBuilder.b(384, iArr[384]);
        flatBufferBuilder.b(385, iArr[385]);
        flatBufferBuilder.b(386, iArr[386]);
        flatBufferBuilder.b(387, iArr[387]);
        flatBufferBuilder.b(388, iArr[388]);
        flatBufferBuilder.b(389, iArr[389]);
        flatBufferBuilder.b(390, iArr[390]);
        flatBufferBuilder.b(391, iArr[391]);
        flatBufferBuilder.b(392, iArr[392]);
        flatBufferBuilder.b(393, iArr[393]);
        flatBufferBuilder.b(394, iArr[394]);
        flatBufferBuilder.b(395, iArr[395]);
        if (zArr[109]) {
            flatBufferBuilder.a(396, enumArr[22]);
        }
        flatBufferBuilder.b(397, iArr[397]);
        flatBufferBuilder.b(398, iArr[398]);
        flatBufferBuilder.b(399, iArr[399]);
        flatBufferBuilder.b(400, iArr[400]);
        flatBufferBuilder.b(401, iArr[401]);
        flatBufferBuilder.b(402, iArr[402]);
        flatBufferBuilder.b(403, iArr[403]);
        flatBufferBuilder.b(404, iArr[404]);
        if (zArr[110]) {
            flatBufferBuilder.a(405, enumArr[23]);
        }
        if (zArr[111]) {
            flatBufferBuilder.a(406, enumArr[24]);
        }
        flatBufferBuilder.b(407, iArr[407]);
        flatBufferBuilder.b(408, iArr[408]);
        if (zArr[112]) {
            flatBufferBuilder.a(409, enumArr[25]);
        }
        flatBufferBuilder.b(410, iArr[410]);
        flatBufferBuilder.b(411, iArr[411]);
        flatBufferBuilder.b(412, iArr[412]);
        flatBufferBuilder.b(413, iArr[413]);
        flatBufferBuilder.b(414, iArr[414]);
        flatBufferBuilder.b(415, iArr[415]);
        flatBufferBuilder.b(416, iArr[416]);
        flatBufferBuilder.b(417, iArr[417]);
        flatBufferBuilder.b(418, iArr[418]);
        flatBufferBuilder.b(419, iArr[419]);
        flatBufferBuilder.b(420, iArr[420]);
        if (zArr[113]) {
            flatBufferBuilder.a(421, enumArr[26]);
        }
        flatBufferBuilder.b(422, iArr[422]);
        flatBufferBuilder.b(423, iArr[423]);
        if (zArr[114]) {
            flatBufferBuilder.a(424, zArr2[60]);
        }
        if (zArr[115]) {
            flatBufferBuilder.a(425, zArr2[61]);
        }
        if (zArr[116]) {
            flatBufferBuilder.a(426, zArr2[62]);
        }
        if (zArr[117]) {
            flatBufferBuilder.a(427, zArr2[63]);
        }
        if (zArr[118]) {
            flatBufferBuilder.a(428, zArr2[64]);
        }
        if (zArr[119]) {
            flatBufferBuilder.a(429, zArr2[65]);
        }
        if (zArr[120]) {
            flatBufferBuilder.a(430, zArr2[66]);
        }
        if (zArr[121]) {
            flatBufferBuilder.a(431, zArr2[67]);
        }
        if (zArr[122]) {
            flatBufferBuilder.a(432, zArr2[68]);
        }
        if (zArr[123]) {
            flatBufferBuilder.a(433, zArr2[69]);
        }
        if (zArr[124]) {
            flatBufferBuilder.a(434, zArr2[70]);
        }
        flatBufferBuilder.b(435, iArr[435]);
        flatBufferBuilder.b(436, iArr[436]);
        flatBufferBuilder.b(437, iArr[437]);
        flatBufferBuilder.b(438, iArr[438]);
        flatBufferBuilder.b(439, iArr[439]);
        flatBufferBuilder.b(440, iArr[440]);
        flatBufferBuilder.b(441, iArr[441]);
        flatBufferBuilder.b(442, iArr[442]);
        if (zArr[125]) {
            flatBufferBuilder.a(443, dArr[3], 0.0d);
        }
        if (zArr[126]) {
            flatBufferBuilder.a(444, dArr[4], 0.0d);
        }
        flatBufferBuilder.b(445, iArr[445]);
        flatBufferBuilder.b(446, iArr[446]);
        if (zArr[127]) {
            flatBufferBuilder.a(447, iArr2[16], 0);
        }
        flatBufferBuilder.b(448, iArr[448]);
        flatBufferBuilder.b(449, iArr[449]);
        flatBufferBuilder.b(450, iArr[450]);
        flatBufferBuilder.b(451, iArr[451]);
        flatBufferBuilder.b(452, iArr[452]);
        if (zArr[128]) {
            flatBufferBuilder.a(453, jArr[8], 0);
        }
        flatBufferBuilder.b(454, iArr[454]);
        flatBufferBuilder.b(455, iArr[455]);
        if (zArr[129]) {
            flatBufferBuilder.a(456, enumArr[27]);
        }
        flatBufferBuilder.b(457, iArr[457]);
        flatBufferBuilder.b(458, iArr[458]);
        flatBufferBuilder.b(459, iArr[459]);
        flatBufferBuilder.b(460, iArr[460]);
        flatBufferBuilder.b(461, iArr[461]);
        if (zArr[130]) {
            flatBufferBuilder.a(462, enumArr[28]);
        }
        flatBufferBuilder.b(463, iArr[463]);
        if (zArr[131]) {
            flatBufferBuilder.a(464, iArr2[17], 0);
        }
        flatBufferBuilder.b(465, iArr[465]);
        flatBufferBuilder.b(466, iArr[466]);
        flatBufferBuilder.b(467, iArr[467]);
        if (zArr[132]) {
            flatBufferBuilder.a(468, enumArr[29]);
        }
        flatBufferBuilder.b(469, iArr[469]);
        flatBufferBuilder.b(470, iArr[470]);
        flatBufferBuilder.b(471, iArr[471]);
        flatBufferBuilder.b(473, iArr[473]);
        flatBufferBuilder.b(474, iArr[474]);
        flatBufferBuilder.b(475, iArr[475]);
        flatBufferBuilder.b(476, iArr[476]);
        flatBufferBuilder.b(477, iArr[477]);
        flatBufferBuilder.b(478, iArr[478]);
        flatBufferBuilder.b(479, iArr[479]);
        flatBufferBuilder.b(480, iArr[480]);
        flatBufferBuilder.b(481, iArr[481]);
        flatBufferBuilder.b(482, iArr[482]);
        flatBufferBuilder.b(483, iArr[483]);
        flatBufferBuilder.b(484, iArr[484]);
        flatBufferBuilder.b(485, iArr[485]);
        flatBufferBuilder.b(486, iArr[486]);
        flatBufferBuilder.b(487, iArr[487]);
        flatBufferBuilder.b(488, iArr[488]);
        flatBufferBuilder.b(489, iArr[489]);
        flatBufferBuilder.b(490, iArr[490]);
        flatBufferBuilder.b(491, iArr[491]);
        flatBufferBuilder.b(492, iArr[492]);
        flatBufferBuilder.b(493, iArr[493]);
        flatBufferBuilder.b(494, iArr[494]);
        flatBufferBuilder.b(495, iArr[495]);
        flatBufferBuilder.b(496, iArr[496]);
        flatBufferBuilder.b(497, iArr[497]);
        flatBufferBuilder.b(498, iArr[498]);
        flatBufferBuilder.b(499, iArr[499]);
        flatBufferBuilder.b(500, iArr[500]);
        flatBufferBuilder.b(501, iArr[501]);
        flatBufferBuilder.b(502, iArr[502]);
        flatBufferBuilder.b(503, iArr[503]);
        flatBufferBuilder.b(504, iArr[504]);
        flatBufferBuilder.b(505, iArr[505]);
        flatBufferBuilder.b(506, iArr[506]);
        flatBufferBuilder.b(507, iArr[507]);
        flatBufferBuilder.b(508, iArr[508]);
        flatBufferBuilder.b(510, iArr[510]);
        if (zArr[133]) {
            flatBufferBuilder.a(511, iArr2[18], 0);
        }
        flatBufferBuilder.b(512, iArr[512]);
        flatBufferBuilder.b(513, iArr[513]);
        flatBufferBuilder.b(514, iArr[514]);
        flatBufferBuilder.b(515, iArr[515]);
        flatBufferBuilder.b(516, iArr[516]);
        if (zArr[134]) {
            flatBufferBuilder.a(517, enumArr[30]);
        }
        flatBufferBuilder.b(518, iArr[518]);
        flatBufferBuilder.b(519, iArr[519]);
        flatBufferBuilder.b(520, iArr[520]);
        flatBufferBuilder.b(521, iArr[521]);
        flatBufferBuilder.b(522, iArr[522]);
        flatBufferBuilder.b(523, iArr[523]);
        flatBufferBuilder.b(524, iArr[524]);
        flatBufferBuilder.b(526, iArr[526]);
        if (zArr[135]) {
            flatBufferBuilder.a(527, iArr2[19], 0);
        }
        if (zArr[136]) {
            flatBufferBuilder.a(528, enumArr[31]);
        }
        if (zArr[137]) {
            flatBufferBuilder.a(529, zArr2[71]);
        }
        if (zArr[138]) {
            flatBufferBuilder.a(530, zArr2[72]);
        }
        flatBufferBuilder.b(531, iArr[531]);
        if (zArr[139]) {
            flatBufferBuilder.a(532, enumArr[32]);
        }
        flatBufferBuilder.b(534, iArr[534]);
        flatBufferBuilder.b(535, iArr[535]);
        if (zArr[140]) {
            flatBufferBuilder.a(536, zArr2[73]);
        }
        flatBufferBuilder.b(537, iArr[537]);
        if (zArr[141]) {
            flatBufferBuilder.a(538, enumArr[33]);
        }
        flatBufferBuilder.b(539, iArr[539]);
        flatBufferBuilder.b(540, iArr[540]);
        if (zArr[142]) {
            flatBufferBuilder.a(541, enumArr[34]);
        }
        flatBufferBuilder.b(542, iArr[542]);
        flatBufferBuilder.b(543, iArr[543]);
        flatBufferBuilder.b(544, iArr[544]);
        flatBufferBuilder.b(545, iArr[545]);
        flatBufferBuilder.b(546, iArr[546]);
        flatBufferBuilder.b(547, iArr[547]);
        flatBufferBuilder.b(548, iArr[548]);
        if (zArr[143]) {
            flatBufferBuilder.a(551, iArr2[20], 0);
        }
        if (zArr[144]) {
            flatBufferBuilder.a(553, enumArr[35]);
        }
        flatBufferBuilder.b(554, iArr[554]);
        if (zArr[145]) {
            flatBufferBuilder.a(555, iArr2[21], 0);
        }
        if (zArr[146]) {
            flatBufferBuilder.a(556, iArr2[22], 0);
        }
        if (zArr[147]) {
            flatBufferBuilder.a(557, enumArr[36]);
        }
        flatBufferBuilder.b(558, iArr[558]);
        flatBufferBuilder.b(559, iArr[559]);
        flatBufferBuilder.b(560, iArr[560]);
        flatBufferBuilder.b(561, iArr[561]);
        flatBufferBuilder.b(562, iArr[562]);
        flatBufferBuilder.b(563, iArr[563]);
        flatBufferBuilder.b(564, iArr[564]);
        if (zArr[148]) {
            flatBufferBuilder.a(565, zArr2[74]);
        }
        if (zArr[149]) {
            flatBufferBuilder.a(566, dArr[5], 0.0d);
        }
        flatBufferBuilder.b(567, iArr[567]);
        if (zArr[150]) {
            flatBufferBuilder.a(568, zArr2[75]);
        }
        flatBufferBuilder.b(569, iArr[569]);
        flatBufferBuilder.b(570, iArr[570]);
        flatBufferBuilder.b(571, iArr[571]);
        flatBufferBuilder.b(572, iArr[572]);
        flatBufferBuilder.b(573, iArr[573]);
        flatBufferBuilder.b(574, iArr[574]);
        flatBufferBuilder.b(575, iArr[575]);
        flatBufferBuilder.b(576, iArr[576]);
        flatBufferBuilder.b(577, iArr[577]);
        flatBufferBuilder.b(578, iArr[578]);
        flatBufferBuilder.b(579, iArr[579]);
        flatBufferBuilder.b(580, iArr[580]);
        flatBufferBuilder.b(581, iArr[581]);
        if (zArr[151]) {
            flatBufferBuilder.a(582, zArr2[76]);
        }
        flatBufferBuilder.b(583, iArr[583]);
        if (zArr[152]) {
            flatBufferBuilder.a(584, zArr2[77]);
        }
        flatBufferBuilder.b(585, iArr[585]);
        flatBufferBuilder.b(586, iArr[586]);
        flatBufferBuilder.b(587, iArr[587]);
        if (zArr[153]) {
            flatBufferBuilder.a(588, iArr2[23], 0);
        }
        flatBufferBuilder.b(589, iArr[589]);
        flatBufferBuilder.b(590, iArr[590]);
        if (zArr[154]) {
            flatBufferBuilder.a(591, dArr[6], 0.0d);
        }
        if (zArr[155]) {
            flatBufferBuilder.a(592, dArr[7], 0.0d);
        }
        flatBufferBuilder.b(593, iArr[593]);
        flatBufferBuilder.b(594, iArr[594]);
        if (zArr[156]) {
            flatBufferBuilder.a(595, jArr[9], 0);
        }
        if (zArr[157]) {
            flatBufferBuilder.a(596, zArr2[78]);
        }
        if (zArr[158]) {
            flatBufferBuilder.a(597, zArr2[79]);
        }
        if (zArr[159]) {
            flatBufferBuilder.a(598, iArr2[24], 0);
        }
        flatBufferBuilder.b(599, iArr[599]);
        if (zArr[160]) {
            flatBufferBuilder.a(600, zArr2[80]);
        }
        if (zArr[161]) {
            flatBufferBuilder.a(601, zArr2[81]);
        }
        if (zArr[162]) {
            flatBufferBuilder.a(602, iArr2[25], 0);
        }
        if (zArr[163]) {
            flatBufferBuilder.a(603, iArr2[26], 0);
        }
        flatBufferBuilder.b(604, iArr[604]);
        if (zArr[164]) {
            flatBufferBuilder.a(605, zArr2[82]);
        }
        if (zArr[165]) {
            flatBufferBuilder.a(606, iArr2[27], 0);
        }
        flatBufferBuilder.b(607, iArr[607]);
        flatBufferBuilder.b(608, iArr[608]);
        flatBufferBuilder.b(609, iArr[609]);
        flatBufferBuilder.b(610, iArr[610]);
        if (zArr[166]) {
            flatBufferBuilder.a(611, enumArr[37]);
        }
        flatBufferBuilder.b(612, iArr[612]);
        if (zArr[167]) {
            flatBufferBuilder.a(613, zArr2[83]);
        }
        if (zArr[168]) {
            flatBufferBuilder.a(614, iArr2[28], 0);
        }
        flatBufferBuilder.b(615, iArr[615]);
        flatBufferBuilder.b(616, iArr[616]);
        flatBufferBuilder.b(617, iArr[617]);
        flatBufferBuilder.b(618, iArr[618]);
        flatBufferBuilder.b(619, iArr[619]);
        if (zArr[169]) {
            flatBufferBuilder.a(620, zArr2[84]);
        }
        flatBufferBuilder.b(621, iArr[621]);
        flatBufferBuilder.b(622, iArr[622]);
        flatBufferBuilder.b(623, iArr[623]);
        if (zArr[170]) {
            flatBufferBuilder.a(624, iArr2[29], 0);
        }
        if (zArr[171]) {
            flatBufferBuilder.a(625, enumArr[38]);
        }
        flatBufferBuilder.b(626, iArr[626]);
        flatBufferBuilder.b(627, iArr[627]);
        if (zArr[172]) {
            flatBufferBuilder.a(628, zArr2[85]);
        }
        return flatBufferBuilder.d();
    }

    public static int m5439b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5436a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5437a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5436a(jsonParser, flatBufferBuilder);
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

    public static void m5438a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5440b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5440b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("accent_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("action_links");
            GraphQLStoryActionLinkDeserializer.m5950a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 3, (short) 0) != (short) 0) {
            jsonGenerator.a("action_style");
            jsonGenerator.b(((GraphQLEventActionStyle) mutableFlatBuffer.a(i, 3, GraphQLEventActionStyle.class)).name());
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("actions");
            GraphQLOpenGraphActionDeserializer.m5459a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("activity_admin_info");
            GraphQLPageAdminInfoDeserializer.m5494a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("actor");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("actors");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("additional_accent_images");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("address");
            GraphQLStreetAddressDeserializer.m5996a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("admin_info");
            GraphQLPageAdminInfoDeserializer.m5494a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("agree_to_privacy_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("aircraft_type_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("album");
            GraphQLAlbumDeserializer.m4551b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        long a = mutableFlatBuffer.a(i, 14, 0);
        if (a != 0) {
            jsonGenerator.a("album_release_date");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("albums");
            GraphQLAlbumsConnectionDeserializer.m4554a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 16);
        if (g != 0) {
            jsonGenerator.a("all_contacts");
            GraphQLPeopleYouMayInviteFeedUnitContactsConnectionDeserializer.m5577a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("all_groups");
            C0243x81539b2b.m5559a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("all_share_stories");
            GraphQLAllShareStoriesConnectionDeserializer.m4560a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("all_stories");
            GraphQLStorySetStoriesConnectionDeserializer.m5987a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("all_substories");
            GraphQLSubstoriesConnectionDeserializer.m6016a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("all_users");
            C0245xd2646133.m5568a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("amount");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("android_app_config");
            GraphQLAndroidAppConfigDeserializer.m4563a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 25, 0);
        if (g != 0) {
            jsonGenerator.a("android_small_screen_phone_threshold");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 26) != 0) {
            jsonGenerator.a("android_store_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 26));
        }
        if (mutableFlatBuffer.g(i, 27) != 0) {
            jsonGenerator.a("android_urls");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 27), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("animated_gif");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("animated_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 30) != 0) {
            jsonGenerator.a("app_center_categories");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 30), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 31);
        if (g != 0) {
            jsonGenerator.a("app_center_cover_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 32);
        if (g != 0) {
            jsonGenerator.a("app_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 33);
        if (g != 0) {
            jsonGenerator.a("app_section_actor");
            GraphQLUserDeserializer.m6152b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("app_section_message");
            jsonGenerator.b(mutableFlatBuffer.c(i, 34));
        }
        if (mutableFlatBuffer.g(i, 35) != 0) {
            jsonGenerator.a("app_section_time_created");
            jsonGenerator.b(mutableFlatBuffer.c(i, 35));
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("app_store_application");
            GraphQLAppStoreApplicationDeserializer.m4575a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 37);
        if (g != 0) {
            jsonGenerator.a("application");
            GraphQLApplicationDeserializer.m4581a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 38) != 0) {
            jsonGenerator.a("application_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 38));
        }
        if (mutableFlatBuffer.g(i, 39) != 0) {
            jsonGenerator.a("arrival_time_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 39));
        }
        if (mutableFlatBuffer.g(i, 40) != 0) {
            jsonGenerator.a("artist_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 40), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 41);
        if (g != 0) {
            jsonGenerator.a("associated_pages");
            GraphQLProfileDeserializer.m5719a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 42, 0);
        if (g != 0) {
            jsonGenerator.a("atom_size");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("attached_action_links");
            GraphQLStoryActionLinkDeserializer.m5950a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("attached_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("attachments");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("attribution");
            GraphQLAttributionEntryDeserializer.m4594a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 47) != 0) {
            jsonGenerator.a("audio_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 47));
        }
        if (mutableFlatBuffer.g(i, 48) != 0) {
            jsonGenerator.a("author_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 48));
        }
        double a2 = mutableFlatBuffer.a(i, 49, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("average_star_rating");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 50) != 0) {
            jsonGenerator.a("base_price_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 50));
        }
        if (mutableFlatBuffer.g(i, 51) != 0) {
            jsonGenerator.a("base_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 51));
        }
        g = mutableFlatBuffer.g(i, 52);
        if (g != 0) {
            jsonGenerator.a("bio_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 53, 0);
        if (g != 0) {
            jsonGenerator.a("bitrate");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 54);
        if (g != 0) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 55) != 0) {
            jsonGenerator.a("boarding_time_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 55));
        }
        if (mutableFlatBuffer.g(i, 56) != 0) {
            jsonGenerator.a("boarding_zone_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 56));
        }
        if (mutableFlatBuffer.g(i, 57) != 0) {
            jsonGenerator.a("booking_number_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 57));
        }
        if (mutableFlatBuffer.a(i, 58, (short) 0) != (short) 0) {
            jsonGenerator.a("broadcast_status");
            jsonGenerator.b(((GraphQLVideoBroadcastStatus) mutableFlatBuffer.a(i, 58, GraphQLVideoBroadcastStatus.class)).name());
        }
        if (mutableFlatBuffer.a(i, 59, (short) 0) != (short) 0) {
            jsonGenerator.a("bubble_type");
            jsonGenerator.b(((GraphQLMessengerCommerceBubbleType) mutableFlatBuffer.a(i, 59, GraphQLMessengerCommerceBubbleType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 60);
        if (g != 0) {
            jsonGenerator.a("business_info");
            GraphQLBusinessInfoDeserializer.m4629a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 61);
        if (g != 0) {
            jsonGenerator.a("bylines");
            GraphQLBylineFragmentDeserializer.m4634a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 62) != 0) {
            jsonGenerator.a("cabin_type_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 62));
        }
        if (mutableFlatBuffer.g(i, 63) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 63));
        }
        g = mutableFlatBuffer.g(i, 64);
        if (g != 0) {
            jsonGenerator.a("campaign");
            GraphQLFundraiserCampaignDeserializer.m4974a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 65) != 0) {
            jsonGenerator.a("campaign_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 65));
        }
        boolean a3 = mutableFlatBuffer.a(i, 66);
        if (a3) {
            jsonGenerator.a("can_guests_invite_friends");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 68);
        if (a3) {
            jsonGenerator.a("can_post_be_moderated");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 69);
        if (a3) {
            jsonGenerator.a("can_see_voice_switcher");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 70);
        if (a3) {
            jsonGenerator.a("can_viewer_add_tags");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 71);
        if (a3) {
            jsonGenerator.a("can_viewer_append_photos");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 72);
        if (a3) {
            jsonGenerator.a("can_viewer_change_availability");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 73);
        if (a3) {
            jsonGenerator.a("can_viewer_change_guest_status");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 74);
        if (a3) {
            jsonGenerator.a("can_viewer_claim");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 75);
        if (a3) {
            jsonGenerator.a("can_viewer_comment");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 76);
        if (a3) {
            jsonGenerator.a("can_viewer_comment_with_photo");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 77);
        if (a3) {
            jsonGenerator.a("can_viewer_comment_with_sticker");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 78);
        if (a3) {
            jsonGenerator.a("can_viewer_comment_with_video");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 79);
        if (a3) {
            jsonGenerator.a("can_viewer_create_post");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 80);
        if (a3) {
            jsonGenerator.a("can_viewer_delete");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 81);
        if (a3) {
            jsonGenerator.a("can_viewer_edit");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 82);
        if (a3) {
            jsonGenerator.a("can_viewer_edit_post_media");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 83);
        if (a3) {
            jsonGenerator.a("can_viewer_edit_post_privacy");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 84);
        if (a3) {
            jsonGenerator.a("can_viewer_edit_tag");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 85);
        if (a3) {
            jsonGenerator.a("can_viewer_get_notification");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 86);
        if (a3) {
            jsonGenerator.a("can_viewer_join");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 87);
        if (a3) {
            jsonGenerator.a("can_viewer_like");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 88);
        if (a3) {
            jsonGenerator.a("can_viewer_message");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 89);
        if (a3) {
            jsonGenerator.a("can_viewer_post");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 90);
        if (a3) {
            jsonGenerator.a("can_viewer_rate");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 91);
        if (a3) {
            jsonGenerator.a("can_viewer_react");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 92);
        if (a3) {
            jsonGenerator.a("can_viewer_subscribe");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 93) != 0) {
            jsonGenerator.a("canvas_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 93));
        }
        if (mutableFlatBuffer.g(i, 94) != 0) {
            jsonGenerator.a("carrier_tracking_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 94));
        }
        if (mutableFlatBuffer.g(i, 95) != 0) {
            jsonGenerator.a("categories");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 95), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 96) != 0) {
            jsonGenerator.a("category_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 96), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 97, (short) 0) != (short) 0) {
            jsonGenerator.a("category_type");
            jsonGenerator.b(((GraphQLPageCategoryType) mutableFlatBuffer.a(i, 97, GraphQLPageCategoryType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 99) != 0) {
            jsonGenerator.a("checkin_cta_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 99));
        }
        if (mutableFlatBuffer.g(i, 100) != 0) {
            jsonGenerator.a("checkin_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 100));
        }
        g = mutableFlatBuffer.g(i, 101);
        if (g != 0) {
            jsonGenerator.a("city");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 102, 0);
        if (a != 0) {
            jsonGenerator.a("claim_time");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 103) != 0) {
            jsonGenerator.a("collection_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 103), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 104);
        if (g != 0) {
            jsonGenerator.a("comments");
            GraphQLCommentsConnectionDeserializer.m4667a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 105) != 0) {
            jsonGenerator.a("comments_mirroring_domain");
            jsonGenerator.b(mutableFlatBuffer.c(i, 105));
        }
        if (mutableFlatBuffer.a(i, 106, (short) 0) != (short) 0) {
            jsonGenerator.a("commerce_checkout_style");
            jsonGenerator.b(((GraphQLCommerceCheckoutStyle) mutableFlatBuffer.a(i, 106, GraphQLCommerceCheckoutStyle.class)).name());
        }
        a3 = mutableFlatBuffer.a(i, 107);
        if (a3) {
            jsonGenerator.a("commerce_featured_item");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.a(i, 108, (short) 0) != (short) 0) {
            jsonGenerator.a("commerce_page_type");
            jsonGenerator.b(((GraphQLCommercePageType) mutableFlatBuffer.a(i, 108, GraphQLCommercePageType.class)).name());
        }
        if (mutableFlatBuffer.a(i, 109, (short) 0) != (short) 0) {
            jsonGenerator.a("commerce_product_visibility");
            jsonGenerator.b(((GraphQLCommerceProductVisibility) mutableFlatBuffer.a(i, 109, GraphQLCommerceProductVisibility.class)).name());
        }
        if (mutableFlatBuffer.g(i, 110) != 0) {
            jsonGenerator.a("concise_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 110));
        }
        if (mutableFlatBuffer.a(i, 111, (short) 0) != (short) 0) {
            jsonGenerator.a("connection_style");
            jsonGenerator.b(((GraphQLConnectionStyle) mutableFlatBuffer.a(i, 111, GraphQLConnectionStyle.class)).name());
        }
        g = mutableFlatBuffer.g(i, 112);
        if (g != 0) {
            jsonGenerator.a("coordinates");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 113) != 0) {
            jsonGenerator.a("copy_right");
            jsonGenerator.b(mutableFlatBuffer.c(i, 113));
        }
        if (mutableFlatBuffer.a(i, 114, (short) 0) != (short) 0) {
            jsonGenerator.a("coupon_claim_location");
            jsonGenerator.b(((GraphQLCouponClaimLocation) mutableFlatBuffer.a(i, 114, GraphQLCouponClaimLocation.class)).name());
        }
        g = mutableFlatBuffer.g(i, 115);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 116) != 0) {
            jsonGenerator.a("cover_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 116));
        }
        g = mutableFlatBuffer.g(i, 117);
        if (g != 0) {
            jsonGenerator.a("created_for_group");
            GraphQLGroupDeserializer.m5159a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 118, 0);
        if (a != 0) {
            jsonGenerator.a("created_time");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 119);
        if (g != 0) {
            jsonGenerator.a("creation_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 120, 0);
        if (a != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 122);
        if (g != 0) {
            jsonGenerator.a("creator");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 123);
        if (g != 0) {
            jsonGenerator.a("cultural_moment_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 124);
        if (g != 0) {
            jsonGenerator.a("current_price");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 125);
        if (g != 0) {
            jsonGenerator.a("data_points");
            GraphQLGoodwillThrowbackDataPointsConnectionDeserializer.m5031a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 126) != 0) {
            jsonGenerator.a("delayed_delivery_time_for_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 126));
        }
        if (mutableFlatBuffer.g(i, 127) != 0) {
            jsonGenerator.a("departure_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 127));
        }
        if (mutableFlatBuffer.g(i, 128) != 0) {
            jsonGenerator.a("departure_time_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 128));
        }
        if (mutableFlatBuffer.g(i, 129) != 0) {
            jsonGenerator.a("description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 129));
        }
        if (mutableFlatBuffer.g(i, 130) != 0) {
            jsonGenerator.a("destination_address");
            jsonGenerator.b(mutableFlatBuffer.c(i, 130));
        }
        g = mutableFlatBuffer.g(i, 131);
        if (g != 0) {
            jsonGenerator.a("destination_location");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 132) != 0) {
            jsonGenerator.a("disclaimer_accept_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 132));
        }
        if (mutableFlatBuffer.g(i, 133) != 0) {
            jsonGenerator.a("disclaimer_continue_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 133));
        }
        if (mutableFlatBuffer.g(i, 134) != 0) {
            jsonGenerator.a("display_duration");
            jsonGenerator.b(mutableFlatBuffer.c(i, 134));
        }
        g = mutableFlatBuffer.g(i, 135);
        if (g != 0) {
            jsonGenerator.a("display_explanation");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a3 = mutableFlatBuffer.a(i, 136);
        if (a3) {
            jsonGenerator.a("display_reactions");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 137) != 0) {
            jsonGenerator.a("display_total");
            jsonGenerator.b(mutableFlatBuffer.c(i, 137));
        }
        a2 = mutableFlatBuffer.a(i, 138, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("distance");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 139) != 0) {
            jsonGenerator.a("distance_unit");
            jsonGenerator.b(mutableFlatBuffer.c(i, 139));
        }
        a3 = mutableFlatBuffer.a(i, 140);
        if (a3) {
            jsonGenerator.a("does_viewer_like");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 141) != 0) {
            jsonGenerator.a("download_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 141));
        }
        g = mutableFlatBuffer.a(i, 142, 0);
        if (g != 0) {
            jsonGenerator.a("duration_ms");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 143);
        if (g != 0) {
            jsonGenerator.a("edit_history");
            GraphQLEditHistoryConnectionDeserializer.m4723a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 144) != 0) {
            jsonGenerator.a("email_addresses");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 144), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 145);
        if (g != 0) {
            jsonGenerator.a("emotional_analysis");
            GraphQLEmotionalAnalysisDeserializer.m4736a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 146);
        if (g != 0) {
            jsonGenerator.a("employer");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 147, 0);
        if (a != 0) {
            jsonGenerator.a("end_timestamp");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 148);
        if (g != 0) {
            jsonGenerator.a("error_codes");
            GraphQLLeadGenErrorNodeDeserializer.m5292a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 149) != 0) {
            jsonGenerator.a("error_message_brief");
            jsonGenerator.b(mutableFlatBuffer.c(i, 149));
        }
        if (mutableFlatBuffer.g(i, 150) != 0) {
            jsonGenerator.a("error_message_detail");
            jsonGenerator.b(mutableFlatBuffer.c(i, 150));
        }
        if (mutableFlatBuffer.g(i, 151) != 0) {
            jsonGenerator.a("estimated_delivery_time_for_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 151));
        }
        g = mutableFlatBuffer.g(i, 152);
        if (g != 0) {
            jsonGenerator.a("eventCategoryLabel");
            GraphQLEventCategoryDataDeserializer.m4775a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 153);
        if (g != 0) {
            jsonGenerator.a("eventProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 154) != 0) {
            jsonGenerator.a("eventUrl");
            jsonGenerator.b(mutableFlatBuffer.c(i, 154));
        }
        g = mutableFlatBuffer.g(i, 155);
        if (g != 0) {
            jsonGenerator.a("event_coordinates");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 156);
        if (g != 0) {
            jsonGenerator.a("event_cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 157);
        if (g != 0) {
            jsonGenerator.a("event_creator");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 158);
        if (g != 0) {
            jsonGenerator.a("event_description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 159);
        if (g != 0) {
            jsonGenerator.a("event_hosts");
            GraphQLEventHostsConnectionDeserializer.m4799a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 160, (short) 0) != (short) 0) {
            jsonGenerator.a("event_kind");
            jsonGenerator.b(((GraphQLEventPrivacyType) mutableFlatBuffer.a(i, 160, GraphQLEventPrivacyType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 161);
        if (g != 0) {
            jsonGenerator.a("event_members");
            GraphQLEventMembersConnectionDeserializer.m4819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 162);
        if (g != 0) {
            jsonGenerator.a("event_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 163, (short) 0) != (short) 0) {
            jsonGenerator.a("event_privacy_type");
            jsonGenerator.b(((GraphQLEventPrivacyType) mutableFlatBuffer.a(i, 163, GraphQLEventPrivacyType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 164) != 0) {
            jsonGenerator.a("event_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 164));
        }
        if (mutableFlatBuffer.a(i, 165, (short) 0) != (short) 0) {
            jsonGenerator.a("event_type");
            jsonGenerator.b(((GraphQLEventType) mutableFlatBuffer.a(i, 165, GraphQLEventType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 166);
        if (g != 0) {
            jsonGenerator.a("event_viewer_capability");
            GraphQLEventViewerCapabilityDeserializer.m4844a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 167, (short) 0) != (short) 0) {
            jsonGenerator.a("event_visibility");
            jsonGenerator.b(((GraphQLEventVisibility) mutableFlatBuffer.a(i, 167, GraphQLEventVisibility.class)).name());
        }
        a = mutableFlatBuffer.a(i, 168, 0);
        if (a != 0) {
            jsonGenerator.a("expiration_date");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 169, 0);
        if (a != 0) {
            jsonGenerator.a("expiration_time");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 170);
        if (g != 0) {
            jsonGenerator.a("explicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a3 = mutableFlatBuffer.a(i, 171);
        if (a3) {
            jsonGenerator.a("expressed_as_place");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 172) != 0) {
            jsonGenerator.a("external_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 172));
        }
        g = mutableFlatBuffer.g(i, 173);
        if (g != 0) {
            jsonGenerator.a("favicon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 174) != 0) {
            jsonGenerator.a("fb_data_policy_setting_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 174));
        }
        if (mutableFlatBuffer.g(i, 175) != 0) {
            jsonGenerator.a("fb_data_policy_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 175));
        }
        g = mutableFlatBuffer.g(i, 176);
        if (g != 0) {
            jsonGenerator.a("feed_topic_content");
            GraphQLFeedTopicContentDeserializer.m4884a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 177);
        if (g != 0) {
            jsonGenerator.a("feed_unit_preview");
            FeedUnitDeserializerResolver.m4504a(mutableFlatBuffer, g, 177, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 178);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 179);
        if (g != 0) {
            jsonGenerator.a("filter_values");
            GraphQLGraphSearchQueryFilterValuesConnectionDeserializer.m5102a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 180, 0);
        if (g != 0) {
            jsonGenerator.a("filtered_claim_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 181) != 0) {
            jsonGenerator.a("first_metaline");
            jsonGenerator.b(mutableFlatBuffer.c(i, 181));
        }
        if (mutableFlatBuffer.g(i, 182) != 0) {
            jsonGenerator.a("flight_date_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 182));
        }
        if (mutableFlatBuffer.g(i, 183) != 0) {
            jsonGenerator.a("flight_gate_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 183));
        }
        if (mutableFlatBuffer.g(i, 184) != 0) {
            jsonGenerator.a("flight_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 184));
        }
        if (mutableFlatBuffer.g(i, 185) != 0) {
            jsonGenerator.a("flight_status_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 185));
        }
        if (mutableFlatBuffer.g(i, 186) != 0) {
            jsonGenerator.a("flight_terminal_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 186));
        }
        if (mutableFlatBuffer.g(i, 188) != 0) {
            jsonGenerator.a("follow_up_action_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 188));
        }
        if (mutableFlatBuffer.g(i, 189) != 0) {
            jsonGenerator.a("follow_up_action_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 189));
        }
        g = mutableFlatBuffer.g(i, 190);
        if (g != 0) {
            jsonGenerator.a("followup_feed_units");
            GraphQLFollowUpFeedUnitsConnectionDeserializer.m4924a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 191) != 0) {
            jsonGenerator.a("formatted_base_price");
            jsonGenerator.b(mutableFlatBuffer.c(i, 191));
        }
        if (mutableFlatBuffer.g(i, 192) != 0) {
            jsonGenerator.a("formatted_tax");
            jsonGenerator.b(mutableFlatBuffer.c(i, 192));
        }
        if (mutableFlatBuffer.g(i, 193) != 0) {
            jsonGenerator.a("formatted_total");
            jsonGenerator.b(mutableFlatBuffer.c(i, 193));
        }
        g = mutableFlatBuffer.g(i, 194);
        if (g != 0) {
            jsonGenerator.a("friendEventMaybesFirst5");
            GraphQLEventMaybesConnectionDeserializer.m4812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 195);
        if (g != 0) {
            jsonGenerator.a("friendEventMembersFirst5");
            GraphQLEventMembersConnectionDeserializer.m4819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 196);
        if (g != 0) {
            jsonGenerator.a("friendEventWatchersFirst5");
            GraphQLEventWatchersConnectionDeserializer.m4847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 197);
        if (g != 0) {
            jsonGenerator.a("friends");
            GraphQLFriendsConnectionDeserializer.m4947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 198, (short) 0) != (short) 0) {
            jsonGenerator.a("friendship_status");
            jsonGenerator.b(((GraphQLFriendshipStatus) mutableFlatBuffer.a(i, 198, GraphQLFriendshipStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 199);
        if (g != 0) {
            jsonGenerator.a("fundraiser_for_charity_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 200);
        if (g != 0) {
            jsonGenerator.a("fundraiser_page");
            GraphQLFundraiserPageDeserializer.m4980a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 201);
        if (g != 0) {
            jsonGenerator.a("global_share");
            GraphQLExternalUrlDeserializer.m4869a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 202);
        if (g != 0) {
            jsonGenerator.a("global_usage_summary_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 203) != 0) {
            jsonGenerator.a("graph_api_write_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 203));
        }
        g = mutableFlatBuffer.g(i, 204);
        if (g != 0) {
            jsonGenerator.a("greeting_card_template");
            GraphQLGreetingCardTemplateDeserializer.m5138a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 205);
        if (g != 0) {
            jsonGenerator.a("group_commerce_item_description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 206);
        if (g != 0) {
            jsonGenerator.a("group_members");
            GraphQLGroupMembersConnectionDeserializer.m5171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 207);
        if (g != 0) {
            jsonGenerator.a("group_owner_authored_stories");
            GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer.m5184a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 208);
        if (g != 0) {
            jsonGenerator.a("group_photorealistic_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 209);
        if (g != 0) {
            jsonGenerator.a("guided_tour");
            GraphQLVideoGuidedTourDeserializer.m6189a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a3 = mutableFlatBuffer.a(i, 210);
        if (a3) {
            jsonGenerator.a("has_comprehensive_title");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 211);
        if (a3) {
            jsonGenerator.a("has_viewer_claimed");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.a(i, 212, 0);
        if (g != 0) {
            jsonGenerator.a("hdAtomSize");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 213, 0);
        if (g != 0) {
            jsonGenerator.a("hdBitrate");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 214) != 0) {
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 214));
        }
        g = mutableFlatBuffer.g(i, 215);
        if (g != 0) {
            jsonGenerator.a("hours");
            GraphQLTimeRangeDeserializer.m6064a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 216) != 0) {
            jsonGenerator.a("html_source");
            jsonGenerator.b(mutableFlatBuffer.c(i, 216));
        }
        g = mutableFlatBuffer.g(i, 217);
        if (g != 0) {
            jsonGenerator.a("icon");
            GraphQLIconDeserializer.m5221a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 218);
        if (g != 0) {
            jsonGenerator.a("iconImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 219) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 219));
        }
        g = mutableFlatBuffer.g(i, 220);
        if (g != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 221);
        if (g != 0) {
            jsonGenerator.a("imageHigh");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 222);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 223) != 0) {
            jsonGenerator.a("image_margin");
            jsonGenerator.b(mutableFlatBuffer.c(i, 223));
        }
        if (mutableFlatBuffer.g(i, 225) != 0) {
            jsonGenerator.a("image_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 225));
        }
        g = mutableFlatBuffer.g(i, 226);
        if (g != 0) {
            jsonGenerator.a("implicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 227, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_heading_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 228, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_pitch_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 229, 0);
        if (g != 0) {
            jsonGenerator.a("initial_view_roll_degrees");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 230);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 231);
        if (g != 0) {
            jsonGenerator.a("insights");
            GraphQLStoryInsightsDeserializer.m5975a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 232);
        if (g != 0) {
            jsonGenerator.a("instant_article");
            GraphQLInstantArticleDeserializer.m5264a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a3 = mutableFlatBuffer.a(i, 233);
        if (a3) {
            jsonGenerator.a("instant_articles_enabled");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 234);
        if (a3) {
            jsonGenerator.a("is_active");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 235);
        if (a3) {
            jsonGenerator.a("is_all_day");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 236);
        if (a3) {
            jsonGenerator.a("is_always_open");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 237);
        if (a3) {
            jsonGenerator.a("is_banned_by_page_viewer");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 238);
        if (a3) {
            jsonGenerator.a("is_canceled");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 239);
        if (a3) {
            jsonGenerator.a("is_current_location");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 240);
        if (a3) {
            jsonGenerator.a("is_disturbing");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 241);
        if (a3) {
            jsonGenerator.a("is_eligible_for_page_verification");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 242);
        if (a3) {
            jsonGenerator.a("is_event_draft");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 243);
        if (a3) {
            jsonGenerator.a("is_expired");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 244);
        if (a3) {
            jsonGenerator.a("is_live_streaming");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 245);
        if (a3) {
            jsonGenerator.a("is_music_item");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 246);
        if (a3) {
            jsonGenerator.a("is_on_sale");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 247);
        if (a3) {
            jsonGenerator.a("is_owned");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 248);
        if (a3) {
            jsonGenerator.a("is_permanently_closed");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 249);
        if (a3) {
            jsonGenerator.a("is_playable");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 250);
        if (a3) {
            jsonGenerator.a("is_privacy_locked");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 252);
        if (a3) {
            jsonGenerator.a("is_service_page");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 253);
        if (a3) {
            jsonGenerator.a("is_sold");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 254);
        if (a3) {
            jsonGenerator.a("is_spherical");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 255);
        if (a3) {
            jsonGenerator.a("is_stopped");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 256);
        if (a3) {
            jsonGenerator.a("is_used");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 257);
        if (a3) {
            jsonGenerator.a("is_verified");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 258);
        if (a3) {
            jsonGenerator.a("is_viewer_notified_about");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 259);
        if (a3) {
            jsonGenerator.a("is_viewer_subscribed");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.g(i, 260);
        if (g != 0) {
            jsonGenerator.a("item_price");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 261, (short) 0) != (short) 0) {
            jsonGenerator.a("item_type");
            jsonGenerator.b(((GraphQLTimelineContactItemType) mutableFlatBuffer.a(i, 261, GraphQLTimelineContactItemType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 262) != 0) {
            jsonGenerator.a("landing_page_cta");
            jsonGenerator.b(mutableFlatBuffer.c(i, 262));
        }
        if (mutableFlatBuffer.g(i, 263) != 0) {
            jsonGenerator.a("landing_page_redirect_instruction");
            jsonGenerator.b(mutableFlatBuffer.c(i, 263));
        }
        g = mutableFlatBuffer.g(i, 264);
        if (g != 0) {
            jsonGenerator.a("lead_gen_data");
            GraphQLLeadGenDataDeserializer.m5285a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 265);
        if (g != 0) {
            jsonGenerator.a("lead_gen_deep_link_user_status");
            GraphQLLeadGenDeepLinkUserStatusDeserializer.m5288a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 266) != 0) {
            jsonGenerator.a("legacy_api_post_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 266));
        }
        if (mutableFlatBuffer.g(i, 267) != 0) {
            jsonGenerator.a("legacy_api_story_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 267));
        }
        g = mutableFlatBuffer.g(i, 268);
        if (g != 0) {
            jsonGenerator.a("like_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 269);
        if (g != 0) {
            jsonGenerator.a("likers");
            GraphQLLikersOfContentConnectionDeserializer.m5320a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 270);
        if (g != 0) {
            jsonGenerator.a("link_media");
            GraphQLMediaDeserializer.m5342b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 271);
        if (g != 0) {
            jsonGenerator.a("list_feed");
            GraphQLFriendListFeedConnectionDeserializer.m4930a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 272) != 0) {
            jsonGenerator.a("list_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 272));
        }
        g = mutableFlatBuffer.a(i, 273, 0);
        if (g != 0) {
            jsonGenerator.a("live_viewer_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 274, 0);
        if (g != 0) {
            jsonGenerator.a("live_viewer_count_read_only");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 275);
        if (g != 0) {
            jsonGenerator.a("location");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 276);
        if (g != 0) {
            jsonGenerator.a("logo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 277);
        if (g != 0) {
            jsonGenerator.a("logo_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 278);
        if (g != 0) {
            jsonGenerator.a("map_points");
            GraphQLLocationDeserializer.m5333a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 279, 0);
        if (g != 0) {
            jsonGenerator.a("map_zoom_level");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 280);
        if (g != 0) {
            jsonGenerator.a("media");
            GraphQLMediaSetMediaConnectionDeserializer.m5360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 281);
        if (g != 0) {
            jsonGenerator.a("media_elements");
            GraphQLSouvenirMediaConnectionDeserializer.m5908a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 282);
        if (g != 0) {
            jsonGenerator.a("media_question_option_order");
            GraphQLMediaQuestionOptionsConnectionDeserializer.m5351a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 283);
        if (g != 0) {
            jsonGenerator.a("media_question_photos");
            GraphQLPhotoDeserializer.m5603a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 284) != 0) {
            jsonGenerator.a("media_question_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 284));
        }
        g = mutableFlatBuffer.g(i, 285);
        if (g != 0) {
            jsonGenerator.a("media_set");
            GraphQLMediaSetDeserializer.m5357a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 286);
        if (g != 0) {
            jsonGenerator.a("menu_info");
            GraphQLPageMenuInfoDeserializer.m5514a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 287);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 288) != 0) {
            jsonGenerator.a("message_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 288));
        }
        if (mutableFlatBuffer.g(i, 289) != 0) {
            jsonGenerator.a("message_permalink");
            jsonGenerator.b(mutableFlatBuffer.c(i, 289));
        }
        g = mutableFlatBuffer.g(i, 290);
        if (g != 0) {
            jsonGenerator.a("messenger_contact");
            GraphQLContactDeserializer.m4679a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 292, 0);
        if (a != 0) {
            jsonGenerator.a("modified_time");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.a(i, 293, (short) 0) != (short) 0) {
            jsonGenerator.a("movie_list_style");
            jsonGenerator.b(((GraphQLMovieBotMovieListStyle) mutableFlatBuffer.a(i, 293, GraphQLMovieBotMovieListStyle.class)).name());
        }
        g = mutableFlatBuffer.g(i, 294);
        if (g != 0) {
            jsonGenerator.a("multiShareAttachmentWithImageFields");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 295);
        if (g != 0) {
            jsonGenerator.a("music_object");
            GraphQLOpenGraphObjectDeserializer.m5469b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 296) != 0) {
            jsonGenerator.a("music_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 296));
        }
        if (mutableFlatBuffer.a(i, 297, (short) 0) != (short) 0) {
            jsonGenerator.a("music_type");
            jsonGenerator.b(((GraphQLMusicType) mutableFlatBuffer.a(i, 297, GraphQLMusicType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 298);
        if (g != 0) {
            jsonGenerator.a("musicians");
            GraphQLOpenGraphObjectDeserializer.m5467a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 299);
        if (g != 0) {
            jsonGenerator.a("mutual_friends");
            GraphQLMutualFriendsConnectionDeserializer.m5382a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 300) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 300));
        }
        g = mutableFlatBuffer.g(i, 301);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 302) != 0) {
            jsonGenerator.a("neighborhood_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 302));
        }
        g = mutableFlatBuffer.g(i, 303);
        if (g != 0) {
            jsonGenerator.a("open_graph_composer_preview");
            GraphQLStoryAttachmentDeserializer.m5957b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 304);
        if (g != 0) {
            jsonGenerator.a("open_graph_metadata");
            GraphQLOpenGraphMetadataDeserializer.m5464a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 305);
        if (g != 0) {
            jsonGenerator.a("open_graph_node");
            m5440b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 306);
        if (g != 0) {
            jsonGenerator.a("options");
            GraphQLQuestionOptionsConnectionDeserializer.m5742a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 307) != 0) {
            jsonGenerator.a("order_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 307));
        }
        if (mutableFlatBuffer.g(i, 308) != 0) {
            jsonGenerator.a("order_payment_method");
            jsonGenerator.b(mutableFlatBuffer.c(i, 308));
        }
        a2 = mutableFlatBuffer.a(i, 309, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("overall_rating");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 310);
        if (g != 0) {
            jsonGenerator.a("overall_star_rating");
            GraphQLRatingDeserializer.m5780a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 311);
        if (g != 0) {
            jsonGenerator.a("owner");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 312);
        if (g != 0) {
            jsonGenerator.a("owning_page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 313);
        if (g != 0) {
            jsonGenerator.a("page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 314);
        if (g != 0) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnectionDeserializer.m5511a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 315) != 0) {
            jsonGenerator.a("page_payment_options");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 315), jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 316, 0);
        if (g != 0) {
            jsonGenerator.a("page_rating");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 317);
        if (g != 0) {
            jsonGenerator.a("parent_group");
            GraphQLGroupDeserializer.m5159a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 318);
        if (g != 0) {
            jsonGenerator.a("partner_logo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 319) != 0) {
            jsonGenerator.a("passenger_name_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 319));
        }
        if (mutableFlatBuffer.g(i, 320) != 0) {
            jsonGenerator.a("passenger_names_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 320));
        }
        if (mutableFlatBuffer.g(i, 321) != 0) {
            jsonGenerator.a("passenger_seat_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 321));
        }
        if (mutableFlatBuffer.g(i, 322) != 0) {
            jsonGenerator.a("payment_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 322));
        }
        if (mutableFlatBuffer.g(i, 323) != 0) {
            jsonGenerator.a("payment_request_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 323));
        }
        if (mutableFlatBuffer.a(i, 325, (short) 0) != (short) 0) {
            jsonGenerator.a("permanently_closed_status");
            jsonGenerator.b(((GraphQLPermanentlyClosedStatus) mutableFlatBuffer.a(i, 325, GraphQLPermanentlyClosedStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 326);
        if (g != 0) {
            jsonGenerator.a("photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 327);
        if (g != 0) {
            jsonGenerator.a("photo_items");
            GraphQLMediaSetMediaConnectionDeserializer.m5360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 328);
        if (g != 0) {
            jsonGenerator.a("photos");
            GraphQLPhotoDeserializer.m5603a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 329);
        if (g != 0) {
            jsonGenerator.a("phrases_analysis");
            GraphQLPhrasesAnalysisDeserializer.m5628a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 330);
        if (g != 0) {
            jsonGenerator.a("pickup_note");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 331);
        if (g != 0) {
            jsonGenerator.a("place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 332);
        if (g != 0) {
            jsonGenerator.a("place_list_items");
            GraphQLCommentPlaceInfoToPlaceListItemsConnectionDeserializer.m4664a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 333) != 0) {
            jsonGenerator.a("place_list_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 333));
        }
        g = mutableFlatBuffer.g(i, 334);
        if (g != 0) {
            jsonGenerator.a("place_open_status");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 335, (short) 0) != (short) 0) {
            jsonGenerator.a("place_open_status_type");
            jsonGenerator.b(((GraphQLPageOpenHoursDisplayDecisionEnum) mutableFlatBuffer.a(i, 335, GraphQLPageOpenHoursDisplayDecisionEnum.class)).name());
        }
        g = mutableFlatBuffer.g(i, 336);
        if (g != 0) {
            jsonGenerator.a("place_recommendation_info");
            GraphQLPlaceRecommendationPostInfoDeserializer.m5662a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 337, (short) 0) != (short) 0) {
            jsonGenerator.a("place_type");
            jsonGenerator.b(((GraphQLPlaceType) mutableFlatBuffer.a(i, 337, GraphQLPlaceType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 338) != 0) {
            jsonGenerator.a("plain_body");
            jsonGenerator.b(mutableFlatBuffer.c(i, 338));
        }
        g = mutableFlatBuffer.a(i, 339, 0);
        if (g != 0) {
            jsonGenerator.a("play_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 340) != 0) {
            jsonGenerator.a("playableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 340));
        }
        if (mutableFlatBuffer.g(i, 341) != 0) {
            jsonGenerator.a("playableUrlRtmpString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 341));
        }
        g = mutableFlatBuffer.a(i, 342, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration_in_ms");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 343) != 0) {
            jsonGenerator.a("playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 343));
        }
        if (mutableFlatBuffer.g(i, 344) != 0) {
            jsonGenerator.a("pnr_number");
            jsonGenerator.b(mutableFlatBuffer.c(i, 344));
        }
        if (mutableFlatBuffer.a(i, 345, (short) 0) != (short) 0) {
            jsonGenerator.a("poll_answers_state");
            jsonGenerator.b(((GraphQLQuestionPollAnswersState) mutableFlatBuffer.a(i, 345, GraphQLQuestionPollAnswersState.class)).name());
        }
        a3 = mutableFlatBuffer.a(i, 346);
        if (a3) {
            jsonGenerator.a("post_approval_required");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.g(i, 347);
        if (g != 0) {
            jsonGenerator.a("post_promotion_info");
            GraphQLBoostedComponentDeserializer.m4613a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 348);
        if (g != 0) {
            jsonGenerator.a("posted_photos");
            GraphQLPostedPhotosConnectionDeserializer.m5687a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 349) != 0) {
            jsonGenerator.a("preferredPlayableUrlString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 349));
        }
        g = mutableFlatBuffer.g(i, 351);
        if (g != 0) {
            jsonGenerator.a("previewTemplateAtPlace");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 352);
        if (g != 0) {
            jsonGenerator.a("previewTemplateNoTags");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 353);
        if (g != 0) {
            jsonGenerator.a("previewTemplateWithPeople");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 354);
        if (g != 0) {
            jsonGenerator.a("previewTemplateWithPeopleAtPlace");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 355);
        if (g != 0) {
            jsonGenerator.a("previewTemplateWithPerson");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 356);
        if (g != 0) {
            jsonGenerator.a("previewTemplateWithPersonAtPlace");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 357);
        if (g != 0) {
            jsonGenerator.a("preview_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 358);
        if (g != 0) {
            jsonGenerator.a("preview_urls");
            GraphQLAudioDeserializer.m4603a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 359) != 0) {
            jsonGenerator.a("price_amount");
            jsonGenerator.b(mutableFlatBuffer.c(i, 359));
        }
        if (mutableFlatBuffer.g(i, 360) != 0) {
            jsonGenerator.a("price_currency");
            jsonGenerator.b(mutableFlatBuffer.c(i, 360));
        }
        if (mutableFlatBuffer.a(i, 361, (short) 0) != (short) 0) {
            jsonGenerator.a("price_type");
            jsonGenerator.b(((GraphQLGroupCommercePriceType) mutableFlatBuffer.a(i, 361, GraphQLGroupCommercePriceType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 362) != 0) {
            jsonGenerator.a("primary_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 362));
        }
        g = mutableFlatBuffer.g(i, 363);
        if (g != 0) {
            jsonGenerator.a("primary_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 364);
        if (g != 0) {
            jsonGenerator.a("primary_object_node");
            m5440b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 365);
        if (g != 0) {
            jsonGenerator.a("privacy_option");
            GraphQLPrivacyOptionDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 366);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 367) != 0) {
            jsonGenerator.a("privacy_setting_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 367));
        }
        g = mutableFlatBuffer.g(i, 368);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 369);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 370);
        if (g != 0) {
            jsonGenerator.a("profilePictureAsCover");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 371);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 372);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 373);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a3 = mutableFlatBuffer.a(i, 374);
        if (a3) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 375) != 0) {
            jsonGenerator.a("progress_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 375));
        }
        if (mutableFlatBuffer.g(i, 376) != 0) {
            jsonGenerator.a("projection_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 376));
        }
        g = mutableFlatBuffer.g(i, 377);
        if (g != 0) {
            jsonGenerator.a("promotion_info");
            GraphQLPagePostPromotionInfoDeserializer.m5520a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 378) != 0) {
            jsonGenerator.a("purchase_summary_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 378));
        }
        g = mutableFlatBuffer.g(i, 379);
        if (g != 0) {
            jsonGenerator.a("quote");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 380);
        if (g != 0) {
            jsonGenerator.a("quotes_analysis");
            GraphQLQuotesAnalysisDeserializer.m5768a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 381);
        if (g != 0) {
            jsonGenerator.a("rating");
            GraphQLRatingDeserializer.m5780a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 382);
        if (g != 0) {
            jsonGenerator.a("reactors");
            GraphQLReactorsOfContentConnectionDeserializer.m5789a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 383) != 0) {
            jsonGenerator.a("receipt_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 383));
        }
        if (mutableFlatBuffer.g(i, 384) != 0) {
            jsonGenerator.a("receipt_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 384));
        }
        g = mutableFlatBuffer.g(i, 385);
        if (g != 0) {
            jsonGenerator.a("receiver");
            GraphQLUserDeserializer.m6152b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 386);
        if (g != 0) {
            jsonGenerator.a("rectangular_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 387) != 0) {
            jsonGenerator.a("redemption_code");
            jsonGenerator.b(mutableFlatBuffer.c(i, 387));
        }
        if (mutableFlatBuffer.g(i, 388) != 0) {
            jsonGenerator.a("redemption_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 388));
        }
        g = mutableFlatBuffer.g(i, 389);
        if (g != 0) {
            jsonGenerator.a("redirection_info");
            GraphQLRedirectionInfoDeserializer.m5801a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 390);
        if (g != 0) {
            jsonGenerator.a("redspace_story");
            GraphQLRedSpaceStoryInfoDeserializer.m5798a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 391);
        if (g != 0) {
            jsonGenerator.a("referenced_sticker");
            GraphQLStickerDeserializer.m5947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 392) != 0) {
            jsonGenerator.a("remixable_photo_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 392));
        }
        g = mutableFlatBuffer.g(i, 393);
        if (g != 0) {
            jsonGenerator.a("represented_profile");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 394);
        if (g != 0) {
            jsonGenerator.a("requestee");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 395);
        if (g != 0) {
            jsonGenerator.a("requester");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 396, (short) 0) != (short) 0) {
            jsonGenerator.a("response_method");
            jsonGenerator.b(((GraphQLQuestionResponseMethod) mutableFlatBuffer.a(i, 396, GraphQLQuestionResponseMethod.class)).name());
        }
        if (mutableFlatBuffer.g(i, 397) != 0) {
            jsonGenerator.a("ride_display_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 397));
        }
        g = mutableFlatBuffer.g(i, 398);
        if (g != 0) {
            jsonGenerator.a("root_share_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 399);
        if (g != 0) {
            jsonGenerator.a("sale_price");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 400);
        if (g != 0) {
            jsonGenerator.a("save_info");
            GraphQLStorySaveInfoDeserializer.m5978a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 401);
        if (g != 0) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollectionDeserializer.m6070b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 402);
        if (g != 0) {
            jsonGenerator.a("school");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 403);
        if (g != 0) {
            jsonGenerator.a("school_class");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 404) != 0) {
            jsonGenerator.a("second_metaline");
            jsonGenerator.b(mutableFlatBuffer.c(i, 404));
        }
        if (mutableFlatBuffer.a(i, 405, (short) 0) != (short) 0) {
            jsonGenerator.a("secondary_subscribe_status");
            jsonGenerator.b(((GraphQLSecondarySubscribeStatus) mutableFlatBuffer.a(i, 405, GraphQLSecondarySubscribeStatus.class)).name());
        }
        if (mutableFlatBuffer.a(i, 406, (short) 0) != (short) 0) {
            jsonGenerator.a("section_type");
            jsonGenerator.b(((GraphQLTimelineAppSectionType) mutableFlatBuffer.a(i, 406, GraphQLTimelineAppSectionType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 407) != 0) {
            jsonGenerator.a("secure_sharing_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 407));
        }
        g = mutableFlatBuffer.g(i, 408);
        if (g != 0) {
            jsonGenerator.a("seen_by");
            GraphQLSeenByConnectionDeserializer.m5879a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 409, (short) 0) != (short) 0) {
            jsonGenerator.a("seen_state");
            jsonGenerator.b(((GraphQLStorySeenState) mutableFlatBuffer.a(i, 409, GraphQLStorySeenState.class)).name());
        }
        if (mutableFlatBuffer.g(i, 410) != 0) {
            jsonGenerator.a("select_text_hint");
            jsonGenerator.b(mutableFlatBuffer.c(i, 410));
        }
        g = mutableFlatBuffer.g(i, 411);
        if (g != 0) {
            jsonGenerator.a("seller");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 412) != 0) {
            jsonGenerator.a("seller_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 412));
        }
        if (mutableFlatBuffer.g(i, 413) != 0) {
            jsonGenerator.a("send_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 413));
        }
        g = mutableFlatBuffer.g(i, 414);
        if (g != 0) {
            jsonGenerator.a("sender");
            GraphQLUserDeserializer.m6152b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 415) != 0) {
            jsonGenerator.a("sent_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 415));
        }
        if (mutableFlatBuffer.g(i, 416) != 0) {
            jsonGenerator.a("service_type_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 416));
        }
        if (mutableFlatBuffer.g(i, 417) != 0) {
            jsonGenerator.a("share_cta_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 417));
        }
        g = mutableFlatBuffer.g(i, 418);
        if (g != 0) {
            jsonGenerator.a("share_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 419);
        if (g != 0) {
            jsonGenerator.a("shareable");
            GraphQLEntityDeserializer.m4766b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 420) != 0) {
            jsonGenerator.a("shipdate_for_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 420));
        }
        if (mutableFlatBuffer.a(i, 421, (short) 0) != (short) 0) {
            jsonGenerator.a("shipment_tracking_event_type");
            jsonGenerator.b(((GraphQLShipmentTrackingEventType) mutableFlatBuffer.a(i, 421, GraphQLShipmentTrackingEventType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 422);
        if (g != 0) {
            jsonGenerator.a("shortSummary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 423) != 0) {
            jsonGenerator.a("short_secure_sharing_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 423));
        }
        a3 = mutableFlatBuffer.a(i, 424);
        if (a3) {
            jsonGenerator.a("should_intercept_delete_post");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 425);
        if (a3) {
            jsonGenerator.a("should_open_single_publisher");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 426);
        if (a3) {
            jsonGenerator.a("should_show_message_button");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 427);
        if (a3) {
            jsonGenerator.a("should_show_recent_activity_entry_point");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 428);
        if (a3) {
            jsonGenerator.a("should_show_recent_checkins_entry_point");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 429);
        if (a3) {
            jsonGenerator.a("should_show_recent_mentions_entry_point");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 430);
        if (a3) {
            jsonGenerator.a("should_show_recent_reviews_entry_point");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 431);
        if (a3) {
            jsonGenerator.a("should_show_recent_shares_entry_point");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 432);
        if (a3) {
            jsonGenerator.a("should_show_reviews_on_profile");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 433);
        if (a3) {
            jsonGenerator.a("show_mark_as_sold_button");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 434);
        if (a3) {
            jsonGenerator.a("skip_experiments");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.g(i, 435);
        if (g != 0) {
            jsonGenerator.a("slides");
            GraphQLGreetingCardSlidesConnectionDeserializer.m5135a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 436) != 0) {
            jsonGenerator.a("snippet");
            jsonGenerator.b(mutableFlatBuffer.c(i, 436));
        }
        g = mutableFlatBuffer.g(i, 437);
        if (g != 0) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 438);
        if (g != 0) {
            jsonGenerator.a("social_usage_summary_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 439);
        if (g != 0) {
            jsonGenerator.a("source");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 440) != 0) {
            jsonGenerator.a("source_address");
            jsonGenerator.b(mutableFlatBuffer.c(i, 440));
        }
        g = mutableFlatBuffer.g(i, 441);
        if (g != 0) {
            jsonGenerator.a("source_location");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 442);
        if (g != 0) {
            jsonGenerator.a("souvenir_cover_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 443, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("sphericalFullscreenAspectRatio");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 444, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("sphericalInlineAspectRatio");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 445) != 0) {
            jsonGenerator.a("sphericalPlayableUrlHdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 445));
        }
        if (mutableFlatBuffer.g(i, 446) != 0) {
            jsonGenerator.a("sphericalPlayableUrlSdString");
            jsonGenerator.b(mutableFlatBuffer.c(i, 446));
        }
        g = mutableFlatBuffer.a(i, 447, 0);
        if (g != 0) {
            jsonGenerator.a("sphericalPreferredFov");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 448) != 0) {
            jsonGenerator.a("split_flow_landing_page_hint_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 448));
        }
        if (mutableFlatBuffer.g(i, 449) != 0) {
            jsonGenerator.a("split_flow_landing_page_hint_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 449));
        }
        g = mutableFlatBuffer.g(i, 450);
        if (g != 0) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 451);
        if (g != 0) {
            jsonGenerator.a("sports_match_data");
            GraphQLSportsDataMatchDataDeserializer.m5926a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 452);
        if (g != 0) {
            jsonGenerator.a("square_logo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 453, 0);
        if (a != 0) {
            jsonGenerator.a("start_timestamp");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 454) != 0) {
            jsonGenerator.a("status");
            jsonGenerator.b(mutableFlatBuffer.c(i, 454));
        }
        if (mutableFlatBuffer.g(i, 455) != 0) {
            jsonGenerator.a("status_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 455));
        }
        if (mutableFlatBuffer.a(i, 456, (short) 0) != (short) 0) {
            jsonGenerator.a("status_type");
            jsonGenerator.b(((GraphQLMessengerRetailItemStatus) mutableFlatBuffer.a(i, 456, GraphQLMessengerRetailItemStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 457);
        if (g != 0) {
            jsonGenerator.a("story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 458);
        if (g != 0) {
            jsonGenerator.a("story_attachment");
            GraphQLStoryAttachmentDeserializer.m5957b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 459);
        if (g != 0) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeaderDeserializer.m5972a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 460);
        if (g != 0) {
            jsonGenerator.a("structured_survey");
            GraphQLStructuredSurveyDeserializer.m6002a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 461) != 0) {
            jsonGenerator.a("submit_card_instruction_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 461));
        }
        if (mutableFlatBuffer.a(i, 462, (short) 0) != (short) 0) {
            jsonGenerator.a("subscribe_status");
            jsonGenerator.b(((GraphQLSubscribeStatus) mutableFlatBuffer.a(i, 462, GraphQLSubscribeStatus.class)).name());
        }
        if (mutableFlatBuffer.g(i, 463) != 0) {
            jsonGenerator.a("substories_grouping_reasons");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 463), jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 464, 0);
        if (g != 0) {
            jsonGenerator.a("substory_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 465);
        if (g != 0) {
            jsonGenerator.a("suffix");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 466);
        if (g != 0) {
            jsonGenerator.a("suggested_event_context_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 467);
        if (g != 0) {
            jsonGenerator.a("summary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 468, (short) 0) != (short) 0) {
            jsonGenerator.a("super_category_type");
            jsonGenerator.b(((GraphQLPageSuperCategoryType) mutableFlatBuffer.a(i, 468, GraphQLPageSuperCategoryType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 469);
        if (g != 0) {
            jsonGenerator.a("supplemental_social_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 470);
        if (g != 0) {
            jsonGenerator.a("supported_reactions");
            GraphQLFeedbackReactionDeserializer.m4899a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 471) != 0) {
            jsonGenerator.a("survey_start_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 471));
        }
        if (mutableFlatBuffer.g(i, 473) != 0) {
            jsonGenerator.a("target_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 473));
        }
        if (mutableFlatBuffer.g(i, 474) != 0) {
            jsonGenerator.a("taxes_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 474));
        }
        if (mutableFlatBuffer.g(i, 475) != 0) {
            jsonGenerator.a("terms");
            jsonGenerator.b(mutableFlatBuffer.c(i, 475));
        }
        if (mutableFlatBuffer.g(i, 476) != 0) {
            jsonGenerator.a("text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 476));
        }
        if (mutableFlatBuffer.g(i, 477) != 0) {
            jsonGenerator.a("theme");
            jsonGenerator.b(mutableFlatBuffer.c(i, 477));
        }
        g = mutableFlatBuffer.g(i, 478);
        if (g != 0) {
            jsonGenerator.a("themeListImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 479);
        if (g != 0) {
            jsonGenerator.a("thirdPartyOwner");
            GraphQLOpenGraphMetadataDeserializer.m5464a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 480) != 0) {
            jsonGenerator.a("third_metaline");
            jsonGenerator.b(mutableFlatBuffer.c(i, 480));
        }
        g = mutableFlatBuffer.g(i, 481);
        if (g != 0) {
            jsonGenerator.a("thread_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 482);
        if (g != 0) {
            jsonGenerator.a("throwback_media");
            GraphQLMediaDeserializer.m5340a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 483);
        if (g != 0) {
            jsonGenerator.a("throwback_media_attachments");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 484);
        if (g != 0) {
            jsonGenerator.a("time_range");
            GraphQLEventTimeRangeDeserializer.m4835a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 485) != 0) {
            jsonGenerator.a("time_range_sentence");
            jsonGenerator.b(mutableFlatBuffer.c(i, 485));
        }
        if (mutableFlatBuffer.g(i, 486) != 0) {
            jsonGenerator.a("timestamp_precise");
            jsonGenerator.b(mutableFlatBuffer.c(i, 486));
        }
        if (mutableFlatBuffer.g(i, 487) != 0) {
            jsonGenerator.a("timezone");
            jsonGenerator.b(mutableFlatBuffer.c(i, 487));
        }
        if (mutableFlatBuffer.g(i, 488) != 0) {
            jsonGenerator.a("tint_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 488));
        }
        g = mutableFlatBuffer.g(i, 489);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 490);
        if (g != 0) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 491);
        if (g != 0) {
            jsonGenerator.a("to");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 492);
        if (g != 0) {
            jsonGenerator.a("top_headline_object");
            m5440b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 493);
        if (g != 0) {
            jsonGenerator.a("top_level_comments");
            GraphQLTopLevelCommentsConnectionDeserializer.m6103a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 494);
        if (g != 0) {
            jsonGenerator.a("top_reactions");
            GraphQLTopReactionsConnectionDeserializer.m6106a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 495);
        if (g != 0) {
            jsonGenerator.a("topic_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 496);
        if (g != 0) {
            jsonGenerator.a("topics_context");
            GraphQLStoryTopicsContextDeserializer.m5990a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 497) != 0) {
            jsonGenerator.a("total");
            jsonGenerator.b(mutableFlatBuffer.c(i, 497));
        }
        if (mutableFlatBuffer.g(i, 498) != 0) {
            jsonGenerator.a("total_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 498));
        }
        if (mutableFlatBuffer.g(i, 499) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 499));
        }
        if (mutableFlatBuffer.g(i, 500) != 0) {
            jsonGenerator.a("tracking_event_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 500));
        }
        if (mutableFlatBuffer.g(i, 501) != 0) {
            jsonGenerator.a("tracking_event_time_for_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 501));
        }
        if (mutableFlatBuffer.g(i, 502) != 0) {
            jsonGenerator.a("tracking_number");
            jsonGenerator.b(mutableFlatBuffer.c(i, 502));
        }
        g = mutableFlatBuffer.g(i, 503);
        if (g != 0) {
            jsonGenerator.a("translatability_for_viewer");
            GraphQLPostTranslatabilityDeserializer.m5684a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 504);
        if (g != 0) {
            jsonGenerator.a("translated_body_for_viewer");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 505);
        if (g != 0) {
            jsonGenerator.a("translated_message_for_viewer");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 506);
        if (g != 0) {
            jsonGenerator.a("translation_metadata");
            GraphQLTranslationMetaDataDeserializer.m6123a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 507);
        if (g != 0) {
            jsonGenerator.a("trending_topic_data");
            GraphQLTrendingTopicDataDeserializer.m6129a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 508) != 0) {
            jsonGenerator.a("trending_topic_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 508));
        }
        if (mutableFlatBuffer.g(i, 510) != 0) {
            jsonGenerator.a("unique_keyword");
            jsonGenerator.b(mutableFlatBuffer.c(i, 510));
        }
        g = mutableFlatBuffer.a(i, 511, 0);
        if (g != 0) {
            jsonGenerator.a("unread_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 512) != 0) {
            jsonGenerator.a("unsubscribe_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 512));
        }
        if (mutableFlatBuffer.g(i, 513) != 0) {
            jsonGenerator.a("update_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 513));
        }
        if (mutableFlatBuffer.g(i, 514) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 514));
        }
        if (mutableFlatBuffer.g(i, 515) != 0) {
            jsonGenerator.a("username");
            jsonGenerator.b(mutableFlatBuffer.c(i, 515));
        }
        g = mutableFlatBuffer.g(i, 516);
        if (g != 0) {
            jsonGenerator.a("value");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 517, (short) 0) != (short) 0) {
            jsonGenerator.a("verification_status");
            jsonGenerator.b(((GraphQLPageVerificationBadge) mutableFlatBuffer.a(i, 517, GraphQLPageVerificationBadge.class)).name());
        }
        g = mutableFlatBuffer.g(i, 518);
        if (g != 0) {
            jsonGenerator.a("via");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 519);
        if (g != 0) {
            jsonGenerator.a("video_channel");
            GraphQLVideoChannelDeserializer.m6178a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 520) != 0) {
            jsonGenerator.a("video_list_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 520));
        }
        if (mutableFlatBuffer.g(i, 521) != 0) {
            jsonGenerator.a("video_list_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 521));
        }
        if (mutableFlatBuffer.g(i, 522) != 0) {
            jsonGenerator.a("view_boarding_pass_cta_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 522));
        }
        if (mutableFlatBuffer.g(i, 523) != 0) {
            jsonGenerator.a("view_details_cta_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 523));
        }
        g = mutableFlatBuffer.g(i, 524);
        if (g != 0) {
            jsonGenerator.a("viewer_acts_as_page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 526);
        if (g != 0) {
            jsonGenerator.a("viewer_does_not_like_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 527, 0);
        if (g != 0) {
            jsonGenerator.a("viewer_feedback_reaction_key");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 528, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_guest_status");
            jsonGenerator.b(((GraphQLEventGuestStatus) mutableFlatBuffer.a(i, 528, GraphQLEventGuestStatus.class)).name());
        }
        a3 = mutableFlatBuffer.a(i, 529);
        if (a3) {
            jsonGenerator.a("viewer_has_pending_invite");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 530);
        if (a3) {
            jsonGenerator.a("viewer_has_voted");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.g(i, 531);
        if (g != 0) {
            jsonGenerator.a("viewer_inviters");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 532, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_join_state");
            jsonGenerator.b(((GraphQLGroupJoinState) mutableFlatBuffer.a(i, 532, GraphQLGroupJoinState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 534);
        if (g != 0) {
            jsonGenerator.a("viewer_likes_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 535) != 0) {
            jsonGenerator.a("viewer_profile_permissions");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 535), jsonGenerator);
        }
        a3 = mutableFlatBuffer.a(i, 536);
        if (a3) {
            jsonGenerator.a("viewer_readstate");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.g(i, 537);
        if (g != 0) {
            jsonGenerator.a("viewer_recommendation");
            GraphQLContactRecommendationFieldDeserializer.m4685a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 538, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 538, GraphQLSavedState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 539);
        if (g != 0) {
            jsonGenerator.a("viewer_timeline_collections_containing");
            GraphQLTimelineAppCollectionDeserializer.m6068a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 540);
        if (g != 0) {
            jsonGenerator.a("viewer_timeline_collections_supported");
            GraphQLTimelineAppCollectionDeserializer.m6068a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 541, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_watch_status");
            jsonGenerator.b(((GraphQLEventWatchStatus) mutableFlatBuffer.a(i, 541, GraphQLEventWatchStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 542);
        if (g != 0) {
            jsonGenerator.a("visibility_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 543) != 0) {
            jsonGenerator.a("websites");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 543), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 544) != 0) {
            jsonGenerator.a("webview_base_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 544));
        }
        g = mutableFlatBuffer.g(i, 545);
        if (g != 0) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnectionDeserializer.m6207a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 546);
        if (g != 0) {
            jsonGenerator.a("work_project");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 547) != 0) {
            jsonGenerator.a("message_cta_label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 547));
        }
        if (mutableFlatBuffer.g(i, 548) != 0) {
            jsonGenerator.a("currency");
            jsonGenerator.b(mutableFlatBuffer.c(i, 548));
        }
        g = mutableFlatBuffer.a(i, 551, 0);
        if (g != 0) {
            jsonGenerator.a("transaction_discount");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 553, (short) 0) != (short) 0) {
            jsonGenerator.a("transaction_status");
            jsonGenerator.b(((GraphQLPageProductTransactionOrderStatusEnum) mutableFlatBuffer.a(i, 553, GraphQLPageProductTransactionOrderStatusEnum.class)).name());
        }
        if (mutableFlatBuffer.g(i, 554) != 0) {
            jsonGenerator.a("transaction_status_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 554));
        }
        g = mutableFlatBuffer.a(i, 555, 0);
        if (g != 0) {
            jsonGenerator.a("transaction_subtotal_cost");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 556, 0);
        if (g != 0) {
            jsonGenerator.a("transaction_total_cost");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 557, (short) 0) != (short) 0) {
            jsonGenerator.a("event_promotion_status");
            jsonGenerator.b(((GraphQLBoostedPostStatus) mutableFlatBuffer.a(i, 557, GraphQLBoostedPostStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 558);
        if (g != 0) {
            jsonGenerator.a("all_sale_groups");
            GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer.m5847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 559);
        if (g != 0) {
            jsonGenerator.a("list_items");
            GraphQLPlaceListItemsFromPlaceListConnectionDeserializer.m5654a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 560);
        if (g != 0) {
            jsonGenerator.a("non_specific_place_to_search");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 561);
        if (g != 0) {
            jsonGenerator.a("charity");
            GraphQLFundraiserCharityDeserializer.m4977a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 562);
        if (g != 0) {
            jsonGenerator.a("header_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 563) != 0) {
            jsonGenerator.a("amount_raised_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 563));
        }
        if (mutableFlatBuffer.g(i, 564) != 0) {
            jsonGenerator.a("campaign_goal_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 564));
        }
        a3 = mutableFlatBuffer.a(i, 565);
        if (a3) {
            jsonGenerator.a("has_goal_amount");
            jsonGenerator.a(a3);
        }
        a2 = mutableFlatBuffer.a(i, 566, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("percent_of_goal_reached");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 567) != 0) {
            jsonGenerator.a("viewer_edit_post_feature_capabilities");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 567), jsonGenerator);
        }
        a3 = mutableFlatBuffer.a(i, 568);
        if (a3) {
            jsonGenerator.a("should_show_username");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.g(i, 569);
        if (g != 0) {
            jsonGenerator.a("big_profile_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 570);
        if (g != 0) {
            jsonGenerator.a("tiny_profile_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 571);
        if (g != 0) {
            jsonGenerator.a("donors");
            GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer.m4986a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 572) != 0) {
            jsonGenerator.a("social_context_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 572));
        }
        g = mutableFlatBuffer.g(i, 573);
        if (g != 0) {
            jsonGenerator.a("parent_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 574);
        if (g != 0) {
            jsonGenerator.a("receipt_image");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 575) != 0) {
            jsonGenerator.a("claim_status");
            jsonGenerator.b(mutableFlatBuffer.c(i, 575));
        }
        if (mutableFlatBuffer.g(i, 576) != 0) {
            jsonGenerator.a("offer_code");
            jsonGenerator.b(mutableFlatBuffer.c(i, 576));
        }
        g = mutableFlatBuffer.g(i, 577);
        if (g != 0) {
            jsonGenerator.a("messenger_content_subscription_option");
            GraphQLMessengerContentSubscriptionOptionDeserializer.m5369a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 578) != 0) {
            jsonGenerator.a("price_range_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 578));
        }
        if (mutableFlatBuffer.g(i, 579) != 0) {
            jsonGenerator.a("query_function");
            jsonGenerator.b(mutableFlatBuffer.c(i, 579));
        }
        if (mutableFlatBuffer.g(i, 580) != 0) {
            jsonGenerator.a("query_role");
            jsonGenerator.b(mutableFlatBuffer.c(i, 580));
        }
        g = mutableFlatBuffer.g(i, 581);
        if (g != 0) {
            jsonGenerator.a("query_title");
            GraphQLGraphSearchQueryTitleDeserializer.m5105a(mutableFlatBuffer, g, jsonGenerator);
        }
        a3 = mutableFlatBuffer.a(i, 582);
        if (a3) {
            jsonGenerator.a("can_viewer_follow");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 583) != 0) {
            jsonGenerator.a("formatted_shipping_address");
            jsonGenerator.b(mutableFlatBuffer.c(i, 583));
        }
        a3 = mutableFlatBuffer.a(i, 584);
        if (a3) {
            jsonGenerator.a("is_viewer_subscribed_to_messenger_content");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.g(i, 585);
        if (g != 0) {
            jsonGenerator.a("feedback_context");
            GraphQLFeedbackContextDeserializer.m4891a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 586) != 0) {
            jsonGenerator.a("buyer_email");
            jsonGenerator.b(mutableFlatBuffer.c(i, 586));
        }
        if (mutableFlatBuffer.g(i, 587) != 0) {
            jsonGenerator.a("buyer_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 587));
        }
        g = mutableFlatBuffer.a(i, 588, 0);
        if (g != 0) {
            jsonGenerator.a("tickets_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 589);
        if (g != 0) {
            jsonGenerator.a("important_reactors");
            GraphQLImportantReactorsConnectionDeserializer.m5233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 590);
        if (g != 0) {
            jsonGenerator.a("viewer_acts_as_person");
            GraphQLUserDeserializer.m6152b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 591, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("product_latitude");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 592, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("product_longitude");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 593) != 0) {
            jsonGenerator.a("video_captions_locales");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 593), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 594) != 0) {
            jsonGenerator.a("accessibility_caption");
            jsonGenerator.b(mutableFlatBuffer.c(i, 594));
        }
        a = mutableFlatBuffer.a(i, 595, 0);
        if (a != 0) {
            jsonGenerator.a("scheduled_publish_timestamp");
            jsonGenerator.a(a);
        }
        a3 = mutableFlatBuffer.a(i, 596);
        if (a3) {
            jsonGenerator.a("has_viewer_viewed");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 597);
        if (a3) {
            jsonGenerator.a("has_viewer_watched_video");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.a(i, 598, 0);
        if (g != 0) {
            jsonGenerator.a("height");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 599);
        if (g != 0) {
            jsonGenerator.a("imageVideoThumbnail");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a3 = mutableFlatBuffer.a(i, 600);
        if (a3) {
            jsonGenerator.a("is_looping");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 601);
        if (a3) {
            jsonGenerator.a("is_video_broadcast");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.a(i, 602, 0);
        if (g != 0) {
            jsonGenerator.a("loop_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 603, 0);
        if (g != 0) {
            jsonGenerator.a("playable_duration");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 604) != 0) {
            jsonGenerator.a("playlist");
            jsonGenerator.b(mutableFlatBuffer.c(i, 604));
        }
        a3 = mutableFlatBuffer.a(i, 605);
        if (a3) {
            jsonGenerator.a("supports_time_slices");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.a(i, 606, 0);
        if (g != 0) {
            jsonGenerator.a("width");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 607) != 0) {
            jsonGenerator.a("locally_updated_containing_collection_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 607));
        }
        g = mutableFlatBuffer.g(i, 608);
        if (g != 0) {
            jsonGenerator.a("profile_video");
            GraphQLProfileVideoDeserializer.m5724a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 609);
        if (g != 0) {
            jsonGenerator.a("message_markdown_html");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 610) != 0) {
            jsonGenerator.a("ad_preview_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 610));
        }
        if (mutableFlatBuffer.a(i, 611, (short) 0) != (short) 0) {
            jsonGenerator.a("ad_sharing_status");
            jsonGenerator.b(((GraphQLAdsExperienceStatusEnum) mutableFlatBuffer.a(i, 611, GraphQLAdsExperienceStatusEnum.class)).name());
        }
        if (mutableFlatBuffer.g(i, 612) != 0) {
            jsonGenerator.a("experimental_freeform_price");
            jsonGenerator.b(mutableFlatBuffer.c(i, 612));
        }
        a3 = mutableFlatBuffer.a(i, 613);
        if (a3) {
            jsonGenerator.a("notifications_enabled");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.a(i, 614, 0);
        if (g != 0) {
            jsonGenerator.a("estimated_results");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 615);
        if (g != 0) {
            jsonGenerator.a("pending_places_for_attachment");
            GraphQLPageDeserializer.m5503a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 616) != 0) {
            jsonGenerator.a("short_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 616));
        }
        g = mutableFlatBuffer.g(i, 617);
        if (g != 0) {
            jsonGenerator.a("structured_name");
            GraphQLNameDeserializer.m5387b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 618) != 0) {
            jsonGenerator.a("transaction_payment_receipt_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 618));
        }
        g = mutableFlatBuffer.g(i, 619);
        if (g != 0) {
            jsonGenerator.a("page_call_to_action");
            GraphQLPageCallToActionDeserializer.m5500a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a3 = mutableFlatBuffer.a(i, 620);
        if (a3) {
            jsonGenerator.a("can_viewer_edit_attachment");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 621) != 0) {
            jsonGenerator.a("source_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 621));
        }
        if (mutableFlatBuffer.g(i, 622) != 0) {
            jsonGenerator.a("dominant_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 622));
        }
        g = mutableFlatBuffer.g(i, 623);
        if (g != 0) {
            jsonGenerator.a("latest_version");
            GraphQLInstantArticleVersionDeserializer.m5267a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 624, 0);
        if (g != 0) {
            jsonGenerator.a("video_full_size");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 625, (short) 0) != (short) 0) {
            jsonGenerator.a("visibility");
            jsonGenerator.b(((GraphQLGroupVisibility) mutableFlatBuffer.a(i, 625, GraphQLGroupVisibility.class)).name());
        }
        if (mutableFlatBuffer.g(i, 626) != 0) {
            jsonGenerator.a("native_link");
            jsonGenerator.b(mutableFlatBuffer.c(i, 626));
        }
        g = mutableFlatBuffer.g(i, 627);
        if (g != 0) {
            jsonGenerator.a("cultural_moment_video");
            GraphQLVideoDeserializer.m6186a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a3 = mutableFlatBuffer.a(i, 628);
        if (a3) {
            jsonGenerator.a("can_viewer_report");
            jsonGenerator.a(a3);
        }
        jsonGenerator.g();
    }
}
