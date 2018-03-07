package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
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

/* compiled from: metapage_redirection_notification */
public class GraphQLUserDeserializer {
    public static int m6148a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[134];
        boolean[] zArr = new boolean[50];
        boolean[] zArr2 = new boolean[33];
        int[] iArr2 = new int[4];
        long[] jArr = new long[4];
        double[] dArr = new double[4];
        Enum[] enumArr = new Enum[5];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("Image")) {
                    iArr[0] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("address")) {
                    iArr[1] = GraphQLStreetAddressDeserializer.m5994a(jsonParser, flatBufferBuilder);
                } else if (i.equals("albums")) {
                    iArr[2] = GraphQLAlbumsConnectionDeserializer.m4552a(jsonParser, flatBufferBuilder);
                } else if (i.equals("alternate_name")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("backstage_audience_mode")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("bio_text")) {
                    iArr[6] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("birthdayFriends")) {
                    iArr[7] = GraphQLFriendsConnectionDeserializer.m4945a(jsonParser, flatBufferBuilder);
                } else if (i.equals("blurredCoverPhoto")) {
                    iArr[8] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("bylines")) {
                    iArr[9] = GraphQLBylineFragmentDeserializer.m4635b(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_see_viewer_montage_thread")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_act_as_memorial_contact")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_block")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_message")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_poke")) {
                    zArr[4] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_post")) {
                    zArr[5] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_report")) {
                    zArr[6] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("communicationRank")) {
                    zArr[7] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("contact")) {
                    iArr[18] = GraphQLContactDeserializer.m4677a(jsonParser, flatBufferBuilder);
                } else if (i.equals("cover_photo")) {
                    iArr[19] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("current_city")) {
                    iArr[20] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("education_experiences")) {
                    iArr[21] = GraphQLUserEducationExperiencesConnectionDeserializer.m6153a(jsonParser, flatBufferBuilder);
                } else if (i.equals("email_addresses")) {
                    iArr[22] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("encrypted_cookie_sync_data")) {
                    iArr[23] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("events")) {
                    iArr[24] = GraphQLEventsConnectionDeserializer.m4852a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[26] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("firstSection")) {
                    iArr[27] = GraphQLTimelineSectionsConnectionDeserializer.m6092a(jsonParser, flatBufferBuilder);
                } else if (i.equals("first_name")) {
                    iArr[28] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("followup_feed_units")) {
                    iArr[29] = GraphQLFollowUpFeedUnitsConnectionDeserializer.m4922a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends")) {
                    iArr[30] = GraphQLFriendsConnectionDeserializer.m4945a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendship_status")) {
                    zArr[8] = true;
                    enumArr[0] = GraphQLFriendshipStatus.fromString(jsonParser.o());
                } else if (i.equals("gender")) {
                    zArr[9] = true;
                    enumArr[1] = GraphQLGender.fromString(jsonParser.o());
                } else if (i.equals("hometown")) {
                    iArr[34] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[35] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("imageHighOrig")) {
                    iArr[36] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[37] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_banned_by_page_viewer")) {
                    zArr[10] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("is_blocked_by_viewer")) {
                    zArr[11] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("is_deactivated_allowed_on_messenger")) {
                    zArr[12] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("is_followed_by_everyone")) {
                    zArr[13] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("is_memorialized")) {
                    zArr[14] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("is_message_blocked_by_viewer")) {
                    zArr[15] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("is_messenger_user")) {
                    zArr[16] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("is_minor")) {
                    zArr[17] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("is_mobile_pushable")) {
                    zArr[18] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("is_partial")) {
                    zArr[19] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("is_pymm_hidden")) {
                    zArr[20] = true;
                    zArr2[17] = jsonParser.H();
                } else if (i.equals("is_pysf_blacklisted")) {
                    zArr[21] = true;
                    zArr2[18] = jsonParser.H();
                } else if (i.equals("is_verified")) {
                    zArr[22] = true;
                    zArr2[19] = jsonParser.H();
                } else if (i.equals("is_viewer_coworker")) {
                    zArr[23] = true;
                    zArr2[20] = jsonParser.H();
                } else if (i.equals("is_viewer_friend")) {
                    zArr[24] = true;
                    zArr2[21] = jsonParser.H();
                } else if (i.equals("is_viewer_notified_about")) {
                    zArr[25] = true;
                    zArr2[22] = jsonParser.H();
                } else if (i.equals("is_work_user")) {
                    zArr[26] = true;
                    zArr2[23] = jsonParser.H();
                } else if (i.equals("liked_profiles")) {
                    iArr[55] = GraphQLLikedProfilesConnectionDeserializer.m5315a(jsonParser, flatBufferBuilder);
                } else if (i.equals("live_video_subscription_status")) {
                    zArr[27] = true;
                    enumArr[2] = GraphQLLiveVideoSubscriptionStatus.fromString(jsonParser.o());
                } else if (i.equals("lowres_profile")) {
                    iArr[57] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("messenger_contact")) {
                    iArr[58] = GraphQLContactDeserializer.m4677a(jsonParser, flatBufferBuilder);
                } else if (i.equals("messenger_install_time")) {
                    zArr[28] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("messenger_invite_priority")) {
                    zArr[29] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("montage_thread_fbid")) {
                    iArr[61] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("mutual_friends")) {
                    iArr[62] = GraphQLMutualFriendsConnectionDeserializer.m5380a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[63] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name_search_tokens")) {
                    iArr[64] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("news_feed")) {
                    iArr[65] = GraphQLNewsFeedConnectionDeserializer.m5421a(jsonParser, flatBufferBuilder);
                } else if (i.equals("posted_item_privacy_scope")) {
                    iArr[66] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preliminaryProfilePicture")) {
                    iArr[67] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageLarge")) {
                    iArr[68] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[69] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture32")) {
                    iArr[70] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[71] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture60")) {
                    iArr[72] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[73] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[74] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_badge")) {
                    iArr[75] = GraphQLProfileBadgeDeserializer.m5714a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[76] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_large")) {
                    iArr[77] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_medium")) {
                    iArr[78] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_small")) {
                    iArr[79] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[80] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_expiration_time")) {
                    zArr[30] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[31] = true;
                    zArr2[24] = jsonParser.H();
                } else if (i.equals("receiver_id")) {
                    iArr[83] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("registration_time")) {
                    zArr[32] = true;
                    jArr[2] = jsonParser.F();
                } else if (i.equals("requestee_id")) {
                    iArr[86] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("requester_id")) {
                    iArr[87] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("secondary_subscribe_status")) {
                    zArr[33] = true;
                    enumArr[3] = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("sender_id")) {
                    iArr[89] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("single_publisher_video_channels")) {
                    iArr[90] = GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5889a(jsonParser, flatBufferBuilder);
                } else if (i.equals("social_context")) {
                    iArr[91] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicBig")) {
                    iArr[92] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicHuge")) {
                    iArr[93] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicSmall")) {
                    iArr[94] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[95] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("structured_name")) {
                    iArr[96] = GraphQLNameDeserializer.m5383a(jsonParser, flatBufferBuilder);
                } else if (i.equals("structured_names")) {
                    iArr[97] = GraphQLNameDeserializer.m5386b(jsonParser, flatBufferBuilder);
                } else if (i.equals("subscribe_status")) {
                    zArr[34] = true;
                    enumArr[4] = GraphQLSubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[99] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tagline")) {
                    iArr[100] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("timeline_sections")) {
                    iArr[101] = GraphQLTimelineSectionsConnectionDeserializer.m6092a(jsonParser, flatBufferBuilder);
                } else if (i.equals("unread_count")) {
                    zArr[35] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("unseen_stories")) {
                    iArr[103] = GraphQLUnseenStoriesConnectionDeserializer.m6142a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[104] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("username")) {
                    iArr[105] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_channel_can_viewer_follow")) {
                    zArr[36] = true;
                    zArr2[25] = jsonParser.H();
                } else if (i.equals("video_channel_can_viewer_subscribe")) {
                    zArr[37] = true;
                    zArr2[26] = jsonParser.H();
                } else if (i.equals("video_channel_curator_profile")) {
                    iArr[108] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_has_new")) {
                    zArr[38] = true;
                    zArr2[27] = jsonParser.H();
                } else if (i.equals("video_channel_has_viewer_subscribed")) {
                    zArr[39] = true;
                    zArr2[28] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_following")) {
                    zArr[40] = true;
                    zArr2[29] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_pinned")) {
                    zArr[41] = true;
                    zArr2[30] = jsonParser.H();
                } else if (i.equals("video_channel_max_new_count")) {
                    zArr[42] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("video_channel_new_count")) {
                    zArr[43] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("video_channel_subtitle")) {
                    iArr[115] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_title")) {
                    iArr[116] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_affinity")) {
                    zArr[44] = true;
                    dArr[2] = jsonParser.G();
                } else if (i.equals("websites")) {
                    iArr[119] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("withTaggingRank")) {
                    zArr[45] = true;
                    dArr[3] = jsonParser.G();
                } else if (i.equals("work_experiences")) {
                    iArr[121] = GraphQLUserWorkExperiencesConnectionDeserializer.m6159a(jsonParser, flatBufferBuilder);
                } else if (i.equals("created_time")) {
                    zArr[46] = true;
                    jArr[3] = jsonParser.F();
                } else if (i.equals("admin_profile_pic")) {
                    iArr[123] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("big_profile_image")) {
                    iArr[124] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tiny_profile_image")) {
                    iArr[125] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("mutual_contacts_count")) {
                    zArr[47] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("short_name")) {
                    iArr[127] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_messenger_cymk_hidden")) {
                    zArr[48] = true;
                    zArr2[31] = jsonParser.H();
                } else if (i.equals("has_viewer_posted_for_birthday")) {
                    zArr[49] = true;
                    zArr2[32] = jsonParser.H();
                } else if (i.equals("timeline_stories")) {
                    iArr[132] = GraphQLTimelineStoriesConnectionDeserializer.m6095a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_video")) {
                    iArr[133] = GraphQLProfileVideoDeserializer.m5722a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(134);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        if (zArr[0]) {
            flatBufferBuilder.a(10, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(11, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(12, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(13, zArr2[3]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(14, zArr2[4]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(15, zArr2[5]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(16, zArr2[6]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(17, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        flatBufferBuilder.b(29, iArr[29]);
        flatBufferBuilder.b(30, iArr[30]);
        if (zArr[8]) {
            flatBufferBuilder.a(31, enumArr[0]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(32, enumArr[1]);
        }
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
        flatBufferBuilder.b(36, iArr[36]);
        flatBufferBuilder.b(37, iArr[37]);
        if (zArr[10]) {
            flatBufferBuilder.a(38, zArr2[7]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(39, zArr2[8]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(40, zArr2[9]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(41, zArr2[10]);
        }
        if (zArr[14]) {
            flatBufferBuilder.a(42, zArr2[11]);
        }
        if (zArr[15]) {
            flatBufferBuilder.a(43, zArr2[12]);
        }
        if (zArr[16]) {
            flatBufferBuilder.a(44, zArr2[13]);
        }
        if (zArr[17]) {
            flatBufferBuilder.a(45, zArr2[14]);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(46, zArr2[15]);
        }
        if (zArr[19]) {
            flatBufferBuilder.a(47, zArr2[16]);
        }
        if (zArr[20]) {
            flatBufferBuilder.a(48, zArr2[17]);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(49, zArr2[18]);
        }
        if (zArr[22]) {
            flatBufferBuilder.a(50, zArr2[19]);
        }
        if (zArr[23]) {
            flatBufferBuilder.a(51, zArr2[20]);
        }
        if (zArr[24]) {
            flatBufferBuilder.a(52, zArr2[21]);
        }
        if (zArr[25]) {
            flatBufferBuilder.a(53, zArr2[22]);
        }
        if (zArr[26]) {
            flatBufferBuilder.a(54, zArr2[23]);
        }
        flatBufferBuilder.b(55, iArr[55]);
        if (zArr[27]) {
            flatBufferBuilder.a(56, enumArr[2]);
        }
        flatBufferBuilder.b(57, iArr[57]);
        flatBufferBuilder.b(58, iArr[58]);
        if (zArr[28]) {
            flatBufferBuilder.a(59, jArr[0], 0);
        }
        if (zArr[29]) {
            flatBufferBuilder.a(60, dArr[1], 0.0d);
        }
        flatBufferBuilder.b(61, iArr[61]);
        flatBufferBuilder.b(62, iArr[62]);
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        flatBufferBuilder.b(65, iArr[65]);
        flatBufferBuilder.b(66, iArr[66]);
        flatBufferBuilder.b(67, iArr[67]);
        flatBufferBuilder.b(68, iArr[68]);
        flatBufferBuilder.b(69, iArr[69]);
        flatBufferBuilder.b(70, iArr[70]);
        flatBufferBuilder.b(71, iArr[71]);
        flatBufferBuilder.b(72, iArr[72]);
        flatBufferBuilder.b(73, iArr[73]);
        flatBufferBuilder.b(74, iArr[74]);
        flatBufferBuilder.b(75, iArr[75]);
        flatBufferBuilder.b(76, iArr[76]);
        flatBufferBuilder.b(77, iArr[77]);
        flatBufferBuilder.b(78, iArr[78]);
        flatBufferBuilder.b(79, iArr[79]);
        flatBufferBuilder.b(80, iArr[80]);
        if (zArr[30]) {
            flatBufferBuilder.a(81, jArr[1], 0);
        }
        if (zArr[31]) {
            flatBufferBuilder.a(82, zArr2[24]);
        }
        flatBufferBuilder.b(83, iArr[83]);
        if (zArr[32]) {
            flatBufferBuilder.a(84, jArr[2], 0);
        }
        flatBufferBuilder.b(86, iArr[86]);
        flatBufferBuilder.b(87, iArr[87]);
        if (zArr[33]) {
            flatBufferBuilder.a(88, enumArr[3]);
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
        if (zArr[34]) {
            flatBufferBuilder.a(98, enumArr[4]);
        }
        flatBufferBuilder.b(99, iArr[99]);
        flatBufferBuilder.b(100, iArr[100]);
        flatBufferBuilder.b(101, iArr[101]);
        if (zArr[35]) {
            flatBufferBuilder.a(102, iArr2[0], 0);
        }
        flatBufferBuilder.b(103, iArr[103]);
        flatBufferBuilder.b(104, iArr[104]);
        flatBufferBuilder.b(105, iArr[105]);
        if (zArr[36]) {
            flatBufferBuilder.a(106, zArr2[25]);
        }
        if (zArr[37]) {
            flatBufferBuilder.a(107, zArr2[26]);
        }
        flatBufferBuilder.b(108, iArr[108]);
        if (zArr[38]) {
            flatBufferBuilder.a(109, zArr2[27]);
        }
        if (zArr[39]) {
            flatBufferBuilder.a(110, zArr2[28]);
        }
        if (zArr[40]) {
            flatBufferBuilder.a(111, zArr2[29]);
        }
        if (zArr[41]) {
            flatBufferBuilder.a(112, zArr2[30]);
        }
        if (zArr[42]) {
            flatBufferBuilder.a(113, iArr2[1], 0);
        }
        if (zArr[43]) {
            flatBufferBuilder.a(114, iArr2[2], 0);
        }
        flatBufferBuilder.b(115, iArr[115]);
        flatBufferBuilder.b(116, iArr[116]);
        if (zArr[44]) {
            flatBufferBuilder.a(117, dArr[2], 0.0d);
        }
        flatBufferBuilder.b(119, iArr[119]);
        if (zArr[45]) {
            flatBufferBuilder.a(120, dArr[3], 0.0d);
        }
        flatBufferBuilder.b(121, iArr[121]);
        if (zArr[46]) {
            flatBufferBuilder.a(122, jArr[3], 0);
        }
        flatBufferBuilder.b(123, iArr[123]);
        flatBufferBuilder.b(124, iArr[124]);
        flatBufferBuilder.b(125, iArr[125]);
        if (zArr[47]) {
            flatBufferBuilder.a(126, iArr2[3], 0);
        }
        flatBufferBuilder.b(127, iArr[127]);
        if (zArr[48]) {
            flatBufferBuilder.a(128, zArr2[31]);
        }
        if (zArr[49]) {
            flatBufferBuilder.a(131, zArr2[32]);
        }
        flatBufferBuilder.b(132, iArr[132]);
        flatBufferBuilder.b(133, iArr[133]);
        return flatBufferBuilder.d();
    }

    public static int m6151b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m6148a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m6149a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6148a(jsonParser, flatBufferBuilder);
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

    public static void m6150a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m6152b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m6152b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("Image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("address");
            GraphQLStreetAddressDeserializer.m5996a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("albums");
            GraphQLAlbumsConnectionDeserializer.m4554a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("alternate_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("backstage_audience_mode");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("bio_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("birthdayFriends");
            GraphQLFriendsConnectionDeserializer.m4947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("bylines");
            GraphQLBylineFragmentDeserializer.m4634a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 10);
        if (a) {
            jsonGenerator.a("can_see_viewer_montage_thread");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("can_viewer_act_as_memorial_contact");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 12);
        if (a) {
            jsonGenerator.a("can_viewer_block");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("can_viewer_message");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("can_viewer_poke");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("can_viewer_post");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("can_viewer_report");
            jsonGenerator.a(a);
        }
        double a2 = mutableFlatBuffer.a(i, 17, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("communicationRank");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("contact");
            GraphQLContactDeserializer.m4679a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("current_city");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("education_experiences");
            GraphQLUserEducationExperiencesConnectionDeserializer.m6155a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 22) != 0) {
            jsonGenerator.a("email_addresses");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 22), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("encrypted_cookie_sync_data");
            jsonGenerator.b(mutableFlatBuffer.c(i, 23));
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("events");
            GraphQLEventsConnectionDeserializer.m4854a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("firstSection");
            GraphQLTimelineSectionsConnectionDeserializer.m6094a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 28) != 0) {
            jsonGenerator.a("first_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 28));
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("followup_feed_units");
            GraphQLFollowUpFeedUnitsConnectionDeserializer.m4924a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 30);
        if (g != 0) {
            jsonGenerator.a("friends");
            GraphQLFriendsConnectionDeserializer.m4947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 31, (short) 0) != (short) 0) {
            jsonGenerator.a("friendship_status");
            jsonGenerator.b(((GraphQLFriendshipStatus) mutableFlatBuffer.a(i, 31, GraphQLFriendshipStatus.class)).name());
        }
        if (mutableFlatBuffer.a(i, 32, (short) 0) != (short) 0) {
            jsonGenerator.a("gender");
            jsonGenerator.b(((GraphQLGender) mutableFlatBuffer.a(i, 32, GraphQLGender.class)).name());
        }
        g = mutableFlatBuffer.g(i, 34);
        if (g != 0) {
            jsonGenerator.a("hometown");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 35) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 35));
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 37);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 38);
        if (a) {
            jsonGenerator.a("is_banned_by_page_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 39);
        if (a) {
            jsonGenerator.a("is_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 40);
        if (a) {
            jsonGenerator.a("is_deactivated_allowed_on_messenger");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 41);
        if (a) {
            jsonGenerator.a("is_followed_by_everyone");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 42);
        if (a) {
            jsonGenerator.a("is_memorialized");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 43);
        if (a) {
            jsonGenerator.a("is_message_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 44);
        if (a) {
            jsonGenerator.a("is_messenger_user");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 45);
        if (a) {
            jsonGenerator.a("is_minor");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 46);
        if (a) {
            jsonGenerator.a("is_mobile_pushable");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 47);
        if (a) {
            jsonGenerator.a("is_partial");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 48);
        if (a) {
            jsonGenerator.a("is_pymm_hidden");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 49);
        if (a) {
            jsonGenerator.a("is_pysf_blacklisted");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 50);
        if (a) {
            jsonGenerator.a("is_verified");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 51);
        if (a) {
            jsonGenerator.a("is_viewer_coworker");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 52);
        if (a) {
            jsonGenerator.a("is_viewer_friend");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 53);
        if (a) {
            jsonGenerator.a("is_viewer_notified_about");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 54);
        if (a) {
            jsonGenerator.a("is_work_user");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 55);
        if (g != 0) {
            jsonGenerator.a("liked_profiles");
            GraphQLLikedProfilesConnectionDeserializer.m5317a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 56, (short) 0) != (short) 0) {
            jsonGenerator.a("live_video_subscription_status");
            jsonGenerator.b(((GraphQLLiveVideoSubscriptionStatus) mutableFlatBuffer.a(i, 56, GraphQLLiveVideoSubscriptionStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 57);
        if (g != 0) {
            jsonGenerator.a("lowres_profile");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 58);
        if (g != 0) {
            jsonGenerator.a("messenger_contact");
            GraphQLContactDeserializer.m4679a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        long a3 = mutableFlatBuffer.a(i, 59, 0);
        if (a3 != 0) {
            jsonGenerator.a("messenger_install_time");
            jsonGenerator.a(a3);
        }
        a2 = mutableFlatBuffer.a(i, 60, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("messenger_invite_priority");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 61) != 0) {
            jsonGenerator.a("montage_thread_fbid");
            jsonGenerator.b(mutableFlatBuffer.c(i, 61));
        }
        g = mutableFlatBuffer.g(i, 62);
        if (g != 0) {
            jsonGenerator.a("mutual_friends");
            GraphQLMutualFriendsConnectionDeserializer.m5382a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 63) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 63));
        }
        if (mutableFlatBuffer.g(i, 64) != 0) {
            jsonGenerator.a("name_search_tokens");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 64), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 65);
        if (g != 0) {
            jsonGenerator.a("news_feed");
            GraphQLNewsFeedConnectionDeserializer.m5423a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 66);
        if (g != 0) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 67);
        if (g != 0) {
            jsonGenerator.a("preliminaryProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 68);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 69);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 70);
        if (g != 0) {
            jsonGenerator.a("profilePicture32");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 71);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 72);
        if (g != 0) {
            jsonGenerator.a("profilePicture60");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 73);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 74);
        if (g != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 75);
        if (g != 0) {
            jsonGenerator.a("profile_badge");
            GraphQLProfileBadgeDeserializer.m5716a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 76);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 77);
        if (g != 0) {
            jsonGenerator.a("profile_pic_large");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 78);
        if (g != 0) {
            jsonGenerator.a("profile_pic_medium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 79);
        if (g != 0) {
            jsonGenerator.a("profile_pic_small");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 80);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a3 = mutableFlatBuffer.a(i, 81, 0);
        if (a3 != 0) {
            jsonGenerator.a("profile_picture_expiration_time");
            jsonGenerator.a(a3);
        }
        a = mutableFlatBuffer.a(i, 82);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 83) != 0) {
            jsonGenerator.a("receiver_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 83));
        }
        a3 = mutableFlatBuffer.a(i, 84, 0);
        if (a3 != 0) {
            jsonGenerator.a("registration_time");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 86) != 0) {
            jsonGenerator.a("requestee_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 86));
        }
        if (mutableFlatBuffer.g(i, 87) != 0) {
            jsonGenerator.a("requester_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 87));
        }
        if (mutableFlatBuffer.a(i, 88, (short) 0) != (short) 0) {
            jsonGenerator.a("secondary_subscribe_status");
            jsonGenerator.b(((GraphQLSecondarySubscribeStatus) mutableFlatBuffer.a(i, 88, GraphQLSecondarySubscribeStatus.class)).name());
        }
        if (mutableFlatBuffer.g(i, 89) != 0) {
            jsonGenerator.a("sender_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 89));
        }
        g = mutableFlatBuffer.g(i, 90);
        if (g != 0) {
            jsonGenerator.a("single_publisher_video_channels");
            GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5891a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 91);
        if (g != 0) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 92);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicBig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 93);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicHuge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 94);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 95);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 96);
        if (g != 0) {
            jsonGenerator.a("structured_name");
            GraphQLNameDeserializer.m5387b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 97);
        if (g != 0) {
            jsonGenerator.a("structured_names");
            GraphQLNameDeserializer.m5385a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 98, (short) 0) != (short) 0) {
            jsonGenerator.a("subscribe_status");
            jsonGenerator.b(((GraphQLSubscribeStatus) mutableFlatBuffer.a(i, 98, GraphQLSubscribeStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 99);
        if (g != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 100);
        if (g != 0) {
            jsonGenerator.a("tagline");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 101);
        if (g != 0) {
            jsonGenerator.a("timeline_sections");
            GraphQLTimelineSectionsConnectionDeserializer.m6094a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 102, 0);
        if (g != 0) {
            jsonGenerator.a("unread_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 103);
        if (g != 0) {
            jsonGenerator.a("unseen_stories");
            GraphQLUnseenStoriesConnectionDeserializer.m6144a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 104) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 104));
        }
        if (mutableFlatBuffer.g(i, 105) != 0) {
            jsonGenerator.a("username");
            jsonGenerator.b(mutableFlatBuffer.c(i, 105));
        }
        a = mutableFlatBuffer.a(i, 106);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_follow");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 107);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_subscribe");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 108);
        if (g != 0) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 109);
        if (a) {
            jsonGenerator.a("video_channel_has_new");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 110);
        if (a) {
            jsonGenerator.a("video_channel_has_viewer_subscribed");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 111);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_following");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 112);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_pinned");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 113, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_max_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 114, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 115);
        if (g != 0) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 116);
        if (g != 0) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 117, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("viewer_affinity");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 119) != 0) {
            jsonGenerator.a("websites");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 119), jsonGenerator);
        }
        a2 = mutableFlatBuffer.a(i, 120, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("withTaggingRank");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 121);
        if (g != 0) {
            jsonGenerator.a("work_experiences");
            GraphQLUserWorkExperiencesConnectionDeserializer.m6161a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a3 = mutableFlatBuffer.a(i, 122, 0);
        if (a3 != 0) {
            jsonGenerator.a("created_time");
            jsonGenerator.a(a3);
        }
        g = mutableFlatBuffer.g(i, 123);
        if (g != 0) {
            jsonGenerator.a("admin_profile_pic");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 124);
        if (g != 0) {
            jsonGenerator.a("big_profile_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 125);
        if (g != 0) {
            jsonGenerator.a("tiny_profile_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 126, 0);
        if (g != 0) {
            jsonGenerator.a("mutual_contacts_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 127) != 0) {
            jsonGenerator.a("short_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 127));
        }
        a = mutableFlatBuffer.a(i, 128);
        if (a) {
            jsonGenerator.a("is_messenger_cymk_hidden");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 131);
        if (a) {
            jsonGenerator.a("has_viewer_posted_for_birthday");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 132);
        if (g != 0) {
            jsonGenerator.a("timeline_stories");
            GraphQLTimelineStoriesConnectionDeserializer.m6097a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 133);
        if (g != 0) {
            jsonGenerator.a("profile_video");
            GraphQLProfileVideoDeserializer.m5724a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
