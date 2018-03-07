package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: open_graph_action */
public class GraphQLLinkOpenActionLinkDeserializer {
    public static int m5321a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[16];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[1];
        Enum[] enumArr = new Enum[3];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("can_watch_and_browse")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("destination_type")) {
                    zArr[1] = true;
                    enumArr[0] = GraphQLStoryActionLinkDestinationType.fromString(jsonParser.o());
                } else if (i.equals("link_description")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_display")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_icon_image")) {
                    iArr[4] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("link_style")) {
                    zArr[2] = true;
                    enumArr[1] = GraphQLCallToActionStyle.fromString(jsonParser.o());
                } else if (i.equals("link_target_store_data")) {
                    iArr[6] = GraphQLLinkTargetStoreDataDeserializer.m5324a(jsonParser, flatBufferBuilder);
                } else if (i.equals("link_title")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("link_type")) {
                    zArr[3] = true;
                    enumArr[2] = GraphQLCallToActionType.fromString(jsonParser.o());
                } else if (i.equals("link_video_endscreen_icon")) {
                    iArr[9] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("stateful_title")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("title")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("video_annotations")) {
                    iArr[13] = GraphQLVideoAnnotationDeserializer.m6172b(jsonParser, flatBufferBuilder);
                } else if (i.equals("header_color")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("logo_uri")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(16);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[2]) {
            flatBufferBuilder.a(5, enumArr[1]);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[3]) {
            flatBufferBuilder.a(8, enumArr[2]);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5322a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5321a(jsonParser, flatBufferBuilder);
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

    public static void m5323a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("can_watch_and_browse");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("destination_type");
            jsonGenerator.b(((GraphQLStoryActionLinkDestinationType) mutableFlatBuffer.a(i, 1, GraphQLStoryActionLinkDestinationType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("link_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("link_display");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        int g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("link_icon_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 5, (short) 0) != (short) 0) {
            jsonGenerator.a("link_style");
            jsonGenerator.b(((GraphQLCallToActionStyle) mutableFlatBuffer.a(i, 5, GraphQLCallToActionStyle.class)).name());
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("link_target_store_data");
            GraphQLLinkTargetStoreDataDeserializer.m5326a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("link_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.a(i, 8, (short) 0) != (short) 0) {
            jsonGenerator.a("link_type");
            jsonGenerator.b(((GraphQLCallToActionType) mutableFlatBuffer.a(i, 8, GraphQLCallToActionType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("link_video_endscreen_icon");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("stateful_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("video_annotations");
            GraphQLVideoAnnotationDeserializer.m6171a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("header_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("logo_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        jsonGenerator.g();
    }
}
