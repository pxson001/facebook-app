package com.facebook.leadgen.model.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.ErrorCodesParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.LeadGenDataParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.LeadGenDeepLinkUserStatusParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.PageParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: photos_albums_view */
public class FetchLeadGenDeepLinkQueryParsers {

    /* compiled from: photos_albums_view */
    public final class FetchLeadGenDeepLinkParser {
        public static int m8297a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[30];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("agree_to_privacy_text")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("android_small_screen_phone_threshold")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("disclaimer_accept_button_text")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("disclaimer_continue_button_text")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("error_codes")) {
                        iArr[5] = ErrorCodesParser.m8458a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("error_message_brief")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("error_message_detail")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fb_data_policy_setting_description")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("fb_data_policy_url")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("follow_up_action_text")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("follow_up_action_url")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("landing_page_cta")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("landing_page_redirect_instruction")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("lead_gen_data")) {
                        iArr[14] = LeadGenDataParser.m8468a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("lead_gen_deep_link_user_status")) {
                        iArr[15] = LeadGenDeepLinkUserStatusParser.m8470a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[16] = PageParser.m8472a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("primary_button_text")) {
                        iArr[17] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_setting_description")) {
                        iArr[18] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("progress_text")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("secure_sharing_text")) {
                        iArr[20] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("select_text_hint")) {
                        iArr[21] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("send_description")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sent_text")) {
                        iArr[23] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("short_secure_sharing_text")) {
                        iArr[24] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("skip_experiments")) {
                        zArr[1] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("split_flow_landing_page_hint_text")) {
                        iArr[26] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("split_flow_landing_page_hint_title")) {
                        iArr[27] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("submit_card_instruction_text")) {
                        iArr[28] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("unsubscribe_description")) {
                        iArr[29] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(30);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, iArr2[0], 0);
            }
            flatBufferBuilder.b(3, iArr[3]);
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
            flatBufferBuilder.b(21, iArr[21]);
            flatBufferBuilder.b(22, iArr[22]);
            flatBufferBuilder.b(23, iArr[23]);
            flatBufferBuilder.b(24, iArr[24]);
            if (zArr[1]) {
                flatBufferBuilder.a(25, zArr2[0]);
            }
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            return flatBufferBuilder.d();
        }

        public static void m8298a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("agree_to_privacy_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int a = mutableFlatBuffer.a(i, 2, 0);
            if (a != 0) {
                jsonGenerator.a("android_small_screen_phone_threshold");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("disclaimer_accept_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("disclaimer_continue_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            a = mutableFlatBuffer.g(i, 5);
            if (a != 0) {
                jsonGenerator.a("error_codes");
                ErrorCodesParser.m8460a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("error_message_brief");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("error_message_detail");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("fb_data_policy_setting_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("fb_data_policy_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("follow_up_action_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("follow_up_action_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("landing_page_cta");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("landing_page_redirect_instruction");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            a = mutableFlatBuffer.g(i, 14);
            if (a != 0) {
                jsonGenerator.a("lead_gen_data");
                LeadGenDataParser.m8469a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 15);
            if (a != 0) {
                jsonGenerator.a("lead_gen_deep_link_user_status");
                LeadGenDeepLinkUserStatusParser.m8471a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.g(i, 16);
            if (a != 0) {
                jsonGenerator.a("page");
                PageParser.m8473a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("primary_button_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 17));
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("privacy_setting_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 18));
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("progress_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            if (mutableFlatBuffer.g(i, 20) != 0) {
                jsonGenerator.a("secure_sharing_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 20));
            }
            if (mutableFlatBuffer.g(i, 21) != 0) {
                jsonGenerator.a("select_text_hint");
                jsonGenerator.b(mutableFlatBuffer.c(i, 21));
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("send_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            if (mutableFlatBuffer.g(i, 23) != 0) {
                jsonGenerator.a("sent_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 23));
            }
            if (mutableFlatBuffer.g(i, 24) != 0) {
                jsonGenerator.a("short_secure_sharing_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 24));
            }
            boolean a2 = mutableFlatBuffer.a(i, 25);
            if (a2) {
                jsonGenerator.a("skip_experiments");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 26) != 0) {
                jsonGenerator.a("split_flow_landing_page_hint_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 26));
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("split_flow_landing_page_hint_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 27));
            }
            if (mutableFlatBuffer.g(i, 28) != 0) {
                jsonGenerator.a("submit_card_instruction_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 28));
            }
            if (mutableFlatBuffer.g(i, 29) != 0) {
                jsonGenerator.a("unsubscribe_description");
                jsonGenerator.b(mutableFlatBuffer.c(i, 29));
            }
            jsonGenerator.g();
        }
    }
}
