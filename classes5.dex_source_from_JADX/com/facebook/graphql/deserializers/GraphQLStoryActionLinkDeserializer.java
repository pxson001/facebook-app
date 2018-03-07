package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: modeQueryName */
public class GraphQLStoryActionLinkDeserializer {
    public static int m5948a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[91];
        boolean[] zArr = new boolean[14];
        boolean[] zArr2 = new boolean[6];
        int[] iArr2 = new int[3];
        long[] jArr = new long[1];
        Enum[] enumArr = new Enum[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("action_link_type")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLProfilePictureActionLinkType.fromString(jsonParser.o());
                } else if (i.equals("ad_id")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("agree_to_privacy_text")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("android_minimal_screen_form_height")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("android_small_screen_phone_threshold")) {
                    zArr[2] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("can_viewer_add_contributors")) {
                    zArr[3] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_watch_and_browse")) {
                    zArr[4] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("collection")) {
                    iArr[8] = GraphQLTimelineAppCollectionDeserializer.m6066a(jsonParser, flatBufferBuilder);
                } else if (i.equals("coupon")) {
                    iArr[9] = GraphQLCouponDeserializer.m4686a(jsonParser, flatBufferBuilder);
                } else if (i.equals("default_expiration_time")) {
                    zArr[5] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("description")) {
                    iArr[11] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("destination_type")) {
                    zArr[6] = true;
                    enumArr[1] = GraphQLStoryActionLinkDestinationType.fromString(jsonParser.o());
                } else if (i.equals("disclaimer_accept_button_text")) {
                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("disclaimer_continue_button_text")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("error_codes")) {
                    iArr[15] = GraphQLLeadGenErrorNodeDeserializer.m5293b(jsonParser, flatBufferBuilder);
                } else if (i.equals("error_message_brief")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("error_message_detail")) {
                    iArr[17] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("event")) {
                    iArr[18] = GraphQLEventDeserializer.m4792a(jsonParser, flatBufferBuilder);
                } else if (i.equals("fb_data_policy_setting_description")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fb_data_policy_url")) {
                    iArr[20] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("feedback")) {
                    iArr[21] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("follow_up_action_text")) {
                    iArr[22] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("follow_up_action_url")) {
                    iArr[23] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("group")) {
                    iArr[24] = GraphQLGroupDeserializer.m5157a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_story_chattable_members")) {
                    iArr[25] = GraphQLGroupMessageChattableMembersConnectionDeserializer.m5176a(jsonParser, flatBufferBuilder);
                } else if (i.equals("info")) {
                    iArr[26] = GraphQLOverlayCallToActionInfoDeserializer.m5473a(jsonParser, flatBufferBuilder);
                } else if (i.equals("item")) {
                    iArr[27] = GraphQLNodeDeserializer.m5436a(jsonParser, flatBufferBuilder);
                } else if (i.equals("landing_page_cta")) {
                    iArr[28] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("landing_page_redirect_instruction")) {
                    iArr[29] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("lead_gen_data")) {
                    iArr[30] = GraphQLLeadGenDataDeserializer.m5283a(jsonParser, flatBufferBuilder);
                } else if (i.equals("lead_gen_data_id")) {
                    iArr[31] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("lead_gen_deep_link_user_status")) {
                    iArr[32] = GraphQLLeadGenDeepLinkUserStatusDeserializer.m5286a(jsonParser, flatBufferBuilder);
                } else if (i.equals("lead_gen_user_status")) {
                    iArr[33] = GraphQLLeadGenUserStatusDeserializer.m5312a(jsonParser, flatBufferBuilder);
                } else if (i.equals("link_description")) {
                    iArr[34] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_display")) {
                    iArr[35] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_icon_image")) {
                    iArr[36] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("link_style")) {
                    zArr[7] = true;
                    enumArr[2] = GraphQLCallToActionStyle.fromString(jsonParser.o());
                } else if (i.equals("link_target_store_data")) {
                    iArr[38] = GraphQLLinkTargetStoreDataDeserializer.m5324a(jsonParser, flatBufferBuilder);
                } else if (i.equals("link_title")) {
                    iArr[39] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_type")) {
                    zArr[8] = true;
                    enumArr[3] = GraphQLCallToActionType.fromString(jsonParser.o());
                } else if (i.equals("link_video_endscreen_icon")) {
                    iArr[41] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message")) {
                    iArr[42] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("nux_description")) {
                    iArr[43] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("nux_title")) {
                    iArr[44] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("page")) {
                    iArr[45] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("parent_story")) {
                    iArr[46] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("primary_button_text")) {
                    iArr[47] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_checkbox_error")) {
                    iArr[48] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_scope")) {
                    iArr[49] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_setting_description")) {
                    iArr[50] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("profile")) {
                    iArr[51] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("progress_text")) {
                    iArr[52] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("promotion_tag")) {
                    iArr[53] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("review")) {
                    iArr[54] = GraphQLContactRecommendationFieldDeserializer.m4683a(jsonParser, flatBufferBuilder);
                } else if (i.equals("secure_sharing_text")) {
                    iArr[55] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("select_text_hint")) {
                    iArr[56] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("send_description")) {
                    iArr[57] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sent_text")) {
                    iArr[58] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("share_id")) {
                    iArr[59] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("short_secure_sharing_text")) {
                    iArr[60] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("show_even_if_installed")) {
                    zArr[9] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("show_in_feed")) {
                    zArr[10] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("show_in_permalink")) {
                    zArr[11] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("skip_experiments")) {
                    zArr[12] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("split_flow_landing_page_hint_text")) {
                    iArr[65] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("split_flow_landing_page_hint_title")) {
                    iArr[66] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("stateful_title")) {
                    iArr[67] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sticker")) {
                    iArr[68] = GraphQLImageOverlayDeserializer.m5226a(jsonParser, flatBufferBuilder);
                } else if (i.equals("submit_card_instruction_text")) {
                    iArr[69] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tagged_and_mentioned_users")) {
                    iArr[70] = C0239xb10bb428.m4576a(jsonParser, flatBufferBuilder);
                } else if (i.equals("temporal_event_info")) {
                    iArr[71] = GraphQLTemporalEventInfoDeserializer.m6053a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title")) {
                    iArr[72] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("topic")) {
                    iArr[73] = GraphQLTopicDeserializer.m6113a(jsonParser, flatBufferBuilder);
                } else if (i.equals("unsubscribe_description")) {
                    iArr[74] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[75] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("prompt_id")) {
                    iArr[76] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("page_outcome_button")) {
                    iArr[77] = GraphQLPageOutcomeButtonDeserializer.m5515a(jsonParser, flatBufferBuilder);
                } else if (i.equals("frame_id")) {
                    iArr[78] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_annotations")) {
                    iArr[79] = GraphQLVideoAnnotationDeserializer.m6172b(jsonParser, flatBufferBuilder);
                } else if (i.equals("story")) {
                    iArr[80] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("hoisted_story_ids")) {
                    iArr[81] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("followup_choices")) {
                    iArr[82] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("followup_question")) {
                    iArr[83] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("main_choices")) {
                    iArr[84] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("main_question")) {
                    iArr[85] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("featured_instant_article_element")) {
                    iArr[86] = GraphQLDocumentElementDeserializer.m4715a(jsonParser, flatBufferBuilder);
                } else if (i.equals("instant_article")) {
                    iArr[87] = GraphQLInstantArticleDeserializer.m5262a(jsonParser, flatBufferBuilder);
                } else if (i.equals("header_color")) {
                    iArr[88] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("logo_uri")) {
                    iArr[89] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("rating")) {
                    zArr[13] = true;
                    iArr2[2] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(91);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, iArr2[0], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(5, iArr2[1], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(6, zArr2[0]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(7, zArr2[1]);
        }
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        if (zArr[5]) {
            flatBufferBuilder.a(10, jArr[0], 0);
        }
        flatBufferBuilder.b(11, iArr[11]);
        if (zArr[6]) {
            flatBufferBuilder.a(12, enumArr[1]);
        }
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(21, iArr[21]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
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
        flatBufferBuilder.b(36, iArr[36]);
        if (zArr[7]) {
            flatBufferBuilder.a(37, enumArr[2]);
        }
        flatBufferBuilder.b(38, iArr[38]);
        flatBufferBuilder.b(39, iArr[39]);
        if (zArr[8]) {
            flatBufferBuilder.a(40, enumArr[3]);
        }
        flatBufferBuilder.b(41, iArr[41]);
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
        flatBufferBuilder.b(52, iArr[52]);
        flatBufferBuilder.b(53, iArr[53]);
        flatBufferBuilder.b(54, iArr[54]);
        flatBufferBuilder.b(55, iArr[55]);
        flatBufferBuilder.b(56, iArr[56]);
        flatBufferBuilder.b(57, iArr[57]);
        flatBufferBuilder.b(58, iArr[58]);
        flatBufferBuilder.b(59, iArr[59]);
        flatBufferBuilder.b(60, iArr[60]);
        if (zArr[9]) {
            flatBufferBuilder.a(61, zArr2[2]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(62, zArr2[3]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(63, zArr2[4]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(64, zArr2[5]);
        }
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
        flatBufferBuilder.b(81, iArr[81]);
        flatBufferBuilder.b(82, iArr[82]);
        flatBufferBuilder.b(83, iArr[83]);
        flatBufferBuilder.b(84, iArr[84]);
        flatBufferBuilder.b(85, iArr[85]);
        flatBufferBuilder.b(86, iArr[86]);
        flatBufferBuilder.b(87, iArr[87]);
        flatBufferBuilder.b(88, iArr[88]);
        flatBufferBuilder.b(89, iArr[89]);
        if (zArr[13]) {
            flatBufferBuilder.a(90, iArr2[2], 0);
        }
        return flatBufferBuilder.d();
    }

    public static int m5951b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5948a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m5949a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5948a(jsonParser, flatBufferBuilder);
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

    public static void m5950a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5952b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5952b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("action_link_type");
            jsonGenerator.b(((GraphQLProfilePictureActionLinkType) mutableFlatBuffer.a(i, 1, GraphQLProfilePictureActionLinkType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("ad_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("agree_to_privacy_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        int a = mutableFlatBuffer.a(i, 4, 0);
        if (a != 0) {
            jsonGenerator.a("android_minimal_screen_form_height");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 5, 0);
        if (a != 0) {
            jsonGenerator.a("android_small_screen_phone_threshold");
            jsonGenerator.b(a);
        }
        boolean a2 = mutableFlatBuffer.a(i, 6);
        if (a2) {
            jsonGenerator.a("can_viewer_add_contributors");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 7);
        if (a2) {
            jsonGenerator.a("can_watch_and_browse");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.g(i, 8);
        if (a != 0) {
            jsonGenerator.a("collection");
            GraphQLTimelineAppCollectionDeserializer.m6070b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 9);
        if (a != 0) {
            jsonGenerator.a("coupon");
            GraphQLCouponDeserializer.m4688a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        long a3 = mutableFlatBuffer.a(i, 10, 0);
        if (a3 != 0) {
            jsonGenerator.a("default_expiration_time");
            jsonGenerator.a(a3);
        }
        a = mutableFlatBuffer.g(i, 11);
        if (a != 0) {
            jsonGenerator.a("description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 12, (short) 0) != (short) 0) {
            jsonGenerator.a("destination_type");
            jsonGenerator.b(((GraphQLStoryActionLinkDestinationType) mutableFlatBuffer.a(i, 12, GraphQLStoryActionLinkDestinationType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("disclaimer_accept_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("disclaimer_continue_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        a = mutableFlatBuffer.g(i, 15);
        if (a != 0) {
            jsonGenerator.a("error_codes");
            GraphQLLeadGenErrorNodeDeserializer.m5292a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("error_message_brief");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        if (mutableFlatBuffer.g(i, 17) != 0) {
            jsonGenerator.a("error_message_detail");
            jsonGenerator.b(mutableFlatBuffer.c(i, 17));
        }
        a = mutableFlatBuffer.g(i, 18);
        if (a != 0) {
            jsonGenerator.a("event");
            GraphQLEventDeserializer.m4796b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("fb_data_policy_setting_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("fb_data_policy_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 20));
        }
        a = mutableFlatBuffer.g(i, 21);
        if (a != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 22) != 0) {
            jsonGenerator.a("follow_up_action_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 22));
        }
        if (mutableFlatBuffer.g(i, 23) != 0) {
            jsonGenerator.a("follow_up_action_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 23));
        }
        a = mutableFlatBuffer.g(i, 24);
        if (a != 0) {
            jsonGenerator.a("group");
            GraphQLGroupDeserializer.m5159a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 25);
        if (a != 0) {
            jsonGenerator.a("group_story_chattable_members");
            GraphQLGroupMessageChattableMembersConnectionDeserializer.m5178a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 26);
        if (a != 0) {
            jsonGenerator.a("info");
            GraphQLOverlayCallToActionInfoDeserializer.m5475a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 27);
        if (a != 0) {
            jsonGenerator.a("item");
            GraphQLNodeDeserializer.m5440b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 28) != 0) {
            jsonGenerator.a("landing_page_cta");
            jsonGenerator.b(mutableFlatBuffer.c(i, 28));
        }
        if (mutableFlatBuffer.g(i, 29) != 0) {
            jsonGenerator.a("landing_page_redirect_instruction");
            jsonGenerator.b(mutableFlatBuffer.c(i, 29));
        }
        a = mutableFlatBuffer.g(i, 30);
        if (a != 0) {
            jsonGenerator.a("lead_gen_data");
            GraphQLLeadGenDataDeserializer.m5285a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 31) != 0) {
            jsonGenerator.a("lead_gen_data_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 31));
        }
        a = mutableFlatBuffer.g(i, 32);
        if (a != 0) {
            jsonGenerator.a("lead_gen_deep_link_user_status");
            GraphQLLeadGenDeepLinkUserStatusDeserializer.m5288a(mutableFlatBuffer, a, jsonGenerator);
        }
        a = mutableFlatBuffer.g(i, 33);
        if (a != 0) {
            jsonGenerator.a("lead_gen_user_status");
            GraphQLLeadGenUserStatusDeserializer.m5314a(mutableFlatBuffer, a, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("link_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 34));
        }
        if (mutableFlatBuffer.g(i, 35) != 0) {
            jsonGenerator.a("link_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 35));
        }
        a = mutableFlatBuffer.g(i, 36);
        if (a != 0) {
            jsonGenerator.a("link_icon_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 37, (short) 0) != (short) 0) {
            jsonGenerator.a("link_style");
            jsonGenerator.b(((GraphQLCallToActionStyle) mutableFlatBuffer.a(i, 37, GraphQLCallToActionStyle.class)).name());
        }
        a = mutableFlatBuffer.g(i, 38);
        if (a != 0) {
            jsonGenerator.a("link_target_store_data");
            GraphQLLinkTargetStoreDataDeserializer.m5326a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 39) != 0) {
            jsonGenerator.a("link_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 39));
        }
        if (mutableFlatBuffer.a(i, 40, (short) 0) != (short) 0) {
            jsonGenerator.a("link_type");
            jsonGenerator.b(((GraphQLCallToActionType) mutableFlatBuffer.a(i, 40, GraphQLCallToActionType.class)).name());
        }
        a = mutableFlatBuffer.g(i, 41);
        if (a != 0) {
            jsonGenerator.a("link_video_endscreen_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a, jsonGenerator);
        }
        a = mutableFlatBuffer.g(i, 42);
        if (a != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 43) != 0) {
            jsonGenerator.a("nux_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 43));
        }
        if (mutableFlatBuffer.g(i, 44) != 0) {
            jsonGenerator.a("nux_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 44));
        }
        a = mutableFlatBuffer.g(i, 45);
        if (a != 0) {
            jsonGenerator.a("page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 46);
        if (a != 0) {
            jsonGenerator.a("parent_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 47) != 0) {
            jsonGenerator.a("primary_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 47));
        }
        if (mutableFlatBuffer.g(i, 48) != 0) {
            jsonGenerator.a("privacy_checkbox_error");
            jsonGenerator.b(mutableFlatBuffer.c(i, 48));
        }
        a = mutableFlatBuffer.g(i, 49);
        if (a != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 50) != 0) {
            jsonGenerator.a("privacy_setting_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 50));
        }
        a = mutableFlatBuffer.g(i, 51);
        if (a != 0) {
            jsonGenerator.a("profile");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 52) != 0) {
            jsonGenerator.a("progress_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 52));
        }
        if (mutableFlatBuffer.g(i, 53) != 0) {
            jsonGenerator.a("promotion_tag");
            jsonGenerator.b(mutableFlatBuffer.c(i, 53));
        }
        a = mutableFlatBuffer.g(i, 54);
        if (a != 0) {
            jsonGenerator.a("review");
            GraphQLContactRecommendationFieldDeserializer.m4685a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 55) != 0) {
            jsonGenerator.a("secure_sharing_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 55));
        }
        if (mutableFlatBuffer.g(i, 56) != 0) {
            jsonGenerator.a("select_text_hint");
            jsonGenerator.b(mutableFlatBuffer.c(i, 56));
        }
        if (mutableFlatBuffer.g(i, 57) != 0) {
            jsonGenerator.a("send_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 57));
        }
        if (mutableFlatBuffer.g(i, 58) != 0) {
            jsonGenerator.a("sent_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 58));
        }
        if (mutableFlatBuffer.g(i, 59) != 0) {
            jsonGenerator.a("share_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 59));
        }
        if (mutableFlatBuffer.g(i, 60) != 0) {
            jsonGenerator.a("short_secure_sharing_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 60));
        }
        a2 = mutableFlatBuffer.a(i, 61);
        if (a2) {
            jsonGenerator.a("show_even_if_installed");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 62);
        if (a2) {
            jsonGenerator.a("show_in_feed");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 63);
        if (a2) {
            jsonGenerator.a("show_in_permalink");
            jsonGenerator.a(a2);
        }
        a2 = mutableFlatBuffer.a(i, 64);
        if (a2) {
            jsonGenerator.a("skip_experiments");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 65) != 0) {
            jsonGenerator.a("split_flow_landing_page_hint_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 65));
        }
        if (mutableFlatBuffer.g(i, 66) != 0) {
            jsonGenerator.a("split_flow_landing_page_hint_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 66));
        }
        if (mutableFlatBuffer.g(i, 67) != 0) {
            jsonGenerator.a("stateful_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 67));
        }
        a = mutableFlatBuffer.g(i, 68);
        if (a != 0) {
            jsonGenerator.a("sticker");
            GraphQLImageOverlayDeserializer.m5230b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 69) != 0) {
            jsonGenerator.a("submit_card_instruction_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 69));
        }
        a = mutableFlatBuffer.g(i, 70);
        if (a != 0) {
            jsonGenerator.a("tagged_and_mentioned_users");
            C0239xb10bb428.m4578a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 71);
        if (a != 0) {
            jsonGenerator.a("temporal_event_info");
            GraphQLTemporalEventInfoDeserializer.m6055a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 72) != 0) {
            jsonGenerator.a("title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 72));
        }
        a = mutableFlatBuffer.g(i, 73);
        if (a != 0) {
            jsonGenerator.a("topic");
            GraphQLTopicDeserializer.m6117b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 74) != 0) {
            jsonGenerator.a("unsubscribe_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 74));
        }
        if (mutableFlatBuffer.g(i, 75) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 75));
        }
        if (mutableFlatBuffer.g(i, 76) != 0) {
            jsonGenerator.a("prompt_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 76));
        }
        a = mutableFlatBuffer.g(i, 77);
        if (a != 0) {
            jsonGenerator.a("page_outcome_button");
            GraphQLPageOutcomeButtonDeserializer.m5517a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 78) != 0) {
            jsonGenerator.a("frame_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 78));
        }
        a = mutableFlatBuffer.g(i, 79);
        if (a != 0) {
            jsonGenerator.a("video_annotations");
            GraphQLVideoAnnotationDeserializer.m6171a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 80);
        if (a != 0) {
            jsonGenerator.a("story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 81) != 0) {
            jsonGenerator.a("hoisted_story_ids");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 81), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 82) != 0) {
            jsonGenerator.a("followup_choices");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 82), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 83) != 0) {
            jsonGenerator.a("followup_question");
            jsonGenerator.b(mutableFlatBuffer.c(i, 83));
        }
        if (mutableFlatBuffer.g(i, 84) != 0) {
            jsonGenerator.a("main_choices");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 84), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 85) != 0) {
            jsonGenerator.a("main_question");
            jsonGenerator.b(mutableFlatBuffer.c(i, 85));
        }
        a = mutableFlatBuffer.g(i, 86);
        if (a != 0) {
            jsonGenerator.a("featured_instant_article_element");
            GraphQLDocumentElementDeserializer.m4717a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 87);
        if (a != 0) {
            jsonGenerator.a("instant_article");
            GraphQLInstantArticleDeserializer.m5264a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 88) != 0) {
            jsonGenerator.a("header_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 88));
        }
        if (mutableFlatBuffer.g(i, 89) != 0) {
            jsonGenerator.a("logo_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 89));
        }
        a = mutableFlatBuffer.a(i, 90, 0);
        if (a != 0) {
            jsonGenerator.a("rating");
            jsonGenerator.b(a);
        }
        jsonGenerator.g();
    }
}
