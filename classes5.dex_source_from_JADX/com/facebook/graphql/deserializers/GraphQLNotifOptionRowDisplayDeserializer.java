package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: official_page */
public class GraphQLNotifOptionRowDisplayDeserializer {
    public static int m5448a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[11];
        boolean[] zArr = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("bg_color")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image_glyph")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image_source")) {
                    iArr[3] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("style")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLNotifOptionRowDisplayStyle.fromString(jsonParser.o());
                } else if (i.equals("subtext")) {
                    iArr[6] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tertiary_text")) {
                    iArr[7] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tertiary_text_color")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("text")) {
                    iArr[9] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("undo_text")) {
                    iArr[10] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(5, enumArr[0]);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5449a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5448a(jsonParser, flatBufferBuilder);
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

    public static void m5450a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("bg_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("image_glyph");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        int g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("image_source");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 5, (short) 0) != (short) 0) {
            jsonGenerator.a("style");
            jsonGenerator.b(((GraphQLNotifOptionRowDisplayStyle) mutableFlatBuffer.a(i, 5, GraphQLNotifOptionRowDisplayStyle.class)).name());
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("subtext");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("tertiary_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("tertiary_text_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("undo_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
