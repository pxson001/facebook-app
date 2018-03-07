package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLDocumentElementMarginStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentListStyle;
import com.facebook.graphql.enums.GraphQLDocumentMapStyle;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: permalink_node */
public class GraphQLDocumentElementDeserializer {
    public static int m4715a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[27];
        boolean[] zArr = new boolean[14];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = new int[2];
        Enum[] enumArr = new Enum[11];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("audio_play_mode")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLAudioAnnotationPlayMode.fromString(jsonParser.o());
                } else if (i.equals("audio_url")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("base_url")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("block_title")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("display_height")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("display_width")) {
                    zArr[2] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("document_element_type")) {
                    zArr[3] = true;
                    enumArr[1] = GraphQLDocumentElementType.fromString(jsonParser.o());
                } else if (i.equals("element_video")) {
                    iArr[9] = GraphQLVideoDeserializer.m6184a(jsonParser, flatBufferBuilder);
                } else if (i.equals("enable_ad_network_bridging")) {
                    zArr[4] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("feedback")) {
                    iArr[12] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback_options")) {
                    zArr[5] = true;
                    enumArr[2] = GraphQLDocumentFeedbackOptions.fromString(jsonParser.o());
                } else if (i.equals("html_source")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("list_style")) {
                    zArr[6] = true;
                    enumArr[3] = GraphQLDocumentListStyle.fromString(jsonParser.o());
                } else if (i.equals("map_style")) {
                    zArr[7] = true;
                    enumArr[4] = GraphQLDocumentMapStyle.fromString(jsonParser.o());
                } else if (i.equals("margin_style")) {
                    zArr[8] = true;
                    enumArr[5] = GraphQLDocumentElementMarginStyle.fromString(jsonParser.o());
                } else if (i.equals("photo")) {
                    iArr[19] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("poster_image")) {
                    iArr[20] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("presentation_state")) {
                    zArr[9] = true;
                    enumArr[6] = GraphQLDocumentMediaPresentationStyle.fromString(jsonParser.o());
                } else if (i.equals("text_background_color")) {
                    iArr[22] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_autoplay_style")) {
                    zArr[10] = true;
                    enumArr[7] = GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o());
                } else if (i.equals("video_control_style")) {
                    zArr[11] = true;
                    enumArr[8] = GraphQLDocumentVideoControlStyle.fromString(jsonParser.o());
                } else if (i.equals("video_looping_style")) {
                    zArr[12] = true;
                    enumArr[9] = GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o());
                } else if (i.equals("webview_presentation_style")) {
                    zArr[13] = true;
                    enumArr[10] = GraphQLDocumentWebviewPresentationStyle.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(27);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[1]) {
            flatBufferBuilder.a(6, iArr2[0], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(7, iArr2[1], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(8, enumArr[1]);
        }
        flatBufferBuilder.b(9, iArr[9]);
        if (zArr[4]) {
            flatBufferBuilder.a(11, zArr2[0]);
        }
        flatBufferBuilder.b(12, iArr[12]);
        if (zArr[5]) {
            flatBufferBuilder.a(13, enumArr[2]);
        }
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[6]) {
            flatBufferBuilder.a(16, enumArr[3]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(17, enumArr[4]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(18, enumArr[5]);
        }
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        if (zArr[9]) {
            flatBufferBuilder.a(21, enumArr[6]);
        }
        flatBufferBuilder.b(22, iArr[22]);
        if (zArr[10]) {
            flatBufferBuilder.a(23, enumArr[7]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(24, enumArr[8]);
        }
        if (zArr[12]) {
            flatBufferBuilder.a(25, enumArr[9]);
        }
        if (zArr[13]) {
            flatBufferBuilder.a(26, enumArr[10]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4716a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4715a(jsonParser, flatBufferBuilder);
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

    public static void m4717a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("audio_play_mode");
            jsonGenerator.b(((GraphQLAudioAnnotationPlayMode) mutableFlatBuffer.a(i, 1, GraphQLAudioAnnotationPlayMode.class)).name());
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("audio_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("base_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("block_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        int a = mutableFlatBuffer.a(i, 6, 0);
        if (a != 0) {
            jsonGenerator.a("display_height");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 7, 0);
        if (a != 0) {
            jsonGenerator.a("display_width");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.a(i, 8, (short) 0) != (short) 0) {
            jsonGenerator.a("document_element_type");
            jsonGenerator.b(((GraphQLDocumentElementType) mutableFlatBuffer.a(i, 8, GraphQLDocumentElementType.class)).name());
        }
        a = mutableFlatBuffer.g(i, 9);
        if (a != 0) {
            jsonGenerator.a("element_video");
            GraphQLVideoDeserializer.m6186a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        boolean a2 = mutableFlatBuffer.a(i, 11);
        if (a2) {
            jsonGenerator.a("enable_ad_network_bridging");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.g(i, 12);
        if (a != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 13, (short) 0) != (short) 0) {
            jsonGenerator.a("feedback_options");
            jsonGenerator.b(((GraphQLDocumentFeedbackOptions) mutableFlatBuffer.a(i, 13, GraphQLDocumentFeedbackOptions.class)).name());
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("html_source");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        if (mutableFlatBuffer.a(i, 16, (short) 0) != (short) 0) {
            jsonGenerator.a("list_style");
            jsonGenerator.b(((GraphQLDocumentListStyle) mutableFlatBuffer.a(i, 16, GraphQLDocumentListStyle.class)).name());
        }
        if (mutableFlatBuffer.a(i, 17, (short) 0) != (short) 0) {
            jsonGenerator.a("map_style");
            jsonGenerator.b(((GraphQLDocumentMapStyle) mutableFlatBuffer.a(i, 17, GraphQLDocumentMapStyle.class)).name());
        }
        if (mutableFlatBuffer.a(i, 18, (short) 0) != (short) 0) {
            jsonGenerator.a("margin_style");
            jsonGenerator.b(((GraphQLDocumentElementMarginStyle) mutableFlatBuffer.a(i, 18, GraphQLDocumentElementMarginStyle.class)).name());
        }
        a = mutableFlatBuffer.g(i, 19);
        if (a != 0) {
            jsonGenerator.a("photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 20);
        if (a != 0) {
            jsonGenerator.a("poster_image");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 21, (short) 0) != (short) 0) {
            jsonGenerator.a("presentation_state");
            jsonGenerator.b(((GraphQLDocumentMediaPresentationStyle) mutableFlatBuffer.a(i, 21, GraphQLDocumentMediaPresentationStyle.class)).name());
        }
        if (mutableFlatBuffer.g(i, 22) != 0) {
            jsonGenerator.a("text_background_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 22));
        }
        if (mutableFlatBuffer.a(i, 23, (short) 0) != (short) 0) {
            jsonGenerator.a("video_autoplay_style");
            jsonGenerator.b(((GraphQLDocumentVideoAutoplayStyle) mutableFlatBuffer.a(i, 23, GraphQLDocumentVideoAutoplayStyle.class)).name());
        }
        if (mutableFlatBuffer.a(i, 24, (short) 0) != (short) 0) {
            jsonGenerator.a("video_control_style");
            jsonGenerator.b(((GraphQLDocumentVideoControlStyle) mutableFlatBuffer.a(i, 24, GraphQLDocumentVideoControlStyle.class)).name());
        }
        if (mutableFlatBuffer.a(i, 25, (short) 0) != (short) 0) {
            jsonGenerator.a("video_looping_style");
            jsonGenerator.b(((GraphQLDocumentVideoLoopingStyle) mutableFlatBuffer.a(i, 25, GraphQLDocumentVideoLoopingStyle.class)).name());
        }
        if (mutableFlatBuffer.a(i, 26, (short) 0) != (short) 0) {
            jsonGenerator.a("webview_presentation_style");
            jsonGenerator.b(((GraphQLDocumentWebviewPresentationStyle) mutableFlatBuffer.a(i, 26, GraphQLDocumentWebviewPresentationStyle.class)).name());
        }
        jsonGenerator.g();
    }
}
