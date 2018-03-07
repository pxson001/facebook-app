package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupCategory;
import com.facebook.graphql.enums.GraphQLGroupContentRestrictionReason;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: overheadCorrection */
public class GraphQLGroupDeserializer {
    public static int m5157a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[95];
        boolean[] zArr = new boolean[42];
        boolean[] zArr2 = new boolean[21];
        int[] iArr2 = new int[5];
        long[] jArr = new long[3];
        Enum[] enumArr = new Enum[13];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("admin_aware_group")) {
                    iArr[0] = m5157a(jsonParser, flatBufferBuilder);
                } else if (i.equals("blurredCoverPhoto")) {
                    iArr[1] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("bookmark_image")) {
                    iArr[2] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_change_cover_photo")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_change_name")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_claim_adminship")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_message")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_post")) {
                    zArr[4] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("community_category")) {
                    zArr[5] = true;
                    enumArr[0] = GraphQLGroupCategory.fromString(jsonParser.o());
                } else if (i.equals("cover_photo")) {
                    iArr[9] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("delta_hash")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("description")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("end_of_privacy_grace_period")) {
                    zArr[6] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[13] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("full_name")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("groupItemCoverPhoto")) {
                    iArr[15] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_cover_photo")) {
                    iArr[16] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_logo")) {
                    iArr[17] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_mediaset")) {
                    iArr[18] = GraphQLMediaSetDeserializer.m5355a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_members")) {
                    iArr[19] = GraphQLGroupMembersConnectionDeserializer.m5169a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_members_viewer_friend_count")) {
                    zArr[7] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("group_owner_authored_stories")) {
                    iArr[21] = GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer.m5182a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_photorealistic_icon")) {
                    iArr[22] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_viewer_favorited")) {
                    zArr[8] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("has_viewer_hidden")) {
                    zArr[9] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("id")) {
                    iArr[25] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("imageHighOrig")) {
                    iArr[26] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[27] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_message_blocked_by_viewer")) {
                    zArr[10] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("is_viewer_newly_added")) {
                    zArr[11] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("join_approval_setting")) {
                    zArr[12] = true;
                    enumArr[1] = GraphQLGroupJoinApprovalSetting.fromString(jsonParser.o());
                } else if (i.equals("last_activity_time")) {
                    zArr[13] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("name")) {
                    iArr[33] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name_search_tokens")) {
                    iArr[34] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("parent_group")) {
                    iArr[35] = m5157a(jsonParser, flatBufferBuilder);
                } else if (i.equals("photoForLauncherShortcut")) {
                    iArr[36] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("post_permission_setting")) {
                    zArr[14] = true;
                    enumArr[2] = GraphQLGroupPostPermissionSetting.fromString(jsonParser.o());
                } else if (i.equals("posted_item_privacy_scope")) {
                    iArr[39] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previous_visibility")) {
                    zArr[15] = true;
                    enumArr[3] = GraphQLGroupVisibility.fromString(jsonParser.o());
                } else if (i.equals("privacy_change_threshold")) {
                    zArr[16] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("profileImageLarge")) {
                    iArr[42] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[43] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[44] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureHighRes")) {
                    iArr[45] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[46] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[47] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_large")) {
                    iArr[48] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_medium")) {
                    iArr[49] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_pic_small")) {
                    iArr[50] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[51] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[17] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("requires_admin_membership_approval")) {
                    zArr[18] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("requires_post_approval")) {
                    zArr[19] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("seen_group_purposes_modal")) {
                    zArr[20] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("settingsRowCoverPhoto")) {
                    iArr[56] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("should_show_notif_settings_transition_nux")) {
                    zArr[21] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("social_context")) {
                    iArr[58] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[59] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("subscribe_status")) {
                    zArr[22] = true;
                    enumArr[4] = GraphQLSubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[62] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("treehouseMembers")) {
                    iArr[63] = GraphQLGroupMembersConnectionDeserializer.m5169a(jsonParser, flatBufferBuilder);
                } else if (i.equals("treehouseheaderCoverPhoto")) {
                    iArr[64] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("unread_count")) {
                    zArr[23] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("url")) {
                    iArr[66] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("username")) {
                    iArr[67] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_channel_can_viewer_follow")) {
                    zArr[24] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("video_channel_can_viewer_subscribe")) {
                    zArr[25] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("video_channel_curator_profile")) {
                    iArr[70] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_has_new")) {
                    zArr[26] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("video_channel_has_viewer_subscribed")) {
                    zArr[27] = true;
                    zArr2[17] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_following")) {
                    zArr[28] = true;
                    zArr2[18] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_pinned")) {
                    zArr[29] = true;
                    zArr2[19] = jsonParser.H();
                } else if (i.equals("video_channel_max_new_count")) {
                    zArr[30] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("video_channel_new_count")) {
                    zArr[31] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("video_channel_subtitle")) {
                    iArr[77] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_title")) {
                    iArr[78] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_content_safety_restrictions")) {
                    iArr[79] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLGroupContentRestrictionReason.class);
                } else if (i.equals("viewer_join_state")) {
                    zArr[32] = true;
                    enumArr[5] = GraphQLGroupJoinState.fromString(jsonParser.o());
                } else if (i.equals("viewer_last_visited_time")) {
                    zArr[33] = true;
                    jArr[2] = jsonParser.F();
                } else if (i.equals("viewer_leave_scenario")) {
                    zArr[34] = true;
                    enumArr[6] = GraphQLLeavingGroupScenario.fromString(jsonParser.o());
                } else if (i.equals("viewer_post_status")) {
                    zArr[35] = true;
                    enumArr[7] = GraphQLGroupPostStatus.fromString(jsonParser.o());
                } else if (i.equals("viewer_push_subscription_level")) {
                    zArr[36] = true;
                    enumArr[8] = GraphQLGroupPushSubscriptionLevel.fromString(jsonParser.o());
                } else if (i.equals("viewer_request_to_join_subscription_level")) {
                    zArr[37] = true;
                    enumArr[9] = GraphQLGroupRequestToJoinSubscriptionLevel.fromString(jsonParser.o());
                } else if (i.equals("viewer_subscription_level")) {
                    zArr[38] = true;
                    enumArr[10] = GraphQLGroupSubscriptionLevel.fromString(jsonParser.o());
                } else if (i.equals("visibility")) {
                    zArr[39] = true;
                    enumArr[11] = GraphQLGroupVisibility.fromString(jsonParser.o());
                } else if (i.equals("visibility_sentence")) {
                    iArr[88] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("work_logo")) {
                    iArr[89] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_admin_type")) {
                    zArr[40] = true;
                    enumArr[12] = GraphQLGroupAdminType.fromString(jsonParser.o());
                } else if (i.equals("group_configs")) {
                    iArr[91] = GraphQLGroupConfigurationsConnectionDeserializer.m5145a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tips_channel")) {
                    iArr[92] = GraphQLAYMTChannelDeserializer.m4505a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_multi_company_group")) {
                    zArr[41] = true;
                    zArr2[20] = jsonParser.H();
                } else if (i.equals("group_topic_tags")) {
                    iArr[94] = GraphQLPageDeserializer.m5504b(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(95);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(4, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(5, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(6, zArr2[3]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(7, zArr2[4]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(8, enumArr[0]);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        if (zArr[6]) {
            flatBufferBuilder.a(12, jArr[0], 0);
        }
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        if (zArr[7]) {
            flatBufferBuilder.a(20, iArr2[0], 0);
        }
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        if (zArr[8]) {
            flatBufferBuilder.a(23, zArr2[5]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(24, zArr2[6]);
        }
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        if (zArr[10]) {
            flatBufferBuilder.a(28, zArr2[7]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(30, zArr2[8]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(31, enumArr[1]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(32, jArr[1], 0);
        }
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
        flatBufferBuilder.b(36, iArr[36]);
        if (zArr[14]) {
            flatBufferBuilder.a(38, enumArr[2]);
        }
        flatBufferBuilder.b(39, iArr[39]);
        if (zArr[15]) {
            flatBufferBuilder.a(40, enumArr[3]);
        }
        if (zArr[16]) {
            flatBufferBuilder.a(41, iArr2[1], 0);
        }
        flatBufferBuilder.b(42, iArr[42]);
        flatBufferBuilder.b(43, iArr[43]);
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(46, iArr[46]);
        flatBufferBuilder.b(47, iArr[47]);
        flatBufferBuilder.b(48, iArr[48]);
        flatBufferBuilder.b(49, iArr[49]);
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(51, iArr[51]);
        if (zArr[17]) {
            flatBufferBuilder.a(52, zArr2[9]);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(53, zArr2[10]);
        }
        if (zArr[19]) {
            flatBufferBuilder.a(54, zArr2[11]);
        }
        if (zArr[20]) {
            flatBufferBuilder.a(55, zArr2[12]);
        }
        flatBufferBuilder.b(56, iArr[56]);
        if (zArr[21]) {
            flatBufferBuilder.a(57, zArr2[13]);
        }
        flatBufferBuilder.b(58, iArr[58]);
        flatBufferBuilder.b(59, iArr[59]);
        if (zArr[22]) {
            flatBufferBuilder.a(60, enumArr[4]);
        }
        flatBufferBuilder.b(62, iArr[62]);
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        if (zArr[23]) {
            flatBufferBuilder.a(65, iArr2[2], 0);
        }
        flatBufferBuilder.b(66, iArr[66]);
        flatBufferBuilder.b(67, iArr[67]);
        if (zArr[24]) {
            flatBufferBuilder.a(68, zArr2[14]);
        }
        if (zArr[25]) {
            flatBufferBuilder.a(69, zArr2[15]);
        }
        flatBufferBuilder.b(70, iArr[70]);
        if (zArr[26]) {
            flatBufferBuilder.a(71, zArr2[16]);
        }
        if (zArr[27]) {
            flatBufferBuilder.a(72, zArr2[17]);
        }
        if (zArr[28]) {
            flatBufferBuilder.a(73, zArr2[18]);
        }
        if (zArr[29]) {
            flatBufferBuilder.a(74, zArr2[19]);
        }
        if (zArr[30]) {
            flatBufferBuilder.a(75, iArr2[3], 0);
        }
        if (zArr[31]) {
            flatBufferBuilder.a(76, iArr2[4], 0);
        }
        flatBufferBuilder.b(77, iArr[77]);
        flatBufferBuilder.b(78, iArr[78]);
        flatBufferBuilder.b(79, iArr[79]);
        if (zArr[32]) {
            flatBufferBuilder.a(80, enumArr[5]);
        }
        if (zArr[33]) {
            flatBufferBuilder.a(81, jArr[2], 0);
        }
        if (zArr[34]) {
            flatBufferBuilder.a(82, enumArr[6]);
        }
        if (zArr[35]) {
            flatBufferBuilder.a(83, enumArr[7]);
        }
        if (zArr[36]) {
            flatBufferBuilder.a(84, enumArr[8]);
        }
        if (zArr[37]) {
            flatBufferBuilder.a(85, enumArr[9]);
        }
        if (zArr[38]) {
            flatBufferBuilder.a(86, enumArr[10]);
        }
        if (zArr[39]) {
            flatBufferBuilder.a(87, enumArr[11]);
        }
        flatBufferBuilder.b(88, iArr[88]);
        flatBufferBuilder.b(89, iArr[89]);
        if (zArr[40]) {
            flatBufferBuilder.a(90, enumArr[12]);
        }
        flatBufferBuilder.b(91, iArr[91]);
        flatBufferBuilder.b(92, iArr[92]);
        if (zArr[41]) {
            flatBufferBuilder.a(93, zArr2[20]);
        }
        flatBufferBuilder.b(94, iArr[94]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5158a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5157a(jsonParser, flatBufferBuilder);
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

    public static void m5159a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("admin_aware_group");
            m5159a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("bookmark_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        boolean a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("can_viewer_change_cover_photo");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("can_viewer_change_name");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("can_viewer_claim_adminship");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("can_viewer_message");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 7);
        if (a) {
            jsonGenerator.a("can_viewer_post");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.a(i, 8, (short) 0) != (short) 0) {
            jsonGenerator.a("community_category");
            jsonGenerator.b(((GraphQLGroupCategory) mutableFlatBuffer.a(i, 8, GraphQLGroupCategory.class)).name());
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("delta_hash");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        long a2 = mutableFlatBuffer.a(i, 12, 0);
        if (a2 != 0) {
            jsonGenerator.a("end_of_privacy_grace_period");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("full_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("groupItemCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 16);
        if (g != 0) {
            jsonGenerator.a("group_cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("group_logo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("group_mediaset");
            GraphQLMediaSetDeserializer.m5357a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("group_members");
            GraphQLGroupMembersConnectionDeserializer.m5171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 20, 0);
        if (g != 0) {
            jsonGenerator.a("group_members_viewer_friend_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("group_owner_authored_stories");
            GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer.m5184a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("group_photorealistic_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 23);
        if (a) {
            jsonGenerator.a("has_viewer_favorited");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 24);
        if (a) {
            jsonGenerator.a("has_viewer_hidden");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 25) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 25));
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 28);
        if (a) {
            jsonGenerator.a("is_message_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 30);
        if (a) {
            jsonGenerator.a("is_viewer_newly_added");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.a(i, 31, (short) 0) != (short) 0) {
            jsonGenerator.a("join_approval_setting");
            jsonGenerator.b(((GraphQLGroupJoinApprovalSetting) mutableFlatBuffer.a(i, 31, GraphQLGroupJoinApprovalSetting.class)).name());
        }
        a2 = mutableFlatBuffer.a(i, 32, 0);
        if (a2 != 0) {
            jsonGenerator.a("last_activity_time");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 33) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 33));
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("name_search_tokens");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 34), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 35);
        if (g != 0) {
            jsonGenerator.a("parent_group");
            m5159a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("photoForLauncherShortcut");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 38, (short) 0) != (short) 0) {
            jsonGenerator.a("post_permission_setting");
            jsonGenerator.b(((GraphQLGroupPostPermissionSetting) mutableFlatBuffer.a(i, 38, GraphQLGroupPostPermissionSetting.class)).name());
        }
        g = mutableFlatBuffer.g(i, 39);
        if (g != 0) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 40, (short) 0) != (short) 0) {
            jsonGenerator.a("previous_visibility");
            jsonGenerator.b(((GraphQLGroupVisibility) mutableFlatBuffer.a(i, 40, GraphQLGroupVisibility.class)).name());
        }
        g = mutableFlatBuffer.a(i, 41, 0);
        if (g != 0) {
            jsonGenerator.a("privacy_change_threshold");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 42);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 48);
        if (g != 0) {
            jsonGenerator.a("profile_pic_large");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 49);
        if (g != 0) {
            jsonGenerator.a("profile_pic_medium");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 50);
        if (g != 0) {
            jsonGenerator.a("profile_pic_small");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 51);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 52);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 53);
        if (a) {
            jsonGenerator.a("requires_admin_membership_approval");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 54);
        if (a) {
            jsonGenerator.a("requires_post_approval");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 55);
        if (a) {
            jsonGenerator.a("seen_group_purposes_modal");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 56);
        if (g != 0) {
            jsonGenerator.a("settingsRowCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 57);
        if (a) {
            jsonGenerator.a("should_show_notif_settings_transition_nux");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 58);
        if (g != 0) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 59);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 60, (short) 0) != (short) 0) {
            jsonGenerator.a("subscribe_status");
            jsonGenerator.b(((GraphQLSubscribeStatus) mutableFlatBuffer.a(i, 60, GraphQLSubscribeStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 62);
        if (g != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 63);
        if (g != 0) {
            jsonGenerator.a("treehouseMembers");
            GraphQLGroupMembersConnectionDeserializer.m5171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 64);
        if (g != 0) {
            jsonGenerator.a("treehouseheaderCoverPhoto");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 65, 0);
        if (g != 0) {
            jsonGenerator.a("unread_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 66) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 66));
        }
        if (mutableFlatBuffer.g(i, 67) != 0) {
            jsonGenerator.a("username");
            jsonGenerator.b(mutableFlatBuffer.c(i, 67));
        }
        a = mutableFlatBuffer.a(i, 68);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_follow");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 69);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_subscribe");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 70);
        if (g != 0) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 71);
        if (a) {
            jsonGenerator.a("video_channel_has_new");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 72);
        if (a) {
            jsonGenerator.a("video_channel_has_viewer_subscribed");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 73);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_following");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 74);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_pinned");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 75, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_max_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 76, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 77);
        if (g != 0) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 78);
        if (g != 0) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 79) != 0) {
            jsonGenerator.a("viewer_content_safety_restrictions");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 79), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 80, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_join_state");
            jsonGenerator.b(((GraphQLGroupJoinState) mutableFlatBuffer.a(i, 80, GraphQLGroupJoinState.class)).name());
        }
        a2 = mutableFlatBuffer.a(i, 81, 0);
        if (a2 != 0) {
            jsonGenerator.a("viewer_last_visited_time");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.a(i, 82, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_leave_scenario");
            jsonGenerator.b(((GraphQLLeavingGroupScenario) mutableFlatBuffer.a(i, 82, GraphQLLeavingGroupScenario.class)).name());
        }
        if (mutableFlatBuffer.a(i, 83, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_post_status");
            jsonGenerator.b(((GraphQLGroupPostStatus) mutableFlatBuffer.a(i, 83, GraphQLGroupPostStatus.class)).name());
        }
        if (mutableFlatBuffer.a(i, 84, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_push_subscription_level");
            jsonGenerator.b(((GraphQLGroupPushSubscriptionLevel) mutableFlatBuffer.a(i, 84, GraphQLGroupPushSubscriptionLevel.class)).name());
        }
        if (mutableFlatBuffer.a(i, 85, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_request_to_join_subscription_level");
            jsonGenerator.b(((GraphQLGroupRequestToJoinSubscriptionLevel) mutableFlatBuffer.a(i, 85, GraphQLGroupRequestToJoinSubscriptionLevel.class)).name());
        }
        if (mutableFlatBuffer.a(i, 86, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_subscription_level");
            jsonGenerator.b(((GraphQLGroupSubscriptionLevel) mutableFlatBuffer.a(i, 86, GraphQLGroupSubscriptionLevel.class)).name());
        }
        if (mutableFlatBuffer.a(i, 87, (short) 0) != (short) 0) {
            jsonGenerator.a("visibility");
            jsonGenerator.b(((GraphQLGroupVisibility) mutableFlatBuffer.a(i, 87, GraphQLGroupVisibility.class)).name());
        }
        g = mutableFlatBuffer.g(i, 88);
        if (g != 0) {
            jsonGenerator.a("visibility_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 89);
        if (g != 0) {
            jsonGenerator.a("work_logo");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 90, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_admin_type");
            jsonGenerator.b(((GraphQLGroupAdminType) mutableFlatBuffer.a(i, 90, GraphQLGroupAdminType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 91);
        if (g != 0) {
            jsonGenerator.a("group_configs");
            GraphQLGroupConfigurationsConnectionDeserializer.m5147a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 92);
        if (g != 0) {
            jsonGenerator.a("tips_channel");
            GraphQLAYMTChannelDeserializer.m4507a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 93);
        if (a) {
            jsonGenerator.a("is_multi_company_group");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 94);
        if (g != 0) {
            jsonGenerator.a("group_topic_tags");
            GraphQLPageDeserializer.m5503a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
