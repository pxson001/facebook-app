package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: option_icon */
public class GraphQLLeadGenActionLinkDeserializer {
    public static int m5277a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[45];
        boolean[] zArr = new boolean[5];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = new int[2];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("ad_id")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("agree_to_privacy_text")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("android_minimal_screen_form_height")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("android_small_screen_phone_threshold")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("disclaimer_accept_button_text")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("disclaimer_continue_button_text")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("error_codes")) {
                    iArr[6] = GraphQLLeadGenErrorNodeDeserializer.m5293b(jsonParser, flatBufferBuilder);
                } else if (i.equals("error_message_brief")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("error_message_detail")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fb_data_policy_setting_description")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fb_data_policy_url")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("follow_up_action_text")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("follow_up_action_url")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("landing_page_cta")) {
                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("landing_page_redirect_instruction")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("lead_gen_data")) {
                    iArr[15] = GraphQLLeadGenDataDeserializer.m5283a(jsonParser, flatBufferBuilder);
                } else if (i.equals("lead_gen_data_id")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("lead_gen_deep_link_user_status")) {
                    iArr[17] = GraphQLLeadGenDeepLinkUserStatusDeserializer.m5286a(jsonParser, flatBufferBuilder);
                } else if (i.equals("lead_gen_user_status")) {
                    iArr[18] = GraphQLLeadGenUserStatusDeserializer.m5312a(jsonParser, flatBufferBuilder);
                } else if (i.equals("link_description")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_display")) {
                    iArr[20] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_style")) {
                    zArr[2] = true;
                    enumArr[0] = GraphQLCallToActionStyle.fromString(jsonParser.o());
                } else if (i.equals("link_title")) {
                    iArr[22] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_type")) {
                    zArr[3] = true;
                    enumArr[1] = GraphQLCallToActionType.fromString(jsonParser.o());
                } else if (i.equals("link_video_endscreen_icon")) {
                    iArr[24] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("nux_description")) {
                    iArr[25] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("nux_title")) {
                    iArr[26] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("page")) {
                    iArr[27] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("primary_button_text")) {
                    iArr[28] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_checkbox_error")) {
                    iArr[29] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_setting_description")) {
                    iArr[30] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("progress_text")) {
                    iArr[31] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("secure_sharing_text")) {
                    iArr[32] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("select_text_hint")) {
                    iArr[33] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("send_description")) {
                    iArr[34] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("sent_text")) {
                    iArr[35] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("share_id")) {
                    iArr[36] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("short_secure_sharing_text")) {
                    iArr[37] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("skip_experiments")) {
                    zArr[4] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("split_flow_landing_page_hint_text")) {
                    iArr[39] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("split_flow_landing_page_hint_title")) {
                    iArr[40] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("submit_card_instruction_text")) {
                    iArr[41] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("title")) {
                    iArr[42] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("unsubscribe_description")) {
                    iArr[43] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[44] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(45);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, iArr2[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(3, iArr2[1], 0);
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
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        if (zArr[2]) {
            flatBufferBuilder.a(21, enumArr[0]);
        }
        flatBufferBuilder.b(22, iArr[22]);
        if (zArr[3]) {
            flatBufferBuilder.a(23, enumArr[1]);
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
        flatBufferBuilder.b(36, iArr[36]);
        flatBufferBuilder.b(37, iArr[37]);
        if (zArr[4]) {
            flatBufferBuilder.a(38, zArr2[0]);
        }
        flatBufferBuilder.b(39, iArr[39]);
        flatBufferBuilder.b(40, iArr[40]);
        flatBufferBuilder.b(41, iArr[41]);
        flatBufferBuilder.b(42, iArr[42]);
        flatBufferBuilder.b(43, iArr[43]);
        flatBufferBuilder.b(44, iArr[44]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5278a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5277a(jsonParser, flatBufferBuilder);
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

    public static void m5279a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("ad_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("agree_to_privacy_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        int a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("android_minimal_screen_form_height");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 3, 0);
        if (a != 0) {
            jsonGenerator.a("android_small_screen_phone_threshold");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("disclaimer_accept_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("disclaimer_continue_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        a = mutableFlatBuffer.g(i, 6);
        if (a != 0) {
            jsonGenerator.a("error_codes");
            GraphQLLeadGenErrorNodeDeserializer.m5292a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("error_message_brief");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("error_message_detail");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("fb_data_policy_setting_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("fb_data_policy_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("follow_up_action_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("follow_up_action_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("landing_page_cta");
            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("landing_page_redirect_instruction");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        a = mutableFlatBuffer.g(i, 15);
        if (a != 0) {
            jsonGenerator.a("lead_gen_data");
            GraphQLLeadGenDataDeserializer.m5285a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("lead_gen_data_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        a = mutableFlatBuffer.g(i, 17);
        if (a != 0) {
            jsonGenerator.a("lead_gen_deep_link_user_status");
            GraphQLLeadGenDeepLinkUserStatusDeserializer.m5288a(mutableFlatBuffer, a, jsonGenerator);
        }
        a = mutableFlatBuffer.g(i, 18);
        if (a != 0) {
            jsonGenerator.a("lead_gen_user_status");
            GraphQLLeadGenUserStatusDeserializer.m5314a(mutableFlatBuffer, a, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("link_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        if (mutableFlatBuffer.g(i, 20) != 0) {
            jsonGenerator.a("link_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 20));
        }
        if (mutableFlatBuffer.a(i, 21, (short) 0) != (short) 0) {
            jsonGenerator.a("link_style");
            jsonGenerator.b(((GraphQLCallToActionStyle) mutableFlatBuffer.a(i, 21, GraphQLCallToActionStyle.class)).name());
        }
        if (mutableFlatBuffer.g(i, 22) != 0) {
            jsonGenerator.a("link_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 22));
        }
        if (mutableFlatBuffer.a(i, 23, (short) 0) != (short) 0) {
            jsonGenerator.a("link_type");
            jsonGenerator.b(((GraphQLCallToActionType) mutableFlatBuffer.a(i, 23, GraphQLCallToActionType.class)).name());
        }
        a = mutableFlatBuffer.g(i, 24);
        if (a != 0) {
            jsonGenerator.a("link_video_endscreen_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 25) != 0) {
            jsonGenerator.a("nux_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 25));
        }
        if (mutableFlatBuffer.g(i, 26) != 0) {
            jsonGenerator.a("nux_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 26));
        }
        a = mutableFlatBuffer.g(i, 27);
        if (a != 0) {
            jsonGenerator.a("page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 28) != 0) {
            jsonGenerator.a("primary_button_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 28));
        }
        if (mutableFlatBuffer.g(i, 29) != 0) {
            jsonGenerator.a("privacy_checkbox_error");
            jsonGenerator.b(mutableFlatBuffer.c(i, 29));
        }
        if (mutableFlatBuffer.g(i, 30) != 0) {
            jsonGenerator.a("privacy_setting_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 30));
        }
        if (mutableFlatBuffer.g(i, 31) != 0) {
            jsonGenerator.a("progress_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 31));
        }
        if (mutableFlatBuffer.g(i, 32) != 0) {
            jsonGenerator.a("secure_sharing_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 32));
        }
        if (mutableFlatBuffer.g(i, 33) != 0) {
            jsonGenerator.a("select_text_hint");
            jsonGenerator.b(mutableFlatBuffer.c(i, 33));
        }
        if (mutableFlatBuffer.g(i, 34) != 0) {
            jsonGenerator.a("send_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 34));
        }
        if (mutableFlatBuffer.g(i, 35) != 0) {
            jsonGenerator.a("sent_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 35));
        }
        if (mutableFlatBuffer.g(i, 36) != 0) {
            jsonGenerator.a("share_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 36));
        }
        if (mutableFlatBuffer.g(i, 37) != 0) {
            jsonGenerator.a("short_secure_sharing_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 37));
        }
        boolean a2 = mutableFlatBuffer.a(i, 38);
        if (a2) {
            jsonGenerator.a("skip_experiments");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 39) != 0) {
            jsonGenerator.a("split_flow_landing_page_hint_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 39));
        }
        if (mutableFlatBuffer.g(i, 40) != 0) {
            jsonGenerator.a("split_flow_landing_page_hint_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 40));
        }
        if (mutableFlatBuffer.g(i, 41) != 0) {
            jsonGenerator.a("submit_card_instruction_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 41));
        }
        if (mutableFlatBuffer.g(i, 42) != 0) {
            jsonGenerator.a("title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 42));
        }
        if (mutableFlatBuffer.g(i, 43) != 0) {
            jsonGenerator.a("unsubscribe_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 43));
        }
        if (mutableFlatBuffer.g(i, 44) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 44));
        }
        jsonGenerator.g();
    }
}
