package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_finch_liked_pages */
public class GraphQLGoodwillThrowbackFeedUnitDeserializer {
    public static int m5032a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[65];
        boolean[] zArr = new boolean[9];
        boolean[] zArr2 = new boolean[7];
        int[] iArr2 = new int[1];
        long[] jArr = new long[1];
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
                } else if (i.equals("actions")) {
                    iArr[3] = GraphQLOpenGraphActionDeserializer.m5460b(jsonParser, flatBufferBuilder);
                } else if (i.equals("actors")) {
                    iArr[4] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("all_substories")) {
                    iArr[5] = GraphQLSubstoriesConnectionDeserializer.m6014a(jsonParser, flatBufferBuilder);
                } else if (i.equals("anniversary_campaign")) {
                    iArr[6] = GraphQLGoodwillAnniversaryCampaignDeserializer.m4996a(jsonParser, flatBufferBuilder);
                } else if (i.equals("application")) {
                    iArr[7] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attached_action_links")) {
                    iArr[8] = GraphQLStoryActionLinkDeserializer.m5951b(jsonParser, flatBufferBuilder);
                } else if (i.equals("attached_story")) {
                    iArr[9] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attachments")) {
                    iArr[10] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("cache_id")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("can_viewer_append_photos")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_delete")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_edit")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_edit_post_media")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("can_viewer_edit_post_privacy")) {
                    zArr[4] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("can_viewer_edit_tag")) {
                    zArr[5] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("color_palette")) {
                    iArr[18] = GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer.m5053a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creation_time")) {
                    zArr[6] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("debug_info")) {
                    iArr[20] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("display_explanation")) {
                    iArr[21] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("edit_history")) {
                    iArr[22] = GraphQLEditHistoryConnectionDeserializer.m4721a(jsonParser, flatBufferBuilder);
                } else if (i.equals("explicit_place")) {
                    iArr[23] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feed_topic_content")) {
                    iArr[24] = GraphQLFeedTopicContentDeserializer.m4882a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[25] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friend_description")) {
                    iArr[26] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friend_list")) {
                    iArr[27] = GraphQLGoodwillThrowbackFriendListConnectionDeserializer.m5035a(jsonParser, flatBufferBuilder);
                } else if (i.equals("friendversary_campaign")) {
                    iArr[28] = GraphQLGoodwillFriendversaryCampaignDeserializer.m5011a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_comprehensive_title")) {
                    zArr[7] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("hideable_token")) {
                    iArr[30] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[31] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("implicit_place")) {
                    iArr[32] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[33] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("legacy_api_story_id")) {
                    iArr[34] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("message")) {
                    iArr[35] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[36] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("photo_attachments")) {
                    iArr[37] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("photo_stories")) {
                    iArr[38] = GraphQLStoryDeserializer.m5965b(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_recommendation_info")) {
                    iArr[39] = GraphQLPlaceRecommendationPostInfoDeserializer.m5660a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_scope")) {
                    iArr[41] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("referenced_sticker")) {
                    iArr[42] = GraphQLStickerDeserializer.m5945a(jsonParser, flatBufferBuilder);
                } else if (i.equals("save_info")) {
                    iArr[43] = GraphQLStorySaveInfoDeserializer.m5976a(jsonParser, flatBufferBuilder);
                } else if (i.equals("section_header")) {
                    iArr[44] = GraphQLGoodwillThrowbackSectionDeserializer.m5068a(jsonParser, flatBufferBuilder);
                } else if (i.equals("shareable")) {
                    iArr[45] = GraphQLEntityDeserializer.m4763a(jsonParser, flatBufferBuilder);
                } else if (i.equals("sponsored_data")) {
                    iArr[46] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("story_header")) {
                    iArr[47] = GraphQLStoryHeaderDeserializer.m5970a(jsonParser, flatBufferBuilder);
                } else if (i.equals("substories_grouping_reasons")) {
                    iArr[48] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLSubstoriesGroupingReason.class);
                } else if (i.equals("substory_count")) {
                    zArr[8] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("subtitle")) {
                    iArr[50] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("suffix")) {
                    iArr[51] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("supplemental_social_story")) {
                    iArr[52] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title")) {
                    iArr[53] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("to")) {
                    iArr[54] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("topics_context")) {
                    iArr[55] = GraphQLStoryTopicsContextDeserializer.m5988a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
                    iArr[56] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("translatability_for_viewer")) {
                    iArr[57] = GraphQLPostTranslatabilityDeserializer.m5682a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[59] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("via")) {
                    iArr[60] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("with_tags")) {
                    iArr[61] = GraphQLWithTagsConnectionDeserializer.m6205a(jsonParser, flatBufferBuilder);
                } else if (i.equals("render_style")) {
                    iArr[62] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("viewer_edit_post_feature_capabilities")) {
                    iArr[63] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLEditPostFeatureCapability.class);
                } else if (i.equals("message_markdown_html")) {
                    iArr[64] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(65);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        if (zArr[0]) {
            flatBufferBuilder.a(12, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(13, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(14, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(15, zArr2[3]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(16, zArr2[4]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(17, zArr2[5]);
        }
        flatBufferBuilder.b(18, iArr[18]);
        if (zArr[6]) {
            flatBufferBuilder.a(19, jArr[0], 0);
        }
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        flatBufferBuilder.b(28, iArr[28]);
        if (zArr[7]) {
            flatBufferBuilder.a(29, zArr2[6]);
        }
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
        flatBufferBuilder.b(41, iArr[41]);
        flatBufferBuilder.b(42, iArr[42]);
        flatBufferBuilder.b(43, iArr[43]);
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(46, iArr[46]);
        flatBufferBuilder.b(47, iArr[47]);
        flatBufferBuilder.b(48, iArr[48]);
        if (zArr[8]) {
            flatBufferBuilder.a(49, iArr2[0], 0);
        }
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(51, iArr[51]);
        flatBufferBuilder.b(52, iArr[52]);
        flatBufferBuilder.b(53, iArr[53]);
        flatBufferBuilder.b(54, iArr[54]);
        flatBufferBuilder.b(55, iArr[55]);
        flatBufferBuilder.b(56, iArr[56]);
        flatBufferBuilder.b(57, iArr[57]);
        flatBufferBuilder.b(59, iArr[59]);
        flatBufferBuilder.b(60, iArr[60]);
        flatBufferBuilder.b(61, iArr[61]);
        flatBufferBuilder.b(62, iArr[62]);
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5033a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5032a(jsonParser, flatBufferBuilder);
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

    public static void m5034a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("actions");
            GraphQLOpenGraphActionDeserializer.m5459a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("actors");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("all_substories");
            GraphQLSubstoriesConnectionDeserializer.m6016a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("anniversary_campaign");
            GraphQLGoodwillAnniversaryCampaignDeserializer.m4998a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("application");
            GraphQLApplicationDeserializer.m4581a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("attached_action_links");
            GraphQLStoryActionLinkDeserializer.m5950a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("attached_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("attachments");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        boolean a = mutableFlatBuffer.a(i, 12);
        if (a) {
            jsonGenerator.a("can_viewer_append_photos");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("can_viewer_delete");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("can_viewer_edit");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("can_viewer_edit_post_media");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("can_viewer_edit_post_privacy");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 17);
        if (a) {
            jsonGenerator.a("can_viewer_edit_tag");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("color_palette");
            GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer.m5055a(mutableFlatBuffer, g, jsonGenerator);
        }
        long a2 = mutableFlatBuffer.a(i, 19, 0);
        if (a2 != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 20));
        }
        g = mutableFlatBuffer.g(i, 21);
        if (g != 0) {
            jsonGenerator.a("display_explanation");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("edit_history");
            GraphQLEditHistoryConnectionDeserializer.m4723a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("explicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("feed_topic_content");
            GraphQLFeedTopicContentDeserializer.m4884a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("friend_description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("friend_list");
            GraphQLGoodwillThrowbackFriendListConnectionDeserializer.m5037a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 28);
        if (g != 0) {
            jsonGenerator.a("friendversary_campaign");
            GraphQLGoodwillFriendversaryCampaignDeserializer.m5013a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 29);
        if (a) {
            jsonGenerator.a("has_comprehensive_title");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 30) != 0) {
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 30));
        }
        if (mutableFlatBuffer.g(i, 31) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 31));
        }
        g = mutableFlatBuffer.g(i, 32);
        if (g != 0) {
            jsonGenerator.a("implicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 33);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("legacy_api_story_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 34));
        }
        g = mutableFlatBuffer.g(i, 35);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 37);
        if (g != 0) {
            jsonGenerator.a("photo_attachments");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 38);
        if (g != 0) {
            jsonGenerator.a("photo_stories");
            GraphQLStoryDeserializer.m5964a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 39);
        if (g != 0) {
            jsonGenerator.a("place_recommendation_info");
            GraphQLPlaceRecommendationPostInfoDeserializer.m5662a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 41);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 42);
        if (g != 0) {
            jsonGenerator.a("referenced_sticker");
            GraphQLStickerDeserializer.m5947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("save_info");
            GraphQLStorySaveInfoDeserializer.m5978a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("section_header");
            GraphQLGoodwillThrowbackSectionDeserializer.m5070a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("shareable");
            GraphQLEntityDeserializer.m4766b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 46);
        if (g != 0) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeaderDeserializer.m5972a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 48) != 0) {
            jsonGenerator.a("substories_grouping_reasons");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 48), jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 49, 0);
        if (g != 0) {
            jsonGenerator.a("substory_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 50);
        if (g != 0) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 51);
        if (g != 0) {
            jsonGenerator.a("suffix");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 52);
        if (g != 0) {
            jsonGenerator.a("supplemental_social_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 53);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 54);
        if (g != 0) {
            jsonGenerator.a("to");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 55);
        if (g != 0) {
            jsonGenerator.a("topics_context");
            GraphQLStoryTopicsContextDeserializer.m5990a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 56) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 56));
        }
        g = mutableFlatBuffer.g(i, 57);
        if (g != 0) {
            jsonGenerator.a("translatability_for_viewer");
            GraphQLPostTranslatabilityDeserializer.m5684a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 59) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 59));
        }
        g = mutableFlatBuffer.g(i, 60);
        if (g != 0) {
            jsonGenerator.a("via");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 61);
        if (g != 0) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnectionDeserializer.m6207a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 62) != 0) {
            jsonGenerator.a("render_style");
            jsonGenerator.b(mutableFlatBuffer.c(i, 62));
        }
        if (mutableFlatBuffer.g(i, 63) != 0) {
            jsonGenerator.a("viewer_edit_post_feature_capabilities");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 63), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 64);
        if (g != 0) {
            jsonGenerator.a("message_markdown_html");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
