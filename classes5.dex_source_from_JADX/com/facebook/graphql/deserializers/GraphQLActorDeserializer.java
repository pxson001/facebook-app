package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
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

/* compiled from: place_review_feed_unit */
public class GraphQLActorDeserializer {
    public static int m4517a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[91];
        boolean[] zArr = new boolean[40];
        boolean[] zArr2 = new boolean[27];
        int[] iArr2 = new int[3];
        long[] jArr = new long[2];
        double[] dArr = new double[3];
        Enum[] enumArr = new Enum[5];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("admin_info")) {
                    iArr[1] = GraphQLPageAdminInfoDeserializer.m5492a(jsonParser, flatBufferBuilder);
                } else if (i.equals("alternate_name")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("backing_application")) {
                    iArr[4] = GraphQLAppStoreApplicationDeserializer.m4573a(jsonParser, flatBufferBuilder);
                } else if (i.equals("bio_text")) {
                    iArr[5] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("birthdayFriends")) {
                    iArr[6] = GraphQLFriendsConnectionDeserializer.m4945a(jsonParser, flatBufferBuilder);
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
                } else if (i.equals("category_names")) {
                    iArr[14] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("communicationRank")) {
                    zArr[7] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("cover_photo")) {
                    iArr[16] = GraphQLFocusedPhotoDeserializer.m4919a(jsonParser, flatBufferBuilder);
                } else if (i.equals("current_city")) {
                    iArr[17] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("email")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("email_addresses")) {
                    iArr[19] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("encrypted_cookie_sync_data")) {
                    iArr[20] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("events")) {
                    iArr[21] = GraphQLEventsConnectionDeserializer.m4852a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friends")) {
                    iArr[25] = GraphQLFriendsConnectionDeserializer.m4945a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendship_status")) {
                    zArr[8] = true;
                    enumArr[0] = GraphQLFriendshipStatus.fromString(jsonParser.o());
                } else if (i.equals("gender")) {
                    zArr[9] = true;
                    enumArr[1] = GraphQLGender.fromString(jsonParser.o());
                } else if (i.equals("hometown")) {
                    iArr[28] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[29] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_banned_by_page_viewer")) {
                    zArr[10] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("is_deactivated_allowed_on_messenger")) {
                    zArr[11] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("is_followed_by_everyone")) {
                    zArr[12] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("is_memorialized")) {
                    zArr[13] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("is_message_blocked_by_viewer")) {
                    zArr[14] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("is_messenger_user")) {
                    zArr[15] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("is_minor")) {
                    zArr[16] = true;
                    zArr2[13] = jsonParser.H();
                } else if (i.equals("is_mobile_pushable")) {
                    zArr[17] = true;
                    zArr2[14] = jsonParser.H();
                } else if (i.equals("is_partial")) {
                    zArr[18] = true;
                    zArr2[15] = jsonParser.H();
                } else if (i.equals("is_verified")) {
                    zArr[19] = true;
                    zArr2[16] = jsonParser.H();
                } else if (i.equals("is_viewer_friend")) {
                    zArr[20] = true;
                    zArr2[17] = jsonParser.H();
                } else if (i.equals("is_work_user")) {
                    zArr[21] = true;
                    zArr2[18] = jsonParser.H();
                } else if (i.equals("liked_profiles")) {
                    iArr[42] = GraphQLLikedProfilesConnectionDeserializer.m5315a(jsonParser, flatBufferBuilder);
                } else if (i.equals("live_video_subscription_status")) {
                    zArr[22] = true;
                    enumArr[2] = GraphQLLiveVideoSubscriptionStatus.fromString(jsonParser.o());
                } else if (i.equals("messenger_install_time")) {
                    zArr[23] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("messenger_invite_priority")) {
                    zArr[24] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("montage_thread_fbid")) {
                    iArr[46] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("mutual_friends")) {
                    iArr[47] = GraphQLMutualFriendsConnectionDeserializer.m5380a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[48] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name_search_tokens")) {
                    iArr[49] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("news_feed")) {
                    iArr[50] = GraphQLNewsFeedConnectionDeserializer.m5421a(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_likers")) {
                    iArr[52] = GraphQLPageLikersConnectionDeserializer.m5509a(jsonParser, flatBufferBuilder);
                } else if (i.equals("posted_item_privacy_scope")) {
                    iArr[53] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profilePicture60")) {
                    iArr[54] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_badge")) {
                    iArr[55] = GraphQLProfileBadgeDeserializer.m5714a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_photo")) {
                    iArr[56] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture")) {
                    iArr[57] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profile_picture_expiration_time")) {
                    zArr[25] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("profile_picture_is_silhouette")) {
                    zArr[26] = true;
                    zArr2[19] = jsonParser.H();
                } else if (i.equals("requestee_id")) {
                    iArr[60] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("requester_id")) {
                    iArr[61] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("secondary_subscribe_status")) {
                    zArr[27] = true;
                    enumArr[3] = GraphQLSecondarySubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("single_publisher_video_channels")) {
                    iArr[63] = GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5889a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicBig")) {
                    iArr[64] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicHuge")) {
                    iArr[65] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("squareProfilePicSmall")) {
                    iArr[66] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("structured_name")) {
                    iArr[67] = GraphQLNameDeserializer.m5383a(jsonParser, flatBufferBuilder);
                } else if (i.equals("subscribe_status")) {
                    zArr[28] = true;
                    enumArr[4] = GraphQLSubscribeStatus.fromString(jsonParser.o());
                } else if (i.equals("tagline")) {
                    iArr[69] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("unread_count")) {
                    zArr[29] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("url")) {
                    iArr[72] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("username")) {
                    iArr[73] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_channel_can_viewer_follow")) {
                    zArr[30] = true;
                    zArr2[20] = jsonParser.H();
                } else if (i.equals("video_channel_curator_profile")) {
                    iArr[75] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_has_new")) {
                    zArr[31] = true;
                    zArr2[21] = jsonParser.H();
                } else if (i.equals("video_channel_is_viewer_following")) {
                    zArr[32] = true;
                    zArr2[22] = jsonParser.H();
                } else if (i.equals("video_channel_max_new_count")) {
                    zArr[33] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("video_channel_new_count")) {
                    zArr[34] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("video_channel_subtitle")) {
                    iArr[80] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_channel_title")) {
                    iArr[81] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_acts_as_profile")) {
                    zArr[35] = true;
                    zArr2[23] = jsonParser.H();
                } else if (i.equals("withTaggingRank")) {
                    zArr[36] = true;
                    dArr[2] = jsonParser.G();
                } else if (i.equals("video_channel_has_viewer_subscribed")) {
                    zArr[37] = true;
                    zArr2[24] = jsonParser.H();
                } else if (i.equals("video_channel_can_viewer_subscribe")) {
                    zArr[38] = true;
                    zArr2[25] = jsonParser.H();
                } else if (i.equals("short_name")) {
                    iArr[86] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profile_video")) {
                    iArr[89] = GraphQLProfileVideoDeserializer.m5722a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_viewer_coworker")) {
                    zArr[39] = true;
                    zArr2[26] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(91);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        if (zArr[0]) {
            flatBufferBuilder.a(7, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(8, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(9, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(10, zArr2[3]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(11, zArr2[4]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(12, zArr2[5]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(13, zArr2[6]);
        }
        flatBufferBuilder.b(14, iArr[14]);
        if (zArr[7]) {
            flatBufferBuilder.a(15, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(25, iArr[25]);
        if (zArr[8]) {
            flatBufferBuilder.a(26, enumArr[0]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(27, enumArr[1]);
        }
        flatBufferBuilder.b(28, iArr[28]);
        flatBufferBuilder.b(29, iArr[29]);
        if (zArr[10]) {
            flatBufferBuilder.a(30, zArr2[7]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(31, zArr2[8]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(32, zArr2[9]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(33, zArr2[10]);
        }
        if (zArr[14]) {
            flatBufferBuilder.a(34, zArr2[11]);
        }
        if (zArr[15]) {
            flatBufferBuilder.a(35, zArr2[12]);
        }
        if (zArr[16]) {
            flatBufferBuilder.a(36, zArr2[13]);
        }
        if (zArr[17]) {
            flatBufferBuilder.a(37, zArr2[14]);
        }
        if (zArr[18]) {
            flatBufferBuilder.a(38, zArr2[15]);
        }
        if (zArr[19]) {
            flatBufferBuilder.a(39, zArr2[16]);
        }
        if (zArr[20]) {
            flatBufferBuilder.a(40, zArr2[17]);
        }
        if (zArr[21]) {
            flatBufferBuilder.a(41, zArr2[18]);
        }
        flatBufferBuilder.b(42, iArr[42]);
        if (zArr[22]) {
            flatBufferBuilder.a(43, enumArr[2]);
        }
        if (zArr[23]) {
            flatBufferBuilder.a(44, jArr[0], 0);
        }
        if (zArr[24]) {
            flatBufferBuilder.a(45, dArr[1], 0.0d);
        }
        flatBufferBuilder.b(46, iArr[46]);
        flatBufferBuilder.b(47, iArr[47]);
        flatBufferBuilder.b(48, iArr[48]);
        flatBufferBuilder.b(49, iArr[49]);
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(52, iArr[52]);
        flatBufferBuilder.b(53, iArr[53]);
        flatBufferBuilder.b(54, iArr[54]);
        flatBufferBuilder.b(55, iArr[55]);
        flatBufferBuilder.b(56, iArr[56]);
        flatBufferBuilder.b(57, iArr[57]);
        if (zArr[25]) {
            flatBufferBuilder.a(58, jArr[1], 0);
        }
        if (zArr[26]) {
            flatBufferBuilder.a(59, zArr2[19]);
        }
        flatBufferBuilder.b(60, iArr[60]);
        flatBufferBuilder.b(61, iArr[61]);
        if (zArr[27]) {
            flatBufferBuilder.a(62, enumArr[3]);
        }
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        flatBufferBuilder.b(65, iArr[65]);
        flatBufferBuilder.b(66, iArr[66]);
        flatBufferBuilder.b(67, iArr[67]);
        if (zArr[28]) {
            flatBufferBuilder.a(68, enumArr[4]);
        }
        flatBufferBuilder.b(69, iArr[69]);
        if (zArr[29]) {
            flatBufferBuilder.a(71, iArr2[0], 0);
        }
        flatBufferBuilder.b(72, iArr[72]);
        flatBufferBuilder.b(73, iArr[73]);
        if (zArr[30]) {
            flatBufferBuilder.a(74, zArr2[20]);
        }
        flatBufferBuilder.b(75, iArr[75]);
        if (zArr[31]) {
            flatBufferBuilder.a(76, zArr2[21]);
        }
        if (zArr[32]) {
            flatBufferBuilder.a(77, zArr2[22]);
        }
        if (zArr[33]) {
            flatBufferBuilder.a(78, iArr2[1], 0);
        }
        if (zArr[34]) {
            flatBufferBuilder.a(79, iArr2[2], 0);
        }
        flatBufferBuilder.b(80, iArr[80]);
        flatBufferBuilder.b(81, iArr[81]);
        if (zArr[35]) {
            flatBufferBuilder.a(82, zArr2[23]);
        }
        if (zArr[36]) {
            flatBufferBuilder.a(83, dArr[2], 0.0d);
        }
        if (zArr[37]) {
            flatBufferBuilder.a(84, zArr2[24]);
        }
        if (zArr[38]) {
            flatBufferBuilder.a(85, zArr2[25]);
        }
        flatBufferBuilder.b(86, iArr[86]);
        flatBufferBuilder.b(89, iArr[89]);
        if (zArr[39]) {
            flatBufferBuilder.a(90, zArr2[26]);
        }
        return flatBufferBuilder.d();
    }

    public static int m4520b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m4517a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m4518a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4517a(jsonParser, flatBufferBuilder);
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

    public static void m4519a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m4521b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m4521b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("admin_info");
            GraphQLPageAdminInfoDeserializer.m5494a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("alternate_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("backing_application");
            GraphQLAppStoreApplicationDeserializer.m4575a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("bio_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("birthdayFriends");
            GraphQLFriendsConnectionDeserializer.m4947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 7);
        if (a) {
            jsonGenerator.a("can_see_viewer_montage_thread");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("can_viewer_act_as_memorial_contact");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 9);
        if (a) {
            jsonGenerator.a("can_viewer_block");
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
        g = mutableFlatBuffer.g(i, 16);
        if (g != 0) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhotoDeserializer.m4921a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("current_city");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("email");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("email_addresses");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 19), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("encrypted_cookie_sync_data");
            jsonGenerator.b(mutableFlatBuffer.c(i, 20));
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("events");
            GraphQLEventsConnectionDeserializer.m4854a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("friends");
            GraphQLFriendsConnectionDeserializer.m4947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 26, (short) 0) != (short) 0) {
            jsonGenerator.a("friendship_status");
            jsonGenerator.b(((GraphQLFriendshipStatus) mutableFlatBuffer.a(i, 26, GraphQLFriendshipStatus.class)).name());
        }
        if (mutableFlatBuffer.a(i, 27, (short) 0) != (short) 0) {
            jsonGenerator.a("gender");
            jsonGenerator.b(((GraphQLGender) mutableFlatBuffer.a(i, 27, GraphQLGender.class)).name());
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("hometown");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 29) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 29));
        }
        a = mutableFlatBuffer.a(i, 30);
        if (a) {
            jsonGenerator.a("is_banned_by_page_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 31);
        if (a) {
            jsonGenerator.a("is_deactivated_allowed_on_messenger");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 32);
        if (a) {
            jsonGenerator.a("is_followed_by_everyone");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 33);
        if (a) {
            jsonGenerator.a("is_memorialized");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 34);
        if (a) {
            jsonGenerator.a("is_message_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 35);
        if (a) {
            jsonGenerator.a("is_messenger_user");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 36);
        if (a) {
            jsonGenerator.a("is_minor");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 37);
        if (a) {
            jsonGenerator.a("is_mobile_pushable");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 38);
        if (a) {
            jsonGenerator.a("is_partial");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 39);
        if (a) {
            jsonGenerator.a("is_verified");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 40);
        if (a) {
            jsonGenerator.a("is_viewer_friend");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 41);
        if (a) {
            jsonGenerator.a("is_work_user");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 42);
        if (g != 0) {
            jsonGenerator.a("liked_profiles");
            GraphQLLikedProfilesConnectionDeserializer.m5317a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 43, (short) 0) != (short) 0) {
            jsonGenerator.a("live_video_subscription_status");
            jsonGenerator.b(((GraphQLLiveVideoSubscriptionStatus) mutableFlatBuffer.a(i, 43, GraphQLLiveVideoSubscriptionStatus.class)).name());
        }
        long a3 = mutableFlatBuffer.a(i, 44, 0);
        if (a3 != 0) {
            jsonGenerator.a("messenger_install_time");
            jsonGenerator.a(a3);
        }
        a2 = mutableFlatBuffer.a(i, 45, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("messenger_invite_priority");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 46) != 0) {
            jsonGenerator.a("montage_thread_fbid");
            jsonGenerator.b(mutableFlatBuffer.c(i, 46));
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("mutual_friends");
            GraphQLMutualFriendsConnectionDeserializer.m5382a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 48) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 48));
        }
        if (mutableFlatBuffer.g(i, 49) != 0) {
            jsonGenerator.a("name_search_tokens");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 49), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 50);
        if (g != 0) {
            jsonGenerator.a("news_feed");
            GraphQLNewsFeedConnectionDeserializer.m5423a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 52);
        if (g != 0) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnectionDeserializer.m5511a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 53);
        if (g != 0) {
            jsonGenerator.a("posted_item_privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 54);
        if (g != 0) {
            jsonGenerator.a("profilePicture60");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 55);
        if (g != 0) {
            jsonGenerator.a("profile_badge");
            GraphQLProfileBadgeDeserializer.m5716a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 56);
        if (g != 0) {
            jsonGenerator.a("profile_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 57);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        a3 = mutableFlatBuffer.a(i, 58, 0);
        if (a3 != 0) {
            jsonGenerator.a("profile_picture_expiration_time");
            jsonGenerator.a(a3);
        }
        a = mutableFlatBuffer.a(i, 59);
        if (a) {
            jsonGenerator.a("profile_picture_is_silhouette");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 60) != 0) {
            jsonGenerator.a("requestee_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 60));
        }
        if (mutableFlatBuffer.g(i, 61) != 0) {
            jsonGenerator.a("requester_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 61));
        }
        if (mutableFlatBuffer.a(i, 62, (short) 0) != (short) 0) {
            jsonGenerator.a("secondary_subscribe_status");
            jsonGenerator.b(((GraphQLSecondarySubscribeStatus) mutableFlatBuffer.a(i, 62, GraphQLSecondarySubscribeStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 63);
        if (g != 0) {
            jsonGenerator.a("single_publisher_video_channels");
            GraphQLSinglePublisherVideoChannelsConnectionDeserializer.m5891a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 64);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicBig");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 65);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicHuge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 66);
        if (g != 0) {
            jsonGenerator.a("squareProfilePicSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 67);
        if (g != 0) {
            jsonGenerator.a("structured_name");
            GraphQLNameDeserializer.m5387b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 68, (short) 0) != (short) 0) {
            jsonGenerator.a("subscribe_status");
            jsonGenerator.b(((GraphQLSubscribeStatus) mutableFlatBuffer.a(i, 68, GraphQLSubscribeStatus.class)).name());
        }
        g = mutableFlatBuffer.g(i, 69);
        if (g != 0) {
            jsonGenerator.a("tagline");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 71, 0);
        if (g != 0) {
            jsonGenerator.a("unread_count");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 72) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 72));
        }
        if (mutableFlatBuffer.g(i, 73) != 0) {
            jsonGenerator.a("username");
            jsonGenerator.b(mutableFlatBuffer.c(i, 73));
        }
        a = mutableFlatBuffer.a(i, 74);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_follow");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 75);
        if (g != 0) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 76);
        if (a) {
            jsonGenerator.a("video_channel_has_new");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 77);
        if (a) {
            jsonGenerator.a("video_channel_is_viewer_following");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 78, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_max_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 79, 0);
        if (g != 0) {
            jsonGenerator.a("video_channel_new_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 80);
        if (g != 0) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 81);
        if (g != 0) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 82);
        if (a) {
            jsonGenerator.a("viewer_acts_as_profile");
            jsonGenerator.a(a);
        }
        a2 = mutableFlatBuffer.a(i, 83, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("withTaggingRank");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.a(i, 84);
        if (a) {
            jsonGenerator.a("video_channel_has_viewer_subscribed");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 85);
        if (a) {
            jsonGenerator.a("video_channel_can_viewer_subscribe");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 86) != 0) {
            jsonGenerator.a("short_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 86));
        }
        g = mutableFlatBuffer.g(i, 89);
        if (g != 0) {
            jsonGenerator.a("profile_video");
            GraphQLProfileVideoDeserializer.m5724a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 90);
        if (a) {
            jsonGenerator.a("is_viewer_coworker");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
