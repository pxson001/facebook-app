package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventNotificationSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventType;
import com.facebook.graphql.enums.GraphQLEventVisibility;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: pb_event */
public class GraphQLEventDeserializer {
    public static int m4792a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[130];
        boolean[] zArr = new boolean[40];
        boolean[] zArr2 = new boolean[19];
        int[] iArr2 = new int[5];
        long[] jArr = new long[4];
        Enum[] enumArr = new Enum[12];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("action_style")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLEventActionStyle.fromString(jsonParser.o());
                } else if (i.equals("album")) {
                    iArr[1] = GraphQLAlbumDeserializer.m4549a(jsonParser, flatBufferBuilder);
                } else if (i.equals("allEventDeclines")) {
                    iArr[2] = GraphQLEventDeclinesConnectionDeserializer.m4785a(jsonParser, flatBufferBuilder);
                } else if (i.equals("allEventMaybes")) {
                    iArr[3] = GraphQLEventMaybesConnectionDeserializer.m4810a(jsonParser, flatBufferBuilder);
                } else if (i.equals("allEventMembers")) {
                    iArr[4] = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attending_activity")) {
                    iArr[5] = GraphQLInlineActivityDeserializer.m5247a(jsonParser, flatBufferBuilder);
                } else if (i.equals("blurredCoverPhoto")) {
                    iArr[6] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("boostable_story")) {
                    iArr[7] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_guests_invite_friends")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_post_be_moderated")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_view_members")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_change_guest_status")) {
                    zArr[4] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_create_post")) {
                    zArr[5] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_join")) {
                    zArr[6] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_message")) {
                    zArr[7] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("can_viewer_post")) {
                    zArr[8] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("category_icon")) {
                    iArr[16] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("connection_style")) {
                    zArr[9] = true;
                    enumArr[1] = GraphQLConnectionStyle.fromString(jsonParser.o());
                } else if (i.equals("contextual_name")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("cover_photo")) {
                    iArr[19] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("created_for_group")) {
                    iArr[20] = GraphQLGroupDeserializer.m5157a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creation_story")) {
                    iArr[21] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creation_time")) {
                    zArr[10] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("end_timestamp")) {
                    zArr[11] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("eventCategoryLabel")) {
                    iArr[24] = GraphQLEventCategoryDataDeserializer.m4773a(jsonParser, flatBufferBuilder);
                } else if (i.equals("eventProfilePicture")) {
                    iArr[25] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("eventUrl")) {
                    iArr[26] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event_buy_ticket_display_url")) {
                    iArr[27] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event_buy_ticket_url")) {
                    iArr[28] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event_category_info")) {
                    iArr[29] = GraphQLEventCategoryDataDeserializer.m4773a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_cover_photo")) {
                    iArr[30] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_creator")) {
                    iArr[31] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_declines")) {
                    iArr[32] = GraphQLEventDeclinesConnectionDeserializer.m4785a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_description")) {
                    iArr[33] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_hosts")) {
                    iArr[34] = GraphQLEventHostsConnectionDeserializer.m4797a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_invitees")) {
                    iArr[35] = GraphQLEventInviteesConnectionDeserializer.m4803a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_kind")) {
                    zArr[12] = true;
                    enumArr[2] = GraphQLEventPrivacyType.fromString(jsonParser.o());
                } else if (i.equals("event_maybes")) {
                    iArr[37] = GraphQLEventMaybesConnectionDeserializer.m4810a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_members")) {
                    iArr[38] = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_place")) {
                    iArr[39] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_privacy_type")) {
                    zArr[13] = true;
                    enumArr[3] = GraphQLEventPrivacyType.fromString(jsonParser.o());
                } else if (i.equals("event_ticket_provider_name")) {
                    iArr[41] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event_type")) {
                    zArr[14] = true;
                    enumArr[4] = GraphQLEventType.fromString(jsonParser.o());
                } else if (i.equals("event_user_location_shares_count")) {
                    zArr[15] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("event_user_location_shares_start_interval")) {
                    zArr[16] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("event_viewer_capability")) {
                    iArr[45] = GraphQLEventViewerCapabilityDeserializer.m4842a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_visibility")) {
                    zArr[17] = true;
                    enumArr[5] = GraphQLEventVisibility.fromString(jsonParser.o());
                } else if (i.equals("event_watchers")) {
                    iArr[47] = GraphQLEventWatchersConnectionDeserializer.m4845a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[48] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventDeclines")) {
                    iArr[49] = GraphQLEventDeclinesConnectionDeserializer.m4785a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventInvitees")) {
                    iArr[50] = GraphQLEventInviteesConnectionDeserializer.m4803a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventInviteesFirst5")) {
                    iArr[51] = GraphQLEventInviteesConnectionDeserializer.m4803a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventMaybes")) {
                    iArr[52] = GraphQLEventMaybesConnectionDeserializer.m4810a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventMaybesFirst5")) {
                    iArr[53] = GraphQLEventMaybesConnectionDeserializer.m4810a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventMembers")) {
                    iArr[54] = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventMembersFirst5")) {
                    iArr[55] = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventWatchers")) {
                    iArr[56] = GraphQLEventWatchersConnectionDeserializer.m4845a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendEventWatchersFirst5")) {
                    iArr[57] = GraphQLEventWatchersConnectionDeserializer.m4845a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends_going")) {
                    iArr[58] = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends_interested")) {
                    iArr[59] = GraphQLEventWatchersConnectionDeserializer.m4845a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends_invited")) {
                    iArr[60] = GraphQLEventInviteesConnectionDeserializer.m4803a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[62] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("imageHighOrig")) {
                    iArr[63] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[64] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_all_day")) {
                    zArr[18] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("is_canceled")) {
                    zArr[19] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("is_event_draft")) {
                    zArr[20] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("is_message_blocked_by_viewer")) {
                    zArr[21] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("is_privacy_locked")) {
                    zArr[22] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("live_permalink_time_range_sentence")) {
                    iArr[71] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("location")) {
                    iArr[72] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("map_bounding_box")) {
                    iArr[73] = GraphQLGeoRectangleDeserializer.m4993a(jsonParser, flatBufferBuilder);
                } else if (i.equals("map_zoom_level")) {
                    zArr[23] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("name")) {
                    iArr[75] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name_search_tokens")) {
                    iArr[76] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("open_graph_composer_preview")) {
                    iArr[77] = GraphQLStoryAttachmentDeserializer.m5953a(jsonParser, flatBufferBuilder);
                } else if (i.equals("otherEventDeclines")) {
                    iArr[78] = GraphQLEventDeclinesConnectionDeserializer.m4785a(jsonParser, flatBufferBuilder);
                } else if (i.equals("otherEventInvitees")) {
                    iArr[79] = GraphQLEventInviteesConnectionDeserializer.m4803a(jsonParser, flatBufferBuilder);
                } else if (i.equals("otherEventMaybes")) {
                    iArr[80] = GraphQLEventMaybesConnectionDeserializer.m4810a(jsonParser, flatBufferBuilder);
                } else if (i.equals("otherEventMembers")) {
                    iArr[81] = GraphQLEventMembersConnectionDeserializer.m4817a(jsonParser, flatBufferBuilder);
                } else if (i.equals("otherEventWatchers")) {
                    iArr[82] = GraphQLEventWatchersConnectionDeserializer.m4845a(jsonParser, flatBufferBuilder);
                } else if (i.equals("parent_group")) {
                    iArr[83] = GraphQLGroupDeserializer.m5157a(jsonParser, flatBufferBuilder);
                } else if (i.equals("pending_post_count")) {
                    zArr[24] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("placeProfilePicture")) {
                    iArr[85] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_topic_id")) {
                    iArr[86] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("place_type")) {
                    zArr[25] = true;
                    enumArr[6] = GraphQLPlaceType.fromString(jsonParser.o());
                } else if (i.equals("post_approval_required")) {
                    zArr[26] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("posted_item_privacy_scope")) {
                    iArr[89] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_scope")) {
                    iArr[90] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageLarge")) {
                    iArr[91] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[92] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[93] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[94] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[95] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[96] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_large")) {
                    iArr[97] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_medium")) {
                    iArr[98] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_small")) {
                    iArr[99] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[100] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[27] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("saved_collection")) {
                    iArr[102] = GraphQLTimelineAppCollectionDeserializer.m6066a(jsonParser, flatBufferBuilder);
                } else if (i.equals("social_context")) {
                    iArr[103] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("start_time_sentence")) {
                    iArr[104] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("start_timestamp")) {
                    zArr[28] = true;
                    jArr[2] = jsonParser.F();
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[106] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("suggested_event_context_sentence")) {
                    iArr[107] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("supports_event_stories")) {
                    zArr[29] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[109] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("time_range")) {
                    iArr[110] = GraphQLEventTimeRangeDeserializer.m4833a(jsonParser, flatBufferBuilder);
                } else if (i.equals("time_range_sentence")) {
                    iArr[111] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("timezone")) {
                    iArr[112] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("unread_count")) {
                    zArr[30] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("url")) {
                    iArr[114] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("username")) {
                    iArr[115] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_guest_status")) {
                    zArr[31] = true;
                    enumArr[7] = GraphQLEventGuestStatus.fromString(jsonParser.o());
                } else if (i.equals("viewer_has_pending_invite")) {
                    zArr[32] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("viewer_inviters")) {
                    iArr[118] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_notification_subscription_level")) {
                    zArr[33] = true;
                    enumArr[8] = GraphQLEventNotificationSubscriptionLevel.fromString(jsonParser.o());
                } else if (i.equals("viewer_saved_state")) {
                    zArr[34] = true;
                    enumArr[9] = GraphQLSavedState.fromString(jsonParser.o());
                } else if (i.equals("viewer_timeline_collections_containing")) {
                    iArr[121] = GraphQLTimelineAppCollectionDeserializer.m6069b(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_timeline_collections_supported")) {
                    iArr[122] = GraphQLTimelineAppCollectionDeserializer.m6069b(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_watch_status")) {
                    zArr[35] = true;
                    enumArr[10] = GraphQLEventWatchStatus.fromString(jsonParser.o());
                } else if (i.equals("event_promotion_status")) {
                    zArr[36] = true;
                    enumArr[11] = GraphQLBoostedPostStatus.fromString(jsonParser.o());
                } else if (i.equals("is_official")) {
                    zArr[37] = true;
                    zArr2[17] = jsonParser.H();
                } else if (i.equals("scheduled_publish_timestamp")) {
                    zArr[38] = true;
                    jArr[3] = jsonParser.F();
                } else if (i.equals("can_viewer_purchase_onsite_tickets")) {
                    zArr[39] = true;
                    zArr2[18] = jsonParser.H();
                } else if (i.equals("event_ticket_provider")) {
                    iArr[129] = GraphQLEventTicketProviderDeserializer.m4830a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(130);
        if (zArr[0]) {
            flatBufferBuilder.a(0, enumArr[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[1]) {
            flatBufferBuilder.a(8, zArr2[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(9, zArr2[1]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(10, zArr2[2]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(11, zArr2[3]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(12, zArr2[4]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(13, zArr2[5]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(14, zArr2[6]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(15, zArr2[7]);
        }
        flatBufferBuilder.b(16, iArr[16]);
        if (zArr[9]) {
            flatBufferBuilder.a(17, enumArr[1]);
        }
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        if (zArr[10]) {
            flatBufferBuilder.a(22, jArr[0], 0);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(23, jArr[1], 0);
        }
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
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
        if (zArr[12]) {
            flatBufferBuilder.a(36, enumArr[2]);
        }
        flatBufferBuilder.b(37, iArr[37]);
        flatBufferBuilder.b(38, iArr[38]);
        flatBufferBuilder.b(39, iArr[39]);
        if (zArr[13]) {
            flatBufferBuilder.a(40, enumArr[3]);
        }
        flatBufferBuilder.b(41, iArr[41]);
        if (zArr[14]) {
            flatBufferBuilder.a(42, enumArr[4]);
        }
        if (zArr[15]) {
            flatBufferBuilder.a(43, iArr2[0], 0);
        }
        if (zArr[16]) {
            flatBufferBuilder.a(44, iArr2[1], 0);
        }
        flatBufferBuilder.b(45, iArr[45]);
        if (zArr[17]) {
            flatBufferBuilder.a(46, enumArr[5]);
        }
        flatBufferBuilder.b(47, iArr[47]);
        flatBufferBuilder.b(48, iArr[48]);
        flatBufferBuilder.b(49, iArr[49]);
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(51, iArr[51]);
        flatBufferBuilder.b(52, iArr[52]);
        flatBufferBuilder.b(53, iArr[53]);
        flatBufferBuilder.b(54, iArr[54]);
        flatBufferBuilder.b(55, iArr[55]);
        flatBufferBuilder.b(56, iArr[56]);
        flatBufferBuilder.b(57, iArr[57]);
        flatBufferBuilder.b(58, iArr[58]);
        flatBufferBuilder.b(59, iArr[59]);
        flatBufferBuilder.b(60, iArr[60]);
        flatBufferBuilder.b(62, iArr[62]);
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        if (zArr[18]) {
            flatBufferBuilder.a(65, zArr2[8]);
        }
        if (zArr[19]) {
            flatBufferBuilder.a(66, zArr2[9]);
        }
        if (zArr[20]) {
            flatBufferBuilder.a(67, zArr2[10]);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(68, zArr2[11]);
        }
        if (zArr[22]) {
            flatBufferBuilder.a(69, zArr2[12]);
        }
        flatBufferBuilder.b(71, iArr[71]);
        flatBufferBuilder.b(72, iArr[72]);
        flatBufferBuilder.b(73, iArr[73]);
        if (zArr[23]) {
            flatBufferBuilder.a(74, iArr2[2], 0);
        }
        flatBufferBuilder.b(75, iArr[75]);
        flatBufferBuilder.b(76, iArr[76]);
        flatBufferBuilder.b(77, iArr[77]);
        flatBufferBuilder.b(78, iArr[78]);
        flatBufferBuilder.b(79, iArr[79]);
        flatBufferBuilder.b(80, iArr[80]);
        flatBufferBuilder.b(81, iArr[81]);
        flatBufferBuilder.b(82, iArr[82]);
        flatBufferBuilder.b(83, iArr[83]);
        if (zArr[24]) {
            flatBufferBuilder.a(84, iArr2[3], 0);
        }
        flatBufferBuilder.b(85, iArr[85]);
        flatBufferBuilder.b(86, iArr[86]);
        if (zArr[25]) {
            flatBufferBuilder.a(87, enumArr[6]);
        }
        if (zArr[26]) {
            flatBufferBuilder.a(88, zArr2[13]);
        }
        flatBufferBuilder.b(89, iArr[89]);
        flatBufferBuilder.b(90, iArr[90]);
        flatBufferBuilder.b(91, iArr[91]);
        flatBufferBuilder.b(92, iArr[92]);
        flatBufferBuilder.b(93, iArr[93]);
        flatBufferBuilder.b(94, iArr[94]);
        flatBufferBuilder.b(95, iArr[95]);
        flatBufferBuilder.b(96, iArr[96]);
        flatBufferBuilder.b(97, iArr[97]);
        flatBufferBuilder.b(98, iArr[98]);
        flatBufferBuilder.b(99, iArr[99]);
        flatBufferBuilder.b(100, iArr[100]);
        if (zArr[27]) {
            flatBufferBuilder.a(101, zArr2[14]);
        }
        flatBufferBuilder.b(102, iArr[102]);
        flatBufferBuilder.b(103, iArr[103]);
        flatBufferBuilder.b(104, iArr[104]);
        if (zArr[28]) {
            flatBufferBuilder.a(105, jArr[2], 0);
        }
        flatBufferBuilder.b(106, iArr[106]);
        flatBufferBuilder.b(107, iArr[107]);
        if (zArr[29]) {
            flatBufferBuilder.a(108, zArr2[15]);
        }
        flatBufferBuilder.b(109, iArr[109]);
        flatBufferBuilder.b(110, iArr[110]);
        flatBufferBuilder.b(111, iArr[111]);
        flatBufferBuilder.b(112, iArr[112]);
        if (zArr[30]) {
            flatBufferBuilder.a(113, iArr2[4], 0);
        }
        flatBufferBuilder.b(114, iArr[114]);
        flatBufferBuilder.b(115, iArr[115]);
        if (zArr[31]) {
            flatBufferBuilder.a(116, enumArr[7]);
        }
        if (zArr[32]) {
            flatBufferBuilder.a(117, zArr2[16]);
        }
        flatBufferBuilder.b(118, iArr[118]);
        if (zArr[33]) {
            flatBufferBuilder.a(119, enumArr[8]);
        }
        if (zArr[34]) {
            flatBufferBuilder.a(120, enumArr[9]);
        }
        flatBufferBuilder.b(121, iArr[121]);
        flatBufferBuilder.b(122, iArr[122]);
        if (zArr[35]) {
            flatBufferBuilder.a(123, enumArr[10]);
        }
        if (zArr[36]) {
            flatBufferBuilder.a(124, enumArr[11]);
        }
        if (zArr[37]) {
            flatBufferBuilder.a(125, zArr2[17]);
        }
        if (zArr[38]) {
            flatBufferBuilder.a(127, jArr[3], 0);
        }
        if (zArr[39]) {
            flatBufferBuilder.a(128, zArr2[18]);
        }
        flatBufferBuilder.b(129, iArr[129]);
        return flatBufferBuilder.d();
    }

    public static int m4795b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m4792a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m4793a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4792a(jsonParser, flatBufferBuilder);
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

    public static void m4794a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m4796b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m4796b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.a(i, 0, (short) 0) != (short) 0) {
            jsonGenerator.a("action_style");
            jsonGenerator.b(((GraphQLEventActionStyle) mutableFlatBuffer.a(i, 0, GraphQLEventActionStyle.class)).name());
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("album");
            GraphQLAlbumDeserializer.m4551b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("allEventDeclines");
            GraphQLEventDeclinesConnectionDeserializer.m4787a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("allEventMaybes");
            GraphQLEventMaybesConnectionDeserializer.m4812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("allEventMembers");
            GraphQLEventMembersConnectionDeserializer.m4819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("attending_activity");
            GraphQLInlineActivityDeserializer.m5249b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("boostable_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("can_guests_invite_friends");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 9);
        if (a) {
            jsonGenerator.a("can_post_be_moderated");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 10);
        if (a) {
            jsonGenerator.a("can_view_members");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("can_viewer_change_guest_status");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 12);
        if (a) {
            jsonGenerator.a("can_viewer_create_post");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("can_viewer_join");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("can_viewer_message");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("can_viewer_post");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 16);
        if (g != 0) {
            jsonGenerator.a("category_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 17, (short) 0) != (short) 0) {
            jsonGenerator.a("connection_style");
            jsonGenerator.b(((GraphQLConnectionStyle) mutableFlatBuffer.a(i, 17, GraphQLConnectionStyle.class)).name());
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("contextual_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("created_for_group");
            GraphQLGroupDeserializer.m5159a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("creation_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        long a2 = mutableFlatBuffer.a(i, 22, 0);
        if (a2 != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 23, 0);
        if (a2 != 0) {
            jsonGenerator.a("end_timestamp");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("eventCategoryLabel");
            GraphQLEventCategoryDataDeserializer.m4775a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("eventProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 26) != 0) {
            jsonGenerator.a("eventUrl");
            jsonGenerator.b(mutableFlatBuffer.c(i, 26));
        }
        if (mutableFlatBuffer.g(i, 27) != 0) {
            jsonGenerator.a("event_buy_ticket_display_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 27));
        }
        if (mutableFlatBuffer.g(i, 28) != 0) {
            jsonGenerator.a("event_buy_ticket_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 28));
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("event_category_info");
            GraphQLEventCategoryDataDeserializer.m4775a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 30);
        if (g != 0) {
            jsonGenerator.a("event_cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 31);
        if (g != 0) {
            jsonGenerator.a("event_creator");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 32);
        if (g != 0) {
            jsonGenerator.a("event_declines");
            GraphQLEventDeclinesConnectionDeserializer.m4787a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 33);
        if (g != 0) {
            jsonGenerator.a("event_description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 34);
        if (g != 0) {
            jsonGenerator.a("event_hosts");
            GraphQLEventHostsConnectionDeserializer.m4799a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 35);
        if (g != 0) {
            jsonGenerator.a("event_invitees");
            GraphQLEventInviteesConnectionDeserializer.m4805a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 36, (short) 0) != (short) 0) {
            jsonGenerator.a("event_kind");
            jsonGenerator.b(((GraphQLEventPrivacyType) mutableFlatBuffer.a(i, 36, GraphQLEventPrivacyType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 37);
        if (g != 0) {
            jsonGenerator.a("event_maybes");
            GraphQLEventMaybesConnectionDeserializer.m4812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 38);
        if (g != 0) {
            jsonGenerator.a("event_members");
            GraphQLEventMembersConnectionDeserializer.m4819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 39);
        if (g != 0) {
            jsonGenerator.a("event_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 40, (short) 0) != (short) 0) {
            jsonGenerator.a("event_privacy_type");
            jsonGenerator.b(((GraphQLEventPrivacyType) mutableFlatBuffer.a(i, 40, GraphQLEventPrivacyType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 41) != 0) {
            jsonGenerator.a("event_ticket_provider_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 41));
        }
        if (mutableFlatBuffer.a(i, 42, (short) 0) != (short) 0) {
            jsonGenerator.a("event_type");
            jsonGenerator.b(((GraphQLEventType) mutableFlatBuffer.a(i, 42, GraphQLEventType.class)).name());
        }
        g = mutableFlatBuffer.a(i, 43, 0);
        if (g != 0) {
            jsonGenerator.a("event_user_location_shares_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 44, 0);
        if (g != 0) {
            jsonGenerator.a("event_user_location_shares_start_interval");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("event_viewer_capability");
            GraphQLEventViewerCapabilityDeserializer.m4844a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 46, (short) 0) != (short) 0) {
            jsonGenerator.a("event_visibility");
            jsonGenerator.b(((GraphQLEventVisibility) mutableFlatBuffer.a(i, 46, GraphQLEventVisibility.class)).name());
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("event_watchers");
            GraphQLEventWatchersConnectionDeserializer.m4847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 48);
        if (g != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 49);
        if (g != 0) {
            jsonGenerator.a("friendEventDeclines");
            GraphQLEventDeclinesConnectionDeserializer.m4787a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 50);
        if (g != 0) {
            jsonGenerator.a("friendEventInvitees");
            GraphQLEventInviteesConnectionDeserializer.m4805a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 51);
        if (g != 0) {
            jsonGenerator.a("friendEventInviteesFirst5");
            GraphQLEventInviteesConnectionDeserializer.m4805a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 52);
        if (g != 0) {
            jsonGenerator.a("friendEventMaybes");
            GraphQLEventMaybesConnectionDeserializer.m4812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 53);
        if (g != 0) {
            jsonGenerator.a("friendEventMaybesFirst5");
            GraphQLEventMaybesConnectionDeserializer.m4812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 54);
        if (g != 0) {
            jsonGenerator.a("friendEventMembers");
            GraphQLEventMembersConnectionDeserializer.m4819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 55);
        if (g != 0) {
            jsonGenerator.a("friendEventMembersFirst5");
            GraphQLEventMembersConnectionDeserializer.m4819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 56);
        if (g != 0) {
            jsonGenerator.a("friendEventWatchers");
            GraphQLEventWatchersConnectionDeserializer.m4847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 57);
        if (g != 0) {
            jsonGenerator.a("friendEventWatchersFirst5");
            GraphQLEventWatchersConnectionDeserializer.m4847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 58);
        if (g != 0) {
            jsonGenerator.a("friends_going");
            GraphQLEventMembersConnectionDeserializer.m4819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 59);
        if (g != 0) {
            jsonGenerator.a("friends_interested");
            GraphQLEventWatchersConnectionDeserializer.m4847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 60);
        if (g != 0) {
            jsonGenerator.a("friends_invited");
            GraphQLEventInviteesConnectionDeserializer.m4805a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 62) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 62));
        }
        g = mutableFlatBuffer.g(i, 63);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 64);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 65);
        if (a) {
            jsonGenerator.a("is_all_day");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 66);
        if (a) {
            jsonGenerator.a("is_canceled");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 67);
        if (a) {
            jsonGenerator.a("is_event_draft");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 68);
        if (a) {
            jsonGenerator.a("is_message_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 69);
        if (a) {
            jsonGenerator.a("is_privacy_locked");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 71) != 0) {
            jsonGenerator.a("live_permalink_time_range_sentence");
            jsonGenerator.b(mutableFlatBuffer.c(i, 71));
        }
        g = mutableFlatBuffer.g(i, 72);
        if (g != 0) {
            jsonGenerator.a("location");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 73);
        if (g != 0) {
            jsonGenerator.a("map_bounding_box");
            GraphQLGeoRectangleDeserializer.m4995a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 74, 0);
        if (g != 0) {
            jsonGenerator.a("map_zoom_level");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 75) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 75));
        }
        if (mutableFlatBuffer.g(i, 76) != 0) {
            jsonGenerator.a("name_search_tokens");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 76), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 77);
        if (g != 0) {
            jsonGenerator.a("open_graph_composer_preview");
            GraphQLStoryAttachmentDeserializer.m5957b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 78);
        if (g != 0) {
            jsonGenerator.a("otherEventDeclines");
            GraphQLEventDeclinesConnectionDeserializer.m4787a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 79);
        if (g != 0) {
            jsonGenerator.a("otherEventInvitees");
            GraphQLEventInviteesConnectionDeserializer.m4805a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 80);
        if (g != 0) {
            jsonGenerator.a("otherEventMaybes");
            GraphQLEventMaybesConnectionDeserializer.m4812a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 81);
        if (g != 0) {
            jsonGenerator.a("otherEventMembers");
            GraphQLEventMembersConnectionDeserializer.m4819a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 82);
        if (g != 0) {
            jsonGenerator.a("otherEventWatchers");
            GraphQLEventWatchersConnectionDeserializer.m4847a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 83);
        if (g != 0) {
            jsonGenerator.a("parent_group");
            GraphQLGroupDeserializer.m5159a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 84, 0);
        if (g != 0) {
            jsonGenerator.a("pending_post_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 85);
        if (g != 0) {
            jsonGenerator.a("placeProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 86) != 0) {
            jsonGenerator.a("place_topic_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 86));
        }
        if (mutableFlatBuffer.a(i, 87, (short) 0) != (short) 0) {
            jsonGenerator.a("place_type");
            jsonGenerator.b(((GraphQLPlaceType) mutableFlatBuffer.a(i, 87, GraphQLPlaceType.class)).name());
        }
        a = mutableFlatBuffer.a(i, 88);
        if (a) {
            jsonGenerator.a("post_approval_required");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 89);
        if (g != 0) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 90);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 91);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 92);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 93);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 94);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 95);
        if (g != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 96);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 97);
        if (g != 0) {
            jsonGenerator.a("profile_pic_large");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 98);
        if (g != 0) {
            jsonGenerator.a("profile_pic_medium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 99);
        if (g != 0) {
            jsonGenerator.a("profile_pic_small");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 100);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 101);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 102);
        if (g != 0) {
            jsonGenerator.a("saved_collection");
            GraphQLTimelineAppCollectionDeserializer.m6070b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 103);
        if (g != 0) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 104) != 0) {
            jsonGenerator.a("start_time_sentence");
            jsonGenerator.b(mutableFlatBuffer.c(i, 104));
        }
        a2 = mutableFlatBuffer.a(i, 105, 0);
        if (a2 != 0) {
            jsonGenerator.a("start_timestamp");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 106);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 107);
        if (g != 0) {
            jsonGenerator.a("suggested_event_context_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 108);
        if (a) {
            jsonGenerator.a("supports_event_stories");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 109);
        if (g != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 110);
        if (g != 0) {
            jsonGenerator.a("time_range");
            GraphQLEventTimeRangeDeserializer.m4835a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 111) != 0) {
            jsonGenerator.a("time_range_sentence");
            jsonGenerator.b(mutableFlatBuffer.c(i, 111));
        }
        if (mutableFlatBuffer.g(i, 112) != 0) {
            jsonGenerator.a("timezone");
            jsonGenerator.b(mutableFlatBuffer.c(i, 112));
        }
        g = mutableFlatBuffer.a(i, 113, 0);
        if (g != 0) {
            jsonGenerator.a("unread_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 114) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 114));
        }
        if (mutableFlatBuffer.g(i, 115) != 0) {
            jsonGenerator.a("username");
            jsonGenerator.b(mutableFlatBuffer.c(i, 115));
        }
        if (mutableFlatBuffer.a(i, 116, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_guest_status");
            jsonGenerator.b(((GraphQLEventGuestStatus) mutableFlatBuffer.a(i, 116, GraphQLEventGuestStatus.class)).name());
        }
        a = mutableFlatBuffer.a(i, 117);
        if (a) {
            jsonGenerator.a("viewer_has_pending_invite");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 118);
        if (g != 0) {
            jsonGenerator.a("viewer_inviters");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 119, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_notification_subscription_level");
            jsonGenerator.b(((GraphQLEventNotificationSubscriptionLevel) mutableFlatBuffer.a(i, 119, GraphQLEventNotificationSubscriptionLevel.class)).name());
        }
        if (mutableFlatBuffer.a(i, 120, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 120, GraphQLSavedState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 121);
        if (g != 0) {
            jsonGenerator.a("viewer_timeline_collections_containing");
            GraphQLTimelineAppCollectionDeserializer.m6068a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 122);
        if (g != 0) {
            jsonGenerator.a("viewer_timeline_collections_supported");
            GraphQLTimelineAppCollectionDeserializer.m6068a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 123, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_watch_status");
            jsonGenerator.b(((GraphQLEventWatchStatus) mutableFlatBuffer.a(i, 123, GraphQLEventWatchStatus.class)).name());
        }
        if (mutableFlatBuffer.a(i, 124, (short) 0) != (short) 0) {
            jsonGenerator.a("event_promotion_status");
            jsonGenerator.b(((GraphQLBoostedPostStatus) mutableFlatBuffer.a(i, 124, GraphQLBoostedPostStatus.class)).name());
        }
        a = mutableFlatBuffer.a(i, 125);
        if (a) {
            jsonGenerator.a("is_official");
            jsonGenerator.a(a);
        }
        a2 = mutableFlatBuffer.a(i, 127, 0);
        if (a2 != 0) {
            jsonGenerator.a("scheduled_publish_timestamp");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.a(i, 128);
        if (a) {
            jsonGenerator.a("can_viewer_purchase_onsite_tickets");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 129);
        if (g != 0) {
            jsonGenerator.a("event_ticket_provider");
            GraphQLEventTicketProviderDeserializer.m4832a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
