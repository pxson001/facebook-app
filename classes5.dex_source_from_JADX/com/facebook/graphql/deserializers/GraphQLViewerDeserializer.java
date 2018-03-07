package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: message_markdown_html */
public class GraphQLViewerDeserializer {
    public static int m6199a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[37];
        boolean[] zArr = new boolean[9];
        boolean[] zArr2 = new boolean[3];
        int[] iArr2 = new int[6];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("account_user")) {
                    iArr[0] = GraphQLUserDeserializer.m6148a(jsonParser, flatBufferBuilder);
                } else if (i.equals("actor")) {
                    iArr[1] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("additional_suggested_post_ads")) {
                    iArr[2] = GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer.m4528a(jsonParser, flatBufferBuilder);
                } else if (i.equals("audience_info")) {
                    iArr[3] = GraphQLAudienceInfoDeserializer.m4597a(jsonParser, flatBufferBuilder);
                } else if (i.equals("composer_privacy_options")) {
                    iArr[4] = GraphQLPrivacyOptionsComposerConnectionDeserializer.m5691a(jsonParser, flatBufferBuilder);
                } else if (i.equals("current_location_page")) {
                    iArr[5] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("currently_processing_profile_video_content_id")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("daily_dialogue_pinned_unit")) {
                    iArr[7] = GraphQLCustomizedStoryDeserializer.m4703a(jsonParser, flatBufferBuilder);
                } else if (i.equals("debug_feed")) {
                    iArr[8] = GraphQLDebugFeedConnectionDeserializer.m4706a(jsonParser, flatBufferBuilder);
                } else if (i.equals("event_invitee_limit")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("friending_possibilities")) {
                    iArr[10] = GraphQLFriendingPossibilitiesConnectionDeserializer.m4939a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_commerce_suggested_location")) {
                    iArr[11] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("happy_birthday_card")) {
                    iArr[13] = GraphQLGoodwillHappyBirthdayCardDeserializer.m5014a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_editable_search_history")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("is_fb_employee")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("is_work_user")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("large_image_page_like_ads")) {
                    iArr[17] = GraphQLStatelessLargeImagePLAsConnectionDeserializer.m5939a(jsonParser, flatBufferBuilder);
                } else if (i.equals("megaphone")) {
                    iArr[18] = GraphQLMegaphoneDeserializer.m5364a(jsonParser, flatBufferBuilder);
                } else if (i.equals("news_feed")) {
                    iArr[19] = GraphQLNewsFeedConnectionDeserializer.m5421a(jsonParser, flatBufferBuilder);
                } else if (i.equals("prefilled_greeting_card")) {
                    iArr[21] = GraphQLGreetingCardDeserializer.m5121a(jsonParser, flatBufferBuilder);
                } else if (i.equals("primary_email")) {
                    iArr[22] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("side_feed")) {
                    iArr[23] = GraphQLSideFeedConnectionDeserializer.m5880a(jsonParser, flatBufferBuilder);
                } else if (i.equals("taggable_activities")) {
                    iArr[24] = GraphQLTaggableActivityDeserializer.m6034b(jsonParser, flatBufferBuilder);
                } else if (i.equals("video_home_badge_check_interval_s")) {
                    zArr[4] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("video_home_badge_count")) {
                    zArr[5] = true;
                    iArr2[2] = jsonParser.E();
                } else if (i.equals("video_home_max_badge_count")) {
                    zArr[6] = true;
                    iArr2[3] = jsonParser.E();
                } else if (i.equals("video_home_prefetch_unit_count")) {
                    zArr[7] = true;
                    iArr2[4] = jsonParser.E();
                } else if (i.equals("video_home_stale_data_interval_s")) {
                    zArr[8] = true;
                    iArr2[5] = jsonParser.E();
                } else if (i.equals("viewer_tag_suggestions_mediaset")) {
                    iArr[30] = GraphQLMediaSetDeserializer.m5355a(jsonParser, flatBufferBuilder);
                } else if (i.equals("work_community")) {
                    iArr[31] = GraphQLGroupDeserializer.m5157a(jsonParser, flatBufferBuilder);
                } else if (i.equals("instream_video_ads")) {
                    iArr[33] = GraphQLInstreamVideoAdsConnectionDeserializer.m5268a(jsonParser, flatBufferBuilder);
                } else if (i.equals("work_subdomain")) {
                    iArr[35] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("eligible_clash_units")) {
                    iArr[36] = GraphQLEligibleClashUnitsConnectionDeserializer.m4728a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(37);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        if (zArr[0]) {
            flatBufferBuilder.a(9, iArr2[0], 0);
        }
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(13, iArr[13]);
        if (zArr[1]) {
            flatBufferBuilder.a(14, zArr2[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(15, zArr2[1]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(16, zArr2[2]);
        }
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        if (zArr[4]) {
            flatBufferBuilder.a(25, iArr2[1], 0);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(26, iArr2[2], 0);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(27, iArr2[3], 0);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(28, iArr2[4], 0);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(29, iArr2[5], 0);
        }
        flatBufferBuilder.b(30, iArr[30]);
        flatBufferBuilder.b(31, iArr[31]);
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(35, iArr[35]);
        flatBufferBuilder.b(36, iArr[36]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m6200a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6199a(jsonParser, flatBufferBuilder);
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

    public static void m6201a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("account_user");
            GraphQLUserDeserializer.m6152b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("actor");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("additional_suggested_post_ads");
            GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer.m4530a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("audience_info");
            GraphQLAudienceInfoDeserializer.m4599a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("composer_privacy_options");
            GraphQLPrivacyOptionsComposerConnectionDeserializer.m5693a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("current_location_page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("currently_processing_profile_video_content_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("daily_dialogue_pinned_unit");
            GraphQLCustomizedStoryDeserializer.m4705a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("debug_feed");
            GraphQLDebugFeedConnectionDeserializer.m4708a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 9, 0);
        if (g != 0) {
            jsonGenerator.a("event_invitee_limit");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("friending_possibilities");
            GraphQLFriendingPossibilitiesConnectionDeserializer.m4941a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("group_commerce_suggested_location");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("happy_birthday_card");
            GraphQLGoodwillHappyBirthdayCardDeserializer.m5016a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("has_editable_search_history");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("is_fb_employee");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("is_work_user");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("large_image_page_like_ads");
            GraphQLStatelessLargeImagePLAsConnectionDeserializer.m5941a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("megaphone");
            GraphQLMegaphoneDeserializer.m5366a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("news_feed");
            GraphQLNewsFeedConnectionDeserializer.m5423a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("prefilled_greeting_card");
            GraphQLGreetingCardDeserializer.m5123a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 22) != 0) {
            jsonGenerator.a("primary_email");
            jsonGenerator.b(mutableFlatBuffer.c(i, 22));
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("side_feed");
            GraphQLSideFeedConnectionDeserializer.m5882a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("taggable_activities");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLTaggableActivityDeserializer.m6035b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.a(i, 25, 0);
        if (g != 0) {
            jsonGenerator.a("video_home_badge_check_interval_s");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 26, 0);
        if (g != 0) {
            jsonGenerator.a("video_home_badge_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 27, 0);
        if (g != 0) {
            jsonGenerator.a("video_home_max_badge_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 28, 0);
        if (g != 0) {
            jsonGenerator.a("video_home_prefetch_unit_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.a(i, 29, 0);
        if (g != 0) {
            jsonGenerator.a("video_home_stale_data_interval_s");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 30);
        if (g != 0) {
            jsonGenerator.a("viewer_tag_suggestions_mediaset");
            GraphQLMediaSetDeserializer.m5357a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 31);
        if (g != 0) {
            jsonGenerator.a("work_community");
            GraphQLGroupDeserializer.m5159a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 33);
        if (g != 0) {
            jsonGenerator.a("instream_video_ads");
            GraphQLInstreamVideoAdsConnectionDeserializer.m5270a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 35) != 0) {
            jsonGenerator.a("work_subdomain");
            jsonGenerator.b(mutableFlatBuffer.c(i, 35));
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("eligible_clash_units");
            GraphQLEligibleClashUnitsConnectionDeserializer.m4730a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
