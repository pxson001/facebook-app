package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLStoryTimestampStyle;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: mobile_sidebar */
public class GraphQLStoryDeserializer {
    public static int m5962a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[91];
        boolean[] zArr = new boolean[19];
        boolean[] zArr2 = new boolean[13];
        int[] iArr2 = new int[2];
        long[] jArr = new long[3];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("action_links")) {
                    iArr[0] = GraphQLStoryActionLinkDeserializer.m5951b(jsonParser, flatBufferBuilder);
                } else if (i.equals("actions")) {
                    iArr[1] = GraphQLOpenGraphActionDeserializer.m5460b(jsonParser, flatBufferBuilder);
                } else if (i.equals("actors")) {
                    iArr[3] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("all_substories")) {
                    iArr[4] = GraphQLSubstoriesConnectionDeserializer.m6014a(jsonParser, flatBufferBuilder);
                } else if (i.equals("android_urls")) {
                    iArr[5] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("app_icon")) {
                    iArr[6] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("application")) {
                    iArr[7] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attached_action_links")) {
                    iArr[8] = GraphQLStoryActionLinkDeserializer.m5951b(jsonParser, flatBufferBuilder);
                } else if (i.equals("attached_story")) {
                    iArr[9] = m5962a(jsonParser, flatBufferBuilder);
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
                } else if (i.equals("composerSessionId")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("container_object_story")) {
                    iArr[19] = m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("creation_time")) {
                    zArr[6] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("debug_info")) {
                    iArr[21] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("display_explanation")) {
                    iArr[22] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("edit_history")) {
                    iArr[23] = GraphQLEditHistoryConnectionDeserializer.m4721a(jsonParser, flatBufferBuilder);
                } else if (i.equals("explicit_place")) {
                    iArr[24] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feed_topic_content")) {
                    iArr[25] = GraphQLFeedTopicContentDeserializer.m4882a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[26] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback_context")) {
                    iArr[27] = GraphQLFeedbackContextDeserializer.m4889a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fetchTimeMs")) {
                    zArr[7] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("followup_feed_units")) {
                    iArr[29] = GraphQLFollowUpFeedUnitsConnectionDeserializer.m4922a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_comprehensive_title")) {
                    zArr[8] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("hideable_token")) {
                    iArr[31] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("icon")) {
                    iArr[33] = GraphQLIconDeserializer.m5219a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[34] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("implicit_place")) {
                    iArr[35] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("inline_activities")) {
                    iArr[36] = GraphQLInlineActivitiesConnectionDeserializer.m5244a(jsonParser, flatBufferBuilder);
                } else if (i.equals("insights")) {
                    iArr[37] = GraphQLStoryInsightsDeserializer.m5973a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_see_first_bumped")) {
                    zArr[9] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("legacy_api_story_id")) {
                    iArr[39] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("message")) {
                    iArr[40] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("multiShareAttachmentWithImageFields")) {
                    iArr[41] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[42] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place")) {
                    iArr[43] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("place_recommendation_info")) {
                    iArr[44] = GraphQLPlaceRecommendationPostInfoDeserializer.m5660a(jsonParser, flatBufferBuilder);
                } else if (i.equals("post_promotion_info")) {
                    iArr[45] = GraphQLBoostedComponentDeserializer.m4611a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_scope")) {
                    iArr[47] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("promotion_info")) {
                    iArr[48] = GraphQLPagePostPromotionInfoDeserializer.m5518a(jsonParser, flatBufferBuilder);
                } else if (i.equals("redspace_story")) {
                    iArr[49] = GraphQLRedSpaceStoryInfoDeserializer.m5796a(jsonParser, flatBufferBuilder);
                } else if (i.equals("referenced_sticker")) {
                    iArr[50] = GraphQLStickerDeserializer.m5945a(jsonParser, flatBufferBuilder);
                } else if (i.equals("save_info")) {
                    iArr[51] = GraphQLStorySaveInfoDeserializer.m5976a(jsonParser, flatBufferBuilder);
                } else if (i.equals("see_first_actors")) {
                    iArr[52] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("seen_state")) {
                    zArr[10] = true;
                    enumArr[0] = GraphQLStorySeenState.fromString(jsonParser.o());
                } else if (i.equals("shareable")) {
                    iArr[54] = GraphQLEntityDeserializer.m4763a(jsonParser, flatBufferBuilder);
                } else if (i.equals("shortSummary")) {
                    iArr[55] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("short_term_cache_key")) {
                    iArr[56] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sponsored_data")) {
                    iArr[57] = GraphQLSponsoredDataDeserializer.m5921a(jsonParser, flatBufferBuilder);
                } else if (i.equals("storyAttachment")) {
                    iArr[58] = GraphQLStoryAttachmentDeserializer.m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("story_header")) {
                    iArr[59] = GraphQLStoryHeaderDeserializer.m5970a(jsonParser, flatBufferBuilder);
                } else if (i.equals("story_timestamp_style_list")) {
                    iArr[60] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLStoryTimestampStyle.class);
                } else if (i.equals("substories_grouping_reasons")) {
                    iArr[61] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLSubstoriesGroupingReason.class);
                } else if (i.equals("substory_count")) {
                    zArr[11] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("suffix")) {
                    iArr[63] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("summary")) {
                    iArr[64] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("supplemental_social_story")) {
                    iArr[65] = m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title")) {
                    iArr[66] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("titleForSummary")) {
                    iArr[67] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("to")) {
                    iArr[69] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("topics_context")) {
                    iArr[70] = GraphQLStoryTopicsContextDeserializer.m5988a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
                    iArr[71] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("translatability_for_viewer")) {
                    iArr[72] = GraphQLPostTranslatabilityDeserializer.m5682a(jsonParser, flatBufferBuilder);
                } else if (i.equals("translated_message_for_viewer")) {
                    iArr[73] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("translation_metadata")) {
                    iArr[74] = GraphQLTranslationMetaDataDeserializer.m6121a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[76] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("via")) {
                    iArr[77] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_readstate")) {
                    zArr[12] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("with_tags")) {
                    iArr[79] = GraphQLWithTagsConnectionDeserializer.m6205a(jsonParser, flatBufferBuilder);
                } else if (i.equals("viewer_edit_post_feature_capabilities")) {
                    iArr[80] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLEditPostFeatureCapability.class);
                } else if (i.equals("local_group_did_approve")) {
                    zArr[13] = true;
                    zArr2[9] = jsonParser.H();
                } else if (i.equals("local_group_did_ignore_report")) {
                    zArr[14] = true;
                    zArr2[10] = jsonParser.H();
                } else if (i.equals("local_group_did_pin")) {
                    zArr[15] = true;
                    zArr2[11] = jsonParser.H();
                } else if (i.equals("local_group_did_unpin")) {
                    zArr[16] = true;
                    zArr2[12] = jsonParser.H();
                } else if (i.equals("local_last_negative_feedback_action_type")) {
                    iArr[85] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("local_story_visibility")) {
                    iArr[86] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("story_ranking_time")) {
                    zArr[17] = true;
                    jArr[2] = jsonParser.F();
                } else if (i.equals("message_markdown_html")) {
                    iArr[88] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("local_story_visible_height")) {
                    zArr[18] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("backdated_time")) {
                    iArr[90] = GraphQLBackdatedTimeDeserializer.m4605a(jsonParser, flatBufferBuilder);
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
        flatBufferBuilder.b(19, iArr[19]);
        if (zArr[6]) {
            flatBufferBuilder.a(20, jArr[0], 0);
        }
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        flatBufferBuilder.b(26, iArr[26]);
        flatBufferBuilder.b(27, iArr[27]);
        if (zArr[7]) {
            flatBufferBuilder.a(28, jArr[1], 0);
        }
        flatBufferBuilder.b(29, iArr[29]);
        if (zArr[8]) {
            flatBufferBuilder.a(30, zArr2[6]);
        }
        flatBufferBuilder.b(31, iArr[31]);
        flatBufferBuilder.b(33, iArr[33]);
        flatBufferBuilder.b(34, iArr[34]);
        flatBufferBuilder.b(35, iArr[35]);
        flatBufferBuilder.b(36, iArr[36]);
        flatBufferBuilder.b(37, iArr[37]);
        if (zArr[9]) {
            flatBufferBuilder.a(38, zArr2[7]);
        }
        flatBufferBuilder.b(39, iArr[39]);
        flatBufferBuilder.b(40, iArr[40]);
        flatBufferBuilder.b(41, iArr[41]);
        flatBufferBuilder.b(42, iArr[42]);
        flatBufferBuilder.b(43, iArr[43]);
        flatBufferBuilder.b(44, iArr[44]);
        flatBufferBuilder.b(45, iArr[45]);
        flatBufferBuilder.b(47, iArr[47]);
        flatBufferBuilder.b(48, iArr[48]);
        flatBufferBuilder.b(49, iArr[49]);
        flatBufferBuilder.b(50, iArr[50]);
        flatBufferBuilder.b(51, iArr[51]);
        flatBufferBuilder.b(52, iArr[52]);
        if (zArr[10]) {
            flatBufferBuilder.a(53, enumArr[0]);
        }
        flatBufferBuilder.b(54, iArr[54]);
        flatBufferBuilder.b(55, iArr[55]);
        flatBufferBuilder.b(56, iArr[56]);
        flatBufferBuilder.b(57, iArr[57]);
        flatBufferBuilder.b(58, iArr[58]);
        flatBufferBuilder.b(59, iArr[59]);
        flatBufferBuilder.b(60, iArr[60]);
        flatBufferBuilder.b(61, iArr[61]);
        if (zArr[11]) {
            flatBufferBuilder.a(62, iArr2[0], 0);
        }
        flatBufferBuilder.b(63, iArr[63]);
        flatBufferBuilder.b(64, iArr[64]);
        flatBufferBuilder.b(65, iArr[65]);
        flatBufferBuilder.b(66, iArr[66]);
        flatBufferBuilder.b(67, iArr[67]);
        flatBufferBuilder.b(69, iArr[69]);
        flatBufferBuilder.b(70, iArr[70]);
        flatBufferBuilder.b(71, iArr[71]);
        flatBufferBuilder.b(72, iArr[72]);
        flatBufferBuilder.b(73, iArr[73]);
        flatBufferBuilder.b(74, iArr[74]);
        flatBufferBuilder.b(76, iArr[76]);
        flatBufferBuilder.b(77, iArr[77]);
        if (zArr[12]) {
            flatBufferBuilder.a(78, zArr2[8]);
        }
        flatBufferBuilder.b(79, iArr[79]);
        flatBufferBuilder.b(80, iArr[80]);
        if (zArr[13]) {
            flatBufferBuilder.a(81, zArr2[9]);
        }
        if (zArr[14]) {
            flatBufferBuilder.a(82, zArr2[10]);
        }
        if (zArr[15]) {
            flatBufferBuilder.a(83, zArr2[11]);
        }
        if (zArr[16]) {
            flatBufferBuilder.a(84, zArr2[12]);
        }
        flatBufferBuilder.b(85, iArr[85]);
        flatBufferBuilder.b(86, iArr[86]);
        if (zArr[17]) {
            flatBufferBuilder.a(87, jArr[2], 0);
        }
        flatBufferBuilder.b(88, iArr[88]);
        if (zArr[18]) {
            flatBufferBuilder.a(89, iArr2[1], 0);
        }
        flatBufferBuilder.b(90, iArr[90]);
        return flatBufferBuilder.d();
    }

    public static int m5965b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5962a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5963a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5962a(jsonParser, flatBufferBuilder);
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

    public static void m5964a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5966b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5966b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("action_links");
            GraphQLStoryActionLinkDeserializer.m5950a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("actions");
            GraphQLOpenGraphActionDeserializer.m5459a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("actors");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("all_substories");
            GraphQLSubstoriesConnectionDeserializer.m6016a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("android_urls");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 5), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("app_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
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
            m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
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
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("composerSessionId");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("container_object_story");
            m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        long a2 = mutableFlatBuffer.a(i, 20, 0);
        if (a2 != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 21) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 21));
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("display_explanation");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("edit_history");
            GraphQLEditHistoryConnectionDeserializer.m4723a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 24);
        if (g != 0) {
            jsonGenerator.a("explicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("feed_topic_content");
            GraphQLFeedTopicContentDeserializer.m4884a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 26);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 27);
        if (g != 0) {
            jsonGenerator.a("feedback_context");
            GraphQLFeedbackContextDeserializer.m4891a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 28, 0);
        if (a2 != 0) {
            jsonGenerator.a("fetchTimeMs");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 29);
        if (g != 0) {
            jsonGenerator.a("followup_feed_units");
            GraphQLFollowUpFeedUnitsConnectionDeserializer.m4924a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 30);
        if (a) {
            jsonGenerator.a("has_comprehensive_title");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 31) != 0) {
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 31));
        }
        g = mutableFlatBuffer.g(i, 33);
        if (g != 0) {
            jsonGenerator.a("icon");
            GraphQLIconDeserializer.m5221a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 34));
        }
        g = mutableFlatBuffer.g(i, 35);
        if (g != 0) {
            jsonGenerator.a("implicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 36);
        if (g != 0) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnectionDeserializer.m5246a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 37);
        if (g != 0) {
            jsonGenerator.a("insights");
            GraphQLStoryInsightsDeserializer.m5975a(mutableFlatBuffer, g, jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 38);
        if (a) {
            jsonGenerator.a("is_see_first_bumped");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 39) != 0) {
            jsonGenerator.a("legacy_api_story_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 39));
        }
        g = mutableFlatBuffer.g(i, 40);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 41);
        if (g != 0) {
            jsonGenerator.a("multiShareAttachmentWithImageFields");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 42);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 43);
        if (g != 0) {
            jsonGenerator.a("place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 44);
        if (g != 0) {
            jsonGenerator.a("place_recommendation_info");
            GraphQLPlaceRecommendationPostInfoDeserializer.m5662a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 45);
        if (g != 0) {
            jsonGenerator.a("post_promotion_info");
            GraphQLBoostedComponentDeserializer.m4613a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 47);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 48);
        if (g != 0) {
            jsonGenerator.a("promotion_info");
            GraphQLPagePostPromotionInfoDeserializer.m5520a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 49);
        if (g != 0) {
            jsonGenerator.a("redspace_story");
            GraphQLRedSpaceStoryInfoDeserializer.m5798a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 50);
        if (g != 0) {
            jsonGenerator.a("referenced_sticker");
            GraphQLStickerDeserializer.m5947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 51);
        if (g != 0) {
            jsonGenerator.a("save_info");
            GraphQLStorySaveInfoDeserializer.m5978a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 52);
        if (g != 0) {
            jsonGenerator.a("see_first_actors");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 53, (short) 0) != (short) 0) {
            jsonGenerator.a("seen_state");
            jsonGenerator.b(((GraphQLStorySeenState) mutableFlatBuffer.a(i, 53, GraphQLStorySeenState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 54);
        if (g != 0) {
            jsonGenerator.a("shareable");
            GraphQLEntityDeserializer.m4766b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 55);
        if (g != 0) {
            jsonGenerator.a("shortSummary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 56) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 56));
        }
        g = mutableFlatBuffer.g(i, 57);
        if (g != 0) {
            jsonGenerator.a("sponsored_data");
            GraphQLSponsoredDataDeserializer.m5923a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 58);
        if (g != 0) {
            jsonGenerator.a("storyAttachment");
            GraphQLStoryAttachmentDeserializer.m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 59);
        if (g != 0) {
            jsonGenerator.a("story_header");
            GraphQLStoryHeaderDeserializer.m5972a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 60) != 0) {
            jsonGenerator.a("story_timestamp_style_list");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 60), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 61) != 0) {
            jsonGenerator.a("substories_grouping_reasons");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 61), jsonGenerator);
        }
        g = mutableFlatBuffer.a(i, 62, 0);
        if (g != 0) {
            jsonGenerator.a("substory_count");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 63);
        if (g != 0) {
            jsonGenerator.a("suffix");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 64);
        if (g != 0) {
            jsonGenerator.a("summary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 65);
        if (g != 0) {
            jsonGenerator.a("supplemental_social_story");
            m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 66);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 67);
        if (g != 0) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 69);
        if (g != 0) {
            jsonGenerator.a("to");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 70);
        if (g != 0) {
            jsonGenerator.a("topics_context");
            GraphQLStoryTopicsContextDeserializer.m5990a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 71) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 71));
        }
        g = mutableFlatBuffer.g(i, 72);
        if (g != 0) {
            jsonGenerator.a("translatability_for_viewer");
            GraphQLPostTranslatabilityDeserializer.m5684a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 73);
        if (g != 0) {
            jsonGenerator.a("translated_message_for_viewer");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 74);
        if (g != 0) {
            jsonGenerator.a("translation_metadata");
            GraphQLTranslationMetaDataDeserializer.m6123a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 76) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 76));
        }
        g = mutableFlatBuffer.g(i, 77);
        if (g != 0) {
            jsonGenerator.a("via");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 78);
        if (a) {
            jsonGenerator.a("viewer_readstate");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 79);
        if (g != 0) {
            jsonGenerator.a("with_tags");
            GraphQLWithTagsConnectionDeserializer.m6207a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 80) != 0) {
            jsonGenerator.a("viewer_edit_post_feature_capabilities");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 80), jsonGenerator);
        }
        a = mutableFlatBuffer.a(i, 81);
        if (a) {
            jsonGenerator.a("local_group_did_approve");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 82);
        if (a) {
            jsonGenerator.a("local_group_did_ignore_report");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 83);
        if (a) {
            jsonGenerator.a("local_group_did_pin");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 84);
        if (a) {
            jsonGenerator.a("local_group_did_unpin");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 85) != 0) {
            jsonGenerator.a("local_last_negative_feedback_action_type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 85));
        }
        if (mutableFlatBuffer.g(i, 86) != 0) {
            jsonGenerator.a("local_story_visibility");
            jsonGenerator.b(mutableFlatBuffer.c(i, 86));
        }
        a2 = mutableFlatBuffer.a(i, 87, 0);
        if (a2 != 0) {
            jsonGenerator.a("story_ranking_time");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 88);
        if (g != 0) {
            jsonGenerator.a("message_markdown_html");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 89, 0);
        if (g != 0) {
            jsonGenerator.a("local_story_visible_height");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 90);
        if (g != 0) {
            jsonGenerator.a("backdated_time");
            GraphQLBackdatedTimeDeserializer.m4607a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }
}
