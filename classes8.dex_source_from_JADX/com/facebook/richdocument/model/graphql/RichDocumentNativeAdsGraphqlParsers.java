package com.facebook.richdocument.model.graphql;

import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.FBFullImageFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDocumentNativeAdType;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBVideoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_count_48_h_since_last_log */
public class RichDocumentNativeAdsGraphqlParsers {

    /* compiled from: photo_count_48_h_since_last_log */
    public final class RichDocumentHTMLNativeAdFragmentParser {

        /* compiled from: photo_count_48_h_since_last_log */
        public final class FallbackNativeAdParser {
            public static int m6761a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[23];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("ad_choices_icon")) {
                            iArr[1] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("ad_choices_link_url")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("ads_encrypted_data")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("body")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("call_to_action")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("click_report_url")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("client_token")) {
                            iArr[7] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("command_url")) {
                            iArr[8] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("icon")) {
                            iArr[9] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image")) {
                            iArr[10] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("impression_report_url")) {
                            iArr[11] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("native_ad_type")) {
                            iArr[12] = flatBufferBuilder.a(GraphQLDocumentNativeAdType.fromString(jsonParser.o()));
                        } else if (i.equals("social_context")) {
                            iArr[13] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("subtitle")) {
                            iArr[14] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
                            iArr[15] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("tracking")) {
                            iArr[16] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("video")) {
                            iArr[17] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_autoplay_style")) {
                            iArr[18] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_control_style")) {
                            iArr[19] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_looping_style")) {
                            iArr[20] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_play_report_url")) {
                            iArr[21] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("video_skip_report_url")) {
                            iArr[22] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(23);
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
                return flatBufferBuilder.d();
            }

            public static void m6762a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("ad_choices_icon");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("ad_choices_link_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("ads_encrypted_data");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("body");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("call_to_action");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("click_report_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                if (mutableFlatBuffer.g(i, 7) != 0) {
                    jsonGenerator.a("client_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("command_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 8));
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("icon");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("image");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("impression_report_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("native_ad_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 12));
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("social_context");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                }
                if (mutableFlatBuffer.g(i, 14) != 0) {
                    jsonGenerator.a("subtitle");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 14));
                }
                if (mutableFlatBuffer.g(i, 15) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 15));
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("tracking");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("video_autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("video_control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 19));
                }
                if (mutableFlatBuffer.g(i, 20) != 0) {
                    jsonGenerator.a("video_looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 20));
                }
                if (mutableFlatBuffer.g(i, 21) != 0) {
                    jsonGenerator.a("video_play_report_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 21));
                }
                if (mutableFlatBuffer.g(i, 22) != 0) {
                    jsonGenerator.a("video_skip_report_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 22));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6763a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("fallback_native_ad")) {
                        iArr[0] = FallbackNativeAdParser.m6761a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: photo_count_48_h_since_last_log */
    public final class RichDocumentNativeAdFragmentParser {

        /* compiled from: photo_count_48_h_since_last_log */
        public final class NativeTypedAdObjectParser {
            public static int m6764a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[23];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("ad_choices_icon")) {
                            iArr[1] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("ad_choices_link_url")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("ads_encrypted_data")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("body")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("call_to_action")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("click_report_url")) {
                            iArr[6] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("client_token")) {
                            iArr[7] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("command_url")) {
                            iArr[8] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("icon")) {
                            iArr[9] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("image")) {
                            iArr[10] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("impression_report_url")) {
                            iArr[11] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("native_ad_type")) {
                            iArr[12] = flatBufferBuilder.a(GraphQLDocumentNativeAdType.fromString(jsonParser.o()));
                        } else if (i.equals("social_context")) {
                            iArr[13] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("subtitle")) {
                            iArr[14] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
                            iArr[15] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("tracking")) {
                            iArr[16] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("video")) {
                            iArr[17] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_autoplay_style")) {
                            iArr[18] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_control_style")) {
                            iArr[19] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_looping_style")) {
                            iArr[20] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_play_report_url")) {
                            iArr[21] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("video_skip_report_url")) {
                            iArr[22] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(23);
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
                return flatBufferBuilder.d();
            }

            public static void m6765a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("ad_choices_icon");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("ad_choices_link_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("ads_encrypted_data");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("body");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("call_to_action");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("click_report_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                }
                if (mutableFlatBuffer.g(i, 7) != 0) {
                    jsonGenerator.a("client_token");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("command_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 8));
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("icon");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("image");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 11) != 0) {
                    jsonGenerator.a("impression_report_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                }
                if (mutableFlatBuffer.g(i, 12) != 0) {
                    jsonGenerator.a("native_ad_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 12));
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("social_context");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                }
                if (mutableFlatBuffer.g(i, 14) != 0) {
                    jsonGenerator.a("subtitle");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 14));
                }
                if (mutableFlatBuffer.g(i, 15) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 15));
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("tracking");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("video_autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("video_control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 19));
                }
                if (mutableFlatBuffer.g(i, 20) != 0) {
                    jsonGenerator.a("video_looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 20));
                }
                if (mutableFlatBuffer.g(i, 21) != 0) {
                    jsonGenerator.a("video_play_report_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 21));
                }
                if (mutableFlatBuffer.g(i, 22) != 0) {
                    jsonGenerator.a("video_skip_report_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 22));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6766a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("native_typed_ad_object")) {
                        iArr[0] = NativeTypedAdObjectParser.m6764a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
