package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
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

/* compiled from: negative_feedback_action_type */
public class GraphQLProfileDeserializer {
    public static int m5717a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[85];
        boolean[] zArr = new boolean[32];
        boolean[] zArr2 = new boolean[17];
        int[] iArr2 = new int[3];
        double[] dArr = new double[2];
        Enum[] enumArr = new Enum[10];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("address")) {
                    iArr[1] = GraphQLStreetAddressDeserializer.m5994a(jsonParser, flatBufferBuilder);
                } else if (i.equals("alternate_name")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("best_description")) {
                    iArr[4] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("bylines")) {
                    iArr[5] = GraphQLBylineFragmentDeserializer.m4635b(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_act_as_memorial_contact")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_block")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_change_guest_status")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_like")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_message")) {
                    zArr[4] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_poke")) {
                    zArr[5] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("can_viewer_post")) {
                    zArr[6] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("can_viewer_report")) {
                    zArr[7] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("category_names")) {
                    iArr[14] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("communicationRank")) {
                    zArr[8] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("connection_style")) {
                    zArr[9] = true;
                    enumArr[0] = GraphQLConnectionStyle.fromString(jsonParser.o());
                } else if (i.equals("cover_photo")) {
                    iArr[17] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("does_viewer_like")) {
                    zArr[10] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("education_experiences")) {
                    iArr[19] = GraphQLUserEducationExperiencesConnectionDeserializer.m6153a(jsonParser, flatBufferBuilder);
                } else if (i.equals("email_addresses")) {
                    iArr[20] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_kind")) {
                    zArr[11] = true;
                    enumArr[1] = GraphQLEventPrivacyType.fromString(jsonParser.o());
                } else if (i.equals("events_calendar_subscriber_count")) {
                    zArr[12] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("events_calendar_subscription_status")) {
                    zArr[13] = true;
                    enumArr[2] = GraphQLEventsCalendarSubscriptionStatus.fromString(jsonParser.o());
                } else if (i.equals("feedAwesomizerProfilePicture")) {
                    iArr[25] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[26] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends")) {
                    iArr[27] = GraphQLFriendsConnectionDeserializer.m4945a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendship_status")) {
                    zArr[14] = true;
                    enumArr[3] = GraphQLFriendshipStatus.fromString(jsonParser.o());
                } else if (i.equals("group_members")) {
                    iArr[29] = GraphQLGroupMembersConnectionDeserializer.m5169a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_members_viewer_friend_count")) {
                    zArr[15] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("id")) {
                    iArr[31] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_followed_by_everyone")) {
                    zArr[16] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("is_messenger_user")) {
                    zArr[17] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("is_playable")) {
                    zArr[18] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("is_verified")) {
                    zArr[19] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("is_viewer_friend")) {
                    zArr[20] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("is_work_user")) {
                    zArr[21] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("location")) {
                    iArr[39] = GraphQLLocationDeserializer.m5330a(jsonParser, flatBufferBuilder);
                } else if (i.equals("mutual_friends")) {
                    iArr[40] = GraphQLMutualFriendsConnectionDeserializer.m5380a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[41] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name_search_tokens")) {
                    iArr[42] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("new_activity_count")) {
                    zArr[22] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("open_graph_composer_preview")) {
                    iArr[44] = GraphQLStoryAttachmentDeserializer.m5953a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page")) {
                    iArr[45] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_likers")) {
                    iArr[46] = GraphQLPageLikersConnectionDeserializer.m5509a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_visits")) {
                    iArr[47] = GraphQLPageVisitsConnectionDeserializer.m5533a(jsonParser, flatBufferBuilder);
                } else if (i.equals("playable_url")) {
                    iArr[48] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("posted_item_privacy_scope")) {
                    iArr[49] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("preliminaryProfilePicture")) {
                    iArr[50] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageLarge")) {
                    iArr[51] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[52] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture50")) {
                    iArr[53] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePictureLarge")) {
                    iArr[54] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[55] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[23] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("related_article_title")) {
                    iArr[57] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("secondary_subscribe_status")) {
                    zArr[24] = true;
                    enumArr[4] = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("short_category_names")) {
                    iArr[59] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("social_context")) {
                    iArr[60] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("streaming_profile_picture")) {
                    iArr[61] = GraphQLStreamingImageDeserializer.m5991a(jsonParser, flatBufferBuilder);
                } else if (i.equals("structured_name")) {
                    iArr[62] = GraphQLNameDeserializer.m5383a(jsonParser, flatBufferBuilder);
                } else if (i.equals("structured_names")) {
                    iArr[63] = GraphQLNameDeserializer.m5386b(jsonParser, flatBufferBuilder);
                } else if (i.equals("subscribe_status")) {
                    zArr[25] = true;
                    enumArr[5] = GraphQLSubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("taggable_object_profile_picture")) {
                    iArr[65] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tagline")) {
                    iArr[66] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("trending_topic_data")) {
                    iArr[68] = GraphQLTrendingTopicDataDeserializer.m6127a(jsonParser, flatBufferBuilder);
                } else if (i.equals("trending_topic_name")) {
                    iArr[69] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("unique_keyword")) {
                    iArr[70] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[71] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_affinity")) {
                    zArr[26] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("viewer_guest_status")) {
                    zArr[27] = true;
                    enumArr[6] = GraphQLEventGuestStatus.fromString(jsonParser.o());
                } else if (i.equals("viewer_has_pending_invite")) {
                    zArr[28] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("viewer_join_state")) {
                    zArr[29] = true;
                    enumArr[7] = GraphQLGroupJoinState.fromString(jsonParser.o());
                } else if (i.equals("viewer_recommendation")) {
                    iArr[76] = GraphQLContactRecommendationFieldDeserializer.m4683a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_saved_state")) {
                    zArr[30] = true;
                    enumArr[8] = GraphQLSavedState.fromString(jsonParser.o());
                } else if (i.equals("viewer_watch_status")) {
                    zArr[31] = true;
                    enumArr[9] = GraphQLEventWatchStatus.fromString(jsonParser.o());
                } else if (i.equals("visibility_sentence")) {
                    iArr[79] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("websites")) {
                    iArr[80] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("work_experiences")) {
                    iArr[81] = GraphQLUserWorkExperiencesConnectionDeserializer.m6159a(jsonParser, flatBufferBuilder);
                } else if (i.equals("global_share")) {
                    iArr[82] = GraphQLExternalUrlDeserializer.m4867a(jsonParser, flatBufferBuilder);
                } else if (i.equals("invitee")) {
                    iArr[83] = GraphQLUserDeserializer.m6148a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(85);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[0]) {
            flatBufferBuilder.a(6, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(7, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(8, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(9, zArr2[3]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(10, zArr2[4]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(11, zArr2[5]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(12, zArr2[6]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(13, zArr2[7]);
        }
        flatBufferBuilder.b(14, iArr[14]);
        if (zArr[8]) {
            flatBufferBuilder.a(15, dArr[0], 0.0d);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(16, enumArr[0]);
        }
        flatBufferBuilder.b(17, iArr[17]);
        if (zArr[10]) {
            flatBufferBuilder.a(18, zArr2[8]);
        }
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        if (zArr[11]) {
            flatBufferBuilder.a(21, enumArr[1]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(23, iArr2[0], 0);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(24, enumArr[2]);
        }
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        if (zArr[14]) {
            flatBufferBuilder.a(28, enumArr[3]);
        }
        flatBufferBuilder.b(29, iArr[29]);
        if (zArr[15]) {
            flatBufferBuilder.a(30, iArr2[1], 0);
        }
        flatBufferBuilder.b(31, iArr[31]);
        if (zArr[16]) {
            flatBufferBuilder.a(33, zArr2[9]);
        }
        if (zArr[17]) {
            flatBufferBuilder.a(34, zArr2[10]);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(35, zArr2[11]);
        }
        if (zArr[19]) {
            flatBufferBuilder.a(36, zArr2[12]);
        }
        if (zArr[20]) {
            flatBufferBuilder.a(37, zArr2[13]);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(38, zArr2[14]);
        }
        flatBufferBuilder.b(39, iArr[39]);
        flatBufferBuilder.b(40, iArr[40]);
        flatBufferBuilder.b(41, iArr[41]);
        flatBufferBuilder.b(42, iArr[42]);
        if (zArr[22]) {
            flatBufferBuilder.a(43, iArr2[2], 0);
        }
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(46, iArr[46]);
        flatBufferBuilder.b(47, iArr[47]);
        flatBufferBuilder.b(48, iArr[48]);
        flatBufferBuilder.b(49, iArr[49]);
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(51, iArr[51]);
        flatBufferBuilder.b(52, iArr[52]);
        flatBufferBuilder.b(53, iArr[53]);
        flatBufferBuilder.b(54, iArr[54]);
        flatBufferBuilder.b(55, iArr[55]);
        if (zArr[23]) {
            flatBufferBuilder.a(56, zArr2[15]);
        }
        flatBufferBuilder.b(57, iArr[57]);
        if (zArr[24]) {
            flatBufferBuilder.a(58, enumArr[4]);
        }
        flatBufferBuilder.b(59, iArr[59]);
        flatBufferBuilder.b(60, iArr[60]);
        flatBufferBuilder.b(61, iArr[61]);
        flatBufferBuilder.b(62, iArr[62]);
        flatBufferBuilder.b(63, iArr[63]);
        if (zArr[25]) {
            flatBufferBuilder.a(64, enumArr[5]);
        }
        flatBufferBuilder.b(65, iArr[65]);
        flatBufferBuilder.b(66, iArr[66]);
        flatBufferBuilder.b(68, iArr[68]);
        flatBufferBuilder.b(69, iArr[69]);
        flatBufferBuilder.b(70, iArr[70]);
        flatBufferBuilder.b(71, iArr[71]);
        if (zArr[26]) {
            flatBufferBuilder.a(72, dArr[1], 0.0d);
        }
        if (zArr[27]) {
            flatBufferBuilder.a(73, enumArr[6]);
        }
        if (zArr[28]) {
            flatBufferBuilder.a(74, zArr2[16]);
        }
        if (zArr[29]) {
            flatBufferBuilder.a(75, enumArr[7]);
        }
        flatBufferBuilder.b(76, iArr[76]);
        if (zArr[30]) {
            flatBufferBuilder.a(77, enumArr[8]);
        }
        if (zArr[31]) {
            flatBufferBuilder.a(78, enumArr[9]);
        }
        flatBufferBuilder.b(79, iArr[79]);
        flatBufferBuilder.b(80, iArr[80]);
        flatBufferBuilder.b(81, iArr[81]);
        flatBufferBuilder.b(82, iArr[82]);
        flatBufferBuilder.b(83, iArr[83]);
        return flatBufferBuilder.d();
    }

    public static int m5720b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5717a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5718a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5717a(jsonParser, flatBufferBuilder);
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

    public static void m5719a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5721b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5721b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("address");
            GraphQLStreetAddressDeserializer.m5996a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("alternate_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("best_description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("bylines");
            GraphQLBylineFragmentDeserializer.m4634a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("can_viewer_act_as_memorial_contact");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 7);
        if (a) {
            jsonGenerator.a("can_viewer_block");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("can_viewer_change_guest_status");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 9);
        if (a) {
            jsonGenerator.a("can_viewer_like");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 10);
        if (a) {
            jsonGenerator.a("can_viewer_message");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("can_viewer_poke");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 12);
        if (a) {
            jsonGenerator.a("can_viewer_post");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("can_viewer_report");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("category_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 14), jsonGenerator);
        }
        double a2 = mutableFlatBuffer.a(i, 15, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("communicationRank");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.a(i, 16, (short) 0) != (short) 0) {
            jsonGenerator.a("connection_style");
            jsonGenerator.b(((GraphQLConnectionStyle) mutableFlatBuffer.a(i, 16, GraphQLConnectionStyle.class)).name());
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 18);
        if (a) {
            jsonGenerator.a("does_viewer_like");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("education_experiences");
            GraphQLUserEducationExperiencesConnectionDeserializer.m6155a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("email_addresses");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 20), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 21, (short) 0) != (short) 0) {
            jsonGenerator.a("event_kind");
            jsonGenerator.b(((GraphQLEventPrivacyType) mutableFlatBuffer.a(i, 21, GraphQLEventPrivacyType.class)).name());
        }
        g = mutableFlatBuffer.a(i, 23, 0);
        if (g != 0) {
            jsonGenerator.a("events_calendar_subscriber_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 24, (short) 0) != (short) 0) {
            jsonGenerator.a("events_calendar_subscription_status");
            jsonGenerator.b(((GraphQLEventsCalendarSubscriptionStatus) mutableFlatBuffer.a(i, 24, GraphQLEventsCalendarSubscriptionStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("friends");
            GraphQLFriendsConnectionDeserializer.m4947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 28, (short) 0) != (short) 0) {
            jsonGenerator.a("friendship_status");
            jsonGenerator.b(((GraphQLFriendshipStatus) mutableFlatBuffer.a(i, 28, GraphQLFriendshipStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("group_members");
            GraphQLGroupMembersConnectionDeserializer.m5171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 30, 0);
        if (g != 0) {
            jsonGenerator.a("group_members_viewer_friend_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 31) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 31));
        }
        a = mutableFlatBuffer.a(i, 33);
        if (a) {
            jsonGenerator.a("is_followed_by_everyone");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 34);
        if (a) {
            jsonGenerator.a("is_messenger_user");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 35);
        if (a) {
            jsonGenerator.a("is_playable");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 36);
        if (a) {
            jsonGenerator.a("is_verified");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 37);
        if (a) {
            jsonGenerator.a("is_viewer_friend");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 38);
        if (a) {
            jsonGenerator.a("is_work_user");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 39);
        if (g != 0) {
            jsonGenerator.a("location");
            GraphQLLocationDeserializer.m5332a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 40);
        if (g != 0) {
            jsonGenerator.a("mutual_friends");
            GraphQLMutualFriendsConnectionDeserializer.m5382a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 41) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 41));
        }
        if (mutableFlatBuffer.g(i, 42) != 0) {
            jsonGenerator.a("name_search_tokens");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 42), jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 43, 0);
        if (g != 0) {
            jsonGenerator.a("new_activity_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("open_graph_composer_preview");
            GraphQLStoryAttachmentDeserializer.m5957b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnectionDeserializer.m5511a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("page_visits");
            GraphQLPageVisitsConnectionDeserializer.m5535a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 48) != 0) {
            jsonGenerator.a("playable_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 48));
        }
        g = mutableFlatBuffer.g(i, 49);
        if (g != 0) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 50);
        if (g != 0) {
            jsonGenerator.a("preliminaryProfilePicture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 51);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 52);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 53);
        if (g != 0) {
            jsonGenerator.a("profilePicture50");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 54);
        if (g != 0) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 55);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 56);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 57) != 0) {
            jsonGenerator.a("related_article_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 57));
        }
        if (mutableFlatBuffer.a(i, 58, (short) 0) != (short) 0) {
            jsonGenerator.a("secondary_subscribe_status");
            jsonGenerator.b(((GraphQLSecondarySubscribeStatus) mutableFlatBuffer.a(i, 58, GraphQLSecondarySubscribeStatus.class)).name());
        }
        if (mutableFlatBuffer.g(i, 59) != 0) {
            jsonGenerator.a("short_category_names");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 59), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 60);
        if (g != 0) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 61);
        if (g != 0) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImageDeserializer.m5993a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 62);
        if (g != 0) {
            jsonGenerator.a("structured_name");
            GraphQLNameDeserializer.m5387b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 63);
        if (g != 0) {
            jsonGenerator.a("structured_names");
            GraphQLNameDeserializer.m5385a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 64, (short) 0) != (short) 0) {
            jsonGenerator.a("subscribe_status");
            jsonGenerator.b(((GraphQLSubscribeStatus) mutableFlatBuffer.a(i, 64, GraphQLSubscribeStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 65);
        if (g != 0) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 66);
        if (g != 0) {
            jsonGenerator.a("tagline");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 68);
        if (g != 0) {
            jsonGenerator.a("trending_topic_data");
            GraphQLTrendingTopicDataDeserializer.m6129a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 69) != 0) {
            jsonGenerator.a("trending_topic_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 69));
        }
        if (mutableFlatBuffer.g(i, 70) != 0) {
            jsonGenerator.a("unique_keyword");
            jsonGenerator.b(mutableFlatBuffer.c(i, 70));
        }
        if (mutableFlatBuffer.g(i, 71) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 71));
        }
        a2 = mutableFlatBuffer.a(i, 72, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("viewer_affinity");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.a(i, 73, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_guest_status");
            jsonGenerator.b(((GraphQLEventGuestStatus) mutableFlatBuffer.a(i, 73, GraphQLEventGuestStatus.class)).name());
        }
        a = mutableFlatBuffer.a(i, 74);
        if (a) {
            jsonGenerator.a("viewer_has_pending_invite");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.a(i, 75, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_join_state");
            jsonGenerator.b(((GraphQLGroupJoinState) mutableFlatBuffer.a(i, 75, GraphQLGroupJoinState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 76);
        if (g != 0) {
            jsonGenerator.a("viewer_recommendation");
            GraphQLContactRecommendationFieldDeserializer.m4685a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 77, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_saved_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 77, GraphQLSavedState.class)).name());
        }
        if (mutableFlatBuffer.a(i, 78, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_watch_status");
            jsonGenerator.b(((GraphQLEventWatchStatus) mutableFlatBuffer.a(i, 78, GraphQLEventWatchStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 79);
        if (g != 0) {
            jsonGenerator.a("visibility_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 80) != 0) {
            jsonGenerator.a("websites");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 80), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 81);
        if (g != 0) {
            jsonGenerator.a("work_experiences");
            GraphQLUserWorkExperiencesConnectionDeserializer.m6161a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 82);
        if (g != 0) {
            jsonGenerator.a("global_share");
            GraphQLExternalUrlDeserializer.m4869a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 83);
        if (g != 0) {
            jsonGenerator.a("invitee");
            GraphQLUserDeserializer.m6152b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
